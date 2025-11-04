package p000;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import android.util.Log;
import android.widget.FrameLayout;
import com.mmbox.xbrowser.controllers.WebViewBrowserController;
import java.io.File;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.StringTokenizer;

public abstract class ContentViewManager {

    public FrameLayout frameLayout;

    public Context context;

    public final File file;

    public final ArrayList<Tab> tabList = new ArrayList<>(3);

    public final Handler handler = new Handler(Looper.getMainLooper());

    public int currentActiveIndex = -1;

    public final boolean f6880g = true;

    public volatile boolean f6881h = false;

    public SharedPreferences preferences = null;

    public c f6883j = null;

    public interface c {
        void mo6289a(InterfaceC0345Hd interfaceC0345Hd);

        void mo6294b();

        void mo6299c(InterfaceC0345Hd interfaceC0345Hd);

        void mo6304d();
    }

    public class Tab {

        public String tabId = null;

        public boolean lock = false;

        public String f6890c = "";

        public int index = -1;

        public int order = -1;

        public String lastTitle = "";

        public String lastUrl = "";

        public boolean f6896i = false;

        public ArrayList f6893f = new ArrayList<>();

        public Tab(String str) {
            this.tabId = str;
            if (TextUtils.isEmpty(str)) {
                this.tabId = System.currentTimeMillis() + "";
            }
        }

        public void m9322A(WebPage page) {
            InterfaceC0345Hd interfaceC0345HdMo5705r = mo5705r(context.getPackageName(), WebViewBrowserController.class.getName());
            if (interfaceC0345HdMo5705r instanceof WebViewBrowserController) {
                ((WebViewBrowserController) interfaceC0345HdMo5705r).m6792b1(tabId, page.title, page.url);
                this.f6893f.add(interfaceC0345HdMo5705r);
                this.index = 0;
            }
        }

        public void m9323B(String str, SharedPreferences.Editor editor) throws Resources.NotFoundException {
            InterfaceC0345Hd interfaceC0345HdM9333l = m9333l();
            if (interfaceC0345HdM9333l instanceof WebViewBrowserController) {
                WebViewBrowserController webViewBrowserController = (WebViewBrowserController) interfaceC0345HdM9333l;
                this.lastTitle = webViewBrowserController.mo1574c();
                this.lastUrl = webViewBrowserController.getUrlFromTitle();
            }
            if (this.f6893f.isEmpty() && this.f6896i) {
                editor.putBoolean(str + ".lock", this.lock);
                return;
            }
            int size = this.f6893f.size();
            editor.putInt(str + ".size", size);
            editor.putInt(str + ".index", this.index);
            editor.putBoolean(str + ".lock", this.lock);
            for (int i = 0; i < size; i++) {
                InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(i);
                String str2 = str + ".v_" + i;
                interfaceC0345Hd.mo1585v(str2, editor);
                editor.putString(str2 + ".c" + i, interfaceC0345Hd.getClass().getName());
                editor.putString(str2 + ".pkg", interfaceC0345Hd.getPackageName());
                if (interfaceC0345Hd instanceof WebViewBrowserController) {
                    WebViewBrowserController webViewBrowserController2 = (WebViewBrowserController) interfaceC0345Hd;
                    String lastTitle = webViewBrowserController2.mo1574c();
                    String lastUrl = webViewBrowserController2.getUrlFromTitle();
                    if (lastTitle == null || lastTitle.length() == 0) {
                        lastTitle = lastUrl;
                    }
                    editor.putString(str2 + ".last_title", lastTitle);
                    editor.putString(str2 + ".last_url", lastUrl);
                }
            }
        }

        public void m9324C(boolean z) {
            this.lock = z;
        }

        public void m9325d(InterfaceC0345Hd interfaceC0345Hd) {
            m9327f(interfaceC0345Hd, true);
        }

        public void m9326e(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
            if (z) {
                m9331j();
            }
            m9325d(interfaceC0345Hd);
        }

