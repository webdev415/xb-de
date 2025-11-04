package com.mmbox.xbrowser.controllers;

import android.content.res.Configuration;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.MotionEvent;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserControllerListener;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import p000.NetworkUtils;
import p000.ResourceCacheManager;
import p000.ThemeManager;
import p000.C2518wb;
import p000.InterfaceC1300b3;

public abstract class AbsBrowserController implements InterfaceC1300b3 {

    public BrowserActivity browserActivity;

    public BrowserControllerListener browserControllerListener;

    public Drawable drawable = null;

    public String title = "";

    public String url = "";

    public String mUrl = null;

    public String f4691g = null;

    public int pageType = 0;

    public AbsBrowserController(BrowserActivity browserActivity, BrowserControllerListener browserControllerListener) {
        this.browserActivity = browserActivity;
        this.browserControllerListener = browserControllerListener;
    }

    @Override
    public Drawable mo5621A(int i) {
        String strM471z;
        if (SharedPreferencesHelper.getInstance().enterPrivateMode || this.pageType == 8) {
            return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_incognito, i);
        }
        if (getUrlFromTitle().indexOf("file:///android_asset/histories/histories.html") >= 0 || getUrlFromTitle().equals("x:history")) {
            return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_history, i);
        }
        if (getUrlFromTitle().indexOf("file:///android_asset/bookmarks/bookmarks.html") >= 0 || getUrlFromTitle().equals("x:bookmark")) {
            return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_bookmark, i);
        }
        if (getUrlFromTitle().indexOf("file:///android_asset/download-manager/download-manager.html") >= 0 || getUrlFromTitle().equals("x:dl")) {
            return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_download, i);
        }
        if (getUrlFromTitle().indexOf("file:///android_asset/settings/settings.html") >= 0 || getUrlFromTitle().equals("x:settings")) {
            return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_setting, i);
        }
        if (getUrlFromTitle().indexOf("offlines") >= 0) {
            return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_offline_reading, i);
        }
        if (getUrlFromTitle().indexOf("file:///android_asset/start-page/index.html") < 0 && !getUrlFromTitle().equals("x:home")) {
            if (this.drawable == null) {
                return this.pageType == 8 ? ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_incognito, i) : ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, i);
            }
            if (this.f4691g != null && (strM471z = NetworkUtils.getHostFileExtension(getUrlFromTitle())) != null && !strM471z.equals(this.f4691g)) {
                this.drawable = this.pageType == 8 ? ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_incognito, i) : ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, i);
            }
            return this.drawable;
        }
        return ThemeManager.getInstance().getDrawable(R.drawable.ic_fav_default, i);
    }

    @Override
    public void mo5622C(int i) {
        this.pageType = i;
    }

    @Override
    public void mo1572D(String str) {
        this.mUrl = str;
    }

    @Override
    public void mo5623E(String str) {
        if (TextUtils.isEmpty(str)) {
            return;
        }
        this.title = str;
        if (str.startsWith("x:")) {
            str = ResourceCacheManager.getInstance().getUrlOrFilePath(str, 2);
        }
        mo6728G(str);
    }

    public void m6727F() {
        C2518wb.m10533d();
    }

    public abstract void mo6728G(String str);

    public BrowserActivity getBrowserActivity() {
        return this.browserActivity;
    }

    public BrowserControllerListener getBrowserControllerListener() {
        return this.browserControllerListener;
    }

    @Override
    public boolean mo5624a() {
        return this.browserActivity.getTabManager().m9289M(this);
    }

    @Override
    public String getUrlFromTitle() {
        return !TextUtils.isEmpty(this.title) ? ResourceCacheManager.getInstance().getUrlOrFilePath(this.title, 2) : "";
    }

    @Override
    public String mo1574c() {
        return this.url;
    }

    @Override
    public boolean hasNext() {
        return false;
    }

    @Override
    public void mo5625f() {
    }

    @Override
    public void mo1576g() {
    }

    @Override
    public int mo5626h() {
        return this.pageType;
    }

    @Override
    public boolean mo5627i(String str) {
        return false;
    }

    @Override
    public void mo5628j() {
    }

    @Override
    public void onDestroy() {
    }

    @Override
    public void mo1578l() {
    }

    @Override
    public void mo1579m(String str) {
        this.title = str;
    }

    @Override
    public void mo1580n() {
    }

    @Override
    public void onConfigurationChanged(Configuration configuration) {
    }

    @Override
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        return false;
    }

    @Override
    public boolean mo5630p(MotionEvent motionEvent) {
        return false;
    }

    @Override
    public boolean mo1581q() {
        return false;
    }

    @Override
    public String getPackageName() {
        return this.browserActivity.getApplicationInfo().packageName;
    }

    @Override
    public void mo1584u() {
        m6727F();
    }

    @Override
    public boolean hasPrevious() {
        return false;
    }

    @Override
    public void mo5632y(Drawable drawable) {
        this.drawable = drawable;
    }

    @Override
    public boolean mo1587z() {
        return false;
    }
}
