package p000;

import android.os.Looper;
import java.util.List;

public final class C0553M0 implements InterfaceC1924jg {
    @Override
    public int mo2807a() {
        return 1073741823;
    }

    @Override
    public String mo2808b() {
        return "For tests Dispatchers.setMain from kotlinx-coroutines-test module can be used";
    }

    @Override
    public AbstractC1878ig mo2809c(List list) {
        Looper mainLooper = Looper.getMainLooper();
        if (mainLooper != null) {
            return new C0803Rc(AbstractC0895Tc.m4136a(mainLooper, true), null, 2, null);
        }
        throw new IllegalStateException("The main looper is not available");
    }
}
