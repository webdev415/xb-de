package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RadioGroup;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class DialogInterfaceOnDismissListenerC0097C4 extends AbstractDialogC2267r implements DialogInterface.OnDismissListener {

    public BrowserActivity f239b;

    public String f240c;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            DialogInterfaceOnDismissListenerC0097C4 dialogInterfaceOnDismissListenerC0097C4 = DialogInterfaceOnDismissListenerC0097C4.this;
            dialogInterfaceOnDismissListenerC0097C4.f240c = dialogInterfaceOnDismissListenerC0097C4.m401f(i);
        }
    }

    public class b implements OnDismissListener {
        public b() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) throws JSONException {
            C2061mf.m8471f0().executionPoint = DialogInterfaceOnDismissListenerC0097C4.this.f240c;
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("transId", "option_changed");
                jSONObject.put("selectedOptionName", C1224ai.m5285e().m5297m("script_execute_mode"));
                jSONObject.put("ex_point", DialogInterfaceOnDismissListenerC0097C4.this.f240c);
                C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public DialogInterfaceOnDismissListenerC0097C4(BrowserActivity browserActivity, String str) {
        super(browserActivity);
        this.f240c = null;
        this.f239b = browserActivity;
        setOnDismissListener(this);
        this.f240c = str;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_choose_ex_point);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        radioGroup.check(m400e());
        radioGroup.setOnCheckedChangeListener(new a());
        setOnDismissListener(new b());
    }

    public final int m400e() {
        return TextUtils.isEmpty(this.f240c) ? R.id.ex_point_auto_load : this.f240c.equals("ep.menu.tool") ? R.id.ex_point_page_t_menu : this.f240c.equals("ep.menu.context") ? R.id.ex_point_page_c_menu : this.f240c.equals("ep.menu.main") ? R.id.ex_point_m_menu : R.id.ex_point_auto_load;
    }

    public final String m401f(int i) {
        if (i == R.id.ex_point_page_t_menu) {
            return "ep.menu.tool";
        }
        if (i == R.id.ex_point_page_c_menu) {
            return "ep.menu.context";
        }
        if (i == R.id.ex_point_m_menu) {
            return "ep.menu.main";
        }
        return null;
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) {
    }
}
