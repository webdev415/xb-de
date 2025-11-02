package p000;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.webkit.WebView;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import com.xbrowser.play.R;

public class ViewOnFocusChangeListenerC0985Va implements View.OnFocusChangeListener, View.OnClickListener, TextWatcher {

    public BrowserActivity f2959a;

    public ViewGroup f2961c;

    public InputMethodManager f2964f;

    public View f2960b = null;

    public WebView f2962d = null;

    public EditText f2963e = null;

    public ViewOnFocusChangeListenerC0985Va(BrowserActivity browserActivity) {
        this.f2961c = null;
        this.f2964f = null;
        this.f2959a = browserActivity;
        this.f2961c = (ViewGroup) browserActivity.findViewById(R.id.bottom_content);
        this.f2964f = (InputMethodManager) this.f2959a.getSystemService(Context.INPUT_METHOD_SERVICE);
    }

    public final void m4385a() {
        if (this.f2960b == null) {
            View viewInflate = LayoutInflater.from(this.f2959a).inflate(R.layout.find_in_page_box, this.f2961c, false);
            EditText editText = (EditText) viewInflate.findViewById(R.id.find_box_editor);
            this.f2963e = editText;
            editText.setFocusable(true);
            this.f2963e.setOnFocusChangeListener(this);
            this.f2963e.addTextChangedListener(this);
            ImageButton imageButton = (ImageButton) viewInflate.findViewById(R.id.find_next_btn);
            ImageButton imageButton2 = (ImageButton) viewInflate.findViewById(R.id.find_back_btn);
            ImageButton imageButton3 = (ImageButton) viewInflate.findViewById(R.id.find_close_btn);
            imageButton.setOnFocusChangeListener(this);
            imageButton.setOnClickListener(this);
            imageButton2.setOnClickListener(this);
            imageButton3.setOnClickListener(this);
            imageButton2.setOnFocusChangeListener(this);
            viewInflate.setVisibility(View.GONE);
            this.f2961c.addView(viewInflate);
            this.f2960b = viewInflate;
        }
    }

    @Override
    public void afterTextChanged(Editable editable) {
        WebView webView = this.f2962d;
        if (webView != null) {
            webView.findAllAsync(editable.toString());
        }
    }

    public void m4386b() {
        View view = this.f2960b;
        if (view != null) {
            view.setVisibility(View.GONE);
        }
    }

    public void m4387c() {
        m4385a();
        InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) this.f2959a.m6222J0().m9316y();
        if (!(interfaceC1300b3 instanceof WebViewBrowserController)) {
            Toast.makeText(this.f2959a, "Not support find on this page", Toast.LENGTH_SHORT).show();
            return;
        }
        this.f2962d = ((WebViewBrowserController) interfaceC1300b3).m6770F0();
        if (this.f2960b.getParent() == null) {
            this.f2961c.addView(this.f2960b);
        }
        this.f2960b.setVisibility(View.VISIBLE);
        this.f2963e.requestFocus();
    }

    @Override
    public void onClick(View view) {
        if (view.getId() == R.id.find_back_btn) {
            WebView webView = this.f2962d;
            if (webView != null) {
                webView.findNext(false);
            }
        } else if (view.getId() == R.id.find_next_btn) {
            WebView webView2 = this.f2962d;
            if (webView2 != null) {
                webView2.findNext(true);
            }
        } else if (view.getId() == R.id.find_close_btn) {
            m4386b();
        }
        this.f2964f.hideSoftInputFromWindow(this.f2963e.getWindowToken(), 0);
    }

    @Override
    public void onFocusChange(View view, boolean z) {
        if (view.getId() != R.id.find_box_editor) {
            this.f2964f.hideSoftInputFromWindow(this.f2963e.getWindowToken(), 0);
            return;
        }
        if (z) {
            this.f2964f.showSoftInput(this.f2963e, 0);
            WebView webView = this.f2962d;
            if (webView != null) {
                webView.findAllAsync(this.f2963e.getText().toString());
            }
        }
    }

    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
    }
}
