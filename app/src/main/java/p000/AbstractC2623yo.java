package p000;

import java.io.Closeable;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.lang.reflect.InvocationTargetException;
import java.net.Socket;
import java.net.SocketException;
import java.net.SocketTimeoutException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TimeZone;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.TimeUnit;

/* loaded from: classes.dex */
public abstract class AbstractC2623yo {

    public static final byte[] f8127a;

    public static final C1079Xc f8128b = C1079Xc.f3227m.m4755g(new String[0]);

    public static final AbstractC0536Lk f8129c;

    public static final AbstractC0168Dk f8130d;

    public static final C1739fi f8131e;

    public static final TimeZone f8132f;

    public static final C2389tk f8133g;

    public static final boolean f8134h;

    public static final String f8135i;

    public static final class a implements AbstractC1918ja.c {

        public final AbstractC1918ja f8136a;

        public a(AbstractC1918ja abstractC1918ja) {
            this.f8136a = abstractC1918ja;
        }

        @Override
        public final AbstractC1918ja mo8158a(InterfaceC0418J3 interfaceC0418J3) {
            AbstractC0116Ce.m476e(interfaceC0418J3, "it");
            return this.f8136a;
        }
    }

    public static final class b implements ThreadFactory {

        public final String f8137a;

        public final boolean f8138b;

        public b(String str, boolean z) {
            this.f8137a = str;
            this.f8138b = z;
        }

