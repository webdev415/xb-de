package com.mmbox.xbrowser;

import android.annotation.SuppressLint;
import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.ContextMenu;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.TranslateAnimation;
import android.widget.AdapterView;
import android.widget.FrameLayout;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import com.mobeta.android.dslv.DragSortListView;
import com.xbrowser.play.R;
import java.util.ArrayList;
import p000.AndroidSystemUtils;
import p000.AbstractC2359t;
import p000.C0762Qg;
import p000.C1344c1;
import p000.ThemeManager;
import p000.DialogC1975kl;
import p000.InterfaceC0529Ld;
import p000.InterfaceC0575Md;

public class TabWindowManager extends AbstractC2359t implements InterfaceC0529Ld.a, View.OnClickListener, AbstractScrollableListController.ItemClickListener {

    public InterfaceC0575Md tabEventListener;

    public DragSortListView dragSortListView;

    public int selectedTabPosition;

    public class ScrollToPositionRunnable implements Runnable {

        public final int targetPosition;

        public ScrollToPositionRunnable(int i) {
            this.targetPosition = i;
        }

        @Override
        public void run() {
            int firstVisiblePosition = dragSortListView.getFirstVisiblePosition();
            int lastVisiblePosition = dragSortListView.getLastVisiblePosition();
            int i = this.targetPosition;
            if (i < firstVisiblePosition || i > lastVisiblePosition) {
                dragSortListView.setSelection(i);
                int i2 = this.targetPosition;
                int height = dragSortListView.getHeight();
                dragSortListView.getChildAt(0).getHeight();
                dragSortListView.smoothScrollToPositionFromTop(i2, height / 2);
            }
        }
    }

    public class TabClickListener implements View.OnClickListener {

        public final InterfaceC0529Ld tab;

        public TabClickListener(InterfaceC0529Ld interfaceC0529Ld) {
            this.tab = interfaceC0529Ld;
        }

        @Override
        public void onClick(View view) {
            if (this.tab.mo2680s()) {
                return;
            }
            tabEventListener.mo2863m((String) this.tab.mo2666e());
        }
    }

    public class TabDragAdapter extends AbstractC2359t.g implements DragSortListView.InterfaceC1596g {
        public TabDragAdapter() {
            super();
        }

        @Override
        public void mo7058a(int i, int i2) {
        }

        @Override
        public void mo7059b(int i, int i2) {
            if (i != i2) {
                this.f7122a.add(i2, (InterfaceC0529Ld) this.f7122a.remove(i));
                notifyDataSetChanged();
                BrowserActivity.getActivity().m6222J0().m9303a0(this.f7122a);
            }
        }

        @Override
        public boolean mo7060c(int i) {
            return !((InterfaceC0529Ld) this.f7122a.get(i)).mo2680s();
        }

        @Override
        public int getCount() {
            return this.f7122a.size();
        }

        @Override
        public Object getItem(int i) {
            return this.f7122a.get(i);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View view, ViewGroup parent) {
            if (view == null) {
                view = getMenuItemView(parent);
            } else {
                ThemeManager.getInstance().m9500u().setLayoutView(view);
            }
            m9658e(view, position);
            return view;
        }

