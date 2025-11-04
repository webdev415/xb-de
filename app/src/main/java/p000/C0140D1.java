package p000;

import android.content.Context;
import android.net.Uri;
import android.text.TextUtils;
import android.util.Log;
import java.util.HashMap;

public class C0140D1 implements InterfaceC0094C1 {

    public Context f340a;

    public C0232F1 f341b;

    public C0278G1 f342c;

    public C0140D1(Context context) {
        this.f341b = null;
        this.f342c = null;
        this.f340a = context;
        this.f341b = C0232F1.m1169l().m1178n(this.f340a);
        this.f342c = new C0278G1(this.f340a);
    }

    @Override
    public void mo364a(String str, boolean z, InterfaceC2229q7 interfaceC2229q7, HashMap map) {
        if (TextUtils.isEmpty(str)) {
            Log.e("mbrowser", "the url is empty");
            return;
        }
        String scheme = Uri.parse(str).getScheme();
        if (scheme.equals("http") || scheme.equals("https")) {
            this.f341b.mo364a(str, z, interfaceC2229q7, map);
        } else {
            if (scheme.equals("file")) {
                throw new IllegalStateException("now this sechme is not support yet");
            }
            if (!scheme.equals("content")) {
                throw new IllegalStateException("now this sechme is not support yet");
            }
            this.f342c.mo364a(str, z, interfaceC2229q7, map);
        }
    }
}
