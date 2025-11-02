package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import org.json.JSONException;

/* loaded from: classes.dex */
public class DialogInterfaceOnDismissListenerC0554M1 extends AbstractDialogC2267r implements DialogInterface.OnDismissListener {

    public BrowserActivity f1748b;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            SharedPreferencesHelper.getInstance().putInt("auto_backup_circle", DialogInterfaceOnDismissListenerC0554M1.this.m2811c(i));
        }
    }

    public DialogInterfaceOnDismissListenerC0554M1(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f1748b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_auto_backup_setting);
        setOnDismissListener(this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.update_setting_group);
        radioGroup.check(m2812d(SharedPreferencesHelper.getInstance().getInt("auto_backup_circle", 4)));
        radioGroup.setOnCheckedChangeListener(new a());
    }

    public final int m2811c(int i) {
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

    public final int m2812d(int i) {
        return i == 1 ? R.id.one_day : i == 2 ? R.id.three_days : i == 3 ? R.id.five_days : i == 4 ? R.id.seven_days : R.id.never_backup;
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) throws JSONException {
        C1199a3.m5090f().m5096h("auto_backup_cycle");
    }
}
