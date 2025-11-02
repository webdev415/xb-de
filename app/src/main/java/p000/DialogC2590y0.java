package p000;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class DialogC2590y0 extends AbstractDialogC2267r {

    public BrowserActivity f8042b;

    public TextView f8043c;

    public DialogC2590y0(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f8043c = null;
        this.f8042b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_font_seek_bar);
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        this.f8043c = (TextView) findViewById(R.id.text_progress);
        seekBar.setMax(20);
        int iM6891d0 = SharedPreferencesHelper.getInstance().m6891d0();
        Log.i("font-size", "current progress :" + iM6891d0);
        seekBar.setOnSeekBarChangeListener(new a());
        seekBar.setProgress(iM6891d0);
        this.f8043c.setText(SharedPreferencesHelper.encodeValue(iM6891d0) + "%");
    }

    public class a implements SeekBar.OnSeekBarChangeListener {
        public a() {
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (SharedPreferencesHelper.getInstance().m6891d0() != i) {
                DialogC2590y0.this.f8043c.setText(SharedPreferencesHelper.encodeValue(i) + "%");
                SharedPreferencesHelper.getInstance().m6866M0(i);
                DialogC2590y0.this.f8042b.m6280X2();
            }
        }

        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    }
}
