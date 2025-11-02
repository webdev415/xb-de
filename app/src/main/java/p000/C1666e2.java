package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import androidx.lifecycle.AbstractC1255c;
import java.util.ArrayList;
import p000.AbstractC0619Nb;

public final class C1666e2 implements Parcelable {
    public static final Creator<C1666e2> CREATOR = new a();

    public final int[] f5361l;

    public final ArrayList f5362m;

    public final int[] f5363n;

    public final int[] f5364o;

    public final int f5365p;

    public final int f5366q;

    public final String f5367r;

    public final int f5368s;

    public final int f5369t;

    public final CharSequence f5370u;

    public final int f5371v;

    public final CharSequence f5372w;

    public final ArrayList f5373x;

    public final ArrayList f5374y;

    public final boolean f5375z;

    public static class a implements Creator {
        @Override
        public C1666e2 createFromParcel(Parcel parcel) {
            return new C1666e2(parcel);
        }

        @Override
        public C1666e2[] newArray(int i) {
            return new C1666e2[i];
        }
    }

    public C1666e2(Parcel parcel) {
        this.f5361l = parcel.createIntArray();
        this.f5362m = parcel.createStringArrayList();
        this.f5363n = parcel.createIntArray();
        this.f5364o = parcel.createIntArray();
        this.f5365p = parcel.readInt();
        this.f5366q = parcel.readInt();
        this.f5367r = parcel.readString();
        this.f5368s = parcel.readInt();
        this.f5369t = parcel.readInt();
        Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.f5370u = (CharSequence) creator.createFromParcel(parcel);
        this.f5371v = parcel.readInt();
        this.f5372w = (CharSequence) creator.createFromParcel(parcel);
        this.f5373x = parcel.createStringArrayList();
        this.f5374y = parcel.createStringArrayList();
        this.f5375z = parcel.readInt() != 0;
    }

    public C1620d2 m7383a(LayoutInflaterFactory2C0435Jb layoutInflaterFactory2C0435Jb) {
        C1620d2 c1620d2 = new C1620d2(layoutInflaterFactory2C0435Jb);
        int i = 0;
        int i2 = 0;
        while (i < this.f5361l.length) {
            AbstractC0619Nb.a aVar = new AbstractC0619Nb.a();
            int i3 = i + 1;
            aVar.f1947a = this.f5361l[i];
            if (LayoutInflaterFactory2C0435Jb.f1323F) {
                Log.v("FragmentManager", "Instantiate " + c1620d2 + " op #" + i2 + " base fragment #" + this.f5361l[i3]);
            }
            String str = (String) this.f5362m.get(i2);
            if (str != null) {
                AbstractC2524wh.m10586a(layoutInflaterFactory2C0435Jb.f1335g.get(str));
            }
            aVar.f1952f = AbstractC1255c.b.values()[this.f5363n[i2]];
            aVar.f1953g = AbstractC1255c.b.values()[this.f5364o[i2]];
            int[] iArr = this.f5361l;
            int i4 = iArr[i3];
            aVar.f1948b = i4;
            int i5 = iArr[i + 2];
            aVar.f1949c = i5;
            int i6 = i + 4;
            int i7 = iArr[i + 3];
            aVar.f1950d = i7;
            i += 5;
            int i8 = iArr[i6];
            aVar.f1951e = i8;
            c1620d2.f1930b = i4;
            c1620d2.f1931c = i5;
            c1620d2.f1932d = i7;
            c1620d2.f1933e = i8;
            c1620d2.m3316b(aVar);
            i2++;
        }
        c1620d2.f1934f = this.f5365p;
        c1620d2.f1935g = this.f5366q;
        c1620d2.f1938j = this.f5367r;
        c1620d2.f5269u = this.f5368s;
        c1620d2.f1936h = true;
        c1620d2.f1939k = this.f5369t;
        c1620d2.f1940l = this.f5370u;
        c1620d2.f1941m = this.f5371v;
        c1620d2.f1942n = this.f5372w;
        c1620d2.f1943o = this.f5373x;
        c1620d2.f1944p = this.f5374y;
        c1620d2.f1945q = this.f5375z;
        c1620d2.m7280c(1);
        return c1620d2;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.f5361l);
        parcel.writeStringList(this.f5362m);
        parcel.writeIntArray(this.f5363n);
        parcel.writeIntArray(this.f5364o);
        parcel.writeInt(this.f5365p);
        parcel.writeInt(this.f5366q);
        parcel.writeString(this.f5367r);
        parcel.writeInt(this.f5368s);
        parcel.writeInt(this.f5369t);
        TextUtils.writeToParcel(this.f5370u, parcel, 0);
        parcel.writeInt(this.f5371v);
        TextUtils.writeToParcel(this.f5372w, parcel, 0);
        parcel.writeStringList(this.f5373x);
        parcel.writeStringList(this.f5374y);
        parcel.writeInt(this.f5375z ? 1 : 0);
    }
}
