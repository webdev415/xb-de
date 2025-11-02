package p000;

import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;

public final class C0573Mb implements Parcelable {
    public static final Creator<C0573Mb> CREATOR = new a();

    public final String f1808l;

    public final String f1809m;

    public final boolean f1810n;

    public final int f1811o;

    public final int f1812p;

    public final String f1813q;

    public final boolean f1814r;

    public final boolean f1815s;

    public final boolean f1816t;

    public final Bundle f1817u;

    public final boolean f1818v;

    public final int f1819w;

    public Bundle f1820x;

    public static class a implements Creator {
        @Override
        public C0573Mb createFromParcel(Parcel parcel) {
            return new C0573Mb(parcel);
        }

        @Override
        public C0573Mb[] newArray(int i) {
            return new C0573Mb[i];
        }
    }

    public C0573Mb(Parcel parcel) {
        this.f1808l = parcel.readString();
        this.f1809m = parcel.readString();
        this.f1810n = parcel.readInt() != 0;
        this.f1811o = parcel.readInt();
        this.f1812p = parcel.readInt();
        this.f1813q = parcel.readString();
        this.f1814r = parcel.readInt() != 0;
        this.f1815s = parcel.readInt() != 0;
        this.f1816t = parcel.readInt() != 0;
        this.f1817u = parcel.readBundle();
        this.f1818v = parcel.readInt() != 0;
        this.f1820x = parcel.readBundle();
        this.f1819w = parcel.readInt();
    }

    public AbstractComponentCallbacksC0159Db m2853a(ClassLoader classLoader, C0297Gb c0297Gb) {
        Bundle bundle = this.f1817u;
        if (bundle != null) {
            bundle.setClassLoader(classLoader);
        }
        c0297Gb.mo1376a(classLoader, this.f1808l);
        throw null;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("FragmentState{");
        sb.append(this.f1808l);
        sb.append(" (");
        sb.append(this.f1809m);
        sb.append(")}:");
        if (this.f1810n) {
            sb.append(" fromLayout");
        }
        if (this.f1812p != 0) {
            sb.append(" id=0x");
            sb.append(Integer.toHexString(this.f1812p));
        }
        String str = this.f1813q;
        if (str != null && !str.isEmpty()) {
            sb.append(" tag=");
            sb.append(this.f1813q);
        }
        if (this.f1814r) {
            sb.append(" retainInstance");
        }
        if (this.f1815s) {
            sb.append(" removing");
        }
        if (this.f1816t) {
            sb.append(" detached");
        }
        if (this.f1818v) {
            sb.append(" hidden");
        }
        return sb.toString();
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(this.f1808l);
        parcel.writeString(this.f1809m);
        parcel.writeInt(this.f1810n ? 1 : 0);
        parcel.writeInt(this.f1811o);
        parcel.writeInt(this.f1812p);
        parcel.writeString(this.f1813q);
        parcel.writeInt(this.f1814r ? 1 : 0);
        parcel.writeInt(this.f1815s ? 1 : 0);
        parcel.writeInt(this.f1816t ? 1 : 0);
        parcel.writeBundle(this.f1817u);
        parcel.writeInt(this.f1818v ? 1 : 0);
        parcel.writeBundle(this.f1820x);
        parcel.writeInt(this.f1819w);
    }
}
