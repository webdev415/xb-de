package com.mmbox.xbrowser.user;

import android.graphics.Bitmap;
import android.os.Environment;
import android.util.Log;
import android.webkit.ConsoleMessage;
import android.webkit.JsPromptResult;
import android.webkit.JsResult;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceError;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;
import com.mmbox.xbrowser.Browser;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.VideoSniffingManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import p000.NetworkUtils;
import p000.FileUtils;
import p000.AndroidSystemUtils;
import p000.AbstractC2313s;
import p000.C0232F1;
import p000.ResourceCacheManager;
import p000.PhoneUtils;
import p000.C2061mf;
import p000.C2107nf;

public class BackgroundWebviewHandler extends AbstractC2313s {

    public WebView f5122e = null;

    public String f5123f = null;

    public ArrayList f5124g = new ArrayList<>(3);

    public boolean f5125h = false;

    public class RunnableC1583a implements Runnable {

        public final int f5126l;

        public final Object f5127m;

        public final String f5128n;

        public class a extends WebViewClient {

            public class RunnableC2714a implements Runnable {
                public RunnableC2714a() {
                }

                @Override
                public void run() {
                }
            }

            public class b implements Runnable {

                public final boolean f5132l;

                public b(boolean z) {
                    this.f5132l = z;
                }

                @Override
                public void run() {
                    BackgroundWebviewHandler backgroundWebviewHandler = BackgroundWebviewHandler.this;
                    if (backgroundWebviewHandler.f5123f == null && this.f5132l && !backgroundWebviewHandler.f5125h) {
                        Toast.makeText(backgroundWebviewHandler.f5122e.getContext(), R.string.toast_not_found_media, Toast.LENGTH_SHORT).show();
                    }
                }
            }

            public a() {
            }

            @Override
            public void onPageFinished(WebView webView, String str) {
                long j;
                RunnableC1583a runnableC1583a = RunnableC1583a.this;
                int i = runnableC1583a.f5126l;
                if (i == 19) {
                    BackgroundWebviewHandler.m7163i(webView);
                } else if (i == 21) {
                    boolean zBooleanValue = ((Boolean) runnableC1583a.f5127m).booleanValue();
                    BackgroundWebviewHandler backgroundWebviewHandler = BackgroundWebviewHandler.this;
                    if (backgroundWebviewHandler.f5123f == null && backgroundWebviewHandler.f5124g.size() > 0) {
                        BackgroundWebviewHandler.this.m7166g();
                    }
                    BrowserActivity.getActivity().getHandler().postDelayed(new b(zBooleanValue), 15000L);
                } else {
                    if (i == 22) {
                        C2061mf.m8471f0().m8542n0(BackgroundWebviewHandler.this.f5122e, "import_bm");
                        j = 150000;
                        BackgroundWebviewHandler backgroundWebviewHandler2 = BackgroundWebviewHandler.this;
                        backgroundWebviewHandler2.f5125h = false;
                        backgroundWebviewHandler2.m7165f(j);
                    }
                    if (i == 52) {
                        C2061mf.m8471f0().m8542n0(BackgroundWebviewHandler.this.f5122e, "xjsapi");
                        C2061mf.m8471f0().m8542n0(BackgroundWebviewHandler.this.f5122e, "preload");
                        BrowserActivity.getActivity().m6361u0("native_call_load_finished()");
                        Log.i("jslog", "=======  preload  end ==============");
                    }
                }
                j = 20000;
                BackgroundWebviewHandler backgroundWebviewHandler22 = BackgroundWebviewHandler.this;
                backgroundWebviewHandler22.f5125h = false;
                backgroundWebviewHandler22.m7165f(j);
            }

            @Override
            public void onPageStarted(WebView webView, String str, Bitmap bitmap) {
                RunnableC1583a runnableC1583a = RunnableC1583a.this;
                BackgroundWebviewHandler.this.f5125h = true;
                if (runnableC1583a.f5126l == 52) {
                    Log.i("jslog", "=======  preload  started ==============");
                }
            }

            @Override
            public void onReceivedError(WebView webView, WebResourceRequest webResourceRequest, WebResourceError webResourceError) {
                super.onReceivedError(webView, webResourceRequest, webResourceError);
                if (webResourceError.getErrorCode() == -1) {
                    BrowserActivity.getActivity().runOnUiThread(new RunnableC2714a());
                }
            }

            @Override
            public void onReceivedHttpError(WebView webView, WebResourceRequest webResourceRequest, WebResourceResponse webResourceResponse) {
                super.onReceivedHttpError(webView, webResourceRequest, webResourceResponse);
                webResourceResponse.getStatusCode();
            }

            @Override
            public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
                if (RunnableC1583a.this.f5126l != 21) {
                    return null;
                }
                Log.d("sniff-video", ">>>> try media url:" + str);
                if (!VideoSniffingManager.getInstance().m7008s(str)) {
                    return null;
                }
                BackgroundWebviewHandler.this.f5123f = str;
                VideoSniffingManager.getInstance().m6991C(str);
                return null;
            }

            @Override
            public boolean shouldOverrideUrlLoading(WebView webView, String str) {
                BackgroundWebviewHandler.this.f5122e.loadUrl(str);
                return true;
            }
        }

