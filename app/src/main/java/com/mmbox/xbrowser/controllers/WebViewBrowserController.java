package com.mmbox.xbrowser.controllers;

import android.R;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.net.http.SslCertificate;
import android.net.http.SslError;
import android.os.Build;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.MessageQueue;
import android.os.Parcel;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.view.GestureDetector;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.webkit.ConsoleMessage;
import android.webkit.CookieManager;
import android.webkit.DownloadListener;
import android.webkit.GeolocationPermissions;
import android.webkit.HttpAuthHandler;
import android.webkit.PermissionRequest;
import android.webkit.RenderProcessGoneDetail;
import android.webkit.SslErrorHandler;
import android.webkit.ValueCallback;
import android.webkit.WebBackForwardList;
import android.webkit.WebChromeClient;
import android.webkit.WebResourceRequest;
import android.webkit.WebResourceResponse;
import android.webkit.WebStorage;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.AbstractScrollableListController;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserActivityDelegate;
import com.mmbox.xbrowser.BrowserControllerListener;
import com.mmbox.xbrowser.ContentDataManager;
import com.mmbox.xbrowser.SiteSettingsManager;
import com.mmbox.xbrowser.VideoSniffingManager;
import com.mmbox.xbrowser.MenuConfigManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.net.URISyntaxException;
import java.nio.charset.StandardCharsets;
import java.text.DateFormat;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

import p000.NetworkUtils;
import p000.JsonUtils;
import p000.FileUtils;
import p000.AbstractC1761g3;
import p000.AndroidSystemUtils;
import p000.AbstractC2129o0;
import p000.AbstractC2320s6;
import p000.AbstractDialogC0814Rn;
import p000.AbstractDialogC1303b6;
import p000.C0219Ep;
import p000.C0232F1;
import p000.C0310Go;
import p000.C0356Ho;
import p000.ResourceCacheManager;
import p000.C0462K1;
import p000.C0896Td;
import p000.C1039Wi;
import p000.PhoneUtils;
import p000.C1344c1;
import p000.C1825ha;
import p000.C2061mf;
import p000.ThemeManager;
import p000.C2480vj;
import p000.C2564xb;

/* loaded from: classes.dex */
public class WebViewBrowserController extends AbsBrowserController implements AbstractScrollableListController.b, View.OnClickListener {

    public static final FrameLayout.LayoutParams f4693I = new FrameLayout.LayoutParams(-1, -1);

    public static final FrameLayout.LayoutParams f4694J = new FrameLayout.LayoutParams(-2, -2);

    public static int f4695K = 0;

    public static boolean f4696L = false;

    public static String f4697M = null;

    public static final ByteArrayInputStream f4698N = new ByteArrayInputStream("".getBytes());

    public static ArrayList f4699O = new ArrayList<>(3);

    public static String f4700P = null;

    public View f4701A;

    public FrameLayout f4702B;

    public C1542A f4703C;

    public ViewGroup f4704D;

    public WebChromeClient.CustomViewCallback f4705E;

    public boolean f4706F;

    public final WebChromeClient f4707G;

    public final WebViewClient f4708H;

    public int f4709i;

    public boolean f4710j;

    public int f4711k;

    public int f4712l;

    public int[] f4713m;

    public final int f4714n;

    public final int f4715o;

    public WebView f4716p;

    public WebView f4717q;

    public boolean f4718r;

    public boolean f4719s;

    public WebView.HitTestResult f4720t;

    public int f4721u;

    public String f4722v;

    public boolean f4723w;

    public String f4724x;

    public String f4725y;

    public String f4726z;

    public class C1542A extends FrameLayout {

        public final long f4727a;

        public Drawable f4728b;

        public Drawable f4729c;

        public Drawable f4730d;

        public Drawable f4731e;

        public int f4732f;

        public int f4733g;

        public final int f4734h;

        public final int f4735i;

        public int f4736j;

        public int f4737k;

        public int f4738l;

        public final GestureDetector f4739m;

        public Runnable f4740n;

        public int f4741o;

        public int f4742p;

        public class a extends GestureDetector.SimpleOnGestureListener {
            public a() {
            }

            @Override
            public boolean onDoubleTap(MotionEvent motionEvent) {
                C2061mf.m8471f0().m8483C(f4716p, "_XJSAPI_.play_or_pause_video()");
                return true;
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override
            public void run() {
                if (C1542A.this.f4738l == -1 && VideoSniffingManager.getInstance().m7000j().m3552a()) {
                    C0310Go.m1445b().m1448e(C1542A.this);
                    C1542A.this.f4738l = 4;
                }
            }
        }

        public C1542A(Context context) {
            float f;
            super(context);
            this.f4727a = 500L;
            this.f4728b = null;
            this.f4729c = null;
            this.f4730d = null;
            this.f4731e = null;
            this.f4737k = 0;
            this.f4738l = -1;
            this.f4739m = new GestureDetector(browserActivity, new a());
            this.f4740n = new b();
            setBackgroundColor(context.getResources().getColor(R.color.black));
            this.f4728b = context.getResources().getDrawable(com.xbrowser.play.R.drawable.ic_volume);
            this.f4729c = context.getResources().getDrawable(com.xbrowser.play.R.drawable.ic_brighness);
            this.f4730d = context.getResources().getDrawable(com.xbrowser.play.R.drawable.ic_fast_ff);
            this.f4731e = context.getResources().getDrawable(com.xbrowser.play.R.drawable.ic_fast_back);
            this.f4734h = ViewConfiguration.get(context).getScaledTouchSlop();
            this.f4735i = (int) getResources().getDimension(com.xbrowser.play.R.dimen.fcb_gravity_y);
            try {
                f = Settings.System.getInt(browserActivity.getContentResolver(), "screen_brightness");
            } catch (Settings.SettingNotFoundException unused) {
                f = 110.0f;
            }
            int i = (int) ((f / 255.0f) * 100.0f);
            this.f4742p = i;
            this.f4741o = i;
        }

        /* JADX WARN: Removed duplicated region for block: B:11:0x0025  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final int m6816a(MotionEvent r7, int r8, int r9) {
            /*
                r6 = this;
                int r0 = r6.f4732f
                int r1 = r6.f4734h
                r2 = 2
                int r1 = r1 * r2
                r3 = 1
                if (r0 <= r1) goto L25
                int r1 = r6.getMeasuredWidth()
                int r4 = r6.f4734h
                int r5 = r4 * 2
                int r1 = r1 - r5
                if (r0 >= r1) goto L25
                int r0 = r6.f4733g
                int r4 = r4 * r2
                if (r0 <= r4) goto L25
                int r1 = r6.getMeasuredHeight()
                int r4 = r6.f4734h
                int r4 = r4 * r2
                int r1 = r1 - r4
                if (r0 >= r1) goto L25
                r0 = r3
                goto L26
            L25:
                r0 = 0
            L26:
                int r1 = java.lang.Math.abs(r8)
                int r4 = java.lang.Math.abs(r9)
                r5 = -1
                if (r1 <= r4) goto L71
                float r7 = r7.getY()
                int r8 = r6.getHeight()
                float r8 = (float) r8
                int r9 = r6.f4735i
                float r9 = (float) r9
                r1 = 1073741824(0x40000000, float:2.0)
                float r9 = r9 * r1
                float r8 = r8 - r9
                int r7 = (r7 > r8 ? 1 : (r7 == r8 ? 0 : -1))
                if (r7 >= 0) goto L70
                com.mmbox.xbrowser.f r7 = com.mmbox.xbrowser.VideoSniffingManager.m6988n()
                Pc r7 = r7.m7000j()
                int r7 = r7.f2130b
                if (r7 == 0) goto L70
                if (r0 == 0) goto L70
                com.mmbox.xbrowser.controllers.WebViewBrowserController r7 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                java.lang.String r7 = com.mmbox.xbrowser.controllers.WebViewBrowserController.m6734M(r7)
                boolean r7 = android.text.TextUtils.isEmpty(r7)
                if (r7 != 0) goto L70
                com.mmbox.xbrowser.f r7 = com.mmbox.xbrowser.VideoSniffingManager.m6988n()
                com.mmbox.xbrowser.controllers.WebViewBrowserController r8 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                java.lang.String r8 = com.mmbox.xbrowser.controllers.WebViewBrowserController.m6734M(r8)
                boolean r7 = r7.m7005p(r8)
                if (r7 != 0) goto L70
                return r3
            L70:
                return r5
            L71:
                float r1 = r7.getX()
                int r3 = r6.getWidth()
                int r3 = r3 / r2
                float r3 = (float) r3
                int r1 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
                if (r1 <= 0) goto L92
                int r1 = java.lang.Math.abs(r8)
                int r3 = r6.f4734h
                if (r1 >= r3) goto L92
                int r1 = java.lang.Math.abs(r9)
                int r3 = r6.f4734h
                if (r1 <= r3) goto L92
                if (r0 == 0) goto L92
                return r2
            L92:
                float r7 = r7.getX()
                int r1 = r6.getWidth()
                int r1 = r1 / r2
                float r1 = (float) r1
                int r7 = (r7 > r1 ? 1 : (r7 == r1 ? 0 : -1))
                if (r7 >= 0) goto Lb4
                int r7 = java.lang.Math.abs(r8)
                int r8 = r6.f4734h
                if (r7 >= r8) goto Lb4
                int r7 = java.lang.Math.abs(r9)
                int r8 = r6.f4734h
                if (r7 <= r8) goto Lb4
                if (r0 == 0) goto Lb4
                r7 = 3
                return r7
            Lb4:
                return r5
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.controllers.WebViewBrowserController.C1542A.m6816a(android.view.MotionEvent, int, int):int");
        }

        @Override
        public boolean dispatchTouchEvent(MotionEvent motionEvent) {
            C2564xb c2564xbM10653b;
            Drawable drawable;
            StringBuilder sb;
            int i;
            String strM8710r;
            String strM8710r2;
            C2564xb c2564xbM10653b2;
            Drawable drawable2;
            StringBuilder sb2;
            AbstractScrollableListController abstractC1540bMo6393A;
            if (SharedPreferencesHelper.getInstance().disableGestureInVideoFullscreen) {
                return super.dispatchTouchEvent(motionEvent);
            }
            int action = motionEvent.getAction();
            if (action == 0) {
                this.f4732f = (int) motionEvent.getX();
                this.f4733g = (int) motionEvent.getY();
                postDelayed(this.f4740n, 500L);
            }
            if (mo5626h() == 0 || mo5626h() == 8 || mo5626h() == 256) {
                if (action == 0) {
                    this.f4736j = C0462K1.m2249b().m2250a();
                    this.f4737k = -1;
                    if (this.f4732f < getWidth() - (this.f4734h * 2)) {
                        browserActivity.m6322h1();
                    }
                    C0356Ho.m1604i().m1610m(this);
                } else if (action == 2) {
                    int y = (int) motionEvent.getY();
                    int x = (int) motionEvent.getX();
                    int i2 = y - this.f4733g;
                    int i3 = x - this.f4732f;
                    if (this.f4738l == -1) {
                        this.f4738l = m6816a(motionEvent, i3, i2);
                    }
                    float fAbs = Math.abs(i3);
                    float fAbs2 = Math.abs(i2);
                    int i4 = this.f4738l;
                    if (i4 != 1) {
                        if (i4 == 3) {
                            if (Math.abs(i2) > Math.abs(i3)) {
                                if (i2 > 0) {
                                    int measuredHeight = this.f4742p - ((int) ((fAbs2 * 100.0f) / getMeasuredHeight()));
                                    this.f4741o = measuredHeight;
                                    if (measuredHeight < 0) {
                                        this.f4741o = 0;
                                    }
                                    c2564xbM10653b = C2564xb.m10653b();
                                    drawable = this.f4729c;
                                    sb = new StringBuilder();
                                } else if (i2 < 0) {
                                    int measuredHeight2 = this.f4742p + ((int) ((fAbs2 * 100.0f) / getMeasuredHeight()));
                                    this.f4741o = measuredHeight2;
                                    if (measuredHeight2 > 100) {
                                        this.f4741o = 100;
                                    }
                                    c2564xbM10653b = C2564xb.m10653b();
                                    drawable = this.f4729c;
                                    sb = new StringBuilder();
                                }
                                sb.append(this.f4741o);
                                sb.append("%");
                                c2564xbM10653b.m10657e(drawable, sb.toString());
                                BrowserActivity.getActivity().m6245P((int) ((this.f4741o / 100.0f) * 255.0f));
                            }
                        } else if (i4 == 2) {
                            if (i2 > 0) {
                                int measuredHeight3 = this.f4736j - ((int) ((fAbs2 * 100.0f) / getMeasuredHeight()));
                                int i5 = measuredHeight3 >= 0 ? measuredHeight3 : 0;
                                C2564xb.m10653b().m10657e(this.f4728b, i5 + "%");
                                C0462K1.m2249b().m2254f(i5);
                            } else if (i2 < 0) {
                                int measuredHeight4 = this.f4736j + ((int) ((fAbs2 * 100.0f) / getMeasuredHeight()));
                                int i6 = measuredHeight4 <= 100 ? measuredHeight4 : 100;
                                C2564xb.m10653b().m10657e(this.f4728b, i6 + "%");
                                C0462K1.m2249b().m2254f(i6);
                            }
                        }
                    } else if (Math.abs(i3) >= this.f4734h) {
                        int i7 = VideoSniffingManager.getInstance().m7000j().f2130b;
                        int i8 = VideoSniffingManager.getInstance().m7000j().f2131c;
                        if (i3 > 0) {
                            float measuredWidth = ((fAbs / getMeasuredWidth()) * 360.0f) + i8;
                            float f = i7;
                            if (measuredWidth > f) {
                                measuredWidth = f;
                            }
                            i = (int) measuredWidth;
                            strM8710r = AndroidSystemUtils.m8710r(i * 1000);
                            strM8710r2 = AndroidSystemUtils.m8710r(i7 * 1000);
                            c2564xbM10653b2 = C2564xb.m10653b();
                            drawable2 = this.f4730d;
                            sb2 = new StringBuilder();
                        } else if (i3 < 0) {
                            float fAbs3 = i8 - ((Math.abs(fAbs) / getMeasuredWidth()) * 360.0f);
                            if (fAbs3 < 0.0f) {
                                fAbs3 = 0.0f;
                            }
                            i = (int) fAbs3;
                            strM8710r = AndroidSystemUtils.m8710r(i * 1000);
                            strM8710r2 = AndroidSystemUtils.m8710r(i7 * 1000);
                            c2564xbM10653b2 = C2564xb.m10653b();
                            drawable2 = this.f4731e;
                            sb2 = new StringBuilder();
                        }
                        sb2.append(strM8710r);
                        sb2.append("/");
                        sb2.append(strM8710r2);
                        c2564xbM10653b2.m10657e(drawable2, sb2.toString());
                        this.f4737k = i;
                    }
                } else if (action == 3 || action == 1) {
                    C2564xb.m10653b().m10654a();
                    this.f4742p = this.f4741o;
                    if (this.f4737k >= 0) {
                        Log.i("video-seek", "seek " + this.f4737k);
                        C2061mf.m8471f0().m8483C(f4716p, "_XJSAPI_.change_video_seek(" + this.f4737k + ")");
                    }
                    removeCallbacks(this.f4740n);
                    if (this.f4738l == 4) {
                        C0310Go.m1445b().m1447d(this);
                    }
                    this.f4738l = -1;
                }
            } else if (action == 0 && (abstractC1540bMo6393A = browserActivity.m6218I0().mo6393A()) != null && abstractC1540bMo6393A.m9656x() && !abstractC1540bMo6393A.m9652q().contains(this.f4732f, this.f4733g)) {
                abstractC1540bMo6393A.m9655v();
            }
            if (this.f4739m.onTouchEvent(motionEvent)) {
                return true;
            }
            return super.dispatchTouchEvent(motionEvent);
        }
    }

    public class C1543a extends WebChromeClient {

        public class a implements MessageQueue.IdleHandler {

            public final String f4747a;

            public final WebView f4748b;

            public a(String str, WebView webView) {
                this.f4747a = str;
                this.f4748b = webView;
            }

            @Override
            public boolean queueIdle() {
                C1825ha.m7824d().m7830g(50, this.f4747a, this.f4748b.getUrl());
                return false;
            }
        }

        public class b extends AbstractDialogC0814Rn {

            public final FileChooserParams f4750f;

            public final String f4751g;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public b(Context context, FileChooserParams fileChooserParams, String str) {
                super(context);
                this.f4750f = fileChooserParams;
                this.f4751g = str;
            }

            @Override
            public void mo3829b() {
                browserActivity.f4247I.onReceiveValue(new Uri[0]);
                browserActivity.f4247I = null;
            }

            @Override
            public void mo3830c() {
                if (Build.VERSION.SDK_INT >= 33) {
                    browserActivity.startActivityForResult(this.f4750f.createIntent(), 16);
                } else {
                    C1543a c1543a = C1543a.this;
                    browserActivity.startActivityForResult(c1543a.m6821e(this.f4751g), 16);
                }
            }

            @Override
            public void mo3831d() {
                browserActivity.m6323h2();
            }
        }

        public class c implements MessageBoxBase.MessageBoxListener {

            public final String f4753a;

            public final PermissionRequest f4754b;

            public c(String str, PermissionRequest permissionRequest) {
                this.f4753a = str;
                this.f4754b = permissionRequest;
            }

            @Override
            public void onShown() {
                CheckBox checkBox = (CheckBox) browserActivity.findViewById(com.xbrowser.play.R.id.check_do_not_show);
                if (checkBox != null) {
                    if (checkBox.isChecked()) {
                        SiteSettingsManager.getInstance().m6965g(f4726z, this.f4753a, false);
                    } else {
                        SiteSettingsManager.getInstance().m6966h(f4726z, this.f4753a);
                    }
                }
                PermissionRequest permissionRequest = this.f4754b;
                permissionRequest.grant(permissionRequest.getResources());
            }

            @Override
            public void onDismissed() {
                CheckBox checkBox = (CheckBox) browserActivity.findViewById(com.xbrowser.play.R.id.check_do_not_show);
                if (checkBox == null || !checkBox.isChecked()) {
                    return;
                }
                SiteSettingsManager.getInstance().m6965g(f4726z, this.f4753a, false);
            }

            @Override
            public void onDismiss() {
            }
        }

        public class d implements MessageBoxBase.MessageBoxListener {

            public final GeolocationPermissions.Callback f4756a;

            public final String f4757b;

            public d(GeolocationPermissions.Callback callback, String str) {
                this.f4756a = callback;
                this.f4757b = str;
            }

            @Override
            public void onShown() {
                if (AbstractC2320s6.m9505a(browserActivity, "android.permission.ACCESS_FINE_LOCATION") != 0) {
                    AbstractC2129o0.m8827j(browserActivity, new String[]{"android.permission.ACCESS_FINE_LOCATION", "android.permission.ACCESS_COARSE_LOCATION"}, 258);
                }
                this.f4756a.invoke(this.f4757b, true, false);
                SiteSettingsManager.getInstance().m6967i(f4726z, true);
            }

            @Override
            public void onDismissed() {
                this.f4756a.invoke(this.f4757b, false, false);
            }

            @Override
            public void onDismiss() {
            }
        }

        public C1543a() {
        }

        public final Intent m6818b() {
            return new Intent("android.media.action.VIDEO_CAPTURE");
        }

        public final Intent m6819c() {
            Intent intent = new Intent("android.media.action.IMAGE_CAPTURE");
            File externalStoragePublicDirectory = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DCIM);
            StringBuilder sb = new StringBuilder();
            sb.append(externalStoragePublicDirectory.getAbsolutePath());
            String str = File.separator;
            sb.append(str);
            sb.append("browser-photos");
            File file = new File(sb.toString());
            file.mkdirs();
            intent.putExtra("output", Uri.fromFile(new File(file.getAbsolutePath() + str + System.currentTimeMillis() + ".jpg")));
            return intent;
        }

        public final Intent m6820d(Intent... intentArr) {
            Intent intent = new Intent("android.intent.action.CHOOSER");
            intent.putExtra("android.intent.extra.INITIAL_INTENTS", intentArr);
            intent.putExtra("android.intent.extra.TITLE", browserActivity.getString(com.xbrowser.play.R.string.choose_upload));
            return intent;
        }

        public final Intent m6821e(String str) {
            Intent intent = new Intent("android.intent.action.GET_CONTENT");
            intent.addCategory("android.intent.category.OPENABLE");
            intent.putExtra("android.intent.extra.ALLOW_MULTIPLE", true);
            intent.setType(str);
            return intent;
        }

        public final Intent m6822f() {
            return new Intent("android.provider.MediaStore.RECORD_SOUND");
        }

        public final void m6823g(String str, PermissionRequest permissionRequest, String str2) throws Resources.NotFoundException {
            MessageBoxManager.getInstance().showMessageFull(browserActivity.getBrowserFrameLayout(), null, str, BrowserActivity.getActivity().getResources().getString(com.xbrowser.play.R.string.btn_text_allow), BrowserActivity.getActivity().getResources().getString(com.xbrowser.play.R.string.btn_text_deny), new c(str2, permissionRequest), false, true);
        }

        public final String m6824h(String[] strArr) {
            if (strArr.length > 3) {
                return "*/*";
            }
            for (String str : strArr) {
                String str2 = "image/*";
                if (str.indexOf("image/*") < 0 && str.indexOf(".jpeg") < 0 && str.indexOf(".bmp") < 0 && str.indexOf(".png") < 0 && str.indexOf(".gif") < 0 && str.indexOf(".jpg") < 0 && str.indexOf(".webp") < 0) {
                    str2 = "video/*";
                    if (str.indexOf("video/*") < 0 && str.indexOf(".mp4") < 0 && str.indexOf(".mov") < 0 && str.indexOf(".avi") < 0 && str.indexOf(".3gp") < 0 && str.indexOf(".asf") < 0 && str.indexOf(".flv") < 0) {
                        str2 = "audio/*";
                        if (str.indexOf("audio/*") < 0 && str.indexOf(".mp3") < 0 && str.indexOf(".m4a") < 0 && str.indexOf(".wav") < 0 && str.indexOf(".wma") < 0 && str.indexOf(".ac3") < 0 && str.indexOf(".ogg") < 0) {
                        }
                    }
                }
                return str2;
            }
            return "*/*";
        }

