package p000;

import android.content.SharedPreferences;
import android.util.Pair;

/* loaded from: classes.dex */
public final class C2126ny {

    public final String f6481a;

    public final String f6482b;

    public final String f6483c;

    public final long f6484d;

    public final C1755fy f6485e;

    public C2126ny(C1755fy c1755fy, String str, long j) {
        this.f6485e = c1755fy;
        AbstractC1085Xi.m4795d(str);
        AbstractC1085Xi.m4792a(j > 0);
        this.f6481a = str + ":start";
        this.f6482b = str + ":count";
        this.f6483c = str + ":value";
        this.f6484d = j;
    }

    public final Pair m8810a() {
        long jAbs;
        this.f6485e.mo356n();
        this.f6485e.mo356n();
        long jM8812c = m8812c();
        if (jM8812c == 0) {
            m8813d();
            jAbs = 0;
        } else {
            jAbs = Math.abs(jM8812c - this.f6485e.mo345b().mo2815a());
        }
        long j = this.f6484d;
        if (jAbs < j) {
            return null;
        }
        if (jAbs > (j << 1)) {
            m8813d();
            return null;
        }
        String string = this.f6485e.m7664J().getString(this.f6483c, null);
        long j2 = this.f6485e.m7664J().getLong(this.f6482b, 0L);
        m8813d();
        return (string == null || j2 <= 0) ? C1755fy.f5550B : new Pair(string, Long.valueOf(j2));
    }

    public final void m8811b(String str, long j) {
        this.f6485e.mo356n();
        if (m8812c() == 0) {
            m8813d();
        }
        if (str == null) {
            str = "";
        }
        long j2 = this.f6485e.m7664J().getLong(this.f6482b, 0L);
        if (j2 <= 0) {
            SharedPreferences.Editor editorEdit = this.f6485e.m7664J().edit();
            editorEdit.putString(this.f6483c, str);
            editorEdit.putLong(this.f6482b, 1L);
            editorEdit.apply();
            return;
        }
        long j3 = j2 + 1;
        boolean z = (this.f6485e.mo352j().m10505W0().nextLong() & Long.MAX_VALUE) < Long.MAX_VALUE / j3;
        SharedPreferences.Editor editorEdit2 = this.f6485e.m7664J().edit();
        if (z) {
            editorEdit2.putString(this.f6483c, str);
        }
        editorEdit2.putLong(this.f6482b, j3);
        editorEdit2.apply();
    }

    public final long m8812c() {
        return this.f6485e.m7664J().getLong(this.f6481a, 0L);
    }

    public final void m8813d() {
        this.f6485e.mo356n();
        long jMo2815a = this.f6485e.mo345b().mo2815a();
        SharedPreferences.Editor editorEdit = this.f6485e.m7664J().edit();
        editorEdit.remove(this.f6482b);
        editorEdit.remove(this.f6483c);
        editorEdit.putLong(this.f6481a, jMo2815a);
        editorEdit.apply();
    }
}
