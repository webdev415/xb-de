package p000;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C1089Xm {

    public static C1089Xm insatnce;

    public OkHttpClient f3265d;

    public boolean f3262a = false;

    public long f3263b = 0;

    public int f3264c = Integer.MIN_VALUE;

    public final HashMap<String, AbstractResourceManager> f3266e = new HashMap<>();

    public boolean f3267f = false;

    public int f3268g = 0;

    public class a implements Runnable {

        public final String f3269l;

        public a(String str) {
            this.f3269l = str;
        }

        @Override
        public void run() {
            Toast.makeText(BrowserActivity.getActivity(), this.f3269l, Toast.LENGTH_LONG).show();
        }
    }

    public class c implements InterfaceC0556M3 {

        public final boolean f3274a;

        public final AbstractResourceManager f3275b;

        public c(boolean z, AbstractResourceManager abstractResourceManager) {
            this.f3274a = z;
            this.f3275b = abstractResourceManager;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            Response response2;
            String str;
            Response response3;
            String str2;
            StringBuilder sb;
            int iM10253j;
            String str3 = " version:";
            String str4 = " state:";
            String strM10252i = " execute pull ";
            if (response.getStatus() == 200) {
                String strM2399p = response.getContentType("Content-Type");
                if (strM2399p != null && strM2399p.indexOf("/json") >= 0) {
                    try {
                        try {
                            this.f3275b.updateFromJson(response.m2392a().m2714l());
                            response.m2392a().close();
                            sb = new StringBuilder();
                            sb.append(" execute pull ");
                            strM10252i = this.f3275b.getResourceType();
                            sb.append(strM10252i);
                            sb.append(" state:");
                            iM10253j = this.f3275b.getState();
                            sb.append(iM10253j);
                            sb.append(" version:");
                            sb.append(this.f3275b.getCurrentVersion());
                            Log.i("xsync", sb.toString());
                            str2 = iM10253j;
                            response3 = sb;
                        } catch (Exception e) {
                            e.printStackTrace();
                            response.m2392a().close();
                            StringBuilder sb2 = new StringBuilder();
                            sb2.append(" execute pull ");
                            strM10252i = this.f3275b.getResourceType();
                            sb2.append(strM10252i);
                            sb2.append(" state:");
                            int iM10253j2 = this.f3275b.getState();
                            sb2.append(iM10253j2);
                            sb2.append(" version:");
                            sb2.append(this.f3275b.getCurrentVersion());
                            Log.i("xsync", sb2.toString());
                            str2 = iM10253j2;
                            response3 = sb2;
                            if (this.f3275b.getState() != 9) {
                                int iM10253j3 = this.f3275b.getState();
                                str4 = iM10253j2;
                                str3 = iM10253j3;
                                response = sb2;
                                str = iM10253j2;
                                response2 = sb2;
                                if (iM10253j3 == 1) {
                                }
                            }
                        }
                        if (this.f3275b.getState() == 9) {
                            C1089Xm.m4814b(C1089Xm.this, -2147483644);
                            AbstractResourceManager abstractResourceManager = this.f3275b;
                            abstractResourceManager.setState(1);
                            str4 = str2;
                            str3 = abstractResourceManager;
                            response = response3;
                        } else {
                            int iM10253j4 = this.f3275b.getState();
                            str4 = iM10253j;
                            str3 = iM10253j4;
                            response = sb;
                            str = iM10253j;
                            response2 = sb;
                            if (iM10253j4 == 1) {
                                C1089Xm c1089Xm = C1089Xm.this;
                                C1089Xm.m4814b(c1089Xm, -2147483392);
                                str4 = str;
                                str3 = c1089Xm;
                                response = response2;
                            }
                        }
                    } catch (Throwable th) {
                        response.m2392a().close();
                        Log.i("xsync", strM10252i + this.f3275b.getResourceType() + str4 + this.f3275b.getState() + str3 + this.f3275b.getCurrentVersion());
                        if (this.f3275b.getState() == 9) {
                            C1089Xm.m4814b(C1089Xm.this, -2147483644);
                            this.f3275b.setState(1);
                        } else if (this.f3275b.getState() == 1) {
                            C1089Xm.m4814b(C1089Xm.this, -2147483392);
                        }
                        throw th;
                    }
                }
            } else {
                C1089Xm.m4814b(C1089Xm.this, -2147352576);
            }
            C1089Xm.this.m4820g(this.f3274a);
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            C1089Xm.m4814b(C1089Xm.this, -2147418112);
            C1089Xm.this.m4820g(this.f3274a);
        }
    }

    public class d implements InterfaceC0556M3 {

        public final boolean f3277a;

        public final AbstractResourceManager f3278b;

        public d(boolean z, AbstractResourceManager abstractResourceManager) {
            this.f3277a = z;
            this.f3278b = abstractResourceManager;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            C1089Xm c1089Xm;
            int i;
            if (response.getStatus() == 200) {
                String strM2399p = response.getContentType("Content-Type");
                if (strM2399p != null && strM2399p.indexOf("/json") >= 0) {
                    try {
                        try {
                            this.f3278b.updateFromJson(response.m2392a().m2714l());
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    } finally {
                        response.m2392a().close();
                    }
                }
                c1089Xm = C1089Xm.this;
                i = -2147481600;
            } else {
                c1089Xm = C1089Xm.this;
                i = -2147352576;
            }
            C1089Xm.m4814b(c1089Xm, i);
            C1089Xm.this.m4820g(this.f3277a);
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            C1089Xm.m4814b(C1089Xm.this, -2147418112);
            C1089Xm.this.m4820g(this.f3277a);
        }
    }

    public class e implements InterfaceC0556M3 {

        public final boolean f3280a;

        public final AbstractResourceManager f3281b;

        public e(boolean z, AbstractResourceManager abstractResourceManager) {
            this.f3280a = z;
            this.f3281b = abstractResourceManager;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            if (response.getStatus() == 200) {
                try {
                    try {
                        this.f3281b.updateFromJson(response.m2392a().m2714l());
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                } finally {
                    response.m2392a().close();
                    C1089Xm.this.f3267f = true;
                    this.f3281b.sync();
                    C1089Xm.m4814b(C1089Xm.this, -2147481600);
                }
            } else {
                C1089Xm.m4814b(C1089Xm.this, -2147352576);
            }
            C1089Xm.this.m4820g(this.f3280a);
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            C1089Xm.this.m4834v("sync to server failed,make sure the network is available");
            C1089Xm.this.m4820g(this.f3280a);
        }
    }

    public class f implements InterfaceC0556M3 {

        public final boolean f3283a;

        public final AbstractResourceManager f3284b;

        public f(boolean z, AbstractResourceManager abstractResourceManager) {
            this.f3283a = z;
            this.f3284b = abstractResourceManager;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, Response response) {
            if (response.getStatus() == 200) {
                try {
                    try {
                        this.f3284b.updateFromJson(response.m2392a().m2714l());
                    } catch (Exception e) {
                        e.printStackTrace();
                        response.m2392a().close();
                        if (this.f3284b.getState() == 8) {
                            if ((C1089Xm.this.f3264c & (-2147483640)) != -2147483640) {
                            }
                        } else if (this.f3284b.getState() == 10) {
                        }
                    }
                } finally {
                    response.m2392a().close();
                    if (this.f3284b.getState() == 8) {
                        if ((C1089Xm.this.f3264c & (-2147483640)) != -2147483640) {
                            C1089Xm.m4814b(C1089Xm.this, -2147482624);
                        }
                    } else if (this.f3284b.getState() == 10) {
                        this.f3284b.setState(7);
                        C1089Xm.m4816d(C1089Xm.this);
                        C1089Xm.this.m4835w(this.f3284b, true);
                    } else {
                        C1089Xm.this.f3267f = true;
                        this.f3284b.sync();
                        C1089Xm.m4814b(C1089Xm.this, -2147481600);
                    }
                }
            } else {
                C1089Xm.m4814b(C1089Xm.this, -2147352576);
            }
            C1089Xm.this.m4820g(this.f3283a);
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            C1089Xm.this.m4834v("sync to server failed,make sure the network is available");
            C1089Xm.this.m4820g(this.f3283a);
        }
    }

    public C1089Xm() {
        this.f3265d = null;
        this.f3265d = new OkHttpClient();
    }

    public static int m4814b(C1089Xm c1089Xm, int i) {
        int i2 = i | c1089Xm.f3264c;
        c1089Xm.f3264c = i2;
        return i2;
    }

    public static int m4816d(C1089Xm c1089Xm) {
        int i = c1089Xm.f3268g + 1;
        c1089Xm.f3268g = i;
        return i;
    }

    public static C1089Xm getInstance() {
        if (insatnce == null) {
            insatnce = new C1089Xm();
        }
        return insatnce;
    }

    public final synchronized void m4820g(boolean z) {
        String string;
        try {
            Log.i("check-state", ">>>> call check sync state" + this.f3268g);
            int i = this.f3268g + (-1);
            this.f3268g = i;
            if (i <= 0) {
                this.f3262a = false;
                if (z) {
                    int i2 = this.f3264c;
                    if ((i2 & (-2147418112)) == -2147418112) {
                        string = BrowserActivity.getActivity().getString(R.string.toast_sync_network_not_available);
                    } else if ((i2 & (-2147352576)) == -2147352576) {
                        string = BrowserActivity.getActivity().getString(R.string.toast_sync_service_response_error);
                    } else if ((i2 & (-2147221504)) == -2147221504) {
                        string = BrowserActivity.getActivity().getString(R.string.toast_sync_timeout);
                    } else if ((i2 & (-2147483647)) == -2147483647) {
                        if ((i2 & (-2146959360)) != -2146959360) {
                            string = ((i2 & (-2147483392)) != -2147483392 && (i2 & (-2147483644)) == -2147483644) ? BrowserActivity.getActivity().getString(R.string.toast_sync_client_side_is_latest) : BrowserActivity.getActivity().getString(R.string.toast_sync_user_data_ok);
                        }
                    } else if ((i2 & (-2147483646)) == -2147483646) {
                        getInstance().m4826n();
                    } else if ((i2 & (-2147483136)) == -2147483136) {
                        if ((i2 & (-2146959360)) == -2146959360 || (i2 & (-2147481600)) == -2147481600) {
                            string = BrowserActivity.getActivity().getString(R.string.toast_sync_to_remote);
                        } else if ((i2 & (-2147483640)) == -2147483640) {
                            BrowserActivity.getActivity().runOnUiThread(new b());
                        } else {
                            string = (i2 & (-2147482624)) == -2147482624 ? BrowserActivity.getActivity().getString(R.string.toast_sync_server_side_is_latest) : BrowserActivity.getActivity().getString(R.string.toast_sync_to_remote);
                        }
                    }
                    m4834v(string);
                }
                C1199a3.m5090f().m5093d("event_app_to_page", "data_sync_done");
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m4821h() {
        for (String o : this.f3266e.keySet()) {
            ((AbstractResourceManager) this.f3266e.get(o)).sync();
        }
    }

    public AbstractResourceManager m4822j(String str) {
        return (AbstractResourceManager) this.f3266e.get(str);
    }

    public String getSyncResourceConfig() {
        String defaultConfig = "[\n" +
                "    {\"id\": \"sync_tag_quick_access\", \"checked\": true},\n" +
                "    {\"id\": \"sync_tag_bookmark\", \"checked\": true},\n" +
                "    {\"id\": \"sync_tag_setting\", \"checked\": true},\n" +
                "    {\"id\": \"sync_tag_userscript\", \"checked\": true},\n" +
                "    {\"id\": \"sync_tag_autofill\", \"checked\": true},\n" +
                "    {\"id\": \"sync_tag_opened_tab\", \"checked\": true},\n" +
                "    {\"id\": \"sync_tag_custom_ad_rule\", \"checked\": true}\n" +
                "]";

        String config = SharedPreferencesHelper.getInstance().getString("sync_resource_conf", defaultConfig);
        return TextUtils.isEmpty(config) ? defaultConfig : config;
    }


    public final boolean m4824l(AbstractResourceManager abstractResourceManager) throws JSONException {
        String strM4823k;
        try {
            strM4823k = getSyncResourceConfig();
        } catch (JSONException e2) {
            e2.printStackTrace();
        }
        if (TextUtils.isEmpty(strM4823k)) {
            return true;
        }
        JSONArray jSONArray = new JSONArray(strM4823k);
        for (int i = 0; i < jSONArray.length(); i++) {
            JSONObject jSONObject = jSONArray.getJSONObject(i);
            if (jSONObject.getString("id").equals(abstractResourceManager.getKey()) && jSONObject.getBoolean("checked")) {
                return true;
            }
        }
        return false;
    }

    public void m4825m() {
        for (String key : this.f3266e.keySet()) {
            this.f3266e.get(key).loadFromCache();
        }
    }

    public void m4826n() {
        for (String key : this.f3266e.keySet()) {
            AbstractResourceManager abstractResourceManager = this.f3266e.get(key);
            abstractResourceManager.restoreFromBackup();
            abstractResourceManager.incrementVersion();
        }
    }

    public void m4827o() {
        for (String o : this.f3266e.keySet()) {
            ((AbstractResourceManager) this.f3266e.get(o)).resetVersion();
        }
        m4828p(false);
    }

    public synchronized void m4828p(boolean z) {
        try {
            if (this.f3262a) {
                return;
            }
            this.f3262a = true;
            this.f3263b = System.currentTimeMillis();
            this.f3264c = Integer.MIN_VALUE;
            if (z) {
                this.f3264c = Integer.MIN_VALUE | (-2147483647);
            } else {
                this.f3264c = Integer.MIN_VALUE | (-2147483646);
            }
            this.f3268g = 0;
            this.f3267f = false;
            Iterator it = this.f3266e.keySet().iterator();
            while (it.hasNext()) {
                AbstractResourceManager abstractResourceManager = (AbstractResourceManager) this.f3266e.get((String) it.next());
                abstractResourceManager.setState(2);
                if (m4824l(abstractResourceManager) && abstractResourceManager.isEnabled) {
                    this.f3268g++;
                    m4835w(abstractResourceManager, z);
                }
            }
            if (this.f3268g == 0) {
                this.f3262a = false;
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public void m4829q() {
        m4831s(true, false);
    }

    public void m4830r(boolean z) {
        m4831s(z, false);
    }

    public void m4831s(boolean z, boolean z2) {
        if (this.f3262a) {
            return;
        }
        this.f3262a = true;
        this.f3263b = System.currentTimeMillis();
        this.f3268g = 0;
        this.f3267f = false;
        this.f3264c = Integer.MIN_VALUE | (-2147483136);
        Iterator it = this.f3266e.keySet().iterator();
        while (it.hasNext()) {
            AbstractResourceManager abstractResourceManager = (AbstractResourceManager) this.f3266e.get((String) it.next());
            abstractResourceManager.setState(z2 ? 14 : 7);
            if (abstractResourceManager.isModified() && m4824l(abstractResourceManager) && abstractResourceManager.isEnabled) {
                this.f3268g++;
                m4835w(abstractResourceManager, z);
            }
        }
        if (this.f3268g == 0) {
            this.f3262a = false;
            this.f3264c |= -2147482624;
            m4820g(z);
        }
    }

    public void m4832t(AbstractResourceManager abstractResourceManager) {
        this.f3266e.put(abstractResourceManager.getResourceType(), abstractResourceManager);
    }

    public void m4833u(String str) {
        SharedPreferencesHelper.getInstance().putString("sync_resource_conf", str);
        getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public final void m4834v(String str) {
        BrowserActivity.getActivity().runOnUiThread(new a(str));
    }

    public final void m4835w(AbstractResourceManager abstractResourceManager, boolean z) {
        if (abstractResourceManager.getState() == 0) {
            abstractResourceManager.loadFromCache();
            return;
        }
        int i = 2;
        if (abstractResourceManager.getState() == 1) {
            if (abstractResourceManager.hasBackupFile()) {
                abstractResourceManager.setState(6);
            }
            m4835w(abstractResourceManager, z);
        }
        try {
            if (abstractResourceManager.getState() == 2) {
                if (!abstractResourceManager.isEnabled) {
                    return;
                }
                String str = ApiEndpointsManager.getInstance().getUserDataEndPoint() + "/pull";
                Log.i("sync-resource", "pull:" + abstractResourceManager.getResourceType() + " url:" + str);
                byte[] bytes = abstractResourceManager.toJsonWithUser().getBytes();
                AbstractCryptoUtils.toggleBytes(bytes);
                this.f3265d.m2004y(new Request.a().m507i(str).m504f(AbstractC0168Dk.m718d(C0716Pg.m3568g("text/json"), bytes)).m500b()).mo1791i(new c(z, abstractResourceManager));
            } else if (abstractResourceManager.getState() != 13) {
                i = 7;
                if (abstractResourceManager.getState() == 4) {
                    if (!z) {
                        abstractResourceManager.sync();
                        return;
                    }
                } else if (abstractResourceManager.getState() == 14) {
                    abstractResourceManager.incrementTempVersion();
                    String str2 = ApiEndpointsManager.getInstance().getUserDataEndPoint() + "/push?override=true";
                    Log.i("sync-resource", "force push :" + abstractResourceManager.getResourceType() + "  " + str2);
                    byte[] bytes2 = abstractResourceManager.toJsonWithIncrement().getBytes();
                    AbstractCryptoUtils.toggleBytes(bytes2);
                    this.f3265d.m2004y(new Request.a().m507i(str2).m499a("Content-Encoding", "gzip").m504f(AbstractC0168Dk.m718d(C0716Pg.m3568g("text/json"), AbstractC2473vc.m10348b(bytes2))).m500b()).mo1791i(new e(z, abstractResourceManager));
                } else {
                    if (abstractResourceManager.getState() != 7) {
                        return;
                    }
                    Log.i("xsync", "do push resource :" + abstractResourceManager.getResourceType() + " version: " + abstractResourceManager.getCurrentVersion());
                    StringBuilder sb = new StringBuilder();
                    sb.append(ApiEndpointsManager.getInstance().getUserDataEndPoint());
                    sb.append("/push");
                    String string = sb.toString();
                    byte[] bytes3 = abstractResourceManager.toJsonWithIncrement().getBytes();
                    AbstractCryptoUtils.toggleBytes(bytes3);
                    this.f3265d.m2004y(new Request.a().m507i(string).m499a("Content-Encoding", "gzip").m504f(AbstractC0168Dk.m718d(C0716Pg.m3568g("text/json"), AbstractC2473vc.m10348b(bytes3))).m500b()).mo1791i(new f(z, abstractResourceManager));
                }
            } else {
                if (!abstractResourceManager.isEnabled) {
                    return;
                }
                String str3 = ApiEndpointsManager.getInstance().getUserDataEndPoint() + "/pull";
                Log.i("sync-resource", "pull:" + abstractResourceManager.getResourceType() + " url:" + str3);
                byte[] bytes4 = abstractResourceManager.toJsonWithUser().getBytes();
                AbstractCryptoUtils.toggleBytes(bytes4);
                this.f3265d.m2004y(new Request.a().m507i(str3).m504f(AbstractC0168Dk.m718d(C0716Pg.m3568g("text/json"), bytes4)).m500b()).mo1791i(new d(z, abstractResourceManager));
            }
            return;
        } catch (Exception e2) {
            e2.printStackTrace();
            m4820g(z);
            return;
        }
        abstractResourceManager.setState(i);
        m4835w(abstractResourceManager, z);
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() {
            new a(BrowserActivity.getActivity()).show();
        }

        public class a extends AbstractDialogC0904Tl {
            public a(BrowserActivity browserActivity) {
                super(browserActivity);
            }

            @Override
            public void mo4178b(int i) {
                if (i == 0) {
                    new DialogC2702a(BrowserActivity.getActivity()).m5643d(BrowserActivity.getActivity().getString(R.string.str_force_override), BrowserActivity.getActivity().getString(R.string.str_force_override_desc));
                } else if (i == 1) {
                    C1089Xm.this.m4828p(true);
                }
            }

            public class DialogC2702a extends AbstractDialogC1303b6 {
                public DialogC2702a(Context context) {
                    super(context);
                }

                @Override
                public void mo316c() {
                    C1089Xm.this.m4830r(true);
                }

                @Override
                public void mo315b() {
                }
            }
        }
    }
}
