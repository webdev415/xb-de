package p000;

import android.app.Dialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Handler;
import android.view.Window;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public abstract class AbstractDialogC2267r extends Dialog {

    public boolean f6858a;

    public class a implements OnDismissListener {
        public a() {
        }

        @Override
        public void onDismiss(DialogInterface dialogInterface) {
            BrowserActivity.getActivity().m6339m2(new Handler());
        }
    }

    public AbstractDialogC2267r(Context context) {
        super(context);
        this.f6858a = false;
    }

    public abstract void mo320a(Bundle bundle);

    @Override
    public void onCreate(Bundle bundle) {
        Window window;
        int i;
        super.onCreate(bundle);
        requestWindowFeature(1);
        int i2 = getContext().getResources().getConfiguration().uiMode;
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            window = getWindow();
            i = R.drawable.dialog_bg_dark;
        } else {
            window = getWindow();
            i = R.drawable.dialog_bg_light;
        }
        window.setBackgroundDrawableResource(i);
        if (this.f6858a) {
            getWindow().getDecorView().setMinimumWidth(getContext().getResources().getDisplayMetrics().widthPixels);
            getWindow().getAttributes().gravity = 80;
            getWindow().setGravity(80);
        }
        setOnDismissListener(new a());
        mo320a(bundle);
    }
}
