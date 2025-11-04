package p000;

import android.content.Context;
import android.os.UserManager;

public abstract class AbstractC2485vo {

    public static class a {
        public static boolean m10405a(Context context) {
            return ((UserManager) context.getSystemService(UserManager.class)).isUserUnlocked();
        }
    }

    public static boolean m10404a(Context context) {
        return a.m10405a(context);
    }
}
