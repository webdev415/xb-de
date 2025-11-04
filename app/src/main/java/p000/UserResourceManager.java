package p000;

import android.text.TextUtils;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import org.json.JSONException;
import org.json.JSONObject;

public class UserResourceManager extends AbstractResourceManager {

    // --- User info ---
    private String userId;
    private String userNick;
    private String userToken;

    // --- App behavior flags ---
    private boolean onceSetDefault;
    private boolean onceShareApp;
    private boolean rankingReviewed;
    private boolean tryAppRequest;
    private boolean rankingMessageBarShowed;

    // --- Counters ---
    private int userPoint;
    private int launchTimes;
    private int lastDay;
    private int daySearchTimes;

    // --- Flow trackers (bytes) ---
    private long privUpFlow;
    private long privDownFlow;
    private long privLeftFlow;
    private long privRewardFlow;

    private final long MAX_FLOW = 524_288_000L; // 500 MB

    public UserResourceManager(String resourceType) {
        super(resourceType, true);

        this.userId = null;
        this.userNick = "";
        this.userToken = "";

        this.onceSetDefault = false;
        this.onceShareApp = false;
        this.rankingReviewed = false;
        this.tryAppRequest = false;
        this.rankingMessageBarShowed = false;

        this.userPoint = 0;
        this.launchTimes = 0;
        this.lastDay = 0;
        this.daySearchTimes = 0;

        this.privUpFlow = 0L;
        this.privDownFlow = 0L;
        this.privRewardFlow = 0L;
        this.privLeftFlow = MAX_FLOW;
    }

    // --- Flow methods ---
    public long getDownloadFlow() { return this.privDownFlow; }

    public long getUploadFlow() { return this.privUpFlow; }

    public long getLeftFlow() {
        if (this.privLeftFlow < 0) this.privLeftFlow = 0L;
        return this.privLeftFlow;
    }

    public void addDownloadFlow(long bytes) { this.privDownFlow += bytes; }

    public void addUploadFlow(long bytes) { this.privUpFlow += bytes; }

    public void consumeLeftFlow(long bytes) {
        this.privLeftFlow -= bytes;
        if (this.privLeftFlow < 0) this.privLeftFlow = 0L;
    }

    // --- User info methods ---
    public String getUserId() {
        if (TextUtils.isEmpty(this.userId)) {
            this.userId = SharedPreferencesHelper.getInstance().getString(
                    "user_id", PhoneUtils.getInstance().getDeviceId()
            );
        }
        return this.userId;
    }

    public void setUserId(String id) {
        this.userId = id;
        SharedPreferencesHelper.getInstance().putString("user_id", id);
    }

    public String getUserNick() { return this.userNick; }
    public void setUserNick(String nick) { this.userNick = nick; }

    public String getUserToken() {
        if (TextUtils.isEmpty(this.userToken)) {
            this.userToken = SharedPreferencesHelper.getInstance().getString("user_token", "");
        }
        return this.userToken;
    }

    public void setUserToken(String token) {
        this.userToken = token;
        SharedPreferencesHelper.getInstance().putString("user_token", token);
    }

    public void clearUser() {
        setUserId("");
        setUserToken("");
    }

    // --- App usage methods ---
    public int getLastDay() { return this.lastDay; }
    public void setLastDay(int lastDay) { this.lastDay = lastDay; }

    public int getLaunchTimes() { return this.launchTimes; }
    public boolean hasTriedAppRequest() { return this.tryAppRequest; }

    public void resetDailySearchCount() { this.daySearchTimes = 0; }

    public void markRankingMessageBarShown() {
        this.rankingMessageBarShowed = true;
        SharedPreferencesHelper.getInstance().putBoolean("ranking_message_bar_showed", true);
    }

    public boolean shouldShowRankingMessageBar() {
        boolean persisted = SharedPreferencesHelper.getInstance()
                .getBoolean("ranking_message_bar_showed", false);
        return persisted ? persisted : this.rankingMessageBarShowed;
    }

    // --- AbstractResourceManager overrides ---
    @Override
    public String getResourceValue() throws JSONException {
        JSONObject json = new JSONObject();
        try {
            json.put("user_id", this.userId);
            json.put("user_nick", this.userNick);
            json.put("user_point", this.userPoint);
            json.put("once_set_default", this.onceSetDefault);
            json.put("once_share_app", this.onceShareApp);
            json.put("ranking_reviewed", this.rankingReviewed);
            json.put("try_app_request", this.tryAppRequest);
            json.put("launch_times", this.launchTimes);
            json.put("priv_down_flow", this.privDownFlow);
            json.put("priv_left_flow", this.privLeftFlow);
            json.put("priv_up_flow", this.privUpFlow);
            json.put("priv_reward_flow", this.privRewardFlow);
            json.put("ranking_message_bar_showed", this.rankingMessageBarShowed);
            json.put("last_day", this.lastDay);
            json.put("day_search_times", this.daySearchTimes);
        } catch (Exception ignored) {}
        return json.toString();
    }

    @Override
    public String getKey() { return "user-info"; }

    @Override
    public void saveToLocal(String str) { loadFromRemote(str); }

    @Override
    public void loadFromRemote(String str) {
        JSONObject json = new JSONObject(str);
        this.userNick = JsonUtils.getString(json, "user_nick", this.userNick);
        this.onceSetDefault = JsonUtils.getBoolean(json, "once_set_default", this.onceSetDefault);
        this.onceShareApp = JsonUtils.getBoolean(json, "once_share_app", this.onceShareApp);
        this.rankingMessageBarShowed = JsonUtils.getBoolean(json, "ranking_message_bar_showed", this.rankingMessageBarShowed);
        this.rankingReviewed = JsonUtils.getBoolean(json, "ranking_reviewed", this.rankingReviewed);
        this.tryAppRequest = JsonUtils.getBoolean(json, "try_app_request", this.tryAppRequest);
        this.launchTimes = JsonUtils.getInt(json, "launch_times", this.launchTimes);
        this.privDownFlow = JsonUtils.getLong(json, "priv_down_flow", this.privDownFlow);
        this.privUpFlow = JsonUtils.getLong(json, "priv_up_flow", this.privUpFlow);
        this.privRewardFlow = JsonUtils.getLong(json, "priv_reward_flow", this.privRewardFlow);
        this.privLeftFlow = JsonUtils.getLong(json, "priv_left_flow", this.privLeftFlow);
        this.userPoint = JsonUtils.getInt(json, "user_point", this.userPoint);
        this.lastDay = JsonUtils.getInt(json, "last_day", this.lastDay);
        this.daySearchTimes = JsonUtils.getInt(json, "day_search_times", this.daySearchTimes);
    }
}
