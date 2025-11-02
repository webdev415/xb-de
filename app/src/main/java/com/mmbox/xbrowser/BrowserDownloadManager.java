package com.mmbox.xbrowser;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
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

import okhttp3.OkHttpClient;
import p000.NetworkUtils;
import p000.FileUtils;
import p000.DatabaseColumns;
import p000.AbstractC1900j2;
import p000.AndroidSystemUtils;
import p000.AbstractC2086n3;
import p000.AbstractC2132o3;
import p000.AbstractDialogC1303b6;
import p000.C0122Ck;
import p000.C0490Kk;
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

    public HashMap downloadRetryMap = new HashMap<>(3);

    public BrowserActivity browserActivity = null;

    public HashMap activeDownloadsMap = new HashMap<>(3);

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

        public final DownloadCallback f4631a;

        public final String f4632b;

        public DownloadInfoCallback(DownloadCallback jVar, String str) {
            this.f4631a = jVar;
            this.f4632b = str;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) throws IOException {
            if (c0490Kk.m2396j() != 200) {
                if (c0490Kk.m2396j() != 403 || downloadRetryMap.containsKey(this.f4632b)) {
                    j jVar = this.f4631a;
                    if (jVar != null) {
                        jVar.mo6445a(this.f4632b);
                        return;
                    }
                    return;
                }
                HashMap map = downloadRetryMap;
                String str = this.f4632b;
                map.put(str, str);
                m6691g(this.f4632b, null, this.f4631a);
                return;
            }
            String strM2399p = c0490Kk.m2399p("Content-Type");
            long jMo2711i = c0490Kk.m2392a().mo2711i();
            String strM2399p2 = c0490Kk.m2399p("Content-Disposition");
            byte[] bArr = new byte[32];
            c0490Kk.m2392a().m2708a().read(bArr);
            try {
                String str2 = new String(bArr, StandardCharsets.UTF_8);
                if (str2.indexOf("#EXT") >= 0) {
                    strM2399p = "application/x-mpegurl";
                } else if (str2.indexOf("mp4") >= 0) {
                    strM2399p = "video/mp4";
                }
            } catch (Exception unused) {
            }
            String str3 = strM2399p;
            j jVar2 = this.f4631a;
            if (jVar2 != null) {
                jVar2.mo6446b(this.f4632b, str3, strM2399p2, jMo2711i);
                downloadRetryMap.remove(this.f4632b);
            }
            interfaceC0418J3.cancel();
            c0490Kk.m2392a().close();
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            j jVar = this.f4631a;
            if (jVar != null) {
                jVar.mo6445a(this.f4632b);
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

    public class RemoveDownloadDialog extends AbstractDialogC1303b6 {

        public final String f4636f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public RemoveDownloadDialog(Context context, String str) {
            super(context);
            this.f4636f = str;
        }

        @Override
        public void mo315b() {
        }

        @Override
        public void mo316c() {
            CheckBox checkBox = (CheckBox) findViewById(R.id.another_condition);
            C1541c.m6674q().m6680F(this.f4636f, checkBox != null && checkBox.isChecked());
            C1199a3.m5090f().m5098j("notify_remove_download", "downloadId", this.f4636f);
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

    public class WiFiConfirmDialog extends AbstractDialogC1303b6 {

        public final DownloadItem f4641f;

        public final DownloadTask f4642g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public WiFiConfirmDialog(Context context, DownloadItem iVar, DownloadTask lVar) {
            super(context);
            this.f4641f = iVar;
            this.f4642g = lVar;
        }

        @Override
        public void mo315b() {
            this.f4641f.downloadStatus = 5;
        }

        @Override
        public void mo316c() {
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

        public DownloadStatusCallback f4659p = null;

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
        void mo6445a(String str);

        void mo6446b(String str, String str2, String str3, long j);
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
                l lVar = l.this;
                i iVar = lVar.currentDownload;
                if (iVar != null && iVar.downloadSpeed == 0) {
                    iVar.downloadStatus = 4;
                    m6687M(iVar);
                    l lVar2 = l.this;
                    m6688N(lVar2.currentDownload);
                }
                l.this.currentDownload = null;
            }
        }

        public class DownloadExecutorRunnable implements Runnable {

            public final long totalBytes;

            public final String downloadUrl;

            public final String fileName;

            public final String userAgent;

            public final HashMap headers;

            public final String filePath;

            public DownloadExecutorRunnable(long j, String str, String str2, String str3, HashMap map, String str4) {
                this.totalBytes = j;
                this.downloadUrl = str;
                this.fileName = str2;
                this.userAgent = str3;
                this.headers = map;
                this.filePath = str4;
            }

            /* JADX WARN: Can't wrap try/catch for region: R(23:14|125|15|16|(21:123|18|25|(1:27)|28|(2:126|30)|34|(4:121|36|(2:39|37)|131)|43|(1:47)|48|(1:50)|120|51|(6:68|(1:78)(5:118|74|79|(2:80|(3:82|(2:84|130)(2:85|129)|86)(1:128))|87)|77|79|(3:80|(0)(0)|86)|87)(2:56|(2:65|(1:67))(1:60))|88|(1:90)|113|(1:115)|116|117)(1:24)|23|25|(0)|28|(0)|34|(0)|43|(2:45|47)|48|(0)|120|51|(4:53|55|68|(8:70|78|77|79|(3:80|(0)(0)|86)|87|88|(0))(0))(0)|113|(0)|116|117) */
            /* JADX WARN: Code restructure failed: missing block: B:63:0x017a, code lost:
            
                r0 = move-exception;
             */
            /* JADX WARN: Code restructure failed: missing block: B:92:0x0236, code lost:
            
                r2 = r20.f4680r.currentDownload;
             */
            /* JADX WARN: Code restructure failed: missing block: B:93:0x023c, code lost:
            
                if (r2.downloadStatus != 2) goto L94;
             */
            /* JADX WARN: Code restructure failed: missing block: B:94:0x023e, code lost:
            
                r2.downloadStatus = 4;
                r2 = r2.f4659p;
             */
            /* JADX WARN: Code restructure failed: missing block: B:95:0x0243, code lost:
            
                if (r2 != null) goto L96;
             */
            /* JADX WARN: Code restructure failed: missing block: B:96:0x0245, code lost:
            
                r2.mo6506a();
             */
            /* JADX WARN: Code restructure failed: missing block: B:97:0x0248, code lost:
            
                r0.printStackTrace();
             */
            /* JADX WARN: Code restructure failed: missing block: B:98:0x024b, code lost:
            
                r10.m2392a().close();
                r0 = r20.f4680r.outputStream;
             */
            /* JADX WARN: Code restructure failed: missing block: B:99:0x0256, code lost:
            
                if (r0 != null) goto L100;
             */
            /* JADX WARN: Removed duplicated region for block: B:115:0x0291  */
            /* JADX WARN: Removed duplicated region for block: B:121:0x008a A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:126:0x007c A[EXC_TOP_SPLITTER, SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:128:0x0222 A[EDGE_INSN: B:128:0x0222->B:87:0x0222 BREAK  A[LOOP:0: B:80:0x01f4->B:86:0x0219], SYNTHETIC] */
            /* JADX WARN: Removed duplicated region for block: B:27:0x0067 A[Catch: Exception -> 0x0057, TryCatch #5 {Exception -> 0x0057, blocks: (B:15:0x002f, B:18:0x004b, B:25:0x0063, B:27:0x0067, B:28:0x0070, B:34:0x0086, B:43:0x00ae, B:45:0x00b8, B:47:0x00be, B:48:0x00fb, B:50:0x011b, B:88:0x0225, B:90:0x0232, B:101:0x0259, B:103:0x0266, B:104:0x0269, B:98:0x024b, B:42:0x00ab, B:33:0x0083, B:24:0x0060, B:23:0x005c, B:22:0x005a, B:36:0x008a, B:37:0x0092, B:39:0x0098, B:51:0x012f, B:53:0x0135, B:56:0x013e, B:58:0x0146, B:60:0x0154, B:65:0x017d, B:67:0x0187, B:68:0x018c, B:70:0x0194, B:72:0x019c, B:74:0x01a2, B:79:0x01e5, B:80:0x01f4, B:82:0x01fa, B:84:0x0212, B:86:0x0219, B:87:0x0222, B:76:0x01bb, B:77:0x01d8, B:78:0x01db, B:92:0x0236, B:94:0x023e, B:96:0x0245, B:97:0x0248, B:30:0x007c), top: B:125:0x002f, inners: #2, #3, #4, #6 }] */
            /* JADX WARN: Removed duplicated region for block: B:50:0x011b A[Catch: Exception -> 0x0057, TRY_LEAVE, TryCatch #5 {Exception -> 0x0057, blocks: (B:15:0x002f, B:18:0x004b, B:25:0x0063, B:27:0x0067, B:28:0x0070, B:34:0x0086, B:43:0x00ae, B:45:0x00b8, B:47:0x00be, B:48:0x00fb, B:50:0x011b, B:88:0x0225, B:90:0x0232, B:101:0x0259, B:103:0x0266, B:104:0x0269, B:98:0x024b, B:42:0x00ab, B:33:0x0083, B:24:0x0060, B:23:0x005c, B:22:0x005a, B:36:0x008a, B:37:0x0092, B:39:0x0098, B:51:0x012f, B:53:0x0135, B:56:0x013e, B:58:0x0146, B:60:0x0154, B:65:0x017d, B:67:0x0187, B:68:0x018c, B:70:0x0194, B:72:0x019c, B:74:0x01a2, B:79:0x01e5, B:80:0x01f4, B:82:0x01fa, B:84:0x0212, B:86:0x0219, B:87:0x0222, B:76:0x01bb, B:77:0x01d8, B:78:0x01db, B:92:0x0236, B:94:0x023e, B:96:0x0245, B:97:0x0248, B:30:0x007c), top: B:125:0x002f, inners: #2, #3, #4, #6 }] */
            /* JADX WARN: Removed duplicated region for block: B:68:0x018c A[Catch: all -> 0x0177, Exception -> 0x017a, TryCatch #1 {Exception -> 0x017a, blocks: (B:51:0x012f, B:53:0x0135, B:56:0x013e, B:58:0x0146, B:60:0x0154, B:65:0x017d, B:67:0x0187, B:68:0x018c, B:70:0x0194, B:72:0x019c, B:79:0x01e5, B:80:0x01f4, B:82:0x01fa, B:84:0x0212, B:86:0x0219, B:87:0x0222, B:76:0x01bb, B:77:0x01d8, B:78:0x01db), top: B:120:0x012f, outer: #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:78:0x01db A[Catch: all -> 0x0177, Exception -> 0x017a, TryCatch #1 {Exception -> 0x017a, blocks: (B:51:0x012f, B:53:0x0135, B:56:0x013e, B:58:0x0146, B:60:0x0154, B:65:0x017d, B:67:0x0187, B:68:0x018c, B:70:0x0194, B:72:0x019c, B:79:0x01e5, B:80:0x01f4, B:82:0x01fa, B:84:0x0212, B:86:0x0219, B:87:0x0222, B:76:0x01bb, B:77:0x01d8, B:78:0x01db), top: B:120:0x012f, outer: #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:82:0x01fa A[Catch: all -> 0x0177, Exception -> 0x017a, TryCatch #1 {Exception -> 0x017a, blocks: (B:51:0x012f, B:53:0x0135, B:56:0x013e, B:58:0x0146, B:60:0x0154, B:65:0x017d, B:67:0x0187, B:68:0x018c, B:70:0x0194, B:72:0x019c, B:79:0x01e5, B:80:0x01f4, B:82:0x01fa, B:84:0x0212, B:86:0x0219, B:87:0x0222, B:76:0x01bb, B:77:0x01d8, B:78:0x01db), top: B:120:0x012f, outer: #3 }] */
            /* JADX WARN: Removed duplicated region for block: B:90:0x0232 A[Catch: Exception -> 0x0057, PHI: r0
  0x0232: PHI (r0v39 java.io.OutputStream) = (r0v38 java.io.OutputStream), (r0v57 java.io.OutputStream) binds: [B:100:0x0258, B:89:0x0230] A[DONT_GENERATE, DONT_INLINE], TRY_LEAVE, TryCatch #5 {Exception -> 0x0057, blocks: (B:15:0x002f, B:18:0x004b, B:25:0x0063, B:27:0x0067, B:28:0x0070, B:34:0x0086, B:43:0x00ae, B:45:0x00b8, B:47:0x00be, B:48:0x00fb, B:50:0x011b, B:88:0x0225, B:90:0x0232, B:101:0x0259, B:103:0x0266, B:104:0x0269, B:98:0x024b, B:42:0x00ab, B:33:0x0083, B:24:0x0060, B:23:0x005c, B:22:0x005a, B:36:0x008a, B:37:0x0092, B:39:0x0098, B:51:0x012f, B:53:0x0135, B:56:0x013e, B:58:0x0146, B:60:0x0154, B:65:0x017d, B:67:0x0187, B:68:0x018c, B:70:0x0194, B:72:0x019c, B:74:0x01a2, B:79:0x01e5, B:80:0x01f4, B:82:0x01fa, B:84:0x0212, B:86:0x0219, B:87:0x0222, B:76:0x01bb, B:77:0x01d8, B:78:0x01db, B:92:0x0236, B:94:0x023e, B:96:0x0245, B:97:0x0248, B:30:0x007c), top: B:125:0x002f, inners: #2, #3, #4, #6 }] */
            @Override
            /*
                Code decompiled incorrectly, please refer to instructions dump.
                To view partially-correct code enable 'Show inconsistent code' option in preferences
            */
            public void run() throws IOException {
                /*
                    Method dump skipped, instructions count: 736
                    To view this dump change 'Code comments level' option to 'DEBUG'
                */
                throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.C1541c.l.c.run():void");
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
                OutputStream outputStream = this.outputStream;
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
            C1199a3.m5090f().m5098j("notify_download_start", "downloadId", this.currentDownload.downloadId + "");
            new Thread(new DownloadExecutorRunnable(j, str, str2, str3, map, str4)).start();
        }

        public void onDownloadComplete() {
            DownloadStatusCallback kVar;
            DownloadItem iVar = this.currentDownload;
            if (iVar != null && (kVar = iVar.f4659p) != null) {
                if (iVar.totalBytes == -1) {
                    iVar.totalBytes = iVar.downloadedBytes;
                }
                kVar.mo6507b();
            }
            C1199a3.m5090f().m5098j("notify_download_finish", "downloadId", this.currentDownload.downloadId + "");
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
            DownloadItem iVar = this.currentDownload;
            iVar.downloadStatus = 1;
            iVar.currentProgress = j;
            iVar.downloadStartTime = System.currentTimeMillis();
            long jCurrentTimeMillis = System.currentTimeMillis();
            DownloadItem iVar2 = this.currentDownload;
            if (jCurrentTimeMillis > iVar2.lastProgressTime + 200) {
                iVar2.downloadSpeed = iVar2.currentProgress - iVar2.lastProgressBytes;
                iVar2.lastProgressTime = System.currentTimeMillis();
                DownloadItem iVar3 = this.currentDownload;
                iVar3.lastProgressBytes = iVar3.currentProgress;
                C1199a3.m5090f().m5098j("notify_download_progress", "downloadId", this.currentDownload.downloadId + "");
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

    public static BrowserDownloadManager m6674q() {
        if (instance == null) {
            instance = new BrowserDownloadManager();
        }
        return instance;
    }

    public void m6675A(DownloadItem iVar) {
        try {
            Uri uri = iVar.contentUri;
            if (uri == null || uri.getAuthority() == null) {
                C0801Ra.m3798f().m3809l(iVar.fileName, iVar.mimeType);
            } else {
                String str = iVar.mimeType;
                if (str.equals("message/rfc822") || str.equals("text/html") || str.equals("text/plain") || str.startsWith("image/")) {
                    this.browserActivity.runOnUiThread(new OpenFileRunnable(iVar.contentUri.toString()));
                } else {
                    C0801Ra.m3798f().m3807j(iVar.contentUri, iVar.mimeType);
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
            m6682H(str);
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
        new RemoveDownloadDialog(this.browserActivity, str).m5644e(this.browserActivity.getString(R.string.dlg_remove_dl_task), this.browserActivity.getString(R.string.dlg_remove_dl_task_confirm), this.browserActivity.getString(R.string.dlg_remove_download_file));
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
                k kVar = iVarM6698n.f4659p;
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
                    new WiFiConfirmDialog(this.browserActivity, iVarM6698n, lVarM6700p).m5643d(this.browserActivity.getString(R.string.dlg_download_title), this.browserActivity.getString(R.string.dlg_download_text_no_wifi));
                }
            } else {
                iVarM6698n.downloadStatus = 6;
            }
            m6687M(iVarM6698n);
        }
        return iVarM6698n;
    }

    public void m6682H(String str) {
        Intent intent = new Intent(this.browserActivity, (Class<?>) DownloadService.class);
        intent.setAction(f4617i);
        intent.putExtra("download-id", str);
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
            iVarM6706w.f4659p = kVar;
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
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.C1541c.m6688N(com.mmbox.xbrowser.c$i):void");
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

    public boolean m6690f() {
        int applicationEnabledSetting = this.browserActivity.getPackageManager().getApplicationEnabledSetting("com.android.providers.downloads");
        return (applicationEnabledSetting == 2 || applicationEnabledSetting == 3 || applicationEnabledSetting == 3 || applicationEnabledSetting == 4) ? false : true;
    }

    public void m6691g(String str, String str2, DownloadCallback jVar) {
        Log.i("check-down", "url:" + str);
        if (!str.startsWith("http")) {
            Log.i("check-down", "invalid url:" + str);
            return;
        }
        if (str.indexOf(".") < 0) {
            return;
        }
        try {
            C0122Ck.a aVarM507i = new C0122Ck.a().m507i(str.trim());
            try {
                aVarM507i.m499a("User-Agent", SharedPreferencesHelper.getInstance().m6849D());
            } catch (IllegalArgumentException unused) {
                aVarM507i.m499a("User-Agent", SharedPreferencesHelper.defaultUserAgent);
            }
            if (str2 != null) {
                aVarM507i.m499a("Referer", str2);
            }
            String cookie = CookieManager.getInstance().getCookie(str);
            if (cookie != null) {
                aVarM507i.m499a("Cookie", cookie);
            }
            this.httpClient.m2004y(aVarM507i.m500b()).mo1791i(new DownloadInfoCallback(jVar, str));
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m6692h() {
        if (AndroidSystemUtils.isWifiConnected(this.browserActivity)) {
            Iterator it = this.activeDownloadsMap.entrySet().iterator();
            while (it.hasNext()) {
                i iVar = (i) ((Map.Entry) it.next()).getValue();
                int i2 = iVar.downloadStatus;
                if (i2 != 3 && i2 != 2 && iVar.retryCount < 3) {
                    m6682H(iVar.downloadId + "");
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
        BrowserActivity.getActivity().m6361u0("native_call_delete_node_by_id('" + str + "')");
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
                DownloadTask lVar2 = (DownloadTask) this.downloadTasksList.get(i3);
                i iVar2 = lVar2.currentDownload;
                if (iVar2 != null && !iVar2.isDownloadComplete()) {
                }
                lVar = lVar2;
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

    public void m6702s(BrowserActivity browserActivity) {
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
        C1541c c1541c = this;
        try {
            Cursor cursorQuery = c1541c.browserActivity.getContentResolver().query(BrowserProvider.uriDownload, DatabaseColumns.DOWNLOAD, null, null, "download_id DESC");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        DownloadItem iVar = c1541c.new DownloadItem();
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
                            c1541c = this;
                            c1541c.activeDownloadsMap.put(iVar.downloadId + "", iVar);
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
            BrowserActivity.getActivity().m6361u0("loadDownloads()");
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
        m6674q().m6675A(iVar);
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
