package p000;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public final class C0962Ux extends AbstractC2513wF {
    public C0962Ux(C0200EF c0200ef) {
        super(c0200ef);
    }

    /* JADX INFO: Access modifiers changed from: private */
    public static byte[] m4299z(HttpURLConnection httpURLConnection) throws IOException {
        InputStream inputStream = null;
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            inputStream = httpURLConnection.getInputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i <= 0) {
                    byte[] byteArray = byteArrayOutputStream.toByteArray();
                    inputStream.close();
                    return byteArray;
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Throwable th) {
            if (inputStream != null) {
                inputStream.close();
            }
            throw th;
        }
    }

    public final boolean m4300B() {
        m10440u();
        ConnectivityManager connectivityManager = (ConnectivityManager) mo344a().getSystemService(Context.CONNECTIVITY_SERVICE);
        NetworkInfo activeNetworkInfo = null;
        if (connectivityManager != null) {
            try {
                activeNetworkInfo = connectivityManager.getActiveNetworkInfo();
            } catch (SecurityException unused) {
            }
        }
        return activeNetworkInfo != null && activeNetworkInfo.isConnected();
    }

    @Override
    public final /* bridge */ Context mo344a() {
        return super.mo344a();
    }

    @Override
    public final /* bridge */ InterfaceC0557M4 mo345b() {
        return super.mo345b();
    }

    @Override
    public final /* bridge */ C1747fq mo346d() {
        return super.mo346d();
    }

    @Override
    public final /* bridge */ C2579xq mo347e() {
        return super.mo347e();
    }

    @Override
    public final /* bridge */ C0083Br mo348f() {
        return super.mo348f();
    }

    @Override
    public final /* bridge */ C2356sx mo349g() {
        return super.mo349g();
    }

    @Override
    public final /* bridge */ C2264qx mo350h() {
        return super.mo350h();
    }

    @Override
    public final /* bridge */ C1755fy mo351i() {
        return super.mo351i();
    }

    @Override
    public final /* bridge */ C2514wG mo352j() {
        return super.mo352j();
    }

    @Override
    public final /* bridge */ void mo353k() {
        super.mo353k();
    }

    @Override
    public final /* bridge */ C1662dz mo354l() {
        return super.mo354l();
    }

    @Override
    public final /* bridge */ void mo355m() {
        super.mo355m();
    }

    @Override
    public final /* bridge */ void mo356n() {
        super.mo356n();
    }

    @Override
    public final /* bridge */ C2145oG mo3244o() {
        return super.mo3244o();
    }

    @Override
    public final /* bridge */ C0846SI mo3245p() {
        return super.mo3245p();
    }

    @Override
    public final /* bridge */ C0496Kq mo3246q() {
        return super.mo3246q();
    }

    @Override
    public final /* bridge */ C0596My mo3247r() {
        return super.mo3247r();
    }

    @Override
    public final /* bridge */ C2420uE mo3248s() {
        return super.mo3248s();
    }

    @Override
    public final /* bridge */ C2467vF mo3249t() {
        return super.mo3249t();
    }

    @Override
    public final boolean mo2541x() {
        return false;
    }

    public final void m4301y(String str, URL url, byte[] bArr, Map map, InterfaceC0870Sx interfaceC0870Sx) {
        mo356n();
        m10440u();
        AbstractC1085Xi.m4801j(url);
        AbstractC1085Xi.m4801j(bArr);
        AbstractC1085Xi.m4801j(interfaceC0870Sx);
        mo354l().m7379x(new RunnableC1661dy(this, str, url, bArr, map, interfaceC0870Sx));
    }
}
