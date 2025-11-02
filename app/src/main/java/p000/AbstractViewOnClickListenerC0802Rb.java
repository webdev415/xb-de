package p000;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.Html;
import android.text.Spannable;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public abstract class AbstractViewOnClickListenerC0802Rb extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f2384b;

    public String f2385c;

    public String f2386d;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            SharedPreferencesHelper sharedPreferencesHelperM6833I;
            boolean z;
            if (((CheckBox) view).isChecked()) {
                sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                z = true;
            } else {
                sharedPreferencesHelperM6833I = SharedPreferencesHelper.getInstance();
                z = false;
            }
            sharedPreferencesHelperM6833I.putBoolean("show_fraud_alert", z);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractViewOnClickListenerC0802Rb.this.dismiss();
            AbstractViewOnClickListenerC0802Rb.this.mo3815c();
        }
    }

    public class c extends URLSpan {
        public c(String str) {
            super(str);
        }

        @Override
        public void onClick(View view) {
            AbstractViewOnClickListenerC0802Rb.this.m3816d(this);
        }
    }

    public AbstractViewOnClickListenerC0802Rb(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f2385c = null;
        this.f2386d = null;
        this.f2384b = browserActivity;
        setCancelable(false);
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_fraud_alert);
        TextView textView = (TextView) findViewById(R.id.title_info);
        if (!TextUtils.isEmpty(this.f2385c)) {
            textView.setText(this.f2385c);
        }
        TextView textView2 = (TextView) findViewById(R.id.fraud_alert_text);
        String string = getContext().getString(R.string.str_fraud_alert);
        if (TextUtils.isEmpty(this.f2386d)) {
            this.f2386d = string;
        } else {
            textView2.setText(this.f2386d);
        }
        textView2.setText(Html.fromHtml(this.f2386d));
        textView2.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = textView2.getText();
        int length = text.length();
        Spannable spannable = (Spannable) textView2.getText();
        URLSpan[] uRLSpanArr = (URLSpan[]) spannable.getSpans(0, length, URLSpan.class);
        SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(text);
        spannableStringBuilder.clearSpans();
        for (URLSpan uRLSpan : uRLSpanArr) {
            spannableStringBuilder.setSpan(new c(uRLSpan.getURL()), spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
        }
        textView2.setText(spannableStringBuilder);
        ((CheckBox) findViewById(R.id.check_do_not_show)).setOnClickListener(new a());
        Button button = (Button) findViewById(R.id.btn_ok);
        String strM3814b = m3814b();
        if (!TextUtils.isEmpty(strM3814b)) {
            button.setText(strM3814b);
        }
        button.setOnClickListener(new b());
    }

    public String m3814b() {
        return "";
    }

    public abstract void mo3815c();

    public void m3816d(URLSpan uRLSpan) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(uRLSpan.getURL()));
        getContext().startActivity(intent);
    }

    @Override
    public void onClick(View view) {
    }
}
