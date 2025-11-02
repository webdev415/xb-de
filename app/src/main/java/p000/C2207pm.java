package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.YuvImage;
import java.io.ByteArrayOutputStream;

/* loaded from: classes.dex */
public class C2207pm {

    public C1178Zj f6648a;

    public int f6649b;

    public int f6650c;

    public Rect f6651d;

    public int f6652e = 1;

    public boolean f6653f;

    public C2207pm(byte[] bArr, int i, int i2, int i3, int i4) {
        this.f6648a = new C1178Zj(bArr, i, i2);
        this.f6650c = i4;
        this.f6649b = i3;
        if (i * i2 <= bArr.length) {
            return;
        }
        throw new IllegalArgumentException("Image data does not match the resolution. " + i + "x" + i2 + " > " + bArr.length);
    }

    public C0718Pi m9074a() {
        C1178Zj c1178ZjM5056a = this.f6648a.m5060h(this.f6650c).m5056a(this.f6651d, this.f6652e);
        return new C0718Pi(c1178ZjM5056a.m5057b(), c1178ZjM5056a.m5059d(), c1178ZjM5056a.m5058c(), 0, 0, c1178ZjM5056a.m5059d(), c1178ZjM5056a.m5058c(), false);
    }

    public Bitmap m9075b(Rect rect, int i) {
        if (rect == null) {
            rect = new Rect(0, 0, this.f6648a.m5059d(), this.f6648a.m5058c());
        } else if (m9076c()) {
            rect = new Rect(rect.top, rect.left, rect.bottom, rect.right);
        }
        YuvImage yuvImage = new YuvImage(this.f6648a.m5057b(), this.f6649b, this.f6648a.m5059d(), this.f6648a.m5058c(), null);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        yuvImage.compressToJpeg(rect, 90, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inSampleSize = i;
        Bitmap bitmapDecodeByteArray = BitmapFactory.decodeByteArray(byteArray, 0, byteArray.length, options);
        if (this.f6650c == 0) {
            return bitmapDecodeByteArray;
        }
        Matrix matrix = new Matrix();
        matrix.postRotate(this.f6650c);
        return Bitmap.createBitmap(bitmapDecodeByteArray, 0, 0, bitmapDecodeByteArray.getWidth(), bitmapDecodeByteArray.getHeight(), matrix, false);
    }

    public boolean m9076c() {
        return this.f6650c % 180 != 0;
    }

    public void m9077d(Rect rect) {
        this.f6651d = rect;
    }

    public void m9078e(boolean z) {
        this.f6653f = z;
    }

    public C0857Sk m9079f(C0857Sk c0857Sk) {
        float fM4067c = (c0857Sk.m4067c() * this.f6652e) + this.f6651d.left;
        float fM4068d = (c0857Sk.m4068d() * this.f6652e) + this.f6651d.top;
        if (this.f6653f) {
            fM4067c = this.f6648a.m5059d() - fM4067c;
        }
        return new C0857Sk(fM4067c, fM4068d);
    }
}
