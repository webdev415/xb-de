package p000;

import android.util.Log;
import com.mmbox.xbrowser.ContentDataManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import java.io.File;
import java.util.ArrayList;

public class C2369t9 extends DataSource {
    @Override
    public String mo8842b() {
        return "browser.blacklist";
    }

    @Override
    public int mo9037c() {
        return 5;
    }

    @Override
    public String mo61f() {
        return "browser.blacklist";
    }

    @Override
    public ArrayList mo62j(Object obj, int i) {
        if (i == 5) {
            String strMo9039e = mo9039e();
            try {
                File file = new File(ResourceCacheManager.getInstance().getUrlOrFilePath(strMo9039e, 1));
                String strM2046a = ResourceCacheManager.getInstance().getUrlOrFilePath(strMo9039e, 9);
                FileUtils.copyFile(file, new File(strM2046a));
                SharedPreferencesHelper.getInstance().putString("black-list", strM2046a);
            } catch (Exception e) {
                SharedPreferencesHelper.getInstance().putString("black-list", null);
                e.printStackTrace();
            }
        }
        Log.i("ad-block", "load total rules:" + ContentDataManager.getInstance().getUrlRules());
        return new ArrayList<>();
    }
}
