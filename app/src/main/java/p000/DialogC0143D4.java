package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioGroup;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class DialogC0143D4 extends AbstractDialogC2267r {

    public BrowserActivity f346b;

    public int f347c;

    public RadioGroup f348d;

    public String f349e;

    public class a implements OnDismissListener {
        public a() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            DialogC0143D4.this.f346b.m6361u0("updateSelectButtonText()");
        }
    }

    public class b implements RadioGroup.OnCheckedChangeListener {
        public b() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            BrowserActivity browserActivity;
            int i2;
            if (i == R.id.sr_portrait) {
                DialogC0143D4.this.f349e = "portrait";
                browserActivity = DialogC0143D4.this.f346b;
                i2 = 1;
            } else {
                if (i != R.id.sr_landscape) {
                    if (i == R.id.sr_auto) {
                        DialogC0143D4.this.f349e = "auto";
                        browserActivity = DialogC0143D4.this.f346b;
                        i2 = -1;
                    }
                    SharedPreferencesHelper.getInstance().m6863K0(DialogC0143D4.this.f349e);
                    DialogC0143D4.this.dismiss();
                }
                DialogC0143D4.this.f349e = "landscape";
                browserActivity = DialogC0143D4.this.f346b;
                i2 = 0;
            }
            browserActivity.setRequestedOrientation(i2);
            SharedPreferencesHelper.getInstance().m6863K0(DialogC0143D4.this.f349e);
            DialogC0143D4.this.dismiss();
        }
    }

    public DialogC0143D4(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f348d = null;
        this.f349e = null;
        this.f346b = browserActivity;
        this.f349e = SharedPreferencesHelper.getInstance().m6880U();
    }

    @Override
    public void mo320a(Bundle bundle) {
        int i;
        setContentView(R.layout.dlg_screen_rotation);
        setOnDismissListener(new a());
        this.f348d = (RadioGroup) findViewById(R.id.radioGroup);
        if (this.f349e.equals("portrait")) {
            i = R.id.sr_portrait;
        } else {
            if (!this.f349e.equals("landscape")) {
                if (this.f349e.equals("auto")) {
                    i = R.id.sr_auto;
                }
                this.f348d.check(this.f347c);
                this.f348d.setOnCheckedChangeListener(new b());
            }
            i = R.id.sr_landscape;
        }
        this.f347c = i;
        this.f348d.check(this.f347c);
        this.f348d.setOnCheckedChangeListener(new b());
    }
}
