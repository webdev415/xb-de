package p000;

import android.content.SharedPreferences;
import android.util.Base64;
import android.util.Log;
import java.security.KeyFactory;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.security.PublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.X509EncodedKeySpec;
import org.json.JSONException;
import org.json.JSONObject;

public class C0942Ud {

    public static final String[] f2857c = {"*", "FCM", "GCM", ""};

    public final SharedPreferences f2858a;

    public final String f2859b;

    public C0942Ud(C1364cb c1364cb) {
        this.f2858a = c1364cb.m5872j().getSharedPreferences("com.google.android.gms.appid", 0);
        this.f2859b = m4252b(c1364cb);
    }

    public static String m4252b(C1364cb c1364cb) {
        String strM9541d = c1364cb.m5874m().m9541d();
        if (strM9541d != null) {
            return strM9541d;
        }
        String strM9540c = c1364cb.m5874m().m9540c();
        if (!strM9540c.startsWith("1:") && !strM9540c.startsWith("2:")) {
            return strM9540c;
        }
        String[] strArrSplit = strM9540c.split(":");
        if (strArrSplit.length != 4) {
            return null;
        }
        String str = strArrSplit[1];
        if (str.isEmpty()) {
            return null;
        }
        return str;
    }

    public static String m4253c(PublicKey publicKey) {
        try {
            byte[] bArrDigest = MessageDigest.getInstance("SHA1").digest(publicKey.getEncoded());
            bArrDigest[0] = (byte) (((bArrDigest[0] & 15) + 112) & 255);
            return Base64.encodeToString(bArrDigest, 0, 8, 11);
        } catch (NoSuchAlgorithmException unused) {
            Log.w("ContentValues", "Unexpected error, device missing required algorithms");
            return null;
        }
    }

    public final String m4254a(String str, String str2) {
        return "|T|" + str + "|" + str2;
    }

    public final String m4255d(String str) {
        try {
            return new JSONObject(str).getString("token");
        } catch (JSONException unused) {
            return null;
        }
    }

    public final PublicKey m4256e(String str) {
        try {
            return KeyFactory.getInstance("RSA").generatePublic(new X509EncodedKeySpec(Base64.decode(str, 8)));
        } catch (IllegalArgumentException | NoSuchAlgorithmException | InvalidKeySpecException e) {
            Log.w("ContentValues", "Invalid key stored " + e);
            return null;
        }
    }

    public String m4257f() {
        synchronized (this.f2858a) {
            try {
                String strM4258g = m4258g();
                if (strM4258g != null) {
                    return strM4258g;
                }
                return m4259h();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final String m4258g() {
        String string;
        synchronized (this.f2858a) {
            string = this.f2858a.getString("|S|id", null);
        }
        return string;
    }

    public final String m4259h() {
        synchronized (this.f2858a) {
            try {
                String string = this.f2858a.getString("|S||P|", null);
                if (string == null) {
                    return null;
                }
                PublicKey publicKeyM4256e = m4256e(string);
                if (publicKeyM4256e == null) {
                    return null;
                }
                return m4253c(publicKeyM4256e);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public String m4260i() {
        synchronized (this.f2858a) {
            try {
                for (String str : f2857c) {
                    String string = this.f2858a.getString(m4254a(this.f2859b, str), null);
                    if (string != null && !string.isEmpty()) {
                        if (string.startsWith("{")) {
                            string = m4255d(string);
                        }
                        return string;
                    }
                }
                return null;
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
