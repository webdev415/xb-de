package com.mmbox.xbrowser.searchbox;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.Configuration;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.text.Editable;
import android.text.TextUtils;
import android.text.TextWatcher;
import android.util.AttributeSet;
import android.util.Log;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.AdapterView;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;

/* loaded from: classes.dex */
public class SuggestionInputView extends AutoCompleteTextView implements TextView.OnEditorActionListener, AdapterView.OnItemClickListener, SuggestionInputAdapter.Callback {

    public InputMethodManager inputMethodManager;

    public SuggestionInputAdapter adapter;

    public InterfaceC1581f f5042c;

    public Paint paint;

    public Rect rect;

    public String f5045f;

    public int f5046g;

    public final String[] f5047h;

    public String titleText;

    public String f5049j;

    public String f5050k;

    public int f5051l;

    public int titleTextColor;

    public int f5053n;

    public int f5054o;

    public boolean f5055p;

    public boolean f5056q;

    public interface InterfaceC1581f {
        void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3);

        void onTextChanged(CharSequence charSequence, int i, int i2, int i3);

        void afterTextChanged(Editable editable);

        void mo6527a(String str, int i);

        void mo6528b();

        void mo6529c();

        void mo6530d(boolean z);
    }

    public SuggestionInputView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        this.f5042c = null;
        this.rect = new Rect();
        this.f5045f = "";
        this.f5046g = 0;
        this.f5047h = new String[]{"www", ".com", ".org", ".me", ".cn"};
        this.titleText = null;
        this.f5049j = null;
        this.f5050k = null;
        this.f5051l = -11034895;
        this.f5055p = true;
        this.f5056q = false;
        this.f5053n = (int) TypedValue.applyDimension(1, 10.0f, getResources().getDisplayMetrics());
        this.f5054o = (int) TypedValue.applyDimension(1, 3.0f, getResources().getDisplayMetrics());
        m7099m(context);
    }

    public static int m7088e(SuggestionInputView suggestionInputView, int i) {
        int i2 = i & suggestionInputView.f5046g;
        suggestionInputView.f5046g = i2;
        return i2;
    }

    public static int m7089f(SuggestionInputView suggestionInputView, int i) {
        int i2 = i | suggestionInputView.f5046g;
        suggestionInputView.f5046g = i2;
        return i2;
    }

    @Override
    public void mo7093a(String str, int i) {
        if (this.f5042c == null || TextUtils.isEmpty(str)) {
            return;
        }
        this.f5042c.mo6527a(str, i);
    }

    @Override
    public void mo7094b(String str) {
        if (!this.f5045f.equals(str) && !m7096j()) {
            this.f5045f = str;
            if (str.startsWith(getText().toString().trim())) {
                m7097k();
            }
        }
        Log.i("mysuggest", "found match section:" + str);
    }

    @Override
    public void mo7095c(SuggestionInputAdapter.m mVar) {
        if ((SharedPreferencesHelper.getInstance().defaultLayoutType & 4098) == 4098) {
            BrowserActivity.getActivity().getHandler().post(new Runnable() {
                @Override
                public void run() {
                    SuggestionInputView.this.setListSelection(20);
                }
            });
        }
    }

    @Override
    public void draw(Canvas canvas) {
        if (isFocused()) {
            super.draw(canvas);
            if (TextUtils.isEmpty(this.f5050k)) {
                setCursorVisible(true);
                return;
            }
            setCursorVisible(false);
            Rect clipBounds = canvas.getClipBounds();
            this.paint.setTextSize(getTextSize());
            float fMeasureText = this.paint.measureText(this.f5049j);
            canvas.save();
            canvas.clipRect(clipBounds);
            Paint paint = this.paint;
            String str = this.f5050k;
            paint.getTextBounds(str, 0, str.length(), this.rect);
            Rect rect = this.rect;
            float f = rect.left + fMeasureText;
            Paint paint2 = this.paint;
            String str2 = this.f5045f;
            paint2.getTextBounds(str2, 0, str2.length(), this.rect);
            Rect rect2 = this.rect;
            rect2.left = (int) f;
            rect2.right = (int) (rect.right + fMeasureText);
            rect2.top += getBaseline() - this.f5054o;
            this.rect.bottom += getBaseline() + this.f5054o;
            this.paint.setColor(this.f5051l);
            canvas.drawRect(this.rect, this.paint);
            this.paint.setColor(getCurrentTextColor());
            canvas.drawText(this.f5050k, fMeasureText, getBaseline(), this.paint);
        } else {
            if (TextUtils.isEmpty(this.titleText)) {
                super.draw(canvas);
                return;
            }
            this.paint.setTextSize(getTextSize());
            Paint paint3 = this.paint;
            int currentTextColor = this.titleTextColor;
            if (currentTextColor == 0) {
                currentTextColor = getCurrentTextColor();
            }
            paint3.setColor(currentTextColor);
            Rect clipBounds2 = canvas.getClipBounds();
            clipBounds2.right -= this.f5053n;
            canvas.save();
            canvas.clipRect(clipBounds2);
            canvas.drawText(this.titleText, 0.0f, getBaseline(), this.paint);
        }
        canvas.restore();
    }

    public String getFinalText() {
        if (TextUtils.isEmpty(this.f5050k)) {
            return getText().toString().trim();
        }
        return getText().toString().trim() + this.f5050k;
    }

    public String getTitleText() {
        return this.titleText;
    }

    public final boolean m7096j() {
        return (this.f5046g & 4) == 4;
    }

    public final void m7097k() {
        String strTrim = getText().toString().trim();
        int length = strTrim.length();
        int length2 = this.f5045f.length();
        if (!this.f5045f.startsWith(strTrim) || length <= 0 || length2 <= length) {
            this.f5050k = "";
            return;
        }
        this.f5050k = this.f5045f.substring(length);
        if (f5042c != null) {
            f5042c.mo6529c();
        }
    }

    public void m7098l() {
        ((InputMethodManager) getContext().getSystemService(Context.INPUT_METHOD_SERVICE)).toggleSoftInput(0, 2);
    }

    public final void m7099m(Context context) {
        this.inputMethodManager = (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
        setOnEditorActionListener(this);
        SuggestionInputAdapter suggestionInputAdapter = new SuggestionInputAdapter(context, this);
        this.adapter = suggestionInputAdapter;
        setAdapter(suggestionInputAdapter);
        setFocusable(true);
        setSelectAllOnFocus(true);
        onConfigurationChanged(context.getResources().getConfiguration());
        setThreshold(1);
        setOnItemClickListener(this);
        setOnDismissListener(new OnDismissListener() {
            @Override
            public void onDismiss() {
                SuggestionInputView.this.f5056q = false;
            }
        });
        setOnKeyListener(new OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (TextUtils.isEmpty(SuggestionInputView.this.f5050k) || keyEvent.getKeyCode() != 67) {
                    return false;
                }
                SuggestionInputView suggestionInputView = SuggestionInputView.this;
                suggestionInputView.f5050k = "";
                suggestionInputView.invalidate();
                return true;
            }
        });
        setInputType(524289);
        addTextChangedListener(new TextWatcher() {
            @Override
            public void afterTextChanged(Editable editable) {
                SuggestionInputView suggestionInputView = SuggestionInputView.this;
                suggestionInputView.f5050k = "";
                SuggestionInputView.m7088e(suggestionInputView, -9);
                if (SuggestionInputView.this.getHandler() != null && !SuggestionInputView.this.m7096j() && SuggestionInputView.this.isFocused()) {
                    SuggestionInputView.this.m7097k();
                }
                if (SuggestionInputView.this.f5042c != null) {
                    SuggestionInputView.this.f5042c.afterTextChanged(editable);
                }
                SuggestionInputView.m7088e(SuggestionInputView.this, -5);
                SuggestionInputView.this.f5049j = editable.toString().trim();
            }

            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Log.i("mysuggest", "call beforeTextChanged char " + ((Object) charSequence) + " count:" + i2 + "start:" + i + "after:" + i3);
                StringBuilder sb = new StringBuilder();
                sb.append("getSelectionStart()");
                sb.append(SuggestionInputView.this.getSelectionStart());
                sb.append("getSelectionEnd() ");
                sb.append(SuggestionInputView.this.getSelectionEnd());
                Log.i("mysuggest", sb.toString());
                if (SuggestionInputView.this.f5042c != null) {
                    SuggestionInputView.this.f5042c.beforeTextChanged(charSequence, i, i2, i3);
                }
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i2, int i3) {
                Log.i("mysuggest", "call onTextChanged char " + ((Object) charSequence) + " count:" + i3 + "start:" + i + "before:" + i2);
                SuggestionInputView.m7089f(SuggestionInputView.this, 1);
                if (i3 == 0) {
                    SuggestionInputView.m7089f(SuggestionInputView.this, 4);
                }
                if (SuggestionInputView.this.f5042c != null) {
                    SuggestionInputView.this.f5042c.onTextChanged(charSequence, i, i2, i3);
                }
                InputMethodManager unused = SuggestionInputView.this.inputMethodManager;
            }
        });
        Paint paint = new Paint();
        this.paint = paint;
        paint.setColor(-256);
        this.paint.setAntiAlias(true);
        this.paint.setStrokeWidth(3.0f);
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
        super.onConfigurationChanged(configuration);
    }

    @Override
    public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
        if (i != 6 && i != 2 && i != 4) {
            return false;
        }
        mo7093a(getFinalText(), -1);
        return true;
    }

    @Override
    public void onFocusChanged(boolean z, int i, Rect rect) {
        super.onFocusChanged(z, i, rect);
        if (f5042c != null) {
            f5042c.mo6530d(z);
        }
        if (z) {
            this.f5055p = true;
            if (getEditableText() == null || getEditableText().length() <= 0) {
                this.adapter.m7143U();
            } else {
                setSelection(0, getEditableText().length());
                performFiltering("", 0);
            }
            post(new Runnable() {
                @Override
                public void run() {
                    SuggestionInputView.this.showDropDown();
                }
            });
        } else {
            setSelection(0, 0);
            setTitleText(this.titleText);
            this.f5050k = null;
            m7098l();
        }
        Log.i("test", "edit on focus change:" + z);
    }

    @Override
    public void onItemClick(AdapterView adapterView, View view, int i, long j) {
        SuggestionInputAdapter.k kVarM7142Q = this.adapter.getItem(i);
        String strM7102T = SuggestionInputAdapter.m7102T(kVarM7142Q);
        if (strM7102T != null) {
            mo7093a(strM7102T, kVarM7142Q.type);
        }
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        if (keyEvent.getAction() != 0 || i != 66) {
            return super.onKeyDown(i, keyEvent);
        }
        mo7093a(getFinalText(), -1);
        return true;
    }

    @Override
    public boolean onKeyPreIme(int i, KeyEvent keyEvent) {
        if (i == 4 && keyEvent.getAction() == 1 && f5042c != null) {
            f5042c.mo6528b();
        }
        return super.onKeyPreIme(i, keyEvent);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent motionEvent) {
        if (motionEvent.getAction() == 0 && isFocused() && !TextUtils.isEmpty(this.f5050k)) {
            setText(getFinalText());
        }
        return super.onTouchEvent(motionEvent);
    }

    @Override
    public void performFiltering(CharSequence charSequence, int i) {
        if (i == 67) {
            this.f5046g |= 4;
        }
        if ((this.f5046g & 8) != 8 && isFocused() && this.f5055p) {
            Log.i("mysuggest", "###  do perform......");
            super.performFiltering(charSequence, i);
        }
    }

    public void setListener(InterfaceC1581f interfaceC1581f) {
        this.f5042c = interfaceC1581f;
    }

    public void setSuggestTextColor(int i) {
        this.f5051l = i;
    }

    public void setTitleText(String title) {
        this.titleText = title;
        invalidate();
    }

    public void setTitleTextColor(int color) {
        this.titleTextColor = color;
    }

    @Override
    public SuggestionInputAdapter getAdapter() {
        return this.adapter;
    }
}
