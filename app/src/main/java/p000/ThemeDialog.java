package p000;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.TextView;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;

public class ThemeDialog extends BaseDialog {

    public static int[] colors = {0, 0xFFC7EDCC, 0xFFFAF9DE, 0xFFFFF2E2, 0xFFFDE6E0, 0xFFDCE2F1, 0xFFE9EBFE, 0xFFE3EDCD, 0xFFF5F0FA};

    public static String[] themes = {"default", "greenBean", "almondYellow", "autumnBrown", "rougeRed", "oceanBlue", "kudzuPurple", "grassGreen", "lavender"};

    public BrowserActivity browserActivity;

    public BaseAdapter adapter;

    public class ThemeAdapter extends BaseAdapter {
        @Override
        public int getCount() {
            return colors.length;
        }

        @Override
        public Object getItem(int position) {
            return colors[position];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            int color = 0xFFEDEDED;
            View root = View.inflate(browserActivity, R.layout.choose_color_item, null);
            GradientDrawable drawable = (GradientDrawable) root.findViewById(R.id.color_item).getBackground().mutate();
            if (m1571d(position)) {
                drawable.setStroke(5, 0xFF579EF1);
                drawable.setColor(ThemeDialog.colors[position]);
            }
            if (position == 0) {
                ((TextView) root.findViewById(R.id.item_text)).setText(R.string.default_title);
            } else {
                color = ThemeDialog.colors[position];
            }
            drawable.setColor(color);
            return root;
        }
    }

    public ThemeDialog(BrowserActivity browserActivity) {
        super(browserActivity);
        this.browserActivity = null;
        this.adapter = new ThemeAdapter();
        this.browserActivity = browserActivity;
    }

    public static String getThemeForColor(int color) {
        if (colors.length != themes.length) {
            throw new IllegalArgumentException("Colors and themes arrays must have the same length.");
        }

        for (int i = 0; i < colors.length; i++) {
            if (colors[i] == color) {
                return themes[i];
            }
        }

        // Return default theme if no match is found
        return themes.length > 0 ? themes[0] : null;
    }

    @Override
    public void initView(Bundle bundle) {
        setContentView(R.layout.dlg_choose_color);
        GridView gridView = (GridView) findViewById(R.id.color_list);
        gridView.setAdapter((ListAdapter) this.adapter);
        gridView.setOnItemClickListener((parent, view, position, id) -> {
            browserActivity.m6301c1(ThemeDialog.colors[position], true);
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
