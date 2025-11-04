package p000;

import com.mmbox.xbrowser.MenuConfigManager;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class SyncTagSettingManager extends AbstractResourceManager {
    public SyncTagSettingManager(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return MenuConfigManager.getInstance().getToolMenuJsonString();
    }

    @Override
    public String getKey() {
        return "sync_tag_setting";
    }

    @Override
    public void saveToLocal(String str) throws Throwable {
        loadFromRemote(str);
    }

    @Override
    public void loadFromRemote(String str) throws Throwable {
        FileUtils.writeBytesToFile(str.getBytes(StandardCharsets.UTF_8), new File(MenuConfigManager.getInstance().getInternalFilePath("tool_menu")));
        MenuConfigManager.getInstance().m7036s();
    }
}
