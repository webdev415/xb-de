package p000;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import androidx.fragment.app.FragmentActivity;
import java.io.FileDescriptor;
import java.io.PrintWriter;

public abstract class AbstractC0343Hb extends AbstractC0205Eb {

    public final Activity f1051a;

    public final Context f1052b;

    public final Handler f1053c;

    public final int f1054d;

    public final LayoutInflaterFactory2C0435Jb f1055e;

    public AbstractC0343Hb(Activity activity, Context context, Handler handler, int i) {
        this.f1055e = new LayoutInflaterFactory2C0435Jb();
        this.f1051a = activity;
        this.f1052b = (Context) AbstractC1225aj.m5301b(context, "context == null");
        this.f1053c = (Handler) AbstractC1225aj.m5301b(handler, "handler == null");
        this.f1054d = i;
    }

    public Context m1565h() {
        return this.f1052b;
    }

    public Handler m1566i() {
        return this.f1053c;
    }

    public abstract void mo1567j(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);

    public abstract void mo1568k();

    public AbstractC0343Hb(FragmentActivity fragmentActivity) {
        this(fragmentActivity, fragmentActivity, new Handler(), 0);
    }
}
