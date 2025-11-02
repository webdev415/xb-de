package p000;

import android.os.Bundle;
import android.text.style.ClickableSpan;
import android.view.View;

/* loaded from: classes.dex */
public final class C0690P extends ClickableSpan {

    public final int f2068l;

    public final C1898j0 f2069m;

    public final int f2070n;

    public C0690P(int i, C1898j0 c1898j0, int i2) {
        this.f2068l = i;
        this.f2069m = c1898j0;
        this.f2070n = i2;
    }

    @Override
    public void onClick(View view) {
        Bundle bundle = new Bundle();
        bundle.putInt("ACCESSIBILITY_CLICKABLE_SPAN_ID", this.f2068l);
        this.f2069m.m8034T(this.f2070n, bundle);
    }
}
