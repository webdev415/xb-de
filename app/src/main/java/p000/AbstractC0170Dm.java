package p000;

public abstract class AbstractC0170Dm {
    public static void m733a(Appendable appendable, Object obj, InterfaceC0986Vb interfaceC0986Vb) {
        CharSequence charSequenceValueOf;
        AbstractC0116Ce.m476e(appendable, "<this>");
        if (interfaceC0986Vb == null) {
            if (!(obj == null ? true : obj instanceof CharSequence)) {
                if (obj instanceof Character) {
                    appendable.append(((Character) obj).charValue());
                    return;
                }
                charSequenceValueOf = String.valueOf(obj);
            }
            appendable.append(charSequenceValueOf);
        }
        obj = interfaceC0986Vb.mo15n(obj);
        charSequenceValueOf = (CharSequence) obj;
        appendable.append(charSequenceValueOf);
    }
}