        public void m9327f(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
            Log.i("tab", ">>>>>  add new tab:" + z);
            int iIndexOf = this.f6893f.indexOf(interfaceC0345Hd);
            int i = this.index;
            InterfaceC0345Hd interfaceC0345Hd2 = (i < 0 || i >= this.f6893f.size()) ? null : (InterfaceC0345Hd) this.f6893f.get(this.index);
            if (iIndexOf < 0) {
                m9330i(this.index + 1);
                int size = this.f6893f.size();
                int i2 = this.index;
                if (i2 != size) {
                    for (int i3 = size - 1; i3 >= i2; i3--) {
                        InterfaceC0345Hd interfaceC0345Hd3 = (InterfaceC0345Hd) this.f6893f.remove(i3);
                        if (f6883j != null) {
                            f6883j.mo6299c(interfaceC0345Hd3);
                        }
                        interfaceC0345Hd3.onDestroy();
                    }
                }
                this.f6893f.add(interfaceC0345Hd);
            } else {
                InterfaceC0345Hd interfaceC0345Hd4 = (InterfaceC0345Hd) this.f6893f.get(this.index);
                if (interfaceC0345Hd4 != null) {
                    interfaceC0345Hd4.mo1576g();
                }
                m9330i(iIndexOf);
            }
            if (z) {
                if (interfaceC0345Hd2 != null) {
                    interfaceC0345Hd2.mo1576g();
                }
                m9301Y(interfaceC0345Hd);
            }
        }

        public boolean isValidNextIndex() {
            if (index < 0) {
                return false;
            }
            InterfaceC0345Hd currentItem = (InterfaceC0345Hd) this.f6893f.get(index);
            return currentItem.hasNext() || index < this.f6893f.size() - 1;
        }

        public boolean isValidPreviousIndex() {
            if (index < 0) {
                return false;
            }
            InterfaceC0345Hd currentItem = (InterfaceC0345Hd) this.f6893f.get(index);
            return currentItem.hasPrevious() || index > 0;
        }

        public final void m9330i(int i) {
            this.index = i;
        }

        public void m9331j() {
            for (int i = 0; i < this.f6893f.size(); i++) {
                InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(i);
                frameLayout.removeView(interfaceC0345Hd.mo1695d());
                if (f6883j != null) {
                    f6883j.mo6299c(interfaceC0345Hd);
                }
                interfaceC0345Hd.onDestroy();
            }
            this.f6893f.clear();
            this.index = -1;
        }

        public InterfaceC0345Hd m9332k(int i) {
            return (InterfaceC0345Hd) this.f6893f.get(i);
        }

        public InterfaceC0345Hd m9333l() {
            if (index < 0 || index >= this.f6893f.size()) {
                return null;
            }
            return (InterfaceC0345Hd) this.f6893f.get(this.index);
        }

        public ArrayList m9334m() {
            ArrayList arrayList = new ArrayList<>();
            if (this.index < 0) {
                return arrayList;
            }
            for (int i = 0; i < this.f6893f.size(); i++) {
                arrayList.add((InterfaceC0345Hd) this.f6893f.get(i));
            }
            return arrayList;
        }

        public ArrayList m9335n() {
            return this.f6893f;
        }

        public int m9336o() {
            return this.index;
        }

        public String m9337p() {
            return this.lastTitle;
        }

        public String m9338q() {
            return this.lastUrl;
        }

        public String getTabId() {
            if (tabId != null) {
                return tabId;
            }
            throw new IllegalStateException("tab id not be set yet");
        }

        public void m9340s() {
            InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(this.index);
            if (interfaceC0345Hd.hasPrevious()) {
                interfaceC0345Hd.mo1580n();
            } else if (isValidPreviousIndex()) {
                m9330i(this.index - 1);
                InterfaceC0345Hd interfaceC0345Hd2 = (InterfaceC0345Hd) this.f6893f.get(this.index);
                interfaceC0345Hd.mo1576g();
                m9301Y(interfaceC0345Hd2);
            }
            if (f6883j != null) {
                f6883j.mo6294b();
            }
        }

        public void m9341t() {
            InterfaceC0345Hd interfaceC0345Hd = (InterfaceC0345Hd) this.f6893f.get(this.index);
            if (interfaceC0345Hd.hasNext()) {
                interfaceC0345Hd.mo1578l();
            } else if (isValidNextIndex()) {
                m9330i(this.index + 1);
                InterfaceC0345Hd interfaceC0345Hd2 = (InterfaceC0345Hd) this.f6893f.get(this.index);
                interfaceC0345Hd.mo1576g();
                m9301Y(interfaceC0345Hd2);
            }
            if (f6883j != null) {
                f6883j.mo6304d();
            }
        }

