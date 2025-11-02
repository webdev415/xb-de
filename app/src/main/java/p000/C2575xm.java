package p000;

import java.io.IOException;

public final class C2575xm extends IOException {

    public final EnumC1159Z9 f8025l;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C2575xm(EnumC1159Z9 enumC1159Z9) {
        super("stream was reset: " + enumC1159Z9);
        AbstractC0116Ce.m476e(enumC1159Z9, "errorCode");
        this.f8025l = enumC1159Z9;
    }
}
