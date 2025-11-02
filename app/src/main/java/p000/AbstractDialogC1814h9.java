package p000;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;

/* loaded from: classes.dex */
public abstract class AbstractDialogC1814h9 extends AbstractDialogC2267r {

    public BrowserActivity f5694b;

    public String f5695c;

    public String f5696d;

    public String f5697e;

    public String f5698f;

    public PopupWindow f5699g;

    public CheckBox f5700h;

    public i f5701i;

    public TextView f5702j;

    public boolean f5703k;

    public boolean f5704l;

    public ArrayList f5705m;

    public class a implements View.OnClickListener {

        public final TextView f5706a;

        public final ImageView f5707b;

        public a(TextView textView, ImageView imageView) {
            this.f5706a = textView;
            this.f5707b = imageView;
        }

        @Override
        public void onClick(View view) {
            this.f5706a.setEnabled(true);
            this.f5706a.setTextColor(0xFF000000);
            this.f5706a.setBackgroundResource(R.drawable.default_search_box_bg);
            this.f5707b.setVisibility(View.GONE);
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1814h9.this.mo6444h();
        }
    }

    public class c implements View.OnClickListener {

        public final View f5710a;

        public c(View view) {
            this.f5710a = view;
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1814h9 abstractDialogC1814h9 = AbstractDialogC1814h9.this;
            if (abstractDialogC1814h9.f5703k) {
                return;
            }
            abstractDialogC1814h9.m7813j(this.f5710a);
        }
    }

    public class d implements CompoundButton.OnCheckedChangeListener {
        public d() {
        }

        @Override
        public void onCheckedChanged(CompoundButton compoundButton, boolean z) {
            if (!z) {
                SharedPreferencesHelper.getInstance().putString("bind_default_downloader", "");
            } else {
                SharedPreferencesHelper.getInstance().putString("bind_default_downloader", SharedPreferencesHelper.getInstance().getString("default_downloader", ""));
            }
        }
    }

    public class e implements View.OnClickListener {

        public final TextView f5713a;

        public e(TextView textView) {
            this.f5713a = textView;
        }

        @Override
        public void onClick(View view) {
            if (TextUtils.isEmpty(this.f5713a.getEditableText().toString())) {
                Toast.makeText(AbstractDialogC1814h9.this.f5694b, R.string.toast_invalid_url, Toast.LENGTH_SHORT).show();
            } else {
                AbstractDialogC1814h9.this.mo6443g();
                AbstractDialogC1814h9.this.dismiss();
            }
        }
    }

