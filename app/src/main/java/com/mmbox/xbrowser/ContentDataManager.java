package com.mmbox.xbrowser;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;
import android.os.Build;
import android.os.Environment;
import android.os.Looper;
import android.os.MessageQueue;
import android.text.TextUtils;
import android.util.Log;
import android.widget.Toast;

import com.mmbox.widget.messagebox.MessageBoxManager;
import com.mmbox.widget.messagebox.MessageBoxBase;
import com.mmbox.xbrowser.provider.BrowserProvider;
import com.xbrowser.play.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.OutputStream;
import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.regex.Pattern;

import okhttp3.OkHttpClient;
import p000.NetworkUtils;
import p000.AbstractC0168Dk;
import p000.JsonUtils;
import p000.FileUtils;
import p000.AbstractC1807h2;
import p000.AndroidSystemUtils;
import p000.AbstractCryptoUtils;
import p000.C0122Ck;
import p000.ResourceCacheManager;
import p000.C0490Kk;
import p000.ApiEndpointsManager;
import p000.C0716Pg;
import p000.C0801Ra;
import p000.C1089Xm;
import p000.C1199a3;
import p000.PhoneUtils;
import p000.C2439uo;
import p000.DatabaseColumns;
import p000.InterfaceC0418J3;
import p000.InterfaceC0556M3;
import p000.MySQLiteOpenHelper;

public class ContentDataManager {

    public static ContentDataManager instance;

    public final HashMap urlRulesMap = new HashMap<>();

    public final HashMap blacklistMap = new HashMap<>();

    public final HashMap elementRulesMap = new HashMap<>();

    public final HashMap userMarkedRulesMap = new HashMap<>();

    public final ArrayList regularRulesList = new ArrayList<>(3);

    public final ArrayList urlPatternsList = new ArrayList<>(3);

    public String currentDomain = "";

    public final ArrayList globalWhitelistHosts = new ArrayList<>(5);

    public final ArrayList localWhitelistHosts = new ArrayList<>(5);

    public final HashMap hostExceptionsMap = new HashMap<>();

    public final HashMap whitelistedRulesMap = new HashMap<>();

    public final HashMap tempStorageMap = new HashMap<>();

    public final ArrayList<Rule> ruleFilesList = new ArrayList<>(2);

    public String lastProcessedUrl = null;

    public int currentSessionBlocked = 0;

    public int tempCounter = 0;

    public final ArrayList whitelistedDomains = new ArrayList<>(3);

    public boolean rulesModified = false;

    public BrowserActivity browserActivity = null;

    public int currentPageBlockedCount = 0;

    public int totalBlockedCount = 0;

    public class RuleFileProcessor implements Runnable {

        public class RuleComparator implements Comparator<Rule> {
            @Override
            public int compare(Rule ruleVar, Rule ruleVar2) {
                long j = ruleVar.lastModified;
                long j2 = ruleVar2.lastModified;
                if (j > j2) {
                    return 1;
                }
                return j == j2 ? 0 : -1;
            }
        }

        public class URLCheckerRunnable implements Runnable {
            public URLCheckerRunnable() {
            }

            @Override
            public void run() {
                String strM6234M0 = ContentDataManager.this.browserActivity.m6234M0();
                if (TextUtils.isEmpty(strM6234M0)) {
                    return;
                }
                strM6234M0.startsWith("x:adb");
            }
        }

        public RuleFileProcessor() {
        }

        @Override
        public void run() throws Throwable {
            try {
                Collections.sort(ContentDataManager.this.ruleFilesList, new RuleComparator());
                Iterator it = ContentDataManager.this.ruleFilesList.iterator();
                while (it.hasNext()) {
                    Rule ruleVar = (Rule) it.next();
                    if (ruleVar.status != 3) {
                        if (TextUtils.isEmpty(ruleVar.fileName) || !FileUtils.fileExists(ruleVar.fileName)) {
                            ContentDataManager.this.m6586Q(ruleVar);
                        } else {
                            ContentDataManager.this.m6573J0(ruleVar);
                            ContentDataManager.this.browserActivity.runOnUiThread(new URLCheckerRunnable());
                        }
                    }
                }
                ContentDataManager.this.m6575K0();
                ContentDataManager.this.m6569H0();
            } catch (Exception unused) {
            }
        }
    }

    public class RuleSharingCallback implements InterfaceC0556M3 {

        public class SuccessMessageRunnable implements Runnable {

            public class ShareMessageBoxListener implements MessageBoxBase.MessageBoxListener {
                public ShareMessageBoxListener() {
                }

                @Override
                public void onShown() throws URISyntaxException {
                    BrowserActivity.getActivity().m6307d2(ApiEndpointsManager.getInstance().getShareAdRulesEndpoint() + "&filter=new");
                }

                @Override
                public void onDismissed() {
                }

                @Override
                public void onDismiss() {
                }
            }

            public SuccessMessageRunnable() {
            }

            @Override
            public void run() {
                MessageBoxManager.getInstance().showMessageWithDescription(BrowserActivity.getActivity().getBrowserFrameLayout(), BrowserActivity.getActivity().getString(R.string.toast_post_rule_source_success), BrowserActivity.getActivity().getString(R.string.btn_text_view), new ShareMessageBoxListener(), false);
            }
        }

        public RuleSharingCallback() {
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) {
            String strM2399p = c0490Kk.m2399p("Content-Type");
            if (strM2399p == null || strM2399p.indexOf("application/json") < 0) {
                return;
            }
            try {
                int i = new JSONObject(c0490Kk.m2392a().m2714l()).getInt("status");
                if (i == 1) {
                    BrowserActivity.getActivity().runOnUiThread(new SuccessMessageRunnable());
                } else if (i == 0) {
                    BrowserActivity.getActivity().m6256R2(BrowserActivity.getActivity().getString(R.string.toast_share_rule_source_exist));
                }
            } catch (JSONException unused) {
            } catch (Throwable th) {
                c0490Kk.m2392a().close();
                throw th;
            }
            c0490Kk.m2392a().close();
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) {
            BrowserActivity.getActivity().m6256R2("Netwrok error!");
        }
    }

    public class UIUpdateRunnable implements Runnable {
        public UIUpdateRunnable() {
        }

        @Override
        public void run() {
            ContentDataManager.this.browserActivity.m6300c0();
        }
    }

    public class RuleCountToastRunnable implements Runnable {

        public final Rule rule;

        public RuleCountToastRunnable(Rule ruleVar) {
            this.rule = ruleVar;
        }

        @Override
        public void run() {
            if (ContentDataManager.this.browserActivity.m6234M0().startsWith("x:rf")) {
                Toast.makeText(ContentDataManager.this.browserActivity, String.format(ContentDataManager.this.browserActivity.getString(R.string.toast_number_of_rules), Integer.valueOf(this.rule.numberRules)), Toast.LENGTH_SHORT).show();
            }
        }
    }

    public class PatternComparator implements Comparator {
        public PatternComparator() {
        }

        @Override
        public int compare(PatternMatcher kVar, PatternMatcher kVar2) {
            boolean z = kVar.isImportant;
            if (!z || kVar2.isImportant) {
                return (!kVar2.isImportant || z) ? 0 : 1;
            }
            return -1;
        }
    }

    public class InitializationHandler implements MessageQueue.IdleHandler {

        public class InitializationTask implements Runnable {
            public InitializationTask() {
            }

            @Override
            public void run() throws Throwable {
                ContentDataManager.this.m6615f1();
                ContentDataManager.this.m6645t0();
                ContentDataManager.this.m6566G();
                ContentDataManager.this.m6567G0();
                ContentDataManager.this.totalBlockedCount = SharedPreferencesHelper.getInstance().getInt("number_of_blocked", 0);
                ContentDataManager.this.m6577L0();
                if (SharedPreferencesHelper.getInstance().activeAdBlock) {
                    ContentDataManager.this.m6565F0();
                    ContentDataManager.this.m6571I0();
                }
            }
        }

        public InitializationHandler() {
        }

        @Override
        public boolean queueIdle() {
            AbstractC1807h2.m7778a(new InitializationTask());
            return false;
        }
    }

    public class EmptyRuleCallback implements RuleOperationCallback {
        public EmptyRuleCallback() {
        }

        @Override
        public void mo6660a(Rule ruleVar) {
        }
    }

    public class RuleDownloadCallback implements InterfaceC0556M3 {

        public final Rule rule;

        public final RuleOperationCallback callback;

        public RuleDownloadCallback(Rule ruleVar, RuleOperationCallback iVar) {
            this.rule = ruleVar;
            this.callback = iVar;
        }

        @Override
        public void mo1180a(InterfaceC0418J3 interfaceC0418J3, C0490Kk c0490Kk) throws JSONException {
            try {
                try {
                    if (c0490Kk.m2399p("Content-Type").indexOf("text/") >= 0) {
                        FileUtils.writeBytesToFile(c0490Kk.m2392a().m2709b(), ResourceCacheManager.getInstance().m2046a(this.rule.sourceUrl, 1));
                        ContentDataManager.this.m6632o0(this.rule);
                        ContentDataManager.this.m6596V0(this.rule);
                        this.rule.status = 0;
                        ContentDataManager.this.m6619h1();
                    } else {
                        this.rule.status = -3;
                    }
                    c0490Kk.m2392a().close();
                    RuleOperationCallback iVar = this.callback;
                    if (iVar != null) {
                        iVar.mo6660a(this.rule);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                    this.rule.status = -3;
                    c0490Kk.m2392a().close();
                    RuleOperationCallback iVar2 = this.callback;
                    if (iVar2 != null) {
                        iVar2.mo6660a(this.rule);
                    }
                    if (this.rule.status == 0) {
                    }
                }
                if (this.rule.status == 0) {
                    ContentDataManager.this.m6600X0();
                    ContentDataManager.this.m6585P0(this.rule);
                }
                ContentDataManager.this.m6583O0(this.rule);
            } catch (Throwable th) {
                c0490Kk.m2392a().close();
                RuleOperationCallback iVar3 = this.callback;
                if (iVar3 != null) {
                    iVar3.mo6660a(this.rule);
                }
                if (this.rule.status == 0) {
                    ContentDataManager.this.m6600X0();
                    ContentDataManager.this.m6585P0(this.rule);
                }
                ContentDataManager.this.m6583O0(this.rule);
                throw th;
            }
        }

        @Override
        public void mo1181b(InterfaceC0418J3 interfaceC0418J3, IOException iOException) throws JSONException {
            Rule ruleVar = this.rule;
            ruleVar.status = -2;
            ContentDataManager.this.m6583O0(ruleVar);
        }
    }

