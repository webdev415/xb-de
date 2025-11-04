package p000;

import com.mmbox.xbrowser.MenuConfigManager;
import java.io.File;
import java.nio.charset.StandardCharsets;

public class C2366t6 extends AbstractResourceManager {
    public C2366t6(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return MenuConfigManager.getInstance().m7026h();
    }

    @Override
    public void applyResource(String str, boolean z) {
        FileUtils.writeBytesToFile(str.getBytes(StandardCharsets.UTF_8), new File(MenuConfigManager.getInstance().getInternalFilePath("context_menu")));
        MenuConfigManager.getInstance().m7036s();
    }

    @Override
    public String getKey() {
        return "sync_tag_setting";
    }

    @Override
    public void saveToLocal(String str) {
    }

    @Override
    public void loadFromRemote(String str) {
    }
}
