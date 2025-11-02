package p000;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Environment;
import android.os.Handler;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.webkit.CookieManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.URLEncoder;
import java.util.HashMap;

import okhttp3.OkHttpClient;

public class C0232F1 implements InterfaceC0094C1 {

    public static C0232F1 f612c;

    public OkHttpClient httpClient = null;

    public Handler handler = null;

    public class a implements InterfaceC0556M3 {

        public final d f615a;

        public final String f616b;

        public final int f617c;

        public a(d dVar, String str, int i) {
            this.f615a = dVar;
            this.f616b = str;
            this.f617c = i;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) throws IOException {
            if (c0490Kk.m2396j() == 200) {
                C0232F1.this.m1179o(ResourceCacheManager.getInstance().m2046a(this.f616b, this.f617c), c0490Kk, this.f615a);
            } else {
                d dVar = this.f615a;
                if (dVar != null) {
                    dVar.mo845b();
                }
            }
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            d dVar = this.f615a;
            if (dVar != null) {
                dVar.mo845b();
            }
        }
    }

    public class b implements InterfaceC0556M3 {

        public final d f619a;

        public final String f620b;

        public final String f621c;

        public final String f622d;

        public b(d dVar, String str, String str2, String str3) {
            this.f619a = dVar;
            this.f620b = str;
            this.f621c = str2;
            this.f622d = str3;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) throws IOException {
            if (c0490Kk.m2396j() != 200) {
                d dVar = this.f619a;
                if (dVar != null) {
                    dVar.mo845b();
                    return;
                }
                return;
            }
            String strM468w = NetworkUtils.generateFileName(this.f620b, null, c0490Kk.m2399p("Content-Type"));
            if (!TextUtils.isEmpty(this.f621c)) {
                strM468w = this.f621c;
            }
            String strM4234r = this.f622d + "/" + strM468w;
            if (FileUtils.fileExists(strM4234r)) {
                strM4234r = FileUtils.getNextAvailableFilePath(strM4234r);
            }
            C0232F1.this.m1179o(strM4234r, c0490Kk, this.f619a);
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            iOException.printStackTrace();
            d dVar = this.f619a;
            if (dVar != null) {
                dVar.mo845b();
            }
        }
    }

    public class c implements InterfaceC0556M3 {

        public final InterfaceC2229q7 f624a;

        public final InterfaceC2183p7 f625b;

        public final String f626c;

        public final String f627d;

        public class a implements Runnable {

            public final Drawable f629l;

            public a(Drawable drawable) {
                this.f629l = drawable;
            }

            @Override
            public void run() {
                if (!c.this.f625b.mo9041h(this.f629l, 3)) {
                    c cVar = c.this;
                    InterfaceC2229q7 interfaceC2229q7 = cVar.f624a;
                    if (interfaceC2229q7 != null) {
                        interfaceC2229q7.mo7838b(cVar.f625b);
                        return;
                    }
                    return;
                }
                Log.d("datasource", ">>>> the data source from http:[" + c.this.f625b.mo8842b() + "] + is ok ");
                c cVar2 = c.this;
                InterfaceC2229q7 interfaceC2229q72 = cVar2.f624a;
                if (interfaceC2229q72 != null) {
                    interfaceC2229q72.mo7837a(cVar2.f625b);
                }
            }
        }

        public class b implements Runnable {

            public final String f631l;

            public b(String str) {
                this.f631l = str;
            }

            @Override
            public void run() {
                if (!c.this.f625b.mo9041h(this.f631l, 1)) {
                    c cVar = c.this;
                    InterfaceC2229q7 interfaceC2229q7 = cVar.f624a;
                    if (interfaceC2229q7 != null) {
                        interfaceC2229q7.mo7838b(cVar.f625b);
                        return;
                    }
                    return;
                }
                Log.d("datasource", ">>>> the data source from http:[" + c.this.f625b.mo8842b() + "] + is ok ");
                c cVar2 = c.this;
                InterfaceC2229q7 interfaceC2229q72 = cVar2.f624a;
                if (interfaceC2229q72 != null) {
                    interfaceC2229q72.mo7837a(cVar2.f625b);
                }
            }
        }

