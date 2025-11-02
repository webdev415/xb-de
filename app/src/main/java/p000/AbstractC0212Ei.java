package p000;

import android.database.DataSetObservable;
import android.database.DataSetObserver;
import android.os.Parcelable;
import android.view.View;
import android.view.ViewGroup;

/* loaded from: classes.dex */
public abstract class AbstractC0212Ei {

    public final DataSetObservable f526a = new DataSetObservable();

    public DataSetObserver f527b;

    public abstract void mo1042a(ViewGroup viewGroup, int i, Object obj);

    public void m1044c(ViewGroup viewGroup) {
        m1043b(viewGroup);
    }

    public abstract int mo1045d();

    public int m1046e(Object obj) {
        return -1;
    }

    public float m1047f(int i) {
        return 1.0f;
    }

    public abstract Object mo1048g(ViewGroup viewGroup, int i);

    public abstract boolean mo1049h(View view, Object obj);

    public void m1050i() {
        synchronized (this) {
            try {
                DataSetObserver dataSetObserver = this.f527b;
                if (dataSetObserver != null) {
                    dataSetObserver.onChanged();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        this.f526a.notifyChanged();
    }

    public Parcelable m1052k() {
        return null;
    }

    public void m1054m(ViewGroup viewGroup, int i, Object obj) {
        m1053l(viewGroup, i, obj);
    }

    public void m1055n(DataSetObserver dataSetObserver) {
        synchronized (this) {
            this.f527b = dataSetObserver;
        }
    }

    public void m1057p(ViewGroup viewGroup) {
        m1056o(viewGroup);
    }

    public void m1043b(View view) {
    }

    public void m1056o(View view) {
    }

    public void m1051j(Parcelable parcelable, ClassLoader classLoader) {
    }

    public void m1053l(View view, int i, Object obj) {
    }
}
