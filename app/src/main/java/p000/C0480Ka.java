package p000;

import java.util.Random;

public final class C0480Ka extends AbstractC0368I {

    public final a f1566n = new a();

    public static final class a extends ThreadLocal {
        @Override
        public Random initialValue() {
            return new Random();
        }
    }

    @Override
    public Random mo1662c() {
        Object obj = this.f1566n.get();
        AbstractC0116Ce.m475d(obj, "implStorage.get()");
        return (Random) obj;
    }
}
