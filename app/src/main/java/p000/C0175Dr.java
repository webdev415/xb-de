package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import java.util.Iterator;

/* loaded from: classes.dex */
public final class C0175Dr extends AbstractC0552M implements Iterable {
    public static final Creator<C0175Dr> CREATOR = new C0359Hr();

    public final Bundle f435l;

    public C0175Dr(Bundle bundle) {
        this.f435l = bundle;
    }

    public final int m783d() {
        return this.f435l.size();
    }

    public final Double m784g(String str) {
        return Double.valueOf(this.f435l.getDouble(str));
    }

    public final Bundle m785h() {
        return new Bundle(this.f435l);
    }

    public final Long m786i(String str) {
        return Long.valueOf(this.f435l.getLong(str));
    }

    @Override
    public final Iterator iterator() {
        return new C0451Jr(this);
    }

    public final Object m787k(String str) {
        return this.f435l.get(str);
    }

    public final String m788o(String str) {
        return this.f435l.getString(str);
    }

    public final String toString() {
        return this.f435l.toString();
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8185e(parcel, 2, m785h(), false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
