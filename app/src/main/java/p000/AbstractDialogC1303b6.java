package p000;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.xbrowser.play.R;

public abstract class AbstractDialogC1303b6 extends AbstractDialogC2267r {

    public String f3842b;

    public String f3843c;

    public String f3844d;

    public int f3845e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1303b6.this.mo316c();
            AbstractDialogC1303b6.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1303b6.this.mo315b();
            AbstractDialogC1303b6.this.dismiss();
        }
    }

    public AbstractDialogC1303b6(Context context) {
        this(context, 0);
    }

    @Override
    public void mo320a(Bundle bundle) {
        int i;
        setContentView(R.layout.dlg_confirm);
        TextView textView = (TextView) findViewById(R.id.title_info);
        TextView textView2 = (TextView) findViewById(R.id.text_info);
        textView.setText(this.f3842b);
        textView2.setText(this.f3843c);
        CheckBox checkBox = (CheckBox) findViewById(R.id.another_condition);
        if (checkBox != null && this.f3844d != null) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setText(this.f3844d);
        }
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setOnClickListener(new a());
        Button button2 = (Button) findViewById(R.id.btn_cancel);
        button2.setOnClickListener(new b());
        int i2 = this.f3845e;
        if (i2 == 1) {
            button.setText(R.string.btn_text_allow);
            i = R.string.btn_text_deny;
        } else {
            if (i2 != 2) {
                return;
            }
            button.setText(R.string.btn_text_send);
            i = R.string.btn_text_finish;
        }
        button2.setText(i);
    }

    public abstract void mo315b();

    public abstract void mo316c();

    public void m5643d(String str, String str2) {
        m5644e(str, str2, null);
    }

    public void m5644e(String str, String str2, String str3) {
        this.f3842b = str;
        this.f3843c = str2;
        this.f3844d = str3;
        show();
    }

    public AbstractDialogC1303b6(Context context, int i) {
        super(context);
        this.f3842b = null;
        this.f3843c = null;
        this.f3844d = null;
        this.f3845e = i;
    }
}