        public c(InterfaceC2229q7 interfaceC2229q7, InterfaceC2183p7 interfaceC2183p7, String str, String str2) {
            this.f624a = interfaceC2229q7;
            this.f625b = interfaceC2183p7;
            this.f626c = str;
            this.f627d = str2;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            InterfaceC2229q7 interfaceC2229q7;
            InterfaceC2183p7 interfaceC2183p7;
            Handler handler;
            Runnable bVar;
            try {
                try {
                    String strM1177m = C0232F1.this.getMimeTypeForUrl(this.f626c, c0490Kk.m2399p("Content-Type"));
                    String strM2046a = ResourceCacheManager.getInstance().m2046a(this.f627d, 1);
                    if (strM1177m != null) {
                        if (strM1177m.indexOf("image/") >= 0) {
                            FileUtils.writeBytesToFile(c0490Kk.m2392a().m2709b(), strM2046a);
                            Drawable drawableM4399i = C0988Vd.m4391d().m4399i(strM2046a, SharedPreferencesHelper.getInstance().homeIconStyle);
                            handler = C0232F1.this.handler;
                            bVar = new a(drawableM4399i);
                        } else if (strM1177m.indexOf("/json") >= 0) {
                            String strM2714l = c0490Kk.m2392a().m2714l();
                            FileUtils.writeBytesToFile(strM2714l.getBytes(), strM2046a);
                            handler = C0232F1.this.handler;
                            bVar = new b(strM2714l);
                        } else if (strM1177m.indexOf("text/") >= 0) {
                            String strM2714l2 = c0490Kk.m2392a().m2714l();
                            if (c0490Kk.m2396j() == 200) {
                                FileUtils.writeBytesToFile(strM2714l2.getBytes(), strM2046a);
                                if (this.f625b.mo9041h(strM2714l2, 5)) {
                                    InterfaceC2229q7 interfaceC2229q72 = this.f624a;
                                    if (interfaceC2229q72 != null) {
                                        interfaceC2229q72.mo7837a(this.f625b);
                                    }
                                } else {
                                    interfaceC2229q7 = this.f624a;
                                    if (interfaceC2229q7 != null) {
                                        interfaceC2183p7 = this.f625b;
                                        interfaceC2229q7.mo7838b(interfaceC2183p7);
                                    }
                                }
                            } else {
                                interfaceC2229q7 = this.f624a;
                                if (interfaceC2229q7 != null) {
                                    interfaceC2183p7 = this.f625b;
                                    interfaceC2229q7.mo7838b(interfaceC2183p7);
                                }
                            }
                        }
                        handler.post(bVar);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    InterfaceC2229q7 interfaceC2229q73 = this.f624a;
                    if (interfaceC2229q73 != null) {
                        interfaceC2229q73.mo7838b(this.f625b);
                    }
                }
            } finally {
                c0490Kk.m2392a().close();
            }
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            iOException.printStackTrace();
            InterfaceC2229q7 interfaceC2229q7 = this.f624a;
            if (interfaceC2229q7 != null) {
                interfaceC2229q7.mo7838b(this.f625b);
            }
        }
    }

    public interface d {
        void mo844a(String str, String str2);

        void mo845b();
    }

    public static C0232F1 m1169l() {
        if (f612c == null) {
            f612c = new C0232F1();
        }
        return f612c;
    }

    @Override
    public void mo364a(String str, boolean z, InterfaceC2229q7 interfaceC2229q7, HashMap map) {
        InterfaceC2183p7 interfaceC2183p7M9356i = C2275r7.m9348e().m9356i(str);
        if (interfaceC2183p7M9356i == null) {
            return;
        }
        if (interfaceC2183p7M9356i.mo9040g() != null && interfaceC2229q7 != null && z) {
            interfaceC2229q7.mo7837a(interfaceC2183p7M9356i);
            return;
        }
        String strM2046a = ResourceCacheManager.getInstance().m2046a(str, 1);
        if (!z || !FileUtils.fileExists(strM2046a) || map != null) {
            String strM1176k = map == null ? str : m1176k(str, map);
            this.httpClient.m2004y(new C0122Ck.a().m507i(strM1176k).m500b()).mo1791i(new c(interfaceC2229q7, interfaceC2183p7M9356i, strM1176k, str));
            return;
        }
        if (!interfaceC2183p7M9356i.mo9041h(interfaceC2183p7M9356i.mo9037c() == 3 ? C0988Vd.m4391d().m4399i(strM2046a, SharedPreferencesHelper.getInstance().homeIconStyle) : FileUtils.readFileToString(strM2046a), interfaceC2183p7M9356i.mo9037c())) {
            if (interfaceC2229q7 != null) {
                interfaceC2229q7.mo7838b(interfaceC2183p7M9356i);
            }
            FileUtils.deleteFile(strM2046a);
        } else if (interfaceC2229q7 != null) {
            interfaceC2229q7.mo7837a(interfaceC2183p7M9356i);
        }
        Log.d("datasource", ">>>> do load resource from cache :" + str);
    }

    public void m1170e(String str, String str2, d dVar) {
        m1172g(str, null, null, str2, null, dVar);
    }

    public void m1171f(String str, String str2, String str3, d dVar) {
        m1172g(str, null, null, str2, str3, dVar);
    }