        @Override
        public void onCloseWindow(WebView webView) {
            WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
            if (webView == webViewBrowserController.f4717q) {
                webViewBrowserController.m6765A0();
            } else {
                webViewBrowserController.browserControllerListener.mo6431k();
            }
        }

        @Override
        public boolean onConsoleMessage(ConsoleMessage consoleMessage) {
            String str = "Console: " + consoleMessage.message() + " " + consoleMessage.sourceId() + ":" + consoleMessage.lineNumber();
            int i = C1561s.f4829a[consoleMessage.messageLevel().ordinal()];
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
        public boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
            Log.i("new-window", ">>>>>>>>>> create new window >>>>>>>>>>");
            if (!mo5624a()) {
                return false;
            }
            if (z) {
                WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
                if (webViewBrowserController.f4717q != null) {
                    Toast.makeText(webViewBrowserController.browserActivity, "You create too many sub windows !", Toast.LENGTH_SHORT).show();
                    return false;
                }
            }
            WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
            if (z && z2) {
                m6814y0();
                webViewTransport.setWebView(f4717q);
                f4710j = true;
                message.sendToTarget();
                return true;
            }
            if (!z2) {
                return false;
            }
            f4726z = "";
            WebViewBrowserController webViewBrowserController2 = WebViewBrowserController.this;
            WebViewBrowserController webViewBrowserController3 = new WebViewBrowserController(webViewBrowserController2.browserActivity, webViewBrowserController2.browserControllerListener, true);
            webViewBrowserController3.f4726z = f4726z;
            webViewBrowserController3.f4688d = f4688d;
            webViewTransport.setWebView(webViewBrowserController3.m6770F0());
            message.sendToTarget();
            Log.i("newtab", ">>>>>>>>> on create new window>>>>>>");
            browserControllerListener.mo6419b(webViewBrowserController3);
            return true;
        }

        @Override
        public void onExceededDatabaseQuota(String str, String str2, long j, long j2, long j3, WebStorage.QuotaUpdater quotaUpdater) {
            Log.i(WebViewBrowserController.class.getName(), " ##### call not implements methond :onExceededDatabaseQuota");
        }

        @Override
        public void onGeolocationPermissionsHidePrompt() {
            Log.i(WebViewBrowserController.class.getName(), " ##### call not implements methond :onGeolocationPermissionsHidePrompt");
        }

        @Override
        public void onGeolocationPermissionsShowPrompt(String str, GeolocationPermissions.Callback callback) throws Resources.NotFoundException {
            if (!SharedPreferencesHelper.getInstance().m6916r()) {
                callback.invoke(str, false, false);
                return;
            }
            if (TextUtils.isEmpty(f4726z) || SiteSettingsManager.getInstance().m6940I(f4726z)) {
                String string = browserActivity.getString(com.xbrowser.play.R.string.message_allow_access_location);
                String string2 = BrowserActivity.getActivity().getResources().getString(com.xbrowser.play.R.string.btn_text_allow);
                SiteSettingsManager.Host hostVarM6982X = SiteSettingsManager.getInstance().getHost(13, f4726z);
                if (hostVarM6982X == null) {
                    MessageBoxManager.getInstance().showToast(BrowserActivity.getActivity().getBrowserFrameLayout(), string, string2, new d(callback, str));
                } else {
                    callback.invoke(str, hostVarM6982X.extra.equals("true"), false);
                }
            }
        }

        @Override
        public void onHideCustomView() {
            Log.i(WebViewBrowserController.class.getName(), " ##### call not implements methond :onHideCustomView");
            m6774J0();
            WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
            int i = webViewBrowserController.pageType;
            if (i == 0 || i == 8 || i == 256) {
                webViewBrowserController.browserActivity.m6264T2();
            }
            C0356Ho.m1604i().m1609l();
            browserActivity.m6276W2();
            int i2 = pageType;
        }

        @Override
        public void onPermissionRequest(PermissionRequest permissionRequest) throws Resources.NotFoundException {
            int i;
            Toast toastMakeText;
            for (String str : permissionRequest.getResources()) {
                String str2 = "android.webkit.resource.AUDIO_CAPTURE";
                if (str.equals("android.webkit.resource.AUDIO_CAPTURE")) {
                    if (browserActivity.checkSelfPermission("android.permission.RECORD_AUDIO") != 0) {
                        browserActivity.f4249K = permissionRequest;
                        browserActivity.requestPermissions(new String[]{"android.permission.RECORD_AUDIO"}, 262);
                        return;
                    } else {
                        if (SiteSettingsManager.getInstance().m6977s(f4726z, "android.webkit.resource.AUDIO_CAPTURE")) {
                            permissionRequest.grant(permissionRequest.getResources());
                            return;
                        }
                        if (SiteSettingsManager.getInstance().m6944M(f4726z, "android.webkit.resource.AUDIO_CAPTURE")) {
                            toastMakeText = Toast.makeText(browserActivity, browserActivity.getString(com.xbrowser.play.R.string.message_permission_deny), 1);
                            toastMakeText.show();
                            return;
                        } else {
                            i = com.xbrowser.play.R.string.message_allow_access_microphone;
                            m6823g(browserActivity.getString(i), permissionRequest, str2);
                            return;
                        }
                    }
                }
                str2 = "android.webkit.resource.VIDEO_CAPTURE";
                if (str.equals("android.webkit.resource.VIDEO_CAPTURE")) {
                    if (browserActivity.checkSelfPermission("android.permission.CAMERA") != 0) {
                        browserActivity.f4249K = permissionRequest;
                        browserActivity.requestPermissions(new String[]{"android.permission.CAMERA"}, 263);
                        return;
                    } else {
                        if (SiteSettingsManager.getInstance().m6977s(f4726z, "android.webkit.resource.VIDEO_CAPTURE")) {
                            permissionRequest.grant(permissionRequest.getResources());
                            return;
                        }
                        if (SiteSettingsManager.getInstance().m6944M(f4726z, "android.webkit.resource.VIDEO_CAPTURE")) {
                            toastMakeText = Toast.makeText(browserActivity, browserActivity.getString(com.xbrowser.play.R.string.message_permission_deny), 0);
                            toastMakeText.show();
                            return;
                        } else {
                            i = com.xbrowser.play.R.string.message_allow_access_camera;
                            m6823g(browserActivity.getString(i), permissionRequest, str2);
                            return;
                        }
                    }
                }
            }
        }

        @Override
        public void onProgressChanged(WebView webView, int i) {
            if (f4709i == 3 || f4688d.startsWith("file:///") || f4688d.startsWith("x:")) {
                return;
            }
            getBrowserControllerListener().mo6427g(WebViewBrowserController.this, i, !r0.mo5624a());
        }

        @Override
        public void onReceivedIcon(WebView webView, Bitmap bitmap) {
            getBrowserControllerListener().mo6448f(WebViewBrowserController.this, bitmap, !r0.mo5624a());
        }

        @Override
        public void onReceivedTitle(WebView webView, String str) {
            BrowserControllerListener browserControllerListenerM6730I = getBrowserControllerListener();
            WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
            browserControllerListenerM6730I.mo6449l(webViewBrowserController, str, webViewBrowserController.mo5624a());
            f4689e = str;
            Log.i("js-console", ">>>>>>> start on receive title");
            if (mo5624a()) {
                BrowserActivity.getActivity().f4243E = str;
            }
        }

        @Override
        public void onReceivedTouchIconUrl(WebView webView, String str, boolean z) {
            Log.i(WebViewBrowserController.class.getName(), " i touch icon in:" + str);
            Looper.myQueue().addIdleHandler(new a(str, webView));
        }

        @Override
        public void onShowCustomView(View view, int i, CustomViewCallback customViewCallback) {
            Log.i(WebViewBrowserController.class.getName(), " ##### call not implements methond :onShowCustomView2");
        }

