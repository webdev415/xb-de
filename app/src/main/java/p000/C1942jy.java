package p000;

import android.content.SharedPreferences;
import android.os.Bundle;
import java.util.Arrays;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public final class C1942jy {

    public final String f5967a;

    public final Bundle f5968b;

    public Bundle f5969c;

    public final C1755fy f5970d;

    public C1942jy(C1755fy c1755fy, String str, Bundle bundle) {
        this.f5970d = c1755fy;
        AbstractC1085Xi.m4795d(str);
        this.f5967a = str;
        this.f5968b = new Bundle();
    }

    /* JADX WARN: Removed duplicated region for block: B:35:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0089  */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0120 A[Catch: NumberFormatException | JSONException -> 0x0128, NumberFormatException | JSONException -> 0x0128, TRY_LEAVE, TryCatch #1 {NumberFormatException | JSONException -> 0x0128, blocks: (B:9:0x0025, B:42:0x0091, B:42:0x0091, B:43:0x00a2, B:43:0x00a2, B:45:0x00a8, B:45:0x00a8, B:47:0x00b6, B:47:0x00b6, B:49:0x00c8, B:49:0x00c8, B:50:0x00d1, B:50:0x00d1, B:51:0x00d5, B:51:0x00d5, B:53:0x00db, B:53:0x00db, B:55:0x00e9, B:55:0x00e9, B:57:0x00fb, B:57:0x00fb, B:58:0x0104, B:58:0x0104, B:59:0x0108, B:59:0x0108, B:60:0x0114, B:60:0x0114, B:61:0x0120, B:61:0x0120, B:20:0x0052, B:23:0x005c, B:26:0x0066, B:29:0x0070, B:32:0x007a), top: B:75:0x0025, outer: #0 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final Bundle m8225a() {
        /*
            Method dump skipped, instructions count: 344
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1942jy.m8225a():android.os.Bundle");
    }

    public final void m8226b(Bundle bundle) {
        if (bundle == null) {
            bundle = new Bundle();
        }
        SharedPreferences.Editor editorEdit = this.f5970d.m7664J().edit();
        if (bundle.size() == 0) {
            editorEdit.remove(this.f5967a);
        } else {
            editorEdit.putString(this.f5967a, m8227c(bundle));
        }
        editorEdit.apply();
        this.f5969c = bundle;
    }

    public final String m8227c(Bundle bundle) throws JSONException {
        C2540wx c2540wxM9618G;
        Class<?> cls;
        String str;
        JSONArray jSONArray = new JSONArray();
        for (String str2 : bundle.keySet()) {
            Object obj = bundle.get(str2);
            if (obj != null) {
                try {
                    JSONObject jSONObject = new JSONObject();
                    jSONObject.put("n", str2);
                    if (!C1963kI.m8253a() || !this.f5970d.mo347e().m10818t(AbstractC0818Rr.f2446I0)) {
                        jSONObject.put("v", String.valueOf(obj));
                        if (obj instanceof String) {
                            jSONObject.put("t", "s");
                            jSONArray.put(jSONObject);
                        } else if (obj instanceof Long) {
                            jSONObject.put("t", "l");
                            jSONArray.put(jSONObject);
                        } else if (obj instanceof Double) {
                            jSONObject.put("t", "d");
                            jSONArray.put(jSONObject);
                        } else {
                            c2540wxM9618G = this.f5970d.mo349g().m9618G();
                            cls = obj.getClass();
                            c2540wxM9618G.m10617b("Cannot serialize bundle value to SharedPreferences. Type", cls);
                        }
                    } else if (obj instanceof String) {
                        jSONObject.put("v", String.valueOf(obj));
                        jSONObject.put("t", "s");
                        jSONArray.put(jSONObject);
                    } else if (obj instanceof Long) {
                        jSONObject.put("v", String.valueOf(obj));
                        jSONObject.put("t", "l");
                        jSONArray.put(jSONObject);
                    } else {
                        if (obj instanceof int[]) {
                            jSONObject.put("v", Arrays.toString((int[]) obj));
                            str = "ia";
                        } else if (obj instanceof long[]) {
                            jSONObject.put("v", Arrays.toString((long[]) obj));
                            str = "la";
                        } else if (obj instanceof Double) {
                            jSONObject.put("v", String.valueOf(obj));
                            jSONObject.put("t", "d");
                            jSONArray.put(jSONObject);
                        } else {
                            c2540wxM9618G = this.f5970d.mo349g().m9618G();
                            cls = obj.getClass();
                            c2540wxM9618G.m10617b("Cannot serialize bundle value to SharedPreferences. Type", cls);
                        }
                        jSONObject.put("t", str);
                        jSONArray.put(jSONObject);
                    }
                } catch (JSONException e) {
                    this.f5970d.mo349g().m9618G().m10617b("Cannot serialize bundle value to SharedPreferences", e);
                }
            }
        }
        return jSONArray.toString();
    }
}
