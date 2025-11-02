package p000;

import java.util.NoSuchElementException;

/* loaded from: classes.dex */
public abstract class AbstractC0138D extends AbstractC2209po {

    public b f327l = b.NOT_READY;

    public Object f328m;

    public static class a {

        public static final int[] f329a;

        static {
            int[] iArr = new int[b.values().length];
            f329a = iArr;
            try {
                iArr[b.DONE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f329a[b.READY.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
        }
    }

    public enum b {
        READY,
        NOT_READY,
        DONE,
        FAILED
    }

    public abstract Object mo588b();

    public final Object m589c() {
        this.f327l = b.DONE;
        return null;
    }

    public final boolean m590d() {
        this.f327l = b.FAILED;
        this.f328m = mo588b();
        if (this.f327l == b.DONE) {
            return false;
        }
        this.f327l = b.READY;
        return true;
    }

    @Override
    public final boolean hasNext() {
        AbstractC1131Yi.m4978n(this.f327l != b.FAILED);
        int i = a.f329a[this.f327l.ordinal()];
        if (i == 1) {
            return false;
        }
        if (i != 2) {
            return m590d();
        }
        return true;
    }

    @Override
    public final Object next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        this.f327l = b.NOT_READY;
        Object objM306a = AbstractC0073Bh.m306a(this.f328m);
        this.f328m = null;
        return objM306a;
    }
}
