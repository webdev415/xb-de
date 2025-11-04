package p000;

import android.content.Intent;
import android.database.SQLException;
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
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public abstract class BaseViewOnClickListenerC1638Da extends BaseDialog implements View.OnClickListener {

    public BrowserActivity f5312b;

    public String f5313c;

    public String f5314d;

    public class c extends URLSpan {
        public c(String str) {
            super(str);
        }

        @Override
        public void onClick(View view) {
            mo6387f(this);
        }
    }

    public BaseViewOnClickListenerC1638Da(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f5313c = null;
        this.f5314d = null;
        this.f5312b = browserActivity;
        setCancelable(false);
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_elua_info);
        TextView textView = (TextView) findViewById(R.id.title_info);
        if (!TextUtils.isEmpty(this.f5313c)) {
            textView.setText(this.f5313c);
        }
        TextView textView2 = (TextView) findViewById(R.id.elua_info);
        String string = getContext().getString(R.string.str_elua_info);
        if (TextUtils.isEmpty(this.f5314d)) {
            this.f5314d = string;
        } else {
            textView2.setText(this.f5314d);
        }
        textView2.setText(Html.fromHtml(this.f5314d));
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
        Button button = (Button) findViewById(R.id.btn_cancel);
        String strM7320b = m7320b();
        if (!TextUtils.isEmpty(strM7320b)) {
            button.setText(strM7320b);
        }
        button.setOnClickListener(view -> {
            dismiss();
            mo6386e();
        });
        Button button2 = (Button) findViewById(R.id.btn_ok);
        String strMo6384c = mo6384c();
        if (!TextUtils.isEmpty(strMo6384c)) {
            button2.setText(strMo6384c);
        }
        button2.setOnClickListener(view -> {
            dismiss();
            mo6385d();
        });
    }

    public String m7320b() {
        return "";
    }

    public String mo6384c() {
        return "";
    }

    public abstract void mo6385d();

    public void mo6386e() throws SQLException {
        this.f5312b.finish();
    }

    public void mo6387f(URLSpan uRLSpan) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(uRLSpan.getURL()));
        getContext().startActivity(intent);
    }

    public BaseViewOnClickListenerC1638Da(BrowserActivity browserActivity, String str, String str2) {
        super(browserActivity);
        this.f5313c = null;
        this.f5314d = null;
        this.f5312b = browserActivity;
        setCancelable(false);
        this.f5313c = str;
        this.f5314d = str2;
    }

    @Override
    public void onClick(View view) {
    }
}
