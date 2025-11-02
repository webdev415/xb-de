package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.io.File;

public class ViewOnClickListenerC2109nh extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f6461b;

    public String f6462c;

    public class a implements View.OnClickListener {

        public final EditText f6463a;

        public a(EditText editText) {
            this.f6463a = editText;
        }

        @Override
        public void onClick(View view) {
            String string = this.f6463a.getText().toString();
            String str = ViewOnClickListenerC2109nh.this.f6462c;
            String str2 = File.separator;
            if (!str.endsWith(str2)) {
                ViewOnClickListenerC2109nh.this.f6462c = ViewOnClickListenerC2109nh.this.f6462c + str2;
            }
            if (new File(ViewOnClickListenerC2109nh.this.f6462c + string).mkdir()) {
                ViewOnClickListenerC2109nh.this.f6461b.refreshQuickAccessUI();
            } else {
                Toast.makeText(ViewOnClickListenerC2109nh.this.f6461b, "Create dir failed", Toast.LENGTH_SHORT).show();
            }
            ViewOnClickListenerC2109nh.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC2109nh.this.dismiss();
        }
    }

    public ViewOnClickListenerC2109nh(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6462c = null;
        this.f6461b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_single_text_field);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        editText.setHint(R.string.dlg_bm_dir_hit);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new a(editText));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public void m8786b(String str) {
        this.f6462c = str;
        show();
    }

    @Override
    public void onClick(View view) {
    }
}