        @Override
        public boolean onShowFileChooser(WebView webView, ValueCallback valueCallback, FileChooserParams fileChooserParams) {
            fileChooserParams.createIntent();
            String strM6824h = m6824h(fileChooserParams.getAcceptTypes());
            browserActivity.f4247I = valueCallback;
            if (fileChooserParams.isCaptureEnabled()) {
                new b(browserActivity, fileChooserParams, strM6824h).m3832e(browserActivity.getString(com.xbrowser.play.R.string.choose_upload), browserActivity.getString(com.xbrowser.play.R.string.btn_text_gallery), browserActivity.getString(com.xbrowser.play.R.string.btn_text_camera));
                return true;
            }
            if (Build.VERSION.SDK_INT >= 33) {
                browserActivity.startActivityForResult(fileChooserParams.createIntent(), 16);
                return true;
            }
            browserActivity.startActivityForResult(m6821e(strM6824h), 16);
            return true;
        }

        public void openFileChooser(ValueCallback<Uri> valueCallback, String str, String str2) {
            Intent intentM6820d;
            String[] strArrSplit = str.split(";");
            String str3 = strArrSplit[0];
            String str4 = str2.length() > 0 ? str2 : "filesystem";
            if (str2.equals("filesystem")) {
                for (String str5 : strArrSplit) {
                    String[] strArrSplit2 = str5.split("=");
                    if (strArrSplit2.length == 2 && "capture".equals(strArrSplit2[0])) {
                        str4 = strArrSplit2[1];
                    }
                }
            }
            String str6 = "image/*";
            if (!str3.equals("image/*")) {
                str6 = "video/*";
                if (!str3.equals("video/*")) {
                    str6 = "audio/*";
                    if (!str3.equals("audio/*")) {
                        Intent intent = new Intent("android.intent.action.GET_CONTENT");
                        intent.addCategory("android.intent.category.OPENABLE");
                        if (str.equals("")) {
                            str = "*/*";
                        }
                        intent.setType(str);
                        browserActivity.startActivityForResult(Intent.createChooser(intent, browserActivity.getString(com.xbrowser.play.R.string.choose_upload)), 16);
                        return;
                    }
                    if (str4.equals("microphone")) {
                        intentM6820d = m6822f();
                    } else {
                        intentM6820d = m6820d(m6822f());
                        intentM6820d.putExtra("android.intent.extra.INTENT", m6821e(str6));
                    }
                } else if (str4.equals("camcorder")) {
                    intentM6820d = m6818b();
                } else {
                    intentM6820d = m6820d(m6818b());
                    intentM6820d.putExtra("android.intent.extra.INTENT", m6821e(str6));
                }
            } else if (str4.equals("camera")) {
                intentM6820d = m6819c();
            } else {
                intentM6820d = m6820d(m6819c());
                intentM6820d.putExtra("android.intent.extra.INTENT", m6821e(str6));
            }
            browserActivity.startActivityForResult(intentM6820d, 16);
        }

