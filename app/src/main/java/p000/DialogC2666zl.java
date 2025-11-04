package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import com.xbrowser.play.R;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class DialogC2666zl extends BaseDialog {

    public JSONArray f8268b;

    public class a implements CompoundButton.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_bookmark", z);
        }
    }

    public class b implements CompoundButton.OnCheckedChangeListener {
        public b() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_quick_access", z);
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_setting", z);
        }
    }

    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_autofill", z);
        }
    }

    public class e implements CompoundButton.OnCheckedChangeListener {
        public e() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_opened_tab", z);
        }
    }

    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_custom_ad_rule", z);
        }
    }

    public class g implements CompoundButton.OnCheckedChangeListener {
        public g() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) throws JSONException {
            DialogC2666zl.this.m11041d("sync_tag_userscript", z);
        }
    }

    public class h implements OnDismissListener {
        public h() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) throws JSONException {
            SyncManager.getInstance().m4833u(DialogC2666zl.this.f8268b.toString());
            C1199a3.getInstance().m5096h("sync_items");
        }
    }

    public DialogC2666zl(Context context) {
        super(context);
        this.f8268b = null;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_select_sync_item);
        try {
            this.f8268b = new JSONArray(SyncManager.getInstance().getSyncResourceConfig());
            CheckBox checkBox = (CheckBox) findViewById(R.id.bookmark);
            checkBox.setChecked(m11040c("sync_tag_bookmark"));
            checkBox.setOnCheckedChangeListener(new a());
            CheckBox checkBox2 = (CheckBox) findViewById(R.id.quick_access);
            checkBox2.setChecked(m11040c("sync_tag_quick_access"));
            checkBox2.setOnCheckedChangeListener(new b());
            CheckBox checkBox3 = (CheckBox) findViewById(R.id.settings);
            checkBox3.setChecked(m11040c("sync_tag_setting"));
            checkBox3.setOnCheckedChangeListener(new c());
            CheckBox checkBox4 = (CheckBox) findViewById(R.id.passwd_and_auto_fill);
            checkBox4.setChecked(m11040c("sync_tag_autofill"));
            checkBox4.setOnCheckedChangeListener(new d());
            CheckBox checkBox5 = (CheckBox) findViewById(R.id.tabs);
            checkBox5.setChecked(m11040c("sync_tag_opened_tab"));
            checkBox5.setOnCheckedChangeListener(new e());
            CheckBox checkBox6 = (CheckBox) findViewById(R.id.custom_ad_rule);
            checkBox6.setChecked(m11040c("sync_tag_custom_ad_rule"));
            checkBox6.setOnCheckedChangeListener(new f());
            CheckBox checkBox7 = (CheckBox) findViewById(R.id.user_script);
            checkBox7.setChecked(m11040c("sync_tag_userscript"));
            checkBox7.setOnCheckedChangeListener(new g());
        } catch (JSONException unused) {
        }
        setOnDismissListener(new h());
    }

    public final boolean m11040c(String str) throws JSONException {
        JSONObject jSONObject;
        if (this.f8268b == null) {
            return true;
        }
        for (int i = 0; i < this.f8268b.length(); i++) {
            try {
                jSONObject = this.f8268b.getJSONObject(i);
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
            if (jSONObject.getString("id").equals(str)) {
                return jSONObject.getBoolean("checked");
            }
            continue;
        }
        return false;
    }

    public final void m11041d(String str, boolean z) throws JSONException {
        if (this.f8268b == null) {
            return;
        }
        for (int i = 0; i < this.f8268b.length(); i++) {
            try {
                JSONObject jSONObject = this.f8268b.getJSONObject(i);
                if (jSONObject.getString("id").equals(str)) {
                    jSONObject.put("checked", z);
                }
            } catch (JSONException e2) {
                e2.printStackTrace();
            }
        }
    }
}
