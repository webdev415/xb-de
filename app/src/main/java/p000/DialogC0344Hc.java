package p000;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public class DialogC0344Hc extends AbstractDialogC2267r {

    public static int[] f1056d = {0, -3674676, -329250, -3358, -137504, -2301199, -1446914, -1839667, -659206};

    public static String[] f1057e = {"default", "greenBean", "almondYellow", "autumnBrown", "rougeRed", "oceanBlue", "kudzuPurple", "grassGreen", "lavender"};

    public BrowserActivity f1058b;

    public BaseAdapter f1059c;

    public class a extends BaseAdapter {
        public a() {
        }

        @Override
        public int getCount() {
            return DialogC0344Hc.f1056d.length;
        }

        @Override
        public Object getItem(int i) {
            return Integer.valueOf(DialogC0344Hc.f1056d[i]);
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            int i2;
            View viewInflate = View.inflate(DialogC0344Hc.this.f1058b, R.layout.choose_color_item, null);
            GradientDrawable gradientDrawable = (GradientDrawable) viewInflate.findViewById(R.id.color_item).getBackground().mutate();
            if (DialogC0344Hc.this.m1571d(i)) {
                gradientDrawable.setStroke(5, -11034895);
                gradientDrawable.setColor(DialogC0344Hc.f1056d[i]);
            }
            if (i == 0) {
                ((TextView) viewInflate.findViewById(R.id.item_text)).setText(R.string.default_title);
                i2 = -1184275;
            } else {
                i2 = DialogC0344Hc.f1056d[i];
            }
            gradientDrawable.setColor(i2);
            return viewInflate;
        }
    }

    public class b implements AdapterView.OnItemClickListener {
        public b() {
        }

        @Override
        public void onItemClick(AdapterView adapterView, View view, int i, long j) {
            DialogC0344Hc.this.f1058b.m6301c1(DialogC0344Hc.f1056d[i], true);
            DialogC0344Hc.this.f1059c.notifyDataSetChanged();
        }
    }

    public DialogC0344Hc(BrowserActivity browserActivity) {
        super(browserActivity);
        this.f1058b = null;
        this.f1059c = new a();
        this.f1058b = browserActivity;
    }

    public static String m1570c(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = f1056d;
            if (i2 >= iArr.length) {
                return f1057e[0];
            }
            if (iArr[i2] == i) {
                return f1057e[i2];
            }
            i2++;
        }
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_choose_color);
        GridView gridView = (GridView) findViewById(R.id.color_list);
        gridView.setAdapter((ListAdapter) this.f1059c);
        gridView.setOnItemClickListener(new b());
    }

    public final boolean m1571d(int i) {
        int i2 = 0;
        while (i2 < f1056d.length) {
            if (SharedPreferencesHelper.getInstance().goodForEyeColor == f1056d[i2]) {
                return i2 == i;
            }
            i2++;
        }
        return false;
    }
}
