package p000;

public abstract class AbstractC2313s {

    public long f6987a = 0;

    public int f6988b = 0;

    public String f6989c = null;

    public boolean f6990d = false;

    public abstract boolean mo7164a(int i, String str, Object obj);

    public void m9455b() {
        this.f6990d = true;
        EventQueueManager.getInstance().removeEvent(m9456c());
    }

    public long m9456c() {
        return this.f6987a;
    }

    public synchronized boolean m9457d(int i, String str, Object obj) {
        boolean zMo7164a;
        this.f6988b = i;
        this.f6989c = str;
        zMo7164a = mo7164a(i, str, obj);
        this.f6990d = zMo7164a;
        return zMo7164a;
    }

    public void m9458e(long j) {
        this.f6987a = j;
    }
}
