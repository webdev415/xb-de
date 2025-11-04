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

public class DialogC0344Hc extends AbstractDialogC2267r {

    public static int[] colors = {0, 0xFFC7EDCC, 0xFFFAF9DE, 0xFFFFF2E2, 0xFFFDE6E0, 0xFFDCE2F1, 0xFFE9EBFE, 0xFFE3EDCD, 0xFFF5F0FA};

    public static String[] themes = {"default", "greenBean", "almondYellow", "autumnBrown", "rougeRed", "oceanBlue", "kudzuPurple", "grassGreen", "lavender"};

    public BrowserActivity browserActivity;

    public BaseAdapter adapter;

    public class a extends BaseAdapter {
        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public Object getItem(int i) {
            return colors[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int color = 0xFFEDEDED;
            View viewInflate = View.inflate(browserActivity, R.layout.choose_color_item, null);
            GradientDrawable gradientDrawable = (GradientDrawable) viewInflate.findViewById(R.id.color_item).getBackground().mutate();
            if (m1571d(position)) {
                gradientDrawable.setStroke(5, -11034895);
                gradientDrawable.setColor(DialogC0344Hc.colors[position]);
            }
            if (position == 0) {
                ((TextView) viewInflate.findViewById(R.id.item_text)).setText(R.string.default_title);
            } else {
                color = DialogC0344Hc.colors[position];
            }
            gradientDrawable.setColor(color);
            return viewInflate;
        }
    }

    public DialogC0344Hc(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = null;
        this.adapter = new a();
        this.browserActivity = browserActivity;
    }

    public static String m1570c(int i) {
        int i2 = 0;
        while (true) {
            int[] iArr = colors;
            if (i2 >= iArr.length) {
                return themes[0];
            }
            if (iArr[i2] == i) {
                return themes[i2];
            }
            i2++;
        }
    }

    @Override
    public void mo320a(Bundle bundle) {
        setContentView(R.layout.dlg_choose_color);
        GridView gridView = (GridView) findViewById(R.id.color_list);
        gridView.setAdapter((ListAdapter) this.adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            browserActivity.m6301c1(DialogC0344Hc.colors[position], true);
            adapter.notifyDataSetChanged();
        });
    }

    public final boolean m1571d(int i) {
        int i2 = 0;
        while (i2 < colors.length) {
            if (SharedPreferencesHelper.getInstance().goodForEyeColor == colors[i2]) {
                return i2 == i;
            }
            i2++;
        }
        return false;
    }
}
