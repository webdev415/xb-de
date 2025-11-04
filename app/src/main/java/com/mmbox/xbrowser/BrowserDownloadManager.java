package com.mmbox.xbrowser;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.webkit.CookieManager;
import android.widget.CheckBox;
import android.widget.Toast;

import androidx.core.content.FileProvider;

import com.mmbox.xbrowser.provider.BrowserProvider;
import com.xbrowser.play.R;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.Call;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import p000.NetworkUtils;
import p000.FileUtils;
import p000.DatabaseColumns;
import p000.AbstractC1900j2;
import p000.AndroidSystemUtils;
import p000.AbstractC2086n3;
import p000.AbstractC2132o3;
import p000.ConfirmDialog;
import p000.C0801Ra;
import p000.C1199a3;
import p000.PhoneUtils;
import p000.MySQLiteOpenHelper;
import p000.C2478vh;
import p000.InterfaceC0418J3;
import p000.InterfaceC0556M3;
import p000.InterfaceC2501w3;

public class BrowserDownloadManager {

    public static String DOWNLOAD_START_ACTION = "com.mmbox.xbrowser.download.start";

    public static String DOWNLOAD_RESUME_ACTION = "com.mmbox.xbrowser.download.resume";

    public static final Pattern FILENAME_COUNTER_PATTERN = Pattern.compile("([^/\\\\]+)_([0-9]{1,3})(\\.\\w{1,5})?$");

    public static BrowserDownloadManager instance = null;

    public HashMap<String, String> downloadRetryMap = new HashMap<>(3);

    public BrowserActivity browserActivity = null;

    public HashMap<String, DownloadItem> activeDownloadsMap = new HashMap<>(3);

    public ArrayList downloadTasksList = new ArrayList<>(3);

    public OkHttpClient httpClient = null;

    public NotificationManager notificationManager = null;

    public NotificationChannel notificationChannel = null;

    public class NotificationUpdateRunnable implements Runnable {

        public final NotificationBuilder f4627l;

        public final DownloadItem f4628m;

        public final int f4629n;

        public NotificationUpdateRunnable(NotificationBuilder mVar, DownloadItem iVar, int i) {
            this.f4627l = mVar;
            this.f4628m = iVar;
            this.f4629n = i;
        }

        @Override
        public void run() {
            this.f4627l.m6724c(m6693i(this.f4628m));
            notificationManager.notify(this.f4629n, this.f4627l.build());
        }
    }

    public class DownloadInfoCallback implements InterfaceC0556M3 {

        public final DownloadCallback callback;

        public final String url;

        public DownloadInfoCallback(DownloadCallback callback, String url) {
            this.callback = callback;
            this.url = url;
        }

        @Override
        public void onSuccess(InterfaceC0418J3 interfaceC0418J3, Response response) {
            if (response.code() == 200) {
                String contentType = response.header("Content-Type");
                long contentLength = response.body().contentLength();
                String contentDisposition = response.header("Content-Disposition");
                byte[] bArr = new byte[32];
                response.body().byteStream().read(bArr);
                try {
                    String str2 = new String(bArr, StandardCharsets.UTF_8);
                    if (str2.contains("#EXT")) {
                        contentType = "application/x-mpegurl";
                    } else if (str2.contains("mp4")) {
                        contentType = "video/mp4";
                    }
                } catch (Exception unused) {
                }
                if (callback != null) {
                    callback.onSuccess(this.url, contentType, contentDisposition, contentLength);
                    downloadRetryMap.remove(this.url);
                }
                interfaceC0418J3.cancel();
                response.body().close();
            } else {
                if (response.code() == 403 && !downloadRetryMap.containsKey(this.url)) {
                    downloadRetryMap.put(url, url);
                    m6691g(this.url, null, this.callback);
                } else if (callback != null) {
                    callback.onFailed(this.url);
                }
            }
        }

        @Override
        public void onError(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            if (callback != null) {
                callback.onFailed(this.url);
            }
        }
    }

    public class QueueIdleHandler implements MessageQueue.IdleHandler {
        @Override
        public boolean queueIdle() {
            m6705v();
            m6692h();
            return false;
        }
    }

    public class ToastRunnable implements Runnable {
        public ToastRunnable() {
        }

        @Override
        public void run() {
            Toast.makeText(browserActivity, R.string.toast_download_stared, Toast.LENGTH_SHORT).show();
        }
    }

    public class RemoveDownloadDialog extends ConfirmDialog {

        public final String f4636f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveDownloadDialog(Context context, String str) {
            super(context);
            this.f4636f = str;
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() {
            CheckBox checkBox = (CheckBox) findViewById(R.id.another_condition);
            BrowserDownloadManager.getInstance().m6680F(this.f4636f, checkBox != null && checkBox.isChecked());
            C1199a3.getInstance().m5098j("notify_remove_download", "downloadId", this.f4636f);
        }
    }

    public class OpenFileRunnable implements Runnable {

        public final String f4638l;

        public OpenFileRunnable(String str) {
            this.f4638l = str;
        }

        @Override
        public void run() throws URISyntaxException {
            browserActivity.m6307d2(this.f4638l);
        }
    }

    public class ErrorToastRunnable implements Runnable {
        public ErrorToastRunnable() {
        }

        @Override
        public void run() {
            Toast.makeText(browserActivity, "open file error", Toast.LENGTH_SHORT).show();
        }
    }

    public class WiFiConfirmDialog extends ConfirmDialog {

        public final DownloadItem f4641f;

