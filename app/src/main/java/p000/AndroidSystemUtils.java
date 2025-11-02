package p000;

import android.content.ActivityNotFoundException;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.pm.PackageManager;
import android.content.pm.ShortcutInfo;
import android.content.pm.ShortcutManager;
import android.content.pm.Signature;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Color;
import android.graphics.drawable.Icon;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.provider.MediaStore;
import android.text.ClipboardManager;
import android.text.TextUtils;
import android.util.Base64;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.core.content.FileProvider;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.searchbox.SuggestionInputAdapter;
import com.xbrowser.play.R;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.DateFormat;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.Locale;
import java.util.UUID;

public abstract class AndroidSystemUtils {

    public static final DecimalFormat sizeFormatter = new DecimalFormat("0.##");

    public static final DecimalFormat twoDigitFormatter = new DecimalFormat("00");

    public static long startTime = 0;

    public static String m8667A(long j) {
        try {
            return new SimpleDateFormat("yyyyMMdd").format(new Date(j));
        } catch (Exception unused) {
            return "2018-01-01 :00:00:00";
        }
    }

    public static String m8668B(long j) {
        try {
            return new SimpleDateFormat("HH:mm").format(new Date(j));
        } catch (Exception unused) {
            return "2018-01-01 :00:00:00";
        }
    }

