package p000;

import android.app.Notification;
import android.app.PendingIntent;
import android.app.RemoteInput;
import android.content.Context;
import android.content.LocusId;
import android.graphics.drawable.Icon;
import android.media.AudioAttributes;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.RemoteViews;
import androidx.core.graphics.drawable.IconCompat;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class C2570xh {

    public final Context f8010a;

    public final Notification.Builder f8011b;

    public final C2478vh f8012c;

    public RemoteViews f8013d;

    public RemoteViews f8014e;

    public final List f8015f = new ArrayList<>();

    public final Bundle f8016g = new Bundle();

    public int f8017h;

    public RemoteViews f8018i;

    public static class a {
        public static Notification.Builder m10728a(Notification.Builder builder, Notification.Action action) {
            return builder.addAction(action);
        }

        public static Notification.Action.Builder m10729b(Notification.Action.Builder builder, Bundle bundle) {
            return builder.addExtras(bundle);
        }

        public static Notification.Action.Builder m10730c(Notification.Action.Builder builder, RemoteInput remoteInput) {
            return builder.addRemoteInput(remoteInput);
        }

        public static Notification.Action m10731d(Notification.Action.Builder builder) {
            return builder.build();
        }

        public static Notification.Action.Builder m10732e(int i, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(i, charSequence, pendingIntent);
        }

        public static String m10733f(Notification notification) {
            return notification.getGroup();
        }

        public static Notification.Builder m10734g(Notification.Builder builder, String str) {
            return builder.setGroup(str);
        }

        public static Notification.Builder m10735h(Notification.Builder builder, boolean z) {
            return builder.setGroupSummary(z);
        }

        public static Notification.Builder m10736i(Notification.Builder builder, boolean z) {
            return builder.setLocalOnly(z);
        }

        public static Notification.Builder m10737j(Notification.Builder builder, String str) {
            return builder.setSortKey(str);
        }
    }

    public static class b {
        public static Notification.Builder m10738a(Notification.Builder builder, String str) {
            return builder.addPerson(str);
        }

        public static Notification.Builder m10739b(Notification.Builder builder, String str) {
            return builder.setCategory(str);
        }

        public static Notification.Builder m10740c(Notification.Builder builder, int i) {
            return builder.setColor(i);
        }

        public static Notification.Builder m10741d(Notification.Builder builder, Notification notification) {
            return builder.setPublicVersion(notification);
        }

        public static Notification.Builder m10742e(Notification.Builder builder, Uri uri, Object obj) {
            return builder.setSound(uri, (AudioAttributes) obj);
        }

        public static Notification.Builder m10743f(Notification.Builder builder, int i) {
            return builder.setVisibility(i);
        }
    }

    public static class c {
        public static Notification.Action.Builder m10744a(Icon icon, CharSequence charSequence, PendingIntent pendingIntent) {
            return new Notification.Action.Builder(icon, charSequence, pendingIntent);
        }

        public static Notification.Builder m10745b(Notification.Builder builder, Icon icon) {
            return builder.setLargeIcon(icon);
        }

        public static Notification.Builder m10746c(Notification.Builder builder, Object obj) {
            return builder.setSmallIcon((Icon) obj);
        }
    }

    public static class d {
        public static Notification.Action.Builder m10747a(Notification.Action.Builder builder, boolean z) {
            return builder.setAllowGeneratedReplies(z);
        }

        public static Notification.Builder m10748b(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomBigContentView(remoteViews);
        }

        public static Notification.Builder m10749c(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomContentView(remoteViews);
        }

        public static Notification.Builder m10750d(Notification.Builder builder, RemoteViews remoteViews) {
            return builder.setCustomHeadsUpContentView(remoteViews);
        }

        public static Notification.Builder m10751e(Notification.Builder builder, CharSequence[] charSequenceArr) {
            return builder.setRemoteInputHistory(charSequenceArr);
        }
    }

    public static class e {
        public static Notification.Builder m10752a(Context context, String str) {
            return new Notification.Builder(context, str);
        }

        public static Notification.Builder m10753b(Notification.Builder builder, int i) {
            return builder.setBadgeIconType(i);
        }

        public static Notification.Builder m10754c(Notification.Builder builder, boolean z) {
            return builder.setColorized(z);
        }

        public static Notification.Builder m10755d(Notification.Builder builder, int i) {
            return builder.setGroupAlertBehavior(i);
        }

        public static Notification.Builder m10756e(Notification.Builder builder, CharSequence charSequence) {
            return builder.setSettingsText(charSequence);
        }

        public static Notification.Builder m10757f(Notification.Builder builder, String str) {
            return builder.setShortcutId(str);
        }

        public static Notification.Builder m10758g(Notification.Builder builder, long j) {
            return builder.setTimeoutAfter(j);
        }
    }

    public static class f {
        public static Notification.Builder m10759a(Notification.Builder builder, boolean z) {
            return builder.setAllowSystemGeneratedContextualActions(z);
        }

        public static Notification.Builder m10760b(Notification.Builder builder, Notification.BubbleMetadata bubbleMetadata) {
            return builder.setBubbleMetadata(bubbleMetadata);
        }

        public static Notification.Action.Builder m10761c(Notification.Action.Builder builder, boolean z) {
            return builder.setContextual(z);
        }

        public static Notification.Builder m10762d(Notification.Builder builder, Object obj) {
            return builder.setLocusId((LocusId) obj);
        }
    }

    public static class g {
        public static Notification.Action.Builder m10763a(Notification.Action.Builder builder, boolean z) {
            return builder.setAuthenticationRequired(z);
        }

        public static Notification.Builder m10764b(Notification.Builder builder, int i) {
            return builder.setForegroundServiceBehavior(i);
        }
    }

    public C2570xh(C2478vh c2478vh) {
        int i;
        this.f8012c = c2478vh;
        Context context = c2478vh.f7701a;
        this.f8010a = context;
        this.f8011b = Build.VERSION.SDK_INT >= 26 ? e.m10752a(context, c2478vh.f7690J) : new Notification.Builder(c2478vh.f7701a);
        Notification notification = c2478vh.f7697Q;
        this.f8011b.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, c2478vh.f7709i).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(c2478vh.f7705e).setContentText(c2478vh.f7706f).setContentInfo(c2478vh.f7711k).setContentIntent(c2478vh.f7707g).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(c2478vh.f7708h, (notification.flags & 128) != 0).setNumber(c2478vh.f7712l).setProgress(c2478vh.f7719s, c2478vh.f7720t, c2478vh.f7721u);
        Notification.Builder builder = this.f8011b;
        IconCompat iconCompat = c2478vh.f7710j;
        c.m10745b(builder, iconCompat == null ? null : iconCompat.m5363h(context));
        this.f8011b.setSubText(c2478vh.f7716p).setUsesChronometer(c2478vh.f7715o).setPriority(c2478vh.f7713m);
        Iterator it = c2478vh.f7702b.iterator();
        while (it.hasNext()) {
            AbstractC2524wh.m10586a(it.next());
            m10724a(null);
        }
        Bundle bundle = c2478vh.f7683C;
        if (bundle != null) {
            this.f8016g.putAll(bundle);
        }
        int i2 = Build.VERSION.SDK_INT;
        this.f8013d = c2478vh.f7687G;
        this.f8014e = c2478vh.f7688H;
        this.f8011b.setShowWhen(c2478vh.f7714n);
        a.m10736i(this.f8011b, c2478vh.f7725y);
        a.m10734g(this.f8011b, c2478vh.f7722v);
        a.m10737j(this.f8011b, c2478vh.f7724x);
        a.m10735h(this.f8011b, c2478vh.f7723w);
        this.f8017h = c2478vh.f7694N;
        b.m10739b(this.f8011b, c2478vh.f7682B);
        b.m10740c(this.f8011b, c2478vh.f7684D);
        b.m10743f(this.f8011b, c2478vh.f7685E);
        b.m10741d(this.f8011b, c2478vh.f7686F);
        b.m10742e(this.f8011b, notification.sound, notification.audioAttributes);
        List listM10722d = i2 < 28 ? m10722d(m10723e(c2478vh.f7703c), c2478vh.f7700T) : c2478vh.f7700T;
        if (listM10722d != null && !listM10722d.isEmpty()) {
            Iterator it2 = listM10722d.iterator();
            while (it2.hasNext()) {
                b.m10738a(this.f8011b, (String) it2.next());
            }
        }
        this.f8018i = c2478vh.f7689I;
        if (c2478vh.f7704d.size() > 0) {
            Bundle bundle2 = c2478vh.m10360b().getBundle("android.car.EXTENSIONS");
            bundle2 = bundle2 == null ? new Bundle() : bundle2;
            Bundle bundle3 = new Bundle(bundle2);
            Bundle bundle4 = new Bundle();
            for (int i3 = 0; i3 < c2478vh.f7704d.size(); i3++) {
                String string = Integer.toString(i3);
                AbstractC2524wh.m10586a(c2478vh.f7704d.get(i3));
                bundle4.putBundle(string, AbstractC2616yh.m10887a(null));
            }
            bundle2.putBundle("invisible_actions", bundle4);
            bundle3.putBundle("invisible_actions", bundle4);
            c2478vh.m10360b().putBundle("android.car.EXTENSIONS", bundle2);
            this.f8016g.putBundle("android.car.EXTENSIONS", bundle3);
        }
        int i4 = Build.VERSION.SDK_INT;
        Object obj = c2478vh.f7699S;
        if (obj != null) {
            c.m10746c(this.f8011b, obj);
        }
        this.f8011b.setExtras(c2478vh.f7683C);
        d.m10751e(this.f8011b, c2478vh.f7718r);
        RemoteViews remoteViews = c2478vh.f7687G;
        if (remoteViews != null) {
            d.m10749c(this.f8011b, remoteViews);
        }
        RemoteViews remoteViews2 = c2478vh.f7688H;
        if (remoteViews2 != null) {
            d.m10748b(this.f8011b, remoteViews2);
        }
        RemoteViews remoteViews3 = c2478vh.f7689I;
        if (remoteViews3 != null) {
            d.m10750d(this.f8011b, remoteViews3);
        }
        if (i4 >= 26) {
            e.m10753b(this.f8011b, c2478vh.f7691K);
            e.m10756e(this.f8011b, c2478vh.f7717q);
            e.m10757f(this.f8011b, c2478vh.f7692L);
            e.m10758g(this.f8011b, c2478vh.f7693M);
            e.m10755d(this.f8011b, c2478vh.f7694N);
            if (c2478vh.f7681A) {
                e.m10754c(this.f8011b, c2478vh.f7726z);
            }
            if (!TextUtils.isEmpty(c2478vh.f7690J)) {
                this.f8011b.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
            }
        }
        if (i4 >= 28) {
            Iterator it3 = c2478vh.f7703c.iterator();
            if (it3.hasNext()) {
                AbstractC2524wh.m10586a(it3.next());
                throw null;
            }
        }
        if (i4 >= 29) {
            f.m10759a(this.f8011b, c2478vh.f7696P);
            f.m10760b(this.f8011b, AbstractC2432uh.m10151a(null));
        }
        if (i4 >= 31 && (i = c2478vh.f7695O) != 0) {
            g.m10764b(this.f8011b, i);
        }
        if (c2478vh.f7698R) {
            if (this.f8012c.f7723w) {
                this.f8017h = 2;
            } else {
                this.f8017h = 1;
            }
            this.f8011b.setVibrate(null);
            this.f8011b.setSound(null);
            int i5 = notification.defaults & (-4);
            notification.defaults = i5;
            this.f8011b.setDefaults(i5);
            if (i4 >= 26) {
                if (TextUtils.isEmpty(this.f8012c.f7722v)) {
                    a.m10734g(this.f8011b, "silent");
                }
                e.m10755d(this.f8011b, this.f8017h);
            }
        }
    }

    public static List m10722d(List list, List list2) {
        if (list == null) {
            return list2;
        }
        if (list2 == null) {
            return list;
        }
        C2499w1 c2499w1 = new C2499w1(list.size() + list2.size());
        c2499w1.addAll(list);
        c2499w1.addAll(list2);
        return new ArrayList<>(c2499w1);
    }

    public static List m10723e(List list) {
        if (list == null) {
            return null;
        }
        ArrayList arrayList = new ArrayList<>(list.size());
        Iterator it = list.iterator();
        if (!it.hasNext()) {
            return arrayList;
        }
        AbstractC2524wh.m10586a(it.next());
        throw null;
    }

    public final void m10724a(AbstractC2386th abstractC2386th) {
        throw null;
    }

    public Notification m10725b() {
        this.f8012c.getClass();
        Notification notificationM10726c = m10726c();
        RemoteViews remoteViews = this.f8012c.f7687G;
        if (remoteViews != null) {
            notificationM10726c.contentView = remoteViews;
        }
        return notificationM10726c;
    }

    public Notification m10726c() {
        if (Build.VERSION.SDK_INT >= 26) {
            return this.f8011b.build();
        }
        Notification notificationBuild = this.f8011b.build();
        if (this.f8017h != 0) {
            if (a.m10733f(notificationBuild) != null && (notificationBuild.flags & 512) != 0 && this.f8017h == 2) {
                m10727f(notificationBuild);
            }
            if (a.m10733f(notificationBuild) != null && (notificationBuild.flags & 512) == 0 && this.f8017h == 1) {
                m10727f(notificationBuild);
            }
        }
        return notificationBuild;
    }

    public final void m10727f(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        notification.defaults &= -4;
    }
}
