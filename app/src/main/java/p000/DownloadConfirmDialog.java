package p000;

import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.util.ArrayList;

public abstract class DownloadConfirmDialog extends BaseDialog {

    public BrowserActivity browserActivity;

    public String title;

    public String text;

    public String fileName;

    public String strFileSize;

    public PopupWindow popupWindow;

    public CheckBox checkBox;

    public i adapter;

    public TextView tvTitleDefaultDownloader;

    public boolean isPopupShowing;

    public boolean isDownloaderSelectable;

    public ArrayList<C1224ai.ThirdApp> f5705m;

    public class a implements View.OnClickListener {

        public final TextView f5706a;

        public final ImageView f5707b;

        public a(TextView textView, ImageView imageView) {
            this.f5706a = textView;
            this.f5707b = imageView;
        }

        @Override
        public void onClick(View view) {
            this.f5706a.setEnabled(true);
            this.f5706a.setTextColor(0xFF000000);
            this.f5706a.setBackgroundResource(R.drawable.default_search_box_bg);
            this.f5707b.setVisibility(View.GONE);
        }
    }

    public class i extends BaseAdapter {

        public class a implements View.OnClickListener {

            public final int f5720a;

            public a(int i) {
                this.f5720a = i;
            }

            @Override
            public void onClick(View view) {
                CheckBox checkBox;
                int i;
                C1224ai.ThirdApp thirdAppVar = (C1224ai.ThirdApp) f5705m.get(this.f5720a);
                tvTitleDefaultDownloader.setText(thirdAppVar.name);
                SharedPreferencesHelper.getInstance().putString("default_downloader", thirdAppVar.pkg);
                popupWindow.dismiss();
                if (DownloadConfirmDialog.this.checkBox != null) {
                    if (thirdAppVar.pkg.equals("com.x.browser.downloader") || thirdAppVar.pkg.equals("com.android.providers.downloads")) {
                        checkBox = DownloadConfirmDialog.this.checkBox;
                        i = 8;
                    } else {
                        checkBox = DownloadConfirmDialog.this.checkBox;
                        i = 0;
                    }
                    checkBox.setVisibility(i);
                }
            }
        }

        public C1224ai.ThirdApp m7814a(String str) {
            for (int i = 0; i < f5705m.size(); i++) {
                C1224ai.ThirdApp thirdApp = (C1224ai.ThirdApp) f5705m.get(i);
                if (thirdApp.pkg.equals(str)) {
                    return thirdApp;
                }
            }
            return null;
        }

        @Override
        public C1224ai.ThirdApp getItem(int i) {
            return (C1224ai.ThirdApp) f5705m.get(i);
        }

        @Override
        public int getCount() {
            return f5705m.size();
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            TextView textView = (TextView) View.inflate(browserActivity, R.layout.downloader_item, null).findViewById(R.id.downloader_title);
            textView.setClickable(true);
            textView.setOnClickListener(new a(i));
            textView.setText(((C1224ai.ThirdApp) f5705m.get(i)).name);
            return textView;
        }
    }

