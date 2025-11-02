package p000;

import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.C1570e;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.net.URISyntaxException;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class DialogC0235F4 extends AbstractDialogC2267r {

    public static String f635g;

    public BrowserActivity f636b;

    public RadioGroup f637c;

    public String f638d;

    public boolean f639e;

    public String f640f;

    public class a implements OnDismissListener {
        public a() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            C1199a3.m5090f().m5097i("choose_ua_done");
        }
    }

    public class b implements RadioGroup.OnCheckedChangeListener {

        public class a implements Runnable {

            public final String f643l;

            public a(String str) {
                this.f643l = str;
            }

            @Override
            public void run() throws URISyntaxException {
                DialogC0235F4.this.f636b.m6280X2();
                if (this.f643l.equals("ua_desktop")) {
                    DialogC0235F4.this.f636b.m6348p2(true);
                } else {
                    DialogC0235F4.this.f636b.refreshQuickAccessUI();
                }
            }
        }

        public b() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            String str = (String) DialogC0235F4.this.f637c.findViewById(i).getTag();
            DialogC0235F4.this.dismiss();
            if (DialogC0235F4.this.f640f == null) {
                SharedPreferencesHelper.getInstance().m6856G0(str);
                DialogC0235F4.this.f636b.getHandler().post(new a(str));
            } else {
                C1570e.getInstance().m6958a(2, DialogC0235F4.this.f640f, str);
            }
            DialogC0235F4.f635g = str;
        }
    }

    public DialogC0235F4(BrowserActivity browserActivity) {
        this(browserActivity, true);
    }

    @Override
    public void mo320a(Bundle bundle) {
        int dimension = (int) this.f636b.getResources().getDimension(R.dimen.std_margin);
        setContentView(R.layout.dlg_choose_ua);
        setOnDismissListener(new a());
        this.f637c = (RadioGroup) findViewById(R.id.radioGroup);
        ArrayList arrayListM6889b0 = SharedPreferencesHelper.getInstance().getUserAgentList();
        if (this.f638d == null) {
            this.f638d = SharedPreferencesHelper.getInstance().getString("user_agent", "ua_default");
        }
        int color = this.f636b.getColor(R.color.neutral_text_color);
        for (int i = 0; i < arrayListM6889b0.size(); i++) {
            SharedPreferencesHelper.UserAgent userAgentVar = (SharedPreferencesHelper.UserAgent) arrayListM6889b0.get(i);
            RadioButton radioButton = new RadioButton(getContext());
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            layoutParams.topMargin = dimension;
            layoutParams.bottomMargin = dimension;
            radioButton.setLayoutParams(layoutParams);
            radioButton.setText(userAgentVar.title);
            radioButton.setTextColor(color);
            radioButton.setId(Math.abs(userAgentVar.id.hashCode()));
            radioButton.setTag(userAgentVar.id);
            this.f637c.addView(radioButton);
            if (this.f638d.equals(userAgentVar.id)) {
                radioButton.setChecked(true);
            }
        }
        this.f637c.setOnCheckedChangeListener(new b());
    }

    public DialogC0235F4(BrowserActivity browserActivity, String str) {
        String str2;
        super(browserActivity);
        this.f637c = null;
        this.f638d = null;
        this.f639e = true;
        this.f636b = browserActivity;
        this.f640f = str;
        C1570e.Host hostVarM6982X = C1570e.getInstance().getHost(2, this.f640f);
        if (hostVarM6982X == null || (str2 = hostVarM6982X.extra) == null) {
            return;
        }
        this.f638d = str2;
    }

    public DialogC0235F4(BrowserActivity browserActivity, boolean z) {
        super(browserActivity);
        this.f637c = null;
        this.f638d = null;
        this.f640f = null;
        this.f636b = browserActivity;
        this.f639e = z;
    }
}
