package com.mmbox.xbrowser;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.xbrowser.play.R;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import okhttp3.OkHttpClient;
import p000.NetworkUtils;
import p000.FileUtils;
import p000.AndroidSystemUtils;
import p000.AbstractCryptoUtils;
import p000.ConfirmDialog;
import p000.DownloadConfirmDialog;
import p000.ResourceCacheManager;
import p000.ApiEndpointsManager;
import p000.C0712Pc;
import p000.C2406u0;
import p000.C2518wb;
import p000.InterfaceC1300b3;

public class VideoSniffingManager {

    public static VideoSniffingManager instance;

    public BrowserActivity browserActivity = null;

    public C0712Pc videoParser = null;

    public OkHttpClient httpClient = null;

    public String currentUrl = null;

    public Runnable videoCheckRunnable = new VideoSniffingTrigger();

    public final ArrayList<String> sniffedVideos = new ArrayList<>();

    public JSONArray videoConfigs = null;

    public final ArrayList pendingVideoChecks = new ArrayList<>(3);

    public class VideoSniffingTrigger implements Runnable {

        public class IdleVideoSniffHandler implements MessageQueue.IdleHandler {
            public IdleVideoSniffHandler() {
            }

            @Override
            public boolean queueIdle() {
                if (browserActivity.isNextTabValid()) {
                    return false;
                }
                Log.i("sniff-video", ">>>>>>>>>>>>>>>>>  start check media resource >>>>>>>>>>>>>>>>>>>2");
                browserActivity.updateTitle("if(window._XJSAPI_ != undefined) _XJSAPI_.sniff_video()");
                return false;
            }
        }

        public VideoSniffingTrigger() {
        }

        @Override
        public void run() {
            Looper.myQueue().addIdleHandler(new IdleVideoSniffHandler());
        }
    }

    public class MediaCheckCallback implements BrowserDownloadManager.j {

        public final CountDownLatch latch;

        public MediaCheckCallback(CountDownLatch countDownLatch) {
            this.latch = countDownLatch;
        }

        @Override
        public void mo6445a(String str) {
            Log.d("check-resources", ">>>>> check media url failed" + str);
            this.latch.countDown();
        }

        @Override
        public void mo6446b(String str, String str2, String str3, long j) {
            this.latch.countDown();
            if (m7007r(str2)) {
                Log.i("check-resources", ">>>>> on found media:" + str2 + " size:" + AndroidSystemUtils.formatFileSize(j) + " url:" + str);
                if (TextUtils.isEmpty(str2) || str2.indexOf("video/mp2t") < 0) {
                    if ((str2.indexOf("video") < 0 || j <= 3145728) && ((str2.indexOf("audio") < 0 || j <= 131072) && str2.indexOf("mpegurl") < 0)) {
                        return;
                    }
                    m7014y(str);
                }
            }
        }
    }

