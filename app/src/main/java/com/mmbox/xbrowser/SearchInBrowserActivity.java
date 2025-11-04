package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;

public class SearchInBrowserActivity extends Activity {
    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        CharSequence charSequenceExtra = getIntent().getCharSequenceExtra("android.intent.extra.PROCESS_TEXT");
        if (!TextUtils.isEmpty(charSequenceExtra)) {
            Intent intent = new Intent("android.intent.action.WEB_SEARCH");
            intent.setClassName(getPackageName(), BrowserActivity.class.getName());
            intent.putExtra("query", charSequenceExtra);
            startActivity(intent);
        }
        finish();
    }
}
