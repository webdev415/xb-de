package p000;

import android.database.sqlite.SQLiteException;
import android.text.TextUtils;
import android.util.Pair;
import java.util.ArrayList;
import java.util.List;
import p000.C0365Hx;

/* loaded from: classes.dex */
public final class C1824hJ {

    public C0365Hx f5728a;

    public Long f5729b;

    public long f5730c;

    public final C0846SI f5731d;

    public C1824hJ(C0846SI c0846si) {
        this.f5731d = c0846si;
    }

    public final C0365Hx m7823a(String str, C0365Hx c0365Hx) {
        C2540wx c2540wxM9620I;
        String str2;
        Object obj;
        String strM1637U = c0365Hx.m1637U();
        List listM1638V = c0365Hx.m1638V();
        this.f5731d.mo3244o();
        Long l = (Long) C2145oG.m8904g0(c0365Hx, "_eid");
        boolean z = l != null;
        if (z && strM1637U.equals("_ep")) {
            AbstractC1085Xi.m4801j(l);
            this.f5731d.mo3244o();
            strM1637U = (String) C2145oG.m8904g0(c0365Hx, "_en");
            if (TextUtils.isEmpty(strM1637U)) {
                this.f5731d.mo349g().m9620I().m10617b("Extra parameter without an event name. eventId", l);
                return null;
            }
            if (this.f5728a == null || this.f5729b == null || l.longValue() != this.f5729b.longValue()) {
                Pair pairM2479H = this.f5731d.mo3246q().m2479H(str, l);
                if (pairM2479H == null || (obj = pairM2479H.first) == null) {
                    this.f5731d.mo349g().m9620I().m10618c("Extra parameter without existing main event. eventName, eventId", strM1637U, l);
                    return null;
                }
                this.f5728a = (C0365Hx) obj;
                this.f5730c = ((Long) pairM2479H.second).longValue();
                this.f5731d.mo3244o();
                this.f5729b = (Long) C2145oG.m8904g0(this.f5728a, "_eid");
            }
            long j = this.f5730c - 1;
            this.f5730c = j;
            if (j <= 0) {
                C0496Kq c0496KqMo3246q = this.f5731d.mo3246q();
                c0496KqMo3246q.mo356n();
                c0496KqMo3246q.mo349g().m9622K().m10617b("Clearing complex main event info. appId", str);
                try {
                    c0496KqMo3246q.m2467B().execSQL("delete from main_event_params where app_id=?", new String[]{str});
                } catch (SQLiteException e) {
                    c0496KqMo3246q.mo349g().m9618G().m10617b("Error clearing complex main event", e);
                }
            } else {
                this.f5731d.mo3246q().m2528h0(str, l, this.f5730c, this.f5728a);
            }
            ArrayList arrayList = new ArrayList<>();
            for (C0457Jx c0457Jx : this.f5728a.m1638V()) {
                this.f5731d.mo3244o();
                if (C2145oG.m8893O(c0365Hx, c0457Jx.m2191W()) == null) {
                    arrayList.add(c0457Jx);
                }
            }
            if (arrayList.isEmpty()) {
                c2540wxM9620I = this.f5731d.mo349g().m9620I();
                str2 = "No unique parameters in main event. eventName";
                c2540wxM9620I.m10617b(str2, strM1637U);
            } else {
                arrayList.addAll(listM1638V);
                listM1638V = arrayList;
            }
        } else if (z) {
            this.f5729b = l;
            this.f5728a = c0365Hx;
            this.f5731d.mo3244o();
            long jLongValue = ((Long) C2145oG.m8890E(c0365Hx, "_epc", 0L)).longValue();
            this.f5730c = jLongValue;
            if (jLongValue <= 0) {
                c2540wxM9620I = this.f5731d.mo349g().m9620I();
                str2 = "Complex event with zero extra param count. eventName";
                c2540wxM9620I.m10617b(str2, strM1637U);
            } else {
                this.f5731d.mo3246q().m2528h0(str, (Long) AbstractC1085Xi.m4801j(l), this.f5730c, c0365Hx);
            }
        }
        return (C0365Hx) ((AbstractC0703PC) ((C0365Hx.a) c0365Hx.m3517y()).m1660z(strM1637U).m1650G().m1659y(listM1638V).m3526o());
    }
}
