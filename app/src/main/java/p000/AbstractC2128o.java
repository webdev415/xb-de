package p000;

import android.graphics.Color;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.drawable.ColorDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.GradientDrawable;
import android.graphics.drawable.StateListDrawable;
import android.os.Build;
import android.util.Log;
import android.view.View;
import android.view.Window;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import com.mmbox.widget.IndicatorImageButton;
import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.mmbox.xbrowser.searchbox.SuggestionInputView;
import com.xbrowser.play.R;

/* loaded from: classes.dex */
public abstract class AbstractC2128o implements InterfaceC0299Gd {

    public static int f6486Q = -11034895;

    public int f6497K = 0xFF000000;

    public int f6498L = 0xFFFFFFFF;

    public BrowserActivity browserActivity;

    public int f6504b = -855310;

    public int f6505c = -8947849;

    public int f6506d = 0;

    public int f6507e = 0xFFFFFFFF;

    public int backgroundColor = 0xFFFFFFFF;

    public int f6509g = 0xFFFFFFFF;

    public int f6510h = -7829368;

    public int f6511i = 0xFFFFFFFF;

    public int f6512j = 0xFFFFFFFF;

    public int colorWhite = 0xFFFFFFFF;

    public int colorDarkGray = 0xFF272727;

    public int f6515m = 0xFFFFFFFF;

    public int f6516n = 0xFF272727;

    public int f6517o = -788553968;

    public int f6518p = 1614001637;

    public int f6519q = -5522986;

    public int f6520r = -5522986;

    public int f6521s = -4334611;

    public int f6522t = 0xFF000000;

    public int f6523u = -8816263;

    public int f6524v = 0xFF272727;

    public int f6525w = -2012607990;

    public int f6526x = 0xFFFFFFFF;

    public int f6527y = 0xFF272727;

    public int f6528z = 0xFFFFFFFF;

    public int f6487A = 0xFFFFFFFF;

    public int f6488B = -855310;

    public int f6489C = 0xFFFFFFFF;

    public int f6490D = -986896;

    public int f6491E = 0xFF272727;

    public int f6492F = -4210753;

    public int f6493G = 0xFF272727;

    public int f6494H = -11034895;

    public int f6495I = -11053225;

    public float f6496J = 0.5f;

    public boolean f6499M = true;

    public boolean f6500N = false;

    public boolean f6501O = true;

    public boolean f6502P = false;

    public AbstractC2128o(BrowserActivity activity) {
        browserActivity = activity;
        f6497K = mo1388g();
        f6498L = Color.parseColor("#6033B5E5");
    }

    public static ColorMatrixColorFilter m8815m(int i) {
        return new ColorMatrixColorFilter(new float[]{0.0f, 0.0f, 0.0f, 0.0f, Color.red(i), 0.0f, 0.0f, 0.0f, 0.0f, Color.green(i), 0.0f, 0.0f, 0.0f, 0.0f, Color.blue(i), 0.0f, 0.0f, 0.0f, Color.alpha(i) / 255.0f, 0.0f});
    }

    public static int m8816n(int i, int i2) {
        Color.alpha(i);
        int iRed = Color.red(i);
        int iGreen = Color.green(i);
        int iGreen2 = Color.green(i);
        return Color.rgb(iRed > 200 ? iRed - i2 : iRed + i2, iGreen > 200 ? iGreen - i2 : iGreen + i2, iGreen2 > 200 ? iGreen2 - i2 : iGreen2 + i2);
    }

