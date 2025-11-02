package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.pm.ServiceInfo;
import android.content.pm.Signature;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.os.RemoteException;
import android.os.ext.SdkExtensions;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.math.BigInteger;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.cert.CertificateException;
import java.security.cert.CertificateFactory;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Objects;
import java.util.Random;
import java.util.TreeSet;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import java.util.concurrent.atomic.AtomicLong;
import javax.security.auth.x500.X500Principal;

/* loaded from: classes.dex */
public final class C2514wG extends AbstractC2508wA {

    public static final String[] f7816i = {"firebase_", "google_", "ga_"};

    public static final String[] f7817j = {"_err"};

    public SecureRandom f7818c;

    public final AtomicLong f7819d;

    public int f7820e;

    public AbstractC0578Mg f7821f;

    public Boolean f7822g;

    public Integer f7823h;

    public C2514wG(C2266qz c2266qz) {
        super(c2266qz);
        this.f7823h = null;
        this.f7819d = new AtomicLong(0L);
    }

    public static long m10443A(C0175Dr c0175Dr) {
        long length = 0;
        if (c0175Dr == null) {
            return 0L;
        }
        Iterator it = c0175Dr.iterator();
        while (it.hasNext()) {
            if (c0175Dr.m787k((String) it.next()) instanceof Parcelable[]) {
                length += ((Parcelable[]) r3).length;
            }
        }
        return length;
    }

    public static long m10444B(byte[] bArr) {
        AbstractC1085Xi.m4801j(bArr);
        int i = 0;
        AbstractC1085Xi.m4804m(bArr.length > 0);
        long j = 0;
        for (int length = bArr.length - 1; length >= 0 && length >= bArr.length - 8; length--) {
            j += (bArr[length] & 255) << i;
            i += 8;
        }
        return j;
    }

