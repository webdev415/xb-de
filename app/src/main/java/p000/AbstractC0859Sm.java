package p000;

import java.io.Serializable;
import java.util.Objects;

/* loaded from: classes.dex */
public abstract class AbstractC0859Sm {

    public static class a implements InterfaceC0813Rm, Serializable {

        public final InterfaceC0813Rm f2665l;

        public volatile transient boolean f2666m;

        public transient Object f2667n;

        public a(InterfaceC0813Rm interfaceC0813Rm) {
            this.f2665l = (InterfaceC0813Rm) AbstractC1131Yi.m4973i(interfaceC0813Rm);
        }

        @Override
        public Object get() {
            if (!this.f2666m) {
                synchronized (this) {
                    try {
                        if (!this.f2666m) {
                            Object obj = this.f2665l.get();
                            this.f2667n = obj;
                            this.f2666m = true;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC0119Ch.m488a(this.f2667n);
        }

        public String toString() {
            Object string;
            if (this.f2666m) {
                String strValueOf = String.valueOf(this.f2667n);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(strValueOf);
                sb.append(">");
                string = sb.toString();
            } else {
                string = this.f2665l;
            }
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(strValueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class b implements InterfaceC0813Rm {

        public volatile InterfaceC0813Rm f2668l;

        public volatile boolean f2669m;

        public Object f2670n;

        public b(InterfaceC0813Rm interfaceC0813Rm) {
            this.f2668l = (InterfaceC0813Rm) AbstractC1131Yi.m4973i(interfaceC0813Rm);
        }

        @Override
        public Object get() {
            if (!this.f2669m) {
                synchronized (this) {
                    try {
                        if (!this.f2669m) {
                            InterfaceC0813Rm interfaceC0813Rm = this.f2668l;
                            Objects.requireNonNull(interfaceC0813Rm);
                            Object obj = interfaceC0813Rm.get();
                            this.f2670n = obj;
                            this.f2669m = true;
                            this.f2668l = null;
                            return obj;
                        }
                    } finally {
                    }
                }
            }
            return AbstractC0119Ch.m488a(this.f2670n);
        }

        public String toString() {
            Object string = this.f2668l;
            if (string == null) {
                String strValueOf = String.valueOf(this.f2670n);
                StringBuilder sb = new StringBuilder(strValueOf.length() + 25);
                sb.append("<supplier that returned ");
                sb.append(strValueOf);
                sb.append(">");
                string = sb.toString();
            }
            String strValueOf2 = String.valueOf(string);
            StringBuilder sb2 = new StringBuilder(strValueOf2.length() + 19);
            sb2.append("Suppliers.memoize(");
            sb2.append(strValueOf2);
            sb2.append(")");
            return sb2.toString();
        }
    }

    public static class c implements InterfaceC0813Rm, Serializable {

        public final Object f2671l;

        public c(Object obj) {
            this.f2671l = obj;
        }

        public boolean equals(Object obj) {
            if (obj instanceof c) {
                return AbstractC0303Gh.m1398a(this.f2671l, ((c) obj).f2671l);
            }
            return false;
        }

        @Override
        public Object get() {
            return this.f2671l;
        }

        public int hashCode() {
            return AbstractC0303Gh.m1399b(this.f2671l);
        }

        public String toString() {
            String strValueOf = String.valueOf(this.f2671l);
            StringBuilder sb = new StringBuilder(strValueOf.length() + 22);
            sb.append("Suppliers.ofInstance(");
            sb.append(strValueOf);
            sb.append(")");
            return sb.toString();
        }
    }

    public static InterfaceC0813Rm m4071a(InterfaceC0813Rm interfaceC0813Rm) {
        return ((interfaceC0813Rm instanceof b) || (interfaceC0813Rm instanceof a)) ? interfaceC0813Rm : interfaceC0813Rm instanceof Serializable ? new a(interfaceC0813Rm) : new b(interfaceC0813Rm);
    }

    public static InterfaceC0813Rm m4072b(Object obj) {
        return new c(obj);
    }
}
