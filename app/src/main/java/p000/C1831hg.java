package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class C1831hg implements InterfaceC2229q7 {

    public static C1831hg f5741g;

    public Context f5742a = null;

    public SharedPreferences f5743b = null;

    public String f5744c = null;

    public int f5745d = 1;

    public final HashMap f5746e = new HashMap<>(5);

    public final HashMap f5747f = new HashMap<>(2);

    public static C1831hg m7836c() {
        if (f5741g == null) {
            f5741g = new C1831hg();
        }
        return f5741g;
    }

    @Override
    public void mo7837a(InterfaceC2183p7 interfaceC2183p7) {
        try {
            if (!interfaceC2183p7.mo8842b().equals("mcms_services")) {
                String strMo61f = interfaceC2183p7.mo61f();
                Log.d("mcms", "service :" + strMo61f + " update successed");
                this.f5743b.edit().putString(strMo61f + ".updated_at", (String) this.f5746e.get(strMo61f)).apply();
                this.f5743b.edit().putString(strMo61f + ".service_url", interfaceC2183p7.mo9039e()).apply();
                C1825ha.m7824d().m7829f(53, strMo61f);
                AbstractC2524wh.m10586a(this.f5747f.get(strMo61f));
                return;
            }
            ArrayList arrayListMo9040g = interfaceC2183p7.mo9040g();
            if (arrayListMo9040g != null) {
                Iterator it = arrayListMo9040g.iterator();
                while (it.hasNext()) {
                    C2615yg c2615yg = (C2615yg) it.next();
                    String strM10881a = c2615yg.m10881a();
                    this.f5746e.put(strM10881a, c2615yg.m10883c());
                    InterfaceC2183p7 interfaceC2183p7M9351c = C2275r7.m9348e().m9351c(strM10881a);
                    if (interfaceC2183p7M9351c != null) {
                        interfaceC2183p7M9351c.mo9038d(c2615yg.m10881a());
                        interfaceC2183p7M9351c.mo9036a(c2615yg.m10882b());
                        C2275r7.m9348e().m9357j(interfaceC2183p7M9351c);
                        Log.d("mcms", ">>>>>>> registered new  data source [" + interfaceC2183p7M9351c.mo8842b() + "] update-at:" + c2615yg.m10883c() + "url:" + c2615yg.m10882b());
                        m7841f(c2615yg.m10881a());
                    } else {
                        Log.d("mcms", ">>>>>>> not found [" + strM10881a + "] corresponding data source implementation");
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void mo7838b(InterfaceC2183p7 interfaceC2183p7) {
        Log.d("mcms", ">>>>>>>>>>   receive data fail " + interfaceC2183p7.mo8842b());
        int i = this.f5745d - 1;
        this.f5745d = i;
        if (i == 0) {
            m7840e(this.f5744c, true);
        }
    }

    public void m7839d(Context context, String str) {
        this.f5742a = context;
        this.f5743b = context.getSharedPreferences("mcms_services", 0);
        this.f5744c = str;
        m7840e(str, false);
    }

    public final void m7840e(String str, boolean z) {
        Log.d("mcms", "main service url:" + str);
        C2599y9 c2599y9 = new C2599y9();
        c2599y9.mo9038d("mcms_services");
        c2599y9.mo9036a(str);
        C2275r7.m9348e().m9357j(c2599y9);
        C2275r7.m9348e().m9349a(c2599y9, z, this, null);
    }

    public void m7841f(String str) {
        String string = this.f5743b.getString(str + ".updated_at", "");
        if (string.equals("") || !string.equals(this.f5746e.get(str))) {
            Log.i("mcms", ">>>> found new update service:" + str);
            C2275r7.m9348e().m9355h(str, this);
        }
    }
}