    public final void m8817A(View view) {
        View viewFindViewById;
        Paint paint;
        int i;
        ImageView imageView = (ImageButton) view.findViewById(R.id.toolbar_btn_back);
        ImageView imageView2 = (ImageButton) view.findViewById(R.id.toolbar_btn_forward);
        ImageView imageView3 = (ImageButton) view.findViewById(R.id.toolbar_btn_home);
        ImageView imageView4 = (ImageButton) view.findViewById(R.id.toolbar_btn_refresh);
        IndicatorImageButton indicatorImageButton = (IndicatorImageButton) view.findViewById(R.id.toolbar_btn_muti_window);
        ImageView imageView5 = (ImageButton) view.findViewById(R.id.toolbar_btn_menu);
        TextView textView = (TextView) view.findViewById(R.id.fake_search_box_bottom);
        if (imageView != null) {
            mo1389h(imageView);
        }
        if (imageView2 != null) {
            mo1389h(imageView2);
        }
        if (imageView3 != null) {
            mo1389h(imageView3);
        }
        if (imageView4 != null) {
            mo1389h(imageView4);
        }
        if (indicatorImageButton != null) {
            mo1389h(indicatorImageButton);
            if (ThemeManager.getInstance().isColorLight(backgroundColor)) {
                paint = indicatorImageButton.getPaint();
                i = f6491E;
            } else {
                paint = indicatorImageButton.getPaint();
                i = f6490D;
            }
            paint.setColor(i);
        }
        if (imageView5 != null) {
            mo1389h(imageView5);
        }
        if (textView != null) {
            textView.setTextColor(ThemeManager.getInstance().isColorLight(backgroundColor) ? colorDarkGray : colorWhite);
        }
        Drawable drawableM8821u = m8821u(backgroundColor);
        if (drawableM8821u != null && (viewFindViewById = view.findViewById(R.id.fake_search_box_holder_bottom)) != null) {
            m8820D(viewFindViewById, drawableM8821u);
        }
        view.setBackgroundColor(backgroundColor);
    }

