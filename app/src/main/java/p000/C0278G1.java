package p000;

import android.content.Context;
import android.database.Cursor;
import android.net.Uri;
import android.util.Log;
import java.util.HashMap;

public class C0278G1 implements InterfaceC0094C1 {

    public Context f703a;

    public class a implements Runnable {

        public final HashMap f704l;

        public final String f705m;

        public final DataSource f706n;

        public final InterfaceC2229q7 f707o;

        public a(HashMap map, String str, DataSource dataSource, InterfaceC2229q7 interfaceC2229q7) {
            this.f704l = map;
            this.f705m = str;
            this.f706n = dataSource;
            this.f707o = interfaceC2229q7;
        }

        @Override
        public void run() {
            String[] strArr;
            String str;
            String[] strArr2;
            String str2;
            InterfaceC2229q7 interfaceC2229q7;
            HashMap map = this.f704l;
            if (map != null) {
                String str3 = (String) map.get("selection");
                String[] strArr3 = (String[]) this.f704l.get("args");
                String[] strArr4 = (String[]) this.f704l.get("projection");
                str = str3;
                strArr2 = strArr3;
                str2 = (String) this.f704l.get("sort_order");
                strArr = strArr4;
            } else {
                strArr = null;
                str = null;
                strArr2 = null;
                str2 = null;
            }
            Cursor cursorQuery = C0278G1.this.f703a.getContentResolver().query(Uri.parse(this.f705m), strArr, str, strArr2, str2);
            try {
                if (cursorQuery == null) {
                    Log.w("database", "failed obtain cursor");
                    return;
                }
                try {
                    Log.i("database", "got a cursor total :" + cursorQuery.getCount());
                    if (this.f706n.mo9041h(cursorQuery, 4) && (interfaceC2229q7 = this.f707o) != null) {
                        interfaceC2229q7.mo7837a(this.f706n);
                    }
                } catch (Exception e) {
                    InterfaceC2229q7 interfaceC2229q72 = this.f707o;
                    if (interfaceC2229q72 != null) {
                        interfaceC2229q72.mo7838b(this.f706n);
                    }
                    e.printStackTrace();
                }
            } finally {
                cursorQuery.close();
            }
        }
    }

    public C0278G1(Context context) {
        this.f703a = context;
    }

    @Override
    public void mo364a(String str, boolean z, InterfaceC2229q7 interfaceC2229q7, HashMap map) {
        DataSource dataSource = (DataSource) C2275r7.m9348e().m9356i(str);
        if (dataSource == null) {
            throw new IllegalStateException("the data source not register");
        }
        BackgroundTaskManager.submitBackgroundTask(new a(map, str, dataSource, interfaceC2229q7));
    }
}
