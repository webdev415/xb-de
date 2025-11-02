package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class AbstractDialogC0537Ll extends AbstractDialogC2267r {

    public BrowserActivity f1730b;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC0537Ll.this.mo317b();
            AbstractDialogC0537Ll.this.dismiss();
        }
    }

    public AbstractDialogC0537Ll(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f1730b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_set_default_browser);
        ((Button) findViewById(R.id.btn_go)).setOnClickListener(new a());
    }

    public abstract void mo317b();
}
