package p000;

import android.content.Context;
import android.media.AudioManager;

/* loaded from: classes.dex */
public class C0462K1 {

    public static C0462K1 f1509e;

    public AudioManager f1510a;

    public int f1511b = 3;

    public int f1512c = 0;

    public int f1513d = 2;

    public static C0462K1 m2249b() {
        if (f1509e == null) {
            f1509e = new C0462K1();
        }
        return f1509e;
    }

    public int m2250a() {
        return (m2251c() * 100) / m2252d();
    }

    public int m2251c() {
        return this.f1510a.getStreamVolume(this.f1511b);
    }

    public int m2252d() {
        return this.f1510a.getStreamMaxVolume(this.f1511b);
    }

    public void m2253e(Context context) {
        this.f1510a = (AudioManager) context.getSystemService("audio");
    }

    public int m2254f(int i) {
        int iCeil = (int) Math.ceil(i * m2252d() * 0.01d);
        if (iCeil <= 0) {
            iCeil = 0;
        }
        if (iCeil >= 100) {
            iCeil = 100;
        }
        this.f1510a.setStreamVolume(this.f1511b, iCeil, 0);
        return m2250a();
    }
}
