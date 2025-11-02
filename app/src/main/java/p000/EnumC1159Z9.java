package p000;

/* loaded from: classes.dex */
public enum EnumC1159Z9 {
    NO_ERROR(0),
    PROTOCOL_ERROR(1),
    INTERNAL_ERROR(2),
    FLOW_CONTROL_ERROR(3),
    SETTINGS_TIMEOUT(4),
    STREAM_CLOSED(5),
    FRAME_SIZE_ERROR(6),
    REFUSED_STREAM(7),
    CANCEL(8),
    COMPRESSION_ERROR(9),
    CONNECT_ERROR(10),
    ENHANCE_YOUR_CALM(11),
    INADEQUATE_SECURITY(12),
    HTTP_1_1_REQUIRED(13);


    public static final a f3405B = new a(null);

    public final int f3420l;

    public static final class a {
        public a() {
        }

        public final EnumC1159Z9 m5027a(int i) {
            for (EnumC1159Z9 enumC1159Z9 : EnumC1159Z9.values()) {
                if (enumC1159Z9.m5026c() == i) {
                    return enumC1159Z9;
                }
            }
            return null;
        }

        public a(AbstractC0881T7 abstractC0881T7) {
            this();
        }
    }

    EnumC1159Z9(int i) {
        this.f3420l = i;
    }

    public final int m5026c() {
        return this.f3420l;
    }
}
