package p000;

import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;

/* loaded from: classes.dex */
public final class C0660OF {

    public static final Uri f2016f = new Uri.Builder().scheme("content").authority("com.google.android.gms.chimera").build();

    public final String f2017a;

    public final String f2018b;

    public final ComponentName f2019c;

    public final int f2020d;

    public final boolean f2021e;

    public C0660OF(String str, String str2, int i, boolean z) {
        AbstractC1085Xi.m4795d(str);
        this.f2017a = str;
        AbstractC1085Xi.m4795d(str2);
        this.f2018b = str2;
        this.f2019c = null;
        this.f2020d = 4225;
        this.f2021e = z;
    }

    public final ComponentName m3389a() {
        return this.f2019c;
    }

    public final Intent m3390b(Context context) {
        Bundle bundleCall;
        if (this.f2017a == null) {
            return new Intent().setComponent(this.f2019c);
        }
        if (this.f2021e) {
            Bundle bundle = new Bundle();
            bundle.putString("serviceActionBundleKey", this.f2017a);
            try {
                bundleCall = context.getContentResolver().call(f2016f, "serviceIntentCall", (String) null, bundle);
            } catch (IllegalArgumentException e) {
                Log.w("ConnectionStatusConfig", "Dynamic intent resolution failed: ".concat(e.toString()));
                bundleCall = null;
            }
            intent = bundleCall != null ? (Intent) bundleCall.getParcelable("serviceResponseIntentKey") : null;
            if (intent == null) {
                Log.w("ConnectionStatusConfig", "Dynamic lookup for intent failed for action: ".concat(String.valueOf(this.f2017a)));
            }
        }
        return intent == null ? new Intent(this.f2017a).setPackage(this.f2018b) : intent;
    }

    public final String m3391c() {
        return this.f2018b;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof C0660OF)) {
            return false;
        }
        C0660OF c0660of = (C0660OF) obj;
        return AbstractC0257Fh.m1255a(this.f2017a, c0660of.f2017a) && AbstractC0257Fh.m1255a(this.f2018b, c0660of.f2018b) && AbstractC0257Fh.m1255a(this.f2019c, c0660of.f2019c) && this.f2021e == c0660of.f2021e;
    }

    public final int hashCode() {
        return AbstractC0257Fh.m1256b(this.f2017a, this.f2018b, this.f2019c, 4225, Boolean.valueOf(this.f2021e));
    }

    public final String toString() {
        String str = this.f2017a;
        if (str != null) {
            return str;
        }
        AbstractC1085Xi.m4801j(this.f2019c);
        return this.f2019c.flattenToString();
    }
}
