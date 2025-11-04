package p000;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.content.res.Resources;
import android.graphics.Rect;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Build;
import android.text.Html;
import android.text.Layout;
import android.text.Spannable;
import android.text.TextUtils;
import android.text.method.LinkMovementMethod;
import android.text.style.URLSpan;
import android.util.Log;
import android.view.MotionEvent;
import android.view.TouchDelegate;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.BaseAdapter;
import android.widget.FrameLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;
import android.widget.Toast;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.BrowserFrameLayout;
import com.mmbox.xbrowser.VideoSniffingManager;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

public class C2518wb extends FrameLayout {

    public static C2518wb f7829k;

    public final View floatControlView;

    public BrowserFrameLayout browserFrameLayout;

    public PopupWindow popupWindow;

    public String f7833d;

    public String f7834e;

    public boolean isPopupVisible;

    public int f7836g;

    public ArrayList<Addon> addonList;

    public ArrayList f7838i;

    public k adapter;

    public class a implements PopupWindow.OnDismissListener {

        public class RunnableC2726a implements Runnable {

            public class RunnableC2727a implements Runnable {
                public RunnableC2727a() {
                }

                @Override
                public void run() {
                    BrowserActivity.getActivity().hasWindowFocus = false;
                }
            }

            public RunnableC2726a() {
            }

            @Override
            public void run() {
                BrowserActivity.getActivity().getHandler().postDelayed(new RunnableC2727a(), 100L);
            }
        }

        public a() {
        }

        @Override
        public void onDismiss() {
            setWindowDim(false);
            BrowserActivity.getActivity().runOnUiThread(new RunnableC2726a());
        }
    }

