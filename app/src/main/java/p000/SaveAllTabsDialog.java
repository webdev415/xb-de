package p000;

import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;

public class SaveAllTabsDialog extends BaseDialog {

    public final BrowserActivity browserActivity;

    public SaveAllTabsDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = browserActivity;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_save_all_tabs);
        ((Button) findViewById(R.id.btn_ok)).setOnClickListener(view -> {
            // Get folder name entered by the user
            String folderName = ((EditText) findViewById(R.id.folder_name)).getText().toString();

            // Check if folder name contains invalid characters like / or \
            if (folderName.contains("/") || folderName.contains("\\")) {
                Toast.makeText(browserActivity, R.string.toast_folder_name_invalid, Toast.LENGTH_LONG).show();
                return;
            }

            // If the folder name is empty, set a default name
            if (TextUtils.isEmpty(folderName)) {
                folderName = browserActivity.getString(R.string.default_tabs_folder_name);
            }

            // Save the bookmark with the folder name
            browserActivity.saveBookmarkWithTabs(folderName);

            // Dismiss the dialog or activity
            dismiss();
        });
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(view -> dismiss());
    }
}
