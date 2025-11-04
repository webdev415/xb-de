package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.net.Uri;
import android.os.Build;
import android.os.Handler;
import android.text.Editable;
import android.text.TextUtils;
import android.view.View;
import android.view.Window;
import android.widget.ImageView;
import android.window.OnBackInvokedCallback;
import com.mmbox.xbrowser.searchbox.SuggestionInputView;
import com.xbrowser.play.R;
import p000.NetworkUtils;
import p000.AbstractC0448Jo;
import p000.SystemUiCompat;
import p000.C1045Wo;
import p000.ThemeManager;
import p000.SystemUiController;
import p000.DialogInterfaceOnDismissListenerC0189E4;
import p000.InterfaceC0299Gd;
import p000.InterfaceC0625Nh;

public class SearchBarActivity extends Activity implements SuggestionInputView.InterfaceC1581f {

    public SuggestionInputView f4538a;

    public OnBackInvokedCallback f4541d;

    public ImageView f4539b = null;

    public ImageView f4540c = null;

    public int f4542e = 0;

    public class ViewOnClickListenerC1534a implements View.OnClickListener {
        public ViewOnClickListenerC1534a() {
        }

        @Override
        public void onClick(View view) {
            SearchBarActivity.this.f4538a.getEditableText().clear();
        }
    }

    public class ViewOnClickListenerC1535b implements View.OnClickListener {
        public ViewOnClickListenerC1535b() {
        }

        @Override
        public void onClick(View view) {
            SearchBarActivity searchBarActivity = SearchBarActivity.this;
            int i = searchBarActivity.f4542e;
            SuggestionInputView suggestionInputView = searchBarActivity.f4538a;
            if (i == 0) {
                suggestionInputView.m7098l();
                SearchBarActivity.this.finish();
            } else {
                SearchBarActivity.this.mo6527a(suggestionInputView.getFinalText(), -1);
            }
        }
    }

    public class ViewOnLongClickListenerC1536c implements View.OnLongClickListener {
        public ViewOnLongClickListenerC1536c() {
        }

        @Override
        public boolean onLongClick(View view) {
            if (SearchBarActivity.this.f4542e != 1) {
                return false;
            }
            new DialogInterfaceOnDismissListenerC0189E4(SearchBarActivity.this).show();
            return true;
        }
    }

    public class C1537d implements InterfaceC0625Nh {

        public final View f4546a;

        public final View f4547b;

        public C1537d(View view, View view2) {
            this.f4546a = view;
            this.f4547b = view2;
        }

        @Override
        public C1045Wo mo3322a(View view, C1045Wo c1045Wo) {
            int i = c1045Wo.m4549f(C1045Wo.m.m4602f()).f7066b;
            int i2 = c1045Wo.m4549f(C1045Wo.m.m4601e()).f7068d;
            int i3 = c1045Wo.m4549f(C1045Wo.m.m4598b()).f7068d;
            View view2 = this.f4546a;
            if (view2 != null) {
                view2.setPadding(view2.getPaddingLeft(), i, this.f4546a.getPaddingRight(), this.f4546a.getPaddingBottom());
            }
            if (this.f4547b != null) {
                int iMax = Math.max(i2, i3);
                View view3 = this.f4547b;
                view3.setPadding(view3.getPaddingLeft(), this.f4547b.getPaddingTop(), this.f4547b.getPaddingRight(), iMax);
            }
            return c1045Wo;
        }
    }

    public class C1538e implements OnBackInvokedCallback {
        public C1538e() {
        }

        public void onBackInvoked() {
            SearchBarActivity.this.mo6528b();
        }
    }

    @Override
    public void mo6527a(String str, int i) {
        int i2;
        String str2;
        Intent intent = new Intent();
        if (TextUtils.isEmpty(str)) {
            i2 = 0;
        } else {
            if (i == 12) {
                intent.setAction("action.active_tab");
                str2 = "tab-id";
            } else if (i == 13) {
                intent.setAction("action.execute_cmd");
                str2 = "command";
            } else {
                intent.setAction(i == 14 ? "action.do_search" : "action.open_url_or_search");
                intent.putExtra("key-or-url", str);
                i2 = -1;
            }
            intent.putExtra(str2, str);
            i2 = -1;
        }
        setResult(i2, intent);
        this.f4538a.m7098l();
        finish();
    }

    @Override
    public void afterTextChanged(Editable editable) {
        String finalText = this.f4538a.getFinalText();
        if (TextUtils.isEmpty(finalText)) {
            this.f4542e = 0;
            this.f4539b.setVisibility(View.INVISIBLE);
            this.f4540c.setImageLevel(0);
            return;
        }
        this.f4539b.setVisibility(View.VISIBLE);
        if (NetworkUtils.isNonUrl(finalText)) {
            this.f4542e = 1;
            this.f4540c.setImageLevel(2);
        } else {
            this.f4542e = 2;
            this.f4540c.setImageLevel(1);
        }
        this.f4539b.setVisibility(View.VISIBLE);
    }

