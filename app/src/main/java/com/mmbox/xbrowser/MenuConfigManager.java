package com.mmbox.xbrowser;

import android.content.Context;
import android.graphics.drawable.Drawable;
import com.xbrowser.play.R;

import java.io.File;
import java.nio.charset.StandardCharsets;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import p000.FileUtils;
import p000.C1089Xm;
import p000.C1199a3;
import p000.PhoneUtils;

/* loaded from: classes.dex */
public class MenuConfigManager {

    public static MenuConfigManager instance;

    public ArrayList<MenuItem> mainMenuList = new ArrayList<>();

    public ArrayList<MenuItem> toolMenuList = new ArrayList<>();

    public ArrayList<MenuItem> contextMenuList = new ArrayList<>();

    public JSONArray mainMenuJson = new JSONArray();

    public JSONArray toolMenuJson = new JSONArray();

    public JSONArray contextMenuArray = new JSONArray();

    public Context context = null;

    public boolean isInitialized = false;

    public class a implements

    public static class MenuItem {

        public String id;

        public String title;

        public Drawable icon;

        public int titleResId;

        public int order;

        public boolean active = true;

        public boolean equals(Object obj) {
            if (obj instanceof MenuItem) {
                return ((MenuItem) obj).id.equals(this.id);
            }
            return false;
        }
    }

    public static MenuConfigManager getInstance() {
        if (instance == null) {
            instance = new MenuConfigManager();
        }
        return instance;
    }

    public void m7017A() {
        try {
            m7042y();
            m7043z();
            m7041x();
        } catch (Exception unused) {
        }
    }

    public final void updateMenuItem(JSONArray menuArray, MenuItem item) throws JSONException {
        if (menuArray == null || item == null) return;

        boolean found = false;

        for (int i = 0; i < menuArray.length(); i++) {
            try {
                JSONObject menuObject = menuArray.getJSONObject(i);

                if (item.id.equals(menuObject.optString("id"))) {
                    // Sync item state from JSON
                    item.order = menuObject.optInt("order", item.order);
                    item.active = menuObject.optBoolean("active", item.active);

                    // Update title in JSON
                    menuObject.put("title", item.title);

                    // Special handling for view_res flag
                    if ("view_res".equals(item.id)) {
                        SharedPreferencesHelper.getInstance().active = item.active;
                    }

                    found = true;
                    break;
                }
            } catch (Exception e) {
                e.printStackTrace();
                return; // stop if bad JSON data
            }
        }

        // If not found, add the new menu item
        if (!found) {
            item.order = menuArray.length();
            menuArray.put(toJsonObject(item));
        }
    }

    public final void addMenuItem(String menuType, String itemId, String title, Drawable iconDrawable, int titleResId) {
        addMenuItem(menuType, itemId, title, iconDrawable, titleResId, true);
    }

    public final void addMenuItem(
            String menuType,
            String itemId,
            String title,
            Drawable iconDrawable,
            int titleResId,
            boolean active
    ) {
        MenuItem item = new MenuItem();
        item.id = itemId;
        item.title = title;
        item.titleResId = titleResId;
        item.icon = iconDrawable;
        item.active = active;
        switch (menuType) {
            case "main_menu":
                if (!this.mainMenuList.contains(item)) {
                    mainMenuList.add(item);
                }
                break;
            case "tool_menu":
                if (!this.toolMenuList.contains(item)) {
                    toolMenuList.add(item);
                }
                break;
            case "context_menu":
                if (!this.contextMenuList.contains(item)) {
                    contextMenuList.add(item);
                }
                break;
        }
    }

    public void m7021c(AbstractScrollableListController abstractC1540b, String str, int i) {
        MenuItem menuItemVarM7024F;
        if ((abstractC1540b instanceof AbstractScrollableListController) && (menuItemVarM7024F = m7024f(i)) != null && menuItemVarM7024F.active) {
            abstractC1540b.m9645e(str, i, menuItemVarM7024F.order);
        }
    }

    public final JSONObject toJsonObject(MenuItem item) throws JSONException {
        JSONObject jSONObject = new JSONObject();
        jSONObject.put("id", item.id);
        jSONObject.put("title", item.title);
        jSONObject.put("order", item.order);
        jSONObject.put("active", item.active);
        return jSONObject;
    }

