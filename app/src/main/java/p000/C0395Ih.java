package p000;

import java.security.cert.Certificate;
import java.security.cert.CertificateParsingException;
import java.security.cert.X509Certificate;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import javax.net.ssl.HostnameVerifier;
import javax.net.ssl.SSLException;
import javax.net.ssl.SSLSession;

/* loaded from: classes.dex */
public final class C0395Ih implements HostnameVerifier {

    public static final C0395Ih f1155a = new C0395Ih();

    public final List m1703a(X509Certificate x509Certificate) throws CertificateParsingException {
        AbstractC0116Ce.m476e(x509Certificate, "certificate");
        return AbstractC2181p5.m9013A(m1704b(x509Certificate, 7), m1704b(x509Certificate, 2));
    }

    public final List m1704b(X509Certificate x509Certificate, int i) throws CertificateParsingException {
        Object obj;
        try {
            Collection<List<?>> subjectAlternativeNames = x509Certificate.getSubjectAlternativeNames();
            if (subjectAlternativeNames == null) {
                return AbstractC1810h5.m7783f();
            }
            ArrayList arrayList = new ArrayList<>();
            for (List<?> list : subjectAlternativeNames) {
                if (list != null && list.size() >= 2 && !(!AbstractC0116Ce.m472a(list.get(0), Integer.valueOf(i))) && (obj = list.get(1)) != null) {
                    arrayList.add((String) obj);
                }
            }
            return arrayList;
        } catch (CertificateParsingException unused) {
            return AbstractC1810h5.m7783f();
        }
    }

    public final boolean m1705c(String str, X509Certificate x509Certificate) {
        AbstractC0116Ce.m476e(str, "host");
        AbstractC0116Ce.m476e(x509Certificate, "certificate");
        return AbstractC2623yo.m10931f(str) ? m1708f(str, x509Certificate) : m1707e(str, x509Certificate);
    }

    public final boolean m1706d(String str, String str2) {
        if (str == null || str.length() == 0 || AbstractC0538Lm.m2731w(str, ".", false, 2, null) || AbstractC0538Lm.m2719k(str, "..", false, 2, null) || str2 == null || str2.length() == 0 || AbstractC0538Lm.m2731w(str2, ".", false, 2, null) || AbstractC0538Lm.m2719k(str2, "..", false, 2, null)) {
            return false;
        }
        if (!AbstractC0538Lm.m2719k(str, ".", false, 2, null)) {
            str = str + ".";
        }
        String str3 = str;
        if (!AbstractC0538Lm.m2719k(str2, ".", false, 2, null)) {
            str2 = str2 + ".";
        }
        Locale locale = Locale.US;
        AbstractC0116Ce.m475d(locale, "Locale.US");
        if (str2 == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str2.toLowerCase(locale);
        AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        if (!AbstractC0584Mm.m2918B(lowerCase, "*", false, 2, null)) {
            return AbstractC0116Ce.m472a(str3, lowerCase);
        }
        if (!AbstractC0538Lm.m2731w(lowerCase, "*.", false, 2, null) || AbstractC0584Mm.m2928L(lowerCase, '*', 1, false, 4, null) != -1 || str3.length() < lowerCase.length() || AbstractC0116Ce.m472a("*.", lowerCase)) {
            return false;
        }
        String strSubstring = lowerCase.substring(1);
        AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.String).substring(startIndex)");
        if (!AbstractC0538Lm.m2719k(str3, strSubstring, false, 2, null)) {
            return false;
        }
        int length = str3.length() - strSubstring.length();
        return length <= 0 || AbstractC0584Mm.m2933Q(str3, '.', length + (-1), false, 4, null) == -1;
    }

    public final boolean m1707e(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        Locale locale = Locale.US;
        AbstractC0116Ce.m475d(locale, "Locale.US");
        if (str == null) {
            throw new NullPointerException("null cannot be cast to non-null type java.lang.String");
        }
        String lowerCase = str.toLowerCase(locale);
        AbstractC0116Ce.m475d(lowerCase, "(this as java.lang.String).toLowerCase(locale)");
        List listM1704b = m1704b(x509Certificate, 2);
        if ((listM1704b instanceof Collection) && listM1704b.isEmpty()) {
            return false;
        }
        Iterator it = listM1704b.iterator();
        while (it.hasNext()) {
            if (f1155a.m1706d(lowerCase, (String) it.next())) {
                return true;
            }
        }
        return false;
    }

    public final boolean m1708f(String str, X509Certificate x509Certificate) throws CertificateParsingException {
        String strM9063e = AbstractC2198pd.m9063e(str);
        List listM1704b = m1704b(x509Certificate, 7);
        if ((listM1704b instanceof Collection) && listM1704b.isEmpty()) {
            return false;
        }
        Iterator it = listM1704b.iterator();
        while (it.hasNext()) {
            if (AbstractC0116Ce.m472a(strM9063e, AbstractC2198pd.m9063e((String) it.next()))) {
                return true;
            }
        }
        return false;
    }

    @Override
    public boolean verify(String str, SSLSession sSLSession) {
        AbstractC0116Ce.m476e(str, "host");
        AbstractC0116Ce.m476e(sSLSession, "session");
        try {
            Certificate certificate = sSLSession.getPeerCertificates()[0];
            if (certificate != null) {
                return m1705c(str, (X509Certificate) certificate);
            }
            throw new NullPointerException("null cannot be cast to non-null type java.security.cert.X509Certificate");
        } catch (SSLException unused) {
            return false;
        }
    }
}
