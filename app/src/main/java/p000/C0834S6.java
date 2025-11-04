package p000;

import android.content.Context;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.lang.Thread;

public class C0834S6 implements Thread.UncaughtExceptionHandler {

    public static C0834S6 f2601c;

    public Context f2602a = null;

    public Thread.UncaughtExceptionHandler f2603b = null;

    public static C0834S6 m4012a() {
        if (f2601c == null) {
            f2601c = new C0834S6();
        }
        return f2601c;
    }

    public void m4013b(Context context) {
        this.f2602a = context;
        this.f2603b = Thread.getDefaultUncaughtExceptionHandler();
        Thread.setDefaultUncaughtExceptionHandler(this);
    }

    @Override
    public void uncaughtException(Thread thread, Throwable th) {
        try {
            PrintWriter printWriter = new PrintWriter(new BufferedWriter(new FileWriter(PhoneUtils.getInstance().getCrashDirPath() + "/crash_" + PhoneUtils.getInstance().getVersionName() + "_" + PhoneUtils.getInstance().getVersionCode() + ".txt")));
            th.printStackTrace(printWriter);
            printWriter.flush();
        } catch (Exception unused) {
        } catch (Throwable th2) {
            BrowserActivity.getActivity().m6379y2();
            throw th2;
        }
        BrowserActivity.getActivity().m6379y2();
        SharedPreferencesHelper.getInstance().putBoolean("app_crashed", true);
        Thread.UncaughtExceptionHandler uncaughtExceptionHandler = this.f2603b;
        if (uncaughtExceptionHandler != null) {
            uncaughtExceptionHandler.uncaughtException(thread, th);
        }
    }
}
