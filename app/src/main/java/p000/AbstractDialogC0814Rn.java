package p000;

import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public abstract class AbstractDialogC0814Rn extends AbstractDialogC2267r {

    public String f2421b;

    public String f2422c;

    public String f2423d;

    public boolean f2424e;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC0814Rn.this.mo3830c();
            AbstractDialogC0814Rn abstractDialogC0814Rn = AbstractDialogC0814Rn.this;
            abstractDialogC0814Rn.f2424e = true;
            abstractDialogC0814Rn.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC0814Rn.this.mo3831d();
            AbstractDialogC0814Rn abstractDialogC0814Rn = AbstractDialogC0814Rn.this;
            abstractDialogC0814Rn.f2424e = true;
            abstractDialogC0814Rn.dismiss();
        }
    }

    public class c implements OnDismissListener {
        public c() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            AbstractDialogC0814Rn abstractDialogC0814Rn = AbstractDialogC0814Rn.this;
            if (abstractDialogC0814Rn.f2424e) {
                return;
            }
            abstractDialogC0814Rn.mo3829b();
        }
    }

    public AbstractDialogC0814Rn(Context context) {
        super(context);
        this.f2421b = null;
        this.f2422c = null;
        this.f2423d = null;
        this.f2424e = false;
        this.f6858a = true;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_tow_options);
        ((TextView) findViewById(R.id.title_info)).setText(this.f2421b);
        TextView textView = (TextView) findViewById(R.id.btn_option1);
        textView.setText(this.f2422c);
        TextView textView2 = (TextView) findViewById(R.id.btn_option2);
        textView2.setText(this.f2423d);
        textView.setOnClickListener(new a());
        textView2.setOnClickListener(new b());
        setOnDismissListener(new c());
    }

    public abstract void mo3829b();

    public abstract void mo3830c();

    public abstract void mo3831d();

    public void m3832e(String str, String str2, String str3) {
        this.f2421b = str;
        this.f2422c = str2;
        this.f2423d = str3;
        show();
    }
}