    public static String getFileNameFromUri(Context context, Uri uri) {
        if ("content".equals(uri.getScheme())) {
            try (Cursor cursorQuery = context.getContentResolver().query(uri, null, null, null, null)) {
                if (cursorQuery != null && cursorQuery.moveToFirst()) {
                    int index = cursorQuery.getColumnIndex("_display_name");
                    if (index != -1) {
                        return cursorQuery.getString(index);
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        String path = uri.getPath();
        if (path == null) return null;
        int lastSlashIndex = path.lastIndexOf('/');
        return lastSlashIndex != -1 ? path.substring(lastSlashIndex + 1) : path;
    }

    public static String getCachedFilePath(Context context, Uri uri) {
        File cacheDir = context.getCacheDir();
        String fileName = getFileNameFromUri(context, uri);

        if (TextUtils.isEmpty(fileName)) {
            return null;
        }

        File file = new File(cacheDir, fileName);
        if (copyUriToFile(context, uri, file) >= 0) {
            return file.getAbsolutePath();
        }

        return null;
    }

    public static Signature[] getAppSignatures(Context context) {
        try {
            return context.getPackageManager()
                    .getPackageInfo(context.getPackageName(), PackageManager.GET_SIGNATURES)
                    .signatures;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    public static String m8672F(Context context, int i) {
        return m8694b(BitmapFactory.decodeResource(context.getResources(), i));
    }

    public static boolean isDefaultBrowser(Context context) {
        IntentFilter intentFilter = new IntentFilter("android.intent.action.VIEW");
        intentFilter.addCategory("android.intent.category.BROWSABLE");
        ArrayList arrayList = new ArrayList<>();
        arrayList.add(intentFilter);
        String packageName = context.getPackageName();
        ArrayList arrayList2 = new ArrayList<>();
        context.getPackageManager().getPreferredActivities(arrayList, arrayList2, packageName);
        Iterator<ComponentName> it = arrayList2.iterator();
        while (it.hasNext()) {
            if (packageName.equals(it.next().getPackageName())) {
                return true;
            }
        }
        return false;
    }

    public static boolean m8674H(C1045Wo c1045Wo, Context context) {
        if (c1045Wo == null || context == null) {
            return false;
        }
        return c1045Wo.m4549f(C1045Wo.m.m4604h()).f7068d > 0 && c1045Wo.m4549f(C1045Wo.m.m4601e()).f7068d <= dpToPx(24, context);
    }

    public static boolean isAppInstalled(Context context, String packageName) {
        try {
            return context.getPackageManager().getPackageInfo(packageName, 0) != null;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }

    public static boolean isWifiConnected(Context context) {
        ConnectivityManager cm = (ConnectivityManager) context.getSystemService(Context.CONNECTIVITY_SERVICE);
        if (cm == null) return false;

        Network activeNetwork = cm.getActiveNetwork();
        if (activeNetwork == null) return false;

        NetworkCapabilities capabilities = cm.getNetworkCapabilities(activeNetwork);
        return capabilities != null
                && capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI);
    }

    /**
     * Starts timing.
     */
    public static void startTiming() {
        startTime = System.currentTimeMillis();
    }

    /**
     * Starts timing and logs a label.
     */
    public static void startTiming(String label) {
        startTime = System.currentTimeMillis();
        Log.i("cost-time", "======== Timing started for: " + label + " ========");
    }

    /**
     * Ends timing and logs the elapsed time.
     */
    public static void logElapsedTime() {
        if (startTime == 0L) {
            Log.i("cost-time", "Warning: startTiming() was not called before logElapsedTime()");
            return;
        }

        long cost = System.currentTimeMillis() - startTime;
        Log.i("cost-time", "Execution time: " + cost + " ms");
        startTime = 0L;
    }

    /**
     * Notify media scanner for a specific file Uri.
     */
    public static void scanMediaFile(Context context, Uri uri) {
        if (uri == null) return;

        Intent intent = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        intent.setData(uri);
        context.sendBroadcast(intent);
    }

    /**
     * Notify media scanner for a file path.
     */
    public static void scanMediaFile(Context context, String filePath) {
        if (filePath == null) return;

        scanMediaFile(context, Uri.fromFile(new File(filePath)));
    }

    public static String normalizeSpaces(String input) {
        if (input == null) return null;

        String trimmed = input.trim();
        StringBuilder sb = new StringBuilder();
        boolean lastWasSpace = false;

        for (char ch : trimmed.toCharArray()) {
            if (!Character.isWhitespace(ch)) {
                sb.append(ch);
                lastWasSpace = false;
            } else if (!lastWasSpace) {
                sb.append(' ');
                lastWasSpace = true;
            }
        }
        return sb.toString();
    }

    public static void saveBitmapToFile(Bitmap bitmap, String filePath) {
        if (bitmap == null || filePath == null) return;

        File file = new File(filePath);

        try {
            // Create parent directory if missing
            File parent = file.getParentFile();
            if (parent != null && !parent.exists()) {
                parent.mkdirs();
            }

            // Create / overwrite file
            try (FileOutputStream out = new FileOutputStream(file)) {
                bitmap.compress(Bitmap.CompressFormat.PNG, 100, out);
                out.flush();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Choose an installed app store package name for the given vendor/key.
     *
     * @param context Android context
     * @param vendor  one of "xiaomi", "mi", "vivo", "yyb", "pp", "oppo",
     *                "huawei", "light_browser", "honor", "baidu", "qihu360",
     *                "qihu", "coolapk", or other. Comparison is case-insensitive.
     * @return package name of an installed app store matching the vendor, or null if none found
     */
    public static String chooseAppStorePackage(Context context, String vendor) {
        // Candidate app store package names in preferred order used as fallback
        final String[] stores = {
                "com.xiaomi.market",               // 0
                "com.coolapk.market",              // 1
                "com.qihoo.appstore",              // 2
                "com.baidu.appsearch",             // 3
                "com.tencent.android.qqdownloader",// 4 (yyb)
                "com.huawei.appmarket",            // 5
                "com.wandoujia.phoenix2",          // 6 (pp)
                "com.android.vending",             // 7 (play)
                "com.hiapk.marketpho",             // 8
                "com.oppo.market",                 // 9
                "com.bbk.appstore",                //10 (vivo)
                "com.hihonor.appmarket"            //11 (honor)
        };

        // Short helper
        String vendorKey = vendor == null ? "" : vendor.trim().toLowerCase();

        // If this flag is set, prefer Play Store if installed (original behavior)
        if (PhoneUtils.getInstance().isGooglePlayChannel()) {
            if (isAppInstalled(context, stores[7])) {
                return stores[7]; // com.android.vending
            }
        }

        switch (vendorKey) {
            case "xiaomi":
            case "mi":
                if (isAppInstalled(context, stores[0])) return stores[0]; // com.xiaomi.market
                break;

            case "vivo":
                if (isAppInstalled(context, stores[10])) return stores[10]; // com.bbk.appstore
                break;

            case "yyb":
                if (isAppInstalled(context, stores[4])) return stores[4]; // com.tencent.android.qqdownloader
                break;

            case "pp":
                if (isAppInstalled(context, stores[6])) return stores[6]; // com.wandoujia.phoenix2
                break;

            case "oppo":
                if (isAppInstalled(context, stores[9])) return stores[9]; // com.oppo.market
                break;

            case "huawei":
            case "light_browser":
                if (isAppInstalled(context, stores[5])) return stores[5];  // com.huawei.appmarket
                if (isAppInstalled(context, stores[11])) return stores[11]; // com.hihonor.appmarket
                break;

            case "honor":
                if (isAppInstalled(context, stores[11])) return stores[11]; // com.hihonor.appmarket
                break;

            case "baidu":
                if (isAppInstalled(context, stores[3])) return stores[3]; // com.baidu.appsearch
                break;

            case "qihu360":
            case "qihu":
                if (isAppInstalled(context, stores[2])) return stores[2]; // com.qihoo.appstore
                break;

            case "coolapk":
                if (isAppInstalled(context, stores[1])) return stores[1]; // com.coolapk.market
                break;

            default:
                // fall through to fallback loop
                break;
        }

        // Fallback: return the first installed store from the preferred list
        for (String pkg : stores) {
            if (isAppInstalled(context, pkg)) return pkg;
        }

        // nothing found
        return null;
    }

    public static void shareFile(@NonNull Context context, @NonNull Uri uri) {
        Intent shareIntent = new Intent(Intent.ACTION_SEND);
        shareIntent.setType("*/*");
        shareIntent.putExtra(Intent.EXTRA_STREAM, uri);
        shareIntent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);

        String chooserTitle = context.getString(R.string.choose_app);
        Intent chooser = Intent.createChooser(shareIntent, chooserTitle);

        // Always wrap startActivity in a try/catch to avoid ActivityNotFoundException
        try {
            context.startActivity(chooser);
        } catch (ActivityNotFoundException e) {
            Toast.makeText(context, R.string.no_app_found, Toast.LENGTH_SHORT).show();
        }
    }

    public static final void m8686T(Context context, String str) {
        try {
            context.startActivity(Intent.createChooser(FileUtils.createShareFileIntent(context, str), context.getResources().getString(R.string.choose_app)));
        } catch (Exception e) {
            e.printStackTrace();
            Toast.makeText(context, "send to failed", Toast.LENGTH_LONG).show();
        }
    }

    public static void m8687U(BrowserActivity browserActivity, boolean z) {
        if (!z) {
            m8695c(browserActivity);
            return;
        }
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.WEB_SEARCH");
            intent.putExtra("query", "xbrowser");
            intent.setComponent(Build.VERSION.SDK_INT >= 29 ? new ComponentName("com.android.permissioncontroller", "com.android.permissioncontroller.role.ui.DefaultAppListActivity") : new ComponentName("android", "com.android.internal.app.ResolverActivity"));
            browserActivity.startActivity(intent);
        } catch (Exception unused) {
            Toast.makeText(browserActivity, "Set as default Browser failed", Toast.LENGTH_SHORT).show();
            browserActivity.m6361u0("updateToggleOStatus('#set-as-default-browser',false);");
        }
    }

    public static final void m8688V(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.putExtra("android.intent.extra.STREAM", uri);
        intent.setFlags(1);
        intent.setType(str);
        try {
            context.startActivity(Intent.createChooser(intent, null));
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static final void m8689W(Context context, String str, String str2, String str3, String str4) {
        m8690X(context, str, str2, str3, str4, null, null);
    }

    public static final void m8690X(Context context, String str, String str2, String str3, String str4, String str5, String str6) {
        Intent intentM4223g;
        if (TextUtils.isEmpty(str5)) {
            intentM4223g = new Intent("android.intent.action.SEND");
            intentM4223g.putExtra("android.intent.extra.TEXT", str + " \n" + str2);
            intentM4223g.putExtra("android.intent.extra.SUBJECT", str);
            if (str6 == null) {
                intentM4223g.setType("text/plain");
            } else {
                intentM4223g.setType(str6);
            }
        } else {
            intentM4223g = FileUtils.createShareFileIntent(context, str5);
        }
        try {
            context.startActivity(Intent.createChooser(intentM4223g, str4));
        } catch (ActivityNotFoundException unused) {
        }
    }

    public static String m8691Y(InputStream inputStream) throws IOException {
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            byte[] bArr = new byte[1024];
            while (true) {
                int i = inputStream.read(bArr);
                if (i == -1) {
                    byteArrayOutputStream.flush();
                    inputStream.close();
                    return byteArrayOutputStream.toString();
                }
                byteArrayOutputStream.write(bArr, 0, i);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static long getMemoryUsed() {
        long result = Runtime.getRuntime().totalMemory() - Runtime.getRuntime().freeMemory();
        Log.i("use-mem", ">>>>>>>>>> total use memory: " + result);
        return result;
    }

    public static final void m8693a(Context context, Uri uri, String str) {
        Intent intent = new Intent("android.intent.action.SEND");
        intent.setFlags(1);
        intent.setType(str);
        intent.putExtra("android.intent.extra.STREAM", uri);
        context.startActivity(Intent.createChooser(intent, context.getResources().getString(R.string.choose_app)));
    }

    public static String m8694b(Bitmap bitmap) {
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.PNG, 100, byteArrayOutputStream);
        return "data:image/png;base64," + Base64.encodeToString(byteArrayOutputStream.toByteArray(), 2);
    }

    public static void m8695c(Context context) {
        context.getPackageManager().clearPackagePreferredActivities(context.getPackageName());
    }

    public static String m8696d(int i) {
        StringBuffer stringBuffer = new StringBuffer();
        String hexString = Integer.toHexString(Color.red(i));
        String hexString2 = Integer.toHexString(Color.green(i));
        String hexString3 = Integer.toHexString(Color.blue(i));
        if (hexString.length() == 1) {
            hexString = "0" + hexString;
        }
        if (hexString2.length() == 1) {
            hexString2 = "0" + hexString2;
        }
        if (hexString3.length() == 1) {
            hexString3 = "0" + hexString3;
        }
        stringBuffer.append("#");
        stringBuffer.append(hexString);
        stringBuffer.append(hexString2);
        stringBuffer.append(hexString3);
        return stringBuffer.toString();
    }

    public static int copyUriToFile(Context context, Uri uri, File file) {
        try (InputStream inputStream = context.getContentResolver().openInputStream(uri);
             FileOutputStream outputStream = new FileOutputStream(file)) {

            if (inputStream == null) {
                return -1;
            }

            copyStream(inputStream, outputStream);
            return 0;

        } catch (Exception e) {
            return -1;
        }
    }

    public static void m8698f(Context context, String str, Uri uri) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            OutputStream outputStreamOpenOutputStream = context.getContentResolver().openOutputStream(uri);
            copyStream(fileInputStream, outputStreamOpenOutputStream);
            fileInputStream.close();
            outputStreamOpenOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void m8699g(String str, String str2) throws IOException {
        try {
            FileInputStream fileInputStream = new FileInputStream(str);
            FileOutputStream fileOutputStream = new FileOutputStream(str2);
            copyStream(fileInputStream, fileOutputStream);
            fileInputStream.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static int copyStream(InputStream inputStream, OutputStream outputStream) throws IOException {
        byte[] buffer = new byte[2048];
        int totalBytes = 0;

        try (BufferedInputStream bis = new BufferedInputStream(inputStream, buffer.length);
             BufferedOutputStream bos = new BufferedOutputStream(outputStream, buffer.length)) {

            int bytesRead;
            while ((bytesRead = bis.read(buffer)) != -1) {
                bos.write(buffer, 0, bytesRead);
                totalBytes += bytesRead;
            }
            bos.flush();
        }

        return totalBytes;
    }

    public static final void m8701i(Context context, CharSequence charSequence) {
        ClipboardManager clipboardManager = (ClipboardManager) context.getSystemService(Context.CLIPBOARD_SERVICE);
        if (clipboardManager != null) {
            clipboardManager.setText(charSequence);
        }
        if (TextUtils.isEmpty(charSequence) || charSequence.length() > 512) {
            return;
        }
        SuggestionInputAdapter.firstUrl = charSequence;
    }

    public static void m8702j(String str) {
        File file = new File(str);
        if (file.exists()) {
            return;
        }
        file.mkdirs();
    }

    public static Uri m8703k(Context context, String str, String str2, String str3) {
        try {
            if (TextUtils.isEmpty(str2) || str2.equals("application/octet-stream")) {
                str2 = NetworkUtils.getMimeType(str);
            } else if (str2.indexOf("gif") >= 0) {
                str2 = "image/gif";
            }
            if (str2.indexOf("image/") < 0) {
                str2 = "image/png";
            }
            ContentResolver contentResolver = context.getContentResolver();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put("relative_path", Environment.DIRECTORY_PICTURES + "/" + str3);
            return contentResolver.insert(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, contentValues);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }

    public static Uri m8704l(Context context, String str, String str2, String str3) {
        return m8705m(context, str, str2, str3, false);
    }

    public static Uri m8705m(Context context, String str, String str2, String str3, boolean z) {
        Uri uriInsert;
        Uri uri = MediaStore.Downloads.EXTERNAL_CONTENT_URI;
        try {
            ContentResolver contentResolver = context.getContentResolver();
            long jCurrentTimeMillis = System.currentTimeMillis();
            ContentValues contentValues = new ContentValues();
            contentValues.put("_display_name", str);
            contentValues.put("mime_type", str2);
            contentValues.put("datetaken", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("date_added", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("date_modified", Long.valueOf(jCurrentTimeMillis));
            contentValues.put("relative_path", Environment.DIRECTORY_DOWNLOADS + File.separator + str3);
            Cursor cursorQuery = contentResolver.query(uri, null, "_display_name=?", new String[]{str}, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst() || z) {
                uriInsert = contentResolver.insert(uri, contentValues);
            } else {
                uriInsert = ContentUris.withAppendedId(uri, cursorQuery.getLong(cursorQuery.getColumnIndex("_id")));
                cursorQuery.close();
            }
            return uriInsert;
        } catch (Exception unused) {
            return null;
        }
    }

    public static void m8706n(Context context, String str, String str2, Bitmap bitmap) {
        BrowserActivity.getActivity().m6273W();
        int i = Build.VERSION.SDK_INT;
        if (i >= 25) {
            Intent intent = new Intent(context, (Class<?>) BrowserActivity.class);
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse(str2));
            ShortcutInfo shortcutInfoBuild = AbstractC2038m1.m8432a(context, str2).setShortLabel(str).setLongLabel(str).setIcon(Icon.createWithBitmap(bitmap)).setIntent(intent).build();
            ShortcutManager shortcutManagerM8096a = AbstractC1899j1.m8096a(context.getSystemService(AbstractC1853i1.m7863a()));
            if (i >= 26) {
                shortcutManagerM8096a.requestPinShortcut(shortcutInfoBuild, null);
            }
        } else {
            Intent intent2 = new Intent(context, (Class<?>) BrowserActivity.class);
            intent2.setAction("android.intent.action.VIEW");
            intent2.setData(Uri.parse(str2));
            intent2.addFlags(268435456);
            intent2.addFlags(67108864);
            intent2.putExtra("duplicate", false);
            Intent intent3 = new Intent();
            intent3.putExtra("android.intent.extra.shortcut.INTENT", intent2);
            intent3.putExtra("android.intent.extra.shortcut.NAME", str);
            intent3.putExtra("android.intent.extra.shortcut.ICON", bitmap);
            intent3.setAction("com.android.launcher.action.INSTALL_SHORTCUT");
        }
        Toast.makeText(context, R.string.toast_send_shortcut_to_launcher, Toast.LENGTH_SHORT).show();
    }

    public static Uri createTempFileUri(Context context, String extension) {
        String timestamp = new SimpleDateFormat("yyyyMMdd_HHmmss", Locale.getDefault()).format(new Date());
        try {
            return FileProvider.getUriForFile(context, context.getPackageName() + ".fileProvider", File.createTempFile("TEMP_" + timestamp + "_", NetworkUtils.getExtensionFromMime(extension), new File(PhoneUtils.getInstance().getCacheDirPath())));
        } catch (Exception unused) {
            return null;
        }
    }

    public static Bitmap m8708p(String str) {
        byte[] bArrDecode = Base64.decode(str.split(",")[1], 0);
        return BitmapFactory.decodeByteArray(bArrDecode, 0, bArrDecode.length);
    }

    public static int dpToPx(int dp, Context context) {
        return Math.round(dp * context.getResources().getDisplayMetrics().density);
    }

    public static String m8710r(long j) {
        String str = (j / 60000) + "";
        String str2 = ((j % 60000) / 1000) + "";
        if (str.length() < 2) {
            str = 0 + str;
        }
        if (str2.length() < 2) {
            str2 = 0 + str2;
        }
        return str + ":" + str2;
    }

    public static String formatFileSize(long bytes) {
        if (bytes < 0) {
            return "--";
        }

        StringBuilder result = new StringBuilder();
        String unit;

        if (bytes < 1024) {
            result.append(bytes);
            unit = "B";
        } else if (bytes < 1048576) { // < 1 MB
            result.append(sizeFormatter.format(bytes / 1024.0d));
            unit = " KB";
        } else if (bytes < 1073741824) { // < 1 GB
            result.append(sizeFormatter.format(bytes / 1048576.0d));
            unit = " MB";
        } else { // ≥ 1 GB
            result.append(sizeFormatter.format(bytes / 1.073741824E9d));
            unit = " GB";
        }

        result.append(unit);
        return result.toString();
    }

    public static String m8712t(long j) {
        StringBuilder sb = new StringBuilder();
        sb.append(twoDigitFormatter.format((int) (j / 60)));
        sb.append(":");
        sb.append(twoDigitFormatter.format((int) (j % 60)));
        return sb.toString();
    }

    public static String m8713u() {
        return "_" + UUID.randomUUID().toString();
    }

    public static String prefixWithMd5(String str) {
        return "_" + AbstractCryptoUtils.toMd5(str);
    }

    public static int m8715w(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] - 0.1f;
        fArr[2] = fArr[2] + 0.1f;
        return Color.HSVToColor(fArr);
    }

    public static int m8716x(int i) {
        float[] fArr = new float[3];
        Color.colorToHSV(i, fArr);
        fArr[1] = fArr[1] + 0.1f;
        fArr[2] = fArr[2] - 0.1f;
        return Color.HSVToColor(fArr);
    }

    public static String m8717y(Context context, long j) {
        try {
            GregorianCalendar gregorianCalendar = new GregorianCalendar();
            long timeInMillis = gregorianCalendar.getTimeInMillis();
            long timeInMillis2 = gregorianCalendar.getTimeInMillis() - 86400000;
            long timeInMillis3 = gregorianCalendar.getTimeInMillis() - 172800000;
            Date date = new Date(j);
            String str = DateFormat.getDateInstance(0).format(Long.valueOf(j));
            SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd");
            String str2 = simpleDateFormat.format(new Date(timeInMillis));
            String str3 = simpleDateFormat.format(new Date(timeInMillis2));
            String str4 = simpleDateFormat.format(new Date(timeInMillis3));
            String str5 = simpleDateFormat.format(date);
            return str5.equals(str2) ? context.getString(R.string.str_today) : str5.equals(str3) ? context.getString(R.string.str_yesterday) : str5.equals(str4) ? context.getString(R.string.str_the_day_before_yes) : str;
        } catch (Exception unused) {
            return "2018-01-01 :00:00:00";
        }
    }

    public static String m8718z(long j) {
        try {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(j));
        } catch (Exception unused) {
            return "2018-01-01 :00:00:00";
        }
    }
}
