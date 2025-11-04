package p000;

import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class C2406u0 {

    public static C2406u0 f7340d;

    public SharedPreferences sharedPreferences = null;

    public BrowserActivity browserActivity = null;

    public HashMap<String, Addon> players = new HashMap<>();

    public static C2406u0 getInstance() {
        if (f7340d == null) {
            f7340d = new C2406u0();
        }
        return f7340d;
    }

    public boolean m9883a(String str) {
        return m9893l(str) && m9892k(str);
    }

    public void m9884b(String str, String str2, String str3, String str4, String str5) {
        Addon c2360t0M9885c = getInstance().m9885c(str);
        try {
            try {
                if (c2360t0M9885c != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.APP_BROWSER");
                    intent.setData(Uri.parse(str2));
                    intent.setClassName(str, c2360t0M9885c.className);
                    intent.putExtra("User-Agent", str3);
                    intent.putExtra("Cookie", str5);
                    intent.putExtra("Referer", str4);
                    this.browserActivity.startActivity(intent);
                } else {
                    Toast.makeText(this.browserActivity, "not found bind downloader", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception unused) {
                Uri uri = Uri.parse(str2);
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("*/*");
                intent2.setData(uri);
                intent2.setClassName(str, c2360t0M9885c.className);
                intent2.putExtra("android.intent.extra.STREAM", uri);
                this.browserActivity.startActivity(intent2);
            }
        } catch (Exception unused2) {
            Toast.makeText(this.browserActivity, "forward third-part downloader:" + str + " error:", Toast.LENGTH_SHORT).show();
        }
    }

    public Addon m9885c(String str) {
        return (Addon) this.players.get(str);
    }

    public Addon m9886d(String str) {
        return (Addon) this.players.get(str);
    }

    public ArrayList m9887e(int i) {
        ArrayList arrayList = new ArrayList<>(3);
        Iterator it = this.players.entrySet().iterator();
        while (it.hasNext()) {
            Addon addon = (Addon) ((Map.Entry) it.next()).getValue();
            if (addon.extPoint == i) {
                arrayList.add(addon);
            }
        }
        return arrayList;
    }

    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
        this.sharedPreferences = browserActivity.getSharedPreferences("addon", 0);
        setupPlayers();
    }

    public final void setupPlayers() {
        m9890i();
        m9891j();
    }

    public final void m9890i() {
        Addon addon = new Addon();
        addon.id = "com.dv.adm.pay";
        addon.type = 0;
        addon.extPoint = 16;
        addon.className = "com.dv.adm.pay.AEditor";
        addon.mainClassName = "com.dv.get.Main";
        addon.title = this.browserActivity.getString(R.string.addon_adm_title);
        addon.intro = this.browserActivity.getString(R.string.addon_adm_intro);
        this.players.put(addon.id, addon);

        Addon c2360t02 = new Addon();
        c2360t02.id = "com.dv.adm";
        c2360t02.type = 0;
        c2360t02.extPoint = 16;
        c2360t02.title = this.browserActivity.getString(R.string.addon_adm_title);
        c2360t02.intro = this.browserActivity.getString(R.string.addon_adm_intro);
        c2360t02.className = "com.dv.adm.AEditor";
        c2360t02.mainClassName = "com.dv.get.Main";
        c2360t02.free = true;
        this.players.put(c2360t02.id, c2360t02);

        Addon c2360t03 = new Addon();
        c2360t03.id = "idm.internet.download.manager.plus";
        c2360t03.type = 0;
        c2360t03.extPoint = 16;
        c2360t03.className = "idm.internet.download.manager.Downloader";
        c2360t03.mainClassName = "idm.internet.download.manager.MainActivity";
        c2360t03.title = this.browserActivity.getString(R.string.addon_idm_title);
        c2360t03.intro = this.browserActivity.getString(R.string.addon_idm_intro);
        this.players.put(c2360t03.id, c2360t03);

        Addon c2360t04 = new Addon();
        c2360t04.id = "idm.internet.download.manager";
        c2360t04.type = 0;
        c2360t04.extPoint = 16;
        c2360t04.className = "idm.internet.download.manager.Downloader";
        c2360t04.mainClassName = "idm.internet.download.manager.MainActivity";
        c2360t04.title = this.browserActivity.getString(R.string.addon_idm_title);
        c2360t04.intro = this.browserActivity.getString(R.string.addon_idm_intro);
        this.players.put(c2360t04.id, c2360t04);

        Addon c2360t05 = new Addon();
        c2360t05.id = "org.freedownloadmanager.fdm";
        c2360t05.extPoint = 16;
        c2360t05.title = this.browserActivity.getString(R.string.addon_fdm_title);
        c2360t05.className = "org.freedownloadmanager.fdm.MyActivity";
        c2360t05.mainClassName = "org.freedownloadmanager.fdm.MyActivity";
        this.players.put(c2360t05.id, c2360t05);

        Addon c2360t06 = new Addon();
        c2360t06.id = "com.gianlu.aria2app";
        c2360t06.extPoint = 16;
        c2360t06.className = "com.gianlu.aria2app.LoadingActivity";
        c2360t06.mainClassName = "com.gianlu.aria2app.LoadingActivity";
        c2360t06.title = this.browserActivity.getString(R.string.addon_aria2app_title);
        this.players.put(c2360t06.id, c2360t06);

        Addon c2360t07 = new Addon();
        c2360t07.id = "com.xunlei.downloadprovider";
        c2360t07.extPoint = 16;
        c2360t07.className = "com.xunlei.downloadprovider.launch.LaunchActivity2";
        c2360t07.mainClassName = "com.xunlei.downloadprovider.launch.LaunchActivity2";
        c2360t07.title = this.browserActivity.getString(R.string.addon_xunlei_title);
        this.players.put(c2360t07.id, c2360t07);
    }

    public final void m9891j() {
        Addon addon = new Addon();
        addon.id = "cast.video.screenmirroring.casttotv";
        addon.extPoint = 8;
        this.players.put("cast.video.screenmirroring.casttotv", addon);
        Addon c2360t02 = new Addon();
        c2360t02.id = "com.olimsoft.android.oplayer";
        c2360t02.extPoint = 8;
        this.players.put("com.olimsoft.android.oplayer", c2360t02);
        Addon c2360t03 = new Addon();
        c2360t03.id = "com.olimsoft.android.oplayer.pro";
        c2360t03.extPoint = 8;
        this.players.put("com.olimsoft.android.oplayer.pro", c2360t03);
        Addon c2360t04 = new Addon();
        c2360t04.id = "com.instantbits.cast.webvideo";
        c2360t04.extPoint = 8;
        this.players.put("com.instantbits.cast.webvideo", c2360t04);
    }

    public boolean m9892k(String str) {
        return this.sharedPreferences.getBoolean(str + ".active", true);
    }

    public boolean m9893l(String str) throws PackageManager.NameNotFoundException {
        boolean z = false;
        try {
            PackageInfo packageInfo = this.browserActivity.getPackageManager().getPackageInfo(str, 8192);
            if (packageInfo != null) {
                z = true;
                Addon addon = (Addon) this.players.get(str);
                if (addon != null) {
                    addon.versionCode = packageInfo.versionCode;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return z;
    }

    public void m9894m(String str) {
        try {
            Addon c2360t0M9885c = m9885c(str);
            if (c2360t0M9885c != null) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setClassName(str, c2360t0M9885c.mainClassName);
                this.browserActivity.startActivity(intent);
            }
        } catch (Exception unused) {
            Toast.makeText(this.browserActivity, "open third-part downloader:" + str + " error:", Toast.LENGTH_SHORT).show();
        }
    }
}
