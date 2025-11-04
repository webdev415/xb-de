package p000;

import android.graphics.drawable.Drawable;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebBackForwardList;
import android.webkit.WebHistoryItem;
import com.mmbox.xbrowser.AbstractC1540b;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.util.ArrayList;

public class C1345c2 extends AbstractC1540b {

    public BrowserActivity f3912t;

    public C1345c2(BrowserActivity browserActivity, InterfaceC0529Ld.a aVar, WebBackForwardList webBackForwardList, int i, int i2) {
        super(browserActivity.getBrowserFrameLayout(), aVar, i, i2);
        this.f3912t = browserActivity;
        m5703N(webBackForwardList);
    }

    @Override
    public View createContextMenuView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9495p(viewGroup);
    }

    @Override
    public int getListViewId() {
        return R.id.pop_menu_list_view;
    }

    public final void m5703N(WebBackForwardList webBackForwardList) {
        ArrayList arrayListM9334m = this.f3912t.getTabManager().getActiveTab().m9334m();
        int iM9336o = this.f3912t.getTabManager().getActiveTab().m9336o();
        for (int i = 0; i < iM9336o; i++) {
            InterfaceC1300b3 interfaceC1300b3 = (InterfaceC1300b3) arrayListM9334m.get(i);
            String strMo1573b = interfaceC1300b3.getUrlFromTitle();
            String strMo1574c = interfaceC1300b3.mo1574c();
            String strM445C = NetworkUtils.getFaviconUrl(strMo1573b);
            C0762Qg c0762Qg = new C0762Qg();
            Drawable drawableM4142f = C0896Td.m4137c().m4142f(strMo1573b, strM445C, -1);
            if (drawableM4142f == null) {
                drawableM4142f = ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, 1);
            }
            c0762Qg.mo2673l(strMo1574c);
            c0762Qg.mo2662a(drawableM4142f);
            c0762Qg.mo2668g();
            c0762Qg.mo2676o(Integer.valueOf(i));
            m9643c(c0762Qg);
        }
        int currentIndex = webBackForwardList.getCurrentIndex();
        for (int i2 = 0; i2 < currentIndex; i2++) {
            WebHistoryItem itemAtIndex = webBackForwardList.getItemAtIndex(i2);
            String url = itemAtIndex.getUrl();
            String strM445C2 = NetworkUtils.getFaviconUrl(url);
            C0762Qg c0762Qg2 = new C0762Qg();
            Drawable drawableM4142f2 = C0896Td.m4137c().m4142f(url, strM445C2, -1);
            if (drawableM4142f2 == null) {
                drawableM4142f2 = ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, 1);
            }
            c0762Qg2.mo2673l(itemAtIndex.getTitle());
            c0762Qg2.mo2662a(drawableM4142f2);
            c0762Qg2.mo2668g();
            c0762Qg2.mo2676o(Integer.valueOf(i2 - currentIndex));
            m9643c(c0762Qg2);
        }
    }

    @Override
    public View getMenuItemView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9494o(viewGroup);
    }
}
