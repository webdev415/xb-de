package p000;

import java.io.IOException;
import java.lang.ref.Reference;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ConcurrentLinkedQueue;
import java.util.concurrent.TimeUnit;

public final class C1835hk {

    public static final a f5750f = new a(null);

    public final long f5751a;

    public final C2254qn f5752b;

    public final b f5753c;

    public final ConcurrentLinkedQueue f5754d;

    public final int f5755e;

    public static final class a {
        public a() {
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    public static final class b extends AbstractC1791gn {
        public b(String str) {
            super(str, false, 2, null);
        }

        @Override
        public long mo7750f() {
            return C1835hk.this.m7845b(System.nanoTime());
        }
    }

    public C1835hk(C2300rn c2300rn, int i, long j, TimeUnit timeUnit) {
        AbstractC0116Ce.m476e(c2300rn, "taskRunner");
        AbstractC0116Ce.m476e(timeUnit, "timeUnit");
        this.f5755e = i;
        this.f5751a = timeUnit.toNanos(j);
        this.f5752b = c2300rn.m9445i();
        this.f5753c = new b(AbstractC2623yo.f8135i + " ConnectionPool");
        this.f5754d = new ConcurrentLinkedQueue();
        if (j > 0) {
            return;
        }
        throw new IllegalArgumentException(("keepAliveDuration <= 0: " + j).toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:13:0x002d A[Catch: all -> 0x002b, TryCatch #0 {all -> 0x002b, blocks: (B:8:0x0024, B:15:0x0033, B:13:0x002d, B:18:0x0037), top: B:26:0x0024 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m7844a(Address r4, C1694ek r5, List r6, boolean r7) {
        /*
            r3 = this;
            java.lang.String r0 = "address"
            p000.AbstractC0116Ce.m476e(r4, r0)
            java.lang.String r0 = "call"
            p000.AbstractC0116Ce.m476e(r5, r0)
            java.util.concurrent.ConcurrentLinkedQueue r0 = r3.f5754d
            java.util.Iterator r0 = r0.iterator()
        L10:
            boolean r1 = r0.hasNext()
            if (r1 == 0) goto L3f
            java.lang.Object r1 = r0.next()
            fk r1 = (p000.C1741fk) r1
            java.lang.String r2 = "connection"
            p000.AbstractC0116Ce.m475d(r1, r2)
            monitor-enter(r1)
            if (r7 == 0) goto L2d
            boolean r2 = r1.m7633v()     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L2d
            goto L33
        L2b:
            r4 = move-exception
            goto L3d
        L2d:
            boolean r2 = r1.m7631t(r4, r6)     // Catch: java.lang.Throwable -> L2b
            if (r2 != 0) goto L37
        L33:
            no r2 = p000.C2116no.f6480a     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r1)
            goto L10
        L37:
            r5.m7435c(r1)     // Catch: java.lang.Throwable -> L2b
            monitor-exit(r1)
            r4 = 1
            return r4
        L3d:
            monitor-exit(r1)
            throw r4
        L3f:
            r4 = 0
            return r4
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C1835hk.m7844a(w0, ek, java.util.List, boolean):boolean");
    }

    public final long m7845b(long j) throws IOException {
        Iterator it = this.f5754d.iterator();
        int i = 0;
        long j2 = Long.MIN_VALUE;
        Connection connection = null;
        int i2 = 0;
        while (it.hasNext()) {
            Connection connection2 = (Connection) it.next();
            AbstractC0116Ce.m475d(connection2, "connection");
            synchronized (connection2) {
                try {
                    if (m7847d(connection2, j) > 0) {
                        i2++;
                    } else {
                        i++;
                        long jM7626o = j - connection2.m7626o();
                        if (jM7626o > j2) {
                            C2116no c2116no = C2116no.f6480a;
                            connection = connection2;
                            j2 = jM7626o;
                        } else {
                            C2116no c2116no2 = C2116no.f6480a;
                        }
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        long j3 = this.f5751a;
        if (j2 < j3 && i <= this.f5755e) {
            if (i > 0) {
                return j3 - j2;
            }
            if (i2 > 0) {
                return j3;
            }
            return -1L;
        }
        AbstractC0116Ce.m473b(connection);
        synchronized (connection) {
            if (!connection.m7625n().isEmpty()) {
                return 0L;
            }
            if (connection.m7626o() + j2 != j) {
                return 0L;
            }
            connection.m7608C(true);
            this.f5754d.remove(connection);
            AbstractC2623yo.m10936k(connection.m7609D());
            if (this.f5754d.isEmpty()) {
                this.f5752b.m9175a();
            }
            return 0L;
        }
    }

    public final boolean m7846c(Connection connection) {
        AbstractC0116Ce.m476e(connection, "connection");
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        }
        if (!connection.m7627p() && this.f5755e != 0) {
            C2254qn.m9174j(this.f5752b, this.f5753c, 0L, 2, null);
            return false;
        }
        connection.m7608C(true);
        this.f5754d.remove(connection);
        if (this.f5754d.isEmpty()) {
            this.f5752b.m9175a();
        }
        return true;
    }

    public final int m7847d(Connection connection, long j) {
        if (AbstractC2623yo.f8134h && !Thread.holdsLock(connection)) {
            StringBuilder sb = new StringBuilder();
            sb.append("Thread ");
            Thread threadCurrentThread = Thread.currentThread();
            AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
            sb.append(threadCurrentThread.getName());
            sb.append(" MUST hold lock on ");
            sb.append(connection);
            throw new AssertionError(sb.toString());
        }
        List listM7625n = connection.m7625n();
        int i = 0;
        while (i < listM7625n.size()) {
            Reference reference = (Reference) listM7625n.get(i);
            if (reference.get() != null) {
                i++;
            } else {
                C0764Qi.f2268c.m3690g().mo3680l("A connection to " + connection.m7637z().m5675a().m10421l() + " was leaked. Did you forget to close a response body?", ((C1694ek.b) reference).m7459a());
                listM7625n.remove(i);
                connection.m7608C(true);
                if (listM7625n.isEmpty()) {
                    connection.m7607B(j - this.f5751a);
                    return 0;
                }
            }
        }
        return listM7625n.size();
    }

    public final void m7848e(Connection connection) {
        AbstractC0116Ce.m476e(connection, "connection");
        if (!AbstractC2623yo.f8134h || Thread.holdsLock(connection)) {
            this.f5754d.add(connection);
            C2254qn.m9174j(this.f5752b, this.f5753c, 0L, 2, null);
            return;
        }
        StringBuilder sb = new StringBuilder();
        sb.append("Thread ");
        Thread threadCurrentThread = Thread.currentThread();
        AbstractC0116Ce.m475d(threadCurrentThread, "Thread.currentThread()");
        sb.append(threadCurrentThread.getName());
        sb.append(" MUST hold lock on ");
        sb.append(connection);
        throw new AssertionError(sb.toString());
    }
}
