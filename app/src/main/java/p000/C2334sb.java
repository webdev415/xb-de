package p000;

import android.content.Context;
import android.text.TextUtils;

/* loaded from: classes.dex */
public final class C2334sb {

    public final String f7032a;

    public final String f7033b;

    public final String f7034c;

    public final String f7035d;

    public final String f7036e;

    public final String f7037f;

    public final String f7038g;

    public C2334sb(String str, String str2, String str3, String str4, String str5, String str6, String str7) {
        AbstractC1085Xi.m4805n(!AbstractC0124Cm.m508a(str), "ApplicationId must be set.");
        this.f7033b = str;
        this.f7032a = str2;
        this.f7034c = str3;
        this.f7035d = str4;
        this.f7036e = str5;
        this.f7037f = str6;
        this.f7038g = str7;
    }

    public static C2334sb m9538a(Context context) {
        C2667zm c2667zm = new C2667zm(context);
        String strM11042a = c2667zm.m11042a("google_app_id");
        if (TextUtils.isEmpty(strM11042a)) {
            return null;
        }
        return new C2334sb(strM11042a, c2667zm.m11042a("google_api_key"), c2667zm.m11042a("firebase_database_url"), c2667zm.m11042a("ga_trackingId"), c2667zm.m11042a("gcm_defaultSenderId"), c2667zm.m11042a("google_storage_bucket"), c2667zm.m11042a("project_id"));
    }

    public String m9539b() {
        return this.f7032a;
    }

    public String m9540c() {
        return this.f7033b;
    }

    public String m9541d() {
        return this.f7036e;
    }

    public String m9542e() {
        return this.f7038g;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof C2334sb)) {
            return false;
        }
        C2334sb c2334sb = (C2334sb) obj;
        return AbstractC0257Fh.m1255a(this.f7033b, c2334sb.f7033b) && AbstractC0257Fh.m1255a(this.f7032a, c2334sb.f7032a) && AbstractC0257Fh.m1255a(this.f7034c, c2334sb.f7034c) && AbstractC0257Fh.m1255a(this.f7035d, c2334sb.f7035d) && AbstractC0257Fh.m1255a(this.f7036e, c2334sb.f7036e) && AbstractC0257Fh.m1255a(this.f7037f, c2334sb.f7037f) && AbstractC0257Fh.m1255a(this.f7038g, c2334sb.f7038g);
    }

    public int hashCode() {
        return AbstractC0257Fh.m1256b(this.f7033b, this.f7032a, this.f7034c, this.f7035d, this.f7036e, this.f7037f, this.f7038g);
    }

    public String toString() {
        return AbstractC0257Fh.m1257c(this).m1258a("applicationId", this.f7033b).m1258a("apiKey", this.f7032a).m1258a("databaseUrl", this.f7034c).m1258a("gcmSenderId", this.f7036e).m1258a("storageBucket", this.f7037f).m1258a("projectId", this.f7038g).toString();
    }
}
