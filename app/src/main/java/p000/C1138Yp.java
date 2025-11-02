package p000;

import android.net.Uri;
import java.util.Map;

public final class C1138Yp extends Thread {

    public final Map f3364l;

    public C1138Yp(C2636z0 c2636z0, Map map) {
        this.f3364l = map;
    }

    @Override
    public final void run() {
        Map map = this.f3364l;
        Uri.Builder builderBuildUpon = Uri.parse("https://pagead2.googlesyndication.com/pagead/gen_204?id=gmob-apps").buildUpon();
        for (String str : map.keySet()) {
            builderBuildUpon.appendQueryParameter(str, (String) map.get(str));
        }
        AbstractC0360Hs.m1620a(builderBuildUpon.build().toString());
    }
}
