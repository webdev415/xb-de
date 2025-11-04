package p000;

public enum EnumC0404Iq {
    UNSET('0'),
    REMOTE_DEFAULT('1'),
    REMOTE_DELEGATION('2'),
    MANIFEST('3'),
    INITIALIZATION('4'),
    API('5'),
    CHILD_ACCOUNT('6'),
    TCF('7'),
    REMOTE_ENFORCED_DEFAULT('8'),
    FAILSAFE('9');


    public final char f1224l;

    EnumC0404Iq(char c) {
        this.f1224l = c;
    }

    public static EnumC0404Iq m1718e(char c) {
        for (EnumC0404Iq enumC0404Iq : values()) {
            if (enumC0404Iq.f1224l == c) {
                return enumC0404Iq;
            }
        }
        return UNSET;
    }
}
