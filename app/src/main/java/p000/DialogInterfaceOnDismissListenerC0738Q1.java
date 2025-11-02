package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import org.json.JSONException;

/* loaded from: classes.dex */
public class DialogInterfaceOnDismissListenerC0738Q1 extends AbstractDialogC2267r implements DialogInterface.OnDismissListener {

    public BrowserActivity f2190b;

    public String f2191c;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int iM3623c = DialogInterfaceOnDismissListenerC0738Q1.this.m3623c(i);
            SharedPreferencesHelper.getInstance().adRuleUpdateCircle = iM3623c;
            SharedPreferencesHelper.getInstance().putInt("ad_rule_update_circle", iM3623c);
        }
    }

    public DialogInterfaceOnDismissListenerC0738Q1(BrowserActivity browserActivity, String str) {
        super(browserActivity);
        this.f2190b = browserActivity;
        this.f2191c = str;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m3623c(int i) {
        if (i == R.id.one_day) {
            return 1;
        }
        if (i == R.id.three_days) {
            return 2;
        }
        if (i == R.id.five_days) {
            return 3;
        }
        return i == R.id.seven_days ? 4 : 0;
    }

    private int m3624d(int i) {
        return i == 1 ? R.id.one_day : i == 2 ? R.id.three_days : i == 3 ? R.id.five_days : i == 4 ? R.id.seven_days : R.id.never_backup;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_auto_update_setting);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.update_setting_group);
        radioGroup.check(m3624d(SharedPreferencesHelper.getInstance().adRuleUpdateCircle));
        radioGroup.setOnCheckedChangeListener(new a());
        setOnDismissListener(this);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) throws JSONException {
        C1199a3.m5090f().m5096h(this.f2191c);
    }
}
