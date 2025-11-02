package p000;

import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public final class C0947Ui extends AbstractC0368I {
    @Override
    public Random mo1662c() {
        ThreadLocalRandom threadLocalRandomCurrent = ThreadLocalRandom.current();
        AbstractC0116Ce.m475d(threadLocalRandomCurrent, "current()");
        return threadLocalRandomCurrent;
    }
}
