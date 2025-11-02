package p000;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.SparseIntArray;

public class C0218Eo extends AbstractC0172Do {

    public final SparseIntArray f537d;

    public final Parcel f538e;

    public final int f539f;

    public final int f540g;

    public final String f541h;

    public int f542i;

    public int f543j;

    public int f544k;

    public C0218Eo(Parcel parcel) {
        this(parcel, parcel.dataPosition(), parcel.dataSize(), "", new C2453v1(), new C2453v1(), new C2453v1());
    }

    @Override
    public void mo736A(byte[] bArr) {
        if (bArr == null) {
            this.f538e.writeInt(-1);
        } else {
            this.f538e.writeInt(bArr.length);
            this.f538e.writeByteArray(bArr);
        }
    }

    @Override
    public void mo738C(CharSequence charSequence) {
        TextUtils.writeToParcel(charSequence, this.f538e, 0);
    }

    @Override
    public void mo740E(int i) {
        this.f538e.writeInt(i);
    }

    @Override
    public void mo742G(Parcelable parcelable) {
        this.f538e.writeParcelable(parcelable, 0);
    }

    @Override
    public void mo744I(String str) {
        this.f538e.writeString(str);
    }

    @Override
    public void mo750a() {
        int i = this.f542i;
        if (i >= 0) {
            int i2 = this.f537d.get(i);
            int iDataPosition = this.f538e.dataPosition();
            this.f538e.setDataPosition(i2);
            this.f538e.writeInt(iDataPosition - i2);
            this.f538e.setDataPosition(iDataPosition);
        }
    }

    @Override
    public AbstractC0172Do mo751b() {
        Parcel parcel = this.f538e;
        int iDataPosition = parcel.dataPosition();
        int i = this.f543j;
        if (i == this.f539f) {
            i = this.f540g;
        }
        return new C0218Eo(parcel, iDataPosition, i, this.f541h + "  ", this.f430a, this.f431b, this.f432c);
    }

    @Override
    public boolean mo756g() {
        return this.f538e.readInt() != 0;
    }

    @Override
    public byte[] mo758i() {
        int i = this.f538e.readInt();
        if (i < 0) {
            return null;
        }
        byte[] bArr = new byte[i];
        this.f538e.readByteArray(bArr);
        return bArr;
    }

    @Override
    public CharSequence mo760k() {
        return (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(this.f538e);
    }

    @Override
    public boolean mo762m(int i) {
        while (this.f543j < this.f540g) {
            int i2 = this.f544k;
            if (i2 == i) {
                return true;
            }
            if (String.valueOf(i2).compareTo(String.valueOf(i)) > 0) {
                return false;
            }
            this.f538e.setDataPosition(this.f543j);
            int i3 = this.f538e.readInt();
            this.f544k = this.f538e.readInt();
            this.f543j += i3;
        }
        return this.f544k == i;
    }

    @Override
    public int mo764o() {
        return this.f538e.readInt();
    }

    @Override
    public Parcelable mo766q() {
        return this.f538e.readParcelable(getClass().getClassLoader());
    }

    @Override
    public String mo768s() {
        return this.f538e.readString();
    }

    @Override
    public void mo772w(int i) {
        mo750a();
        this.f542i = i;
        this.f537d.put(i, this.f538e.dataPosition());
        mo740E(0);
        mo740E(i);
    }

    @Override
    public void mo774y(boolean z) {
        this.f538e.writeInt(z ? 1 : 0);
    }

    public C0218Eo(Parcel parcel, int i, int i2, String str, C2453v1 c2453v1, C2453v1 c2453v12, C2453v1 c2453v13) {
        super(c2453v1, c2453v12, c2453v13);
        this.f537d = new SparseIntArray();
        this.f542i = -1;
        this.f544k = -1;
        this.f538e = parcel;
        this.f539f = i;
        this.f540g = i2;
        this.f543j = i;
        this.f541h = str;
    }
}