        public boolean m9342u(InterfaceC0345Hd interfaceC0345Hd) {
            return this.f6893f.contains(interfaceC0345Hd);
        }

        public void m9343v() {
            if (this.f6896i) {
                this.f6896i = false;
                m9347z(this.tabId, preferences);
            }
        }

        public boolean m9344w() {
            return this.f6896i;
        }

        public boolean m9345x() {
            return this.lock;
        }

        public void m9346y(String str, SharedPreferences sharedPreferences) {
            this.f6896i = true;
            preferences = sharedPreferences;
            int size = sharedPreferences.getInt(str + ".size", 0);
            int index = sharedPreferences.getInt(str + ".index", 0);
            this.lock = sharedPreferences.getBoolean(str + ".lock", false);
            int iMax = size > 0 ? (index < 0 || index >= size) ? Math.max(0, Math.min(index, size - 1)) : index : 0;
            String str2 = str + ".v_" + iMax;
            this.lastTitle = sharedPreferences.getString(str2 + ".last_title", "");
            this.lastUrl = sharedPreferences.getString(str2 + ".last_url", "");
            this.index = iMax;
        }

        public boolean m9347z(String str, SharedPreferences sharedPreferences) {
            try {
                try {
                    int size = sharedPreferences.getInt(str + ".size", 0);
                    this.index = sharedPreferences.getInt(str + ".index", 0);
                    this.lock = sharedPreferences.getBoolean(str + ".lock", false);
                    String packageName = context.getPackageName();
                    for (int i2 = 0; i2 < size; i2++) {
                        String str2 = str + ".v_" + i2;
                        String string = sharedPreferences.getString(str2 + ".c" + i2, "");
                        if (string.equals(WebViewBrowserController.class.getName())) {
                            InterfaceC0345Hd interfaceC0345HdMo5705r = mo5705r(packageName, string);
                            if (interfaceC0345HdMo5705r.mo1582r(str2, sharedPreferences)) {
                                this.f6893f.add(interfaceC0345HdMo5705r);
                            }
                        }
                    }
                    if (this.f6893f.size() != 0) {
                        if (this.index >= this.f6893f.size() - 1) {
                            this.index = this.f6893f.size() - 1;
                        }
                        return true;
                    }
                    this.index = -1;
                    if (-1 >= this.f6893f.size() - 1) {
                        this.index = this.f6893f.size() - 1;
                    }
                    return false;
                } catch (Exception e) {
                    e.printStackTrace();
                    if (this.index < this.f6893f.size() - 1) {
                        return false;
                    }
                    this.index = this.f6893f.size() - 1;
                    return false;
                }
            } catch (Throwable th) {
                if (this.index >= this.f6893f.size() - 1) {
                    this.index = this.f6893f.size() - 1;
                }
                throw th;
            }
        }
    }

    public ContentViewManager(Context context, FrameLayout frameLayout) {
        this.frameLayout = null;
        this.context = null;
        this.frameLayout = frameLayout;
        this.context = context;
        this.file = context.getDir("thumbnails", 0);
    }

    public Tab getActiveTab() {
        if (currentActiveIndex == -1 || tabList.isEmpty()) {
            return null;
        }
        return tabList.get(currentActiveIndex);
    }

    public final int getActiveIndex() {
        return this.currentActiveIndex;
    }

    public ArrayList m9279C(int i) {
        if (i >= 0 && i < this.tabList.size()) {
            return tabList.get(i).m9335n();
        }
        return null;
    }

    public final int getTabCount() {
        return this.tabList.size();
    }

    public int m9281E(String str) {
        int i = -1;
        for (int i2 = 0; i2 < this.tabList.size(); i2++) {
            if (((Tab) this.tabList.get(i2)).getTabId().equals(str)) {
                i = i2;
            }
        }
        return i;
    }

    public final Tab getTab(int i) {
        return (Tab) this.tabList.get(i);
    }

