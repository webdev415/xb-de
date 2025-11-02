package p000;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Handler;

/* loaded from: classes.dex */
public final class C1782ge {

    public final Context f5629a;

    public Runnable f5633e;

    public boolean f5634f;

    public boolean f5631c = false;

    public final BroadcastReceiver f5630b = new b();

    public Handler f5632d = new Handler();

    public final class b extends BroadcastReceiver {
        public b() {
        }

        public final void m7731b(boolean z) {
            C1782ge.this.m7726f(z);
        }

        @Override
        public void onReceive(Context context, Intent intent) {
            if ("android.intent.action.BATTERY_CHANGED".equals(intent.getAction())) {
                final boolean z = intent.getIntExtra("plugged", -1) <= 0;
                C1782ge.this.f5632d.post(new Runnable() {
                    @Override
                    public final void run() {
                        this.f5738l.m7731b(z);
                    }
                });
            }
        }
    }

    public C1782ge(Context context, Runnable runnable) {
        this.f5629a = context;
        this.f5633e = runnable;
    }

    public void m7723c() {
        m7725e();
        if (this.f5634f) {
            this.f5632d.postDelayed(this.f5633e, 300000L);
        }
    }

    public void m7724d() {
        m7725e();
        m7729i();
    }

    public final void m7725e() {
        this.f5632d.removeCallbacksAndMessages(null);
    }

    public final void m7726f(boolean z) {
        this.f5634f = z;
        if (this.f5631c) {
            m7723c();
        }
    }

    public final void m7727g() {
        if (this.f5631c) {
            return;
        }
        this.f5629a.registerReceiver(this.f5630b, new IntentFilter("android.intent.action.BATTERY_CHANGED"));
        this.f5631c = true;
    }

    public void m7728h() {
        m7727g();
        m7723c();
    }

    public final void m7729i() {
        if (this.f5631c) {
            this.f5629a.unregisterReceiver(this.f5630b);
            this.f5631c = false;
        }
    }
}
