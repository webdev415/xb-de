package p000;

import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.widget.FrameLayout;
import android.widget.ImageView;
import com.mmbox.xbrowser.AbstractC1540b;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class C0401In extends AbstractC1540b implements InterfaceC0529Ld.a {
    public C0401In(FrameLayout frameLayout, InterfaceC0529Ld.a aVar, int i, int i2) {
        super(frameLayout, aVar, i, i2);
        this.context = frameLayout.getContext();
    }

    @Override
    public void mo1710A(View view, int i) {
        ThemeManager.getInstance().m9500u().setLayoutView(view);
        InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) view.getTag();
        int iMo2683v = interfaceC0529Ld.mo2683v();
        ImageView imageView = (ImageView) view.findViewById(R.id.item_switch);
        if (iMo2683v != -1) {
            imageView.setVisibility(View.GONE);
        } else {
            imageView.setVisibility(View.VISIBLE);
            imageView.setImageResource(interfaceC0529Ld.mo2678q() ? R.drawable.ic_switch_on : R.drawable.ic_switch_off);
        }
    }

    @Override
    public View createContextMenuView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9495p(viewGroup);
    }

    @Override
    public int getListViewId() {
        return R.id.pop_menu_list_view;
    }

    @Override
    public View getMenuItemView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9494o(viewGroup);
    }

    @Override
    public Animation mo1714p() {
        return null;
    }

    @Override
    public Animation mo1715u() {
        return null;
    }

    @Override
    public void mo1615w(InterfaceC0529Ld interfaceC0529Ld, ContextMenu.ContextMenuInfo contextMenuInfo) {
        this.f7104c.mo1615w(interfaceC0529Ld, null);
    }
}