    public final String getTabId(int i) {
        if (i >= 0 && i < this.tabList.size()) {
            return this.tabList.get(i).getTabId();
        }
        throw new IllegalStateException("invalid stack index[" + i + "]");
    }

    public int m9284H(InterfaceC0345Hd interfaceC0345Hd) {
        for (int i = 0; i < this.tabList.size(); i++) {
            if (this.tabList.get(i).m9342u(interfaceC0345Hd)) {
                return i;
            }
        }
        return -1;
    }

    public final int getTabIndexById(String str) {
        for (int i = 0; i < this.tabList.size(); i++) {
            if (this.tabList.get(i).getTabId().equals(str)) {
                return i;
            }
        }
        return -1;
    }

    public final ArrayList<Tab> getTabList() {
        return this.tabList;
    }

    public void m9287K() {
        if (getActiveTab() != null) {
            getActiveTab().m9340s();
        }
    }

    public void m9288L() {
        if (getActiveTab() != null) {
            getActiveTab().m9341t();
        }
    }

    public final boolean m9289M(InterfaceC0345Hd interfaceC0345Hd) {
        Tab tabVarM9277A = getActiveTab();
        return tabVarM9277A != null && tabVarM9277A.m9333l() == interfaceC0345Hd;
    }

    public final void m9290N() {
        if (tabList.size() > currentActiveIndex + 1) {
            m9298V(currentActiveIndex + 1);
        } else {
            m9298V(0);
        }
    }

    public final void m9291O() {
        if (currentActiveIndex <= 0) {
            currentActiveIndex = this.tabList.size();
        }
        m9298V(currentActiveIndex - 1);
    }

    public void m9292P(Runnable runnable) {
        ArrayList<Tab> tabs = new ArrayList<>(tabList.size());
        for (int i = 0; i < tabList.size(); i++) {
            Tab tab = tabList.get(i);
            if (!tab.lock) {
                tabs.add(tab);
            }
        }
        if (tabs.isEmpty()) {
            if (runnable != null) {
                handler.post(runnable);
            }
        } else {
            frameLayout.removeAllViews();
            f6881h = true;
            handler.post(new Runnable() {
                @Override
                public void run() {
                    int iMin = Math.min(3, tabs.size());
                    for (int i = 0; i < iMin; i++) {
                        Tab tab = tabs.remove(0);
                        try {
                            InterfaceC0345Hd interfaceC0345HdM9333l = tab.m9333l();
                            if (interfaceC0345HdM9333l != null) {
                                frameLayout.removeView(interfaceC0345HdM9333l.mo1695d());
                                interfaceC0345HdM9333l.mo1576g();
                            }
                            tab.m9331j();
                            tabList.remove(tab);
                        } catch (Throwable th) {
                            Log.w("ContentViewManager", "destroy tab failed: " + th);
                        }
                    }
                    if (!tabs.isEmpty()) {
                        handler.post(this);
                        return;
                    }
                    if (tabList.isEmpty()) {
                        currentActiveIndex = -1;
                    } else {
                        if (currentActiveIndex < 0 || currentActiveIndex >= tabList.size()) {
                            currentActiveIndex = 0;
                        }
                        m9298V(currentActiveIndex);
                    }
                    f6881h = false;
                    if (runnable != null) {
                        runnable.run();
                    }
                }
            });
        }
    }

    public final void removeTabAtIndex(int index) {
        if (this.tabList.isEmpty()) {
            return; // No tabs to remove
        }

        if (index < 0 || index >= this.tabList.size()) {
            throw new IllegalStateException("Invalid tab index: " + index);
        }

        boolean tabChanged = false;

        if (this.tabList.size() == 1) {
            // Only one tab, reset index
            this.currentActiveIndex = -1;
        } else {
            int currentIndex = this.currentActiveIndex;

            if (index == currentIndex) {
                // If the tab to remove is the current one, move the index
                if (index == (this.tabList.size() - 1)) {
                    this.currentActiveIndex = index - 1;  // Move to the previous tab
                } else {
                    this.currentActiveIndex = index + 1;  // Move to the next tab
                }
                tabChanged = true;
            } else if (index < currentIndex) {
                // If the tab is before the current index, adjust the current index
                this.currentActiveIndex--;
            }
        }

        // Remove the tab at the specified index
        tabList.remove(index).m9331j();

        // If the current index is valid, show the new tab or exit
        if (this.currentActiveIndex >= 0 && this.currentActiveIndex < this.tabList.size()) {
            if (tabChanged) {
                m9298V(this.currentActiveIndex); // Handle the visual update for the tab change
            }
        }
    }

