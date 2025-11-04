package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class BaseDialogC1042Wl extends BaseDialog {

    public BrowserActivity browserActivity;

    public String f3107c;

    public int f3108d;

    public BaseDialogC1042Wl(BrowserActivity browserActivity, int i) {
        super(browserActivity);
        this.f3107c = null;
        this.browserActivity = browserActivity;
        this.f3108d = i;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_single_text_field);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        Button button = (Button) findViewById(R.id.btn_ok);
        editText.setText(this.f3107c);
        if (f3108d != 0) {
            editText.setHint(f3108d);
        }
        button.setOnClickListener(view -> {
            mo4538b(editText.getText().toString());
            dismiss();
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> dismiss());
    }

    public abstract void mo4538b(String str);
}
