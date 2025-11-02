package p000;

import java.util.logging.Level;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public abstract class AbstractC0737Q0 {
    public static final int m3621b(LogRecord logRecord) {
        int iIntValue = logRecord.getLevel().intValue();
        Level level = Level.INFO;
        if (iIntValue > level.intValue()) {
            return 5;
        }
        return logRecord.getLevel().intValue() == level.intValue() ? 4 : 3;
    }
}
