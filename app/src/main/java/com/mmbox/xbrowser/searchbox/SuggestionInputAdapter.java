package com.mmbox.xbrowser.searchbox;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.SystemClock;
import android.text.SpannableStringBuilder;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.mmbox.widget.FlowLayout;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.regex.Pattern;
import p000.NetworkUtils;
import p000.AndroidSystemUtils;
import p000.AbstractC2274r6;
import p000.AbstractC2524wh;
import p000.C0768Qm;
import p000.C0896Td;
import p000.MySQLiteOpenHelper;
import p000.ThemeManager;
import p000.C2390tl;
import p000.C2476vf;
import p000.InterfaceC1300b3;

public class SuggestionInputAdapter extends BaseAdapter implements Filterable, View.OnClickListener {

    public static final Pattern FROM_PATTERN = Pattern.compile("from=[a-z0-9_]{8,20}");

    public static final ExecutorService EXECUTOR_SERVICE = Executors.newSingleThreadExecutor();

    public static CharSequence firstUrl;

    public Context context = null;

    public Callback callback = null;

    public int hotWordVMargin = 0;

    public int hotWordHMargin = 0;

    public final Filter filter = new Filter() {
        @Override
        protected Filter.FilterResults performFiltering(CharSequence constraint) {
            ArrayList arrayList;
            Filter.FilterResults results = new Filter.FilterResults();
            filterAt = SystemClock.uptimeMillis();
            filterConstraint = constraint == null ? "" : constraint.toString().trim();
            if (TextUtils.isEmpty(filterConstraint) || filterConstraint.length() <= 30) {
                arrayList = new ArrayList<>();
                if (TextUtils.isEmpty(filterConstraint)) {
                    m7150b0(arrayList);
                } else {
                    m7148Z(arrayList);
                }
                m7132G(arrayList);
                m7152d0(arrayList);
            } else {
                arrayList = new ArrayList<>();
            }
            results.count = arrayList.size();
            results.values = arrayList;
            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, Filter.FilterResults results) {
            if (results != null) {
                Object obj = results.values;
                if (obj instanceof ArrayList) {
                    ArrayList arrayList = (ArrayList) obj;
                    handler.removeCallbacks(f5079o);
                    f5074j = null;
                    m7154x(arrayList);
                    f5068d.clear();
                    for (Object o : arrayList) {
                        f5068d.add((k) o);
                    }
                    f5075k = m7133H(arrayList);
                    notifyDataSetChanged();
                    if (callback != null) {
                        callback.mo7095c(f5068d);
                    }
                }
            }
            if (!TextUtils.isEmpty(filterConstraint)
                    && filterConstraint.length() >= 2
                    && !SharedPreferencesHelper.getInstance().disableSearchSuggestion) {
                strFilterConstraint = filterConstraint.toString();
                handler.removeCallbacks(f5078n);
                handler.postDelayed(f5078n, 200L);
            } else {
                handler.removeCallbacks(f5078n);
            }
        }
    };

    public m f5068d = new m();

    public ArrayList f5071g = new ArrayList<>();

    public Handler handler = new Handler(Looper.getMainLooper());

    public CharSequence filterConstraint = "";

    public ArrayList f5074j = null;

    public String f5075k = "";

    public long filterAt = 0;

    public String strFilterConstraint = null;

    public final Runnable f5078n = () -> {
        if (SharedPreferencesHelper.getInstance().disableSearchSuggestion) {
            return;
        }
        if (TextUtils.isEmpty(strFilterConstraint)) {
            return;
        }
        C2390tl.m9731f().m9744o(strFilterConstraint, new C2390tl.c() {
            @Override
            public void mo7157a(ArrayList arrayList) {
                if (strFilterConstraint.equals(filterConstraint == null ? "" : filterConstraint.toString())) {
                    ArrayList arrayList2 = new ArrayList<>();
                    arrayList2.add(m7138M(arrayList, 10));
                    m7130E(arrayList2);
                    m7134I(arrayList2);
                    m7151c0(arrayList2);
                }
            }

            @Override
            public void mo7158b() {
                if (strFilterConstraint.equals(filterConstraint == null ? "" : filterConstraint.toString())) {
                    ArrayList arrayList = new ArrayList<>();
                    m7130E(arrayList);
                    m7134I(arrayList);
                    m7151c0(arrayList);
                }
            }
        });
    };

    public final Runnable f5079o = () -> {
        if (f5074j == null) {
            return;
        }
        String strM7133H = m7133H(f5074j);
        if (!strM7133H.equals(f5075k)) {
            f5068d.clear();
            for (Object o : f5074j) {
                f5068d.add((k) o);
            }
            f5075k = strM7133H;
            notifyDataSetChanged();
            if (callback != null) {
                callback.mo7095c(f5068d);
            }
        }
        f5074j = null;
    };

    public class e implements View.OnClickListener {

        public final k f5091a;

        public e(k kVar) {
            this.f5091a = kVar;
        }

