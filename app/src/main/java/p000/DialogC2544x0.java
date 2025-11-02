package p000;

import android.os.Bundle;
import android.provider.Settings;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.SeekBar;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class DialogC2544x0 extends AbstractDialogC2267r {

    public BrowserActivity f7929b;

    public TextView f7930c;

    public int f7931d;

    public int f7932e;

    public class a implements CompoundButton.OnCheckedChangeListener {

        public final SeekBar f7933a;

        public a(SeekBar seekBar) {
            this.f7933a = seekBar;
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            boolean z2;
            SeekBar seekBar;
            int i;
            if (z) {
                z2 = false;
                SharedPreferencesHelper.getInstance().putBoolean("support_adjust_brightness", false);
                SharedPreferencesHelper.getInstance().f4872O0 = false;
                DialogC2544x0.this.f7929b.m6245P(-1);
            } else {
                z2 = true;
                SharedPreferencesHelper.getInstance().f4872O0 = true;
                SharedPreferencesHelper.getInstance().putBoolean("support_adjust_brightness", true);
                if (SharedPreferencesHelper.getInstance().enterNightMode) {
                    DialogC2544x0.this.f7929b.m6245P(SharedPreferencesHelper.getInstance().nightBrightness);
                    seekBar = this.f7933a;
                    i = SharedPreferencesHelper.getInstance().nightBrightness;
                } else {
                    DialogC2544x0.this.f7929b.m6245P(SharedPreferencesHelper.getInstance().defaultBrightness);
                    seekBar = this.f7933a;
                    i = SharedPreferencesHelper.getInstance().defaultBrightness;
                }
                seekBar.setProgress(i);
            }
            this.f7933a.setEnabled(z2);
        }
    }

    public DialogC2544x0(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f7930c = null;
        this.f7929b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        int i;
        setContentView(R.layout.dlg_brightness_seek_bar);
        m10623b();
        SeekBar seekBar = (SeekBar) findViewById(R.id.seekbar);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_auto);
        if (SharedPreferencesHelper.getInstance().f4872O0) {
            checkBox.setChecked(false);
        } else {
            checkBox.setChecked(true);
            seekBar.setEnabled(false);
        }
        checkBox.setOnCheckedChangeListener(new a(seekBar));
        this.f7930c = (TextView) findViewById(R.id.text_progress);
        seekBar.setMax(255);
        try {
            this.f7932e = Settings.System.getInt(this.f7929b.getContentResolver(), "screen_brightness");
            seekBar.setProgress(this.f7931d);
        } catch (Settings.SettingNotFoundException e) {
            this.f7932e = 110;
            e.printStackTrace();
        }
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            this.f7931d = SharedPreferencesHelper.getInstance().nightBrightness;
            if (!SharedPreferencesHelper.getInstance().f4872O0) {
                this.f7931d = -1;
            } else if (this.f7931d == -1) {
                i = 50;
                this.f7931d = i;
            }
        } else {
            this.f7931d = SharedPreferencesHelper.getInstance().defaultBrightness;
            if (SharedPreferencesHelper.getInstance().f4872O0 && this.f7931d == -1) {
                i = this.f7932e;
                this.f7931d = i;
            }
        }
        seekBar.setOnSeekBarChangeListener(new b());
        seekBar.setProgress(this.f7931d);
        this.f7930c.setText(((int) ((this.f7931d / 255.0f) * 100.0f)) + "%");
    }

    public void m10623b() {
        TextView textView = (TextView) findViewById(R.id.text_progress);
        CheckBox checkBox = (CheckBox) findViewById(R.id.cb_auto);
        int i = SharedPreferencesHelper.getInstance().enterNightMode ? -7829368 : 0xFF000000;
        textView.setTextColor(i);
        checkBox.setTextColor(i);
    }

    public class b implements SeekBar.OnSeekBarChangeListener {
        public b() {
        }

        @Override
        public void onProgressChanged(SeekBar seekBar, int i, boolean z) {
            if (SharedPreferencesHelper.getInstance().f4872O0) {
                DialogC2544x0.this.f7929b.m6245P(i);
                if (SharedPreferencesHelper.getInstance().enterNightMode) {
                    SharedPreferencesHelper.getInstance().putInt("night_brightness", i);
                    SharedPreferencesHelper.getInstance().nightBrightness = i;
                } else {
                    SharedPreferencesHelper.getInstance().putInt("default_brightness", i);
                    SharedPreferencesHelper.getInstance().defaultBrightness = i;
                }
                DialogC2544x0 dialogC2544x0 = DialogC2544x0.this;
                dialogC2544x0.f7931d = i;
                dialogC2544x0.f7930c.setText(((int) ((DialogC2544x0.this.f7931d / 255.0f) * 100.0f)) + "%");
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
