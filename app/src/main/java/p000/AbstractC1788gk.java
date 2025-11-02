package p000;

import java.net.Proxy;

/* loaded from: classes.dex */
public abstract class AbstractC1788gk {

    public static final int[] f5641a;

    static {
        int[] iArr = new int[Proxy.Type.values().length];
        f5641a = iArr;
        iArr[Proxy.Type.DIRECT.ordinal()] = 1;
        iArr[Proxy.Type.HTTP.ordinal()] = 2;
    }
}