    public static boolean m10445B0(Context context, String str) {
        ServiceInfo serviceInfo;
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (serviceInfo = packageManager.getServiceInfo(new ComponentName(context, str), 0)) != null) {
                if (serviceInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static Bundle m10446D(Bundle bundle) {
        if (bundle == null) {
            return new Bundle();
        }
        Bundle bundle2 = new Bundle(bundle);
        for (String str : bundle2.keySet()) {
            Object obj = bundle2.get(str);
            if (obj instanceof Bundle) {
                bundle2.putBundle(str, new Bundle((Bundle) obj));
            } else {
                int i = 0;
                if (obj instanceof Parcelable[]) {
                    Parcelable[] parcelableArr = (Parcelable[]) obj;
                    while (i < parcelableArr.length) {
                        if (parcelableArr[i] instanceof Bundle) {
                            parcelableArr[i] = new Bundle((Bundle) parcelableArr[i]);
                        }
                        i++;
                    }
                } else if (obj instanceof List) {
                    List list = (List) obj;
                    while (i < list.size()) {
                        Object obj2 = list.get(i);
                        if (obj2 instanceof Bundle) {
                            list.set(i, new Bundle((Bundle) obj2));
                        }
                        i++;
                    }
                }
            }
        }
        return bundle2;
    }

    public static boolean m10447D0(String str) {
        return m10449G0((String) AbstractC0818Rr.f2494e0.m4296a(null), str);
    }

    public static Bundle m10448G(List list) {
        Bundle bundle = new Bundle();
        if (list == null) {
            return bundle;
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C2053mG c2053mG = (C2053mG) it.next();
            String str = c2053mG.f6161p;
            if (str != null) {
                bundle.putString(c2053mG.f6158m, str);
            } else {
                Long l = c2053mG.f6160o;
                if (l != null) {
                    bundle.putLong(c2053mG.f6158m, l.longValue());
                } else {
                    Double d = c2053mG.f6163r;
                    if (d != null) {
                        bundle.putDouble(c2053mG.f6158m, d.doubleValue());
                    }
                }
            }
        }
        return bundle;
    }

    public static boolean m10449G0(String str, String str2) {
        return str.equals("*") || Arrays.asList(str.split(",")).contains(str2);
    }

    public static boolean m10450H0(String str) {
        return m10449G0((String) AbstractC0818Rr.f2547z0.m4296a(null), str);
    }

    public static String m10451I(String str, int i, boolean z) {
        if (str == null) {
            return null;
        }
        if (str.codePointCount(0, str.length()) <= i) {
            return str;
        }
        if (!z) {
            return null;
        }
        return str.substring(0, str.offsetByCodePoints(0, i)) + "...";
    }

    public static boolean m10452J0(String str) {
        return !TextUtils.isEmpty(str) && str.startsWith("_");
    }

    public static void m10453L(Bundle bundle, int i, String str, Object obj) {
        if (m10472v0(bundle, i)) {
            bundle.putString("_ev", m10451I(str, 40, true));
            if (obj != null) {
                AbstractC1085Xi.m4801j(bundle);
                if ((obj instanceof String) || (obj instanceof CharSequence)) {
                    bundle.putLong("_el", String.valueOf(obj).length());
                }
            }
        }
    }

    public static boolean m10454L0(String str) {
        AbstractC1085Xi.m4795d(str);
        return str.charAt(0) != '_' || str.equals("_ep");
    }

    public static boolean m10455N0(String str) {
        for (String str2 : f7817j) {
            if (str2.equals(str)) {
                return false;
            }
        }
        return true;
    }

    public static int m10456Q0(String str) {
        if ("_ldl".equals(str)) {
            return 2048;
        }
        if ("_id".equals(str)) {
            return 256;
        }
        return "_lgclid".equals(str) ? 100 : 36;
    }

    private static boolean m10457T0(String str) {
        AbstractC1085Xi.m4801j(str);
        return str.matches("^(1:\\d+:android:[a-f0-9]+|ca-app-pub-.*)$");
    }

    public static MessageDigest m10458V0() throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance("MD5");
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }

    public static void m10459Y(C1162ZC c1162zc, Bundle bundle, boolean z) {
        if (bundle == null || c1162zc == null || (bundle.containsKey("_sc") && !z)) {
            if (bundle != null && c1162zc == null && z) {
                bundle.remove("_sn");
                bundle.remove("_sc");
                bundle.remove("_si");
                return;
            }
            return;
        }
        String str = c1162zc.f3421a;
        if (str != null) {
            bundle.putString("_sn", str);
        } else {
            bundle.remove("_sn");
        }
        String str2 = c1162zc.f3422b;
        if (str2 != null) {
            bundle.putString("_sc", str2);
        } else {
            bundle.remove("_sc");
        }
        bundle.putLong("_si", c1162zc.f3423c);
    }

    public static void m10460Z(InterfaceC2422uG interfaceC2422uG, int i, String str, String str2, int i2) {
        m10462a0(interfaceC2422uG, null, i, str, str2, i2);
    }

    private final boolean m10461Z0() {
        Integer num;
        if (this.f7822g == null) {
            AbstractC0578Mg abstractC0578MgM10499S0 = m10499S0();
            boolean z = false;
            if (abstractC0578MgM10499S0 == null) {
                return false;
            }
            Integer num2 = null;
            try {
                num = (Integer) abstractC0578MgM10499S0.mo2868b().get(10000L, TimeUnit.MILLISECONDS);
                if (num != null) {
                    try {
                        if (num.intValue() == 1) {
                            z = true;
                        }
                    } catch (InterruptedException e) {
                        e = e;
                        num2 = num;
                        mo349g().m9623L().m10617b("Measurement manager api exception", e);
                        this.f7822g = Boolean.FALSE;
                        num = num2;
                        mo349g().m9622K().m10617b("Measurement manager api status result", num);
                        return this.f7822g.booleanValue();
                    } catch (CancellationException e2) {
                        e = e2;
                        num2 = num;
                        mo349g().m9623L().m10617b("Measurement manager api exception", e);
                        this.f7822g = Boolean.FALSE;
                        num = num2;
                        mo349g().m9622K().m10617b("Measurement manager api status result", num);
                        return this.f7822g.booleanValue();
                    } catch (ExecutionException e3) {
                        e = e3;
                        num2 = num;
                        mo349g().m9623L().m10617b("Measurement manager api exception", e);
                        this.f7822g = Boolean.FALSE;
                        num = num2;
                        mo349g().m9622K().m10617b("Measurement manager api status result", num);
                        return this.f7822g.booleanValue();
                    } catch (TimeoutException e4) {
                        e = e4;
                        num2 = num;
                        mo349g().m9623L().m10617b("Measurement manager api exception", e);
                        this.f7822g = Boolean.FALSE;
                        num = num2;
                        mo349g().m9622K().m10617b("Measurement manager api status result", num);
                        return this.f7822g.booleanValue();
                    }
                }
                this.f7822g = Boolean.valueOf(z);
            } catch (InterruptedException e5) {
                e = e5;
            } catch (CancellationException e6) {
                e = e6;
            } catch (ExecutionException e7) {
                e = e7;
            } catch (TimeoutException e8) {
                e = e8;
            }
            mo349g().m9622K().m10617b("Measurement manager api status result", num);
        }
        return this.f7822g.booleanValue();
    }

    public static void m10462a0(InterfaceC2422uG interfaceC2422uG, String str, int i, String str2, String str3, int i2) {
        Bundle bundle = new Bundle();
        m10472v0(bundle, i);
        if (!TextUtils.isEmpty(str2) && !TextUtils.isEmpty(str3)) {
            bundle.putString(str2, str3);
        }
        if (i == 6 || i == 7 || i == 2) {
            bundle.putLong("_el", i2);
        }
        interfaceC2422uG.mo4024l(str, "_err", bundle);
    }

    public static boolean m10463d0(Context context) {
        ActivityInfo receiverInfo;
        AbstractC1085Xi.m4801j(context);
        try {
            PackageManager packageManager = context.getPackageManager();
            if (packageManager != null && (receiverInfo = packageManager.getReceiverInfo(new ComponentName(context, "com.google.android.gms.measurement.AppMeasurementReceiver"), 0)) != null) {
                if (receiverInfo.enabled) {
                    return true;
                }
            }
        } catch (PackageManager.NameNotFoundException unused) {
        }
        return false;
    }

    public static boolean m10464e0(Context context, boolean z) {
        AbstractC1085Xi.m4801j(context);
        return m10445B0(context, "com.google.android.gms.measurement.AppMeasurementJobService");
    }

    public static boolean m10465f0(Intent intent) {
        String stringExtra = intent.getStringExtra("android.intent.extra.REFERRER_NAME");
        return "android-app://com.google.android.googlequicksearchbox/https/www.google.com".equals(stringExtra) || "https://www.google.com".equals(stringExtra) || "android-app://com.google.appcrawler".equals(stringExtra);
    }

    public static boolean m10466g0(Bundle bundle, int i) {
        int i2 = 0;
        if (bundle.size() <= i) {
            return false;
        }
        for (String str : new TreeSet(bundle.keySet())) {
            i2++;
            if (i2 > i) {
                bundle.remove(str);
            }
        }
        return true;
    }

    public static boolean m10467h0(Object obj) {
        return (obj instanceof Parcelable[]) || (obj instanceof ArrayList) || (obj instanceof Bundle);
    }

    public static boolean m10468m0(String str, String str2, String str3, String str4) {
        boolean zIsEmpty = TextUtils.isEmpty(str);
        boolean zIsEmpty2 = TextUtils.isEmpty(str2);
        if (!zIsEmpty && !zIsEmpty2) {
            AbstractC1085Xi.m4801j(str);
            return !str.equals(str2);
        }
        if (zIsEmpty && zIsEmpty2) {
            return (TextUtils.isEmpty(str3) || TextUtils.isEmpty(str4)) ? !TextUtils.isEmpty(str4) : !str3.equals(str4);
        }
        if (zIsEmpty || !zIsEmpty2) {
            return TextUtils.isEmpty(str3) || !str3.equals(str4);
        }
        if (TextUtils.isEmpty(str4)) {
            return false;
        }
        return TextUtils.isEmpty(str3) || !str3.equals(str4);
    }

    public static boolean m10469n0(String str, String[] strArr) {
        AbstractC1085Xi.m4801j(strArr);
        for (String str2 : strArr) {
            if (Objects.equals(str, str2)) {
                return true;
            }
        }
        return false;
    }

    public static byte[] m10470q0(Parcelable parcelable) {
        if (parcelable == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelable.writeToParcel(parcelObtain, 0);
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }

    public static ArrayList m10471t0(List list) {
        if (list == null) {
            return new ArrayList<>(0);
        }
        ArrayList arrayList = new ArrayList<>(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C2303rq c2303rq = (C2303rq) it.next();
            Bundle bundle = new Bundle();
            bundle.putString("app_id", c2303rq.f6976l);
            bundle.putString("origin", c2303rq.f6977m);
            bundle.putLong("creation_timestamp", c2303rq.f6979o);
            bundle.putString("name", c2303rq.f6978n.f6158m);
            AbstractC0011AA.m67b(bundle, AbstractC1085Xi.m4801j(c2303rq.f6978n.m8448d()));
            bundle.putBoolean("active", c2303rq.f6980p);
            String str = c2303rq.f6981q;
            if (str != null) {
                bundle.putString("trigger_event_name", str);
            }
            C0635Nr c0635Nr = c2303rq.f6982r;
            if (c0635Nr != null) {
                bundle.putString("timed_out_event_name", c0635Nr.f1974l);
                C0175Dr c0175Dr = c0635Nr.f1975m;
                if (c0175Dr != null) {
                    bundle.putBundle("timed_out_event_params", c0175Dr.m785h());
                }
            }
            bundle.putLong("trigger_timeout", c2303rq.f6983s);
            C0635Nr c0635Nr2 = c2303rq.f6984t;
            if (c0635Nr2 != null) {
                bundle.putString("triggered_event_name", c0635Nr2.f1974l);
                C0175Dr c0175Dr2 = c0635Nr2.f1975m;
                if (c0175Dr2 != null) {
                    bundle.putBundle("triggered_event_params", c0175Dr2.m785h());
                }
            }
            bundle.putLong("triggered_timestamp", c2303rq.f6978n.f6159n);
            bundle.putLong("time_to_live", c2303rq.f6985u);
            C0635Nr c0635Nr3 = c2303rq.f6986v;
            if (c0635Nr3 != null) {
                bundle.putString("expired_event_name", c0635Nr3.f1974l);
                C0175Dr c0175Dr3 = c0635Nr3.f1975m;
                if (c0175Dr3 != null) {
                    bundle.putBundle("expired_event_params", c0175Dr3.m785h());
                }
            }
            arrayList.add(bundle);
        }
        return arrayList;
    }

    public static boolean m10472v0(Bundle bundle, int i) {
        if (bundle == null || bundle.getLong("_err") != 0) {
            return false;
        }
        bundle.putLong("_err", i);
        return true;
    }

    public static Bundle[] m10473x0(Object obj) {
        if (obj instanceof Bundle) {
            return new Bundle[]{(Bundle) obj};
        }
        if (obj instanceof Parcelable[]) {
            Parcelable[] parcelableArr = (Parcelable[]) obj;
            return (Bundle[]) Arrays.copyOf(parcelableArr, parcelableArr.length, Bundle[].class);
        }
        if (!(obj instanceof ArrayList)) {
            return null;
        }
        ArrayList arrayList = (ArrayList) obj;
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static long m10474y(long j, long j2) {
        return (j + (j2 * 60000)) / 86400000;
    }

    public static int m10475y0() {
        if (Build.VERSION.SDK_INT < 30 || SdkExtensions.getExtensionVersion(30) <= 3) {
            return 0;
        }
        return SdkExtensions.getExtensionVersion(1000000);
    }

    public final Object m10476A0(String str, Object obj) {
        return "_ldl".equals(str) ? m10483H(m10456Q0(str), obj, true, false, null) : m10483H(m10456Q0(str), obj, false, false, null);
    }

    public final Bundle m10477C(Uri uri, boolean z) {
        String queryParameter;
        String queryParameter2;
        String queryParameter3;
        String queryParameter4;
        String queryParameter5;
        String queryParameter6;
        String queryParameter7;
        String queryParameter8;
        String queryParameter9;
        String str;
        if (uri == null) {
            return null;
        }
        try {
            if (uri.isHierarchical()) {
                queryParameter = uri.getQueryParameter("utm_campaign");
                queryParameter2 = uri.getQueryParameter("utm_source");
                queryParameter3 = uri.getQueryParameter("utm_medium");
                queryParameter4 = uri.getQueryParameter("gclid");
                queryParameter5 = z ? uri.getQueryParameter("gbraid") : null;
                queryParameter6 = uri.getQueryParameter("utm_id");
                queryParameter7 = uri.getQueryParameter("dclid");
                queryParameter8 = uri.getQueryParameter("srsltid");
                queryParameter9 = uri.getQueryParameter("sfmc_id");
            } else {
                queryParameter = null;
                queryParameter2 = null;
                queryParameter3 = null;
                queryParameter4 = null;
                queryParameter5 = null;
                queryParameter6 = null;
                queryParameter7 = null;
                queryParameter8 = null;
                queryParameter9 = null;
            }
            if (TextUtils.isEmpty(queryParameter) && TextUtils.isEmpty(queryParameter2) && TextUtils.isEmpty(queryParameter3) && TextUtils.isEmpty(queryParameter4) && ((!z || TextUtils.isEmpty(queryParameter5)) && TextUtils.isEmpty(queryParameter6) && TextUtils.isEmpty(queryParameter7) && TextUtils.isEmpty(queryParameter8) && TextUtils.isEmpty(queryParameter9))) {
                return null;
            }
            Bundle bundle = new Bundle();
            if (TextUtils.isEmpty(queryParameter)) {
                str = "sfmc_id";
            } else {
                str = "sfmc_id";
                bundle.putString("campaign", queryParameter);
            }
            if (!TextUtils.isEmpty(queryParameter2)) {
                bundle.putString("source", queryParameter2);
            }
            if (!TextUtils.isEmpty(queryParameter3)) {
                bundle.putString("medium", queryParameter3);
            }
            if (!TextUtils.isEmpty(queryParameter4)) {
                bundle.putString("gclid", queryParameter4);
            }
            if (z && !TextUtils.isEmpty(queryParameter5)) {
                bundle.putString("gbraid", queryParameter5);
            }
            String queryParameter10 = uri.getQueryParameter("gad_source");
            if (z && !TextUtils.isEmpty(queryParameter10)) {
                bundle.putString("gad_source", queryParameter10);
            }
            String queryParameter11 = uri.getQueryParameter("utm_term");
            if (!TextUtils.isEmpty(queryParameter11)) {
                bundle.putString("term", queryParameter11);
            }
            String queryParameter12 = uri.getQueryParameter("utm_content");
            if (!TextUtils.isEmpty(queryParameter12)) {
                bundle.putString("content", queryParameter12);
            }
            String queryParameter13 = uri.getQueryParameter("aclid");
            if (!TextUtils.isEmpty(queryParameter13)) {
                bundle.putString("aclid", queryParameter13);
            }
            String queryParameter14 = uri.getQueryParameter("cp1");
            if (!TextUtils.isEmpty(queryParameter14)) {
                bundle.putString("cp1", queryParameter14);
            }
            String queryParameter15 = uri.getQueryParameter("anid");
            if (!TextUtils.isEmpty(queryParameter15)) {
                bundle.putString("anid", queryParameter15);
            }
            if (!TextUtils.isEmpty(queryParameter6)) {
                bundle.putString("campaign_id", queryParameter6);
            }
            if (!TextUtils.isEmpty(queryParameter7)) {
                bundle.putString("dclid", queryParameter7);
            }
            String queryParameter16 = uri.getQueryParameter("utm_source_platform");
            if (!TextUtils.isEmpty(queryParameter16)) {
                bundle.putString("source_platform", queryParameter16);
            }
            String queryParameter17 = uri.getQueryParameter("utm_creative_format");
            if (!TextUtils.isEmpty(queryParameter17)) {
                bundle.putString("creative_format", queryParameter17);
            }
            String queryParameter18 = uri.getQueryParameter("utm_marketing_tactic");
            if (!TextUtils.isEmpty(queryParameter18)) {
                bundle.putString("marketing_tactic", queryParameter18);
            }
            if (!TextUtils.isEmpty(queryParameter8)) {
                bundle.putString("srsltid", queryParameter8);
            }
            if (!TextUtils.isEmpty(queryParameter9)) {
                bundle.putString(str, queryParameter9);
            }
            return bundle;
        } catch (UnsupportedOperationException e) {
            mo349g().m9623L().m10617b("Install referrer url isn't a hierarchical URI", e);
            return null;
        }
    }

    public final boolean m10478C0(String str, String str2) {
        if (str2 == null) {
            mo349g().m9619H().m10617b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo349g().m9619H().m10617b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt)) {
            mo349g().m9619H().m10618c("Name must start with a letter. Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                mo349g().m9619H().m10618c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    public final Bundle m10479E(Bundle bundle, String str) {
        Bundle bundle2 = new Bundle();
        if (bundle != null) {
            for (String str2 : bundle.keySet()) {
                Object objM10518s0 = m10518s0(str2, bundle.get(str2));
                if (objM10518s0 == null) {
                    mo349g().m9624M().m10617b("Param value can't be null", mo350h().m9212f(str2));
                } else {
                    m10491O(bundle2, str2, objM10518s0);
                }
            }
        }
        return bundle2;
    }

    public final boolean m10480E0(String str, String str2) {
        if (C2470vI.m10339a() && mo347e().m10818t(AbstractC0818Rr.f2545y0) && !TextUtils.isEmpty(str2)) {
            return true;
        }
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        return mo347e().m10807V().equals(str);
    }

    public final Bundle m10481F(String str, String str2, Bundle bundle, List list, boolean z) {
        int iM10494P0;
        int i;
        C2514wG c2514wG = this;
        boolean zM10469n0 = m10469n0(str2, AbstractC0701PA.f2095d);
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = new Bundle(bundle);
        int iM10801K = mo347e().m10801K();
        int i2 = 0;
        for (String str3 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str3)) {
                iM10494P0 = !z ? c2514wG.m10494P0(str3) : 0;
                if (iM10494P0 == 0) {
                    iM10494P0 = c2514wG.m10492O0(str3);
                }
            } else {
                iM10494P0 = 0;
            }
            if (iM10494P0 != 0) {
                m10453L(bundle2, iM10494P0, str3, iM10494P0 == 3 ? str3 : null);
                bundle2.remove(str3);
                i = iM10801K;
            } else {
                i = iM10801K;
                int iM10524x = m10524x(str, str2, str3, bundle.get(str3), bundle2, list, z, zM10469n0);
                if (iM10524x == 17) {
                    m10453L(bundle2, iM10524x, str3, Boolean.FALSE);
                } else if (iM10524x != 0 && !"_ev".equals(str3)) {
                    m10453L(bundle2, iM10524x, iM10524x == 21 ? str2 : str3, bundle.get(str3));
                    bundle2.remove(str3);
                }
                if (m10454L0(str3)) {
                    int i3 = i2 + 1;
                    if (i3 > i) {
                        mo349g().m9619H().m10618c("Event can't contain more than " + i + " params", mo350h().m9209b(str2), mo350h().m9208a(bundle));
                        m10472v0(bundle2, 5);
                        bundle2.remove(str3);
                    }
                    i2 = i3;
                }
            }
            iM10801K = i;
            c2514wG = this;
        }
        return bundle2;
    }

    public final boolean m10482F0(String str) {
        mo356n();
        if (C2670zp.m11048a(mo344a()).m10888a(str) == 0) {
            return true;
        }
        mo349g().m9617F().m10617b("Permission not granted", str);
        return false;
    }

    public final Object m10483H(int i, Object obj, boolean z, boolean z2, String str) {
        Bundle bundleM10479E;
        if (obj == null) {
            return null;
        }
        if ((obj instanceof Long) || (obj instanceof Double)) {
            return obj;
        }
        if (obj instanceof Integer) {
            return Long.valueOf(((Integer) obj).intValue());
        }
        if (obj instanceof Byte) {
            return Long.valueOf(((Byte) obj).byteValue());
        }
        if (obj instanceof Short) {
            return Long.valueOf(((Short) obj).shortValue());
        }
        if (obj instanceof Boolean) {
            return Long.valueOf(((Boolean) obj).booleanValue() ? 1L : 0L);
        }
        if (obj instanceof Float) {
            return Double.valueOf(((Float) obj).doubleValue());
        }
        if ((obj instanceof String) || (obj instanceof Character) || (obj instanceof CharSequence)) {
            return m10451I(String.valueOf(obj), i, z);
        }
        if (!z2 || (!(obj instanceof Bundle[]) && !(obj instanceof Parcelable[]))) {
            return null;
        }
        ArrayList arrayList = new ArrayList<>();
        for (Parcelable parcelable : (Parcelable[]) obj) {
            if ((parcelable instanceof Bundle) && (bundleM10479E = m10479E((Bundle) parcelable, null)) != null && !bundleM10479E.isEmpty()) {
                arrayList.add(bundleM10479E);
            }
        }
        return arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public final int m10484I0() {
        if (this.f7823h == null) {
            this.f7823h = Integer.valueOf(C0390Ic.m1692b().m1693a(mo344a()) / 1000);
        }
        return this.f7823h.intValue();
    }

    public final URL m10485J(long j, String str, String str2, long j2, String str3) {
        try {
            AbstractC1085Xi.m4795d(str2);
            AbstractC1085Xi.m4795d(str);
            String strConcat = String.format("https://www.googleadservices.com/pagead/conversion/app/deeplink?id_type=adid&sdk_version=%s&rdid=%s&bundleid=%s&retry=%s", String.format("v%s.%s", Long.valueOf(j), Integer.valueOf(m10484I0())), str2, str, Long.valueOf(j2));
            if (str.equals(mo347e().m10808W())) {
                strConcat = strConcat.concat("&ddl_test=1");
            }
            if (!str3.isEmpty()) {
                if (str3.charAt(0) != '&') {
                    strConcat = strConcat.concat("&");
                }
                strConcat = strConcat.concat(str3);
            }
            return new URL(strConcat);
        } catch (IllegalArgumentException e) {
            e = e;
            mo349g().m9618G().m10617b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        } catch (MalformedURLException e2) {
            e = e2;
            mo349g().m9618G().m10617b("Failed to create BOW URL for Deferred Deep Link. exception", e.getMessage());
            return null;
        }
    }

    public final C0635Nr m10486K(String str, String str2, Bundle bundle, String str3, long j, boolean z, boolean z2) {
        if (TextUtils.isEmpty(str2)) {
            return null;
        }
        if (m10521v(str2) != 0) {
            mo349g().m9618G().m10617b("Invalid conditional property event name", mo350h().m9213g(str2));
            throw new IllegalArgumentException();
        }
        Bundle bundle2 = bundle != null ? new Bundle(bundle) : new Bundle();
        bundle2.putString("_o", str3);
        Bundle bundleM10481F = m10481F(str, str2, bundle2, AbstractC1669e5.m7387a("_o"), true);
        if (z) {
            bundleM10481F = m10479E(bundleM10481F, str);
        }
        AbstractC1085Xi.m4801j(bundleM10481F);
        return new C0635Nr(str2, new C0175Dr(bundleM10481F), str3, j);
    }

    public final long m10487K0() {
        mo356n();
        if (!m10447D0(this.f8058a.m9220B().m7770F())) {
            return 0L;
        }
        long j = Build.VERSION.SDK_INT < 30 ? 4L : SdkExtensions.getExtensionVersion(30) < 4 ? 8L : m10475y0() < ((Integer) AbstractC0818Rr.f2477Y.m4296a(null)).intValue() ? 16L : 0L;
        if (!m10482F0("android.permission.ACCESS_ADSERVICES_ATTRIBUTION")) {
            j |= 2;
        }
        if (j == 0 && !m10461Z0()) {
            j |= 64;
        }
        if (j == 0) {
            return 1L;
        }
        return j;
    }

    public final void m10488M(Bundle bundle, long j) {
        long j2 = bundle.getLong("_et");
        if (j2 != 0) {
            mo349g().m9623L().m10617b("Params already contained engagement", Long.valueOf(j2));
        }
        bundle.putLong("_et", j + j2);
    }

    public final boolean m10489M0(String str) {
        List<ResolveInfo> listQueryIntentActivities;
        return (TextUtils.isEmpty(str) || (listQueryIntentActivities = mo344a().getPackageManager().queryIntentActivities(new Intent("android.intent.action.VIEW", Uri.parse(str)), 0)) == null || listQueryIntentActivities.isEmpty()) ? false : true;
    }

    public final void m10490N(Bundle bundle, Bundle bundle2) {
        if (bundle2 == null) {
            return;
        }
        for (String str : bundle2.keySet()) {
            if (!bundle.containsKey(str)) {
                mo352j().m10491O(bundle, str, bundle2.get(str));
            }
        }
    }

    public final void m10491O(Bundle bundle, String str, Object obj) {
        if (bundle == null) {
            return;
        }
        if (obj instanceof Long) {
            bundle.putLong(str, ((Long) obj).longValue());
            return;
        }
        if (obj instanceof String) {
            bundle.putString(str, String.valueOf(obj));
            return;
        }
        if (obj instanceof Double) {
            bundle.putDouble(str, ((Double) obj).doubleValue());
        } else if (obj instanceof Bundle[]) {
            bundle.putParcelableArray(str, (Bundle[]) obj);
        } else if (str != null) {
            mo349g().m9624M().m10618c("Not putting event parameter. Invalid value type. name, type", mo350h().m9212f(str), obj != null ? obj.getClass().getSimpleName() : null);
        }
    }

    public final int m10492O0(String str) {
        if (!m10523w0("event param", str)) {
            return 3;
        }
        if (m10515o0("event param", null, str)) {
            return !m10512j0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final void m10493P(String str, String str2, String str3, Bundle bundle, List list, boolean z) {
        int iM10494P0;
        String str4;
        int iM10524x;
        C2540wx c2540wxM9619H;
        String strM9209b;
        String strM9208a;
        String str5;
        if (bundle == null) {
            return;
        }
        int iM10791A = mo347e().m10791A();
        int i = 0;
        for (String str6 : new TreeSet(bundle.keySet())) {
            if (list == null || !list.contains(str6)) {
                iM10494P0 = !z ? m10494P0(str6) : 0;
                if (iM10494P0 == 0) {
                    iM10494P0 = m10492O0(str6);
                }
            } else {
                iM10494P0 = 0;
            }
            if (iM10494P0 != 0) {
                m10453L(bundle, iM10494P0, str6, iM10494P0 == 3 ? str6 : null);
                bundle.remove(str6);
            } else {
                if (m10467h0(bundle.get(str6))) {
                    mo349g().m9624M().m10619d("Nested Bundle parameters are not allowed; discarded. event name, param name, child param name", str2, str3, str6);
                    iM10524x = 22;
                    str4 = str6;
                } else {
                    str4 = str6;
                    iM10524x = m10524x(str, str2, str6, bundle.get(str6), bundle, list, z, false);
                }
                if (iM10524x != 0 && !"_ev".equals(str4)) {
                    m10453L(bundle, iM10524x, str4, bundle.get(str4));
                    bundle.remove(str4);
                } else if (m10454L0(str4) && !m10469n0(str4, AbstractC0609NA.f1915d)) {
                    int i2 = i + 1;
                    if (m10510c0(231100000, true)) {
                        if (i2 > iM10791A) {
                            if (C0891TH.m4129a() && mo347e().m10818t(AbstractC0818Rr.f2440F0)) {
                                mo349g().m9619H().m10618c("Item can't contain more than " + iM10791A + " item-scoped custom params", mo350h().m9209b(str2), mo350h().m9208a(bundle));
                                m10472v0(bundle, 28);
                                bundle.remove(str4);
                            } else {
                                c2540wxM9619H = mo349g().m9619H();
                                strM9209b = mo350h().m9209b(str2);
                                strM9208a = mo350h().m9208a(bundle);
                                str5 = "Item cannot contain custom parameters";
                            }
                        }
                        i = i2;
                    } else {
                        c2540wxM9619H = mo349g().m9619H();
                        strM9209b = mo350h().m9209b(str2);
                        strM9208a = mo350h().m9208a(bundle);
                        str5 = "Item array not supported on client's version of Google Play Services (Android Only)";
                    }
                    c2540wxM9619H.m10618c(str5, strM9209b, strM9208a);
                    m10472v0(bundle, 23);
                    bundle.remove(str4);
                    i = i2;
                }
            }
        }
    }

    public final int m10494P0(String str) {
        if (!m10478C0("event param", str)) {
            return 3;
        }
        if (m10515o0("event param", null, str)) {
            return !m10512j0("event param", 40, str) ? 3 : 0;
        }
        return 14;
    }

    public final void m10495Q(InterfaceC2076mu interfaceC2076mu, int i) {
        Bundle bundle = new Bundle();
        bundle.putInt("r", i);
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning int value to wrapper", e);
        }
    }

    public final void m10496R(InterfaceC2076mu interfaceC2076mu, long j) {
        Bundle bundle = new Bundle();
        bundle.putLong("r", j);
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning long value to wrapper", e);
        }
    }

    public final long m10497R0() {
        long andIncrement;
        long j;
        if (this.f7819d.get() != 0) {
            synchronized (this.f7819d) {
                this.f7819d.compareAndSet(-1L, 1L);
                andIncrement = this.f7819d.getAndIncrement();
            }
            return andIncrement;
        }
        synchronized (this.f7819d) {
            long jNextLong = new Random(System.nanoTime() ^ mo345b().mo2815a()).nextLong();
            int i = this.f7820e + 1;
            this.f7820e = i;
            j = jNextLong + i;
        }
        return j;
    }

    public final void m10498S(InterfaceC2076mu interfaceC2076mu, Bundle bundle) {
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning bundle value to wrapper", e);
        }
    }

    public final AbstractC0578Mg m10499S0() {
        if (this.f7821f == null) {
            this.f7821f = AbstractC0578Mg.m2867a(mo344a());
        }
        return this.f7821f;
    }

    public final void m10500T(InterfaceC2076mu interfaceC2076mu, String str) {
        Bundle bundle = new Bundle();
        bundle.putString("r", str);
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning string value to wrapper", e);
        }
    }

    public final void m10501U(InterfaceC2076mu interfaceC2076mu, ArrayList arrayList) {
        Bundle bundle = new Bundle();
        bundle.putParcelableArrayList("r", arrayList);
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning bundle list to wrapper", e);
        }
    }

