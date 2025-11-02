package com.mmbox.xbrowser;

import android.content.Context;
import android.widget.FrameLayout;
import com.mmbox.widget.swiperefresh.SwipeRefreshLayout;
import com.xbrowser.play.R;
import p000.InterfaceC2018li;

public class PullToRefreshHandler implements InterfaceC2018li {

    public final SwipeRefreshLayout swipeRefreshLayout;

    public BrowserFrameLayout browserFrameLayout;

    public Runnable stopRefreshRunnable;

    public String accessibilityText;

    public PullToRefreshHandler(Context context) {
        swipeRefreshLayout = new SwipeRefreshLayout(context);
        swipeRefreshLayout.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        swipeRefreshLayout.setColorSchemeResources(android.R.color.holo_red_light);
        swipeRefreshLayout.setSize(1);
        swipeRefreshLayout.setEnabled(false);
    }

    @Override
    public void mo7069a(boolean z) {
        swipeRefreshLayout.finishPullGesture(z);
    }

    @Override
    public void mo7070b(float f) {
        swipeRefreshLayout.onPull(f);
    }

    public final void attachToContainer() {
        if (browserFrameLayout != null && swipeRefreshLayout.getParent() == null) {
            browserFrameLayout.getMainContainer().addView(swipeRefreshLayout);
        }
    }

    public final void removeCallbacks() {
        Runnable runnable = stopRefreshRunnable;
        if (runnable != null) {
            swipeRefreshLayout.removeCallbacks(runnable);
        }
    }

    public final void detachFromContainer() {
        if (browserFrameLayout == null || swipeRefreshLayout.getParent() == null) {
            return;
        }
        browserFrameLayout.getMainContainer().removeView(swipeRefreshLayout);
    }

    public void finishRefreshing() {
        if (swipeRefreshLayout.isRefreshing()) {
            removeCallbacks();
            swipeRefreshLayout.postDelayed(getStopRefreshRunnable(), 500L);
        }
    }

    public final Runnable getStopRefreshRunnable() {
        if (stopRefreshRunnable == null) {
            stopRefreshRunnable = new Runnable() {
                @Override
                public void run() {
                    swipeRefreshLayout.setRefreshing(false);
                }
            };
        }
        return stopRefreshRunnable;
    }

    public void reset() {
        removeCallbacks();
        swipeRefreshLayout.reset();
        detachFromContainer();
    }

    public void setBrowserFrameLayout(BrowserFrameLayout browserFrameLayout) {
        BrowserFrameLayout browserFrameLayout2 = this.browserFrameLayout;
        if (browserFrameLayout2 == browserFrameLayout) {
            return;
        }
        if (browserFrameLayout2 != null) {
            setEnabled(false);
            removeCallbacks();
            swipeRefreshLayout.setOnRefreshListener(null);
            this.browserFrameLayout.setOverscrollRefreshHandler(null);
        }
        this.browserFrameLayout = browserFrameLayout;
        if (browserFrameLayout == null) {
            return;
        }
        setEnabled(true);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                removeCallbacks();
                swipeRefreshLayout.postDelayed(getStopRefreshRunnable(), 7500L);
                if (accessibilityText == null) {
                    accessibilityText = browserFrameLayout.getContext().getResources().getString(R.string.accessibility_swipe_refresh);
                }
                browserFrameLayout.getEventListener().mo6390a(0);
            }
        });
        browserFrameLayout.setOverscrollRefreshHandler(this);
    }

    public void setEnabled(boolean z) {
        swipeRefreshLayout.setEnabled(z);
        if (z) {
            return;
        }
        reset();
    }

    @Override
    public boolean start() {
        attachToContainer();
        return swipeRefreshLayout.startManualRefresh();
    }
}
