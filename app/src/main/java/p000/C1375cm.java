package p000;

public class C1375cm implements InterfaceC0353Hl {

    public int localPort;

    public String proxyHost;

    public int proxyPort;

    public boolean f3995d;

    public int f3996e;

    public AbstractC2434uj.a f3997f;

    public class a extends Thread {
        /* JADX WARN: Removed duplicated region for block: B:39:0x0112 A[EXC_TOP_SPLITTER, SYNTHETIC] */
        @Override
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public void run() throws Throwable {
            /*
                Method dump skipped, instructions count: 283
                To view this dump change 'Code comments level' option to 'DEBUG'
            */
            throw new UnsupportedOperationException("Method not decompiled: p000.C1375cm.a.run():void");
        }
    }

    public C1375cm(int i, String str, int i2) {
        this(i, str, i2, null);
    }

    @Override
    public void onSwichProxyTo(String host, int port) {
        this.proxyHost = host;
        this.proxyPort = port;
    }

    @Override
    public int mo1597b() {
        return this.f3996e;
    }

    public void m5939g(AbstractC2434uj.a aVar) {
        this.f3997f = aVar;
    }

    @Override
    public void start() {
        new a().start();
    }

    public C1375cm(int localPort, String proxyHost, int proxyPort, AbstractC2434uj.a aVar) {
        this.f3995d = true;
        this.f3996e = 0;
        this.localPort = localPort;
        this.proxyHost = proxyHost;
        this.proxyPort = proxyPort;
        this.f3997f = aVar;
    }
}
