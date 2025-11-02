package p000;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;
import android.util.Log;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.util.ArrayList;
import org.json.JSONArray;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class MySQLiteOpenHelper extends SQLiteOpenHelper {

    public static MySQLiteOpenHelper instance;

    public ArrayList<ContentValues> pendingEntries = null;

    public final long creationTimestamp;

    public MySQLiteOpenHelper(Context context) {
        super(context, "mbrowser", null, 49);
        instance = this;
        this.creationTimestamp = System.currentTimeMillis();
        this.pendingEntries = new ArrayList<>(5);
    }

    public static MySQLiteOpenHelper getInstance() {
        return instance;
    }

    public final void addUserScriptTableColumn_ResourcesVersion(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN resources TEXT ;");
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN version TEXT  ;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts a new quick-access entry or updates an existing one if the URL already exists.
     *
     * @param db the writable SQLiteDatabase
     * @param url the URL of the quick-access entry
     * @param values the ContentValues containing column data (title, parent, etc.)
     */
    public void upsertQuickAccess(SQLiteDatabase db, String url, ContentValues values) {
        try {
            if (isUrlInQuickAccess(db, url)) {
                db.update("quick_access", values, "url = ?", new String[]{url});
            } else {
                db.insert("quick_access", null, values);
            }
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors
        }
    }

    public final void addUserScriptTableColumn_NameNamespace(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN name TEXT ;");
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN namespace TEXT ;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Inserts or updates a root-level quick-access entry.
     *
     * @param db the writable SQLiteDatabase
     * @param urlKey the URL used as the unique key for upsert
     * @param title the title of the quick-access entry
     * @param url the URL of the quick-access entry
     */
    public void upsertRootQuickAccess(SQLiteDatabase db, String urlKey, String title, String url) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("url", url);
        values.put("parent", "root");
        upsertQuickAccess(db, urlKey, values);
    }

    public boolean m7488C(String str, int i, int i2, String str2) {
        String str3;
        SQLiteDatabase writableDatabase = getWritableDatabase();
        Cursor cursorQuery = writableDatabase.query("bookmark", DatabaseColumns.BOOKMARK, "item_order= ?", new String[]{i + ""}, null, null, null);
        if (cursorQuery == null) {
            return false;
        }
        try {
            try {
                if (cursorQuery.moveToFirst() && cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id")) != -1) {
                    if (i > i2) {
                        writableDatabase.execSQL("UPDATE bookmark SET item_order=item_order+1 WHERE item_order >=" + i2 + " AND item_order<" + i);
                        str3 = "UPDATE bookmark SET item_order=" + i2 + " WHERE url='" + str + "'";
                    } else {
                        if (i >= i2) {
                            if (i == i2) {
                                str3 = "UPDATE bookmark SET item_order=" + i2 + "1 WHERE url='" + str + "'";
                            }
                            writableDatabase.execSQL("UPDATE bookmark SET last_visit=" + Long.parseLong(str2) + " WHERE url='" + str + "'");
                            cursorQuery.close();
                            return true;
                        }
                        writableDatabase.execSQL("UPDATE bookmark SET item_order=item_order-1 WHERE item_order >" + i + " AND item_order<=" + i2);
                        str3 = "UPDATE bookmark SET item_order=" + i2 + " WHERE url='" + str + "'";
                    }
                    writableDatabase.execSQL(str3);
                    writableDatabase.execSQL("UPDATE bookmark SET last_visit=" + Long.parseLong(str2) + " WHERE url='" + str + "'");
                    cursorQuery.close();
                    return true;
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
            cursorQuery.close();
            return false;
        } catch (Throwable th) {
            cursorQuery.close();
            throw th;
        }
    }

    public int m7489C0() {
        return this.pendingEntries.size();
    }

    public void m7490D0(JSONArray jSONArray) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            try {
                writableDatabase.beginTransaction();
                for (int i = 0; i < jSONArray.length(); i++) {
                    writableDatabase.delete("bookmark", "url= ?", new String[]{jSONArray.getString(i)});
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public void m7491E(String str, int i) {
        m7500K0(str, (~i) & getBookmarkStatus(str));
    }

    public void m7492E0() throws SQLException {
        try {
            getWritableDatabase().execSQL("DELETE FROM ad_block_rule WHERE rule_type =3");
        } catch (Exception unused) {
        }
    }

    public void m7493F0(JSONArray jSONArray) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            try {
                writableDatabase.beginTransaction();
                for (int i = 0; i < jSONArray.length(); i++) {
                    writableDatabase.delete("history", "url= ?", new String[]{jSONArray.getString(i)});
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writableDatabase.endTransaction();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            throw th;
        }
    }

    public void m7494G0(String str) throws SQLException {
        try {
            getWritableDatabase().execSQL("DELETE FROM history WHERE url='" + str + "'");
        } catch (Exception unused) {
        }
    }

    /**
     * Inserts default root-level quick-access entries based on region and channel.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void insertDefaultRootQuickAccessEntries(SQLiteDatabase db) {
        boolean inChina = PhoneUtils.getInstance().isInChina();
        String channelCode = PhoneUtils.getInstance().getChannelCode();

        // Region-specific help entries
        if (inChina) {
            upsertRootQuickAccess(db, "https://www.xbext.com/docs/", "帮助", "https://www.xbext.com/docs/");
            upsertRootQuickAccess(db, "https://browser.umeweb.com/cn_ume_api/goto?target=sohu_new01",
                    "手机搜狐", "https://browser.umeweb.com/cn_ume_api/goto?target=sohu_new01");
        } else {
            upsertRootQuickAccess(db, "https://en.xbext.com/docs/", "Help", "https://en.xbext.com/docs/");
        }

        // Google Play specific games
        if (PhoneUtils.getInstance().isGooglePlayChannel()) {
            if (!inChina) {
                PhoneUtils.getInstance().isInIndia(); // Possibly triggers analytics/config
                upsertRootQuickAccess(db, "https://www.gamezop.com/?id=XyliIy87&_xbpm_=game_auto", "Game",
                        "https://www.gamezop.com/?id=XyliIy87&_xbpm_=pure_page");
                upsertRootQuickAccess(db, "https://8817.read.astrozop.com/?_xbpm_=pure_page", "Astro",
                        "https://8817.read.astrozop.com/?_xbpm_=pure_page");
                upsertRootQuickAccess(db, "https://9715.play.quizzop.com//?_xbpm_=pure_page", "Quiz",
                        "https://9715.play.quizzop.com//?_xbpm_=pure_page");
                upsertRootQuickAccess(db, "https://10552.read.criczop.com/", "Cricket",
                        "https://10552.read.criczop.com/");
                upsertRootQuickAccess(db, "https://play2036.gamereo.com/?_xbpm_=pure_page", "Game2",
                        "https://play2036.gamereo.com/?_xbpm_=pure_page");
                upsertRootQuickAccess(db, "https://play2036.thopquiz.com/?_xbpm_=pure_page", "Quiz2",
                        "https://play2036.thopquiz.com/?_xbpm_=pure_page");
            }

            // Global game entries
            upsertRootQuickAccess(db, "https://go.hypergames.top/Xmini/donttap/index.html", "Don't Tap",
                    "https://go.hypergames.top/Xmini/donttap/index.html");
            upsertRootQuickAccess(db, "https://go.hypergames.top/Xmini/footballsuperstars/index.html", "Football",
                    "https://go.hypergames.top/Xmini/footballsuperstars/index.html");
        }

        // Additional China-specific entries
        if (inChina) {
            upsertRootQuickAccess(db, "https://metaso.cn/?s=xllx&referrer_s=xllx", "秘塔AI",
                    "https://metaso.cn/?s=xllx&referrer_s=xllx");
            upsertRootQuickAccess(db, "https://browser.umeweb.com/cn_ume_api/goto?target=sohu_new01",
                    "手机搜狐", "https://browser.umeweb.com/cn_ume_api/goto?target=sohu_new01");
        }
    }

    public void m7496I() throws SQLException {
        try {
            getWritableDatabase().execSQL("DELETE FROM event_log");
        } catch (Exception unused) {
        }
    }

    public void m7497I0() throws SQLException {
        try {
            getWritableDatabase().execSQL("UPDATE bookmark SET item_order=_id");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m7498J() throws SQLException {
        try {
            getWritableDatabase().execSQL("DELETE FROM history");
        } catch (Exception unused) {
        }
    }

    public void m7499J0(JSONArray jSONArray) {
        SQLiteDatabase writableDatabase = getWritableDatabase();
        try {
            try {
                writableDatabase.beginTransaction();
                for (int i = 0; i < jSONArray.length(); i++) {
                    JSONObject jSONObject = jSONArray.getJSONObject(i);
                    String string = jSONObject.getString("url");
                    int i2 = jSONObject.getInt("item_order");
                    ContentValues contentValues = new ContentValues();
                    contentValues.put("item_order", Integer.valueOf(i2));
                    writableDatabase.update("bookmark", contentValues, "url= ?", new String[]{string});
                }
                writableDatabase.setTransactionSuccessful();
            } catch (Exception e) {
                e.printStackTrace();
            }
            writableDatabase.endTransaction();
            C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
        } catch (Throwable th) {
            writableDatabase.endTransaction();
            C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
            throw th;
        }
    }

    public void m7500K0(String str, int i) {
        try {
            getInstance().getWritableDatabase().execSQL("UPDATE bookmark SET status='" + i + "' WHERE url='" + str + "'");
        } catch (Exception unused) {
        } catch (Throwable th) {
            C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
            throw th;
        }
        C1089Xm.getInstance().m4822j("syncable_bookmark").incrementVersion();
    }

    public void m7501L0(SQLiteDatabase sQLiteDatabase, int i, String str) {
        ContentValues contentValues = new ContentValues();
        contentValues.put("guid", str);
        sQLiteDatabase.update("quick_access", contentValues, "_id= ? ", new String[]{i + ""});
        Log.i("affect", i + "");
    }

    public void deleteRecentHistory() throws SQLException {
        try {
            getWritableDatabase().execSQL("DELETE FROM history WHERE last_visit>" + this.creationTimestamp);
        } catch (Exception unused) {
        }
    }

    public void clearSearchHistory() throws SQLException {
        try {
            getWritableDatabase().execSQL("DELETE FROM search_his");
        } catch (Exception unused) {
        }
    }

    public final void m7504U(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE ad_block_log (_id INTEGER PRIMARY KEY,rule_hash TEXT UNIQUE,rule_data TEXT,rule_type INTEGER DEFAULT 0,hit_times INTEGER DEFAULT 0,host TEXT,origin_url TEXT,block_url TEXT,last_hit  LONG);");
        sQLiteDatabase.execSQL("create index if not exists inx_rule_hash on ad_block_log(rule_hash)");
        sQLiteDatabase.execSQL("create index if not exists inx_rule_host on ad_block_log(host)");
        sQLiteDatabase.execSQL("create index if not exists inx_origin_url on ad_block_log(origin_url)");
    }

    public final void m7505V(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE ad_block_rule (_id INTEGER PRIMARY KEY,rule_hash TEXT UNIQUE,rule_data TEXT,rule_type INTEGER DEFAULT 0,mark_times INTEGER DEFAULT 0,hit_times INTEGER DEFAULT 0,host TEXT DEFAULT '*',extra TEXT);");
        sQLiteDatabase.execSQL("create index if not exists inx_rule_hash on ad_block_rule(rule_hash)");
        sQLiteDatabase.execSQL("create index if not exists inx_rule_host on ad_block_rule(host)");
        sQLiteDatabase.execSQL("create index if not exists inx_rule_type on ad_block_rule(rule_type)");
    }

    public final void m7506W(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE bookmark (_id INTEGER PRIMARY KEY,guid TEXT ,title TEXT,url  TEXT UNIQUE,parent TEXT DEFAULT '/' ,type INTEGER DEFAULT 0,visits INTEGER,last_visit LONG,item_order INTEGER DEFAULT 0,status INTEGER DEFAULT 0);");
        sQLiteDatabase.execSQL("create index if not exists inx_url on bookmark(url)");
    }

    public final void m7507X(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE download (_id INTEGER PRIMARY KEY,download_id LONG,file_name TEXT,mime_type TEXT,title TEXT,url TEXT,path TEXT,ua TEXT,referer TEXT,dl_so_far LONG DEFAULT -1,total_size LONG DEFAULT -1,create_at LONG,try_times INTEGER DEFAULT 0,status INTEGER DEFAULT 0);");
    }

    public final void m7508Y(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE event_log (_id INTEGER PRIMARY KEY,event_type INTEGER DEFAULT 0,event_id INTEGER DEFAULT 0,event_message TEXT,create_at LONG);");
    }

    public final void m7509Z(SQLiteDatabase sQLiteDatabase) throws SQLException {
        sQLiteDatabase.execSQL("CREATE TABLE event_queue (_id INTEGER PRIMARY KEY,tran_id LONG DEFAULT 0,event_id INTEGER DEFAULT 0,event_params TEXT,create_at LONG,status INTEGER DEFAULT 0);");
    }

    public void m7510a(String str, int i) {
        m7500K0(str, i | getBookmarkStatus(str));
    }

    /**
     * Creates the H5 store table with indexes.
     */
    public final void createH5StoreTable(SQLiteDatabase db) throws SQLException {
        db.execSQL(
                "CREATE TABLE h5store (" +
                        "_id INTEGER PRIMARY KEY," +
                        "cate_id TEXT," +
                        "cate_name TEXT," +
                        "title TEXT," +
                        "intro TEXT," +
                        "url TEXT," +
                        "tag TEXT," +
                        "ctr_flag INTEGER DEFAULT 0," +
                        "created_at TEXT," +
                        "score INTEGER DEFAULT 0," +
                        "status INTEGER DEFAULT 0" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_cateid ON h5store(cate_id)");
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_url ON h5store(url)");
    }

    /**
     * Adds a ContentValues entry to the pending entries list (thread-safe).
     */
    public synchronized void addPendingEntry(ContentValues contentValues) {
        this.pendingEntries.add(contentValues);
    }

    /**
     * Creates the history table with an index on URL.
     */
    public final void createHistoryTable(SQLiteDatabase db) throws SQLException {
        db.execSQL(
                "CREATE TABLE history (" +
                        "_id INTEGER PRIMARY KEY," +
                        "title TEXT," +
                        "url TEXT," +
                        "host TEXT," +
                        "visits INTEGER," +
                        "last_visit LONG," +
                        "status INTEGER DEFAULT 0" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_url ON history(url)");
    }

    /**
     * Creates the host list table with indexes.
     */
    public final void createHostListTable(SQLiteDatabase db) throws SQLException {
        db.execSQL(
                "CREATE TABLE host_list (" +
                        "_id INTEGER PRIMARY KEY," +
                        "host TEXT," +
                        "host_type INTEGER DEFAULT 0," +
                        "extra TEXT" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_host ON host_list(host)");
        db.execSQL("CREATE UNIQUE INDEX IF NOT EXISTS inx_host_type ON host_list(host, host_type)");
    }

    /**
     * Creates the launcher table with an index on package name.
     */
    public final void createLauncherTable(SQLiteDatabase db) throws SQLException {
        db.execSQL(
                "CREATE TABLE launcher (" +
                        "_id INTEGER PRIMARY KEY," +
                        "package_name TEXT," +
                        "app_name TEXT," +
                        "item_order INTEGER DEFAULT 0," +
                        "visits INTEGER DEFAULT 0," +
                        "status INTEGER DEFAULT 0" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_pkg_name ON launcher(package_name)");
    }

    /**
     * Initializes the quick_access table and inserts default entries based on region and channel.
     *
     * @param db the writable SQLiteDatabase
     * @throws SQLException if any SQL operation fails
     */
    public final void initializeQuickAccess(SQLiteDatabase db) throws SQLException {
        // Create the quick_access table with columns and indexes
        db.execSQL(
                "CREATE TABLE quick_access (" +
                        "_id INTEGER PRIMARY KEY," +
                        "title TEXT," +
                        "url TEXT UNIQUE," +
                        "icon_uri TEXT," +
                        "guid TEXT," +
                        "parent TEXT DEFAULT 'root'," +
                        "create_at LONG," +
                        "item_type INTEGER DEFAULT 0," +
                        "item_order INTEGER DEFAULT 0," +
                        "extra TEXT," +
                        "status INTEGER DEFAULT 0" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_url ON quick_access(url)");
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_guid ON quick_access(guid)");
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_parentid ON quick_access(parent)");

        String historyLabel;

        // Locale-specific defaults
        if (PhoneUtils.getInstance().getLocaleCode().equals("zh-CN")) {
            // Skip certain channels
            String channel = PhoneUtils.getInstance().getChannelCode();
            if (!channel.equals("huawei") && !channel.equals("vivo") && !channel.equals("mi") && !channel.equals("oppo")) {
                // no-op, maybe analytics/config
            }

            // China-specific quick access entries
            insertDefaultVideoQuickAccess(db);
            insertQuickAccessEntry(db, "新浪微博", "https://m.weibo.cn/");
            insertQuickAccessEntry(db, "收藏", "x:bookmark");
            historyLabel = "历史";
        } else {
            // Non-China locale entries
            insertQuickAccessEntry(db, "Youtube", "https://m.youtube.com");
            insertDefaultSocialQuickAccess(db);
            insertQuickAccessEntry(db, "Bookmark", "x:bookmark");
            historyLabel = "History";
        }

        // Add history entry
        insertQuickAccessEntry(db, historyLabel, "x:history");

        // Insert region/global default root entries
        insertDefaultRootQuickAccessEntries(db);

        // Ensure Google Play channel setup
        PhoneUtils.getInstance().isGooglePlayChannel();
    }

    /**
     * Creates the `readlater` table with required columns and an index on URL.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void createReadLaterTable(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE readlater (" +
                        "_id INTEGER PRIMARY KEY," +
                        "title TEXT," +
                        "url TEXT," +
                        "visits INTEGER," +
                        "create_at LONG," +
                        "status INTEGER DEFAULT 0" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_url ON readlater(url);");
    }

    /**
     * Adds a `host` column to the `ad_block_rule` table and creates an index on it.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void addHostColumnToAdBlockRule(SQLiteDatabase db) {
        try {
            db.execSQL("ALTER TABLE ad_block_rule ADD COLUMN host TEXT;");
            db.execSQL("CREATE INDEX IF NOT EXISTS inx_rule_host ON ad_block_rule(host);");
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors if column/index already exists
        }
    }

    /**
     * Creates the `resource_map` table and an index on `resource_key`.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void createResourceMapTable(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE resource_map (" +
                        "_id INTEGER PRIMARY KEY," +
                        "resource_key TEXT," +
                        "resource_value TEXT," +
                        "resource_type INTEGER DEFAULT 0" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_key ON resource_map(resource_key);");
    }

    /**
     * Creates the `search_his` table and indexes on `last_search` and `key_words`.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void createSearchHistoryTable(SQLiteDatabase db) {
        db.execSQL(
                "CREATE TABLE search_his (" +
                        "_id INTEGER PRIMARY KEY," +
                        "key_words TEXT," +
                        "search_times INTEGER DEFAULT 0," +
                        "last_search LONG" +
                        ");"
        );
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_last_search ON search_his(last_search);");
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_keyword ON search_his(key_words);");
    }

    /**
     * Adds `parent`, `type`, and `item_order` columns to the `bookmark` table.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void addColumnsToBookmark(SQLiteDatabase db) {
        try {
            db.execSQL("ALTER TABLE bookmark ADD COLUMN parent TEXT DEFAULT '/';");
            db.execSQL("ALTER TABLE bookmark ADD COLUMN type INTEGER DEFAULT 0;");
            db.execSQL("ALTER TABLE bookmark ADD COLUMN item_order INTEGER DEFAULT 0;");
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors if columns already exist
        }
    }

    /**
     * Inserts default social network quick-access entries into the database.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void insertDefaultSocialQuickAccess(SQLiteDatabase db) {
        // Facebook quick access
        ContentValues facebook = new ContentValues();
        facebook.put("title", "Facebook");
        facebook.put("url", "https://m.facebook.com/");
        facebook.put("parent", "social-folder-demo");
        db.insert("quick_access", null, facebook);

        // Twitter quick access
        ContentValues twitter = new ContentValues();
        twitter.put("title", "Twitter");
        twitter.put("url", "https://mobile.twitter.com/");
        twitter.put("parent", "social-folder-demo");
        db.insert("quick_access", null, twitter);

        // Social folder entry
        ContentValues socialFolder = new ContentValues();
        socialFolder.put("title", "SocialNetwork");
        socialFolder.put("url", "guid:social-folder-demo");
        socialFolder.put("guid", "social-folder-demo");
        socialFolder.put("item_type", 1);
        socialFolder.put(
                "extra",
                "{ \"thumbnail\": [ " +
                        "'https://en.xbext.com/touch_icons/72x72/facebook.com.png', " +
                        "'https://en.xbext.com/touch_icons/72x72/twitter.com.png' " +
                        "] }"
        );
        socialFolder.put("parent", "root");
        db.insert("quick_access", null, socialFolder);
    }

    /**
     * Adds a GUID column to the `bookmark` table and creates an index on `quick_access.guid`.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void addGuidColumnToBookmark(SQLiteDatabase db) {
        try {
            db.execSQL("ALTER TABLE bookmark ADD COLUMN guid TEXT;");
            db.execSQL("CREATE INDEX IF NOT EXISTS inx_guid ON quick_access(guid);");
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors if column/index already exists
        }
    }

    /**
     * Creates the `user_script` table with required columns and indexes.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void createUserScriptTable(SQLiteDatabase db) {
        try {
            db.execSQL(
                    "CREATE TABLE user_script (" +
                            "_id INTEGER PRIMARY KEY," +
                            "script_id TEXT UNIQUE," +
                            "name TEXT," +
                            "namespace TEXT," +
                            "title TEXT," +
                            "script_desc TEXT," +
                            "script_data TEXT," +
                            "ex_point TEXT," +
                            "include_script TEXT," +
                            "exclude TEXT," +
                            "auto_run_at INTEGER DEFAULT 0," +
                            "create_by TEXT," +
                            "create_at LONG," +
                            "icon_url TEXT," +
                            "resources TEXT," +
                            "version TEXT," +
                            "source TEXT," +
                            "type INTEGER DEFAULT 0," +
                            "status INTEGER DEFAULT 1" +
                            ");"
            );

            db.execSQL("CREATE INDEX IF NOT EXISTS inx_script_id ON user_script(script_id);");
            db.execSQL("CREATE INDEX IF NOT EXISTS inx_ex_point ON user_script(ex_point);");
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors if table/index already exists
        }
    }

    /**
     * Adds new columns to the `download` table if they do not exist.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void addDownloadColumns(SQLiteDatabase db) {
        try {
            db.execSQL("ALTER TABLE download ADD COLUMN ua TEXT;");
            db.execSQL("ALTER TABLE download ADD COLUMN referer TEXT;");
            db.execSQL("ALTER TABLE download ADD COLUMN dl_so_far LONG DEFAULT -1;");
            db.execSQL("ALTER TABLE download ADD COLUMN total_size LONG DEFAULT -1;");
            db.execSQL("ALTER TABLE download ADD COLUMN try_times INTEGER DEFAULT 0;");
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors (e.g., if columns already exist)
        }
    }

    /**
     * Inserts default video quick-access entries into the database.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void insertDefaultVideoQuickAccess(SQLiteDatabase db) {
        // Bilibili quick access
        ContentValues bilibili = new ContentValues();
        bilibili.put("title", "哔哩哔哩");
        bilibili.put("url", "https://m.bilibili.com/?utm_source=xbrowser");
        bilibili.put("parent", "video-folder-demo");
        db.insert("quick_access", null, bilibili);

        // Tencent Video quick access
        ContentValues tencent = new ContentValues();
        tencent.put("title", "腾讯视频");
        tencent.put("url", "https://m.v.qq.com/?utm_source=xbrowser");
        tencent.put("parent", "video-folder-demo");
        db.insert("quick_access", null, tencent);

        // Video folder entry
        ContentValues videoFolder = new ContentValues();
        videoFolder.put("title", "视频");
        videoFolder.put("url", "guid:video-folder-demo");
        videoFolder.put("guid", "video-folder-demo");
        videoFolder.put("item_type", 1);
        videoFolder.put(
                "extra",
                "{ \"thumbnail\": [ " +
                        "'https://www.xbext.com/touch_icons/72x72/bilibili.com.png', " +
                        "'https://www.xbext.com/touch_icons/72x72/v.qq.com.png' " +
                        "] }"
        );
        videoFolder.put("parent", "root");
        db.insert("quick_access", null, videoFolder);
    }

    /**
     * Adds a new column `extra` to the `host_list` table if it does not exist.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void addExtraColumnToHostList(SQLiteDatabase db) {
        try {
            db.execSQL("ALTER TABLE host_list ADD COLUMN extra TEXT;");
        } catch (Exception e) {
            e.printStackTrace(); // Log but ignore errors if the column already exists
        }
    }

    /**
     * Recursively deletes a bookmark and its child bookmarks from the database.
     *
     * @param db      the writable SQLiteDatabase
     * @param parentUrl the URL of the bookmark to delete
     */
    public void deleteBookmarkRecursive(SQLiteDatabase db, String parentUrl) {
        Cursor cursor = null;
        try {
            cursor = db.query(
                    "bookmark",
                    DatabaseColumns.BOOKMARK,
                    "parent = ?",
                    new String[]{parentUrl},
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String childUrl = cursor.getString(cursor.getColumnIndex("url"));
                    int type = cursor.getInt(cursor.getColumnIndex("type"));

                    // Recursively delete child bookmarks if type == 1
                    if (type == 1) {
                        deleteBookmarkRecursive(db, childUrl);
                    }
                } while (cursor.moveToNext());
            }

            // Delete the parent bookmark and all entries where parent matches
            db.delete(
                    "bookmark",
                    "url = ? OR parent = ?",
                    new String[]{parentUrl, parentUrl}
            );
        } catch (Exception e) {
            e.printStackTrace();
            // Ensure deletion even on error
            db.delete(
                    "bookmark",
                    "url = ? OR parent = ?",
                    new String[]{parentUrl, parentUrl}
            );
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }
    }

    /**
     * Inserts a list of ContentValues into the specified table.
     * Optionally clears the table before inserting.
     *
     * @param tableName the name of the table
     * @param clearBeforeInsert true to delete existing rows before inserting
     * @return the number of successfully inserted rows
     */
    public synchronized int insertOrReplaceEntries(String tableName, boolean clearBeforeInsert) {
        SQLiteDatabase db = getWritableDatabase();
        int insertedCount = 0;

        try {
            db.beginTransaction();

            // Optionally clear existing table data
            if (clearBeforeInsert) {
                db.delete(tableName, null, null);
            }

            // Insert each entry from the list
            for (ContentValues values : pendingEntries) {
                try {
                    long rowId = db.insert(tableName, null, values);
                    if (rowId > 0) {
                        insertedCount++;
                    }
                } catch (Exception e) {
                    e.printStackTrace(); // log but continue with next entry
                }
            }

            db.setTransactionSuccessful();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            db.endTransaction();
            pendingEntries.clear(); // clear the in-memory list after committing
        }

        return insertedCount;
    }

    /**
     * Retrieves the status of a bookmark by URL.
     *
     * @param url the bookmark URL
     * @return the status of the bookmark, or 0 if not found
     */
    public int getBookmarkStatus(String url) {
        int status = 0;

        Cursor cursor = null;
        try {
            cursor = getReadableDatabase().query(
                    "bookmark",                     // Table name
                    DatabaseColumns.BOOKMARK,       // Columns to retrieve
                    "url = ?",                      // WHERE clause
                    new String[]{url},              // WHERE args
                    null,
                    null,
                    null
            );

            if (cursor != null && cursor.moveToFirst()) {
                status = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // log the exception
        } finally {
            if (cursor != null) {
                cursor.close();
            }
        }

        return status;
    }

    @Override
    public void onCreate(SQLiteDatabase sQLiteDatabase) throws SQLException {
        createHistoryTable(sQLiteDatabase);
        m7506W(sQLiteDatabase);
        m7507X(sQLiteDatabase);
        createLauncherTable(sQLiteDatabase);
        initializeQuickAccess(sQLiteDatabase);
        createReadLaterTable(sQLiteDatabase);
        m7505V(sQLiteDatabase);
        createHostListTable(sQLiteDatabase);
        createSearchHistoryTable(sQLiteDatabase);
        createH5StoreTable(sQLiteDatabase);
        createResourceMapTable(sQLiteDatabase);
        m7508Y(sQLiteDatabase);
        m7509Z(sQLiteDatabase);
        createUserScriptTable(sQLiteDatabase);
        m7504U(sQLiteDatabase);
        SharedPreferencesHelper.getInstance().f4849D = true;
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.i("provider", "Upgrading database from version " + oldVersion + " to " + newVersion + ", which will destroy all old data");

        if (oldVersion <= 2) {
            createLauncherTable(db);
            m7505V(db);
            createHostListTable(db);
            createSearchHistoryTable(db);
            createH5StoreTable(db);
            createResourceMapTable(db);
            m7508Y(db);
            addColumnsToBookmark(db);
            m7509Z(db);
            addExtraColumnToHostList(db);
            addDownloadColumns(db);
            addHostColumnToAdBlockRule(db);
            createUserScriptTable(db);
            m7504U(db);
            upgradeQuickAccessTable(db);
            addGuidColumnToBookmark(db);
            insertDefaultRootQuickAccessEntries(db);
            return;
        }

        if (oldVersion < 5) {
            m7505V(db);
            createHostListTable(db);
            createSearchHistoryTable(db);
            createH5StoreTable(db);
            createResourceMapTable(db);
            m7508Y(db);
            addColumnsToBookmark(db);
            m7509Z(db);
            addExtraColumnToHostList(db);
            addDownloadColumns(db);
            addHostColumnToAdBlockRule(db);
            createUserScriptTable(db);
            m7504U(db);
            upgradeQuickAccessTable(db);
            addGuidColumnToBookmark(db);
            insertDefaultRootQuickAccessEntries(db);
            return;
        }

        if (oldVersion == 5) {
            createLauncherTable(db);
            m7505V(db);
            createHostListTable(db);
        } else if (oldVersion == 6) {
            createSearchHistoryTable(db);
            createH5StoreTable(db);
        } else if (oldVersion == 7) {
            createH5StoreTable(db);
            createResourceMapTable(db);
            m7508Y(db);
            addColumnsToBookmark(db);
            addDownloadColumns(db);
            m7509Z(db);
            addExtraColumnToHostList(db);
        } else if (oldVersion == 8) {
            createResourceMapTable(db);
            m7508Y(db);
            addColumnsToBookmark(db);
        } else if (oldVersion == 9) {
            m7508Y(db);
            addColumnsToBookmark(db);
        } else if (oldVersion == 10) {
            addColumnsToBookmark(db);
        } else if (oldVersion == 11) {
            m7509Z(db);
        } else if (oldVersion <= 15) {
            addExtraColumnToHostList(db);
        } else if (oldVersion == 16) {
            addDownloadColumns(db);
        } else if (oldVersion == 17) {
            addHostColumnToAdBlockRule(db);
            m7504U(db);
            createUserScriptTable(db);
        } else if (oldVersion <= 21) {
            m7504U(db);
            upgradeQuickAccessTable(db);
        } else if (oldVersion == 22) {
            addIncludeScriptColumnToUserScript(db);
        } else if (oldVersion == 23) {
            addUserScriptTableColumn_ExcludeAutoRunAt(db);
        } else if (oldVersion <= 30) {
            m7504U(db);
            upgradeQuickAccessTable(db);
        } else if (oldVersion <= 32) {
            addUserScriptTableColumn_IconUrlSource(db);
            addUserScriptTableColumn_ResourcesVersion(db);
            upgradeQuickAccessTable(db);
            addGuidColumnToBookmark(db);
            addUserScriptTableColumn_NameNamespace(db);
        } else if (oldVersion == 33) {
            addUserScriptTableColumn_ResourcesVersion(db);
            upgradeQuickAccessTable(db);
            addGuidColumnToBookmark(db);
            addUserScriptTableColumn_NameNamespace(db);
        } else if (oldVersion <= 36) {
            upgradeQuickAccessTable(db);
            addGuidColumnToBookmark(db);
            addUserScriptTableColumn_NameNamespace(db);
        }

        insertDefaultRootQuickAccessEntries(db);
    }

    /**
     * Adds new columns and indexes to the quick_access table.
     *
     * @param db the writable SQLiteDatabase
     * @throws SQLException if SQL execution fails
     */
    public final void upgradeQuickAccessTable(SQLiteDatabase db) throws SQLException {
        db.execSQL("ALTER TABLE quick_access ADD COLUMN icon_uri TEXT;");
        db.execSQL("ALTER TABLE quick_access ADD COLUMN parent TEXT DEFAULT 'root';");
        db.execSQL("ALTER TABLE quick_access ADD COLUMN extra TEXT;");
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_guid ON quick_access(guid);");
        db.execSQL("CREATE INDEX IF NOT EXISTS inx_pid ON quick_access(parent);");
    }

    /**
     * Returns the maximum value of a column in a table, optionally filtered by parent.
     *
     * @param db the SQLiteDatabase
     * @param table the table name
     * @param column the column to find the maximum of
     * @param parent optional parent filter (can be null)
     * @return the maximum value, or 0 if table is empty or query fails
     */
    public int getMaxColumnValue(SQLiteDatabase db, String table, String column, String parent) {
        int max = 0;
        String[] args = null;
        String query = "SELECT MAX(" + column + ") AS max_order FROM " + table;
        if (!TextUtils.isEmpty(parent)) {
            query += " WHERE parent = ?";
            args = new String[]{parent};
        }

        try (Cursor cursor = db.rawQuery(query, args)) {
            if (cursor != null && cursor.moveToFirst()) {
                max = cursor.getInt(cursor.getColumnIndexOrThrow("max_order"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return max;
    }

    /**
     * Returns a comma-separated list of URLs from bookmarks with type = 1 and status containing bit 4.
     *
     * @return comma-separated URLs or empty string
     */
    public String getFilteredBookmarkUrls() {
        StringBuilder sb = new StringBuilder();
        try (Cursor cursor = getReadableDatabase().query(
                "bookmark",
                DatabaseColumns.BOOKMARK,
                "type = ?",
                new String[]{"1"},
                null,
                null,
                null
        )) {
            if (cursor != null && cursor.moveToFirst()) {
                do {
                    String url = cursor.getString(cursor.getColumnIndexOrThrow("url"));
                    int status = cursor.getInt(cursor.getColumnIndexOrThrow("status"));
                    if ((status & 4) == 4) {
                        if (sb.length() > 0) sb.append(",");
                        sb.append(url);
                    }
                } while (cursor.moveToNext());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return sb.toString();
    }

    /**
     * Retrieves the rule_data for a given rule_hash from ad_block_rule table.
     *
     * @param ruleHash the rule hash
     * @return the rule_data string or empty if not found
     */
    public String getAdBlockRuleData(String ruleHash) {
        try (Cursor cursor = getReadableDatabase().query(
                "ad_block_rule",
                DatabaseColumns.AD_BLOCK_RULE,
                "rule_hash = ?",
                new String[]{ruleHash},
                null,
                null,
                null
        )) {
            if (cursor != null && cursor.moveToFirst()) {
                return cursor.getString(cursor.getColumnIndexOrThrow("rule_data"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

    /**
     * Returns the total number of rows in a table.
     *
     * @param db the SQLiteDatabase
     * @param table the table name
     * @return the row count, or 0 if query fails
     */
    public int getTableRowCount(SQLiteDatabase db, String table) {
        int count = 0;
        try (Cursor cursor = db.rawQuery("SELECT COUNT(*) AS _count FROM " + table, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                count = cursor.getInt(cursor.getColumnIndexOrThrow("_count"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return count;
    }

    /**
     * Returns the total hit count from the ad_block_log table, optionally filtered by rule type.
     *
     * @param ruleTypeFilter 1 for rule_type <= 1, 2 for rule_type >= 2, any other value for no filter
     * @return the total hit count, or 0 if query fails
     */
    public int getAdBlockHitCount(int ruleTypeFilter) {
        String whereClause;
        switch (ruleTypeFilter) {
            case 1:
                whereClause = " WHERE rule_type <= 1";
                break;
            case 2:
                whereClause = " WHERE rule_type >= 2";
                break;
            default:
                whereClause = "";
                break;
        }

        int hitCount = 0;
        try (Cursor cursor = getReadableDatabase().rawQuery(
                "SELECT SUM(hit_times) AS hit_count FROM ad_block_log" + whereClause, null)) {
            if (cursor != null && cursor.moveToFirst()) {
                hitCount = cursor.getInt(cursor.getColumnIndexOrThrow("hit_count"));
            }
        } catch (Exception e) {
            e.printStackTrace(); // log exception and return 0
        }

        return hitCount;
    }

    /**
     * Adds the 'include_script' column to the 'user_script' table.
     *
     * @param db the writable SQLiteDatabase
     */
    public final void addIncludeScriptColumnToUserScript(SQLiteDatabase db) {
        try {
            db.execSQL("ALTER TABLE user_script ADD COLUMN include_script TEXT;");
        } catch (Exception e) {
            e.printStackTrace(); // log but ignore errors if column already exists
        }
    }

    /**
     * Inserts a quick-access entry into the database with default parent "root".
     *
     * @param db the writable SQLiteDatabase
     * @param title the title of the quick-access entry
     * @param url the URL of the entry
     */
    public final void insertQuickAccessEntry(SQLiteDatabase db, String title, String url) {
        insertQuickAccessEntry(db, title, url, "root");
    }

    /**
     * Inserts a single quick-access entry into the database.
     *
     * @param db the writable SQLiteDatabase
     * @param title the display title of the quick-access entry
     * @param url the URL of the entry
     * @param parent the parent folder or category
     */
    public final void insertQuickAccessEntry(SQLiteDatabase db, String title, String url, String parent) {
        ContentValues values = new ContentValues();
        values.put("title", title);
        values.put("url", url);
        values.put("parent", parent);
        db.insert("quick_access", null, values);
    }

    public final void addUserScriptTableColumn_ExcludeAutoRunAt(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN exclude TEXT ;");
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN auto_run_at INTEGER DEFAULT 0  ;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean m7541w0(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("quick_access", DatabaseColumns.QUICK_ACCESS, "url= ? AND status > ?", new String[]{str, "0"}, null, null, null);
        long j = -1;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return j >= 0;
    }

    public boolean m7542x0(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("bookmark", DatabaseColumns.BOOKMARK, "url= ?", new String[]{str}, null, null, null);
        long j = -1;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return j >= 0;
    }

    public boolean m7543y0(SQLiteDatabase sQLiteDatabase, String str) {
        Cursor cursorQuery = sQLiteDatabase.query("quick_access", DatabaseColumns.QUICK_ACCESS, "guid= ?", new String[]{str}, null, null, null);
        long j = -1;
        if (cursorQuery != null) {
            try {
                if (cursorQuery.moveToFirst()) {
                    j = cursorQuery.getLong(cursorQuery.getColumnIndexOrThrow("_id"));
                }
            } catch (Exception unused) {
                return false;
            }
        }
        return j >= 0;
    }

    public final void addUserScriptTableColumn_IconUrlSource(SQLiteDatabase sQLiteDatabase) throws SQLException {
        try {
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN icon_url TEXT ;");
            sQLiteDatabase.execSQL("ALTER TABLE user_script ADD COLUMN source TEXT  ;");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public boolean isUrlInQuickAccess(SQLiteDatabase database, String url) {
        Cursor cursor = database.query("quick_access", DatabaseColumns.QUICK_ACCESS, "url= ?", new String[]{url}, null, null, null);
        long recordId = -1;
        if (cursor != null) {
            try {
                if (cursor.moveToFirst()) {
                    recordId = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
                }
            } catch (Exception e) {
                return false;
            }
        }
        return recordId >= 0;
    }
}
