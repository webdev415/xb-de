package p000;

import android.app.NotificationManager;
import android.content.Context;
import java.util.HashSet;
import java.util.Set;

/* loaded from: classes.dex */
public final class C2662zh {

    public static final Object f8259c = new Object();

    public static Set f8260d = new HashSet();

    public static final Object f8261e = new Object();

    public final Context f8262a;

    public final NotificationManager f8263b;

    public static class a {
        public static boolean m11036a(NotificationManager notificationManager) {
            return notificationManager.areNotificationsEnabled();
        }

        public static int m11037b(NotificationManager notificationManager) {
            return notificationManager.getImportance();
        }
    }

    public C2662zh(Context context) {
        this.f8262a = context;
        this.f8263b = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
    }

    public static C2662zh m11034b(Context context) {
        return new C2662zh(context);
    }

    public boolean m11035a() {
        return a.m11036a(this.f8263b);
    }
}
