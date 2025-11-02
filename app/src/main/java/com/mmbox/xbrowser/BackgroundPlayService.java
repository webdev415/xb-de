package com.mmbox.xbrowser;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import com.xbrowser.play.R;
import p000.AbstractC1900j2;
import p000.C2478vh;

/* loaded from: classes.dex */
public class BackgroundPlayService extends Service {

    public NotificationManager f4235a;

    public final void m6159a() {
        if (Build.VERSION.SDK_INT >= 26) {
            NotificationChannel notificationChannelM8097a = AbstractC1900j2.m8097a("BackgroundPlayServiceChannel", "Background Play Service Channel", 4);
            NotificationManager notificationManager = (NotificationManager) getSystemService(NotificationManager.class);
            if (!notificationManager.areNotificationsEnabled()) {
                BrowserActivity.getActivity().m6277X();
            }
            notificationManager.createNotificationChannel(notificationChannelM8097a);
        }
    }

    public final void m6160b(String str) {
        Intent intent = new Intent(this, (Class<?>) BrowserActivity.class);
        intent.setAction("android.intent.action.VIEW");
        startForeground(1, new C2478vh(this, "BackgroundPlayServiceChannel").m10364g(getApplicationContext().getString(R.string.message_page_run_in_background)).m10363f(str).m10368k(R.drawable.ic_slogan).m10362e(PendingIntent.getActivity(this, 0, intent, 67108864)).m10359a());
    }

    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        this.f4235a = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        this.f4235a.cancel(1);
    }

    @Override
    public int onStartCommand(Intent intent, int i, int i2) {
        m6159a();
        if (intent == null || intent.getAction() == null || !intent.getAction().equals("action.make_page_background")) {
            return 2;
        }
        m6160b(intent.getStringExtra("title"));
        return 2;
    }
}
