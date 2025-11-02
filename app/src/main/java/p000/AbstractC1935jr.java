package p000;

import java.util.ArrayList;
import java.util.List;

/* loaded from: classes.dex */
public abstract class AbstractC1935jr {

    public final List f5966a = new ArrayList<>();

    public final InterfaceC0909Tq m8207a(String str) {
        if (!this.f5966a.contains(AbstractC1145Yw.m4998e(str))) {
            throw new IllegalArgumentException("Command not supported");
        }
        throw new UnsupportedOperationException("Command not implemented: " + str);
    }

    public abstract InterfaceC0909Tq mo160b(String str, C2357sy c2357sy, List list);
}