    @Override
    public void mo6528b() {
        this.f4538a.m7098l();
        finish();
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public void mo6529c() {
    }

    @Override
    public void mo6530d(boolean z) {
    }

    public final void m6531e() {
        View viewFindViewById = findViewById(R.id.search_bar_top);
        View viewFindViewById2 = findViewById(R.id.search_bar_bottom);
        View decorView = getWindow().getDecorView();
        if (decorView == null) {
            return;
        }
        AbstractC0448Jo.m2095x(decorView, new C1537d(viewFindViewById, viewFindViewById2));
        decorView.requestApplyInsets();
    }

    public boolean m6532f(String str) throws Resources.NotFoundException {
        int iIndexOf;
        String host = Uri.parse(SharedPreferencesHelper.getInstance().getSearchUrl()).getHost();
        if (TextUtils.isEmpty(str)) {
            return false;
        }
        if (host != null && ((iIndexOf = str.indexOf(host)) == 7 || iIndexOf == 8)) {
            return host.indexOf("baidu.com") < 0 || str.indexOf("wd=") >= 0 || str.indexOf("word=") >= 0;
        }
        for (CharSequence charSequence : getResources().getTextArray(R.array.settings_default_search_values)) {
            String host2 = Uri.parse(charSequence.toString()).getHost();
            if (host2 != null) {
                int iIndexOf2 = str.indexOf(host2);
                if (iIndexOf2 == 7 || iIndexOf2 == 8) {
                    return host2.indexOf("baidu.com") < 0 || str.indexOf("from=") >= 0;
                }
                if (iIndexOf2 >= 0) {
                    return true;
                }
            }
        }
        return str.indexOf("3g.baidu.com") > 0 || str.indexOf("wap.baidu.com") > 0 || str.indexOf("www.baidu.com") > 0 || str.indexOf("cn.bing.com") > 0;
    }

    @Override
    public void finish() {
        super.finish();
        overridePendingTransition(0, 0);
    }

    public final void m6533g() {
        if (Build.VERSION.SDK_INT >= 33) {
            this.f4541d = new C1538e();
            try {
                getOnBackInvokedDispatcher().registerOnBackInvokedCallback(0, this.f4541d);
            } catch (Throwable unused) {
            }
        }
    }

    public final void m6534h() {
        Window window = getWindow();
        try {
            SystemUiCompat.setDecorFitsSystemWindows(window, false);
        } catch (Throwable unused) {
        }
        SystemUiController systemUiController = new SystemUiController(window, window.getDecorView());
        InterfaceC0299Gd interfaceC0299GdM9500u = ThemeManager.getInstance().m9500u();
        boolean z = true;
        if (interfaceC0299GdM9500u != null) {
            try {
                int iMo1388g = interfaceC0299GdM9500u.mo1388g();
                z = ((((double) ((iMo1388g >> 16) & 255)) * 0.299d) + (((double) ((iMo1388g >> 8) & 255)) * 0.587d)) + (((double) (iMo1388g & 255)) * 0.114d) > 160.0d;
            } catch (Throwable unused2) {
            }
        }
        systemUiController.setLightStatusBar(z);
        systemUiController.setLightNavigationBar(z);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
        View viewSearchBarBottom = findViewById(R.id.search_bar_bottom);
        View viewSearchBarTop = findViewById(R.id.search_bar_top);
        if (viewSearchBarBottom != null) {
            ThemeManager.getInstance().m9500u().setLayoutView(viewSearchBarBottom);
        }
        if (viewSearchBarTop != null) {
            ThemeManager.getInstance().m9500u().setLayoutView(viewSearchBarTop);
        }
        int i = configuration.uiMode;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x009e  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x00b0  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x00c1 A[PHI: r1
  0x00c1: PHI (r1v12 android.view.View) = (r1v6 android.view.View), (r1v15 android.view.View) binds: [B:29:0x00bf, B:25:0x00ad] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:33:0x00d4  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x00e9  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0108  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void onCreate(android.os.Bundle r4) throws java.io.UnsupportedEncodingException {
        /*
            Method dump skipped, instructions count: 312
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.SearchBarActivity.onCreate(android.os.Bundle):void");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        if (Build.VERSION.SDK_INT < 33 || this.f4541d == null) {
            return;
        }
        try {
            getOnBackInvokedDispatcher().unregisterOnBackInvokedCallback(this.f4541d);
        } catch (Throwable unused) {
        }
    }

    @Override
    public void onResume() {
        super.onResume();
        SuggestionInputView suggestionInputView = this.f4538a;
        if (suggestionInputView != null) {
            suggestionInputView.setFocusable(true);
            this.f4538a.requestFocus();
        }
        Handler handler = new Handler();
        if (BrowserActivity.getActivity() != null) {
            BrowserActivity.getActivity().handleClipboardUrl(handler);
        }
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
