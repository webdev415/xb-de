package p000;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.BitSet;
import java.util.Iterator;
import java.util.Map;
import java.util.TreeMap;

public abstract class AbstractC2065mj {

    public static final byte[] f6252a = {112, 114, 111, 0};

    public static final byte[] f6253b = {112, 114, 109, 0};

    public static void m8597A(InputStream inputStream) {
        AbstractC1113Y9.m4892h(inputStream);
        int iM4894j = AbstractC1113Y9.m4894j(inputStream);
        if (iM4894j == 6 || iM4894j == 7) {
            return;
        }
        while (iM4894j > 0) {
            AbstractC1113Y9.m4894j(inputStream);
            for (int iM4894j2 = AbstractC1113Y9.m4894j(inputStream); iM4894j2 > 0; iM4894j2--) {
                AbstractC1113Y9.m4892h(inputStream);
            }
            iM4894j--;
        }
    }

    public static boolean m8598B(OutputStream outputStream, byte[] bArr, C0790R8[] c0790r8Arr) throws IOException {
        if (Arrays.equals(bArr, AbstractC2111nj.f6467a)) {
            m8610N(outputStream, c0790r8Arr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC2111nj.f6468b)) {
            m8609M(outputStream, c0790r8Arr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC2111nj.f6470d)) {
            m8607K(outputStream, c0790r8Arr);
            return true;
        }
        if (Arrays.equals(bArr, AbstractC2111nj.f6469c)) {
            m8608L(outputStream, c0790r8Arr);
            return true;
        }
        if (!Arrays.equals(bArr, AbstractC2111nj.f6471e)) {
            return false;
        }
        m8606J(outputStream, c0790r8Arr);
        return true;
    }

    public static void m8599C(OutputStream outputStream, C0790R8 c0790r8) throws IOException {
        int[] iArr = c0790r8.f2348h;
        int length = iArr.length;
        int i = 0;
        int i2 = 0;
        while (i < length) {
            int i3 = iArr[i];
            AbstractC1113Y9.m4900p(outputStream, i3 - i2);
            i++;
            i2 = i3;
        }
    }

