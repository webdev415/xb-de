package p000;

import android.content.Context;
import android.view.KeyEvent;
import android.widget.Checkable;

/* loaded from: classes.dex */
public class C2000l9 extends C1954k9 implements Checkable {
    public C2000l9(Context context) {
        super(context);
    }

    @Override
    public boolean isChecked() {
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            return ((Checkable) childAt).isChecked();
        }
        return false;
    }

    @Override
    public void setChecked(boolean z) {
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).setChecked(z);
        }
    }

    @Override
    public void toggle() {
        KeyEvent.Callback childAt = getChildAt(0);
        if (childAt instanceof Checkable) {
            ((Checkable) childAt).toggle();
        }
    }
}
