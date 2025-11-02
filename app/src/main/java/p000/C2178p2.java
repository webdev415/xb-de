package p000;

import android.graphics.Bitmap;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

public class C2178p2 {

    public C0720Pk f6610a;

    public C2207pm f6611b;

    public final int f6612c = 2;

    public C2178p2(C0720Pk c0720Pk, C2207pm c2207pm) {
        this.f6610a = c0720Pk;
        this.f6611b = c2207pm;
    }

    public static List m9000e(List list, C2207pm c2207pm) {
        ArrayList arrayList = new ArrayList<>(list.size());
        Iterator it = list.iterator();
        while (it.hasNext()) {
            arrayList.add(c2207pm.m9079f((C0857Sk) it.next()));
        }
        return arrayList;
    }

    public BarcodeFormat m9001a() {
        return this.f6610a.m3576b();
    }

    public Bitmap m9002b() {
        return this.f6611b.m9075b(null, 2);
    }

    public byte[] m9003c() {
        return this.f6610a.m3577c();
    }

    public Map m9004d() {
        return this.f6610a.m3578d();
    }

    public String toString() {
        return this.f6610a.m3580f();
    }
}
