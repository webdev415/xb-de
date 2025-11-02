package com.mmbox.xbrowser.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.util.Log;

import androidx.annotation.NonNull;

import p000.DatabaseColumns;
import p000.MySQLiteOpenHelper;

public class BrowserProvider extends ContentProvider {

    public static String packageName;

    public static Uri uriHistory;

    public static Uri uriBookmark;

    public static Uri uriDownload;

    public static Uri uriReadlater;

    public static Uri uriQuickAccess;

    public static Uri uriLauncher;

    public static Uri uriAdBlockRule;

    public static Uri uriHostList;

    public static Uri uriHistoryHostGroup;

    public static Uri uriAdBlockGroup;

    public static UriMatcher uriMatcher;

    public SQLiteOpenHelper sqLiteOpenHelper;

    /**
     * Queries the host_list table for a specific host and type.
     *
     * @param host The host string to look for.
     * @param hostType The type of the host.
     * @param database The SQLiteDatabase instance to query.
     * @return The row ID (_id) if found, otherwise -1.
     */
    public final long getHostId(String host, int hostType, SQLiteDatabase database) {
        Cursor cursor = database.query(
                "host_list",
                DatabaseColumns.HOST_LIST,          // columns to select
                "host = ? AND host_type = ?",       // WHERE clause
                new String[]{host, String.valueOf(hostType)}, // selection args
                null,
                null,
                null
        );

        if (cursor == null) {
            return -1L;
        }

        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            }
            return -1L;
        } finally {
            cursor.close();
        }
    }

    public final void init() {
        packageName = getContext().getPackageName();

        uriHistory = Uri.parse("content://" + packageName + "/history");
        uriBookmark = Uri.parse("content://" + packageName + "/bookmark");
        uriDownload = Uri.parse("content://" + packageName + "/download");
        uriReadlater = Uri.parse("content://" + packageName + "/readlater");
        uriQuickAccess = Uri.parse("content://" + packageName + "/quick_access");
        uriLauncher = Uri.parse("content://" + packageName + "/launcher");
        uriAdBlockRule = Uri.parse("content://" + packageName + "/ad_block_rule");
        uriHostList = Uri.parse("content://" + packageName + "/host_list");
        uriHistoryHostGroup = Uri.parse("content://" + packageName + "/history_host_group");
        uriAdBlockGroup = Uri.parse("content://" + packageName + "/ad_block_group");

        uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
        uriMatcher.addURI(packageName, "history", 0);
        uriMatcher.addURI(packageName, "bookmark", 1);
        uriMatcher.addURI(packageName, "download", 2);
        uriMatcher.addURI(packageName, "readlater", 3);
        uriMatcher.addURI(packageName, "quick_access", 4);
        uriMatcher.addURI(packageName, "history_host_group", 5);
        uriMatcher.addURI(packageName, "launcher", 6);
        uriMatcher.addURI(packageName, "ad_block_rule", 7);
        uriMatcher.addURI(packageName, "host_list", 8);
        uriMatcher.addURI(packageName, "ad_block_group", 9);
    }

    public final long getLauncherIdByPackageName(String packageName, SQLiteDatabase database) {
        Cursor cursor = database.query("launcher", DatabaseColumns.LAUNCHER, "package_name= ?", new String[]{packageName}, null, null, null);
        if (cursor == null) {
            return -1L;
        }
        try {
            if (cursor.moveToFirst()) {
                return cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            }
            return -1L;
        } finally {
            cursor.close();
        }
    }

    public final long updateAdBlockRuleHitTimes(String ruleHash, SQLiteDatabase database) {
        Cursor cursor = database.query("ad_block_rule", DatabaseColumns.AD_BLOCK_RULE, "rule_hash= ?", new String[]{ruleHash}, null, null, null);
        if (cursor == null) {
            return -1L;
        }
        try {
            if (!cursor.moveToFirst()) {
                return -1L;
            }
            long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            ContentValues contentValues = new ContentValues();
            contentValues.put("hit_times", cursor.getInt(cursor.getColumnIndexOrThrow("hit_times")) + 1);
            database.update("ad_block_rule", contentValues, "_id=" + id, null);
            return id;
        } finally {
            cursor.close();
        }
    }

    @Override
    public int delete(@NonNull Uri uri, String whereClause, String[] whereArgs) {
        String table;
        SQLiteDatabase db = this.sqLiteOpenHelper.getWritableDatabase();
        switch (uriMatcher.match(uri)) {
            case 0:
                table = "history";
                break;
            case 1:
                table = "bookmark";
                break;
            case 2:
                table = "download";
                break;
            case 3:
                table = "readlater";
                break;
            case 4:
                table = "quick_access";
                break;
            case 6:
                table = "launcher";
                break;
            case 7:
                table = "ad_block_rule";
                break;
            case 8:
                table = "host_list";
                break;
            case 5:
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
        return db.delete(table, whereClause, whereArgs);
    }

    public final long updateBookmarkVisit(String title, String url, String parent, SQLiteDatabase database) {
        Cursor cursor = database.query("bookmark", DatabaseColumns.BOOKMARK, "url = ?", new String[]{url}, null, null, null);
        if (cursor == null) {
            return -1L;
        }
        try {
            if (!cursor.moveToFirst()) {
                return -1L;
            }

            long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));

            ContentValues values = new ContentValues();
            values.put("visits", cursor.getInt(cursor.getColumnIndexOrThrow("visits")) + 1);
            values.put("last_visit", System.currentTimeMillis());
            values.put("title", title);
            values.put("parent", parent);

            database.update("bookmark", values, "_id=" + id, null);
            return id;
        } finally {
            cursor.close();
        }
    }

    public final long updateHistoryVisit(String url, String title, SQLiteDatabase database) {
        Cursor cursor = database.query("history", DatabaseColumns.HISTORY, "url = ?", new String[]{url}, null, null, null);
        if (cursor == null) {
            return -1L;
        }
        try {
            if (!cursor.moveToFirst()) {
                return -1L;
            }

            long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));

            ContentValues values = new ContentValues();
            values.put("visits", cursor.getInt(cursor.getColumnIndexOrThrow("visits")) + 1);
            values.put("title", title);
            values.put("last_visit", System.currentTimeMillis());

            database.update("history", values, "_id=" + id, null);
            return id;
        } finally {
            cursor.close();
        }
    }

    public final long updateQuickAccess(String url, SQLiteDatabase database, ContentValues values) {
        Cursor cursor = database.query("quick_access", DatabaseColumns.QUICK_ACCESS, "url = ?", new String[]{url}, null, null, null);
        if (cursor == null) {
            return -1L;
        }
        try {
            if (!cursor.moveToFirst()) {
                return -1L;
            }

            long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            database.update("quick_access", values, "_id=" + id, null);
            return id;
        } finally {
            cursor.close();
        }
    }

    @Override
    public String getType(@NonNull Uri uri) {
        throw new IllegalArgumentException("getType method not implements yet");
    }

    public final long updateReadLaterTimestamp(String url, SQLiteDatabase database) {
        Cursor cursor = database.query("readlater", DatabaseColumns.READLATER, "url = ?", new String[]{url}, null, null, null);
        if (cursor == null) {
            return -1L;
        }
        try {
            if (!cursor.moveToFirst()) {
                return -1L;
            }

            long id = cursor.getLong(cursor.getColumnIndexOrThrow("_id"));
            ContentValues values = new ContentValues();
            values.put("create_at", System.currentTimeMillis());
            database.update("readlater", values, "_id=" + id, null);
            return id;
        } finally {
            cursor.close();
        }
    }

    @Override
    public Uri insert(Uri uri, ContentValues values) {
        long recordId;

        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();

        switch (uriMatcher.match(uri)) {

            case 0: // History
                recordId = updateHistoryVisit(
                        values.getAsString("url"),
                        values.getAsString("title"),
                        db
                );
                if (recordId < 0) {
                    recordId = db.insert("history", null, values);
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return Uri.parse(uriHistory + "/" + recordId);

            case 1: // Bookmark
                recordId = updateBookmarkVisit(
                        values.getAsString("title"),
                        values.getAsString("url"),
                        values.getAsString("parent"),
                        db
                );
                if (recordId < 0) {
                    recordId = db.insert("bookmark", null, values);
                    getContext().getContentResolver().notifyChange(uri, null);
                }
                return Uri.parse(uriBookmark + "/" + recordId);

            case 2: // Download
                return Uri.parse(uriDownload + "/" + db.insert("download", null, values));

            case 3: // Read Later
                recordId = updateReadLaterTimestamp(values.getAsString("url"), db);
                if (recordId < 0) {
                    recordId = db.insert("readlater", null, values);
                }
                return Uri.parse(uriReadlater + "/" + recordId);

            case 4: // Quick Access
                recordId = updateQuickAccess(values.getAsString("url"), db, values);
                if (recordId < 0) {
                    recordId = db.insert("quick_access", null, values);
                }
                return Uri.parse(uriQuickAccess + "/" + recordId);

            case 6: // Launcher
                recordId = getLauncherIdByPackageName(values.getAsString("package_name"), db);
                if (recordId == -1) {
                    recordId = db.insert("launcher", null, values);
                }
                return Uri.parse(uriLauncher + "/" + recordId);

            case 7: // Ad Block Rule
                recordId = updateAdBlockRuleHitTimes(values.getAsString("rule_hash"), db);
                if (recordId == -1) {
                    recordId = db.insert("ad_block_rule", null, values);
                }
                return Uri.parse(uriAdBlockRule + "/" + recordId);

            case 8: // Host List
                recordId = getHostId(
                        values.getAsString("host"),
                        values.getAsInteger("host_type"),
                        db
                );
                if (recordId == -1) {
                    recordId = db.insert("host_list", null, values);
                }
                return Uri.parse(uriHostList + "/" + recordId);

            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }


    @Override
    public boolean onCreate() {
        init();
        this.sqLiteOpenHelper = new MySQLiteOpenHelper(getContext());
        return true;
    }

    @Override
    public Cursor query(@NonNull Uri uri, String[] projection, String selection,
                        String[] selectionArgs, String sortOrder) {

        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        SQLiteQueryBuilder queryBuilder = new SQLiteQueryBuilder();
        Cursor resultCursor;
        String limit = "5"; // default row limit

        switch (uriMatcher.match(uri)) {

            case 0: // History
                queryBuilder.setTables("history");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, limit);
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 1: // Bookmark
                // Use a larger limit if sorting by last_visit
                limit = (sortOrder == null || !sortOrder.contains("last_visit")) ? "2000" : "5";
                queryBuilder.setTables("bookmark");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, limit);
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 2: // Download
                queryBuilder.setTables("download");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, "2000");
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 3: // Read Later
                queryBuilder.setTables("readlater");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, "2000");
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 4: // Quick Access
                queryBuilder.setTables("quick_access");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, "2000");
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 5: // History Host Ranking
                return db.rawQuery(
                        "SELECT COUNT(host) AS maxhost, host FROM history GROUP BY host ORDER BY maxhost DESC",
                        null
                );

            case 6: // Launcher
                queryBuilder.setTables("launcher");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, "2000");
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 7: // Ad Block Rule
                queryBuilder.setTables("ad_block_rule");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, "2000");
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 8: // Host List
                queryBuilder.setTables("host_list");
                resultCursor = queryBuilder.query(db, projection, selection, selectionArgs,
                        null, null, sortOrder, "2000");
                Log.i("database", ">> Executing query: " + selection);
                return resultCursor;

            case 9: // Ad Block Stats
                return db.rawQuery(
                        "SELECT SUM(hit_times) AS hit_count, rule_type FROM ad_block_rule GROUP BY rule_type",
                        null
                );

            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }
    }

    @Override
    public int update(@NonNull Uri uri, ContentValues values, String whereClause, String[] whereArgs) {
        SQLiteDatabase db = sqLiteOpenHelper.getWritableDatabase();
        String tableName;

        switch (uriMatcher.match(uri)) {
            case 0:
            case 1:
                return 0;
            case 2:
                tableName = "download";
                break;
            case 3:
                tableName = "readlater";
                break;
            case 4:
                tableName = "quick_access";
                break;
            case 6:
                tableName = "launcher";
                break;
            case 7:
                tableName = "ad_block_rule";
                break;
            case 8:
                tableName = "host_list";
                break;
            default:
                throw new IllegalArgumentException("Unsupported URI: " + uri);
        }

        return db.update(tableName, values, whereClause, whereArgs);
    }
}
