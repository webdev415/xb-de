package p000;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC0389Ib {

    public static final C0297Gb f1151b = new C0297Gb();

    public C0297Gb f1152a = null;

    public abstract void mo1688a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public C0297Gb mo1689b() {
        if (this.f1152a == null) {
            this.f1152a = f1151b;
        }
        return this.f1152a;
    }

    public abstract List mo1690c();

    public void m1691d(C0297Gb c0297Gb) {
        this.f1152a = c0297Gb;
    }
}
