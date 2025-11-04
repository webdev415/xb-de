package p000;

import android.text.TextUtils;
import java.util.concurrent.TimeUnit;
import java.util.regex.Pattern;

public final class C0034Ao {

    public static final long f82b = TimeUnit.HOURS.toSeconds(1);

    public static final Pattern f83c = Pattern.compile("\\AA[\\w-]{38}\\z");

    public static C0034Ao f84d;

    public final InterfaceC0511L4 f85a;

    public C0034Ao(InterfaceC0511L4 interfaceC0511L4) {
        this.f85a = interfaceC0511L4;
    }

    public static C0034Ao m143c() {
        return m144d(C1181Zm.m5071b());
    }

    public static C0034Ao m144d(InterfaceC0511L4 interfaceC0511L4) {
        if (f84d == null) {
            f84d = new C0034Ao(interfaceC0511L4);
        }
        return f84d;
    }

    public static boolean m145g(String str) {
        return f83c.matcher(str).matches();
    }

    public static boolean m146h(String str) {
        return str.contains(":");
    }

    public long m147a() {
        return this.f85a.mo2587a();
    }

    public long m148b() {
        return TimeUnit.MILLISECONDS.toSeconds(m147a());
    }

    public long m149e() {
        return (long) (Math.random() * 1000.0d);
    }

    public boolean m150f(AbstractC0580Mi abstractC0580Mi) {
        return TextUtils.isEmpty(abstractC0580Mi.mo2886b()) || abstractC0580Mi.mo2892h() + abstractC0580Mi.mo2887c() < m148b() + f82b;
    }
}
