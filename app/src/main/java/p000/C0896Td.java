package p000;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Base64;
import android.util.LruCache;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.io.ByteArrayOutputStream;

public class C0896Td {

    public static C0896Td f2754b;

    public final LruCache f2755a = new a(Math.max(64, ((int) (Runtime.getRuntime().maxMemory() / 1024)) / 32));

    public class a extends LruCache {
        public a(int i) {
            super(i);
        }

        @Override
        public int sizeOf(String str, Drawable drawable) {
            return 1;
        }
    }

    public static C0896Td m4137c() {
        if (f2754b == null) {
            f2754b = new C0896Td();
        }
        return f2754b;
    }

    public String getIconUri(String str) {
        Bitmap bitmapM4141e = m4141e(NetworkUtils.getFaviconUrl(str));
        if (bitmapM4141e == null) {
            bitmapM4141e = BitmapFactory.decodeResource(BrowserActivity.getActivity().getResources(), R.drawable.ic_earth);
        }
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmapM4141e.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        byte[] byteArray = byteArrayOutputStream.toByteArray();
        StringBuffer stringBuffer = new StringBuffer();
        stringBuffer.append("data:image/png;base64,");
        stringBuffer.append(Base64.encodeToString(byteArray, 2));
        return stringBuffer.toString();
    }

    public final Drawable m4139b(String str) {
        return (Drawable) this.f2755a.get(str);
    }

    public boolean m4140d(String str) {
        String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(str, 10);
        if (strM2046a == null) {
            String host = Uri.parse(str).getHost();
            if (!TextUtils.isEmpty(host) && (strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(host, 10)) == null) {
                String strM458m = NetworkUtils.getDomain(host);
                if (!TextUtils.isEmpty(strM458m)) {
                    strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(strM458m, 10);
                }
            }
        }
        return strM2046a != null;
    }

    public Bitmap m4141e(String str) {
        return C0988Vd.getInstance().m4396f(ResourceCacheManager.getInstance().getUrlOrFilePath(str, 1));
    }

    public Drawable m4142f(String str, String str2, int i) {
        Drawable drawableM4145i = m4145i(str, i);
        if (drawableM4145i == null) {
            drawableM4145i = m4145i(str2, i);
        }
        return drawableM4145i == null ? m4144h(str2, i) : drawableM4145i;
    }

    public Drawable m4143g(String str, float f, int i) {
        String strM4147k = m4147k(str, f, i);
        Drawable drawableM4139b = m4139b(strM4147k);
        if (drawableM4139b != null) {
            return drawableM4139b;
        }
        Drawable drawableM4398h = C0988Vd.getInstance().m4398h(ResourceCacheManager.getInstance().getUrlOrFilePath(str, 1), f, i);
        if (drawableM4398h != null) {
            m4148l(strM4147k, drawableM4398h);
        }
        return drawableM4398h;
    }

    public Drawable m4144h(String str, int i) {
        return m4143g(str, 1.0f, i);
    }

    public Drawable m4145i(String str, int i) {
        String strM4147k = m4147k(str, 1.0f, i);
        Drawable drawableM4139b = m4139b(strM4147k);
        if (drawableM4139b != null) {
            return drawableM4139b;
        }
        Drawable drawableM4398h = C0988Vd.getInstance().m4398h(ResourceCacheManager.getInstance().getUrlOrFilePath(str, 9), 1.0f, i);
        if (drawableM4398h != null) {
            m4148l(strM4147k, drawableM4398h);
        }
        return drawableM4398h;
    }

    public Drawable m4146j(Context context, String str) {
        if (TextUtils.isEmpty(str)) {
            return null;
        }
        return str.equals("x:history") ? context.getResources().getDrawable(R.drawable.ic_fav_history) : str.equals("x:home") ? context.getResources().getDrawable(R.drawable.ic_fav_home) : str.equals("x:settings") ? context.getResources().getDrawable(R.drawable.ic_setting) : str.equals("x:dl") ? context.getResources().getDrawable(R.drawable.ic_fav_download) : str.equals("x:bookmark") ? context.getResources().getDrawable(R.drawable.ic_fav_bookmark) : m4144h(str, 2);
    }

    public final String m4147k(String str, float f, int i) {
        StringBuilder sb = new StringBuilder();
        sb.append(String.valueOf(i));
        sb.append("|");
        sb.append(f);
        sb.append("|");
        if (str == null) {
            str = "";
        }
        sb.append(str);
        return sb.toString();
    }

    public final void m4148l(String str, Drawable drawable) {
        if (str == null || drawable == null || this.f2755a.get(str) != null) {
            return;
        }
        this.f2755a.put(str, drawable);
    }
}