        public class b extends WebChromeClient {

            public class a implements C0232F1.d {

                public final String f5135a;

                public a(String str) {
                    this.f5135a = str;
                }

                @Override
                public void mo844a(String str, String str2) {
                    FileUtils.moveOrRenameFile(str, ResourceCacheManager.getInstance().m2046a(ResourceCacheManager.getInstance().m2046a(this.f5135a, 0), 1));
                }

                @Override
                public void mo845b() {
                }
            }

            public b() {
            }

            @Override
            public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
                String str = "Console: " + consoleMessage.message() + " " + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber();
                int i = C1585c.f5138a[consoleMessage.messageLevel().ordinal()];
                if (i == 1) {
                    Log.v("js-console", str);
                } else if (i == 2) {
                    Log.i("js-console", str);
                } else if (i == 3) {
                    Log.w("js-console", str);
                } else if (i == 4) {
                    Log.e("js-console", str);
                } else if (i == 5) {
                    Log.d("js-console", str);
                }
                return true;
            }

            @Override
            public boolean onJsAlert(WebView webView, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override
            public boolean onJsConfirm(WebView webView, String str, String str2, JsResult jsResult) {
                return true;
            }

            @Override
            public boolean onJsPrompt(WebView webView, String str, String str2, String str3, JsPromptResult jsPromptResult) {
                return true;
            }

            @Override
            public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
                String url = webView.getUrl();
                if (str.startsWith("http")) {
                    C0232F1.m1169l().m1170e(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath(), str, new a(url));
                }
            }
        }

        public RunnableC1583a(int i, Object obj, String str) {
            this.f5126l = i;
            this.f5127m = obj;
            this.f5128n = str;
        }

        @Override
        public void run() {
            String str;
            BackgroundWebviewHandler.this.f5122e = new WebView(BrowserActivity.getActivity());
            WebSettings settings = BackgroundWebviewHandler.this.f5122e.getSettings();
            settings.setAllowFileAccess(true);
            settings.setAllowContentAccess(true);
            SharedPreferencesHelper.getInstance().m6868N0(BackgroundWebviewHandler.this.f5122e);
            BackgroundWebviewHandler.this.f5122e.setWebViewClient(new a());
            BackgroundWebviewHandler.this.f5122e.setWebChromeClient(new b());
            int i = this.f5126l;
            if (i != 19) {
                if (i != 20) {
                    if (i == 21) {
                        BackgroundWebviewHandler.this.m7167h(this.f5128n);
                        BackgroundWebviewHandler.this.m7166g();
                        return;
                    } else {
                        if (i != 22 && i != 52) {
                            return;
                        }
                        str = this.f5128n;
                        WebView webView = BackgroundWebviewHandler.this.f5122e;
                        C2107nf c2107nf = new C2107nf(BrowserActivity.getActivity());
                        webView.addJavascriptInterface(c2107nf, "mbrowser");
                    }
                }
                BackgroundWebviewHandler.this.f5122e.loadUrl(str);
            }
            if (!AndroidSystemUtils.isWifiConnected(Browser.m6161a())) {
                return;
            }
            str = this.f5128n;
            BackgroundWebviewHandler.this.f5122e.loadUrl(str);
        }
    }

    public class RunnableC1584b implements Runnable {
        public RunnableC1584b() {
        }

        @Override
        public void run() {
            Log.i("jslog", ">>>>>> background webview destroied >>>>>>>>>>>>");
            BackgroundWebviewHandler.this.f5122e.destroy();
            BackgroundWebviewHandler backgroundWebviewHandler = BackgroundWebviewHandler.this;
            backgroundWebviewHandler.f5123f = null;
            backgroundWebviewHandler.m9455b();
        }
    }

    public static class C1585c {

        public static final int[] f5138a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f5138a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5138a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5138a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5138a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5138a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public static void m7163i(WebView webView) {
        String url = webView.getUrl();
        String title = webView.getTitle();
        if (url == null || title == null) {
            return;
        }
        if (title.length() > 80) {
            title = title.substring(0, 80);
        }
        String strM4234r = FileUtils.getNextAvailableFilePath(PhoneUtils.getInstance().getOfflinesDirPath() + "/" + NetworkUtils.sanitizeFileName(title, Math.abs(url.hashCode()) + "", ".mht"));
        AndroidSystemUtils.m8702j(PhoneUtils.getInstance().getOfflinesDirPath());
        webView.saveWebArchive(strM4234r);
    }

    @Override
    public boolean mo7164a(int i, String str, Object obj) {
        if (BrowserActivity.getActivity() == null) {
            return true;
        }
        BrowserActivity.getActivity().runOnUiThread(new RunnableC1583a(i, obj, str));
        return true;
    }

    public void m7165f(long j) {
        BrowserActivity.getActivity().getHandler().postDelayed(new RunnableC1584b(), j);
    }

    public void m7166g() {
        if (this.f5124g.size() > 0) {
            this.f5122e.loadUrl((String) this.f5124g.remove((int) (Math.random() * this.f5124g.size())));
        }
    }

    public void m7167h(String str) {
        try {
            JSONArray jSONArray = new JSONArray(str);
            for (int i = 0; i < jSONArray.length(); i++) {
                this.f5124g.add(jSONArray.getString(i));
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
