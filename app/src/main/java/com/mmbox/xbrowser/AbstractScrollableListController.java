package com.mmbox.xbrowser;

import android.util.Log;
import android.view.ContextMenu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.FrameLayout;
import android.widget.ListView;
import com.xbrowser.play.R;
import p000.AbstractC2359t;
import p000.ThemeManager;
import p000.InterfaceC0529Ld;

public abstract class AbstractScrollableListController extends AbstractC2359t {

    public ListView listView;

    public View viewTopMore;

    public View viewBottomMore;

    public boolean hasScrollIndicators;

    public int indicatorHeight;

    public int lastIndicatorState;

    public class ScrollListener implements AbsListView.OnScrollListener {
        @Override
        public void onScroll(AbsListView absListView, int i, int i2, int i3) {
            Log.i("scroll", "scroll-lvp:" + absListView.getLastVisiblePosition());
            Log.i("scroll", "scroll-fvp:" + absListView.getFirstVisiblePosition());
            Log.i("scroll", "scroll-first-item:" + i);
            Log.i("scroll", "scroll-visable-count:" + i2);
            if (hasScrollIndicators) {
                if (absListView.getFirstVisiblePosition() == 0) {
                    m6667M(0);
                } else if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    m6667M(1);
                } else {
                    m6667M(2);
                }
            }
        }

        @Override
        public void onScrollStateChanged(AbsListView absListView, int i) {
            AbstractC1540b abstractC1540b;
            int i2;
            if (i == 0) {
                AbstractC1540b abstractC1540b2 = AbstractScrollableListController.this;
                if (!abstractC1540b2.hasScrollIndicators) {
                    abstractC1540b2.m6667M(-1);
                    return;
                }
                if (absListView.getLastVisiblePosition() == absListView.getCount() - 1) {
                    m6667M(1);
                    return;
                }
                if (absListView.getFirstVisiblePosition() == 0) {
                    abstractC1540b = AbstractScrollableListController.this;
                    i2 = 0;
                } else {
                    abstractC1540b = AbstractScrollableListController.this;
                    i2 = 2;
                }
                abstractC1540b.m6667M(i2);
            }
        }
    }

    public interface ItemClickListener extends InterfaceC0529Ld.a {
        boolean mo6669B(AbstractScrollableListController abstractScrollableListController, View view, ContextMenu.ContextMenuInfo contextMenuInfo);
    }

    public AbstractScrollableListController(FrameLayout frameLayout, InterfaceC0529Ld.a aVar, int i, int i2) {
        super(frameLayout, aVar, i, i2);
        this.listView = null;
        this.viewTopMore = null;
        this.viewBottomMore = null;
        this.hasScrollIndicators = false;
        this.lastIndicatorState = -1;
        this.context = frameLayout.getContext();
        View contextMenuView = createContextMenuView(null);
        this.indicatorHeight = (int) this.context.getResources().getDimension(R.dimen.scroll_indictor_height);
        listView = (ListView) contextMenuView.findViewById(getListViewId());
        listView.setOnScrollListener(new ScrollListener());
        viewTopMore = contextMenuView.findViewById(R.id.top_more);
        viewBottomMore = contextMenuView.findViewById(R.id.bottom_more);
        initListView(this.listView);
        m9642E(contextMenuView);
    }

    @Override
    public void mo1710A(View view, int i) {
        ThemeManager.getInstance().m9500u().setLayoutView(view);
    }

    public View createContextMenuView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().inflateContextMenuView(getContext(), viewGroup);
    }

    public int m6665J() {
        int dimension = (int) getContext().getResources().getDimension(R.dimen.context_menu_item_height);
        return ((BrowserActivity.getActivity().getBrowserFrameLayout().getHeight() / dimension) * dimension) - (dimension / 3);
    }

    public int m6666K() {
        return (((int) getContext().getResources().getDimension(R.dimen.context_menu_item_height)) * this.adapter.getCount()) + (((int) getContext().getResources().getDimension(R.dimen.context_menu_padding)) * 2);
    }

    public int getListViewId() {
        return R.id.context_menu_list_view;
    }

    public final int m6667M(int i) {
        View view;
        View viewM9654t = m9654t();
        if (viewM9654t == null) {
            return 0;
        }
        ViewGroup.LayoutParams layoutParams = viewM9654t.getLayoutParams();
        FrameLayout.LayoutParams layoutParams2 = (FrameLayout.LayoutParams) this.listView.getLayoutParams();
        if (i == -1) {
            layoutParams.height = m6666K();
            layoutParams2.bottomMargin = 0;
            layoutParams2.topMargin = 0;
            this.listView.setLayoutParams(layoutParams2);
            this.viewTopMore.setVisibility(View.INVISIBLE);
            this.viewBottomMore.setVisibility(View.INVISIBLE);
            viewM9654t.setLayoutParams(layoutParams);
            this.lastIndicatorState = i;
        } else if (i != this.lastIndicatorState) {
            if (i == 0) {
                this.viewBottomMore.setVisibility(View.VISIBLE);
                view = this.viewTopMore;
            } else if (i == 1) {
                this.viewTopMore.setVisibility(View.VISIBLE);
                view = this.viewBottomMore;
            } else if (i == 2) {
                this.viewTopMore.setVisibility(View.VISIBLE);
                this.viewBottomMore.setVisibility(View.VISIBLE);
                this.lastIndicatorState = i;
                layoutParams.height = m6665J();
                int i2 = this.indicatorHeight;
                layoutParams2.bottomMargin = i2;
                layoutParams2.topMargin = i2;
                viewM9654t.setLayoutParams(layoutParams);
                this.listView.setLayoutParams(layoutParams2);
            }
            view.setVisibility(View.INVISIBLE);
            this.lastIndicatorState = i;
            layoutParams.height = m6665J();
            int i22 = this.indicatorHeight;
            layoutParams2.bottomMargin = i22;
            layoutParams2.topMargin = i22;
            viewM9654t.setLayoutParams(layoutParams);
            this.listView.setLayoutParams(layoutParams2);
        }
        return layoutParams.height;
    }

    @Override
    public View getMenuItemView(ViewGroup viewGroup) {
        return ThemeManager.getInstance().inflateContextMenuItem(viewGroup);
    }

    @Override
    public int mo6668y() {
        if (m6666K() > m6665J()) {
            this.hasScrollIndicators = true;
            return m6667M(0);
        }
        this.hasScrollIndicators = false;
        return m6667M(-1);
    }
}
