package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import org.json.JSONException;

/* loaded from: classes.dex */
public class DialogInterfaceOnDismissListenerC1974kk extends AbstractDialogC2267r implements DialogInterface.OnDismissListener {

    public BrowserActivity f6026b;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            int iM8300c = DialogInterfaceOnDismissListenerC1974kk.this.m8300c(i);
            SharedPreferencesHelper.getInstance().recoveryTabType = iM8300c;
            SharedPreferencesHelper.getInstance().putInt("recovery_tab_type", iM8300c);
        }
    }

    public DialogInterfaceOnDismissListenerC1974kk(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6026b = browserActivity;
    }

    /* JADX INFO: Access modifiers changed from: private */
    public int m8300c(int i) {
        if (i == R.id.recovery) {
            return 0;
        }
        if (i == R.id.recovery_query) {
            return 1;
        }
        return i == R.id.recovery_never ? 2 : 0;
    }

    private int m8301d(int i) {
        return i == 0 ? R.id.recovery : i == 1 ? R.id.recovery_query : i == 2 ? R.id.recovery_never : R.id.recovery;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_recovery_tab_setting);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.recovery_tab_setting_group);
        radioGroup.check(m8301d(SharedPreferencesHelper.getInstance().recoveryTabType));
        radioGroup.setOnCheckedChangeListener(new a());
        setOnDismissListener(this);
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) throws JSONException {
        C1199a3.m5090f().m5096h("tab_revert_way");
    }
}