    public class VideoTitleUpdateRunnable implements Runnable {
        public VideoTitleUpdateRunnable() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            VideoSniffingManager VideoSniffingManager = VideoSniffingManager.this;
            VideoSniffingManager.videoParser.title = ((InterfaceC1300b3) VideoSniffingManager.browserActivity.m6222J0().m9316y()).mo1574c();
            if (TextUtils.isEmpty(videoParser.path)) {
                return;
            }
            browserActivity.getActivityDelegate().m6394C().m1429l(2);
            C2518wb.m10534j(browserActivity.getBrowserFrameLayout());
            browserActivity.m6241O(5);
        }
    }

    public class VideoNotFoundToastRunnable implements Runnable {

        public final boolean showToast;

        public VideoNotFoundToastRunnable(boolean z) {
            this.showToast = z;
        }

        @Override
        public void run() {
            if (TextUtils.isEmpty(videoParser.path) && this.showToast) {
                browserActivity.m6228K2(R.string.toast_media_resource_not_found);
            }
        }
    }

    public class UIUpdateRunnable implements Runnable {
        public UIUpdateRunnable() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            C2518wb.m10534j(browserActivity.getBrowserFrameLayout());
        }
    }

    public class AddonDialog extends ConfirmDialog {
        public AddonDialog(Context context) {
            super(context);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() throws URISyntaxException {
            browserActivity.openUrl("x:addon", true, 0);
        }
    }

    public class VideoDownloadCallback implements BrowserDownloadManager.j {

        public final String url;

        public final String mimeType;

        public final String userAgent;

        public class DownloadDialogRunnable implements Runnable {

            public final String downloadUrl;

            public final String fileName;

            public final String fileExtension;

            public final long fileSize;

            public class VideoDownloadDialog extends DownloadConfirmDialog {
                public VideoDownloadDialog(BrowserActivity browserActivity) {
                    super(browserActivity);
                }

                @Override
                public void mo6441e() {
                }

                @Override
                public void mo6442f() {
                    ((ClipboardManager) browserActivity.getSystemService(Context.CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("download_link", DownloadDialogRunnable.this.downloadUrl));
                    Toast.makeText(browserActivity, R.string.toast_copy_link_to_clipboard, Toast.LENGTH_SHORT).show();
                }

                @Override
                public void mo6443g() {
                    String string = ((EditText) findViewById(R.id.file_name)).getText().toString();
                    browserActivity.getActivityDelegate().m6399H(downloadUrl, VideoDownloadCallback.this.mimeType, null, string, fileExtension, fileSize);
                }

                @Override
                public void mo6444h() {
                    AndroidSystemUtils.share(browserActivity, userAgent, downloadUrl,  null, null, null);
                }
            }

            public DownloadDialogRunnable(String str, String str2, String str3, long j) {
                this.downloadUrl = str;
                this.fileName = str2;
                this.fileExtension = str3;
                this.fileSize = j;
            }

            @Override
            public void run() {
                String strM6871P = SharedPreferencesHelper.getInstance().getString("bind_default_downloader", "");
                if (!TextUtils.isEmpty((strM6871P.equals("com.x.browser.downloader") || strM6871P.equals("com.android.providers.downloads") || C2406u0.getInstance().m9893l(strM6871P)) ? strM6871P : "")) {
                    browserActivity.getActivityDelegate().m6399H(this.downloadUrl, VideoDownloadCallback.this.mimeType, null, this.fileName, this.fileExtension, this.fileSize);
                    return;
                }
                VideoDownloadDialog dialogC2712a = new VideoDownloadDialog(browserActivity);
                String string = browserActivity.getString(R.string.dlg_download_title);
                if (AndroidSystemUtils.isWifiConnected(browserActivity)) {
                    dialogC2712a.m7812i(string, browserActivity.getString(R.string.dlg_download_text), this.fileName, AndroidSystemUtils.formatFileSize(this.fileSize));
                } else {
                    dialogC2712a.m7812i(string, browserActivity.getString(R.string.dlg_download_text_no_wifi), this.fileName, AndroidSystemUtils.formatFileSize(this.fileSize));
                }
            }
        }

        public VideoDownloadCallback(String str, String str2, String str3) {
            this.url = str;
            this.mimeType = str2;
            this.userAgent = str3;
        }

        @Override
        public void mo6445a(String str) {
        }

        @Override
        public void mo6446b(String str, String str2, String str3, long j) {
            if (!TextUtils.isEmpty(str2) && !str2.equals("application/octet-stream")) {
                videoParser.f2133e = str2;
            }
            if (str3 == null && !TextUtils.isEmpty(videoParser.f2133e)) {
                str3 = "filename=" + this.url + NetworkUtils.getExtensionFromMime(videoParser.f2133e);
            }
            browserActivity.runOnUiThread(new DownloadDialogRunnable(str, NetworkUtils.generateFileName(str, str3, videoParser.f2133e), str2, j));
        }
    }

    public static VideoSniffingManager getInstance() {
        if (instance == null) {
            instance = new VideoSniffingManager();
        }
        return instance;
    }

    public void m6989A() {
        this.videoConfigs = new JSONArray();
        this.browserActivity.updateTitle("_XJSAPI_.extract_image_res()");
        this.browserActivity.openUrl(ApiEndpointsManager.getInstance().getViewPicListUrl(), true, 0);
    }

    public void m6990B(String str) {
        if (str.startsWith("http")) {
            this.videoParser.path = str;
            if (this.browserActivity.m6246P0() == 5) {
                m7014y(str);
            }
        }
    }

    public void m6991C(String str) {
        this.browserActivity.runOnUiThread(new UIUpdateRunnable());
    }

    public synchronized void m6992D(String str) {
        this.videoParser.m3553b();
        this.sniffedVideos.clear();
        this.currentUrl = str;
        BrowserDownloadManager.getInstance().f4620a.clear();
    }

    public final boolean m6993E(String str, String str2) {
        String lastPathSegment;
        return (TextUtils.isEmpty(str) || (lastPathSegment = Uri.parse(str).getLastPathSegment()) == null || lastPathSegment.indexOf(str2) <= 0) ? false : true;
    }

    public void m6994d(String title, String src) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("title", title);
            jSONObject.put("src", src);
            this.videoConfigs.put(jSONObject);
        } catch (Exception ignored) {
        }
    }

    public synchronized void m6995e(String str) {
        if (!this.sniffedVideos.contains(str)) {
            this.sniffedVideos.add(str);
        }
    }

    public synchronized void m6996f(String str, String str2) {
        try {
            int iIndexOf = this.sniffedVideos.indexOf(str);
            if (iIndexOf >= 0) {
                String str3 = (String) this.sniffedVideos.get(iIndexOf);
                if (!TextUtils.isEmpty(str3)) {
                    String strM446a = NetworkUtils.appendQueryParam(str3, "_res_tag_=" + str2);
                    if (iIndexOf > 0) {
                        this.sniffedVideos.add(iIndexOf, strM446a);
                    }
                    this.sniffedVideos.remove(iIndexOf + 1);
                }
            } else if (!TextUtils.isEmpty(str)) {
                this.sniffedVideos.add(NetworkUtils.appendQueryParam(str, "_res_tag_=" + str2));
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m6997g(String str) {
        if (TextUtils.isEmpty(str) || m7013x(str) || m7009t(str)) {
            return;
        }
        Log.d("check-resources", ">>>>> check media resource:" + str);
        this.browserActivity.getHandler().removeCallbacks(this.videoCheckRunnable);
        this.browserActivity.getHandler().postDelayed(this.videoCheckRunnable, 500L);
        if (m7008s(str)) {
            m7014y(str);
            return;
        }
        CountDownLatch countDownLatch = new CountDownLatch(1);
        BrowserDownloadManager.getInstance().m6691g(str, this.currentUrl, new MediaCheckCallback(countDownLatch));
        try {
            countDownLatch.await();
        } catch (InterruptedException unused) {
        }
    }

    public final void m6998h(boolean z) {
        this.browserActivity.updateTitle("if(window._XJSAPI_ != undefined) _XJSAPI_.sniff_video()");
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < this.sniffedVideos.size(); i++) {
            String str = (String) this.sniffedVideos.get(i);
            if (!m7009t(str)) {
                arrayList.add(str);
            }
        }
        arrayList.sort(new Comparator() {
            @Override
            public final int compare(Object obj, Object obj2) {
                return this.f1956l.m7010u((String) obj, (String) obj2);
            }
        });
        Log.d("check-resources", ">>>>> check urls size:" + arrayList.size());
        ExecutorService executorServiceNewFixedThreadPool = Executors.newFixedThreadPool(5);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            String str2 = (String) arrayList.get(i2);
            if (m7008s(str2)) {
                m7014y(str2);
                return;
            }
        }
        while (arrayList.size() > 0) {
            final String str3 = (String) arrayList.remove(0);
            executorServiceNewFixedThreadPool.submit(new Runnable() {
                @Override
                public final void run() {
                    this.f2048l.m7011v(str3);
                }
            });
            if (!TextUtils.isEmpty(this.videoParser.path)) {
                break;
            }
        }
        this.browserActivity.m6241O(5);
        this.browserActivity.getHandler().postDelayed(new VideoNotFoundToastRunnable(z), 1000L);
        Log.d("check-resources", ">>>>> check urls finished" + this.videoParser.path);
        executorServiceNewFixedThreadPool.shutdown();
    }

    public final JSONObject m6999i(String str, String str2) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        String host = Uri.parse(str2).getHost();
        jSONObject.put("url", str2);
        jSONObject.put("id", AbstractCryptoUtils.toMd5(str2));
        jSONObject.put("host", host);
        if (!ContentDataManager.getInstance().m6628m0(str, str2, 0) && !ContentDataManager.getInstance().m6628m0(str, str2, 2)) {
            boolean zM6628m0 = ContentDataManager.getInstance().m6628m0(str, str2, 1);
            jSONObject.put("block_host", false);
            if (!zM6628m0) {
                jSONObject.put("block_url", false);
            }
            return jSONObject;
        }
        jSONObject.put("block_host", true);
        jSONObject.put("block_url", true);
        return jSONObject;
    }

    public C0712Pc m7000j() {
        return this.videoParser;
    }

    public void m7001k(boolean z) {
        this.browserActivity.m6241O(5);
        if (z) {
            Toast.makeText(this.browserActivity, R.string.toast_do_sniff_media, Toast.LENGTH_LONG).show();
        }
        if (TextUtils.isEmpty(this.videoParser.path)) {
            m6998h(z);
        } else if (!z) {
            this.browserActivity.getActivityDelegate().m6394C().m1429l(2);
        } else {
            this.browserActivity.getActivityDelegate().m6394C().m1429l(2);
            m6991C(this.videoParser.path);
        }
    }

    public void m7002l() {
        String strMo1574c = ((InterfaceC1300b3) this.browserActivity.getTabManager().m9316y()).mo1574c();
        String strM6234M0 = this.browserActivity.m6234M0();
        if (this.videoParser.path.indexOf(".m3u8") <= 0) {
            C0712Pc c0712Pc = this.videoParser;
            c0712Pc.f2133e = NetworkUtils.getMimeType(c0712Pc.path);
            String strM4215D = FileUtils.sanitizeFileName(((InterfaceC1300b3) this.browserActivity.getTabManager().m9316y()).mo1574c());
            if (this.videoParser.path.startsWith("blob:")) {
                return;
            }
            Toast.makeText(this.browserActivity, R.string.toast_getting_download_info, Toast.LENGTH_SHORT).show();
            BrowserDownloadManager.getInstance().m6691g(m7000j().path, strM6234M0, new VideoDownloadCallback(strM4215D, strM6234M0, strMo1574c));
            return;
        }
        if (C2406u0.getInstance().m9893l("idm.internet.download.manager.plus")) {
            Intent intent = new Intent("android.intent.action.VIEW");
            intent.addCategory("android.intent.category.APP_BROWSER");
            intent.setData(Uri.parse(this.videoParser.path));
            intent.putExtra("title", strMo1574c);
            intent.setClassName("idm.internet.download.manager.plus", "idm.internet.download.manager.Downloader");
            this.browserActivity.startActivity(intent);
            SharedPreferencesHelper.getInstance().putString("default_downloader", "idm.internet.download.manager.plus");
            return;
        }
        if (!C2406u0.getInstance().m9893l("idm.internet.download.manager")) {
            new AddonDialog(this.browserActivity).show(this.browserActivity.getString(R.string.dlg_title_installation_addon), this.browserActivity.getString(R.string.dlg_text_m3u8_addon_required));
            return;
        }
        Intent intent2 = new Intent("android.intent.action.VIEW");
        intent2.addCategory("android.intent.category.APP_BROWSER");
        intent2.setData(Uri.parse(this.videoParser.path));
        intent2.putExtra("title", strMo1574c);
        intent2.setClassName("idm.internet.download.manager", "idm.internet.download.manager.Downloader");
        this.browserActivity.startActivity(intent2);
        SharedPreferencesHelper.getInstance().putString("default_downloader", "idm.internet.download.manager");
    }

    public String m7003m() {
        JSONArray jSONArray = this.videoConfigs;
        return jSONArray != null ? jSONArray.toString() : "[]";
    }

    public String m7004o(String str, String str2) {
        JSONObject jSONObjectM6999i;
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < this.sniffedVideos.size(); i++) {
            try {
                String str3 = (String) this.sniffedVideos.get(i);
                if (str2.equals("all")) {
                    jSONObjectM6999i = m6999i(str, str3);
                } else {
                    if (str2.equals("img")) {
                        if (str3.indexOf("_res_tag_=img") > 0 || str3.indexOf(".jpg") > 0 || str3.indexOf(".png") > 0 || str3.indexOf(".gif") > 0 || str3.indexOf(".webp") > 0 || str3.indexOf(".ico") > 0) {
                            jSONObjectM6999i = m6999i(str, str3);
                        }
                    } else if (str2.equals("css")) {
                        if (str3.indexOf("_res_tag_=css") > 0 || str3.indexOf(".css") > 0) {
                            jSONObjectM6999i = m6999i(str, str3);
                        }
                    } else if (str2.equals("js")) {
                        if (str3.indexOf("_res_tag_=js") > 0 || str3.indexOf(".js") > 0) {
                            jSONObjectM6999i = m6999i(str, str3);
                        }
                    } else if (str2.equals("media")) {
                        if (getInstance().m7008s(str3)) {
                            jSONObjectM6999i = m6999i(str, str3);
                        }
                    } else if (str2.equals("other") && str3.indexOf("_res_tag_") < 0 && str3.indexOf(".mp4") < 0 && str3.indexOf(".png") < 0 && str3.indexOf(".jpg") < 0 && str3.indexOf(".webp") < 0 && str3.indexOf(".js") < 0 && str3.indexOf(".css") < 0 && str3.indexOf(".gif") < 0 && str3.indexOf(".ico") < 0 && str3.indexOf(".js") < 0) {
                        jSONObjectM6999i = m6999i(str, str3);
                    }
                }
                jSONArray.put(jSONObjectM6999i);
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return jSONArray.toString();
    }

    public boolean m7005p(String str) {
        if (str == null) {
            return false;
        }
        if (str.indexOf("youku.com") >= 0 || str.indexOf("iqiyi.com") >= 0 || str.indexOf("ximalaya.com") >= 0 || str.indexOf("v.qq.com") >= 0 || str.indexOf("bilibili.com") >= 0 || str.indexOf("pptv.com") >= 0 || str.indexOf(".le.com") >= 0 || str.indexOf("mgtv.com") >= 0) {
            return true;
        }
        for (int i = 0; i < this.pendingVideoChecks.size(); i++) {
            if (str.indexOf((String) this.pendingVideoChecks.get(i)) >= 0) {
                return true;
            }
        }
        return false;
    }

    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
        this.httpClient = new OkHttpClient();
        this.videoParser = new C0712Pc();
        m7012w();
    }

    public final boolean m7007r(String str) {
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return str.indexOf("video") >= 0 || str.indexOf("audio") >= 0 || str.indexOf("mpegurl") >= 0 || str.toLowerCase().indexOf("mpegurl") >= 0;
    }

    public boolean m7008s(String str) {
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || str.indexOf("hm.baidu.com") >= 0 || str.indexOf("cnzz.com") > 0 || m6993E(str, ".html")) {
            return false;
        }
        return str.indexOf("_res_tag_=video") > 0 || str.indexOf("_res_tag_=audio") > 0 || str.indexOf("_res_tag_=audio") > 0 || str.indexOf("_res_tag_=media") > 0 || m6993E(str, ".mp4") || m6993E(str, ".aac") || m6993E(str, ".mp3") || m6993E(str, ".m4a") || m6993E(str, ".flv") || m6993E(str, ".webm") || m6993E(str, ".m3u8") || m6993E(str, ".3gp") || m6993E(str, ".rmvb") || m6993E(str, ".mov");
    }

    public final boolean m7009t(String str) {
        return str.indexOf("googleads") > 0 || str.indexOf("gstatic") > 0 || str.indexOf("googlesyndication") > 0 || str.indexOf("googleapis") > 0 || str.indexOf("fonts.") > 0 || str.indexOf("doubleclick") > 0 || str.indexOf("doubleclick") > 0;
    }

    public final int m7010u(String str, String str2) {
        boolean z = false;
        boolean z2 = m7013x(str) && !m7008s(str);
        if (m7013x(str2) && !m7008s(str2)) {
            z = true;
        }
        if (z2 && z) {
            return str.compareTo(str2);
        }
        if (z2) {
            return 1;
        }
        if (z) {
            return -1;
        }
        return str.compareTo(str2);
    }

    public final void m7011v(String str) {
        if (TextUtils.isEmpty(this.videoParser.path)) {
            m6997g(str);
        }
    }

    public final void m7012w() throws JSONException {
        try {
            String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath("ad_sniffing_white_list", 1002);
            if (strM2046a != null) {
                JSONArray jSONArray = new JSONArray(strM2046a);
                for (int i = 0; i < jSONArray.length(); i++) {
                    this.pendingVideoChecks.add(jSONArray.getString(i));
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public final boolean m7013x(String str) {
        return str.indexOf("html") > 0 || str.indexOf(".html") > 0 || str.indexOf(".htm") > 0 || str.indexOf(".gif") > 0 || str.indexOf(".png") > 0 || str.indexOf("jpg") > 0 || str.indexOf(".JPEG") > 0 || str.indexOf(".js") > 0 || str.indexOf(".svg") > 0 || str.indexOf(".ico") > 0 || str.indexOf(".webp") > 0 || str.indexOf(".css") > 0 || str.indexOf(".ts") > 0 || str.indexOf(".jpg") > 0 || str.indexOf(".ttf") > 0 || str.indexOf(".woff") > 0 || str.indexOf(".json") > 0 || str.indexOf(".svg") > 0 || str.indexOf("jsonp") > 0 || str.indexOf(".ts") > 0 || str.indexOf(".m4s") > 0 || str.indexOf("click") > 0 || str.indexOf("code") > 0 || str.indexOf("log") > 0 || str.indexOf("sdk") > 0 || str.indexOf("font") > 0 || str.indexOf("icon") > 0 || str.indexOf("cnzz") > 0;
    }

    public void m7014y(String str) {
        if (str.startsWith("http")) {
            if (str.indexOf("_res_tag_") > 0) {
                str = str.replaceAll("[\\?&]_res_tag_=[a-z]{0,5}", "");
            }
            Log.i("sniff-video", "notify found new media>>>>> " + str);
            this.videoParser.path = str;
            this.browserActivity.runOnUiThread(new VideoTitleUpdateRunnable());
        }
    }

    public void m7015z(String str) {
        if (!str.startsWith("http")) {
            Toast.makeText(this.browserActivity, "invalid video url", Toast.LENGTH_SHORT).show();
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(str), "video/*");
        BrowserActivity.getActivity().startActivity(intent);
    }
}
