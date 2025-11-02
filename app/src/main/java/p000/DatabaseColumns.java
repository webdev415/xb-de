package p000;

/* loaded from: classes.dex */
public abstract class DatabaseColumns {

    public static final String[] HISTORY = {"_id", "title", "url", "host", "visits", "status", "last_visit"};

    public static final String[] BOOKMARK = {"_id", "title", "url", "parent", "type", "visits", "item_order", "status", "last_visit"};

    public static final String[] DOWNLOAD = {"_id", "download_id", "file_name", "mime_type", "title", "url", "path", "ua", "referer", "dl_so_far", "total_size", "create_at", "try_times", "status"};

    public static final String[] READLATER = {"_id", "title", "url", "visits", "create_at", "status"};

    public static final String[] QUICK_ACCESS = {"_id", "title", "url", "guid", "icon_uri", "parent", "create_at", "item_type", "item_order", "extra", "status"};

    public static final String[] LAUNCHER = {"_id", "package_name", "app_name", "item_order", "visits", "status"};

    public static final String[] AD_BLOCK_RULE = {"_id", "rule_hash", "rule_data", "rule_type", "mark_times", "hit_times", "host", "extra"};

    public static final String[] HOST_LIST = {"_id", "host", "host_type", "extra"};

    public static final String[] SEARCH_HISTORY = {"_id", "key_words", "search_times", "last_search"};

    public static final String[] H_5_STORE = {"_id", "cate_id", "cate_name", "title", "intro", "url", "tag", "ctr_flag", "created_at", "score", "status"};

    public static final String[] RESOURCE_MAP = {"_id", "resource_key", "resource_value", "resource_type"};

    public static final String[] EVENT_QUEUE = {"_id", "event_id", "tran_id", "event_params", "create_at", "status"};

    public static final String[] f5388m = {"_id", "event_type", "event_id", "event_message", "create_at"};

    public static final String[] USER_SCRIPT = {"_id", "script_id", "name", "namespace", "title", "script_desc", "script_data", "ex_point", "include_script", "exclude", "auto_run_at", "icon_url", "resources", "version", "source", "type", "create_by", "create_at", "status"};

    public static final String[] AD_BLOCK_LOG = {"_id", "rule_hash", "rule_data", "rule_type", "hit_times", "host", "origin_url", "block_url", "last_hit"};
}
