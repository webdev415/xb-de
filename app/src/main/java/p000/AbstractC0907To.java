package p000;

import android.text.TextUtils;
import android.webkit.WebView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;

/* loaded from: classes.dex */
public abstract class AbstractC0907To {

    public static String f2782a;

    public static WebView m4181a(BrowserActivity browserActivity, int i) {
        C0219Ep c0219Ep = new C0219Ep(browserActivity);
        c0219Ep.setLayerType(2, null);
        if (f2782a == null) {
            m4182b(c0219Ep);
        }
        if (i == 0) {
            c0219Ep.addJavascriptInterface(new C2107nf(browserActivity), "mbrowser");
        }
        c0219Ep.setDrawingCacheEnabled(true);
        c0219Ep.setDrawingCacheQuality(1048576);
        SharedPreferencesHelper.getInstance().m6868N0(c0219Ep);
        c0219Ep.setScrollBarStyle(0);
        return c0219Ep;
    }

    public static void m4182b(WebView webView) {
        String strSubstring;
        int iIndexOf;
        String userAgentString = webView.getSettings().getUserAgentString();
        if (TextUtils.isEmpty(userAgentString)) {
            return;
        }
        int iIndexOf2 = userAgentString.indexOf("Chrome/");
        if (iIndexOf2 > 0 && (iIndexOf = (strSubstring = userAgentString.substring(iIndexOf2 + 7)).indexOf(32)) > 0) {
            f2782a = strSubstring.substring(0, iIndexOf);
        }
        SharedPreferencesHelper.getInstance();
        SharedPreferencesHelper.defaultUserAgent = userAgentString;
    }
}
