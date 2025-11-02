package p000;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class C2034ly {

    public final String f6108a;

    public final boolean f6109b;

    public boolean f6110c;

    public boolean f6111d;

    public final C1755fy f6112e;

    public C2034ly(C1755fy c1755fy, String str, boolean z) {
        this.f6112e = c1755fy;
        AbstractC1085Xi.m4795d(str);
        this.f6108a = str;
        this.f6109b = z;
    }

    public final void m8427a(boolean z) {
        SharedPreferences.Editor editorEdit = this.f6112e.m7664J().edit();
        editorEdit.putBoolean(this.f6108a, z);
        editorEdit.apply();
        this.f6111d = z;
    }

    public final boolean m8428b() {
        if (!this.f6110c) {
            this.f6110c = true;
            this.f6111d = this.f6112e.m7664J().getBoolean(this.f6108a, this.f6109b);
        }
        return this.f6111d;
    }
}
