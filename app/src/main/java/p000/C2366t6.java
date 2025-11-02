package p000;

import com.mmbox.xbrowser.C1572g;
import java.io.File;
import java.nio.charset.StandardCharsets;

/* loaded from: classes.dex */
public class C2366t6 extends AbstractResourceManager {
    public C2366t6(String str) {
        super(str, false);
    }

    @Override
    public String getResourceValue() {
        return C1572g.getInstance().m7026h();
    }

    @Override
    public void applyResource(String str, boolean z) throws Throwable {
        FileUtils.writeBytesToFile(str.getBytes(StandardCharsets.UTF_8), new File(C1572g.getInstance().getInternalFilePath("context_menu")));
        C1572g.getInstance().m7036s();
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
