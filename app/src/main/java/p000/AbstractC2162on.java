package p000;

import java.util.Arrays;
import java.util.logging.Logger;

public abstract class AbstractC2162on {
    public static final String m8979b(long j) {
        StringBuilder sb;
        long j2;
        long j3;
        long j4;
        if (j > -999500000) {
            if (j > -999500) {
                if (j <= 0) {
                    sb = new StringBuilder();
                    j4 = j - 500;
                } else if (j < 999500) {
                    sb = new StringBuilder();
                    j4 = j + 500;
                } else if (j < 999500000) {
                    sb = new StringBuilder();
                    j3 = j + 500000;
                } else {
                    sb = new StringBuilder();
                    j2 = j + 500000000;
                }
                sb.append(j4 / 1000);
                sb.append(" µs");
                String string = sb.toString();
                C2621ym c2621ym = C2621ym.f8126a;
                String str = String.format("%6s", Arrays.copyOf(new Object[]{string}, 1));
                AbstractC0116Ce.m475d(str, "java.lang.String.format(format, *args)");
                return str;
            }
            sb = new StringBuilder();
            j3 = j - 500000;
            sb.append(j3 / 1000000);
            sb.append(" ms");
            String string2 = sb.toString();
            C2621ym c2621ym2 = C2621ym.f8126a;
            String str2 = String.format("%6s", Arrays.copyOf(new Object[]{string2}, 1));
            AbstractC0116Ce.m475d(str2, "java.lang.String.format(format, *args)");
            return str2;
        }
        sb = new StringBuilder();
        j2 = j - 500000000;
        sb.append(j2 / 1000000000);
        sb.append(" s ");
        String string22 = sb.toString();
        C2621ym c2621ym22 = C2621ym.f8126a;
        String str22 = String.format("%6s", Arrays.copyOf(new Object[]{string22}, 1));
        AbstractC0116Ce.m475d(str22, "java.lang.String.format(format, *args)");
        return str22;
    }

    public static final void m8980c(AbstractC1791gn abstractC1791gn, C2254qn c2254qn, String str) {
        Logger loggerM9450a = C2300rn.f6965j.m9450a();
        StringBuilder sb = new StringBuilder();
        sb.append(c2254qn.m9180f());
        sb.append(' ');
        C2621ym c2621ym = C2621ym.f8126a;
        String str2 = String.format("%-22s", Arrays.copyOf(new Object[]{str}, 1));
        AbstractC0116Ce.m475d(str2, "java.lang.String.format(format, *args)");
        sb.append(str2);
        sb.append(": ");
        sb.append(abstractC1791gn.m7746b());
        loggerM9450a.fine(sb.toString());
    }
}
