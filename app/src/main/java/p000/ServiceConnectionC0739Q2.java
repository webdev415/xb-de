package p000;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

public class ServiceConnectionC0739Q2 implements ServiceConnection {

    public boolean f2193a = false;

    public final BlockingQueue f2194b = new LinkedBlockingQueue();

    public IBinder m3625a(long j, TimeUnit timeUnit) throws TimeoutException {
        AbstractC1085Xi.m4800i("BlockingServiceConnection.getServiceWithTimeout() called on main thread");
        if (this.f2193a) {
            throw new IllegalStateException("Cannot call get on this connection more than once");
        }
        this.f2193a = true;
        IBinder iBinder = (IBinder) this.f2194b.poll(j, timeUnit);
        if (iBinder != null) {
            return iBinder;
        }
        throw new TimeoutException("Timed out waiting for the service connection");
    }

    @Override
    public final void onServiceConnected(ComponentName componentName, IBinder iBinder) {
        this.f2194b.add(iBinder);
    }

    @Override
    public final void onServiceDisconnected(ComponentName componentName) {
    }
}