    public void m1172g(String str, String str2, String str3, String str4, String str5, d dVar) {
        if (TextUtils.isEmpty(str4)) {
            return;
        }
        if (str4.startsWith("http")) {
            C0122Ck.a aVarM507i = new C0122Ck.a().m507i(str4);
            if (str3 != null) {
                try {
                    aVarM507i.m499a("User-Agent", str3);
                } catch (IllegalArgumentException unused) {
                }
            } else {
                SharedPreferencesHelper.getInstance();
                aVarM507i.m499a("User-Agent", SharedPreferencesHelper.defaultUserAgent);
            }
            if (str2 != null) {
                if (str2.indexOf("dlpanda.com") < 0) {
                    aVarM507i.m499a("Referer", str2);
                }
                String cookie = CookieManager.getInstance().getCookie(str2);
                if (cookie != null) {
                    aVarM507i.m499a("Cookie", cookie);
                }
            }
            this.httpClient.m2004y(aVarM507i.m500b()).mo1791i(new b(dVar, str4, str5, str));
            return;
        }
        if (str4.startsWith("data:image/")) {
            String[] strArrM470y = NetworkUtils.parseDataUriLegacy(str4);
            if (strArrM470y.length <= 0) {
                if (dVar != null) {
                    dVar.mo845b();
                    return;
                }
                return;
            }
            String str6 = strArrM470y[0];
            String str7 = strArrM470y[1];
            String str8 = strArrM470y[2];
            if (str7 == null || !str7.equals("base64")) {
                return;
            }
            String str9 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES).getAbsolutePath() + "/" + NetworkUtils.generateFileName(str4, null, str6);
            FileUtils.ensureParentDirsExist(str9);
            FileUtils.writeBytesToFile(Base64.decode(str8, 0), str9);
            if (dVar != null) {
                dVar.mo844a(str9, str6);
            }
        }
    }

    public void m1173h(String str) {
        m1174i(str, null);
    }

    public void m1174i(String str, d dVar) {
        m1175j(str, dVar, 9);
    }

    public void m1175j(String str, d dVar, int i) {
        C0122Ck.a aVarM507i = new C0122Ck.a().m507i(str);
        String strM6849D = SharedPreferencesHelper.getInstance().m6849D();
        if (TextUtils.isEmpty(strM6849D)) {
            strM6849D = SharedPreferencesHelper.defaultUserAgent;
        }
        aVarM507i.m499a("User-Agent", strM6849D);
        this.httpClient.m2004y(aVarM507i.m500b()).mo1791i(new a(dVar, str, i));
    }

    public final String m1176k(String str, HashMap map) {
        try {
            for (String str2 : map.keySet()) {
                str = str.replaceAll("%" + str2 + "%", URLEncoder.encode((String) map.get(str2), "UTF-8"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return str;
    }

    public final String getMimeTypeForUrl(String url, String defaultMime) {
        if ("http://top.baidu.com/mobile_v2/buzz/hotspot".equals(url)
                || url.contains("http://suggestion.baidu.com/su")) {
            return "application/json";
        }
        return defaultMime;
    }

    public C0232F1 m1178n(Context context) {
        this.httpClient = NetworkUtils.createUnsafeOkHttpClient();
        this.handler = new Handler();
        return this;
    }

    public final void m1179o(String str, C0490Kk c0490Kk, d dVar) throws IOException {
        FileUtils.ensureParentDirsExist(str);
        String strM2399p = c0490Kk.m2399p("Content-Type");
        InputStream inputStreamM2708a = c0490Kk.m2392a().m2708a();
        FileOutputStream fileOutputStream = new FileOutputStream(str, false);
        try {
            try {
                byte[] bArr = new byte[8192];
                boolean z = false;
                while (true) {
                    int i = inputStreamM2708a.read(bArr);
                    if (i == -1 || Thread.currentThread().isInterrupted()) {
                        break;
                    }
                    if (TextUtils.isEmpty(strM2399p) && !z) {
                        byte[] bArr2 = new byte[4];
                        System.arraycopy(bArr, 0, bArr2, 0, 4);
                        strM2399p = FileUtils.getMimeTypeFromBytes(bArr2);
                        z = true;
                    }
                    fileOutputStream.write(bArr, 0, i);
                }
                if (dVar != null) {
                    dVar.mo844a(str, strM2399p);
                }
                inputStreamM2708a.close();
            } catch (Exception e) {
                e.printStackTrace();
                if (dVar != null) {
                    dVar.mo845b();
                }
                if (inputStreamM2708a != null) {
                    inputStreamM2708a.close();
                }
            }
            fileOutputStream.close();
            c0490Kk.m2392a().close();
        } catch (Throwable th) {
            if (inputStreamM2708a != null) {
                try {
                    inputStreamM2708a.close();
                } catch (IOException unused) {
                    c0490Kk.m2392a().close();
                    throw th;
                }
            }
            fileOutputStream.close();
            c0490Kk.m2392a().close();
            throw th;
        }
    }
}
