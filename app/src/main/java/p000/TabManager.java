package p000;

import android.widget.FrameLayout;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserControllerListener;
import java.lang.reflect.Constructor;

public class TabManager extends ContentViewManager {

    public BrowserActivity f3913k;

    public TabManager(BrowserActivity browserActivity, FrameLayout frameLayout) {
        super(browserActivity, frameLayout);
        this.f3913k = browserActivity;
    }

    @Override
    public InterfaceC1300b3 mo5705r(String pkg, String className) throws NoSuchMethodException, SecurityException {
        if (!this.f3913k.getApplicationInfo().packageName.equals(pkg)) {
            return null;
        }
        try {
            Constructor<?> constructor = this.f3913k.getClassLoader().loadClass(className).getConstructor(BrowserActivity.class, BrowserControllerListener.class);
            BrowserActivity browserActivity = this.f3913k;
            return (InterfaceC1300b3) constructor.newInstance(browserActivity, browserActivity.getActivityDelegate());
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
