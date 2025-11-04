package p000;

import android.content.DialogInterface;
import android.content.res.Resources;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;
import org.json.JSONException;

public class DialogInterfaceOnDismissListenerC2318s4 extends BaseDialog implements DialogInterface.OnDismissListener {

    public BrowserActivity f7009b;

    public CharSequence f7010c;

    public int f7011d;

    public ArrayList f7012e;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            DialogInterfaceOnDismissListenerC2318s4 dialogInterfaceOnDismissListenerC2318s4 = DialogInterfaceOnDismissListenerC2318s4.this;
            dialogInterfaceOnDismissListenerC2318s4.f7011d = i;
            dialogInterfaceOnDismissListenerC2318s4.f7010c = ((C1224ai.ThirdApp) dialogInterfaceOnDismissListenerC2318s4.f7012e.get(i)).pkg;
        }
    }

    public DialogInterfaceOnDismissListenerC2318s4(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f7010c = null;
        this.f7011d = -1;
        this.f7012e = null;
        this.f7009b = browserActivity;
        setOnDismissListener(this);
        this.f7012e = C1224ai.getInstance().getAppList("language");
    }

    @Override
    public void initView(Bundle bundle) throws JSONException, Resources.NotFoundException {
        setOnDismissListener(this);
        setContentView(R.layout.dlg_change_language);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int dimension = (int) this.f7009b.getResources().getDimension(R.dimen.std_margin);
        getContext().getResources();
        String str = SharedPreferencesHelper.getInstance().defaultLangCode;
        this.f7010c = str;
        if (TextUtils.isEmpty(str)) {
            this.f7010c = "";
        }
        int iM5291g = C1224ai.getInstance().m5291g("language", this.f7010c.toString());
        int color = this.f7009b.getColor(R.color.neutral_text_color);
        for (int i = 0; i < this.f7012e.size(); i++) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setTextColor(color);
            radioButton.setText(((C1224ai.ThirdApp) this.f7012e.get(i)).name);
            radioButton.setId(i);
            layoutParams.topMargin = dimension;
            layoutParams.bottomMargin = dimension;
            radioButton.setLayoutParams(layoutParams);
            radioGroup.addView(radioButton);
        }
        radioGroup.check(iM5291g);
        radioGroup.setOnCheckedChangeListener(new a());
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) throws JSONException {
        CharSequence charSequence = this.f7010c;
        if (charSequence != null && !charSequence.equals(SharedPreferencesHelper.getInstance().defaultLangCode) && ((!TextUtils.isEmpty(SharedPreferencesHelper.getInstance().defaultLangCode) || !TextUtils.isEmpty(this.f7010c)) && !this.f7010c.equals(SharedPreferencesHelper.getInstance().defaultLangCode))) {
            String string = this.f7010c.toString();
            SharedPreferencesHelper.getInstance().defaultLangCode = string;
            SharedPreferencesHelper.getInstance().putString("default_lang_code", string);
            SharedPreferencesHelper.getInstance().m6931z0();
            Toast.makeText(this.f7009b, R.string.toast_change_language, Toast.LENGTH_LONG).show();
        }
        C1199a3.getInstance().m5096h("language");
    }
}
