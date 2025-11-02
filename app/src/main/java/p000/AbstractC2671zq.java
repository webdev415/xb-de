package p000;

import java.math.BigDecimal;
import java.math.BigInteger;

/* loaded from: classes.dex */
public abstract class AbstractC2671zq {
    public static BigDecimal m11050a(BigDecimal bigDecimal) {
        return bigDecimal.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : bigDecimal.stripTrailingZeros();
    }
}
