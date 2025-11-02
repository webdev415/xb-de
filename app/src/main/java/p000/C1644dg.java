package p000;

import android.util.Log;
import java.io.Writer;

/* loaded from: classes.dex */
public class C1644dg extends Writer {

    public final String f5318l;

    public StringBuilder f5319m = new StringBuilder(128);

    public C1644dg(String str) {
        this.f5318l = str;
    }

    public final void m7324a() {
        if (this.f5319m.length() > 0) {
            Log.d(this.f5318l, this.f5319m.toString());
            StringBuilder sb = this.f5319m;
            sb.delete(0, sb.length());
        }
    }

    @Override
    public void close() {
        m7324a();
    }

    @Override
    public void flush() {
        m7324a();
    }

    @Override
    public void write(char[] cArr, int i, int i2) {
        for (int i3 = 0; i3 < i2; i3++) {
            char c = cArr[i + i3];
            if (c == '\n') {
                m7324a();
            } else {
                this.f5319m.append(c);
            }
        }
    }
}