        @Override
        public final Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable, this.f8137a);
            thread.setDaemon(this.f8138b);
            return thread;
        }
    }

    static {
        byte[] bArr = new byte[0];
        f8127a = bArr;
        f8129c = AbstractC0536Lk.a.m2715c(AbstractC0536Lk.f1726l, bArr, null, 1, null);
        f8130d = AbstractC0168Dk.a.m726f(AbstractC0168Dk.f416a, bArr, null, 0, 0, 7, null);
        C1739fi.a aVar = C1739fi.f5506o;
        C0096C3.a aVar2 = C0096C3.f235p;
        f8131e = aVar.m7603d(aVar2.m393a("efbbbf"), aVar2.m393a("feff"), aVar2.m393a("fffe"), aVar2.m393a("0000ffff"), aVar2.m393a("ffff0000"));
        TimeZone timeZone = TimeZone.getTimeZone("GMT");
        AbstractC0116Ce.m473b(timeZone);
        f8132f = timeZone;
        f8133g = new C2389tk("([0-9a-fA-F]*:[0-9a-fA-F:.]*)|([\\d.]+)");
        f8134h = false;
        String name = OkHttpClient.class.getName();
        AbstractC0116Ce.m475d(name, "OkHttpClient::class.java.name");
        f8135i = AbstractC0584Mm.m2944b0(AbstractC0584Mm.m2943a0(name, "okhttp3."), "Client");
    }

    public static final int m10905A(String str, int i) {
        AbstractC0116Ce.m476e(str, "$this$indexOfNonWhitespace");
        int length = str.length();
        while (i < length) {
            char cCharAt = str.charAt(i);
            if (cCharAt != ' ' && cCharAt != '\t') {
                return i;
            }
            i++;
        }
        return str.length();
    }

    public static final String[] m10906B(String[] strArr, String[] strArr2, Comparator comparator) {
        AbstractC0116Ce.m476e(strArr, "$this$intersect");
        AbstractC0116Ce.m476e(strArr2, "other");
        AbstractC0116Ce.m476e(comparator, "comparator");
        ArrayList arrayList = new ArrayList<>();
        for (String str : strArr) {
            int length = strArr2.length;
            int i = 0;
            while (true) {
                if (i >= length) {
                    break;
                }
                if (comparator.compare(str, strArr2[i]) == 0) {
                    arrayList.add(str);
                    break;
                }
                i++;
            }
        }
        Object[] array = arrayList.toArray(new String[0]);
        if (array != null) {
            return (String[]) array;
        }
        throw new NullPointerException("null cannot be cast to non-null type kotlin.Array<T>");
    }

    public static final boolean m10907C(Socket socket, InterfaceC2547x3 interfaceC2547x3) throws SocketException {
        AbstractC0116Ce.m476e(socket, "$this$isHealthy");
        AbstractC0116Ce.m476e(interfaceC2547x3, "source");
        try {
            int soTimeout = socket.getSoTimeout();
            try {
                socket.setSoTimeout(1);
                boolean z = !interfaceC2547x3.mo7333K();
                socket.setSoTimeout(soTimeout);
                return z;
            } catch (Throwable th) {
                socket.setSoTimeout(soTimeout);
                throw th;
            }
        } catch (SocketTimeoutException unused) {
            return true;
        } catch (IOException unused2) {
            return false;
        }
    }

    public static final int m10908D(char c) {
        if ('0' <= c && '9' >= c) {
            return c - '0';
        }
        if ('a' <= c && 'f' >= c) {
            return c - 'W';
        }
        if ('A' <= c && 'F' >= c) {
            return c - '7';
        }
        return -1;
    }

    public static final Charset m10909E(InterfaceC2547x3 interfaceC2547x3, Charset charset) {
        Charset charset2;
        String str;
        AbstractC0116Ce.m476e(interfaceC2547x3, "$this$readBomAsCharset");
        AbstractC0116Ce.m476e(charset, "default");
        int iMo7349v = interfaceC2547x3.mo7349v(f8131e);
        if (iMo7349v == -1) {
            return charset;
        }
        if (iMo7349v == 0) {
            charset2 = StandardCharsets.UTF_8;
            str = "UTF_8";
        } else if (iMo7349v == 1) {
            charset2 = StandardCharsets.UTF_16BE;
            str = "UTF_16BE";
        } else {
            if (iMo7349v != 2) {
                if (iMo7349v == 3) {
                    return C2502w4.f7788a.m10430a();
                }
                if (iMo7349v == 4) {
                    return C2502w4.f7788a.m10431b();
                }
                throw new AssertionError();
            }
            charset2 = StandardCharsets.UTF_16LE;
            str = "UTF_16LE";
        }
        AbstractC0116Ce.m475d(charset2, str);
        return charset2;
    }

    public static final int m10910F(InterfaceC2547x3 interfaceC2547x3) {
        AbstractC0116Ce.m476e(interfaceC2547x3, "$this$readMedium");
        return m10927b(interfaceC2547x3.mo7338R(), 255) | (m10927b(interfaceC2547x3.mo7338R(), 255) << 16) | (m10927b(interfaceC2547x3.mo7338R(), 255) << 8);
    }

    public static final int m10911G(C2409u3 c2409u3, byte b2) throws EOFException {
        AbstractC0116Ce.m476e(c2409u3, "$this$skipAll");
        int i = 0;
        while (!c2409u3.mo7333K() && c2409u3.m9932z(0L) == b2) {
            i++;
            c2409u3.mo7338R();
        }
        return i;
    }

    public static final boolean m10912H(InterfaceC2161om interfaceC2161om, int i, TimeUnit timeUnit) {
        AbstractC0116Ce.m476e(interfaceC2161om, "$this$skipAll");
        AbstractC0116Ce.m476e(timeUnit, "timeUnit");
        long jNanoTime = System.nanoTime();
        long jMo435c = interfaceC2161om.mo239d().mo437e() ? interfaceC2161om.mo239d().mo435c() - jNanoTime : Long.MAX_VALUE;
        interfaceC2161om.mo239d().mo436d(Math.min(jMo435c, timeUnit.toNanos(i)) + jNanoTime);
        try {
            C2409u3 c2409u3 = new C2409u3();
            while (interfaceC2161om.mo1488n(c2409u3, 8192L) != -1) {
                c2409u3.m9913a();
            }
            C0125Cn c0125CnMo239d = interfaceC2161om.mo239d();
            if (jMo435c == Long.MAX_VALUE) {
                c0125CnMo239d.mo433a();
            } else {
                c0125CnMo239d.mo436d(jNanoTime + jMo435c);
            }
            return true;
        } catch (InterruptedIOException unused) {
            C0125Cn c0125CnMo239d2 = interfaceC2161om.mo239d();
            if (jMo435c == Long.MAX_VALUE) {
                c0125CnMo239d2.mo433a();
            } else {
                c0125CnMo239d2.mo436d(jNanoTime + jMo435c);
            }
            return false;
        } catch (Throwable th) {
            C0125Cn c0125CnMo239d3 = interfaceC2161om.mo239d();
            if (jMo435c == Long.MAX_VALUE) {
                c0125CnMo239d3.mo433a();
            } else {
                c0125CnMo239d3.mo436d(jNanoTime + jMo435c);
            }
            throw th;
        }
    }

    public static final ThreadFactory m10913I(String str, boolean z) {
        AbstractC0116Ce.m476e(str, "name");
        return new b(str, z);
    }

    public static final List m10914J(C1079Xc c1079Xc) {
        AbstractC0116Ce.m476e(c1079Xc, "$this$toHeaderList");
        C2659ze c2659zeM4987h = AbstractC1132Yj.m4987h(0, c1079Xc.size());
        ArrayList arrayList = new ArrayList<>(AbstractC1857i5.m7866n(c2659zeM4987h, 10));
        Iterator it = c2659zeM4987h.iterator();
        while (it.hasNext()) {
            int iMo10565b = ((AbstractC2521we) it).mo10565b();
            arrayList.add(new C1033Wc(c1079Xc.m4738f(iMo10565b), c1079Xc.m4740h(iMo10565b)));
        }
        return arrayList;
    }

    public static final C1079Xc m10915K(List list) {
        AbstractC0116Ce.m476e(list, "$this$toHeaders");
        C1079Xc.a aVar = new C1079Xc.a();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            C1033Wc c1033Wc = (C1033Wc) it.next();
            aVar.m4744c(c1033Wc.m4491a().m390x(), c1033Wc.m4492b().m390x());
        }
        return aVar.m4745d();
    }

    public static final String m10916L(C0069Bd c0069Bd, boolean z) {
        String strM249h;
        AbstractC0116Ce.m476e(c0069Bd, "$this$toHostHeader");
        if (AbstractC0584Mm.m2918B(c0069Bd.m249h(), ":", false, 2, null)) {
            strM249h = '[' + c0069Bd.m249h() + ']';
        } else {
            strM249h = c0069Bd.m249h();
        }
        if (!z && c0069Bd.m253l() == C0069Bd.f158l.m293c(c0069Bd.m257p())) {
            return strM249h;
        }
        return strM249h + ':' + c0069Bd.m253l();
    }

    public static String m10917M(C0069Bd c0069Bd, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            z = false;
        }
        return m10916L(c0069Bd, z);
    }

    public static final List m10918N(List list) {
        AbstractC0116Ce.m476e(list, "$this$toImmutableList");
        List listUnmodifiableList = Collections.unmodifiableList(AbstractC2181p5.m9021I(list));
        AbstractC0116Ce.m475d(listUnmodifiableList, "Collections.unmodifiableList(toMutableList())");
        return listUnmodifiableList;
    }

    public static final Map m10919O(Map map) {
        AbstractC0116Ce.m476e(map, "$this$toImmutableMap");
        if (map.isEmpty()) {
            return AbstractC2339sg.m9572d();
        }
        Map mapUnmodifiableMap = Collections.unmodifiableMap(new LinkedHashMap(map));
        AbstractC0116Ce.m475d(mapUnmodifiableMap, "Collections.unmodifiableMap(LinkedHashMap(this))");
        return mapUnmodifiableMap;
    }

    public static final long m10920P(String str, long j) {
        AbstractC0116Ce.m476e(str, "$this$toLongOrDefault");
        try {
            return Long.parseLong(str);
        } catch (NumberFormatException unused) {
            return j;
        }
    }

    public static final int m10921Q(String str, int i) throws NumberFormatException {
        if (str != null) {
            try {
                long j = Long.parseLong(str);
                if (j > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                }
                if (j < 0) {
                    return 0;
                }
                return (int) j;
            } catch (NumberFormatException unused) {
            }
        }
        return i;
    }

    public static final String m10922R(String str, int i, int i2) {
        AbstractC0116Ce.m476e(str, "$this$trimSubstring");
        int iM10948w = m10948w(str, i, i2);
        String strSubstring = str.substring(iM10948w, m10950y(str, iM10948w, i2));
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
        return strSubstring;
    }

    public static String m10923S(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m10922R(str, i, i2);
    }

    public static final Throwable m10924T(Exception exc, List list) throws IllegalAccessException, IllegalArgumentException, InvocationTargetException {
        AbstractC0116Ce.m476e(exc, "$this$withSuppressed");
        AbstractC0116Ce.m476e(list, "suppressed");
        if (list.size() > 1) {
            System.out.println(list);
        }
        Iterator it = list.iterator();
        while (it.hasNext()) {
            AbstractC2241qa.m9151a(exc, (Exception) it.next());
        }
        return exc;
    }

    public static final void m10925U(InterfaceC2501w3 interfaceC2501w3, int i) {
        AbstractC0116Ce.m476e(interfaceC2501w3, "$this$writeMedium");
        interfaceC2501w3.mo5926L((i >>> 16) & 255);
        interfaceC2501w3.mo5926L((i >>> 8) & 255);
        interfaceC2501w3.mo5926L(i & 255);
    }

    public static final void m10926a(List list, Object obj) {
        AbstractC0116Ce.m476e(list, "$this$addIfAbsent");
        if (list.contains(obj)) {
            return;
        }
        list.add(obj);
    }

    public static final int m10927b(byte b2, int i) {
        return b2 & i;
    }

    public static final int m10928c(short s, int i) {
        return s & i;
    }

    public static final long m10929d(int i, long j) {
        return i & j;
    }

    public static final AbstractC1918ja.c m10930e(AbstractC1918ja abstractC1918ja) {
        AbstractC0116Ce.m476e(abstractC1918ja, "$this$asFactory");
        return new a(abstractC1918ja);
    }

    public static final boolean m10931f(String str) {
        AbstractC0116Ce.m476e(str, "$this$canParseAsIpAddress");
        return f8133g.m9728a(str);
    }

    public static final boolean m10932g(C0069Bd c0069Bd, C0069Bd c0069Bd2) {
        AbstractC0116Ce.m476e(c0069Bd, "$this$canReuseConnectionFor");
        AbstractC0116Ce.m476e(c0069Bd2, "other");
        return AbstractC0116Ce.m472a(c0069Bd.m249h(), c0069Bd2.m249h()) && c0069Bd.m253l() == c0069Bd2.m253l() && AbstractC0116Ce.m472a(c0069Bd.m257p(), c0069Bd2.m257p());
    }

    public static final int m10933h(String name, long j, TimeUnit timeUnit) {
        AbstractC0116Ce.m476e(name, "name");
        if (!(j >= 0)) {
            throw new IllegalStateException((name + " < 0").toString());
        }
        if (!(timeUnit != null)) {
            throw new IllegalStateException("unit == null".toString());
        }
        long millis = timeUnit.toMillis(j);
        if (!(millis <= ((long) Integer.MAX_VALUE))) {
            throw new IllegalArgumentException((name + " too large.").toString());
        }
        if (millis != 0 || j <= 0) {
            return (int) millis;
        }
        throw new IllegalArgumentException((name + " too small.").toString());
    }

    public static final void m10934i(long j, long j2, long j3) {
        if ((j2 | j3) < 0 || j2 > j || j - j2 < j3) {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    public static final void m10935j(Closeable closeable) throws IOException {
        AbstractC0116Ce.m476e(closeable, "$this$closeQuietly");
        try {
            closeable.close();
        } catch (RuntimeException e) {
            throw e;
        } catch (Exception unused) {
        }
    }

    public static final void m10936k(Socket socket) throws IOException {
        AbstractC0116Ce.m476e(socket, "$this$closeQuietly");
        try {
            socket.close();
        } catch (AssertionError e) {
            throw e;
        } catch (RuntimeException e2) {
            if (!AbstractC0116Ce.m472a(e2.getMessage(), "bio == null")) {
                throw e2;
            }
        } catch (Exception unused) {
        }
    }

    public static final String[] m10937l(String[] strArr, String str) {
        AbstractC0116Ce.m476e(strArr, "$this$concat");
        AbstractC0116Ce.m476e(str, "value");
        Object[] objArrCopyOf = Arrays.copyOf(strArr, strArr.length + 1);
        AbstractC0116Ce.m475d(objArrCopyOf, "java.util.Arrays.copyOf(this, newSize)");
        String[] strArr2 = (String[]) objArrCopyOf;
        strArr2[AbstractC0002A1.m8o(strArr2)] = str;
        return strArr2;
    }

    public static final int m10938m(String str, char c, int i, int i2) {
        AbstractC0116Ce.m476e(str, "$this$delimiterOffset");
        while (i < i2) {
            if (str.charAt(i) == c) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static final int m10939n(String str, String str2, int i, int i2) {
        AbstractC0116Ce.m476e(str, "$this$delimiterOffset");
        AbstractC0116Ce.m476e(str2, "delimiters");
        while (i < i2) {
            if (AbstractC0584Mm.m2917A(str2, str.charAt(i), false, 2, null)) {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int m10940o(String str, char c, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = str.length();
        }
        return m10938m(str, c, i, i2);
    }

    public static final boolean m10941p(InterfaceC2161om interfaceC2161om, int i, TimeUnit timeUnit) {
        AbstractC0116Ce.m476e(interfaceC2161om, "$this$discard");
        AbstractC0116Ce.m476e(timeUnit, "timeUnit");
        try {
            return m10912H(interfaceC2161om, i, timeUnit);
        } catch (IOException unused) {
            return false;
        }
    }

    public static final String m10942q(String str, Object... objArr) {
        AbstractC0116Ce.m476e(str, "format");
        AbstractC0116Ce.m476e(objArr, "args");
        C2621ym c2621ym = C2621ym.f8126a;
        Locale locale = Locale.US;
        Object[] objArrCopyOf = Arrays.copyOf(objArr, objArr.length);
        String str2 = String.format(locale, str, Arrays.copyOf(objArrCopyOf, objArrCopyOf.length));
        AbstractC0116Ce.m475d(str2, "java.lang.String.format(locale, format, *args)");
        return str2;
    }

    public static final boolean m10943r(String[] strArr, String[] strArr2, Comparator comparator) {
        AbstractC0116Ce.m476e(strArr, "$this$hasIntersection");
        AbstractC0116Ce.m476e(comparator, "comparator");
        if (strArr.length != 0 && strArr2 != null && strArr2.length != 0) {
            for (String str : strArr) {
                for (String str2 : strArr2) {
                    if (comparator.compare(str, str2) == 0) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public static final long m10944s(C0490Kk c0490Kk) {
        AbstractC0116Ce.m476e(c0490Kk, "$this$headersContentLength");
        String strM4737d = c0490Kk.m2401z().m4737d("Content-Length");
        if (strM4737d != null) {
            return m10920P(strM4737d, -1L);
        }
        return -1L;
    }

    public static final List m10945t(Object... objArr) {
        AbstractC0116Ce.m476e(objArr, "elements");
        Object[] objArr2 = (Object[]) objArr.clone();
        List listUnmodifiableList = Collections.unmodifiableList(AbstractC1810h5.m7785h(Arrays.copyOf(objArr2, objArr2.length)));
        AbstractC0116Ce.m475d(listUnmodifiableList, "Collections.unmodifiable…istOf(*elements.clone()))");
        return listUnmodifiableList;
    }

    public static final int m10946u(String[] strArr, String str, Comparator comparator) {
        AbstractC0116Ce.m476e(strArr, "$this$indexOf");
        AbstractC0116Ce.m476e(str, "value");
        AbstractC0116Ce.m476e(comparator, "comparator");
        int length = strArr.length;
        for (int i = 0; i < length; i++) {
            if (comparator.compare(strArr[i], str) == 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int m10947v(String str) {
        AbstractC0116Ce.m476e(str, "$this$indexOfControlOrNonAscii");
        int length = str.length();
        for (int i = 0; i < length; i++) {
            char cCharAt = str.charAt(i);
            if (AbstractC0116Ce.m477f(cCharAt, 31) <= 0 || AbstractC0116Ce.m477f(cCharAt, 127) >= 0) {
                return i;
            }
        }
        return -1;
    }

    public static final int m10948w(String str, int i, int i2) {
        AbstractC0116Ce.m476e(str, "$this$indexOfFirstNonAsciiWhitespace");
        while (i < i2) {
            char cCharAt = str.charAt(i);
            if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                return i;
            }
            i++;
        }
        return i2;
    }

    public static int m10949x(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m10948w(str, i, i2);
    }

    public static final int m10950y(String str, int i, int i2) {
        AbstractC0116Ce.m476e(str, "$this$indexOfLastNonAsciiWhitespace");
        int i3 = i2 - 1;
        if (i3 >= i) {
            while (true) {
                char cCharAt = str.charAt(i3);
                if (cCharAt != '\t' && cCharAt != '\n' && cCharAt != '\f' && cCharAt != '\r' && cCharAt != ' ') {
                    return i3 + 1;
                }
                if (i3 == i) {
                    break;
                }
                i3--;
            }
        }
        return i;
    }

    public static int m10951z(String str, int i, int i2, int i3, Object obj) {
        if ((i3 & 1) != 0) {
            i = 0;
        }
        if ((i3 & 2) != 0) {
            i2 = str.length();
        }
        return m10950y(str, i, i2);
    }
}