    public class f implements View.OnClickListener {
        public f() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1814h9.this.mo6442f();
        }
    }

    public class g implements View.OnClickListener {
        public g() {
        }

        @Override
        public void onClick(View view) {
            AbstractDialogC1814h9.this.mo6441e();
            AbstractDialogC1814h9.this.dismiss();
        }
    }

    public class h implements PopupWindow.OnDismissListener {

        public class a implements Runnable {
            public a() {
            }

            @Override
            public void run() {
                AbstractDialogC1814h9.this.f5703k = false;
            }
        }

        public h() {
        }

        @Override
        public void onDismiss() {
            AbstractDialogC1814h9.this.f5694b.getHandler().postDelayed(new a(), 100L);
        }
    }

    public class i extends BaseAdapter {

        public class a implements View.OnClickListener {

            public final int f5720a;

            public a(int i) {
                this.f5720a = i;
            }

            @Override
            public void onClick(View view) {
                CheckBox checkBox;
                int i;
                C1224ai.a aVar = (C1224ai.a) AbstractDialogC1814h9.this.f5705m.get(this.f5720a);
                AbstractDialogC1814h9.this.f5702j.setText(aVar.f3549b);
                SharedPreferencesHelper.getInstance().putString("default_downloader", aVar.f3548a);
                AbstractDialogC1814h9.this.f5699g.dismiss();
                if (AbstractDialogC1814h9.this.f5700h != null) {
                    if (aVar.f3548a.equals("com.x.browser.downloader") || aVar.f3548a.equals("com.android.providers.downloads")) {
                        checkBox = AbstractDialogC1814h9.this.f5700h;
                        i = 8;
                    } else {
                        checkBox = AbstractDialogC1814h9.this.f5700h;
                        i = 0;
                    }
                    checkBox.setVisibility(i);
                }
            }
        }

        public i() {
        }

        public C1224ai.a m7814a(String str) {
            for (int i = 0; i < AbstractDialogC1814h9.this.f5705m.size(); i++) {
                C1224ai.a aVar = (C1224ai.a) AbstractDialogC1814h9.this.f5705m.get(i);
                if (aVar.f3548a.equals(str)) {
                    return aVar;
                }
            }
            return null;
        }

        @Override
        public C1224ai.a getItem(int i) {
            return (C1224ai.a) AbstractDialogC1814h9.this.f5705m.get(i);
        }

        @Override
        public int getCount() {
            return AbstractDialogC1814h9.this.f5705m.size();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) View.inflate(AbstractDialogC1814h9.this.f5694b, R.layout.downloader_item, null).findViewById(R.id.downloader_title);
            textView.setClickable(true);
            textView.setOnClickListener(new a(i));
            textView.setText(((C1224ai.a) AbstractDialogC1814h9.this.f5705m.get(i)).f3549b);
            return textView;
        }
    }

    public AbstractDialogC1814h9(BrowserActivity browserActivity) {
        this(browserActivity, true);
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_download_confirm);
        ImageView imageView = (ImageView) findViewById(R.id.rename);
        TextView textView = (TextView) findViewById(R.id.title_info);
        TextView textView2 = (TextView) findViewById(R.id.text_info);
        TextView textView3 = (TextView) findViewById(R.id.file_name);
        TextView textView4 = (TextView) findViewById(R.id.file_size);
        ImageView imageView2 = (ImageView) findViewById(R.id.share_to_other);
        textView.setText(this.f5695c);
        textView2.setText(this.f5696d);
        textView3.setText(this.f5697e);
        textView4.setText(this.f5698f);
        imageView.setOnClickListener(new a(textView3, imageView));
        imageView2.setOnClickListener(new b());
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            imageView.setColorFilter(-7829368);
        } else {
            imageView.clearColorFilter();
        }
        View viewFindViewById = findViewById(R.id.downloader_selector);
        if (this.f5704l) {
            viewFindViewById.setOnClickListener(new c(viewFindViewById));
            String strM6871P = SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader");
            CheckBox checkBox = (CheckBox) findViewById(R.id.as_default_downloader);
            this.f5700h = checkBox;
            if (checkBox != null) {
                if (!TextUtils.isEmpty(strM6871P) && !strM6871P.equals("com.x.browser.downloader") && !strM6871P.equals("com.android.providers.downloads") && C2406u0.m9882f().m9883a(strM6871P)) {
                    this.f5700h.setVisibility(View.VISIBLE);
                }
                this.f5700h.setOnCheckedChangeListener(new d());
            }
            this.f5702j = (TextView) viewFindViewById.findViewById(R.id.download_name);
            C1224ai.a aVarM7814a = this.f5701i.m7814a(strM6871P);
            if (aVarM7814a != null) {
                this.f5702j.setText(aVarM7814a.f3549b);
            } else {
                SharedPreferencesHelper.getInstance().putString("default_downloader", "com.x.browser.downloader");
                this.f5702j.setText(R.string.title_default_downloader);
            }
        } else {
            viewFindViewById.setVisibility(View.GONE);
        }
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new e(textView3));
        ((Button) findViewById(R.id.btn_copy_link)).setOnClickListener(new f());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new g());
    }

    public final void m7811d() {
        this.f5705m = C1224ai.m5285e().m5292h("downloader");
    }

    public abstract void mo6441e();

    public abstract void mo6442f();

    public abstract void mo6443g();

    public abstract void mo6444h();

    public void m7812i(String str, String str2, String str3, String str4) {
        this.f5695c = str;
        this.f5696d = str2;
        this.f5697e = str3;
        String string = this.f5694b.getString(R.string.dlg_download_size);
        if (str4.indexOf("--") >= 0 || str4.indexOf("0B") >= 0) {
            str4 = this.f5694b.getString(R.string.dlg_download_size_unknown);
        }
        this.f5698f = String.format(string, str4);
        show();
    }

    public final void m7813j(View view) {
        int dimension = (int) this.f5694b.getResources().getDimension(R.dimen.popmenu_offset_y);
        View viewInflate = View.inflate(this.f5694b, R.layout.select_downloader_pop_win, null);
        this.f5699g = new PopupWindow(viewInflate, view.getMeasuredWidth(), -2);
        ListView listView = (ListView) viewInflate.findViewById(R.id.downloader_list_view);
        listView.setAdapter((ListAdapter) this.f5701i);
        listView.setFocusable(true);
        this.f5699g.setTouchable(true);
        this.f5699g.setOnDismissListener(new h());
        this.f5699g.setBackgroundDrawable(new ColorDrawable(0));
        this.f5699g.setOutsideTouchable(true);
        this.f5699g.showAsDropDown(view, 0, dimension);
        this.f5703k = true;
    }

    public AbstractDialogC1814h9(BrowserActivity browserActivity, boolean z) {
        super(browserActivity);
        this.f5694b = null;
        this.f5695c = null;
        this.f5696d = null;
        this.f5697e = null;
        this.f5698f = null;
        this.f5699g = null;
        this.f5700h = null;
        this.f5701i = new i();
        this.f5702j = null;
        this.f5703k = false;
        this.f5705m = null;
        this.f5694b = browserActivity;
        this.f5704l = z;
        m7811d();
    }
}
