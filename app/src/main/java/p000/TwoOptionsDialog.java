package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xbrowser.play.R;

public abstract class TwoOptionsDialog extends BaseDialog {

    public String title;

    public String strBtn1;

    public String strBtn2;

    public boolean btnClicked;

    public TwoOptionsDialog(Context context) {
        super(context);
        this.title = null;
        this.strBtn1 = null;
        this.strBtn2 = null;
        this.btnClicked = false;
        this.bottom = true;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_tow_options);
        ((TextView) findViewById(R.id.title_info)).setText(this.title);
        TextView textView = (TextView) findViewById(R.id.btn_option1);
        textView.setText(this.strBtn1);
        TextView textView2 = (TextView) findViewById(R.id.btn_option2);
        textView2.setText(this.strBtn2);
        textView.setOnClickListener(view -> {
            onButton1Clicked();
            btnClicked = true;
            dismiss();
        });
        textView2.setOnClickListener(view -> {
            onButton2Clicked();
            btnClicked = true;
            dismiss();
        });
        setOnDismissListener(dialogInterface -> {
            if (!btnClicked) {
                onDismissClicked();
            }
        });
    }

    public abstract void onDismissClicked();

    public abstract void onButton1Clicked();

    public abstract void onButton2Clicked();

    public void show(String title, String strBtn1, String strBtn2) {
        this.title = title;
        this.strBtn1 = strBtn1;
        this.strBtn2 = strBtn2;
        show();
    }
}
