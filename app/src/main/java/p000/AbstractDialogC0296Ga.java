package p000;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public abstract class AbstractDialogC0296Ga extends AbstractDialogC2267r {

    public BrowserActivity f932b;

    public class a implements View.OnClickListener {

        public final CheckBox f933a;

        public final CheckBox f934b;

        public final CheckBox f935c;

        public a(CheckBox checkBox, CheckBox checkBox2, CheckBox checkBox3) {
            this.f933a = checkBox;
            this.f934b = checkBox2;
            this.f935c = checkBox3;
        }

        @Override
        public void onClick(View view) throws SQLException {
            AbstractDialogC0296Ga.this.mo1372c();
            boolean zIsChecked = this.f933a.isChecked();
            boolean zIsChecked2 = this.f934b.isChecked();
            boolean zIsChecked3 = this.f935c.isChecked();
            if (zIsChecked) {
                MySQLiteOpenHelper.getInstance().deleteRecentHistory();
            }
            SharedPreferencesHelper.getInstance().putBoolean("clean_latest_his_check", zIsChecked);
            if (zIsChecked2) {
                MySQLiteOpenHelper.getInstance().clearSearchHistory();
            }
            SharedPreferencesHelper.getInstance().putBoolean("clean_search_his_check", zIsChecked2);
            SharedPreferencesHelper.getInstance().putBoolean("show-confirm-dlg-on-exit", !zIsChecked3);
            AbstractDialogC0296Ga.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC0296Ga.this.mo1371b();
            AbstractDialogC0296Ga.this.dismiss();
        }
    }

    public AbstractDialogC0296Ga(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f932b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_exit_confirm);
        Button button = (Button) findViewById(R.id.btn_ok);
        CheckBox checkBox = (CheckBox) findViewById(R.id.clean_latest_his);
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.clean_search_his);
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.do_not_show_ext_dlg);
        boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("clean_latest_his_check", false);
        boolean zM6873Q2 = SharedPreferencesHelper.getInstance().getBoolean("clean_search_his_check", false);
        checkBox.setChecked(zM6873Q);
        checkBox2.setChecked(zM6873Q2);
        button.setOnClickListener(new a(checkBox, checkBox2, checkBox3));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public abstract void mo1371b();

    public abstract void mo1372c();
}
