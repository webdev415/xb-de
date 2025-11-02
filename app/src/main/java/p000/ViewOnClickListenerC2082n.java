package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class ViewOnClickListenerC2082n extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f6282b;

    public class a implements View.OnClickListener {

        public class RunnableC2719a implements Runnable {
            public RunnableC2719a() {
            }

            @Override
            public void run() throws URISyntaxException {
                ViewOnClickListenerC2082n.this.dismiss();
                ViewOnClickListenerC2082n.this.f6282b.m6307d2("x:donate");
            }
        }

        public a() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC2082n.this.f6282b.runOnUiThread(new RunnableC2719a());
        }
    }

    public ViewOnClickListenerC2082n(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f6282b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_about_info);
        TextView textView = (TextView) findViewById(R.id.version_info);
        TextView textView2 = (TextView) findViewById(R.id.about_info);
        String string = this.f6282b.getString(R.string.str_about_info);
        textView.setText(PhoneUtils.getInstance().getVersionName() + " build " + PhoneUtils.getInstance().getVersionCode());
        textView2.setText(string.replaceAll("\\*", "\n\n"));
        Button button = (Button) findViewById(R.id.btn_donation);
        if (PhoneUtils.getInstance().isGooglePlayChannel()) {
            TextView textView3 = (TextView) findViewById(R.id.donate_info);
            if (textView3 != null) {
                textView3.setVisibility(View.GONE);
            }
            ImageView imageView = (ImageView) findViewById(R.id.div1);
            if (imageView != null) {
                imageView.setVisibility(View.GONE);
            }
            button.setVisibility(View.GONE);
        }
        button.setOnClickListener(new a());
    }

    @Override
    public void onClick(View view) {
    }
}
