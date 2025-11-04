package p000;

import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Handler;

public final class C0139D0 implements SensorEventListener {

    public C0877T3 f335a;

    public C0969V3 f336b;

    public Sensor f337c;

    public Context f338d;

    public Handler f339e = new Handler();

    public C0139D0(Context context, C0877T3 c0877t3, C0969V3 c0969v3) {
        this.f338d = context;
        this.f335a = c0877t3;
        this.f336b = c0969v3;
    }

    public final void m593b(boolean z) {
        this.f335a.m4106t(z);
    }

    public final void m594c(final boolean z) {
        this.f339e.post(new Runnable() {
            @Override
            public final void run() {
                this.f231l.m593b(z);
            }
        });
    }

    public void m595d() {
        if (this.f336b.m4323d()) {
            SensorManager sensorManager = (SensorManager) this.f338d.getSystemService("sensor");
            Sensor defaultSensor = sensorManager.getDefaultSensor(5);
            this.f337c = defaultSensor;
            if (defaultSensor != null) {
                sensorManager.registerListener(this, defaultSensor, 3);
            }
        }
    }

    public void m596e() {
        if (this.f337c != null) {
            ((SensorManager) this.f338d.getSystemService("sensor")).unregisterListener(this);
            this.f337c = null;
        }
    }

    @Override
    public void onSensorChanged(SensorEvent sensorEvent) {
        float f = sensorEvent.values[0];
        if (this.f335a != null) {
            if (f <= 45.0f) {
                m594c(true);
            } else if (f >= 450.0f) {
                m594c(false);
            }
        }
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int i) {
    }
}
