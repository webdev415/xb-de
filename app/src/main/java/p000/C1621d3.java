package p000;

import android.net.Uri;
import android.util.Log;
import com.mmbox.xbrowser.BrowserActivity;
import java.util.ArrayList;
import java.util.Iterator;

public class C1621d3 {

    public ArrayList f5270a = new ArrayList<>();

    public InterfaceC1300b3 m7293a(String str) {
        if (str == null) {
            str = "x:home";
        }
        C1374cl c1374clM7294b = m7294b(str.toLowerCase());
        if (c1374clM7294b != null) {
            return BrowserActivity.getActivity().m6222J0().mo5705r(c1374clM7294b.f3989a, c1374clM7294b.f3990b);
        }
        return null;
    }

    public final C1374cl m7294b(String str) {
        Iterator it = this.f5270a.iterator();
        while (it.hasNext()) {
            C1374cl c1374cl = (C1374cl) it.next();
            if (str.startsWith(c1374cl.f3991c) || str.matches(c1374cl.f3991c)) {
                Log.i("matcher", c1374cl.f3991c);
                return c1374cl;
            }
        }
        return null;
    }

    public void m7295c(String str, String str2) {
        String host = str2.startsWith("ex://") ? Uri.parse(str2).getHost() : BrowserActivity.getActivity().getApplicationInfo().packageName;
        C1374cl c1374cl = new C1374cl();
        c1374cl.f3989a = host;
        c1374cl.f3990b = str;
        c1374cl.f3991c = str2;
        this.f5270a.add(c1374cl);
    }
}
