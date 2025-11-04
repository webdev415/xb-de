package com.mmbox.xbrowser;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.Cursor;
import android.database.DatabaseUtils;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.NetworkInfo;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.MessageQueue;
import android.os.Process;
import android.provider.MediaStore;
import android.text.TextUtils;
import android.text.style.URLSpan;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.PermissionRequest;
import android.webkit.ValueCallback;
import android.webkit.WebIconDatabase;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.RequiresApi;

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.xbrowser.controllers.AbsBrowserController;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.mmbox.xbrowser.provider.BrowserProvider;
import com.mmbox.xbrowser.searchbox.SuggestionInputAdapter;
import com.xbrowser.play.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;
import java.util.Map;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import p000.AbstractC0448Jo;
import p000.AbstractC2129o0;
import p000.AbstractC2320s6;
import p000.AndroidSystemUtils;
import p000.BackgroundTaskManager;
import p000.BaseViewOnClickListenerC0802Rb;
import p000.C0219Ep;
import p000.C0310Go;
import p000.C0356Ho;
import p000.C0461K0;
import p000.C0462K1;
import p000.C0600N1;
import p000.C0801Ra;
import p000.C0848Sb;
import p000.C0896Td;
import p000.C0988Vd;
import p000.C1039Wi;
import p000.C1045Wo;
import p000.C1199a3;
import p000.C1224ai;
import p000.C1344c1;
import p000.C1651dn;
import p000.C2363t3;
import p000.C2390tl;
import p000.C2406u0;
import p000.C2439uo;
import p000.C2564xb;
import p000.ConfirmDialog;
import p000.ContentViewManager;
import p000.DatabaseColumns;
import p000.DialogC0076Bk;
import p000.DialogC0143D4;
import p000.DialogC0465K4;
import p000.DialogC2544x0;
import p000.DialogC2590y0;
import p000.EluaInfoDialog;
import p000.EventQueueManager;
import p000.ExitConfirmDialog;
import p000.FileUtils;
import p000.Insets;
import p000.InterfaceC0299Gd;
import p000.InterfaceC0345Hd;
import p000.InterfaceC0575Md;
import p000.InterfaceC0625Nh;
import p000.InterfaceC1300b3;
import p000.JSManager;
import p000.MenuController;
import p000.MySQLiteOpenHelper;
import p000.NetworkUtils;
import p000.PhoneUtils;
import p000.ResourceCacheManager;
import p000.ScanOption;
import p000.SyncManager;
import p000.SystemUiCompat;
import p000.SystemUiController;
import p000.TabManager;
import p000.TextAreaDialog;
import p000.ThemeManager;
import p000.TouchEventDispatcher;
import p000.ViewOnClickListenerC0166Di;
import p000.ViewOnClickListenerC1156Z6;
import p000.WebPage;

public class BrowserActivity extends Activity implements ContentViewManager.c, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnSystemUiVisibilityChangeListener {

    public static final ExecutorService backgroundExecutor = Executors.newSingleThreadExecutor();
    private static final int REQUEST_CODE_TEXT_FILE_PICKER = 65;

    public static BrowserActivity activity = null;

    public String currentUserAgent;

    public ValueCallback<Uri[]> fileUploadCallback;

    public Uri cameraPhotoUri;

    public PermissionRequest webPermissionRequest;

    public View decorView;

    public int systemUiVisibility;

    public TouchEventDispatcher touchEventDispatcher;

    public MyGestureDetector gestureDetector;

    public final int CONSTANT_ZERO = 0;

    public final int CONSTANT_ONE = 1;

    public final int CONSTANT_ZERO_ALT = 0;

    public final int CONSTANT_3000 = 3000;

    public boolean hasShownExitDialog = false;

    public boolean isDestroyed = false;

    public boolean hasOnCreate = false;

    public boolean hasResumed = false;

    public boolean isPaused = false;

    public boolean isInEditMode = false;

    public int uiLayoutMode = 0;

    public boolean isLoadingUrl = false;

    public boolean hasWindowFocus = false;

    public final int CONSTANT_ZERO_ALT2 = 0;

    public int unusedIntField = 0;

    public String pendingSearchQuery = null;

    public Uri pendingApkUri = null;

    public BrowserActivityDelegate activityDelegate = null;

    public TabManager tabManager = null;

    public MenuController menuController = null;

    public BrowserFrameLayout browserFrameLayout = null;

    public final Handler handler = new Handler();

    public final ArrayList<String> activeControllers = new ArrayList<>(3);

    public PullToRefreshHandler pullToRefreshHandler = null;

    public String lastNavigatedUrl = "";

    public String lastPageTitle = "";

    public int[] screenDimensions = null;

    public int textFitWidth = -1;

    public int textFitHeight = -1;

    public Object lockObject = null;

    public final Runnable unusedRunnable = null;

    public long lastActionTimestamp = 0;

    public final Runnable textAutoFitRunnable = () -> updateTitle("_XJSAPI_.text_auto_fit(" + textFitWidth + "," + textFitHeight + ")");

    public class FlagResetRunnable implements Runnable {

        public final C0219Ep flagObject;

        public FlagResetRunnable(C0219Ep c0219Ep) {
            this.flagObject = c0219Ep;
        }

        @Override
        public void run() {
            this.flagObject.f555f = false;
        }
    }

    public class ShortToastRunnable implements Runnable {

        public final String message;

        public ShortToastRunnable(String str) {
            this.message = str;
        }

        @Override
        public void run() {
            Toast.makeText(BrowserActivity.this, this.message, Toast.LENGTH_SHORT).show();
        }
    }

    public class TimestampUpdateRunnable implements Runnable {

        public final String data;

        public TimestampUpdateRunnable(String str) {
            this.data = str;
        }

        @Override
        public void run() {
            m6232L2(this.data);
            lastActionTimestamp = System.currentTimeMillis();
        }
    }

    public class LongToastRunnable implements Runnable {

        public final String message;

        public LongToastRunnable(String str) {
            this.message = str;
        }

        @Override
        public void run() {
            Toast.makeText(BrowserActivity.this, this.message, Toast.LENGTH_LONG).show();
        }
    }

    public class UrlValidationRunnable implements Runnable {

        public final String url;

        public UrlValidationRunnable(String str) {
            this.url = str;
        }

        @Override
        public void run() {
            if (this.url.equals(m6234M0()) || this.url.startsWith("file:///")) {
                m6224J2(this.url);
            }
        }
    }

    public class VideoSniffingAcceptDialog extends EluaInfoDialog {

        public final boolean enableSniffing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoSniffingAcceptDialog(BrowserActivity browserActivity, String str, String str2, boolean z) {
            super(browserActivity, str, str2);
            this.enableSniffing = z;
        }

        @Override
        public String getOKLabel() {
            return "已了解";
        }

        @Override
        public void onOK() {
            SharedPreferencesHelper.getInstance().putBoolean("first-sniff-media", false);
            SharedPreferencesHelper.getInstance().putBoolean("accept-sniff-media", true);
            VideoSniffingManager.getInstance().m7001k(this.enableSniffing);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void handleUrlClick(URLSpan uRLSpan) {
            dismiss();
            openUrl(uRLSpan.getURL(), true, 0);
        }
    }

    public class InitializationRunnable implements Runnable {
        public InitializationRunnable() {
        }

        @Override
        public void run() {
            showConfirmDialog();
        }
    }

    public class QrScannerDialog extends ConfirmDialog {
        public QrScannerDialog(Context context) {
            super(context);
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() {
            ScanOption option = new ScanOption(BrowserActivity.this);
            option.setFormats("QR_CODE");
            option.lockOrientation(false);
            option.setRequestCode(32);
            option.setClass(QrScanActivity.class);
            option.start();
        }
    }

    public class UpdateCheckRunnable implements Runnable {
        public UpdateCheckRunnable() {
        }

        @Override
        public void run() {
            m6318g1();
        }
    }

    public class EmptyConfirmDialog extends BaseViewOnClickListenerC0802Rb {
        public EmptyConfirmDialog(BrowserActivity browserActivity) {
            super(browserActivity);
        }

        @Override
        public void mo3815c() {
        }
    }

    public class EulaAcceptDialog extends EluaInfoDialog {
        public EulaAcceptDialog(BrowserActivity browserActivity) {
            super(browserActivity);
        }

        @Override
        public void onOK() {
            SharedPreferencesHelper.getInstance().acceptEula = true;
            SharedPreferencesHelper.getInstance().putBoolean("accept-eula", true);
            if (PhoneUtils.getInstance().isInChina()) {
                getHandler().postDelayed(() -> {
                    SharedPreferencesHelper.getInstance().putBoolean("show_fraud_alert", false);
                    showConfirmDialog();
                }, 1000L);
            }
        }
    }

    public class GestureCallback implements MyGestureDetector.GestureCallback {
        @Override
        public void onGestureDetected(String str) {
            if (str.equals("LDR")) {
                getActivityDelegate().mo6431k();
            } else if (str.equals("RDL")) {
                m6375x2();
            } else if (str.equals("URD")) {
                getActivityDelegate().m6434s();
            }
        }
    }

    public class TouchEventHandler implements BrowserFrameLayout.InterfaceC1510m {
        @Override
        public boolean mo6389a(MotionEvent motionEvent) {
            touchEventDispatcher.m116a(motionEvent);
            if (!SharedPreferencesHelper.getInstance().supportQuickGesture) {
                return false;
            }
            gestureDetector.handleMotionEvent(motionEvent);
            return false;
        }
    }

    public class FrameLayoutCallback implements BrowserFrameLayout.InterfaceC1509l {
        @Override
        public void mo6390a(int i) {
            if (i == 1) {
                m6360u();
            } else if (i == 0) {
                refreshQuickAccessUI();
            } else if (i == 2) {
                m6268U2();
            }
        }
    }

    public class SearchBarPositionRunnable implements Runnable {

        private final String position;

        public SearchBarPositionRunnable(String key) {
            this.position = key;
        }

        @Override // java.lang.Runnable
        public void run() {
            // Retrieve the current settings from SharedPreferences
            int currentSettings = SharedPreferencesHelper.getInstance().getDefaultLayoutType();

            // Handle the search-bar-at-top setting
            if ("search-bar-at-top".equals(position)) {
                if ((currentSettings & 8192) == 8192) {
                    // If search bar should be at the top, update the UI with a specific ID
                    m6253R(12289);
                } else {
                    // Otherwise, update with a different ID
                    m6253R(4097);
                }
            }

            // Handle the search-bar-at-bottom setting
            else if ("search-bar-at-bottom".equals(position)) {
                if ((currentSettings & 8192) == 8192) {
                    // If search bar should be at the bottom, set flag and update the UI
                    m6253R(12290);
                    SharedPreferencesHelper.getInstance().browserFullscreenMode = true;
                } else {
                    // Otherwise, update with a different ID
                    m6253R(4098);
                }
            }

            // Check for additional preferences and handle accordingly
            if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                    C0848Sb.getInstance().restorePosition(); // Perform some action if condition is true
                } else {
                    C0848Sb.getInstance().hideFloatingButton(); // Perform a different action if false
                }
            }

            // Call methods to update the browser state and UI
            m6189B();
            m6320g3();
            getActivityDelegate().mo6428g0();
            ThemeManager.getInstance().m9478F(BrowserActivity.getActivity());
        }
    }

    public class SearchBarLaunchRunnable implements Runnable {
        public SearchBarLaunchRunnable() {
        }

        @Override
        public void run() {
            Intent intent = new Intent(BrowserActivity.this, (Class<?>) SearchBarActivity.class);
            intent.putExtra("key-or-url", getBrowserController().getUrlFromTitle());
            startActivityForResult(intent, 83);
            overridePendingTransition(0, 0);
        }
    }

    public class UrlProcessRunnable implements Runnable {

        public final String url;

        public UrlProcessRunnable(String str) {
            this.url = str;
        }

        @Override
        public void run() {
            m6199D1(this.url);
        }
    }

    public class PageInfoUpdateRunnable implements Runnable {

        public final String url;

        public final String title;

        public PageInfoUpdateRunnable(String str, String str2) {
            this.url = str;
            this.title = str2;
        }

        @Override
        public void run() {
            logHistory(this.url, this.title);
        }
    }

    public class PageTitleUpdateRunnable implements Runnable {

        public final String title;

        public PageTitleUpdateRunnable(String str) {
            this.title = str;
        }

        @Override
        public void run() {
            m6353r1(this.title);
        }
    }

    public class WebViewScriptRunnable implements Runnable {

        public final String script;

        public WebViewScriptRunnable(String str) {
            this.script = str;
        }

