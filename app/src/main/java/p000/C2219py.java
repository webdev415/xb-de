package p000;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class C2219py {

    public final String f6657a;

    public final long f6658b;

    public boolean f6659c;

    public long f6660d;

    public final C1755fy f6661e;

    public C2219py(C1755fy c1755fy, String str, long j) {
        this.f6661e = c1755fy;
        AbstractC1085Xi.m4795d(str);
        this.f6657a = str;
        this.f6658b = j;
    }

    public final long m9085a() {
        if (!this.f6659c) {
            this.f6659c = true;
            this.f6660d = this.f6661e.m7664J().getLong(this.f6657a, this.f6658b);
        }
        return this.f6660d;
    }

    public final void m9086b(long j) {
        SharedPreferences.Editor editorEdit = this.f6661e.m7664J().edit();
        editorEdit.putLong(this.f6657a, j);
        editorEdit.apply();
        this.f6660d = j;
    }
}
