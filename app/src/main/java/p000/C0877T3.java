package p000;

import android.content.Context;
import android.hardware.Camera;
import android.os.Build;
import android.util.Log;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public final class C0877T3 {

    public static final String f2688n = "T3";

    public Camera f2689a;

    public Camera.CameraInfo f2690b;

    public C0646O1 f2691c;

    public C0139D0 f2692d;

    public boolean f2693e;

    public String f2694f;

    public C1205a9 f2696h;

    public C1180Zl f2697i;

    public C1180Zl f2698j;

    public Context f2700l;

    public C0969V3 f2695g = new C0969V3();

    public int f2699k = -1;

    public final a f2701m = new a();

    public final class a implements Camera.PreviewCallback {

        public InterfaceC1372cj f2702a;

        public C1180Zl f2703b;

        public a() {
        }

        public void m4109a(InterfaceC1372cj interfaceC1372cj) {
            this.f2702a = interfaceC1372cj;
        }

        public void m4110b(C1180Zl c1180Zl) {
            this.f2703b = c1180Zl;
        }

        @Override
        public void onPreviewFrame(byte[] bArr, Camera camera) {
            Exception e;
            C1180Zl c1180Zl = this.f2703b;
            InterfaceC1372cj interfaceC1372cj = this.f2702a;
            if (c1180Zl == null || interfaceC1372cj == null) {
                Log.d(C0877T3.f2688n, "Got preview callback, but no handler or resolution available");
                if (interfaceC1372cj == null) {
                    return;
                } else {
                    e = new Exception("No resolution available");
                }
            } else {
                try {
                    if (bArr == null) {
                        throw new NullPointerException("No preview data received");
                    }
                    C2207pm c2207pm = new C2207pm(bArr, c1180Zl.f3463l, c1180Zl.f3464m, camera.getParameters().getPreviewFormat(), C0877T3.this.m4093f());
                    if (C0877T3.this.f2690b.facing == 1) {
                        c2207pm.m9078e(true);
                    }
                    interfaceC1372cj.mo3764b(c2207pm);
                    return;
                } catch (RuntimeException e2) {
                    e = e2;
                    Log.e(C0877T3.f2688n, "Camera preview failed", e);
                }
            }
            interfaceC1372cj.mo3763a(e);
        }
    }

    public C0877T3(Context context) {
        this.f2700l = context;
    }

    public static List m4089i(Camera.Parameters parameters) {
        List<Camera.Size> supportedPreviewSizes = parameters.getSupportedPreviewSizes();
        ArrayList arrayList = new ArrayList<>();
        if (supportedPreviewSizes == null) {
            Camera.Size previewSize = parameters.getPreviewSize();
            if (previewSize != null) {
                new C1180Zl(previewSize.width, previewSize.height);
                arrayList.add(new C1180Zl(previewSize.width, previewSize.height));
            }
            return arrayList;
        }
        for (Camera.Size size : supportedPreviewSizes) {
            arrayList.add(new C1180Zl(size.width, size.height));
        }
        return arrayList;
    }

    public final int m4090c() {
        int iM5104c = this.f2696h.m5104c();
        int i = 0;
        if (iM5104c != 0) {
            if (iM5104c == 1) {
                i = 90;
            } else if (iM5104c == 2) {
                i = 180;
            } else if (iM5104c == 3) {
                i = 270;
            }
        }
        Camera.CameraInfo cameraInfo = this.f2690b;
        int i2 = cameraInfo.facing;
        int i3 = cameraInfo.orientation;
        int i4 = (i2 == 1 ? 360 - ((i3 + i) % 360) : (i3 - i) + 360) % 360;
        Log.i(f2688n, "Camera Display Orientation: " + i4);
        return i4;
    }

    public void m4091d() {
        Camera camera = this.f2689a;
        if (camera != null) {
            camera.release();
            this.f2689a = null;
        }
    }

    public void m4092e() {
        if (this.f2689a == null) {
            throw new RuntimeException("Camera not open");
        }
        m4104r();
    }

    public int m4093f() {
        return this.f2699k;
    }

    public final Camera.Parameters m4094g() {
        Camera.Parameters parameters = this.f2689a.getParameters();
        String str = this.f2694f;
        if (str == null) {
            this.f2694f = parameters.flatten();
        } else {
            parameters.unflatten(str);
        }
        return parameters;
    }

    public C1180Zl m4095h() {
        if (this.f2698j == null) {
            return null;
        }
        return m4096j() ? this.f2698j.m5068e() : this.f2698j;
    }

    public boolean m4096j() {
        int i = this.f2699k;
        if (i != -1) {
            return i % 180 != 0;
        }
        throw new IllegalStateException("Rotation not calculated yet. Call configure() first.");
    }

    public boolean m4097k() {
        String flashMode;
        Camera.Parameters parameters = this.f2689a.getParameters();
        if (parameters == null || (flashMode = parameters.getFlashMode()) == null) {
            return false;
        }
        return "on".equals(flashMode) || "torch".equals(flashMode);
    }

    public void m4098l() {
        Camera cameraM4964b = AbstractC1130Yh.m4964b(this.f2695g.m4321b());
        this.f2689a = cameraM4964b;
        if (cameraM4964b == null) {
            throw new RuntimeException("Failed to open camera");
        }
        int iM4963a = AbstractC1130Yh.m4963a(this.f2695g.m4321b());
        Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
        this.f2690b = cameraInfo;
        Camera.getCameraInfo(iM4963a, cameraInfo);
    }

    public void m4099m(InterfaceC1372cj interfaceC1372cj) {
        Camera camera = this.f2689a;
        if (camera == null || !this.f2693e) {
            return;
        }
        this.f2701m.m4109a(interfaceC1372cj);
        camera.setOneShotPreviewCallback(this.f2701m);
    }

    public final void m4100n(int i) {
        this.f2689a.setDisplayOrientation(i);
    }

    public void m4101o(C0969V3 c0969v3) {
        this.f2695g = c0969v3;
    }

    public final void m4102p(boolean z) {
        Camera.Parameters parametersM4094g = m4094g();
        if (parametersM4094g == null) {
            Log.w(f2688n, "Device error: no camera parameters are available. Proceeding without configuration.");
            return;
        }
        String str = f2688n;
        Log.i(str, "Initial camera parameters: " + parametersM4094g.flatten());
        if (z) {
            Log.w(str, "In camera config safe mode -- most settings will not be honored");
        }
        AbstractC0648O3.m3373g(parametersM4094g, this.f2695g.m4320a(), z);
        if (!z) {
            AbstractC0648O3.m3377k(parametersM4094g, false);
            if (this.f2695g.m4327h()) {
                AbstractC0648O3.m3375i(parametersM4094g);
            }
            if (this.f2695g.m4324e()) {
                AbstractC0648O3.m3369c(parametersM4094g);
            }
            if (this.f2695g.m4326g()) {
                AbstractC0648O3.m3378l(parametersM4094g);
                AbstractC0648O3.m3374h(parametersM4094g);
                AbstractC0648O3.m3376j(parametersM4094g);
            }
        }
        List listM4089i = m4089i(parametersM4094g);
        if (listM4089i.size() == 0) {
            this.f2697i = null;
        } else {
            C1180Zl c1180ZlM5102a = this.f2696h.m5102a(listM4089i, m4096j());
            this.f2697i = c1180ZlM5102a;
            parametersM4094g.setPreviewSize(c1180ZlM5102a.f3463l, c1180ZlM5102a.f3464m);
        }
        if (Build.DEVICE.equals("glass-1")) {
            AbstractC0648O3.m3371e(parametersM4094g);
        }
        Log.i(str, "Final camera parameters: " + parametersM4094g.flatten());
        this.f2689a.setParameters(parametersM4094g);
    }

    public void m4103q(C1205a9 c1205a9) {
        this.f2696h = c1205a9;
    }

    public final void m4104r() {
        try {
            int iM4090c = m4090c();
            this.f2699k = iM4090c;
            m4100n(iM4090c);
        } catch (Exception unused) {
            Log.w(f2688n, "Failed to set rotation.");
        }
        try {
            m4102p(false);
        } catch (Exception unused2) {
            try {
                m4102p(true);
            } catch (Exception unused3) {
                Log.w(f2688n, "Camera rejected even safe-mode parameters! No configuration");
            }
        }
        Camera.Size previewSize = this.f2689a.getParameters().getPreviewSize();
        if (previewSize == null) {
            this.f2698j = this.f2697i;
        } else {
            this.f2698j = new C1180Zl(previewSize.width, previewSize.height);
        }
        this.f2701m.m4110b(this.f2698j);
    }

    public void m4105s(C1015W3 c1015w3) throws IOException {
        c1015w3.m4444a(this.f2689a);
    }

    public void m4106t(boolean z) {
        if (this.f2689a != null) {
            try {
                if (z != m4097k()) {
                    C0646O1 c0646o1 = this.f2691c;
                    if (c0646o1 != null) {
                        c0646o1.m3364j();
                    }
                    Camera.Parameters parameters = this.f2689a.getParameters();
                    AbstractC0648O3.m3377k(parameters, z);
                    if (this.f2695g.m4325f()) {
                        AbstractC0648O3.m3370d(parameters, z);
                    }
                    this.f2689a.setParameters(parameters);
                    C0646O1 c0646o12 = this.f2691c;
                    if (c0646o12 != null) {
                        c0646o12.m3363i();
                    }
                }
            } catch (RuntimeException e) {
                Log.e(f2688n, "Failed to set torch", e);
            }
        }
    }

    public void m4107u() {
        Camera camera = this.f2689a;
        if (camera == null || this.f2693e) {
            return;
        }
        camera.startPreview();
        this.f2693e = true;
        this.f2691c = new C0646O1(this.f2689a, this.f2695g);
        C0139D0 c0139d0 = new C0139D0(this.f2700l, this, this.f2695g);
        this.f2692d = c0139d0;
        c0139d0.m595d();
    }

    public void m4108v() {
        C0646O1 c0646o1 = this.f2691c;
        if (c0646o1 != null) {
            c0646o1.m3364j();
            this.f2691c = null;
        }
        C0139D0 c0139d0 = this.f2692d;
        if (c0139d0 != null) {
            c0139d0.m596e();
            this.f2692d = null;
        }
        Camera camera = this.f2689a;
        if (camera == null || !this.f2693e) {
            return;
        }
        camera.stopPreview();
        this.f2701m.m4109a(null);
        this.f2693e = false;
    }
}
