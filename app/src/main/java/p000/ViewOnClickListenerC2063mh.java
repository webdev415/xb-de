package p000;

import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Filter;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.mmbox.xbrowser.provider.BrowserProvider;
import com.xbrowser.play.R;
import java.util.ArrayList;
import java.util.List;
import org.json.JSONException;

/* loaded from: classes.dex */
public class ViewOnClickListenerC2063mh extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f6225b;

    public String f6226c;

    public String f6227d;

    public String f6228e;

    public boolean f6229f;

    public String f6230g;

    public int f6231h;

    public AutoCompleteTextView f6232i;

    public ArrayList f6233j;

    public class a implements View.OnFocusChangeListener {
        public a() {
        }

        @Override
        public void onFocusChange(View view, boolean z) {
            if (z) {
                ViewOnClickListenerC2063mh.this.f6232i.showDropDown();
            }
        }
    }

    public class b extends ArrayAdapter {

        public class a extends Filter {
            public a() {
            }

            @Override
            public FilterResults performFiltering(CharSequence charSequence) {
                String lowerCase = String.valueOf(charSequence).toLowerCase();
                FilterResults filterResults = new FilterResults();
                ArrayList arrayListM8581i = ViewOnClickListenerC2063mh.this.m8581i(lowerCase);
                if (!ViewOnClickListenerC2063mh.this.f6232i.hasFocus()) {
                    arrayListM8581i = ViewOnClickListenerC2063mh.this.m8581i("");
                }
                filterResults.count = arrayListM8581i.size();
                filterResults.values = arrayListM8581i;
                return filterResults;
            }

            @Override
            public void publishResults(CharSequence charSequence, FilterResults filterResults) {
                if (filterResults == null || filterResults.count <= 0) {
                    b.this.notifyDataSetInvalidated();
                    return;
                }
                b.this.clear();
                b.this.addAll((List) filterResults.values);
                b.this.notifyDataSetChanged();
            }
        }

        public b(Context context, int i, List list) {
            super(context, i, list);
        }

        @Override
        public Filter getFilter() {
            return new a();
        }
    }

    public class c implements View.OnClickListener {
        public c() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC2063mh.this.f6232i.showDropDown();
        }
    }

    public class d implements View.OnClickListener {

        public final EditText f6238a;

        public final EditText f6239b;

        public final CheckBox f6240c;

        public d(EditText editText, EditText editText2, CheckBox checkBox) {
            this.f6238a = editText;
            this.f6239b = editText2;
            this.f6240c = checkBox;
        }

        @Override
        public void onClick(View view) throws Throwable {
            String str;
            String strMo1573b;
            Toast toastMakeText;
            String string = ViewOnClickListenerC2063mh.this.f6232i.getText().toString();
            if (!string.startsWith("/")) {
                string = "/" + string;
            }
            if (!ViewOnClickListenerC2063mh.this.m8580h(string)) {
                ViewOnClickListenerC2063mh.this.m8579g(string);
            }
            if (ViewOnClickListenerC2063mh.this.f6231h != 0) {
                if (ViewOnClickListenerC2063mh.this.f6231h == 1) {
                    String strTrim = this.f6238a.getText().toString().trim();
                    if (strTrim.indexOf("&") >= 0) {
                        strTrim = strTrim.replaceAll("&", "＆");
                    }
                    if (string.equals("/")) {
                        str = string + strTrim;
                    } else {
                        str = string + "/" + strTrim;
                    }
                    if (!TextUtils.isEmpty(strTrim)) {
                        ViewOnClickListenerC2063mh viewOnClickListenerC2063mh = ViewOnClickListenerC2063mh.this;
                        if (viewOnClickListenerC2063mh.f6229f) {
                            viewOnClickListenerC2063mh.f6225b.m6303c3(viewOnClickListenerC2063mh.f6227d, str, strTrim, string);
                        } else {
                            viewOnClickListenerC2063mh.f6225b.m6368w(strTrim, str, string, true);
                        }
                    }
                    toastMakeText = Toast.makeText(ViewOnClickListenerC2063mh.this.f6225b, "title not allow empty", 0);
                }
                ViewOnClickListenerC2063mh.this.dismiss();
                SharedPreferencesHelper.getInstance().putString("last_bm_dir", string);
                strMo1573b = ((InterfaceC1300b3) ViewOnClickListenerC2063mh.this.f6225b.m6222J0().m9316y()).mo1573b();
                if (TextUtils.isEmpty(strMo1573b)) {
                    return;
                } else {
                    return;
                }
            }
            String strTrim2 = this.f6238a.getText().toString().trim();
            String strTrim3 = this.f6239b.getText().toString().trim();
            if (TextUtils.isEmpty(strTrim2)) {
                toastMakeText = Toast.makeText(ViewOnClickListenerC2063mh.this.f6225b, "title not allow empty", 0);
            } else {
                if (!TextUtils.isEmpty(strTrim3)) {
                    if (!TextUtils.isEmpty(strTrim3) && strTrim3.indexOf("baidu.com") > 0 && strTrim3.indexOf(SharedPreferencesHelper.getInstance().f4897c0) > 0 && !TextUtils.isEmpty(ViewOnClickListenerC2063mh.this.f6228e)) {
                        strTrim3 = strTrim3.replaceAll("from=[a-z0-9_]{8,20}", "from=" + ViewOnClickListenerC2063mh.this.f6228e);
                    }
                    ViewOnClickListenerC2063mh viewOnClickListenerC2063mh2 = ViewOnClickListenerC2063mh.this;
                    if (viewOnClickListenerC2063mh2.f6229f) {
                        viewOnClickListenerC2063mh2.f6225b.m6303c3(viewOnClickListenerC2063mh2.f6227d, strTrim3, strTrim2, string);
                    } else {
                        viewOnClickListenerC2063mh2.f6225b.m6368w(strTrim2, strTrim3, string, false);
                    }
                    if (this.f6240c.isChecked()) {
                        ViewOnClickListenerC2063mh.this.f6225b.m6376y(strTrim2, strTrim3, 0);
                    }
                    ViewOnClickListenerC2063mh.this.dismiss();
                    SharedPreferencesHelper.getInstance().putString("last_bm_dir", string);
                    strMo1573b = ((InterfaceC1300b3) ViewOnClickListenerC2063mh.this.f6225b.m6222J0().m9316y()).mo1573b();
                    if (TextUtils.isEmpty(strMo1573b) || strMo1573b.indexOf("x:bm") < 0) {
                        return;
                    }
                    ViewOnClickListenerC2063mh.this.f6225b.refreshQuickAccessUI();
                    return;
                }
                toastMakeText = Toast.makeText(ViewOnClickListenerC2063mh.this.f6225b, "url not allow empty", 0);
            }
            toastMakeText.show();
        }
    }

    public class e implements View.OnClickListener {
        public e() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC2063mh.this.dismiss();
        }
    }

    public ViewOnClickListenerC2063mh(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6225b = null;
        this.f6226c = null;
        this.f6227d = null;
        this.f6228e = null;
        this.f6229f = false;
        this.f6230g = "/";
        this.f6231h = 0;
        this.f6233j = new ArrayList<>(3);
        this.f6225b = browserActivity;
        this.f6230g = SharedPreferencesHelper.getInstance().getString("last_bm_dir", "/");
    }

    @Override
    public void mo320a(Bundle bundle) {
        String strReplaceAll;
        setContentView(R.layout.dlg_bookmark_add);
        EditText editText = (EditText) findViewById(R.id.title);
        EditText editText2 = (EditText) findViewById(R.id.url);
        CheckBox checkBox = (CheckBox) findViewById(R.id.check_add_to_qa);
        AutoCompleteTextView autoCompleteTextView = (AutoCompleteTextView) findViewById(R.id.select_dir);
        this.f6232i = autoCompleteTextView;
        autoCompleteTextView.setOnFocusChangeListener(new a());
        m8582j();
        this.f6232i.setAdapter(new b(getContext(), R.layout.bookmark_dir_item, m8581i("")));
        if (this.f6231h == 1) {
            editText.setHint(R.string.dlg_bm_dir_hit);
            editText2.setVisibility(View.GONE);
        }
        if (!this.f6230g.equals("/")) {
            this.f6232i.setText(this.f6230g);
        }
        this.f6232i.setClickable(true);
        this.f6232i.setOnClickListener(new c());
        editText.setText(this.f6226c);
        String str = this.f6227d;
        if (TextUtils.isEmpty(str) || str.indexOf("baidu.com") <= 0) {
            strReplaceAll = this.f6227d;
        } else {
            this.f6228e = NetworkUtils.extractFirstGroup(this.f6227d, NetworkUtils.FROM_PARAM_PATTERN);
            strReplaceAll = str.replaceAll("from=[a-z0-9_]{8,20}", "from=" + SharedPreferencesHelper.getInstance().f4897c0);
        }
        editText2.setText(strReplaceAll);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new d(editText, editText2, checkBox));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new e());
    }

    public final void m8579g(String str) throws JSONException, Resources.NotFoundException {
        StringBuilder sb;
        if (str.equals("/")) {
            return;
        }
        str.indexOf(47);
        String[] strArrSplit = str.split("/");
        String str2 = "";
        int i = 0;
        while (i < strArrSplit.length) {
            String str3 = strArrSplit[i];
            if (str2.equals("/")) {
                sb = new StringBuilder();
                sb.append(str2);
            } else {
                sb = new StringBuilder();
                sb.append(str2);
                sb.append("/");
            }
            sb.append(str3);
            String string = sb.toString();
            if (!TextUtils.isEmpty(str3)) {
                this.f6225b.m6368w(str3, string, str2, true);
            }
            i++;
            str2 = string;
        }
    }

    public final boolean m8580h(String str) {
        for (int i = 0; i < this.f6233j.size(); i++) {
            if (str.equals((String) this.f6233j.get(i))) {
                return true;
            }
        }
        return false;
    }

    public final ArrayList m8581i(String str) {
        ArrayList arrayList = new ArrayList<>();
        for (int i = 0; i < this.f6233j.size(); i++) {
            String str2 = (String) this.f6233j.get(i);
            if (str2.toLowerCase().indexOf(str) >= 0 || TextUtils.isEmpty(str)) {
                arrayList.add(str2);
            }
        }
        return arrayList;
    }

    public final void m8582j() {
        String[] strArr = {"1"};
        this.f6233j.add("/");
        try {
            Cursor cursorQuery = this.f6225b.getContentResolver().query(BrowserProvider.uriBookmark, DatabaseColumns.BOOKMARK, "type = ?", strArr, "url");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        this.f6233j.add(cursorQuery.getString(cursorQuery.getColumnIndex("url")));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m8583k(String str) {
        this.f6230g = str;
    }

    public void m8584l(int i) {
        this.f6231h = i;
        show();
    }

    public void m8585m(String str) {
        Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("bookmark", DatabaseColumns.BOOKMARK, "url= ?", new String[]{str}, null, null, null);
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    this.f6231h = cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("type"));
                    this.f6230g = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("parent"));
                    this.f6226c = cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("title"));
                    this.f6227d = str;
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        this.f6229f = true;
        show();
    }

    public void m8586n(String str, String str2) {
        this.f6226c = str;
        this.f6227d = str2;
        m8584l(0);
    }

    @Override
    public void onClick(View view) {
    }
}
