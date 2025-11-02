package p000;

import android.content.Context;
import com.mmbox.widget.messagebox.C1418a;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.net.URISyntaxException;

/* loaded from: classes.dex */
public class C0786R4 extends AbstractC2175p {
    /* JADX WARN: Removed duplicated region for block: B:28:0x0070  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x0073  */
    /* JADX WARN: Removed duplicated region for block: B:33:0x007f  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x0081  */
    /* JADX WARN: Removed duplicated region for block: B:36:0x0084  */
    /* JADX WARN: Removed duplicated region for block: B:37:0x0086  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0089 A[ADDED_TO_REGION] */
    /* JADX WARN: Removed duplicated region for block: B:58:? A[ADDED_TO_REGION, RETURN, SYNTHETIC] */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void mo3474a(Context r11, C2273r5 r12) {
        /*
            r10 = this;
            java.lang.String r0 = "default"
            java.lang.String r1 = r12.f6871b
            if (r1 == 0) goto Lb4
            r1 = 0
            org.json.JSONObject r2 = new org.json.JSONObject     // Catch: java.lang.Exception -> L68
            java.lang.String r12 = r12.f6871b     // Catch: java.lang.Exception -> L68
            r2.<init>(r12)     // Catch: java.lang.Exception -> L68
            java.lang.String r12 = "message"
            org.json.JSONObject r12 = p000.AbstractC0760Qe.m3662g(r2, r12)     // Catch: java.lang.Exception -> L68
            java.lang.String r3 = "btn_txt"
            org.json.JSONObject r3 = p000.AbstractC0760Qe.m3662g(r2, r3)     // Catch: java.lang.Exception -> L68
            java.lang.String r4 = "target_url"
            java.lang.String r4 = p000.AbstractC0760Qe.m3665j(r2, r4)     // Catch: java.lang.Exception -> L68
            java.lang.String r5 = "msg_id"
            java.lang.String r5 = p000.AbstractC0760Qe.m3665j(r2, r5)     // Catch: java.lang.Exception -> L62
            java.lang.String r6 = p000.AbstractC0760Qe.m3665j(r12, r0)     // Catch: java.lang.Exception -> L5d
            java.lang.String r0 = p000.AbstractC0760Qe.m3665j(r3, r0)     // Catch: java.lang.Exception -> L59
            b1 r7 = p000.C1298b1.getInstance()     // Catch: java.lang.Exception -> L56
            java.lang.String r7 = r7.m5578B()     // Catch: java.lang.Exception -> L56
            java.lang.String r12 = p000.AbstractC0760Qe.m3665j(r12, r7)     // Catch: java.lang.Exception -> L56
            b1 r7 = p000.C1298b1.getInstance()     // Catch: java.lang.Exception -> L51
            java.lang.String r7 = r7.m5578B()     // Catch: java.lang.Exception -> L51
            java.lang.String r1 = p000.AbstractC0760Qe.m3665j(r3, r7)     // Catch: java.lang.Exception -> L51
            boolean r2 = r10.m8998b(r11, r2)     // Catch: java.lang.Exception -> L51
            if (r2 != 0) goto L4d
            return
        L4d:
            r8 = r5
            r2 = r6
            r6 = r4
            goto L7d
        L51:
            r2 = move-exception
            r9 = r1
            r1 = r12
            r12 = r9
            goto L6e
        L56:
            r2 = move-exception
            r12 = r1
            goto L6e
        L59:
            r2 = move-exception
            r12 = r1
            r0 = r12
            goto L6e
        L5d:
            r2 = move-exception
            r12 = r1
            r0 = r12
            r6 = r0
            goto L6e
        L62:
            r2 = move-exception
            r12 = r1
            r0 = r12
            r5 = r0
        L66:
            r6 = r5
            goto L6e
        L68:
            r2 = move-exception
            r12 = r1
            r0 = r12
            r4 = r0
            r5 = r4
            goto L66
        L6e:
            if (r1 != 0) goto L71
            r1 = r6
        L71:
            if (r12 != 0) goto L74
            r12 = r0
        L74:
            r2.printStackTrace()
            r8 = r5
            r2 = r6
            r6 = r4
            r9 = r1
            r1 = r12
            r12 = r9
        L7d:
            if (r12 != 0) goto L81
            r4 = r2
            goto L82
        L81:
            r4 = r12
        L82:
            if (r1 != 0) goto L86
            r5 = r0
            goto L87
        L86:
            r5 = r1
        L87:
            if (r6 == 0) goto Lb4
            if (r4 == 0) goto Lb4
            if (r5 == 0) goto Lb4
            com.mmbox.xbrowser.d r12 = com.mmbox.xbrowser.SharedPreferencesOnSharedPreferenceChangeListenerC1569d.m6833I()
            java.lang.String r0 = "last_cmd_message_id"
            java.lang.String r1 = ""
            java.lang.String r12 = r12.m6871P(r0, r1)
            boolean r12 = r12.equals(r8)
            if (r12 != 0) goto Lb4
            com.mmbox.xbrowser.BrowserActivity r12 = com.mmbox.xbrowser.BrowserActivity.m6183s1()
            android.os.Handler r12 = r12.m6242O0()
            R4$a r0 = new R4$a
            r2 = r0
            r3 = r10
            r7 = r11
            r2.<init>(r4, r5, r6, r7, r8)
            r1 = 5000(0x1388, double:2.4703E-320)
            r12.postDelayed(r0, r1)
        Lb4:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0786R4.mo3474a(android.content.Context, r5):void");
    }

    public class a implements Runnable {

        public final String f2321l;

        public final String f2322m;

        public final String f2323n;

        public final Context f2324o;

        public final String f2325p;

        public a(String str, String str2, String str3, Context context, String str4) {
            this.f2321l = str;
            this.f2322m = str2;
            this.f2323n = str3;
            this.f2324o = context;
            this.f2325p = str4;
        }

        @Override
        public void run() {
            if (this.f2321l != null && this.f2322m != null) {
                C1418a.m6110b().m6118i(BrowserActivity.getActivity().getBrowserFrameLayout(), this.f2321l, this.f2322m, new C2697a(), true);
            }
            SharedPreferencesHelper.getInstance().putString("last_cmd_message_id", this.f2325p);
        }

        public class C2697a implements MessageBoxBase.MessageBoxListener {
            public C2697a() {
            }

            @Override
            public void onShown() throws URISyntaxException {
                BrowserActivity.getActivity().m6307d2(a.this.f2323n);
                a aVar = a.this;
                C0786R4.this.m8999c(aVar.f2324o, "message_" + a.this.f2325p);
            }

            @Override
            public void onDismissed() {
            }

            @Override
            public void onDismiss() {
            }
        }
    }
}