        public final DownloadTask f4642g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WiFiConfirmDialog(Context context, DownloadItem iVar, DownloadTask lVar) {
            super(context);
            this.f4641f = iVar;
            this.f4642g = lVar;
        }

        @Override
        public void onCancel() {
            this.f4641f.downloadStatus = 5;
        }

        @Override
        public void onOK() {
            l lVar = this.f4642g;
            i iVar = this.f4641f;
            lVar.executeDownload(iVar.downloadUrl, iVar.userAgent, iVar.referer, iVar.totalBytes, iVar.fileName, null);
        }
    }

    public class DownloadItem {

        public long downloadId;

        public long downloadedBytes;

        public long currentProgress;

        public long lastProgressTime;

        public long downloadStartTime;

        public long lastProgressBytes;

        public long downloadSpeed;

        public long lastUpdateTime;

        public String fileName = null;

        public String downloadUrl = null;

        public String userAgent = null;

        public String referer = null;

        public String mimeType = null;

        public String tag = null;

        public Uri contentUri = null;

        public long totalBytes = 0;

        public int downloadStatus = 0;

        public int retryCount = 0;

        public boolean allowMobileData = false;

        public NotificationBuilder f4658o = null;

        public DownloadStatusCallback callback = null;

        public DownloadItem() {
        }

        public boolean shouldUpdateProgress() {
            long jCurrentTimeMillis = System.currentTimeMillis();
            if (jCurrentTimeMillis - this.lastUpdateTime < 600) {
                return false;
            }
            this.lastUpdateTime = jCurrentTimeMillis;
            return true;
        }

        public NotificationBuilder getNotificationBuilder() {
            if (this.f4658o == null) {
                this.f4658o = new NotificationBuilder(this.downloadId + "");
            }
            return this.f4658o;
        }

        public String getDownloadSpeedText() {
            return AndroidSystemUtils.formatFileSize((this.downloadSpeed * 1000) / 200) + "/s";
        }

        public boolean isDownloadComplete() {
            long j = this.totalBytes;
            return j != -1 && this.downloadedBytes == j;
        }

        public void updateContentUri() {
            this.contentUri = AndroidSystemUtils.m8704l(browserActivity, FileUtils.getFileName(this.fileName), this.mimeType, "");
        }
    }

    public interface DownloadCallback {
        void onFailed(String str);

        void onSuccess(String str, String str2, String str3, long j);
    }

    public interface DownloadStatusCallback {
        void mo6506a();

        void mo6507b();
    }

    public class DownloadTask {

        public DownloadItem currentDownload = null;

        public InterfaceC0418J3 httpCall = null;

        public OutputStream outputStream = null;

        public InterfaceC2501w3 requestBody = null;

        public class ShowDownloadCompleteRunnable implements Runnable {

            public final long downloadId;

            public ShowDownloadCompleteRunnable(long j) {
                this.downloadId = j;
            }

            @Override
            public void run() {
                browserActivity.m6227K1(this.downloadId + "");
            }
        }

        public class CleanupFailedDownloadRunnable implements Runnable {
            public CleanupFailedDownloadRunnable() {
            }

            @Override
            public void run() {
                i iVar = currentDownload;
                if (currentDownload != null && currentDownload.downloadSpeed == 0) {
                    currentDownload.downloadStatus = 4;
                    m6687M(currentDownload);
                    m6688N(currentDownload);
                }
                currentDownload = null;
            }
        }

        public class DownloadExecutorRunnable implements Runnable {

            public final long totalBytes;

            public final String downloadUrl;

            public final String fileName;

            public final String userAgent;

            public final HashMap<String, String> headers;

            public final String filePath;

            public DownloadExecutorRunnable(long j, String str, String str2, String str3, HashMap<String, String> map, String str4) {
                this.totalBytes = j;
                this.downloadUrl = str;
                this.fileName = str2;
                this.userAgent = str3;
                this.headers = map;
                this.filePath = str4;
            }

