package p000;

/* loaded from: classes.dex */
public enum EnumC0019AI {
    DEBUG(3),
    ERROR(6),
    INFO(4),
    VERBOSE(2),
    WARN(5);

    EnumC0019AI(int i) {
    }

    public static EnumC0019AI m113c(int i) {
        return i != 2 ? i != 3 ? i != 5 ? i != 6 ? INFO : ERROR : WARN : DEBUG : VERBOSE;
    }
}
