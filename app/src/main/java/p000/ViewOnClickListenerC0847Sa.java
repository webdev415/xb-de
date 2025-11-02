package p000;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.xbrowser.play.R;
import java.io.File;
import org.json.JSONException;
import org.json.JSONObject;

/* loaded from: classes.dex */
public class ViewOnClickListenerC0847Sa extends AbstractDialogC2267r implements View.OnClickListener {

    public BrowserActivity f2622b;

    public String f2623c;

    public class a implements View.OnClickListener {

        public final EditText f2624a;

        public final String f2625b;

        public final File f2626c;

        public a(EditText editText, String str, File file) {
            this.f2624a = editText;
            this.f2625b = str;
            this.f2626c = file;
        }

        @Override
        public void onClick(View view) throws JSONException {
            String strTrim = this.f2624a.getText().toString().trim();
            String str = this.f2625b + "/" + strTrim;
            boolean zIsDirectory = this.f2626c.isDirectory();
            FileUtils.getFileType(strTrim);
            AndroidSystemUtils.m8718z(this.f2626c.lastModified());
            AndroidSystemUtils.formatFileSize(this.f2626c.length());
            if (!ViewOnClickListenerC0847Sa.this.f2623c.equals(str)) {
                if (FileUtils.fileExists(str)) {
                    Toast.makeText(ViewOnClickListenerC0847Sa.this.f2622b, "File existed ", Toast.LENGTH_SHORT).show();
                } else {
                    FileUtils.moveOrRenameFile(ViewOnClickListenerC0847Sa.this.f2623c, str);
                    String strM8714v = AndroidSystemUtils.prefixWithMd5(ViewOnClickListenerC0847Sa.this.f2623c);
                    String strM8714v2 = AndroidSystemUtils.prefixWithMd5(str);
                    JSONObject jSONObject = new JSONObject();
                    try {
                        jSONObject.put("transId", "notify_file_rename");
                        jSONObject.put("oldId", strM8714v);
                        jSONObject.put("newId", strM8714v2);
                        jSONObject.put("fileName", strTrim);
                        jSONObject.put("fullName", str);
                        jSONObject.put("type", zIsDirectory ? 1 : 0);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                    C1199a3.m5090f().m5094e("event_app_to_page", jSONObject);
                }
            }
            ViewOnClickListenerC0847Sa.this.dismiss();
        }
    }

    public class b implements View.OnClickListener {
        public b() {
        }

        @Override
        public void onClick(View view) {
            ViewOnClickListenerC0847Sa.this.dismiss();
        }
    }

    public ViewOnClickListenerC0847Sa(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f2623c = null;
        this.f2622b = browserActivity;
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_single_text_field);
        EditText editText = (EditText) findViewById(R.id.edit_text);
        String str = this.f2623c;
        String strSubstring = str.substring(0, str.lastIndexOf("/"));
        Button button = (Button) findViewById(R.id.btn_ok);
        File file = new File(this.f2623c);
        editText.setText(file.getName());
        button.setOnClickListener(new a(editText, strSubstring, file));
        ((Button) findViewById(R.id.btn_cancel)).setOnClickListener(new b());
    }

    public void m4034b(String str) {
        this.f2623c = str;
        show();
    }

    @Override
    public void onClick(View view) {
    }
}
