package p000;

import android.content.Context;
import android.text.TextUtils;
import org.json.JSONObject;

/* loaded from: classes.dex */
public abstract class AbstractC2175p implements InterfaceC2319s5 {
    public boolean m8998b(Context context, JSONObject jSONObject) {
        boolean zEquals;
        boolean z;
        try {
            JSONObject jSONObjectM3662g = JsonUtils.getJSONObject(jSONObject, "condition");
            if (jSONObjectM3662g == null) {
                return true;
            }
            String strM3665j = JsonUtils.getString(jSONObjectM3662g, "install_package");
            String strM3665j2 = JsonUtils.getString(jSONObjectM3662g, "not_install_package");
            String strM3665j3 = JsonUtils.getString(jSONObjectM3662g, "channel");
            int iM3659d = JsonUtils.getInt(jSONObjectM3662g, "max_launch_times");
            int iM3659d2 = JsonUtils.getInt(jSONObjectM3662g, "min_launch_times");
            long jM3659d = JsonUtils.getInt(jSONObjectM3662g, "min_down_flow");
            int iM3659d3 = JsonUtils.getInt(jSONObjectM3662g, "min_version_code");
            int iM3659d4 = JsonUtils.getInt(jSONObjectM3662g, "max_version_code");
            boolean zM3657b = JsonUtils.getBoolean(jSONObjectM3662g, "execute_in_wifi");
            if (TextUtils.isEmpty(strM3665j)) {
                zEquals = true;
            } else {
                zEquals = AndroidSystemUtils.isAppInstalled(context, strM3665j);
                if (!zEquals) {
                    return false;
                }
            }
            try {
                if (!TextUtils.isEmpty(strM3665j2) && !(!AndroidSystemUtils.isAppInstalled(context, strM3665j2))) {
                    return false;
                }
                if (!TextUtils.isEmpty(strM3665j3) && !(zEquals = PhoneUtils.getInstance().getChannelCode().equals(strM3665j3))) {
                    return false;
                }
                if (iM3659d != -1) {
                    zEquals = C2439uo.getInstance().getUser().getLaunchTimes() < iM3659d;
                    if (!zEquals) {
                        return false;
                    }
                }
                if (iM3659d2 != -1) {
                    zEquals = C2439uo.getInstance().getUser().getLaunchTimes() > iM3659d2;
                    if (!zEquals) {
                        return false;
                    }
                }
                if (jM3659d != -1) {
                    zEquals = C2439uo.getInstance().getUser().getDownloadFlow() > jM3659d;
                    if (!zEquals) {
                        return false;
                    }
                }
                if (iM3659d3 != -1) {
                    zEquals = PhoneUtils.getInstance().getVersionCode() > iM3659d3;
                    if (!zEquals) {
                        return false;
                    }
                }
                if (iM3659d4 != -1) {
                    z = PhoneUtils.getInstance().getVersionCode() < iM3659d4;
                    if (!z) {
                        return false;
                    }
                } else {
                    z = zEquals;
                }
                if (!zM3657b) {
                    return z;
                }
                boolean zM8676J = AndroidSystemUtils.isWifiConnected(context);
                if (zM8676J) {
                    return zM8676J;
                }
                return false;
            } catch (Exception unused) {
                return zEquals;
            }
        } catch (Exception unused2) {
            return true;
        }
    }

    public void m8999c(Context context, String str) {
        C1344c1.m5691d().m5698h("Execute Action", "action/" + str);
    }
}
