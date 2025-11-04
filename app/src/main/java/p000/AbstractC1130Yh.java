package p000;

import android.hardware.Camera;
import android.util.Log;

public abstract class AbstractC1130Yh {

    public static final String f3357a = "Yh";

    public static int m4963a(int i) {
        int numberOfCameras = Camera.getNumberOfCameras();
        if (numberOfCameras == 0) {
            Log.w(f3357a, "No cameras!");
            return -1;
        }
        boolean z = i >= 0;
        if (!z) {
            i = 0;
            while (i < numberOfCameras) {
                Camera.CameraInfo cameraInfo = new Camera.CameraInfo();
                Camera.getCameraInfo(i, cameraInfo);
                if (cameraInfo.facing == 0) {
                    break;
                }
                i++;
            }
        }
        return i < numberOfCameras ? i : z ? -1 : 0;
    }

    public static Camera m4964b(int i) {
        int iM4963a = m4963a(i);
        if (iM4963a == -1) {
            return null;
        }
        return Camera.open(iM4963a);
    }
}
