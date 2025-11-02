package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.Context;
import android.os.Bundle;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;

/* loaded from: classes.dex */
public class C2478vh {

    public boolean f7681A;

    public String f7682B;

    public Bundle f7683C;

    public int f7684D;

    public int f7685E;

    public Notification f7686F;

    public RemoteViews f7687G;

    public RemoteViews f7688H;

    public RemoteViews f7689I;

    public String f7690J;

    public int f7691K;

    public String f7692L;

    public long f7693M;

    public int f7694N;

    public int f7695O;

    public boolean f7696P;

    public Notification f7697Q;

    public boolean f7698R;

    public Object f7699S;

    public ArrayList f7700T;

    public Context f7701a;

    public ArrayList f7702b;

    public ArrayList f7703c;

    public ArrayList f7704d;

    public CharSequence f7705e;

    public CharSequence f7706f;

    public PendingIntent f7707g;

    public PendingIntent f7708h;

    public RemoteViews f7709i;

    public IconCompat f7710j;

    public CharSequence f7711k;

    public int f7712l;

    public int f7713m;

    public boolean f7714n;

    public boolean f7715o;

    public CharSequence f7716p;

    public CharSequence f7717q;

    public CharSequence[] f7718r;

    public int f7719s;

    public int f7720t;

    public boolean f7721u;

    public String f7722v;

    public boolean f7723w;

    public String f7724x;

    public boolean f7725y;

    public boolean f7726z;

    public C2478vh(Context context) {
        this(context, null);
    }

    public static CharSequence m10358c(CharSequence charSequence) {
        return (charSequence != null && charSequence.length() > 5120) ? charSequence.subSequence(0, 5120) : charSequence;
    }

    public Notification m10359a() {
        return new C2570xh(this).m10725b();
    }

    public Bundle m10360b() {
        if (this.f7683C == null) {
            this.f7683C = new Bundle();
        }
        return this.f7683C;
    }

    public C2478vh m10361d(boolean z) {
        m10365h(16, z);
        return this;
    }

    public C2478vh m10362e(PendingIntent pendingIntent) {
        this.f7707g = pendingIntent;
        return this;
    }

    public C2478vh m10363f(CharSequence charSequence) {
        this.f7706f = m10358c(charSequence);
        return this;
    }

    public C2478vh m10364g(CharSequence charSequence) {
        this.f7705e = m10358c(charSequence);
        return this;
    }

    public final void m10365h(int i, boolean z) {
        Notification notification;
        int i2;
        if (z) {
            notification = this.f7697Q;
            i2 = i | notification.flags;
        } else {
            notification = this.f7697Q;
            i2 = (~i) & notification.flags;
        }
        notification.flags = i2;
    }

    public C2478vh m10366i(boolean z) {
        m10365h(8, z);
        return this;
    }

    public C2478vh m10367j(int i, int i2, boolean z) {
        this.f7719s = i;
        this.f7720t = i2;
        this.f7721u = z;
        return this;
    }

    public C2478vh m10368k(int i) {
        this.f7697Q.icon = i;
        return this;
    }

    public C2478vh(Context context, String str) {
        this.f7702b = new ArrayList<>();
        this.f7703c = new ArrayList<>();
        this.f7704d = new ArrayList<>();
        this.f7714n = true;
        this.f7725y = false;
        this.f7684D = 0;
        this.f7685E = 0;
        this.f7691K = 0;
        this.f7694N = 0;
        this.f7695O = 0;
        Notification notification = new Notification();
        this.f7697Q = notification;
        this.f7701a = context;
        this.f7690J = str;
        notification.when = System.currentTimeMillis();
        this.f7697Q.audioStreamType = -1;
        this.f7713m = 0;
        this.f7700T = new ArrayList<>();
        this.f7696P = true;
    }
}