        @Override
        public void remove(int i) {
            InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) this.f7122a.remove(i);
            adapter.m9661h(interfaceC0529Ld);
            tabEventListener.mo2863m((String) interfaceC0529Ld.mo2666e());
            notifyDataSetChanged();
        }
    }

    public ViewOnClickListenerC1573h(FrameLayout frameLayout, InterfaceC0575Md interfaceC0575Md) {
        super(frameLayout, null, -1, -2, false);
        this.dragSortListView = null;
        this.selectedTabPosition = -1;
        this.tabEventListener = interfaceC0575Md;
        View viewM7049K = m7049K(null);
        this.dragSortListView = (DragSortListView) viewM7049K.findViewById(R.id.muti_window_list_view);
        viewM7049K.setClickable(false);
        viewM7049K.setOnTouchListener(new View.OnTouchListener() {
            @SuppressLint("ClickableViewAccessibility")
            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                return true;
            }
        });
        initListView(this.dragSortListView);
        m9642E(viewM7049K);
        m9641D(this);
        ((ImageButton) viewM7049K.findViewById(R.id.btn_new_window)).setOnClickListener(this);
        ((ImageButton) viewM7049K.findViewById(R.id.btn_clean_all_tab)).setOnClickListener(this);
        ((ImageButton) viewM7049K.findViewById(R.id.btn_crete_incognito_tab)).setOnClickListener(this);
        this.dragSortListView.setTag(this);
        this.dragSortListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView adapterView, View view, int i, long j) {
                selectedTabPosition = i;
                BrowserActivity.getActivity().getBrowserFrameLayout().showContextMenuForChild(dragSortListView);
                return true;
            }
        });
    }

    @Override
    public void mo1710A(View view, int i) {
        InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) this.adapter.getItem(i);
        View viewFindViewById = view.findViewById(R.id.muti_window_item);
        if (viewFindViewById != null) {
            viewFindViewById.setSelected(interfaceC0529Ld.mo2682u());
        }
        ImageView imageView = (ImageView) view.findViewById(R.id.btn_close_or_lock);
        if (interfaceC0529Ld.mo2680s()) {
            imageView.setImageResource(R.drawable.ic_lock);
        } else {
            imageView.setImageResource(R.drawable.ic_stop_or_close);
            imageView.setOnClickListener(new TabClickListener(interfaceC0529Ld));
        }
    }

    @Override
    public boolean mo6669B(AbstractScrollableListController abstractC1540b, View view, ContextMenu.ContextMenuInfo contextMenuInfo) {
        Resources resources;
        int i;
        int i2 = this.selectedTabPosition;
        if (i2 < 0) {
            return false;
        }
        if (i2 > 0) {
            abstractC1540b.m9644d(getContext().getResources().getString(R.string.tab_menu_close_above), R.string.tab_menu_close_above);
        }
        if (this.selectedTabPosition < this.adapter.getCount() - 1) {
            abstractC1540b.m9644d(getContext().getResources().getString(R.string.tab_menu_close_below), R.string.tab_menu_close_below);
        }
        if (this.adapter.getCount() > 1) {
            abstractC1540b.m9644d(getContext().getResources().getString(R.string.tab_menu_close_other), R.string.tab_menu_close_other);
        }
        if (((InterfaceC0529Ld) this.adapter.getItem(this.selectedTabPosition)).mo2680s()) {
            resources = getContext().getResources();
            i = R.string.tab_menu_unlock_tab;
        } else {
            resources = getContext().getResources();
            i = R.string.tab_menu_lock_tab;
        }
        abstractC1540b.m9644d(resources.getString(i), i);
        abstractC1540b.m9644d(getContext().getResources().getString(R.string.tab_menu_copy_url), R.string.tab_menu_copy_url);
        abstractC1540b.m9644d(getContext().getResources().getString(R.string.tab_menu_save_all), R.string.tab_menu_save_all);
        return true;
    }

    @Override
    public void mo7047F(int i, int i2, int i3) {
        super.mo7047F(i, i2, i3);
        int i4 = 0;
        while (true) {
            if (i4 >= this.adapter.getCount()) {
                i4 = -1;
                break;
            } else if (((InterfaceC0529Ld) this.adapter.getItem(i4)).mo2682u()) {
                break;
            } else {
                i4++;
            }
        }
        this.dragSortListView.post(new ScrollToPositionRunnable(i4));
    }

    public void m7048J(Drawable drawable, String str, String str2, boolean z, boolean z2) {
        C0762Qg c0762Qg = new C0762Qg();
        c0762Qg.mo2673l(str);
        c0762Qg.mo2662a(drawable);
        c0762Qg.mo2663b(str2.hashCode());
        c0762Qg.mo2676o(str2);
        c0762Qg.mo2670i(z);
        c0762Qg.mo2672k(z2);
        m9643c(c0762Qg);
    }

    public View m7049K(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9491l(viewGroup);
    }

    public void m7050L(String str) {
        InterfaceC0529Ld interfaceC0529Ld = null;
        for (int i = 0; i < this.adapter.getCount(); i++) {
            InterfaceC0529Ld interfaceC0529Ld2 = (InterfaceC0529Ld) this.adapter.getItem(i);
            if (interfaceC0529Ld2.mo2683v() == str.hashCode()) {
                interfaceC0529Ld = interfaceC0529Ld2;
            }
        }
        this.adapter.m9661h(interfaceC0529Ld);
        this.adapter.notifyDataSetChanged();
    }

    public final void m7051M(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList<>(5);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 < i) {
                arrayList2.add((InterfaceC0529Ld) arrayList.get(i2));
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (!((C0762Qg) arrayList2.get(i3)).mo2680s()) {
                arrayList.remove(arrayList2.get(i3));
            }
        }
    }

    public final void m7052N(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList<>(5);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 > i) {
                arrayList2.add((InterfaceC0529Ld) arrayList.get(i2));
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (!((C0762Qg) arrayList2.get(i3)).mo2680s()) {
                arrayList.remove(arrayList2.get(i3));
            }
        }
    }

    public final void m7053O(int i, ArrayList arrayList) {
        ArrayList arrayList2 = new ArrayList<>(5);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            if (i2 != i) {
                arrayList2.add((InterfaceC0529Ld) arrayList.get(i2));
            }
        }
        for (int i3 = 0; i3 < arrayList2.size(); i3++) {
            if (!((C0762Qg) arrayList2.get(i3)).mo2680s()) {
                arrayList.remove(arrayList2.get(i3));
            }
        }
    }

    public void m7054P(String str) {
        for (int i = 0; i < this.adapter.getCount(); i++) {
            InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) this.adapter.getItem(i);
            interfaceC0529Ld.mo2670i(interfaceC0529Ld.mo2683v() == str.hashCode());
        }
    }

    public void m7055Q() {
        this.adapter.notifyDataSetChanged();
    }

    @Override
    public View getMenuItemView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().m9490k(viewGroup);
    }

    @Override
    public AbstractC2359t.g mo7056l() {
        return new TabDragAdapter();
    }

    @Override
    public void onClick(View view) {
        C1344c1 c1344c1M5691d;
        String str;
        String str2;
        m9655v();
        if (view.getId() == R.id.btn_new_window) {
            this.tabEventListener.mo2862j();
            c1344c1M5691d = C1344c1.m5691d();
            str = "New Tab";
            str2 = "new_tab";
        } else if (view.getId() == R.id.btn_clean_all_tab) {
            this.tabEventListener.mo2861i();
            c1344c1M5691d = C1344c1.m5691d();
            str = "Close All Tab";
            str2 = "close_all_tab";
        } else {
            if (view.getId() != R.id.btn_crete_incognito_tab) {
                return;
            }
            this.tabEventListener.mo2864o();
            c1344c1M5691d = C1344c1.m5691d();
            str = "Incognito Tab";
            str2 = "add_incognito_tab";
        }
        c1344c1M5691d.m5698h(str, str2);
    }

    @Override
    public Animation mo1714p() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, 0.0f, m9654t().getMeasuredHeight());
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    @Override
    public Animation mo1715u() {
        TranslateAnimation translateAnimation = new TranslateAnimation(0.0f, 0.0f, m9654t().getMeasuredHeight(), 0.0f);
        translateAnimation.setDuration(200L);
        return translateAnimation;
    }

    @Override
    public void mo1615w(InterfaceC0529Ld interfaceC0529Ld, ContextMenu.ContextMenuInfo contextMenuInfo) {
        if (interfaceC0529Ld.mo2683v() == R.string.tab_menu_close_above) {
            m7051M(this.selectedTabPosition, m9653s().m9660g());
        } else if (interfaceC0529Ld.mo2683v() == R.string.tab_menu_close_below) {
            m7052N(this.selectedTabPosition, m9653s().m9660g());
        } else {
            if (interfaceC0529Ld.mo2683v() != R.string.tab_menu_close_other) {
                if (interfaceC0529Ld.mo2683v() == R.string.tab_menu_lock_tab) {
                    ((InterfaceC0529Ld) this.adapter.getItem(this.selectedTabPosition)).mo2672k(true);
                } else {
                    if (interfaceC0529Ld.mo2683v() != R.string.tab_menu_unlock_tab) {
                        if (interfaceC0529Ld.mo2683v() == R.string.tab_menu_copy_url) {
                            String strM6282Y0 = BrowserActivity.getActivity().m6282Y0(this.selectedTabPosition);
                            if (TextUtils.isEmpty(strM6282Y0)) {
                                return;
                            }
                            AndroidSystemUtils.m8701i(getContext(), strM6282Y0);
                            Toast.makeText(getContext(), R.string.toast_copy_to_clip_board, Toast.LENGTH_SHORT).show();
                            return;
                        }
                        if (interfaceC0529Ld.mo2683v() == R.string.tab_menu_save_all) {
                            new DialogC1975kl(BrowserActivity.getActivity()).show();
                            return;
                        } else {
                            if (!(interfaceC0529Ld.mo2666e() instanceof String)) {
                                throw new IllegalStateException("Make sure you specifyed winowId when add muit-window-indicator");
                            }
                            this.tabEventListener.mo2860c((String) interfaceC0529Ld.mo2666e());
                            return;
                        }
                    }
                    ((InterfaceC0529Ld) this.adapter.getItem(this.selectedTabPosition)).mo2672k(false);
                }
                this.adapter.notifyDataSetChanged();
                BrowserActivity.getActivity().m6222J0().m9303a0(m9653s().m9660g());
                return;
            }
            m7053O(this.selectedTabPosition, m9653s().m9660g());
        }
        m9653s().notifyDataSetChanged();
        BrowserActivity.getActivity().m6222J0().m9303a0(m9653s().m9660g());
        BrowserActivity.getActivity().m6324h3();
    }

    @Override
    public boolean mo7057z() {
        return true;
    }
}
