package p000;

import java.io.IOException;

public class C1771gD extends IOException {
    public C1771gD(String str) {
        super(str);
    }

    public static C2050mD m7702a() {
        return new C2050mD("Protocol message tag had invalid wire type.");
    }

    public static C1771gD m7703b() {
        return new C1771gD("Protocol message contained an invalid tag (zero).");
    }

    public static C1771gD m7704c() {
        return new C1771gD("Protocol message had invalid UTF-8.");
    }

    public static C1771gD m7705d() {
        return new C1771gD("CodedInputStream encountered an embedded string or message which claimed to have negative size.");
    }

    public static C1771gD m7706e() {
        return new C1771gD("Failed to parse the message.");
    }

    public static C1771gD m7707f() {
        return new C1771gD("Protocol message had too many levels of nesting.  May be malicious.  Use setRecursionLimit() to increase the recursion depth limit.");
    }

    public static C1771gD m7708g() {
        return new C1771gD("While parsing a protocol message, the input ended unexpectedly in the middle of a field.  This could mean either that the input has been truncated or that an embedded message misreported its own length.");
    }
}
