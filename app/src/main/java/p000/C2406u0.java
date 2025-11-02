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

/* loaded from: classes.dex */
public class C2406u0 {

    public static C2406u0 f7340d;

    public SharedPreferences f7341a = null;

    public BrowserActivity f7342b = null;

    public HashMap f7343c = new HashMap<>();

    public static C2406u0 m9882f() {
        if (f7340d == null) {
            f7340d = new C2406u0();
        }
        return f7340d;
    }

    public boolean m9883a(String str) {
        return m9893l(str) && m9892k(str);
    }

    public void m9884b(String str, String str2, String str3, String str4, String str5) {
        Player c2360t0M9885c = m9882f().m9885c(str);
        try {
            try {
                if (c2360t0M9885c != null) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.addCategory("android.intent.category.APP_BROWSER");
                    intent.setData(Uri.parse(str2));
                    intent.setClassName(str, c2360t0M9885c.f7129d);
                    intent.putExtra("User-Agent", str3);
                    intent.putExtra("Cookie", str5);
                    intent.putExtra("Referer", str4);
                    this.f7342b.startActivity(intent);
                } else {
                    Toast.makeText(this.f7342b, "not found bind downloader", Toast.LENGTH_SHORT).show();
                }
            } catch (Exception unused) {
                Uri uri = Uri.parse(str2);
                Intent intent2 = new Intent("android.intent.action.SEND");
                intent2.setType("*/*");
                intent2.setData(uri);
                intent2.setClassName(str, c2360t0M9885c.f7129d);
                intent2.putExtra("android.intent.extra.STREAM", uri);
                this.f7342b.startActivity(intent2);
            }
        } catch (Exception unused2) {
            Toast.makeText(this.f7342b, "forward third-part downloader:" + str + " error:", Toast.LENGTH_SHORT).show();
        }
    }

    public Player m9885c(String str) {
        return (Player) this.f7343c.get(str);
    }

    public Player m9886d(String str) {
        return (Player) this.f7343c.get(str);
    }

    public ArrayList m9887e(int i) {
        ArrayList arrayList = new ArrayList<>(3);
        Iterator it = this.f7343c.entrySet().iterator();
        while (it.hasNext()) {
            Player player = (Player) ((Map.Entry) it.next()).getValue();
            if (player.f7133h == i) {
                arrayList.add(player);
            }
        }
        return arrayList;
    }

    public void m9888g(BrowserActivity browserActivity) {
        this.f7342b = browserActivity;
        this.f7341a = browserActivity.getSharedPreferences("addon", 0);
        m9889h();
    }

    public final void m9889h() {
        m9890i();
        m9891j();
    }

    public final void m9890i() {
        Player player = new Player();
        player.packageName = "com.dv.adm.pay";
        player.type = 0;
        player.f7133h = 16;
        player.f7129d = "com.dv.adm.pay.AEditor";
        player.className = "com.dv.get.Main";
        player.f7126a = this.f7342b.getString(R.string.addon_adm_title);
        player.f7127b = this.f7342b.getString(R.string.addon_adm_intro);
        this.f7343c.put(player.packageName, player);
        Player c2360t02 = new Player();
        c2360t02.packageName = "com.dv.adm";
        c2360t02.type = 0;
        c2360t02.f7133h = 16;
        c2360t02.f7126a = this.f7342b.getString(R.string.addon_adm_title);
        c2360t02.f7127b = this.f7342b.getString(R.string.addon_adm_intro);
        c2360t02.f7129d = "com.dv.adm.AEditor";
        c2360t02.className = "com.dv.get.Main";
        c2360t02.f7135j = true;
        this.f7343c.put(c2360t02.packageName, c2360t02);
        Player c2360t03 = new Player();
        c2360t03.packageName = "idm.internet.download.manager.plus";
        c2360t03.type = 0;
        c2360t03.f7133h = 16;
        c2360t03.f7129d = "idm.internet.download.manager.Downloader";
        c2360t03.className = "idm.internet.download.manager.MainActivity";
        c2360t03.f7126a = this.f7342b.getString(R.string.addon_idm_title);
        c2360t03.f7127b = this.f7342b.getString(R.string.addon_idm_intro);
        this.f7343c.put(c2360t03.packageName, c2360t03);
        Player c2360t04 = new Player();
        c2360t04.packageName = "idm.internet.download.manager";
        c2360t04.type = 0;
        c2360t04.f7133h = 16;
        c2360t04.f7129d = "idm.internet.download.manager.Downloader";
        c2360t04.className = "idm.internet.download.manager.MainActivity";
        c2360t04.f7126a = this.f7342b.getString(R.string.addon_idm_title);
        c2360t04.f7127b = this.f7342b.getString(R.string.addon_idm_intro);
        this.f7343c.put(c2360t04.packageName, c2360t04);
        Player c2360t05 = new Player();
        c2360t05.packageName = "org.freedownloadmanager.fdm";
        c2360t05.f7133h = 16;
        c2360t05.f7126a = this.f7342b.getString(R.string.addon_fdm_title);
        c2360t05.f7129d = "org.freedownloadmanager.fdm.MyActivity";
        c2360t05.className = "org.freedownloadmanager.fdm.MyActivity";
        this.f7343c.put(c2360t05.packageName, c2360t05);
        Player c2360t06 = new Player();
        c2360t06.packageName = "com.gianlu.aria2app";
        c2360t06.f7133h = 16;
        c2360t06.f7129d = "com.gianlu.aria2app.LoadingActivity";
        c2360t06.className = "com.gianlu.aria2app.LoadingActivity";
        c2360t06.f7126a = this.f7342b.getString(R.string.addon_aria2app_title);
        this.f7343c.put(c2360t06.packageName, c2360t06);
        Player c2360t07 = new Player();
        c2360t07.packageName = "com.xunlei.downloadprovider";
        c2360t07.f7133h = 16;
        c2360t07.f7129d = "com.xunlei.downloadprovider.launch.LaunchActivity2";
        c2360t07.className = "com.xunlei.downloadprovider.launch.LaunchActivity2";
        c2360t07.f7126a = this.f7342b.getString(R.string.addon_xunlei_title);
        this.f7343c.put(c2360t07.packageName, c2360t07);
    }

    public final void m9891j() {
        Player player = new Player();
        player.packageName = "cast.video.screenmirroring.casttotv";
        player.f7133h = 8;
        this.f7343c.put("cast.video.screenmirroring.casttotv", player);
        Player c2360t02 = new Player();
        c2360t02.packageName = "com.olimsoft.android.oplayer";
        c2360t02.f7133h = 8;
        this.f7343c.put("com.olimsoft.android.oplayer", c2360t02);
        Player c2360t03 = new Player();
        c2360t03.packageName = "com.olimsoft.android.oplayer.pro";
        c2360t03.f7133h = 8;
        this.f7343c.put("com.olimsoft.android.oplayer.pro", c2360t03);
        Player c2360t04 = new Player();
        c2360t04.packageName = "com.instantbits.cast.webvideo";
        c2360t04.f7133h = 8;
        this.f7343c.put("com.instantbits.cast.webvideo", c2360t04);
    }

    public boolean m9892k(String str) {
        return this.f7341a.getBoolean(str + ".active", true);
    }

    public boolean m9893l(String str) throws PackageManager.NameNotFoundException {
        boolean z = false;
        try {
            PackageInfo packageInfo = this.f7342b.getPackageManager().getPackageInfo(str, 8192);
            if (packageInfo != null) {
                z = true;
                Player player = (Player) this.f7343c.get(str);
                if (player != null) {
                    player.f7131f = packageInfo.versionCode;
                }
            }
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return z;
    }

    public void m9894m(String str) {
        try {
            Player c2360t0M9885c = m9885c(str);
            if (c2360t0M9885c != null) {
                Intent intent = new Intent("android.intent.action.MAIN");
                intent.setClassName(str, c2360t0M9885c.className);
                this.f7342b.startActivity(intent);
            }
        } catch (Exception unused) {
            Toast.makeText(this.f7342b, "open third-part downloader:" + str + " error:", Toast.LENGTH_SHORT).show();
        }
    }
}
