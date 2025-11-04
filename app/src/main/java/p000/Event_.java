package p000;

import android.os.Bundle;
import android.text.TextUtils;
import java.util.Iterator;

public final class Event_ {

    public final String appId;

    public final String name;

    public final String f8283c;

    public final long f8284d;

    public final long f8285e;

    public final C0175Dr params;

    public Event_(C2266qz c2266qz, String str, String str2, String str3, long j, long j2, Bundle bundle) {
        C0175Dr c0175Dr;
        AbstractC1085Xi.m4795d(str2);
        AbstractC1085Xi.m4795d(str3);
        this.appId = str2;
        this.name = str3;
        this.f8283c = TextUtils.isEmpty(str) ? null : str;
        this.f8284d = j;
        this.f8285e = j2;
        if (j2 != 0 && j2 > j) {
            c2266qz.mo349g().m9623L().m10617b("Event created with reverse previous/current timestamps. appId", C2356sx.m9613v(str2));
        }
        if (bundle == null || bundle.isEmpty()) {
            c0175Dr = new C0175Dr(new Bundle());
        } else {
            Bundle bundle2 = new Bundle(bundle);
            Iterator<String> it = bundle2.keySet().iterator();
            while (it.hasNext()) {
                String next = it.next();
                if (next == null) {
                    c2266qz.mo349g().m9618G().m10616a("Param name can't be null");
                } else {
                    Object objM10518s0 = c2266qz.m9230L().m10518s0(next, bundle2.get(next));
                    if (objM10518s0 == null) {
                        c2266qz.mo349g().m9623L().m10617b("Param value can't be null", c2266qz.m9222D().m9212f(next));
                    } else {
                        c2266qz.m9230L().m10491O(bundle2, next, objM10518s0);
                    }
                }
                it.remove();
            }
            c0175Dr = new C0175Dr(bundle2);
        }
        this.params = c0175Dr;
    }

    public final Event_ m11051a(C2266qz c2266qz, long j) {
        return new Event_(c2266qz, this.f8283c, this.appId, this.name, this.f8284d, j, this.params);
    }

    public final String toString() {
        return "Event{appId='" + this.appId + "', name='" + this.name + "', params=" + this.params + "}";
    }

    public Event_(C2266qz c2266qz, String str, String str2, String str3, long j, long j2, C0175Dr c0175Dr) {
        AbstractC1085Xi.m4795d(str2);
        AbstractC1085Xi.m4795d(str3);
        AbstractC1085Xi.m4801j(c0175Dr);
        this.appId = str2;
        this.name = str3;
        this.f8283c = TextUtils.isEmpty(str) ? null : str;
        this.f8284d = j;
        this.f8285e = j2;
        if (j2 != 0 && j2 > j) {
            c2266qz.mo349g().m9623L().m10618c("Event created with reverse previous/current timestamps. appId, name", C2356sx.m9613v(str2), C2356sx.m9613v(str3));
        }
        this.params = c0175Dr;
    }
}
