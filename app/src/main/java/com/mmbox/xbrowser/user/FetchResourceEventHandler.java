package com.mmbox.xbrowser.user;

import android.net.Uri;
import java.io.IOException;
import p000.AbstractC2313s;
import p000.C0122Ck;
import p000.ResourceCacheManager;
import p000.C0490Kk;
import p000.ApiEndpointsManager;
import p000.InterfaceC0418J3;
import p000.InterfaceC0556M3;

/* loaded from: classes.dex */
public class FetchResourceEventHandler extends AbstractC2313s {
    @Override
    public boolean mo7164a(int i, String str, Object obj) {
        if (i != 50) {
            if (i != 51) {
                return true;
            }
            m7168f(ApiEndpointsManager.getInstance().getClientResourcesEndpoint() + "/" + str);
            return true;
        }
        String host = Uri.parse((String) obj).getHost();
        if (str.indexOf(host) < 0) {
            return true;
        }
        ResourceCacheManager.getInstance().m2061q(host + ".touch-icon", str, 11);
        return true;
    }

    public final void m7168f(String str) {
        new OkHttpClient().m2004y(new C0122Ck.a().m507i(str).m500b()).mo1791i(new C1586a());
    }

    public class C1586a implements InterfaceC0556M3 {
        public C1586a() {
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            c0490Kk.m2399p("Content-Type").startsWith("image/");
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
        }
    }
}
