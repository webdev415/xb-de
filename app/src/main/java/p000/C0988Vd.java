package p000;

import android.app.Activity;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.util.DisplayMetrics;
import com.xbrowser.play.R;
import java.io.IOException;

/* loaded from: classes.dex */
public class C0988Vd {

    public static C0988Vd f2965c;

    public Activity f2966a = null;

    public float f2967b;

    public interface b {
        void mo4400a(byte[] bArr);

        void mo4401b();
    }

    public static C0988Vd m4391d() {
        if (f2965c == null) {
            f2965c = new C0988Vd();
        }
        return f2965c;
    }

    public void m4392a(String str, String str2, b bVar) {
        new OkHttpClient().m2004y(new C0122Ck.a().m507i(str).m500b()).mo1791i(new a(bVar));
    }

    public final int m4393b(String str, String str2) {
        return Color.parseColor(new String[]{"#FF3399", "#339900", "#FF9933", "#f12f4b", "#990099", "#CE6D39", "#AF4034", "#379392", "#006666", "#0066cc", "#FFBC42", "#0099CC", "#0077b8", "#9055A2", "#0079ba", "#285943", "#3F4B3B", "#ed6a30", "#F6B352", "#25b39d", "#f12f4b", "#4670e9", "#548687", "#16A085"}[str.charAt(0) % 23]);
    }

    public Bitmap m4394c(String str, String str2) {
        int dimensionPixelSize = this.f2966a.getResources().getDimensionPixelSize(R.dimen.icon_size);
        int iM4393b = m4393b(str, str2);
        Bitmap bitmapCreateBitmap = Bitmap.createBitmap(dimensionPixelSize, dimensionPixelSize, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmapCreateBitmap);
        Paint paint = new Paint();
        paint.setColor(iM4393b);
        paint.setStyle(Paint.Style.FILL);
        float f = dimensionPixelSize;
        canvas.drawRect(0.0f, 0.0f, f, f, paint);
        paint.setColor(-1);
        paint.setTextSize(this.f2966a.getResources().getDimensionPixelSize(R.dimen.text_size));
        paint.setTextAlign(Paint.Align.CENTER);
        float f2 = f / 2.0f;
        canvas.drawText(str.charAt(0) + "", f2, f2 - ((paint.ascent() + paint.descent()) / 2.0f), paint);
        return bitmapCreateBitmap;
    }

    public void m4395e(Activity activity) {
        this.f2966a = activity;
        DisplayMetrics displayMetrics = new DisplayMetrics();
        activity.getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        this.f2967b = displayMetrics.density;
    }

    public Bitmap m4396f(String str) {
        return m4397g(str, 1.0f);
    }

    public Bitmap m4397g(String str, float f) {
        if (!FileUtils.fileExists(str)) {
            return null;
        }
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inJustDecodeBounds = true;
        this.f2966a.getWindowManager().getDefaultDisplay().getMetrics(new DisplayMetrics());
        options.inScaled = true;
        options.inTargetDensity = 160;
        options.inDensity = (int) (f * 160.0f);
        options.inJustDecodeBounds = false;
        return BitmapFactory.decodeFile(str, options);
    }

    public Drawable m4398h(String str, float f, int i) {
        Bitmap bitmapM4397g = m4397g(str, f);
        if (bitmapM4397g != null) {
            return i == 0 ? new C0327H4(bitmapM4397g) : i == 1 ? new C1227al(bitmapM4397g, this.f2967b * 5.0f) : new BitmapDrawable(bitmapM4397g);
        }
        return null;
    }

    public Drawable m4399i(String str, int i) {
        return m4398h(str, 1.0f, i);
    }

    public class a implements InterfaceC0556M3 {

        public final b f2968a;

        public a(b bVar) {
            this.f2968a = bVar;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            try {
                String strM2399p = c0490Kk.m2399p("Content-Type");
                if (strM2399p == null || !strM2399p.startsWith("image/")) {
                    b bVar = this.f2968a;
                    if (bVar != null) {
                        bVar.mo4401b();
                    }
                } else {
                    b bVar2 = this.f2968a;
                    if (bVar2 != null) {
                        bVar2.mo4400a(c0490Kk.m2392a().m2709b());
                    }
                }
                c0490Kk.m2392a().close();
            } catch (Exception unused) {
            }
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
        }
    }
}
