package p000;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

public final class C0022Ac {

    public final GestureDetector f65a;

    public C0022Ac(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean m116a(MotionEvent motionEvent) {
        return this.f65a.onTouchEvent(motionEvent);
    }

    public C0022Ac(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f65a = new GestureDetector(context, onGestureListener, handler);
    }
}
