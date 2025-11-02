package p000;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public class C0606N7 implements InterfaceC0903Tk {

    public InterfaceC1226ak f1907a;

    public List f1908b = new ArrayList<>();

    public C0606N7(InterfaceC1226ak interfaceC1226ak) {
        this.f1907a = interfaceC1226ak;
    }

    @Override
    public void mo3293a(C0857Sk c0857Sk) {
        this.f1908b.add(c0857Sk);
    }

    public C0720Pk m3294b(BinaryBitmap binaryBitmap) {
        this.f1908b.clear();
        try {
            InterfaceC1226ak interfaceC1226ak = this.f1907a;
            if (interfaceC1226ak instanceof QRCodeReader) {
                C0720Pk c0720PkM5922e = ((QRCodeReader) interfaceC1226ak).m5922e(binaryBitmap);
                this.f1907a.mo140c();
                return c0720PkM5922e;
            }
            C0720Pk c0720PkMo138a = interfaceC1226ak.decode(binaryBitmap);
            this.f1907a.mo140c();
            return c0720PkMo138a;
        } catch (Exception unused) {
            this.f1907a.mo140c();
            return null;
        } catch (Throwable th) {
            this.f1907a.mo140c();
            throw th;
        }
    }

    public C0720Pk m3295c(AbstractC1784gg abstractC1784gg) {
        return m3294b(mo1696e(abstractC1784gg));
    }

    public List m3296d() {
        return new ArrayList<>(this.f1908b);
    }

    public BinaryBitmap mo1696e(AbstractC1784gg abstractC1784gg) {
        return new BinaryBitmap(new HybridBinarizer(abstractC1784gg));
    }
}