    public void removeTab(String id) {
        int index = getTabIndexById(id);
        if (index >= 0) {
            removeTabAtIndex(index);
            return;
        }
        throw new IllegalStateException("not found stack with give stackid:" + id);
    }

    public boolean restoreUserData(SharedPreferences sharedPreferences) {
        AndroidSystemUtils.startTiming("restoreState");
        Log.i("save-state", "Preparing to restore user data... current tab index: " + currentActiveIndex);

        // Ensure current tab index is valid
        if (currentActiveIndex < 0) {
            currentActiveIndex = sharedPreferences.getInt("current_stack_index", 0);
        }

        Log.i("save-state", "Restoring user data... current tab index: " + currentActiveIndex);

        // Get the saved tab list from shared preferences
        String savedTabList = sharedPreferences.getString("pref-tab-list", null);
        if (TextUtils.isEmpty(savedTabList)) {
            return false; // No saved tabs to restore
        }

        try {
            StringTokenizer tokenizer = new StringTokenizer(savedTabList, ",");
            int index = 0;
            boolean restoreSuccess = false;

            // Iterate through the saved tab list and restore each tab
            while (tokenizer.hasMoreTokens()) {
                Tab tab = new Tab(tokenizer.nextToken());
                if (index == currentActiveIndex) {
                    if (tab.m9347z(tab.tabId, sharedPreferences)) {
                        restoreSuccess = true;
                    } else {
                        Log.i("save-state", "Failed to restore tab: " + tab.tabId);
                    }
                } else {
                    tab.m9346y(tab.tabId, sharedPreferences);
                }
                tabList.add(tab);
                index++;
            }

            // Finalize restoration process
            if (restoreSuccess && currentActiveIndex >= 0 && currentActiveIndex < tabList.size()) {
                m9298V(currentActiveIndex);
                return true;
            } else {
                Log.i("save-state", "Invalid tab index or failed to restore tab");
                return false;
            }
        } catch (Exception e) {
            Log.i("save-state", "Error restoring user data: " + e);
            e.printStackTrace();
            tabList.clear();
            currentActiveIndex = -1;
            return false;
        } finally {
            AndroidSystemUtils.logElapsedTime();
        }
    }

    public void m9296T(ArrayList<WebPage> pages) {
        for (WebPage page : pages) {
            Tab tab = new Tab(null);
            tab.m9322A(page);
            tabList.add(tab);
        }
    }

    public void m9297U(SharedPreferences sharedPreferences) {
        AndroidSystemUtils.startTiming("saveState");
        int size = this.tabList.size();
        int iM9278B = getActiveIndex();
        SharedPreferences.Editor editorEdit = sharedPreferences.edit();
        if (iM9278B < 0 || iM9278B >= size) {
            iM9278B = 0;
        }
        editorEdit.putInt("current_stack_index", iM9278B).apply();
        editorEdit.putInt("num_tabs", size).apply();
        StringBuffer stringBuffer = new StringBuffer();
        for (int i = 0; i < size; i++) {
            Tab tabVar = (Tab) this.tabList.get(i);
            WebViewBrowserController webViewBrowserController = (WebViewBrowserController) tabVar.m9333l();
            if (webViewBrowserController == null || webViewBrowserController.mo5626h() != 8) {
                stringBuffer.append(i == 0 ? tabVar.tabId : "," + tabVar.tabId);
                tabVar.m9323B(tabVar.tabId, editorEdit);
            }
        }
        editorEdit.putString("pref-tab-list", stringBuffer.toString());
        int i2 = this.currentActiveIndex;
        if (i2 >= 0 && i2 < this.tabList.size()) {
            Tab tabVar2 = (Tab) this.tabList.get(this.currentActiveIndex);
            WebViewBrowserController webViewBrowserController2 = (WebViewBrowserController) tabVar2.m9333l();
            String strMo1573b = webViewBrowserController2 != null ? webViewBrowserController2.getUrlFromTitle() : tabVar2.m9338q();
            if (strMo1573b == null) {
                strMo1573b = "";
            }
            editorEdit.putString("last-active-tab-url", strMo1573b);
        }
        editorEdit.commit();
        Log.i("save-state", ">>>>>>>>> saveState finished>>>>>>");
        AndroidSystemUtils.logElapsedTime();
    }

