package p000;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import android.widget.Toast;

import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

import java.io.File;
import java.net.URISyntaxException;
import java.text.Collator;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Locale;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class C0801Ra {

    public static C0801Ra f2374d;

    public BrowserActivity browserActivity = null;

    public boolean f2376b = false;

    public String f2377c = null;

    public class b implements Runnable {

        public final String f2380l;

        public b(String str) {
            this.f2380l = str;
        }

        @Override
        public void run() throws URISyntaxException {
            C0801Ra.this.browserActivity.m6307d2("file://" + this.f2380l);
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

    public static C0801Ra getInstance() {
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
        C1199a3.getInstance().m5098j("notify_cut_file_item", "id", AndroidSystemUtils.prefixWithMd5(str));
    }

    public void m3801c(String path) {
        File file = new File(path);

        // Check if it's a directory
        if (!file.isDirectory()) {
            FileUtils.deleteFile(path);
            C1199a3.getInstance().m5098j("notify_file_deleted", "id", AndroidSystemUtils.prefixWithMd5(path));
        } else {
            new a(this.browserActivity, path).show(
                    browserActivity.getString(R.string.dlg_remove_dir_title),
                    browserActivity.getString(R.string.dlg_remove_dir_confirm));
        }
    }

    public String getFilesAsJson(String directoryPath, String sortCriteria) {
        String externalStorageState = Environment.getExternalStorageState();
        ArrayList<FileDetails> fileDetailsList = new ArrayList<>();
        JSONArray jsonArray = new JSONArray();

        // Ensure external storage is mounted
        if (!externalStorageState.equals(Environment.MEDIA_MOUNTED)) {
            return jsonArray.toString();
        }

        // Get the external files directory
        File externalFilesDir = browserActivity.getExternalFilesDir("");
        if (TextUtils.isEmpty(directoryPath)) {
            directoryPath = "/";
        }

        if (TextUtils.isEmpty(sortCriteria)) {
            sortCriteria = "default";
        }

        // List files in the directory
        File directory = new File(externalFilesDir.getAbsolutePath() + "/" + directoryPath);
        File[] files = directory.listFiles();
        if (files == null) {
            return jsonArray.toString();
        }

        // Loop through files and collect details
        for (File file : files) {
            if (file.isHidden()) continue;

            String fileName = file.getName();
            int fileType = file.isDirectory() ? 1 : FileUtils.getFileType(fileName);

            FileDetails fileDetails = new FileDetails();
            fileDetails.name = fileName;
            fileDetails.type = fileType;
            fileDetails.path = directory + "/" + fileName;
            fileDetails.lastModified = file.lastModified();
            fileDetails.size = file.length();

            fileDetailsList.add(fileDetails);
        }

        // Sorting based on criteria
        Comparator<FileDetails> comparator = null;
        if (sortCriteria.equals("date")) {
            comparator = (f1, f2) -> Long.compare(f2.lastModified, f1.lastModified);
        } else if (sortCriteria.equals("name")) {
            comparator = (f1, f2) -> f1.name.compareTo(f2.name);
        }

        if (comparator != null) {
            System.setProperty("java.util.Arrays.useLegacyMergeSort", "true");
            Collections.sort(fileDetailsList, comparator);
        }

        // Add sorted file details to the JSON array
        for (FileDetails fileDetails : fileDetailsList) {
            JSONObject fileJson = new JSONObject();
            try {
                fileJson.put("id", AndroidSystemUtils.prefixWithMd5(fileDetails.path));
                fileJson.put("file_name", fileDetails.name);
                fileJson.put("file_type", fileDetails.type);
                fileJson.put("full_name", fileDetails.path);
                fileJson.put("modify", fileDetails.lastModified);
                fileJson.put("update_at", AndroidSystemUtils.m8718z(fileDetails.lastModified));
                fileJson.put("size", AndroidSystemUtils.formatFileSize(fileDetails.size));
            } catch (JSONException e) {
                e.printStackTrace();
            }
            jsonArray.put(fileJson);
        }

        return jsonArray.toString();
    }

    private static class FileDetails {
        String name;
        int type;
        String path;
        long lastModified;
        long size;
    }

    @SuppressLint("Range")
    public String getDisplayName(Uri uri) {
        String displayName = null;

        if ("content".equals(uri.getScheme())) {
            try (Cursor cursor = browserActivity.getContentResolver().query(uri, null, null, null, null)) {
                if (cursor != null && cursor.moveToFirst()) {
                    displayName = cursor.getString(cursor.getColumnIndex("_display_name"));
                }
            } catch (Exception ignored) {
            }
        }

        return displayName;
    }

    public void init(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
    }

    public boolean m3805h() {
        return this.f2377c != null;
    }

    public void m3806i(String str) {
        new ViewOnClickListenerC2109nh(this.browserActivity).m8786b(this.browserActivity.getExternalFilesDir("") + File.separator + str);
    }

    public void m3807j(Uri uri, String str) {
        if (Build.VERSION.SDK_INT >= 26 && !TextUtils.isEmpty(str) && str.equals("application/vnd.android.package-archive") && !this.browserActivity.getPackageManager().canRequestPackageInstalls()) {
            this.browserActivity.installApk(uri);
            return;
        }
        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setFlags(1);
        intent.setDataAndType(uri, str);
        this.browserActivity.startActivity(intent);
    }

    public void m3808k(String str) {
        m3809l(str, null);
    }

    public void m3809l(String str, String str2) {
        if (TextUtils.isEmpty(str2)) {
            str2 = NetworkUtils.getMimeType(str);
        }
        if (TextUtils.isEmpty(str2)) {
            Toast.makeText(this.browserActivity, "Unknown file type", Toast.LENGTH_SHORT).show();
            return;
        }
        if (str2.equals("message/rfc822") || str2.equals("text/html") || str2.equals("text/plain") || str2.startsWith("image/")) {
            this.browserActivity.runOnUiThread(new b(str));
        } else {
            this.browserActivity.startActivity(FileUtils.createViewFileIntent(this.browserActivity, str));
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
                C1199a3.getInstance().m5094e("event_app_to_page", jSONObject);
                if (this.f2376b) {
                    if (zIsDirectory) {
                        FileUtils.deleteRecursively(file);
                    } else {
                        FileUtils.deleteFile(this.f2377c);
                    }
                    C1199a3.getInstance().m5098j("notify_file_deleted", "id", AbstractCryptoUtils.toMd5(this.f2377c));
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
        new ViewOnClickListenerC0847Sa(this.browserActivity).m4034b(str);
    }

    public class a extends ConfirmDialog {

        public final String f2378f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Context context, String str) {
            super(context);
            this.f2378f = str;
        }

        @Override
        public void onOK() {
            FileUtils.deleteRecursively(new File(this.f2378f));
            C1199a3.getInstance().m5098j("notify_file_deleted", "id", AndroidSystemUtils.prefixWithMd5(this.f2378f));
        }

        @Override
        public void onCancel() {
        }
    }
}
