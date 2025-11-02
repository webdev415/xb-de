package p000;

import android.net.Uri;
import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class AbstractC1803gz {

    public static final Uri f5668a = Uri.parse("content://com.google.android.gsf.gservices");

    public static final Uri f5669b = Uri.parse("content://com.google.android.gsf.gservices/prefix");

    public static final Pattern f5670c = Pattern.compile("^(1|true|t|on|yes|y)$", 2);

    public static final Pattern f5671d = Pattern.compile("^(0|false|f|off|no|n)$", 2);
}