    public final void m9298V(int i) {
        if (i >= 0 && i <= this.tabList.size() - 1) {
            m9299W(tabList.get(i));
            return;
        }
        throw new IllegalStateException("specify stack id not exist [" + i + "]");
    }

    public final void m9299W(Tab tabVar) {
        int iIndexOf = this.tabList.indexOf(tabVar);
        if (iIndexOf >= 0) {
            tabVar.m9343v();
            Tab tabVarM9277A = getActiveTab();
            InterfaceC0345Hd interfaceC0345HdM9333l = tabVarM9277A.m9333l();
            if (interfaceC0345HdM9333l instanceof WebViewBrowserController) {
                WebViewBrowserController webViewBrowserController = (WebViewBrowserController) interfaceC0345HdM9333l;
                tabVarM9277A.lastTitle = webViewBrowserController.mo1574c();
                tabVarM9277A.lastUrl = webViewBrowserController.getUrlFromTitle();
            }
            if (interfaceC0345HdM9333l != null) {
                interfaceC0345HdM9333l.mo1576g();
            }
            this.currentActiveIndex = iIndexOf;
            InterfaceC0345Hd interfaceC0345HdM9333l2 = tabVar.m9333l();
            if (interfaceC0345HdM9333l2 != null) {
                m9301Y(interfaceC0345HdM9333l2);
            }
        }
    }

    public void m9300X(String str) {
        Iterator it = this.tabList.iterator();
        while (it.hasNext()) {
            Tab tabVar = (Tab) it.next();
            if (tabVar.getTabId().equals(str)) {
                m9299W(tabVar);
                return;
            }
        }
    }

    public final void m9301Y(InterfaceC0345Hd interfaceC0345Hd) {
        this.frameLayout.removeAllViews();
        this.frameLayout.addView(interfaceC0345Hd.mo1695d(), new FrameLayout.LayoutParams(-1, -1));
        interfaceC0345Hd.mo1584u();
        Log.i("ContentViewManager", ">>>>>>>>add view to continer " + interfaceC0345Hd.mo1695d());
        c cVar = this.f6883j;
        if (cVar != null) {
            cVar.mo6289a(interfaceC0345Hd);
        }
    }

    public void m9302Z(c cVar) {
        this.f6883j = cVar;
    }

