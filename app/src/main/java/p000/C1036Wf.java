package p000;

import java.io.FileDescriptor;
import java.io.PrintWriter;
import p000.C0632No;

public class C1036Wf extends AbstractC0990Vf {

    public final InterfaceC0623Nf f3065a;

    public final a f3066b;

    public static class a extends AbstractC0586Mo {

        public static final C0632No.a f3067f = new C2701a();

        public C2253qm f3068d = new C2253qm();

        public boolean f3069e = false;

        public static class C2701a implements C0632No.a {
            @Override
            public AbstractC0586Mo mo2655a(Class cls) {
                return new a();
            }
        }

        public static a m4502e(C0678Oo c0678Oo) {
            return (a) new C0632No(c0678Oo, f3067f).m3330a(a.class);
        }

        @Override
        public void mo2653c() {
            super.mo2653c();
            if (this.f3068d.m9172m() <= 0) {
                this.f3068d.m9164a();
            } else {
                AbstractC2524wh.m10586a(this.f3068d.m9173n(0));
                throw null;
            }
        }

        public void m4503d(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
            if (this.f3068d.m9172m() > 0) {
                printWriter.print(str);
                printWriter.println("Loaders:");
                StringBuilder sb = new StringBuilder();
                sb.append(str);
                sb.append("    ");
                if (this.f3068d.m9172m() <= 0) {
                    return;
                }
                AbstractC2524wh.m10586a(this.f3068d.m9173n(0));
                printWriter.print(str);
                printWriter.print("  #");
                printWriter.print(this.f3068d.m9169f(0));
                printWriter.print(": ");
                throw null;
            }
        }
    }

    public C1036Wf(InterfaceC0623Nf interfaceC0623Nf, C0678Oo c0678Oo) {
        this.f3065a = interfaceC0623Nf;
        this.f3066b = a.m4502e(c0678Oo);
    }

    @Override
    public void mo4404a(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr) {
        this.f3066b.m4503d(str, fileDescriptor, printWriter, strArr);
    }

    public String toString() {
        StringBuilder sb = new StringBuilder(128);
        sb.append("LoaderManager{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append(" in ");
        AbstractC2551x7.m10630a(this.f3065a, sb);
        sb.append("}}");
        return sb.toString();
    }
}
