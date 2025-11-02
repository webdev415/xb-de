package p000;

import android.util.Log;
import org.json.JSONException;
import org.json.JSONObject;

public abstract class AbstractResourceManager {

    protected boolean isActive;
    protected String resourceType;
    protected int currentVersion = 0;
    protected int previousVersion = 0;
    protected int tempVersion = 0;
    protected int state = 0;
    protected boolean isEnabled = true;

    public AbstractResourceManager(String resourceType, boolean isActive) {
        this.resourceType = resourceType;
        this.isActive = isActive;
    }

    public final void updateResource(int version, String resValue) {
        this.currentVersion = version;
        this.previousVersion = version;
        applyResource(resValue, true);
        this.state = 1;
    }

    public void setState(int state) {
        this.state = state;
    }

    public void sync() {
        ResourceCacheManager.getInstance().saveResource(getResourceType(), toJson());
        this.state = 1;
    }

    public abstract String getResourceValue();

    public void applyResource(String resValue, boolean saveLocally) {
        if (saveLocally) {
            saveToLocal(resValue);
        } else {
            loadFromRemote(resValue);
        }
    }

    public String toJson() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("resource_type", this.resourceType);
            jsonObject.put("version_code", this.currentVersion);
            jsonObject.put("other_version_code", this.previousVersion);

            String resValue = this.isActive ? getResourceValue() : "->" + this.resourceType;
            jsonObject.put("res_value", resValue);

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String toJsonWithUser() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("user_id", C2439uo.getInstance().getUser().getUserId());
            jsonObject.put("resource_type", this.resourceType);
            jsonObject.put("version_code", this.currentVersion);
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String toJsonWithIncrement() {
        JSONObject jsonObject = new JSONObject();
        try {
            jsonObject.put("user_id", C2439uo.getInstance().getUser().getUserId());
            jsonObject.put("resource_type", this.resourceType);
            if (this.currentVersion == 0) this.currentVersion++;
            jsonObject.put("version_code", this.currentVersion);
            jsonObject.put("res_value", getResourceValue());
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonObject.toString();
    }

    public String getResourceType() {
        return this.resourceType;
    }

    public int getState() {
        return this.state;
    }

    public abstract String getKey();

    public int getCurrentVersion() {
        return this.currentVersion;
    }

    public boolean isModified() {
        return this.currentVersion != this.previousVersion;
    }

    public void loadFromCache() {
        try {
            String cachedStr = ResourceCacheManager.getInstance().getCachedResource(getResourceType());
            if (cachedStr != null) {
                JSONObject jsonObject = new JSONObject(cachedStr);
                this.currentVersion = jsonObject.getInt("version_code");
                String resValue = jsonObject.getString("res_value");
                if (this.isActive) {
                    applyResource(resValue, false);
                }
                this.previousVersion = jsonObject.getInt("other_version_code");
            }
        } catch (JSONException e) {
            e.printStackTrace();
        } finally {
            this.state = 1;
        }
    }

    public abstract void saveToLocal(String resValue);

    public void restoreFromBackup() {
        String path = PhoneUtils.getInstance().getBackupDirPath() + "/" + this.resourceType;
        try {
            if (FileUtils.fileExists(path)) {
                applyResource(C2439uo.getInstance().readFile(path), true);
                FileUtils.deleteFile(path);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            this.state = 1;
            this.currentVersion = this.previousVersion;
        }
    }

    public void incrementVersion() {
        this.currentVersion++;
    }

    public abstract void loadFromRemote(String resValue);

    public void resetVersion() {
        this.currentVersion = 0;
        this.previousVersion = 0;
    }

    public void setVersionCodes(int version) {
        this.currentVersion = version;
        this.previousVersion = version;
    }

    public void updateFromJson(String jsonStr) {
        try {
            JSONObject json = new JSONObject(jsonStr);
            int remoteVersion = json.getInt("version_code");
            int remoteStatus = json.getInt("status");

            // Log for syncable_quick_access resource type
            if ("syncable_quick_access".equals(this.resourceType)) {
                Log.i("xsync", "The remote status: " + remoteStatus + " " + this.resourceType);
            }

            switch (this.state) {
                case 2:
                    if (remoteStatus > 2) {
                        updateResource(remoteVersion, json.getString("res_value"));
                        return;
                    } else {
                        this.state = 9;
                        if (remoteStatus == 0 || this.currentVersion == -1) {
                            this.previousVersion = 0;
                            this.currentVersion = 1;
                        }
                    }
                    break;

                case 13:
                    String resValue = json.getString("res_value");
                    this.previousVersion = remoteVersion;
                    applyResource(resValue, false);
                    this.currentVersion = remoteVersion;
                    this.state = 1;
                    break;

                case 7:
                    if (remoteStatus == 5) {
                        updateResource(remoteVersion, json.getString("res_value"));
                        this.state = 10;
                        this.currentVersion = remoteVersion + 1;
                        this.tempVersion = remoteVersion;
                    } else if (remoteStatus == 6) {
                        this.tempVersion = 0;
                        this.previousVersion = this.currentVersion;
                        this.state = 8;
                    } else {
                        this.tempVersion = 0;
                        this.previousVersion = this.currentVersion;
                    }
                    break;

                default:
                    // Do nothing for other states
                    break;
            }
        } catch (Exception e) {
            e.printStackTrace();
            this.state = 1;
        }
    }

    public void incrementTempVersion() {
        int baseVersion = this.tempVersion == 0 ? this.currentVersion : this.tempVersion;
        this.currentVersion = baseVersion + 1;
        this.previousVersion = this.currentVersion;
    }

    public boolean hasBackupFile() {
        return FileUtils.fileExists(PhoneUtils.getInstance().getBackupDirPath() + "/" + this.resourceType);
    }
}