    public static C0035Ap m8600D(C0790R8[] c0790r8Arr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            AbstractC1113Y9.m4900p(byteArrayOutputStream, c0790r8Arr.length);
            int i = 2;
            for (C0790R8 c0790r8 : c0790r8Arr) {
                AbstractC1113Y9.m4901q(byteArrayOutputStream, c0790r8.f2343c);
                AbstractC1113Y9.m4901q(byteArrayOutputStream, c0790r8.f2344d);
                AbstractC1113Y9.m4901q(byteArrayOutputStream, c0790r8.f2347g);
                String strM8621j = m8621j(c0790r8.f2341a, c0790r8.f2342b, AbstractC2111nj.f6467a);
                int iM4895k = AbstractC1113Y9.m4895k(strM8621j);
                AbstractC1113Y9.m4900p(byteArrayOutputStream, iM4895k);
                i = i + 14 + iM4895k;
                AbstractC1113Y9.m4898n(byteArrayOutputStream, strM8621j);
            }
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            if (i == byteArray.length) {
                C0035Ap c0035Ap = new C0035Ap(EnumC0893Ta.DEX_FILES, i, byteArray, false);
                byteArrayOutputStream.close();
                return c0035Ap;
            }
            throw AbstractC1113Y9.m4887c("Expected size " + i + ", does not match actual size " + byteArray.length);
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static void m8601E(OutputStream outputStream, byte[] bArr) throws IOException {
        outputStream.write(f6252a);
        outputStream.write(bArr);
    }

    public static void m8602F(OutputStream outputStream, C0790R8 c0790r8) throws IOException {
        m8605I(outputStream, c0790r8);
        m8599C(outputStream, c0790r8);
        m8604H(outputStream, c0790r8);
    }

    public static void m8603G(OutputStream outputStream, C0790R8 c0790r8, String str) throws IOException {
        AbstractC1113Y9.m4900p(outputStream, AbstractC1113Y9.m4895k(str));
        AbstractC1113Y9.m4900p(outputStream, c0790r8.f2345e);
        AbstractC1113Y9.m4901q(outputStream, c0790r8.f2346f);
        AbstractC1113Y9.m4901q(outputStream, c0790r8.f2343c);
        AbstractC1113Y9.m4901q(outputStream, c0790r8.f2347g);
        AbstractC1113Y9.m4898n(outputStream, str);
    }

    public static void m8604H(OutputStream outputStream, C0790R8 c0790r8) throws IOException {
        byte[] bArr = new byte[m8622k(c0790r8.f2347g)];
        for (Map.Entry entry : c0790r8.f2349i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            int iIntValue2 = ((Integer) entry.getValue()).intValue();
            if ((iIntValue2 & 2) != 0) {
                m8637z(bArr, 2, iIntValue, c0790r8);
            }
            if ((iIntValue2 & 4) != 0) {
                m8637z(bArr, 4, iIntValue, c0790r8);
            }
        }
        outputStream.write(bArr);
    }

    public static void m8605I(OutputStream outputStream, C0790R8 c0790r8) throws IOException {
        int i = 0;
        for (Map.Entry entry : c0790r8.f2349i.entrySet()) {
            int iIntValue = ((Integer) entry.getKey()).intValue();
            if ((((Integer) entry.getValue()).intValue() & 1) != 0) {
                AbstractC1113Y9.m4900p(outputStream, iIntValue - i);
                AbstractC1113Y9.m4900p(outputStream, 0);
                i = iIntValue;
            }
        }
    }

    public static void m8606J(OutputStream outputStream, C0790R8[] c0790r8Arr) throws IOException {
        AbstractC1113Y9.m4900p(outputStream, c0790r8Arr.length);
        for (C0790R8 c0790r8 : c0790r8Arr) {
            String strM8621j = m8621j(c0790r8.f2341a, c0790r8.f2342b, AbstractC2111nj.f6471e);
            AbstractC1113Y9.m4900p(outputStream, AbstractC1113Y9.m4895k(strM8621j));
            AbstractC1113Y9.m4900p(outputStream, c0790r8.f2349i.size());
            AbstractC1113Y9.m4900p(outputStream, c0790r8.f2348h.length);
            AbstractC1113Y9.m4901q(outputStream, c0790r8.f2343c);
            AbstractC1113Y9.m4898n(outputStream, strM8621j);
            Iterator it = c0790r8.f2349i.keySet().iterator();
            while (it.hasNext()) {
                AbstractC1113Y9.m4900p(outputStream, ((Integer) it.next()).intValue());
            }
            for (int i : c0790r8.f2348h) {
                AbstractC1113Y9.m4900p(outputStream, i);
            }
        }
    }

    public static void m8607K(OutputStream outputStream, C0790R8[] c0790r8Arr) throws IOException {
        AbstractC1113Y9.m4902r(outputStream, c0790r8Arr.length);
        for (C0790R8 c0790r8 : c0790r8Arr) {
            int size = c0790r8.f2349i.size() * 4;
            String strM8621j = m8621j(c0790r8.f2341a, c0790r8.f2342b, AbstractC2111nj.f6470d);
            AbstractC1113Y9.m4900p(outputStream, AbstractC1113Y9.m4895k(strM8621j));
            AbstractC1113Y9.m4900p(outputStream, c0790r8.f2348h.length);
            AbstractC1113Y9.m4901q(outputStream, size);
            AbstractC1113Y9.m4901q(outputStream, c0790r8.f2343c);
            AbstractC1113Y9.m4898n(outputStream, strM8621j);
            Iterator it = c0790r8.f2349i.keySet().iterator();
            while (it.hasNext()) {
                AbstractC1113Y9.m4900p(outputStream, ((Integer) it.next()).intValue());
                AbstractC1113Y9.m4900p(outputStream, 0);
            }
            for (int i : c0790r8.f2348h) {
                AbstractC1113Y9.m4900p(outputStream, i);
            }
        }
    }

    public static void m8608L(OutputStream outputStream, C0790R8[] c0790r8Arr) throws IOException {
        byte[] bArrM8613b = m8613b(c0790r8Arr, AbstractC2111nj.f6469c);
        AbstractC1113Y9.m4902r(outputStream, c0790r8Arr.length);
        AbstractC1113Y9.m4897m(outputStream, bArrM8613b);
    }

    public static void m8609M(OutputStream outputStream, C0790R8[] c0790r8Arr) throws IOException {
        byte[] bArrM8613b = m8613b(c0790r8Arr, AbstractC2111nj.f6468b);
        AbstractC1113Y9.m4902r(outputStream, c0790r8Arr.length);
        AbstractC1113Y9.m4897m(outputStream, bArrM8613b);
    }

    public static void m8610N(OutputStream outputStream, C0790R8[] c0790r8Arr) throws IOException {
        m8611O(outputStream, c0790r8Arr);
    }

    public static void m8611O(OutputStream outputStream, C0790R8[] c0790r8Arr) throws IOException {
        int length;
        ArrayList arrayList = new ArrayList<>(3);
        ArrayList arrayList2 = new ArrayList<>(3);
        arrayList.add(m8600D(c0790r8Arr));
        arrayList.add(m8614c(c0790r8Arr));
        arrayList.add(m8615d(c0790r8Arr));
        long length2 = AbstractC2111nj.f6467a.length + f6252a.length + 4 + (arrayList.size() * 16);
        AbstractC1113Y9.m4901q(outputStream, arrayList.size());
        for (int i = 0; i < arrayList.size(); i++) {
            C0035Ap c0035Ap = (C0035Ap) arrayList.get(i);
            AbstractC1113Y9.m4901q(outputStream, c0035Ap.f86a.m4134e());
            AbstractC1113Y9.m4901q(outputStream, length2);
            if (c0035Ap.f89d) {
                byte[] bArr = c0035Ap.f88c;
                long length3 = bArr.length;
                byte[] bArrM4886b = AbstractC1113Y9.m4886b(bArr);
                arrayList2.add(bArrM4886b);
                AbstractC1113Y9.m4901q(outputStream, bArrM4886b.length);
                AbstractC1113Y9.m4901q(outputStream, length3);
                length = bArrM4886b.length;
            } else {
                arrayList2.add(c0035Ap.f88c);
                AbstractC1113Y9.m4901q(outputStream, c0035Ap.f88c.length);
                AbstractC1113Y9.m4901q(outputStream, 0L);
                length = c0035Ap.f88c.length;
            }
            length2 += length;
        }
        for (int i2 = 0; i2 < arrayList2.size(); i2++) {
            outputStream.write((byte[]) arrayList2.get(i2));
        }
    }

    public static int m8612a(C0790R8 c0790r8) {
        Iterator it = c0790r8.f2349i.entrySet().iterator();
        int iIntValue = 0;
        while (it.hasNext()) {
            iIntValue |= ((Integer) ((Map.Entry) it.next()).getValue()).intValue();
        }
        return iIntValue;
    }

    public static byte[] m8613b(C0790R8[] c0790r8Arr, byte[] bArr) throws IOException {
        int i = 0;
        int iM4895k = 0;
        for (C0790R8 c0790r8 : c0790r8Arr) {
            iM4895k += AbstractC1113Y9.m4895k(m8621j(c0790r8.f2341a, c0790r8.f2342b, bArr)) + 16 + (c0790r8.f2345e * 2) + c0790r8.f2346f + m8622k(c0790r8.f2347g);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(iM4895k);
        if (Arrays.equals(bArr, AbstractC2111nj.f6469c)) {
            int length = c0790r8Arr.length;
            while (i < length) {
                C0790R8 c0790r82 = c0790r8Arr[i];
                m8603G(byteArrayOutputStream, c0790r82, m8621j(c0790r82.f2341a, c0790r82.f2342b, bArr));
                m8602F(byteArrayOutputStream, c0790r82);
                i++;
            }
        } else {
            for (C0790R8 c0790r83 : c0790r8Arr) {
                m8603G(byteArrayOutputStream, c0790r83, m8621j(c0790r83.f2341a, c0790r83.f2342b, bArr));
            }
            int length2 = c0790r8Arr.length;
            while (i < length2) {
                m8602F(byteArrayOutputStream, c0790r8Arr[i]);
                i++;
            }
        }
        if (byteArrayOutputStream.size() == iM4895k) {
            return byteArrayOutputStream.toByteArray();
        }
        throw AbstractC1113Y9.m4887c("The bytes saved do not match expectation. actual=" + byteArrayOutputStream.size() + " expected=" + iM4895k);
    }

    public static C0035Ap m8614c(C0790R8[] c0790r8Arr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < c0790r8Arr.length; i2++) {
            try {
                C0790R8 c0790r8 = c0790r8Arr[i2];
                AbstractC1113Y9.m4900p(byteArrayOutputStream, i2);
                AbstractC1113Y9.m4900p(byteArrayOutputStream, c0790r8.f2345e);
                i = i + 4 + (c0790r8.f2345e * 2);
                m8599C(byteArrayOutputStream, c0790r8);
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i == byteArray.length) {
            C0035Ap c0035Ap = new C0035Ap(EnumC0893Ta.CLASSES, i, byteArray, true);
            byteArrayOutputStream.close();
            return c0035Ap;
        }
        throw AbstractC1113Y9.m4887c("Expected size " + i + ", does not match actual size " + byteArray.length);
    }

    public static C0035Ap m8615d(C0790R8[] c0790r8Arr) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        int i = 0;
        for (int i2 = 0; i2 < c0790r8Arr.length; i2++) {
            try {
                C0790R8 c0790r8 = c0790r8Arr[i2];
                int iM8612a = m8612a(c0790r8);
                byte[] bArrM8616e = m8616e(c0790r8);
                byte[] bArrM8617f = m8617f(c0790r8);
                AbstractC1113Y9.m4900p(byteArrayOutputStream, i2);
                int length = bArrM8616e.length + 2 + bArrM8617f.length;
                AbstractC1113Y9.m4901q(byteArrayOutputStream, length);
                AbstractC1113Y9.m4900p(byteArrayOutputStream, iM8612a);
                byteArrayOutputStream.write(bArrM8616e);
                byteArrayOutputStream.write(bArrM8617f);
                i = i + 6 + length;
            } catch (Throwable th) {
                try {
                    byteArrayOutputStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        if (i == byteArray.length) {
            C0035Ap c0035Ap = new C0035Ap(EnumC0893Ta.METHODS, i, byteArray, true);
            byteArrayOutputStream.close();
            return c0035Ap;
        }
        throw AbstractC1113Y9.m4887c("Expected size " + i + ", does not match actual size " + byteArray.length);
    }

    public static byte[] m8616e(C0790R8 c0790r8) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m8604H(byteArrayOutputStream, c0790r8);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static byte[] m8617f(C0790R8 c0790r8) throws IOException {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        try {
            m8605I(byteArrayOutputStream, c0790r8);
            byte[] byteArray = byteArrayOutputStream.toByteArray();
            byteArrayOutputStream.close();
            return byteArray;
        } catch (Throwable th) {
            try {
                byteArrayOutputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static String m8618g(String str, String str2) {
        return "!".equals(str2) ? str.replace(":", "!") : ":".equals(str2) ? str.replace("!", ":") : str;
    }

    public static String m8619h(String str) {
        int iIndexOf = str.indexOf("!");
        if (iIndexOf < 0) {
            iIndexOf = str.indexOf(":");
        }
        return iIndexOf > 0 ? str.substring(iIndexOf + 1) : str;
    }

    public static C0790R8 m8620i(C0790R8[] c0790r8Arr, String str) {
        if (c0790r8Arr.length <= 0) {
            return null;
        }
        String strM8619h = m8619h(str);
        for (int i = 0; i < c0790r8Arr.length; i++) {
            if (c0790r8Arr[i].f2342b.equals(strM8619h)) {
                return c0790r8Arr[i];
            }
        }
        return null;
    }

    public static String m8621j(String str, String str2, byte[] bArr) {
        String strM8792a = AbstractC2111nj.m8792a(bArr);
        if (str.length() <= 0) {
            return m8618g(str2, strM8792a);
        }
        if (str2.equals("classes.dex")) {
            return str;
        }
        if (str2.contains("!") || str2.contains(":")) {
            return m8618g(str2, strM8792a);
        }
        if (str2.endsWith(".apk")) {
            return str2;
        }
        return str + AbstractC2111nj.m8792a(bArr) + str2;
    }

    public static int m8622k(int i) {
        return m8636y(i * 2) / 8;
    }

    public static int m8623l(int i, int i2, int i3) {
        if (i == 1) {
            throw AbstractC1113Y9.m4887c("HOT methods are not stored in the bitmap");
        }
        if (i == 2) {
            return i2;
        }
        if (i == 4) {
            return i2 + i3;
        }
        throw AbstractC1113Y9.m4887c("Unexpected flag: " + i);
    }

    public static int[] m8624m(InputStream inputStream, int i) {
        int[] iArr = new int[i];
        int iM4892h = 0;
        for (int i2 = 0; i2 < i; i2++) {
            iM4892h += AbstractC1113Y9.m4892h(inputStream);
            iArr[i2] = iM4892h;
        }
        return iArr;
    }

    public static int m8625n(BitSet bitSet, int i, int i2) {
        int i3 = bitSet.get(m8623l(2, i, i2)) ? 2 : 0;
        return bitSet.get(m8623l(4, i, i2)) ? i3 | 4 : i3;
    }

    public static byte[] m8626o(InputStream inputStream, byte[] bArr) {
        if (Arrays.equals(bArr, AbstractC1113Y9.m4888d(inputStream, bArr.length))) {
            return AbstractC1113Y9.m4888d(inputStream, AbstractC2111nj.f6468b.length);
        }
        throw AbstractC1113Y9.m4887c("Invalid magic");
    }

    public static void m8627p(InputStream inputStream, C0790R8 c0790r8) {
        int iAvailable = inputStream.available() - c0790r8.f2346f;
        int iM4892h = 0;
        while (inputStream.available() > iAvailable) {
            iM4892h += AbstractC1113Y9.m4892h(inputStream);
            c0790r8.f2349i.put(Integer.valueOf(iM4892h), 1);
            for (int iM4892h2 = AbstractC1113Y9.m4892h(inputStream); iM4892h2 > 0; iM4892h2--) {
                m8597A(inputStream);
            }
        }
        if (inputStream.available() != iAvailable) {
            throw AbstractC1113Y9.m4887c("Read too much data during profile line parse");
        }
    }

    public static C0790R8[] m8628q(InputStream inputStream, byte[] bArr, byte[] bArr2, C0790R8[] c0790r8Arr) {
        if (Arrays.equals(bArr, AbstractC2111nj.f6472f)) {
            if (Arrays.equals(AbstractC2111nj.f6467a, bArr2)) {
                throw AbstractC1113Y9.m4887c("Requires new Baseline Profile Metadata. Please rebuild the APK with Android Gradle Plugin 7.2 Canary 7 or higher");
            }
            return m8629r(inputStream, bArr, c0790r8Arr);
        }
        if (Arrays.equals(bArr, AbstractC2111nj.f6473g)) {
            return m8631t(inputStream, bArr2, c0790r8Arr);
        }
        throw AbstractC1113Y9.m4887c("Unsupported meta version");
    }

    public static C0790R8[] m8629r(InputStream inputStream, byte[] bArr, C0790R8[] c0790r8Arr) throws IOException {
        if (!Arrays.equals(bArr, AbstractC2111nj.f6472f)) {
            throw AbstractC1113Y9.m4887c("Unsupported meta version");
        }
        int iM4894j = AbstractC1113Y9.m4894j(inputStream);
        byte[] bArrM4889e = AbstractC1113Y9.m4889e(inputStream, (int) AbstractC1113Y9.m4893i(inputStream), (int) AbstractC1113Y9.m4893i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC1113Y9.m4887c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM4889e);
        try {
            C0790R8[] c0790r8ArrM8630s = m8630s(byteArrayInputStream, iM4894j, c0790r8Arr);
            byteArrayInputStream.close();
            return c0790r8ArrM8630s;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C0790R8[] m8630s(InputStream inputStream, int i, C0790R8[] c0790r8Arr) {
        if (inputStream.available() == 0) {
            return new C0790R8[0];
        }
        if (i != c0790r8Arr.length) {
            throw AbstractC1113Y9.m4887c("Mismatched number of dex files found in metadata");
        }
        String[] strArr = new String[i];
        int[] iArr = new int[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iM4892h = AbstractC1113Y9.m4892h(inputStream);
            iArr[i2] = AbstractC1113Y9.m4892h(inputStream);
            strArr[i2] = AbstractC1113Y9.m4890f(inputStream, iM4892h);
        }
        for (int i3 = 0; i3 < i; i3++) {
            C0790R8 c0790r8 = c0790r8Arr[i3];
            if (!c0790r8.f2342b.equals(strArr[i3])) {
                throw AbstractC1113Y9.m4887c("Order of dexfiles in metadata did not match baseline");
            }
            int i4 = iArr[i3];
            c0790r8.f2345e = i4;
            c0790r8.f2348h = m8624m(inputStream, i4);
        }
        return c0790r8Arr;
    }

    public static C0790R8[] m8631t(InputStream inputStream, byte[] bArr, C0790R8[] c0790r8Arr) throws IOException {
        int iM4892h = AbstractC1113Y9.m4892h(inputStream);
        byte[] bArrM4889e = AbstractC1113Y9.m4889e(inputStream, (int) AbstractC1113Y9.m4893i(inputStream), (int) AbstractC1113Y9.m4893i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC1113Y9.m4887c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM4889e);
        try {
            C0790R8[] c0790r8ArrM8632u = m8632u(byteArrayInputStream, bArr, iM4892h, c0790r8Arr);
            byteArrayInputStream.close();
            return c0790r8ArrM8632u;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C0790R8[] m8632u(InputStream inputStream, byte[] bArr, int i, C0790R8[] c0790r8Arr) {
        if (inputStream.available() == 0) {
            return new C0790R8[0];
        }
        if (i != c0790r8Arr.length) {
            throw AbstractC1113Y9.m4887c("Mismatched number of dex files found in metadata");
        }
        for (int i2 = 0; i2 < i; i2++) {
            AbstractC1113Y9.m4892h(inputStream);
            String strM4890f = AbstractC1113Y9.m4890f(inputStream, AbstractC1113Y9.m4892h(inputStream));
            long jM4893i = AbstractC1113Y9.m4893i(inputStream);
            int iM4892h = AbstractC1113Y9.m4892h(inputStream);
            C0790R8 c0790r8M8620i = m8620i(c0790r8Arr, strM4890f);
            if (c0790r8M8620i == null) {
                throw AbstractC1113Y9.m4887c("Missing profile key: " + strM4890f);
            }
            c0790r8M8620i.f2344d = jM4893i;
            int[] iArrM8624m = m8624m(inputStream, iM4892h);
            if (Arrays.equals(bArr, AbstractC2111nj.f6471e)) {
                c0790r8M8620i.f2345e = iM4892h;
                c0790r8M8620i.f2348h = iArrM8624m;
            }
        }
        return c0790r8Arr;
    }

    public static void m8633v(InputStream inputStream, C0790R8 c0790r8) {
        BitSet bitSetValueOf = BitSet.valueOf(AbstractC1113Y9.m4888d(inputStream, AbstractC1113Y9.m4885a(c0790r8.f2347g * 2)));
        int i = 0;
        while (true) {
            int i2 = c0790r8.f2347g;
            if (i >= i2) {
                return;
            }
            int iM8625n = m8625n(bitSetValueOf, i, i2);
            if (iM8625n != 0) {
                Integer num = (Integer) c0790r8.f2349i.get(Integer.valueOf(i));
                if (num == null) {
                    num = 0;
                }
                c0790r8.f2349i.put(Integer.valueOf(i), Integer.valueOf(iM8625n | num.intValue()));
            }
            i++;
        }
    }

    public static C0790R8[] m8634w(InputStream inputStream, byte[] bArr, String str) throws IOException {
        if (!Arrays.equals(bArr, AbstractC2111nj.f6468b)) {
            throw AbstractC1113Y9.m4887c("Unsupported version");
        }
        int iM4894j = AbstractC1113Y9.m4894j(inputStream);
        byte[] bArrM4889e = AbstractC1113Y9.m4889e(inputStream, (int) AbstractC1113Y9.m4893i(inputStream), (int) AbstractC1113Y9.m4893i(inputStream));
        if (inputStream.read() > 0) {
            throw AbstractC1113Y9.m4887c("Content found after the end of file");
        }
        ByteArrayInputStream byteArrayInputStream = new ByteArrayInputStream(bArrM4889e);
        try {
            C0790R8[] c0790r8ArrM8635x = m8635x(byteArrayInputStream, str, iM4894j);
            byteArrayInputStream.close();
            return c0790r8ArrM8635x;
        } catch (Throwable th) {
            try {
                byteArrayInputStream.close();
            } catch (Throwable th2) {
                th.addSuppressed(th2);
            }
            throw th;
        }
    }

    public static C0790R8[] m8635x(InputStream inputStream, String str, int i) {
        if (inputStream.available() == 0) {
            return new C0790R8[0];
        }
        C0790R8[] c0790r8Arr = new C0790R8[i];
        for (int i2 = 0; i2 < i; i2++) {
            int iM4892h = AbstractC1113Y9.m4892h(inputStream);
            int iM4892h2 = AbstractC1113Y9.m4892h(inputStream);
            c0790r8Arr[i2] = new C0790R8(str, AbstractC1113Y9.m4890f(inputStream, iM4892h), AbstractC1113Y9.m4893i(inputStream), 0L, iM4892h2, (int) AbstractC1113Y9.m4893i(inputStream), (int) AbstractC1113Y9.m4893i(inputStream), new int[iM4892h2], new TreeMap());
        }
        for (int i3 = 0; i3 < i; i3++) {
            C0790R8 c0790r8 = c0790r8Arr[i3];
            m8627p(inputStream, c0790r8);
            c0790r8.f2348h = m8624m(inputStream, c0790r8.f2345e);
            m8633v(inputStream, c0790r8);
        }
        return c0790r8Arr;
    }

    public static int m8636y(int i) {
        return (i + 7) & (-8);
    }

    public static void m8637z(byte[] bArr, int i, int i2, C0790R8 c0790r8) {
        int iM8623l = m8623l(i, i2, c0790r8.f2347g);
        int i3 = iM8623l / 8;
        bArr[i3] = (byte) ((1 << (iM8623l % 8)) | bArr[i3]);
    }
}
