package p000;

import android.content.SharedPreferences;

/* loaded from: classes.dex */
public final class C2541wy {

    public final String f7922a;

    public boolean f7923b;

    public String f7924c;

    public final C1755fy f7925d;

    public C2541wy(C1755fy c1755fy, String str, String str2) {
        this.f7925d = c1755fy;
        AbstractC1085Xi.m4795d(str);
        this.f7922a = str;
    }

    public final String m10620a() {
        if (!this.f7923b) {
            this.f7923b = true;
            this.f7924c = this.f7925d.m7664J().getString(this.f7922a, null);
        }
        return this.f7924c;
    }

    public final void m10621b(String str) {
        SharedPreferences.Editor editorEdit = this.f7925d.m7664J().edit();
        editorEdit.putString(this.f7922a, str);
        editorEdit.apply();
        this.f7924c = str;
    }
}
