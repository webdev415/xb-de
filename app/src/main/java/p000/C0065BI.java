package p000;

import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Pair;

/* loaded from: classes.dex */
public final class C0065BI {

    public final C2266qz f154a;

    public C0065BI(C2266qz c2266qz) {
        this.f154a = c2266qz;
    }

    public final void m233a() {
        this.f154a.mo354l().mo356n();
        if (m236d()) {
            if (m237e()) {
                this.f154a.m9224F().f5574y.m10621b(null);
                Bundle bundle = new Bundle();
                bundle.putString("source", "(not set)");
                bundle.putString("medium", "(not set)");
                bundle.putString("_cis", "intent");
                bundle.putLong("_cc", 1L);
                this.f154a.m9226H().m5166a1("auto", "_cmpx", bundle);
            } else {
                String strM10620a = this.f154a.m9224F().f5574y.m10620a();
                if (TextUtils.isEmpty(strM10620a)) {
                    this.f154a.mo349g().m9620I().m10616a("Cache still valid but referrer not found");
                } else {
                    long jM9085a = ((this.f154a.m9224F().f5575z.m9085a() / 3600000) - 1) * 3600000;
                    Uri uri = Uri.parse(strM10620a);
                    Bundle bundle2 = new Bundle();
                    Pair pair = new Pair(uri.getPath(), bundle2);
                    for (String str : uri.getQueryParameterNames()) {
                        bundle2.putString(str, uri.getQueryParameter(str));
                    }
                    ((Bundle) pair.second).putLong("_cc", jM9085a);
                    Object obj = pair.first;
                    this.f154a.m9226H().m5166a1(obj == null ? "app" : (String) obj, "_cmp", (Bundle) pair.second);
                }
                this.f154a.m9224F().f5574y.m10621b(null);
            }
            this.f154a.m9224F().f5575z.m9086b(0L);
        }
    }

    public final void m234b(String str, Bundle bundle) {
        String string;
        this.f154a.mo354l().mo356n();
        if (this.f154a.m9242p()) {
            return;
        }
        if (bundle == null || bundle.isEmpty()) {
            string = null;
        } else {
            if (str == null || str.isEmpty()) {
                str = "auto";
            }
            Uri.Builder builder = new Uri.Builder();
            builder.path(str);
            for (String str2 : bundle.keySet()) {
                builder.appendQueryParameter(str2, bundle.getString(str2));
            }
            string = builder.build().toString();
        }
        if (TextUtils.isEmpty(string)) {
            return;
        }
        this.f154a.m9224F().f5574y.m10621b(string);
        this.f154a.m9224F().f5575z.m9086b(this.f154a.mo345b().mo2815a());
    }

    public final void m235c() {
        if (m236d() && m237e()) {
            this.f154a.m9224F().f5574y.m10621b(null);
        }
    }

    public final boolean m236d() {
        return this.f154a.m9224F().f5575z.m9085a() > 0;
    }

    public final boolean m237e() {
        return m236d() && this.f154a.mo345b().mo2815a() - this.f154a.m9224F().f5575z.m9085a() > this.f154a.m9252z().m10793C(null, AbstractC0818Rr.f2473W);
    }
}
