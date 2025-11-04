package p000;

import android.content.Context;
import android.os.Handler;
import android.view.GestureDetector;
import android.view.MotionEvent;

public final class TouchEventDispatcher {

    public final GestureDetector f65a;

    public TouchEventDispatcher(Context context, GestureDetector.OnGestureListener onGestureListener) {
        this(context, onGestureListener, null);
    }

    public boolean m116a(MotionEvent motionEvent) {
        return this.f65a.onTouchEvent(motionEvent);
    }

    public TouchEventDispatcher(Context context, GestureDetector.OnGestureListener onGestureListener, Handler handler) {
        this.f65a = new GestureDetector(context, onGestureListener, handler);
    }
}
