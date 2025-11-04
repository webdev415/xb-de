package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0312Gq extends AbstractC0552M {
    public static final Creator<C0312Gq> CREATOR = new C0588Mq();

    public final Bundle f990l;

    public C0312Gq(Bundle bundle) {
        this.f990l = bundle;
    }

    @Override
    public final void writeToParcel(Parcel parcel, int i) {
        int iM8181a = AbstractC1929jl.m8181a(parcel);
        AbstractC1929jl.m8185e(parcel, 1, this.f990l, false);
        AbstractC1929jl.m8182b(parcel, iM8181a);
    }
}
