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

public abstract class EluaInfoDialog extends BaseDialog implements View.OnClickListener {

    public BrowserActivity browserActivity;

    public String title;

    public String eluaInfo;

    public EluaInfoDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.title = null;
        this.eluaInfo = null;
        this.browserActivity = browserActivity;
        setCancelable(false);
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_elua_info);
        TextView tvTitle = (TextView) findViewById(R.id.title_info);
        if (!TextUtils.isEmpty(this.title)) {
            tvTitle.setText(this.title);
        }
        TextView tvInfo = (TextView) findViewById(R.id.elua_info);
        String string = getContext().getString(R.string.str_elua_info);
        if (TextUtils.isEmpty(this.eluaInfo)) {
            this.eluaInfo = string;
        } else {
            tvInfo.setText(this.eluaInfo);
        }
        tvInfo.setText(Html.fromHtml(this.eluaInfo));
        tvInfo.setMovementMethod(LinkMovementMethod.getInstance());
        CharSequence text = tvInfo.getText();
        Spannable spannable = (Spannable) tvInfo.getText();
        URLSpan[] uRLSpanArr = spannable.getSpans(0, text.length(), URLSpan.class);
        SpannableStringBuilder builder = new SpannableStringBuilder(text);
        builder.clearSpans();
        for (URLSpan uRLSpan : uRLSpanArr) {
            builder.setSpan(new URLSpan(uRLSpan.getURL()) {
                @Override
                public void onClick(View view) {
                    handleUrlClick(this);
                }
            }, spannable.getSpanStart(uRLSpan), spannable.getSpanEnd(uRLSpan), 33);
        }
        tvInfo.setText(builder);
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        String cancelLabel = getCancelLabel();
        if (!TextUtils.isEmpty(cancelLabel)) {
            btnCancel.setText(cancelLabel);
        }
        btnCancel.setOnClickListener(view -> {
            dismiss();
            onCancel();
        });
        Button btnOK = (Button) findViewById(R.id.btn_ok);
        String okLabel = getOKLabel();
        if (!TextUtils.isEmpty(okLabel)) {
            btnOK.setText(okLabel);
        }
        btnOK.setOnClickListener(view -> {
            dismiss();
            onOK();
        });
    }

    public String getCancelLabel() {
        return "";
    }

    public String getOKLabel() {
        return "";
    }

    public abstract void onOK();

    public void onCancel() throws SQLException {
        this.browserActivity.finish();
    }

    public void handleUrlClick(URLSpan uRLSpan) {
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setData(Uri.parse(uRLSpan.getURL()));
        getContext().startActivity(intent);
    }

    public EluaInfoDialog(BrowserActivity browserActivity, String title, String elua) {
        super(browserActivity);
        this.title = null;
        this.eluaInfo = null;
        this.browserActivity = browserActivity;
        setCancelable(false);
        this.title = title;
        this.eluaInfo = elua;
    }

    @Override
    public void onClick(View view) {
    }
}
