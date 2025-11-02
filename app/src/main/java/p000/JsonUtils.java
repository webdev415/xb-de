package p000;

import android.text.TextUtils;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.Iterator;

/* Modern JSON utility class */
public abstract class JsonUtils {

    /** Copy all key-value pairs from source to target */
    public static void copyJSONObject(JSONObject source, JSONObject target) throws JSONException {
        if (source == null || target == null) return;

        Iterator<String> keys = source.keys(); // <- compatible with all API levels
        while (keys.hasNext()) {
            String key = keys.next();
            target.put(key, source.get(key));
        }
    }

    /** Safe boolean getters */
    public static boolean getBoolean(JSONObject obj, String key) {
        return getBoolean(obj, key, false);
    }

    public static boolean getBoolean(JSONObject obj, String key, boolean defaultValue) {
        return obj != null && obj.optBoolean(key, defaultValue);
    }

    /** Safe integer getters */
    public static int getInt(JSONObject obj, String key) {
        return getInt(obj, key, -1);
    }

    public static int getInt(JSONObject obj, String key, int defaultValue) {
        return obj != null ? obj.optInt(key, defaultValue) : defaultValue;
    }

    /** Safe long getters */
    public static long getLong(JSONObject obj, String key) {
        return getLong(obj, key, -1L);
    }

    public static long getLong(JSONObject obj, String key, long defaultValue) {
        return obj != null ? obj.optLong(key, defaultValue) : defaultValue;
    }

    /** Safe string getters */
    public static String getString(JSONObject obj, String key) {
        return getString(obj, key, null);
    }

    public static String getString(JSONObject obj, String key, String defaultValue) {
        if (obj == null) return defaultValue;
        String value = obj.optString(key, defaultValue);
        return TextUtils.isEmpty(value) ? defaultValue : value;
    }

    /** Safe JSONObject/JSONArray getters */
    public static JSONObject getJSONObject(JSONObject obj, String key) {
        return obj != null ? obj.optJSONObject(key) : null;
    }

    public static JSONArray getJSONArray(JSONObject obj, String key) {
        return obj != null ? obj.optJSONArray(key) : null;
    }

    /** Remove first occurrence of a string from JSONArray */
    public static void remove(JSONArray array, String target) {
        if (array == null || TextUtils.isEmpty(target)) return;

        for (int i = 0; i < array.length(); i++) {
            if (target.equals(array.optString(i))) {
                array.remove(i);
                return;
            }
        }
    }
}
