package p000;

import android.database.SQLException;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.webkit.WebStorage;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public class DialogC0465K4 extends AbstractDialogC2267r {

    public BrowserActivity f1518b;

    public boolean f1519c;

    public boolean f1520d;

    public boolean f1521e;

    public boolean f1522f;

    public boolean f1523g;

    public boolean f1524h;

    public boolean f1525i;

    public boolean f1526j;

    public boolean f1527k;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            DialogC0465K4.this.m2280q();
            DialogC0465K4.this.dismiss();
        }
    }

    public class b implements Runnable {
        public b() {
        }

        @Override
        public void run() throws SQLException {
            Log.i("cache", "execute clean cache ....");
            if (DialogC0465K4.this.f1519c) {
                MySQLiteOpenHelper.getInstance().m7498J();
            }
            if (DialogC0465K4.this.f1520d) {
                MySQLiteOpenHelper.getInstance().clearSearchHistory();
            }
            if (DialogC0465K4.this.f1521e) {
                SharedPreferencesHelper.getInstance().m6906m(true);
            }
            if (DialogC0465K4.this.f1522f) {
                DialogC0465K4.this.f1518b.m6262T0().clear();
                SharedPreferencesHelper.getInstance().m6900j();
            }
            if (DialogC0465K4.this.f1523g) {
                SharedPreferencesHelper.getInstance().m6910o();
            }
            if (DialogC0465K4.this.f1524h) {
                SharedPreferencesHelper.getInstance().m6902k();
            }
            if (DialogC0465K4.this.f1525i) {
                WebStorage.getInstance().deleteAllData();
            }
            SharedPreferencesHelper.getInstance().putInt("home_load_times", 0);
        }
    }

    public class c implements CompoundButton.OnCheckedChangeListener {
        public c() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1519c = z;
        }
    }

    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1520d = z;
        }
    }

    public class e implements CompoundButton.OnCheckedChangeListener {
        public e() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1521e = z;
        }
    }

    public class f implements CompoundButton.OnCheckedChangeListener {
        public f() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1522f = z;
        }
    }

    public class g implements CompoundButton.OnCheckedChangeListener {
        public g() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1524h = z;
        }
    }

    public class h implements CompoundButton.OnCheckedChangeListener {
        public h() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1523g = z;
        }
    }

    public class i implements CompoundButton.OnCheckedChangeListener {
        public i() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1525i = z;
        }
    }

    public class j implements CompoundButton.OnCheckedChangeListener {
        public j() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            DialogC0465K4.this.f1526j = z;
        }
    }

    public class k implements View.OnClickListener {
        public k() {
        }

        @Override
        public void onClick(View view) {
            DialogC0465K4.this.m2281r();
            DialogC0465K4.this.dismiss();
        }
    }

    public DialogC0465K4(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f1519c = false;
        this.f1520d = false;
        this.f1521e = false;
        this.f1522f = false;
        this.f1523g = false;
        this.f1524h = false;
        this.f1525i = false;
        this.f1526j = false;
        this.f1527k = true;
        this.f1518b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_clean_data);
        CheckBox checkBox = (CheckBox) findViewById(R.id.clean_his);
        boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("clean_history_checked", true);
        this.f1519c = zM6873Q;
        checkBox.setChecked(zM6873Q);
        checkBox.setOnCheckedChangeListener(new c());
        CheckBox checkBox2 = (CheckBox) findViewById(R.id.clean_search_his);
        boolean zM6873Q2 = SharedPreferencesHelper.getInstance().getBoolean("clean_search_his_checked", true);
        this.f1520d = zM6873Q2;
        checkBox2.setChecked(zM6873Q2);
        checkBox2.setOnCheckedChangeListener(new d());
        CheckBox checkBox3 = (CheckBox) findViewById(R.id.clean_web_cache);
        boolean zM6873Q3 = SharedPreferencesHelper.getInstance().getBoolean("clean_web_cache_checked", true);
        this.f1521e = zM6873Q3;
        checkBox3.setChecked(zM6873Q3);
        checkBox3.setOnCheckedChangeListener(new e());
        CheckBox checkBox4 = (CheckBox) findViewById(R.id.clean_app_cache);
        boolean zM6873Q4 = SharedPreferencesHelper.getInstance().getBoolean("clean_web_app_cache_checked", true);
        this.f1522f = zM6873Q4;
        checkBox4.setChecked(zM6873Q4);
        checkBox4.setOnCheckedChangeListener(new f());
        CheckBox checkBox5 = (CheckBox) findViewById(R.id.clean_form_data);
        boolean zM6873Q5 = SharedPreferencesHelper.getInstance().getBoolean("clean_form_data_checked", true);
        this.f1524h = zM6873Q5;
        checkBox5.setChecked(zM6873Q5);
        checkBox5.setOnCheckedChangeListener(new g());
        CheckBox checkBox6 = (CheckBox) findViewById(R.id.clean_cookies);
        boolean zM6873Q6 = SharedPreferencesHelper.getInstance().getBoolean("clean_web_cookies_checked", true);
        this.f1523g = zM6873Q6;
        checkBox6.setChecked(zM6873Q6);
        checkBox6.setOnCheckedChangeListener(new h());
        CheckBox checkBox7 = (CheckBox) findViewById(R.id.clean_local_storage);
        boolean zM6873Q7 = SharedPreferencesHelper.getInstance().getBoolean("clean_storage_checked", false);
        this.f1525i = zM6873Q7;
        checkBox7.setChecked(zM6873Q7);
        checkBox7.setOnCheckedChangeListener(new i());
        CheckBox checkBox8 = (CheckBox) findViewById(R.id.clean_web_data);
        boolean zM6873Q8 = SharedPreferencesHelper.getInstance().getBoolean("clean_web_data_checked", false);
        this.f1526j = zM6873Q8;
        checkBox8.setChecked(zM6873Q8);
        checkBox8.setOnCheckedChangeListener(new j());
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new k());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new a());
    }

    public void m2281r() {
        SharedPreferencesHelper.getInstance().putBoolean("clean_web_cache_checked", this.f1521e);
        SharedPreferencesHelper.getInstance().putBoolean("clean_web_app_cache_checked", this.f1522f);
        SharedPreferencesHelper.getInstance().putBoolean("clean_web_cookies_checked", this.f1523g);
        SharedPreferencesHelper.getInstance().putBoolean("clean_history_checked", this.f1519c);
        SharedPreferencesHelper.getInstance().putBoolean("clean_search_his_checked", this.f1520d);
        SharedPreferencesHelper.getInstance().putBoolean("clean_form_data_checked", this.f1524h);
        SharedPreferencesHelper.getInstance().putBoolean("clean_storage_checked", this.f1525i);
        SharedPreferencesHelper.getInstance().putBoolean("clean_web_data_checked", this.f1526j);
        if (this.f1527k) {
            this.f1518b.runOnUiThread(new b());
            Toast.makeText(this.f1518b, R.string.toast_data_clean, Toast.LENGTH_SHORT).show();
        }
    }

    public DialogC0465K4(BrowserActivity browserActivity, boolean z) {
        super(browserActivity);
        this.f1519c = false;
        this.f1520d = false;
        this.f1521e = false;
        this.f1522f = false;
        this.f1523g = false;
        this.f1524h = false;
        this.f1525i = false;
        this.f1526j = false;
        this.f1518b = browserActivity;
        this.f1527k = z;
    }

    public void m2280q() {
    }
}