    public void m8818B(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            drawable.clearColorFilter();
            m8824y(drawable, imageView.isEnabled() ? ThemeManager.getInstance().isColorLight(f6507e) ? f6491E : f6490D : f6492F);
        }
    }

    public final void m8819C(View view) {
        ImageView imageView = (ImageView) view.findViewById(R.id.default_indicator);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.btn_loading_state);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.toolbox_btn);
        TextView textView = (TextView) view.findViewById(R.id.fake_search_box_top);
        m8818B(imageView);
        m8818B(imageView2);
        m8818B(imageView3);
        Log.i("theme", ">>>color_status_bar " + f6507e);
        if (textView != null) {
            textView.setTextColor(ThemeManager.getInstance().isColorLight(f6507e) ? colorDarkGray : colorWhite);
        }
        Drawable drawableM8821u = m8821u(f6507e);
        if (drawableM8821u != null) {
            m8820D(view.findViewById(R.id.search_box_view_holder), drawableM8821u);
        }
        view.setBackgroundColor(f6507e);
    }

    public final void m8820D(View view, Drawable drawable) {
        if (view == null || drawable == null) {
            return;
        }
        view.setBackground(drawable);
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0014  */
    /* JADX WARN: Removed duplicated region for block: B:9:0x001a  */
    @Override
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public Drawable getDrawable(int r2, int r3) {
        /*
            r1 = this;
            android.graphics.drawable.Drawable r2 = r1.m8823x(r2)
            if (r2 == 0) goto L2d
            if (r3 != 0) goto L1d
            s3 r3 = p000.ThemeManager.m9472y()
            int r0 = r1.f6507e
            boolean r3 = r3.m9473A(r0)
            if (r3 == 0) goto L1a
        L14:
            int r3 = r1.f6516n
        L16:
            r1.m8824y(r2, r3)
            goto L2d
        L1a:
            int r3 = r1.f6515m
            goto L16
        L1d:
            r0 = 1
            if (r3 != r0) goto L2d
            s3 r3 = p000.ThemeManager.m9472y()
            int r0 = r1.f6526x
            boolean r3 = r3.m9473A(r0)
            if (r3 == 0) goto L1a
            goto L14
        L2d:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: p000.AbstractC2128o.mo1382a(int, int):android.graphics.drawable.Drawable");
    }

    @Override
    public void setLayoutView(View view) {
        ImageView imageView;
        Drawable drawable;
        int i;
        int i2;
        ImageView imageView2;
        Drawable drawableMo7302o;
        TextView textView;
        View view2;
        int i3;
        int i4;
        Drawable drawable2;
        int i5;
        int id = view.getId();
        if (id == R.id.main_root) {
            return;
        }
        if (id != R.id.back_indicator && id != R.id.forward_indicator) {
            if (id == R.id.top_content || id == R.id.top_toolbar_container) {
                m8819C(view);
                return;
            }
            if (id == R.id.search_bar_bottom) {
                m8825z(view, false);
                return;
            }
            if (id == R.id.search_bar_top) {
                m8825z(view, true);
                return;
            }
            if (id == R.id.sug_keywords_container) {
                drawableMo7302o = mo7308w();
            } else if (id == R.id.sug_hot_words_container) {
                TextView textView2 = (TextView) view.findViewById(R.id.title_hot_words);
                if (textView2 != null) {
                    textView2.setTextColor(f6524v);
                }
                ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_next_hot_words);
                if (imageView3 == null) {
                    return;
                }
                drawable = imageView3.getDrawable();
                i = f6524v;
            } else if (id == R.id.sug_search_his_container) {
                TextView textView3 = (TextView) view.findViewById(R.id.title_search_his);
                if (textView3 != null) {
                    textView3.setTextColor(f6524v);
                }
                ImageView imageView4 = (ImageView) view.findViewById(R.id.btn_clean_search_his);
                if (imageView4 != null) {
                    drawable2 = imageView4.getDrawable();
                    i5 = f6524v;
                    m8824y(drawable2, i5);
                }
                drawableMo7302o = mo7308w();
            } else {
                if (id == R.id.suggest_item_current_url_view) {
                    TextView textView4 = (TextView) view.findViewById(R.id.sug_item_title);
                    if (textView4 != null) {
                        textView4.setTextColor(f6522t);
                    }
                    TextView textView5 = (TextView) view.findViewById(R.id.sug_item_data);
                    if (textView5 != null) {
                        textView5.setTextColor(f6523u);
                    }
                    ImageView imageView5 = (ImageView) view.findViewById(R.id.copy_url);
                    ImageView imageView6 = (ImageView) view.findViewById(R.id.site_setting);
                    if (imageView5 != null) {
                        m8824y(imageView5.getDrawable(), f6491E);
                    }
                    if (imageView6 != null) {
                        drawable2 = imageView6.getDrawable();
                        i5 = f6491E;
                        m8824y(drawable2, i5);
                    }
                } else {
                    if (id != R.id.suggest_item_view) {
                        if (id == R.id.hot_word_item_view) {
                            textView = (TextView) view;
                            m8820D(textView, mo7303p());
                            i4 = f6525w;
                        } else {
                            if (id == R.id.message_box_view) {
                                View viewFindViewById = view.findViewById(R.id.message_bar);
                                if (viewFindViewById != null) {
                                    m8820D(viewFindViewById, mo7306s());
                                }
                                textView = (TextView) view.findViewById(R.id.message);
                                if (textView == null) {
                                    return;
                                }
                            } else {
                                if (id == R.id.mark_ad_toolbar) {
                                    m8820D(view, mo7308w());
                                    ImageView imageView7 = (ImageButton) view.findViewById(R.id.toolbar_btn_expand);
                                    ImageView imageView8 = (ImageButton) view.findViewById(R.id.toolbar_btn_reduce);
                                    ImageView imageView9 = (ImageButton) view.findViewById(R.id.toolbar_btn_save);
                                    ImageView imageView10 = (ImageButton) view.findViewById(R.id.toolbar_btn_exit);
                                    if (imageView7 != null) {
                                        mo1389h(imageView7);
                                    }
                                    if (imageView8 != null) {
                                        mo1389h(imageView8);
                                    }
                                    if (imageView9 != null) {
                                        mo1389h(imageView9);
                                    }
                                    if (imageView10 != null) {
                                        mo1389h(imageView10);
                                        return;
                                    }
                                    return;
                                }
                                if (id == R.id.adjust_order_toolbar) {
                                    m8820D(view, mo7308w());
                                    textView = (Button) view.findViewById(R.id.toolbar_btn_ok);
                                    if (textView == null) {
                                        return;
                                    }
                                } else {
                                    if (id == R.id.toolbar_mixed_container || id == R.id.toolbar_container) {
                                        m8817A(view);
                                        return;
                                    }
                                    if (id != R.id.main_menu_container) {
                                        if (id == R.id.main_menu_item) {
                                            m8820D(view, m8822v(f6526x));
                                            TextView textView6 = (TextView) view.findViewById(R.id.menu_item_title);
                                            Drawable drawable3 = ((ImageView) view.findViewById(R.id.menu_item_icon)).getDrawable();
                                            InterfaceC0529Ld interfaceC0529Ld = (InterfaceC0529Ld) view.getTag();
                                            if (interfaceC0529Ld == null || !interfaceC0529Ld.mo2682u()) {
                                                textView6.setTextColor(f6527y);
                                                if (interfaceC0529Ld == null || interfaceC0529Ld.mo2681t()) {
                                                    return;
                                                } else {
                                                    i3 = f6527y;
                                                }
                                            } else {
                                                textView6.setTextColor(f6486Q);
                                                i3 = f6486Q;
                                            }
                                            m8824y(drawable3, i3);
                                            return;
                                        }
                                        if (id == R.id.ply_setting_container) {
                                            m8820D(view, mo7308w());
                                            TextView textView7 = (TextView) view.findViewById(R.id.ply_setting_title);
                                            textView7.setTextColor(f6527y);
                                            i2 = f6526x;
                                            view2 = textView7;
                                        } else if (id == R.id.player_setting_item) {
                                            m8820D(view, m8822v(f6526x));
                                            ((TextView) view.findViewById(R.id.menu_item_title)).setTextColor(f6527y);
                                            textView = (TextView) view.findViewById(R.id.check_flag);
                                        } else {
                                            if (id != R.id.context_menu_container) {
                                                if (id == R.id.context_menu_item) {
                                                    InterfaceC0529Ld interfaceC0529Ld2 = (InterfaceC0529Ld) view.getTag();
                                                    m8820D(view, m8822v(f6526x));
                                                    ((TextView) view.findViewById(R.id.menu_item_title)).setTextColor(f6527y);
                                                    imageView2 = (ImageView) view.findViewById(R.id.menu_item_icon);
                                                    if (interfaceC0529Ld2 == null || interfaceC0529Ld2.mo2681t()) {
                                                        return;
                                                    }
                                                } else if (id != R.id.pop_menu_container) {
                                                    if (id == R.id.pop_menu_item) {
                                                        InterfaceC0529Ld interfaceC0529Ld3 = (InterfaceC0529Ld) view.getTag();
                                                        m8820D(view, m8822v(f6526x));
                                                        TextView textView8 = (TextView) view.findViewById(R.id.menu_item_title);
                                                        textView8.setTextColor(f6527y);
                                                        drawable = ((ImageView) view.findViewById(R.id.menu_item_icon)).getDrawable();
                                                        if (interfaceC0529Ld3 == null || !interfaceC0529Ld3.mo2682u()) {
                                                            textView8.setTextColor(f6527y);
                                                            if (interfaceC0529Ld3 == null || interfaceC0529Ld3.mo2681t()) {
                                                                return;
                                                            }
                                                            i = f6527y;
                                                        } else {
                                                            textView8.setTextColor(f6486Q);
                                                            i = f6486Q;
                                                        }
                                                    } else {
                                                        if (id == R.id.muti_window_container) {
                                                            m8820D(view, mo7304q());
                                                            ImageButton imageButton = (ImageButton) view.findViewById(R.id.btn_clean_all_tab);
                                                            if (imageButton != null) {
                                                                m8824y(imageButton.getDrawable(), f6527y);
                                                            }
                                                            ImageButton imageButton2 = (ImageButton) view.findViewById(R.id.btn_new_window);
                                                            if (imageButton2 != null) {
                                                                m8824y(imageButton2.getDrawable(), f6527y);
                                                            }
                                                            ImageButton imageButton3 = (ImageButton) view.findViewById(R.id.btn_crete_incognito_tab);
                                                            if (imageButton != null) {
                                                                m8824y(imageButton3.getDrawable(), f6527y);
                                                            }
                                                            view.setAlpha(1.0f);
                                                            return;
                                                        }
                                                        if (id == R.id.muti_window_item_container) {
                                                            TextView textView9 = (TextView) view.findViewById(R.id.menu_item_title);
                                                            if (textView9 != null) {
                                                                textView9.setTextColor(f6527y);
                                                            }
                                                            m8820D(view.findViewById(R.id.muti_window_item), mo7307t());
                                                            imageView2 = (ImageView) view.findViewById(R.id.btn_close_or_lock);
                                                            if (imageView2 == null) {
                                                                return;
                                                            }
                                                        } else {
                                                            if (id == 4663) {
                                                                ((WebView) view).setBackgroundColor(f6528z);
                                                                return;
                                                            }
                                                            if (id == 4672) {
                                                                drawable = ((ImageView) view.findViewById(R.id.msg_icon)).getDrawable();
                                                                i = f6494H;
                                                            } else if (id == 4664) {
                                                                view.setVisibility(View.VISIBLE);
                                                                i2 = f6507e;
                                                                view2 = view;
                                                            } else if (id == R.id.message_box_view) {
                                                                View viewFindViewById2 = view.findViewById(R.id.message_bar);
                                                                viewFindViewById2.setBackgroundResource(R.drawable.message_box_bg_light);
                                                                m8820D(viewFindViewById2, mo7306s());
                                                                drawable = ((ImageView) view.findViewById(R.id.msg_icon)).getDrawable();
                                                                i = f6494H;
                                                            } else {
                                                                if (id == R.id.find_in_page_box) {
                                                                    view.setBackgroundColor(f6526x);
                                                                    ImageButton imageButton4 = (ImageButton) view.findViewById(R.id.find_back_btn);
                                                                    ImageButton imageButton5 = (ImageButton) view.findViewById(R.id.find_next_btn);
                                                                    ImageButton imageButton6 = (ImageButton) view.findViewById(R.id.find_close_btn);
                                                                    m8824y(imageButton4.getDrawable(), f6527y);
                                                                    m8824y(imageButton5.getDrawable(), f6527y);
                                                                    m8824y(imageButton6.getDrawable(), f6527y);
                                                                    m8820D(imageButton4, m8822v(f6526x));
                                                                    m8820D(imageButton6, m8822v(f6526x));
                                                                    m8820D(imageButton5, m8822v(f6526x));
                                                                    return;
                                                                }
                                                                if (id == R.id.float_control_box) {
                                                                    m8820D(view, mo7308w());
                                                                    m8824y(((ImageButton) view.findViewById(R.id.btn_play_or_pause)).getDrawable(), f6491E);
                                                                    m8824y(((ImageButton) view.findViewById(R.id.btn_plyr_setting)).getDrawable(), f6491E);
                                                                    m8824y(((ImageButton) view.findViewById(R.id.btn_down)).getDrawable(), f6491E);
                                                                    m8824y(((ImageButton) view.findViewById(R.id.btn_cast)).getDrawable(), f6491E);
                                                                    imageView = (ImageButton) view.findViewById(R.id.btn_copy_link);
                                                                } else {
                                                                    if (id != R.id.tts_float_control_box) {
                                                                        return;
                                                                    }
                                                                    m8824y(((ImageView) view.findViewById(R.id.btn_play_or_pause)).getDrawable(), f6491E);
                                                                    imageView = (ImageView) view.findViewById(R.id.close_tts_btn);
                                                                }
                                                                drawable = imageView.getDrawable();
                                                                i = f6491E;
                                                            }
                                                        }
                                                    }
                                                }
                                            }
                                            drawableMo7302o = mo7302o();
                                        }
                                        view2.setBackgroundColor(i2);
                                        return;
                                    }
                                    m8820D(view, mo7304q());
                                    TextView textView10 = (TextView) view.findViewById(R.id.user_center_title);
                                    if (textView10 != null) {
                                        textView10.setTextColor(f6527y);
                                    }
                                    View viewFindViewById3 = view.findViewById(R.id.menu_bottom_bar);
                                    ImageView imageView11 = (ImageView) view.findViewById(R.id.menu_bottom_setting);
                                    ImageView imageView12 = (ImageView) view.findViewById(R.id.menu_bottom_close_menu);
                                    imageView2 = (ImageView) view.findViewById(R.id.menu_bottom_exit);
                                    if (viewFindViewById3 == null) {
                                        return;
                                    }
                                    m8820D(viewFindViewById3, mo7305r());
                                    m8824y(imageView11.getDrawable(), f6527y);
                                    m8824y(imageView12.getDrawable(), f6527y);
                                    drawable = imageView2.getDrawable();
                                    i = f6527y;
                                }
                            }
                            i4 = f6527y;
                        }
                        textView.setTextColor(i4);
                        return;
                    }
                    TextView textView11 = (TextView) view.findViewById(R.id.sug_item_title);
                    if (textView11 != null) {
                        textView11.setTextColor(f6522t);
                    }
                    TextView textView12 = (TextView) view.findViewById(R.id.sug_item_data);
                    if (textView12 != null) {
                        textView12.setTextColor(f6523u);
                    }
                }
                drawableMo7302o = mo7308w();
            }
            m8820D(view, drawableMo7302o);
            return;
        }
        drawable = ((ImageView) view).getDrawable();
        i = f6489C;
        m8824y(drawable, i);
    }

    @Override
    public void mo1385d(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        if (drawable != null) {
            m8824y(drawable, ThemeManager.getInstance().isColorLight(mo1388g()) ? f6491E : f6490D);
        }
    }

    @Override
    public void updateBackgroundColor(int color) {
        backgroundColor = color;
        Window window = browserActivity.getWindow();
        View decorView = window.getDecorView();
        if (Build.VERSION.SDK_INT >= 35 && browserActivity.getApplication().getApplicationInfo().targetSdkVersion >= 35) {
            SystemUiController systemUiController = SystemUiCompat.create(window, decorView);
            systemUiController.showInsets(C1045Wo.m.getType());
            systemUiController.setLightNavigationBar(ThemeManager.getInstance().isColorLight(color));
        } else {
            window.setNavigationBarColor(color);
            browserActivity.findViewById(R.id.bottom_content).setBackgroundColor(color);
            if (ThemeManager.getInstance().isColorLight(color))
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() | 16);
            else
                decorView.setSystemUiVisibility(decorView.getSystemUiVisibility() & (-17));
        }
    }

    @Override
    public void mo1387f(int[] iArr) {
        View viewFindViewById;
        mo1391j(iArr[0]);
        updateBackgroundColor(iArr[1]);
        View viewTopContent = browserActivity.findViewById(R.id.top_content);
        if (viewTopContent != null) {
            setLayoutView(viewTopContent);
        }
        if (Build.VERSION.SDK_INT >= 35 && SharedPreferencesHelper.getInstance().defaultLayoutType == 4098 && (viewFindViewById = browserActivity.findViewById(R.id.main_content)) != null) {
            viewFindViewById.setBackgroundColor(iArr[0]);
        }
        View viewToolbarContainer = browserActivity.findViewById(R.id.toolbar_container);
        if (viewToolbarContainer != null) {
            setLayoutView(viewToolbarContainer);
        }
        View viewToolbarMixedContainer = browserActivity.findViewById(R.id.toolbar_mixed_container);
        if (viewToolbarMixedContainer != null) {
            setLayoutView(viewToolbarMixedContainer);
        }
    }

    @Override
    public void mo1389h(ImageView imageView) {
        Drawable drawable = imageView.getDrawable();
        drawable.clearColorFilter();
        m8824y(drawable, imageView.isEnabled() ? ThemeManager.getInstance().isColorLight(backgroundColor) ? f6491E : f6490D : f6492F);
    }

    @Override
    public boolean mo1390i() {
        return f6500N;
    }

    @Override
    public void mo1391j(int i) {
        if (SharedPreferencesHelper.getInstance().browserFullscreenMode) {
            return;
        }
        f6507e = i;
        int i2 = Build.VERSION.SDK_INT;
        View decorView = browserActivity.getWindow().getDecorView();
        if (i2 < 35) {
            browserActivity.getWindow().setStatusBarColor(i);
            decorView.setSystemUiVisibility(ThemeManager.getInstance().isColorLight(i) ? decorView.getSystemUiVisibility() | 8192 : decorView.getSystemUiVisibility() & (-8193));
            return;
        }
        Window window = browserActivity.getWindow();
        SystemUiController systemUiControllerM4436A = SystemUiCompat.create(window, window.getDecorView());
        if (systemUiControllerM4436A != null) {
            systemUiControllerM4436A.showInsets(C1045Wo.m.getType());
            systemUiControllerM4436A.setLightStatusBar(ThemeManager.getInstance().isColorLight(i));
        }
    }

    public Drawable mo7302o() {
        return m8823x(R.drawable.default_context_menu_bg);
    }

    public Drawable mo7303p() {
        return m8823x(R.drawable.default_sugguest_hotwrod_bg);
    }

    public Drawable mo7304q() {
        return m8823x(R.drawable.main_menu_bg);
    }

    public Drawable mo7305r() {
        return m8823x(R.drawable.default_tool_bar_bg);
    }

    public Drawable mo7306s() {
        return m8823x(R.drawable.message_box_bg_light);
    }

    @Override
    public void start() {
        mo1391j(mo1388g());
        updateBackgroundColor(mo1384c());
    }

    public Drawable mo7307t() {
        return m8823x(R.drawable.default_muti_window_item_bg);
    }

    public Drawable m8821u(int i) {
        GradientDrawable gradientDrawable = (GradientDrawable) m8823x(R.drawable.light_search_box_input_bg);
        gradientDrawable.setColor(ThemeManager.getInstance().isColorLight(i) ? -986896 : AndroidSystemUtils.m8715w(i));
        return gradientDrawable;
    }

    public Drawable m8822v(int i) {
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{android.R.attr.state_pressed, android.R.attr.state_pressed}, new ColorDrawable(m8816n(i, 30)));
        return stateListDrawable;
    }

    public Drawable mo7308w() {
        return m8823x(R.drawable.default_tool_bar_bg);
    }

    public Drawable m8823x(int i) {
        return browserActivity.getDrawable(i);
    }

    public void m8824y(Drawable drawable, int i) {
        if (drawable != null) {
            drawable.clearColorFilter();
            drawable.setColorFilter(m8815m(i));
        }
    }

    public final void m8825z(View view, boolean z) {
        ImageView imageView = (ImageView) view.findViewById(R.id.ic_site);
        ImageView imageView2 = (ImageView) view.findViewById(R.id.search_action_btn);
        ImageView imageView3 = (ImageView) view.findViewById(R.id.btn_clean);
        SuggestionInputView suggestionInputView = (SuggestionInputView) view.findViewById(R.id.search_box);
        if (imageView != null) {
            mo1385d(imageView);
        }
        if (imageView2 != null) {
            mo1385d(imageView2);
        }
        if (imageView3 != null) {
            mo1385d(imageView3);
        }
        Log.i("theme", ">>>color_status_bar " + f6507e);
        if (suggestionInputView != null) {
            suggestionInputView.setTextColor(ThemeManager.getInstance().isColorLight(mo1388g()) ? colorDarkGray : colorWhite);
        }
        int iMo1388g = z ? mo1388g() : mo1384c();
        Drawable drawableM8821u = m8821u(iMo1388g);
        if (drawableM8821u != null) {
            m8820D(view.findViewById(R.id.search_box_view_holder), drawableM8821u);
        }
        view.setBackgroundColor(iMo1388g);
    }
}
