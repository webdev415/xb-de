package p000;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public final class SharedPreferencesEditorC2168ot implements SharedPreferences.Editor {

    public boolean f6592a;

    public Set f6593b;

    public Map f6594c;

    public final SharedPreferencesC2260qt f6595d;

    public SharedPreferencesEditorC2168ot(SharedPreferencesC2260qt sharedPreferencesC2260qt) {
        this.f6595d = sharedPreferencesC2260qt;
        this.f6592a = false;
        this.f6593b = new HashSet();
        this.f6594c = new HashMap<>();
    }

    public final void m8985a(String str, Object obj) {
        if (obj != null) {
            this.f6594c.put(str, obj);
        } else {
            remove(str);
        }
    }

    @Override
    public final void apply() {
        commit();
    }

    @Override
    public final SharedPreferences.Editor clear() {
        this.f6592a = true;
        return this;
    }

    @Override
    public final boolean commit() {
        if (this.f6592a) {
            this.f6595d.f6815a.clear();
        }
        this.f6595d.f6815a.keySet().removeAll(this.f6593b);
        for (Map.Entry entry : this.f6594c.entrySet()) {
            this.f6595d.f6815a.put((String) entry.getKey(), entry.getValue());
        }
        for (SharedPreferences.OnSharedPreferenceChangeListener onSharedPreferenceChangeListener : this.f6595d.f6816b) {
            AbstractC2209po abstractC2209poMo2916d = AbstractC0583Ml.m2915c(this.f6593b, this.f6594c.keySet()).iterator();
            while (abstractC2209poMo2916d.hasNext()) {
                onSharedPreferenceChangeListener.onSharedPreferenceChanged(this.f6595d, (String) abstractC2209poMo2916d.next());
            }
        }
        return (!this.f6592a && this.f6593b.isEmpty() && this.f6594c.isEmpty()) ? false : true;
    }

    @Override
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        m8985a(str, Boolean.valueOf(z));
        return this;
    }

    @Override
    public final SharedPreferences.Editor putFloat(String str, float f) {
        m8985a(str, Float.valueOf(f));
        return this;
    }

    @Override
    public final SharedPreferences.Editor putInt(String str, int i) {
        m8985a(str, Integer.valueOf(i));
        return this;
    }

    @Override
    public final SharedPreferences.Editor putLong(String str, long j) {
        m8985a(str, Long.valueOf(j));
        return this;
    }

    @Override
    public final SharedPreferences.Editor putString(String str, String str2) {
        m8985a(str, str2);
        return this;
    }

    @Override
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        m8985a(str, set);
        return this;
    }

    @Override
    public final SharedPreferences.Editor remove(String str) {
        this.f6593b.add(str);
        return this;
    }
}
