package p000;

import android.widget.FrameLayout;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserControllerListener;
import java.lang.reflect.Constructor;

/* loaded from: classes.dex */
public class C1346c3 extends AbstractC2274r6 {

    public BrowserActivity f3913k;

    public C1346c3(BrowserActivity browserActivity, FrameLayout frameLayout) {
        super(browserActivity, frameLayout);
        this.f3913k = browserActivity;
    }

    @Override
    public InterfaceC1300b3 mo5705r(String str, String str2) throws NoSuchMethodException, SecurityException {
        if (!this.f3913k.getApplicationInfo().packageName.equals(str)) {
            return null;
        }
        try {
            Constructor<?> constructor = this.f3913k.getClassLoader().loadClass(str2).getConstructor(BrowserActivity.class, BrowserControllerListener.class);
            BrowserActivity browserActivity = this.f3913k;
            return (InterfaceC1300b3) constructor.newInstance(browserActivity, browserActivity.m6218I0());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
