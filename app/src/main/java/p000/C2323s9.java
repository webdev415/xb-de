package p000;

import android.util.Log;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C2323s9 extends AbstractC2221q {

    public static final Pattern f7023h = Pattern.compile("window\\.baidu\\.sug\\((.*)\\);");

    public C2323s9(boolean z) {
        super(z);
    }

    @Override
    public ArrayList mo62j(Object obj, int i) throws JSONException {
        ArrayList arrayList = new ArrayList<>();
        if (i == 1) {
            Matcher matcher = f7023h.matcher((String) obj);
            String strGroup = matcher.matches() ? matcher.group(1) : null;
            if (strGroup != null) {
                Log.i("test", ">>> baidu json string:" + strGroup);
                try {
                    JSONArray jSONArray = new JSONObject(strGroup).getJSONArray("s");
                    for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                        String string = jSONArray.getString(i2);
                        C2476vf c2476vf = new C2476vf();
                        c2476vf.f7677b = string;
                        arrayList.add(c2476vf);
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }
        return arrayList;
    }
}
