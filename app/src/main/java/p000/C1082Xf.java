package p000;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.ConnectException;
import java.net.Socket;

/* loaded from: classes.dex */
public class C1082Xf extends AbstractC2434uj {

    public final Socket f3239m;

    public InputStream f3240n;

    public OutputStream f3241o;

    public Socket f3242p;

    public InputStream f3243q;

    public OutputStream f3244r;

    public a f3245s;

    public String f3247u;

    public int f3248v;

    public final byte[] f3238l = new byte[4096];

    public boolean f3246t = false;

    public C1082Xf(Socket socket, String str, int i, a aVar) {
        this.f3239m = socket;
        this.f3247u = str;
        this.f3248v = i;
        this.f3245s = aVar;
    }

    @Override
    public void mo4779e() {
        try {
            try {
                try {
                    this.f3240n = this.f3239m.getInputStream();
                    this.f3241o = this.f3239m.getOutputStream();
                    f3242p = new Socket(this.f3247u, this.f3248v);
                    f3242p.setSoTimeout(3000);
                    this.f3243q = this.f3242p.getInputStream();
                    this.f3244r = this.f3242p.getOutputStream();
                    this.f3240n.read(this.f3238l);
                    if (f3238l[0] == 5) {
                        byte[] bArrM10588a = C2525wi.m10587c().m10588a((byte) 7);
                        AbstractC2434uj.m10176b("first hand request", bArrM10588a, true);
                        AbstractC0672Oi.m3427b(bArrM10588a, 0, bArrM10588a.length);
                        this.f3244r.write(bArrM10588a, 0, bArrM10588a.length);
                        this.f3244r.flush();
                        AbstractC2434uj.m10176b("*first hand request", bArrM10588a, true);
                        this.f3243q.read(this.f3238l);
                        AbstractC0672Oi.m3426a(f3238l, 0, f3238l.length);
                        AbstractC2434uj.m10176b("first hand response", this.f3238l, false);
                        if (this.f3238l[0] == 8) {
                            byte[] bArrM10588a2 = C2525wi.m10587c().m10588a((byte) 5);
                            this.f3241o.write(bArrM10588a2, 0, bArrM10588a2.length);
                            this.f3241o.flush();
                            System.out.println("<- the first proxy hand shake is ok ");
                            int i = this.f3240n.read(this.f3238l);
                            System.out.println("> forward second hand shake to " + this.f3247u + " with origin info:" + m10180g(this.f3238l));
                            f3238l[0] = 9;
                            AbstractC0672Oi.m3427b(f3238l, 0, f3238l.length);
                            this.f3244r.write(this.f3238l, 0, i);
                            this.f3244r.flush();
                            AbstractC2434uj.m10176b("second hand response", this.f3238l, true);
                            int i2 = this.f3243q.read(this.f3238l);
                            AbstractC0672Oi.m3426a(f3238l, 0, f3238l.length);
                            AbstractC2434uj.m10176b("second hand response", bArrM10588a, false);
                            if (f3238l[0] != 10) {
                                System.out.println("second hand shake failed ,create proxy connection [" + this.f3247u + ":" + this.f3248v + "] failed");
                                System.out.println("->package dump: " + AbstractC2434uj.m10175a(f3238l, 0, i2));
                            } else if (f3238l[1] == 0) {
                                byte[] bArrM10588a3 = C2525wi.m10587c().m10588a((byte) 6);
                                this.f3241o.write(bArrM10588a3, 0, bArrM10588a3.length);
                                this.f3241o.flush();
                                System.out.println("second hand shake ok , prepare create proxy connection [" + this.f3247u + ":" + this.f3248v + "]");
                                if (!this.f3246t) {
                                    m4781i();
                                }
                            } else {
                                System.out.println("second hand shake failed ,create proxy connection [" + this.f3247u + ":" + this.f3248v + "] failed");
                                System.out.println("->package dump: " + AbstractC2434uj.m10175a(f3238l, 0, i2));
                            }
                        } else {
                        }
                        m4780h(f3241o);
                    } else {
                        this.f3241o.write(f3238l);
                        this.f3241o.flush();
                        System.out.println("> Unknown Request Package" + AbstractC2434uj.m10175a(this.f3238l, 0, 10));
                    }
                    if (f3241o != null) {
                        f3241o.close();
                        f3241o = null;
                    }
                    if (f3244r != null) {
                        f3244r.close();
                        f3244r = null;
                    }
                    if (f3240n != null) {
                        f3240n.close();
                        f3240n = null;
                    }
                    if (f3243q != null) {
                        f3243q.close();
                        f3243q = null;
                    }
                    if (f3239m != null) {
                        f3239m.close();
                    }
                    if (f3242p != null) {
                        f3242p.close();
                    }
                } catch (Exception e) {
                    if (e instanceof ConnectException) {
                        AbstractC2434uj.log("Remte proxy server not available:" + this.f3247u + ":" + this.f3248v);
                        if (f3245s != null) {
                            f3245s.mo10181g(e);
                        }
                    }
                    if (f3241o != null) {
                        f3241o.close();
                        f3241o = null;
                    }
                    if (f3244r != null) {
                        f3244r.close();
                        f3244r = null;
                    }
                    if (f3240n != null) {
                        f3240n.close();
                        f3240n = null;
                    }
                    if (f3243q != null) {
                        f3243q.close();
                        f3243q = null;
                    }
                    if (f3239m != null) {
                        f3239m.close();
                    }
                    if (f3242p != null) {
                        f3242p.close();
                    }
                }
            } catch (IOException e2) {
                e2.printStackTrace();
            }
        } catch (Throwable th) {
            try {
                if (f3241o != null) {
                    f3241o.close();
                    f3241o = null;
                }
                OutputStream outputStream7 = this.f3244r;
                if (outputStream7 != null) {
                    outputStream7.close();
                    this.f3244r = null;
                }
                InputStream inputStream5 = this.f3240n;
                if (inputStream5 != null) {
                    inputStream5.close();
                    this.f3240n = null;
                }
                InputStream inputStream6 = this.f3243q;
                if (inputStream6 != null) {
                    inputStream6.close();
                    this.f3243q = null;
                }
                Socket socket6 = this.f3239m;
                if (socket6 != null) {
                    socket6.close();
                }
                Socket socket7 = this.f3242p;
                if (socket7 != null) {
                    socket7.close();
                }
            } catch (IOException e3) {
                e3.printStackTrace();
            }
            throw th;
        }
    }

    public final void m4780h(OutputStream outputStream) throws IOException {
        outputStream.write(C2525wi.m10587c().m10588a((byte) 3));
        outputStream.flush();
        System.out.println("<- socke5 hand shake failed");
    }

    public final void m4781i() throws InterruptedException {
        C1926ji c1926ji = new C1926ji(this.f3240n, this.f3244r, this.f3245s);
        c1926ji.m3430e("client --->" + this.f3239m.getInetAddress() + ":" + this.f3239m.getPort() + " to " + this.f3242p.getInetAddress() + ":" + this.f3242p.getPort());
        C2060me c2060me = new C2060me(this.f3243q, this.f3241o, this.f3245s);
        c2060me.m3430e("server ----> " + this.f3242p.getInetAddress() + ":" + this.f3242p.getPort() + " to " + this.f3239m.getInetAddress() + ":" + this.f3242p.getLocalPort());
        c1926ji.m3429d(1);
        c2060me.m3429d(16);
        c1926ji.start();
        c2060me.start();
        c1926ji.join();
        c2060me.join();
        this.f3246t = true;
    }
}
