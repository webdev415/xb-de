package p000;

import android.os.Bundle;
import android.speech.tts.TextToSpeech;
import android.speech.tts.UtteranceProgressListener;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.util.Locale;

/* loaded from: classes.dex */
public class C1651dn extends UtteranceProgressListener implements TextToSpeech.OnInitListener {

    public static C1651dn f5331i;

    public BrowserActivity f5332a;

    public TextToSpeech f5333b;

    public String[] f5334c = null;

    public int f5335d = 0;

    public View f5336e = null;

    public ImageView f5337f = null;

    public boolean f5338g = false;

    public String f5339h;

    public class a implements View.OnClickListener {
        public a() {
        }

        @Override
        public void onClick(View view) {
            C1651dn.this.f5332a.getBrowserFrameLayout().removeView(C1651dn.this.f5336e);
            C1651dn c1651dn = C1651dn.this;
            c1651dn.f5334c = null;
            c1651dn.m7363j();
            C1651dn.this.f5338g = false;
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            ImageView imageView;
            int i;
            if (C1651dn.this.f5333b != null) {
                if (C1651dn.this.f5333b.isSpeaking()) {
                    C1651dn.this.m7358e();
                    imageView = C1651dn.this.f5337f;
                    if (imageView == null) {
                        return;
                    } else {
                        i = R.drawable.ic_toolbar_play;
                    }
                } else {
                    C1651dn.this.m7359f();
                    imageView = C1651dn.this.f5337f;
                    if (imageView == null) {
                        return;
                    } else {
                        i = R.drawable.ic_toolbar_pause;
                    }
                }
                imageView.setImageResource(i);
            }
        }
    }

    public class c implements Runnable {
        public c() {
        }

        @Override
        public void run() {
            ImageView imageView = C1651dn.this.f5337f;
            if (imageView != null) {
                imageView.setImageResource(R.drawable.ic_toolbar_play);
            }
        }
    }

    public static C1651dn m7356c() {
        if (f5331i == null) {
            synchronized (C1651dn.class) {
                try {
                    if (f5331i == null) {
                        f5331i = new C1651dn();
                    }
                } finally {
                }
            }
        }
        return f5331i;
    }

    public void m7357d(BrowserActivity browserActivity) {
        this.f5332a = browserActivity;
    }

    public void m7358e() {
        TextToSpeech textToSpeech = this.f5333b;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

    public final void m7359f() {
        String[] strArr;
        if (this.f5333b == null || (strArr = this.f5334c) == null || this.f5335d >= strArr.length) {
            return;
        }
        m7362i();
    }

    public final void m7360g() {
        if (this.f5338g) {
            return;
        }
        View viewM9497r = ThemeManager.getInstance().m9497r();
        this.f5336e = viewM9497r;
        viewM9497r.findViewById(R.id.close_tts_btn).setOnClickListener(new a());
        ImageView imageView = (ImageView) this.f5336e.findViewById(R.id.btn_play_or_pause);
        this.f5337f = imageView;
        if (imageView != null) {
            imageView.setOnClickListener(new b());
        }
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-2, -2);
        layoutParams.gravity = 85;
        int dimension = (int) this.f5332a.getResources().getDimension(R.dimen.tts_fcb_gravity_x);
        int dimension2 = (int) this.f5332a.getResources().getDimension(R.dimen.tts_fcb_gravity_y);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = dimension2;
        layoutParams.rightMargin = dimension;
        this.f5332a.getBrowserFrameLayout().addView(this.f5336e, layoutParams);
        this.f5338g = true;
    }

    public void m7361h(String str) {
        if (!TextUtils.isEmpty(str)) {
            str = AndroidSystemUtils.normalizeSpaces(str);
        }
        this.f5339h = str;
        this.f5335d = 0;
        String[] strArrSplit = str.split("[\n,，,。,？,！,；,：,、,.,?!,;:]");
        this.f5334c = strArrSplit;
        if (strArrSplit != null && strArrSplit.length > 1) {
            m7360g();
        }
        if (this.f5333b == null) {
            this.f5333b = new TextToSpeech(this.f5332a, this);
        } else {
            m7362i();
        }
    }

    public final void m7362i() {
        ImageView imageView = this.f5337f;
        if (imageView != null) {
            imageView.setImageResource(R.drawable.ic_toolbar_pause);
        }
        if (this.f5333b != null) {
            Bundle bundle = new Bundle();
            bundle.putString("utteranceId", Integer.toString(this.f5335d));
            TextToSpeech textToSpeech = this.f5333b;
            String[] strArr = this.f5334c;
            int i = this.f5335d;
            textToSpeech.speak(strArr[i], 0, bundle, Integer.toString(i));
        }
    }

    public void m7363j() {
        TextToSpeech textToSpeech = this.f5333b;
        if (textToSpeech != null) {
            textToSpeech.stop();
        }
    }

    @Override
    public void onDone(String str) {
        Log.i("TTS", "onDone utteranceId = " + str);
        int i = this.f5335d + 1;
        this.f5335d = i;
        if (i < this.f5334c.length) {
            m7362i();
        } else {
            this.f5335d = 0;
            this.f5332a.runOnUiThread(new c());
        }
    }

    @Override
    public void onInit(int i) {
        if (i != 0) {
            Log.e("TTS", "Initialization failed");
            return;
        }
        int language = this.f5333b.setLanguage(Locale.getDefault());
        if (language == -1 || language == -2) {
            Log.e("TTS", "Language not supported");
        }
        this.f5333b.setOnUtteranceProgressListener(this);
        if (this.f5334c.length > 0) {
            m7362i();
        }
    }

    @Override
    public void onStart(String str) {
        Log.i("TTS", "onStart utteranceId = " + str);
    }

    @Override
    public void onError(String str) {
    }
}
