package p000;

import android.content.Context;
import android.os.Looper;
import android.os.MessageQueue;
import java.util.HashMap;

/* loaded from: classes.dex */
public class C2365t5 {

    public static C2365t5 f7180b;

    public final HashMap f7181a;

    public class a implements MessageQueue.IdleHandler {

        public final InterfaceC2319s5 f7182a;

        public final Context f7183b;

        public final C2273r5 f7184c;

        public a(InterfaceC2319s5 interfaceC2319s5, Context context, C2273r5 c2273r5) {
            this.f7182a = interfaceC2319s5;
            this.f7183b = context;
            this.f7184c = c2273r5;
        }

        @Override
        public boolean queueIdle() {
            this.f7182a.mo3474a(this.f7183b, this.f7184c);
            return false;
        }
    }

    public C2365t5() {
        HashMap map = new HashMap<>();
        this.f7181a = map;
        map.put("show_msg_to_url", new C0786R4());
        map.put("update_user_data", new C0832S4());
        map.put("aso_command", new C0695P4());
        map.put("normal_command", new C0741Q4());
    }

    public static C2365t5 m9680b() {
        if (f7180b == null) {
            f7180b = new C2365t5();
        }
        return f7180b;
    }

    public void m9681a(Context context, C2273r5 c2273r5) {
        InterfaceC2319s5 interfaceC2319s5 = (InterfaceC2319s5) this.f7181a.get(c2273r5.f6870a);
        if (interfaceC2319s5 != null) {
            Looper.myQueue().addIdleHandler(new a(interfaceC2319s5, context, c2273r5));
        }
    }
}
