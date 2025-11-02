package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
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

import com.google.firebase.analytics.FirebaseAnalytics;
import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.controllers.AbsBrowserController;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.mmbox.xbrowser.provider.BrowserProvider;
import com.mmbox.xbrowser.searchbox.SuggestionInputAdapter;
import com.xbrowser.play.R;

import java.io.File;
import java.io.IOException;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Locale;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import org.json.JSONException;
import org.json.JSONObject;

import p000.NetworkUtils;
import p000.AbstractC0448Jo;
import p000.FileUtils;
import p000.SystemUiCompat;
import p000.DatabaseColumns;
import p000.AbstractC1807h2;
import p000.AndroidSystemUtils;
import p000.AbstractC2129o0;
import p000.AbstractC2274r6;
import p000.AbstractC2320s6;
import p000.AbstractDialogC0296Ga;
import p000.AbstractDialogC1303b6;
import p000.AbstractViewOnClickListenerC0802Rb;
import p000.AbstractViewOnClickListenerC1638da;
import p000.C0022Ac;
import p000.C0024Ae;
import p000.C0219Ep;
import p000.C0310Go;
import p000.C0356Ho;
import p000.ResourceCacheManager;
import p000.C0461K0;
import p000.C0462K1;
import p000.C0600N1;
import p000.C0801Ra;
import p000.C0848Sb;
import p000.C0896Td;
import p000.C0988Vd;
import p000.C1039Wi;
import p000.C1045Wo;
import p000.C1089Xm;
import p000.C1199a3;
import p000.C1224ai;
import p000.PhoneUtils;
import p000.C1344c1;
import p000.C1346c3;
import p000.C1621d3;
import p000.C1651dn;
import p000.C1697en;
import p000.MySQLiteOpenHelper;
import p000.C1825ha;
import p000.C2061mf;
import p000.ThemeManager;
import p000.C2337se;
import p000.C2363t3;
import p000.C2390tl;
import p000.SystemUiController;
import p000.C2406u0;
import p000.C2439uo;
import p000.C2564xb;
import p000.DialogC0076Bk;
import p000.DialogC0143D4;
import p000.DialogC0465K4;
import p000.DialogC0812Rl;
import p000.DialogC2544x0;
import p000.DialogC2590y0;
import p000.InterfaceC0299Gd;
import p000.InterfaceC0345Hd;
import p000.InterfaceC0575Md;
import p000.InterfaceC0625Nh;
import p000.InterfaceC1300b3;
import p000.ViewOnClickListenerC0166Di;
import p000.ViewOnClickListenerC1156Z6;

public class BrowserActivity extends Activity implements AbstractC2274r6.c, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener, View.OnSystemUiVisibilityChangeListener {

    public static final ExecutorService backgroundExecutor = Executors.newSingleThreadExecutor();

    public static BrowserActivity activity = null;

    public String currentUserAgent;

    public ValueCallback fileUploadCallback;

    public Uri cameraPhotoUri;

    public PermissionRequest webPermissionRequest;

    public View decorView;

    public int systemUiVisibility;

    public C0022Ac touchEventDispatcher;

    public GestureDetector gestureDetector;

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

    public C1346c3 tabManager = null;

    public C1621d3 menuController = null;

    public BrowserFrameLayout browserFrameLayout = null;

    public final Handler handler = new Handler();

    public final ArrayList activeControllers = new ArrayList<>(3);

    public PullToRefreshHandler pullToRefreshHandler = null;

    public String lastNavigatedUrl = "";

    public String lastPageTitle = "";

    public int[] screenDimensions = null;

    public int textFitWidth = -1;

    public int textFitHeight = -1;

    public Object lockObject = null;

    public final Runnable unusedRunnable = null;

    public long lastActionTimestamp = 0;

    public final Runnable textAutoFitRunnable = new Runnable() {
        @Override
        public void run() {
            m6361u0("_XJSAPI_.text_auto_fit(" + textFitWidth + "," + textFitHeight + ")");
        }
    };

    public class ApkInstallPermissionRunnable implements Runnable {

        public final Uri apkUri;

        public ApkInstallPermissionRunnable(Uri uri) {
            this.apkUri = uri;
        }

        @Override
        public void run() throws Resources.NotFoundException {
            String str = String.format(BrowserActivity.getActivity().getResources().getString(R.string.message_request_install_unknown_source), getString(R.string.app_name));
            String string = BrowserActivity.getActivity().getResources().getString(R.string.btn_text_set);
            String string2 = BrowserActivity.getActivity().getResources().getString(R.string.btn_text_deny);
            f4272s = this.apkUri;
            MessageBoxManager.getInstance().showMessage(BrowserActivity.getActivity().getBrowserFrameLayout(), null, str, string, string2, new MessageBoxBase.MessageBoxListener() {
                @Override
                public void onShown() {
                    startActivityForResult(new Intent("android.settings.MANAGE_UNKNOWN_APP_SOURCES", Uri.parse("package:" + getPackageName())), 259);
                }

                @Override
                public void onDismissed() {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setFlags(1);
                    intent.setDataAndType(apkUri, "application/vnd.android.package-archive");
                    startActivity(intent);
                }

                @Override
                public void onDismiss() {
                }
            }, true);
        }
    }

    public class SdCardPermissionRunnable implements Runnable {

        public final String permission;

        public class PermissionSettingsListener implements MessageBoxBase.MessageBoxListener {
            public PermissionSettingsListener() {
            }

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
        }

        public SdCardPermissionRunnable(String str) {
            this.permission = str;
        }

