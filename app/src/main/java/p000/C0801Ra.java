package p000;

import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.text.TextUtils;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.io.File;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.Comparator;
import java.util.Locale;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class C0801Ra {

    public static C0801Ra f2374d;

    public BrowserActivity f2375a = null;

    public boolean f2376b = false;

    public String f2377c = null;

    public class b implements Runnable {

        public final String f2380l;

        public b(String str) {
            this.f2380l = str;
        }

        @Override
        public void run() throws URISyntaxException {
            C0801Ra.this.f2375a.m6307d2("file://" + this.f2380l);
        }
    }

    public class c implements Comparator {
        public c() {
        }

        @Override
        public int compare(C0710Pa c0710Pa, C0710Pa c0710Pa2) {
            long j = c0710Pa2.f2119c;
            long j2 = c0710Pa.f2119c;
            if (j > j2) {
                return 1;
            }
            return j == j2 ? 0 : -1;
        }
    }

    public class d implements Comparator {
        public d() {
        }

        @Override
        public int compare(C0710Pa c0710Pa, C0710Pa c0710Pa2) {
            return PhoneUtils.getInstance().isInChina() ? Collator.getInstance(Locale.CHINESE).compare(c0710Pa.f2117a, c0710Pa2.f2117a) : c0710Pa.f2117a.compareTo(c0710Pa2.f2117a);
        }
    }

    public static C0801Ra m3798f() {
        if (f2374d == null) {
            f2374d = new C0801Ra();
        }
        return f2374d;
    }

    public void m3799a(String str) {
        this.f2377c = str;
    }

    public void m3800b(String str) {
        this.f2376b = true;
        this.f2377c = str;
        C1199a3.m5090f().m5098j("notify_cut_file_item", "id", AndroidSystemUtils.prefixWithMd5(str));
    }

    public void m3801c(String str) {
        boolean zIsDirectory = new File(str).isDirectory();
        if (zIsDirectory) {
            if (zIsDirectory) {
                new a(this.f2375a, str).m5643d(this.f2375a.getString(R.string.dlg_remove_dir_title), this.f2375a.getString(R.string.dlg_remove_dir_confirm));
            }
        } else {
            FileUtils.deleteFile(str);
            C1199a3.m5090f().m5098j("notify_file_deleted", "id", AndroidSystemUtils.prefixWithMd5(str));
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x00d5 A[Catch: Exception -> 0x0030, LOOP:1: B:32:0x00cf->B:34:0x00d5, LOOP_END, TRY_LEAVE, TryCatch #0 {Exception -> 0x0030, blocks: (B:4:0x0016, B:8:0x0027, B:13:0x0033, B:15:0x0059, B:17:0x0061, B:21:0x0071, B:20:0x006d, B:22:0x009d, B:23:0x00a0, B:25:0x00a8, B:26:0x00b4, B:31:0x00cb, B:32:0x00cf, B:34:0x00d5, B:27:0x00b8, B:29:0x00c0, B:30:0x00c6), top: B:39:0x0016 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String m3802d(String r11, String r12) throws org.json.JSONException {
        /*
            Method dump skipped, instructions count: 297
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.C0801Ra.m3802d(java.lang.String, java.lang.String):java.lang.String");
    }

    public String m3803e(Uri uri) {
        String string = null;
        if (uri.getScheme().equals("content")) {
            Cursor cursorQuery = this.f2375a.getContentResolver().query(uri, null, null, null, null);
            if (cursorQuery != null) {
                try {
                    if (cursorQuery.moveToFirst()) {
                        string = cursorQuery.getString(cursorQuery.getColumnIndex("_display_name"));
                    }
                } finally {
                    cursorQuery.close();
                }
            }
            if (cursorQuery != null) {
            }
        }
        return string;
    }

    public void m3804g(BrowserActivity browserActivity) {
        this.f2375a = browserActivity;
    }

    public boolean m3805h() {
        return this.f2377c != null;
    }

    public void m3806i(String str) {
        new ViewOnClickListenerC2109nh(this.f2375a).m8786b(this.f2375a.getExternalFilesDir("") + File.separator + str);
    }

    public void m3807j(Uri uri, String str) {
        if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive") && !this.f2375a.getPackageManager().canRequestPackageInstalls()) {
            this.f2375a.m6356s2(uri);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(1);
        intent.setDataAndType(uri, str);
        this.f2375a.startActivity(intent);
    }

    public void m3808k(String str) {
        m3809l(str, null);
    }

    public void m3809l(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = NetworkUtils.getMimeType(str);
        }
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.f2375a, "Unknown file type", Toast.LENGTH_SHORT).show();
            return;
        }
        if (str2.equals("message/rfc822") || str2.equals("text/html") || str2.equals("text/plain") || str2.startsWith("image/")) {
            this.f2375a.runOnUiThread(new b(str));
        } else {
            this.f2375a.startActivity(FileUtils.createViewFileIntent(this.f2375a, str));
        }
    }

    public void m3810m(String str, int i) {
        String strM4227k = FileUtils.getFileName(this.f2377c);
        String str2 = str + "/" + strM4227k;
        if (str2.equals(this.f2377c) && this.f2376b) {
            this.f2377c = null;
            this.f2376b = false;
            return;
        }
        if (FileUtils.fileExists(str2)) {
            str2 = str + "/" + FileUtils.appendSuffix(strM4227k, "copy");
        }
        try {
            try {
                File file = new File(this.f2377c);
                File file2 = new File(str2);
                boolean zIsDirectory = file.isDirectory();
                if (zIsDirectory) {
                    FileUtils.copyDirectory(file, file2);
                } else {
                    FileUtils.copyFile(file, file2);
                }
                int iM4229m = FileUtils.getFileType(str2);
                AndroidSystemUtils.m8718z(file2.lastModified());
                AndroidSystemUtils.formatFileSize(file2.length());
                FileUtils.getFileName(str2);
                String strM10184c = AbstractCryptoUtils.toMd5(str2);
                JSONObject jSONObject = new JSONObject();
                jSONObject.put("transId", "notify_paste_file_item");
                JSONObject jSONObject2 = new JSONObject();
                jSONObject2.put("id", strM10184c);
                jSONObject2.put("file_name", strM4227k);
                jSONObject2.put("full_name", str2);
                jSONObject2.put("file_type", iM4229m);
                jSONObject.put("file_item", jSONObject2);
                C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
                if (this.f2376b) {
                    if (zIsDirectory) {
                        FileUtils.deleteRecursively(file);
                    } else {
                        FileUtils.deleteFile(this.f2377c);
                    }
                    C1199a3.m5090f().m5098j("notify_file_deleted", "id", AbstractCryptoUtils.toMd5(this.f2377c));
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            this.f2377c = null;
            this.f2376b = false;
        } catch (Throwable th) {
            this.f2377c = null;
            this.f2376b = false;
            throw th;
        }
    }

    public void m3811n(String str) {
        new ViewOnClickListenerC0847Sa(this.f2375a).m4034b(str);
    }

    public class a extends AbstractDialogC1303b6 {

        public final String f2378f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, String str) {
            super(context);
            this.f2378f = str;
        }

        @Override
        public void mo316c() {
            FileUtils.deleteRecursively(new File(this.f2378f));
            C1199a3.m5090f().m5098j("notify_file_deleted", "id", AndroidSystemUtils.prefixWithMd5(this.f2378f));
        }

        @Override
        public void mo315b() {
        }
    }
}
