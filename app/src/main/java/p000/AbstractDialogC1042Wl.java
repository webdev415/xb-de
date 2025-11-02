package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class AbstractDialogC1042Wl extends AbstractDialogC2267r {

    public BrowserActivity f3106b;

    public String f3107c;

    public int f3108d;

    public class a implements View.OnClickListener {

        public final EditText f3109a;

        public a(EditText editText) {
            this.f3109a = editText;
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1042Wl.this.mo4538b(this.f3109a.getText().toString());
            AbstractDialogC1042Wl.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1042Wl.this.dismiss();
        }
    }

    public AbstractDialogC1042Wl(BrowserActivity browserActivity, int i) {
        super(browserActivity);
        this.f3107c = null;
        this.f3106b = browserActivity;
        this.f3108d = i;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_single_text_field);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.btn_ok);
        editText.setText(this.f3107c);
        int i = this.f3108d;
        if (i != 0) {
            editText.setHint(i);
        }
        button.setOnClickListener(new a(editText));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public abstract void mo4538b(String str);
}