        @Override
        public void run() throws Resources.NotFoundException {
            MessageBoxManager.getInstance().showMessage(BrowserActivity.getActivity().getBrowserFrameLayout(), null, String.format(BrowserActivity.getActivity().getResources().getString(R.string.message_request_sd), this.permission), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_set), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_deny), new PermissionSettingsListener(), true);
        }
    }

    public class ModuleLoadFailureRunnable implements Runnable {

        public final String moduleId;

        public class ModuleRetryListener implements MessageBoxBase.MessageBoxListener {

            public class ModuleDownloadRunnable implements Runnable {
                public ModuleDownloadRunnable() {
                }

                @Override
                public void run() {
                    C2061mf.m8471f0().m8505N(ModuleLoadFailureRunnable.this.moduleId);
                    ModuleLoadFailureRunnable runnableC1434D = ModuleLoadFailureRunnable.this;
                    m6187A1(runnableC1434D.moduleId);
                }
            }

            public ModuleRetryListener() {
            }

            @Override
            public void onShown() {
                Toast.makeText(BrowserActivity.this, R.string.toast_loading_module, Toast.LENGTH_LONG).show();
                AbstractC1807h2.m7778a(new ModuleDownloadRunnable());
            }

            @Override
            public void onDismissed() {
                SharedPreferencesHelper.getInstance().putBoolean("confirm_not_allow_sd", true);
            }

            @Override
            public void onDismiss() {
            }
        }

        public ModuleLoadFailureRunnable(String str) {
            this.moduleId = str;
        }

        @Override
        public void run() throws Resources.NotFoundException {
            MessageBoxManager.getInstance().showMessage(BrowserActivity.getActivity().getBrowserFrameLayout(), null, BrowserActivity.getActivity().getResources().getString(R.string.toast_load_module_failed), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_ok), BrowserActivity.getActivity().getResources().getString(R.string.btn_text_cancel), new ModuleRetryListener(), true);
        }
    }

    public class BookmarkAddedListener implements MessageBoxBase.MessageBoxListener {

        public final String bookmarkId;

        public BookmarkAddedListener(String str) {
            this.bookmarkId = str;
        }

        @Override
        public void onShown() {
            C1825ha.m7824d().m7831h(System.currentTimeMillis(), 22, this.bookmarkId, null);
            C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }

    public class UrlDeleteListener implements MessageBoxBase.MessageBoxListener {

        public final String url;

        public UrlDeleteListener(String str) {
            this.url = str;
        }

        @Override
        public void onShown() {
            C2439uo.getInstance().m10213K(this.url);
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }

    public class TrafficStrategyInitRunnable implements Runnable {
        public TrafficStrategyInitRunnable() {
        }

        @Override
        public void run() {
            m6257S(SharedPreferencesHelper.getInstance().getInt("save_traffic_strategy", 0));
            BrowserDownloadManager.m6674q().m6692h();
        }
    }

    public class OfflineFilesOpenListener implements MessageBoxBase.MessageBoxListener {
        public OfflineFilesOpenListener() {
        }

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
    }

    public class DownloadDeleteListener implements MessageBoxBase.MessageBoxListener {

        public final String downloadPath;

        public DownloadDeleteListener(String str) {
            this.downloadPath = str;
        }

        @Override
        public void onShown() {
            BrowserDownloadManager.m6674q().m6709z(this.downloadPath);
        }

        @Override
        public void onDismissed() {
        }

        @Override
        public void onDismiss() {
        }
    }

    public class DarkModeNotificationRunnable implements Runnable {

        public class DarkModeSettingsListener implements MessageBoxBase.MessageBoxListener {
            public DarkModeSettingsListener() {
            }

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
        }

        public DarkModeNotificationRunnable() {
        }

        @Override
        public void run() throws Resources.NotFoundException {
            if (SharedPreferencesHelper.getInstance().getBoolean("notify_flow_system_dark_mode", true)) {
                MessageBoxManager.getInstance().showMessage(BrowserActivity.getActivity().getBrowserFrameLayout(), null, getResources().getString(R.string.message_follow_dark_mode), getResources().getString(R.string.btn_text_apply), getResources().getString(R.string.btn_text_cancel), new DarkModeSettingsListener(), true);
            }
        }
    }

    public class ParentElementSelectorListener implements View.OnClickListener {
        public ParentElementSelectorListener() {
        }

        @Override
        public void onClick(View view) {
            m6361u0("selectParent()");
            if (SharedPreferencesHelper.getInstance().getBoolean("log_mark_ad", false)) {
                m6195C1();
            }
        }
    }

    public class ChildElementSelectorListener implements View.OnClickListener {
        public ChildElementSelectorListener() {
        }

        @Override
        public void onClick(View view) {
            m6361u0("selectChild()");
        }
    }

    public class ElementHiderListener implements View.OnClickListener {
        public ElementHiderListener() {
        }

        @Override
        public void onClick(View view) {
            m6361u0("exportABPRule()");
            m6361u0("hideSelectedElement()");
        }
    }

    public class CloseEditModeListener implements View.OnClickListener {
        public CloseEditModeListener() {
        }

        @Override
        public void onClick(View view) {
            m6377y0();
        }
    }

    public class ItemSelectionTrackerListener implements View.OnClickListener {
        public ItemSelectionTrackerListener() {
        }

        @Override
        public void onClick(View view) throws JSONException {
            C1199a3.m5090f().m5093d("event_app_to_page", "select_or_deselect_items");
        }
    }

    public class DeleteConfirmationListener implements View.OnClickListener {

        public class DeleteConfirmDialog extends AbstractDialogC1303b6 {
            public DeleteConfirmDialog(Context context) {
                super(context);
            }

            @Override
            public void mo315b() {
            }

            @Override
            public void mo316c() throws JSONException {
                C1199a3.m5090f().m5093d("event_app_to_page", "delete_selected_items");
            }
        }

        public DeleteConfirmationListener() {
        }

        @Override
        public void onClick(View view) {
            new DeleteConfirmDialog(BrowserActivity.this).m5643d(getString(R.string.batch_del_title), getString(R.string.del_select_item_confrim));
        }
    }

    public class ItemCutListener implements View.OnClickListener {
        public ItemCutListener() {
        }

        @Override
        public void onClick(View view) throws JSONException {
            m6373x0();
            C1199a3.m5090f().m5093d("event_app_to_page", "cut_selected_items");
        }
    }

    public class ReadModeActivationRunnable implements Runnable {
        public ReadModeActivationRunnable() {
        }

        @Override
        public void run() {
            Log.i("toolbar", " set state to readmode...");
            m6218I0().m6394C().m1429l(3);
        }
    }

    public class ExitSelectionListener implements View.OnClickListener {
        public ExitSelectionListener() {
        }

        @Override
        public void onClick(View view) {
            m6373x0();
        }
    }

    public class ExitEditModeRunnable implements Runnable {
        public ExitEditModeRunnable() {
        }

        @Override
        public void run() throws JSONException {
            BrowserActivity browserActivity = BrowserActivity.this;
            browserActivity.f4264k = 0;
            browserActivity.getBrowserFrameLayout().m6466o(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
            C1199a3.m5090f().m5093d("event_app_to_page", "exit_edit_mode");
        }
    }

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
            f4252N = System.currentTimeMillis();
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

    public class VideoSniffingAcceptDialog extends AbstractViewOnClickListenerC1638da {

        public final boolean enableSniffing;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public VideoSniffingAcceptDialog(BrowserActivity browserActivity, String str, String str2, boolean z) {
            super(browserActivity, str, str2);
            this.enableSniffing = z;
        }

        @Override
        public String mo6384c() {
            return "已了解";
        }

        @Override
        public void mo6385d() {
            SharedPreferencesHelper.getInstance().putBoolean("first-sniff-media", false);
            SharedPreferencesHelper.getInstance().putBoolean("accept-sniff-media", true);
            VideoSniffingManager.getInstance().m7001k(this.enableSniffing);
        }

        @Override
        public void mo6386e() {
        }

        @Override
        public void mo6387f(URLSpan uRLSpan) {
            dismiss();
            openUrl(uRLSpan.getURL(), true, 0);
        }
    }

    public class InitializationRunnable implements Runnable {
        public InitializationRunnable() {
        }

        @Override
        public void run() {
            m6198D0();
        }
    }

    public class QrScannerDialog extends AbstractDialogC1303b6 {
        public QrScannerDialog(Context context) {
            super(context);
        }

        @Override
        public void mo315b() {
        }

        @Override
        public void mo316c() {
            C0024Ae c0024Ae = new C0024Ae(BrowserActivity.this);
            c0024Ae.m129i("QR_CODE");
            c0024Ae.m130j(false);
            c0024Ae.m131k(32);
            c0024Ae.m128h(QrScanActivity.class);
            c0024Ae.m127f();
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

    public class EmptyConfirmDialog extends AbstractViewOnClickListenerC0802Rb {
        public EmptyConfirmDialog(BrowserActivity browserActivity) {
            super(browserActivity);
        }

        @Override
        public void mo3815c() {
        }
    }

    public class InitializationIdleHandler implements MessageQueue.IdleHandler {
        public InitializationIdleHandler() {
        }

        @Override
        public boolean queueIdle() {
            C1825ha.m7824d().m7828e(0);
            return false;
        }
    }

    public class EulaAcceptDialog extends AbstractViewOnClickListenerC1638da {

        public class FraudAlertDismissRunnable implements Runnable {
            public FraudAlertDismissRunnable() {
            }

            @Override
            public void run() {
                SharedPreferencesHelper.getInstance().putBoolean("show_fraud_alert", false);
                m6198D0();
            }
        }

        public EulaAcceptDialog(BrowserActivity browserActivity) {
            super(browserActivity);
        }

        @Override
        public void mo6385d() {
            SharedPreferencesHelper.getInstance().acceptEula = true;
            SharedPreferencesHelper.getInstance().putBoolean("accept-eula", true);
            if (PhoneUtils.getInstance().isInChina()) {
                getHandler().postDelayed(new FraudAlertDismissRunnable(), 1000L);
            }
        }
    }

    public class GestureCallback implements GestureDetector.a {
        @Override
        public void mo6388a(String str) {
            if (str.equals("LDR")) {
                m6218I0().mo6431k();
            } else if (str.equals("RDL")) {
                m6375x2();
            } else if (str.equals("URD")) {
                m6218I0().m6434s();
            }
        }
    }

    public class TouchEventHandler implements BrowserFrameLayout.InterfaceC1510m {
        @Override
        public boolean mo6389a(MotionEvent motionEvent) {
            f4273t.m116a(motionEvent);
            if (!SharedPreferencesHelper.getInstance().supportQuickGesture) {
                return false;
            }
            f4274u.m7063c(motionEvent);
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

    public class BrightnessAdjustmentRunnable implements Runnable {

        public final int brightnessValue;

        public BrightnessAdjustmentRunnable(int i) {
            this.brightnessValue = i;
        }

        @Override
        public void run() {
            float f;
            WindowManager.LayoutParams attributes = getWindow().getAttributes();
            if (this.brightnessValue >= 0) {
                f = (SharedPreferencesHelper.getInstance().enterNightMode ? this.brightnessValue * 0.5f : this.brightnessValue) * 0.003921569f;
            } else {
                f = -1.0f;
            }
            attributes.screenBrightness = f;
            getWindow().setAttributes(attributes);
        }
    }

    public class SearchBarPositionRunnable implements Runnable {

        public final String position;

        public SearchBarPositionRunnable(String str) {
            this.position = str;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x005d  */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() {
            /*
                r4 = this;
                com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                int r0 = r0.m6845B()
                java.lang.String r1 = r4.position
                java.lang.String r2 = "search-bar-at-top"
                boolean r1 = r1.equals(r2)
                r2 = 8192(0x2000, float:1.148E-41)
                if (r1 == 0) goto L24
                r0 = r0 & r2
                if (r0 != r2) goto L1f
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                r1 = 12289(0x3001, float:1.722E-41)
            L1b:
                r0.m6253R(r1)
                goto L45
            L1f:
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                r1 = 4097(0x1001, float:5.741E-42)
                goto L1b
            L24:
                java.lang.String r1 = r4.position
                java.lang.String r3 = "search-bar-at-bottom"
                boolean r1 = r1.equals(r3)
                if (r1 == 0) goto L45
                r0 = r0 & r2
                if (r0 != r2) goto L40
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                r1 = 12290(0x3002, float:1.7222E-41)
                r0.m6253R(r1)
                com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                r1 = 1
                r0.f4914l = r1
                goto L45
            L40:
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                r1 = 4098(0x1002, float:5.743E-42)
                goto L1b
            L45:
                com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                boolean r0 = r0.f4914l
                if (r0 == 0) goto L5d
                com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                boolean r0 = r0.f4916m
                if (r0 == 0) goto L5d
                Sb r0 = p000.C0848Sb.m4048n()
                r0.m4052r()
                goto L64
            L5d:
                Sb r0 = p000.C0848Sb.m4048n()
                r0.m4049o()
            L64:
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                com.mmbox.xbrowser.BrowserActivity.m6181r(r0)
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                r0.m6320g3()
                com.mmbox.xbrowser.BrowserActivity r0 = com.mmbox.xbrowser.BrowserActivity.this
                com.mmbox.xbrowser.BrowserActivityDelegate r0 = r0.m6218I0()
                r0.mo6428g0()
                s3 r0 = p000.ThemeManager.m9472y()
                com.mmbox.xbrowser.BrowserActivity r1 = com.mmbox.xbrowser.BrowserActivity.this
                r0.m9478F(r1)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserActivity.SearchBarPositionRunnable.run():void");
        }
    }

    public class SearchBarLaunchRunnable implements Runnable {
        public SearchBarLaunchRunnable() {
        }

        @Override
        public void run() {
            Intent intent = new Intent(BrowserActivity.this, (Class<?>) SearchBarActivity.class);
            intent.putExtra("key-or-url", m6210G0().mo1573b());
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
            m6331k0(this.url, this.title);
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
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) f4276w.m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                C2061mf.m8471f0().m8542n0(((WebViewBrowserController) interfaceC1300b3).m6770F0(), this.script);
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
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) f4276w.m9316y();
            if (interfaceC1300b3 instanceof WebViewBrowserController) {
                C2061mf.m8471f0().m8552s0(((WebViewBrowserController) interfaceC1300b3).m6770F0(), this.script);
            }
        }
    }

    public class ExitConfirmDialog extends AbstractDialogC0296Ga {
        public ExitConfirmDialog(BrowserActivity browserActivity) {
            super(browserActivity);
        }

        @Override
        public void mo1371b() {
        }

        @Override
        public void mo1372c() {
            finish();
        }
    }

    public class FlagClearRunnable implements Runnable {
        public FlagClearRunnable() {
        }

        @Override
        public void run() {
            f4258e = false;
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
                    C0988Vd c0988VdM4391d = C0988Vd.m4391d();
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
                C0988Vd c0988VdM4391d = C0988Vd.m4391d();
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
                C0988Vd c0988VdM4391d = C0988Vd.m4391d();
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

    public class HistoryItemDeleteAnalyticsRunnable implements Runnable {

        public final String itemId;

        public HistoryItemDeleteAnalyticsRunnable(String str) {
            this.itemId = str;
        }

        @Override
        public void run() throws JSONException {
            JSONObject jSONObject = new JSONObject();
            try {
                jSONObject.put("transId", "delete_history_item");
                jSONObject.put("id", this.itemId);
            } catch (Exception unused) {
            }
            C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
        }
    }

    public class BookmarkDeleteConfirmDialog extends AbstractDialogC1303b6 {

        public final SQLiteDatabase database;

        public final String bookmarkId;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public BookmarkDeleteConfirmDialog(Context context, SQLiteDatabase sQLiteDatabase, String str) {
            super(context);
            this.database = sQLiteDatabase;
            this.bookmarkId = str;
        }

        @Override
        public void mo315b() {
        }

        @Override
        public void mo316c() throws JSONException {
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

    public void m6187A1(String str) {
        runOnUiThread(new WebViewEvaluateRunnable(str));
    }

    public void m6188A2(String str, String str2) {
        String strM2049e = ResourceCacheManager.getInstance().getCachedResource(Uri.parse(str2).getHost() + ".touch-icon");
        if (TextUtils.isEmpty(strM2049e)) {
            AndroidSystemUtils.m8706n(this, str, str2, C0988Vd.m4391d().m4394c(str, str2));
        } else {
            C0988Vd.m4391d().m4392a(strM2049e, str2, new FaviconDownloadCallback(str, str2));
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
                intent.addFlags(268435456);
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
                            Intent uri2 = Intent.parseUri(str, 1);
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
                    intent.addFlags(268435456);
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
            String string = cursorQuery.getString(cursorQuery.getColumnIndex("icon_uri"));
            String string2 = cursorQuery.getString(cursorQuery.getColumnIndex("title"));
            String string3 = cursorQuery.getString(cursorQuery.getColumnIndex("url"));
            if (TextUtils.isEmpty(string)) {
                bitmapM8708p = C0988Vd.m4391d().m4394c(string2, string3);
            } else if (string.startsWith("http")) {
                C0988Vd.m4391d().m4392a(string, string3, new AlternateFaviconCallback(string2, string3));
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
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        if (interfaceC1300b3 != null) {
            C1344c1.m5691d().m5699i("Mark AD", "mark_ad", interfaceC1300b3.mo1573b());
        }
    }

    public void m6196C2(int i) {
        this.f4269p = i;
        if (i == 0) {
            C2564xb.m10653b().m10654a();
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
        C2337se c2337seM4549f = c1045Wo.m4549f(C1045Wo.m.getType());
        C2337se c2337seM4549f2 = c1045Wo.m4549f(C1045Wo.m.m4601e());
        C2337se c2337seM4549f3 = c1045Wo.m4549f(C1045Wo.m.m4602f());
        C2337se c2337seM4549f4 = c1045Wo.m4549f(C1045Wo.m.m4597a());
        int iMax = Math.max(c2337seM4549f3.f7066b, c2337seM4549f4.f7066b);
        int iMax2 = Math.max(c2337seM4549f2.f7068d, c2337seM4549f4.f7068d);
        int iMax3 = Math.max(c2337seM4549f.f7065a, c2337seM4549f4.f7065a);
        int iMax4 = Math.max(c2337seM4549f.f7067c, c2337seM4549f4.f7067c);
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
        if (this.f4264k == 1) {
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

    public final void m6198D0() {
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
        this.f4271r = str;
    }

    public final boolean m6201E(C1045Wo c1045Wo) {
        int i;
        C2337se c2337seM4549f = c1045Wo.m4549f(C1045Wo.m.getType());
        C2337se c2337seM4549f2 = c1045Wo.m4549f(C1045Wo.m.m4601e());
        C2337se c2337seM4549f3 = c1045Wo.m4549f(C1045Wo.m.m4602f());
        int i2 = getResources().getDisplayMetrics().heightPixels / 4;
        int i3 = c2337seM4549f3.f7066b;
        return i3 >= 0 && i3 <= i2 && (i = c2337seM4549f2.f7068d) >= 0 && i <= i2 && c2337seM4549f.f7065a >= 0 && c2337seM4549f.f7067c >= 0;
    }

    public void m6202E0(String str, String str2) {
        Intent intent = new Intent(this, (Class<?>) GenQrCodeActivity.class);
        intent.putExtra("title", str);
        intent.putExtra("text", str2);
        startActivity(intent);
    }

    public void m6203E1() {
        AbsBrowserController absBrowserControllerM6210G0 = m6210G0();
        if (absBrowserControllerM6210G0 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) absBrowserControllerM6210G0).m6798h1(absBrowserControllerM6210G0.mo1573b());
        }
    }

    public void m6204E2(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        ((WebViewBrowserController) interfaceC1300b3).m6804n1(i);
    }

    public void m6205F() {
        int i;
        if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
            m6322h1();
            if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                C0848Sb.m4048n().m4052r();
            }
        } else {
            m6264T2();
        }
        getBrowserFrameLayout().setLayoutType(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
        if (SharedPreferencesHelper.getInstance().m6880U().equals("auto")) {
            i = -1;
        } else if (!SharedPreferencesHelper.getInstance().m6880U().equals("portrait")) {
            return;
        } else {
            i = 1;
        }
        setRequestedOrientation(i);
    }

    public String m6206F0(String str) {
        int i;
        if (str.equals("go_to_top")) {
            i = R.string.web_str_action_goto_top;
        } else if (str.equals("go_to_bottom")) {
            i = R.string.web_str_action_goto_bottom;
        } else if (str.equals("search")) {
            i = R.string.web_str_action_do_search;
        } else if (str.equals("refresh")) {
            i = R.string.web_str_action_do_refresh;
        } else if (str.equals("new_tab")) {
            i = R.string.web_str_action_new_tab;
        } else if (str.equals("remove_tabs")) {
            i = R.string.web_str_action_remove_tabs;
        } else if (str.equals("close_tab")) {
            i = R.string.web_str_action_close_current_tab;
        } else if (str.equals("revert_tab")) {
            i = R.string.web_str_action_revert_closed_tab;
        } else if (str.equals("next_tab")) {
            i = R.string.web_str_action_next_tab;
        } else if (str.equals("previous_tab")) {
            i = R.string.web_str_action_previous_tab;
        } else if (str.equals("go_to_home")) {
            i = R.string.web_str_action_go_to_home;
        } else if (str.equals("add_to_bm")) {
            i = R.string.web_str_action_add_to_bm;
        } else if (str.equals("copy_url")) {
            i = R.string.web_str_action_copy_url;
        } else if (str.equals("open_toolbox")) {
            i = R.string.web_str_action_open_toolbox;
        } else if (str.equals("toggle_fullscreen")) {
            i = R.string.web_str_action_toggle_fullscreen;
        } else if (str.equals("open_bookmark")) {
            i = R.string.web_str_action_open_bm;
        } else if (str.equals("open_history")) {
            i = R.string.web_str_action_open_his;
        } else {
            if (!str.equals("switch_search_engine")) {
                return str.equals("not_set") ? getString(R.string.web_str_action_do_nothing) : getString(R.string.web_str_action_do_nothing);
            }
            i = R.string.web_str_action_switch_search;
        }
        return getString(i);
    }

    public final void m6207F1() {
        Intent intent = new Intent(this, (Class<?>) BackgroundPlayService.class);
        intent.putExtra("title", m6210G0().mo1574c());
        intent.setAction("action.make_page_background");
        startService(intent);
        this.f4260g = true;
    }

    public final void m6208F2() {
        C1621d3 c1621d3 = new C1621d3();
        this.f4277x = c1621d3;
        c1621d3.m7295c(WebViewBrowserController.class.getName(), "^(https?|view-source|content):.*");
        this.f4277x.m7295c(WebViewBrowserController.class.getName(), "^file:///.*");
        this.f4277x.m7295c(WebViewBrowserController.class.getName(), "^data:.*");
        this.f4277x.m7295c(WebViewBrowserController.class.getName(), "^about:.*");
        this.f4277x.m7295c(WebViewBrowserController.class.getName(), "^x:.*");
        this.f4277x.m7295c(WebViewBrowserController.class.getName(), "http");
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x005e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void m6209G(String r10) {
        /*
            r9 = this;
            f3 r0 = p000.C1714f3.m7483o0()
            android.database.sqlite.SQLiteDatabase r1 = r0.getReadableDatabase()
            java.lang.String r4 = "parent= ? AND status>= ?"
            java.lang.String r8 = "item_order ASC"
            java.lang.String r0 = "0"
            java.lang.String[] r5 = new java.lang.String[]{r10, r0}
            java.util.ArrayList r10 = new java.util.ArrayList
            r10.<init>()
            r0 = 0
            java.lang.String r2 = "bookmark"
            java.lang.String[] r3 = p000.AbstractC1667e3.f5377b     // Catch: java.lang.Exception -> L5e
            r6 = 0
            r7 = 0
            android.database.Cursor r1 = r1.query(r2, r3, r4, r5, r6, r7, r8)     // Catch: java.lang.Exception -> L5e
            if (r1 == 0) goto L5e
            boolean r2 = r1.moveToFirst()     // Catch: java.lang.Exception -> L5e
            if (r2 == 0) goto L5e
            r2 = r0
        L2b:
            java.lang.String r3 = "url"
            int r3 = r1.getColumnIndex(r3)     // Catch: java.lang.Exception -> L5f
            java.lang.String r3 = r1.getString(r3)     // Catch: java.lang.Exception -> L5f
            java.lang.String r4 = "title"
            int r4 = r1.getColumnIndex(r4)     // Catch: java.lang.Exception -> L5f
            java.lang.String r4 = r1.getString(r4)     // Catch: java.lang.Exception -> L5f
            java.lang.String r5 = "_tab-id_"
            int r5 = r3.indexOf(r5)     // Catch: java.lang.Exception -> L5f
            if (r5 <= 0) goto L4d
            int r5 = r5 + (-1)
            java.lang.String r3 = r3.substring(r0, r5)     // Catch: java.lang.Exception -> L5f
        L4d:
            en r5 = new en     // Catch: java.lang.Exception -> L5f
            r5.<init>(r4, r3)     // Catch: java.lang.Exception -> L5f
            r10.add(r5)     // Catch: java.lang.Exception -> L5f
            int r2 = r2 + 1
            boolean r3 = r1.moveToNext()     // Catch: java.lang.Exception -> L5f
            if (r3 != 0) goto L2b
            goto L5f
        L5e:
            r2 = r0
        L5f:
            c3 r1 = r9.m6222J0()
            r1.m9296T(r10)
            r10 = 2131559026(0x7f0d0272, float:1.8743384E38)
            java.lang.String r10 = r9.getString(r10)
            java.lang.Integer r1 = java.lang.Integer.valueOf(r2)
            java.lang.Object[] r1 = new java.lang.Object[]{r1}
            java.lang.String r10 = java.lang.String.format(r10, r1)
            android.widget.Toast r10 = android.widget.Toast.makeText(r9, r10, r0)
            r10.show()
            com.mmbox.xbrowser.BrowserActivityDelegate r10 = r9.m6218I0()
            r10.mo6428g0()
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserActivity.m6209G(java.lang.String):void");
    }

    public AbsBrowserController m6210G0() {
        return (AbsBrowserController) m6222J0().m9316y();
    }

    public final void m6211G1(boolean z) {
        SharedPreferencesHelper.getInstance().normalExit = z;
        SharedPreferencesHelper.getInstance().putBoolean("normal_exit", z);
    }

    public final void m6212G2() {
        try {
            SystemUiCompat.setDecorFitsSystemWindows(getWindow(), false);
            View viewFindViewById = findViewById(android.R.id.content);
            if (viewFindViewById != null) {
                AbstractC0448Jo.m2095x(viewFindViewById, new InterfaceC0625Nh() {
                    @Override
                    public final C1045Wo mo3322a(View view, C1045Wo c1045Wo) {
                        return this.f3302a.m6370w1(view, c1045Wo);
                    }
                });
            }
            m6317g0();
        } catch (Exception unused) {
            m6216H2();
        }
    }

    public void m6213H(String str) {
        SQLiteDatabase readableDatabase = MySQLiteOpenHelper.getInstance().getReadableDatabase();
        String[] strArr = {str, "0"};
        ArrayList arrayList = new ArrayList<>();
        try {
            Cursor cursorQuery = readableDatabase.query("quick_access", DatabaseColumns.QUICK_ACCESS, "parent= ? AND status>= ?", strArr, null, null, "item_order ASC");
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    arrayList.add(new C1697en(cursorQuery.getString(cursorQuery.getColumnIndex("title")), cursorQuery.getString(cursorQuery.getColumnIndex("url"))));
                } while (cursorQuery.moveToNext());
            }
        } catch (Exception unused) {
        }
        m6222J0().m9296T(arrayList);
        Toast.makeText(this, String.format(getString(R.string.toast_open_tab_count), Integer.valueOf(arrayList.size())), Toast.LENGTH_SHORT).show();
        m6218I0().mo6428g0();
    }

    public String m6214H0(String str, String str2) {
        if (!str.startsWith("blob")) {
            return "javascript: console.log('It is not a Blob URL');";
        }
        return "var xhr = new XMLHttpRequest();xhr.open('GET', '" + str + "', true);xhr.setRequestHeader('Content-type','" + str2 + "');xhr.responseType = 'blob';xhr.onload = function(e) {    if (this.status == 200) {        var blobPdf = this.response;        var reader = new FileReader();        reader.readAsDataURL(blobPdf);        reader.onloadend = function() {            base64data = reader.result;            mbrowser.getBase64FromBlobData(base64data,'" + str2 + "');        }    }};xhr.send();";
    }

    public void m6215H1(int i, String str, String str2) {
        C1199a3 c1199a3M5090f;
        String str3;
        String str4;
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getWritableDatabase().query("bookmark", DatabaseColumns.BOOKMARK, "url= ?", new String[]{str}, null, null, null);
        String strM8714v = AndroidSystemUtils.prefixWithMd5(str);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                    if (cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("parent")).equals(str2)) {
                        c1199a3M5090f = C1199a3.m5090f();
                        str3 = "cut_bookmark_item";
                    } else {
                        int i2 = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type"));
                        String string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("title"));
                        if (str.startsWith("/")) {
                            if (str2.endsWith("/")) {
                                str4 = str2 + string;
                            } else {
                                str4 = str2 + "/" + string;
                            }
                            m6303c3(str, str4, string, str2);
                        } else {
                            m6303c3(str, str, string, str2);
                        }
                        if (i == 0) {
                            JSONObject jSONObject = new JSONObject();
                            jSONObject.put("transId", "paste_bookmark_item");
                            JSONObject jSONObject2 = new JSONObject();
                            jSONObject2.put("id", strM8714v);
                            jSONObject2.put("title", string);
                            jSONObject2.put("url", str);
                            jSONObject2.put("type", i2);
                            jSONObject2.put("path", str2);
                            jSONObject2.put("icon_uri", C0896Td.m4137c().m4138a(str));
                            jSONObject.put("item", jSONObject2);
                            C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
                            return;
                        }
                        c1199a3M5090f = C1199a3.m5090f();
                        str3 = "paste_to_this_folder";
                    }
                    c1199a3M5090f.m5098j(str3, "id", strM8714v);
                }
            } catch (Exception unused) {
            }
        }
    }

    public void m6216H2() {
        View viewFindViewById = findViewById(R.id.top_content);
        View viewFindViewById2 = findViewById(R.id.main_content);
        View viewFindViewById3 = findViewById(R.id.bottom_content);
        if (viewFindViewById == null || viewFindViewById2 == null || viewFindViewById3 == null) {
            return;
        }
        int iM5583G = PhoneUtils.getInstance().getStatusBarHeight();
        PhoneUtils.getInstance().getNavigationBarHeight();
        if (this.f4264k == 1) {
            viewFindViewById2.setPadding(0, iM5583G, 0, 0);
            return;
        }
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097) {
            if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                viewFindViewById.setPadding(0, 0, 0, 0);
            } else {
                viewFindViewById.setPadding(0, iM5583G, 0, 0);
            }
        } else {
            if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) != 4098) {
                return;
            }
            if (!SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                viewFindViewById2.setPadding(0, iM5583G, 0, 0);
                return;
            }
        }
        viewFindViewById2.setPadding(0, 0, 0, 0);
    }

    public boolean m6217I() {
        return this.f4276w.m9308p() && this.f4264k == 0;
    }

    public BrowserActivityDelegate m6218I0() {
        return this.f4275v;
    }

    public void m6219I1(NetworkInfo.State state) {
        if (state != NetworkInfo.State.CONNECTED) {
            if (state == NetworkInfo.State.DISCONNECTED) {
                BrowserDownloadManager.m6674q().m6707x();
                return;
            }
            return;
        }
        getHandler().postDelayed(new TrafficStrategyInitRunnable(), 200L);
        int iM9280D = m6222J0().m9280D();
        for (int i = 0; i < iM9280D; i++) {
            ArrayList arrayListM9279C = m6222J0().m9279C(i);
            for (int i2 = 0; i2 < arrayListM9279C.size(); i2++) {
                InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) arrayListM9279C.get(i2);
                if (interfaceC1300b3 != null && (interfaceC1300b3 instanceof WebViewBrowserController)) {
                    ((WebViewBrowserController) interfaceC1300b3).m6770F0().setNetworkAvailable(true);
                }
            }
        }
    }

    public void m6220I2() {
        String strMo1574c = ((InterfaceC1300b3) m6222J0().m9316y()).mo1574c();
        String strMo1573b = ((InterfaceC1300b3) m6222J0().m9316y()).mo1573b();
        if (strMo1573b == null || strMo1573b.startsWith("x:")) {
            new DialogC0812Rl(this).show();
        } else {
            AndroidSystemUtils.m8689W(this, strMo1574c, strMo1573b, "", getResources().getString(R.string.choose_app));
        }
    }

    public boolean m6221J() {
        return this.f4276w.m9309q() && this.f4264k == 0;
    }

    public C1346c3 m6222J0() {
        return this.f4276w;
    }

    public final void m6223J1(String str) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", "delete_bookmark_item");
            jSONObject.put("id", str);
        } catch (Exception unused) {
        }
        C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
    }

    public final void m6224J2(String str) {
        m6218I0().m6394C().m1440w(str);
    }

    public void m6225K() {
        m6373x0();
    }

    public int m6226K0() {
        return this.f4269p;
    }

    public void m6227K1(String str) {
        MessageBoxManager.getInstance().showMessageWithDescription(getActivity().getBrowserFrameLayout(), getActivity().getString(R.string.message_download_finished), getActivity().getString(R.string.btn_text_open), new DownloadDeleteListener(str), false);
    }

    public void m6228K2(int i) {
        m6232L2(getString(i));
    }

    public final void m6229L() {
        stopService(new Intent(this, (Class<?>) BackgroundPlayService.class));
    }

    public int m6230L0() {
        return m6210G0().mo5626h();
    }

    public void m6231L1() {
        getHandler().postDelayed(new DarkModeNotificationRunnable(), 200L);
    }

    public void m6232L2(String str) {
        runOnUiThread(new LongToastRunnable(str));
    }

    public void m6233M() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo1581q();
        }
    }

    public String m6234M0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        if (interfaceC1300b3 != null) {
            return interfaceC1300b3.mo1573b();
        }
        return null;
    }

    public void m6235M1(String str) {
        MessageBoxManager.getInstance().showMessageWithDescription(getActivity().getBrowserFrameLayout(), getActivity().getString(R.string.toast_found_bookmark_recovery_file), getActivity().getString(R.string.btn_text_restore), new BookmarkAddedListener(str), false);
    }

    public void m6236M2(int i, long j) {
        m6240N2(getString(i), j);
    }

    public void m6237N(String mediaUrl) {
        Intent intent = new Intent(this, CasterActivity.class);
        intent.putExtra("media_url", mediaUrl);
        startActivity(intent);
    }

    public String m6238N0(String str) {
        int i;
        if (str.equals("long_press_back_btn")) {
            i = R.string.web_str_gs_long_press_back;
        } else if (str.equals("long_press_forward_btn")) {
            i = R.string.web_str_gs_long_press_forward;
        } else if (str.equals("long_press_home")) {
            i = R.string.web_str_gs_long_press_home;
        } else if (str.equals("long_press_multi_tab")) {
            i = R.string.web_str_gs_long_press_tabs;
        } else {
            if (!str.equals("long_press_menu")) {
                return "";
            }
            i = R.string.web_str_gs_long_press_menu;
        }
        return getString(i);
    }

    public void m6239N1() {
        MessageBoxManager.getInstance().showMessageWithDescription(getActivity().getBrowserFrameLayout(), getActivity().getString(R.string.toast_found_offline_file), getActivity().getString(R.string.btn_text_view), new OfflineFilesOpenListener(), false);
    }

    public void m6240N2(String str, long j) {
        if (this.f4252N == 0 || System.currentTimeMillis() - this.f4252N > j) {
            runOnUiThread(new TimestampUpdateRunnable(str));
        }
    }

    public void m6241O(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 == null || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            return;
        }
        ((WebViewBrowserController) interfaceC1300b3).m6812w0(i);
    }

    public Handler getHandler() {
        return this.handler;
    }

    public void m6243O1(String str) {
        MessageBoxManager.getInstance().showMessageWithDescription(getActivity().getBrowserFrameLayout(), getActivity().getString(R.string.toast_found_user_recovery_file), getActivity().getString(R.string.btn_text_restore), new UrlDeleteListener(str), false);
    }

    public void m6244O2() {
        new ViewOnClickListenerC0166Di(this).m714c(((InterfaceC1300b3) m6222J0().m9316y()).mo1574c(), ((InterfaceC1300b3) m6222J0().m9316y()).mo1573b());
    }

    public void m6245P(int i) {
        runOnUiThread(new BrightnessAdjustmentRunnable(i));
    }

    public int m6246P0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
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
        C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
    }

    public final void m6248P2() throws Resources.NotFoundException {
        MessageBoxManager.getInstance().showToast(getActivity().getBrowserFrameLayout(), getActivity().getResources().getString(R.string.message_revert_tabls), getActivity().getResources().getString(R.string.btn_text_restore), new MessageBoxBase.MessageBoxListener() {
            @Override
            public void onShown() {
                f4276w.m9314w();
                f4276w.m9295S(m6278X0());
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

    public void m6251Q1(String str) {
        runOnUiThread(new ModuleLoadFailureRunnable(str));
    }

    public void m6252Q2(int i) {
        m6256R2(getString(i));
    }

    public void m6253R(int i) {
        SharedPreferencesHelper.getInstance().m6854F0(i);
        getBrowserFrameLayout().setLayoutType(i);
    }

    public PullToRefreshHandler m6254R0() {
        return this.f4240B;
    }

    public final void m6255R1(String str, String str2, String str3) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("transId", "new_bookmark_item");
            jSONObject.put("id", AndroidSystemUtils.prefixWithMd5(str2));
            jSONObject.put("title", str);
            jSONObject.put("url", str2);
            jSONObject.put("type", str2.startsWith("/") ? 1 : 0);
            jSONObject.put("path", str3);
        } catch (Exception e) {
            e.printStackTrace();
        }
        C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
    }

    public void m6256R2(String str) {
        runOnUiThread(new ShortToastRunnable(str));
    }

    public void m6257S(int i) {
        SharedPreferencesHelper sharedPreferencesHelperM6833I;
        boolean zM8676J;
        if (i == 0) {
            SharedPreferencesHelper.getInstance().putBoolean("load_images", true);
        } else {
            if (i == 1) {
                sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                zM8676J = false;
            } else if (i == 2) {
                sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                zM8676J = AndroidSystemUtils.isWifiConnected(this);
            }
            sharedPreferencesHelperM6833I.putBoolean("load_images", zM8676J);
        }
        SharedPreferencesHelper.getInstance().putInt("save_traffic_strategy", i);
        m6280X2();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public int[] m6258S0() {
        AbsBrowserController absBrowserControllerM6210G0 = m6210G0();
        if (!(absBrowserControllerM6210G0 instanceof WebViewBrowserController)) {
            return WebViewBrowserController.m6731J();
        }
        absBrowserControllerM6210G0.mo1573b();
        return ((WebViewBrowserController) absBrowserControllerM6210G0).m6769E0();
    }

    public void m6259S1(boolean z) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6782R0(z);
        }
    }

    public final void m6260S2() {
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:19:? A[RETURN, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6261T() {
        /*
            r3 = this;
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            java.lang.String r0 = r0.m6880U()
            java.lang.String r1 = "auto"
            boolean r1 = r0.equals(r1)
            r2 = 1
            if (r1 == 0) goto L16
            r0 = -1
        L12:
            r3.setRequestedOrientation(r0)
            goto L2c
        L16:
            java.lang.String r1 = "portrait"
            boolean r1 = r0.equals(r1)
            if (r1 == 0) goto L22
            r3.setRequestedOrientation(r2)
            goto L2c
        L22:
            java.lang.String r1 = "landscape"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L2c
            r0 = 0
            goto L12
        L2c:
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            java.lang.String r0 = r0.m6928y()
            java.lang.String r1 = "browser"
            boolean r0 = r0.equals(r1)
            if (r0 == 0) goto L5c
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            int r0 = r0.m6845B()
            r1 = 8192(0x2000, float:1.148E-41)
            r0 = r0 & r1
            if (r0 != r1) goto L4f
            com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            r0.f4914l = r2
        L4f:
            com.mmbox.xbrowser.BrowserFrameLayout r0 = r3.f4278y
            com.mmbox.xbrowser.d r1 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            int r1 = r1.m6845B()
            r0.setLayoutType(r1)
        L5c:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.BrowserActivity.m6261T():void");
    }

    public ArrayList m6262T0() {
        return this.f4239A;
    }

    public void m6263T1() {
        runOnUiThread(new ReadModeActivationRunnable());
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
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6788X0();
        }
    }

    public void m6268U2() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
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
        m6279X1("x:bm?order=" + SharedPreferencesHelper.getInstance().getString("bm_order", "default"));
    }

    public boolean m6272V2() {
        int iM6230L0 = m6230L0();
        String strMo1573b = m6210G0().mo1573b();
        return (SharedPreferencesHelper.getInstance().disablePullToRefreshGesture || SharedPreferencesHelper.getInstance().canVScroll || (iM6230L0 != 0 && iM6230L0 != 8) || strMo1573b.startsWith("file://") || strMo1573b.startsWith("x:") || this.f4264k != 0) ? false : true;
    }

    public void m6273W() {
        if (m6281Y(new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"})) {
            return;
        }
        AbstractC2129o0.m8827j(this, new String[]{"com.android.launcher.permission.INSTALL_SHORTCUT"}, 257);
    }

    public String m6274W0() {
        String strM2046a = ResourceCacheManager.getInstance().m2046a("start-page.bg", 9);
        if (FileUtils.fileExists(strM2046a)) {
            return FileUtils.readFileToString(strM2046a);
        }
        return null;
    }

    public void m6275W1() {
        m6187A1("devtools");
    }

    public void m6276W2() {
        int i;
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            if (SharedPreferencesHelper.getInstance().f4872O0 && SharedPreferencesHelper.getInstance().nightBrightness >= 0) {
                i = SharedPreferencesHelper.getInstance().nightBrightness;
                m6245P(i);
                return;
            }
            m6245P(-1);
        }
        if (SharedPreferencesHelper.getInstance().f4872O0 && SharedPreferencesHelper.getInstance().defaultBrightness >= 0) {
            i = SharedPreferencesHelper.getInstance().defaultBrightness;
            m6245P(i);
            return;
        }
        m6245P(-1);
    }

    public boolean m6277X() {
        boolean zM6281Y = m6281Y(new String[]{"android.permission.POST_NOTIFICATIONS"});
        AbstractC2129o0.m8827j(this, new String[]{"android.permission.POST_NOTIFICATIONS"}, 260);
        return zM6281Y;
    }

    public final SharedPreferences m6278X0() {
        SharedPreferences sharedPreferences = getSharedPreferences("tabs_recovery", 0);
        return !TextUtils.isEmpty(sharedPreferences.getString("pref-tab-list", "")) ? sharedPreferences : SharedPreferencesHelper.getInstance().m6875R();
    }

    public void m6279X1(String str) {
        openUrl(str, true, 0);
    }

    public void m6280X2() {
        if (m6222J0() != null) {
            int iM9280D = m6222J0().m9280D();
            for (int i = 0; i < iM9280D; i++) {
                ArrayList arrayListM9279C = m6222J0().m9279C(i);
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
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9317z(i);
        if (interfaceC1300b3 != null) {
            return interfaceC1300b3.mo1573b();
        }
        return null;
    }

    public void m6283Y1() {
        m6307d2("market://details?id=" + getPackageName());
    }

    public void m6284Y2() {
        this.handler.removeCallbacks(this.f4253O);
        if (this.f4245G > 0) {
            this.handler.postDelayed(this.f4253O, 200L);
        }
    }

    public boolean m6285Z(String str) {
        return AbstractC2320s6.m9505a(this, str) == 0;
    }

    public final String m6286Z0(Intent intent) {
        Uri data = intent.getData();
        return data != null ? data.toString() : intent.getStringExtra("url");
    }

    public void m6287Z1() {
        m6279X1("x:sd?path=offlines&sort=" + SharedPreferencesHelper.getInstance().getString("file_order", "date"));
    }

    public boolean m6288Z2() {
        int iM6845B = SharedPreferencesHelper.getInstance().getDefaultLayoutType();
        if ((iM6845B & 8192) == 8192) {
            m6253R(iM6845B ^ 8192);
            SharedPreferencesHelper.getInstance().browserFullscreenMode = false;
            SharedPreferencesHelper.getInstance().putBoolean("browser_fullscreen_mode", false);
            C0848Sb.m4048n().m4049o();
            m6264T2();
        } else {
            m6322h1();
            m6253R(iM6845B | 8192);
            SharedPreferencesHelper.getInstance().browserFullscreenMode = true;
            SharedPreferencesHelper.getInstance().putBoolean("browser_fullscreen_mode", true);
            if (SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                C0848Sb.m4048n().m4052r();
            }
            if (!SharedPreferencesHelper.getInstance().fullscreenWithFloatBtn) {
                C2363t3.m9665a().m9673i(112, false);
            }
        }
        m6189B();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
        return SharedPreferencesHelper.getInstance().browserFullscreenMode;
    }

    @Override
    public void mo6289a(InterfaceC0345Hd interfaceC0345Hd) {
        this.f4275v.mo6401J(interfaceC0345Hd);
    }

    public void m6290a0() {
        m6281Y(new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"});
        AbstractC2129o0.m8827j(this, new String[]{"android.permission.WRITE_EXTERNAL_STORAGE"}, 256);
    }

    public void m6291a1() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo5628j();
        }
        this.f4276w.m9287K();
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
            if (this.f4250L != null) {
                getHandler().removeCallbacksAndMessages(this.f4250L);
            }
            UrlValidationRunnable runnableC1455Y = new UrlValidationRunnable(str);
            this.f4250L = runnableC1455Y;
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
        this.f4276w.m9288L();
        m6324h3();
    }

    public void m6297b2(String str) {
        int i;
        int i2;
        if (str != null) {
            if (NetworkUtils.isNonUrl(str)) {
                m6334l0(str);
            } else {
                m6307d2(str);
            }
            if (str.startsWith("http")) {
                return;
            }
            AndroidSystemUtils.m8701i(this, str);
            i = R.string.copied_to_clipboard;
            i2 = 1;
        } else {
            i = R.string.toast_unrecognised_qrcode;
            i2 = 0;
        }
        Toast.makeText(this, i, i2).show();
    }

    public void m6298b3() {
        if (m6222J0() != null) {
            int iM9280D = m6222J0().m9280D();
            for (int i = 0; i < iM9280D; i++) {
                Iterator it = m6222J0().m9279C(i).iterator();
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
            this.f4239A.add(((InterfaceC1300b3) interfaceC0345Hd).mo1573b());
        }
    }

    public void m6300c0() {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) interfaceC1300b3).m6770F0().clearCache(false);
        }
    }

    public void m6301c1(int i, boolean z) {
        SharedPreferencesHelper.getInstance().goodForEyeColor = i;
        SharedPreferencesHelper.getInstance().putInt("good_for_eye_color", i);
        m6298b3();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public void m6302c2() {
        String strMo1573b = ((InterfaceC1300b3) m6222J0().m9316y()).mo1573b();
        if (!strMo1573b.startsWith("http")) {
            Toast.makeText(this, R.string.toast_not_support_this_operation, Toast.LENGTH_SHORT).show();
            return;
        }
        String host = Uri.parse(strMo1573b).getHost();
        openUrl("x:site?host=" + host + "&top_domain=" + NetworkUtils.getFileExtension(host), true, 0);
    }

    public void m6303c3(String str, String str2, String str3, String str4) throws Throwable {
        String str5;
        Cursor cursor;
        C1089Xm c1089XmM4819i;
        String str6;
        long j;
        String string;
        ContentValues contentValues;
        StringBuilder sb;
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        String[] strArr = DatabaseColumns.BOOKMARK;
        Cursor cursorQuery = writableDatabase.query("bookmark", strArr, "url= ?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    try {
                        j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                        cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type"));
                        string = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("parent"));
                        contentValues = new ContentValues();
                        contentValues.put("url", str2);
                        contentValues.put("title", str3);
                        contentValues.put("parent", str4);
                        try {
                            contentValues.put("last_visit", Long.valueOf(System.currentTimeMillis()));
                            sb = new StringBuilder();
                            str6 = "syncable_bookmark";
                        } catch (Exception e) {
                            e = e;
                            str6 = "syncable_bookmark";
                        } catch (Throwable th) {
                            th = th;
                            str6 = "syncable_bookmark";
                        }
                    } catch (Exception e2) {
                        e = e2;
                        str6 = "syncable_bookmark";
                        cursor = cursorQuery;
                    } catch (Throwable th2) {
                        th = th2;
                        str6 = "syncable_bookmark";
                        cursor = cursorQuery;
                    }
                    try {
                        sb.append("_id=");
                        sb.append(j);
                        writableDatabase.update("bookmark", contentValues, sb.toString(), null);
                        string.equals(str4);
                        m6247P1(str3, str, str2, str4);
                        if (str.startsWith("/")) {
                            cursor = cursorQuery;
                            try {
                                Cursor cursorQuery2 = writableDatabase.query("bookmark", strArr, "parent= ?", new String[]{str}, null, null, null);
                                if (cursorQuery2 != null) {
                                    try {
                                        if (cursorQuery2.moveToFirst()) {
                                            do {
                                                String string2 = cursorQuery2.getString(cursorQuery2.getColumnIndex("url"));
                                                String string3 = cursorQuery2.getString(cursorQuery2.getColumnIndex("title"));
                                                if (string2.startsWith("/")) {
                                                    m6303c3(string2, str2 + "/" + string3, string3, str2);
                                                } else {
                                                    m6303c3(string2, string2, string3, str2);
                                                }
                                            } while (cursorQuery2.moveToNext());
                                        }
                                        cursorQuery2.close();
                                    } catch (Throwable th3) {
                                        cursorQuery2.close();
                                        throw th3;
                                    }
                                }
                            } catch (Exception e3) {
                                e = e3;
                                str5 = str6;
                                try {
                                    Toast.makeText(this, R.string.toast_bookmark_exist, Toast.LENGTH_SHORT).show();
                                    e.printStackTrace();
                                    cursor.close();
                                    c1089XmM4819i = C1089Xm.getInstance();
                                    c1089XmM4819i.m4822j(str5).incrementVersion();
                                } catch (Throwable th4) {
                                    th = th4;
                                    cursor.close();
                                    C1089Xm.getInstance().m4822j(str5).incrementVersion();
                                    throw th;
                                }
                            } catch (Throwable th5) {
                                th = th5;
                                str5 = str6;
                                cursor.close();
                                C1089Xm.getInstance().m4822j(str5).incrementVersion();
                                throw th;
                            }
                        } else {
                            cursor = cursorQuery;
                        }
                    } catch (Exception e4) {
                        e = e4;
                        cursor = cursorQuery;
                        str5 = str6;
                        Toast.makeText(this, R.string.toast_bookmark_exist, Toast.LENGTH_SHORT).show();
                        e.printStackTrace();
                        cursor.close();
                        c1089XmM4819i = C1089Xm.getInstance();
                        c1089XmM4819i.m4822j(str5).incrementVersion();
                    } catch (Throwable th6) {
                        th = th6;
                        cursor = cursorQuery;
                        str5 = str6;
                        cursor.close();
                        C1089Xm.getInstance().m4822j(str5).incrementVersion();
                        throw th;
                    }
                } else {
                    str6 = "syncable_bookmark";
                    cursor = cursorQuery;
                }
                cursor.close();
                c1089XmM4819i = C1089Xm.getInstance();
                str5 = str6;
            } catch (Exception e5) {
                e = e5;
                str5 = "syncable_bookmark";
                cursor = cursorQuery;
            } catch (Throwable th7) {
                th = th7;
                str5 = "syncable_bookmark";
                cursor = cursorQuery;
            }
            c1089XmM4819i.m4822j(str5).incrementVersion();
        }
    }

    @Override
    public void mo6304d() {
    }

    public void m6305d0() {
        FileUtils.deleteFile(ResourceCacheManager.getInstance().m2046a("page.immerse.colors", 1));
        this.f4244F = null;
    }

    public final boolean m6306d1(Intent intent) throws IOException {
        String strM6286Z0 = m6286Z0(intent);
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
                    m6235M1("file://" + strM6333k2);
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
                        m6235M1("file://" + strM6333k22);
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
                    m6243O1(str);
                } else if (FileUtils.doesFirstLineStartWith(str, "// ==UserScript==")) {
                    C2061mf.m8471f0().m8565z0(str);
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
        m6311e2(str, null, m6222J0().m9316y() != null ? ((InterfaceC1300b3) m6222J0().m9316y()).mo5626h() : 0, SharedPreferencesHelper.getInstance().supportSuperCache);
    }

    public void m6308d3() {
        m6312e3((SharedPreferencesHelper.getInstance().defaultLayoutType & 4097) == 4097 ? "search-bar-at-top" : "search-bar-at-bottom");
    }

    @Override
    public boolean dispatchKeyEvent(KeyEvent keyEvent) {
        int keyCode = keyEvent.getKeyCode();
        if (keyCode == 4 && keyEvent.isLongPress() && m6217I()) {
            m6218I0().mo6411T();
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
        if (this.f4266m) {
            return true;
        }
        return super.dispatchTouchEvent(motionEvent);
    }

    public void m6309e0() {
        FileUtils.deleteFile(ResourceCacheManager.getInstance().m2046a("start-page.bg", 9));
    }

    public final void m6310e1(C2337se c2337se, C2337se c2337se2) {
        WebView webViewM6770F0;
        ViewGroup.MarginLayoutParams marginLayoutParams;
        if (m6222J0() != null) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
            if (!(interfaceC1300b3 instanceof WebViewBrowserController) || (webViewM6770F0 = ((WebViewBrowserController) interfaceC1300b3).m6770F0()) == null || (marginLayoutParams = (ViewGroup.MarginLayoutParams) webViewM6770F0.getLayoutParams()) == null) {
                return;
            }
            marginLayoutParams.leftMargin = Math.max(c2337se.f7065a, c2337se2.f7065a);
            marginLayoutParams.rightMargin = Math.max(c2337se.f7067c, c2337se2.f7067c);
            webViewM6770F0.setLayoutParams(marginLayoutParams);
        }
    }

    public void m6311e2(String str, InterfaceC1300b3 interfaceC1300b3, int i, boolean z) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        InterfaceC1300b3 interfaceC1300b32 = interfaceC1300b3 == null ? (InterfaceC1300b3) this.f4276w.m9316y() : interfaceC1300b3;
        if (interfaceC1300b3 == null || z) {
            InterfaceC1300b3 interfaceC1300b3M7293a = this.f4277x.m7293a(str);
            if (interfaceC1300b3M7293a != null) {
                interfaceC1300b3M7293a.mo5622C(i);
                interfaceC1300b3M7293a.mo1579m(str);
                this.f4276w.m9305m(interfaceC1300b3M7293a);
                if (interfaceC1300b32 != null) {
                    interfaceC1300b3M7293a.mo1572D(interfaceC1300b32.mo1573b());
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
            int iM9284H = this.f4276w.m9284H(interfaceC1300b32);
            InterfaceC1300b3 interfaceC1300b3M7293a2 = this.f4277x.m7293a(str);
            if (interfaceC1300b3M7293a2 != null) {
                interfaceC1300b3M7293a2.mo5622C(i);
                this.f4276w.m9306n(interfaceC1300b3M7293a2, iM9284H);
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
        return FileUtils.fileExists(ResourceCacheManager.getInstance().m2046a("start-page.bg", 9));
    }

    public void m6315f2(String str, boolean z) {
        m6311e2(str, null, m6222J0().m9316y() != null ? ((InterfaceC1300b3) m6222J0().m9316y()).mo5626h() : 0, z);
    }

    public void m6316f3(String str, String str2, String str3) {
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (!MySQLiteOpenHelper.getInstance().m7543y0(writableDatabase, str)) {
            m6380z(str, str2, str3, 0);
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
        m6361u0(sb.toString());
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

    public final void m6317g0() {
        SystemUiController systemUiControllerM4436A = SystemUiCompat.create(getWindow(), getWindow().getDecorView());
        if (systemUiControllerM4436A != null) {
            boolean z = !SharedPreferencesHelper.getInstance().enterNightMode;
            systemUiControllerM4436A.setLightStatusBar(z);
            systemUiControllerM4436A.setLightNavigationBar(z);
            systemUiControllerM4436A.setSystemBarsBehavior(2);
        }
    }

    public final void m6318g1() {
    }

    public void openUrl(String str, boolean z, int i) {
        if (this.f4276w.m9280D() > 1024) {
            Toast.makeText(this, "open too many tabs", Toast.LENGTH_SHORT).show();
            return;
        }
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        InterfaceC1300b3 interfaceC1300b3M7293a = this.f4277x.m7293a(str);
        if (interfaceC1300b3M7293a == null) {
            m6190B0(str);
            return;
        }
        interfaceC1300b3M7293a.mo5622C(i);
        if (interfaceC1300b3 != null && i != -1) {
            interfaceC1300b3M7293a.mo1572D(interfaceC1300b3.mo1573b());
        }
        interfaceC1300b3M7293a.mo5623E(str);
        if ((SharedPreferencesHelper.getInstance().newTabAtBottom && str.startsWith("x:")) || (SharedPreferencesHelper.getInstance().newTabAtBottom && str.startsWith("file:///android_asset/"))) {
            this.f4276w.m9310s(interfaceC1300b3M7293a);
        } else {
            this.f4276w.m9312u(interfaceC1300b3M7293a, z);
        }
        m6324h3();
        if (z) {
            return;
        }
        Toast.makeText(this, R.string.toast_open_in_bg, Toast.LENGTH_SHORT).show();
    }

    public void m6320g3() {
        ThemeManager.getInstance().m9479G();
        m6218I0().m6394C().m1434q();
    }

    public void m6321h0(String str) {
        String strM8714v;
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("bookmark", DatabaseColumns.BOOKMARK, "url= ?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    if (cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type")) != 1) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("status", (Integer) (-1));
                        writableDatabase.update("bookmark", contentValues, "url= ?", new String[]{str});
                        strM8714v = AndroidSystemUtils.prefixWithMd5(str);
                    } else if (this.f4264k == 3) {
                        MySQLiteOpenHelper.getInstance().deleteBookmarkRecursive(writableDatabase, str);
                        strM8714v = AndroidSystemUtils.prefixWithMd5(str);
                    } else {
                        new BookmarkDeleteConfirmDialog(this, writableDatabase, str).m5643d(getString(R.string.dlg_remove_dir_title), getString(R.string.dlg_remove_dir_confirm));
                    }
                    m6223J1(strM8714v);
                }
                cursorQuery.close();
                C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
            } catch (Throwable th) {
                cursorQuery.close();
                C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
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
            this.f4248J = uriM8707o;
            if (uriM8707o != null) {
                intent.putExtra("output", uriM8707o);
                startActivityForResult(intent, 17);
            }
        }
    }

    public void m6324h3() {
        this.f4275v.mo6428g0();
        this.f4275v.m6394C().m1427E();
    }

    public void m6325i0(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        MySQLiteOpenHelper.getInstance().getWritableDatabase().update("quick_access", contentValues, "parent= ?", new String[]{str});
        m6328j0(str);
    }

    public void m6326i1() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("text/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 68);
    }

    public void m6327i2() {
        m6187A1("page_tts_v2");
    }

    public void m6328j0(String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("status", (Integer) (-1));
        MySQLiteOpenHelper.getInstance().getWritableDatabase().update("quick_access", contentValues, "guid= ?", new String[]{str});
        m6361u0("nav_call_deleteItem('" + str + "')");
        C1089Xm.getInstance().m4822j("syncable_quick_access").incrementVersion();
    }

    public void m6329j1() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("text/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 65);
    }

    public final String getFilePathFromIntent(Intent intent) {
        Uri dataUri = intent.getData();
        if (dataUri == null) return null;

        return "file".equalsIgnoreCase(dataUri.getScheme())
                ? dataUri.getPath()
                : AndroidSystemUtils.getCachedFilePath(this, dataUri);
    }

    public final void m6331k0(String str, String str2) {
        try {
            if (TextUtils.isEmpty(str2) || str2.startsWith("file:///")) {
                return;
            }
            String strM458m = "";
            if (!str2.startsWith("x:")) {
                try {
                    String host = Uri.parse(str2).getHost();
                    if (host != null) {
                        strM458m = NetworkUtils.getFileExtension(host);
                    }
                } catch (Exception unused) {
                }
            }
            long jCurrentTimeMillis = System.currentTimeMillis();
            SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
            writableDatabase.beginTransaction();
            try {
                try {
                    writableDatabase.execSQL("UPDATE history SET visits = visits + 1, last_visit = ?, title = ?, host = ?  WHERE url = ?", new Object[]{Long.valueOf(jCurrentTimeMillis), str, strM458m, str2});
                    if (DatabaseUtils.longForQuery(writableDatabase, "SELECT changes()", null) == 0) {
                        ContentValues contentValues = new ContentValues();
                        contentValues.put("title", str);
                        contentValues.put("url", str2);
                        contentValues.put("host", strM458m);
                        contentValues.put("visits", (Integer) 1);
                        contentValues.put("last_visit", Long.valueOf(jCurrentTimeMillis));
                        writableDatabase.insert("history", null, contentValues);
                    }
                    writableDatabase.setTransactionSuccessful();
                } catch (Exception e) {
                    Log.w("xbrowser", "doLogHistoryDb failed", e);
                }
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused2) {
                }
            } catch (Throwable th) {
                try {
                    writableDatabase.endTransaction();
                } catch (Exception unused3) {
                }
                throw th;
            }
        } catch (Exception e2) {
            Log.w("xbrowser", "logHistory outer failed", e2);
        }
    }

    public void m6332k1() {
        Intent intent = new Intent("android.intent.action.GET_CONTENT");
        intent.setType("text/*");
        intent.addCategory("android.intent.category.OPENABLE");
        startActivityForResult(intent, 84);
    }

    public final String m6333k2(Uri uri, boolean z) throws IOException {
        String strM3803e = C0801Ra.m3798f().m3803e(uri);
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
        C2390tl.m9731f().m9735e(str);
        String strM6882V = SharedPreferencesHelper.getInstance().getSearchUrl();
        String strM5602i = PhoneUtils.getInstance().getSimOrNetworkCountryCode();
        if (strM5602i == null) {
            strM5602i = "";
        }
        try {
            strM6882V = strM6882V.replace("%keywords%", URLEncoder.encode(str, "utf-8"));
            strReplace = strM6882V.replace("%country_code%", strM5602i);
        } catch (Exception e) {
            e.printStackTrace();
            strReplace = strM6882V.replace("%keywords%", str).replace("%country_code%", strM5602i);
        }
        C1344c1.m5691d().m5698h("Search Times", "search_times");
        C1344c1.m5691d().m5698h("Search Times By Channel", "search_times/" + PhoneUtils.getInstance().getChannelCode());
        String host = Uri.parse(strReplace).getHost();
        C1344c1.m5691d().m5698h("Search Times By Domain", "search_times/" + host);
        try {
            FirebaseAnalytics firebaseAnalytics = FirebaseAnalytics.getInstance(this);
            firebaseAnalytics.m5981b(true);
            Bundle bundle = new Bundle();
            bundle.putString("domain", host);
            bundle.putString("country_code", strM5602i);
            firebaseAnalytics.m5980a("search_times", bundle);
        } catch (Throwable unused) {
        }
        if (z) {
            openUrl(strReplace, true, 0);
        } else {
            m6307d2(strReplace);
        }
        C1825ha.m7824d().m7828e(4);
        if (SharedPreferencesHelper.getInstance().enterPrivateMode) {
            return;
        }
        backgroundExecutor.execute(new UrlProcessRunnable(str));
    }

    public boolean m6338m1() {
        String strMo1573b = ((InterfaceC1300b3) m6222J0().m9316y()).mo1573b();
        return strMo1573b != null && strMo1573b.indexOf("article_list_for_xb_readmode") > 0;
    }

    public void m6339m2(Handler handler) {
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                try {
                    if (!SharedPreferencesHelper.getInstance().acceptEula || SharedPreferencesHelper.getInstance().hideClipboardContent) {
                        return;
                    }
                    handleClipboardUrl((ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE));
                } catch (Exception unused) {
                }
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
        this.f4273t = new C0022Ac(this, this);
        this.f4274u = new GestureDetector(this, new GestureCallback());
        this.browserFrameLayout.setTouchHooker(new TouchEventHandler());
        this.browserFrameLayout.setEventListener(new FrameLayoutCallback());
        PullToRefreshHandler pullToRefreshHandler = new PullToRefreshHandler(this);
        this.f4240B = pullToRefreshHandler;
        pullToRefreshHandler.setBrowserFrameLayout(this.browserFrameLayout);
        this.browserFrameLayout.setOverscrollRefreshHandler(this.f4240B);
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
        C1199a3.m5090f().m5093d("event_app_to_page", "enter_edit_mode");
        this.f4264k = 3;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mark_toolbar_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = (LinearLayout) View.inflate(this, R.layout.toolbar_layout_bm_multi_sel, null);
        ((Button) linearLayout2.findViewById(R.id.select_all_bm)).setOnClickListener(new ItemSelectionTrackerListener());
        ((Button) linearLayout2.findViewById(R.id.delete_bookmarks)).setOnClickListener(new DeleteConfirmationListener());
        Button button = (Button) linearLayout2.findViewById(R.id.cut_bookmarks);
        if (z) {
            button.setOnClickListener(new ItemCutListener());
        } else {
            button.setVisibility(View.GONE);
        }
        ((Button) linearLayout2.findViewById(R.id.toolbar_btn_finish)).setOnClickListener(new ExitSelectionListener());
        linearLayout.addView(linearLayout2, layoutParams);
        getBrowserFrameLayout().m6465n();
    }

    public final void m6344o1() {
    }

    public void refreshQuickAccessUI() {
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) f4276w.m9316y();
                if (interfaceC1300b3 != null) {
                    interfaceC1300b3.mo5625f();
                }
            }
        });
    }

    @Override
    public void onActivityResult(int i, int i2, Intent intent) throws Throwable {
        String stringExtra;
        Toast toastMakeText;
        ValueCallback valueCallback;
        Uri uri;
        Uri[] uriArr;
        try {
            if (i == 32) {
                if (i2 == -1 && intent != null) {
                    stringExtra = intent.getStringExtra("SCAN_RESULT");
                    if (!TextUtils.isEmpty(stringExtra)) {
                        m6297b2(stringExtra);
                    }
                }
            } else if (i == 65) {
                if (i2 == -1) {
                    Toast.makeText(this, R.string.toast_import_bookmark, Toast.LENGTH_SHORT).show();
                    C1825ha.m7824d().m7831h(System.currentTimeMillis(), 22, intent.getDataString(), null);
                    C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
                }
            } else if (i == 84) {
                if (i2 == -1) {
                    String strM6330j2 = getFilePathFromIntent(intent);
                    if (strM6330j2 != null) {
                        C0600N1.m3257k().m3264m(strM6330j2);
                    } else {
                        toastMakeText = Toast.makeText(this, "import error", 0);
                        toastMakeText.show();
                    }
                }
            } else if (i == 68) {
                if (i2 == -1) {
                    String strM6330j22 = getFilePathFromIntent(intent);
                    if (strM6330j22 != null) {
                        ContentDataManager.getInstance().m6634p0(strM6330j22);
                    } else {
                        toastMakeText = Toast.makeText(this, "import error", 0);
                        toastMakeText.show();
                    }
                }
            } else if (i == 82) {
                if (i2 == -1) {
                    String strM6330j23 = getFilePathFromIntent(intent);
                    if (strM6330j23 != null) {
                        C2061mf.m8471f0().m8536h0(strM6330j23);
                    } else {
                        toastMakeText = Toast.makeText(this, "import error", 0);
                        toastMakeText.show();
                    }
                }
            } else if (i == 66) {
                if (i2 == -1) {
                    String strM6330j24 = getFilePathFromIntent(intent);
                    if (TextUtils.isEmpty(strM6330j24)) {
                        C2439uo.getInstance().m10211I();
                    } else {
                        C2439uo.getInstance().m10213K(strM6330j24);
                    }
                }
            } else if (i != 69) {
                if (i == 70) {
                    if (i2 == -1 && intent != null) {
                        stringExtra = intent.getStringExtra("result");
                        AndroidSystemUtils.m8701i(this, stringExtra);
                        m6297b2(stringExtra);
                    }
                } else if (i == 71) {
                    if (i2 == -1 && intent != null) {
                        stringExtra = intent.getStringExtra("SCAN_RESULT");
                        m6297b2(stringExtra);
                    }
                } else if (i == 72) {
                    if (i2 == -1) {
                        Uri data = intent.getData();
                        String type = intent.getType();
                        Intent intent2 = new Intent("android.intent.action.VIEW");
                        intent2.addFlags(1);
                        intent2.setDataAndType(data, type);
                        startActivity(intent2);
                    }
                } else if (i == 83) {
                    if (i2 == -1) {
                        String action = intent.getAction();
                        if (action.equals("action.open_url_or_search")) {
                            m6292a2(intent.getStringExtra("key-or-url"));
                        } else if (action.equals("action.do_search")) {
                            m6334l0(intent.getStringExtra("key-or-url"));
                        } else if (action.equals("action.active_tab")) {
                            m6364v(intent.getStringExtra("tab-id"));
                        } else if (action.equals("action.execute_cmd")) {
                            m6218I0().mo6439y(intent.getStringExtra("command"));
                        }
                    }
                } else if (i == 259 && this.f4272s != null) {
                    Intent intent3 = new Intent("android.intent.action.VIEW");
                    intent3.setFlags(1);
                    intent3.setDataAndType(this.f4272s, "application/vnd.android.package-archive");
                    startActivity(intent3);
                    this.f4272s = null;
                }
            }
            if (i != 16 || intent == null || this.f4247I == null) {
                if (i != 17 || (valueCallback = this.f4247I) == null) {
                    ValueCallback valueCallback2 = this.f4247I;
                    if (valueCallback2 != null) {
                        valueCallback2.onReceiveValue(new Uri[0]);
                        return;
                    }
                    return;
                }
                if (i2 == -1 && (uri = this.f4248J) != null) {
                    valueCallback.onReceiveValue(new Uri[]{uri});
                    this.f4247I = null;
                    this.f4248J = null;
                    return;
                }
                valueCallback.onReceiveValue(new Uri[0]);
            } else {
                String dataString = intent.getDataString();
                ClipData clipData = intent.getClipData();
                if (clipData != null) {
                    uriArr = new Uri[clipData.getItemCount()];
                    for (int i3 = 0; i3 < clipData.getItemCount(); i3++) {
                        uriArr[i3] = clipData.getItemAt(i3).getUri();
                    }
                } else {
                    uriArr = null;
                }
                if (dataString != null) {
                    uriArr = new Uri[]{Uri.parse(dataString)};
                }
                this.f4247I.onReceiveValue(uriArr);
            }
            this.f4247I = null;
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        int i = configuration.uiMode & 48;
        if (SharedPreferencesHelper.getInstance().followSystemDarkMode && i != SharedPreferencesHelper.getInstance().f4915l0) {
            SharedPreferencesHelper.getInstance().f4915l0 = i;
            m6186A0(i);
        }
        ((InterfaceC1300b3) m6222J0().m9316y()).onConfigurationChanged(configuration);
    }

    @Override
    public void onCreate(Bundle bundle) throws JSONException, Resources.NotFoundException, IOException {
        super.onCreate(bundle);
        this.decorView = getWindow().getDecorView();
        AndroidSystemUtils.startTiming("Browser Activity create");
        getWindow().getDecorView().setOnSystemUiVisibilityChangeListener(this);
        activity = this;
        this.f4270q = (int) getResources().getDimension(R.dimen.swipe_slop);
        if (SharedPreferencesHelper.getInstance().keepScreenOn) {
            getWindow().addFlags(128);
        }
        C1344c1.m5691d().m5695e();
        m6344o1();
        MenuConfigManager.getInstance().m7032o(this);
        C0600N1.m3257k().m3265n(this);
        C0988Vd.m4391d().m4395e(this);
        ThemeManager.getInstance().init(this);
        C2363t3.m9665a().m9667c(this);
        ContentDataManager.getInstance().m6640r0(this);
        C1199a3.m5090f().m5095g(this);
        C2061mf.m8471f0().m8537i0();
        C2390tl.m9731f().m9739j();
        BrowserDownloadManager.m6674q().m6702s(this);
        C2406u0.m9882f().m9888g(this);
        C1224ai.m5285e().m5298n(this);
        C0801Ra.m3798f().m3804g(this);
        VideoSniffingManager.getInstance().m7006q(this);
        C1651dn.m7356c().m7357d(this);
        C2564xb.m10653b().m10655c(this);
        C0356Ho.m1604i().m1608k(this);
        C0310Go.m1445b().m1446c(this);
        C0462K1.m2249b().m2253e(this);
        WebIconDatabase.getInstance().open(getDir("icons", 0).getPath());
        PhoneBrowserActivtyDelegate phoneBrowserActivtyDelegate = new PhoneBrowserActivtyDelegate(this);
        this.f4275v = phoneBrowserActivtyDelegate;
        phoneBrowserActivtyDelegate.mo6402K(bundle);
        C0848Sb.m4048n().m4050p(this);
        m6341n1();
        if (SharedPreferencesHelper.getInstance().getBoolean("show_splash", false)) {
            m6260S2();
            getHandler().postDelayed(new UpdateCheckRunnable(), 1500L);
        }
        FrameLayout frameLayout = (FrameLayout) findViewById(R.id.main_content);
        m6261T();
        C1346c3 c1346c3 = new C1346c3(this, frameLayout);
        this.f4276w = c1346c3;
        c1346c3.m9302Z(this);
        AndroidSystemUtils.logElapsedTime();
        m6208F2();
        boolean zM6306d1 = m6306d1(getIntent());
        m6367v2();
        if (!zM6306d1 && this.f4276w.m9280D() == 0) {
            openUrl(SharedPreferencesHelper.getInstance().m6857H(), true, 0);
        }
        m6324h3();
        Looper.myQueue().addIdleHandler(new InitializationIdleHandler());
        m6276W2();
        m6265U();
        if (SharedPreferencesHelper.getInstance().acceptEula && !SharedPreferencesHelper.getInstance().showFraudAlert) {
            m6269V();
        }
        m6211G1(false);
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
    public boolean onDoubleTap(MotionEvent motionEvent) {
        String strM6855G = SharedPreferencesHelper.getInstance().m6855G("double_click_blank");
        String strM6234M0 = m6234M0();
        if (TextUtils.isEmpty(strM6234M0) || !strM6234M0.startsWith("x:home") || SharedPreferencesHelper.getInstance().getBoolean("show-qa-icons", true) || !(strM6855G.equals("not_set") || strM6855G.equals("none"))) {
            return m6218I0().mo6439y(strM6855G);
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
        if (!SharedPreferencesHelper.getInstance().supportSwitchTabGesture || MessageBoxManager.getInstance().isShowing() || !getBrowserFrameLayout().m6470s((int) motionEvent.getX(), (int) motionEvent.getY()) || (iAbs = (int) Math.abs(motionEvent2.getX() - motionEvent.getX())) <= ((int) Math.abs(motionEvent2.getY() - motionEvent.getY())) || iAbs <= this.f4270q) {
            return false;
        }
        if (motionEvent.getX() < motionEvent2.getX()) {
            m6222J0().m9291O();
            return true;
        }
        if (motionEvent.getX() <= motionEvent2.getX()) {
            return true;
        }
        m6222J0().m9290N();
        return true;
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
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
                this.f4275v.mo6416Y();
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
            if (m6217I()) {
                m6291a1();
                return true;
            }
            if (m6222J0().m9280D() > 1) {
                boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("close-tab-in-order", false);
                AbstractC2274r6.d dVarM9277A = this.f4276w.m9277A();
                if (zM6873Q || TextUtils.isEmpty(dVarM9277A.f6890c) || this.f4276w.m9281E(dVarM9277A.f6890c) < 0) {
                    this.f4275v.mo6431k();
                } else {
                    this.f4276w.m9300X(dVarM9277A.f6890c);
                    m6222J0().m9294R(dVarM9277A.m9339r());
                    m6324h3();
                }
                return true;
            }
            if (!this.f4258e && !SharedPreferencesHelper.getInstance().showExitConfirmDialog) {
                this.f4258e = true;
                Toast.makeText(this, R.string.toast_repeat_to_exit, Toast.LENGTH_SHORT).show();
                return false;
            }
            m6369w0();
        }
        return true;
    }

    @Override
    public boolean onKeyLongPress(int i, KeyEvent keyEvent) {
        this.f4261h = true;
        if (m6362u1()) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
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
        if (!this.f4261h && m6362u1()) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
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
        this.f4261h = false;
        return super.onKeyUp(i, keyEvent);
    }

    @Override
    public void onLongPress(MotionEvent motionEvent) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
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
    public void onNewIntent(Intent intent) throws IOException {
        super.onNewIntent(intent);
        m6306d1(intent);
    }

    @Override
    public void onPause() throws JSONException {
        super.onPause();
        if (!this.f4263j) {
            this.f4259f = true;
        }
        C1344c1.m5691d().m5700j();
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo1576g();
        }
        C0848Sb.m4048n().m4051q();
    }

    @Override
    public void onRequestPermissionsResult(int i, String[] strArr, int[] iArr) throws Resources.NotFoundException {
        Toast toastMakeText;
        super.onRequestPermissionsResult(i, strArr, iArr);
        if (iArr == null || iArr.length <= 0) {
            return;
        }
        if (i == 256) {
            if (iArr[0] == -1) {
                m6359t2(getResources().getString(R.string.perm_this_feature));
                return;
            }
        } else {
            if (i == 261) {
                if (iArr[0] == 0) {
                    m6323h2();
                    return;
                }
                return;
            }
            if (i != 258) {
                if (i == 257) {
                    toastMakeText = iArr[0] == -1 ? Toast.makeText(this, "request  permit failed ", 0) : Toast.makeText(this, R.string.toast_grant_perm_ok, 0);
                } else if (i == 262 || i == 263) {
                    if (iArr[0] != -1) {
                        PermissionRequest permissionRequest = this.f4249K;
                        if (permissionRequest != null) {
                            permissionRequest.grant(permissionRequest.getResources());
                            this.f4249K = null;
                            return;
                        }
                        return;
                    }
                } else {
                    if (i != 260 || iArr[0] == -1) {
                        return;
                    }
                }
                toastMakeText.show();
            }
            if (iArr[0] == -1) {
                return;
            }
        }
        toastMakeText = Toast.makeText(this, R.string.toast_grant_perm_ok, 1);
        toastMakeText.show();
    }

    @Override
    public void onResume() throws JSONException {
        super.onResume();
        ThemeManager.getInstance().m9478F(this);
        C1344c1.m5691d().m5701k();
        this.f4262i = true;
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 != null) {
            interfaceC1300b3.mo1584u();
        }
        this.f4259f = false;
        this.f4263j = false;
        if (this.f4260g) {
            m6229L();
        }
        Looper.myQueue().addIdleHandler(new MessageQueue.IdleHandler() {
            @Override
            public boolean queueIdle() {
                C1825ha.m7824d().m7828e(1);
                return false;
            }
        });
        if (!SharedPreferencesHelper.getInstance().f4849D) {
            m6218I0().m6394C().m1437t();
        }
        m6339m2(getHandler());
        WebViewBrowserController.f4695K = 0;
    }

    @Override
    public void onSaveInstanceState(Bundle bundle) throws Resources.NotFoundException {
        super.onSaveInstanceState(bundle);
        if (this.f4259f) {
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
        if (!SharedPreferencesHelper.getInstance().disableJavascript || ((WebViewBrowserController) m6210G0()).m6770F0().getSettings().getJavaScriptEnabled() || TextUtils.isEmpty(strM6234M0) || !(strM6234M0.startsWith("x:") || strM6234M0.startsWith("file:///"))) {
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
        if (!this.f4263j) {
            this.f4259f = true;
        }
        if (this.f4259f && (strM6234M0 = m6234M0()) != null && strM6234M0.startsWith("http") && (host = Uri.parse(strM6234M0).getHost()) != null && SiteSettingsManager.getInstance().m6961c(host)) {
            m6207F1();
        }
    }

    @Override
    public void onSystemUiVisibilityChange(int i) {
    }

    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 != null && interfaceC1300b3.mo5630p(motionEvent)) {
            return true;
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void onTrimMemory(int i) {
        super.onTrimMemory(i);
        this.f4259f = true;
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
                    return this.f3382a.m6366v1(view, c1045Wo);
                }
            });
        }
    }

    public void m6348p2(boolean z) {
        String str;
        String str2;
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        if (interfaceC1300b3 != null) {
            String strMo1573b = interfaceC1300b3.mo1573b();
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
        C2061mf.m8471f0().m8542n0(((WebViewBrowserController) m6222J0().m9316y()).m6770F0(), "mark_ad");
        this.f4264k = 1;
        LinearLayout linearLayout = (LinearLayout) findViewById(R.id.mark_toolbar_container);
        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(-1, -1);
        LinearLayout linearLayout2 = (LinearLayout) ThemeManager.getInstance().m9488i();
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_expand)).setOnClickListener(new ParentElementSelectorListener());
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_reduce)).setOnClickListener(new ChildElementSelectorListener());
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_save)).setOnClickListener(new ElementHiderListener());
        ((ImageButton) linearLayout2.findViewById(R.id.toolbar_btn_exit)).setOnClickListener(new CloseEditModeListener());
        linearLayout.addView(linearLayout2, layoutParams);
        getBrowserFrameLayout().m6465n();
        m6189B();
    }

    public void m6350q1(String str) {
        runOnUiThread(new WebViewScriptRunnable(str));
    }

    public void m6351q2(String str, String str2) {
        MySQLiteOpenHelper.getInstance().m7494G0(str);
        runOnUiThread(new HistoryItemDeleteAnalyticsRunnable(str2));
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
            m6245P(SharedPreferencesHelper.getInstance().f4872O0 ? SharedPreferencesHelper.getInstance().nightBrightness : -1);
        } else {
            window.setBackgroundDrawableResource(R.drawable.white);
            ThemeManager.getInstance().m9481b(this, "light");
            SharedPreferencesHelper.getInstance().enterNightMode = false;
            SharedPreferencesHelper.getInstance().loadGoodForEyeColor();
            m6245P(-1);
            C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
        }
        if (Build.VERSION.SDK_INT >= 33) {
            m6193C(z);
        }
        m6298b3();
        m6280X2();
        m6361u0("document.dispatchEvent(new CustomEvent('themechange'))");
    }

    public void m6353r1(String str) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f4276w.m9316y();
        if (interfaceC1300b3 instanceof WebViewBrowserController) {
            C2061mf.m8471f0().m8483C(((WebViewBrowserController) interfaceC1300b3).m6770F0(), str);
        }
    }

    public void m6354r2() {
        String strM6234M0 = m6234M0();
        if (TextUtils.isEmpty(strM6234M0)) {
            return;
        }
        new DialogC0076Bk(this, strM6234MToast.LENGTH_SHORT).show();
    }

    public void m6355s0(boolean z) {
        m6357t0(z, true);
    }

    public void m6356s2(Uri uri) {
        runOnUiThread(new ApkInstallPermissionRunnable(uri));
    }

    public void m6357t0(boolean z, boolean z2) {
        if (z2) {
            SharedPreferencesHelper.getInstance().enterPrivateMode = z;
            SharedPreferencesHelper.getInstance().putBoolean("enter-private-mode", z);
            int iM9280D = m6222J0().m9280D();
            for (int i = 0; i < iM9280D; i++) {
                ArrayList arrayListM9279C = m6222J0().m9279C(i);
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
            InterfaceC1300b3 interfaceC1300b32 = (InterfaceC1300b3) m6222J0().m9316y();
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
        m6218I0().m6394C().m1441x(z);
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

    public void m6359t2(String str) {
        runOnUiThread(new SdCardPermissionRunnable(str));
    }

    public void m6360u() {
        this.f4263j = true;
        runOnUiThread(new SearchBarLaunchRunnable());
    }

    public void m6361u0(String str) {
        runOnUiThread(new PageTitleUpdateRunnable(str));
    }

    public final boolean m6362u1() {
        return SharedPreferencesHelper.getInstance().supportVolumePageDown && getResources().getConfiguration().orientation == 1;
    }

    public void m6363u2() {
        AbsBrowserController absBrowserControllerM6210G0 = m6210G0();
        if (absBrowserControllerM6210G0 instanceof WebViewBrowserController) {
            ((WebViewBrowserController) absBrowserControllerM6210G0).m6791a1();
        }
    }

    public final void m6364v(String str) {
        BrowserControllerListener browserControllerListenerM6218I0 = m6218I0();
        if (browserControllerListenerM6218I0 instanceof InterfaceC0575Md) {
            ((InterfaceC0575Md) browserControllerListenerM6218I0).mo2860c(str);
            getActivity().getBrowserFrameLayout().requestFocus();
        }
    }

    public void m6365v0() {
        this.f4264k = 0;
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
            this.f4276w.m9295S(sharedPreferencesM6278X0);
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
        } else if (i <= 1) {
            return;
        }
        m6248P2();
    }

    public void m6368w(String str, String str2, String str3, boolean z) {
        m6372x(str, str2, str3, z, false);
    }

    public void m6369w0() {
        m6211G1(true);
        if (SharedPreferencesHelper.getInstance().showExitConfirmDialog) {
            new ExitConfirmDialog(this).show();
        } else {
            finish();
        }
    }

    public final C1045Wo m6370w1(View view, C1045Wo c1045Wo) {
        if (m6201E(c1045Wo)) {
            m6197D(c1045Wo);
        } else {
            m6216H2();
        }
        return C1045Wo.f3118b;
    }

    public void m6371w2() {
        while (this.f4239A.size() > 0) {
            m6375x2();
        }
    }

    public void m6372x(String str, String str2, String str3, boolean z, boolean z2) throws JSONException, Resources.NotFoundException {
        Toast toastMakeText;
        String str4;
        if (TextUtils.isEmpty(str) && !z2) {
            str4 = "title not allow empty";
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
                    toastMakeText = Toast.makeText(this, z ? R.string.toast_add_bm_dir : R.string.toast_add_to_bm, 0);
                    toastMakeText.show();
                }
                m6255R1(str, str2, str3);
                C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
            }
            str4 = "url not allow empty";
        }
        toastMakeText = Toast.makeText(this, str4, 0);
        toastMakeText.show();
        m6255R1(str, str2, str3);
        C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
    }

    public void m6373x0() {
        getHandler().postDelayed(new ExitEditModeRunnable(), 200L);
    }

    public void m6374x1() {
        try {
            if (Build.VERSION.SDK_INT >= 29) {
                Intent intent = new Intent("android.intent.action.GET_CONTENT");
                Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
                intent.addCategory("android.intent.category.OPENABLE");
                intent.setDataAndType(uri, "*/*");
                startActivityForResult(intent, 72);
            } else {
                Intent intent2 = new Intent();
                intent2.setAction("android.intent.action.VIEW_DOWNLOADS");
                startActivity(intent2);
            }
        } catch (Exception unused) {
        }
    }

    public void m6375x2() {
        if (this.f4239A.size() > 0) {
            ArrayList arrayList = this.f4239A;
            openUrl((String) arrayList.remove(arrayList.size() - 1), true, 0);
            m6324h3();
        }
    }

    public void m6376y(String str, String str2, int i) {
        m6380z(AndroidSystemUtils.m8713u(), str, str2, i);
    }

    public void m6377y0() {
        this.f4264k = 0;
        getBrowserFrameLayout().m6466o(SharedPreferencesHelper.getInstance().getDefaultLayoutType());
        ContentDataManager.getInstance().m6636q(true);
        m6361u0("exitSelectionMode()");
        m6189B();
    }

    public void m6378y1(int i) {
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) m6222J0().m9316y();
        String strMo1573b = interfaceC1300b3.mo1573b();
        if (this.f4264k == 1) {
            m6377y0();
            return;
        }
        if (!strMo1573b.startsWith("http") || !(interfaceC1300b3 instanceof WebViewBrowserController)) {
            Toast.makeText(this, R.string.toast_current_page_not_support_ad_mark, Toast.LENGTH_SHORT).show();
            return;
        }
        m6349q0();
        if (i == 0) {
            C2363t3.m9665a().m9673i(17, false);
        }
    }

    public void m6379y2() throws Resources.NotFoundException {
        AndroidSystemUtils.startTiming("save-tabs");
        this.f4276w.m9297U(m6278X0());
        AndroidSystemUtils.logElapsedTime();
        Log.i("save-state", " >>>>>call on save Instance");
        AbstractC1807h2.m7778a(new Runnable() {
            @Override
            public void run() {
                C1825ha.m7824d().m7828e(2);
            }
        });
        SharedPreferencesHelper.getInstance().f4899d0 = false;
        Log.i("save-state", " >>>>> on save Instance finished >>>>>>  ");
        ContentDataManager.getInstance().m6621i1();
    }

    public void m6380z(String str, String str2, String str3, int i) throws Resources.NotFoundException {
        Toast toastMakeText;
        String str4;
        if (TextUtils.isEmpty(str2)) {
            str4 = "title not allow empty";
        } else {
            if (!TextUtils.isEmpty(str3)) {
                SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
                if (!str3.toLowerCase().startsWith("http") && !str3.startsWith("x:") && !str3.startsWith("file://")) {
                    str3 = "http://" + str3.trim();
                }
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", str2);
                contentValues.put("url", str3);
                contentValues.put("create_at", Long.valueOf(System.currentTimeMillis()));
                contentValues.put("item_type", Integer.valueOf(i));
                contentValues.put("parent", "root");
                contentValues.put("status", (Integer) 0);
                contentValues.put("item_order", Integer.valueOf(MySQLiteOpenHelper.getInstance().getMaxColumnValue(writableDatabase, "quick_access", "item_order", "")));
                if (MySQLiteOpenHelper.getInstance().isUrlInQuickAccess(writableDatabase, str3)) {
                    writableDatabase.update("quick_access", contentValues, "url= ?", new String[]{str3});
                } else {
                    writableDatabase.insert("quick_access", null, contentValues);
                }
                toastMakeText = Toast.makeText(this, R.string.toast_add_new_quick_access, 0);
                toastMakeText.show();
                C1089Xm.getInstance().m4822j("syncable_quick_access").incrementVersion();
            }
            str4 = "url not allow empty";
        }
        toastMakeText = Toast.makeText(this, str4, 0);
        toastMakeText.show();
        C1089Xm.getInstance().m4822j("syncable_quick_access").incrementVersion();
    }

    public void m6381z0() {
        C1039Wi.m4517p().m4521m();
        m6218I0().mo6431k();
    }

    public void m6382z1() {
        if (!m6285Z("android.permission.CAMERA")) {
            new QrScannerDialog(this).m5643d(getString(R.string.message_permission_request), getString(R.string.message_request_perm_camera_for_qrcode));
            return;
        }
        C0024Ae c0024Ae = new C0024Ae(this);
        c0024Ae.m129i("QR_CODE");
        c0024Ae.m130j(false);
        c0024Ae.m131k(32);
        c0024Ae.m128h(QrScanActivity.class);
        c0024Ae.m127f();
    }

    public void m6383z2(String str) {
        String str2 = "/" + str;
        try {
            ArrayList arrayListM9286J = m6222J0().m9286J();
            if (m6358t1(str2)) {
                MySQLiteOpenHelper.getInstance().getWritableDatabase().delete("bookmark", "parent= ?", new String[]{str2});
            } else {
                ContentValues contentValues = new ContentValues();
                contentValues.put("title", str);
                contentValues.put("url", str2);
                contentValues.put("parent", "/");
                contentValues.put("type", 1);
                contentValues.put("last_visit", System.currentTimeMillis());
                contentValues.put("status", 1);
                MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues);
            }
            for (int i = 0; i < arrayListM9286J.size(); i++) {
                AbstractC2274r6.d dVar = (AbstractC2274r6.d) arrayListM9286J.get(i);
                InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) dVar.m9333l();
                if (interfaceC1300b3 != null) {
                    String strMo1574c = interfaceC1300b3.mo1574c();
                    String strMo1573b = interfaceC1300b3.mo1573b();
                    if (strMo1573b.indexOf("_tab-id_") < 0) {
                        strMo1573b = NetworkUtils.appendQueryParam(strMo1573b, "_tab-id_=" + dVar.m9339r());
                    }
                    ContentValues contentValues2 = new ContentValues();
                    contentValues2.put("title", strMo1574c);
                    contentValues2.put("url", strMo1573b);
                    contentValues2.put("parent", str2);
                    contentValues2.put("type", 0);
                    contentValues2.put("last_visit", System.currentTimeMillis());
                    contentValues2.put("status", 1);
                    MySQLiteOpenHelper.getInstance().addPendingEntry(contentValues2);
                }
            }
            MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("bookmark", false);
            Toast.makeText(this, String.format(getString(R.string.toast_all_tabs_saved), Integer.valueOf(arrayListM9286J.size())), Toast.LENGTH_LONG).show();
        } catch (Exception unused) {
        }
    }
}
