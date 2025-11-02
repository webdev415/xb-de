package p000;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Iterator;
import java.util.List;

/* loaded from: classes.dex */
public final class C0036Aq implements InterfaceC0909Tq {

    public final Double f90l;

    public C0036Aq(Double d) {
        if (d == null) {
            this.f90l = Double.valueOf(Double.NaN);
        } else {
            this.f90l = d;
        }
    }

    @Override
    public final InterfaceC0909Tq mo151c() {
        return new C0036Aq(this.f90l);
    }

    @Override
    public final Boolean mo152d() {
        return Boolean.valueOf((Double.isNaN(this.f90l.doubleValue()) || this.f90l.doubleValue() == 0.0d) ? false : true);
    }

    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (obj instanceof C0036Aq) {
            return this.f90l.equals(((C0036Aq) obj).f90l);
        }
        return false;
    }

    @Override
    public final Double mo153f() {
        return this.f90l;
    }

    @Override
    public final String mo154h() throws NumberFormatException {
        if (Double.isNaN(this.f90l.doubleValue())) {
            return "NaN";
        }
        if (Double.isInfinite(this.f90l.doubleValue())) {
            return this.f90l.doubleValue() > 0.0d ? "Infinity" : "-Infinity";
        }
        BigDecimal bigDecimalValueOf = BigDecimal.valueOf(this.f90l.doubleValue());
        BigDecimal bigDecimal = bigDecimalValueOf.signum() == 0 ? new BigDecimal(BigInteger.ZERO, 0) : AbstractC2671zq.m11050a(bigDecimalValueOf);
        DecimalFormat decimalFormat = new DecimalFormat("0E0");
        decimalFormat.setRoundingMode(RoundingMode.HALF_UP);
        decimalFormat.setMinimumFractionDigits((bigDecimal.scale() > 0 ? bigDecimal.precision() : bigDecimal.scale()) - 1);
        String str = decimalFormat.format(bigDecimal);
        int iIndexOf = str.indexOf("E");
        if (iIndexOf <= 0) {
            return str;
        }
        int i = Integer.parseInt(str.substring(iIndexOf + 1));
        return ((i >= 0 || i <= -7) && (i < 0 || i >= 21)) ? str.replace("E-", "e-").replace("E", "e+") : bigDecimal.toPlainString();
    }

    public final int hashCode() {
        return this.f90l.hashCode();
    }

    @Override
    public final Iterator mo155i() {
        return null;
    }

    @Override
    public final InterfaceC0909Tq mo156o(String str, C2357sy c2357sy, List list) {
        if ("toString".equals(str)) {
            return new C1093Xq(mo154h());
        }
        throw new IllegalArgumentException(String.format("%s.%s is not a function.", mo154h(), str));
    }

    public final String toString() {
        return mo154h();
    }
}
