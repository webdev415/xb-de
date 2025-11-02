package p000;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import com.journeyapps.barcodescanner.CaptureActivity;
import java.io.Serializable;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/* loaded from: classes.dex */
public class C0024Ae {

    public static final Collection f67g = m121g("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14");

    public static final Collection f68h = m121g("UPC_A", "UPC_E", "EAN_8", "EAN_13", "RSS_14", "CODE_39", "CODE_93", "CODE_128", "ITF", "RSS_14", "RSS_EXPANDED");

    public static final Collection f69i = null;

    public final Activity f70a;

    public Fragment f71b;

    public Collection f73d;

    public Class f74e;

    public final Map f72c = new HashMap<>(3);

    public int f75f = 49374;

    public C0024Ae(Activity activity) {
        this.f70a = activity;
    }

    public static List m121g(String... strArr) {
        return Collections.unmodifiableList(Arrays.asList(strArr));
    }

    public final C0024Ae m122a(String str, Object obj) {
        this.f72c.put(str, obj);
        return this;
    }

    public final void m123b(Intent intent) {
        Serializable serializable;
        for (Map.Entry entry : this.f72c.entrySet()) {
            String str = (String) entry.getKey();
            Object value = entry.getValue();
            if (value instanceof Integer) {
                serializable = (Integer) value;
            } else if (value instanceof Long) {
                serializable = (Long) value;
            } else if (value instanceof Boolean) {
                serializable = (Boolean) value;
            } else if (value instanceof Double) {
                serializable = (Double) value;
            } else if (value instanceof Float) {
                serializable = (Float) value;
            } else if (value instanceof Bundle) {
                intent.putExtra(str, (Bundle) value);
            } else if (value instanceof int[]) {
                intent.putExtra(str, (int[]) value);
            } else if (value instanceof long[]) {
                intent.putExtra(str, (long[]) value);
            } else if (value instanceof boolean[]) {
                intent.putExtra(str, (boolean[]) value);
            } else if (value instanceof double[]) {
                intent.putExtra(str, (double[]) value);
            } else if (value instanceof float[]) {
                intent.putExtra(str, (float[]) value);
            } else if (value instanceof String[]) {
                intent.putExtra(str, (String[]) value);
            } else {
                intent.putExtra(str, value.toString());
            }
            intent.putExtra(str, serializable);
        }
    }

    public Intent m124c() {
        Intent intent = new Intent(this.f70a, (Class<?>) m125d());
        intent.setAction("com.google.zxing.client.android.SCAN");
        if (this.f73d != null) {
            StringBuilder sb = new StringBuilder();
            for (String str : this.f73d) {
                if (sb.length() > 0) {
                    sb.append(',');
                }
                sb.append(str);
            }
            intent.putExtra("SCAN_FORMATS", sb.toString());
        }
        intent.addFlags(67108864);
        intent.addFlags(524288);
        m123b(intent);
        return intent;
    }

    public Class m125d() {
        if (this.f74e == null) {
            this.f74e = m126e();
        }
        return this.f74e;
    }

    public Class m126e() {
        return CaptureActivity.class;
    }

    public final void m127f() {
        m132l(m124c(), this.f75f);
    }

    public C0024Ae m128h(Class cls) {
        this.f74e = cls;
        return this;
    }

    public C0024Ae m129i(String... strArr) {
        this.f73d = Arrays.asList(strArr);
        return this;
    }

    public C0024Ae m130j(boolean z) {
        m122a("SCAN_ORIENTATION_LOCKED", Boolean.valueOf(z));
        return this;
    }

    public C0024Ae m131k(int i) {
        if (i <= 0 || i > 65535) {
            throw new IllegalArgumentException("requestCode out of range");
        }
        this.f75f = i;
        return this;
    }

    public void m132l(Intent intent, int i) {
        Fragment fragment = this.f71b;
        if (fragment != null) {
            fragment.startActivityForResult(intent, i);
        } else {
            this.f70a.startActivityForResult(intent, i);
        }
    }
}
