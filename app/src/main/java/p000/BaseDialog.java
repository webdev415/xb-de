package p000;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;

import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public abstract class BaseDialog extends Dialog {

    public boolean bottom;

    public BaseDialog(Context context) {
        super(context);
        this.bottom = false;
    }

    public abstract void initView(Bundle bundle);

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        int uiMode = getContext().getResources().getConfiguration().uiMode;
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg_dark);
        } else {
            getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg_light);
        }
        if (this.bottom) {
            getWindow().getDecorView().setMinimumWidth(getContext().getResources().getDisplayMetrics().widthPixels);
            getWindow().getAttributes().gravity = Gravity.BOTTOM;
            getWindow().setGravity(Gravity.BOTTOM);
        }
        setOnDismissListener(dialogInterface -> BrowserActivity.getActivity().handleClipboardUrl(new Handler()));
        initView(bundle);
    }
}