    public interface RuleOperationCallback {
        void mo6660a(Rule ruleVar);
    }

    public static class Rule {

        public String updateAt;

        public String fileName;

        public String title;

        public int numberRules;

        public int source;

        public long lastModified;

        public String size;

        public boolean active = true;

        public int status;

        public String hash;

        public String sourceUrl;
    }

    public class PatternMatcher {

        public Pattern pattern = null;

        public String domain;

        public String ruleText;

        public String processedPattern;

        public String originalPattern;

        public int thirdPartyOption;

        public boolean isRegex;

        public boolean isImportant;

        /* JADX WARN: Code restructure failed: missing block: B:18:0x0058, code lost:
        
            if (r0 > 0) goto L15;
         */
        /* JADX WARN: Removed duplicated region for block: B:21:0x005d  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x0064  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public PatternMatcher(String r5, boolean r6, boolean r7) {
            /*
                r3 = this;
                com.mmbox.xbrowser.ContentDataManager.this = r4
                r3.<init>()
                r4 = 0
                r3.pattern = r4
                r3.domain = r4
                r3.processedPattern = r4
                r4 = 0
                r3.thirdPartyOption = r4
                r3.ruleText = r5
                r3.originalPattern = r5
                r3.isRegex = r6
                r3.isImportant = r7
                java.lang.String r7 = "@"
                int r7 = r5.indexOf(r7)
                java.lang.String r0 = "$3p"
                int r0 = r5.indexOf(r0)
                r1 = 2
                if (r0 <= 0) goto L2a
                r2 = 1
                r3.thirdPartyOption = r2
                goto L34
            L2a:
                java.lang.String r0 = "$~3p"
                int r0 = r5.indexOf(r0)
                if (r0 <= 0) goto L34
                r3.thirdPartyOption = r1
            L34:
                if (r7 <= 0) goto L58
                if (r0 <= 0) goto L43
                if (r0 <= r7) goto L43
                int r2 = r7 + 1
                java.lang.String r2 = r5.substring(r2, r0)
            L40:
                r3.domain = r2
                goto L4a
            L43:
                int r2 = r7 + 1
                java.lang.String r2 = r5.substring(r2)
                goto L40
            L4a:
                if (r0 <= 0) goto L53
            L4c:
                java.lang.String r4 = r5.substring(r4, r0)
            L50:
                r3.originalPattern = r4
                goto L5b
            L53:
                java.lang.String r4 = r5.substring(r4, r7)
                goto L50
            L58:
                if (r0 <= 0) goto L5b
                goto L4c
            L5b:
                if (r6 == 0) goto L64
                java.lang.String r4 = r5.substring(r1)
            L61:
                r3.processedPattern = r4
                goto L6b
            L64:
                java.lang.String r4 = r3.originalPattern
                java.lang.String r4 = r3.m6663c(r4)
                goto L61
            L6b:
                return
            */
            throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.PatternMatcher.<init>(com.mmbox.xbrowser.ContentDataManager, java.lang.String, boolean, boolean):void");
        }

        public boolean m6661a() {
            try {
                this.f4600a = Pattern.compile(this.f4603d);
                return true;
            } catch (Exception unused) {
                return false;
            }
        }

        public boolean m6662b(String str) {
            return this.f4600a.matcher(str).find();
        }

        public final String m6663c(String str) {
            return str.replaceAll("\\.", "\\\\.").replaceAll("\\-", "\\\\-").replaceAll("\\[", "\\\\[").replaceAll("\\]", "\\\\]").replaceAll("\\*", ".*").replaceAll("\\{", "\\\\{").replaceAll("\\}", "\\\\}").replaceAll("\\?", "\\\\?").replaceAll("\\|", "\\\\|");
        }

        public boolean equals(Object obj) {
            return obj instanceof k ? this.f4602c.equals(((k) obj).f4602c) : super.equals(obj);
        }
    }

    public static int m6536S(String str, int i2) {
        int i3 = 0;
        while (i2 < str.length()) {
            char cCharAt = str.charAt(i2);
            if (cCharAt == '[') {
                i3++;
            } else if (cCharAt == ']') {
                i3--;
            } else if (cCharAt == ',' && i3 == 0) {
                return i2;
            }
            i2++;
        }
        return -1;
    }

    public static ContentDataManager getInstance() {
        if (instance == null) {
            instance = new ContentDataManager();
        }
        return instance;
    }

