package p000;

import android.os.Bundle;
import android.text.TextUtils;

public final class C1864iC implements InterfaceC2422uG {

    public final C1207aB f5792a;

    public C1864iC(C1207aB c1207aB) {
        this.f5792a = c1207aB;
    }

    @Override
    public final void mo4024l(String str, String str2, Bundle bundle) {
        if (TextUtils.isEmpty(str)) {
            this.f5792a.m5150R0("auto", str2, bundle);
        } else {
            this.f5792a.m5157W("auto", str2, bundle, str);
        }
    }
}
