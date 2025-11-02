package p000;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

public class C2453v1 extends C0950Ul implements Map {

    public AbstractC2108ng f7619s;

    public class a extends AbstractC2108ng {
        public a() {
        }

        @Override
        public void mo8770a() {
            C2453v1.this.clear();
        }

        @Override
        public Object mo8771b(int i, int i2) {
            return C2453v1.this.f2869m[(i << 1) + i2];
        }

        @Override
        public Map mo8772c() {
            return C2453v1.this;
        }

        @Override
        public int mo8773d() {
            return C2453v1.this.f2870n;
        }

        @Override
        public int mo8774e(Object obj) {
            return C2453v1.this.m4280f(obj);
        }

        @Override
        public int mo8775f(Object obj) {
            return C2453v1.this.m4282h(obj);
        }

        @Override
        public void mo8776g(Object obj, Object obj2) {
            C2453v1.this.put(obj, obj2);
        }

        @Override
        public void mo8777h(int i) {
            C2453v1.this.m4284j(i);
        }

        @Override
        public Object mo8778i(int i, Object obj) {
            return C2453v1.this.m4285k(i, obj);
        }
    }

    public C2453v1() {
    }

    @Override
    public Set entrySet() {
        return m10263m().m8779l();
    }

    @Override
    public Set keySet() {
        return m10263m().m8780m();
    }

    public final AbstractC2108ng m10263m() {
        if (this.f7619s == null) {
            this.f7619s = new a();
        }
        return this.f7619s;
    }

    @Override
    public void putAll(Map map) {
        m4278c(this.f2870n + map.size());
        for (Entry entry : map.entrySet()) {
            put(entry.getKey(), entry.getValue());
        }
    }

    @Override
    public Collection values() {
        return m10263m().m8781n();
    }

    public C2453v1(int i) {
        super(i);
    }
}