        @Override
        public void onClick(View view) {
            view.post(() -> {
                MySQLiteOpenHelper.getInstance().clearSearchHistory();
                if (f5068d != null && f5068d.list != null) {
                    f5068d.list.remove(f5091a);
                }
                notifyDataSetChanged();
            });
        }
    }

    public class f implements View.OnClickListener {

        public final k f5095a;

        public f(k kVar) {
            this.f5095a = kVar;
        }

        @Override
        public void onClick(View view) {
            if (this.f5095a.type == 3) {
                view.post(new Runnable() {
                    @Override
                    public void run() {
                        f5095a.url = C2390tl.m9731f().m9737h();
                        notifyDataSetChanged();
                    }
                });
            }
        }
    }

    public static class i {

        public final int f5101a;

        public TextView tvPrefix;

        public TextView f5103c;

        public ImageView imageView;

        public View f5105e;

        public FlowLayout f5106f;

        public View f5107g;

        public View f5108h;

        public TextView f5109i;

        public TextView f5110j;

        public View f5111k;

        public View f5112l;

        public i(int i) {
            this.f5101a = i;
        }
    }

    public class k {

        public int type;

        public String title = null;

        public Object url = null;

        public int f5117d = 0;

        public Object id = null;

        public boolean equals(Object obj) {
            if (this == obj) {
                return true;
            }
            if (obj == null || getClass() != obj.getClass()) {
                return false;
            }
            return this.url.equals(((k) obj).url);
        }

        @NonNull
        public String toString() {
            return "";
        }
    }

    public interface Callback {
        void mo7093a(String str, int i);

        void mo7094b(String str);

        void mo7095c(m mVar);
    }

    public class m {

        public ArrayList<k> list = new ArrayList<>(24);

        public void add(k kVar) {
            this.list.add(kVar);
        }

        public void clear() {
            this.list.clear();
        }

        public int getSize() {
            return this.list.size();
        }
    }

    public SuggestionInputAdapter(Context context, Callback callbackVar) {
        this.context = context;
        this.callback = callbackVar;
        this.hotWordVMargin = (int) context.getResources().getDimension(R.dimen.hotword_v_margin);
        this.hotWordHMargin = (int) this.context.getResources().getDimension(R.dimen.hotword_h_margin);
        m7144V();
    }

    public static Drawable m7100R(k kVar) {
        if (kVar.type != 4) {
            return null;
        }
        AbstractC2524wh.m10586a(kVar.url);
        throw null;
    }

    public static String m7101S(k kVar) {
        Object obj = kVar.url;
        if (obj != null) {
            if (kVar.type == 4) {
                AbstractC2524wh.m10586a(obj);
                new StringBuilder().append("app://");
                throw null;
            }
            if (obj instanceof String) {
                return (String) obj;
            }
        }
        return "";
    }

    public static String m7102T(k kVar) {
        if (kVar.type == 4) {
            AbstractC2524wh.m10586a(kVar.url);
            new StringBuilder().append("app://");
            throw null;
        }
        Object obj = kVar.url;
        if (kVar.type != 1) {
            if (obj instanceof String) {
                return (String) obj;
            }
            if (obj instanceof CharSequence) {
                return obj.toString();
            }
            return null;
        }
        if (!(obj instanceof String)) {
            return null;
        }
        String str = (String) obj;
        if (!str.startsWith("http")) {
            str = "x:bookmark?path=" + str;
        }
        return str;
    }

