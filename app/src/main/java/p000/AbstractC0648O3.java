package p000;

import android.graphics.Rect;
import android.hardware.Camera;
import android.util.Log;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.regex.Pattern;
import p000.C0969V3;

/* loaded from: classes.dex */
public abstract class AbstractC0648O3 {

    public static final Pattern f2002a = Pattern.compile(";");

    public static List m3367a(int i) {
        int i2 = -i;
        return Collections.singletonList(new Camera.Area(new Rect(i2, i2, i, i), 1));
    }

    public static String m3368b(String str, Collection collection, String... strArr) {
        Log.i("CameraConfiguration", "Requesting " + str + " value from among: " + Arrays.toString(strArr));
        Log.i("CameraConfiguration", "Supported " + str + " values: " + collection);
        if (collection != null) {
            for (String str2 : strArr) {
                if (collection.contains(str2)) {
                    Log.i("CameraConfiguration", "Can set " + str + " to: " + str2);
                    return str2;
                }
            }
        }
        Log.i("CameraConfiguration", "No supported values match");
        return null;
    }

    public static void m3369c(Camera.Parameters parameters) {
        if ("barcode".equals(parameters.getSceneMode())) {
            Log.i("CameraConfiguration", "Barcode scene mode already set");
            return;
        }
        String strM3368b = m3368b("scene mode", parameters.getSupportedSceneModes(), "barcode");
        if (strM3368b != null) {
            parameters.setSceneMode(strM3368b);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0069  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void m3370d(Camera.Parameters r6, boolean r7) {
        /*
            int r0 = r6.getMinExposureCompensation()
            int r1 = r6.getMaxExposureCompensation()
            float r2 = r6.getExposureCompensationStep()
            java.lang.String r3 = "CameraConfiguration"
            if (r0 != 0) goto L12
            if (r1 == 0) goto L69
        L12:
            r4 = 0
            int r5 = (r2 > r4 ? 1 : (r2 == r4 ? 0 : -1))
            if (r5 <= 0) goto L69
            if (r7 == 0) goto L1a
            goto L1c
        L1a:
            r4 = 1069547520(0x3fc00000, float:1.5)
        L1c:
            float r4 = r4 / r2
            int r7 = java.lang.Math.round(r4)
            float r4 = (float) r7
            float r2 = r2 * r4
            int r7 = java.lang.Math.min(r7, r1)
            int r7 = java.lang.Math.max(r7, r0)
            int r0 = r6.getExposureCompensation()
            java.lang.String r1 = " / "
            if (r0 != r7) goto L4b
            java.lang.StringBuilder r6 = new java.lang.StringBuilder
            r6.<init>()
            java.lang.String r0 = "Exposure compensation already set to "
            r6.append(r0)
            r6.append(r7)
            r6.append(r1)
            r6.append(r2)
            java.lang.String r6 = r6.toString()
            goto L6b
        L4b:
            java.lang.StringBuilder r0 = new java.lang.StringBuilder
            r0.<init>()
            java.lang.String r4 = "Setting exposure compensation to "
            r0.append(r4)
            r0.append(r7)
            r0.append(r1)
            r0.append(r2)
            java.lang.String r0 = r0.toString()
            android.util.Log.i(r3, r0)
            r6.setExposureCompensation(r7)
            goto L6e
        L69:
            java.lang.String r6 = "Camera does not support exposure compensation"
        L6b:
            android.util.Log.i(r3, r6)
        L6e:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC0648O3.m3370d(android.hardware.Camera$Parameters, boolean):void");
    }

    public static void m3371e(Camera.Parameters parameters) {
        m3372f(parameters, 10, 20);
    }

    public static void m3372f(Camera.Parameters parameters, int i, int i2) {
        int[] next;
        String str;
        List<int[]> supportedPreviewFpsRange = parameters.getSupportedPreviewFpsRange();
        Log.i("CameraConfiguration", "Supported FPS ranges: " + m3380n(supportedPreviewFpsRange));
        if (supportedPreviewFpsRange == null || supportedPreviewFpsRange.isEmpty()) {
            return;
        }
        Iterator<int[]> it = supportedPreviewFpsRange.iterator();
        while (true) {
            if (!it.hasNext()) {
                next = null;
                break;
            }
            next = it.next();
            int i3 = next[0];
            int i4 = next[1];
            if (i3 >= i * 1000 && i4 <= i2 * 1000) {
                break;
            }
        }
        if (next == null) {
            str = "No suitable FPS range?";
        } else {
            int[] iArr = new int[2];
            parameters.getPreviewFpsRange(iArr);
            if (!Arrays.equals(iArr, next)) {
                Log.i("CameraConfiguration", "Setting FPS range to " + Arrays.toString(next));
                parameters.setPreviewFpsRange(next[0], next[1]);
                return;
            }
            str = "FPS range already set to " + Arrays.toString(next);
        }
        Log.i("CameraConfiguration", str);
    }

    public static void m3373g(Camera.Parameters parameters, C0969V3.a aVar, boolean z) {
        List<String> supportedFocusModes = parameters.getSupportedFocusModes();
        String strM3368b = (z || aVar == C0969V3.a.AUTO) ? m3368b("focus mode", supportedFocusModes, "auto") : aVar == C0969V3.a.CONTINUOUS ? m3368b("focus mode", supportedFocusModes, "continuous-picture", "continuous-video", "auto") : aVar == C0969V3.a.INFINITY ? m3368b("focus mode", supportedFocusModes, "infinity") : aVar == C0969V3.a.MACRO ? m3368b("focus mode", supportedFocusModes, "macro") : null;
        if (!z && strM3368b == null) {
            strM3368b = m3368b("focus mode", supportedFocusModes, "macro", "edof");
        }
        if (strM3368b != null) {
            if (!strM3368b.equals(parameters.getFocusMode())) {
                parameters.setFocusMode(strM3368b);
                return;
            }
            Log.i("CameraConfiguration", "Focus mode already set to " + strM3368b);
        }
    }

    public static void m3374h(Camera.Parameters parameters) {
        if (parameters.getMaxNumFocusAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support focus areas");
            return;
        }
        Log.i("CameraConfiguration", "Old focus areas: " + m3379m(parameters.getFocusAreas()));
        List<Camera.Area> listM3367a = m3367a(400);
        Log.i("CameraConfiguration", "Setting focus area to : " + m3379m(listM3367a));
        parameters.setFocusAreas(listM3367a);
    }

    public static void m3375i(Camera.Parameters parameters) {
        if ("negative".equals(parameters.getColorEffect())) {
            Log.i("CameraConfiguration", "Negative effect already set");
            return;
        }
        String strM3368b = m3368b("color effect", parameters.getSupportedColorEffects(), "negative");
        if (strM3368b != null) {
            parameters.setColorEffect(strM3368b);
        }
    }

    public static void m3376j(Camera.Parameters parameters) {
        if (parameters.getMaxNumMeteringAreas() <= 0) {
            Log.i("CameraConfiguration", "Device does not support metering areas");
            return;
        }
        Log.i("CameraConfiguration", "Old metering areas: " + parameters.getMeteringAreas());
        List<Camera.Area> listM3367a = m3367a(400);
        Log.i("CameraConfiguration", "Setting metering area to : " + m3379m(listM3367a));
        parameters.setMeteringAreas(listM3367a);
    }

    public static void m3377k(Camera.Parameters parameters, boolean z) {
        List<String> supportedFlashModes = parameters.getSupportedFlashModes();
        String strM3368b = z ? m3368b("flash mode", supportedFlashModes, "torch", "on") : m3368b("flash mode", supportedFlashModes, "off");
        if (strM3368b != null) {
            if (strM3368b.equals(parameters.getFlashMode())) {
                Log.i("CameraConfiguration", "Flash mode already set to " + strM3368b);
                return;
            }
            Log.i("CameraConfiguration", "Setting flash mode to " + strM3368b);
            parameters.setFlashMode(strM3368b);
        }
    }

    public static void m3378l(Camera.Parameters parameters) {
        String str;
        if (!parameters.isVideoStabilizationSupported()) {
            str = "This device does not support video stabilization";
        } else {
            if (!parameters.getVideoStabilization()) {
                Log.i("CameraConfiguration", "Enabling video stabilization...");
                parameters.setVideoStabilization(true);
                return;
            }
            str = "Video stabilization already enabled";
        }
        Log.i("CameraConfiguration", str);
    }

    public static String m3379m(Iterable iterable) {
        if (iterable == null) {
            return null;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            Camera.Area area = (Camera.Area) it.next();
            sb.append(area.rect);
            sb.append(':');
            sb.append(area.weight);
            sb.append(' ');
        }
        return sb.toString();
    }

    public static String m3380n(Collection collection) {
        if (collection == null || collection.isEmpty()) {
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            sb.append(Arrays.toString((int[]) it.next()));
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(']');
        return sb.toString();
    }
}
