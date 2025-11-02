package p000;

import android.os.Bundle;
import android.widget.RadioGroup;

import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class DialogC2180p4 extends AbstractDialogC2267r {

    public BrowserActivity f6624b;

    public RadioGroup f6625c;

    public class a implements RadioGroup.OnCheckedChangeListener {

        public class RunnableC2720a implements Runnable {
            public RunnableC2720a() {
            }

            @Override
            public void run() {
                f6624b.m6361u0("update_bf_gesture_name()");
            }
        }

        public a() {
        }

        @Override
        public void onCheckedChanged(RadioGroup radioGroup, int i) {
            if (i == R.id.bf_gesture_none) {
                SharedPreferencesHelper.getInstance().gestureMode = 0;
                SharedPreferencesHelper.getInstance().putInt("back-forward-gesture-trigger-type", 0);
            } else if (i == R.id.bf_gesture_normal) {
                SharedPreferencesHelper.getInstance().gestureMode = 1;
                SharedPreferencesHelper.getInstance().putInt("back-forward-gesture-trigger-type", 1);
            } else if (i == R.id.bf_gesture_edge) {
                SharedPreferencesHelper.getInstance().gestureMode = 2;
                SharedPreferencesHelper.getInstance().putInt("back-forward-gesture-trigger-type", 2);
            } else if (i == R.id.bf_gesture_bottom) {
                SharedPreferencesHelper.getInstance().gestureMode = 3;
                SharedPreferencesHelper.getInstance().putInt("back-forward-gesture-trigger-type", 3);
            }
            f6624b.runOnUiThread(new RunnableC2720a());
            dismiss();
        }
    }

    public DialogC2180p4(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6625c = null;
        this.f6624b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        RadioGroup radioGroup;
        int i;
        setContentView(R.layout.dlg_change_bf_gesture);
        this.f6625c = (RadioGroup) findViewById(R.id.radioGroup);
        int i2 = SharedPreferencesHelper.getInstance().gestureMode;
        if (i2 == 0) {
            radioGroup = this.f6625c;
            i = R.id.bf_gesture_none;
        } else if (i2 == 1) {
            radioGroup = this.f6625c;
            i = R.id.bf_gesture_normal;
        } else {
            if (i2 != 2) {
                if (i2 == 3) {
                    radioGroup = this.f6625c;
                    i = R.id.bf_gesture_bottom;
                }
                this.f6625c.setOnCheckedChangeListener(new a());
            }
            radioGroup = this.f6625c;
            i = R.id.bf_gesture_edge;
        }
        radioGroup.check(i);
        this.f6625c.setOnCheckedChangeListener(new a());
    }
}
