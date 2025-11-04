package p000;

import android.content.Context;
import android.net.Uri;

public abstract class AbstractC1721fA {

    public static final ScriptMap f5489a = new ScriptMap();

    public static synchronized Uri m7566a(String str) {
        Uri uri;
        ScriptMap scriptMap = f5489a;
        uri = (Uri) scriptMap.get(str);
        if (uri == null) {
            uri = Uri.parse("content://com.google.android.gms.phenotype/" + Uri.encode(str));
            scriptMap.put(str, uri);
        }
        return uri;
    }

    public static String m7567b(Context context, String str) {
        if (str.contains("#")) {
            throw new IllegalArgumentException("The passed in package cannot already have a subpackage: " + str);
        }
        return str + "#" + context.getPackageName();
    }

    public static boolean m7568c(String str, String str2) {
        if (str.equals("eng") || str.equals("userdebug")) {
            return str2.contains("dev-keys") || str2.contains("test-keys");
        }
        return false;
    }
}
