package p000;

import android.content.Context;
import android.os.Bundle;

public final class C0976VA {

    public final Context f2944a;

    public String f2945b;

    public String f2946c;

    public String f2947d;

    public Boolean f2948e;

    public long f2949f;

    public C0086Bu f2950g;

    public boolean f2951h;

    public Long f2952i;

    public String f2953j;

    public C0976VA(Context context, C0086Bu c0086Bu, Long l) {
        this.f2951h = true;
        AbstractC1085Xi.m4801j(context);
        Context applicationContext = context.getApplicationContext();
        AbstractC1085Xi.m4801j(applicationContext);
        this.f2944a = applicationContext;
        this.f2952i = l;
        if (c0086Bu != null) {
            this.f2950g = c0086Bu;
            this.f2945b = c0086Bu.f221q;
            this.f2946c = c0086Bu.f220p;
            this.f2947d = c0086Bu.f219o;
            this.f2951h = c0086Bu.f218n;
            this.f2949f = c0086Bu.f217m;
            this.f2953j = c0086Bu.f223s;
            Bundle bundle = c0086Bu.f222r;
            if (bundle != null) {
                this.f2948e = Boolean.valueOf(bundle.getBoolean("dataCollectionDefaultEnabled", true));
            }
        }
    }
}