            public void run() {
                // Check if the download is already completed
                if (currentDownload == null) {
                    return;
                }

                currentDownload.currentProgress = 0;

                // Check if there's a valid download size and condition
                if (totalBytes == -1 || totalBytes == 0 || currentDownload.downloadedBytes != totalBytes) {
                    return;
                }

                // Proceed with download action
                currentDownload.downloadStatus = 3; // Set status to downloading
                m6687M(currentDownload);

                // Prepare request headers
                Request.Builder builder = new Request.Builder().url(this.downloadUrl)
                        .addHeader("Accept", "*/*");

                // Set User-Agent header, fallback to default if not provided
                String userAgent = TextUtils.isEmpty(this.fileName) ? SharedPreferencesHelper.defaultUserAgent : this.fileName;
                builder.addHeader("User-Agent", userAgent);

                // Set Referer header if available
                if (this.userAgent != null) {
                    builder.addHeader("Referer", this.userAgent.trim());
                }

                // Add cookies
                String cookies = CookieManager.getInstance().getCookie(this.downloadUrl);
                if (cookies != null) {
                    builder.addHeader("Cookie", cookies);
                }

                // Add any additional headers from custom map
                if (this.headers != null) {
                    for (String key : this.headers.keySet()) {
                        builder.addHeader(key, this.headers.get(key));
                    }
                }

                // Handle download conditions based on the file range or other factors
                if (currentDownload.downloadedBytes > 0) {
                    builder.addHeader("Range", "bytes=" + currentDownload.downloadedBytes + "-");
                }

                // Make the actual network request
                Request request = builder.build();
                Call call = httpClient.newCall(request);

                // Check response status
                try {
                    Response response = call.execute();
                    if (response.code() != 200) {
                        handleError();
                        return;
                    }

                    // Process successful response
                    currentDownload.totalBytes = response.body().contentLength();
                    long fileSize = currentDownload.totalBytes;

                    // Handle download completion or progress
                    if (fileSize > 0) {
                        writeToFile(response);
                    } else {
                        finishDownload();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            // Helper method to handle errors during download
            private void handleError() {
                if (currentDownload.downloadStatus == 2) {
                    return;
                }
                currentDownload.downloadStatus = 4;
                if (currentDownload.callback != null) {
                    currentDownload.callback.mo6506a();
                }
            }

            // Helper method to write data to the output file
            private void writeToFile(Response response) {
                byte[] buffer = new byte[81920];

                try (InputStream inputStream = response.body().byteStream()) {
                    try {
                        int bytesRead;
                        int totalBytesRead = 0;
                        while ((bytesRead = inputStream.read(buffer)) > 0) {
                            outputStream.write(buffer, 0, bytesRead);
                            totalBytesRead += bytesRead;

                            currentDownload.downloadedBytes += totalBytesRead;
                            if (currentDownload.totalBytes > 0) {
                                currentDownload.totalBytes = totalBytesRead;
                            }

                            updateProgress(totalBytesRead);
                        }
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }

                finishDownload();
            }

            // Finalize the download
            private void finishDownload() {
                if (outputStream != null) {
                    try {
                        outputStream.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                currentDownload.retryCount++;
                if (currentDownload.isDownloadComplete()) {
                    downloadRetryMap.remove(this.downloadUrl);
                }

                Log.i("download-manager", "Download finished: " + currentDownload.f4645b + " total: " + currentDownload.totalBytes);
                onDownloadComplete();
            }
        }

        public DownloadTask() {
        }

        public void assignDownload(DownloadItem iVar) {
            this.currentDownload = iVar;
            iVar.downloadStatus = 0;
        }

        public boolean isHandlingDownload(long j) {
            DownloadItem iVar = this.currentDownload;
            return iVar != null && iVar.downloadId == j;
        }

        public void cancelDownload() throws IOException {
            InterfaceC0418J3 interfaceC0418J3 = this.httpCall;
            if (interfaceC0418J3 != null) {
                interfaceC0418J3.cancel();
                if (outputStream != null) {
                    try {
                        outputStream.flush();
                        this.outputStream.close();
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        public final synchronized void executeDownload(String str, String str2, String str3, long j, String str4, HashMap map) {
            i iVar = this.currentDownload;
            if (iVar == null) {
                return;
            }
            iVar.lastProgressTime = System.currentTimeMillis();
            i iVar2 = this.currentDownload;
            iVar2.currentProgress = 0L;
            iVar2.lastProgressBytes = 0L;
            C1199a3.getInstance().m5098j("notify_download_start", "downloadId", this.currentDownload.downloadId + "");
            new Thread(new DownloadExecutorRunnable(j, str, str2, str3, map, str4)).start();
        }

        public void onDownloadComplete() {
            DownloadStatusCallback kVar;
            DownloadItem iVar = this.currentDownload;
            if (iVar != null && (kVar = iVar.callback) != null) {
                if (iVar.totalBytes == -1) {
                    iVar.totalBytes = iVar.downloadedBytes;
                }
                kVar.mo6507b();
            }
            C1199a3.getInstance().m5098j("notify_download_finish", "downloadId", this.currentDownload.downloadId + "");
            if (!this.currentDownload.isDownloadComplete()) {
                DownloadItem iVar2 = this.currentDownload;
                if (iVar2.downloadStatus != 2) {
                    browserActivity.getHandler().postDelayed(new CleanupFailedDownloadRunnable(), 2000L);
                    return;
                } else {
                    m6687M(iVar2);
                    m6688N(this.currentDownload);
                    return;
                }
            }
            DownloadItem iVar3 = this.currentDownload;
            iVar3.downloadStatus = 3;
            m6708y(iVar3);
            m6692h();
            m6687M(this.currentDownload);
            m6688N(this.currentDownload);
            boolean z = SharedPreferencesHelper.getInstance().f4936w;
            long j = this.currentDownload.downloadId;
            if (SharedPreferencesHelper.getInstance().remindWhenDownloadComplete) {
                browserActivity.runOnUiThread(new ShowDownloadCompleteRunnable(j));
            }
        }

        public void updateProgress(long j) {
            currentDownload.downloadStatus = 1;
            currentDownload.currentProgress = j;
            currentDownload.downloadStartTime = System.currentTimeMillis();
            long jCurrentTimeMillis = System.currentTimeMillis();
            DownloadItem iVar2 = this.currentDownload;
            if (jCurrentTimeMillis > iVar2.lastProgressTime + 200) {
                iVar2.downloadSpeed = iVar2.currentProgress - iVar2.lastProgressBytes;
                iVar2.lastProgressTime = System.currentTimeMillis();
                DownloadItem iVar3 = this.currentDownload;
                iVar3.lastProgressBytes = iVar3.currentProgress;
                C1199a3.getInstance().m5098j("notify_download_progress", "downloadId", this.currentDownload.downloadId + "");
            }
            if (this.currentDownload.shouldUpdateProgress()) {
                m6688N(this.currentDownload);
            }
        }
    }

    public class NotificationBuilder {

        public C2478vh notificationCompat;

        public Notification.Builder notificationBuilder;

        public String downloadIdStr;

        public NotificationBuilder(String str) {
            this.notificationCompat = null;
            this.notificationBuilder = null;
            this.downloadIdStr = str;
            if (Build.VERSION.SDK_INT < 26) {
                C2478vh c2478vh = new C2478vh(browserActivity);
                this.notificationCompat = c2478vh;
                c2478vh.m10368k(R.drawable.ic_main_menu_downloads);
                this.notificationCompat.m10366i(true);
                return;
            }
            if (!notificationManager.areNotificationsEnabled()) {
                browserActivity.m6277X();
            }
            if (notificationChannel == null) {
                NotificationChannel notificationChannelM8097a = AbstractC1900j2.m8097a("Download", "Download", 3);
                notificationChannel = notificationChannelM8097a;
                notificationChannelM8097a.enableLights(true);
                notificationChannel.setLightColor(-16711936);
                notificationChannel.setShowBadge(true);
                notificationManager.createNotificationChannel(notificationChannel);
            }
            AbstractC2132o3.m8836a();
            this.notificationBuilder = AbstractC2086n3.m8722a(browserActivity, str).setSmallIcon(R.drawable.ic_main_menu_downloads).setAutoCancel(true).setChannelId("Download").setOnlyAlertOnce(true);
        }

        public Notification build() {
            Notification.Builder builder;
            return (Build.VERSION.SDK_INT < 26 || (builder = this.notificationBuilder) == null) ? this.notificationCompat.m10359a() : builder.build();
        }

        public void setAutoCancel(boolean z) {
            C2478vh c2478vh = this.notificationCompat;
            if (c2478vh != null) {
                c2478vh.m10361d(z);
                return;
            }
            Notification.Builder builder = this.notificationBuilder;
            if (builder != null) {
                builder.setAutoCancel(z);
            }
        }

        public void setContentIntent(PendingIntent pendingIntent) {
            C2478vh c2478vh = this.notificationCompat;
            if (c2478vh != null) {
                c2478vh.m10362e(pendingIntent);
                return;
            }
            Notification.Builder builder = this.notificationBuilder;
            if (builder != null) {
                builder.setContentIntent(pendingIntent);
            }
        }

        public void setContentText(CharSequence charSequence) {
            C2478vh c2478vh = this.notificationCompat;
            if (c2478vh != null) {
                c2478vh.m10363f(charSequence);
                return;
            }
            Notification.Builder builder = this.notificationBuilder;
            if (builder != null) {
                builder.setContentText(charSequence);
            }
        }

        public void setProgress(int i, int i2, boolean z) {
            C2478vh c2478vh = this.notificationCompat;
            if (c2478vh != null) {
                c2478vh.m10367j(i, i2, z);
                return;
            }
            Notification.Builder builder = this.notificationBuilder;
            if (builder != null) {
                builder.setProgress(i, i2, z);
            }
        }
    }

    public static BrowserDownloadManager getInstance() {
        if (instance == null) {
            instance = new BrowserDownloadManager();
        }
        return instance;
    }

    public void m6675A(DownloadItem iVar) {
        try {
            Uri uri = iVar.contentUri;
            if (uri == null || uri.getAuthority() == null) {
                C0801Ra.getInstance().m3809l(iVar.fileName, iVar.mimeType);
            } else {
                String str = iVar.mimeType;
                if (str.equals("message/rfc822") || str.equals("text/html") || str.equals("text/plain") || str.startsWith("image/")) {
                    this.browserActivity.runOnUiThread(new OpenFileRunnable(iVar.contentUri.toString()));
                } else {
                    C0801Ra.getInstance().m3807j(iVar.contentUri, iVar.mimeType);
                }
            }
        } catch (Exception unused) {
            this.browserActivity.runOnUiThread(new ErrorToastRunnable());
        }
    }

    public int m6676B(String str) {
        DownloadItem iVarM6698n = m6698n(str);
        DownloadTask lVarM6701r = m6701r(str);
        if (lVarM6701r != null) {
            lVarM6701r.cancelDownload();
            iVarM6698n.downloadStatus = 2;
            if (iVarM6698n.totalBytes == -1) {
                iVarM6698n.downloadedBytes = 0L;
                iVarM6698n.currentProgress = 0L;
            }
        }
        m6687M(iVarM6698n);
        m6688N(iVarM6698n);
        if (iVarM6698n == null) {
            return 0;
        }
        iVarM6698n.downloadStatus = 2;
        m6692h();
        return 0;
    }

    public void m6677C(String str) {
        DownloadItem iVarM6698n = m6698n(str);
        if (iVarM6698n != null) {
            if (iVarM6698n.downloadStatus == 3) {
                FileUtils.deleteFile(iVarM6698n.fileName);
                try {
                    Uri uri = iVarM6698n.contentUri;
                    if (uri != null && uri.getAuthority() != null) {
                        this.browserActivity.getContentResolver().delete(iVarM6698n.contentUri, null, null);
                        iVarM6698n.updateContentUri();
                    }
                } catch (Exception unused) {
                }
            } else {
                FileUtils.deleteFile(m6697m(str, iVarM6698n.fileName));
            }
            iVarM6698n.downloadedBytes = 0L;
            resumeDownload(str);
        }
    }

    public void m6678D(boolean z) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        try {
            try {
                Iterator it = this.activeDownloadsMap.entrySet().iterator();
                while (it.hasNext()) {
                    DownloadItem iVar = (DownloadItem) ((Map.Entry) it.next()).getValue();
                    if (z) {
                        Uri uri = iVar.contentUri;
                        if (uri == null || uri.getAuthority() == null) {
                            FileUtils.deleteFile(iVar.fileName);
                        } else {
                            this.browserActivity.getContentResolver().delete(iVar.contentUri, null, null);
                        }
                    }
                    this.notificationManager.cancel((int) iVar.downloadId);
                }
                this.activeDownloadsMap.clear();
            } catch (Exception e2) {
                e2.printStackTrace();
            }
            writableDatabase.delete("download", null, null);
        } catch (Throwable th) {
            writableDatabase.delete("download", null, null);
            throw th;
        }
    }

    public void m6679E(String str) {
        new RemoveDownloadDialog(this.browserActivity, str).show(this.browserActivity.getString(R.string.dlg_remove_dl_task), this.browserActivity.getString(R.string.dlg_remove_dl_task_confirm), this.browserActivity.getString(R.string.dlg_remove_download_file));
    }

    public void m6680F(String str, boolean z) {
        l lVarM6700p;
        try {
            DownloadItem iVarM6698n = m6698n(str);
            if (iVarM6698n != null) {
                if (z) {
                    Uri uri = iVarM6698n.contentUri;
                    if (uri == null || uri.getAuthority() == null) {
                        FileUtils.deleteFile(iVarM6698n.fileName);
                    } else {
                        this.browserActivity.getContentResolver().delete(iVarM6698n.contentUri, null, null);
                    }
                }
                if (iVarM6698n.downloadStatus == 1 && (lVarM6700p = m6700p(iVarM6698n)) != null) {
                    lVarM6700p.cancelDownload();
                }
                m6694j(str);
                k kVar = iVarM6698n.callback;
                if (kVar != null) {
                    kVar.mo6507b();
                }
            }
        } catch (Exception unused) {
        }
    }

    public DownloadItem m6681G(String str) {
        int i2;
        DownloadItem iVarM6698n = m6698n(str);
        if (iVarM6698n != null) {
            if (iVarM6698n.totalBytes > 0) {
                m6695k(iVarM6698n);
            }
            iVarM6698n.retryCount = 0;
            DownloadTask lVarM6700p = m6700p(iVarM6698n);
            if (lVarM6700p != null) {
                DownloadItem iVar = lVarM6700p.currentDownload;
                if (iVar != null && ((i2 = iVar.downloadStatus) == 7 || i2 == 1)) {
                    return iVarM6698n;
                }
                lVarM6700p.assignDownload(iVarM6698n);
                if (AndroidSystemUtils.isWifiConnected(this.browserActivity) || lVarM6700p.currentDownload.allowMobileData) {
                    lVarM6700p.executeDownload(iVarM6698n.downloadUrl, iVarM6698n.userAgent, iVarM6698n.referer, iVarM6698n.totalBytes, iVarM6698n.fileName, null);
                } else {
                    new WiFiConfirmDialog(this.browserActivity, iVarM6698n, lVarM6700p).show(this.browserActivity.getString(R.string.dlg_download_title), this.browserActivity.getString(R.string.dlg_download_text_no_wifi));
                }
            } else {
                iVarM6698n.downloadStatus = 6;
            }
            m6687M(iVarM6698n);
        }
        return iVarM6698n;
    }

    public void resumeDownload(String downloadId) {
        Intent intent = new Intent(this.browserActivity, DownloadService.class);
        intent.setAction(DOWNLOAD_RESUME_ACTION);
        intent.putExtra("download-id", downloadId);
        this.browserActivity.startService(intent);
    }

    public DownloadItem m6683I(String str, String str2, String str3, String str4, String str5, long j2, String str6) {
        return m6684J(str, str2, str3, str4, str5, j2, str6, null, null);
    }

    public DownloadItem m6684J(String str, String str2, String str3, String str4, String str5, long j2, String str6, DownloadStatusCallback kVar, HashMap map) {
        DownloadItem iVarM6706w;
        if (TextUtils.isEmpty(str) || !str.toLowerCase().startsWith("http")) {
            return null;
        }
        String strM5610q = PhoneUtils.getInstance().getDownloadsDirPath();
        String strM6696l = strM5610q + "/" + str4;
        CookieManager.getInstance().getCookie(str);
        this.browserActivity.runOnUiThread(new ToastRunnable());
        long jCurrentTimeMillis = System.currentTimeMillis();
        if (FileUtils.fileExists(strM6696l)) {
            strM6696l = m6696l(strM6696l);
        }
        String str7 = strM6696l;
        DownloadTask lVarM6699o = m6699o();
        Long lValueOf = Long.valueOf(jCurrentTimeMillis);
        if (lVarM6699o != null) {
            iVarM6706w = m6706w(lValueOf, str7, str, str2, strM5610q, str5, str3, j2, 0, str6);
            lVarM6699o.assignDownload(iVarM6706w);
            iVarM6706w.downloadStatus = 7;
            m6688N(iVarM6706w);
            lVarM6699o.executeDownload(str, str3, str2, j2, str7, map);
        } else {
            iVarM6706w = m6706w(lValueOf, str4, str, str2, strM5610q, str5, str3, j2, 6, str6);
        }
        if (kVar != null) {
            iVarM6706w.callback = kVar;
        }
        return iVarM6706w;
    }

    public void m6685K(String str, String str2, String str3, String str4, String str5, long j2, String str6) {
        Intent intent = new Intent(this.browserActivity, (Class<?>) DownloadService.class);
        intent.setAction(f4616h);
        intent.putExtra("url", str);
        intent.putExtra("filename", str4);
        intent.putExtra("referer", str2);
        intent.putExtra("user-agent", str3);
        intent.putExtra("mime-type", str5);
        intent.putExtra("tag", str6);
        intent.putExtra("content-length", j2);
        if (Build.VERSION.SDK_INT >= 26) {
            this.browserActivity.startForegroundService(intent);
        } else {
            this.browserActivity.startService(intent);
        }
    }

    public final boolean m6686L(String str) {
        Iterator it = this.activeDownloadsMap.entrySet().iterator();
        while (it.hasNext()) {
            if (((i) ((Map.Entry) it.next()).getValue()).fileName.equals(str)) {
                return true;
            }
        }
        return false;
    }

    public final void m6687M(DownloadItem iVar) {
        Log.i("dl-manager", " >>>>> update   download sofar:" + iVar.downloadedBytes);
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        String[] strArr = {iVar.downloadId + ""};
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", Integer.valueOf(iVar.downloadStatus));
        contentValues.put("total_size", Long.valueOf(iVar.totalBytes));
        contentValues.put("dl_so_far", Long.valueOf(iVar.downloadedBytes));
        contentValues.put("try_times", Integer.valueOf(iVar.retryCount));
        Uri uri = iVar.contentUri;
        if (uri != null) {
            contentValues.put("path", uri.toString());
        }
        writableDatabase.update("download", contentValues, "download_id= ?", strArr);
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x00d9 A[ADDED_TO_REGION, LOOP:0: B:35:0x00d9->B:36:0x00db, LOOP_START, PHI: r6
  0x00d9: PHI (r6v1 int) = (r6v0 int), (r6v2 int) binds: [B:34:0x00d7, B:36:0x00db] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:39:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6688N(DownloadItem r13) {
        /*
            Method dump skipped, instructions count: 239
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserDownloadManager.m6688N(com.mmbox.xbrowser.c$i):void");
    }

    public void m6689e(String str, String str2, String str3, String str4) throws IOException {
        Uri uri;
        DownloadItem iVarM6706w = m6706w(Long.valueOf(System.currentTimeMillis()), str2, str, null, TextUtils.isEmpty(str3) ? PhoneUtils.getInstance().getDownloadsDirPath() : str3, str4, null, FileUtils.getFileSize(str2), 3, "");
        if (!SharedPreferencesHelper.getInstance().f4936w || (uri = iVarM6706w.contentUri) == null) {
            return;
        }
        if (uri == null || uri.getAuthority() == null) {
            AndroidSystemUtils.m8699g(str2, iVarM6706w.fileName);
            FileUtils.deleteFile(str2);
        } else {
            AndroidSystemUtils.m8698f(this.browserActivity, iVarM6706w.fileName, iVarM6706w.contentUri);
            FileUtils.deleteFile(iVarM6706w.fileName);
        }
    }

    public boolean isDownloadProviderEnabled() {
        // Get the current application enabled setting for the download provider
        int appEnabledSetting = this.browserActivity.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");

        // Check if the application is in an enabled state
        return !(appEnabledSetting == PackageManager.COMPONENT_ENABLED_STATE_DISABLED ||
                appEnabledSetting == PackageManager.COMPONENT_ENABLED_STATE_DISABLED_USER ||
                appEnabledSetting == PackageManager.COMPONENT_ENABLED_STATE_DISABLED_UNTIL_USED ||
                appEnabledSetting == PackageManager.COMPONENT_ENABLED_STATE_DEFAULT);
    }


    public void m6691g(String url, String str2, DownloadCallback callback) {
        Log.i("check-down", "url:" + url);
        if (!url.startsWith("http")) {
            Log.i("check-down", "invalid url:" + url);
            return;
        }
        if (!url.contains(".")) {
            return;
        }
        try {
            Request.Builder builderVarM507I = new Request.Builder().url(url.trim());
            try {
                builderVarM507I.addHeader("User-Agent", SharedPreferencesHelper.getInstance().m6849D());
            } catch (IllegalArgumentException unused) {
                builderVarM507I.addHeader("User-Agent", SharedPreferencesHelper.defaultUserAgent);
            }
            if (str2 != null) {
                builderVarM507I.addHeader("Referer", str2);
            }
            String cookie = CookieManager.getInstance().getCookie(url);
            if (cookie != null) {
                builderVarM507I.addHeader("Cookie", cookie);
            }
            this.httpClient.newCall(builderVarM507I.m500b()).mo1791i(new DownloadInfoCallback(callback, url));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m6692h() {
        if (AndroidSystemUtils.isWifiConnected(this.browserActivity)) {
            for (Map.Entry<String, DownloadItem> entry : this.activeDownloadsMap.entrySet()) {
                DownloadItem downloadItem = entry.getValue();
                if (downloadItem.downloadStatus != 3 && downloadItem.downloadStatus != 2 && downloadItem.retryCount < 3) {
                    resumeDownload(downloadItem.downloadId + "");
                }
            }
        }
    }

    public final PendingIntent m6693i(DownloadItem iVar) {
        Intent intent;
        if (iVar.downloadStatus == 3) {
            int i2 = Build.VERSION.SDK_INT;
            if ((i2 >= 29 && !Environment.isExternalStorageLegacy()) || iVar.contentUri != null) {
                Intent intent2 = new Intent("android.intent.action.VIEW");
                intent2.setFlags(1);
                intent2.setDataAndType(iVar.contentUri, iVar.mimeType);
                return i2 >= 31 ? PendingIntent.getActivity(this.browserActivity, (int) iVar.downloadId, intent2, 67108864) : PendingIntent.getActivity(this.browserActivity, (int) iVar.downloadId, intent2, 134217728);
            }
            intent = FileUtils.createViewFileIntent(this.browserActivity, iVar.fileName);
        } else {
            BrowserActivity browserActivity = this.browserActivity;
            intent = new Intent(browserActivity, browserActivity.getClass());
            intent.setAction("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.APP_BROWSER");
            intent.setData(Uri.parse("x:dl"));
            if (Build.VERSION.SDK_INT >= 31) {
                return PendingIntent.getActivity(this.browserActivity, (int) iVar.downloadId, intent, 67108864);
            }
        }
        return PendingIntent.getActivity(this.browserActivity, (int) iVar.downloadId, intent, 134217728);
    }

    public final void m6694j(String str) {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("download", "download_id= ?", new String[]{str});
        DownloadItem iVar = (DownloadItem) this.activeDownloadsMap.get(str);
        if (iVar.downloadStatus != 3) {
            FileUtils.deleteFile(m6697m(str, iVar.fileName));
            m6676B(str);
        }
        this.activeDownloadsMap.remove(iVar.downloadId + "");
        this.notificationManager.cancel((int) iVar.downloadId);
        BrowserActivity.getActivity().updateTitle("native_call_delete_node_by_id('" + str + "')");
    }

    public long m6695k(DownloadItem iVar) {
        long length = 0;
        try {
            Uri uri = iVar.contentUri;
            if (uri != null && uri.getAuthority() != null) {
                length = this.browserActivity.getContentResolver().openInputStream(iVar.contentUri).available();
            } else if (FileUtils.fileExists(iVar.fileName)) {
                length = new File(iVar.fileName).length();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        iVar.downloadedBytes = length;
        return length;
    }

    public String m6696l(String str) {
        Matcher matcher = f4618j.matcher(str);
        if (!matcher.find()) {
            String strM4238v = FileUtils.appendSuffix(str, "1");
            return (FileUtils.fileExists(strM4238v) || m6686L(strM4238v)) ? m6696l(strM4238v) : strM4238v;
        }
        String strGroup = matcher.group(1);
        int i2 = Integer.parseInt(matcher.group(2)) + 1;
        String strGroup2 = matcher.group(3);
        if (strGroup2 == null) {
            strGroup2 = "";
        }
        String str2 = FileUtils.getParentPath(str) + "/" + strGroup + "_" + i2 + strGroup2;
        return (FileUtils.fileExists(str2) || m6686L(str2)) ? m6696l(str2) : str2;
    }

    public final String m6697m(String str, String str2) {
        return FileUtils.getFileNameWithoutExtension(str2) + "_" + str + ".part";
    }

    public DownloadItem m6698n(String str) {
        return (DownloadItem) this.activeDownloadsMap.get(str);
    }

    public synchronized DownloadTask m6699o() {
        return m6700p(null);
    }

    public synchronized DownloadTask m6700p(DownloadItem iVar) {
        DownloadTask lVar;
        if (iVar != null) {
            for (int i2 = 0; i2 < this.downloadTasksList.size(); i2++) {
                try {
                    lVar = (DownloadTask) this.downloadTasksList.get(i2);
                    if (lVar.currentDownload == iVar) {
                        break;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            lVar = null;
        } else {
            lVar = null;
        }
        if (lVar == null) {
            for (int i3 = 0; i3 < this.downloadTasksList.size(); i3++) {
                DownloadTask downloadTask = (DownloadTask) this.downloadTasksList.get(i3);
                i currentDownload = downloadTask.currentDownload;
                if (currentDownload != null && !currentDownload.isDownloadComplete()) {
                }
                lVar = downloadTask;
            }
        }
        if (lVar == null && this.downloadTasksList.size() < 7) {
            lVar = new DownloadTask();
            this.downloadTasksList.add(lVar);
        }
        return lVar;
    }

    public final DownloadTask m6701r(String str) throws NumberFormatException {
        long j2 = Long.parseLong(str);
        for (int i2 = 0; i2 < this.downloadTasksList.size(); i2++) {
            DownloadTask lVar = (DownloadTask) this.downloadTasksList.get(i2);
            if (lVar.isHandlingDownload(j2)) {
                return lVar;
            }
        }
        return null;
    }

    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
        this.httpClient = NetworkUtils.createUnsafeOkHttpClient();
        this.notificationManager = (NotificationManager) this.browserActivity.getSystemService(Context.NOTIFICATION_SERVICE);
        m6703t();
    }

    public final void m6703t() {
        Looper.myQueue().addIdleHandler(new QueueIdleHandler());
    }

    public String m6704u() throws JSONException {
        JSONArray jSONArray = new JSONArray();
        try {
            Cursor cursorQuery = this.browserActivity.getContentResolver().query(BrowserProvider.uriDownload, DatabaseColumns.DOWNLOAD, null, null, "create_at DESC");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("download_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("file_name"));
                        cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        cursorQuery.getString(cursorQuery.getColumnIndex("ua"));
                        cursorQuery.getString(cursorQuery.getColumnIndex("referer"));
                        cursorQuery.getLong(cursorQuery.getColumnIndex("total_size"));
                        cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                        cursorQuery.getInt(cursorQuery.getColumnIndex("try_times"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                        JSONObject jSONObject = new JSONObject();
                        jSONObject.put("download_id", j2);
                        jSONObject.put("file_name", FileUtils.getFileName(string));
                        jSONObject.put("file_type", FileUtils.getFileType(string));
                        jSONObject.put("status", i2);
                        jSONArray.put(jSONObject);
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return jSONArray.toString();
    }

    public void m6705v() {
        BrowserDownloadManager BrowserDownloadManager = this;
        try {
            Cursor cursorQuery = BrowserDownloadManager.browserActivity.getContentResolver().query(BrowserProvider.uriDownload, DatabaseColumns.DOWNLOAD, null, null, "download_id DESC");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        DownloadItem iVar = BrowserDownloadManager.new DownloadItem();
                        long j2 = cursorQuery.getLong(cursorQuery.getColumnIndex("download_id"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("file_name"));
                        String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
                        String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("path"));
                        String string4 = cursorQuery.getString(cursorQuery.getColumnIndex("ua"));
                        String string5 = cursorQuery.getString(cursorQuery.getColumnIndex("referer"));
                        long j3 = cursorQuery.getLong(cursorQuery.getColumnIndex("total_size"));
                        long j4 = cursorQuery.getLong(cursorQuery.getColumnIndex("dl_so_far"));
                        String string6 = cursorQuery.getString(cursorQuery.getColumnIndex("mime_type"));
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndex("try_times"));
                        try {
                            int i3 = cursorQuery.getInt(cursorQuery.getColumnIndex("status"));
                            iVar.downloadId = j2;
                            iVar.fileName = string;
                            iVar.downloadUrl = string2;
                            iVar.userAgent = string4;
                            iVar.referer = string5;
                            iVar.totalBytes = j3;
                            iVar.mimeType = string6;
                            iVar.downloadedBytes = j4;
                            iVar.retryCount = i2;
                            iVar.downloadStatus = i3;
                            if (SharedPreferencesHelper.getInstance().f4936w && !TextUtils.isEmpty(string3) && string3.startsWith("content://")) {
                                iVar.contentUri = Uri.parse(string3);
                            }
                            BrowserDownloadManager = this;
                            BrowserDownloadManager.activeDownloadsMap.put(iVar.downloadId + "", iVar);
                        } catch (Exception e2) {
                            e = e2;
                            e.printStackTrace();
                            return;
                        }
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e3) {
            e = e3;
        }
    }

    public DownloadItem m6706w(Long l2, String str, String str2, String str3, String str4, String str5, String str6, long j2, int i2, String str7) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        DownloadItem iVar = new DownloadItem();
        String strM457l = NetworkUtils.getMimeType(str);
        if (TextUtils.isEmpty(strM457l) || strM457l.equals("application/octet-stream")) {
            strM457l = str5;
        }
        try {
            ContentValues contentValues = new ContentValues();
            contentValues.put("download_id", l2);
            contentValues.put("url", str2);
            contentValues.put("referer", str3);
            contentValues.put("path", str4);
            contentValues.put("file_name", str);
            contentValues.put("path", str4);
            contentValues.put("mime_type", strM457l);
            contentValues.put("ua", str6);
            contentValues.put("total_size", Long.valueOf(j2));
            contentValues.put("create_at", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("status", Integer.valueOf(i2));
            iVar.downloadId = l2.longValue();
            iVar.fileName = str;
            iVar.totalBytes = j2;
            iVar.downloadStatus = i2;
            iVar.downloadUrl = str2;
            iVar.referer = str3;
            iVar.mimeType = strM457l;
            iVar.tag = str7;
            if (SharedPreferencesHelper.getInstance().f4936w) {
                if (Build.VERSION.SDK_INT >= 29) {
                    Uri uriM8705m = AndroidSystemUtils.m8705m(this.browserActivity, FileUtils.getFileName(str), strM457l, str7, true);
                    iVar.contentUri = uriM8705m;
                    if (uriM8705m != null) {
                        contentValues.put("path", uriM8705m.toString());
                    }
                } else {
                    iVar.fileName = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath() + "/" + FileUtils.getFileName(str);
                    File file = new File(iVar.fileName);
                    iVar.contentUri = FileProvider.getUriForFile(this.browserActivity, this.browserActivity.getPackageName() + ".fileProvider", file);
                }
            }
            writableDatabase.insert("download", null, contentValues);
            this.activeDownloadsMap.put(l2 + "", iVar);
            BrowserActivity.getActivity().updateTitle("loadDownloads()");
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return iVar;
    }

    public void m6707x() {
        Iterator it = this.activeDownloadsMap.entrySet().iterator();
        while (it.hasNext()) {
            i iVar = (i) ((Map.Entry) it.next()).getValue();
            int i2 = iVar.downloadStatus;
            if (i2 == 1 || i2 == 7) {
                iVar.downloadStatus = 5;
                m6688N(iVar);
            }
        }
    }

    public void m6708y(DownloadItem iVar) {
        Uri.parse(iVar.downloadUrl);
        if (!TextUtils.isEmpty(iVar.downloadUrl) || iVar.downloadUrl.indexOf("open=true") <= 0) {
            return;
        }
        getInstance().m6675A(iVar);
    }

    public void m6709z(String str) {
        try {
            DownloadItem iVarM6698n = m6698n(str);
            if (iVarM6698n.downloadStatus == 3) {
                m6675A(iVarM6698n);
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }
}
