package p000;

import android.content.Context;
import android.content.pm.PackageInfo;
import android.content.pm.Signature;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/* loaded from: classes.dex */
public abstract class AbstractC0874T0 {
    public static byte[] m4082a(Context context, String str) {
        MessageDigest messageDigestM4083b;
        PackageInfo packageInfoM10890c = C2670zp.m11048a(context).m10890c(str, 64);
        Signature[] signatureArr = packageInfoM10890c.signatures;
        if (signatureArr == null || signatureArr.length != 1 || (messageDigestM4083b = m4083b("SHA1")) == null) {
            return null;
        }
        return messageDigestM4083b.digest(packageInfoM10890c.signatures[0].toByteArray());
    }

    public static MessageDigest m4083b(String str) throws NoSuchAlgorithmException {
        MessageDigest messageDigest;
        for (int i = 0; i < 2; i++) {
            try {
                messageDigest = MessageDigest.getInstance(str);
            } catch (NoSuchAlgorithmException unused) {
            }
            if (messageDigest != null) {
                return messageDigest;
            }
        }
        return null;
    }
}
