package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Build;
import java.text.SimpleDateFormat;
import java.time.ZoneOffset;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.Set;

public class C1921jd {

    public final SharedPreferences f5946a;

    public C1921jd(Context context, String str) {
        this.f5946a = context.getSharedPreferences("FirebaseHeartBeat" + str, 0);
    }

    public final synchronized void m8160a() {
        try {
            long j = this.f5946a.getLong("fire-count", 0L);
            String key = "";
            String str = null;
            for (Map.Entry<String, ?> entry : this.f5946a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    for (String str2 : (Set) entry.getValue()) {
                        if (str == null || str.compareTo(str2) > 0) {
                            key = entry.getKey();
                            str = str2;
                        }
                    }
                }
            }
            HashSet hashSet = new HashSet(this.f5946a.getStringSet(key, new HashSet()));
            hashSet.remove(str);
            this.f5946a.edit().putStringSet(key, hashSet).putLong("fire-count", j - 1).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m8161b() {
        try {
            SharedPreferences.Editor editorEdit = this.f5946a.edit();
            int i = 0;
            for (Map.Entry<String, ?> entry : this.f5946a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    Set set = (Set) entry.getValue();
                    String strM8163d = m8163d(System.currentTimeMillis());
                    String key = entry.getKey();
                    if (set.contains(strM8163d)) {
                        HashSet hashSet = new HashSet();
                        hashSet.add(strM8163d);
                        i++;
                        editorEdit.putStringSet(key, hashSet);
                    } else {
                        editorEdit.remove(key);
                    }
                }
            }
            if (i == 0) {
                editorEdit.remove("fire-count");
            } else {
                editorEdit.putLong("fire-count", i);
            }
            editorEdit.commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized List m8162c() {
        ArrayList arrayList;
        try {
            arrayList = new ArrayList<>();
            for (Map.Entry<String, ?> entry : this.f5946a.getAll().entrySet()) {
                if (entry.getValue() instanceof Set) {
                    HashSet hashSet = new HashSet((Set) entry.getValue());
                    hashSet.remove(m8163d(System.currentTimeMillis()));
                    if (!hashSet.isEmpty()) {
                        arrayList.add(AbstractC1967kd.m8292a(entry.getKey(), new ArrayList<>(hashSet)));
                    }
                }
            }
            m8167h(System.currentTimeMillis());
        } catch (Throwable th) {
            throw th;
        }
        return arrayList;
    }

    public final synchronized String m8163d(long j) {
        if (Build.VERSION.SDK_INT >= 26) {
            return new Date(j).toInstant().atOffset(ZoneOffset.UTC).toLocalDateTime().format(DateTimeFormatter.ISO_LOCAL_DATE);
        }
        return new SimpleDateFormat("yyyy-MM-dd", Locale.UK).format(new Date(j));
    }

    public final synchronized String m8164e(String str) {
        for (Map.Entry<String, ?> entry : this.f5946a.getAll().entrySet()) {
            if (entry.getValue() instanceof Set) {
                Iterator it = ((Set) entry.getValue()).iterator();
                while (it.hasNext()) {
                    if (str.equals((String) it.next())) {
                        return entry.getKey();
                    }
                }
            }
        }
        return null;
    }

    public final synchronized void m8165f(String str) {
        try {
            String strM8164e = m8164e(str);
            if (strM8164e == null) {
                return;
            }
            HashSet hashSet = new HashSet(this.f5946a.getStringSet(strM8164e, new HashSet()));
            hashSet.remove(str);
            (hashSet.isEmpty() ? this.f5946a.edit().remove(strM8164e) : this.f5946a.edit().putStringSet(strM8164e, hashSet)).commit();
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void m8166g(long j, String str) {
        String strM8163d = m8163d(j);
        if (this.f5946a.getString("last-used-date", "").equals(strM8163d)) {
            String strM8164e = m8164e(strM8163d);
            if (strM8164e == null) {
                return;
            }
            if (strM8164e.equals(str)) {
                return;
            }
            m8168i(str, strM8163d);
            return;
        }
        long j2 = this.f5946a.getLong("fire-count", 0L);
        if (j2 + 1 == 30) {
            m8160a();
            j2 = this.f5946a.getLong("fire-count", 0L);
        }
        HashSet hashSet = new HashSet(this.f5946a.getStringSet(str, new HashSet()));
        hashSet.add(strM8163d);
        this.f5946a.edit().putStringSet(str, hashSet).putLong("fire-count", j2 + 1).putString("last-used-date", strM8163d).commit();
    }

    public synchronized void m8167h(long j) {
        this.f5946a.edit().putLong("fire-global", j).commit();
    }

    public final synchronized void m8168i(String str, String str2) {
        m8165f(str2);
        HashSet hashSet = new HashSet(this.f5946a.getStringSet(str, new HashSet()));
        hashSet.add(str2);
        this.f5946a.edit().putStringSet(str, hashSet).commit();
    }
}