    public final void m6554A(String str, boolean z) {
        if (m6614f0(str) == null) {
            if (str.indexOf("examplecode/ad-rules-for-xbrowser") <= 0 || m6593U() == null) {
                Rule ruleVar = new Rule();
                ruleVar.sourceUrl = str;
                ruleVar.active = z;
                this.ruleFilesList.add(ruleVar);
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x004f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean m6555A0(String r10, String r11, String r12, String r13, boolean r14) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        /*
            r9 = this;
            java.lang.System.currentTimeMillis()
            java.lang.String r1 = r9.m6592T0(r11)
            r3 = 0
            r4 = r3
        L9:
            java.util.ArrayList r5 = r9.f4556e
            int r5 = r5.size()
            if (r4 >= r5) goto L86
            java.util.ArrayList r5 = r9.f4556e
            java.lang.Object r5 = r5.get(r4)
            com.mmbox.xbrowser.ContentDataManager$PatternMatcher r5 = (com.mmbox.xbrowser.ContentDataManager.PatternMatcher) r5
            java.lang.String r6 = r5.ruleText
            java.lang.String r7 = "3p"
            int r6 = r6.indexOf(r7)
            if (r6 < 0) goto L24
            goto L2b
        L24:
            java.lang.String r6 = r5.f4602c
            java.lang.String r7 = "~3p"
            r6.indexOf(r7)
        L2b:
            java.lang.String r6 = r5.f4604e
            boolean r6 = r9.m6561D0(r11, r6)
            if (r6 != 0) goto L34
            goto L83
        L34:
            boolean r6 = r5.f4607h
            if (r14 == r6) goto L39
            goto L83
        L39:
            int r6 = r5.f4605f
            r7 = 1
            if (r6 != r7) goto L45
            boolean r6 = r12.equals(r13)
            if (r6 == 0) goto L4f
            goto L83
        L45:
            r8 = 2
            if (r6 != r8) goto L4f
            boolean r6 = r12.equals(r13)
            if (r6 != 0) goto L4f
            goto L83
        L4f:
            java.lang.String r6 = r5.f4602c
            boolean r6 = r9.m6649v0(r6)
            if (r6 != 0) goto L58
            goto L83
        L58:
            java.lang.String r6 = p000.AbstractC0115Cd.m458m(r12)
            java.lang.String r8 = r5.f4601b
            if (r8 == 0) goto L6f
            boolean r6 = r8.equals(r6)
            if (r6 != 0) goto L6f
            java.lang.String r6 = r5.f4601b
            boolean r6 = r6.equals(r12)
            if (r6 != 0) goto L6f
            goto L83
        L6f:
            boolean r6 = r5.m6662b(r1)
            if (r6 == 0) goto L83
            if (r14 != 0) goto L82
            java.lang.String r4 = r5.f4602c
            r5 = 31
            r0 = r9
            r1 = r10
            r2 = r11
            r3 = r12
            r0.m6579M0(r1, r2, r3, r4, r5)
        L82:
            return r7
        L83:
            int r4 = r4 + 1
            goto L9
        L86:
            java.lang.System.currentTimeMillis()
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.m6555A0(java.lang.String, java.lang.String, java.lang.String, java.lang.String, boolean):boolean");
    }

    public final void m6556B(String str) {
        String strSubstring;
        ArrayList arrayList;
        int iIndexOf = str.indexOf(124);
        if (iIndexOf == 0) {
            if (this.urlPatternsList.contains(str.substring(1))) {
                return;
            }
            arrayList = this.urlPatternsList;
            strSubstring = str.substring(1);
        } else {
            if (iIndexOf != str.length() - 1) {
                return;
            }
            strSubstring = str.substring(0, iIndexOf);
            if (this.urlPatternsList.contains(strSubstring)) {
                return;
            } else {
                arrayList = this.urlPatternsList;
            }
        }
        arrayList.add(strSubstring);
    }

    public final boolean m6557B0(String str, String str2, String str3, String str4, int i2, boolean z) {
        return false;
    }

    public final void m6558C(String str) {
        String strSubstring = str.substring(2);
        int iIndexOf = strSubstring.indexOf(64);
        if (iIndexOf <= 0) {
            for (String str2 : strSubstring.split(",")) {
                if (!this.globalWhitelistHosts.contains(str2)) {
                    this.globalWhitelistHosts.add(str2);
                }
            }
            return;
        }
        String strSubstring2 = strSubstring.substring(iIndexOf + 1);
        String strSubstring3 = strSubstring.substring(0, iIndexOf);
        if (TextUtils.isEmpty(strSubstring2)) {
            return;
        }
        String str3 = (String) this.hostExceptionsMap.get(strSubstring2);
        if (!TextUtils.isEmpty(str3)) {
            if (str3.indexOf(strSubstring3) >= 0) {
                return;
            }
            strSubstring3 = str3 + "," + strSubstring3;
        }
        this.hostExceptionsMap.put(strSubstring2, strSubstring3);
    }

    public final boolean m6559C0(String str, String str2, String str3, String str4, int i2, boolean z) {
        StringBuilder sb;
        String str5;
        StringBuilder sb2;
        str2.indexOf("pornhub.com");
        if (m6655y0(str, str2, str3, str4, i2)) {
            return true;
        }
        if (m6655y0(str, str2, str3 + "@" + str2, str4, i2)) {
            return true;
        }
        StringBuilder sb3 = new StringBuilder();
        String strM458m = NetworkUtils.getFileExtension(str2);
        sb3.append(str3);
        sb3.append("@");
        sb3.append(strM458m);
        if (m6655y0(str, str2, sb3.toString(), str4, i2)) {
            return true;
        }
        if (z) {
            sb = new StringBuilder();
            sb.append(str3);
            sb.append("@");
            sb.append(str2);
            str5 = "$3p";
            sb.append("$3p");
            if (m6655y0(str, str2, sb.toString(), str4, i2)) {
                return true;
            }
            sb2 = new StringBuilder();
        } else {
            sb = new StringBuilder();
            sb.append(str3);
            sb.append("@");
            sb.append(str2);
            str5 = "$~3p";
            sb.append("$~3p");
            if (m6655y0(str, str2, sb.toString(), str4, i2)) {
                return true;
            }
            sb2 = new StringBuilder();
        }
        sb2.append(str3);
        sb2.append(str5);
        return m6655y0(str, str2, sb2.toString(), str4, i2);
    }

    public void m6560D(String str) {
        this.whitelistedDomains.add(str);
    }

    public final boolean m6561D0(String str, String str2) {
        int iIndexOf = str2.indexOf("$");
        if (iIndexOf > 0) {
            str2 = str2.substring(0, iIndexOf);
        }
        int length = str2.length();
        int i2 = 0;
        int length2 = 0;
        while (i2 < length) {
            char cCharAt = str2.charAt(i2);
            if (cCharAt == '*' || cCharAt == '@') {
                i2++;
            } else {
                int i3 = i2;
                while (i3 < length && str2.charAt(i3) != '*' && str2.charAt(i3) != '@') {
                    i3++;
                }
                String strSubstring = str2.substring(i2, i3);
                int iIndexOf2 = str.indexOf(strSubstring, length2);
                if (iIndexOf2 == -1) {
                    return false;
                }
                length2 = iIndexOf2 + strSubstring.length();
                i2 = i3;
            }
        }
        return true;
    }

    public final void m6562E(String str, String str2) {
        ArrayList arrayList = (ArrayList) this.elementRulesMap.get(str);
        if (arrayList == null) {
            arrayList = new ArrayList<>(3);
        }
        int i2 = 0;
        while (i2 < str2.length()) {
            int iM6536S = m6536S(str2, i2);
            if (iM6536S == -1) {
                iM6536S = str2.length();
            }
            String strTrim = str2.substring(i2, iM6536S).trim();
            if (!arrayList.contains(strTrim)) {
                arrayList.add(strTrim);
            }
            i2 = iM6536S + 1;
        }
        this.elementRulesMap.put(str, arrayList);
    }

    public final void m6563E0() {
        Looper.myQueue().addIdleHandler(new InitializationHandler());
    }

    public final void m6564F(Rule rule) {
        if (rule != null) {
            if (TextUtils.isEmpty(rule.fileName) || !FileUtils.fileExists(rule.fileName) || FileUtils.getFileSize(rule.fileName) == 0) {
                if (TextUtils.isEmpty(rule.sourceUrl) || !rule.sourceUrl.startsWith("http")) {
                    return;
                }
                Log.i("ad-block", ">>>>>>>>> call check file >>>>>>>>>>>>>>>>>>>>");
                if (rule.status == 3 || !rule.active) {
                    return;
                }
            } else if (rule.status == 0) {
                if (SharedPreferencesHelper.getInstance().adRuleUpdateCircle == 0) {
                    m6596V0(rule);
                    return;
                } else {
                    if (TextUtils.isEmpty(rule.sourceUrl) || !rule.sourceUrl.startsWith("http")) {
                        return;
                    }
                    if (System.currentTimeMillis() - new File(rule.fileName).lastModified() <= (SharedPreferencesHelper.getInstance().adRuleUpdateCircle == 1 ? 86400000L : SharedPreferencesHelper.getInstance().adRuleUpdateCircle == 2 ? 259200000L : SharedPreferencesHelper.getInstance().adRuleUpdateCircle == 3 ? 432000000L : 604800000L)) {
                        return;
                    }
                }
            }
            m6586Q(rule);
        }
    }

    public final void m6565F0() {
        AbstractC1807h2.m7778a(new RuleFileProcessor());
    }

    public final void m6566G() {
        File file = new File(PhoneUtils.getInstance().getAdRulesDirPath());
        if (!file.exists()) {
            file.mkdirs();
        }
        Iterator it = this.ruleFilesList.iterator();
        while (it.hasNext()) {
            m6564F((Rule) it.next());
        }
    }

    public final void m6567G0() throws Throwable {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("black-list", "");
        if (TextUtils.isEmpty(strM6871P)) {
            return;
        }
        BufferedReader bufferedReader = null;
        try {
            try {
                try {
                    BufferedReader bufferedReader2 = new BufferedReader(new FileReader(strM6871P));
                    while (true) {
                        try {
                            String line = bufferedReader2.readLine();
                            if (line == null) {
                                break;
                            } else {
                                this.blacklistMap.put(line, line);
                            }
                        } catch (Exception e2) {
                            e = e2;
                            bufferedReader = bufferedReader2;
                            e.printStackTrace();
                            if (bufferedReader != null) {
                                bufferedReader.close();
                            }
                            return;
                        } catch (Throwable th) {
                            th = th;
                            bufferedReader = bufferedReader2;
                            if (bufferedReader != null) {
                                try {
                                    bufferedReader.close();
                                } catch (IOException e3) {
                                    e3.printStackTrace();
                                }
                            }
                            throw th;
                        }
                    }
                    bufferedReader2.close();
                } catch (Throwable th2) {
                    th = th2;
                }
            } catch (Exception e4) {
                e = e4;
            }
        } catch (IOException e5) {
            e5.printStackTrace();
        }
    }

    public void m6568H() {
        try {
            MySQLiteOpenHelper.getInstance().getWritableDatabase().execSQL("DELETE FROM ad_block_log");
        } catch (Exception unused) {
        }
        this.whitelistedRulesMap.clear();
    }

    public final void m6569H0() {
        try {
            Cursor cursorQuery = this.browserActivity.getContentResolver().query(BrowserProvider.uriAdBlockRule, DatabaseColumns.AD_BLOCK_RULE, null, null, null);
            if (cursorQuery == null || !cursorQuery.moveToFirst()) {
                return;
            }
            do {
                String string = cursorQuery.getString(cursorQuery.getColumnIndex("rule_data"));
                if (cursorQuery.getInt(cursorQuery.getColumnIndex("rule_type")) != 4 && !TextUtils.isEmpty(string)) {
                    m6576L(string);
                }
            } while (cursorQuery.moveToNext());
        } catch (Exception unused) {
        }
    }

    public void m6570I() {
        this.currentPageBlockedCount = 0;
    }

    public final void m6571I0() {
        try {
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("ad_block_log", DatabaseColumns.AD_BLOCK_LOG, "rule_type = ?", new String[]{"-2"}, null, null, "last_hit");
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        String string = cursorQuery.getString(cursorQuery.getColumnIndex("rule_data"));
                        this.whitelistedRulesMap.put(string, string);
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m6572J() {
        this.browserActivity.runOnUiThread(new UIUpdateRunnable());
    }

    /* JADX WARN: Removed duplicated region for block: B:55:0x007f A[EXC_TOP_SPLITTER, SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6573J0(Rule r7) throws Throwable {
        /*
            r6 = this;
            p000.AndroidSystemUtils.m8678L()
            boolean r0 = r7.f4596h
            if (r0 == 0) goto L94
            r0 = 0
            r1 = 0
            java.io.BufferedReader r2 = new java.io.BufferedReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45 java.io.FileNotFoundException -> L4a
            java.io.FileReader r3 = new java.io.FileReader     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45 java.io.FileNotFoundException -> L4a
            java.lang.String r4 = r7.f4590b     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45 java.io.FileNotFoundException -> L4a
            r3.<init>(r4)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45 java.io.FileNotFoundException -> L4a
            r2.<init>(r3)     // Catch: java.lang.Throwable -> L40 java.io.IOException -> L45 java.io.FileNotFoundException -> L4a
        L15:
            java.lang.String r0 = r2.readLine()     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L29
            if (r0 == 0) goto L2b
            boolean r0 = r6.m6576L(r0)     // Catch: java.lang.Throwable -> L24 java.io.IOException -> L27 java.io.FileNotFoundException -> L29
            if (r0 == 0) goto L15
            int r1 = r1 + 1
            goto L15
        L24:
            r0 = move-exception
            goto L7d
        L27:
            r0 = move-exception
            goto L4f
        L29:
            r0 = move-exception
            goto L64
        L2b:
            r2.close()     // Catch: java.io.IOException -> L2f
            goto L33
        L2f:
            r0 = move-exception
            r0.printStackTrace()
        L33:
            r7.f4592d = r1
            com.mmbox.xbrowser.ContentDataManager$PatternComparator r7 = new com.mmbox.xbrowser.ContentDataManager$PatternComparator
            r7.<init>()
        L3a:
            java.util.ArrayList r0 = r6.f4556e
            java.util.Collections.sort(r0, r7)
            goto L79
        L40:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L7d
        L45:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L4f
        L4a:
            r2 = move-exception
            r5 = r2
            r2 = r0
            r0 = r5
            goto L64
        L4f:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L5c
            r2.close()     // Catch: java.io.IOException -> L58
            goto L5c
        L58:
            r0 = move-exception
            r0.printStackTrace()
        L5c:
            r7.f4592d = r1
            com.mmbox.xbrowser.ContentDataManager$PatternComparator r7 = new com.mmbox.xbrowser.ContentDataManager$PatternComparator
            r7.<init>()
            goto L3a
        L64:
            r0.printStackTrace()     // Catch: java.lang.Throwable -> L24
            if (r2 == 0) goto L71
            r2.close()     // Catch: java.io.IOException -> L6d
            goto L71
        L6d:
            r0 = move-exception
            r0.printStackTrace()
        L71:
            r7.f4592d = r1
            com.mmbox.xbrowser.ContentDataManager$PatternComparator r7 = new com.mmbox.xbrowser.ContentDataManager$PatternComparator
            r7.<init>()
            goto L3a
        L79:
            p000.AndroidSystemUtils.m8677K()
            goto L94
        L7d:
            if (r2 == 0) goto L87
            r2.close()     // Catch: java.io.IOException -> L83
            goto L87
        L83:
            r2 = move-exception
            r2.printStackTrace()
        L87:
            r7.f4592d = r1
            com.mmbox.xbrowser.ContentDataManager$PatternComparator r7 = new com.mmbox.xbrowser.ContentDataManager$PatternComparator
            r7.<init>()
            java.util.ArrayList r1 = r6.f4556e
            java.util.Collections.sort(r1, r7)
            throw r0
        L94:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.m6573J0(com.mmbox.xbrowser.ContentDataManager$Rule):void");
    }

    public void m6574K(String str, boolean z) {
        int i2;
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        String strM6612e0 = getAdBlockRuleData(writableDatabase, str);
        if (z) {
            if (strM6612e0 == null) {
                return;
            }
            this.whitelistedRulesMap.put(strM6612e0, strM6612e0);
            i2 = -2;
        } else {
            if (strM6612e0 == null) {
                return;
            }
            this.whitelistedRulesMap.remove(strM6612e0);
            i2 = 0;
        }
        m6635p1(writableDatabase, str, i2);
    }

    public void m6575K0() {
        this.currentDomain = SiteSettingsManager.getInstance().m6948Q();
    }

    public boolean m6576L(String str) {
        if (str.startsWith("@@") || str.indexOf("@#") >= 0) {
            m6648v(str);
        } else if (str.indexOf("##") >= 0) {
            m6646u(3, str);
        } else if (str.startsWith("--")) {
            m6654y(str, true, false);
        } else if (str.startsWith("|") || str.endsWith("|")) {
            m6556B(str);
        } else if (str.startsWith("==") || str.startsWith("=+")) {
            m6558C(str);
        } else {
            if (str.startsWith("!") || str.startsWith("#%#") || TextUtils.isEmpty(str)) {
                return false;
            }
            m6650w(str);
        }
        return true;
    }

    public final void m6577L0() throws JSONException {
        try {
            String strM2046a = ResourceCacheManager.getInstance().m2046a("ad_block_white", 1002);
            if (strM2046a != null) {
                JSONArray jSONArray = new JSONArray(strM2046a);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    this.whitelistedDomains.add(jSONArray.getString(i2));
                }
            }
            Cursor cursorQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().query("host_list", DatabaseColumns.HOST_LIST, "host_type= ?", new String[]{"1"}, null, null, null);
            if (cursorQuery != null) {
                if (cursorQuery.moveToFirst()) {
                    do {
                        this.whitelistedDomains.add(cursorQuery.getString(cursorQuery.getColumnIndex("host")));
                    } while (cursorQuery.moveToNext());
                }
                cursorQuery.close();
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public String m6578M() {
        return m6580N(false);
    }

    public void m6579M0(String str, String str2, String str3, String str4, int i2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        if (str3 != null) {
            try {
                str = URLDecoder.decode(str, "utf-8");
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        if (str2 != null) {
            str2 = URLDecoder.decode(str2, "utf-8");
        }
        if ((i2 == 20 || i2 == 3) && str4.indexOf("##") < 0) {
            str4 = str4 + "@" + str3;
        }
        String strM10184c = AbstractCryptoUtils.toMd5(str4);
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (m6633o1(writableDatabase, strM10184c, str) < 0) {
            contentValues.put("rule_hash", strM10184c);
            contentValues.put("rule_data", str4);
            contentValues.put("rule_type", Integer.valueOf(i2));
            contentValues.put("host", str3);
            contentValues.put("block_url", str2);
            contentValues.put("origin_url", str);
            contentValues.put("last_hit", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("hit_times", (Integer) 1);
            writableDatabase.insert("ad_block_log", null, contentValues);
        }
        this.currentPageBlockedCount++;
        Log.i("ad-block", "found one ad  with rule:" + str4);
        this.browserActivity.m6293a3(str);
        this.totalBlockedCount = this.totalBlockedCount + 1;
    }

    public String m6580N(boolean z) {
        JSONArray jSONArray = new JSONArray();
        try {
            for (Rule rule : this.ruleFilesList) {
                JSONObject jSONObjectM6617g1 = buildRuleJson(rule);
                if (z) {
                    jSONArray.put(jSONObjectM6617g1);
                } else if (rule.status != 3) {
                    jSONArray.put(jSONObjectM6617g1);
                    m6564F(rule);
                }
            }
        } catch (Exception unused) {
        }
        return jSONArray.toString();
    }

    public final boolean m6581N0(String str, String str2, String str3, String str4, boolean z) {
        String strSubstring;
        String lowerCase = m6622j0(str4).toLowerCase();
        int i2 = 0;
        if (lowerCase.length() > 256) {
            lowerCase = lowerCase.substring(0, 256);
        }
        String strSubstring2 = lowerCase;
        char cCharAt = 0;
        while (true) {
            int iM6607b0 = m6607b0(strSubstring2);
            if (iM6607b0 < 0) {
                if (TextUtils.isEmpty(strSubstring2)) {
                    return false;
                }
                if (cCharAt != 0) {
                    if (m6559C0(str, str3, cCharAt + strSubstring2, str4, 0, z)) {
                        return true;
                    }
                }
                if (m6559C0(str, str3, strSubstring2, str4, 0, z)) {
                    return true;
                }
                return m6557B0(str, str3, strSubstring2, str4, 0, z);
            }
            int[] iArrM6597W = m6597W(strSubstring2);
            if (cCharAt != 0) {
                if (m6559C0(str, str3, cCharAt + strSubstring2, str4, 0, z)) {
                    return true;
                }
            }
            if (m6559C0(str, str3, strSubstring2, str4, 0, z) || m6557B0(str, str3, strSubstring2, str4, 0, z)) {
                return true;
            }
            int i3 = i2;
            while (i3 < iArrM6597W.length) {
                int i4 = iArrM6597W[i3];
                String strSubstring3 = strSubstring2.substring(i2, i4);
                if (m6559C0(str, str3, strSubstring3, str4, 0, z)) {
                    return true;
                }
                int i5 = i4 + 1;
                if (i5 < strSubstring2.length()) {
                    strSubstring = strSubstring2.substring(i2, i5);
                    if (m6559C0(str, str3, strSubstring, str4, 0, z)) {
                        return true;
                    }
                } else {
                    strSubstring = null;
                }
                String str5 = strSubstring;
                if (cCharAt != 0) {
                    if (m6559C0(str, str3, cCharAt + strSubstring3, str4, 0, z)) {
                        return true;
                    }
                    if (str5 != null) {
                        if (m6559C0(str, str3, cCharAt + str5, str4, 0, z)) {
                            return true;
                        }
                    }
                }
                if (m6557B0(str, str3, strSubstring3, str4, 0, z)) {
                    return true;
                }
                i3++;
                i2 = 0;
            }
            cCharAt = strSubstring2.charAt(iM6607b0);
            strSubstring2 = strSubstring2.substring(iM6607b0 + 1);
            i2 = 0;
        }
    }

    public void m6582O(boolean z) {
        SharedPreferencesHelper.getInstance().enableSmartADB = z;
        SharedPreferencesHelper.getInstance().putBoolean("enable-smart-adb", z);
    }

    public final void m6583O0(Rule ruleVar) throws JSONException {
        String string;
        JSONObject jSONObject = new JSONObject();
        try {
            if (ruleVar.status == 0) {
                string = ruleVar.size + " " + this.browserActivity.getString(R.string.web_str_update_at) + " " + ruleVar.updateAt;
            } else {
                string = this.browserActivity.getString(R.string.web_str_dl_status_fail);
            }
            ruleVar.hash = string;
            jSONObject.put("transId", "import_rule_from_url");
            jSONObject.put("rule_file_info", buildRuleJson(ruleVar));
            C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void m6584P() {
        OutputStream fileOutputStream;
        String str = "custom_rule_" + AndroidSystemUtils.m8667A(System.currentTimeMillis()) + ".txt";
        String str2 = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS) + "/" + str;
        String str3 = this.browserActivity.getResources().getString(R.string.toast_export_to) + str2;
        try {
            int i2 = Build.VERSION.SDK_INT;
            if (i2 >= 29) {
                Uri uriM8704l = AndroidSystemUtils.m8704l(this.browserActivity, str, "text/plain", "");
                fileOutputStream = uriM8704l != null ? this.browserActivity.getContentResolver().openOutputStream(uriM8704l) : null;
                if (fileOutputStream == null) {
                    return;
                }
            } else {
                if (i2 < 29 && !BrowserActivity.getActivity().m6285Z("android.permission.WRITE_EXTERNAL_STORAGE")) {
                    BrowserActivity.getActivity().m6290a0();
                    return;
                }
                fileOutputStream = FileUtils.fileExists(str2) ? new FileOutputStream(str2) : new FileOutputStream(new File(str2));
            }
            Cursor cursorQuery = this.browserActivity.getContentResolver().query(BrowserProvider.uriAdBlockRule, DatabaseColumns.AD_BLOCK_RULE, null, null, null);
            if (cursorQuery != null && cursorQuery.moveToFirst()) {
                do {
                    String string = cursorQuery.getString(cursorQuery.getColumnIndex("rule_data"));
                    if (cursorQuery.getInt(cursorQuery.getColumnIndex("rule_type")) != 4 && !string.startsWith("=+") && !TextUtils.isEmpty(string)) {
                        fileOutputStream.write((string + "\n").getBytes(StandardCharsets.UTF_8));
                    }
                } while (cursorQuery.moveToNext());
                fileOutputStream.flush();
            }
        } catch (IOException e2) {
            e2.printStackTrace();
        }
        Toast.makeText(this.browserActivity, str3, Toast.LENGTH_LONG).show();
    }

    public final void m6585P0(Rule ruleVar) {
        this.browserActivity.runOnUiThread(new RuleCountToastRunnable(ruleVar));
    }

    public void m6586Q(Rule ruleVar) throws JSONException {
        fetchFile(ruleVar, null);
    }

    public final void m6587Q0(Rule ruleVar) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            ruleVar.f4598j = this.browserActivity.getString(R.string.web_str_status_importing);
            jSONObject.put("transId", "import_rule_from_url");
            jSONObject.put("rule_file_info", buildRuleJson(ruleVar));
            C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
        } catch (Exception e2) {
            e2.printStackTrace();
        }
    }

    public void fetchFile(Rule rule, i iVar) throws JSONException {
        Log.i("ad-block", ">>>>>>>>> fetch file >>>>>>>>>>>>>>>>>>>>");
        try {
            rule.status = -1;
            m6587Q0(rule);
            m6619h1();
            OkHttpClient okHttpClientM462Q = NetworkUtils.createUnsafeOkHttpClient();
            C0122Ck.a aVarM507i = new C0122Ck.a().m507i(rule.sourceUrl);
            try {
                aVarM507i.m499a("User-Agent", SharedPreferencesHelper.getInstance().m6849D());
            } catch (IllegalArgumentException unused) {
                aVarM507i.m499a("User-Agent", SharedPreferencesHelper.defaultUserAgent);
            }
            okHttpClientM462Q.m2004y(aVarM507i.m500b()).mo1791i(new RuleDownloadCallback(rule, iVar));
        } catch (Exception e2) {
            e2.printStackTrace();
            rule.status = -2;
            m6583O0(rule);
        }
    }

    public void m6589R0(String str) {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (ruleVarM6614F0 == null || TextUtils.isEmpty(ruleVarM6614F0.fileName) || !FileUtils.fileExists(ruleVarM6614F0.fileName)) {
            Toast.makeText(this.browserActivity, "file lost", Toast.LENGTH_SHORT).show();
        } else {
            C0801Ra.m3798f().m3808k(ruleVarM6614F0.fileName);
        }
    }

    public void m6590S0(String title, String desc, String sourceUrl, String from) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        try {
            jSONObject.put("resource_id", AbstractCryptoUtils.toMd5(sourceUrl));
            jSONObject.put("title", title);
            jSONObject.put("desc", desc);
            jSONObject.put("from", from);
            jSONObject.put("source_url", sourceUrl);
            jSONObject.put("user_id", C2439uo.getInstance().getUser().getUserId());
            String string = jSONObject.toString();
            OkHttpClient okHttpClient = new OkHttpClient();
            String strM2432l = ApiEndpointsManager.getInstance().getPostShareRuleEndpoint();
            try {
                okHttpClient.m2004y(new C0122Ck.a().m507i(strM2432l).m504f(AbstractC0168Dk.m718d(C0716Pg.m3568g("text/json"), string.getBytes(StandardCharsets.UTF_8))).m500b()).mo1791i(new RuleSharingCallback());
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        } catch (Exception unused) {
        }
    }

    public String m6591T(String str) {
        String strReplace;
        String strReplaceAll = FileUtils.getFileName(str).replaceAll("\\?", "_");
        if (TextUtils.isEmpty(strReplaceAll)) {
            strReplace = Math.abs(Math.abs(str.hashCode())) + ".txt";
        } else if (strReplaceAll.endsWith(".txt")) {
            strReplace = strReplaceAll.replace(".txt", "-" + Math.abs(str.hashCode()) + ".txt");
        } else {
            strReplace = strReplaceAll + "-" + Math.abs(str.hashCode()) + ".txt";
        }
        return PhoneUtils.getInstance().getAdRulesDirPath() + "/" + strReplace;
    }

    public final String m6592T0(String str) {
        return str.toLowerCase();
    }

    public Rule m6593U() {
        for (int i2 = 0; i2 < this.ruleFilesList.size(); i2++) {
            Rule ruleVar = (Rule) this.ruleFilesList.get(i2);
            if (!TextUtils.isEmpty(ruleVar.sourceUrl) && ruleVar.sourceUrl.indexOf("examplecode/ad-rules-for-xbrowser") > 0) {
                return ruleVar;
            }
        }
        return null;
    }

    public void m6594U0() {
        m6615f1();
    }

    public final int m6595V(String str) {
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (m6653x0(str.charAt(i3))) {
                i2++;
            }
        }
        return i2;
    }

    public final void m6596V0(Rule ruleVar) {
        if (TextUtils.isEmpty(ruleVar.fileName) || !FileUtils.fileExists(ruleVar.fileName)) {
            if (ruleVar.status != 3) {
                ruleVar.updateAt = "";
                ruleVar.size = "0";
                ruleVar.status = 2;
                return;
            }
            return;
        }
        File file = new File(ruleVar.fileName);
        ruleVar.updateAt = AndroidSystemUtils.m8718z(file.lastModified());
        long length = file.length();
        ruleVar.lastModified = length;
        ruleVar.size = AndroidSystemUtils.formatFileSize(length);
    }

    public final int[] m6597W(String str) {
        int[] iArr = new int[m6595V(str)];
        int i2 = 0;
        for (int i3 = 0; i3 < str.length(); i3++) {
            if (m6653x0(str.charAt(i3))) {
                iArr[i2] = i3;
                i2++;
            }
        }
        return iArr;
    }

    public void m6598W0(String str) {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (ruleVarM6614F0 != null) {
            if (!ruleVarM6614F0.active) {
                Toast.makeText(this.browserActivity, R.string.toast_active_rf_first, Toast.LENGTH_SHORT).show();
            } else {
                m6600X0();
                m6585P0(ruleVarM6614F0);
            }
        }
    }

    public ArrayList m6599X(String str) {
        return (ArrayList) this.elementRulesMap.get(str);
    }

    public void m6600X0() {
        try {
            this.urlRulesMap.clear();
            this.regularRulesList.clear();
            this.urlPatternsList.clear();
            this.elementRulesMap.clear();
            this.whitelistedRulesMap.clear();
            this.globalWhitelistHosts.clear();
            this.localWhitelistHosts.clear();
            m6565F0();
            m6571I0();
            m6572J();
        } catch (Exception unused) {
        }
    }

    public int m6601Y(String str) {
        int i2 = 0;
        Cursor cursorRawQuery = null;
        try {
            cursorRawQuery = MySQLiteOpenHelper.getInstance().getReadableDatabase().rawQuery("SELECT COUNT(*) as total FROM ad_block_log WHERE origin_url=? AND rule_type!=?", new String[]{URLDecoder.decode(str, "utf-8"), "-2"});
            if (cursorRawQuery.moveToFirst()) {
                i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndexOrThrow("total"));
            }
        } catch (Exception unused) {
            if (cursorRawQuery != null) {
            }
        } catch (Throwable th) {
            if (cursorRawQuery != null) {
                cursorRawQuery.close();
            }
            throw th;
        }
        cursorRawQuery.close();
        return i2;
    }

    public void m6602Y0(String str) {
        String[] strArr = {str};
        String strM7534r0 = MySQLiteOpenHelper.getInstance().getAdBlockRuleData(str);
        this.urlRulesMap.remove(strM7534r0);
        if (strM7534r0.indexOf("##") >= 0) {
            m6604Z0(strM7534r0);
        }
        if (strM7534r0.startsWith("==")) {
            m6611d1(strM7534r0);
        }
        if (strM7534r0.startsWith("@@") || strM7534r0.indexOf("@#") >= 0) {
            this.whitelistedRulesMap.remove(strM7534r0.substring(2));
        } else if (strM7534r0.indexOf("*") >= 0) {
            m6606a1(strM7534r0);
        }
        this.browserActivity.getContentResolver().delete(BrowserProvider.uriAdBlockRule, "rule_hash = ?", strArr);
        this.rulesModified = true;
        m6572J();
        C1089Xm.getInstance().m4822j("syncable_ad_rule").incrementVersion();
    }

    public int getUrlRules() {
        return this.urlRulesMap.size();
    }

    public final void m6604Z0(String str) {
        try {
            int iIndexOf = str.indexOf("##");
            if (iIndexOf >= 0) {
                String strSubstring = str.substring(0, iIndexOf);
                if (strSubstring.equals("")) {
                    strSubstring = "*";
                }
                ((ArrayList) this.elementRulesMap.get(strSubstring)).remove(str.substring(iIndexOf + 2));
            }
        } catch (Exception unused) {
        }
    }

    public int m6605a0() {
        return this.currentPageBlockedCount;
    }

    public final void m6606a1(String str) {
        for (int i2 = 0; i2 < this.regularRulesList.size(); i2++) {
            if (((k) this.regularRulesList.get(i2)).f4602c.equals(str)) {
                this.regularRulesList.remove(i2);
                return;
            }
        }
    }

    public final int m6607b0(String str) {
        int iIndexOf;
        int i2 = -1;
        int[] iArr = {-1, -1, -1, -1, -1, -1, -1, -1};
        iArr[0] = str.indexOf(61);
        iArr[1] = str.indexOf(45);
        iArr[2] = str.indexOf(95);
        iArr[3] = str.indexOf(38);
        iArr[4] = str.indexOf(63);
        iArr[5] = str.indexOf(46);
        iArr[6] = str.indexOf(47);
        int iIndexOf2 = str.indexOf(47);
        if (iIndexOf2 > 0 && (iIndexOf = str.substring(0, iIndexOf2).indexOf(58)) > 0) {
            iArr[7] = iIndexOf;
        }
        for (int i3 = 0; i3 < 8; i3++) {
            int i4 = iArr[i3];
            if (i2 < 0 || (i4 > 0 && i4 < i2)) {
                i2 = i4;
            }
        }
        return i2;
    }

    public void m6608b1(String str, String str2, int i2) {
        String strM459n;
        StringBuilder sb;
        String host;
        if (i2 == 0) {
            sb = new StringBuilder();
            strM459n = Uri.parse(str2).getHost();
        } else if (i2 == 2) {
            host = Uri.parse(str2).getHost();
            m6602Y0(AbstractCryptoUtils.toMd5(host));
        } else {
            if (i2 != 1) {
                return;
            }
            strM459n = NetworkUtils.stripUrlSchemeAndQuery(str2);
            sb = new StringBuilder();
        }
        sb.append(strM459n);
        sb.append("@");
        sb.append(str);
        host = sb.toString();
        m6602Y0(AbstractCryptoUtils.toMd5(host));
    }

    public void m6609c1(String str) {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (!TextUtils.isEmpty(ruleVarM6614F0.fileName)) {
            FileUtils.deleteFile(ruleVarM6614F0.fileName);
        }
        ruleVarM6614F0.status = 3;
        m6619h1();
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
        m6600X0();
    }

    public int getRegularRules() {
        return this.regularRulesList.size();
    }

    public final void m6611d1(String str) {
        String strSubstring = str.substring(2);
        int iIndexOf = strSubstring.indexOf(64);
        if (iIndexOf > 0) {
            this.hostExceptionsMap.remove(strSubstring.substring(iIndexOf + 1));
            return;
        }
        for (String str2 : strSubstring.split(",")) {
            this.globalWhitelistHosts.remove(str2);
        }
    }

    public final String getAdBlockRuleData(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("ad_block_log", DatabaseColumns.AD_BLOCK_LOG, "rule_hash= ?", new String[]{str}, null, null, null);
        if (cursorQuery == null) {
            return null;
        }
        try {
            if (cursorQuery.moveToFirst()) {
                return cursorQuery.getString(cursorQuery.getColumnIndexOrThrow("rule_data"));
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    public void m6613e1(String str) {
        for (int i2 = 0; i2 < this.whitelistedDomains.size(); i2++) {
            String str2 = (String) this.whitelistedDomains.get(i2);
            if (str2.equals(str)) {
                this.whitelistedDomains.remove(str2);
            }
        }
    }

    public Rule m6614f0(String str) {
        for (Object o : this.ruleFilesList) {
            Rule ruleVar = (Rule) o;
            String str2 = ruleVar.sourceUrl;
            if (str2 != null && str2.equals(str)) {
                return ruleVar;
            }
        }
        return null;
    }

    public final void m6615f1() throws JSONException {
        String strM6871P = SharedPreferencesHelper.getInstance().getString("rule_file_info", null);
        if (strM6871P != null) {
            try {
                JSONArray jSONArray = new JSONArray(strM6871P);
                for (int i2 = 0; i2 < jSONArray.length(); i2++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i2);
                    Rule ruleVar = new Rule();
                    ruleVar.fileName = JsonUtils.getString(jSONObject, "file_name");
                    ruleVar.sourceUrl = JsonUtils.getString(jSONObject, "source_url");
                    ruleVar.title = JsonUtils.getString(jSONObject, "title");
                    ruleVar.active = JsonUtils.getBoolean(jSONObject, "active", true);
                    ruleVar.status = JsonUtils.getInt(jSONObject, "status", 0);
                    m6596V0(ruleVar);
                    m6638q1(ruleVar);
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
    }

    public synchronized int getElementRules() {
        int size;
        Iterator it = this.elementRulesMap.values().iterator();
        size = 0;
        while (it.hasNext()) {
            size += ((ArrayList) it.next()).size();
        }
        return size;
    }

    public final JSONObject buildRuleJson(Rule rule) {
        JSONObject jsonObject = new JSONObject();
        try {
            String statusText;
            if (rule.status == 0) {
                statusText = rule.size;
            } else if (rule.status == -1) {
                statusText = browserActivity.getString(R.string.web_str_status_importing);
            } else {
                statusText = browserActivity.getString(R.string.web_str_dl_status_fail);
            }

            jsonObject.put("id", AndroidSystemUtils.prefixWithMd5(rule.sourceUrl));
            jsonObject.put("title", rule.title);
            jsonObject.put("size", rule.size);
            jsonObject.put("source", rule.source);
            jsonObject.put("update_at", rule.updateAt);
            jsonObject.put("number_rules", rule.numberRules);
            jsonObject.put("file_name", rule.fileName != null ? rule.fileName : "");
            jsonObject.put("active", rule.active);
            jsonObject.put("status", rule.status);
            jsonObject.put("status_text", statusText);
            jsonObject.put("source_url", rule.sourceUrl);

        } catch (Exception ignored) {
            // You might log the error here if needed
        }

        return jsonObject;
    }

    public int getExceptionRules() {
        return this.elementRulesMap.size() + this.whitelistedRulesMap.size();
    }

    public final void m6619h1() {
        SharedPreferencesHelper.getInstance().putString("rule_file_info", m6580N(true));
    }

    public int m6620i0() {
        return this.urlRulesMap.size() + getElementRules() + this.regularRulesList.size() + this.localWhitelistHosts.size() + this.userMarkedRulesMap.size() + this.urlPatternsList.size();
    }

    public void m6621i1() {
        SharedPreferencesHelper.getInstance().putInt("number_of_blocked", this.totalBlockedCount);
    }

    public final String m6622j0(String str) {
        String strSubstring;
        int i2 = str.startsWith("http://") ? 7 : str.startsWith("https://") ? 8 : -1;
        StringBuilder sb = new StringBuilder();
        if (i2 > 0) {
            str = str.substring(i2);
        }
        int iIndexOf = str.indexOf(47);
        if (iIndexOf <= 0) {
            return str;
        }
        String strSubstring2 = str.substring(0, iIndexOf);
        String strSubstring3 = str.substring(iIndexOf);
        sb.append(strSubstring2);
        int iIndexOf2 = strSubstring3.indexOf(63);
        if (iIndexOf2 > 0) {
            String strSubstring4 = strSubstring3.substring(0, iIndexOf2);
            strSubstring = strSubstring3.substring(iIndexOf2);
            strSubstring3 = strSubstring4;
        } else {
            strSubstring = null;
        }
        if (strSubstring3 != null) {
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < strSubstring3.length(); i5++) {
                if (strSubstring3.charAt(i5) == '/') {
                    if (i5 > i4) {
                        String strSubstring5 = strSubstring3.substring(i4, i5);
                        if (strSubstring5.length() >= 32) {
                            strSubstring5 = strSubstring5.substring(0, 32);
                        }
                        sb.append(strSubstring5);
                    }
                    i3 = i5;
                    i4 = i3;
                }
            }
            sb.append(strSubstring3.substring(i3));
        }
        if (strSubstring != null) {
            int i6 = 0;
            for (int i7 = 0; i7 < strSubstring.length(); i7++) {
                if (strSubstring.charAt(i7) == '=') {
                    int i8 = i7 + 1;
                    sb.append(strSubstring.substring(i6, i8));
                    i6 = i8;
                } else if (strSubstring.charAt(i7) == '&') {
                    String strSubstring6 = strSubstring.substring(i6, i7);
                    if (strSubstring6.length() >= 8) {
                        strSubstring6 = strSubstring6.substring(0, 8);
                    }
                    sb.append(strSubstring6);
                    sb.append('&');
                    i6 = i7 + 1;
                }
            }
            sb.append(strSubstring.substring(i6));
        }
        return sb.toString();
    }

    public void m6623j1(String str) {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (ruleVarM6614F0 == null || TextUtils.isEmpty(ruleVarM6614F0.fileName) || !FileUtils.fileExists(ruleVarM6614F0.fileName)) {
            Toast.makeText(this.browserActivity, "file lost", Toast.LENGTH_SHORT).show();
        } else {
            AndroidSystemUtils.m8686T(this.browserActivity, ruleVarM6614F0.fileName);
        }
    }

    public int getUserMarkRules() {
        return this.userMarkedRulesMap.size();
    }

    public synchronized void m6625k1() {
        this.currentSessionBlocked = 0;
        this.tempStorageMap.clear();
        this.lastProcessedUrl = null;
    }

    public String m6626l0(String str) {
        return (String) this.userMarkedRulesMap.get(str);
    }

    public void m6627l1() {
        this.currentSessionBlocked = 0;
    }

    public boolean m6628m0(String str, String str2, int i2) {
        if (i2 == 0) {
            String host = Uri.parse(str2).getHost();
            StringBuilder sb = new StringBuilder();
            sb.append(host);
            sb.append("@");
            sb.append(str);
            return this.urlRulesMap.get(sb.toString()) != null;
        }
        if (i2 == 2) {
            return this.urlRulesMap.get(Uri.parse(str2).getHost()) != null;
        }
        if (i2 != 1) {
            return false;
        }
        String strM459n = NetworkUtils.stripUrlSchemeAndQuery(str2);
        StringBuilder sb2 = new StringBuilder();
        sb2.append(strM459n);
        sb2.append("@");
        sb2.append(str);
        return this.urlRulesMap.get(sb2.toString()) != null;
    }

    /* JADX WARN: Removed duplicated region for block: B:128:0x01e0  */
    /* JADX WARN: Removed duplicated region for block: B:140:0x023b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public String m6629m1(String r13) {
        /*
            Method dump skipped, instructions count: 605
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.m6629m1(java.lang.String):java.lang.String");
    }

    public void m6630n0(String str) {
        String strM6591T = m6591T(str);
        Rule ruleVar = new Rule();
        ruleVar.fileName = strM6591T;
        ruleVar.source = 1;
        ruleVar.sourceUrl = str;
        ruleVar.title = FileUtils.getFileName(str);
        ruleVar.status = -1;
        m6652x(ruleVar);
        m6586Q(ruleVar);
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public void m6631n1(String str, String str2) {
        m6602Y0(str);
        m6644t(str2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:88:0x0166 A[PHI: r0 r1 r4 r5 r6
  0x0166: PHI (r0v7 java.lang.String) = (r0v10 java.lang.String), (r0v11 java.lang.String) binds: [B:87:0x0164, B:103:0x018c] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r1v17 boolean) = (r1v35 boolean), (r1v36 boolean) binds: [B:87:0x0164, B:103:0x018c] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r4v6 java.io.BufferedReader) = (r4v4 java.io.BufferedReader), (r4v7 java.io.BufferedReader) binds: [B:87:0x0164, B:103:0x018c] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r5v7 java.lang.String) = (r5v5 java.lang.String), (r5v8 java.lang.String) binds: [B:87:0x0164, B:103:0x018c] A[DONT_GENERATE, DONT_INLINE]
  0x0166: PHI (r6v7 int) = (r6v5 int), (r6v8 int) binds: [B:87:0x0164, B:103:0x018c] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Type inference failed for: r1v13, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r1v14, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v15 */
    /* JADX WARN: Type inference failed for: r1v16 */
    /* JADX WARN: Type inference failed for: r1v18, types: [java.io.BufferedWriter] */
    /* JADX WARN: Type inference failed for: r1v19, types: [java.io.IOException, java.lang.Throwable] */
    /* JADX WARN: Type inference failed for: r1v20 */
    /* JADX WARN: Type inference failed for: r1v24 */
    /* JADX WARN: Type inference failed for: r1v26 */
    /* JADX WARN: Type inference failed for: r1v33 */
    /* JADX WARN: Type inference failed for: r1v34 */
    /* JADX WARN: Type inference failed for: r1v37 */
    /* JADX WARN: Type inference failed for: r1v38 */
    /* JADX WARN: Type inference failed for: r1v39 */
    /* JADX WARN: Type inference failed for: r1v40 */
    /* JADX WARN: Type inference failed for: r1v41 */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m6632o0(Rule r14) throws Throwable {
        /*
            Method dump skipped, instructions count: 438
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.m6632o0(com.mmbox.xbrowser.ContentDataManager$Rule):void");
    }

    public final long m6633o1(SQLiteDatabase sQLiteDatabase, String str, String str2) {
        Cursor cursorQuery = sQLiteDatabase.query("ad_block_log", DatabaseColumns.AD_BLOCK_LOG, "rule_hash= ?", new String[]{str}, null, null, null);
        if (cursorQuery == null) {
            return -1L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                cursorQuery.close();
                return -1L;
            }
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_times", Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("hit_times")) + 1));
            if (!TextUtils.isEmpty(str2)) {
                contentValues.put("origin_url", str2);
            }
            contentValues.put("last_hit", Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabase.update("ad_block_log", contentValues, "_id= ?", new String[]{j2 + ""});
            cursorQuery.close();
            return j2;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public void m6634p0(String str) {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (ruleVarM6614F0 != null) {
            ruleVarM6614F0.status = 0;
        } else {
            ruleVarM6614F0 = new Rule();
            ruleVarM6614F0.sourceUrl = str;
        }
        m6632o0(ruleVarM6614F0);
        m6585P0(ruleVarM6614F0);
        this.browserActivity.m6361u0("show_rule_files()");
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    public final long m6635p1(SQLiteDatabase sQLiteDatabase, String str, int i2) {
        Cursor cursorQuery = sQLiteDatabase.query("ad_block_log", DatabaseColumns.AD_BLOCK_LOG, "rule_hash= ?", new String[]{str}, null, null, null);
        if (cursorQuery == null) {
            return -1L;
        }
        try {
            if (!cursorQuery.moveToFirst()) {
                return -1L;
            }
            long j2 = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_times", Integer.valueOf(cursorQuery.getInt(cursorQuery.getColumnIndexOrThrow("hit_times")) + 1));
            contentValues.put("rule_type", Integer.valueOf(i2));
            contentValues.put("last_hit", Long.valueOf(System.currentTimeMillis()));
            sQLiteDatabase.update("ad_block_log", contentValues, "_id=" + j2, null);
            return j2;
        } finally {
            cursorQuery.close();
        }
    }

    public void m6636q(boolean z) {
        SharedPreferencesHelper.getInstance().activeAdBlock = z;
        SharedPreferencesHelper.getInstance().putBoolean("active-ad-block", z);
        if (!z) {
            Toast.makeText(this.browserActivity, R.string.toast_deactive_ad_block, Toast.LENGTH_LONG).show();
        } else if (this.urlRulesMap.size() == 0) {
            m6563E0();
        }
        C1089Xm.getInstance().m4822j("syncable_setting").incrementVersion();
    }

    /* JADX WARN: Removed duplicated region for block: B:88:0x010b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m6637q0(String r10) {
        /*
            Method dump skipped, instructions count: 425
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.m6637q0(java.lang.String):boolean");
    }

    public final void m6638q1(Rule ruleVar) {
        Rule ruleVarM6614F0 = m6614f0(ruleVar.sourceUrl);
        if (ruleVarM6614F0 == null) {
            this.ruleFilesList.add(ruleVar);
            return;
        }
        ruleVarM6614F0.fileName = ruleVar.fileName;
        ruleVarM6614F0.active = ruleVar.active;
        ruleVarM6614F0.source = ruleVar.source;
        ruleVarM6614F0.title = ruleVar.title;
        ruleVarM6614F0.status = ruleVar.status;
    }

    public void m6639r(String str, boolean z) {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (ruleVarM6614F0 != null) {
            m6564F(ruleVarM6614F0);
            ruleVarM6614F0.active = z;
            m6619h1();
            m6600X0();
            m6596V0(ruleVarM6614F0);
        }
    }

    public void m6640r0(BrowserActivity browserActivity) {
        this.browserActivity = browserActivity;
        m6563E0();
        m6643s0();
    }

    public void m6641r1(String str) throws JSONException {
        Rule ruleVarM6614F0 = m6614f0(str);
        if (ruleVarM6614F0 != null) {
            fetchFile(ruleVarM6614F0, new EmptyRuleCallback());
        }
    }

    public void m6642s(String str) throws NoSuchAlgorithmException {
        this.whitelistedRulesMap.put(str, str);
        String strM10184c = AbstractCryptoUtils.toMd5(str);
        ContentValues contentValues = new ContentValues();
        SQLiteDatabase writableDatabase = MySQLiteOpenHelper.getInstance().getWritableDatabase();
        if (m6633o1(writableDatabase, strM10184c, "") < 0) {
            contentValues.put("rule_hash", strM10184c);
            contentValues.put("rule_data", str);
            contentValues.put("rule_type", (Integer) (-2));
            contentValues.put("last_hit", Long.valueOf(System.currentTimeMillis()));
            contentValues.put("hit_times", (Integer) 1);
            writableDatabase.insert("ad_block_log", null, contentValues);
        }
    }

    public final void m6643s0() {
        this.globalWhitelistHosts.add("jquery");
        this.globalWhitelistHosts.add("font");
        this.globalWhitelistHosts.add("bootstrap");
        this.globalWhitelistHosts.add("bdstatic.com");
        this.globalWhitelistHosts.add("m3u8");
        this.globalWhitelistHosts.add("mp4");
        this.globalWhitelistHosts.add("zhimg.com");
        this.globalWhitelistHosts.add("qhimg");
        this.globalWhitelistHosts.add("qiyi");
        this.globalWhitelistHosts.add("player");
        this.globalWhitelistHosts.add("qpic.cn");
        this.globalWhitelistHosts.add("gtimg");
        this.globalWhitelistHosts.add("netease");
        this.globalWhitelistHosts.add("bdimg.com");
        this.globalWhitelistHosts.add("ndstatic.cdn.bcebos.com");
        this.globalWhitelistHosts.add("wx.qq.com");
        this.globalWhitelistHosts.add("greasyfork.org");
        this.globalWhitelistHosts.add("cdn.jsdelivr.net");
        this.globalWhitelistHosts.add("vue");
        this.globalWhitelistHosts.add("angular");
        this.globalWhitelistHosts.add("cdnjs.cloudflare.com");
        this.globalWhitelistHosts.add("cdnjs.com");
        this.globalWhitelistHosts.add("github.com");
        this.globalWhitelistHosts.add("sinaimg.cn");
        this.globalWhitelistHosts.add("127.0.0.1");
        this.globalWhitelistHosts.add("m.taobao.com");
        this.globalWhitelistHosts.add("gstatic.com");
        this.globalWhitelistHosts.add("googleapis.com");
        this.globalWhitelistHosts.add("google.cn");
        this.globalWhitelistHosts.add("google.com");
        this.globalWhitelistHosts.add("facebook.com");
        this.globalWhitelistHosts.add("c.mipcdn.com");
        this.globalWhitelistHosts.add("vue");
        this.globalWhitelistHosts.add("DPlayer");
        this.globalWhitelistHosts.add("flv");
        this.globalWhitelistHosts.add("hls");
        this.globalWhitelistHosts.add("des.js");
    }

    public String m6644t(String str) {
        String strM6629m1 = m6629m1(str);
        if (strM6629m1 != null) {
            m6576L(strM6629m1);
            try {
                ContentValues contentValues = new ContentValues();
                contentValues.put("rule_hash", AbstractCryptoUtils.toMd5(strM6629m1));
                contentValues.put("rule_data", strM6629m1);
                this.browserActivity.getContentResolver().insert(BrowserProvider.uriAdBlockRule, contentValues);
                C1089Xm.getInstance().m4822j("syncable_ad_rule").incrementVersion();
            } catch (Exception unused) {
            }
        }
        return strM6629m1;
    }

    public final void m6645t0() throws JSONException {
        String strM2050f;
        if (PhoneUtils.getInstance().isInChina()) {
            m6554A(ResourceCacheManager.getInstance().m2050f("ad-rule-core-rule-cn", "https://quantil.jsdelivr.net/gh/examplecode/ad-rules-for-xbrowser@latest/core-rule-cn.txt"), true);
            if (!PhoneUtils.getInstance().isGooglePlayChannel()) {
                return;
            } else {
                strM2050f = ResourceCacheManager.getInstance().m2050f("ad-rule-easylistchina", "https://easylist-downloads.adblockplus.org/easylistchina.txt");
            }
        } else {
            m6554A("https://filters.adtidy.org/extension/chromium/filters/11.txt", true);
            strM2050f = "https://easylist.to/easylist/easylist.txt";
        }
        m6554A(strM2050f, true);
    }

    public void m6646u(int i2, String str) {
        int iIndexOf = str.indexOf("##");
        int i3 = 0;
        if (iIndexOf > 0) {
            String strSubstring = str.substring(0, iIndexOf);
            String strSubstring2 = str.substring(iIndexOf + 2);
            if (strSubstring.indexOf(",") < 0) {
                m6562E(strSubstring, strSubstring2);
                return;
            }
            String[] strArrSplit = strSubstring.split(",");
            while (i3 < strArrSplit.length) {
                m6562E(strArrSplit[i3], strSubstring2);
                i3++;
            }
            return;
        }
        if (iIndexOf == 0) {
            int iIndexOf2 = str.indexOf("@");
            if (iIndexOf2 <= 0) {
                if (iIndexOf2 == 0) {
                    return;
                }
                str.indexOf("->");
                m6562E("*", str.substring(iIndexOf + 2));
                return;
            }
            String strSubstring3 = str.substring(iIndexOf2 + 1);
            String strSubstring4 = str.substring(iIndexOf + 2, iIndexOf2);
            if (strSubstring3.indexOf(",") < 0) {
                m6562E(strSubstring3, strSubstring4);
                return;
            }
            String[] strArrSplit2 = strSubstring3.split(",");
            while (i3 < strArrSplit2.length) {
                m6562E(strArrSplit2[i3], strSubstring4);
                i3++;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:69:0x01d2 A[Catch: all -> 0x0123, Exception -> 0x0126, TryCatch #1 {Exception -> 0x0126, blocks: (B:3:0x0013, B:10:0x0058, B:14:0x0065, B:19:0x00b5, B:23:0x00e4, B:25:0x00ec, B:28:0x00fc, B:34:0x0129, B:36:0x012f, B:44:0x0167, B:46:0x016b, B:49:0x017e, B:67:0x01c6, B:69:0x01d2, B:70:0x01de, B:72:0x01e9, B:75:0x01f2, B:80:0x0210, B:79:0x01fc, B:82:0x0232, B:84:0x0248, B:87:0x0265, B:91:0x0281, B:71:0x01e2, B:53:0x0191, B:55:0x0199, B:61:0x01b0, B:62:0x01b5, B:64:0x01bb, B:58:0x01a9, B:48:0x0171, B:42:0x015f), top: B:99:0x0013, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x01e2 A[Catch: all -> 0x0123, Exception -> 0x0126, TryCatch #1 {Exception -> 0x0126, blocks: (B:3:0x0013, B:10:0x0058, B:14:0x0065, B:19:0x00b5, B:23:0x00e4, B:25:0x00ec, B:28:0x00fc, B:34:0x0129, B:36:0x012f, B:44:0x0167, B:46:0x016b, B:49:0x017e, B:67:0x01c6, B:69:0x01d2, B:70:0x01de, B:72:0x01e9, B:75:0x01f2, B:80:0x0210, B:79:0x01fc, B:82:0x0232, B:84:0x0248, B:87:0x0265, B:91:0x0281, B:71:0x01e2, B:53:0x0191, B:55:0x0199, B:61:0x01b0, B:62:0x01b5, B:64:0x01bb, B:58:0x01a9, B:48:0x0171, B:42:0x015f), top: B:99:0x0013, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:74:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x0248 A[Catch: all -> 0x0123, Exception -> 0x0126, TRY_LEAVE, TryCatch #1 {Exception -> 0x0126, blocks: (B:3:0x0013, B:10:0x0058, B:14:0x0065, B:19:0x00b5, B:23:0x00e4, B:25:0x00ec, B:28:0x00fc, B:34:0x0129, B:36:0x012f, B:44:0x0167, B:46:0x016b, B:49:0x017e, B:67:0x01c6, B:69:0x01d2, B:70:0x01de, B:72:0x01e9, B:75:0x01f2, B:80:0x0210, B:79:0x01fc, B:82:0x0232, B:84:0x0248, B:87:0x0265, B:91:0x0281, B:71:0x01e2, B:53:0x0191, B:55:0x0199, B:61:0x01b0, B:62:0x01b5, B:64:0x01bb, B:58:0x01a9, B:48:0x0171, B:42:0x015f), top: B:99:0x0013, outer: #0 }] */
    /* JADX WARN: Removed duplicated region for block: B:86:0x025a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public boolean m6647u0(String r22, String r23, String r24, int r25, boolean r26) {
        /*
            Method dump skipped, instructions count: 745
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.ContentDataManager.m6647u0(java.lang.String, java.lang.String, java.lang.String, int, boolean):boolean");
    }

    public final void m6648v(String str) {
        String strSubstring;
        if (str.startsWith("@@")) {
            String strSubstring2 = str.indexOf("||") == 2 ? str.substring(4) : str.substring(2);
            int iIndexOf = strSubstring2.indexOf("@");
            if (iIndexOf <= 0) {
                if (strSubstring2.indexOf("*") < 0) {
                    if (this.localWhitelistHosts.contains(strSubstring2)) {
                        return;
                    }
                    this.localWhitelistHosts.add(strSubstring2);
                    return;
                }
                m6654y(strSubstring2, false, true);
                return;
            }
            String strSubstring3 = strSubstring2.substring(iIndexOf + 1);
            String strSubstring4 = strSubstring2.substring(0, iIndexOf);
            if (strSubstring3.indexOf(",") <= 0) {
                if (strSubstring2.indexOf("*") < 0) {
                    if (this.localWhitelistHosts.contains(strSubstring2)) {
                        return;
                    }
                    this.localWhitelistHosts.add(strSubstring2);
                    return;
                }
                m6654y(strSubstring2, false, true);
                return;
            }
            String[] strArrSplit = strSubstring3.split(",");
            for (String str2 : strArrSplit) {
                strSubstring4.split(",");
                String str3 = strSubstring4 + "@" + str2;
                if (str3.indexOf("*") >= 0) {
                    m6654y(str3, false, true);
                } else if (!this.localWhitelistHosts.contains(str3)) {
                    this.localWhitelistHosts.add(str3);
                }
            }
            return;
        }
        if (str.indexOf("@#") >= 0) {
            int iIndexOf2 = str.indexOf("#@");
            if (iIndexOf2 > 0) {
                String strSubstring5 = str.substring(0, iIndexOf2);
                String strSubstring6 = str.substring(iIndexOf2 + 3);
                for (String str4 : strSubstring5.split(",")) {
                    String strTrim = str4.trim();
                    for (String str5 : strSubstring6.split(",")) {
                        String str6 = str5.trim() + "@" + strTrim;
                        this.whitelistedRulesMap.put(str6, str6);
                    }
                }
                return;
            }
            if (iIndexOf2 == 0) {
                strSubstring = str.substring(3);
            } else {
                int iIndexOf3 = str.indexOf("@");
                if (iIndexOf3 > 0) {
                    String strSubstring7 = str.substring(iIndexOf3 + 1);
                    String strSubstring8 = str.substring(iIndexOf2 + 2, iIndexOf3);
                    if (strSubstring7.indexOf(",") >= 0) {
                        for (String str7 : strSubstring7.split(",")) {
                            String str8 = strSubstring8 + "@" + str7;
                            this.whitelistedRulesMap.put(str8, str8);
                        }
                        return;
                    }
                    strSubstring = strSubstring8 + "@" + strSubstring7;
                } else if (str.indexOf("@#") != 0) {
                    return;
                } else {
                    strSubstring = str.substring(2);
                }
            }
            this.whitelistedRulesMap.put(strSubstring, strSubstring);
        }
    }

    public boolean m6649v0(String str) {
        return this.whitelistedRulesMap.get(str) == null;
    }

    public void m6650w(String str) {
        String lowerCase = str.toLowerCase();
        if (lowerCase.indexOf("*") >= 0) {
            m6654y(lowerCase, false, false);
            return;
        }
        int iIndexOf = lowerCase.indexOf("@");
        if (iIndexOf > 0) {
            String strSubstring = lowerCase.substring(iIndexOf + 1);
            String strSubstring2 = lowerCase.substring(0, iIndexOf);
            if (strSubstring.indexOf(",") > 0) {
                for (String str2 : strSubstring.split(",")) {
                    String str3 = strSubstring2 + "@" + str2;
                    this.urlRulesMap.put(str3, str3);
                }
                return;
            }
        }
        this.urlRulesMap.put(lowerCase, lowerCase);
    }

    public boolean m6651w0(String str) {
        String host = Uri.parse(str).getHost();
        if (!TextUtils.isEmpty(host)) {
            if (m6637q0(host)) {
                return false;
            }
            if (this.blacklistMap.get("*" + host) != null) {
                return true;
            }
        }
        return this.blacklistMap.get(str) != null;
    }

    public void m6652x(Rule ruleVar) {
        Rule ruleVarM6614F0 = m6614f0(ruleVar.sourceUrl);
        if (ruleVarM6614F0 != null) {
            String str = ruleVar.updateAt;
            if (str != null) {
                ruleVarM6614F0.updateAt = str;
            }
            ruleVarM6614F0.numberRules = ruleVar.numberRules;
            ruleVarM6614F0.fileName = ruleVar.fileName;
            ruleVarM6614F0.title = ruleVar.title;
            ruleVarM6614F0.status = ruleVar.status;
        } else {
            m6596V0(ruleVar);
            this.ruleFilesList.add(ruleVar);
        }
        m6619h1();
    }

    public final boolean m6653x0(char c2) {
        return c2 == '.' || c2 == '/' || c2 == '-' || c2 == '_' || c2 == '?' || c2 == '=' || c2 == '&' || c2 == ':';
    }

    public final void m6654y(String str, boolean z, boolean z2) {
        if (str.equals("://*.*")) {
            return;
        }
        PatternMatcher kVar = new PatternMatcher(this, str, z, z2);
        if (!kVar.m6661a() || this.regularRulesList.contains(kVar)) {
            return;
        }
        this.regularRulesList.add(kVar);
    }

    public final boolean m6655y0(String str, String str2, String str3, String str4, int i2) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        this.tempCounter++;
        if (str3.equals(str2) || this.urlRulesMap.get(str3) == null || !m6649v0(str3)) {
            return false;
        }
        m6579M0(str, str4, str2, str3, i2);
        return true;
    }

    public void m6656z(String str, String str2, int i2) {
        String strM459n;
        StringBuilder sb;
        String host;
        if (i2 != 0) {
            if (i2 == 2) {
                host = Uri.parse(str).getHost();
                m6644t(host);
                m6572J();
            } else {
                if (i2 == 1) {
                    strM459n = NetworkUtils.stripUrlSchemeAndQuery(str);
                    sb = new StringBuilder();
                }
                m6572J();
            }
        }
        strM459n = Uri.parse(str).getHost();
        sb = new StringBuilder();
        sb.append(strM459n);
        sb.append("@");
        sb.append(str2);
        host = sb.toString();
        m6644t(host);
        m6572J();
    }

    public final boolean m6657z0(String str, String str2, String str3, String str4) {
        for (int i2 = 0; i2 < this.localWhitelistHosts.size(); i2++) {
            String str5 = (String) this.localWhitelistHosts.get(i2);
            int iIndexOf = str5.indexOf("@");
            if (iIndexOf > 0) {
                String strSubstring = str5.substring(iIndexOf + 1);
                if (str2.indexOf(str5.substring(0, iIndexOf)) >= 0 && str3.indexOf(strSubstring) >= 0) {
                    return true;
                }
            } else if (str2.indexOf(str5) >= 0) {
                return true;
            }
        }
        return m6555A0(str, str2, str3, str4, true);
    }
}
