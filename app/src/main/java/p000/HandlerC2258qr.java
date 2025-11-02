package p000;

import android.app.PendingIntent;
import android.os.Looper;
import android.os.Message;
import android.util.Log;

public final class HandlerC2258qr extends HandlerC2680zz {

    public final AbstractC2454v2 f6745b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC2258qr(AbstractC2454v2 abstractC2454v2, Looper looper) {
        super(looper);
        this.f6745b = abstractC2454v2;
    }

    public static final void m9201a(Message message) {
        AbstractC0038As abstractC0038As = (AbstractC0038As) message.obj;
        abstractC0038As.mo162b();
        abstractC0038As.m165e();
    }

    public static final boolean m9202b(Message message) {
        int i = message.what;
        return i == 2 || i == 1 || i == 7;
    }

    @Override
    public final void handleMessage(Message message) {
        if (this.f6745b.f7625C.get() != message.arg1) {
            if (m9202b(message)) {
                m9201a(message);
                return;
            }
            return;
        }
        int i = message.what;
        if ((i == 1 || i == 7 || ((i == 4 && !this.f6745b.m10290f()) || message.what == 5)) && !this.f6745b.m10304w()) {
            m9201a(message);
            return;
        }
        int i2 = message.what;
        if (i2 == 4) {
            this.f6745b.f7651z = new C1717f6(message.arg2);
            if (AbstractC2454v2.m10276U(this.f6745b)) {
                AbstractC2454v2 abstractC2454v2 = this.f6745b;
                if (!abstractC2454v2.f7623A) {
                    abstractC2454v2.m10285V(3, null);
                    return;
                }
            }
            AbstractC2454v2 abstractC2454v22 = this.f6745b;
            C1717f6 c1717f6 = abstractC2454v22.f7651z != null ? abstractC2454v22.f7651z : new C1717f6(8);
            this.f6745b.f7641p.mo10308a(c1717f6);
            this.f6745b.m10306y(c1717f6);
            return;
        }
        if (i2 == 5) {
            AbstractC2454v2 abstractC2454v23 = this.f6745b;
            C1717f6 c1717f62 = abstractC2454v23.f7651z != null ? abstractC2454v23.f7651z : new C1717f6(8);
            this.f6745b.f7641p.mo10308a(c1717f62);
            this.f6745b.m10306y(c1717f62);
            return;
        }
        if (i2 == 3) {
            Object obj = message.obj;
            C1717f6 c1717f63 = new C1717f6(message.arg2, obj instanceof PendingIntent ? (PendingIntent) obj : null);
            this.f6745b.f7641p.mo10308a(c1717f63);
            this.f6745b.m10306y(c1717f63);
            return;
        }
        if (i2 == 6) {
            this.f6745b.m10285V(5, null);
            AbstractC2454v2 abstractC2454v24 = this.f6745b;
            if (abstractC2454v24.f7646u != null) {
                abstractC2454v24.f7646u.mo8240a(message.arg2);
            }
            this.f6745b.m10307z(message.arg2);
            AbstractC2454v2.m10275T(this.f6745b, 5, 1, null);
            return;
        }
        if (i2 == 2 && !this.f6745b.m10303v()) {
            m9201a(message);
            return;
        }
        if (m9202b(message)) {
            ((AbstractC0038As) message.obj).m163c();
            return;
        }
        Log.wtf("GmsClient", "Don't know how to handle message: " + message.what, new Exception());
    }
}