        @Override
        public void run() {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) tabManager.m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                JSManager.getInstance().injectJavascript(((WebViewBrowserController) interfaceC1300b3).m6770F0(), this.script);
            }
        }
    }

    public class WebViewEvaluateRunnable implements Runnable {

        public final String script;

        public WebViewEvaluateRunnable(String str) {
            this.script = str;
        }

        @Override
        public void run() {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) tabManager.m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                JSManager.getInstance().m8552s0(((WebViewBrowserController) interfaceC1300b3).m6770F0(), this.script);
            }
        }
    }

    public class FlagClearRunnable implements Runnable {
        public FlagClearRunnable() {
        }

        @Override
        public void run() {
            hasShownExitDialog = false;
        }
    }

    public class WebViewSettingsApplyRunnable implements Runnable {

        public final WebView webView;

        public WebViewSettingsApplyRunnable(WebView webView) {
            this.webView = webView;
        }

        @Override
        public void run() {
            SharedPreferencesHelper.getInstance().m6868N0(this.webView);
        }
    }

    public class FaviconDownloadCallback implements C0988Vd.b {

        public final String url;

        public final String title;

        public class FaviconSuccessRunnable implements Runnable {

            public final byte[] imageData;

            public FaviconSuccessRunnable(byte[] bArr) {
                this.imageData = bArr;
            }

            @Override
            public void run() throws Resources.NotFoundException {
                byte[] bArr = this.imageData;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                if (bitmapDecodeByteArray == null) {
                    C0988Vd c0988VdM4391d = C0988Vd.getInstance();
                    FaviconDownloadCallback c1482w = FaviconDownloadCallback.this;
                    bitmapDecodeByteArray = c0988VdM4391d.m4394c(c1482w.url, c1482w.title);
                }
                FaviconDownloadCallback c1482w2 = FaviconDownloadCallback.this;
                AndroidSystemUtils.m8706n(BrowserActivity.this, c1482w2.url, c1482w2.title, bitmapDecodeByteArray);
            }
        }

        public class FaviconErrorRunnable implements Runnable {
            public FaviconErrorRunnable() {
            }

            @Override
            public void run() throws Resources.NotFoundException {
                C0988Vd c0988VdM4391d = C0988Vd.getInstance();
                FaviconDownloadCallback c1482w = FaviconDownloadCallback.this;
                Bitmap bitmapM4394c = c0988VdM4391d.m4394c(c1482w.url, c1482w.title);
                FaviconDownloadCallback c1482w2 = FaviconDownloadCallback.this;
                AndroidSystemUtils.m8706n(BrowserActivity.this, c1482w2.url, c1482w2.title, bitmapM4394c);
            }
        }

        public FaviconDownloadCallback(String str, String str2) {
            this.url = str;
            this.title = str2;
        }

        @Override
        public void mo4400a(byte[] bArr) {
            runOnUiThread(new FaviconSuccessRunnable(bArr));
        }

        @Override
        public void mo4401b() {
            runOnUiThread(new FaviconErrorRunnable());
        }
    }

    public class AlternateFaviconCallback implements C0988Vd.b {

        public final String url;

        public final String title;

        public class FaviconDataRunnable implements Runnable {

            public final byte[] imageData;

            public FaviconDataRunnable(byte[] bArr) {
                this.imageData = bArr;
            }

            @Override
            public void run() {
                byte[] bArr = this.imageData;
                Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(bArr, 0, bArr.length);
                AlternateFaviconCallback c1483x = AlternateFaviconCallback.this;
                AndroidSystemUtils.m8706n(BrowserActivity.this, c1483x.url, c1483x.title, bitmapDecodeByteArray);
            }
        }

        public class FaviconFallbackRunnable implements Runnable {
            public FaviconFallbackRunnable() {
            }

            @Override
            public void run() throws Resources.NotFoundException {
                C0988Vd c0988VdM4391d = C0988Vd.getInstance();
                AlternateFaviconCallback c1483x = AlternateFaviconCallback.this;
                Bitmap bitmapM4394c = c0988VdM4391d.m4394c(c1483x.url, c1483x.title);
                AlternateFaviconCallback c1483x2 = AlternateFaviconCallback.this;
                AndroidSystemUtils.m8706n(BrowserActivity.this, c1483x2.url, c1483x2.title, bitmapM4394c);
            }
        }

        public AlternateFaviconCallback(String str, String str2) {
            this.url = str;
            this.title = str2;
        }

        @Override
        public void mo4400a(byte[] bArr) {
            runOnUiThread(new FaviconDataRunnable(bArr));
        }

        @Override
        public void mo4401b() {
            runOnUiThread(new FaviconFallbackRunnable());
        }
    }

    public class BookmarkDeleteConfirmDialog extends ConfirmDialog {

        public final SQLiteDatabase database;

        public final String bookmarkId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookmarkDeleteConfirmDialog(Context context, SQLiteDatabase sQLiteDatabase, String str) {
            super(context);
            this.database = sQLiteDatabase;
            this.bookmarkId = str;
        }

        @Override
        public void onCancel() {
        }

        @Override
        public void onOK() {
            MySQLiteOpenHelper.getInstance().deleteBookmarkRecursive(this.database, this.bookmarkId);
            m6223J1(AndroidSystemUtils.prefixWithMd5(this.bookmarkId));
        }
    }

    public static BrowserActivity getActivity() {
        return activity;
    }

    public void m6185A() {
        new DialogC2544x0(this).show();
    }

    public final void m6186A0(int i) {
        if (i == 32) {
            if (SharedPreferencesHelper.getInstance().enterNightMode) {
                return;
            }
            m6352r0(true, false);
        } else if (i == 16 && SharedPreferencesHelper.getInstance().enterNightMode) {
            m6352r0(false, false);
        }
    }

    public void evaluateJS(String moduleName) {
        runOnUiThread(new WebViewEvaluateRunnable(moduleName));
    }

    public void m6188A2(String str, String str2) {
        String strM2049e = ResourceCacheManager.getInstance().getResourceValueByKey(Uri.parse(str2).getHost() + ".touch-icon");
        if (TextUtils.isEmpty(strM2049e)) {
            AndroidSystemUtils.m8706n(this, str, str2, C0988Vd.getInstance().m4394c(str, str2));
        } else {
            C0988Vd.getInstance().m4392a(strM2049e, str2, new FaviconDownloadCallback(str, str2));
        }
    }

    public final void m6189B() {
        if (Build.VERSION.SDK_INT >= 35) {
            m6212G2();
        }
    }

    public void m6190B0(String str) {
        Intent intent;
        try {
            Uri uri = Uri.parse(str);
            uri.getHost();
            if (str.startsWith("app://")) {
                intent = new Intent("android.intent.action.VIEW");
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                intent.setData(uri);
            } else {
                if (str.startsWith("local://")) {
                    m6194C0(str);
                    return;
                }
                if (str.startsWith("market://")) {
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    String strM8684R = AndroidSystemUtils.chooseAppStorePackage(this, PhoneUtils.getInstance().getChannelCode());
                    if (strM8684R != null) {
                        intent.setPackage(strM8684R);
                    }
                } else {
                    if (str.startsWith("intent://")) {
                        try {
                            Intent uri2 = Intent.parseUri(str, Intent.URI_INTENT_SCHEME);
                            uri2.addCategory("android.intent.category.BROWSABLE");
                            uri2.setComponent(null);
                            startActivity(uri2);
                            return;
                        } catch (Exception unused) {
                            return;
                        }
                    }
                    intent = new Intent("android.intent.action.VIEW");
                    intent.setData(uri);
                    intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                }
            }
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m6191B1(String str, String str2) {
        backgroundExecutor.execute(new PageInfoUpdateRunnable(str, str2));
    }

    public void m6192B2(String str) {
        Bitmap bitmapM8708p;
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("quick_access", DatabaseColumns.QUICK_ACCESS, "guid= ?", new String[]{str}, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return;
            }
            @SuppressLint("Range") String string = cursorQuery.getString(cursorQuery.getColumnIndex("icon_uri"));
            @SuppressLint("Range") String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
            @SuppressLint("Range") String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
            if (TextUtils.isEmpty(string)) {
                bitmapM8708p = C0988Vd.getInstance().m4394c(string2, string3);
            } else if (string.startsWith("http")) {
                C0988Vd.getInstance().m4392a(string, string3, new AlternateFaviconCallback(string2, string3));
                return;
            } else if (!string.startsWith("data:")) {
                return;
            } else {
                bitmapM8708p = AndroidSystemUtils.m8708p(string);
            }
            AndroidSystemUtils.m8706n(this, string2, string3, bitmapM8708p);
        } catch (Exception unused) {
        }
    }

    public void m6193C(boolean z) {
        Resources resources = getResources();
        Configuration configuration = resources.getConfiguration();
        int i = configuration.uiMode & (-49);
        configuration.uiMode = i;
        configuration.uiMode = (z ? 32 : 16) | i;
        resources.updateConfiguration(configuration, getResources().getDisplayMetrics());
        SharedPreferencesHelper.getInstance().recoveryTabType = 0;
        if (Build.VERSION.SDK_INT < 33 || getApplicationContext().getApplicationInfo().targetSdkVersion < 33) {
            return;
        }
        recreate();
    }

    public void m6194C0(String str) {
        Uri uri = Uri.parse(str);
        String host = uri.getHost();
        String path = uri.getPath();
        if (host.equals("dlg.qa") && !TextUtils.isEmpty(path) && path.equals("/new")) {
            new ViewOnClickListenerC1156Z6(this).show();
        }
    }

    public void m6195C1() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if (interfaceC1300b3 != null) {
            C1344c1.getInstance().m5699i("Mark AD", "mark_ad", interfaceC1300b3.getUrlFromTitle());
        }
    }

    public void m6196C2(int i) {
        this.unusedIntField = i;
        if (i == 0) {
            C2564xb.getInstance().m10654a();
        }
    }

    public final void m6197D(C1045Wo c1045Wo) {
        float f;
        float f2;
        View viewFindViewById = findViewById(R.id.top_content);
        View viewFindViewById2 = findViewById(R.id.main_content);
        View viewFindViewById3 = findViewById(R.id.bottom_content);
        if (viewFindViewById == null || viewFindViewById2 == null || viewFindViewById3 == null) {
            return;
        }
        Insets insetsM4549F = c1045Wo.m4549f(C1045Wo.m.getType());
        Insets insetsM4549F2 = c1045Wo.m4549f(C1045Wo.m.m4601e());
        Insets insetsM4549F3 = c1045Wo.m4549f(C1045Wo.m.m4602f());
        Insets insetsM4549F4 = c1045Wo.m4549f(C1045Wo.m.m4597a());
        int iMax = Math.max(insetsM4549F3.f7066b, insetsM4549F4.f7066b);
        int iMax2 = Math.max(insetsM4549F2.f7068d, insetsM4549F4.f7068d);
        int iMax3 = Math.max(insetsM4549F.f7065a, insetsM4549F4.f7065a);
        int iMax4 = Math.max(insetsM4549F.f7067c, insetsM4549F4.f7067c);
        if (AndroidSystemUtils.m8674H(c1045Wo, this)) {
            f = iMax2;
            f2 = 0.8f;
        } else {
            f = iMax2;
            f2 = 1.0f;
        }
        int iM5579C = (int) (f * f2);
        if (iM5579C == 0) {
            iM5579C = PhoneUtils.getInstance().getNavigationBarHeight();
        }
        if (this.uiLayoutMode == 1) {
            viewFindViewById2.setPadding(iMax3, iMax, iMax4, 0);
            viewFindViewById.setPadding(0, 0, 0, 0);
            viewFindViewById3.setPadding(0, 0, 0, iM5579C);
        } else {
            if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                viewFindViewById.setPadding(0, 0, 0, 0);
                viewFindViewById2.setPadding(0, 0, 0, 0);
                viewFindViewById3.setPadding(0, 0, 0, 0);
                return;
            }
            if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097) {
                viewFindViewById.setPadding(iMax3, iMax, iMax4, 0);
                viewFindViewById2.setPadding(0, 0, 0, 0);
            } else {
                if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) != 4098) {
                    return;
                }
                viewFindViewById.setPadding(0, 0, 0, 0);
                viewFindViewById2.setPadding(iMax3, iMax, iMax4, 0);
            }
            viewFindViewById3.setPadding(0, 0, 0, iM5579C);
        }
    }

    public final void showConfirmDialog() {
        new EmptyConfirmDialog(this).show();
    }

    public final void m6199D1(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        String strTrim = str.trim();
        if (strTrim.length() == 0) {
            return;
        }
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        long jCurrentTimeMillis = System.currentTimeMillis();
        writableDatabase.beginTransaction();
        try {
            try {
                writableDatabase.execSQL("UPDATE search_his SET search_times = search_times + 1, last_search = ?  WHERE key_words = ?", new Object[]{Long.valueOf(jCurrentTimeMillis), strTrim});
                if (DatabaseUtils.longForQuery(writableDatabase, "SELECT changes()", null) == 0) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("key_words", strTrim);
                    contentValues.put("last_search", Long.valueOf(jCurrentTimeMillis));
                    contentValues.put("search_times", (Integer) 1);
                    writableDatabase.insert("search_his", null, contentValues);
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Throwable th) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused) {
                }
                throw th;
            }
        } catch (Exception e) {
            Log.w("xbrowser", "logSearchHistory failed", e);
        }
        try {
            writableDatabase.endTransaction();
        } catch (Exception unused2) {
        }
    }

    public void m6200D2(String str) {
        this.pendingSearchQuery = str;
    }

    public final boolean m6201E(C1045Wo c1045Wo) {
        int i;
        Insets insetsM4549F = c1045Wo.m4549f(C1045Wo.m.getType());
        Insets insetsM4549F2 = c1045Wo.m4549f(C1045Wo.m.m4601e());
        Insets insetsM4549F3 = c1045Wo.m4549f(C1045Wo.m.m4602f());
        int i2 = getResources().getDisplayMetrics().heightPixels / 4;
        int i3 = insetsM4549F3.f7066b;
        return i3 >= 0 && i3 <= i2 && (i = insetsM4549F2.f7068d) >= 0 && i <= i2 && insetsM4549F.f7065a >= 0 && insetsM4549F.f7067c >= 0;
    }

    public void m6202E0(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) GenQrCodeActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("text", str2);
        startActivity(intent);
    }

    public void m6203E1() {
        AbsBrowserController absBrowserControllerM6210G0 = getBrowserController();
        if (absBrowserControllerM6210G0 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) absBrowserControllerM6210G0).m6798h1(absBrowserControllerM6210G0.getUrlFromTitle());
        }
    }

    public void m6204E2(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if (interfaceC1300b3 != null && interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6804n1(i);
        }
    }

    public void m6205F() {
        if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
            m6322h1();
            if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                C0848Sb.getInstance().restorePosition();
            }
        } else {
            m6264T2();
        }
        getBrowserFrameLayout().setLayoutType(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
        if (SharedPreferencesHelper.getInstance().m6880U().equals("auto")) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED);
        } else if (SharedPreferencesHelper.getInstance().m6880U().equals("portrait")) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public String getActionText(String str) {
        // Map to associate strings with resource IDs
        Map<String, Integer> actionMap = new HashMap<>();
        actionMap.put("go_to_top", R.string.web_str_action_goto_top);
        actionMap.put("go_to_bottom", R.string.web_str_action_goto_bottom);
        actionMap.put("search", R.string.web_str_action_do_search);
        actionMap.put("refresh", R.string.web_str_action_do_refresh);
        actionMap.put("new_tab", R.string.web_str_action_new_tab);
        actionMap.put("remove_tabs", R.string.web_str_action_remove_tabs);
        actionMap.put("close_tab", R.string.web_str_action_close_current_tab);
        actionMap.put("revert_tab", R.string.web_str_action_revert_closed_tab);
        actionMap.put("next_tab", R.string.web_str_action_next_tab);
        actionMap.put("previous_tab", R.string.web_str_action_previous_tab);
        actionMap.put("go_to_home", R.string.web_str_action_go_to_home);
        actionMap.put("add_to_bm", R.string.web_str_action_add_to_bm);
        actionMap.put("copy_url", R.string.web_str_action_copy_url);
        actionMap.put("open_toolbox", R.string.web_str_action_open_toolbox);
        actionMap.put("toggle_fullscreen", R.string.web_str_action_toggle_fullscreen);
        actionMap.put("open_bookmark", R.string.web_str_action_open_bm);
        actionMap.put("open_history", R.string.web_str_action_open_his);
        actionMap.put("switch_search_engine", R.string.web_str_action_switch_search);

        // Return the string associated with the input, or a default message if not found
        if (actionMap.containsKey(str)) {
            return getString(actionMap.get(str));
        }

        // Default case if the action isn't recognized
        return getString(R.string.web_str_action_do_nothing);
    }

    public final void m6207F1() {
        Intent intent = new Intent(this, (Class<?>) BackgroundPlayService.class);
        intent.putExtra("title", getBrowserController().mo1574c());
        intent.setAction("action.make_page_background");
        startService(intent);
        this.hasOnCreate = true;
    }

    public final void m6208F2() {
        menuController = new MenuController();
        menuController.m7295c(WebViewBrowserController.class.getName(), "^(https?|view-source|content):.*");
        menuController.m7295c(WebViewBrowserController.class.getName(), "^file:///.*");
        menuController.m7295c(WebViewBrowserController.class.getName(), "^data:.*");
        menuController.m7295c(WebViewBrowserController.class.getName(), "^about:.*");
        menuController.m7295c(WebViewBrowserController.class.getName(), "^x:.*");
        menuController.m7295c(WebViewBrowserController.class.getName(), "http");
    }

    public void loadBookmarks(String parent) {
        SQLiteDatabase db = null;
        Cursor cursor = null;
        ArrayList<WebPage> bookmarkList = new ArrayList<>();
        int bookmarkCount = 0;

        try {
            db = MySQLiteOpenHelper.getInstance().getReadableDatabase();
            String[] selectionArgs = {parent, "0"};

            // Query for bookmarks with the given parent and status >= 0, ordered by item_order ASC
            cursor = db.query("bookmark", DatabaseColumns.BOOKMARK,
                    "parent= ? AND status>= ?",
                    selectionArgs, null, null, "item_order ASC");

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    @SuppressLint("Range") String url = cursor.getString(cursor.getColumnIndex("url"));
                    @SuppressLint("Range") String title = cursor.getString(cursor.getColumnIndex("title"));

                    // Process the URL if it contains "_tab-id_"
                    int tabIndex = url.indexOf("_tab-id_");
                    if (tabIndex > 0) {
                        url = url.substring(0, tabIndex - 1); // Trim the URL before the "_tab-id_"
                    }

                    bookmarkList.add(new WebPage(title, url));
                    bookmarkCount++;
                } while (cursor.moveToNext());
            }

            // Pass the list of bookmarks to the next method
            getTabManager().m9296T(bookmarkList);

            // Show a toast with the number of bookmarks (tabs) found
            Toast.makeText(this, String.format(getString(R.string.toast_open_tab_count), bookmarkCount), Toast.LENGTH_SHORT).show();
            getActivityDelegate().mo6428g0();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Ensure cursor and database are closed properly to avoid memory leaks
            if (cursor != null) {
                cursor.close();
            }
            if (db != null) {
                db.close();
            }
        }
    }

    public AbsBrowserController getBrowserController() {
        return (AbsBrowserController) getTabManager().m9316y();
    }

    public final void setNormalExit(boolean enabled) {
        SharedPreferencesHelper.getInstance().normalExit = enabled;
        SharedPreferencesHelper.getInstance().putBoolean("normal_exit", enabled);
    }

    public final void m6212G2() {
        try {
            SystemUiCompat.setDecorFitsSystemWindows(getWindow(), false);
            View layoutContent = findViewById(android.R.id.content);
            if (layoutContent != null) {
                AbstractC0448Jo.m2095x(layoutContent, new InterfaceC0625Nh() {
                    @Override
                    public final C1045Wo mo3322a(View view, C1045Wo c1045Wo) {
                        return m6370w1(view, c1045Wo);
                    }
                });
            }
            updateSystemUI();
        } catch (Exception unused) {
            updateContentLayoutPadding();
        }
    }

    @SuppressLint("Range")
    public void m6213H(String str) {
        SQLiteDatabase readableDatabase = MySQLiteOpenHelper.getInstance().getReadableDatabase();
        String[] strArr = {str, "0"};
        ArrayList<WebPage> pages = new ArrayList<>();
        try {
            Cursor cursorQuery = readableDatabase.query("quick_access", DatabaseColumns.QUICK_ACCESS, "parent= ? AND status>= ?", strArr, null, null, "item_order ASC");
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    pages.add(new WebPage(cursorQuery.getString(cursorQuery.getColumnIndex("title")), cursorQuery.getString(cursorQuery.getColumnIndex("url"))));
                } while (cursorQuery.moveToNext());
            }
        } catch (Exception unused) {
        }
        getTabManager().m9296T(pages);
        Toast.makeText(this, String.format(getString(R.string.toast_open_tab_count), pages.size()), Toast.LENGTH_SHORT).show();
        getActivityDelegate().mo6428g0();
    }

    public String createBlobRequestUrl(String blobUrl, String contentType) {
        if (!blobUrl.startsWith("blob")) {
            return "javascript: console.log('It is not a Blob URL');";
        }

        return buildBlobRequestScript(blobUrl, contentType);
    }

    private String buildBlobRequestScript(String blobUrl, String contentType) {
        return "var xhr = new XMLHttpRequest();" +
                "xhr.open('GET', '" + blobUrl + "', true);" +
                "xhr.setRequestHeader('Content-type', '" + contentType + "');" +
                "xhr.responseType = 'blob';" +
                "xhr.onload = function(e) { " +
                "if (this.status == 200) { " +
                "var blobPdf = this.response;" +
                "var reader = new FileReader();" +
                "reader.readAsDataURL(blobPdf);" +
                "reader.onloadend = function() { " +
                "base64data = reader.result;" +
                "mbrowser.getBase64FromBlobData(base64data, '" + contentType + "');" +
                "};" +
                "}" +
                "};" +
                "xhr.send();";
    }

    public void m6215H1(int i, String url, String path) {
        C1199a3 c1199a3M5090f;
        String str3;
        String str4;
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getWritableDatabase().query("bookmark", DatabaseColumns.BOOKMARK, "url= ?", new String[]{url}, null, null, null);
        String id = AndroidSystemUtils.prefixWithMd5(url);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                    if (cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("parent")).equals(path)) {
                        c1199a3M5090f = C1199a3.getInstance();
                        str3 = "cut_bookmark_item";
                    } else {
                        int type = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type"));
                        String title = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("title"));
                        if (url.startsWith("/")) {
                            if (path.endsWith("/")) {
                                str4 = path + title;
                            } else {
                                str4 = path + "/" + title;
                            }
                            updateBookmark(url, str4, title, path);
                        } else {
                            updateBookmark(url, url, title, path);
                        }
                        if (i == 0) {
                            JSONObject bookmarkItem = new JSONObject();
                            bookmarkItem.put("transId", "paste_bookmark_item");

                            JSONObject jsonItem = new JSONObject();
                            jsonItem.put("id", id);
                            jsonItem.put("title", title);
                            jsonItem.put("url", url);
                            jsonItem.put("type", type);
                            jsonItem.put("path", path);
                            jsonItem.put("icon_uri", C0896Td.m4137c().getIconUri(url));

                            bookmarkItem.put("item", jsonItem);
                            C1199a3.getInstance().m5094e("event_app_to_page", bookmarkItem);
                            return;
                        } else {
                            c1199a3M5090f = C1199a3.getInstance();
                            str3 = "paste_to_this_folder";
                        }
                    }
                    c1199a3M5090f.m5098j(str3, "id", id);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void updateContentLayoutPadding() {
        View layoutTopContent = findViewById(R.id.top_content);
        View layoutMainContent = findViewById(R.id.main_content);
        View layoutBottomContent = findViewById(R.id.bottom_content);
        if (layoutTopContent == null || layoutMainContent == null || layoutBottomContent == null) {
            return;
        }
        int statusBarHeight = PhoneUtils.getInstance().getStatusBarHeight();
        PhoneUtils.getInstance().getNavigationBarHeight();
        if (this.uiLayoutMode == 1) {
            layoutMainContent.setPadding(0, statusBarHeight, 0, 0);
            return;
        }
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097) {
            if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                layoutTopContent.setPadding(0, 0, 0, 0);
            } else {
                layoutTopContent.setPadding(0, statusBarHeight, 0, 0);
            }
        } else if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) == 4098) {
            if (!SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                layoutMainContent.setPadding(0, statusBarHeight, 0, 0);
                return;
            }
        } else {
            return;
        }
        layoutMainContent.setPadding(0, 0, 0, 0);
    }

    public BrowserActivityDelegate getActivityDelegate() {
        return this.activityDelegate;
    }

    public void m6219I1(NetworkInfo.State state) {
        if (state == NetworkInfo.State.CONNECTED) {
            getHandler().postDelayed(() -> {
                m6257S(SharedPreferencesHelper.getInstance().getInt("save_traffic_strategy", 0));
                BrowserDownloadManager.getInstance().m6692h();
            }, 200L);
            int iM9280D = getTabManager().getTabCount();
            for (int i = 0; i < iM9280D; i++) {
                ArrayList arrayListM9279C = getTabManager().m9279C(i);
                for (int i2 = 0; i2 < arrayListM9279C.size(); i2++) {
                    InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) arrayListM9279C.get(i2);
                    if (interfaceC1300b3 != null && (interfaceC1300b3 instanceof WebViewBrowserController)) {
                        ((WebViewBrowserController) interfaceC1300b3).m6770F0().setNetworkAvailable(true);
                    }
                }
            }
        } else if (state == NetworkInfo.State.DISCONNECTED) {
            BrowserDownloadManager.getInstance().m6707x();
        }
    }

    public void m6220I2() {
        String subject = getTabManager().m9316y().mo1574c();
        String body = getTabManager().m9316y().getUrlFromTitle();
        if (body == null || body.startsWith("x:")) {
            new TextAreaDialog(this).show();
        } else {
            AndroidSystemUtils.share(this, subject, body, getResources().getString(R.string.choose_app));
        }
    }

    public boolean isPreviousTabValid() {
        return this.tabManager.hasValidPreviousTab() && this.uiLayoutMode == 0;
    }

    public boolean isNextTabValid() {
        return this.tabManager.hasValidNextTab() && this.uiLayoutMode == 0;
    }

    public TabManager getTabManager() {
        return this.tabManager;
    }

    public final void m6223J1(String str) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", "delete_bookmark_item");
            jSONObject.put("id", str);
        } catch (Exception unused) {
        }
        C1199a3.getInstance().m5094e("event_app_to_page", jSONObject);
    }

    public final void m6224J2(String str) {
        getActivityDelegate().m6394C().m1440w(str);
    }

    public void m6225K() {
        m6373x0();
    }

    public int m6226K0() {
        return this.unusedIntField;
    }

    public void m6227K1(String downloadPath) {
        MessageBoxManager.getInstance().showMessageWithDescription(getActivity().getBrowserFrameLayout(), getActivity().getString(R.string.message_download_finished), getActivity().getString(R.string.btn_text_open), new MessageBoxBase.MessageBoxListener() {
            @Override
            public void onShown() {
                BrowserDownloadManager.getInstance().m6709z(downloadPath);
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }, false);
    }

    public void m6228K2(int i) {
        m6232L2(getString(i));
    }

    public final void m6229L() {
        stopService(new Intent(this, (Class<?>) BackgroundPlayService.class));
    }

    public int m6230L0() {
        return getBrowserController().mo5626h();
    }

    public void applyDarkMode() {
        getHandler().postDelayed(new Runnable() {
            @Override
            public void run() throws Resources.NotFoundException {
                if (SharedPreferencesHelper.getInstance().getBoolean("notify_flow_system_dark_mode", true)) {
                    MessageBoxManager.getInstance().showMessage(
                            BrowserActivity.getActivity().getBrowserFrameLayout(),
                            null,
                            getResources().getString(R.string.message_follow_dark_mode),
                            getResources().getString(R.string.btn_text_apply),
                            getResources().getString(R.string.btn_text_cancel),
                            new MessageBoxBase.MessageBoxListener() {
                                @Override
                                public void onShown() {
                                }

                                @Override
                                public void onDismissed() {
                                    SharedPreferencesHelper.getInstance().followSystemDarkMode = false;
                                    SharedPreferencesHelper.getInstance().enterNightMode = false;
                                    m6352r0(false, true);
                                    SharedPreferencesHelper.getInstance().putBoolean("follow-sys-dark-mode", false);
                                }

                                @Override
                                public void onDismiss() {
                                    SharedPreferencesHelper.getInstance().putBoolean("notify_flow_system_dark_mode", false);
                                }
                            },
                            true);
                }
            }
        }, 200L);
    }

    public void m6232L2(String str) {
        runOnUiThread(new LongToastRunnable(str));
    }

    public void m6233M() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo1581q();
        }
    }

    public String m6234M0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if (interfaceC1300b3 != null) {
            return interfaceC1300b3.getUrlFromTitle();
        }
        return null;
    }

    public void recoverBookmark(String bookmarkId) {
        MessageBoxManager.getInstance().showMessageWithDescription(getActivity().getBrowserFrameLayout(),
                getActivity().getString(R.string.toast_found_bookmark_recovery_file),
                getActivity().getString(R.string.btn_text_restore),
                new MessageBoxBase.MessageBoxListener() {
                    @Override
                    public void onShown() {
                        EventQueueManager.getInstance().processEvent(System.currentTimeMillis(), 22, bookmarkId, null);
                        SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
                    }

                    @Override
                    public void onDismissed() {
                    }

                    @Override
                    public void onDismiss() {
                    }
                },
                false);
    }

    public void m6236M2(int i, long j) {
        m6240N2(getString(i), j);
    }

    public void m6237N(String mediaUrl) {
        Intent intent = new Intent(this, CasterActivity.class);
        intent.putExtra("media_url", mediaUrl);
        startActivity(intent);
    }

    public String getLongPressDescription(String action) {
        int resourceId = -1;
        switch (action) {
            case "long_press_back_btn":
                resourceId = R.string.web_str_gs_long_press_back;
                break;
            case "long_press_forward_btn":
                resourceId = R.string.web_str_gs_long_press_forward;
                break;
            case "long_press_home":
                resourceId = R.string.web_str_gs_long_press_home;
                break;
            case "long_press_multi_tab":
                resourceId = R.string.web_str_gs_long_press_tabs;
                break;
            case "long_press_menu":
                resourceId = R.string.web_str_gs_long_press_menu;
                break;
        }
        return resourceId != -1 ? getString(resourceId) : "";
    }

    public void m6239N1() {
        MessageBoxManager.getInstance().showMessageWithDescription(
                getActivity().getBrowserFrameLayout(),
                getActivity().getString(R.string.toast_found_offline_file),
                getActivity().getString(R.string.btn_text_view),
                new MessageBoxBase.MessageBoxListener() {
                    @Override
                    public void onShown() {
                        openUrl("x:sd?path=offlines&sort=date", true, 0);
                    }

                    @Override
                    public void onDismissed() {
                    }

                    @Override
                    public void onDismiss() {
                    }
                },
                false);
    }

    public void m6240N2(String str, long j) {
        if (this.lastActionTimestamp == 0 || System.currentTimeMillis() - this.lastActionTimestamp > j) {
            runOnUiThread(new TimestampUpdateRunnable(str));
        }
    }

    public void m6241O(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6812w0(i);
        }
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void recoverUserData(String path) {
        MessageBoxManager.getInstance().showMessageWithDescription(
                getActivity().getBrowserFrameLayout(),
                getActivity().getString(R.string.toast_found_user_recovery_file),
                getActivity().getString(R.string.btn_text_restore),
                new MessageBoxBase.MessageBoxListener() {
                    @Override
                    public void onShown() {
                        C2439uo.getInstance().recover(path);
                    }

                    @Override
                    public void onDismissed() {
                    }

                    @Override
                    public void onDismiss() {
                    }
                },
                false);
    }

    public void m6244O2() {
        new ViewOnClickListenerC0166Di(this).m714c(getTabManager().m9316y().mo1574c(), getTabManager().m9316y().getUrlFromTitle());
    }

    public void setScreenBrightness(int brightnessValue) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                WindowManager.LayoutParams attributes = getWindow().getAttributes();

                // Constants for brightness scaling
                final float BRIGHTNESS_SCALE = 1 / 255f;

                if (brightnessValue >= 0) {
                    float adjustedBrightness = SharedPreferencesHelper.getInstance().enterNightMode
                            ? brightnessValue * 0.5f
                            : brightnessValue;
                    attributes.screenBrightness = adjustedBrightness * BRIGHTNESS_SCALE;
                } else {
                    attributes.screenBrightness = -1.0f;  // Default system brightness
                }

                getWindow().setAttributes(attributes);
            }
        });
    }

    public int m6246P0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return 0;
        }
        return ((WebViewBrowserController) interfaceC1300b3).m6768D0();
    }

    public final void m6247P1(String str, String str2, String str3, String str4) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", "update_bookmark_item");
            jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(str2));
            jSONObject.put("newId", AndroidSystemUtils.prefixWithMd5(str3));
            jSONObject.put("title", str);
            jSONObject.put("url", str3);
            jSONObject.put("path", str4);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1199a3.getInstance().m5094e("event_app_to_page", jSONObject);
    }

    public final void m6248P2() throws Resources.NotFoundException {
        MessageBoxManager.getInstance().showToast(getActivity().getBrowserFrameLayout(), getActivity().getResources().getString(R.string.message_revert_tabls), getActivity().getResources().getString(R.string.btn_text_restore), new MessageBoxBase.MessageBoxListener() {
            @Override
            public void onShown() {
                tabManager.m9314w();
                tabManager.restoreUserData(m6278X0());
                m6324h3();
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        });
    }

    public void m6249Q() {
        new DialogC2590y0(this).show();
    }

    public ViewGroup m6250Q0() {
        return (ViewGroup) this.browserFrameLayout.findViewById(R.id.main_content);
    }

    public void onLoadModuleFailed(String moduleName) {
        runOnUiThread(() -> MessageBoxManager.getInstance().showMessage(
                BrowserActivity.getActivity().getBrowserFrameLayout(),
                null,
                BrowserActivity.getActivity().getResources().getString(R.string.toast_load_module_failed),
                BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ok),
                BrowserActivity.getActivity().getResources().getString(R.string.btn_text_cancel),
                new MessageBoxBase.MessageBoxListener() {
                    @Override
                    public void onShown() {
                        Toast.makeText(BrowserActivity.this, R.string.toast_loading_module, Toast.LENGTH_LONG).show();
                        BackgroundTaskManager.submitBackgroundTask(() -> {
                            JSManager.getInstance().install(moduleName);
                            evaluateJS(moduleName);
                        });
                    }

                    @Override
                    public void onDismissed() {
                        SharedPreferencesHelper.getInstance().putBoolean("confirm_not_allow_sd", true);
                    }

                    @Override
                    public void onDismiss() {
                    }
                },
                true));
    }

    public void m6252Q2(int i) {
        showToast(getString(i));
    }

    public void m6253R(int i) {
        SharedPreferencesHelper.getInstance().m6854F0(i);
        getBrowserFrameLayout().setLayoutType(i);
    }

    public PullToRefreshHandler m6254R0() {
        return this.pullToRefreshHandler;
    }

    public final void m6255R1(String title, String url, String path) {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", "new_bookmark_item");
            jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(url));
            jSONObject.put("title", title);
            jSONObject.put("url", url);
            jSONObject.put("type", url.startsWith("/") ? 1 : 0);
            jSONObject.put("path", path);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1199a3.getInstance().m5094e("event_app_to_page", jSONObject);
    }

    public void showToast(String str) {
        runOnUiThread(new ShortToastRunnable(str));
    }

    private void showToast(int messageResId) {
        showToast(getString(messageResId));
    }

    public void m6257S(int i) {
        if (i == 0) {
            SharedPreferencesHelper.getInstance().putBoolean("load_images", true);
        } else if (i == 1) {
            SharedPreferencesHelper.getInstance().putBoolean("load_images", false);
        } else if (i == 2) {
            SharedPreferencesHelper.getInstance().putBoolean("load_images", AndroidSystemUtils.isWifiConnected(this));
        }
        SharedPreferencesHelper.getInstance().putInt("save_traffic_strategy", i);
        m6280X2();
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    public int[] getColors() {
        AbsBrowserController browserController = getBrowserController();
        if (browserController instanceof WebViewBrowserController) {
            browserController.getUrlFromTitle();
            return ((WebViewBrowserController) browserController).getColors();
        } else {
            return WebViewBrowserController.getColorsByTheme();
        }
    }

    public void m6259S1(boolean z) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6782R0(z);
        }
    }

    public final void m6260S2() {
    }

    public final void m6261T() {
        // Get the user preference for screen orientation
        String orientationPreference = SharedPreferencesHelper.getInstance().m6880U();
        int orientation = ActivityInfo.SCREEN_ORIENTATION_UNSPECIFIED; // Default to "auto"

        // Determine the orientation setting based on preference
        if ("portrait".equals(orientationPreference)) {
            orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT; // Portrait
        } else if ("landscape".equals(orientationPreference)) {
            orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE; // Landscape
        }

        // Apply the screen orientation
        setRequestedOrientation(orientation);

        // Check if the current mode is "browser"
        if ("browser".equals(SharedPreferencesHelper.getInstance().m6928y())) {
            // Check if the specific flag is set (8192)
            if ((SharedPreferencesHelper.getInstance().getDefaultLayoutType() & 8192) == 8192) {
                SharedPreferencesHelper.getInstance().browserFullscreenMode = true;
            }

            // Update the layout type
            this.browserFrameLayout.setLayoutType(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
        }
    }

    public ArrayList getActiveControllers() {
        return this.activeControllers;
    }

    public void m6263T1() {
        runOnUiThread(() -> {
            Log.i("toolbar", " set state to readmode...");
            getActivityDelegate().m6394C().m1429l(3);
        });
    }

    public void m6264T2() {
        Window window = getWindow();
        if (Build.VERSION.SDK_INT >= 35) {
            SystemUiController systemUiController = SystemUiCompat.create(window, window.getDecorView());
            boolean nightMode = !SharedPreferencesHelper.getInstance().enterNightMode;
            if (systemUiController != null) {
                systemUiController.showInsets(C1045Wo.m.getType());
                systemUiController.setLightStatusBar(nightMode);
                systemUiController.setLightNavigationBar(nightMode);
                systemUiController.setSystemBarsBehavior(2);
            }
            window.getDecorView().setSystemUiVisibility(nightMode ? 9472 : 1280);
            m6189B();
        } else {
            window.clearFlags(1024);
            window.getDecorView().setSystemUiVisibility(8208);
            window.getDecorView().setSystemUiVisibility(8208);
        }
        if (m6230L0() == 8) {
            InterfaceC0299Gd interfaceC0299GdM9500u = ThemeManager.getInstance().m9500u();
            int[] iArr = ThemeManager.f6998j;
            interfaceC0299GdM9500u.mo1391j(iArr[0]);
            ThemeManager.getInstance().m9500u().updateBackgroundColor(iArr[1]);
        }
    }

    public final void m6265U() {
        if (SharedPreferencesHelper.getInstance().acceptEula) {
            return;
        }
        new EulaAcceptDialog(this).show();
    }

    public BrowserFrameLayout getBrowserFrameLayout() {
        return this.browserFrameLayout;
    }

    public void m6267U1() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6788X0();
        }
    }

    public void m6268U2() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo5628j();
        }
    }

    public final void m6269V() {
        if (getResources().getConfiguration().orientation == 2 || SharedPreferencesHelper.getInstance().getBoolean("do_not_show_fraud_alert", false) || !PhoneUtils.getInstance().isInChina()) {
            return;
        }
        getHandler().postDelayed(new InitializationRunnable(), 500L);
    }

    public float m6270V0() {
        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        return displayMetrics.density;
    }

    public void m6271V1() {
        openUrl("x:bm?order=" + SharedPreferencesHelper.getInstance().getString("bm_order", "default"));
    }

    public boolean m6272V2() {
        int iM6230L0 = m6230L0();
        String strMo1573b = getBrowserController().getUrlFromTitle();
        return (SharedPreferencesHelper.getInstance().disablePullToRefreshGesture || SharedPreferencesHelper.getInstance().canVScroll || (iM6230L0 != 0 && iM6230L0 != 8) || strMo1573b.startsWith("file://") || strMo1573b.startsWith("x:") || this.uiLayoutMode != 0) ? false : true;
    }

    public void m6273W() {
        if (m6281Y(new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"})) {
            return;
        }
        AbstractC2129o0.m8827j(this, new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"}, 257);
    }

    public String m6274W0() {
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.bg", 9);
        if (FileUtils.fileExists(strM2046a)) {
            return FileUtils.readFileToString(strM2046a);
        }
        return null;
    }

    public void m6275W1() {
        evaluateJS("devtools");
    }

    public void m6276W2() {
        int i;
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            if (SharedPreferencesHelper.getInstance().f4872O0 && SharedPreferencesHelper.getInstance().nightBrightness >= 0) {
                i = SharedPreferencesHelper.getInstance().nightBrightness;
                setScreenBrightness(i);
                return;
            }
            setScreenBrightness(-1);
        }
        if (SharedPreferencesHelper.getInstance().f4872O0 && SharedPreferencesHelper.getInstance().defaultBrightness >= 0) {
            i = SharedPreferencesHelper.getInstance().defaultBrightness;
            setScreenBrightness(i);
            return;
        }
        setScreenBrightness(-1);
    }

    public boolean m6277X() {
        boolean zM6281Y = m6281Y(new String[]{"android.permission.POST_NOTIFICATIONS"});
        AbstractC2129o0.m8827j(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 260);
        return zM6281Y;
    }

    public final SharedPreferences m6278X0() {
        SharedPreferences sharedPreferences = getSharedPreferences("tabs_recovery", 0);
        return !TextUtils.isEmpty(sharedPreferences.getString("pref-tab-list", "")) ? sharedPreferences : SharedPreferencesHelper.getInstance().getSharedPreferences();
    }

    public void openUrl(String str) {
        openUrl(str, true, 0);
    }

    public void m6280X2() {
        if (getTabManager() != null) {
            int iM9280D = getTabManager().getTabCount();
            for (int i = 0; i < iM9280D; i++) {
                ArrayList arrayListM9279C = getTabManager().m9279C(i);
                for (int i2 = 0; i2 < arrayListM9279C.size(); i2++) {
                    InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) arrayListM9279C.get(i2);
                    if (interfaceC1300b3 != null && (interfaceC1300b3 instanceof WebViewBrowserController)) {
                        runOnUiThread(new WebViewSettingsApplyRunnable(((WebViewBrowserController) interfaceC1300b3).m6770F0()));
                    }
                }
            }
        }
    }

    public final boolean m6281Y(String[] strArr) {
        for (String str : strArr) {
            if (AbstractC2320s6.m9505a(this, str) == 0) {
                return true;
            }
        }
        return false;
    }

    public String m6282Y0(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9317z(i);
        if (interfaceC1300b3 != null) {
            return interfaceC1300b3.getUrlFromTitle();
        }
        return null;
    }

    public void m6283Y1() {
        m6307d2("market://details?id=" + getPackageName());
    }

    public void m6284Y2() {
        this.handler.removeCallbacks(this.textAutoFitRunnable);
        if (this.textFitWidth > 0) {
            this.handler.postDelayed(this.textAutoFitRunnable, 200L);
        }
    }

    public boolean m6285Z(String str) {
        return AbstractC2320s6.m9505a(this, str) == 0;
    }

    public final String getUrlFromIntent(Intent intent) {
        Uri data = intent.getData();
        if (data != null) {
            return data.toString();
        }
        return intent.getStringExtra("url");
    }

    public void m6287Z1() {
        openUrl("x:sd?path=offlines&sort=" + SharedPreferencesHelper.getInstance().getString("file_order", "date"));
    }

    public boolean m6288Z2() {
        int iM6845B = SharedPreferencesHelper.getInstance().getDefaultLayoutType();
        if ((iM6845B & 8192) == 8192) {
            m6253R(iM6845B ^ 8192);
            SharedPreferencesHelper.getInstance().browserFullscreenMode = false;
            SharedPreferencesHelper.getInstance().putBoolean("browser_fullscreen_mode", false);
            C0848Sb.getInstance().hideFloatingButton();
            m6264T2();
        } else {
            m6322h1();
            m6253R(iM6845B | 8192);
            SharedPreferencesHelper.getInstance().browserFullscreenMode = true;
            SharedPreferencesHelper.getInstance().putBoolean("browser_fullscreen_mode", true);
            if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                C0848Sb.getInstance().restorePosition();
            }
            if (!SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                C2363t3.getInstance().m9673i(112, false);
            }
        }
        m6189B();
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
        return SharedPreferencesHelper.getInstance().browserFullscreenMode;
    }

    @Override
    public void mo6289a(InterfaceC0345Hd interfaceC0345Hd) {
        this.activityDelegate.mo6401J(interfaceC0345Hd);
    }

    public void m6290a0() {
        m6281Y(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        AbstractC2129o0.m8827j(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 256);
    }

    public void m6291a1() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo5628j();
        }
        this.tabManager.m9287K();
        m6324h3();
    }

    public void m6292a2(String str) {
        if (TextUtils.isEmpty(str)) {
            Toast.makeText(this, R.string.toast_input_key_or_url, Toast.LENGTH_SHORT).show();
            return;
        }
        if (NetworkUtils.isNonUrl(str)) {
            m6334l0(str);
            return;
        }
        if (!NetworkUtils.startsWithKnownScheme(str)) {
            str = "http://" + str;
        }
        m6307d2(str);
    }

    public void m6293a3(String str) {
        if (SharedPreferencesHelper.getInstance().activeAdBlock && SharedPreferencesHelper.getInstance().showAdBlockToast) {
            if (this.lockObject != null) {
                getHandler().removeCallbacksAndMessages(this.lockObject);
            }
            UrlValidationRunnable runnableC1455Y = new UrlValidationRunnable(str);
            this.lockObject = runnableC1455Y;
            getHandler().postDelayed(runnableC1455Y, 300L);
        }
    }

    @Override
    public void attachBaseContext(Context context) {
        Locale locale = Locale.getDefault();
        if (Build.VERSION.SDK_INT >= 25) {
            String str = SharedPreferencesHelper.getInstance().defaultLangCode;
            if (!TextUtils.isEmpty(str) && !locale.toLanguageTag().equals(str)) {
                int iIndexOf = str.indexOf("-");
                Locale locale2 = iIndexOf < 0 ? new Locale(str) : new Locale(str.substring(0, iIndexOf), str.substring(iIndexOf + 1));
                Configuration configuration = context.getResources().getConfiguration();
                configuration.setLocale(locale2);
                super.attachBaseContext(context.createConfigurationContext(configuration));
                return;
            }
        }
        super.attachBaseContext(context);
    }

    @Override
    public void mo6294b() {
    }

    public void m6295b0() {
        new DialogC0143D4(this).show();
    }

    public void m6296b1() {
        this.tabManager.m9288L();
        m6324h3();
    }

    public void m6297b2(String str) {
        if (str != null) {
            if (NetworkUtils.isNonUrl(str)) {
                m6334l0(str);
            } else {
                m6307d2(str);
            }
            if (!str.startsWith("http")) {
                AndroidSystemUtils.m8701i(this, str);
                Toast.makeText(this, R.string.copied_to_clipboard, Toast.LENGTH_LONG).show();
            }
        } else {
            Toast.makeText(this, R.string.toast_unrecognised_qrcode, Toast.LENGTH_SHORT).show();
        }
    }

    public void m6298b3() {
        if (getTabManager() != null) {
            int iM9280D = getTabManager().getTabCount();
            for (int i = 0; i < iM9280D; i++) {
                Iterator it = getTabManager().m9279C(i).iterator();
                while (it.hasNext()) {
                    InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) it.next();
                    if (interfaceC1300b3 instanceof WebViewBrowserController) {
                        ((WebViewBrowserController) interfaceC1300b3).m6791a1();
                    }
                    interfaceC1300b3.mo5631t();
                }
            }
        }
    }

    @Override
    public void mo6299c(InterfaceC0345Hd interfaceC0345Hd) {
        if (interfaceC0345Hd instanceof InterfaceC1300b3) {
            this.activeControllers.add(interfaceC0345Hd.getUrlFromTitle());
        }
    }

    public void m6300c0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6770F0().clearCache(false);
        }
    }

    public void m6301c1(int i, boolean z) {
        SharedPreferencesHelper.getInstance().goodForEyeColor = i;
        SharedPreferencesHelper.getInstance().putInt("good_for_eye_color", i);
        m6298b3();
        SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
    }

    public void openSiteFromCurrentTab() {
        // Get the URL from the current tab's title
        String url = getTabManager().m9316y().getUrlFromTitle();

        // Check if the URL starts with "http", if not show a toast and return
        if (!url.startsWith("http")) {
            Toast.makeText(this, R.string.toast_not_support_this_operation, Toast.LENGTH_SHORT).show();
            return;
        }

        // Extract the host from the URL using Uri.parse
        String host = Uri.parse(url).getHost();

        // Build the site URL for further processing
        String siteUrl = "x:site?host=" + host + "&top_domain=" + NetworkUtils.getDomain(host);

        // Open the constructed URL
        openUrl(siteUrl, true, 0);
    }

    public void updateBookmark(String oldUrl, String newUrl, String newTitle, String parentUrl) {
        SQLiteDatabase db = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        String[] columns = DatabaseColumns.BOOKMARK;

        try (Cursor cursor = db.query("bookmark", columns, "url= ?", new String[]{oldUrl}, null, null, null)) {
            if (!cursor.moveToFirst()) {
                // Handle case when bookmark is not found
                cursor.close();
                SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
                return;
            }

            long bookmarkId = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            cursor.getInt(cursor.getColumnIndexOrThrow("type"));
            String parent = cursor.getString(cursor.getColumnIndexOrThrow("parent"));

            ContentValues contentValues = new ContentValues();
            contentValues.put("url", newUrl);
            contentValues.put("title", newTitle);
            contentValues.put("parent", parentUrl);
            contentValues.put("last_visit", System.currentTimeMillis());

            String whereClause = "_id=?";
            String[] whereArgs = new String[]{String.valueOf(bookmarkId)};
            db.update("bookmark", contentValues, whereClause, whereArgs);

            parent.equals(parentUrl); // Comparison to avoid unnecessary operations
            m6247P1(newTitle, oldUrl, newUrl, parentUrl);

            if (oldUrl.startsWith("/")) {
                try (Cursor childCursor = db.query("bookmark", columns, "parent= ?", new String[]{oldUrl}, null, null, null)) {
                    while (childCursor.moveToNext()) {
                        @SuppressLint("Range") String childUrl = childCursor.getString(childCursor.getColumnIndex("url"));
                        @SuppressLint("Range") String childTitle = childCursor.getString(childCursor.getColumnIndex("title"));

                        if (childUrl.startsWith("/")) {
                            updateBookmark(childUrl, newUrl + "/" + childTitle, childTitle, newUrl);
                        } else {
                            updateBookmark(childUrl, childUrl, childTitle, newUrl);
                        }
                    }
                }
            }
        } catch (Exception e) {
            Log.e("updateBookmark", "Error updating bookmark", e);
            Toast.makeText(this, R.string.toast_bookmark_exist, Toast.LENGTH_SHORT).show();
        } finally {
            SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
        }
    }

    @Override
    public void mo6304d() {
    }

    public void clearImmersePageCache() {
        // Delete the cached immerse colors file from the resource cache
        FileUtils.deleteFile(ResourceCacheManager.getInstance().getUrlOrFilePath("page.immerse.colors", 1));

        // Clear the screen dimensions data
        this.screenDimensions = null;
    }

    public final boolean m6306d1(Intent intent) {
        String strM6286Z0 = getUrlFromIntent(intent);
        String action = intent.getAction();
        String type = intent.getType();
        int intExtra = intent.getIntExtra("browser_mode", 0);
        if (TextUtils.isEmpty(action)) {
            return false;
        }
        if (action.equals("android.intent.action.MAIN") || action.equals("android.intent.action.VIEW")) {
            if (TextUtils.isEmpty(strM6286Z0)) {
                return false;
            }
            if (!NetworkUtils.startsWithKnownScheme(strM6286Z0)) {
                strM6286Z0 = "http://" + strM6286Z0;
            }
            if (strM6286Z0.endsWith(".mht")) {
                m6307d2(strM6286Z0);
            } else {
                String strM6333k2 = m6333k2(Uri.parse(strM6286Z0), true);
                openUrl(strM6286Z0, true, intExtra);
                if (FileUtils.doesFirstLineStartWith(strM6333k2, "<!DOCTYPE NETSCAPE-Bookmark-file-1>")) {
                    recoverBookmark("file://" + strM6333k2);
                }
            }
            if (strM6286Z0.equals("http://www.xbext.com/?source=set-default-browser") && !AndroidSystemUtils.isDefaultBrowser(this)) {
                Toast.makeText(this, "Set default browser failed", Toast.LENGTH_SHORT).show();
                refreshQuickAccessUI();
            }
        } else if (action.equals("android.intent.action.WEB_SEARCH") || action.equals("android.intent.action.SEARCH")) {
            m6337m0(intent.getStringExtra("query"), true);
        } else if (!action.equals("android.intent.action.SEND")) {
            Toast.makeText(this, "not found url data in action:[" + action + "]", Toast.LENGTH_SHORT).show();
        } else if (!TextUtils.isEmpty(type)) {
            if (type.startsWith("text/")) {
                String stringExtra = intent.getStringExtra("android.intent.extra.TEXT");
                if (TextUtils.isEmpty(stringExtra)) {
                    Uri uri = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                    FileUtils.getFileName(uri.toString());
                    m6307d2(uri.toString());
                    String strM6333k22 = m6333k2(uri, true);
                    if (FileUtils.doesFirstLineStartWith(strM6333k22, "<!DOCTYPE NETSCAPE-Bookmark-file-1>")) {
                        recoverBookmark("file://" + strM6333k22);
                    } else {
                        m6307d2("file://" + m6333k2(uri, false));
                        m6239N1();
                    }
                } else {
                    String strM456k = NetworkUtils.extractHttpUrl(stringExtra);
                    if (strM456k != null) {
                        openUrl(strM456k, true, intExtra);
                    } else if (NetworkUtils.FULL_URL_PATTERN.matcher(stringExtra).matches()) {
                        strM456k = "https://" + stringExtra;
                        openUrl(strM456k, true, intExtra);
                    } else {
                        m6337m0(stringExtra, true);
                    }
                }
            } else if (type.startsWith("application/")) {
                Uri uri2 = (Uri) intent.getParcelableExtra("android.intent.extra.STREAM");
                String str = PhoneUtils.getInstance().getCacheDirPath() + "/" + FileUtils.getFileName(uri2.toString());
                File file = new File(str);
                AndroidSystemUtils.copyUriToFile(this, uri2, file);
                if (FileUtils.isZipFile(file)) {
                    recoverUserData(str);
                } else if (FileUtils.doesFirstLineStartWith(str, "// ==UserScript==")) {
                    JSManager.getInstance().m8565z0(str);
                } else {
                    if (!str.endsWith(".mht")) {
                        Toast.makeText(this, "Unrecognised file format", Toast.LENGTH_LONG).show();
                        return false;
                    }
                    m6333k2(uri2, false);
                    m6239N1();
                }
            }
        }
        return true;
    }

    public void m6307d2(String str) {
        m6311e2(str, null, getTabManager().m9316y() != null ? ((InterfaceC1300b3) getTabManager().m9316y()).mo5626h() : 0, SharedPreferencesHelper.getInstance().supportSuperCache);
    }

    public void m6308d3() {
        m6312e3((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097 ? "search-bar-at-top" : "search-bar-at-bottom");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4 && keyEvent.isLongPress() && isPreviousTabValid()) {
            getActivityDelegate().mo6411T();
            return true;
        }
        if (!m6362u1()) {
            return super.dispatchKeyEvent(keyEvent);
        }
        if ((keyCode == 24 || keyCode == 25) && m6362u1()) {
            super.dispatchKeyEvent(keyEvent);
            return true;
        }
        return super.dispatchKeyEvent(keyEvent);
    }

    @Override
    public boolean dispatchTouchEvent(MotionEvent motionEvent) {
        if (this.hasWindowFocus) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void m6309e0() {
        FileUtils.deleteFile(ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.bg", 9));
    }

    public final void m6310e1(Insets insets, Insets insets2) {
        WebView webViewM6770F0;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (getTabManager() != null) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
            if (!(interfaceC1300b3 instanceof WebViewBrowserController) || (webViewM6770F0 = ((WebViewBrowserController) interfaceC1300b3).m6770F0()) == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) webViewM6770F0.getLayoutParams()) == null) {
                return;
            }
            marginLayoutParams.leftMargin = Math.max(insets.f7065a, insets2.f7065a);
            marginLayoutParams.rightMargin = Math.max(insets.f7067c, insets2.f7067c);
            webViewM6770F0.setLayoutParams(marginLayoutParams);
        }
    }

    public void m6311e2(String str, InterfaceC1300b3 interfaceC1300b3, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InterfaceC1300b3 interfaceC1300b32 = interfaceC1300b3 == null ? (InterfaceC1300b3) this.tabManager.m9316y() : interfaceC1300b3;
        if (interfaceC1300b3 == null || z) {
            InterfaceC1300b3 interfaceC1300b3M7293a = this.menuController.m7293a(str);
            if (interfaceC1300b3M7293a != null) {
                interfaceC1300b3M7293a.mo5622C(i);
                interfaceC1300b3M7293a.mo1579m(str);
                this.tabManager.m9305m(interfaceC1300b3M7293a);
                if (interfaceC1300b32 != null) {
                    interfaceC1300b3M7293a.mo1572D(interfaceC1300b32.getUrlFromTitle());
                }
                interfaceC1300b3M7293a.mo5623E(str);
                return;
            }
            Log.i("browser", "forward url to other app:" + str);
            if (!str.startsWith("market://")) {
                return;
            }
        } else {
            if (interfaceC1300b32.mo5627i(str)) {
                interfaceC1300b32.mo5623E(str);
                return;
            }
            int iM9284H = this.tabManager.m9284H(interfaceC1300b32);
            InterfaceC1300b3 interfaceC1300b3M7293a2 = this.menuController.m7293a(str);
            if (interfaceC1300b3M7293a2 != null) {
                interfaceC1300b3M7293a2.mo5622C(i);
                this.tabManager.m9306n(interfaceC1300b3M7293a2, iM9284H);
                interfaceC1300b3M7293a2.mo5623E(str);
                return;
            } else {
                Log.i("browser", "forward url to other app:" + str);
            }
        }
        m6190B0(str);
    }

    public void m6312e3(String str) {
        runOnUiThread(new SearchBarPositionRunnable(str));
    }

    public void m6313f0() {
        new DialogC0465K4(this).show();
    }

    public boolean m6314f1() {
        return FileUtils.fileExists(ResourceCacheManager.getInstance().getUrlOrFilePath("start-page.bg", 9));
    }

    public void m6315f2(String str, boolean z) {
        m6311e2(str, null, getTabManager().m9316y() != null ? ((InterfaceC1300b3) getTabManager().m9316y()).mo5626h() : 0, z);
    }

    public void m6316f3(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (!MySQLiteOpenHelper.getInstance().m7543y0(writableDatabase, str)) {
            addQuickAccessItem(str, str2, str3, 0);
            return;
        }
        String[] strArr = {str};
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", str2);
        contentValues.put("status", (Integer) 0);
        if (!TextUtils.isEmpty(str3)) {
            contentValues.put("url", str3);
        }
        writableDatabase.execSQL("DELETE FROM quick_access WHERE url='" + str3 + "' AND guid != '" + str + "'");
        writableDatabase.update("quick_access", contentValues, "guid= ?", strArr);
        StringBuilder sb = new StringBuilder();
        sb.append("nav_call_updateItem('");
        sb.append(str);
        sb.append("','");
        sb.append(str2);
        sb.append("')");
        updateTitle(sb.toString());
    }

    @Override
    public void finish() {
        super.finish();
        m6379y2();
        if (SharedPreferencesHelper.getInstance().cleanCacheOnExit) {
            if (SharedPreferencesHelper.getInstance().getBoolean("clean_web_cookies_checked", false)) {
                SharedPreferencesHelper.getInstance().m6910o();
            }
            if (SharedPreferencesHelper.getInstance().getBoolean("clean_history_checked", false)) {
                MySQLiteOpenHelper.getInstance().m7498J();
            }
            if (SharedPreferencesHelper.getInstance().getBoolean("clean_search_his_checked", false)) {
                MySQLiteOpenHelper.getInstance().clearSearchHistory();
            }
            if (SharedPreferencesHelper.getInstance().getBoolean("clean_form_data_checked", false)) {
                SharedPreferencesHelper.getInstance().m6902k();
            }
            SharedPreferencesHelper.getInstance().m6906m(true);
        }
        Log.i("save-state", "destory xbrowser .....");
    }

    public final void updateSystemUI() {
        // Create a SystemUiController instance using SystemUiCompat
        SystemUiController systemUiController = SystemUiCompat.create(getWindow(), getWindow().getDecorView());

        // Proceed only if the controller is not null
        if (systemUiController != null) {
            // Check if Night Mode is enabled and set the system UI light/dark theme accordingly
            boolean isLightMode = !SharedPreferencesHelper.getInstance().enterNightMode;

            // Set light status and navigation bars based on Night Mode setting
            systemUiController.setLightStatusBar(isLightMode);
            systemUiController.setLightNavigationBar(isLightMode);

            // Set the system bars behavior
            systemUiController.setSystemBarsBehavior(2);
        }
    }

    public final void m6318g1() {
    }

    public void openUrl(String str, boolean z, int i) {
        if (this.tabManager.getTabCount() > 1024) {
            Toast.makeText(this, "open too many tabs", Toast.LENGTH_SHORT).show();
            return;
        }
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        InterfaceC1300b3 interfaceC1300b3M7293a = this.menuController.m7293a(str);
        if (interfaceC1300b3M7293a == null) {
            m6190B0(str);
            return;
        }
        interfaceC1300b3M7293a.mo5622C(i);
        if (interfaceC1300b3 != null && i != -1) {
            interfaceC1300b3M7293a.mo1572D(interfaceC1300b3.getUrlFromTitle());
        }
        interfaceC1300b3M7293a.mo5623E(str);
        if ((SharedPreferencesHelper.getInstance().newTabAtBottom && str.startsWith("x:")) || (SharedPreferencesHelper.getInstance().newTabAtBottom && str.startsWith("file:///android_asset/"))) {
            this.tabManager.m9310s(interfaceC1300b3M7293a);
        } else {
            this.tabManager.m9312u(interfaceC1300b3M7293a, z);
        }
        m6324h3();
        if (!z) {
            Toast.makeText(this, R.string.toast_open_in_bg, Toast.LENGTH_SHORT).show();
        }
    }

    public void m6320g3() {
        ThemeManager.getInstance().m9479G();
        getActivityDelegate().m6394C().m1434q();
    }

    public void m6321h0(String str) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("bookmark", DatabaseColumns.BOOKMARK, "url= ?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type")) != 1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("status", -1);
                        writableDatabase.update("bookmark", contentValues, "url= ?", new String[]{str});
                        m6223J1(AndroidSystemUtils.prefixWithMd5(str));
                    } else if (this.uiLayoutMode == 3) {
                        MySQLiteOpenHelper.getInstance().deleteBookmarkRecursive(writableDatabase, str);
                        m6223J1(AndroidSystemUtils.prefixWithMd5(str));
                    } else {
                        new BookmarkDeleteConfirmDialog(this, writableDatabase, str).show(getString(R.string.dlg_remove_dir_title), getString(R.string.dlg_remove_dir_confirm));
                    }
                }
                cursorQuery.close();
                SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
            } catch (Throwable th) {
                cursorQuery.close();
                SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
                throw th;
            }
        }
    }

    public void m6322h1() {
        if (Build.VERSION.SDK_INT >= 35) {
            SystemUiController systemUiControllerM4436A = SystemUiCompat.create(getWindow(), getWindow().getDecorView());
            if (systemUiControllerM4436A != null) {
                systemUiControllerM4436A.hideInsets(C1045Wo.m.getType());
                systemUiControllerM4436A.setSystemBarsBehavior(2);
            }
        } else {
            this.decorView.setSystemUiVisibility(7942);
        }
        m6189B();
    }

    public void m6323h2() {
        Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
        if (intent.resolveActivity(getPackageManager()) != null) {
            if (AbstractC2320s6.m9505a(this, "android.permission.CAMERA") != 0) {
                AbstractC2129o0.m8827j(this, new String[]{"android.permission.CAMERA"}, 261);
                return;
            }
            Uri uriM8707o = AndroidSystemUtils.createTempFileUri(this, "image/jpeg");
            this.cameraPhotoUri = uriM8707o;
            if (uriM8707o != null) {
                intent.putExtra("output", uriM8707o);
                startActivityForResult(intent, 17);
            }
        }
    }

    public void m6324h3() {
        this.activityDelegate.mo6428g0();
        this.activityDelegate.m6394C().m1427E();
    }

    public void m6325i0(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", -1);
        MySQLiteOpenHelper.getInstance().getWritableDatabase().update("quick_access", contentValues, "parent= ?", new String[]{str});
        deleteQuickAccessItem(str);
    }

    public void m6326i1() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("text/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 68);
    }

    public void m6327i2() {
        evaluateJS("page_tts_v2");
    }

    public void deleteQuickAccessItem(String itemGuid) {
        updateQuickAccessStatus(itemGuid);
        triggerTitleUpdate(itemGuid);
        incrementSyncVersion();
    }

    private void updateQuickAccessStatus(String itemGuid) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", -1);
        MySQLiteOpenHelper.getInstance().getWritableDatabase().update("quick_access", contentValues, "guid= ?", new String[]{itemGuid});
    }

    private void triggerTitleUpdate(String itemGuid) {
        String deleteScript = "nav_call_deleteItem('" + itemGuid + "')";
        updateTitle(deleteScript);
    }

    private void incrementSyncVersion() {
        SyncManager.getInstance().getResourceManager("syncable_quick_access").incrementVersion();
    }

    public void openTextFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        intent.setType("text/*");
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        startActivityForResult(intent, REQUEST_CODE_TEXT_FILE_PICKER);
    }

    public final String getFilePathFromIntent(Intent intent) {
        Uri dataUri = intent.getData();
        if (dataUri == null) return null;

        return "file".equalsIgnoreCase(dataUri.getScheme())
                ? dataUri.getPath()
                : AndroidSystemUtils.getCachedFilePath(this, dataUri);
    }

    public final void logHistory(String title, String url) {
        if (TextUtils.isEmpty(url) || url.startsWith("file:///")) {
            return;
        }

        String domain = "";
        if (!url.startsWith("x:")) {
            try {
                String host = Uri.parse(url).getHost();
                if (host != null) {
                    domain = NetworkUtils.getDomain(host);
                }
            } catch (Exception e) {
                Log.w("xbrowser", "Failed to parse host from URL", e);
            }
        }

        long lastVisit = System.currentTimeMillis();
        SQLiteDatabase db = MySQLiteOpenHelper.getInstance().getWritableDatabase();

        db.beginTransaction();
        try {
            ContentValues values = new ContentValues();
            values.put("title", title);
            values.put("url", url);
            values.put("host", domain);
            values.put("visits", 1);  // Assuming the visit count should be 1 for new entries
            values.put("last_visit", lastVisit);

            // Try to update the history record
            int rowsAffected = db.update(
                    "history",
                    values,
                    "url = ?",
                    new String[]{url}
            );

            // If no rows were affected, insert a new record
            if (rowsAffected == 0) {
                db.insert("history", null, values);
            }

            db.setTransactionSuccessful();
        } catch (Exception e) {
            Log.w("xbrowser", "Failed to log history", e);
        } finally {
            db.endTransaction();
        }
    }

    public final String m6333k2(Uri uri, boolean z) {
        String strM3803e = C0801Ra.getInstance().getDisplayName(uri);
        if (TextUtils.isEmpty(strM3803e)) {
            strM3803e = FileUtils.getFileName(uri.toString());
        }
        StringBuilder sb = new StringBuilder();
        sb.append(z ? PhoneUtils.getInstance().getCacheDirPath() : PhoneUtils.getInstance().getOfflinesDirPath());
        sb.append("/");
        sb.append(strM3803e);
        String string = sb.toString();
        AndroidSystemUtils.copyUriToFile(this, uri, new File(string));
        return string;
    }

    public void m6334l0(String str) {
        m6337m0(str, SharedPreferencesHelper.getInstance().openSearchInNewTab);
    }

    public void m6335l1() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 82);
    }

    public final void handleClipboardUrl(ClipboardManager clipboardManager) {
        if (clipboardManager != null
                && clipboardManager.hasPrimaryClip()
                && clipboardManager.getPrimaryClip().getItemCount() > 0) {

            CharSequence clipText = clipboardManager.getPrimaryClip().getItemAt(0).getText();
            if (clipText != null && clipText.length() < 1024) {
                SuggestionInputAdapter.firstUrl = NetworkUtils.extractFirstUrl(clipText);
            }
        }
    }

    public void m6337m0(String str, boolean z) {
        String strReplace;
        C2390tl.getInstance().m9735e(str);
        String strM6882V = SharedPreferencesHelper.getInstance().getSearchUrl();
        String countryCode = PhoneUtils.getInstance().getSimOrNetworkCountryCode();
        if (countryCode == null) {
            countryCode = "";
        }
        try {
            strM6882V = strM6882V.replace("%keywords%", URLEncoder.encode(str, "utf-8"));
            strReplace = strM6882V.replace("%country_code%", countryCode);
        } catch (Exception e) {
            e.printStackTrace();
            strReplace = strM6882V.replace("%keywords%", str).replace("%country_code%", countryCode);
        }
        C1344c1.getInstance().m5698h("Search Times", "search_times");
        C1344c1.getInstance().m5698h("Search Times By Channel", "search_times/" + PhoneUtils.getInstance().getChannelCode());
        String domain = Uri.parse(strReplace).getHost();
        C1344c1.getInstance().m5698h("Search Times By Domain", "search_times/" + domain);
        try {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
            firebaseAnalytics.setAnalyticsCollectionEnabled(true);
            Bundle bundle = new Bundle();
            bundle.putString("domain", domain);
            bundle.putString("country_code", countryCode);
            firebaseAnalytics.logEvent("search_times", bundle);
        } catch (Exception ignored) {
        }
        if (z) {
            openUrl(strReplace, true, 0);
        } else {
            m6307d2(strReplace);
        }
        EventQueueManager.getInstance().processEvent(4);
        if (SharedPreferencesHelper.getInstance().enterPrivateMode) {
            return;
        }
        backgroundExecutor.execute(new UrlProcessRunnable(str));
    }

    public boolean m6338m1() {
        String strMo1573b = getTabManager().m9316y().getUrlFromTitle();
        return strMo1573b != null && strMo1573b.indexOf("article_list_for_xb_readmode") > 0;
    }

    public void handleClipboardUrl(Handler handler) {
        handler.postDelayed(() -> {
            try {
                if (SharedPreferencesHelper.getInstance().acceptEula
                        && !SharedPreferencesHelper.getInstance().hideClipboardContent) {
                    handleClipboardUrl((ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE));
                }
            } catch (Exception ignored) {
            }
        }, 500L);
    }

    public void m6340n0(boolean z) {
        if (SharedPreferencesHelper.getInstance().getBoolean("first-sniff-media", true) && PhoneUtils.getInstance().isInChina()) {
            new VideoSniffingAcceptDialog(this, "免责声明", "页面中的资源版权归属内容提供方，仅供用户自己学习、研究，未经授权请勿传播含有版权内容,否则将承担法律责任。如果您是版权所有人发现此服务涉及到您的权利请务必联系作者本人，联系方式及详情请点击<a href='https://www.xbext.com/docs/end-user-license-agreement.html#5-%E6%97%A0%E6%8B%85%E4%BF%9D%E5%A3%B0%E6%98%8E'>《无担保声明》</a>进行查看", z).show();
        } else {
            VideoSniffingManager.getInstance().m7001k(z);
        }
    }

    public final void m6341n1() {
        this.browserFrameLayout = (BrowserFrameLayout) findViewById(R.id.main_root);
        this.touchEventDispatcher = new TouchEventDispatcher(this, this);
        this.gestureDetector = new MyGestureDetector(this, new GestureCallback());
        this.browserFrameLayout.setTouchHooker(new TouchEventHandler());
        this.browserFrameLayout.setEventListener(new FrameLayoutCallback());
        PullToRefreshHandler pullToRefreshHandler = new PullToRefreshHandler(this);
        this.pullToRefreshHandler = pullToRefreshHandler;
        pullToRefreshHandler.setBrowserFrameLayout(this.browserFrameLayout);
        this.browserFrameLayout.setOverscrollRefreshHandler(this.pullToRefreshHandler);
        m6189B();
        m6320g3();
        if (Build.VERSION.SDK_INT >= 35) {
            m6347p1();
        }
    }

    public void m6342n2() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("*/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 66);
    }

    public void m6343o0(boolean z) {
        C1199a3.getInstance().m5093d("event_app_to_page", "enter_edit_mode");
        this.uiLayoutMode = 3;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mark_toolbar_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = (LinearLayout) View.inflate(this, R.layout.toolbar_layout_bm_multi_sel, null);
        ((Button) linearLayout2.findViewById(R.id.select_all_bm)).setOnClickListener(view -> C1199a3.getInstance().m5093d("event_app_to_page", "select_or_deselect_items"));
        ((Button) linearLayout2.findViewById(R.id.delete_bookmarks)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new ConfirmDialog((BrowserActivity.this)) {
                    @Override
                    public void onCancel() {
                    }

                    @Override
                    public void onOK() {
                        C1199a3.getInstance().m5093d("event_app_to_page", "delete_selected_items");
                    }
                }.show(getString(R.string.batch_del_title), getString(R.string.del_select_item_confrim));
            }
        });
        Button button = (Button) linearLayout2.findViewById(R.id.cut_bookmarks);
        if (z) {
            button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    m6373x0();
                    C1199a3.getInstance().m5093d("event_app_to_page", "cut_selected_items");
                }
            });
        } else {
            button.setVisibility(View.GONE);
        }
        ((Button) linearLayout2.findViewById(R.id.toolbar_btn_finish)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m6373x0();
            }
        });
        linearLayout.addView(linearLayout2, layoutParams);
        getBrowserFrameLayout().m6465n();
    }

    public final void m6344o1() {
    }

    public void refreshQuickAccessUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) tabManager.m9316y();
                if (interfaceC1300b3 != null) {
                    interfaceC1300b3.mo5625f();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        try {
            if (requestCode == 32) {
                if (resultCode == RESULT_OK && data != null) {
                    String stringExtra = data.getStringExtra("SCAN_RESULT");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        m6297b2(stringExtra);
                    }
                }
            } else if (requestCode == 65) {
                if (resultCode == RESULT_OK) {
                    Toast.makeText(this, R.string.toast_import_bookmark, Toast.LENGTH_SHORT).show();
                    EventQueueManager.getInstance().processEvent(System.currentTimeMillis(), 22, data.getDataString(), null);
                    SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
                }
            } else if (requestCode == 84) {
                if (resultCode == RESULT_OK) {
                    String strM6330j2 = getFilePathFromIntent(data);
                    if (strM6330j2 != null) {
                        C0600N1.getInstance().m3264m(strM6330j2);
                    } else {
                        Toast.makeText(this, "import error", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (requestCode == 68) {
                if (resultCode == RESULT_OK) {
                    String strM6330j22 = getFilePathFromIntent(data);
                    if (strM6330j22 != null) {
                        ContentDataManager.getInstance().m6634p0(strM6330j22);
                    } else {
                        Toast.makeText(this, "import error", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (requestCode == 82) {
                if (resultCode == RESULT_OK) {
                    String strM6330j23 = getFilePathFromIntent(data);
                    if (strM6330j23 != null) {
                        JSManager.getInstance().m8536h0(strM6330j23);
                    } else {
                        Toast.makeText(this, "import error", Toast.LENGTH_SHORT).show();
                    }
                }
            } else if (requestCode == 66) {
                if (resultCode == RESULT_OK) {
                    String strM6330j24 = getFilePathFromIntent(data);
                    if (TextUtils.isEmpty(strM6330j24)) {
                        C2439uo.getInstance().m10211I();
                    } else {
                        C2439uo.getInstance().recover(strM6330j24);
                    }
                }
            } else if (requestCode == 69) {
            } else if (requestCode == 70) {
                if (resultCode == RESULT_OK && data != null) {
                    String stringExtra = data.getStringExtra("result");
                    AndroidSystemUtils.m8701i(this, stringExtra);
                    m6297b2(stringExtra);
                }
            } else if (requestCode == 71) {
                if (resultCode == RESULT_OK && data != null) {
                    String stringExtra = data.getStringExtra("SCAN_RESULT");
                    m6297b2(stringExtra);
                }
            } else if (requestCode == 72) {
                if (resultCode == RESULT_OK) {
                    Uri uri = data.getData();
                    String type = data.getType();
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent2.setDataAndType(uri, type);
                    startActivity(intent2);
                }
            } else if (requestCode == 83) {
                if (resultCode == RESULT_OK) {
                    String action = data.getAction();
                    switch (action) {
                        case "action.open_url_or_search":
                            m6292a2(data.getStringExtra("key-or-url"));
                            break;
                        case "action.do_search":
                            m6334l0(data.getStringExtra("key-or-url"));
                            break;
                        case "action.active_tab":
                            m6364v(data.getStringExtra("tab-id"));
                            break;
                        case "action.execute_cmd":
                            getActivityDelegate().mo6439y(data.getStringExtra("command"));
                            break;
                    }
                }
            } else if (requestCode == 259) {
                if (this.pendingApkUri != null) {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
                    intent3.setDataAndType(this.pendingApkUri, "application/vnd.android.package-archive");
                    startActivity(intent3);
                    this.pendingApkUri = null;
                }
            }
            if (requestCode == 16) {
                if (data != null && this.fileUploadCallback != null) {
                    String dataString = data.getDataString();
                    ClipData clipData = data.getClipData();
                    Uri[] uriArr = null;
                    if (clipData != null) {
                        uriArr = new Uri[clipData.getItemCount()];
                        for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                            uriArr[i3] = clipData.getItemAt(i3).getUri();
                        }
                    }
                    if (dataString != null) {
                        uriArr = new Uri[]{Uri.parse(dataString)};
                    }
                    this.fileUploadCallback.onReceiveValue(uriArr);
                    fileUploadCallback = null;
                }
            } else if (requestCode == 17) {
                if (fileUploadCallback != null) {
                    if (resultCode == RESULT_OK && cameraPhotoUri != null) {
                        fileUploadCallback.onReceiveValue(new Uri[]{cameraPhotoUri});
                        this.fileUploadCallback = null;
                        this.cameraPhotoUri = null;
                    } else {
                        fileUploadCallback.onReceiveValue(new Uri[0]);
                    }
                    fileUploadCallback = null;
                }
            } else {
                if (fileUploadCallback != null) {
                    fileUploadCallback.onReceiveValue(new Uri[0]);
                    fileUploadCallback = null;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConfigurationChanged(@NonNull Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        int i = newConfig.uiMode & 48;
        if (SharedPreferencesHelper.getInstance().followSystemDarkMode && i != SharedPreferencesHelper.getInstance().f4915l0) {
            SharedPreferencesHelper.getInstance().f4915l0 = i;
            m6186A0(i);
        }
        ((InterfaceC1300b3) getTabManager().m9316y()).onConfigurationChanged(newConfig);
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        this.decorView = getWindow().getDecorView();
        AndroidSystemUtils.startTiming("Browser Activity create");
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
        activity = this;
        this.systemUiVisibility = (int) getResources().getDimension(R.dimen.swipe_slop);
        if (SharedPreferencesHelper.getInstance().keepScreenOn) {
            getWindow().addFlags(128);
        }
        C1344c1.getInstance().init();
        m6344o1();
        MenuConfigManager.getInstance().init(this);
        C0600N1.getInstance().init(this);
        C0988Vd.getInstance().init(this);
        ThemeManager.getInstance().init(this);
        C2363t3.getInstance().init(this);
        ContentDataManager.getInstance().m6640r0(this);
        C1199a3.getInstance().init(this);
        JSManager.getInstance().init();
        C2390tl.getInstance().init();
        BrowserDownloadManager.getInstance().init(this);
        C2406u0.getInstance().init(this);
        C1224ai.getInstance().init(this);
        C0801Ra.getInstance().init(this);
        VideoSniffingManager.getInstance().init(this);
        C1651dn.getInstance().init(this);
        C2564xb.getInstance().init(this);
        C0356Ho.getInstance().init(this);
        C0310Go.getInstance().init(this);
        C0462K1.getInstance().init(this);
        WebIconDatabase.getInstance().open(getDir("icons", 0).getPath());
        activityDelegate = new PhoneBrowserActivtyDelegate(this);
        activityDelegate.mo6402K(bundle);
        C0848Sb.getInstance().init(this);
        m6341n1();
        if (SharedPreferencesHelper.getInstance().getBoolean("show_splash", false)) {
            m6260S2();
            getHandler().postDelayed(new UpdateCheckRunnable(), 1500L);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.main_content);
        m6261T();
        tabManager = new TabManager(this, frameLayout);
        tabManager.m9302Z(this);
        AndroidSystemUtils.logElapsedTime();
        m6208F2();
        boolean zM6306d1 = m6306d1(getIntent());
        m6367v2();
        if (!zM6306d1 && this.tabManager.getTabCount() == 0) {
            openUrl(SharedPreferencesHelper.getInstance().m6857H(), true, 0);
        }
        m6324h3();
        Looper.myQueue().addIdleHandler(() -> {
            EventQueueManager.getInstance().processEvent(0);
            return false;
        });
        m6276W2();
        m6265U();
        if (SharedPreferencesHelper.getInstance().acceptEula && !SharedPreferencesHelper.getInstance().showFraudAlert) {
            m6269V();
        }
        setNormalExit(false);
        C0461K0.m2246i(this);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (SharedPreferencesHelper.getInstance().normalExit) {
            Process.killProcess(Process.myPid());
        }
    }

    @Override
    public boolean onDoubleTap(@NonNull MotionEvent event) {
        String strM6855G = SharedPreferencesHelper.getInstance().getDefaultActionForKey("double_click_blank");
        String strM6234M0 = m6234M0();
        if (TextUtils.isEmpty(strM6234M0) || !strM6234M0.startsWith("x:home") || SharedPreferencesHelper.getInstance().getBoolean("show-qa-icons", true) || !(strM6855G.equals("not_set") || strM6855G.equals("none"))) {
            return getActivityDelegate().mo6439y(strM6855G);
        }
        m6307d2("x:bookmark");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onDown(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean onFling(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        int iAbs;
        if (!SharedPreferencesHelper.getInstance().supportSwitchTabGesture || MessageBoxManager.getInstance().isShowing() || !getBrowserFrameLayout().m6470s((int) motionEvent.getX(), (int) motionEvent.getY()) || (iAbs = (int) Math.abs(motionEvent2.getX() - motionEvent.getX())) <= ((int) Math.abs(motionEvent2.getY() - motionEvent.getY())) || iAbs <= this.systemUiVisibility) {
            return false;
        }
        if (motionEvent.getX() < motionEvent2.getX()) {
            getTabManager().m9291O();
            return true;
        }
        if (motionEvent.getX() <= motionEvent2.getX()) {
            return true;
        }
        getTabManager().m9290N();
        return true;
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 == null) {
            return super.onKeyDown(i, keyEvent);
        }
        if (interfaceC1300b3.onKeyDown(i, keyEvent)) {
            return true;
        }
        if (i != 4) {
            if (i == 84) {
                return true;
            }
            if (i == 82) {
                this.activityDelegate.mo6416Y();
                return true;
            }
            if ((i != 25 && i != 24) || !m6362u1()) {
                return false;
            }
            if (keyEvent.getRepeatCount() == 0) {
                keyEvent.startTracking();
            }
            return true;
        }
        if (this.browserFrameLayout.m6461j()) {
            return true;
        }
        getHandler().postDelayed(new FlagClearRunnable(), 3000L);
        if (!interfaceC1300b3.mo1695d().onKeyDown(i, keyEvent)) {
            if (interfaceC1300b3.mo1587z()) {
                interfaceC1300b3.mo1581q();
                return true;
            }
            if (isPreviousTabValid()) {
                m6291a1();
                return true;
            }
            if (getTabManager().getTabCount() > 1) {
                boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("close-tab-in-order", false);
                ContentViewManager.Tab tabVarM9277A = this.tabManager.getActiveTab();
                if (zM6873Q || TextUtils.isEmpty(tabVarM9277A.f6890c) || this.tabManager.m9281E(tabVarM9277A.f6890c) < 0) {
                    this.activityDelegate.mo6431k();
                } else {
                    this.tabManager.m9300X(tabVarM9277A.f6890c);
                    getTabManager().removeTab(tabVarM9277A.getTabId());
                    m6324h3();
                }
                return true;
            }
            if (!this.hasShownExitDialog && !SharedPreferencesHelper.getInstance().showExitConfirmDialog) {
                this.hasShownExitDialog = true;
                Toast.makeText(this, R.string.toast_repeat_to_exit, Toast.LENGTH_SHORT).show();
                return false;
            }
            tryExit();
        }
        return true;
    }

    @Override
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        this.hasResumed = true;
        if (m6362u1()) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
            WebViewBrowserController webViewBrowserController = (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) ? null : (WebViewBrowserController) interfaceC1300b3;
            if (webViewBrowserController != null) {
                if (i == 25) {
                    webViewBrowserController.m6770F0().pageDown(true);
                    return true;
                }
                if (i == 24) {
                    webViewBrowserController.m6770F0().pageUp(true);
                    return true;
                }
            }
        }
        return super.onKeyLongPress(i, keyEvent);
    }

    @Override
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        if (!this.hasResumed && m6362u1()) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
            WebViewBrowserController webViewBrowserController = (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) ? null : (WebViewBrowserController) interfaceC1300b3;
            if (webViewBrowserController != null) {
                if (i == 25) {
                    webViewBrowserController.m6770F0().pageDown(false);
                    return true;
                }
                if (i == 24) {
                    webViewBrowserController.m6770F0().pageUp(false);
                    return true;
                }
            }
        }
        this.hasResumed = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if ((interfaceC1300b3 instanceof WebViewBrowserController) && interfaceC1300b3.mo5626h() == 0) {
            WebView webViewM6770F0 = ((WebViewBrowserController) interfaceC1300b3).m6770F0();
            if (webViewM6770F0 instanceof C0219Ep) {
                C0219Ep c0219Ep = (C0219Ep) webViewM6770F0;
                if (c0219Ep.f554e) {
                    this.browserFrameLayout.showContextMenuForChild(webViewM6770F0);
                    c0219Ep.f555f = true;
                    getHandler().postDelayed(new FlagResetRunnable(c0219Ep), 100L);
                }
            }
        }
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m6306d1(intent);
    }

    @Override
    public void onPause() {
        super.onPause();
        if (!this.isInEditMode) {
            this.isDestroyed = true;
        }
        C1344c1.getInstance().m5700j();
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo1576g();
        }
        C0848Sb.getInstance().savePosition();
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (grantResults.length == 0) {
            return;
        }
        if (requestCode == 256) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED) {
                requestSdcardPermission(getResources().getString(R.string.perm_this_feature));
            }
        } else if (requestCode == 261) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                m6323h2();
            }
        }
        if (requestCode == 258) {
            if (grantResults[0] != PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, R.string.toast_grant_perm_ok, Toast.LENGTH_LONG).show();
            }
        } else if (requestCode == 257) {
            if (grantResults[0] == PackageManager.PERMISSION_DENIED)
                Toast.makeText(this, "request  permit failed ", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(this, R.string.toast_grant_perm_ok, Toast.LENGTH_SHORT).show();
        } else if (requestCode == 262 || requestCode == 263) {
            if (grantResults[0] != PackageManager.PERMISSION_DENIED) {
                PermissionRequest permissionRequest = this.webPermissionRequest;
                if (permissionRequest != null) {
                    permissionRequest.grant(permissionRequest.getResources());
                    this.webPermissionRequest = null;
                }
            }
        } else if (requestCode == 260) {
            if (grantResults[0] != PackageManager.PERMISSION_DENIED) {
                Toast.makeText(this, R.string.toast_grant_perm_ok, Toast.LENGTH_LONG).show();
            }
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        ThemeManager.getInstance().m9478F(this);
        C1344c1.getInstance().m5701k();
        this.isPaused = true;
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo1584u();
        }
        this.isDestroyed = false;
        this.isInEditMode = false;
        if (this.hasOnCreate) {
            m6229L();
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                EventQueueManager.getInstance().processEvent(1);
                return false;
            }
        });
        if (!SharedPreferencesHelper.getInstance().f4849D) {
            getActivityDelegate().m6394C().m1437t();
        }
        handleClipboardUrl(getHandler());
        WebViewBrowserController.f4695K = 0;
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) throws Resources.NotFoundException {
        super.onSaveInstanceState(bundle);
        if (this.isDestroyed) {
            m6379y2();
        }
    }

    @Override
    public boolean onScroll(MotionEvent motionEvent, MotionEvent motionEvent2, float f, float f2) {
        return false;
    }

    @Override
    public void onShowPress(MotionEvent motionEvent) {
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent motionEvent) {
        String strM6234M0 = m6234M0();
        if (!SharedPreferencesHelper.getInstance().disableJavascript || ((WebViewBrowserController) getBrowserController()).m6770F0().getSettings().getJavaScriptEnabled() || TextUtils.isEmpty(strM6234M0) || !(strM6234M0.startsWith("x:") || strM6234M0.startsWith("file:///"))) {
            return false;
        }
        Toast.makeText(this, R.string.toast_local_page_do_not_work_in_disable_js_state, Toast.LENGTH_SHORT).show();
        return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public void onStart() {
        super.onStart();
    }

    @Override
    public void onStop() {
        String strM6234M0;
        String host;
        super.onStop();
        if (!this.isInEditMode) {
            this.isDestroyed = true;
        }
        if (this.isDestroyed && (strM6234M0 = m6234M0()) != null && strM6234M0.startsWith("http") && (host = Uri.parse(strM6234M0).getHost()) != null && SiteSettingsManager.getInstance().m6961c(host)) {
            m6207F1();
        }
    }

    @Override
    public void onSystemUiVisibilityChange(int i) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 != null && interfaceC1300b3.mo5630p(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.isDestroyed = true;
        Log.i("onTrimMemory", "onTrimMemory called level:" + i);
    }

    public void m6346p0(int i) {
        if (i == 2 || i == 4 || i == 128 || i == 256 || i == 16) {
            m6322h1();
        }
        if (i != 16 && i != 64) {
            if (i == 4) {
                getBrowserFrameLayout().setLayoutType(8198);
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    return;
                }
            } else if (i == 256) {
                getBrowserFrameLayout().setLayoutType(8199);
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE) {
                    return;
                }
            } else if (i == 2) {
                getBrowserFrameLayout().setLayoutType(8198);
                if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                    return;
                }
            } else if (i == 128) {
                getBrowserFrameLayout().setLayoutType(8198);
                return;
            } else {
                if (i == 1) {
                    getBrowserFrameLayout().setLayoutType(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
                    if (getRequestedOrientation() == ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
                        return;
                    }
                } else {
                    return;
                }
            }
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
            return;
        }
        getBrowserFrameLayout().setLayoutType(8199);
        if (getRequestedOrientation() != ActivityInfo.SCREEN_ORIENTATION_PORTRAIT) {
            setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        }
    }

    public final void m6347p1() {
        View viewFindViewById = findViewById(android.R.id.content);
        if (viewFindViewById != null) {
            AbstractC0448Jo.m2095x(viewFindViewById, new InterfaceC0625Nh() {
                @Override
                public final C1045Wo mo3322a(View view, C1045Wo c1045Wo) {
                    return m6366v1(view, c1045Wo);
                }
            });
        }
    }

    public void m6348p2(boolean z) {
        String str;
        String str2;
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        if (interfaceC1300b3 != null) {
            String strMo1573b = interfaceC1300b3.getUrlFromTitle();
            if (strMo1573b.indexOf("baidu.com") <= 0 && strMo1573b.indexOf("sogou.com") <= 0 && strMo1573b.indexOf("douban.com") <= 0) {
                interfaceC1300b3.mo5625f();
                return;
            }
            if (z) {
                str = "(m|3g|mobile|wap)\\.";
                str2 = "www.";
            } else {
                str = "(www)\\.";
                str2 = "m.";
            }
            m6307d2(strMo1573b.replaceFirst(str, str2));
        }
    }

    public void m6349q0() {
        JSManager.getInstance().injectJavascript(((WebViewBrowserController) getTabManager().m9316y()).m6770F0(), "mark_ad");
        this.uiLayoutMode = 1;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mark_toolbar_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = (LinearLayout) ThemeManager.getInstance().m9488i();
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_expand)).setOnClickListener(view -> {
            updateTitle("selectParent()");
            if (SharedPreferencesHelper.getInstance().getBoolean("log_mark_ad", false)) {
                m6195C1();
            }
        });
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_reduce)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTitle("selectChild()");
            }
        });
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_save)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                updateTitle("exportABPRule()");
                updateTitle("hideSelectedElement()");
            }
        });
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_exit)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                m6377y0();
            }
        });
        linearLayout.addView(linearLayout2, layoutParams);
        getBrowserFrameLayout().m6465n();
        m6189B();
    }

    public void m6350q1(String str) {
        runOnUiThread(new WebViewScriptRunnable(str));
    }

    public void m6351q2(String str, String itemId) {
        MySQLiteOpenHelper.getInstance().m7494G0(str);
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                JSONObject jSONObject = new JSONObject();
                try {
                    jSONObject.put("transId", "delete_history_item");
                    jSONObject.put("id", itemId);
                } catch (Exception ignored) {
                }
                C1199a3.getInstance().m5094e("event_app_to_page", jSONObject);
            }
        });
    }

    public void m6352r0(boolean z, boolean z2) {
        if (z2) {
            SharedPreferencesHelper.getInstance().putBoolean("enter-night-mode", z);
        }
        Window window = getWindow();
        if (z) {
            window.setBackgroundDrawableResource(R.drawable.black);
            ThemeManager.getInstance().m9481b(this, "dark");
            SharedPreferencesHelper.getInstance().enterNightMode = true;
            SharedPreferencesHelper.getInstance().m6904l();
            setScreenBrightness(SharedPreferencesHelper.getInstance().f4872O0 ? SharedPreferencesHelper.getInstance().nightBrightness : -1);
        } else {
            window.setBackgroundDrawableResource(R.drawable.white);
            ThemeManager.getInstance().m9481b(this, "light");
            SharedPreferencesHelper.getInstance().enterNightMode = false;
            SharedPreferencesHelper.getInstance().loadGoodForEyeColor();
            setScreenBrightness(-1);
            SyncManager.getInstance().getResourceManager("syncable_setting").incrementVersion();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            m6193C(z);
        }
        m6298b3();
        m6280X2();
        updateTitle("document.dispatchEvent(new CustomEvent('themechange'))");
    }

    public void m6353r1(String str) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.tabManager.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            JSManager.getInstance().evaluateJavascript(((WebViewBrowserController) interfaceC1300b3).m6770F0(), str);
        }
    }

    public void m6354r2() {
        String strM6234M0 = m6234M0();
        if (TextUtils.isEmpty(strM6234M0)) {
            return;
        }
        new DialogC0076Bk(this, strM6234M0).show();
    }

    public void m6355s0(boolean z) {
        m6357t0(z, true);
    }

    public void installApk(Uri apkUri) {
        runOnUiThread(new Runnable() {
            @Override
            public void run() throws Resources.NotFoundException {
                // Get the necessary strings for the message
                String installMessage = String.format(
                        BrowserActivity.getActivity().getResources().getString(R.string.message_request_install_unknown_source),
                        getString(R.string.app_name)
                );
                String setButtonText = BrowserActivity.getActivity().getResources().getString(R.string.btn_text_set);
                String denyButtonText = BrowserActivity.getActivity().getResources().getString(R.string.btn_text_deny);

                // Set the Uri for pending APK
                pendingApkUri = apkUri;

                // Show the message box with appropriate listener actions
                MessageBoxManager.getInstance().showMessage(
                        BrowserActivity.getActivity().getBrowserFrameLayout(),
                        null,
                        installMessage,
                        setButtonText,
                        denyButtonText,
                        new MessageBoxBase.MessageBoxListener() {
                            @Override
                            public void onShown() {
                                // If the user presses "Set", open the settings to manage unknown app sources
                                startActivityForResult(
                                        new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES",
                                                Uri.parse("package:" + getPackageName())),
                                        259
                                );
                            }

                            @Override
                            public void onDismissed() {
                                // If the user presses "Deny", start the APK installation
                                Intent installIntent = new Intent("android.intent.action.VIEW");
                                installIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                                installIntent.setDataAndType(apkUri, "application/vnd.android.package-archive");
                                startActivity(installIntent);
                            }

                            @Override
                            public void onDismiss() {
                                // You can add any necessary action if needed on dismiss (currently empty)
                            }
                        },
                        true
                );
            }
        });
    }

    public void m6357t0(boolean z, boolean z2) {
        if (z2) {
            SharedPreferencesHelper.getInstance().enterPrivateMode = z;
            SharedPreferencesHelper.getInstance().putBoolean("enter-private-mode", z);
            int iM9280D = getTabManager().getTabCount();
            for (int i = 0; i < iM9280D; i++) {
                ArrayList arrayListM9279C = getTabManager().m9279C(i);
                for (int i2 = 0; i2 < arrayListM9279C.size(); i2++) {
                    InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) arrayListM9279C.get(i2);
                    if (interfaceC1300b3 != null && (interfaceC1300b3 instanceof WebViewBrowserController)) {
                        WebView webViewM6770F0 = ((WebViewBrowserController) interfaceC1300b3).m6770F0();
                        SharedPreferencesHelper sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                        WebSettings settings = webViewM6770F0.getSettings();
                        if (z) {
                            sharedPreferencesHelperM6833I.m6924v(settings);
                        } else {
                            sharedPreferencesHelperM6833I.m6925v0(settings);
                        }
                    }
                }
            }
        } else {
            InterfaceC1300b3 interfaceC1300b32 = (InterfaceC1300b3) getTabManager().m9316y();
            if (interfaceC1300b32 != null && (interfaceC1300b32 instanceof WebViewBrowserController)) {
                WebView webViewM6770F02 = ((WebViewBrowserController) interfaceC1300b32).m6770F0();
                SharedPreferencesHelper sharedPreferencesHelperM6833I2 = SharedPreferencesHelper.getInstance();
                WebSettings settings2 = webViewM6770F02.getSettings();
                if (z) {
                    sharedPreferencesHelperM6833I2.m6924v(settings2);
                } else {
                    sharedPreferencesHelperM6833I2.m6925v0(settings2);
                }
            }
        }
        getActivityDelegate().m6394C().m1441x(z);
    }

    public boolean m6358t1(String str) {
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("bookmark", DatabaseColumns.BOOKMARK, "url= ? AND status>= ?", new String[]{str, "0"}, null, null, null);
        if (cursorQuery == null) {
            return false;
        }
        try {
            return cursorQuery.moveToFirst();
        } finally {
            cursorQuery.close();
        }
    }

    public void requestSdcardPermission(String feature) {
        runOnUiThread(() -> MessageBoxManager.getInstance().showMessage(
                BrowserActivity.getActivity().getBrowserFrameLayout(),
                null,
                String.format(BrowserActivity.getActivity().getResources().getString(R.string.message_request_sd), feature),
                BrowserActivity.getActivity().getResources().getString(R.string.btn_text_set),
                BrowserActivity.getActivity().getResources().getString(R.string.btn_text_deny),
                new MessageBoxBase.MessageBoxListener() {
                    @Override
                    public void onShown() {
                        Intent intent = new Intent("android.settings.APPLICATION_DETAILS_SETTINGS");
                        intent.setData(Uri.parse("package:" + getPackageName()));
                        startActivity(intent);
                    }

                    @Override
                    public void onDismissed() {
                        SharedPreferencesHelper.getInstance().putBoolean("confirm_not_allow_sd", true);
                    }

                    @Override
                    public void onDismiss() {
                    }
                },
                true));
    }

    public void m6360u() {
        this.isInEditMode = true;
        runOnUiThread(new SearchBarLaunchRunnable());
    }

    public void updateTitle(String str) {
        runOnUiThread(new PageTitleUpdateRunnable(str));
    }

    public final boolean m6362u1() {
        return SharedPreferencesHelper.getInstance().supportVolumePageDown && getResources().getConfiguration().orientation == 1;
    }

    public void m6363u2() {
        AbsBrowserController controller = getBrowserController();
        if (controller instanceof WebViewBrowserController) {
            ((WebViewBrowserController) controller).m6791a1();
        }
    }

    public final void m6364v(String str) {
        BrowserControllerListener delegate = getActivityDelegate();
        if (delegate instanceof InterfaceC0575Md) {
            ((InterfaceC0575Md) delegate).mo2860c(str);
            getActivity().getBrowserFrameLayout().requestFocus();
        }
    }

    public void m6365v0() {
        this.uiLayoutMode = 0;
        getBrowserFrameLayout().m6466o(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
    }

    public final C1045Wo m6366v1(View view, C1045Wo c1045Wo) {
        m6310e1(c1045Wo.m4549f(C1045Wo.m.m4604h()), c1045Wo.m4549f(C1045Wo.m.m4600d()));
        m6197D(c1045Wo);
        return C1045Wo.f3118b;
    }

    public final void m6367v2() throws Resources.NotFoundException {
        SharedPreferences sharedPreferencesM6278X0 = m6278X0();
        if (SharedPreferencesHelper.getInstance().recoveryTabType == 0) {
            if ((!SharedPreferencesHelper.getInstance().enterPrivateMode || SharedPreferencesHelper.getInstance().normalExit) && SharedPreferencesHelper.getInstance().enterPrivateMode) {
                return;
            }
            this.tabManager.restoreUserData(sharedPreferencesM6278X0);
            return;
        }
        if (SharedPreferencesHelper.getInstance().recoveryTabType != 1 || SharedPreferencesHelper.getInstance().enterPrivateMode) {
            return;
        }
        int i = sharedPreferencesM6278X0.getInt("num_tabs", 1);
        if (i == 1) {
            if (sharedPreferencesM6278X0.getString("last-active-tab-url", "").indexOf("x:home") >= 0) {
                return;
            }
        } else {
            if (i <= 1) {
                return;
            }
        }
        m6248P2();
    }

    public void m6368w(String str, String str2, String str3, boolean z) {
        m6372x(str, str2, str3, z, false);
    }

    public void tryExit() {
        setNormalExit(true);
        if (SharedPreferencesHelper.getInstance().showExitConfirmDialog) {
            new ExitConfirmDialog(this) {
                @Override
                public void onCancel() {
                }

                @Override
                public void onOK() {
                    finish();
                }
            }.show();
        } else {
            finish();
        }
    }

    public final C1045Wo m6370w1(View view, C1045Wo c1045Wo) {
        if (m6201E(c1045Wo)) {
            m6197D(c1045Wo);
        } else {
            updateContentLayoutPadding();
        }
        return C1045Wo.f3118b;
    }

    public void m6371w2() {
        while (this.activeControllers.size() > 0) {
            m6375x2();
        }
    }

    public void m6372x(String str, String str2, String str3, boolean z, boolean z2)  {
        if (TextUtils.isEmpty(str) && !z2) {
            Toast.makeText(this, "title not allow empty", Toast.LENGTH_SHORT).show();
        } else {
            if (!TextUtils.isEmpty(str2) || z2) {
                if (!str2.toLowerCase().startsWith("http") && !str2.startsWith("x:") && !str2.startsWith("file://") && !z && !str2.startsWith("javascript:") && !str2.startsWith("data:")) {
                    str2 = "http://" + str2;
                }
                SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
                if (MySQLiteOpenHelper.getInstance().m7542x0(writableDatabase, str2)) {
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("status", (Integer) 1);
                    contentValues.put("title", str);
                    contentValues.put("parent", str3);
                    contentValues.put("last_visit", Long.valueOf(System.currentTimeMillis()));
                    writableDatabase.update("bookmark", contentValues, "url= ?", new String[]{str2});
                } else {
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("title", str);
                    contentValues2.put("url", str2);
                    contentValues2.put("status", (Integer) 1);
                    contentValues2.put("parent", str3);
                    contentValues2.put("type", Integer.valueOf(z ? 1 : 0));
                    contentValues2.put("last_visit", Long.valueOf(System.currentTimeMillis()));
                    contentValues2.put("item_order", Integer.valueOf(MySQLiteOpenHelper.getInstance().getMaxColumnValue(writableDatabase, "bookmark", "item_order", "")));
                    getContentResolver().insert(BrowserProvider.uriBookmark, contentValues2);
                }
                if (!z2) {
                    Toast.makeText(this, z ? R.string.toast_add_bm_dir : R.string.toast_add_to_bm, Toast.LENGTH_SHORT).show();
                }
                m6255R1(str, str2, str3);
                SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
            }
            Toast.makeText(this, "url not allow empty", Toast.LENGTH_SHORT).show();
        }
        m6255R1(str, str2, str3);
        SyncManager.getInstance().getResourceManager("syncable_bookmark").incrementVersion();
    }

    public void m6373x0() {
        getHandler().postDelayed(() -> {
            uiLayoutMode = 0;
            getBrowserFrameLayout().m6466o(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
            C1199a3.getInstance().m5093d("event_app_to_page", "exit_edit_mode");
        }, 200L);
    }

    public void openDownloads() {
        try {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.Q) {
                openFilePicker();
            } else {
                openDownloadsFolder();
            }
        } catch (Exception e) {
            // Optionally, log the error
            Log.e("DownloadIntent", "Failed to open downloads", e);
        }
    }

    @RequiresApi(api = Build.VERSION_CODES.Q)
    private void openFilePicker() {
        Intent intent = new Intent(Intent.ACTION_GET_CONTENT);
        Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        intent.addCategory(Intent.CATEGORY_OPENABLE);
        intent.setDataAndType(uri, "*/*");
        startActivityForResult(intent, 72);
    }

    private void openDownloadsFolder() {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setDataAndType(Uri.parse("content://downloads/public_downloads"), "*/*");
        startActivity(intent);
    }

    public void m6375x2() {
        if (this.activeControllers.size() > 0) {
            openUrl(activeControllers.remove(activeControllers.size() - 1), true, 0);
            m6324h3();
        }
    }

    public void m6376y(String str, String str2, int i) {
        addQuickAccessItem(AndroidSystemUtils.getSId(), str, str2, i);
    }

    public void m6377y0() {
        this.uiLayoutMode = 0;
        getBrowserFrameLayout().m6466o(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
        ContentDataManager.getInstance().m6636q(true);
        updateTitle("exitSelectionMode()");
        m6189B();
    }

    public void m6378y1(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) getTabManager().m9316y();
        String strMo1573b = interfaceC1300b3.getUrlFromTitle();
        if (this.uiLayoutMode == 1) {
            m6377y0();
            return;
        }
        if (!strMo1573b.startsWith("http") || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            Toast.makeText(this, R.string.toast_current_page_not_support_ad_mark, Toast.LENGTH_SHORT).show();
            return;
        }
        m6349q0();
        if (i == 0) {
            C2363t3.getInstance().m9673i(17, false);
        }
    }

    public void m6379y2() throws Resources.NotFoundException {
        AndroidSystemUtils.startTiming("save-tabs");
        this.tabManager.m9297U(m6278X0());
        AndroidSystemUtils.logElapsedTime();
        Log.i("save-state", " >>>>>call on save Instance");
        BackgroundTaskManager.submitBackgroundTask(new Runnable() {
            @Override
            public void run() {
                EventQueueManager.getInstance().processEvent(2);
            }
        });
        SharedPreferencesHelper.getInstance().f4899d0 = false;
        Log.i("save-state", " >>>>> on save Instance finished >>>>>>  ");
        ContentDataManager.getInstance().m6621i1();
    }

    public void addQuickAccessItem(String title, String url, String rawUrl, int itemType) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(title)) {
            showToast("title not allow empty");
            return;
        }

        if (TextUtils.isEmpty(rawUrl)) {
            showToast("url not allow empty");
            return;
        }

        String finalUrl = processUrl(rawUrl);

        SQLiteDatabase db = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        ContentValues contentValues = createContentValues(title, finalUrl, itemType);

        if (MySQLiteOpenHelper.getInstance().isUrlInQuickAccess(db, finalUrl)) {
            db.update("quick_access", contentValues, "url= ?", new String[]{finalUrl});
        } else {
            db.insert("quick_access", null, contentValues);
        }

        showToast(R.string.toast_add_new_quick_access);
        incrementSyncVersion();
    }

    private String processUrl(String url) {
        if (!url.toLowerCase().startsWith("http") && !url.startsWith("x:") && !url.startsWith("file://")) {
            return "http://" + url.trim();
        }
        return url;
    }

    private ContentValues createContentValues(String title, String url, int itemType) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", title);
        contentValues.put("url", url);
        contentValues.put("create_at", System.currentTimeMillis());
        contentValues.put("item_type", itemType);
        contentValues.put("parent", "root");
        contentValues.put("status", 0); // Default status
        contentValues.put("item_order", getMaxItemOrder());
        return contentValues;
    }

    private int getMaxItemOrder() {
        SQLiteDatabase db = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        return MySQLiteOpenHelper.getInstance().getMaxColumnValue(db, "quick_access", "item_order", "");
    }

    public void m6381z0() {
        C1039Wi.m4517p().m4521m();
        getActivityDelegate().mo6431k();
    }

    public void m6382z1() {
        if (!m6285Z("android.permission.CAMERA")) {
            new QrScannerDialog(this).show(getString(R.string.message_permission_request), getString(R.string.message_request_perm_camera_for_qrcode));
            return;
        }
        ScanOption option = new ScanOption(this);
        option.setFormats("QR_CODE");
        option.lockOrientation(false);
        option.setRequestCode(32);
        option.setClass(QrScanActivity.class);
        option.start();
    }

    public void saveBookmarkWithTabs(String folderName) {
        String folderPath = "/" + folderName;
        try {
            ArrayList<ContentViewManager.Tab> tabList = getTabManager().getTabList();

            if (isBookmarkAlreadySaved(folderPath)) {
                deleteBookmark(folderPath);
            } else {
                addBookmark(folderName, folderPath);
            }

            saveTabsToBookmarks(tabList, folderPath);

            MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("bookmark", false);
            showTabsSavedToast(tabList.size());
        } catch (Exception e) {
            // Handle the exception or log it if needed
            Log.e("BookmarkError", "Error saving bookmark with tabs", e);
        }
    }

    private boolean isBookmarkAlreadySaved(String folderPath) {
        return m6358t1(folderPath); // checks if the bookmark already exists
    }

    private void deleteBookmark(String folderPath) {
        MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("bookmark", "parent= ?", new String[]{folderPath});
    }

    private void addBookmark(String folderName, String folderPath) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("title", folderName);
        contentValues.put("url", folderPath);
        contentValues.put("parent", "/");
        contentValues.put("type", 1);
        contentValues.put("last_visit", System.currentTimeMillis());
        contentValues.put("status", 1);
        MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
    }

    private void saveTabsToBookmarks(ArrayList<ContentViewManager.Tab> tabList, String folderPath) {
        for (ContentViewManager.Tab tab : tabList) {
            InterfaceC1300b3 tabInterface = (InterfaceC1300b3) tab.m9333l();
            if (tabInterface != null) {
                String tabTitle = tabInterface.mo1574c();
                String tabUrl = tabInterface.getUrlFromTitle();

                if (!tabUrl.contains("_tab-id_")) {
                    tabUrl = NetworkUtils.appendQueryParam(tabUrl, "_tab-id_=" + tab.getTabId());
                }

                ContentValues tabContentValues = new ContentValues();
                tabContentValues.put("title", tabTitle);
                tabContentValues.put("url", tabUrl);
                tabContentValues.put("parent", folderPath);
                tabContentValues.put("type", 0);
                tabContentValues.put("last_visit", System.currentTimeMillis());
                tabContentValues.put("status", 1);
                MySQLiteOpenHelper.getInstance().addPendingEntry(tabContentValues);
            }
        }
    }

    private void showTabsSavedToast(int tabCount) {
        String message = String.format(getString(R.string.toast_all_tabs_saved), tabCount);
        Toast.makeText(this, message, Toast.LENGTH_LONG).show();
    }
}
