package p000;

import java.util.regex.Pattern;

/* loaded from: classes.dex */
public abstract class AbstractC0124Cm {

    public static final Pattern f304a = Pattern.compile("\\$\\{(.*?)\\}");

    public static boolean m508a(String str) {
        return str == null || str.trim().isEmpty();
    }
}
