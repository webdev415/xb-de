package com.mmbox.xbrowser.user;

import android.os.Looper;
import android.os.MessageQueue;
import android.util.Log;
import android.widget.Toast;
import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.MenuConfigManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONException;
import p000.FileUtils;
import p000.AbstractC2313s;
import p000.SyncManager;
import p000.PhoneUtils;
import p000.EventQueueManager;
import p000.C2439uo;

public class StdUserEventHandler extends AbstractC2313s {

    public class C1587a implements MessageQueue.IdleHandler {
        public C1587a() {
        }

        @Override
        public boolean queueIdle() {
            if (SharedPreferencesHelper.getInstance().autoCleanWebCache && SharedPreferencesHelper.getInstance().appLaunchTimes % 10 == 0) {
                SharedPreferencesHelper.getInstance().m6906m(false);
            }
            StdUserEventHandler.this.m7172i();
            return false;
        }
    }

    public class C1588b implements MessageQueue.IdleHandler {
        public C1588b() {
        }

        @Override
        public boolean queueIdle() {
            Log.i("save-tabs", ">>>>>>>>>>> do  save tabs >>>>>>>>>>>>>>>");
            BrowserActivity.getActivity().getTabManager().m9297U(SharedPreferencesHelper.getInstance().getSharedPreferences());
            StdUserEventHandler.this.m7173j();
            return false;
        }
    }

    public class RunnableC1589c implements Runnable {
        public RunnableC1589c() {
        }

        @Override
        public void run() {
            Toast.makeText(BrowserActivity.getActivity(), "Hello Async message", Toast.LENGTH_SHORT).show();
            StdUserEventHandler.this.m9455b();
        }
    }

    @Override
    public boolean mo7164a(int i, String str, Object obj) throws JSONException {
        MessageQueue messageQueueMyQueue;
        MessageQueue.IdleHandler c1588b;
        if (i != 0) {
            if (i == 1) {
                C2439uo.getInstance().m10230q();
                C2439uo.getInstance().m10231r();
            } else if (i == 2) {
                MenuConfigManager.getInstance().m7017A();
                int iM6869O = SharedPreferencesHelper.getInstance().getInt("auto_backup_circle", 4);
                long jM6862K = SharedPreferencesHelper.getInstance().m6862K("last_auto_backup_time", 0L);
                long j = iM6869O == 1 ? 86400000L : iM6869O == 2 ? 259200000L : iM6869O == 3 ? 432000000L : iM6869O == 4 ? 604800000L : -1L;
                if (j > 0 && System.currentTimeMillis() - jM6862K > j) {
                    C2439uo.getInstance().m10223j(false, "auto_backup");
                    SharedPreferencesHelper.getInstance().m6919s0("last_auto_backup_time", System.currentTimeMillis());
                }
                if (C2439uo.getInstance().m10206D()) {
                    SyncManager.getInstance().m4821h();
                }
                m7173j();
                if (C2439uo.getInstance().m10206D()) {
                    boolean zM6873Q = SharedPreferencesHelper.getInstance().getBoolean("auto-sync-to-cloud", false);
                    if (System.currentTimeMillis() - SharedPreferencesHelper.getInstance().m6862K("last_auto_sync_time", 0L) > 3600000 && zM6873Q) {
                        SyncManager.getInstance().m4830r(false);
                        SharedPreferencesHelper.getInstance().m6919s0("last_auto_sync_time", System.currentTimeMillis());
                    }
                }
            } else if (i == 54) {
                messageQueueMyQueue = Looper.myQueue();
                c1588b = new C1588b();
            } else {
                if (i == 18) {
                    m7171h();
                    return false;
                }
                if (i == 53) {
                    Log.i("user-event", " data source updated:" + str);
                }
            }
            return true;
        }
        if (SharedPreferencesHelper.getInstance().f4873P) {
            C2439uo.getInstance().m10229p();
        }
        if (C2439uo.getInstance().m10206D()) {
            SyncManager.getInstance().m4825m();
        }
        C2439uo.getInstance().m10210H();
        if (SharedPreferencesHelper.getInstance().appLaunchTimes >= 7) {
            C2439uo.getInstance().m10228o();
        }
        if (SharedPreferencesHelper.getInstance().appLaunchTimes % 3 == 0 && !MessageBoxManager.getInstance().m6112c()) {
            PhoneUtils.getInstance().isInChina();
        }
        EventQueueManager.getInstance().loadEvents();
        messageQueueMyQueue = Looper.myQueue();
        c1588b = new C1587a();
        messageQueueMyQueue.addIdleHandler(c1588b);
        return true;
    }

    public final void m7171h() {
        BrowserActivity.getActivity().getHandler().postDelayed(new RunnableC1589c(), 5000L);
    }

    public final void m7172i() {
        try {
            String str = BrowserActivity.getActivity().getFilesDir().getAbsolutePath() + "/revert_urls";
            if (FileUtils.fileExists(str)) {
                JSONArray jSONArray = new JSONArray(FileUtils.readFileToString(str));
                for (int i = 0; i < jSONArray.length(); i++) {
                    BrowserActivity.getActivity().getActiveControllers().add(jSONArray.getString(i));
                }
            }
        } catch (Exception unused) {
        }
    }

    public final void m7173j() {
        ArrayList arrayListM6262T0 = BrowserActivity.getActivity().getActiveControllers();
        JSONArray jSONArray = new JSONArray();
        for (int i = 0; i < arrayListM6262T0.size(); i++) {
            jSONArray.put(arrayListM6262T0.get(i));
        }
        try {
            FileUtils.writeBytesToFile(jSONArray.toString().getBytes(StandardCharsets.UTF_8), BrowserActivity.getActivity().getFilesDir().getAbsolutePath() + "/revert_urls");
        } catch (Exception unused) {
        }
    }
}
