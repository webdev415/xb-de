package p000;

import android.database.SQLException;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public abstract class BaseDialogC0296Ga extends BaseDialog {

    public BrowserActivity browserActivity;

    public BaseDialogC0296Ga(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_exit_confirm);

        Button okButton = findViewById(R.id.btn_ok);
        CheckBox cbCleanLatestHistory = findViewById(R.id.clean_latest_his);
        CheckBox cbCleanSearchHistory = findViewById(R.id.clean_search_his);
        CheckBox cbDoNotShowDialog = findViewById(R.id.do_not_show_ext_dlg);

        // Load saved preferences
        boolean isCleanLatestHistoryChecked = SharedPreferencesHelper.getInstance().getBoolean("clean_latest_his_check", false);
        boolean isCleanSearchHistoryChecked = SharedPreferencesHelper.getInstance().getBoolean("clean_search_his_check", false);

        cbCleanLatestHistory.setChecked(isCleanLatestHistoryChecked);
        cbCleanSearchHistory.setChecked(isCleanSearchHistoryChecked);

        // Handle "OK" button click
        okButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                handleDialogConfirm(cbCleanLatestHistory, cbCleanSearchHistory, cbDoNotShowDialog);
                dismiss();
            }
        });

        // Handle "Cancel" button click
        Button cancelButton = findViewById(R.id.btn_cancel);
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mo1371b();
                dismiss();
            }
        });
    }

    private void handleDialogConfirm(CheckBox cbCleanLatestHistory, CheckBox cbCleanSearchHistory, CheckBox cbDoNotShowDialog) {
        boolean isCleanLatestHistoryChecked = cbCleanLatestHistory.isChecked();
        boolean isCleanSearchHistoryChecked = cbCleanSearchHistory.isChecked();
        boolean isDoNotShowDialogChecked = cbDoNotShowDialog.isChecked();

        // Handle cleaning of histories based on checkboxes
        if (isCleanLatestHistoryChecked) {
            MySQLiteOpenHelper.getInstance().deleteRecentHistory();
        }
        if (isCleanSearchHistoryChecked) {
            MySQLiteOpenHelper.getInstance().clearSearchHistory();
        }

        // Save the checkbox states in SharedPreferences
        SharedPreferencesHelper.getInstance().putBoolean("clean_latest_his_check", isCleanLatestHistoryChecked);
        SharedPreferencesHelper.getInstance().putBoolean("clean_search_his_check", isCleanSearchHistoryChecked);

        // Save whether to show the confirmation dialog on exit
        SharedPreferencesHelper.getInstance().putBoolean("show-confirm-dlg-on-exit", !isDoNotShowDialogChecked);
    }

    public abstract void mo1371b();

    public abstract void mo1372c();
}
