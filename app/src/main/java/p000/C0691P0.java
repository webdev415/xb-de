package p000;

import java.util.logging.Handler;
import java.util.logging.LogRecord;

/* loaded from: classes.dex */
public final class C0691P0 extends Handler {

    public static final C0691P0 f2071a = new C0691P0();

    @Override
    public void publish(LogRecord logRecord) {
        AbstractC0116Ce.m476e(logRecord, "record");
        C0645O0 c0645o0 = C0645O0.f1989c;
        String loggerName = logRecord.getLoggerName();
        AbstractC0116Ce.m475d(loggerName, "record.loggerName");
        int iM3621b = AbstractC0737Q0.m3621b(logRecord);
        String message = logRecord.getMessage();
        AbstractC0116Ce.m475d(message, "record.message");
        c0645o0.m3351a(loggerName, iM3621b, message, logRecord.getThrown());
    }

    @Override
    public void close() {
    }

    @Override
    public void flush() {
    }
}
