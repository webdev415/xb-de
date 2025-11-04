package p000;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Gravity;
import android.view.Window;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public abstract class AbstractDialogC2267r extends Dialog {

    public boolean f6858a;

    public AbstractDialogC2267r(Context context) {
        super(context);
        this.f6858a = false;
    }

    public abstract void mo320a(Bundle bundle);

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        requestWindowFeature(1);
        int i2 = getContext().getResources().getConfiguration().uiMode;
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg_dark);
        } else {
            getWindow().setBackgroundDrawableResource(R.drawable.dialog_bg_light);
        }
        if (this.f6858a) {
            getWindow().getDecorView().setMinimumWidth(getContext().getResources().getDisplayMetrics().widthPixels);
            getWindow().getAttributes().gravity = Gravity.BOTTOM;
            getWindow().setGravity(Gravity.BOTTOM);
        }
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss(DialogInterface dialogInterface) {
                BrowserActivity.getActivity().m6339m2(new Handler());
            }
        });
        mo320a(bundle);
    }
}