    public final String m10502U0() {
        byte[] bArr = new byte[16];
        m10505W0().nextBytes(bArr);
        return String.format(Locale.US, "%032x", new BigInteger(1, bArr));
    }

    public final void m10503V(InterfaceC2076mu interfaceC2076mu, boolean z) {
        Bundle bundle = new Bundle();
        bundle.putBoolean("r", z);
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning boolean value to wrapper", e);
        }
    }

    public final void m10504W(InterfaceC2076mu interfaceC2076mu, byte[] bArr) {
        Bundle bundle = new Bundle();
        bundle.putByteArray("r", bArr);
        try {
            interfaceC2076mu.mo7764f(bundle);
        } catch (RemoteException e) {
            this.f8058a.mo349g().m9623L().m10617b("Error returning byte array to wrapper", e);
        }
    }

    public final SecureRandom m10505W0() {
        mo356n();
        if (this.f7818c == null) {
            this.f7818c = new SecureRandom();
        }
        return this.f7818c;
    }

    public final void m10506X(C0043Ax c0043Ax, int i) {
        int i2 = 0;
        for (String str : new TreeSet(c0043Ax.f98d.keySet())) {
            if (m10454L0(str) && (i2 = i2 + 1) > i) {
                mo349g().m9619H().m10618c("Event can't contain more than " + i + " params", mo350h().m9209b(c0043Ax.f95a), mo350h().m9208a(c0043Ax.f98d));
                m10472v0(c0043Ax.f98d, 5);
                c0043Ax.f98d.remove(str);
            }
        }
    }

    public final boolean m10507X0() {
        mo356n();
        return m10487K0() == 1;
    }

    public final boolean m10508Y0() throws ClassNotFoundException {
        try {
            mo344a().getClassLoader().loadClass("com.google.firebase.remoteconfig.FirebaseRemoteConfig");
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    public final void m10509b0(Parcelable[] parcelableArr, int i, boolean z) {
        int i2;
        AbstractC1085Xi.m4801j(parcelableArr);
        for (Parcelable parcelable : parcelableArr) {
            Bundle bundle = (Bundle) parcelable;
            int i3 = 0;
            for (String str : new TreeSet(bundle.keySet())) {
                if (m10454L0(str) && !m10469n0(str, AbstractC0609NA.f1915d) && (i3 = i3 + 1) > i) {
                    C2540wx c2540wxM9619H = mo349g().m9619H();
                    if (z) {
                        c2540wxM9619H.m10618c("Param can't contain more than " + i + " item-scoped custom parameters", mo350h().m9212f(str), mo350h().m9208a(bundle));
                        i2 = 28;
                    } else {
                        c2540wxM9619H.m10618c("Param cannot contain item-scoped custom parameters", mo350h().m9212f(str), mo350h().m9208a(bundle));
                        i2 = 23;
                    }
                    m10472v0(bundle, i2);
                    bundle.remove(str);
                }
            }
        }
    }

    public final boolean m10510c0(int i, boolean z) {
        Boolean boolM8871W = this.f8058a.m9228J().m8871W();
        if (m10484I0() < i / 1000) {
            return (boolM8871W == null || boolM8871W.booleanValue()) ? false : true;
        }
        return true;
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    public final boolean m10511i0(String str, double d) {
        try {
            SharedPreferences.Editor editorEdit = mo344a().getSharedPreferences("google.analytics.deferred.deeplink.prefs", 0).edit();
            editorEdit.putString("deeplink", str);
            editorEdit.putLong("timestamp", Double.doubleToRawLongBits(d));
            return editorEdit.commit();
        } catch (RuntimeException e) {
            mo349g().m9618G().m10617b("Failed to persist Deferred Deep Link. exception", e);
            return false;
        }
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    public final boolean m10512j0(String str, int i, String str2) {
        if (str2 == null) {
            mo349g().m9619H().m10617b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.codePointCount(0, str2.length()) <= i) {
            return true;
        }
        mo349g().m9619H().m10619d("Name is too long. Type, maximum supported length, name", str, Integer.valueOf(i), str2);
        return false;
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    public final boolean m10513k0(String str, String str2) {
        if (!TextUtils.isEmpty(str)) {
            if (m10457T0(str)) {
                return true;
            }
            if (this.f8058a.m9244r()) {
                mo349g().m9619H().m10617b("Invalid google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI. provided id", C2356sx.m9613v(str));
            }
            return false;
        }
        if (TextUtils.isEmpty(str2)) {
            if (this.f8058a.m9244r()) {
                mo349g().m9619H().m10616a("Missing google_app_id. Firebase Analytics disabled. See https://goo.gl/NAOOOI");
            }
            return false;
        }
        if (m10457T0(str2)) {
            return true;
        }
        mo349g().m9619H().m10617b("Invalid admob_app_id. Analytics disabled.", C2356sx.m9613v(str2));
        return false;
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    public final boolean m10514l0(String str, String str2, int i, Object obj) {
        if (obj != null && !(obj instanceof Long) && !(obj instanceof Float) && !(obj instanceof Integer) && !(obj instanceof Byte) && !(obj instanceof Short) && !(obj instanceof Boolean) && !(obj instanceof Double)) {
            if (!(obj instanceof String) && !(obj instanceof Character) && !(obj instanceof CharSequence)) {
                return false;
            }
            String strValueOf = String.valueOf(obj);
            if (strValueOf.codePointCount(0, strValueOf.length()) > i) {
                mo349g().m9624M().m10619d("Value is too long; discarded. Value kind, name, value length", str, str2, Integer.valueOf(strValueOf.length()));
                return false;
            }
        }
        return true;
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final void mo7675o() {
        mo356n();
        SecureRandom secureRandom = new SecureRandom();
        long jNextLong = secureRandom.nextLong();
        if (jNextLong == 0) {
            jNextLong = secureRandom.nextLong();
            if (jNextLong == 0) {
                mo349g().m9623L().m10616a("Utils falling back to Random for random id");
            }
        }
        this.f7819d.set(jNextLong);
    }

    public final boolean m10515o0(String str, String[] strArr, String str2) {
        return m10516p0(str, strArr, null, str2);
    }

    public final boolean m10516p0(String str, String[] strArr, String[] strArr2, String str2) {
        if (str2 == null) {
            mo349g().m9619H().m10617b("Name is required and can't be null. Type", str);
            return false;
        }
        AbstractC1085Xi.m4801j(str2);
        for (String str3 : f7816i) {
            if (str2.startsWith(str3)) {
                mo349g().m9619H().m10618c("Name starts with reserved prefix. Type, name", str, str2);
                return false;
            }
        }
        if (strArr == null || !m10469n0(str2, strArr)) {
            return true;
        }
        if (strArr2 != null && m10469n0(str2, strArr2)) {
            return true;
        }
        mo349g().m9619H().m10618c("Name is reserved. Type, name", str, str2);
        return false;
    }

    public final int m10517r0(String str) {
        if (!m10523w0("user property", str)) {
            return 6;
        }
        if (m10515o0("user property", AbstractC0884TA.f2726a, str)) {
            return !m10512j0("user property", 24, str) ? 6 : 0;
        }
        return 15;
    }

    public final Object m10518s0(String str, Object obj) {
        if ("_ev".equals(str)) {
            return m10483H(mo347e().m10824z(null, false), obj, true, true, null);
        }
        return m10483H(m10452J0(str) ? mo347e().m10824z(null, false) : mo347e().m10816r(null, false), obj, false, true, null);
    }

    @Override
    public final boolean mo357t() {
        return true;
    }

    public final int m10519u(int i) {
        return C0390Ic.m1692b().m1694c(mo344a(), 12451000);
    }

    public final boolean m10520u0(Context context, String str) {
        C2540wx c2540wxM9618G;
        String str2;
        Signature[] signatureArr;
        X500Principal x500Principal = new X500Principal("CN=Android Debug,O=Android,C=US");
        try {
            PackageInfo packageInfoM10890c = C2670zp.m11048a(context).m10890c(str, 64);
            if (packageInfoM10890c == null || (signatureArr = packageInfoM10890c.signatures) == null || signatureArr.length <= 0) {
                return true;
            }
            return ((X509Certificate) CertificateFactory.getInstance("X.509").generateCertificate(new ByteArrayInputStream(signatureArr[0].toByteArray()))).getSubjectX500Principal().equals(x500Principal);
        } catch (PackageManager.NameNotFoundException e) {
            e = e;
            c2540wxM9618G = mo349g().m9618G();
            str2 = "Package name not found";
            c2540wxM9618G.m10617b(str2, e);
            return true;
        } catch (CertificateException e2) {
            e = e2;
            c2540wxM9618G = mo349g().m9618G();
            str2 = "Error obtaining certificate";
            c2540wxM9618G.m10617b(str2, e);
            return true;
        }
    }

    public final int m10521v(String str) {
        if (!m10523w0("event", str)) {
            return 2;
        }
        if (m10516p0("event", AbstractC0701PA.f2092a, AbstractC0701PA.f2093b, str)) {
            return !m10512j0("event", 40, str) ? 2 : 0;
        }
        return 13;
    }

    public final int m10522w(String str, Object obj) {
        return m10514l0("_ldl".equals(str) ? "user property referrer" : "user property", str, m10456Q0(str), obj) ? 0 : 7;
    }

    public final boolean m10523w0(String str, String str2) {
        if (str2 == null) {
            mo349g().m9619H().m10617b("Name is required and can't be null. Type", str);
            return false;
        }
        if (str2.length() == 0) {
            mo349g().m9619H().m10617b("Name is required and can't be empty. Type", str);
            return false;
        }
        int iCodePointAt = str2.codePointAt(0);
        if (!Character.isLetter(iCodePointAt) && iCodePointAt != 95) {
            mo349g().m9619H().m10618c("Name must start with a letter or _ (underscore). Type, name", str, str2);
            return false;
        }
        int length = str2.length();
        int iCharCount = Character.charCount(iCodePointAt);
        while (iCharCount < length) {
            int iCodePointAt2 = str2.codePointAt(iCharCount);
            if (iCodePointAt2 != 95 && !Character.isLetterOrDigit(iCodePointAt2)) {
                mo349g().m9619H().m10618c("Name must consist of letters, digits or _ (underscores). Type, name", str, str2);
                return false;
            }
            iCharCount += Character.charCount(iCodePointAt2);
        }
        return true;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int m10524x(String r14, String r15, String r16, Object r17, Bundle r18, List r19, boolean r20, boolean r21) {
        /*
            Method dump skipped, instructions count: 316
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2514wG.m10524x(java.lang.String, java.lang.String, java.lang.String, java.lang.Object, android.os.Bundle, java.util.List, boolean, boolean):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0073  */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:18:0x0066 -> B:19:0x0073). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long m10525z(Context r7, String r8) throws NoSuchAlgorithmException {
        /*
            r6 = this;
            r6.mo356n()
            p000.AbstractC1085Xi.m4801j(r7)
            p000.AbstractC1085Xi.m4795d(r8)
            android.content.pm.PackageManager r0 = r7.getPackageManager()
            java.security.MessageDigest r1 = m10458V0()
            r2 = -1
            if (r1 != 0) goto L23
            sx r7 = r6.mo349g()
            wx r7 = r7.m9618G()
            java.lang.String r8 = "Could not get MD5 instance"
            r7.m10616a(r8)
            goto L74
        L23:
            r4 = 0
            if (r0 == 0) goto L73
            boolean r8 = r6.m10520u0(r7, r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            if (r8 != 0) goto L73
            yi r7 = p000.C2670zp.m11048a(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            android.content.Context r8 = r6.mo344a()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            java.lang.String r8 = r8.getPackageName()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            r0 = 64
            android.content.pm.PackageInfo r7 = r7.m10890c(r8, r0)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            android.content.pm.Signature[] r7 = r7.signatures     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            if (r7 == 0) goto L58
            int r8 = r7.length     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            if (r8 <= 0) goto L58
            r8 = 0
            r7 = r7[r8]     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            byte[] r7 = r7.toByteArray()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            byte[] r7 = r1.digest(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            long r2 = m10444B(r7)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            goto L74
        L56:
            r7 = move-exception
            goto L66
        L58:
            sx r7 = r6.mo349g()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            wx r7 = r7.m9623L()     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            java.lang.String r8 = "Could not get signatures"
            r7.m10616a(r8)     // Catch: android.content.pm.PackageManager.NameNotFoundException -> L56
            goto L74
        L66:
            sx r8 = r6.mo349g()
            wx r8 = r8.m9618G()
            java.lang.String r0 = "Package name not found"
            r8.m10617b(r0, r7)
        L73:
            r2 = r4
        L74:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C2514wG.m10525z(android.content.Context, java.lang.String):long");
    }

    public final long m10526z0(String str) {
        if (mo344a().getPackageManager() == null) {
            return 0L;
        }
        int i = 0;
        try {
            ApplicationInfo applicationInfoM10889b = C2670zp.m11048a(mo344a()).m10889b(str, 0);
            if (applicationInfoM10889b != null) {
                i = applicationInfoM10889b.targetSdkVersion;
            }
        } catch (PackageManager.NameNotFoundException unused) {
            mo349g().m9621J().m10617b("PackageManager failed to find running app: app_id", str);
        }
        return i;
    }
}
