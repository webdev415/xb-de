package p000;

import java.util.List;

/* loaded from: classes.dex */
public final class C1796gs extends AbstractC1935jr {
    @Override
    public final InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list) {
        if (str == null || str.isEmpty() || !c2357sy.m9635g(str)) {
            throw new IllegalArgumentException(String.format("Command not found: %s", str));
        }
        InterfaceC0909Tq interfaceC0909TqM9629a = c2357sy.m9629a(str);
        if (interfaceC0909TqM9629a instanceof AbstractC0450Jq) {
            return ((AbstractC0450Jq) interfaceC0909TqM9629a).mo1366b(c2357sy, list);
        }
        throw new IllegalArgumentException(String.format("Function %s is not defined", str));
    }
}
