package p000;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.SurfaceHolder;
import java.io.IOException;

/* loaded from: classes.dex */
public class C1015W3 {

    public SurfaceHolder f3023a;

    public SurfaceTexture f3024b;

    public C1015W3(SurfaceTexture surfaceTexture) {
        if (surfaceTexture == null) {
            throw new IllegalArgumentException("surfaceTexture may not be null");
        }
        this.f3024b = surfaceTexture;
    }

    public void m4444a(Camera camera) throws IOException {
        SurfaceHolder surfaceHolder = this.f3023a;
        if (surfaceHolder != null) {
            camera.setPreviewDisplay(surfaceHolder);
        } else {
            camera.setPreviewTexture(this.f3024b);
        }
    }

    public C1015W3(SurfaceHolder surfaceHolder) {
        if (surfaceHolder == null) {
            throw new IllegalArgumentException("surfaceHolder may not be null");
        }
        this.f3023a = surfaceHolder;
    }
}
