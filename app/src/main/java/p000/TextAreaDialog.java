package p000;

import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public class TextAreaDialog extends BaseDialog {

    public BrowserActivity browserActivity;

    public String strInfo;

    public String f2417d;

    public int f2418e;

    public TextAreaDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.strInfo = null;
        this.f2417d = null;
        this.f2418e = 0;
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_area_text_box);
        EditText editText = (EditText) findViewById(R.id.text_info);
        editText.setText(this.strInfo);
        editText.selectAll();
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setText(R.string.btn_text_share);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) throws Resources.NotFoundException {
                onShare();
                dismiss();
            }
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCancel();
                dismiss();
            }
        });
    }

    public void onCancel() {
        dismiss();
    }

    public void onShare() throws Resources.NotFoundException {
        AndroidSystemUtils.share(getContext(), ((EditText) findViewById(R.id.text_info)).getEditableText().toString(), this.f2417d, getContext().getResources().getString(R.string.choose_app));
        if (this.f2418e == 0) {
            EventQueueManager.getInstance().processEvent(7);
        }
    }

    public void m3828d(String str, String str2, int i) {
        this.f2417d = str2;
        this.strInfo = str;
        this.f2418e = i;
        show();
    }
}
