package p000;

import java.util.Iterator;
import java.util.Map;

/* loaded from: classes.dex */
public final class C1311bE implements InterfaceC0979VD {
    @Override
    public final AbstractC0795RD mo4367b(Object obj) {
        AbstractC2524wh.m10586a(obj);
        throw new NoSuchMethodError();
    }

    @Override
    public final Object mo4368c(Object obj, Object obj2) {
        C1071XD c1071xdM4706d = (C1071XD) obj;
        C1071XD c1071xd = (C1071XD) obj2;
        if (!c1071xd.isEmpty()) {
            if (!c1071xdM4706d.m4708f()) {
                c1071xdM4706d = c1071xdM4706d.m4706d();
            }
            c1071xdM4706d.m4705c(c1071xd);
        }
        return c1071xdM4706d;
    }

    @Override
    public final Map mo4369d(Object obj) {
        return (C1071XD) obj;
    }

    @Override
    public final Object mo4370e(Object obj) {
        return C1071XD.m4704b().m4706d();
    }

    @Override
    public final Map mo4371f(Object obj) {
        return (C1071XD) obj;
    }

    @Override
    public final boolean mo4372g(Object obj) {
        return !((C1071XD) obj).m4708f();
    }

    @Override
    public final Object mo4373h(Object obj) {
        ((C1071XD) obj).m4707e();
        return obj;
    }

    @Override
    public final int mo4374i(int i, Object obj, Object obj2) {
        C1071XD c1071xd = (C1071XD) obj;
        AbstractC2524wh.m10586a(obj2);
        if (c1071xd.isEmpty()) {
            return 0;
        }
        Iterator it = c1071xd.entrySet().iterator();
        if (!it.hasNext()) {
            return 0;
        }
        Map.Entry entry = (Map.Entry) it.next();
        entry.getKey();
        entry.getValue();
        throw new NoSuchMethodError();
    }
}