        @Override
        public void onShowCustomView(View view, CustomViewCallback customViewCallback) {
            String str;
            if (mo5624a()) {
                if (f4701A != null) {
                    customViewCallback.onCustomViewHidden();
                    return;
                }
                browserActivity.m6322h1();
                WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
                webViewBrowserController.f4721u = webViewBrowserController.browserActivity.getRequestedOrientation();
                f4722v = SharedPreferencesHelper.getInstance().m6880U();
                WebViewBrowserController webViewBrowserController2 = WebViewBrowserController.this;
                int i = webViewBrowserController2.pageType;
                if (i != 0 && i != 8) {
                    webViewBrowserController2.browserActivity.setRequestedOrientation(10);
                } else if (i == 256 || ((str = webViewBrowserController2.f4725y) != null && str.equals("landscape"))) {
                    browserActivity.setRequestedOrientation(6);
                    f4725y = "landscape";
                } else {
                    String str2 = f4725y;
                    if (str2 == null || !str2.equals("portrait")) {
                        browserActivity.setRequestedOrientation(6);
                    } else {
                        browserActivity.setRequestedOrientation(7);
                        f4725y = "portrait";
                    }
                }
                FrameLayout frameLayout = (FrameLayout) browserActivity.getWindow().getDecorView();
                WebViewBrowserController webViewBrowserController3 = WebViewBrowserController.this;
                WebViewBrowserController webViewBrowserController4 = WebViewBrowserController.this;
                webViewBrowserController3.f4703C = webViewBrowserController4.new C1542A(webViewBrowserController4.browserActivity);
                f4703C.setId(13399);
                C1542A c1542a = f4703C;
                FrameLayout.LayoutParams layoutParams = WebViewBrowserController.f4693I;
                c1542a.addView(view, layoutParams);
                frameLayout.addView(f4703C, layoutParams);
                f4701A = view;
                m6796f1(true);
                f4705E = customViewCallback;
                browserActivity.f4265l = true;
            }
        }
    }

    public class RunnableC1544b implements Runnable {
        public RunnableC1544b() {
        }

        @Override
        public void run() {
            if (mo5624a()) {
                m6803m1();
            }
        }
    }

    public class C1545c implements DownloadListener {
        public C1545c() {
        }

        @Override
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            getBrowserControllerListener().mo6424e(str, f4690f, str2, str3, str4, j);
            if (f4717q.copyBackForwardList().getSize() == 0) {
                m6765A0();
            }
        }
    }

    public class ViewOnClickListenerC1546d implements View.OnClickListener {
        public ViewOnClickListenerC1546d() {
        }

        @Override
        public void onClick(View view) {
            f4707G.onCloseWindow(f4717q);
        }
    }

    public class RunnableC1547e implements Runnable {
        public RunnableC1547e() {
        }

        @Override
        public void run() {
            WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
            webViewBrowserController.m6801k1(webViewBrowserController.f4716p.getUrl());
        }
    }

    public class HandlerC1548f extends Handler {

        public final boolean f4763a;

        public final int f4764b;

        public HandlerC1548f(boolean z, int i) {
            this.f4763a = z;
            this.f4764b = i;
        }

        @Override
        public void handleMessage(Message message) throws URISyntaxException {
            String str = (String) message.getData().get("url");
            if (TextUtils.isEmpty(str)) {
                Toast.makeText(browserActivity, "can't obtain url", Toast.LENGTH_SHORT).show();
            } else {
                browserActivity.openUrl(str, this.f4763a, this.f4764b);
            }
        }
    }

    public class C1549g implements C0232F1.d {

        public final int f4766a;

        public final String f4767b;

        public class a implements Runnable {

            public final String f4769l;

            public final String f4770m;

            public a(String str, String str2) {
                this.f4769l = str;
                this.f4770m = str2;
            }

            @Override
            public void run() throws Resources.NotFoundException, IOException {
                C1549g c1549g = C1549g.this;
                m6771G0(c1549g.f4766a, this.f4769l, this.f4770m, c1549g.f4767b);
            }
        }

        public class b implements Runnable {
            public b() {
            }

            @Override
            public void run() {
                Toast.makeText(browserActivity, com.xbrowser.play.R.string.toast_download_image_fail, Toast.LENGTH_SHORT).show();
            }
        }

        public C1549g(int i, String str) {
            this.f4766a = i;
            this.f4767b = str;
        }

        @Override
        public void mo844a(String str, String str2) {
            browserActivity.runOnUiThread(new a(str, str2));
        }

        @Override
        public void mo845b() {
            browserActivity.runOnUiThread(new b());
        }
    }

    public class C1550h implements C0232F1.d {

        public final String f4773a;

        public final int f4774b;

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                C1550h c1550h = C1550h.this;
                m6799i1(c1550h.f4773a, c1550h.f4774b);
            }
        }

        public class b implements Runnable {

            public final String f4777l;

            public final String f4778m;

            public b(String str, String str2) {
                this.f4777l = str;
                this.f4778m = str2;
            }

            @Override
            public void run() throws Resources.NotFoundException, IOException {
                C1550h c1550h = C1550h.this;
                m6771G0(c1550h.f4774b, this.f4777l, this.f4778m, c1550h.f4773a);
            }
        }

        public C1550h(String str, int i) {
            this.f4773a = str;
            this.f4774b = i;
        }

        @Override
        public void mo844a(String str, String str2) {
            if (TextUtils.isEmpty(str2) || str2.indexOf("image") >= 0) {
                browserActivity.runOnUiThread(new b(str, str2));
            } else {
                browserActivity.runOnUiThread(new a());
            }
        }

        @Override
        public void mo845b() {
            m6799i1(this.f4773a, this.f4774b);
        }
    }

    public class HandlerC1551i extends Handler {
        public HandlerC1551i() {
        }

        @Override
        public void handleMessage(Message message) {
            C1825ha.m7824d().m7829f(19, (String) message.getData().get("url"));
            Toast.makeText(browserActivity, com.xbrowser.play.R.string.toast_add_to_rl, Toast.LENGTH_SHORT).show();
        }
    }

    public class HandlerC1552j extends Handler {

        public final int f4781a;

        public HandlerC1552j(int i) {
            this.f4781a = i;
        }

        @Override
        public void handleMessage(Message message) throws Resources.NotFoundException, IOException {
            String string = message.getData().getString("url");
            if (!TextUtils.isEmpty(string) && string.toLowerCase().startsWith("http")) {
                m6766B0(string, this.f4781a);
                return;
            }
            if (TextUtils.isEmpty(string) || !string.toLowerCase().startsWith("data:image/")) {
                if (TextUtils.isEmpty(string) || !string.toLowerCase().startsWith("blob:")) {
                    Toast.makeText(browserActivity, "not download from this url", Toast.LENGTH_SHORT).show();
                    return;
                } else {
                    browserActivity.m6361u0(browserActivity.m6214H0(string, null));
                    return;
                }
            }
            String[] strArrM470y = NetworkUtils.parseDataUriLegacy(string);
            if (strArrM470y.length > 0) {
                String str = strArrM470y[0];
                String str2 = strArrM470y[1];
                String str3 = strArrM470y[2];
                if (str2 == null || !str2.equals("base64")) {
                    return;
                }
                String strM468w = NetworkUtils.generateFileName(string, null, str);
                String str4 = PhoneUtils.getInstance().getCacheDirPath() + "/" + strM468w;
                if (Build.VERSION.SDK_INT < 29) {
                    String str5 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + strM468w;
                    FileUtils.writeBytesToFile(Base64.decode(str3, 0), str5);
                    m6773I0(this.f4781a, str5, str, null);
                    AndroidSystemUtils.scanMediaFile(browserActivity, str5);
                    return;
                }
                FileUtils.writeBytesToFile(Base64.decode(str3, 0), str4);
                Uri uriM8703k = AndroidSystemUtils.m8703k(browserActivity, System.currentTimeMillis() + "_" + strM468w, str, browserActivity.getString(com.xbrowser.play.R.string.app_name));
                if (uriM8703k != null) {
                    AndroidSystemUtils.m8698f(browserActivity, str4, uriM8703k);
                }
                m6773I0(this.f4781a, str4, str, uriM8703k);
            }
        }
    }

    public class HandlerC1553k extends Handler {
        public HandlerC1553k() {
        }

        @Override
        public void handleMessage(Message message) {
            AndroidSystemUtils.m8701i(browserActivity, message.getData().getString("url"));
            Toast.makeText(browserActivity, com.xbrowser.play.R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
        }
    }

    public class C1554l extends WebViewClient {

        public HttpAuthHandler f4784a;

        public AlertDialog f4785b;

        public CharSequence f4786c;

        public class a implements DialogInterface.OnClickListener {

            public final HttpAuthHandler f4788a;

            public a(HttpAuthHandler httpAuthHandler) {
                this.f4788a = httpAuthHandler;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4788a.cancel();
                C1554l.this.f4785b = null;
                C1554l.this.f4784a = null;
                C1554l.this.f4786c = null;
            }
        }

        public class b implements DialogInterface.OnClickListener {

            public final EditText f4790a;

            public final EditText f4791b;

            public final String f4792c;

            public final String f4793d;

            public final HttpAuthHandler f4794e;

            public b(EditText editText, EditText editText2, String str, String str2, HttpAuthHandler httpAuthHandler) {
                this.f4790a = editText;
                this.f4791b = editText2;
                this.f4792c = str;
                this.f4793d = str2;
                this.f4794e = httpAuthHandler;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                String string = this.f4790a.getText().toString();
                String string2 = this.f4791b.getText().toString();
                WebView webView = f4716p;
                if (webView != null) {
                    webView.setHttpAuthUsernamePassword(this.f4792c, this.f4793d, string, string2);
                }
                this.f4794e.proceed(string, string2);
                C1554l.this.f4785b = null;
                C1554l.this.f4784a = null;
                C1554l.this.f4786c = null;
            }
        }

        public class c implements Runnable {

            public final WebView f4796l;

            public c(WebView webView) {
                this.f4796l = webView;
            }

            @Override
            public void run() {
                ((C0219Ep) this.f4796l).f572w = false;
                Log.i("third-app", " do start load page........." + ((C0219Ep) this.f4796l).f572w);
            }
        }

        public class d implements Runnable {
            public d() {
            }

            @Override
            public void run() {
                if (mo5624a() && !mo1575e() && VideoSniffingManager.getInstance().m7000j().path == null && !VideoSniffingManager.getInstance().m7005p(f4726z)) {
                    browserActivity.m6361u0("if(window._XJSAPI_ != undefined) _XJSAPI_.sniff_media_res(false)");
                } else if (mo5624a()) {
                    String str = VideoSniffingManager.getInstance().m7000j().path;
                }
                browserActivity.m6361u0("if(window._XJSAPI_ != undefined) _XJSAPI_.check_user_script()");
            }
        }

        public class e implements Runnable {

            public final String f4799l;

            public e(String str) {
                this.f4799l = str;
            }

            @Override
            public void run() {
                if (mo5624a()) {
                    m6808s0(this.f4799l);
                }
            }
        }

        public class f extends AbstractDialogC1303b6 {

            public final Message f4801f;

            /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
            public f(Context context, Message message) {
                super(context);
                this.f4801f = message;
            }

            @Override
            public void mo315b() {
            }

            @Override
            public void mo316c() {
                this.f4801f.sendToTarget();
            }
        }

        public class g implements DialogInterface.OnCancelListener {

            public final SslErrorHandler f4803a;

            public g(SslErrorHandler sslErrorHandler) {
                this.f4803a = sslErrorHandler;
            }

            @Override
            public void onCancel(DialogInterface dialogInterface) {
                this.f4803a.cancel();
            }
        }

        public class h implements DialogInterface.OnClickListener {

            public final SslErrorHandler f4805a;

            public h(SslErrorHandler sslErrorHandler) {
                this.f4805a = sslErrorHandler;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4805a.cancel();
            }
        }

        public class i implements DialogInterface.OnClickListener {

            public final WebView f4807a;

            public final SslErrorHandler f4808b;

            public final SslError f4809c;

            public i(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                this.f4807a = webView;
                this.f4808b = sslErrorHandler;
                this.f4809c = sslError;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) throws ParseException {
                C1554l.this.m6832h(this.f4807a, this.f4808b, this.f4809c);
            }
        }

        public class j implements DialogInterface.OnClickListener {

            public final SslErrorHandler f4811a;

            public j(SslErrorHandler sslErrorHandler) {
                this.f4811a = sslErrorHandler;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                this.f4811a.proceed();
                f4723w = true;
            }
        }

        public class k implements DialogInterface.OnCancelListener {
            public k() {
            }

            @Override
            public void onCancel(DialogInterface dialogInterface) {
            }
        }

        public class l implements DialogInterface.OnClickListener {

            public final WebView f4814a;

            public final SslErrorHandler f4815b;

            public final SslError f4816c;

            public l(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
                this.f4814a = webView;
                this.f4815b = sslErrorHandler;
                this.f4816c = sslError;
            }

            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                f4708H.onReceivedSslError(this.f4814a, this.f4815b, this.f4816c);
            }
        }

        public class m implements DialogInterface.OnCancelListener {

            public final HttpAuthHandler f4818a;

            public m(HttpAuthHandler httpAuthHandler) {
                this.f4818a = httpAuthHandler;
            }

            @Override
            public void onCancel(DialogInterface dialogInterface) {
                this.f4818a.cancel();
                C1554l.this.f4785b = null;
                C1554l.this.f4784a = null;
                C1554l.this.f4786c = null;
            }
        }

        public C1554l() {
        }

        @Override
        public void doUpdateVisitedHistory(WebView webView, String str, boolean z) {
            if (m6777M0()) {
                m6797g1(webView, str);
                m6776L0();
                browserActivity.getHandler().postDelayed(new e(str), 50L);
            }
            getBrowserControllerListener().mo6433p(WebViewBrowserController.this, ResourceCacheManager.getInstance().m2046a(str, 2), z);
        }

        public final View m6829e(SslCertificate sslCertificate) throws ParseException {
            if (sslCertificate == null) {
                return null;
            }
            View viewInflate = LayoutInflater.from(browserActivity).inflate(com.xbrowser.play.R.layout.ssl_certificate, (ViewGroup) null);
            SslCertificate.DName issuedTo = sslCertificate.getIssuedTo();
            if (issuedTo != null) {
                ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.to_common)).setText(issuedTo.getCName());
                ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.to_org)).setText(issuedTo.getOName());
                ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.to_org_unit)).setText(issuedTo.getUName());
            }
            SslCertificate.DName issuedBy = sslCertificate.getIssuedBy();
            if (issuedBy != null) {
                ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.by_common)).setText(issuedBy.getCName());
                ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.by_org)).setText(issuedBy.getOName());
                ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.by_org_unit)).setText(issuedBy.getUName());
            }
            ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.issued_on)).setText(m6830f(sslCertificate.getValidNotBefore()));
            ((TextView) viewInflate.findViewById(com.xbrowser.play.R.id.expires_on)).setText(m6830f(sslCertificate.getValidNotAfter()));
            return viewInflate;
        }

        public final String m6830f(String str) throws ParseException {
            Date date;
            String str2 = null;
            if (str != null) {
                try {
                    date = DateFormat.getInstance().parse(str);
                } catch (ParseException unused) {
                    date = null;
                }
                if (date != null) {
                    str2 = android.text.format.DateFormat.getDateFormat(browserActivity).format(date);
                }
            }
            return str2 != null ? str2 : str != null ? str : "";
        }

        public final void m6831g(HttpAuthHandler httpAuthHandler, String str, String str2, String str3, String str4, String str5, int i2) {
            String str6;
            View viewInflate = View.inflate(browserActivity, com.xbrowser.play.R.layout.http_authentication, null);
            EditText editText = (EditText) viewInflate.findViewById(com.xbrowser.play.R.id.username_edit);
            EditText editText2 = (EditText) viewInflate.findViewById(com.xbrowser.play.R.id.password_edit);
            if (str4 != null) {
                editText.setText(str4);
            }
            if (str5 != null) {
                editText2.setText(str5);
            }
            if (str3 == null) {
                str6 = str + " : \"" + str2 + "\"";
            } else {
                str6 = str3;
            }
            this.f4786c = str6;
            this.f4784a = httpAuthHandler;
            AlertDialog alertDialogCreate = new AlertDialog.Builder(browserActivity).setTitle(str6).setIcon(R.drawable.ic_dialog_alert).setView(viewInflate).setPositiveButton(com.xbrowser.play.R.string.btn_text_ok, new b(editText, editText2, str, str2, httpAuthHandler)).setNegativeButton(com.xbrowser.play.R.string.btn_text_cancel, new a(httpAuthHandler)).setOnCancelListener(new m(httpAuthHandler)).create();
            alertDialogCreate.getWindow().setSoftInputMode(4);
            alertDialogCreate.show();
            if (i2 != 0) {
                alertDialogCreate.findViewById(i2).requestFocus();
            } else {
                editText.requestFocus();
            }
            this.f4785b = alertDialogCreate;
        }

        public final void m6832h(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) throws ParseException {
            View viewM6829e = m6829e(sslError.getCertificate());
            if (viewM6829e == null) {
                return;
            }
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(browserActivity);
            LinearLayout linearLayout = (LinearLayout) viewM6829e.findViewById(com.xbrowser.play.R.id.placeholder);
            if (sslError.hasError(3)) {
                ((TextView) ((LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, linearLayout)).findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_untrusted);
            }
            if (sslError.hasError(2)) {
                ((TextView) ((LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, linearLayout)).findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_mismatch);
            }
            if (sslError.hasError(1)) {
                ((TextView) ((LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, linearLayout)).findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_expired);
            }
            if (sslError.hasError(0)) {
                ((TextView) ((LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, linearLayout)).findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_not_yet_valid);
            }
            new AlertDialog.Builder(browserActivity).setTitle(com.xbrowser.play.R.string.ssl_certificate).setView(viewM6829e).setPositiveButton(com.xbrowser.play.R.string.btn_text_ok, new l(webView, sslErrorHandler, sslError)).setOnCancelListener(new k()).show();
        }

        @Override
        public void onFormResubmission(WebView webView, Message message, Message message2) {
            new f(browserActivity, message2).m5643d(browserActivity.getString(com.xbrowser.play.R.string.dlg_resubmit_form), browserActivity.getString(com.xbrowser.play.R.string.dlg_resubmit_form_confirm));
        }

        /* JADX WARN: Removed duplicated region for block: B:19:0x0086  */
        /* JADX WARN: Removed duplicated region for block: B:22:0x0095  */
        /* JADX WARN: Removed duplicated region for block: B:30:0x00d5  */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void onPageFinished(WebView r5, String r6) {
            /*
                r4 = this;
                java.lang.String r5 = "js-console"
                java.lang.String r0 = "onPageFinished........"
                android.util.Log.i(r5, r0)
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                boolean r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.m6736O(r5)
                r0 = 0
                if (r5 == 0) goto L20
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                boolean r5 = r5.mo5624a()
                if (r5 == 0) goto L20
                mf r5 = p000.C2061mf.m8471f0()
                r5.m8550r0(r6, r0)
                goto L3b
            L20:
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                int r1 = r5.f4692h
                r2 = 8
                if (r1 != r2) goto L3b
                com.mmbox.xbrowser.BrowserActivity r5 = r5.f4685a
                com.mmbox.xbrowser.BrowserActivityDelegate r5 = r5.m6218I0()
                Gn r5 = r5.m6394C()
                com.mmbox.xbrowser.controllers.WebViewBrowserController r1 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                android.graphics.drawable.Drawable r1 = r1.mo5621A(r0)
                r5.m1438u(r1)
            L3b:
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                com.mmbox.xbrowser.BrowserActivity r5 = r5.f4685a
                java.lang.String r1 = "if(window._XJSAPI_) _XJSAPI_.sniff_video()"
                r5.m6361u0(r1)
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                int r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.m6732K(r5)
                r1 = 5
                r2 = 2
                if (r5 == r1) goto L68
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                r1 = 3
                com.mmbox.xbrowser.controllers.WebViewBrowserController.m6733L(r5, r1)
            L54:
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                com.mmbox.xbrowser.BrowserControllerListener r5 = r5.m6730I()
                com.mmbox.xbrowser.controllers.WebViewBrowserController r1 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                Jk r3 = p000.ResourceCacheManager.m2045c()
                java.lang.String r2 = r3.m2046a(r6, r2)
                r5.mo6432n(r1, r2)
                goto L79
            L68:
                com.mmbox.xbrowser.f r5 = com.mmbox.xbrowser.VideoSniffingManager.m6988n()
                Pc r5 = r5.m7000j()
                java.lang.String r5 = r5.f2132d
                boolean r5 = android.text.TextUtils.isEmpty(r5)
                if (r5 == 0) goto L79
                goto L54
            L79:
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                r5.m6798h1(r6)
                com.mmbox.xbrowser.d r5 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                boolean r5 = r5.f4928s
                if (r5 == 0) goto L8d
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                android.webkit.WebView r5 = r5.f4716p
                r5.setVisibility(r0)
            L8d:
                java.lang.String r5 = "http"
                boolean r0 = r6.startsWith(r5)
                if (r0 == 0) goto Laf
                t3 r0 = p000.C2363t3.m9665a()
                r1 = 22
                r0.m9672h(r1)
                t3 r0 = p000.C2363t3.m9665a()
                r1 = 20
                r0.m9672h(r1)
                com.mmbox.xbrowser.controllers.WebViewBrowserController r0 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                java.lang.String r1 = p000.AbstractC0115Cd.m471z(r6)
                r0.f4691g = r1
            Laf:
                com.mmbox.xbrowser.a r0 = com.mmbox.xbrowser.ContentDataManager.m6540c0()
                r0.m6627l1()
                com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                boolean r0 = r0.f4906h
                if (r0 == 0) goto Lcf
                com.mmbox.xbrowser.d r0 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
                boolean r0 = r0.f4926r
                if (r0 == 0) goto Lcf
                com.mmbox.xbrowser.controllers.WebViewBrowserController r0 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                com.mmbox.xbrowser.BrowserActivity r0 = r0.f4685a
                java.lang.String r1 = "if(window._XJSAPI_) _XJSAPI_.countHitTimes()"
                r0.m6361u0(r1)
            Lcf:
                boolean r5 = r6.startsWith(r5)
                if (r5 == 0) goto Le7
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                com.mmbox.xbrowser.BrowserActivity r5 = r5.f4685a
                android.os.Handler r5 = r5.m6242O0()
                com.mmbox.xbrowser.controllers.WebViewBrowserController$l$d r6 = new com.mmbox.xbrowser.controllers.WebViewBrowserController$l$d
                r6.<init>()
                r0 = 1000(0x3e8, double:4.94E-321)
                r5.postDelayed(r6, r0)
            Le7:
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                com.mmbox.xbrowser.BrowserActivity r6 = r5.f4685a
                java.lang.String r5 = r5.f4688d
                r6.m6293a3(r5)
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                r5.m6800j1()
                com.mmbox.xbrowser.controllers.WebViewBrowserController r5 = com.mmbox.xbrowser.controllers.WebViewBrowserController.this
                com.mmbox.xbrowser.controllers.WebViewBrowserController.m6738Q(r5)
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.controllers.WebViewBrowserController.C1554l.onPageFinished(android.webkit.WebView, java.lang.String):void");
        }

        @Override
        public void onPageStarted(WebView webView, String url, Bitmap favicon) {
            browserActivity.getHandler().postDelayed(new c(webView), 1500L);
            if (mo5624a()) {
                browserActivity.f4242D = url;
            }
            m6790Z0(url);
            String str2 = f4688d;
            if (str2 == null || !str2.startsWith("http")) {
                String str3 = f4688d;
                if (str3 != null) {
                    str3.startsWith("view-source:");
                }
            } else {
                getBrowserControllerListener().mo6429h(WebViewBrowserController.this, ResourceCacheManager.getInstance().m2046a(url, 2), favicon);
            }
            f4688d = url;
            if (url.startsWith("http") && mo5626h() != 32) {
                m6801k1(url);
                Log.i("ad-block", "get main domain onPageStarted");
                VideoSniffingManager.getInstance().m6992D(url);
                ContentDataManager.getInstance().m6625k1();
                if (!C1039Wi.m4517p().m4520l() && mo5624a()) {
                    C1039Wi.m4517p().m4519k();
                }
            }
            m6805o1(url);
            if (SharedPreferencesHelper.getInstance().activeAdBlock && mo5624a()) {
                ContentDataManager.getInstance().m6570I();
            }
            WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
            if (webViewBrowserController.pageType == 0) {
                webViewBrowserController.m6808s0(url);
                m6809t0(url);
            }
            if (!SharedPreferencesHelper.getInstance().enterNightMode || Build.VERSION.SDK_INT >= 29) {
                return;
            }
            f4716p.setVisibility(View.INVISIBLE);
        }

        @Override
        public void onReceivedError(WebView webView, int i2, String str, String str2) {
            getBrowserControllerListener().mo6447a(WebViewBrowserController.this, i2, str, str2);
        }

        @Override
        public void onReceivedHttpAuthRequest(WebView webView, HttpAuthHandler httpAuthHandler, String str, String str2) {
            String str3;
            String str4;
            String[] httpAuthUsernamePassword;
            if (!httpAuthHandler.useHttpAuthUsernamePassword() || webView == null || (httpAuthUsernamePassword = webView.getHttpAuthUsernamePassword(str, str2)) == null || httpAuthUsernamePassword.length != 2) {
                str3 = null;
                str4 = null;
            } else {
                str3 = httpAuthUsernamePassword[0];
                str4 = httpAuthUsernamePassword[1];
            }
            if (str3 != null && str4 != null) {
                httpAuthHandler.proceed(str3, str4);
            } else if (mo5624a()) {
                m6831g(httpAuthHandler, str, str2, null, null, null, 0);
            } else {
                httpAuthHandler.cancel();
            }
        }

        @Override
        public void onReceivedLoginRequest(WebView webView, String str, String str2, String str3) {
            super.onReceivedLoginRequest(webView, str, str2, str3);
        }

        @Override
        public void onReceivedSslError(WebView webView, SslErrorHandler sslErrorHandler, SslError sslError) {
            String url = webView.getUrl();
            if (!mo5624a() || (!TextUtils.isEmpty(url) && url.startsWith("file:///"))) {
                sslErrorHandler.cancel();
                return;
            }
            if (SharedPreferencesHelper.getInstance().m6892e0() || f4723w) {
                sslErrorHandler.proceed();
                return;
            }
            LayoutInflater layoutInflaterFrom = LayoutInflater.from(browserActivity);
            View viewInflate = layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warnings, (ViewGroup) null);
            LinearLayout linearLayout = (LinearLayout) viewInflate.findViewById(com.xbrowser.play.R.id.placeholder);
            if (sslError.hasError(3)) {
                LinearLayout linearLayout2 = (LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, (ViewGroup) null);
                ((TextView) linearLayout2.findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_untrusted);
                linearLayout.addView(linearLayout2);
            }
            if (sslError.hasError(2)) {
                LinearLayout linearLayout3 = (LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, (ViewGroup) null);
                ((TextView) linearLayout3.findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_mismatch);
                linearLayout.addView(linearLayout3);
            }
            if (sslError.hasError(1)) {
                LinearLayout linearLayout4 = (LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, (ViewGroup) null);
                ((TextView) linearLayout4.findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_expired);
                linearLayout.addView(linearLayout4);
            }
            if (sslError.hasError(0)) {
                LinearLayout linearLayout5 = (LinearLayout) layoutInflaterFrom.inflate(com.xbrowser.play.R.layout.ssl_warning, (ViewGroup) null);
                ((TextView) linearLayout5.findViewById(com.xbrowser.play.R.id.warning)).setText(com.xbrowser.play.R.string.ssl_not_yet_valid);
                linearLayout.addView(linearLayout5);
            }
            new AlertDialog.Builder(browserActivity).setTitle(com.xbrowser.play.R.string.security_warning).setIcon(R.drawable.ic_dialog_alert).setView(viewInflate).setPositiveButton(com.xbrowser.play.R.string.ssl_continue, new j(sslErrorHandler)).setNeutralButton(com.xbrowser.play.R.string.view_certificate, new i(webView, sslErrorHandler, sslError)).setNegativeButton(com.xbrowser.play.R.string.btn_text_cancel, new h(sslErrorHandler)).setOnCancelListener(new g(sslErrorHandler)).show();
        }

        @Override
        public boolean onRenderProcessGone(WebView webView, RenderProcessGoneDetail renderProcessGoneDetail) {
            Log.e("WebView-crash", "WebView render process gone. Did it crash? " + renderProcessGoneDetail.didCrash());
            return true;
        }

        @Override
        public void onScaleChanged(WebView webView, float f2, float f3) {
            if (SharedPreferencesHelper.getInstance().autoWrapWhenScaled) {
                browserActivity.f4245G = (int) (webView.getWidth() / f3);
                if (browserActivity.f4246H == -1) {
                    browserActivity.f4246H = (int) (webView.getWidth() / f3);
                }
                Log.i("page-scale", " width:" + webView.getWidth() + " old-scale:" + f2 + " new-scale:" + f3 + " new-width:" + browserActivity.f4245G + " old-width:" + browserActivity.f4246H);
                browserActivity.m6284Y2();
            }
        }

        @Override
        public WebResourceResponse shouldInterceptRequest(WebView webView, String str) {
            try {
                if (ContentDataManager.getInstance().m6651w0(str) && !str.equals(WebViewBrowserController.f4697M)) {
                    return m6794d1(str);
                }
                String str2 = AbstractC1761g3.HEADER_USER_SCRIPT;
                int iIndexOf = str.indexOf(str2);
                if (iIndexOf >= 0) {
                    return new WebResourceResponse("text/javascript", "UTF8", new ByteArrayInputStream(C2061mf.m8471f0().m8525b0(str.substring(iIndexOf + str2.length() + 1)).getBytes(StandardCharsets.UTF_8)));
                }
                String str3 = AbstractC1761g3.HEADER_LIB_SCRIPT;
                int iIndexOf2 = str.indexOf(str3);
                if (iIndexOf2 >= 0) {
                    return new WebResourceResponse("text/javascript", "UTF8", new ByteArrayInputStream(C2061mf.m8471f0().readAppFileOrToast(str.substring(iIndexOf2 + str3.length() + 1)).getBytes(StandardCharsets.UTF_8)));
                }
                int iIndexOf3 = str.indexOf(str2);
                if (iIndexOf3 >= 0) {
                    return new WebResourceResponse("text/javascript", "UTF8", new ByteArrayInputStream(C2061mf.m8471f0().m8525b0(str.substring(iIndexOf3 + str2.length() + 1)).getBytes(StandardCharsets.UTF_8)));
                }
                if (f4709i == 5 && mo5624a()) {
                    VideoSniffingManager.getInstance().m6997g(str);
                }
                if (mo5624a()) {
                    VideoSniffingManager.getInstance().m6995e(str);
                }
                if (!SharedPreferencesHelper.getInstance().activeAdBlock || TextUtils.isEmpty(f4726z) || ContentDataManager.getInstance().m6637q0(f4726z)) {
                    return null;
                }
                C1539a c1539aM6540c0 = ContentDataManager.getInstance();
                WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
                if (c1539aM6540c0.m6647u0(webViewBrowserController.f4688d, webViewBrowserController.f4726z, str, f4709i, SharedPreferencesHelper.getInstance().enableSmartADB)) {
                    return new WebResourceResponse("text/plain", "utf-8", WebViewBrowserController.f4698N);
                }
                return null;
            } catch (Exception e2) {
                e2.printStackTrace();
                return null;
            }
        }

        @Override
        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            SiteSettingsManager.Host hostVarM6982X;
            String string = webResourceRequest.getUrl().toString();
            if (string.startsWith("http")) {
                f4688d = string;
            }
            if (SharedPreferencesHelper.getInstance().f4858H0) {
                C2480vj.getInstance().m10377l();
                SharedPreferencesHelper.getInstance().f4858H0 = false;
            }
            if (browserActivity.f4264k != 0) {
                return true;
            }
            if (string.startsWith("http")) {
                if (SharedPreferencesHelper.getInstance().blockPopWindow && SharedPreferencesHelper.getInstance().activeAdBlock && !TextUtils.isEmpty(f4688d) && !TextUtils.isEmpty(f4726z) && !ContentDataManager.getInstance().m6637q0(f4726z)) {
                    C1539a c1539aM6540c0 = ContentDataManager.getInstance();
                    WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
                    if (c1539aM6540c0.m6647u0(webViewBrowserController.f4688d, webViewBrowserController.f4726z, string, f4709i, false)) {
                        if (SharedPreferencesHelper.getInstance().showAdBlockToast) {
                            Toast.makeText(browserActivity, com.xbrowser.play.R.string.toast_total_block_ad_jump, Toast.LENGTH_SHORT).show();
                        }
                        return true;
                    }
                }
                if (!TextUtils.isEmpty(f4691g) && (hostVarM6982X = SiteSettingsManager.getInstance().getHost(17, f4726z)) != null && hostVarM6982X.extra.equals("true") && string.indexOf(f4691g) < 0) {
                    if (SharedPreferencesHelper.getInstance().showAdBlockToast) {
                        Toast.makeText(browserActivity, com.xbrowser.play.R.string.toast_block_jumping_thirdpart, Toast.LENGTH_SHORT).show();
                    }
                    return true;
                }
                m6801k1(string);
            }
            if (SharedPreferencesHelper.getInstance().supportSuperCache || SharedPreferencesHelper.getInstance().forceOpenInNewTab) {
                if (getBrowserControllerListener().mo6422d(WebViewBrowserController.this, string, webResourceRequest.hasGesture(), webResourceRequest.isRedirect())) {
                    return true;
                }
                if (!string.startsWith("x:")) {
                    if (mo5624a()) {
                        browserActivity.m6218I0().m6404M(string);
                    }
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
            } else {
                if (getBrowserControllerListener().mo6422d(WebViewBrowserController.this, string, webResourceRequest.hasGesture(), webResourceRequest.isRedirect())) {
                    return true;
                }
                if (!string.startsWith("x:")) {
                    if (mo5624a()) {
                        browserActivity.m6218I0().m6404M(string);
                    }
                    return super.shouldOverrideUrlLoading(webView, webResourceRequest);
                }
            }
            f4716p.loadUrl(ResourceCacheManager.getInstance().m2046a(string, 2));
            return true;
        }
    }

    public class HandlerC1555m extends Handler {
        public HandlerC1555m() {
        }

        @Override
        public void handleMessage(Message message) {
            AndroidSystemUtils.m8701i(browserActivity, message.getData().getString("url"));
        }
    }

    public class HandlerC1556n extends Handler {
        public HandlerC1556n() {
        }

        @Override
        public void handleMessage(Message message) {
            AndroidSystemUtils.m8701i(browserActivity, message.getData().getString("title"));
            Toast.makeText(browserActivity, com.xbrowser.play.R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
        }
    }

    public class DialogC1557o extends AbstractDialogC1303b6 {

        public final String f4822f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public DialogC1557o(Context context, String str) {
            super(context);
            this.f4822f = str;
        }

        @Override
        public void mo315b() {
        }

        @Override
        public void mo316c() {
            browserActivity.m6325i0(this.f4822f);
        }
    }

    public class RunnableC1558p implements Runnable {

        public final String f4824l;

        public RunnableC1558p(String str) {
            this.f4824l = str;
        }

        @Override
        public void run() throws IOException {
            m6810u0(this.f4824l);
        }
    }

    public class RunnableC1559q implements Runnable {

        public final String f4826l;

        public RunnableC1559q(String str) {
            this.f4826l = str;
        }

        @Override
        public void run() {
            if (f4709i == 3 || browserActivity.m6218I0().m6394C().m1431n() == 3 || browserActivity.m6218I0().m6394C().m1431n() == 2) {
                return;
            }
            m6787W0(this.f4826l);
        }
    }

    public class RunnableC1560r implements Runnable {
        public RunnableC1560r() {
        }

        @Override
        public void run() {
            if (SharedPreferencesHelper.getInstance().enableAutoFill && SiteSettingsManager.getInstance().m6935D(f4726z)) {
                C2061mf.m8471f0().m8542n0(f4716p, "auto_fill");
            }
        }
    }

    public static class C1561s {

        public static final int[] f4829a;

        static {
            int[] iArr = new int[ConsoleMessage.MessageLevel.values().length];
            f4829a = iArr;
            try {
                iArr[ConsoleMessage.MessageLevel.TIP.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f4829a[ConsoleMessage.MessageLevel.LOG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f4829a[ConsoleMessage.MessageLevel.WARNING.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f4829a[ConsoleMessage.MessageLevel.ERROR.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f4829a[ConsoleMessage.MessageLevel.DEBUG.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public class ViewOnScrollChangeListenerC1562t implements View.OnScrollChangeListener {
        public ViewOnScrollChangeListenerC1562t() {
        }

        @Override
        public void onScrollChange(View view, int i, int i2, int i3, int i4) {
            f4712l = i2;
        }
    }

    public class ViewOnLongClickListenerC1563u implements View.OnLongClickListener {
        public ViewOnLongClickListenerC1563u() {
        }

        @Override
        public boolean onLongClick(View view) {
            Log.i("web-touch", "start post long press ====================");
            int i = pageType;
            return (i == 32 || i == 0 || i == 8 || i == 64 || i == 512) ? false : true;
        }
    }

    public class C1564v implements DownloadListener {
        public C1564v() {
        }

        @Override
        public void onDownloadStart(String str, String str2, String str3, String str4, long j) {
            if (TextUtils.isEmpty(f4690f) || !f4690f.startsWith("http")) {
                WebViewBrowserController webViewBrowserController = WebViewBrowserController.this;
                webViewBrowserController.f4690f = webViewBrowserController.f4716p.getUrl();
            }
            getBrowserControllerListener().mo6424e(str, f4690f, str2, str3, str4, j);
        }
    }

    public class RunnableC1565w implements Runnable {
        public RunnableC1565w() {
        }

        @Override
        public void run() {
            String url;
            if (C1039Wi.m4517p().m4520l() || (url = f4716p.getUrl()) == null || C1039Wi.m4517p().m4524q(url) || url.indexOf("xbext.com") >= 0 || url.indexOf("taobao.com") >= 0) {
                return;
            }
            Log.i("jslog", "=========  do try test support preload ============" + url);
            C2061mf.m8471f0().m8542n0(f4716p, "preload");
        }
    }

    public class RunnableC1566x implements Runnable {

        public final String f4834l;

        public RunnableC1566x(String str) {
            this.f4834l = str;
        }

        @Override
        public void run() {
            String strM448c;
            C1344c1 c1344c1M5691d;
            StringBuilder sb;
            try {
                String host = Uri.parse(this.f4834l).getHost();
                if (SharedPreferencesHelper.getInstance().getBoolean("log_host_access", false) && !TextUtils.isEmpty(host)) {
                    C1344c1.m5691d().m5698h("Host Access", "host_access/" + host);
                }
                if (this.f4834l.indexOf("baidu.com") > 0 && this.f4834l.indexOf("from=") > 0) {
                    String strM448c2 = NetworkUtils.extractFirstGroup(this.f4834l, NetworkUtils.FROM_PARAM_PATTERN);
                    if (strM448c2 != null) {
                        C1344c1.m5691d().m5698h("Search FeeCode", "search_baidu_feecode/" + strM448c2);
                    }
                    if (WebViewBrowserController.f4695K >= SharedPreferencesHelper.getInstance().f4913k0) {
                        boolean unused = WebViewBrowserController.f4696L = true;
                    }
                } else {
                    if (this.f4834l.indexOf("sogou.com") <= 0) {
                        if (this.f4834l.indexOf("sm.cn") > 0) {
                            String strM448c3 = NetworkUtils.extractFirstGroup(this.f4834l, NetworkUtils.FROM_PARAM_PATTERN);
                            if (strM448c3 == null) {
                                return;
                            }
                            c1344c1M5691d = C1344c1.m5691d();
                            sb = new StringBuilder();
                            sb.append("search_sm_feecode/");
                            sb.append(strM448c3);
                        } else if (this.f4834l.indexOf("so.toutiao.com") > 0) {
                            String strM448c4 = NetworkUtils.extractFirstGroup(this.f4834l, NetworkUtils.TRAFFIC_SOURCE_PATTERN);
                            if (strM448c4 == null) {
                                return;
                            }
                            c1344c1M5691d = C1344c1.m5691d();
                            sb = new StringBuilder();
                            sb.append("search_toutiao_feecode/");
                            sb.append(strM448c4);
                        } else {
                            if (this.f4834l.indexOf("m.so.com") <= 0 || (strM448c = NetworkUtils.extractFirstGroup(this.f4834l, NetworkUtils.SRC_PARAM_PATTERN)) == null) {
                                return;
                            }
                            c1344c1M5691d = C1344c1.m5691d();
                            sb = new StringBuilder();
                            sb.append("search_360_feecode/");
                            sb.append(strM448c);
                        }
                        c1344c1M5691d.m5698h("Search FeeCode", sb.toString());
                        return;
                    }
                    String strM448c5 = NetworkUtils.extractFirstGroup(this.f4834l, NetworkUtils.SOGOU_MOBB_PATTERN);
                    if (strM448c5 != null) {
                        C1344c1.m5691d().m5698h("Search FeeCode", "search_sogou_feecode/" + strM448c5);
                    }
                    if (WebViewBrowserController.f4695K >= 100) {
                        boolean unused2 = WebViewBrowserController.f4696L = true;
                    }
                }
                WebViewBrowserController.f4695K++;
            } catch (Exception unused3) {
            }
        }
    }

    public class RunnableC1567y implements Runnable {

        public final String f4836l;

        public RunnableC1567y(String str) {
            this.f4836l = str;
        }

        @Override
        public void run() {
            if (mo5624a()) {
                C2061mf.m8471f0().m8550r0(this.f4836l, 2);
            }
        }
    }

    public class RunnableC1568z implements Runnable {
        public RunnableC1568z() {
        }

        @Override
        public void run() {
            browserActivity.m6361u0("if(window._XJSAPI_) _XJSAPI_.loadHideElementRule()");
        }
    }

    public WebViewBrowserController(BrowserActivity browserActivity, BrowserControllerListener browserControllerListener) {
        this(browserActivity, browserControllerListener, false);
    }

    public static int[] m6731J() {
        int i = SharedPreferencesHelper.getInstance().enterNightMode ? 0xFF000000 : -1;
        return new int[]{i, i};
    }

    public void m6765A0() {
        if (this.f4717q != null) {
            if (this.f4704D != null) {
                this.browserActivity.m6250Q0().removeView(this.f4704D);
                this.f4704D = null;
            }
            this.f4717q.destroy();
            this.f4717q = null;
        }
        WebView webView = this.f4716p;
        if (webView != null) {
            webView.requestFocus();
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:139:0x056d  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean mo6669B(AbstractScrollableListController r13, View r14, android.view.ContextMenu.ContextMenuInfo r15) throws JSONException, NumberFormatException {
        /*
            Method dump skipped, instructions count: 1848
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.controllers.WebViewBrowserController.mo6669B(com.mmbox.xbrowser.b, android.view.View, android.view.ContextMenu$ContextMenuInfo):boolean");
    }

    public final void m6766B0(String str, int i) {
        String strM5596c = PhoneUtils.getInstance().getCacheDirPath();
        if (Build.VERSION.SDK_INT < 29) {
            strM5596c = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        }
        C0232F1.m1169l().m1172g(strM5596c, this.f4716p.getUrl(), this.f4716p.getSettings().getUserAgentString(), str, null, new C1550h(str, i));
    }

    public String m6767C0() {
        return this.f4726z;
    }

    public int m6768D0() {
        return this.f4709i;
    }

    public int[] m6769E0() {
        return this.f4713m;
    }

    public WebView m6770F0() {
        return this.f4716p;
    }

    @Override
    public void mo6728G(String str) {
        m6813x0();
        if (mo5624a()) {
            this.browserActivity.m6218I0().m6403L(str);
        }
        this.browserActivity.f4241C = str;
        m6801k1(str);
        SiteSettingsManager.getInstance().m6975q(this.f4716p, str, true);
        this.f4709i = 0;
        this.browserActivity.f4264k = 0;
        this.f4688d = str;
        if (str.indexOf("baidu.com") > 0) {
            if (SharedPreferencesHelper.getInstance().containsSpecialCode(str)) {
                str = str.replaceAll("from=[a-z0-9_]{8,20}", "from=" + SharedPreferencesHelper.getInstance().f4895b0);
            }
            str = SharedPreferencesHelper.getInstance().replaceFromPrefs(str, "baidu_old_qa_feecode", "baidu_new_qa_feecode");
        }
        HashMap map = new HashMap<>(2);
        map.put("X-Requested-With", "XBrowser");
        if (!TextUtils.isEmpty(this.f4690f)) {
            map.put("Referer", this.f4690f);
        }
        if (SharedPreferencesHelper.getInstance().enableDNT) {
            map.put("DNT", "1");
        }
        if (m6778N0(str)) {
            str = m6785U0(str);
        }
        m6780P0(str);
        this.f4716p.loadUrl(str, map);
        this.f4718r = true;
        this.f4723w = false;
    }

    public final void m6771G0(int i, String str, String str2, String str3) throws Resources.NotFoundException, IOException {
        String str4;
        String strM4227k = FileUtils.getFileName(str);
        if (!TextUtils.isEmpty(this.f4726z)) {
            strM4227k = this.f4726z + "_" + strM4227k;
        }
        if ((TextUtils.isEmpty(str2) || str2.equals("application/octet-stream")) && strM4227k.endsWith(".bin")) {
            str4 = "image/jpeg";
            if (str3.indexOf("jpg") <= 0 && str3.indexOf("png") > 0) {
                str4 = "image/png";
            }
        } else {
            str4 = str2;
        }
        if (Build.VERSION.SDK_INT < 29) {
            m6773I0(i, str, str2, null);
            AndroidSystemUtils.scanMediaFile(this.browserActivity, str);
            return;
        }
        BrowserActivity browserActivity = this.browserActivity;
        Uri uriM8703k = AndroidSystemUtils.m8703k(browserActivity, strM4227k, str4, browserActivity.getString(com.xbrowser.play.R.string.app_name));
        if (uriM8703k != null) {
            AndroidSystemUtils.m8698f(this.browserActivity, str, uriM8703k);
            m6773I0(i, str, str2, uriM8703k);
            AndroidSystemUtils.scanMediaFile(this.browserActivity, uriM8703k);
        }
    }

    public final void m6772H0(String str, int i) {
        if (Build.VERSION.SDK_INT < 29 && !BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
            BrowserActivity.getActivity().m6290a0();
            return;
        }
        Toast.makeText(this.browserActivity, com.xbrowser.play.R.string.toast_prepare_image, Toast.LENGTH_SHORT).show();
        if (this.f4720t.getType() != 8 && this.f4720t.getType() != 5) {
            m6766B0(str, i);
            return;
        }
        Message message = new Message();
        message.setTarget(new HandlerC1552j(i));
        this.f4716p.requestImageRef(message);
    }

    public final void m6773I0(int i, String str, String str2, Uri uri) throws Resources.NotFoundException {
        Toast toastMakeText;
        if (i == com.xbrowser.play.R.string.context_menu_share_image) {
            String string = this.browserActivity.getResources().getString(com.xbrowser.play.R.string.choose_app);
            String string2 = this.browserActivity.getResources().getString(com.xbrowser.play.R.string.share_sign);
            String string3 = this.browserActivity.getString(com.xbrowser.play.R.string.origin_url);
            if (uri != null) {
                AndroidSystemUtils.m8688V(this.browserActivity, uri, str2);
                return;
            }
            AndroidSystemUtils.m8690X(this.browserActivity, mo1574c(), string3 + mo1573b(), string2, string, str, str2);
            return;
        }
        if (i == com.xbrowser.play.R.string.context_menu_save_image) {
            toastMakeText = Toast.makeText(this.browserActivity, com.xbrowser.play.R.string.toast_image_had_saved_to_pictures, 1);
        } else {
            if (i != com.xbrowser.play.R.string.context_menu_recognize_qrcode) {
                return;
            }
            try {
                Bitmap bitmapDecodeFile = BitmapFactory.decodeFile(str);
                QRCodeReader QRCodeReader = new QRCodeReader();
                int[] iArr = new int[bitmapDecodeFile.getWidth() * bitmapDecodeFile.getHeight()];
                bitmapDecodeFile.getPixels(iArr, 0, bitmapDecodeFile.getWidth(), 0, 0, bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight());
                String strM3580f = QRCodeReader.decode(new BinaryBitmap(new HybridBinarizer(new RGBLuminanceSource(bitmapDecodeFile.getWidth(), bitmapDecodeFile.getHeight(), iArr)))).m3580f();
                if (TextUtils.isEmpty(strM3580f)) {
                    Toast.makeText(this.browserActivity, com.xbrowser.play.R.string.toast_unrecognised_qrcode, Toast.LENGTH_SHORT).show();
                } else {
                    this.browserActivity.m6297b2(strM3580f);
                }
                return;
            } catch (Exception unused) {
                toastMakeText = Toast.makeText(this.browserActivity, com.xbrowser.play.R.string.toast_unrecognised_qrcode, 0);
            }
        }
        toastMakeText.show();
    }

    public final void m6774J0() {
        Log.i("flash", "hide custom view");
        if (mo5624a() && this.f4701A != null) {
            m6796f1(false);
            FrameLayout frameLayout = (FrameLayout) this.browserActivity.getWindow().getDecorView();
            if (frameLayout != null) {
                try {
                    frameLayout.removeView(this.f4703C);
                } catch (NullPointerException e) {
                    e.printStackTrace();
                }
            }
            C1542A c1542a = this.f4703C;
            if (c1542a != null) {
                c1542a.removeAllViews();
                this.f4703C = null;
            }
            this.f4701A = null;
            try {
                this.f4705E.onCustomViewHidden();
            } catch (NullPointerException e2) {
                e2.printStackTrace();
            }
            this.browserActivity.setRequestedOrientation(this.f4721u);
            SharedPreferencesHelper.getInstance().m6863K0(this.f4722v);
            this.browserActivity.f4265l = false;
        }
    }

    public final void m6775K0() {
        WebView webViewM9499t = ThemeManager.getInstance().m9499t();
        this.f4716p = webViewM9499t;
        webViewM9499t.setWebViewClient(this.f4708H);
        this.f4716p.setWebChromeClient(this.f4707G);
        this.f4716p.setTag(this);
        this.f4716p.setOnScrollChangeListener(new ViewOnScrollChangeListenerC1562t());
        this.f4716p.setLongClickable(true);
        this.f4716p.setOnLongClickListener(new ViewOnLongClickListenerC1563u());
        this.f4716p.setDownloadListener(new C1564v());
    }

    public final void m6776L0() {
        this.browserActivity.getHandler().postDelayed(new RunnableC1560r(), 700L);
    }

    public final boolean m6777M0() {
        int i = this.pageType;
        return i == 0 || i == 8 || i == -1;
    }

    public final boolean m6778N0(String str) {
        return f4696L && (str.indexOf("baidu.com") > 0 || str.indexOf("sogou.com") > 0);
    }

    public final void m6779O0(long j) {
        this.browserActivity.getHandler().postDelayed(new RunnableC1568z(), j);
    }

    public final void m6780P0(String str) {
        this.browserActivity.getHandler().post(new RunnableC1566x(str));
    }

    public void m6781Q0() {
        Bitmap drawingCache = null;
        try {
            try {
                this.f4716p.setDrawingCacheEnabled(true);
                drawingCache = this.f4716p.getDrawingCache();
                if (drawingCache != null) {
                    try {
                        this.f4713m[0] = drawingCache.getPixel(10, 10);
                        this.f4713m[1] = drawingCache.getPixel(10, this.f4716p.getHeight() - 10);
                        Log.i("try-auto", ">>>>>try auto pick color0:" + this.f4713m[0]);
                        if (mo5624a()) {
                            ThemeManager.getInstance().m9474B(this.f4713m);
                        }
                        drawingCache.recycle();
                        this.f4716p.setDrawingCacheEnabled(false);
                    } catch (Throwable th) {
                        drawingCache.recycle();
                        this.f4716p.setDrawingCacheEnabled(false);
                        throw th;
                    }
                }
                if (drawingCache == null) {
                    return;
                }
            } catch (Exception e) {
                e.printStackTrace();
                if (0 == 0) {
                    return;
                }
            }
            drawingCache.recycle();
        } catch (Throwable th2) {
            if (0 != 0) {
                drawingCache.recycle();
            }
            throw th2;
        }
    }

    public void m6782R0(boolean z) {
        WebView webView = this.f4716p;
        if (webView instanceof C0219Ep) {
            ((C0219Ep) webView).m1087h(z);
            this.f4706F = z;
        }
    }

    public final void m6783S0() {
        this.f4716p.requestFocusNodeHref(new HandlerC1551i().obtainMessage());
    }

    public final void m6784T0(boolean z, int i) throws URISyntaxException {
        WebView.HitTestResult hitTestResult = this.f4720t;
        if (hitTestResult != null) {
            if (hitTestResult.getType() == 8) {
                this.f4716p.requestFocusNodeHref(new HandlerC1548f(z, i).obtainMessage());
            } else {
                this.browserActivity.openUrl(this.f4720t.getExtra(), z, i);
            }
        }
    }

    public final String m6785U0(String str) {
        return str.replaceAll("from=[a-z0-9_]{1,20}", "");
    }

    public void m6786V0() {
        this.f4709i = 4;
        String url = this.f4716p.getUrl();
        if (url != null) {
            getBrowserControllerListener().mo6427g(this, 100, mo5624a());
            m6798h1(url);
        }
        if (m6777M0() && mo5624a()) {
            C2061mf.m8471f0().m8550r0(url, 1);
        }
        m6809t0(url);
        this.browserActivity.getHandler().postDelayed(new RunnableC1559q(url), 500L);
    }

    public void m6787W0(String str) {
        if (this.f4709i == 5) {
            return;
        }
        this.f4709i = 3;
        getBrowserControllerListener().mo6432n(this, ResourceCacheManager.getInstance().m2046a(str, 2));
    }

    public void m6788X0() {
        WebView webView = this.f4716p;
        if (webView != null) {
            webView.setVisibility(View.VISIBLE);
        }
    }

    public final String m6789Y0(AbstractScrollableListController abstractC1540b) throws JSONException {
        String str = "img";
        C0219Ep c0219Ep = (C0219Ep) this.f4716p;
        String str2 = "unknown";
        if (c0219Ep.getHitTestData() == null) {
            return "unknown";
        }
        try {
            JSONObject jSONObject = new JSONObject(c0219Ep.getHitTestData());
            String string = jSONObject.getString("tagType");
            if (string == null) {
                return "unknown";
            }
            if (string.equalsIgnoreCase("img")) {
                String string2 = jSONObject.getString("src");
                if (string2 != null) {
                    abstractC1540b.m9640C("src", string2);
                } else {
                    str = "unknown";
                }
                return str;
            }
            if (string.equalsIgnoreCase("grid-item")) {
                String string3 = jSONObject.getString("id");
                String string4 = jSONObject.getString("data_type");
                try {
                    abstractC1540b.m9640C("id", string3);
                    abstractC1540b.m9640C("type", string4);
                } catch (JSONException e) {
                    e = e;
                    str2 = string;
                    e.printStackTrace();
                    return str2;
                }
            } else if (string.equalsIgnoreCase("li")) {
                String string5 = jSONObject.getString("li_id");
                String string6 = jSONObject.getString("data_title");
                String string7 = jSONObject.getString("data_url");
                String string8 = jSONObject.getString("data_type");
                int iM3660e = JsonUtils.getInt(jSONObject, "data_status", 0);
                if ((TextUtils.isEmpty(string7) || string7.equals("null")) && TextUtils.isEmpty(string5)) {
                    return "unknown";
                }
                abstractC1540b.m9640C("id", string5);
                abstractC1540b.m9640C("url", string7);
                abstractC1540b.m9640C("title", string6);
                abstractC1540b.m9640C("type", string8);
                abstractC1540b.m9640C("status", iM3660e + "");
            } else if (!string.equalsIgnoreCase("input")) {
                return "unknown";
            }
            return string;
        } catch (JSONException e2) {
            e = e2;
        }
    }

    public final void m6790Z0(String str) {
        this.f4726z = "";
        this.f4709i = 1;
        m6727F();
        this.f4723w = false;
        this.pageType = this.pageType != 8 ? 0 : 8;
        m6805o1(str);
        C2061mf.m8471f0().m8490F0();
        BrowserActivity browserActivity = this.browserActivity;
        browserActivity.f4264k = 0;
        browserActivity.f4246H = -1;
        this.f4725y = null;
        BrowserActivityDelegate.f4376j = "";
        m6791a1();
    }

    public void m6791a1() {
        if (this.pageType == 8) {
            this.f4713m = ThemeManager.f6998j;
        } else {
            this.f4713m = m6731J();
        }
    }

    @Override
    public String mo1573b() {
        String url = this.f4716p.getUrl();
        if (TextUtils.isEmpty(url)) {
            url = this.f4688d;
        }
        if (!TextUtils.isEmpty(url) && (url.startsWith("x:") || url.startsWith("file:///"))) {
            return ResourceCacheManager.getInstance().m2046a(url, 2);
        }
        if (TextUtils.isEmpty(url) || url.indexOf("baidu.com") <= 0 || url.indexOf("from=") <= 0) {
            return url == null ? "" : url;
        }
        return url.replaceAll("from=[a-z0-9_]{8,20}", "from=" + SharedPreferencesHelper.getInstance().f4897c0);
    }

    public void m6792b1(String str, String str2, String str3) {
        this.f4724x = str;
        this.f4688d = str3;
        this.f4689e = str2;
    }

    /* JADX WARN: Removed duplicated region for block: B:17:0x004f  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x007c  */
    /* JADX WARN: Removed duplicated region for block: B:7:0x0018  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String mo1574c() throws Resources.NotFoundException {
        /*
            Method dump skipped, instructions count: 417
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.controllers.WebViewBrowserController.mo1574c():java.lang.String");
    }

    public final void m6793c1() {
        if (this.f4719s || TextUtils.isEmpty(this.f4724x)) {
            return;
        }
        try {
            try {
                File file = new File(this.browserActivity.getFilesDir(), "webstack-" + this.f4724x);
                if (file.exists()) {
                    FileInputStream fileInputStream = new FileInputStream(file);
                    Parcel parcelObtain = Parcel.obtain();
                    int length = (int) file.length();
                    byte[] bArr = new byte[length];
                    fileInputStream.read(bArr);
                    parcelObtain.unmarshall(bArr, 0, length);
                    parcelObtain.setDataPosition(0);
                    Bundle bundle = new Bundle();
                    bundle.readFromParcel(parcelObtain);
                    parcelObtain.recycle();
                    this.f4716p.restoreState(bundle);
                    fileInputStream.close();
                } else if (!this.f4718r && !TextUtils.isEmpty(this.f4688d)) {
                    Log.i("web-state", ">>>>> restore from url >>>>>>>>>");
                    if (this.f4688d.startsWith("file:///")) {
                        this.f4716p.loadUrl(this.f4688d);
                    } else {
                        mo5623E(this.f4688d);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f4719s = true;
        } catch (Throwable th) {
            this.f4719s = true;
            throw th;
        }
    }

    @Override
    public View mo1695d() throws IOException {
        WebView webView;
        int color;
        int i;
        if (SharedPreferencesHelper.getInstance().enterNightMode || this.pageType == 256) {
            webView = this.f4716p;
            color = Color.parseColor("#000000");
        } else if (SharedPreferencesHelper.getInstance().m6893f0()) {
            webView = this.f4716p;
            color = SharedPreferencesHelper.getInstance().goodForEyeColor;
        } else {
            String url = this.f4688d;
            if (TextUtils.isEmpty(url)) {
                url = this.f4716p.getUrl();
            }
            if (!TextUtils.isEmpty(url) && ((SharedPreferencesHelper.getInstance().m6857H().equals(url) || url.equals("file:///android_asset/start-page/index.html")) && this.browserActivity.m6314f1())) {
                int[] iArr = this.browserActivity.f4244F;
                if (iArr != null) {
                    this.f4716p.setBackgroundColor(iArr[0]);
                } else {
                    String strM2046a = ResourceCacheManager.getInstance().m2046a("page.immerse.colors", 1);
                    if (FileUtils.fileExists(strM2046a)) {
                        int[] iArrM4242z = FileUtils.readIntArrayFromFile(strM2046a);
                        this.f4713m = iArrM4242z;
                        if (iArrM4242z.length == 2 && (i = iArrM4242z[0]) != -1) {
                            this.f4716p.setBackgroundColor(i);
                        }
                    }
                }
                return this.f4716p;
            }
            webView = this.f4716p;
            color = Color.parseColor("#ffffff");
        }
        webView.setBackgroundColor(color);
        return this.f4716p;
    }

    public final WebResourceResponse m6794d1(String str) {
        return new WebResourceResponse("text/html", "utf-8", new ByteArrayInputStream("<!DOCTYPE html>\n<html lang=\"zh-CN\">\n<head>\n    <meta charset=\"UTF-8\">\n    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\n    <title>网页禁止访问</title>\n    <style>\n        body {\n            font-family: -apple-system, BlinkMacSystemFont, 'Segoe UI', Roboto, Oxygen, Ubuntu, Cantarell, 'Open Sans', 'Helvetica Neue', sans-serif;\n            margin: 0;\n            padding: 0;\n            display: flex;\n            flex-direction: column;\n            align-items: center;\n            justify-content: center;\n            min-height: 100vh;\n            text-align: center;\n            background-color: white;\n            color: #333;\n        }\n        \n        .stop-container {\n            width: 120px;\n            height: 120px;\n            margin: 0 auto 20px;\n        }\n\n        .stop-sign {\n            width: 120px;\n            height: 120px;\n            background-color: #c0c0c0;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n            color: white;\n            font-size: 32px;\n            font-weight: bold;\n            clip-path: polygon(30% 0%, 70% 0%, 100% 30%, 100% 70%, 70% 100%, 30% 100%, 0% 70%, 0% 30%);\n            margin: 0 auto;\n        }\n        \n        .title {\n            font-size: 28px;\n            margin: 20px 0;\n            font-weight: normal;\n        }\n        \n        .description {\n            font-size: 16px;\n            max-width: 80%;\n            line-height: 1.6;\n            color: #666;\n            margin: 0 auto 30px;\n        }\n        \n        .container {\n            padding: 20px;\n        }\n        \n        .continue-button {\n            background-color: #e53935;\n            color: white;\n            border: none;\n            padding: 10px 20px;\n            border-radius: 4px;\n            font-size: 16px;\n            cursor: pointer;\n            transition: background-color 0.3s;\n            text-decoration: none;\n            display: inline-block;\n        }\n        \n        .continue-button:hover {\n            background-color: #c62828;\n        }\n        \n        .checkbox-container {\n            margin-top: 20px;\n            display: flex;\n            align-items: center;\n            justify-content: center;\n        }\n        \n        .checkbox-container input[type=\"checkbox\"] {\n            margin-right: 8px;\n            cursor: pointer;\n        }\n        \n        .checkbox-container label {\n            color: #666;\n            font-size: 14px;\n            cursor: pointer;\n        }\n    </style>\n</head>\n<body>\n    <div class=\"container\">\n        <div class=\"stop-container\">\n            <div class=\"stop-sign\">STOP</div>\n        </div>\n        \n        <h1 class=\"title\">网页禁止访问</h1>\n        \n        <p class=\"description\">\n            依据国家法律法规及用户举报，该网页包含违法或欺诈内容，已禁止访问。如无视提醒继续访问您将自行承担由此造成的一切后果。\n        </p>\n        \n        <a href=\"#\" class=\"continue-button\" onclick=\"onContinueButtonClick()\">无视提醒继续访问</a>\n        \n        <div class=\"checkbox-container\">\n            <input type=\"checkbox\" id=\"no-remind\" name=\"no-remind\">\n            <label for=\"no-remind\">不再提醒</label>\n        </div>\n    </div>\n\n    <script>\n        function onContinueButtonClick() {\n            if(window.mbrowser) {\n                var noRemind = document.getElementById('no-remind').checked;\n                mbrowser.continueAccessBlockedUrl('{{url}}', noRemind);\n                window.location.href = '{{url}}';\n            }\n        }   \n    </script>\n</body>\n</html>".replaceAll("\\{\\{url\\}\\}", str).getBytes()));
    }

    @Override
    public boolean mo1575e() {
        return this.f4716p.canGoForward();
    }

    public final void m6795e1() {
        this.f4706F = true;
        ((C0219Ep) this.f4716p).m1090k();
    }

    @Override
    public void mo5625f() {
        if (this.f4716p.getUrl() == null) {
            this.f4716p.loadUrl(this.f4688d);
        } else {
            SiteSettingsManager c1570eM6932A = SiteSettingsManager.getInstance();
            WebView webView = this.f4716p;
            c1570eM6932A.m6974p(webView, webView.getUrl());
            WebView webView2 = this.f4716p;
            ((C0219Ep) webView2).f572w = false;
            webView2.reload();
        }
        C1039Wi.m4517p().m4519k();
        if (SharedPreferencesHelper.getInstance().f4858H0) {
            C2480vj.getInstance().m10377l();
            SharedPreferencesHelper.getInstance().f4858H0 = false;
        }
    }

    public final void m6796f1(boolean z) {
        View view;
        int i;
        Window window = this.browserActivity.getWindow();
        WindowManager.LayoutParams attributes = window.getAttributes();
        try {
            if (z) {
                attributes.flags |= 1024;
                view = this.f4701A;
                i = 1;
                if (view == null) {
                    view = this.f4702B;
                }
            } else {
                attributes.flags &= -1025;
                view = this.f4701A;
                i = 0;
                if (view == null) {
                    view = this.f4702B;
                }
            }
            view.setSystemUiVisibility(i);
        } catch (Exception e) {
            e.printStackTrace();
            Log.i("flash", "error occured : " + e.getMessage());
        }
        window.setAttributes(attributes);
        Log.i("flash", "window attributes setted");
    }

    @Override
    public void mo1576g() {
        super.mo1576g();
        if (TextUtils.isEmpty(this.f4726z) || !SiteSettingsManager.getInstance().m6961c(this.f4726z)) {
            this.f4716p.onPause();
            this.f4716p.pauseTimers();
        }
        if (this.f4701A != null) {
            m6774J0();
        }
    }

    public final void m6797g1(WebView webView, String str) {
        if (str.indexOf("article_list_for_xb_readmode") > 0) {
            return;
        }
        C2061mf.m8471f0().m8544o0(webView);
        this.browserActivity.getHandler().postDelayed(new RunnableC1567y(str), 50L);
        m6779O0(80L);
    }

    public void m6798h1(String str) {
        if (!mo5624a() || this.pageType == 8 || !SharedPreferencesHelper.getInstance().enableImmersiveMode) {
            if (mo5624a() && this.pageType == 8) {
                ThemeManager.getInstance().m9474B(ThemeManager.f6998j);
                return;
            }
            return;
        }
        if (str.startsWith("http") || str.equals("file:///android_asset/start-page/index.html") || str.equals("x:home") || SharedPreferencesHelper.getInstance().m6893f0()) {
            this.browserActivity.getHandler().postDelayed(new RunnableC1558p(str), 100L);
        } else {
            ThemeManager.getInstance().m9474B(this.f4713m);
        }
    }

    @Override
    public boolean mo5627i(String str) {
        if (str == null) {
            return false;
        }
        String lowerCase = str.toLowerCase();
        if (str.equals("x:home")) {
            return false;
        }
        return str.startsWith("x:") || lowerCase.startsWith("http") || lowerCase.startsWith("file") || lowerCase.startsWith("javascript:");
    }

    public final void m6799i1(String str, int i) {
        String strM5596c = PhoneUtils.getInstance().getCacheDirPath();
        if (Build.VERSION.SDK_INT < 29) {
            strM5596c = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath();
        }
        SharedPreferencesHelper.getInstance();
        C0232F1.m1169l().m1172g(strM5596c, null, SharedPreferencesHelper.defaultUserAgent, str, null, new C1549g(i, str));
    }

    @Override
    public void mo5628j() {
        this.f4716p.stopLoading();
    }

    public void m6800j1() {
        if (SharedPreferencesHelper.getInstance().disableReadMode) {
            return;
        }
        this.browserActivity.getHandler().postDelayed(new RunnableC1565w(), 50L);
    }

    @Override
    public void mo1577k() {
        Log.i("webview_controller", "call webview controller destroy .......");
        super.mo1577k();
        SharedPreferencesHelper.getInstance().removeWebSettings(this.f4716p.getSettings());
        m6765A0();
        this.f4716p.destroy();
        f4700P = null;
        this.f4688d = null;
        m6815z0();
    }

    public void m6801k1(String str) {
        Uri uri;
        if (TextUtils.isEmpty(str) || !str.startsWith("http") || (uri = Uri.parse(str)) == null) {
            return;
        }
        this.f4726z = uri.getHost();
    }

    @Override
    public void mo1578l() {
        m6813x0();
        this.f4716p.goForward();
        m6727F();
        this.f4726z = null;
    }

    public final void m6802l1(long j) {
        this.browserActivity.getHandler().postDelayed(new RunnableC1544b(), j);
    }

    public final void m6803m1() {
        String strMo1573b = mo1573b();
        if (this.pageType == 8) {
            ThemeManager.getInstance().m9474B(ThemeManager.f6998j);
            return;
        }
        if (!strMo1573b.startsWith("x:home") && !strMo1573b.startsWith("file:///android_asset/start-page/index.html")) {
            ThemeManager.getInstance().m9474B(this.f4713m);
        } else if (this.browserActivity.f4244F != null) {
            ThemeManager.getInstance().m9474B(this.browserActivity.f4244F);
        } else {
            ThemeManager.getInstance().m9474B(this.f4713m);
        }
    }

    @Override
    public void mo1580n() {
        m6813x0();
        this.browserActivity.m6218I0().m6396E();
        this.f4726z = null;
        this.f4716p.goBack();
        m6727F();
        this.browserActivity.getHandler().postDelayed(new RunnableC1547e(), 100L);
    }

    public void m6804n1(int i) {
        this.f4711k = i;
    }

    @Override
    public boolean mo5629o() {
        return this.f4710j;
    }

    public final void m6805o1(String url) {
        SiteSettingsManager.Host host;
        boolean z = false;
        if (pageType == 16 || pageType == 4 || pageType == 256 || pageType == 2 || pageType == 64 || pageType == 1 || pageType == 128) {
            this.browserActivity.m6346p0(pageType);
        } else if (pageType == 0 || pageType == 8) {
            String strM460o = NetworkUtils.getQueryParam("_xbpm_", url);
            if (!TextUtils.isEmpty(strM460o) && strM460o.equals("app")) {
                pageType = 1;
            }
            if ((this.pageType != 8 && (url.contains("limestart.cn") || url.contains("itab.link") || url.contains("inftab.com")))
                    || url.contains("gamezop.com") || url.contains("atmegame.com") || url.contains("gamereo.com")) {
                pageType = 512;
            } else if (url.contains("h5games")) {
                pageType = 128;
            } else if (url.contains("go.hypergames.top")) {
                pageType = 2;
            }
        } else if (url.startsWith("file:///android_asset/start-page/index.html")) {
            this.pageType = 0;
        }
        boolean zEquals = SharedPreferencesHelper.getInstance().acceptCookies;
        if (!TextUtils.isEmpty(this.f4726z) && (host = SiteSettingsManager.getInstance().getHost(5, this.f4726z)) != null) {
            zEquals = host.extra.equals("true");
        }
        if (this.pageType != 8 && !SharedPreferencesHelper.getInstance().enterPrivateMode) {
            CookieManager.getInstance().setAcceptCookie(zEquals);
            return;
        }
        CookieManager cookieManager = CookieManager.getInstance();
        if (zEquals && SharedPreferencesHelper.getInstance().supportCookiesInPrivate) {
            z = true;
        }
        cookieManager.setAcceptCookie(z);
    }

    @Override
    public void onClick(View view) {
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        m6806p1();
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) throws Resources.NotFoundException {
        if (i == 4 && this.f4701A != null) {
            if (this.pageType == 256) {
                this.browserActivity.m6361u0("native_call_exit_fullscreen()");
                return true;
            }
            m6774J0();
            return true;
        }
        BrowserActivity browserActivity = this.browserActivity;
        int i2 = browserActivity.f4264k;
        if (i2 == 3 && i == 4) {
            browserActivity.m6225K();
            return true;
        }
        if (i2 == 2 && i == 4) {
            browserActivity.m6365v0();
            return true;
        }
        if (i2 == 1 && i == 4) {
            browserActivity.m6377y0();
            return true;
        }
        if (browserActivity.m6338m1() && i == 4) {
            this.browserActivity.m6381z0();
            return true;
        }
        if (!MessageBoxManager.getInstance().isShowing()) {
            return super.onKeyDown(i, keyEvent);
        }
        MessageBoxManager.getInstance().dismiss();
        return true;
    }

    /* JADX WARN: Code restructure failed: missing block: B:15:0x0057, code lost:
    
        if (mo1573b().equals("about:blank") == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x005a, code lost:
    
        r0.setVisibility(View.GONE);
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0077, code lost:
    
        if (r4 == false) goto L17;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:?, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6806p1() {
        /*
            r6 = this;
            boolean r0 = r6.mo5624a()
            if (r0 == 0) goto L7a
            com.mmbox.xbrowser.BrowserActivity r0 = r6.f4685a
            r1 = 2131165578(0x7f07018a, float:1.7945377E38)
            android.view.View r0 = r0.findViewById(r1)
            java.lang.String r1 = r6.mo1573b()
            java.lang.String r2 = "http"
            boolean r1 = r1.startsWith(r2)
            r2 = 0
            if (r1 == 0) goto L20
        L1c:
            r0.setVisibility(r2)
            goto L7a
        L20:
            java.lang.String r1 = r6.mo1573b()
            java.lang.String r3 = "file:///android_asset/start-page/index.html"
            boolean r1 = r1.equals(r3)
            r3 = 8
            if (r1 != 0) goto L5e
            java.lang.String r1 = r6.mo1573b()
            java.lang.String r4 = "x:home"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L3b
            goto L5e
        L3b:
            java.lang.String r1 = r6.mo1573b()
            com.mmbox.xbrowser.d r4 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            java.lang.String r4 = r4.m6857H()
            boolean r1 = r1.equals(r4)
            if (r1 != 0) goto L1c
            java.lang.String r1 = r6.mo1573b()
            java.lang.String r4 = "about:blank"
            boolean r1 = r1.equals(r4)
            if (r1 == 0) goto L5a
            goto L1c
        L5a:
            r0.setVisibility(r3)
            goto L7a
        L5e:
            com.mmbox.xbrowser.BrowserActivity r1 = r6.f4685a
            android.content.res.Resources r1 = r1.getResources()
            android.content.res.Configuration r1 = r1.getConfiguration()
            int r1 = r1.orientation
            com.mmbox.xbrowser.d r4 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            java.lang.String r5 = "qa-fill-the-whole-screen"
            boolean r4 = r4.m6873Q(r5, r2)
            r5 = 2
            if (r1 == r5) goto L1c
            if (r4 == 0) goto L5a
            goto L1c
        L7a:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.controllers.WebViewBrowserController.m6806p1():void");
    }

    @Override
    public boolean mo1581q() {
        WebView webView = this.f4716p;
        if (webView == null) {
            return true;
        }
        ((C0219Ep) webView).f560k = false;
        return false;
    }

    @Override
    public boolean mo1582r(String str, SharedPreferences sharedPreferences) {
        Log.i("web-state", "restore tab id:" + str);
        this.f4724x = str;
        String string = sharedPreferences.getString(str + ".last_url", "");
        this.f4688d = string;
        if (string.indexOf("xbext.com") > 0 && this.f4688d.indexOf("open=true") > 0) {
            return false;
        }
        this.f4689e = sharedPreferences.getString(str + ".last_title", "");
        TextUtils.isEmpty(this.f4688d);
        return true;
    }

    public final void m6807r0(AbstractScrollableListController abstractC1540b) {
        MenuConfigManager.getInstance().m7021c(abstractC1540b, this.browserActivity.getResources().getString(com.xbrowser.play.R.string.page_info_view), com.xbrowser.play.R.string.page_info_view);
        MenuConfigManager.getInstance().m7021c(abstractC1540b, this.browserActivity.getResources().getString(com.xbrowser.play.R.string.inspect_element), com.xbrowser.play.R.string.inspect_element);
        C2061mf.m8471f0().m8538j0(abstractC1540b, "ep.menu.context");
        if (abstractC1540b.mo9012r() == 0) {
            Log.v("showContext", "no menu for this item ......");
        }
    }

    public final void m6808s0(String str) {
        if (TextUtils.isEmpty(str) || str.indexOf("file:///android_asset") >= 0) {
            return;
        }
        if (SharedPreferencesHelper.getInstance().enterDesktopMode) {
            if (str.indexOf("file:///android_asset") >= 0 || this.browserActivity.m6338m1()) {
                return;
            }
        } else if (TextUtils.isEmpty(this.f4726z) || !SiteSettingsManager.getInstance().m6959a0(this.f4726z)) {
            return;
        } else {
            Log.i("domain-set", ">>>>applyDestopMode");
        }
        C2061mf.m8471f0().m8542n0(this.f4716p, "desktop_mode");
    }

    @Override
    public void mo5631t() {
        C2061mf.m8471f0().m8543o(this.f4716p);
    }

    public void m6809t0(String str) {
        if (!TextUtils.isEmpty(str)) {
            if (str.indexOf("file:///android_asset") >= 0) {
                return;
            }
            if (SharedPreferencesHelper.getInstance().disableWriteClipboard || (!TextUtils.isEmpty(this.f4726z) && SiteSettingsManager.getInstance().m6945N(this.f4726z))) {
                this.browserActivity.m6361u0("document.execCommand = () => {};navigator.clipboard.write = () => {};navigator.clipboard.writeText = () => {};");
            }
        }
        if (!SharedPreferencesHelper.getInstance().forceUserScalable || SharedPreferencesHelper.getInstance().enterDesktopMode) {
            return;
        }
        this.browserActivity.m6361u0("if( window.innerWidth <= window.screen.width) { document.querySelector('meta[name=viewport]').setAttribute('content','width=device-width,initial-scale=1.0,maximum-scale=3.0,user-scalable=1');}");
    }

    @Override
    public void mo1584u() {
        Log.i("theme", "on webviewController active......" + this.f4726z);
        boolean z = SharedPreferencesHelper.getInstance().browserFullscreenMode;
        m6806p1();
        try {
            m6793c1();
            this.f4716p.onResume();
            this.f4716p.resumeTimers();
            String strMo1574c = mo1574c();
            if (!TextUtils.isEmpty(strMo1574c)) {
                getBrowserControllerListener().mo6449l(this, strMo1574c, true);
            }
            if (!TextUtils.isEmpty(this.f4688d)) {
                String strM445C = NetworkUtils.getFaviconUrl(this.f4716p.getUrl());
                if (!TextUtils.isEmpty(strM445C)) {
                    Drawable drawableM4146j = C0896Td.m4137c().m4146j(this.browserActivity, strM445C);
                    if (drawableM4146j == null || this.pageType != 0) {
                        this.browserActivity.m6218I0().m6394C().m1438u(mo5621A(0));
                    } else {
                        this.browserActivity.m6218I0().m6394C().m1438u(drawableM4146j);
                    }
                }
            }
            this.browserActivity.f4262i = false;
            if (!TextUtils.isEmpty(this.f4726z)) {
                C2061mf.m8471f0().m8497J(this.f4726z);
            }
            if (pageType == 16 || pageType == 64 || pageType == 4 || pageType == 256 || pageType == 2 || pageType == 1) {
                this.browserActivity.m6346p0(pageType);
            } else {
                this.browserActivity.m6205F();
            }
            if (this.f4711k != 1) {
                this.browserActivity.m6218I0().m6394C().m1429l(this.f4711k);
            }
            this.browserActivity.m6218I0().m6394C().m1440w(this.f4688d);
            String url = this.f4716p.getUrl();
            BrowserActivity browserActivity = this.browserActivity;
            browserActivity.f4242D = url;
            browserActivity.f4243E = this.f4716p.getTitle();
            m6801k1(url);
            m6803m1();
            m6802l1(10L);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public final void m6810u0(String str) throws IOException {
        int i;
        if (ThemeManager.getInstance().m9500u().mo1390i()) {
            if (this.f4709i != 1 && ((i = this.pageType) == 0 || i == 512)) {
                m6781Q0();
            }
            int i2 = this.f4713m[0];
            if (i2 != -1 || i2 == 0xFF000000) {
                if ((SharedPreferencesHelper.getInstance().m6857H().equals(str) || str.equals("file:///android_asset/start-page/index.html")) && this.f4709i == 3) {
                    FileUtils.writeIntArrayToFile(this.f4713m, ResourceCacheManager.getInstance().m2046a("page.immerse.colors", 1));
                    return;
                }
                return;
            }
            if ((SharedPreferencesHelper.getInstance().m6857H().equals(str) || str.equals("file:///android_asset/start-page/index.html")) && this.browserActivity.m6314f1()) {
                if (this.browserActivity.f4244F != null) {
                    ThemeManager.getInstance().m9474B(this.browserActivity.f4244F);
                    return;
                }
                String strM2046a = ResourceCacheManager.getInstance().m2046a("page.immerse.colors", 1);
                if (FileUtils.fileExists(strM2046a)) {
                    int[] iArrM4242z = FileUtils.readIntArrayFromFile(strM2046a);
                    this.f4713m = iArrM4242z;
                    if (iArrM4242z.length != 2 || iArrM4242z[0] == -1) {
                        return;
                    }
                    this.browserActivity.f4244F = iArrM4242z;
                    ThemeManager.getInstance().m9474B(this.f4713m);
                }
            }
        }
    }

    @Override
    public void mo1585v(String str, SharedPreferences.Editor editor) {
        StringBuilder sb;
        String strMo1573b = mo1573b();
        if (TextUtils.isEmpty(strMo1573b)) {
            return;
        }
        String string = SharedPreferencesHelper.getInstance().m6875R().getString(str + ".last_url", "");
        try {
            File file = new File(this.browserActivity.getFilesDir(), "webstack-" + str);
            if (!file.exists() || (strMo1573b.startsWith("http") && !strMo1573b.equals(string))) {
                Log.i("web-state", "do  keep current tab webstack-" + str);
                Bundle bundle = new Bundle();
                WebBackForwardList webBackForwardListSaveState = this.f4716p.saveState(bundle);
                if (webBackForwardListSaveState != null && webBackForwardListSaveState.getSize() > 0) {
                    Parcel parcelObtain = Parcel.obtain();
                    parcelObtain.setDataPosition(0);
                    bundle.writeToParcel(parcelObtain, 0);
                    byte[] bArrMarshall = parcelObtain.marshall();
                    FileOutputStream fileOutputStream = new FileOutputStream(file);
                    fileOutputStream.write(bArrMarshall);
                    fileOutputStream.close();
                    parcelObtain.recycle();
                }
            }
            editor.putString(str + ".last_url", strMo1573b);
            sb = new StringBuilder();
        } catch (Exception unused) {
            editor.putString(str + ".last_url", strMo1573b);
            sb = new StringBuilder();
        } catch (Throwable th) {
            editor.putString(str + ".last_url", strMo1573b);
            editor.putString(str + ".last_title", this.f4689e);
            throw th;
        }
        sb.append(str);
        sb.append(".last_title");
        editor.putString(sb.toString(), this.f4689e);
    }

    public final boolean m6811v0() {
        return this.f4716p.getUrl().indexOf("file://") < 0;
    }

    /* JADX WARN: Removed duplicated region for block: B:10:0x006f A[PHI: r15
  0x006f: PHI (r15v3 int) = (r15v0 int), (r15v1 int) binds: [B:9:0x006d, B:12:0x0079] A[DONT_GENERATE, DONT_INLINE]] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo1615w(p000.InterfaceC0529Ld r17, android.view.ContextMenu.ContextMenuInfo r18) throws Throwable {
        /*
            Method dump skipped, instructions count: 1363
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.controllers.WebViewBrowserController.mo1615w(Ld, android.view.ContextMenu$ContextMenuInfo):void");
    }

    public void m6812w0(int i) {
        this.f4709i = i;
    }

    @Override
    public boolean mo1586x() {
        return this.f4716p.canGoBack();
    }

    public final void m6813x0() {
        if (!C2480vj.getInstance().m10378n() || SharedPreferencesHelper.getInstance().someFlag1) {
            return;
        }
        C2480vj.getInstance().m10377l();
    }

    public final void m6814y0() {
        ViewGroup viewGroup = (ViewGroup) this.browserActivity.getLayoutInflater().inflate(com.xbrowser.play.R.layout.browser_subwindow, (ViewGroup) null);
        this.f4704D = viewGroup;
        ViewGroup viewGroup2 = (ViewGroup) viewGroup.findViewById(com.xbrowser.play.R.id.inner_container);
        WebView webViewM9499t = ThemeManager.getInstance().m9499t();
        this.f4717q = webViewM9499t;
        webViewM9499t.setWebViewClient(this.f4708H);
        this.f4717q.setWebChromeClient(this.f4707G);
        this.f4717q.setTag(this);
        this.f4717q.setLongClickable(true);
        this.f4717q.setDownloadListener(new C1545c());
        viewGroup2.addView(this.f4717q, new ViewGroup.LayoutParams(-1, -1));
        ((ImageView) this.f4704D.findViewById(com.xbrowser.play.R.id.subwindow_close)).setOnClickListener(new ViewOnClickListenerC1546d());
        this.browserActivity.m6250Q0().addView(this.f4704D, new FrameLayout.LayoutParams(-1, -1));
    }

    @Override
    public boolean mo1587z() {
        WebView webView = this.f4716p;
        if (webView != null) {
            return ((C0219Ep) webView).f560k;
        }
        return false;
    }

    public final void m6815z0() {
        if (TextUtils.isEmpty(this.f4724x)) {
            return;
        }
        Log.i("web-state", "delete tab id:" + this.f4724x);
        new File(this.browserActivity.getFilesDir(), "webstack-" + this.f4724x).delete();
    }

    public WebViewBrowserController(BrowserActivity browserActivity, BrowserControllerListener browserControllerListener, boolean z) {
        super(browserActivity, browserControllerListener);
        this.f4709i = 0;
        this.f4710j = false;
        this.f4711k = 0;
        this.f4712l = 1;
        this.f4713m = m6731J();
        this.f4714n = 1;
        this.f4715o = 0;
        this.f4716p = null;
        this.f4717q = null;
        this.f4718r = false;
        this.f4719s = false;
        this.f4723w = false;
        this.f4724x = null;
        this.f4725y = null;
        this.f4726z = null;
        this.f4704D = null;
        this.f4706F = false;
        this.f4707G = new C1543a();
        this.f4708H = new C1554l();
        this.f4710j = z;
        m6775K0();
        if (z) {
            this.f4718r = true;
        }
    }
}
