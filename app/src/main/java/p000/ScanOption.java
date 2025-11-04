package p000;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.journeyapps.barcodescanner.CaptureActivity;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class C0024Ae {

    public static final Collection f67g = toList("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");

    public static final Collection f68h = toList("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");

    public static final Collection f69i = null;

    public final Activity activity;

    public Fragment fragment;

    public Collection<String> scanFormats;

    public Class captureClass;

    public final Map<String, Object> options = new HashMap<>(3);

    public int requestCode = 49374;

    public C0024Ae(Activity activity) {
        this.activity = activity;
    }

    public static List<String> toList(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public final C0024Ae putOption(String str, Object obj) {
        this.options.put(str, obj);
        return this;
    }

    public final void putIntentExtra(Intent intent) {
        for (Map.Entry<String, Object> entry : this.options.entrySet()) {
            String key = entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                intent.putExtra(key, (Integer) value);
            } else if (value instanceof Long) {
                intent.putExtra(key, (Long) value);
            } else if (value instanceof Boolean) {
                intent.putExtra(key, (Boolean) value);
            } else if (value instanceof Double) {
                intent.putExtra(key, (Double) value);
            } else if (value instanceof Float) {
                intent.putExtra(key, (Float) value);
            } else if (value instanceof Bundle) {
                intent.putExtra(key, (Bundle) value);
            } else if (value instanceof int[]) {
                intent.putExtra(key, (int[]) value);
            } else if (value instanceof long[]) {
                intent.putExtra(key, (long[]) value);
            } else if (value instanceof boolean[]) {
                intent.putExtra(key, (boolean[]) value);
            } else if (value instanceof double[]) {
                intent.putExtra(key, (double[]) value);
            } else if (value instanceof float[]) {
                intent.putExtra(key, (float[]) value);
            } else if (value instanceof String[]) {
                intent.putExtra(key, (String[]) value);
            } else {
                intent.putExtra(key, value.toString());
            }
        }
    }

    public Intent getIntent() {
        Intent intent = new Intent(this.activity, (Class<?>) getCaptureClassSafe());
        intent.setAction("com.google.zxing.client.android.SCAN");
        if (this.scanFormats != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.scanFormats) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb.toString());
        }
        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_DOCUMENT);
        putIntentExtra(intent);
        return intent;
    }

    public Class getCaptureClassSafe() {
        if (this.captureClass == null) {
            this.captureClass = getCaptureClass();
        }
        return this.captureClass;
    }

    public Class getCaptureClass() {
        return CaptureActivity.class;
    }

    public final void start() {
        startActivityForResult(getIntent(), this.requestCode);
    }

    public C0024Ae setClass(Class cls) {
        this.captureClass = cls;
        return this;
    }

    public C0024Ae setFormats(String... strArr) {
        this.scanFormats = Arrays.asList(strArr);
        return this;
    }

    public C0024Ae lockOrientation(boolean z) {
        putOption("SCAN_ORIENTATION_LOCKED", z);
        return this;
    }

    public C0024Ae setRequestCode(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("requestCode out of range");
        }
        this.requestCode = i;
        return this;
    }

    public void startActivityForResult(Intent intent, int requestCode) {
        if (fragment != null) {
            fragment.startActivityForResult(intent, requestCode);
        } else {
            activity.startActivityForResult(intent, requestCode);
        }
    }
}