    public final void m9303a0(ArrayList arrayList) {
        if (arrayList.size() != this.tabList.size()) {
            ArrayList arrayList2 = new ArrayList<>(3);
            for (int i = 0; i < this.tabList.size(); i++) {
                String strM9339r = ((Tab) this.tabList.get(i)).getTabId();
                if (!m9315x(strM9339r, arrayList)) {
                    arrayList2.add(strM9339r);
                }
            }
            for (int i2 = 0; i2 < arrayList2.size(); i2++) {
                removeTab((String) arrayList2.get(i2));
            }
        } else {
            int i3 = -1;
            for (int i4 = 0; i4 < arrayList.size(); i4++) {
                InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) arrayList.get(i4);
                ((Tab) this.tabList.get(getTabIndexById((String) interfaceC0529Ld.mo2666e()))).order = i4;
                if (interfaceC0529Ld.mo2682u()) {
                    i3 = i4;
                }
            }
            Collections.sort(this.tabList, (o1, o2) -> o1.order - o2.order);
            this.currentActiveIndex = i3;
        }
        for (int i5 = 0; i5 < arrayList.size(); i5++) {
            ((Tab) this.tabList.get(i5)).lock = ((InterfaceC0529Ld) arrayList.get(i5)).mo2680s();
        }
    }

    public final void m9304l(int i) {
        Tab tabVarM9277A = getActiveTab();
        InterfaceC0345Hd interfaceC0345HdM9333l = tabVarM9277A.m9333l();
        if (interfaceC0345HdM9333l != null) {
            interfaceC0345HdM9333l.mo1576g();
        }
        InterfaceC0345Hd interfaceC0345HdM9332k = tabVarM9277A.m9332k(i);
        if (interfaceC0345HdM9332k != null) {
            tabVarM9277A.m9330i(i);
            m9301Y(interfaceC0345HdM9332k);
        }
    }

    public final void m9305m(InterfaceC0345Hd interfaceC0345Hd) {
        m9307o(interfaceC0345Hd, false);
    }

    public final void m9306n(InterfaceC0345Hd interfaceC0345Hd, int i) {
        Tab tabVar = (Tab) this.tabList.get(i);
        if (tabVar != null) {
            tabVar.m9326e(interfaceC0345Hd, false);
            return;
        }
        Log.w("ContentViewManager", "not found tab group with groud id:" + i);
    }

    public final void m9307o(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
        Tab tabVarM9277A = getActiveTab();
        if (tabVarM9277A != null) {
            tabVarM9277A.m9326e(interfaceC0345Hd, z);
        } else {
            m9312u(interfaceC0345Hd, true);
            this.currentActiveIndex = 0;
        }
    }

    public boolean hasValidPreviousTab() {
        Tab activeTab = getActiveTab();
        return activeTab != null && activeTab.isValidPreviousIndex();
    }

    public boolean hasValidNextTab() {
        Tab activeTab = getActiveTab();
        return activeTab != null && activeTab.isValidNextIndex();
    }

    public abstract InterfaceC0345Hd mo5705r(String pkg, String className);

    public final Tab m9310s(InterfaceC0345Hd interfaceC0345Hd) {
        return m9313v(interfaceC0345Hd, true, this.tabList.size(), null);
    }

    public final Tab m9311t(InterfaceC0345Hd interfaceC0345Hd, String str) {
        int i = this.currentActiveIndex;
        return m9313v(interfaceC0345Hd, false, (i >= 0 && i < this.tabList.size()) ? this.currentActiveIndex + 1 : this.tabList.size(), str);
    }

    public final Tab m9312u(InterfaceC0345Hd interfaceC0345Hd, boolean z) {
        int i = this.currentActiveIndex;
        return m9313v(interfaceC0345Hd, z, (i >= 0 && i < this.tabList.size()) ? this.currentActiveIndex + 1 : this.tabList.size(), null);
    }

    public final Tab m9313v(InterfaceC0345Hd interfaceC0345Hd, boolean active, int i, String str) {
        Tab tabVar = new Tab(str);
        Tab tabVarM9277A = getActiveTab();
        if (tabVarM9277A != null) {
            tabVar.f6890c = tabVarM9277A.tabId;
        }
        if (i < 0) {
            i = 0;
        }
        if (i > this.tabList.size()) {
            i = this.tabList.size();
        }
        this.tabList.add(i, tabVar);
        Log.i("save-state", " current active index:" + currentActiveIndex + " active:" + active);
        if (active) {
            currentActiveIndex = i;
            m9305m(interfaceC0345Hd);
        } else {
            tabVar.m9327f(interfaceC0345Hd, false);
        }
        Log.i("save-state", " >>current active index:" + currentActiveIndex);
        tabVar.order = i;
        return tabVar;
    }

    public void m9314w() {
        for (int i = 0; i < this.tabList.size(); i++) {
            ((Tab) this.tabList.get(i)).m9331j();
        }
        this.tabList.clear();
        this.currentActiveIndex = -1;
    }

    public final boolean m9315x(String str, ArrayList arrayList) {
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            if (str.equals(((InterfaceC0529Ld) it.next()).mo2666e())) {
                return true;
            }
        }
        return false;
    }

    public final InterfaceC0345Hd m9316y() {
        if (tabList.isEmpty()) {
            return null;
        }
        if (currentActiveIndex < 0 || currentActiveIndex >= tabList.size()) {
            currentActiveIndex = 0;
        }
        return tabList.get(currentActiveIndex).m9333l();
    }

    public InterfaceC0345Hd m9317z(int i) {
        if (i >= 0 && i < this.tabList.size()) {
            return ((Tab) this.tabList.get(i)).m9333l();
        }
        throw new IllegalStateException("invalid stack index[" + i + "]");
    }
}
