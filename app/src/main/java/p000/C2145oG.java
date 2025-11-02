package p000;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.nio.charset.Charset;
import java.security.MessageDigest;
import java.util.ArrayList;
import java.util.BitSet;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Set;
import java.util.zip.GZIPInputStream;
import java.util.zip.GZIPOutputStream;
import p000.AbstractC1883il;
import p000.C0365Hx;
import p000.C0425JA;
import p000.C0457Jx;
import p000.C0595Mx;
import p000.C0779Qx;

/* loaded from: classes.dex */
public final class C2145oG extends AbstractC2513wF {
    public C2145oG(C0200EF c0200ef) {
        super(c0200ef);
    }

    public static Bundle m8889B(List list) {
        Bundle bundle = new Bundle();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0457Jx c0457Jx = (C0457Jx) it.next();
            String strM2191W = c0457Jx.m2191W();
            if (c0457Jx.m2194Z()) {
                bundle.putDouble(strM2191W, c0457Jx.m2187G());
            } else if (c0457Jx.m2195a0()) {
                bundle.putFloat(strM2191W, c0457Jx.m2188N());
            } else if (c0457Jx.m2198d0()) {
                bundle.putString(strM2191W, c0457Jx.m2192X());
            } else if (c0457Jx.m2196b0()) {
                bundle.putLong(strM2191W, c0457Jx.m2190S());
            }
        }
        return bundle;
    }

    public static Object m8890E(C0365Hx c0365Hx, String str, Object obj) {
        Object objM8904g0 = m8904g0(c0365Hx, str);
        return objM8904g0 == null ? obj : objM8904g0;
    }

    public static String m8891I(boolean z, boolean z2, boolean z3) {
        StringBuilder sb = new StringBuilder();
        if (z) {
            sb.append("Dynamic ");
        }
        if (z2) {
            sb.append("Sequence ");
        }
        if (z3) {
            sb.append("Session-Scoped ");
        }
        return sb.toString();
    }

    public static List m8892J(BitSet bitSet) {
        int length = (bitSet.length() + 63) / 64;
        ArrayList arrayList = new ArrayList<>(length);
        for (int i = 0; i < length; i++) {
            long j = 0;
            for (int i2 = 0; i2 < 64; i2++) {
                int i3 = (i << 6) + i2;
                if (i3 < bitSet.length()) {
                    if (bitSet.get(i3)) {
                        j |= 1 << i2;
                    }
                }
            }
            arrayList.add(Long.valueOf(j));
        }
        return arrayList;
    }

    public static C0457Jx m8893O(C0365Hx c0365Hx, String str) {
        for (C0457Jx c0457Jx : c0365Hx.m1638V()) {
            if (c0457Jx.m2191W().equals(str)) {
                return c0457Jx;
            }
        }
        return null;
    }

    public static InterfaceC1819hE m8894P(InterfaceC1819hE interfaceC1819hE, byte[] bArr) {
        C1957kC c1957kCM8236a = C1957kC.m8236a();
        return c1957kCM8236a != null ? interfaceC1819hE.mo4200l(bArr, c1957kCM8236a) : interfaceC1819hE.mo4201p(bArr);
    }

    public static void m8895R(Uri.Builder builder, String str, String str2, Set set) {
        if (set.contains(str) || TextUtils.isEmpty(str2)) {
            return;
        }
        builder.appendQueryParameter(str, str2);
    }

    public static void m8896S(Uri.Builder builder, String[] strArr, Bundle bundle, Set set) {
        for (String str : strArr) {
            String[] strArrSplit = str.split(",");
            String str2 = strArrSplit[0];
            String str3 = strArrSplit[strArrSplit.length - 1];
            String string = bundle.getString(str2);
            if (string != null) {
                m8895R(builder, str3, string, set);
            }
        }
    }

    public static void m8897T(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            sb.append("  ");
        }
    }

    public static void m8898U(StringBuilder sb, int i, String str, Object obj) {
        if (obj == null) {
            return;
        }
        m8897T(sb, i + 1);
        sb.append(str);
        sb.append(": ");
        sb.append(obj);
        sb.append('\n');
    }

    public static void m8899V(StringBuilder sb, int i, String str, C2078mw c2078mw) {
        if (c2078mw == null) {
            return;
        }
        m8897T(sb, i);
        sb.append(str);
        sb.append(" {\n");
        if (c2078mw.m8649N()) {
            m8898U(sb, i, "comparison_type", c2078mw.m8644G().name());
        }
        if (c2078mw.m8651P()) {
            m8898U(sb, i, "match_as_float", Boolean.valueOf(c2078mw.m8648M()));
        }
        if (c2078mw.m8650O()) {
            m8898U(sb, i, "comparison_value", c2078mw.m8645J());
        }
        if (c2078mw.m8653R()) {
            m8898U(sb, i, "min_comparison_value", c2078mw.m8647L());
        }
        if (c2078mw.m8652Q()) {
            m8898U(sb, i, "max_comparison_value", c2078mw.m8646K());
        }
        m8897T(sb, i);
        sb.append("}\n");
    }

    public static void m8900W(StringBuilder sb, int i, String str, C0687Ox c0687Ox) {
        if (c0687Ox == null) {
            return;
        }
        m8897T(sb, 3);
        sb.append(str);
        sb.append(" {\n");
        if (c0687Ox.m3457I() != 0) {
            m8897T(sb, 4);
            sb.append("results: ");
            int i2 = 0;
            for (Long l : c0687Ox.m3461V()) {
                int i3 = i2 + 1;
                if (i2 != 0) {
                    sb.append(", ");
                }
                sb.append(l);
                i2 = i3;
            }
            sb.append('\n');
        }
        if (c0687Ox.m3459O() != 0) {
            m8897T(sb, 4);
            sb.append("status: ");
            int i4 = 0;
            for (Long l2 : c0687Ox.m3463X()) {
                int i5 = i4 + 1;
                if (i4 != 0) {
                    sb.append(", ");
                }
                sb.append(l2);
                i4 = i5;
            }
            sb.append('\n');
        }
        if (c0687Ox.m3464j() != 0) {
            m8897T(sb, 4);
            sb.append("dynamic_filter_timestamps: {");
            int i6 = 0;
            for (C0319Gx c0319Gx : c0687Ox.m3460U()) {
                int i7 = i6 + 1;
                if (i6 != 0) {
                    sb.append(", ");
                }
                sb.append(c0319Gx.m1457M() ? Integer.valueOf(c0319Gx.m1458j()) : null);
                sb.append(":");
                sb.append(c0319Gx.m1456L() ? Long.valueOf(c0319Gx.m1455I()) : null);
                i6 = i7;
            }
            sb.append("}\n");
        }
        if (c0687Ox.m3458L() != 0) {
            m8897T(sb, 4);
            sb.append("sequence_filter_timestamps: {");
            int i8 = 0;
            for (C0733Px c0733Px : c0687Ox.m3462W()) {
                int i9 = i8 + 1;
                if (i8 != 0) {
                    sb.append(", ");
                }
                sb.append(c0733Px.m3602N() ? Integer.valueOf(c0733Px.m3600J()) : null);
                sb.append(": [");
                Iterator it = c0733Px.m3601M().iterator();
                int i10 = 0;
                while (it.hasNext()) {
                    long jLongValue = ((Long) it.next()).longValue();
                    int i11 = i10 + 1;
                    if (i10 != 0) {
                        sb.append(", ");
                    }
                    sb.append(jLongValue);
                    i10 = i11;
                }
                sb.append("]");
                i8 = i9;
            }
            sb.append("}\n");
        }
        m8897T(sb, 3);
        sb.append("}\n");
    }

    public static void m8901Z(C0365Hx.a aVar, String str, Object obj) {
        List listM1652I = aVar.m1652I();
        int i = 0;
        while (true) {
            if (i >= listM1652I.size()) {
                i = -1;
                break;
            } else if (str.equals(((C0457Jx) listM1652I.get(i)).m2191W())) {
                break;
            } else {
                i++;
            }
        }
        C0457Jx.a aVarM2210x = C0457Jx.m2185U().m2210x(str);
        if (obj instanceof Long) {
            aVarM2210x.m2208v(((Long) obj).longValue());
        } else if (obj instanceof String) {
            aVarM2210x.m2200A((String) obj);
        } else if (obj instanceof Double) {
            aVarM2210x.m2207u(((Double) obj).doubleValue());
        }
        if (i >= 0) {
            aVar.m1656v(i, aVarM2210x);
        } else {
            aVar.m1644A(aVarM2210x);
        }
    }

    public static boolean m8902e0(List list, int i) {
        if (i < (list.size() << 6)) {
            return ((1 << (i % 64)) & ((Long) list.get(i / 64)).longValue()) != 0;
        }
        return false;
    }

    public static boolean m8903f0(C0635Nr c0635Nr, C0569MG c0569mg) {
        AbstractC1085Xi.m4801j(c0635Nr);
        AbstractC1085Xi.m4801j(c0569mg);
        return (TextUtils.isEmpty(c0569mg.f1788m) && TextUtils.isEmpty(c0569mg.f1771B)) ? false : true;
    }

    public static Object m8904g0(C0365Hx c0365Hx, String str) {
        C0457Jx c0457JxM8893O = m8893O(c0365Hx, str);
        if (c0457JxM8893O == null) {
            return null;
        }
        if (c0457JxM8893O.m2198d0()) {
            return c0457JxM8893O.m2192X();
        }
        if (c0457JxM8893O.m2196b0()) {
            return Long.valueOf(c0457JxM8893O.m2190S());
        }
        if (c0457JxM8893O.m2194Z()) {
            return Double.valueOf(c0457JxM8893O.m2187G());
        }
        if (c0457JxM8893O.m2189Q() > 0) {
            return m8906j0(c0457JxM8893O.m2193Y());
        }
        return null;
    }

    public static boolean m8905h0(String str) {
        return str != null && str.matches("([+-])?([0-9]+\\.?[0-9]*|[0-9]*\\.?[0-9]+)") && str.length() <= 310;
    }

    public static Bundle[] m8906j0(List list) {
        ArrayList arrayList = new ArrayList<>();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0457Jx c0457Jx = (C0457Jx) it.next();
            if (c0457Jx != null) {
                Bundle bundle = new Bundle();
                for (C0457Jx c0457Jx2 : c0457Jx.m2193Y()) {
                    if (c0457Jx2.m2198d0()) {
                        bundle.putString(c0457Jx2.m2191W(), c0457Jx2.m2192X());
                    } else if (c0457Jx2.m2196b0()) {
                        bundle.putLong(c0457Jx2.m2191W(), c0457Jx2.m2190S());
                    } else if (c0457Jx2.m2194Z()) {
                        bundle.putDouble(c0457Jx2.m2191W(), c0457Jx2.m2187G());
                    }
                }
                if (!bundle.isEmpty()) {
                    arrayList.add(bundle);
                }
            }
        }
        return (Bundle[]) arrayList.toArray(new Bundle[arrayList.size()]);
    }

    public static int m8907y(C0595Mx.a aVar, String str) {
        if (aVar == null) {
            return -1;
        }
        for (int i = 0; i < aVar.m3168Z(); i++) {
            if (str.equals(aVar.m3133H0(i).m3731U())) {
                return i;
            }
        }
        return -1;
    }

    public final long m8908A(byte[] bArr) {
        AbstractC1085Xi.m4801j(bArr);
        mo352j().mo356n();
        MessageDigest messageDigestM10458V0 = C2514wG.m10458V0();
        if (messageDigestM10458V0 != null) {
            return C2514wG.m10444B(messageDigestM10458V0.digest(bArr));
        }
        mo349g().m9618G().m10616a("Failed to get MD5");
        return 0L;
    }

    public final Bundle m8909C(Map map, boolean z) {
        String string;
        Bundle bundle = new Bundle();
        for (String str : map.keySet()) {
            Object obj = map.get(str);
            if (obj == null) {
                string = null;
            } else if (obj instanceof Long) {
                bundle.putLong(str, ((Long) obj).longValue());
            } else if (obj instanceof Double) {
                bundle.putDouble(str, ((Double) obj).doubleValue());
            } else if (!(obj instanceof ArrayList)) {
                string = obj.toString();
            } else if (z) {
                ArrayList arrayList = (ArrayList) obj;
                ArrayList arrayList2 = new ArrayList<>();
                int size = arrayList.size();
                int i = 0;
                while (i < size) {
                    Object obj2 = arrayList.get(i);
                    i++;
                    arrayList2.add(m8909C((Map) obj2, false));
                }
                bundle.putParcelableArray(str, (Parcelable[]) arrayList2.toArray(new Parcelable[0]));
            }
            bundle.putString(str, string);
        }
        return bundle;
    }

    public final Parcelable m8910D(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.unmarshall(bArr, 0, bArr.length);
            parcelObtain.setDataPosition(0);
            return (Parcelable) creator.createFromParcel(parcelObtain);
        } catch (AbstractC1883il.a unused) {
            mo349g().m9618G().m10616a("Failed to load parcelable from buffer");
            return null;
        } finally {
            parcelObtain.recycle();
        }
    }

    public final String m8911F(C1986kw c1986kw) {
        if (c1986kw == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nevent_filter {\n");
        if (c1986kw.m8332T()) {
            m8898U(sb, 0, "filter_id", Integer.valueOf(c1986kw.m8324J()));
        }
        m8898U(sb, 0, "event_name", mo350h().m9209b(c1986kw.m8326N()));
        String strM8891I = m8891I(c1986kw.m8328P(), c1986kw.m8329Q(), c1986kw.m8330R());
        if (!strM8891I.isEmpty()) {
            m8898U(sb, 0, "filter_type", strM8891I);
        }
        if (c1986kw.m8331S()) {
            m8899V(sb, 1, "event_count_filter", c1986kw.m8325M());
        }
        if (c1986kw.m8334j() > 0) {
            sb.append("  filters {\n");
            Iterator it = c1986kw.m8327O().iterator();
            while (it.hasNext()) {
                m8920Y(sb, 2, (C2032lw) it.next());
            }
        }
        m8897T(sb, 1);
        sb.append("}\n}\n");
        return sb.toString();
    }

    public final String m8912G(C2124nw c2124nw) {
        if (c2124nw == null) {
            return "null";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nproperty_filter {\n");
        if (c2124nw.m8806O()) {
            m8898U(sb, 0, "filter_id", Integer.valueOf(c2124nw.m8808j()));
        }
        m8898U(sb, 0, "property_name", mo350h().m9213g(c2124nw.m8802K()));
        String strM8891I = m8891I(c2124nw.m8803L(), c2124nw.m8804M(), c2124nw.m8805N());
        if (!strM8891I.isEmpty()) {
            m8898U(sb, 0, "filter_type", strM8891I);
        }
        m8920Y(sb, 1, c2124nw.m8801H());
        sb.append("}\n");
        return sb.toString();
    }

    public final String m8913H(C0549Lx c0549Lx) {
        C0227Ex c0227ExM3112t2;
        if (c0549Lx == null) {
            return "";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("\nbatch {\n");
        if (C2470vI.m10339a() && mo347e().m10818t(AbstractC0818Rr.f2543x0) && c0549Lx.m2783j() > 0) {
            mo352j();
            if (C2514wG.m10450H0(c0549Lx.m2776H(0).m3117x2())) {
                if (c0549Lx.m2781T()) {
                    m8898U(sb, 0, "upload_subdomain", c0549Lx.m2778Q());
                }
                if (c0549Lx.m2780S()) {
                    m8898U(sb, 0, "sgtm_join_id", c0549Lx.m2777P());
                }
            }
        }
        for (C0595Mx c0595Mx : c0549Lx.m2779R()) {
            if (c0595Mx != null) {
                m8897T(sb, 1);
                sb.append("bundle {\n");
                if (c0595Mx.m3060R0()) {
                    m8898U(sb, 1, "protocol_version", Integer.valueOf(c0595Mx.m3115w1()));
                }
                if (C2194pI.m9056a() && mo347e().m10798H(c0595Mx.m3117x2(), AbstractC0818Rr.f2541w0) && c0595Mx.m3064U0()) {
                    m8898U(sb, 1, "session_stitching_token", c0595Mx.m3090i0());
                }
                m8898U(sb, 1, "platform", c0595Mx.m3086g0());
                if (c0595Mx.m3054M0()) {
                    m8898U(sb, 1, "gmp_version", Long.valueOf(c0595Mx.m3085f2()));
                }
                if (c0595Mx.m3076Z0()) {
                    m8898U(sb, 1, "uploading_gmp_version", Long.valueOf(c0595Mx.m3108r2()));
                }
                if (c0595Mx.m3051K0()) {
                    m8898U(sb, 1, "dynamite_version", Long.valueOf(c0595Mx.m3074Y1()));
                }
                if (c0595Mx.m3042D0()) {
                    m8898U(sb, 1, "config_version", Long.valueOf(c0595Mx.m3059Q1()));
                }
                m8898U(sb, 1, "gmp_app_id", c0595Mx.m3082d0());
                m8898U(sb, 1, "admob_app_id", c0595Mx.m3116w2());
                m8898U(sb, 1, "app_id", c0595Mx.m3117x2());
                m8898U(sb, 1, "app_version", c0595Mx.m3068W());
                if (c0595Mx.m3109s0()) {
                    m8898U(sb, 1, "app_version_major", Integer.valueOf(c0595Mx.m3113u0()));
                }
                m8898U(sb, 1, "firebase_instance_id", c0595Mx.m3080c0());
                if (c0595Mx.m3049I0()) {
                    m8898U(sb, 1, "dev_cert_hash", Long.valueOf(c0595Mx.m3065U1()));
                }
                m8898U(sb, 1, "app_store", c0595Mx.m3066V());
                if (c0595Mx.m3073Y0()) {
                    m8898U(sb, 1, "upload_timestamp_millis", Long.valueOf(c0595Mx.m3104p2()));
                }
                if (c0595Mx.m3067V0()) {
                    m8898U(sb, 1, "start_timestamp_millis", Long.valueOf(c0595Mx.m3098l2()));
                }
                if (c0595Mx.m3052L0()) {
                    m8898U(sb, 1, "end_timestamp_millis", Long.valueOf(c0595Mx.m3081c2()));
                }
                if (c0595Mx.m3058Q0()) {
                    m8898U(sb, 1, "previous_bundle_start_timestamp_millis", Long.valueOf(c0595Mx.m3095j2()));
                }
                if (c0595Mx.m3057P0()) {
                    m8898U(sb, 1, "previous_bundle_end_timestamp_millis", Long.valueOf(c0595Mx.m3089h2()));
                }
                m8898U(sb, 1, "app_instance_id", c0595Mx.m3063U());
                m8898U(sb, 1, "resettable_device_id", c0595Mx.m3087h0());
                m8898U(sb, 1, "ds_id", c0595Mx.m3079b0());
                if (c0595Mx.m3056O0()) {
                    m8898U(sb, 1, "limited_ad_tracking", Boolean.valueOf(c0595Mx.m3103p0()));
                }
                m8898U(sb, 1, "os_version", c0595Mx.m3084f0());
                m8898U(sb, 1, "device_model", c0595Mx.m3077a0());
                m8898U(sb, 1, "user_default_language", c0595Mx.m3093j0());
                if (c0595Mx.m3071X0()) {
                    m8898U(sb, 1, "time_zone_offset_minutes", Integer.valueOf(c0595Mx.m3047G1()));
                }
                if (c0595Mx.m3041C0()) {
                    m8898U(sb, 1, "bundle_sequential_index", Integer.valueOf(c0595Mx.m3078a1()));
                }
                if (C2470vI.m10339a()) {
                    mo352j();
                    if (C2514wG.m10450H0(c0595Mx.m3117x2()) && mo347e().m10818t(AbstractC0818Rr.f2543x0) && c0595Mx.m3048H0()) {
                        m8898U(sb, 1, "delivery_index", Integer.valueOf(c0595Mx.m3094j1()));
                    }
                }
                if (c0595Mx.m3062T0()) {
                    m8898U(sb, 1, "service_upload", Boolean.valueOf(c0595Mx.m3105q0()));
                }
                m8898U(sb, 1, "health_monitor", c0595Mx.m3083e0());
                if (c0595Mx.m3061S0()) {
                    m8898U(sb, 1, "retry_counter", Integer.valueOf(c0595Mx.m3040B1()));
                }
                if (c0595Mx.m3044F0()) {
                    m8898U(sb, 1, "consent_signals", c0595Mx.m3072Y());
                }
                if (c0595Mx.m3055N0()) {
                    m8898U(sb, 1, "is_dma_region", Boolean.valueOf(c0595Mx.m3102o0()));
                }
                if (c0595Mx.m3046G0()) {
                    m8898U(sb, 1, "core_platform_services", c0595Mx.m3075Z());
                }
                if (c0595Mx.m3043E0()) {
                    m8898U(sb, 1, "consent_diagnostics", c0595Mx.m3070X());
                }
                if (c0595Mx.m3069W0()) {
                    m8898U(sb, 1, "target_os_version", Long.valueOf(c0595Mx.m3101n2()));
                }
                if (C1963kI.m8253a() && mo347e().m10798H(c0595Mx.m3117x2(), AbstractC0818Rr.f2444H0)) {
                    m8898U(sb, 1, "ad_services_version", Integer.valueOf(c0595Mx.m3092j()));
                    if (c0595Mx.m3111t0() && (c0227ExM3112t2 = c0595Mx.m3112t2()) != null) {
                        m8897T(sb, 2);
                        sb.append("attribution_eligibility_status {\n");
                        m8898U(sb, 2, "eligible", Boolean.valueOf(c0227ExM3112t2.m1145R()));
                        m8898U(sb, 2, "no_access_adservices_attribution_permission", Boolean.valueOf(c0227ExM3112t2.m1147U()));
                        m8898U(sb, 2, "pre_r", Boolean.valueOf(c0227ExM3112t2.m1148V()));
                        m8898U(sb, 2, "r_extensions_too_old", Boolean.valueOf(c0227ExM3112t2.m1149W()));
                        m8898U(sb, 2, "adservices_extension_too_old", Boolean.valueOf(c0227ExM3112t2.m1144P()));
                        m8898U(sb, 2, "ad_storage_not_allowed", Boolean.valueOf(c0227ExM3112t2.m1143N()));
                        m8898U(sb, 2, "measurement_manager_disabled", Boolean.valueOf(c0227ExM3112t2.m1146T()));
                        m8897T(sb, 2);
                        sb.append("}\n");
                    }
                }
                if (C0340HH.m1558a() && mo347e().m10818t(AbstractC0818Rr.f2470U0) && c0595Mx.m3107r0()) {
                    C0135Cx c0135CxM3110s2 = c0595Mx.m3110s2();
                    m8897T(sb, 2);
                    sb.append("ad_campaign_info {\n");
                    if (c0135CxM3110s2.m562h0()) {
                        m8898U(sb, 2, "deep_link_gclid", c0135CxM3110s2.m556b0());
                    }
                    if (c0135CxM3110s2.m561g0()) {
                        m8898U(sb, 2, "deep_link_gbraid", c0135CxM3110s2.m555a0());
                    }
                    if (c0135CxM3110s2.m560f0()) {
                        m8898U(sb, 2, "deep_link_gad_source", c0135CxM3110s2.m554X());
                    }
                    if (c0135CxM3110s2.m563i0()) {
                        m8898U(sb, 2, "deep_link_session_millis", Long.valueOf(c0135CxM3110s2.m552G()));
                    }
                    if (c0135CxM3110s2.m568m0()) {
                        m8898U(sb, 2, "market_referrer_gclid", c0135CxM3110s2.m559e0());
                    }
                    if (c0135CxM3110s2.m566l0()) {
                        m8898U(sb, 2, "market_referrer_gbraid", c0135CxM3110s2.m558d0());
                    }
                    if (c0135CxM3110s2.m565k0()) {
                        m8898U(sb, 2, "market_referrer_gad_source", c0135CxM3110s2.m557c0());
                    }
                    if (c0135CxM3110s2.m564j0()) {
                        m8898U(sb, 2, "market_referrer_click_millis", Long.valueOf(c0135CxM3110s2.m553K()));
                    }
                    m8897T(sb, 2);
                    sb.append("}\n");
                }
                List<C0779Qx> listM3099m0 = c0595Mx.m3099m0();
                if (listM3099m0 != null) {
                    for (C0779Qx c0779Qx : listM3099m0) {
                        if (c0779Qx != null) {
                            m8897T(sb, 2);
                            sb.append("user_property {\n");
                            m8898U(sb, 2, "set_timestamp_millis", c0779Qx.m3736Z() ? Long.valueOf(c0779Qx.m3730R()) : null);
                            m8898U(sb, 2, "name", mo350h().m9213g(c0779Qx.m3731U()));
                            m8898U(sb, 2, "string_value", c0779Qx.m3732V());
                            m8898U(sb, 2, "int_value", c0779Qx.m3735Y() ? Long.valueOf(c0779Qx.m3729P()) : null);
                            m8898U(sb, 2, "double_value", c0779Qx.m3733W() ? Double.valueOf(c0779Qx.m3727G()) : null);
                            m8897T(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C0273Fx> listM3096k0 = c0595Mx.m3096k0();
                c0595Mx.m3117x2();
                if (listM3096k0 != null) {
                    for (C0273Fx c0273Fx : listM3096k0) {
                        if (c0273Fx != null) {
                            m8897T(sb, 2);
                            sb.append("audience_membership {\n");
                            if (c0273Fx.m1303P()) {
                                m8898U(sb, 2, "audience_id", Integer.valueOf(c0273Fx.m1306j()));
                            }
                            if (c0273Fx.m1304Q()) {
                                m8898U(sb, 2, "new_audience", Boolean.valueOf(c0273Fx.m1302O()));
                            }
                            m8900W(sb, 2, "current_data", c0273Fx.m1300M());
                            if (c0273Fx.m1305R()) {
                                m8900W(sb, 2, "previous_data", c0273Fx.m1301N());
                            }
                            m8897T(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                List<C0365Hx> listM3097l0 = c0595Mx.m3097l0();
                if (listM3097l0 != null) {
                    for (C0365Hx c0365Hx : listM3097l0) {
                        if (c0365Hx != null) {
                            m8897T(sb, 2);
                            sb.append("event {\n");
                            m8898U(sb, 2, "name", mo350h().m9209b(c0365Hx.m1637U()));
                            if (c0365Hx.m1641Y()) {
                                m8898U(sb, 2, "timestamp_millis", Long.valueOf(c0365Hx.m1636R()));
                            }
                            if (c0365Hx.m1640X()) {
                                m8898U(sb, 2, "previous_timestamp_millis", Long.valueOf(c0365Hx.m1635Q()));
                            }
                            if (c0365Hx.m1639W()) {
                                m8898U(sb, 2, "count", Integer.valueOf(c0365Hx.m1643j()));
                            }
                            if (c0365Hx.m1634O() != 0) {
                                m8919X(sb, 2, c0365Hx.m1638V());
                            }
                            m8897T(sb, 2);
                            sb.append("}\n");
                        }
                    }
                }
                m8897T(sb, 1);
                sb.append("}\n");
            }
        }
        sb.append("} // End-of-batch\n");
        return sb.toString();
    }

    public final List m8914K(List list, List list2) {
        int i;
        ArrayList arrayList = new ArrayList<>(list);
        Iterator it = list2.iterator();
        while (it.hasNext()) {
            Integer num = (Integer) it.next();
            if (num.intValue() < 0) {
                mo349g().m9623L().m10617b("Ignoring negative bit index to be cleared", num);
            } else {
                int iIntValue = num.intValue() / 64;
                if (iIntValue >= arrayList.size()) {
                    mo349g().m9623L().m10618c("Ignoring bit index greater than bitSet size", num, Integer.valueOf(arrayList.size()));
                } else {
                    arrayList.set(iIntValue, Long.valueOf(((Long) arrayList.get(iIntValue)).longValue() & (~(1 << (num.intValue() % 64)))));
                }
            }
        }
        int size = arrayList.size();
        int size2 = arrayList.size() - 1;
        while (true) {
            int i2 = size2;
            i = size;
            size = i2;
            if (size < 0 || ((Long) arrayList.get(size)).longValue() != 0) {
                break;
            }
            size2 = size - 1;
        }
        return arrayList.subList(0, i);
    }

    public final Map m8915L(Bundle bundle, boolean z) {
        HashMap map = new HashMap<>();
        for (String str : bundle.keySet()) {
            Object obj = bundle.get(str);
            boolean z2 = obj instanceof Parcelable[];
            if (z2 || (obj instanceof ArrayList) || (obj instanceof Bundle)) {
                if (z) {
                    ArrayList arrayList = new ArrayList<>();
                    if (z2) {
                        for (Parcelable parcelable : (Parcelable[]) obj) {
                            if (parcelable instanceof Bundle) {
                                arrayList.add(m8915L((Bundle) parcelable, false));
                            }
                        }
                    } else if (obj instanceof ArrayList) {
                        ArrayList arrayList2 = (ArrayList) obj;
                        int size = arrayList2.size();
                        int i = 0;
                        while (i < size) {
                            Object obj2 = arrayList2.get(i);
                            i++;
                            if (obj2 instanceof Bundle) {
                                arrayList.add(m8915L((Bundle) obj2, false));
                            }
                        }
                    } else if (obj instanceof Bundle) {
                        arrayList.add(m8915L((Bundle) obj, false));
                    }
                    map.put(str, arrayList);
                }
            } else if (obj != null) {
                map.put(str, obj);
            }
        }
        return map;
    }

    public final C0635Nr m8916M(C1888iq c1888iq) {
        Object obj;
        Bundle bundleM8909C = m8909C(c1888iq.m8008g(), true);
        String string = (!bundleM8909C.containsKey("_o") || (obj = bundleM8909C.get("_o")) == null) ? "app" : obj.toString();
        String strM3492b = AbstractC0701PA.m3492b(c1888iq.m8006e());
        if (strM3492b == null) {
            strM3492b = c1888iq.m8006e();
        }
        return new C0635Nr(strM3492b, new C0175Dr(bundleM8909C), string, c1888iq.m8003a());
    }

    public final C0365Hx m8917N(C2672zr c2672zr) {
        C0365Hx.a aVarM1658x = C0365Hx.m1631S().m1658x(c2672zr.f8285e);
        Iterator it = c2672zr.f8286f.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            C0457Jx.a aVarM2210x = C0457Jx.m2185U().m2210x(str);
            Object objM787k = c2672zr.f8286f.m787k(str);
            AbstractC1085Xi.m4801j(objM787k);
            m8921a0(aVarM2210x, objM787k);
            aVarM1658x.m1644A(aVarM2210x);
        }
        if (mo347e().m10818t(AbstractC0818Rr.f2522n1) && !TextUtils.isEmpty(c2672zr.f8283c) && c2672zr.f8286f.m787k("_o") == null) {
            aVarM1658x.m1645B((C0457Jx) ((AbstractC0703PC) C0457Jx.m2185U().m2210x("_o").m2200A(c2672zr.f8283c).m3526o()));
        }
        return (C0365Hx) ((AbstractC0703PC) aVarM1658x.m3526o());
    }

    public final C1913jF m8918Q(String str, C0595Mx.a aVar, C0365Hx.a aVar2, String str2) throws Throwable {
        String strValueOf;
        String strValueOf2;
        int iIndexOf;
        if (!C1963kI.m8253a() || !mo347e().m10798H(str, AbstractC0818Rr.f2444H0)) {
            return null;
        }
        long jMo2815a = mo345b().mo2815a();
        String[] strArrSplit = mo347e().m10796F(str, AbstractC0818Rr.f2503h0).split(",");
        HashSet hashSet = new HashSet(strArrSplit.length);
        for (String str3 : strArrSplit) {
            Objects.requireNonNull(str3);
            if (!hashSet.add(str3)) {
                throw new IllegalArgumentException("duplicate element: " + ((Object) str3));
            }
        }
        Set setUnmodifiableSet = Collections.unmodifiableSet(hashSet);
        C2467vF c2467vFMo3249t = mo3249t();
        String strM3227R = c2467vFMo3249t.mo3247r().m3227R(str);
        Uri.Builder builder = new Uri.Builder();
        builder.scheme(c2467vFMo3249t.mo347e().m10796F(str, AbstractC0818Rr.f2482a0));
        builder.authority(TextUtils.isEmpty(strM3227R) ? c2467vFMo3249t.mo347e().m10796F(str, AbstractC0818Rr.f2485b0) : strM3227R + "." + c2467vFMo3249t.mo347e().m10796F(str, AbstractC0818Rr.f2485b0));
        builder.path(c2467vFMo3249t.mo347e().m10796F(str, AbstractC0818Rr.f2488c0));
        m8895R(builder, "gmp_app_id", aVar.m3177d1(), setUnmodifiableSet);
        m8895R(builder, "gmp_version", "102001", setUnmodifiableSet);
        String strM3171a1 = aVar.m3171a1();
        C2579xq c2579xqMo347e = mo347e();
        C0961Uw c0961Uw = AbstractC0818Rr.f2450K0;
        if (c2579xqMo347e.m10798H(str, c0961Uw) && mo3247r().m3237b0(str)) {
            strM3171a1 = "";
        }
        m8895R(builder, "app_instance_id", strM3171a1, setUnmodifiableSet);
        m8895R(builder, "rdid", aVar.m3181f1(), setUnmodifiableSet);
        m8895R(builder, "bundle_id", aVar.m3169Z0(), setUnmodifiableSet);
        String strM1651H = aVar2.m1651H();
        String strM3491a = AbstractC0701PA.m3491a(strM1651H);
        if (!TextUtils.isEmpty(strM3491a)) {
            strM1651H = strM3491a;
        }
        m8895R(builder, "app_event_name", strM1651H, setUnmodifiableSet);
        m8895R(builder, "app_version", String.valueOf(aVar.m3144N()), setUnmodifiableSet);
        String strM3179e1 = aVar.m3179e1();
        if (mo347e().m10798H(str, c0961Uw) && mo3247r().m3241f0(str) && !TextUtils.isEmpty(strM3179e1) && (iIndexOf = strM3179e1.indexOf(".")) != -1) {
            strM3179e1 = strM3179e1.substring(0, iIndexOf);
        }
        m8895R(builder, "os_version", strM3179e1, setUnmodifiableSet);
        m8895R(builder, "timestamp", String.valueOf(aVar2.m1649F()), setUnmodifiableSet);
        if (aVar.m3140L()) {
            m8895R(builder, "lat", "1", setUnmodifiableSet);
        }
        m8895R(builder, "privacy_sandbox_version", String.valueOf(aVar.m3195t()), setUnmodifiableSet);
        m8895R(builder, "trigger_uri_source", "1", setUnmodifiableSet);
        m8895R(builder, "trigger_uri_timestamp", String.valueOf(jMo2815a), setUnmodifiableSet);
        m8895R(builder, "request_uuid", str2, setUnmodifiableSet);
        List<C0457Jx> listM1652I = aVar2.m1652I();
        Bundle bundle = new Bundle();
        for (C0457Jx c0457Jx : listM1652I) {
            String strM2191W = c0457Jx.m2191W();
            if (c0457Jx.m2194Z()) {
                strValueOf2 = String.valueOf(c0457Jx.m2187G());
            } else if (c0457Jx.m2195a0()) {
                strValueOf2 = String.valueOf(c0457Jx.m2188N());
            } else if (c0457Jx.m2198d0()) {
                strValueOf2 = c0457Jx.m2192X();
            } else if (c0457Jx.m2196b0()) {
                strValueOf2 = String.valueOf(c0457Jx.m2190S());
            }
            bundle.putString(strM2191W, strValueOf2);
        }
        m8896S(builder, mo347e().m10796F(str, AbstractC0818Rr.f2500g0).split("\\|"), bundle, setUnmodifiableSet);
        List<C0779Qx> listM3136J = aVar.m3136J();
        Bundle bundle2 = new Bundle();
        for (C0779Qx c0779Qx : listM3136J) {
            String strM3731U = c0779Qx.m3731U();
            if (c0779Qx.m3733W()) {
                strValueOf = String.valueOf(c0779Qx.m3727G());
            } else if (c0779Qx.m3734X()) {
                strValueOf = String.valueOf(c0779Qx.m3728L());
            } else if (c0779Qx.m3737a0()) {
                strValueOf = c0779Qx.m3732V();
            } else if (c0779Qx.m3735Y()) {
                strValueOf = String.valueOf(c0779Qx.m3729P());
            }
            bundle2.putString(strM3731U, strValueOf);
        }
        m8896S(builder, mo347e().m10796F(str, AbstractC0818Rr.f2497f0).split("\\|"), bundle2, setUnmodifiableSet);
        m8895R(builder, "dma", aVar.m3138K() ? "1" : "0", setUnmodifiableSet);
        if (!aVar.m3175c1().isEmpty()) {
            m8895R(builder, "dma_cps", aVar.m3175c1(), setUnmodifiableSet);
        }
        if (mo347e().m10818t(AbstractC0818Rr.f2454M0) && aVar.m3142M()) {
            C0135Cx c0135CxM3190o0 = aVar.m3190o0();
            if (!c0135CxM3190o0.m556b0().isEmpty()) {
                m8895R(builder, "dl_gclid", c0135CxM3190o0.m556b0(), setUnmodifiableSet);
            }
            if (!c0135CxM3190o0.m555a0().isEmpty()) {
                m8895R(builder, "dl_gbraid", c0135CxM3190o0.m555a0(), setUnmodifiableSet);
            }
            if (!c0135CxM3190o0.m554X().isEmpty()) {
                m8895R(builder, "dl_gs", c0135CxM3190o0.m554X(), setUnmodifiableSet);
            }
            if (c0135CxM3190o0.m552G() > 0) {
                m8895R(builder, "dl_ss_ts", String.valueOf(c0135CxM3190o0.m552G()), setUnmodifiableSet);
            }
            if (!c0135CxM3190o0.m559e0().isEmpty()) {
                m8895R(builder, "mr_gclid", c0135CxM3190o0.m559e0(), setUnmodifiableSet);
            }
            if (!c0135CxM3190o0.m558d0().isEmpty()) {
                m8895R(builder, "mr_gbraid", c0135CxM3190o0.m558d0(), setUnmodifiableSet);
            }
            if (!c0135CxM3190o0.m557c0().isEmpty()) {
                m8895R(builder, "mr_gs", c0135CxM3190o0.m557c0(), setUnmodifiableSet);
            }
            if (c0135CxM3190o0.m553K() > 0) {
                m8895R(builder, "mr_click_ts", String.valueOf(c0135CxM3190o0.m553K()), setUnmodifiableSet);
            }
        }
        return new C1913jF(builder.build().toString(), jMo2815a, 1);
    }

    public final void m8919X(StringBuilder sb, int i, List list) {
        if (list == null) {
            return;
        }
        int i2 = i + 1;
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C0457Jx c0457Jx = (C0457Jx) it.next();
            if (c0457Jx != null) {
                m8897T(sb, i2);
                sb.append("param {\n");
                m8898U(sb, i2, "name", c0457Jx.m2197c0() ? mo350h().m9212f(c0457Jx.m2191W()) : null);
                m8898U(sb, i2, "string_value", c0457Jx.m2198d0() ? c0457Jx.m2192X() : null);
                m8898U(sb, i2, "int_value", c0457Jx.m2196b0() ? Long.valueOf(c0457Jx.m2190S()) : null);
                m8898U(sb, i2, "double_value", c0457Jx.m2194Z() ? Double.valueOf(c0457Jx.m2187G()) : null);
                if (c0457Jx.m2189Q() > 0) {
                    m8919X(sb, i2, c0457Jx.m2193Y());
                }
                m8897T(sb, i2);
                sb.append("}\n");
            }
        }
    }

    public final void m8920Y(StringBuilder sb, int i, C2032lw c2032lw) {
        if (c2032lw == null) {
            return;
        }
        m8897T(sb, i);
        sb.append("filter {\n");
        if (c2032lw.m8422N()) {
            m8898U(sb, i, "complement", Boolean.valueOf(c2032lw.m8421M()));
        }
        if (c2032lw.m8424P()) {
            m8898U(sb, i, "param_name", mo350h().m9212f(c2032lw.m8420L()));
        }
        if (c2032lw.m8425Q()) {
            int i2 = i + 1;
            C2171ow c2171owM8419K = c2032lw.m8419K();
            if (c2171owM8419K != null) {
                m8897T(sb, i2);
                sb.append("string_filter");
                sb.append(" {\n");
                if (c2171owM8419K.m8994O()) {
                    m8898U(sb, i2, "match_type", c2171owM8419K.m8988G().name());
                }
                if (c2171owM8419K.m8993N()) {
                    m8898U(sb, i2, "expression", c2171owM8419K.m8989J());
                }
                if (c2171owM8419K.m8992M()) {
                    m8898U(sb, i2, "case_sensitive", Boolean.valueOf(c2171owM8419K.m8991L()));
                }
                if (c2171owM8419K.m8995j() > 0) {
                    m8897T(sb, i + 2);
                    sb.append("expression_list {\n");
                    for (String str : c2171owM8419K.m8990K()) {
                        m8897T(sb, i + 3);
                        sb.append(str);
                        sb.append("\n");
                    }
                    sb.append("}\n");
                }
                m8897T(sb, i2);
                sb.append("}\n");
            }
        }
        if (c2032lw.m8423O()) {
            m8899V(sb, i + 1, "number_filter", c2032lw.m8418J());
        }
        m8897T(sb, i);
        sb.append("}\n");
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    public final void m8921a0(C0457Jx.a aVar, Object obj) {
        AbstractC1085Xi.m4801j(obj);
        aVar.m2203D().m2201B().m2212z().m2202C();
        if (obj instanceof String) {
            aVar.m2200A((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.m2208v(((Long) obj).longValue());
            return;
        }
        if (obj instanceof Double) {
            aVar.m2207u(((Double) obj).doubleValue());
            return;
        }
        if (!(obj instanceof Bundle[])) {
            mo349g().m9618G().m10617b("Ignoring invalid (type) event param value", obj);
            return;
        }
        ArrayList arrayList = new ArrayList<>();
        for (Bundle bundle : (Bundle[]) obj) {
            if (bundle != null) {
                C0457Jx.a aVarM2185U = C0457Jx.m2185U();
                for (String str : bundle.keySet()) {
                    C0457Jx.a aVarM2210x = C0457Jx.m2185U().m2210x(str);
                    Object obj2 = bundle.get(str);
                    if (obj2 instanceof Long) {
                        aVarM2210x.m2208v(((Long) obj2).longValue());
                    } else if (obj2 instanceof String) {
                        aVarM2210x.m2200A((String) obj2);
                    } else if (obj2 instanceof Double) {
                        aVarM2210x.m2207u(((Double) obj2).doubleValue());
                    }
                    aVarM2185U.m2211y(aVarM2210x);
                }
                if (aVarM2185U.m2206t() > 0) {
                    arrayList.add((C0457Jx) ((AbstractC0703PC) aVarM2185U.m3526o()));
                }
            }
        }
        aVar.m2209w(arrayList);
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    public final void m8922b0(C0595Mx.a aVar) {
        mo349g().m9622K().m10616a("Checking account type status for ad personalization signals");
        if (m8926k0(aVar.m3169Z0())) {
            mo349g().m9617F().m10616a("Turning off ad personalization due to account type");
            C0779Qx c0779Qx = (C0779Qx) ((AbstractC0703PC) C0779Qx.m3725S().m3742w("_npa").m3744y(mo348f().m358u()).m3741v(1L).m3526o());
            int i = 0;
            while (true) {
                if (i >= aVar.m3168Z()) {
                    aVar.m3130G(c0779Qx);
                    break;
                } else {
                    if ("_npa".equals(aVar.m3133H0(i).m3731U())) {
                        aVar.m3203x(i, c0779Qx);
                        break;
                    }
                    i++;
                }
            }
            C0082Bq c0082BqM340a = C0082Bq.m340a(aVar.m3173b1());
            c0082BqM340a.m343d(C0425JA.a.AD_PERSONALIZATION, EnumC0404Iq.CHILD_ACCOUNT);
            aVar.m3189n0(c0082BqM340a.toString());
        }
    }

    public final void m8923c0(C0779Qx.a aVar, Object obj) {
        AbstractC1085Xi.m4801j(obj);
        aVar.m3738A().m3743x().m3739t();
        if (obj instanceof String) {
            aVar.m3745z((String) obj);
            return;
        }
        if (obj instanceof Long) {
            aVar.m3741v(((Long) obj).longValue());
        } else if (obj instanceof Double) {
            aVar.m3740u(((Double) obj).doubleValue());
        } else {
            mo349g().m9618G().m10617b("Ignoring invalid (type) user attribute value", obj);
        }
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    public final boolean m8924d0(long j, long j2) {
        return j == 0 || j2 <= 0 || Math.abs(mo345b().mo2815a() - j) > j2;
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

    public final byte[] m8925i0(byte[] bArr) {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            GZIPOutputStream gZIPOutputStream = new GZIPOutputStream(byteArrayOutputStream);
            gZIPOutputStream.write(bArr);
            gZIPOutputStream.close();
            byteArrayOutputStream.close();
            return byteArrayOutputStream.toByteArray();
        } catch (IOException e) {
            mo349g().m9618G().m10617b("Failed to gzip content", e);
            throw e;
        }
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    public final boolean m8926k0(String str) {
        if (C1635dH.m7317a() && mo347e().m10818t(AbstractC0818Rr.f2474W0)) {
            return false;
        }
        AbstractC1085Xi.m4801j(str);
        C2403ty c2403tyM2488L0 = mo3246q().m2488L0(str);
        return c2403tyM2488L0 != null && mo348f().m362y() && c2403tyM2488L0.m9876z() && mo3247r().m3232W(str);
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    public final byte[] m8927l0(byte[] bArr) throws IOException {
        try {
            ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArr);
            GZIPInputStream gZIPInputStream = new GZIPInputStream(byteArrayInputStream);
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr2 = new byte[1024];
            while (true) {
                int i = gZIPInputStream.read(bArr2);
                if (i <= 0) {
                    gZIPInputStream.close();
                    byteArrayInputStream.close();
                    return byteArrayOutputStream.toByteArray();
                }
                byteArrayOutputStream.write(bArr2, 0, i);
            }
        } catch (IOException e) {
            mo349g().m9618G().m10617b("Failed to ungzip content", e);
            throw e;
        }
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    public final List m8928m0() throws NumberFormatException {
        Map mapM3890b = AbstractC0818Rr.m3890b(this.f6912b.mo344a());
        if (mapM3890b == null || mapM3890b.isEmpty()) {
            return null;
        }
        ArrayList arrayList = new ArrayList<>();
        int iIntValue = ((Integer) AbstractC0818Rr.f2465S.m4296a(null)).intValue();
        for (Map.Entry entry : mapM3890b.entrySet()) {
            if (((String) entry.getKey()).startsWith("measurement.id.")) {
                try {
                    int i = Integer.parseInt((String) entry.getValue());
                    if (i != 0) {
                        arrayList.add(Integer.valueOf(i));
                        if (arrayList.size() >= iIntValue) {
                            mo349g().m9623L().m10617b("Too many experiment IDs. Number of IDs", Integer.valueOf(arrayList.size()));
                            break;
                        }
                        continue;
                    } else {
                        continue;
                    }
                } catch (NumberFormatException e) {
                    mo349g().m9623L().m10617b("Experiment ID NumberFormatException", e);
                }
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return arrayList;
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final /* bridge */ C2145oG mo3244o() {
        return super.mo3244o();
    }

    @Override
    public final /* bridge */ C0846SI mo3245p() {
        return super.mo3245p();
    }

    @Override
    public final /* bridge */ C0496Kq mo3246q() {
        return super.mo3246q();
    }

    @Override
    public final /* bridge */ C0596My mo3247r() {
        return super.mo3247r();
    }

    @Override
    public final /* bridge */ C2420uE mo3248s() {
        return super.mo3248s();
    }

    @Override
    public final /* bridge */ C2467vF mo3249t() {
        return super.mo3249t();
    }

    @Override
    public final boolean mo2541x() {
        return false;
    }

    public final long m8929z(String str) {
        if (TextUtils.isEmpty(str)) {
            return 0L;
        }
        return m8908A(str.getBytes(Charset.forName("UTF-8")));
    }
}
