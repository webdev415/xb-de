package p000;

import android.util.Log;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.logging.Level;
import java.util.logging.Logger;

/* loaded from: classes.dex */
public final class C0645O0 {

    public static final Map f1988b;

    public static final C0645O0 f1989c = new C0645O0();

    public static final CopyOnWriteArraySet f1987a = new CopyOnWriteArraySet();

    static {
        LinkedHashMap linkedHashMap = new LinkedHashMap();
        Package r2 = OkHttpClient.class.getPackage();
        String name = r2 != null ? r2.getName() : null;
        if (name != null) {
            linkedHashMap.put(name, "OkHttp");
        }
        String name2 = OkHttpClient.class.getName();
        AbstractC0116Ce.m475d(name2, "OkHttpClient::class.java.name");
        linkedHashMap.put(name2, "okhttp.OkHttpClient");
        String name3 = C2382td.class.getName();
        AbstractC0116Ce.m475d(name3, "Http2::class.java.name");
        linkedHashMap.put(name3, "okhttp.Http2");
        String name4 = C2300rn.class.getName();
        AbstractC0116Ce.m475d(name4, "TaskRunner::class.java.name");
        linkedHashMap.put(name4, "okhttp.TaskRunner");
        linkedHashMap.put("okhttp3.mockwebserver.MockWebServer", "okhttp.MockWebServer");
        f1988b = AbstractC2339sg.m9577i(linkedHashMap);
    }

    public final void m3351a(String str, int i, String str2, Throwable th) {
        int iMin;
        AbstractC0116Ce.m476e(str, "loggerName");
        AbstractC0116Ce.m476e(str2, "message");
        String strM3354d = m3354d(str);
        if (Log.isLoggable(strM3354d, i)) {
            if (th != null) {
                str2 = str2 + "\n" + Log.getStackTraceString(th);
            }
            int length = str2.length();
            int i2 = 0;
            while (i2 < length) {
                int iM2928L = AbstractC0584Mm.m2928L(str2, '\n', i2, false, 4, null);
                if (iM2928L == -1) {
                    iM2928L = length;
                }
                while (true) {
                    iMin = Math.min(iM2928L, i2 + 4000);
                    String strSubstring = str2.substring(i2, iMin);
                    AbstractC0116Ce.m475d(strSubstring, "(this as java.lang.Strin…ing(startIndex, endIndex)");
                    Log.println(i, strM3354d, strSubstring);
                    if (iMin >= iM2928L) {
                        break;
                    } else {
                        i2 = iMin;
                    }
                }
                i2 = iMin + 1;
            }
        }
    }

    public final void m3352b() {
        for (Map.Entry entry : f1988b.entrySet()) {
            m3353c((String) entry.getKey(), (String) entry.getValue());
        }
    }

    public final void m3353c(String str, String str2) throws SecurityException {
        Logger logger = Logger.getLogger(str);
        if (f1987a.add(logger)) {
            AbstractC0116Ce.m475d(logger, "logger");
            logger.setUseParentHandlers(false);
            logger.setLevel(Log.isLoggable(str2, 3) ? Level.FINE : Log.isLoggable(str2, 4) ? Level.INFO : Level.WARNING);
            logger.addHandler(C0691P0.f2071a);
        }
    }

    public final String m3354d(String str) {
        String str2 = (String) f1988b.get(str);
        return str2 != null ? str2 : AbstractC0676Om.m3436o0(str, 23);
    }
}
