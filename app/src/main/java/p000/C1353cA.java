package p000;

import android.content.Context;
import android.net.Uri;
import android.os.Build;
import android.os.StrictMode;
import android.util.Log;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public final class C1353cA {

    public static class a {

        public static volatile AbstractC1325bi f3931a;

        public static AbstractC1325bi m5769a(Context context) {
            AbstractC1325bi abstractC1325biM5765a;
            AbstractC1325bi abstractC1325bi = f3931a;
            if (abstractC1325bi == null) {
                synchronized (a.class) {
                    try {
                        abstractC1325bi = f3931a;
                        if (abstractC1325bi == null) {
                            new C1353cA();
                            if (AbstractC1721fA.m7568c(Build.TYPE, Build.TAGS)) {
                                if (AbstractC0229Ez.m1159a() && !context.isDeviceProtectedStorage()) {
                                    context = context.createDeviceProtectedStorageContext();
                                }
                                abstractC1325biM5765a = C1353cA.m5765a(context);
                            } else {
                                abstractC1325biM5765a = AbstractC1325bi.m5671a();
                            }
                            f3931a = abstractC1325biM5765a;
                            abstractC1325bi = abstractC1325biM5765a;
                        }
                    } finally {
                    }
                }
            }
            return abstractC1325bi;
        }
    }

    public static AbstractC1325bi m5765a(Context context) {
        StrictMode.ThreadPolicy threadPolicyAllowThreadDiskReads = StrictMode.allowThreadDiskReads();
        try {
            StrictMode.allowThreadDiskWrites();
            AbstractC1325bi abstractC1325biM5768d = m5768d(context);
            AbstractC1325bi abstractC1325biM5672d = abstractC1325biM5768d.mo5674c() ? AbstractC1325bi.m5672d(m5767c(context, (File) abstractC1325biM5768d.mo5673b())) : AbstractC1325bi.m5671a();
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            return abstractC1325biM5672d;
        } catch (Throwable th) {
            StrictMode.setThreadPolicy(threadPolicyAllowThreadDiskReads);
            throw th;
        }
    }

    public static final String m5766b(String str) {
        return new String(str);
    }

    public static InterfaceC1194Zz m5767c(Context context, File file) throws IOException {
        try {
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
            try {
                C0950Ul c0950Ul = new C0950Ul();
                HashMap map = new HashMap<>();
                while (true) {
                    String line = bufferedReader.readLine();
                    if (line == null) {
                        Log.w("HermeticFileOverrides", "Parsed " + String.valueOf(file) + " for Android package " + context.getPackageName());
                        C0735Pz c0735Pz = new C0735Pz(c0950Ul);
                        bufferedReader.close();
                        return c0735Pz;
                    }
                    String[] strArrSplit = line.split(" ", 3);
                    if (strArrSplit.length != 3) {
                        Log.e("HermeticFileOverrides", "Invalid: " + line);
                    } else {
                        String strM5766b = m5766b(strArrSplit[0]);
                        String strDecode = Uri.decode(m5766b(strArrSplit[1]));
                        String strDecode2 = (String) map.get(strArrSplit[2]);
                        if (strDecode2 == null) {
                            String strM5766b2 = m5766b(strArrSplit[2]);
                            strDecode2 = Uri.decode(strM5766b2);
                            if (strDecode2.length() < 1024 || strDecode2 == strM5766b2) {
                                map.put(strM5766b2, strDecode2);
                            }
                        }
                        C0950Ul c0950Ul2 = (C0950Ul) c0950Ul.get(strM5766b);
                        if (c0950Ul2 == null) {
                            c0950Ul2 = new C0950Ul();
                            c0950Ul.put(strM5766b, c0950Ul2);
                        }
                        c0950Ul2.put(strDecode, strDecode2);
                    }
                }
            } finally {
            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public static AbstractC1325bi m5768d(Context context) {
        try {
            File file = new File(context.getDir("phenotype_hermetic", 0), "overrides.txt");
            return file.exists() ? AbstractC1325bi.m5672d(file) : AbstractC1325bi.m5671a();
        } catch (RuntimeException e) {
            Log.e("HermeticFileOverrides", "no data dir", e);
            return AbstractC1325bi.m5671a();
        }
    }
}
