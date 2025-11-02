package p000;

/* loaded from: classes.dex */
public enum EnumC1336bt implements InterfaceC1209aD {
    UNSPECIFIED_TYPE(0),
    RAW_FILE_IO_TYPE(1),
    MOBSTORE_TYPE(2),
    SQLITE_OPEN_HELPER_TYPE(3),
    LEVEL_DB_TYPE(5),
    ROOM_TYPE(6),
    SHARED_PREFS_TYPE(7),
    PROTO_DATA_STORE_TYPE(8),
    UNRECOGNIZED(-1);


    public final int f3900l;

    EnumC1336bt(int i) {
        this.f3900l = i;
    }

    @Override
    public final int mo1742a() {
        if (this != UNRECOGNIZED) {
            return this.f3900l;
        }
        throw new IllegalArgumentException("Can't get the number of an unknown enum value.");
    }

    @Override
    public final String toString() {
        StringBuilder sb = new StringBuilder("<");
        sb.append(EnumC1336bt.class.getName());
        sb.append('@');
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        if (this != UNRECOGNIZED) {
            sb.append(" number=");
            sb.append(mo1742a());
        }
        sb.append(" name=");
        sb.append(name());
        sb.append('>');
        return sb.toString();
    }
}
