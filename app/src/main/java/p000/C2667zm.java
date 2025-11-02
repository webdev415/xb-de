package p000;

import android.content.Context;
import android.content.res.Resources;

/* loaded from: classes.dex */
public class C2667zm {

    public final Resources f8277a;

    public final String f8278b;

    public C2667zm(Context context) {
        AbstractC1085Xi.m4801j(context);
        Resources resources = context.getResources();
        this.f8277a = resources;
        this.f8278b = resources.getResourcePackageName(AbstractC0535Lj.common_google_play_services_unknown_issue);
    }

    public String m11042a(String str) {
        int identifier = this.f8277a.getIdentifier(str, "string", this.f8278b);
        if (identifier == 0) {
            return null;
        }
        return this.f8277a.getString(identifier);
    }
}
