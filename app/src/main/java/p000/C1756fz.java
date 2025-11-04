package p000;

import android.content.Context;
import android.content.res.Resources;
import android.text.TextUtils;

public final class C1756fz {

    public final Resources f5576a;

    public final String f5577b;

    public C1756fz(Context context, String str) {
        AbstractC1085Xi.m4801j(context);
        this.f5576a = context.getResources();
        if (TextUtils.isEmpty(str)) {
            this.f5577b = m7682a(context);
        } else {
            this.f5577b = str;
        }
    }

    public static String m7682a(Context context) {
        try {
            return context.getResources().getResourcePackageName(AbstractC0535Lj.common_google_play_services_unknown_issue);
        } catch (Resources.NotFoundException unused) {
            return context.getPackageName();
        }
    }

    public final String m7683b(String str) {
        int identifier = this.f5576a.getIdentifier(str, "string", this.f5577b);
        if (identifier == 0) {
            return null;
        }
        try {
            return this.f5576a.getString(identifier);
        } catch (Resources.NotFoundException unused) {
            return null;
        }
    }
}
