package p000;

import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Build;

public abstract class AbstractC2536wt {

    public static final int f7911a;

    static {
        f7911a = Build.VERSION.SDK_INT >= 31 ? 33554432 : 0;
    }

    public static PendingIntent m10615a(Context context, int i, Intent intent, int i2) {
        return PendingIntent.getBroadcast(context, 0, intent, i2);
    }
}
