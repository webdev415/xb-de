package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;

public class C1294ay extends BroadcastReceiver {

    public final C0200EF f3813a;

    public boolean f3814b;

    public boolean f3815c;

    public C1294ay(C0200EF c0200ef) {
        AbstractC1085Xi.m4801j(c0200ef);
        this.f3813a = c0200ef;
    }

    public final void m5570b() {
        this.f3813a.m904A0();
        this.f3813a.mo354l().mo356n();
        if (this.f3814b) {
            return;
        }
        this.f3813a.mo344a().registerReceiver(this, new IntentFilter("android.net.conn.CONNECTIVITY_CHANGE"));
        this.f3815c = this.f3813a.m953q0().m4300B();
        this.f3813a.mo349g().m9622K().m10617b("Registering connectivity change receiver. Network connected", Boolean.valueOf(this.f3815c));
        this.f3814b = true;
    }

    public final void m5571c() {
        this.f3813a.m904A0();
        this.f3813a.mo354l().mo356n();
        this.f3813a.mo354l().mo356n();
        if (this.f3814b) {
            this.f3813a.mo349g().m9622K().m10616a("Unregistering connectivity change receiver");
            this.f3814b = false;
            this.f3815c = false;
            try {
                this.f3813a.mo344a().unregisterReceiver(this);
            } catch (IllegalArgumentException e) {
                this.f3813a.mo349g().m9618G().m10617b("Failed to unregister the network broadcast receiver", e);
            }
        }
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.f3813a.m904A0();
        String action = intent.getAction();
        this.f3813a.mo349g().m9622K().m10617b("NetworkBroadcastReceiver received action", action);
        if (!"android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
            this.f3813a.mo349g().m9623L().m10617b("NetworkBroadcastReceiver received unknown action", action);
            return;
        }
        boolean zM4300B = this.f3813a.m953q0().m4300B();
        if (this.f3815c != zM4300B) {
            this.f3815c = zM4300B;
            this.f3813a.mo354l().m7374C(new RunnableC1849hy(this, zM4300B));
        }
    }
}
