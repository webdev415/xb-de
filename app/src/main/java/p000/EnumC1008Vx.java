package p000;

public enum EnumC1008Vx implements InterfaceC1209aD {
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN(0),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED(1),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED(2),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED(3),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED(4),
    AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED(5);


    public final int f3011l;

    EnumC1008Vx(int i) {
        this.f3011l = i;
    }

    public static EnumC1008Vx m4440c(int i) {
        if (i == 0) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_UNKNOWN;
        }
        if (i == 1) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_RESTRICTED;
        }
        if (i == 2) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_DENIED;
        }
        if (i == 3) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_AUTHORIZED;
        }
        if (i == 4) {
            return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_DETERMINED;
        }
        if (i != 5) {
            return null;
        }
        return AT_TRACKING_MANAGER_AUTHORIZATION_STATUS_NOT_CONFIGURED;
    }

    public static InterfaceC1116YC m4441e() {
        return C0916Tx.f2796a;
    }

    @Override
    public final int mo1742a() {
        return this.f3011l;
    }

    @Override
    public final String toString() {
        return "<" + EnumC1008Vx.class.getName() + '@' + Integer.toHexString(System.identityHashCode(this)) + " number=" + this.f3011l + " name=" + name() + '>';
    }
}