    public DownloadConfirmDialog(BrowserActivity browserActivity) {
        this(browserActivity, true);
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_download_confirm);
        ImageView ivRename = (ImageView) findViewById(R.id.rename);
        TextView tvTitle = (TextView) findViewById(R.id.title_info);
        TextView tvText = (TextView) findViewById(R.id.text_info);
        TextView tvFileName = (TextView) findViewById(R.id.file_name);
        TextView tvFileSize = (TextView) findViewById(R.id.file_size);
        ImageView ivShare = (ImageView) findViewById(R.id.share_to_other);
        tvTitle.setText(this.title);
        tvText.setText(this.text);
        tvFileName.setText(this.fileName);
        tvFileSize.setText(this.strFileSize);
        ivRename.setOnClickListener(new a(tvFileName, ivRename));
        ivShare.setOnClickListener(view -> mo6444h());
        if (SharedPreferencesHelper.getInstance().enterNightMode) {
            ivRename.setColorFilter(-7829368);
        } else {
            ivRename.clearColorFilter();
        }
        View vDownloaderSelector = findViewById(R.id.downloader_selector);
        if (this.isDownloaderSelectable) {
            vDownloaderSelector.setOnClickListener(view -> {
                if (!isPopupShowing) {
                    showSelectDownloaderPopup(vDownloaderSelector);
                }
            });
            String strM6871P = SharedPreferencesHelper.getInstance().getString("default_downloader", "com.x.browser.downloader");
            CheckBox checkBox = (CheckBox) findViewById(R.id.as_default_downloader);
            this.checkBox = checkBox;
            if (checkBox != null) {
                if (!TextUtils.isEmpty(strM6871P) && !strM6871P.equals("com.x.browser.downloader") && !strM6871P.equals("com.android.providers.downloads") && C2406u0.getInstance().m9883a(strM6871P)) {
                    this.checkBox.setVisibility(View.VISIBLE);
                }
                this.checkBox.setOnCheckedChangeListener((compoundButton, z) -> {
                    if (!z) {
                        SharedPreferencesHelper.getInstance().putString("bind_default_downloader", "");
                    } else {
                        SharedPreferencesHelper.getInstance().putString("bind_default_downloader", SharedPreferencesHelper.getInstance().getString("default_downloader", ""));
                    }
                });
            }
            this.tvTitleDefaultDownloader = (TextView) vDownloaderSelector.findViewById(R.id.download_name);
            C1224ai.ThirdApp aVarM7814ThirdApp = this.adapter.m7814a(strM6871P);
            if (aVarM7814ThirdApp != null) {
                this.tvTitleDefaultDownloader.setText(aVarM7814ThirdApp.name);
            } else {
                SharedPreferencesHelper.getInstance().putString("default_downloader", "com.x.browser.downloader");
                this.tvTitleDefaultDownloader.setText(R.string.title_default_downloader);
            }
        } else {
            vDownloaderSelector.setVisibility(View.GONE);
        }
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (TextUtils.isEmpty(tvFileName.getEditableText().toString())) {
                    Toast.makeText(browserActivity, R.string.toast_invalid_url, Toast.LENGTH_SHORT).show();
                } else {
                    mo6443g();
                    dismiss();
                }
            }
        });
        ((Button) findViewById(R.id.btn_copy_link)).setOnClickListener(view -> mo6442f());
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> {
            mo6441e();
            dismiss();
        });
    }

    public final void m7811d() {
        this.f5705m = C1224ai.getInstance().getAppList("downloader");
    }

    public abstract void mo6441e();

    public abstract void mo6442f();

    public abstract void mo6443g();

    public abstract void mo6444h();

    public void m7812i(String str, String str2, String str3, String str4) {
        this.title = str;
        this.text = str2;
        this.fileName = str3;
        String string = this.browserActivity.getString(R.string.dlg_download_size);
        if (str4.indexOf("--") >= 0 || str4.indexOf("0B") >= 0) {
            str4 = this.browserActivity.getString(R.string.dlg_download_size_unknown);
        }
        this.strFileSize = String.format(string, str4);
        show();
    }

    public final void showSelectDownloaderPopup(View view) {
        int dimension = (int) this.browserActivity.getResources().getDimension(R.dimen.popmenu_offset_y);
        View viewInflate = View.inflate(this.browserActivity, R.layout.select_downloader_pop_win, null);
        this.popupWindow = new PopupWindow(viewInflate, view.getMeasuredWidth(), -2);
        ListView listView = (ListView) viewInflate.findViewById(R.id.downloader_list_view);
        listView.setAdapter((ListAdapter) this.adapter);
        listView.setFocusable(true);
        this.popupWindow.setTouchable(true);
        this.popupWindow.setOnDismissListener(() -> browserActivity.getHandler().postDelayed(() -> isPopupShowing = false, 100L));
        this.popupWindow.setBackgroundDrawable(new ColorDrawable(0));
        this.popupWindow.setOutsideTouchable(true);
        this.popupWindow.showAsDropDown(view, 0, dimension);
        this.isPopupShowing = true;
    }

    public DownloadConfirmDialog(BrowserActivity browserActivity, boolean z) {
        super(browserActivity);
        this.browserActivity = null;
        this.title = null;
        this.text = null;
        this.fileName = null;
        this.strFileSize = null;
        this.popupWindow = null;
        this.checkBox = null;
        this.adapter = new i();
        this.tvTitleDefaultDownloader = null;
        this.isPopupShowing = false;
        this.f5705m = null;
        this.browserActivity = browserActivity;
        this.isDownloaderSelectable = z;
        m7811d();
    }
}
