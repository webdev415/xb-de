package com.mmbox.xbrowser;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import p000.C1651dn;

/* loaded from: classes.dex */
public class TextToSpeechActivity extends Activity {

    public String f4550a;

    public final void m6535a(Intent intent) {
        if ("android.intent.action.PROCESS_TEXT".equals(intent.getAction())) {
            String stringExtra = intent.getStringExtra("android.intent.extra.PROCESS_TEXT");
            this.f4550a = stringExtra;
            if (stringExtra != null) {
                C1651dn.m7356c().m7361h(this.f4550a);
            }
        }
    }

    @Override
    public void onCreate(Bundle bundle) {
        super.onCreate(bundle);
        m6535a(getIntent());
        finish();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    @Override
    public void onNewIntent(Intent intent) {
        super.onNewIntent(intent);
        m6535a(intent);
    }
}
