package p000;

import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

/* loaded from: classes.dex */
public class C1227al extends Drawable {

    public final Paint f3551a;

    public final Bitmap f3552b;

    public float f3553c;

    public C1227al(Bitmap bitmap, float f) {
        this.f3552b = bitmap;
        Shader.TileMode tileMode = Shader.TileMode.CLAMP;
        BitmapShader bitmapShader = new BitmapShader(bitmap, tileMode, tileMode);
        Paint paint = new Paint();
        this.f3551a = paint;
        paint.setAntiAlias(true);
        paint.setShader(bitmapShader);
        this.f3553c = f;
    }

    @Override
    public void draw(Canvas canvas) {
        RectF rectF = new RectF(0.0f, 0.0f, this.f3552b.getWidth(), this.f3552b.getHeight());
        float f = this.f3553c;
        canvas.drawRoundRect(rectF, f, f, this.f3551a);
    }

    @Override
    public int getIntrinsicHeight() {
        return this.f3552b.getHeight();
    }

    @Override
    public int getIntrinsicWidth() {
        return this.f3552b.getWidth();
    }

    @Override
    public int getOpacity() {
        return -3;
    }

    @Override
    public void setAlpha(int i) {
        this.f3551a.setAlpha(i);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        this.f3551a.setColorFilter(colorFilter);
    }
}
