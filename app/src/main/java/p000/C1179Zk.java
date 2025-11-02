package p000;

import android.content.Context;
import android.view.OrientationEventListener;
import android.view.WindowManager;

public class C1179Zk {

    public int f3458a;

    public WindowManager f3459b;

    public OrientationEventListener f3460c;

    public InterfaceC1133Yk f3461d;

    public class a extends OrientationEventListener {
        public a(Context context, int i) {
            super(context, i);
        }

        @Override
        public void onOrientationChanged(int i) {
            int rotation;
            WindowManager windowManager = C1179Zk.this.f3459b;
            InterfaceC1133Yk interfaceC1133Yk = C1179Zk.this.f3461d;
            if (C1179Zk.this.f3459b == null || interfaceC1133Yk == null || (rotation = windowManager.getDefaultDisplay().getRotation()) == C1179Zk.this.f3458a) {
                return;
            }
            C1179Zk.this.f3458a = rotation;
            interfaceC1133Yk.mo4988a(rotation);
        }
    }

    public void m5065e(Context context, InterfaceC1133Yk interfaceC1133Yk) {
        m5066f();
        Context applicationContext = context.getApplicationContext();
        this.f3461d = interfaceC1133Yk;
        this.f3459b = (WindowManager) applicationContext.getSystemService("window");
        a aVar = new a(applicationContext, 3);
        this.f3460c = aVar;
        aVar.enable();
        this.f3458a = this.f3459b.getDefaultDisplay().getRotation();
    }

    public void m5066f() {
        OrientationEventListener orientationEventListener = this.f3460c;
        if (orientationEventListener != null) {
            orientationEventListener.disable();
        }
        this.f3460c = null;
        this.f3459b = null;
        this.f3461d = null;
    }
}