    public final void m7023e(ArrayList<MenuItem> arrayList, JSONArray jSONArray) throws JSONException {
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            updateMenuItem(jSONArray, arrayList.get(i));
        }
    }

    public final MenuItem m7024f(int i) {
        Iterator it = this.contextMenuList.iterator();
        while (it.hasNext()) {
            MenuItem menuItemVar = (MenuItem) it.next();
            if (menuItemVar.titleResId == i) {
                return menuItemVar;
            }
        }
        return null;
    }

    public String m7025g(String str) {
        JSONArray jSONArray;
        if (str.equals("main_menu")) {
            jSONArray = this.mainMenuJson;
        } else if (str.equals("tool_menu")) {
            jSONArray = this.toolMenuJson;
        } else {
            if (!str.equals("context_menu")) {
                return "[]";
            }
            jSONArray = this.contextMenuArray;
        }
        return jSONArray.toString();
    }

    public String m7026h() {
        return this.contextMenuArray.toString();
    }

    public String m7027j() {
        return this.mainMenuJson.toString();
    }

    /**
     * Returns the absolute path for a file stored in the app's internal files directory.
     *
     * @param fileName Name of the file
     * @return Full absolute path as a String
     */
    public String getInternalFilePath(String fileName) {
        if (fileName == null) {
            fileName = "";
        }
        return new File(context.getFilesDir(), fileName).getAbsolutePath();
    }

    public ArrayList<MenuItem> getMenuList(String key) {
        switch (key) {
            case "main_menu":
                Collections.sort(this.mainMenuList, new Comparator<>() {
                    @Override
                    public int compare(MenuItem menuItemVar, MenuItem menuItemVar2) {
                        return menuItemVar.order - menuItemVar2.order;
                    }
                });
                return this.mainMenuList;
            case "tool_menu":
                return this.toolMenuList;
            case "context_menu":
                return this.contextMenuList;
        }
        return null;
    }

    public String getToolMenuJsonString() {
        return this.toolMenuJson.toString();
    }

    public boolean m7031n() {
        return this.isInitialized;
    }

    public void m7032o(Context context) {
        this.context = context;
        loadMenus();
        m7034q();
        m7035r();
        m7033p();
    }

    public final void m7033p() throws JSONException {
        this.contextMenuList.clear();
        addMenuItem("context_menu", "open_in_new_tab", this.context.getString(R.string.context_menu_open_new), null, R.string.context_menu_open_new);
        addMenuItem("context_menu", "open_with_full_screen", this.context.getString(R.string.context_menu_open_with_fullscreen), null, R.string.context_menu_open_with_fullscreen);
        addMenuItem("context_menu", "open_by_incognito", this.context.getString(R.string.context_menu_open_by_incognito), null, R.string.context_menu_open_by_incognito);
        addMenuItem("context_menu", "open_in_bg", this.context.getString(R.string.context_menu_open_in_bg), null, R.string.context_menu_open_in_bg);
        addMenuItem("context_menu", "copy_link", this.context.getString(R.string.context_menu_copy_link), null, R.string.context_menu_copy_link);
        addMenuItem("context_menu", "copy_img_link", this.context.getString(R.string.context_menu_copy_image_link), null, R.string.context_menu_copy_image_link);
        addMenuItem("context_menu", "copy_text", this.context.getString(R.string.context_menu_copy_text), null, R.string.context_menu_copy_text);
        addMenuItem("context_menu", "select_text", this.context.getString(R.string.context_menu_select_text), null, R.string.context_menu_select_text);
        addMenuItem("context_menu", "save_image", this.context.getString(R.string.context_menu_save_image), null, R.string.context_menu_save_image);
        addMenuItem("context_menu", "image_mode", this.context.getString(R.string.context_menu_image_mode), null, R.string.context_menu_image_mode);
        addMenuItem("context_menu", "mark_ad", this.context.getString(R.string.context_menu_mark_ad), null, R.string.context_menu_mark_ad);
        addMenuItem("context_menu", "save_image", this.context.getString(R.string.context_menu_save_image), null, R.string.context_menu_save_image);
        addMenuItem("context_menu", "share_image", this.context.getString(R.string.context_menu_share_image), null, R.string.context_menu_share_image);
        addMenuItem("context_menu", "mark_ad", this.context.getString(R.string.context_menu_mark_ad), null, R.string.context_menu_mark_ad);
        addMenuItem("context_menu", "recognize_qrcode", this.context.getString(R.string.context_menu_recognize_qrcode), null, R.string.context_menu_recognize_qrcode);
        addMenuItem("context_menu", "select_text", this.context.getString(R.string.context_menu_select_text), null, R.string.context_menu_select_text);
        addMenuItem("context_menu", "inspect_element", this.context.getString(R.string.inspect_element), null, R.string.inspect_element);
        addMenuItem("context_menu", "page_info", this.context.getString(R.string.page_info_view), null, R.string.page_info_view);
        m7023e(this.contextMenuList, this.contextMenuArray);
    }

    public final void m7034q() throws JSONException {
        this.mainMenuList.clear();
        addMenuItem("main_menu", "bm", this.context.getString(R.string.menu_bookmarks), this.context.getResources().getDrawable(R.drawable.ic_main_menu_bookmark), R.string.menu_bookmarks);
        addMenuItem("main_menu", "his", this.context.getString(R.string.menu_histories), this.context.getResources().getDrawable(R.drawable.ic_main_menu_history), R.string.menu_histories);
        addMenuItem("main_menu", "night", this.context.getString(R.string.menu_night_mode), this.context.getResources().getDrawable(R.drawable.ic_main_menu_night), R.string.menu_night_mode);
        addMenuItem("main_menu", "nopic", this.context.getString(R.string.menu_no_pic), this.context.getResources().getDrawable(R.drawable.ic_main_menu_no_pic), R.string.menu_no_pic);
        addMenuItem("main_menu", "addbm", this.context.getString(R.string.menu_new_bookmark), this.context.getResources().getDrawable(R.drawable.ic_add_bm), R.string.menu_new_bookmark);
        addMenuItem("main_menu", "dl", this.context.getString(R.string.menu_downloads), this.context.getResources().getDrawable(R.drawable.ic_main_menu_downloads), R.string.menu_downloads);
        addMenuItem("main_menu", "markad", this.context.getString(R.string.menu_mark_ad), this.context.getResources().getDrawable(R.drawable.ic_mark_ad), R.string.menu_mark_ad);
        addMenuItem("main_menu", "adb", this.context.getString(R.string.menu_ad_block), this.context.getResources().getDrawable(R.drawable.ic_main_menu_ad_block), R.string.menu_ad_block);
        addMenuItem("main_menu", "pcmode", this.context.getString(R.string.menu_pc_mode), this.context.getResources().getDrawable(R.drawable.ic_main_menu_pc_mode), R.string.menu_pc_mode);
        addMenuItem("main_menu", "privmode", this.context.getString(R.string.menu_private_mode), this.context.getResources().getDrawable(R.drawable.ic_main_menu_incognito), R.string.menu_private_mode);
        addMenuItem("main_menu", "toolbox", this.context.getString(R.string.menu_toolbox), this.context.getResources().getDrawable(R.drawable.ic_toolbox), R.string.menu_toolbox);
        addMenuItem("main_menu", "refresh", this.context.getString(R.string.menu_refresh), this.context.getResources().getDrawable(R.drawable.ic_refresh), R.string.menu_refresh);
        addMenuItem("main_menu", "good_for_eye", this.context.getString(R.string.menu_good_for_eye), this.context.getResources().getDrawable(R.drawable.ic_good_for_eye), R.string.menu_good_for_eye);
        addMenuItem("main_menu", "offlines", this.context.getString(R.string.menu_offline_page), this.context.getResources().getDrawable(R.drawable.ic_main_menu_offline_page), R.string.menu_offline_page);
        addMenuItem("main_menu", "fullscreen", this.context.getString(R.string.menu_full_screen), this.context.getResources().getDrawable(R.drawable.ic_main_menu_fullscreen), R.string.menu_full_screen);
        addMenuItem("main_menu", "js", this.context.getString(R.string.web_str_setting_disable_js), this.context.getResources().getDrawable(R.drawable.ic_js), R.string.web_str_setting_disable_js);
        addMenuItem("main_menu", "sd", this.context.getString(R.string.menu_sd_card), this.context.getResources().getDrawable(R.drawable.ic_sd), R.string.menu_sd_card, false);
        addMenuItem("main_menu", "ua", this.context.getString(R.string.web_str_choose_ua), this.context.getResources().getDrawable(R.drawable.ic_ua), R.string.web_str_choose_ua);
        addMenuItem("main_menu", "sr", this.context.getString(R.string.menu_screen_rotation), this.context.getResources().getDrawable(R.drawable.ic_screen_rotation_), R.string.menu_screen_rotation);
        addMenuItem("main_menu", "font_size", this.context.getString(R.string.menu_font_size), this.context.getResources().getDrawable(R.drawable.ic_font_size), R.string.menu_font_size);
        addMenuItem("main_menu", "share", this.context.getString(R.string.pop_menu_share), this.context.getResources().getDrawable(R.drawable.ic_share), R.string.pop_menu_share, false);
        addMenuItem("main_menu", "clean_up", this.context.getString(R.string.menu_clean_up), this.context.getResources().getDrawable(R.drawable.ic_clean_up), R.string.menu_clean_up);
        addMenuItem("main_menu", "tampermonkey", this.context.getString(R.string.menu_tampermonkey), this.context.getResources().getDrawable(R.drawable.ic_tampermonkey), R.string.menu_tampermonkey);
        m7023e(this.mainMenuList, this.mainMenuJson);
    }

    public final void m7035r() throws JSONException {
        this.toolMenuList.clear();
        addMenuItem("tool_menu", "add_bm", this.context.getString(R.string.pop_menu_add_bookmark), this.context.getResources().getDrawable(R.drawable.ic_add_bm), R.string.pop_menu_add_bookmark);
        addMenuItem("tool_menu", "add_qa", this.context.getString(R.string.pop_menu_add_to_quick_access), this.context.getResources().getDrawable(R.drawable.ic_context_menu_qa), R.string.pop_menu_add_to_quick_access);
        addMenuItem("tool_menu", "site_conf", this.context.getString(R.string.pop_menu_site_conf), this.context.getResources().getDrawable(R.drawable.ic_setting), R.string.pop_menu_site_conf);
        addMenuItem("tool_menu", "save_page", this.context.getString(R.string.pop_menu_offline_reading), this.context.getResources().getDrawable(R.drawable.ic_download_page), R.string.pop_menu_offline_reading);
        addMenuItem("tool_menu", "share", this.context.getString(R.string.pop_menu_share), this.context.getResources().getDrawable(R.drawable.ic_share), R.string.pop_menu_share);
        addMenuItem("tool_menu", "find", this.context.getString(R.string.pop_menu_find_in_page), this.context.getResources().getDrawable(R.drawable.ic_context_menu_find), R.string.pop_menu_find_in_page);
        addMenuItem("tool_menu", "send_desktop", this.context.getString(R.string.context_menu_send_to_destop), this.context.getResources().getDrawable(R.drawable.ic_shortcut), R.string.context_menu_send_to_destop, true);
        addMenuItem("tool_menu", "trans", this.context.getString(R.string.pop_menu_translate), this.context.getResources().getDrawable(R.drawable.ic_translated), R.string.pop_menu_translate);
        addMenuItem("tool_menu", "sniff_res", this.context.getString(R.string.pop_menu_sniff_res), this.context.getResources().getDrawable(R.drawable.ic_sniff_res), R.string.pop_menu_sniff_res);
        addMenuItem("tool_menu", "view_res", this.context.getString(R.string.pop_menu_view_res), this.context.getResources().getDrawable(R.drawable.ic_view_res), R.string.pop_menu_view_res);
        addMenuItem("tool_menu", "view_source", this.context.getString(R.string.pop_menu_view_source), this.context.getResources().getDrawable(R.drawable.ic_code), R.string.pop_menu_view_source);
        addMenuItem("tool_menu", "dev_tool", this.context.getString(R.string.pop_menu_dev_tools), this.context.getResources().getDrawable(R.drawable.ic_dev_tool), R.string.pop_menu_dev_tools);
        addMenuItem("tool_menu", "page_tts", this.context.getString(R.string.pop_menu_page_tts), this.context.getResources().getDrawable(R.drawable.ic_voice), R.string.pop_menu_page_tts);
        addMenuItem("tool_menu", "gen_qrcode", this.context.getString(R.string.pop_menu_gen_qrcode), this.context.getResources().getDrawable(R.drawable.ic_gen_qrcode), R.string.pop_menu_gen_qrcode);
        addMenuItem("tool_menu", "scan_qrcode", this.context.getString(R.string.pop_menu_scan_qrcode), this.context.getResources().getDrawable(R.drawable.ic_qrcode), R.string.pop_menu_scan_qrcode, false);
        addMenuItem("tool_menu", "page_info", this.context.getString(R.string.page_info_view), this.context.getResources().getDrawable(R.drawable.ic_info_outline), R.string.page_info_view, false);
        if (PhoneUtils.getInstance().isInChina()) {
            addMenuItem("tool_menu", "report_site", this.context.getString(R.string.pop_menu_report_site), this.context.getResources().getDrawable(R.drawable.ic_report), R.string.pop_menu_report_site, true);
        }
        m7023e(this.toolMenuList, this.toolMenuJson);
    }

    public void m7036s() {
        loadMenus();
        m7034q();
        m7035r();
        m7033p();
    }

    public void m7037t() {
        this.isInitialized = true;
    }

    public void m7038u() {
        this.mainMenuJson = new JSONArray();
        this.toolMenuJson = new JSONArray();
        this.contextMenuArray = new JSONArray();
        m7042y();
        m7043z();
        m7041x();
        m7034q();
        m7035r();
        m7033p();
        C1199a3.m5090f().m5093d("event_app_to_page", "reset_menu_config_done");
    }

    public final void loadMenus() {
        try {
            if (FileUtils.fileExists(getInternalFilePath("main_menu"))) {
                this.mainMenuJson = new JSONArray(FileUtils.readFileToString(getInternalFilePath("main_menu")));
            }
            if (FileUtils.fileExists(getInternalFilePath("tool_menu"))) {
                this.toolMenuJson = new JSONArray(FileUtils.readFileToString(getInternalFilePath("tool_menu")));
            }
            if (FileUtils.fileExists(getInternalFilePath("context_menu"))) {
                this.contextMenuArray = new JSONArray(FileUtils.readFileToString(getInternalFilePath("context_menu")));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void m7040w(String str, String str2) {
        try {
            if (str.equals("main_menu")) {
                this.mainMenuJson = new JSONArray(str2);
                m7034q();
                m7042y();
            } else if (str.equals("tool_menu")) {
                this.toolMenuJson = new JSONArray(str2);
                m7035r();
                m7043z();
            } else if (str.equals("context_menu")) {
                this.contextMenuArray = new JSONArray(str2);
                m7033p();
                m7041x();
            }
        } catch (JSONException e) {
            e.printStackTrace();
        }
        C1089Xm.getInstance().m4822j("syncable_menu").incrementVersion();
        C1089Xm.getInstance().m4822j("syncable_tool_menu").incrementVersion();
        C1089Xm.getInstance().m4822j("syncable_context_menu").incrementVersion();
        this.isInitialized = true;
    }

    public final void m7041x() {
        try {
            FileUtils.writeBytesToFile(this.contextMenuArray.toString().getBytes(StandardCharsets.UTF_8), getInternalFilePath("context_menu"));
        } catch (Exception unused) {
        }
    }

    public final void m7042y() {
        try {
            FileUtils.writeBytesToFile(this.mainMenuJson.toString().getBytes(StandardCharsets.UTF_8), getInternalFilePath("main_menu"));
        } catch (Exception unused) {
        }
    }

    public final void m7043z() {
        try {
            FileUtils.writeBytesToFile(this.toolMenuJson.toString().getBytes(StandardCharsets.UTF_8), getInternalFilePath("tool_menu"));
        } catch (Exception unused) {
        }
    }
}
