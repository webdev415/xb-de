package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

public class C0327H4 extends Drawable {

    public final Paint f1014a;

    public final int f1015b;

    public final Bitmap f1016c;

    public C0327H4(Bitmap bitmap) {
        this.f1016c = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.f1014a = paint;
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        this.f1015b = Math.min(bitmap.getWidth(), bitmap.getHeight());
    }

    @Override
    public void draw(Canvas canvas) {
        int i = this.f1015b;
        canvas.drawCircle(i / 2, i / 2, i / 2, this.f1014a);
    }

    @Override
    public int getIntrinsicHeight() {
        return this.f1015b;
    }

    @Override
    public int getIntrinsicWidth() {
        return this.f1015b;
    }

    @Override
    public int getOpacity() {
        return -3;
    }

    @Override
    public void setAlpha(int i) {
        this.f1014a.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        this.f1014a.setColorFilter(colorFilter);
    }
}
