package p000;

/* loaded from: classes.dex */
public abstract class AbstractC1785gh {
    public static boolean m7738a(InterfaceC1738fh interfaceC1738fh, Object obj) {
        if (obj == interfaceC1738fh) {
            return true;
        }
        if (obj instanceof InterfaceC1738fh) {
            return interfaceC1738fh.mo1311a().equals(((InterfaceC1738fh) obj).mo1311a());
        }
        return false;
    }
}
