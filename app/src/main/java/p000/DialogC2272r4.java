package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.ScrollView;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import org.json.JSONException;
import org.json.JSONObject;

public class DialogC2272r4 extends BaseDialog {

    public BrowserActivity f6863b;

    public RadioGroup f6864c;

    public String f6865d;

    public String f6866e;

    public class a implements OnDismissListener {
        public a() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) throws JSONException {
            try {
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("transId", "option_changed");
                C1224ai c1224aiM5285e = C1224ai.getInstance();
                String str = DialogC2272r4.this.f6866e;
                DialogC2272r4 dialogC2272r4 = DialogC2272r4.this;
                jSONObject.put("selectedOptionName", c1224aiM5285e.m5293i(str, dialogC2272r4.f6863b.getLongPressDescription(dialogC2272r4.f6866e)));
                C1199a3.getInstance().m5094e("event_app_to_page", jSONObject);
            } catch (Exception unused) {
            }
        }
    }

    public class b implements RadioGroup.OnCheckedChangeListener {

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                DialogC2272r4.this.f6863b.getActivityDelegate().m6394C().m1435r();
            }
        }

        public b() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            DialogC2272r4 dialogC2272r4 = DialogC2272r4.this;
            dialogC2272r4.f6865d = dialogC2272r4.m9265i(dialogC2272r4.f6864c.getCheckedRadioButtonId());
            DialogC2272r4 dialogC2272r42 = DialogC2272r4.this;
            if (dialogC2272r42.m9264h(dialogC2272r42.f6866e, DialogC2272r4.this.f6865d)) {
                return;
            }
            SharedPreferencesHelper.getInstance().m6859I0(DialogC2272r4.this.f6866e, DialogC2272r4.this.f6865d);
            DialogC2272r4.this.dismiss();
            DialogC2272r4.this.f6863b.runOnUiThread(new a());
        }
    }

    public DialogC2272r4(BrowserActivity browserActivity, String str) {
        super(browserActivity);
        this.f6864c = null;
        this.f6865d = null;
        this.f6863b = browserActivity;
        this.f6866e = str;
    }

    @Override
    public void initView(Bundle bundle) {
        RadioButton radioButton;
        setContentView(R.layout.dlg_change_gesture);
        setOnDismissListener(new a());
        this.f6864c = (RadioGroup) findViewById(R.id.radioGroup);
        if (this.f6865d == null) {
            this.f6865d = SharedPreferencesHelper.getInstance().getDefaultActionForKey(this.f6866e);
        }
        if (this.f6866e.equals("double_click_blank") && (radioButton = (RadioButton) this.f6864c.findViewById(R.id.ac_toggle_fullscreen)) != null) {
            radioButton.setVisibility(View.VISIBLE);
        }
        if (this.f6866e.equals("push_bottom_toolbar_up")) {
            for (int i = 0; i < this.f6864c.getChildCount(); i++) {
                View childAt = this.f6864c.getChildAt(i);
                if (childAt.getId() == R.id.ac_goto_home || childAt.getId() == R.id.ac_do_search || childAt.getId() == R.id.ac_close_tab || childAt.getId() == R.id.ac_refresh || childAt.getId() == R.id.ac_none) {
                    childAt.setVisibility(View.VISIBLE);
                } else {
                    childAt.setVisibility(View.GONE);
                }
            }
            ScrollView scrollView = (ScrollView) findViewById(R.id.scroll_view_content);
            ViewGroup.LayoutParams layoutParams = scrollView.getLayoutParams();
            layoutParams.height = -2;
            scrollView.setLayoutParams(layoutParams);
        }
        this.f6864c.check(m9263g(this.f6865d));
        this.f6864c.setOnCheckedChangeListener(new b());
    }

    public final int m9263g(String str) {
        return str.equals("new_tab") ? R.id.ac_new_tab : str.equals("refresh") ? R.id.ac_refresh : str.equals("search") ? R.id.ac_do_search : str.equals("go_to_top") ? R.id.ac_goto_top : str.equals("go_to_bottom") ? R.id.ac_goto_bottom : str.equals("close_tab") ? R.id.ac_close_tab : str.equals("remove_tabs") ? R.id.ac_remove_tabs : str.equals("revert_tab") ? R.id.ac_revert_close_tab : str.equals("next_tab") ? R.id.ac_next_tab : str.equals("previous_tab") ? R.id.ac_previous_tab : str.equals("add_to_bm") ? R.id.ac_add_to_bm : str.equals("copy_url") ? R.id.ac_copy_url : str.equals("open_toolbox") ? R.id.ac_open_toolbox : str.equals("toggle_fullscreen") ? R.id.ac_toggle_fullscreen : str.equals("open_bookmark") ? R.id.ac_open_bm : str.equals("open_history") ? R.id.ac_open_his : str.equals("switch_search_engine") ? R.id.ac_switch_search : str.equals("go_to_home") ? R.id.ac_goto_home : R.id.ac_none;
    }

    public final boolean m9264h(String str, String str2) {
        int i = 0;
        while (true) {
            String[] strArr = SharedPreferencesHelper.f4840Y0;
            if (i >= strArr.length) {
                return false;
            }
            String str3 = strArr[i];
            String strM6855G = SharedPreferencesHelper.getInstance().getDefaultActionForKey(str3);
            if (!str2.equals("none") && strM6855G.equals(str2) && !str3.equals(str)) {
                Toast.makeText(this.f6863b, this.f6863b.getString(R.string.toast_action_has_bound) + "\"" + this.f6863b.getLongPressDescription(str3) + "\"", Toast.LENGTH_LONG).show();
                return false;
            }
            i++;
        }
    }

    public final String m9265i(int i) {
        return i == R.id.ac_goto_top ? "go_to_top" : i == R.id.ac_goto_bottom ? "go_to_bottom" : i == R.id.ac_do_search ? "search" : i == R.id.ac_refresh ? "refresh" : i == R.id.ac_new_tab ? "new_tab" : i == R.id.ac_remove_tabs ? "remove_tabs" : i == R.id.ac_close_tab ? "close_tab" : i == R.id.ac_revert_close_tab ? "revert_tab" : i == R.id.ac_next_tab ? "next_tab" : i == R.id.ac_previous_tab ? "previous_tab" : i == R.id.ac_add_to_bm ? "add_to_bm" : i == R.id.ac_copy_url ? "copy_url" : i == R.id.ac_open_toolbox ? "open_toolbox" : i == R.id.ac_toggle_fullscreen ? "toggle_fullscreen" : i == R.id.ac_open_bm ? "open_bookmark" : i == R.id.ac_open_his ? "open_history" : i == R.id.ac_switch_search ? "switch_search_engine" : i == R.id.ac_goto_home ? "go_to_home" : "none";
    }
}
