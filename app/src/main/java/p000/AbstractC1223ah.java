package p000;

import android.view.MotionEvent;

/* loaded from: classes.dex */
public abstract class AbstractC1223ah {
    public static int m5280a(MotionEvent motionEvent, int i) {
        return motionEvent.findPointerIndex(i);
    }

    public static int m5281b(MotionEvent motionEvent) {
        return motionEvent.getActionIndex();
    }

    public static int m5282c(MotionEvent motionEvent) {
        return motionEvent.getPointerCount();
    }

    public static int m5283d(MotionEvent motionEvent, int i) {
        return motionEvent.getPointerId(i);
    }

    public static float m5284e(MotionEvent motionEvent, int i) {
        return motionEvent.getX(i);
    }
}
