package p000;

import android.content.SharedPreferences;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

/* loaded from: classes.dex */
public final class SharedPreferencesC2260qt implements SharedPreferences {

    public final Map f6815a = new HashMap<>();

    public final Set f6816b = new HashSet();

    public final Object m9206a(String str, Object obj) {
        Object obj2 = this.f6815a.get(str);
        return obj2 != null ? obj2 : obj;
    }

    @Override
    public final boolean contains(String str) {
        return this.f6815a.containsKey(str);
    }

    @Override
    public final Editor edit() {
        return new SharedPreferencesEditorC2168ot(this);
    }

    @Override
    public final Map getAll() {
        return this.f6815a;
    }

    @Override
    public final boolean getBoolean(String str, boolean z) {
        return ((Boolean) m9206a(str, Boolean.valueOf(z))).booleanValue();
    }

    @Override
    public final float getFloat(String str, float f) {
        return ((Float) m9206a(str, Float.valueOf(f))).floatValue();
    }

    @Override
    public final int getInt(String str, int i) {
        return ((Integer) m9206a(str, Integer.valueOf(i))).intValue();
    }

    @Override
    public final long getLong(String str, long j) {
        return ((Long) m9206a(str, Long.valueOf(j))).longValue();
    }

    @Override
    public final String getString(String str, String str2) {
        return (String) m9206a(str, str2);
    }

    @Override
    public final Set getStringSet(String str, Set set) {
        return (Set) m9206a(str, set);
    }

    @Override
    public final void registerOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f6816b.add(onSharedPreferenceChangeListener);
    }

    @Override
    public final void unregisterOnSharedPreferenceChangeListener(OnSharedPreferenceChangeListener onSharedPreferenceChangeListener) {
        this.f6816b.remove(onSharedPreferenceChangeListener);
    }
}
