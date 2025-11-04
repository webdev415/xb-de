package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.RelativeLayout;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;
import org.json.JSONException;

public class DialogInterfaceOnDismissListenerC2226q4 extends BaseDialog implements DialogInterface.OnDismissListener {

    public Context f6676b;

    public ArrayList f6677c;

    public int f6678d;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            SharedPreferencesHelper.getInstance().putString("default_downloader", ((C1224ai.ThirdApp) DialogInterfaceOnDismissListenerC2226q4.this.f6677c.get(i)).pkg);
            DialogInterfaceOnDismissListenerC2226q4.this.f6678d = i;
        }
    }

    public DialogInterfaceOnDismissListenerC2226q4(Context context) {
        super(context);
        this.f6678d = -1;
        this.f6676b = context;
        setOnDismissListener(this);
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_choose_default_search);
        setOnDismissListener(this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int dimension = (int) this.f6676b.getResources().getDimension(R.dimen.std_margin);
        String strM6871P = SharedPreferencesHelper.getInstance().getString("default_downloader", "");
        this.f6677c = C1224ai.getInstance().getAppList("downloader");
        int color = this.f6676b.getColor(R.color.neutral_text_color);
        for (int i = 0; i < this.f6677c.size(); i++) {
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setTextColor(0xFF000000);
            radioButton.setText(((C1224ai.ThirdApp) this.f6677c.get(i)).name);
            if (((C1224ai.ThirdApp) this.f6677c.get(i)).pkg.equals(strM6871P)) {
                this.f6678d = i;
            }
            radioButton.setId(i);
            radioButton.setTextColor(color);
            layoutParams.topMargin = dimension;
            layoutParams.bottomMargin = dimension;
            radioButton.setLayoutParams(layoutParams);
            radioGroup.addView(radioButton);
        }
        radioGroup.check(this.f6678d);
        radioGroup.setOnCheckedChangeListener(new a());
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) throws JSONException {
        C1199a3.getInstance().m5096h("downloader");
    }
}
