package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xbrowser.play.R;

public abstract class BaseDialogC0814Rn extends BaseDialog {

    public String title;

    public String strBtn1;

    public String strBtn2;

    public boolean f2424e;

    public BaseDialogC0814Rn(Context context) {
        super(context);
        this.title = null;
        this.strBtn1 = null;
        this.strBtn2 = null;
        this.f2424e = false;
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
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mo3830c();
                f2424e = true;
                dismiss();
            }
        });
        textView2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mo3831d();
                f2424e = true;
                dismiss();
            }
        });
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                if (!f2424e) {
                    mo3829b();
                }
            }
        });
    }

    public abstract void mo3829b();

    public abstract void mo3830c();

    public abstract void mo3831d();

    public void m3832e(String title, String strBtn1, String strBtn2) {
        this.title = title;
        this.strBtn1 = strBtn1;
        this.strBtn2 = strBtn2;
        show();
    }
}
