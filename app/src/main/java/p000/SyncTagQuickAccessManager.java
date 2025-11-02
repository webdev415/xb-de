package p000;

import android.content.ContentValues;
import android.database.Cursor;
import android.text.TextUtils;

import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.provider.BrowserProvider;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;

/**
 * Manager for syncing and handling Quick Access tags/bookmarks.
 */
public class SyncTagQuickAccessManager extends AbstractResourceManager {

    public SyncTagQuickAccessManager(String resourceType) {
        super(resourceType, false);
    }

    @Override
    public String getResourceValue() {
        try {
            return getLocalQuickAccessJson().toString();
        } catch (Throwable e) {
            e.printStackTrace();
            return "[]";
        }
    }

    @Override
    public void applyResource(String jsonStr, boolean saveLocally) {
        super.applyResource(jsonStr, saveLocally);
        BrowserActivity.getActivity().refreshQuickAccessUI();
    }

    @Override
    public String getKey() {
        return "sync_tag_quick_access";
    }

    @Override
    public void saveToLocal(String jsonStr) {
        try {
            JSONArray localArray = getLocalQuickAccessJson();
            HashMap<String, JSONObject> map = new HashMap<>();

            for (int i = 0; i < localArray.length(); i++) {
                JSONObject obj = localArray.getJSONObject(i);
                map.put(obj.getString("url"), obj);
            }

            JSONArray remoteArray = new JSONArray(jsonStr);
            for (int i = 0; i < remoteArray.length(); i++) {
                JSONObject remoteObj = remoteArray.getJSONObject(i);
                String url = remoteObj.getString("url");

                if (map.containsKey(url)) {
                    JsonUtils.copyJSONObject(remoteObj, map.get(url));
                } else {
                    localArray.put(remoteObj);
                }
            }

            saveJsonToDb(localArray);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public void loadFromRemote(String jsonStr) {
        try {
            saveJsonToDb(new JSONArray(jsonStr));
        } catch (JSONException e) {
            throw new RuntimeException(e);
        }
    }

    private void saveJsonToDb(JSONArray jsonArray) {
        String defaultParent = "root";
        String defaultExtra = "extra";

        try {
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject obj = jsonArray.getJSONObject(i);

                String guid = JsonUtils.getString(obj, "guid", "");
                String url = JsonUtils.getString(obj, "url", "");
                String title = JsonUtils.getString(obj, "title", "");
                int itemType = JsonUtils.getInt(obj, "item_type", 0);
                int itemOrder = JsonUtils.getInt(obj, "item_order", 0);
                String parent = JsonUtils.getString(obj, "parent", defaultParent);
                String iconUri = JsonUtils.getString(obj, "icon_uri", "");
                int status = JsonUtils.getInt(obj, "status", 1);
                String extra = JsonUtils.getString(obj, defaultExtra, "");

                ContentValues values = new ContentValues();
                values.put("guid", guid);
                values.put("title", title);
                values.put("url", url);
                values.put("item_type", itemType);
                values.put("item_order", itemOrder);
                values.put("parent", TextUtils.isEmpty(parent) ? defaultParent : parent);
                values.put("icon_uri", iconUri);
                values.put("status", status);
                values.put(defaultExtra, extra);

                MySQLiteOpenHelper.getInstance().addPendingEntry(values);
            }

            if (jsonArray.length() > 0) {
                MySQLiteOpenHelper.getInstance().insertOrReplaceEntries("quick_access", true);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private JSONArray getLocalQuickAccessJson() {
        Cursor cursor = null;
        JSONArray resultArray = new JSONArray();

        try {
            cursor = BrowserActivity.getActivity().getContentResolver().query(
                    BrowserProvider.uriQuickAccess,
                    null,
                    "status>= ? AND item_type != ?",
                    new String[]{"0", "3"},
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    JSONObject obj = new JSONObject();

                    int guidIdx = cursor.getColumnIndex("guid");
                    int titleIdx = cursor.getColumnIndex("title");
                    int urlIdx = cursor.getColumnIndex("url");
                    int typeIdx = cursor.getColumnIndex("item_type");
                    int orderIdx = cursor.getColumnIndex("item_order");
                    int parentIdx = cursor.getColumnIndex("parent");
                    int iconIdx = cursor.getColumnIndex("icon_uri");
                    int statusIdx = cursor.getColumnIndex("status");
                    int extraIdx = cursor.getColumnIndex("extra");

                    // Only get values if column exists
                    String guid = guidIdx >= 0 ? cursor.getString(guidIdx) : "";
                    String title = titleIdx >= 0 ? cursor.getString(titleIdx) : "NoName";
                    String url = urlIdx >= 0 ? cursor.getString(urlIdx) : guid;
                    int itemType = typeIdx >= 0 ? cursor.getInt(typeIdx) : 0;
                    int itemOrder = orderIdx >= 0 ? cursor.getInt(orderIdx) : 0;
                    String parent = parentIdx >= 0 ? cursor.getString(parentIdx) : "root";
                    String iconUri = iconIdx >= 0 ? cursor.getString(iconIdx) : "";
                    int status = statusIdx >= 0 ? cursor.getInt(statusIdx) : 1;
                    String extra = extraIdx >= 0 ? cursor.getString(extraIdx) : "";

                    obj.put("guid", guid);
                    obj.put("title", title);
                    obj.put("url", url);
                    obj.put("item_type", itemType);
                    obj.put("item_order", itemOrder);
                    obj.put("parent", parent);
                    obj.put("icon_uri", iconUri);
                    obj.put("status", status);
                    obj.put("extra", extra);

                    resultArray.put(obj);
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (cursor != null) cursor.close();
        }

        return resultArray;
    }
}
