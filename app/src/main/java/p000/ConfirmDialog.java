package p000;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;

import com.xbrowser.play.R;

public abstract class ConfirmDialog extends BaseDialog {

    public String strTitle;

    public String strContent;

    public String strCheckbox;

    public int type;

    public ConfirmDialog(Context context) {
        this(context, 0);
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_confirm);
        TextView tvTitleInfo = (TextView) findViewById(R.id.title_info);
        TextView tvText = (TextView) findViewById(R.id.text_info);
        tvTitleInfo.setText(this.strTitle);
        tvText.setText(this.strContent);
        CheckBox checkBox = (CheckBox) findViewById(R.id.another_condition);
        if (checkBox != null && strCheckbox != null) {
            checkBox.setVisibility(View.VISIBLE);
            checkBox.setText(strCheckbox);
        }
        Button button = (Button) findViewById(R.id.btn_ok);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onOK();
                dismiss();
            }
        });
        Button btnCancel = (Button) findViewById(R.id.btn_cancel);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onCancel();
                dismiss();
            }
        });
        if (type == 1) {
            button.setText(R.string.btn_text_allow);
            btnCancel.setText(R.string.btn_text_deny);
        } else if (type == 2) {
            button.setText(R.string.btn_text_send);
            btnCancel.setText(R.string.btn_text_finish);
        }
    }

    public abstract void onCancel();

    public abstract void onOK();

    public void show(String title, String content) {
        show(title, content, null);
    }

    public void show(String title, String content, String checkbox) {
        this.strTitle = title;
        this.strContent = content;
        this.strCheckbox = checkbox;
        show();
    }

    public ConfirmDialog(Context context, int type) {
        super(context);
        this.strTitle = null;
        this.strContent = null;
        this.strCheckbox = null;
        this.type = type;
    }
}
