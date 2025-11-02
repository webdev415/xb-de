package p000;

import android.app.Application;
import android.os.Build;
import android.os.Process;
import android.os.StrictMode;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/* loaded from: classes.dex */
public abstract class AbstractC1740fj {

    public static String f5509a;

    public static int f5510b;

    public static String m7604a() throws Throwable {
        BufferedReader bufferedReader;
        String str;
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads;
        if (f5509a == null) {
            if (Build.VERSION.SDK_INT >= 28) {
                f5509a = Application.getProcessName();
            } else {
                int iMyPid = f5510b;
                if (iMyPid == 0) {
                    iMyPid = Process.myPid();
                    f5510b = iMyPid;
                }
                String strTrim = null;
                strTrim = null;
                strTrim = null;
                BufferedReader bufferedReader2 = null;
                if (iMyPid > 0) {
                    try {
                        str = "/proc/" + iMyPid + "/cmdline";
                        threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
                    } catch (IOException unused) {
                        bufferedReader = null;
                    } catch (Throwable th) {
                        th = th;
                    }
                    try {
                        bufferedReader = new BufferedReader(new FileReader(str));
                        try {
                            String line = bufferedReader.readLine();
                            AbstractC1085Xi.m4801j(line);
                            strTrim = line.trim();
                        } catch (IOException unused2) {
                        } catch (Throwable th2) {
                            th = th2;
                            bufferedReader2 = bufferedReader;
                            AbstractC0621Nd.m3317a(bufferedReader2);
                            throw th;
                        }
                        AbstractC0621Nd.m3317a(bufferedReader);
                    } finally {
                        StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
                    }
                }
                f5509a = strTrim;
            }
        }
        return f5509a;
    }
}