    public class e implements OnClickListener {
        @Override
        public void onClick(View view) throws URISyntaxException {
            String path = VideoSniffingManager.getInstance().m7000j().path;
            if (path != null) {
                Addon addon = getCurrentPlayer();
                if (addon == null) {
                    Toast.makeText(getContext(), "Not bind any player", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (addon.type == 2) {
                    Intent intent = new Intent("android.intent.action.VIEW");
                    intent.setDataAndType(Uri.parse(path), "video/*");
                    intent.putExtra("title", VideoSniffingManager.getInstance().m7000j().title);
                    getContext().startActivity(intent);
                    return;
                }
                if (addon.type == 3) {
                    if (!TextUtils.isEmpty(path)) {
                        BrowserActivity.getActivity().openUrl(path, true, 0);
                    }
                } else if (addon.type == 0) {
                    Intent intent2 = new Intent("android.intent.action.VIEW");
                    intent2.setDataAndType(Uri.parse(path), "video/*");
                    intent2.setClassName(addon.id, addon.mainClassName);
                    intent2.putExtra("title", VideoSniffingManager.getInstance().m7000j().title);
                    getContext().startActivity(intent2);
                }
            }
        }
    }

    public class g extends TouchDelegate {
        public g(Rect rect, View view) {
            super(rect, view);
        }

        @Override
        public boolean onTouchEvent(MotionEvent motionEvent) {
            if (!isPopupVisible || motionEvent.getActionMasked() != 0) {
                return false;
            }
            float x = motionEvent.getX();
            float y = motionEvent.getY();
            Rect rect = new Rect();
            getHitRect(rect);
            if (rect.contains((int) x, (int) y)) {
                return false;
            }
            dismissPopup();
            return true;
        }
    }

    public class k extends BaseAdapter {

        public ArrayList f7852a = null;

        public void m10541a(ArrayList arrayList) {
            this.f7852a = arrayList;
        }

        @Override
        public int getCount() {
            if (f7852a == null) {
                return 0;
            }
            return f7852a.size();
        }

        @Override
        public Object getItem(int i) {
            if (f7852a == null) {
                return null;
            }
            return f7852a.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0L;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            String str = f7836g == 0 ? f7833d : f7834e;
            if (view == null) {
                view = ThemeManager.getInstance().m9492m();
            }
            TextView textView = (TextView) view.findViewById(R.id.menu_item_title);
            Addon addon = (Addon) this.f7852a.get(i);
            if (i == 0 && TextUtils.isEmpty(str)) {
                str = addon.id;
            }
            textView.setText(addon.title);
            ((TextView) view.findViewById(R.id.check_flag)).setVisibility(addon.id.equals(str) ? 0 : 4);
            return view;
        }
    }

    public C2518wb(Context context) {
        super(context);
        this.f7833d = "share";
        this.f7834e = "";
        this.isPopupVisible = false;
        this.f7836g = 0;
        this.addonList = new ArrayList<>();
        this.f7838i = new ArrayList<>();
        this.adapter = new k();
        m10536f();
        floatControlView = ThemeManager.getInstance().getFloatControlView();
        View btnDown = floatControlView.findViewById(R.id.btn_down);
        View btnPlayOrPause = floatControlView.findViewById(R.id.btn_play_or_pause);
        View btnPlyrSetting = floatControlView.findViewById(R.id.btn_plyr_setting);
        View btnCopyLink = floatControlView.findViewById(R.id.btn_copy_link);
        View btnCast = floatControlView.findViewById(R.id.btn_cast);
        if (btnPlyrSetting != null) {
            btnPlyrSetting.setOnClickListener(view -> {
                if (!BrowserActivity.getActivity().hasWindowFocus) {
                    m10540k();
                    BrowserActivity.getActivity().hasWindowFocus = true;
                }
            });
        }
        if (btnCast != null) {
            btnCast.setOnClickListener(view -> BrowserActivity.getActivity().m6237N(VideoSniffingManager.getInstance().m7000j().path));
        }
        if (btnDown != null) {
            btnDown.setOnClickListener(view -> {
                String str = VideoSniffingManager.getInstance().m7000j().path;
                if (str != null) {
                    Log.i("video-sniff", "media url:" + str);
                    VideoSniffingManager.getInstance().m7002l();
                }
            });
        }
        if (btnPlayOrPause != null) {
            btnPlayOrPause.setOnClickListener(new e());
        }
        if (btnCopyLink != null) {
            btnCopyLink.setOnClickListener(view -> {
                String str = VideoSniffingManager.getInstance().m7000j().path;
                if (str != null) {
                    AndroidSystemUtils.m8701i(getContext(), str);
                    Toast.makeText(getContext(), R.string.toast_copy_link_to_clipboard, Toast.LENGTH_LONG).show();
                }
            });
        }
        setId(13398);
    }

    public static void m10533d() {
        C2518wb c2518wb = f7829k;
        if (c2518wb != null) {
            c2518wb.dismissPopup();
        }
    }

    /* JADX INFO: Access modifiers changed from: private */
    public Addon getCurrentPlayer() {
        for (int i2 = 0; i2 < this.addonList.size(); i2++) {
            Addon addon = (Addon) this.addonList.get(i2);
            if (addon.id.equals(this.f7833d)) {
                return addon;
            }
        }
        return null;
    }

    private Animation getShowAnimation() {
        return AnimationUtils.loadAnimation(getContext(), R.anim.faid_in);
    }

    public static void m10534j(BrowserFrameLayout browserFrameLayout) throws Resources.NotFoundException {
        if (TextUtils.isEmpty(VideoSniffingManager.getInstance().m7000j().path)) {
            Toast.makeText(BrowserActivity.getActivity(), "Lost Media url ,pls try sniff again.", Toast.LENGTH_SHORT).show();
            return;
        }
        if (f7829k == null) {
            f7829k = new C2518wb(browserFrameLayout.getContext());
        }
        C2518wb c2518wb = f7829k;
        if (c2518wb.isPopupVisible) {
            return;
        }
        c2518wb.m10538h(browserFrameLayout);
    }

    public void dismissPopup() {
        // Remove this view from its parent layout and clear touch delegate
        if (browserFrameLayout != null) {
            browserFrameLayout.removeView(this);
            browserFrameLayout.setTouchDelegate(null);
        }

        // Dismiss the popup window if it is showing
        if (popupWindow != null && popupWindow.isShowing()) {
            popupWindow.dismiss();
        }

        // Update internal state
        isPopupVisible = false;
    }

    public final void m10536f() {
        this.f7833d = SharedPreferencesHelper.getInstance().getString("video.opener", "share");
        this.f7834e = SharedPreferencesHelper.getInstance().getString("video.cast", "");
        m10537g();
        if ((TextUtils.isEmpty(this.f7833d) || (!this.f7833d.equals("play_at_new_tab") && !C2406u0.getInstance().m9893l(this.f7833d))) && this.addonList.size() > 0) {
            this.f7833d = ((Addon) this.addonList.get(0)).id;
        }
        if ((TextUtils.isEmpty(this.f7834e) || !C2406u0.getInstance().m9893l(this.f7834e)) && this.f7838i.size() > 0) {
            this.f7834e = ((Addon) this.f7838i.get(0)).id;
        }
    }

    public final void m10537g() {
        Addon addon3RdParty = new Addon();
        addon3RdParty.id = "share";
        addon3RdParty.title = getContext().getString(R.string.opt_forward_third_party);
        addon3RdParty.type = 2;
        addonList.add(addon3RdParty);

        Addon addonNewTab = new Addon();
        addonNewTab.title = getContext().getString(R.string.opt_open_in_new_tab);
        addonNewTab.type = 3;
        addonNewTab.id = "play_at_new_tab";
        addonList.add(addonNewTab);

        Intent intent = new Intent("android.intent.action.VIEW");
        intent.setDataAndType(Uri.parse(VideoSniffingManager.getInstance().m7000j().path), "video/*");
        PackageManager packageManager = getContext().getPackageManager();
        List<ResolveInfo> listQueryIntentActivities = packageManager.queryIntentActivities(intent, 0);
        for (int i2 = 0; i2 < listQueryIntentActivities.size(); i2++) {
            ActivityInfo activityInfo = listQueryIntentActivities.get(i2).activityInfo;
            Addon addonM9886D = C2406u0.getInstance().m9886d(activityInfo.packageName);
            if (addonM9886D != null && addonM9886D.extPoint == 8) {
                addonM9886D.type = 0;
                addonM9886D.title = activityInfo.applicationInfo.loadLabel(packageManager).toString();
                String str = activityInfo.name;
                addonM9886D.mainClassName = str;
                addonM9886D.className = str;
                this.f7838i.add(addonM9886D);
            }
            Addon c2360t03 = new Addon();
            c2360t03.type = 0;
            c2360t03.title = activityInfo.loadLabel(packageManager).toString();
            c2360t03.id = activityInfo.packageName;
            String str2 = activityInfo.name;
            c2360t03.mainClassName = str2;
            c2360t03.className = str2;
            this.addonList.add(c2360t03);
        }
    }

    public void m10538h(BrowserFrameLayout frameLayout) throws Resources.NotFoundException {
        this.browserFrameLayout = frameLayout;
        Rect rect = new Rect();
        this.browserFrameLayout.getHitRect(rect);
        g gVar = new g(rect, this.floatControlView);
        if (this.browserFrameLayout.findViewById(13398) == null) {
            LayoutParams layoutParams = new LayoutParams(-1, -2);
            removeAllViews();
            addView(this.floatControlView);
            frameLayout.getContext().getResources().getDimension(R.dimen.fcb_gravity_x);
            int dimension = (int) frameLayout.getContext().getResources().getDimension(R.dimen.fcb_gravity_y);
            if (Build.VERSION.SDK_INT >= 35 && BrowserActivity.getActivity().getApplication().getApplicationInfo().targetSdkVersion >= 35 && !SharedPreferencesHelper.getInstance().browserFullscreenMode) {
                dimension += PhoneUtils.getInstance().getNavigationBarHeight();
            }
            layoutParams.gravity = 83;
            layoutParams.bottomMargin = dimension;
            setLayoutParams(layoutParams);
            setAnimation(getShowAnimation());
            this.browserFrameLayout.addView(this);
            this.browserFrameLayout.setTouchDelegate(gVar);
            this.isPopupVisible = true;
        }
    }

    /**
     * Adjusts the background transparency of the BrowserActivity window.
     *
     * @param dim true to dim the background, false to restore full opacity
     */
    public final void setWindowDim(boolean dim) {
        float alpha = dim ? 0.4f : 1.0f;
        Activity activity = BrowserActivity.getActivity();
        if (activity == null) return;

        WindowManager.LayoutParams params = activity.getWindow().getAttributes();
        params.alpha = alpha;
        activity.getWindow().setAttributes(params);
    }

    public void m10540k() {
        ArrayList arrayList;
        View viewM9493n = ThemeManager.getInstance().m9493n();
        ListView openMethodListView = (ListView) viewM9493n.findViewById(R.id.open_method_list);
        TextView tvEmpty = (TextView) viewM9493n.findViewById(R.id.emptyView);
        tvEmpty.setText(Html.fromHtml(getContext().getString(R.string.empty_video_cast_list)));
        tvEmpty.setMovementMethod(new LinkMovementMethod() {

            @Override
            public boolean onTouchEvent(TextView textView, Spannable spannable, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_UP) {
                    int x = (int) event.getX();
                    int y = (int) event.getY();

                    // Adjust for padding and scroll
                    int adjustedX = x - textView.getTotalPaddingLeft() + textView.getScrollX();
                    int adjustedY = y - textView.getTotalPaddingTop() + textView.getScrollY();

                    Layout layout = textView.getLayout();
                    int offset = layout.getOffsetForHorizontal(layout.getLineForVertical(adjustedY), adjustedX);

                    URLSpan[] urlSpans = spannable.getSpans(offset, offset, URLSpan.class);
                    if (urlSpans.length > 0) {
                        String url = urlSpans[0].getURL();
                        BrowserActivity.getActivity().openUrl(url, true, 0);
                        return true;
                    }
                }

                return super.onTouchEvent(textView, spannable, event);
            }
        });
        openMethodListView.setEmptyView(tvEmpty);
        if (this.f7836g == 0) {
            arrayList = this.addonList;
        } else {
            arrayList = this.f7838i;
        }
        adapter.m10541a(arrayList);
        openMethodListView.setAdapter(adapter);
        openMethodListView.setOnItemClickListener((parent, view, position, id) -> {
            if (f7836g == 0) {
                Addon addon = (Addon) addonList.get(position);
                f7833d = addon.id;
                SharedPreferencesHelper.getInstance().putString("video.opener", f7833d);
            } else {
                Addon c2360t02 = (Addon) f7838i.get(position);
                f7834e = c2360t02.id;
                SharedPreferencesHelper.getInstance().putString("video.cast", f7834e);
            }
            adapter.notifyDataSetChanged();
        });
        int dimension = (int) getContext().getResources().getDimension(R.dimen.plyr_setting_menu_margin_x);
        int height = BrowserActivity.getActivity().findViewById(R.id.bottom_content).getHeight() * 2;
        popupWindow = new PopupWindow(viewM9493n, (int) getContext().getResources().getDimension(R.dimen.plyr_setting_menu_width), -2);
        popupWindow.setOutsideTouchable(true);
        popupWindow.setTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        popupWindow.setTouchInterceptor((view, motionEvent) -> {
            if (motionEvent.getAction() != 4) {
                return false;
            }
            popupWindow.dismiss();
            return true;
        });
        popupWindow.setOnDismissListener(new a());
        popupWindow.showAtLocation(this.browserFrameLayout, 83, dimension, height);
        setWindowDim(true);
    }

    @SuppressLint("ClickableViewAccessibility")
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();

        int action = event.getAction();

        // Dismiss popup if touch is outside the view bounds
        if (action == MotionEvent.ACTION_DOWN &&
                (x < 0 || x >= getWidth() || y < 0 || y >= getHeight())) {
            dismissPopup();
            return true;
        }

        // Dismiss popup on outside touch (e.g., ACTION_OUTSIDE)
        if (action == MotionEvent.ACTION_OUTSIDE) {
            dismissPopup();
            return true;
        }

        // Let parent handle other touch events
        super.onTouchEvent(event);
        return true;
    }
}