    public final void m7126A(i iVar, k kVar) {
        if (iVar.imageView != null) {
            ThemeManager.getInstance().m9500u().mo1385d(iVar.imageView);
        }
        iVar.f5109i.setText(kVar.title);
        iVar.f5110j.setText((CharSequence) kVar.url);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void m7127B(FlowLayout flowLayout, k kVar) {
        int i2;
        boolean z;
        String str;
        ArrayList arrayList = (ArrayList) kVar.url;
        if (arrayList == null) {
            int childCount = flowLayout.getChildCount();
            for (int i3 = 0; i3 < childCount; i3++) {
                flowLayout.getChildAt(i3).setVisibility(View.GONE);
            }
            return;
        }
        int iMin = Math.min(10, arrayList.size());
        int childCount2 = flowLayout.getChildCount();
        int i4 = 0;
        while (true) {
            i2 = 3;
            z = true;
            if (i4 >= childCount2 || i4 >= iMin) {
                break;
            }
            TextView textView = (TextView) flowLayout.getChildAt(i4);
            C2476vf c2476vf = (C2476vf) arrayList.get(i4);
            String str2 = c2476vf.f7677b;
            if (str2 != null) {
                int iIndexOf = str2.indexOf("<strong>");
                int iIndexOf2 = c2476vf.f7677b.indexOf("</strong>");
                if (iIndexOf >= 0) {
                    String str3 = c2476vf.f7677b;
                    if (iIndexOf2 <= 0) {
                        iIndexOf2 = str3.length();
                    }
                    c2476vf.f7677b = str3.substring(8, iIndexOf2);
                    c2476vf.f7680e = true;
                }
            }
            textView.setOnClickListener(this);
            textView.setTag(c2476vf);
            if (c2476vf.f7680e) {
                SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(c2476vf.f7677b);
                spannableStringBuilder.setSpan(new StyleSpan(3), 0, c2476vf.f7677b.length(), 33);
                spannableStringBuilder.setSpan(new ForegroundColorSpan(-65281), 0, c2476vf.f7677b.length(), 33);
                str = spannableStringBuilder;
            } else {
                str = c2476vf.f7677b;
            }
            textView.setText(str);
            textView.setVisibility(View.VISIBLE);
            i4++;
        }
        while (i4 < iMin) {
            C2476vf c2476vf2 = (C2476vf) arrayList.get(i4);
            String str4 = c2476vf2.f7677b;
            if (str4 != null) {
                int iIndexOf3 = str4.indexOf("<strong>");
                int iIndexOf4 = c2476vf2.f7677b.indexOf("</strong>");
                if (iIndexOf3 >= 0) {
                    String str5 = c2476vf2.f7677b;
                    if (iIndexOf4 <= 0) {
                        iIndexOf4 = str5.length();
                    }
                    c2476vf2.f7677b = str5.substring(8, iIndexOf4);
                    c2476vf2.f7680e = z;
                }
            }
            TextView textView2 = (TextView) ThemeManager.getInstance().m9485f();
            textView2.setOnClickListener(this);
            textView2.setTag(c2476vf2);
            if (c2476vf2.f7680e) {
                SpannableStringBuilder spannableStringBuilder2 = new SpannableStringBuilder(c2476vf2.f7677b);
                spannableStringBuilder2.setSpan(new StyleSpan(i2), 0, c2476vf2.f7677b.length(), 33);
                spannableStringBuilder2.setSpan(new ForegroundColorSpan(-65281), 0, c2476vf2.f7677b.length(), 33);
                textView2.setText(spannableStringBuilder2);
            } else {
                textView2.setText(c2476vf2.f7677b);
            }
            flowLayout.addView(textView2, new FlowLayout.C1415a(this.hotWordHMargin, this.hotWordVMargin));
            i4++;
            i2 = 3;
            z = true;
        }
        while (iMin < childCount2) {
            flowLayout.getChildAt(iMin).setVisibility(View.GONE);
            iMin++;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:54:0x010a A[PHI: r0
  0x010a: PHI (r0v4 java.lang.String) = (r0v3 java.lang.String), (r0v7 java.lang.String) binds: [B:53:0x0108, B:50:0x00fd] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:56:0x0116  */
    /* JADX WARN: Removed duplicated region for block: B:57:0x011a  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m7128C(i r14, k r15) {
        /*
            Method dump skipped, instructions count: 318
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.searchbox.ViewOnClickListenerC1582a.m7128C(com.mmbox.xbrowser.searchbox.a$i, com.mmbox.xbrowser.searchbox.a$k):void");
    }

    public final void m7129D(i iVar, k kVar) {
        iVar.tvPrefix.setText(kVar.title);
        iVar.f5103c.setText((String) kVar.url);
    }

    public final void m7130E(ArrayList arrayList) {
        if (arrayList == null) {
            throw new IllegalArgumentException("Mix suggestion list can't be empty");
        }
        if (TextUtils.isEmpty(this.filterConstraint)) {
            m7149a0(arrayList);
        } else {
            m7147Y(arrayList);
        }
        m7132G(arrayList);
        m7152d0(arrayList);
    }

    public final int m7131F(k kVar) {
        int i2 = kVar.type;
        int i3 = i2 == 11 ? Integer.MAX_VALUE : 0;
        if (i2 == 3) {
            return 2147483646;
        }
        if (i2 == 0) {
            return 1024;
        }
        if (i2 == 1) {
            return 1023;
        }
        if (i2 == 2) {
            return 1022;
        }
        if (i2 == 5) {
            return 1010;
        }
        if (i2 == 4) {
            return 1008;
        }
        return i3;
    }

    public final void m7132G(ArrayList arrayList) {
        int i2;
        int iIndexOf;
        CharSequence charSequence = this.filterConstraint;
        if (charSequence != null) {
            String string = charSequence.toString();
            String lowerCase = string == null ? "" : string.toLowerCase();
            Iterator it = arrayList.iterator();
            while (it.hasNext()) {
                k kVar = (k) it.next();
                int iM7131F = m7131F(kVar);
                int i3 = kVar.type;
                if (i3 == 11) {
                    i2 = Integer.MAX_VALUE;
                } else if (i3 == 9 || i3 == 10) {
                    i2 = 2147483646;
                } else if (i3 == 3) {
                    i2 = 2147483645;
                } else if (i3 == 7) {
                    i2 = 2147483644;
                } else if (i3 == 6) {
                    i2 = 2147483643;
                } else if (i3 == 14) {
                    i2 = 2147483642;
                } else if (i3 == 12) {
                    i2 = 2147482623;
                } else {
                    String str = kVar.title;
                    if (str != null && (iIndexOf = str.toLowerCase().indexOf(lowerCase)) >= 0) {
                        kVar.f5117d += (iM7131F - iIndexOf) + 10;
                    }
                    String strM7101S = m7101S(kVar);
                    if (strM7101S != null) {
                        String lowerCase2 = strM7101S.toLowerCase();
                        int iIndexOf2 = lowerCase2.indexOf(lowerCase);
                        if (iIndexOf2 >= 0) {
                            kVar.f5117d += (iM7131F - iIndexOf2) + 20;
                        }
                        if (strM7101S.startsWith("http://")) {
                            if (lowerCase2.indexOf(lowerCase) == 7) {
                                i2 = kVar.f5117d + 256;
                            }
                        } else if (strM7101S.startsWith("https://") && lowerCase2.indexOf(lowerCase) == 8) {
                            i2 = kVar.f5117d + 256;
                        }
                    }
                }
                kVar.f5117d = i2;
            }
        }
    }

    public final String m7133H(ArrayList arrayList) {
        StringBuilder sb = new StringBuilder(256);
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            sb.append(kVar.type);
            sb.append('|');
            String str = kVar.title;
            if (str != null) {
                sb.append(str);
            }
            sb.append('|');
            String strM7101S = m7101S(kVar);
            if (strM7101S != null) {
                sb.append(strM7101S);
            }
            sb.append('\n');
        }
        return sb.toString();
    }

    public final void m7134I(ArrayList arrayList) {
        k kVarM7141P = m7141P(arrayList);
        if (kVarM7141P != null) {
            String strM7140O = getFilteredHost(m7101S(kVarM7141P));
            if (strM7140O != null) {
                this.callback.mo7094b(strM7140O);
            }
        }
    }

    public final k m7135J() {
        k kVar = new k();
        kVar.type = 7;
        kVar.url = firstUrl;
        if (firstUrl == null || !NetworkUtils.isNonUrl(firstUrl.toString())) {
            kVar.title = context.getString(R.string.prefix_visit);
        } else {
            kVar.title = context.getString(R.string.prefix_search);
        }
        return kVar;
    }

    public final k m7136K() {
        k kVar = new k();
        kVar.type = 14;
        kVar.url = this.filterConstraint;
        kVar.title = this.context.getString(R.string.prefix_search);
        return kVar;
    }

    public final k m7137L() {
        k kVar = new k();
        kVar.type = 11;
        kVar.url = BrowserActivity.getActivity().f4242D;
        kVar.title = BrowserActivity.getActivity().f4243E;
        return kVar;
    }

    public final k m7138M(Object obj, int i2) {
        k kVar = new k();
        kVar.type = i2;
        kVar.url = obj;
        kVar.title = "hotwords";
        return kVar;
    }

    public final k m7139N(String title, String url, String id) {
        k kVar = new k();
        kVar.type = 5;
        kVar.url = url;
        kVar.title = title;
        kVar.id = id;
        return kVar;
    }

    public String getFilteredHost(String str) {
        if (filterConstraint == null) {
            return null;
        }
        String lowerCase = filterConstraint.toString().toLowerCase();
        if (str.indexOf("://") <= 0) {
            return str;
        }
        String host = Uri.parse(str).getHost();
        if (host != null) {
            if (host.startsWith(lowerCase)) {
                return host;
            }
            if (host.startsWith("www.")) {
                String strSubstring = host.substring(4);
                if (strSubstring.startsWith(lowerCase)) {
                    return strSubstring;
                }
            } else if (host.startsWith("3g.")) {
                String strSubstring2 = host.substring(3);
                if (strSubstring2.startsWith(lowerCase)) {
                    return strSubstring2;
                }
            } else if (host.startsWith("m.")) {
                String strSubstring3 = host.substring(2);
                if (strSubstring3.startsWith(lowerCase)) {
                    return strSubstring3;
                }
            }
        }
        return null;
    }

    public final k m7141P(ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            k kVar = (k) it.next();
            int i2 = kVar.type;
            if (i2 != 10 && i2 != 9 && i2 != 3 && i2 != 14 && i2 != 12 && i2 != 7 && i2 != 6) {
                return kVar;
            }
        }
        return null;
    }

    @Override
    public k getItem(int i2) {
        ArrayList arrayList;
        m mVar = this.f5068d;
        if (mVar != null && (arrayList = mVar.list) != null) {
            int size = arrayList.size();
            if (i2 >= 0 && i2 < size) {
                return (k) this.f5068d.list.get(i2);
            }
        }
        return null;
    }

    public void m7143U() {
        this.f5068d.clear();
        ArrayList arrayList = new ArrayList<>();
        m7149a0(arrayList);
        m7132G(arrayList);
        m7152d0(arrayList);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            this.f5068d.add((k) arrayList.get(i2));
        }
        notifyDataSetChanged();
    }

    public final void m7144V() {
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_setting), "x:st", "setting"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_history), "x:history", "his"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_bookmark), "x:bm", "bookmark,bm"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_set_appearance_custom), "x:custom", "custom"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_gs_setting), "x:gs", "gs,gesture,setting"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_set_general), "x:gens", "gen,general,setting"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_set_security_and_privacy), "x:sp", "sp,privacy,security"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_menu_conf), "x:mc", "menu,menu conf"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_setting_adb), "x:adb", "adblock,adb"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_rule_files), "x:rf", "rf,rule,adb"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_custom_rule), "x:block-rule", "custom,rule"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_adv_setting), "x:as", "adv,as,setting"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_set_user_center), "x:me", "me,user center"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_add_custom_ua), "x:ua", "ua"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_add_custom_search), "x:s", "search"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_myscript), "x:sc", "us,user script"));
        this.f5071g.add(m7139N(context.getString(R.string.web_str_title_download), "x:dl", "dl,download"));
    }

    public final ArrayList m7145W() {
        Cursor cursorRawQuery;
        ArrayList arrayList = new ArrayList<>();
        if (!SharedPreferencesHelper.getInstance().hideBrowserHistory) {
            SQLiteDatabase readableDatabase = MySQLiteOpenHelper.getInstance().getReadableDatabase();
            try {
                if (!SharedPreferencesHelper.getInstance().enterPrivateMode && (cursorRawQuery = readableDatabase.rawQuery("SELECT title,url,visits,last_visit FROM history ORDER BY last_visit DESC LIMIT 3", null)) != null) {
                    if (cursorRawQuery.moveToFirst()) {
                        do {
                            int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("visits"));
                            String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("title"));
                            String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("url"));
                            long j2 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex("last_visit"));
                            C0768Qm c0768Qm = new C0768Qm();
                            c0768Qm.f2293c = i2;
                            c0768Qm.f2291a = string;
                            c0768Qm.f2292b = string2;
                            c0768Qm.f2294d = j2;
                            c0768Qm.f2295e = 0;
                            arrayList.add(c0768Qm);
                        } while (cursorRawQuery.moveToNext());
                    }
                    cursorRawQuery.close();
                }
            } catch (Exception e2) {
                e2.printStackTrace();
            }
        }
        return arrayList;
    }

    public final ArrayList m7146X(String str) {
        String str2;
        Cursor cursorRawQuery;
        ArrayList arrayList = new ArrayList<>();
        SQLiteDatabase readableDatabase = MySQLiteOpenHelper.getInstance().getReadableDatabase();
        String str3 = "%" + str + "%";
        try {
            String str4 = "last_visit";
            String str5 = "visits";
            if (SharedPreferencesHelper.getInstance().enterPrivateMode || SharedPreferencesHelper.getInstance().hideBrowserHistory || (cursorRawQuery = readableDatabase.rawQuery("SELECT title,url,visits,last_visit FROM history WHERE title LIKE ? OR host LIKE ? ORDER BY last_visit DESC LIMIT 30", new String[]{str3, str3})) == null) {
                str2 = "last_visit";
            } else {
                if (cursorRawQuery.moveToFirst()) {
                    while (true) {
                        int i2 = cursorRawQuery.getInt(cursorRawQuery.getColumnIndex("visits"));
                        String string = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("title"));
                        String string2 = cursorRawQuery.getString(cursorRawQuery.getColumnIndex("url"));
                        str2 = str4;
                        long j2 = cursorRawQuery.getLong(cursorRawQuery.getColumnIndex(str4));
                        C0768Qm c0768Qm = new C0768Qm();
                        c0768Qm.f2293c = i2;
                        c0768Qm.f2291a = string;
                        c0768Qm.f2292b = string2;
                        c0768Qm.f2294d = j2;
                        c0768Qm.f2295e = 0;
                        arrayList.add(c0768Qm);
                        if (!cursorRawQuery.moveToNext()) {
                            break;
                        }
                        str4 = str2;
                    }
                } else {
                    str2 = "last_visit";
                }
                cursorRawQuery.close();
            }
            if (!SharedPreferencesHelper.getInstance().hideBookmarks) {
                Cursor cursorRawQuery2 = readableDatabase.rawQuery("SELECT title,url,visits,last_visit,parent FROM bookmark WHERE type=0 AND status >= 0 AND (title LIKE ? OR url LIKE ?) ORDER BY last_visit DESC LIMIT 30", new String[]{str3, str3});
                if (cursorRawQuery2 != null) {
                    if (cursorRawQuery2.moveToFirst()) {
                        while (true) {
                            String strM7533q0 = MySQLiteOpenHelper.getInstance().getFilteredBookmarkUrls();
                            int i3 = cursorRawQuery2.getInt(cursorRawQuery2.getColumnIndex(str5));
                            String string3 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("title"));
                            String string4 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("url"));
                            String str6 = str2;
                            long j3 = cursorRawQuery2.getLong(cursorRawQuery2.getColumnIndex(str6));
                            String string5 = cursorRawQuery2.getString(cursorRawQuery2.getColumnIndex("parent"));
                            String str7 = str5;
                            C0768Qm c0768Qm2 = new C0768Qm();
                            if (SharedPreferencesHelper.getInstance().f4899d0 || TextUtils.isEmpty(str) || TextUtils.isEmpty(string5) || string5.equals("/") || strM7533q0.indexOf(string5) < 0) {
                                c0768Qm2.f2293c = i3;
                                c0768Qm2.f2291a = string3;
                                c0768Qm2.f2292b = string4;
                                c0768Qm2.f2294d = j3;
                                c0768Qm2.f2295e = 1;
                                arrayList.add(c0768Qm2);
                            }
                            if (!cursorRawQuery2.moveToNext()) {
                                break;
                            }
                            str5 = str7;
                            str2 = str6;
                        }
                    }
                    cursorRawQuery2.close();
                }
                Cursor cursorRawQuery3 = readableDatabase.rawQuery("SELECT title,url FROM quick_access WHERE status >= 0 AND (title LIKE ? OR url LIKE ?)", new String[]{str3, str3});
                if (cursorRawQuery3 != null) {
                    if (cursorRawQuery3.moveToFirst()) {
                        do {
                            String string6 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndex("title"));
                            String string7 = cursorRawQuery3.getString(cursorRawQuery3.getColumnIndex("url"));
                            C0768Qm c0768Qm3 = new C0768Qm();
                            c0768Qm3.f2291a = string6;
                            c0768Qm3.f2292b = string7;
                            c0768Qm3.f2295e = 0;
                            arrayList.add(c0768Qm3);
                        } while (cursorRawQuery3.moveToNext());
                    }
                    cursorRawQuery3.close();
                }
            }
        } catch (Exception e2) {
            e2.printStackTrace();
        }
        return arrayList;
    }

    public final void m7147Y(List list) {
        String strM9337p;
        String strM9338q;
        String lowerCase = this.filterConstraint.toString().toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            list.add(m7136K());
        }
        ArrayList arrayListM9286J = BrowserActivity.getActivity().m6222J0().m9286J();
        for (int i2 = 0; i2 < arrayListM9286J.size(); i2++) {
            AbstractC2274r6.d dVar = (AbstractC2274r6.d) arrayListM9286J.get(i2);
            String strM9339r = dVar.m9339r();
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) dVar.m9333l();
            if (interfaceC1300b3 != null) {
                strM9337p = interfaceC1300b3.mo1574c();
                strM9338q = interfaceC1300b3.mo1573b();
                String strM9337p2 = dVar.m9337p();
                String strM9338q2 = dVar.m9338q();
                if (TextUtils.isEmpty(strM9337p) || (!TextUtils.isEmpty(strM9337p2) && !TextUtils.isEmpty(strM9338q2) && strM9337p2.equals(strM9337p) && !strM9338q2.equals(strM9338q))) {
                    strM9337p = strM9338q;
                }
            } else if (dVar.m9344w()) {
                strM9337p = dVar.m9337p();
                strM9338q = dVar.m9338q();
            }
            if (strM9337p == null) {
                strM9337p = "";
            }
            if (strM9338q == null) {
                strM9338q = "";
            }
            int i3 = strM9338q.startsWith("http://") ? 7 : strM9338q.startsWith("https://") ? 8 : 0;
            if (strM9337p.toLowerCase().indexOf(lowerCase) >= 0 || strM9338q.toLowerCase().indexOf(lowerCase) >= i3) {
                k kVar = new k();
                kVar.title = strM9337p;
                kVar.url = strM9338q;
                kVar.type = 12;
                kVar.id = strM9339r;
                kVar.f5117d = (int) (kVar.f5117d + (System.currentTimeMillis() % 86400000));
                list.add(kVar);
            }
        }
        Iterator it = m7146X(this.filterConstraint.toString()).iterator();
        while (it.hasNext()) {
            C0768Qm c0768Qm = (C0768Qm) it.next();
            k kVar2 = new k();
            kVar2.title = c0768Qm.f2291a;
            String str = c0768Qm.f2292b;
            kVar2.url = str;
            kVar2.type = c0768Qm.f2295e;
            int i4 = kVar2.f5117d + c0768Qm.f2293c;
            kVar2.f5117d = i4;
            if (str != null) {
                long j2 = c0768Qm.f2294d;
                if (j2 != 0) {
                    kVar2.f5117d = (int) (i4 + (j2 % 86400000));
                }
                list.add(kVar2);
                if (list.size() >= 20) {
                    return;
                }
            }
        }
        for (int i5 = 0; i5 < this.f5071g.size(); i5++) {
            k kVar3 = (k) this.f5071g.get(i5);
            String str2 = (String) kVar3.id;
            String str3 = (String) kVar3.url;
            if (kVar3.title.indexOf(lowerCase) >= 0 || str3.indexOf(lowerCase) >= 0 || str2.indexOf(lowerCase) >= 0) {
                list.add(kVar3);
            }
        }
    }

    public final void m7148Z(List list) {
        String lowerCase = this.filterConstraint.toString().toLowerCase();
        if (!TextUtils.isEmpty(lowerCase)) {
            list.add(m7136K());
        }
        if (lowerCase.length() >= 2) {
            Iterator it = m7146X(this.filterConstraint.toString()).iterator();
            while (it.hasNext()) {
                C0768Qm c0768Qm = (C0768Qm) it.next();
                k kVar = new k();
                kVar.title = c0768Qm.f2291a;
                String str = c0768Qm.f2292b;
                kVar.url = str;
                kVar.type = c0768Qm.f2295e;
                int i2 = kVar.f5117d + c0768Qm.f2293c;
                kVar.f5117d = i2;
                if (str != null) {
                    long j2 = c0768Qm.f2294d;
                    if (j2 != 0) {
                        kVar.f5117d = (int) (i2 + (j2 % 86400000));
                    }
                    list.add(kVar);
                    if (list.size() >= 20) {
                        return;
                    }
                }
            }
        }
        for (int i3 = 0; i3 < this.f5071g.size(); i3++) {
            k kVar2 = (k) this.f5071g.get(i3);
            String str2 = (String) kVar2.id;
            String str3 = (String) kVar2.url;
            if (kVar2.title.indexOf(lowerCase) >= 0 || str3.indexOf(lowerCase) >= 0 || str2.indexOf(lowerCase) >= 0) {
                list.add(kVar2);
            }
        }
    }

    public final void m7149a0(List list) {
        ArrayList arrayListM9736g;
        String str = BrowserActivity.getActivity().f4242D;
        if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
            list.add(m7137L());
        }
        if (!SharedPreferencesHelper.getInstance().hideSearchHistory && (arrayListM9736g = C2390tl.m9731f().m9736g()) != null && arrayListM9736g.size() > 0) {
            list.add(m7138M(arrayListM9736g, 9));
        }
        if (!SharedPreferencesHelper.getInstance().hideClipboardContent && !TextUtils.isEmpty(firstUrl)) {
            list.add(m7135J());
        }
        ArrayList arrayListM9737h = C2390tl.m9731f().m9737h();
        if (arrayListM9737h != null && arrayListM9737h.size() > 0) {
            list.add(m7138M(arrayListM9737h, 3));
        }
        for (Object o : m7145W()) {
            C0768Qm c0768Qm = (C0768Qm) o;
            k kVar = new k();
            kVar.title = c0768Qm.f2291a;
            kVar.url = c0768Qm.f2292b;
            kVar.type = 0;
            int i2 = kVar.f5117d + c0768Qm.f2293c;
            kVar.f5117d = i2;
            long j2 = c0768Qm.f2294d;
            if (j2 != 0) {
                kVar.f5117d = (int) (i2 + (j2 % 86400000));
            }
            list.add(kVar);
            if (list.size() >= 20) {
                return;
            }
        }
    }

    public final void m7150b0(List list) {
        ArrayList arrayListM9736g;
        if (!SharedPreferencesHelper.getInstance().hideSearchHistory && (arrayListM9736g = C2390tl.m9731f().m9736g()) != null && arrayListM9736g.size() > 0) {
            list.add(m7138M(arrayListM9736g, 9));
        }
        if (!SharedPreferencesHelper.getInstance().hideClipboardContent && !TextUtils.isEmpty(firstUrl)) {
            list.add(m7135J());
        }
        ArrayList arrayListM9737h = C2390tl.m9731f().m9737h();
        if (arrayListM9737h != null && arrayListM9737h.size() > 0) {
            list.add(m7138M(arrayListM9737h, 3));
        }
        for (Object o : m7145W()) {
            C0768Qm c0768Qm = (C0768Qm) o;
            k kVar = new k();
            kVar.title = c0768Qm.f2291a;
            kVar.url = c0768Qm.f2292b;
            kVar.type = 0;
            int i2 = kVar.f5117d + c0768Qm.f2293c;
            kVar.f5117d = i2;
            long j2 = c0768Qm.f2294d;
            if (j2 != 0) {
                kVar.f5117d = (int) (i2 + (j2 % 86400000));
            }
            list.add(kVar);
            if (list.size() >= 20) {
                return;
            }
        }
    }

    public final void m7151c0(ArrayList arrayList) {
        this.f5074j = arrayList;
        this.handler.removeCallbacks(this.f5079o);
        this.handler.postDelayed(this.f5079o, 150L);
    }

    public final void m7152d0(ArrayList<k> arrayList) {
        Collections.sort(arrayList, (kVar, kVar2) -> SharedPreferencesHelper.getInstance().defaultLayoutType == 4097 ? kVar2.f5117d - kVar.f5117d : kVar.f5117d - kVar2.f5117d);
    }

    public final void m7153e0(k kVar, ImageView imageView) {
        String strM7102T = m7102T(kVar);
        if (TextUtils.isEmpty(strM7102T) || imageView == null) {
            return;
        }
        imageView.setTag(strM7102T);
        EXECUTOR_SERVICE.execute(new Runnable() {
            @Override
            public void run() {
                int i = kVar.type;
                Drawable drawableM4146j = C0896Td.m4137c().m4146j(context, (i == 4 || i == 5) ? strM7102T : NetworkUtils.getFaviconUrl(strM7102T));
                if (drawableM4146j != null) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            Object tag = imageView.getTag();
                            if (strM7102T.equals(tag)) {
                                imageView.setImageDrawable(drawableM4146j);
                            }
                        }
                    });
                }
            }
        });
    }

    @Override
    public int getCount() {
        m mVar = this.f5068d;
        if (mVar == null || mVar.getSize() == 0) {
            return 0;
        }
        return this.f5068d.getSize();
    }

    @Override
    public Filter getFilter() {
        return this.filter;
    }

    @Override
    public long getItemId(int i2) {
        return i2;
    }

    @Override
    public int getItemViewType(int i2) {
        ArrayList arrayList;
        m mVar = this.f5068d;
        if (mVar != null && (arrayList = mVar.list) != null) {
            int size = arrayList.size();
            if (i2 >= 0 && i2 < size) {
                k kVar = (k) this.f5068d.list.get(i2);
                if (kVar.url != null && kVar.type == 3) {
                    return 0;
                }
                int i3 = kVar.type;
                if (i3 == 9) {
                    return 4;
                }
                if (i3 == 10) {
                    return 5;
                }
                if (i3 == 11) {
                    return 6;
                }
                if (i3 == 6) {
                    return 2;
                }
                if (i3 == 7) {
                    return 3;
                }
                if (i3 == 12) {
                    return 7;
                }
                if (i3 == 14) {
                    return 8;
                }
            }
        }
        return 1;
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002c  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x00ab  */
    /* JADX WARN: Removed duplicated region for block: B:34:0x00eb  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x00fd  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public View getView(int r17, View r18, android.view.ViewGroup r19) {
        /*
            Method dump skipped, instructions count: 304
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.mmbox.xbrowser.searchbox.ViewOnClickListenerC1582a.getView(int, android.view.View, android.view.ViewGroup):android.view.View");
    }

    @Override
    public int getViewTypeCount() {
        return 9;
    }

    @Override
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof C2476vf) {
            this.callback.mo7093a(((C2476vf) tag).f7677b, 3);
            return;
        }
        if (tag instanceof k) {
            k kVar = (k) view.getTag();
            int i2 = kVar.type;
            if (i2 != 12) {
                this.callback.mo7093a(m7102T(kVar), kVar.type);
                return;
            }
            Object obj = kVar.id;
            if (obj != null) {
                this.callback.mo7093a((String) obj, i2);
            }
        }
    }

    public final void m7154x(ArrayList arrayList) {
        if (TextUtils.isEmpty(this.filterConstraint)) {
            String str = BrowserActivity.getActivity().f4242D;
            if (!TextUtils.isEmpty(str) && str.startsWith("http")) {
                arrayList.add(0, m7137L());
            }
        } else {
            String lowerCase = this.filterConstraint.toString().toLowerCase();
            int iM9280D = BrowserActivity.getActivity().m6222J0().m9280D();
            for (int i2 = 0; i2 < iM9280D; i2++) {
                String strM9283G = BrowserActivity.getActivity().m6222J0().m9283G(i2);
                InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) BrowserActivity.getActivity().m6222J0().m9317z(i2);
                String strMo1574c = interfaceC1300b3 != null ? interfaceC1300b3.mo1574c() : null;
                String strMo1573b = interfaceC1300b3 != null ? interfaceC1300b3.mo1573b() : null;
                if (strMo1573b != null) {
                    int i3 = strMo1573b.startsWith("http://") ? 7 : strMo1573b.startsWith("https://") ? 8 : 0;
                    String lowerCase2 = strMo1574c == null ? "" : strMo1574c.toLowerCase();
                    String lowerCase3 = strMo1573b.toLowerCase();
                    if (lowerCase2.indexOf(lowerCase) >= 0 || lowerCase3.indexOf(lowerCase) >= i3) {
                        k kVar = new k();
                        kVar.title = strMo1574c;
                        kVar.url = strMo1573b;
                        kVar.type = 12;
                        kVar.id = strM9283G;
                        kVar.f5117d = (int) (kVar.f5117d + (System.currentTimeMillis() % 86400000));
                        arrayList.add(kVar);
                    }
                }
            }
        }
        m7132G(arrayList);
        m7152d0(arrayList);
    }

    public final void m7155y(i iVar, k kVar) {
        if (iVar.imageView != null) {
            ThemeManager.getInstance().m9500u().mo1385d(iVar.imageView);
        }
        iVar.f5109i.setText(kVar.title);
        iVar.f5110j.setText((CharSequence) kVar.url);
    }

    public final void m7156z(i iVar, k kVar) {
        if (iVar.imageView != null) {
            ThemeManager.getInstance().m9500u().mo1385d(iVar.imageView);
        }
        iVar.tvPrefix.setText(kVar.title);
        iVar.f5103c.setText((String) kVar.url);
        if (iVar.f5111k != null) {
            iVar.f5111k.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    AndroidSystemUtils.m8701i(context, iVar.f5103c.getText().toString());
                    Toast.makeText(context, R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
                }
            });
        }
        if (iVar.f5112l != null) {
            iVar.f5112l.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (callback != null) {
                        callback.mo7093a("open_site_config", 13);
                    }
                }
            });
        }
    }
}
