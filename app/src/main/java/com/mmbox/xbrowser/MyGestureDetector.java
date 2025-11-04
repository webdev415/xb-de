package com.mmbox.xbrowser;

import android.content.Context;
import android.view.MotionEvent;
import android.view.ViewConfiguration;
import com.xbrowser.play.R;
import java.util.ArrayList;
import java.util.Iterator;

public class GestureDetector {

    public int invalidGestureDistance = 0;

    public int validGestureDistance = 0;

    public ArrayList gestureSequence = new ArrayList<>();

    public final int touchSlop;

    public final int minDeltaSlot;

    public MotionEvent initialMotionEvent;

    public GestureCallback gestureCallback;

    public interface GestureCallback {
        void onGestureDetected(String gesturePattern);
    }

    public GestureDetector(Context context, GestureCallback gestureCallback) {
        this.gestureCallback = gestureCallback;
        this.touchSlop = ViewConfiguration.get(context).getScaledTouchSlop();
        this.minDeltaSlot = context.getResources().getDimensionPixelSize(R.dimen.gesture_min_delta_slot);
    }

    public char detectSwipeDirection(MotionEvent motionEvent, MotionEvent motionEvent2) {
        float x = motionEvent.getX();
        float y = motionEvent.getY();
        float x2 = motionEvent2.getX() - x;
        float y2 = motionEvent2.getY() - y;
        if (Math.abs(x2) > Math.abs(y2)) {
            if (x2 <= 0.0f || x2 <= this.touchSlop) {
                return (x2 >= 0.0f || Math.abs(x2) <= ((float) this.touchSlop)) ? '-' : 'L';
            }
            return 'R';
        }
        if (Math.abs(y2) <= Math.abs(x2)) {
            return '-';
        }
        if (y2 <= 0.0f || y2 <= this.touchSlop) {
            return (y2 >= 0.0f || Math.abs(y2) <= ((float) this.touchSlop)) ? '-' : 'U';
        }
        return 'D';
    }

    public String getGesturePattern() {
        StringBuffer stringBuffer = new StringBuffer();
        Iterator it = this.gestureSequence.iterator();
        while (it.hasNext()) {
            stringBuffer.append(((Character) it.next()).charValue());
        }
        return stringBuffer.toString();
    }

    /* JADX WARN: Removed duplicated region for block: B:28:0x006f  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0071  */
    /* JADX WARN: Removed duplicated region for block: B:35:0x008e  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0098  */
    /* JADX WARN: Removed duplicated region for block: B:40:0x00ae  */
    /* JADX WARN: Removed duplicated region for block: B:41:0x00b5  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean onTouchEvent(MotionEvent r11) {
        /*
            r10 = this;
            r0 = 0
            if (r11 != 0) goto L4
            return r0
        L4:
            float r1 = r11.getX()
            float r2 = r11.getY()
            int r3 = r11.getAction()
            if (r3 != 0) goto L1a
        L12:
            android.view.MotionEvent r11 = android.view.MotionEvent.obtain(r11)
            r10.initialMotionEvent = r11
            goto Lda
        L1a:
            int r3 = r11.getAction()
            r4 = 2
            r5 = 1
            if (r3 != r4) goto Lbc
            android.view.MotionEvent r3 = r10.initialMotionEvent
            if (r3 != 0) goto L27
            return r0
        L27:
            float r3 = r3.getX()
            android.view.MotionEvent r4 = r10.initialMotionEvent
            float r4 = r4.getY()
            float r1 = r1 - r3
            float r1 = java.lang.Math.abs(r1)
            float r2 = r2 - r4
            float r2 = java.lang.Math.abs(r2)
            int r3 = r10.minDeltaSlot
            float r4 = (float) r3
            int r4 = (r1 > r4 ? 1 : (r1 == r4 ? 0 : -1))
            if (r4 > 0) goto L47
            float r3 = (float) r3
            int r3 = (r2 > r3 ? 1 : (r2 == r3 ? 0 : -1))
            if (r3 <= 0) goto Lda
        L47:
            android.view.MotionEvent r3 = r10.initialMotionEvent
            char r3 = r10.detectSwipeDirection(r3, r11)
            r4 = 68
            r6 = 4629137466983448576(0x403e000000000000, double:30.0)
            if (r3 == r4) goto L71
            r4 = 76
            if (r3 == r4) goto L60
            r4 = 82
            if (r3 == r4) goto L60
            r4 = 85
            if (r3 == r4) goto L71
            goto L81
        L60:
            float r4 = r2 / r1
            double r8 = (double) r4
            double r8 = java.lang.Math.atan(r8)
            double r8 = java.lang.Math.toDegrees(r8)
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 >= 0) goto L81
        L6f:
            r4 = r5
            goto L82
        L71:
            float r4 = r1 / r2
            double r8 = (double) r4
            double r8 = java.lang.Math.atan(r8)
            double r8 = java.lang.Math.toDegrees(r8)
            int r4 = (r8 > r6 ? 1 : (r8 == r6 ? 0 : -1))
            if (r4 >= 0) goto L81
            goto L6f
        L81:
            r4 = r0
        L82:
            float r1 = r1 * r1
            float r2 = r2 * r2
            float r1 = r1 + r2
            int r1 = (int) r1
            java.util.ArrayList r2 = r10.gestureSequence
            boolean r2 = r2.isEmpty()
            if (r2 == 0) goto L98
        L8e:
            java.util.ArrayList r2 = r10.gestureSequence
            java.lang.Character r3 = java.lang.Character.valueOf(r3)
            r2.add(r3)
            goto Lac
        L98:
            java.util.ArrayList r2 = r10.gestureSequence
            int r6 = r2.size()
            int r6 = r6 - r5
            java.lang.Object r2 = r2.get(r6)
            java.lang.Character r2 = (java.lang.Character) r2
            char r2 = r2.charValue()
            if (r3 == r2) goto Lac
            goto L8e
        Lac:
            if (r4 == 0) goto Lb5
            int r2 = r10.validGestureDistance
            int r2 = r2 + r1
            r10.validGestureDistance = r2
            goto L12
        Lb5:
            int r2 = r10.invalidGestureDistance
            int r2 = r2 + r1
            r10.invalidGestureDistance = r2
            goto L12
        Lbc:
            int r11 = r11.getAction()
            if (r11 != r5) goto Lda
            int r11 = r10.invalidGestureDistance
            int r1 = r10.validGestureDistance
            if (r11 >= r1) goto Ld1
            java.lang.String r11 = r10.getGesturePattern()
            com.mmbox.xbrowser.i$a r1 = r10.gestureCallback
            r1.mo6388a(r11)
        Ld1:
            r10.invalidGestureDistance = r0
            r10.validGestureDistance = r0
            java.util.ArrayList r11 = r10.gestureSequence
            r11.clear()
        Lda:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.C1574i.m7063c(android.view.MotionEvent):boolean");
    }
}
