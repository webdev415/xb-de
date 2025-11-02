package p000;

/* loaded from: classes.dex */
public class C0945Ug extends C0606N7 {

    public boolean f2861c;

    public C0945Ug(InterfaceC1226ak interfaceC1226ak) {
        super(interfaceC1226ak);
        this.f2861c = true;
    }

    @Override
    public BinaryBitmap mo1696e(AbstractC1784gg abstractC1784gg) {
        if (this.f2861c) {
            this.f2861c = false;
            return new BinaryBitmap(new HybridBinarizer(abstractC1784gg.mo1971e()));
        }
        this.f2861c = true;
        return new BinaryBitmap(new HybridBinarizer(abstractC1784gg));
    }
}
