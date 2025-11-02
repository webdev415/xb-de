package p000;

import android.content.res.Resources;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class ViewOnClickListenerC1156Z6 extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f3389b;

    public String f3390c;

    public String f3391d;

    public String f3392e;

    public String f3393f;

    public class a implements View.OnClickListener {

        public final EditText f3394a;

        public final EditText f3395b;

        public a(EditText editText, EditText editText2) {
            this.f3394a = editText;
            this.f3395b = editText2;
        }

        @Override
        public void onClick(View view) throws Resources.NotFoundException, SQLException {
            String strTrim = this.f3394a.getText().toString().trim();
            String strTrim2 = this.f3395b.getText().toString().trim();
            if (!TextUtils.isEmpty(strTrim2) && strTrim2.indexOf("baidu.com") > 0 && strTrim2.indexOf(SharedPreferencesHelper.getInstance().f4897c0) > 0 && !TextUtils.isEmpty(ViewOnClickListenerC1156Z6.this.f3392e)) {
                strTrim2 = strTrim2.replaceAll("from=[a-z0-9_]{1,20}", "from=" + ViewOnClickListenerC1156Z6.this.f3392e);
            }
            if (TextUtils.isEmpty(ViewOnClickListenerC1156Z6.this.f3393f)) {
                ViewOnClickListenerC1156Z6.this.f3393f = AndroidSystemUtils.m8713u();
            }
            ViewOnClickListenerC1156Z6 viewOnClickListenerC1156Z6 = ViewOnClickListenerC1156Z6.this;
            viewOnClickListenerC1156Z6.f3389b.m6316f3(viewOnClickListenerC1156Z6.f3393f, strTrim, strTrim2);
            ViewOnClickListenerC1156Z6.this.dismiss();
            ViewOnClickListenerC1156Z6.this.f3389b.m6361u0("native_call_reload_qa();");
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC1156Z6.this.dismiss();
        }
    }

    public ViewOnClickListenerC1156Z6(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f3390c = null;
        this.f3391d = null;
        this.f3392e = null;
        this.f3393f = null;
        this.f3389b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        String strReplaceAll;
        setContentView(R.layout.dlg_quick_access_add);
        EditText editText = (EditText) findViewById(R.id.qa_title);
        EditText editText2 = (EditText) findViewById(R.id.qa_url);
        if (!TextUtils.isEmpty(this.f3390c)) {
            String str = this.f3391d;
            if (str.indexOf("baidu.com") > 0) {
                this.f3392e = NetworkUtils.extractFirstGroup(this.f3391d, NetworkUtils.FROM_PARAM_PATTERN);
                strReplaceAll = str.replaceAll("from=[a-z0-9_]{8,20}", "from=" + SharedPreferencesHelper.getInstance().f4897c0);
            } else {
                strReplaceAll = this.f3391d;
            }
            editText2.setText(strReplaceAll);
        }
        if (!TextUtils.isEmpty(this.f3390c)) {
            editText.setText(this.f3390c);
        }
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new a(editText, editText2));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public final void m5020b(String str) {
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("quick_access", DatabaseColumns.QUICK_ACCESS, "guid= ?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    this.f3390c = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("title"));
                    this.f3391d = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("url"));
                    this.f3393f = str;
                }
            } catch (Exception unused) {
            } catch (Throwable th) {
                cursorQuery.close();
                throw th;
            }
            cursorQuery.close();
        }
    }

    public void m5021c(String str) {
        m5020b(str);
        show();
    }

    public void m5022d(String str, String str2) {
        this.f3390c = str;
        this.f3391d = str2;
        show();
    }

    @Override
    public void onClick(View view) {
    }
}
