package p000;

import android.os.Bundle;
import android.widget.Button;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class SetDefaultBrowserDialog extends BaseDialog {

    public BrowserActivity browserActivity;

    public SetDefaultBrowserDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_set_default_browser);
        ((Button) findViewById(R.id.btn_go)).setOnClickListener(view -> {
            onGo();
            dismiss();
        });
    }

    public abstract void onGo();
}
