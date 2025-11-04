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

public class DialogInterfaceOnDismissListenerC0189E4 extends BaseDialog implements DialogInterface.OnDismissListener {

    public Context f458b;

    public ArrayList f459c;

    public class a implements RadioGroup.OnCheckedChangeListener {
        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            SharedPreferencesHelper.getInstance().putString("user_search_url", ((C1224ai.ThirdApp) DialogInterfaceOnDismissListenerC0189E4.this.f459c.get(i)).pkg.toString());
            SharedPreferencesHelper.getInstance().searchUrl = null;
            DialogInterfaceOnDismissListenerC0189E4.this.dismiss();
        }
    }

    public DialogInterfaceOnDismissListenerC0189E4(Context context) {
        super(context);
        this.f459c = null;
        this.f458b = context;
        setOnDismissListener(this);
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_choose_default_search);
        setOnDismissListener(this);
        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radioGroup);
        int dimension = (int) this.f458b.getResources().getDimension(R.dimen.std_margin);
        String strM6882V = SharedPreferencesHelper.getInstance().getSearchUrl();
        this.f459c = C1224ai.getInstance().getAppList("search_engine");
        int color = this.f458b.getColor(R.color.neutral_text_color);
        for (int i = 0; i < this.f459c.size(); i++) {
            String str = ((C1224ai.ThirdApp) this.f459c.get(i)).pkg;
            RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(-1, -2);
            RadioButton radioButton = new RadioButton(getContext());
            radioButton.setTextColor(0xFF000000);
            radioButton.setText(((C1224ai.ThirdApp) this.f459c.get(i)).name);
            radioButton.setId(i);
            radioButton.setTextColor(color);
            layoutParams.topMargin = dimension;
            layoutParams.bottomMargin = dimension;
            radioButton.setLayoutParams(layoutParams);
            radioGroup.addView(radioButton);
        }
        radioGroup.check(C1224ai.getInstance().m5291g("search_engine", strM6882V));
        radioGroup.setOnCheckedChangeListener(new a());
    }

    @Override
    public void onDismiss(DialogInterface dialogInterface) throws JSONException {
        C1199a3.getInstance().m5096h("search_engine");
    }
}
