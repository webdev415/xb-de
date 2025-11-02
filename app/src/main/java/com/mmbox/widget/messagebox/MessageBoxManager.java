package com.mmbox.widget.messagebox;

import android.content.res.Resources;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;

import com.mmbox.xbrowser.BrowserActivity;
import com.mmbox.xbrowser.SharedPreferencesHelper;
import com.xbrowser.play.R;
import p000.PhoneUtils;

public class MessageBoxManager {

    public static MessageBoxManager instance;

    public FrameLayout containerLayout = null;

    public MessageBox messageBox = null;

    public static MessageBoxManager getInstance() {
        if (instance == null) {
            instance = new MessageBoxManager();
        }
        return instance;
    }

    public void dismiss() throws Resources.NotFoundException {
        MessageBoxBase messageBoxBase = this.messageBox;
        if (messageBoxBase != null) {
            Animation animationLoadAnimation = AnimationUtils.loadAnimation(messageBoxBase.getContext(), R.anim.message_bar_dissmiss_anim);
            MessageBoxBase messageBoxBase2 = this.messageBox;
            if (messageBoxBase2.messageStyle == 3) {
                animationLoadAnimation = AnimationUtils.loadAnimation(messageBoxBase2.getContext(), R.anim.faid_out);
            }
            this.messageBox.startAnimation(animationLoadAnimation);
            animationLoadAnimation.setAnimationListener(new Animation.AnimationListener() {
                @Override
                public void onAnimationEnd(Animation animation) {
                    new Handler().post(new Runnable() {
                        @Override
                        public void run() {
                            if (messageBox != null) {
                                messageBox.removeFromParent();
                                messageBox = null;
                            }
                        }
                    });
                }

                @Override
                public void onAnimationRepeat(Animation animation) {
                }

                @Override
                public void onAnimationStart(Animation animation) {
                }
            });
        }
    }

    public boolean isShowing() {
        if (messageBox != null) {
            return messageBox.isShowing();
        }
        return false;
    }

    public void showMessage(FrameLayout frameLayout, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, MessageBoxBase.MessageBoxListener messageBoxListener, boolean z) {
        showMessageFull(frameLayout, drawable, charSequence, charSequence2, charSequence3, messageBoxListener, z, false);
    }

    public void showMessageFull(FrameLayout frameLayout, Drawable drawable, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, MessageBoxBase.MessageBoxListener messageBoxListener, boolean z, boolean z2) {
        FrameLayout frameLayout2;
        MessageBoxBase messageBoxBase;
        if (z && (frameLayout2 = this.containerLayout) != null && (messageBoxBase = this.messageBox) != null) {
            frameLayout2.removeView(messageBoxBase);
        } else if (isShowing()) {
            return;
        }
        this.containerLayout = frameLayout;
        int i = charSequence3 != null ? 2 : 1;
        if (charSequence.length() > 15) {
            i = 4;
        }
        messageBox = new MessageBox(this.containerLayout.getContext(), i);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 85;
        if (Build.VERSION.SDK_INT >= 35 && !SharedPreferencesHelper.getInstance().browserFullscreenMode) {
            layoutParams.bottomMargin = PhoneUtils.getInstance().getNavigationBarHeight();
        }
        messageBox.setLayoutParams(layoutParams);
        messageBox.setOnActionListener(messageBoxListener);
        messageBox.showMessage(frameLayout, drawable, charSequence, charSequence2, charSequence3, z2);
    }

    public void showSimpleMessage(FrameLayout frameLayout, CharSequence charSequence, MessageBoxBase.MessageBoxListener messageBoxListener, boolean z) {
        showSimpleMessageWithAutoClose(frameLayout, charSequence, messageBoxListener, false, z);
    }

    public void showSimpleMessageWithAutoClose(FrameLayout frameLayout, CharSequence charSequence, MessageBoxBase.MessageBoxListener messageBoxListener, boolean z, boolean z2) {
        if (z) {
            new Handler().postDelayed(new Runnable() {
                @Override
                public void run() throws Resources.NotFoundException {
                    dismiss();
                }
            }, 5000L);
        }
        showMessage(frameLayout, null, charSequence, null, null, messageBoxListener, z2);
    }

    public void showToast(FrameLayout frameLayout, CharSequence charSequence, CharSequence charSequence2, MessageBoxBase.MessageBoxListener messageBoxListener) {
        if (isShowing()) {
            return;
        }
        if (containerLayout != null) {
            containerLayout.removeView(this.messageBox);
        }
        this.containerLayout = frameLayout;
        messageBox = new MessageBox(frameLayout.getContext(), 3);
        int dimension = (int) this.containerLayout.getContext().getResources().getDimension(R.dimen.messagebox_bottom_margin);
        FrameLayout.LayoutParams layoutParams = new FrameLayout.LayoutParams(-1, -2);
        layoutParams.gravity = 85;
        layoutParams.bottomMargin = dimension;
        messageBox.setLayoutParams(layoutParams);
        messageBox.setOnActionListener(messageBoxListener);
        messageBox.showMessage(frameLayout, null, charSequence, charSequence2, null, false);
        BrowserActivity.getActivity().getHandler().postDelayed(new Runnable() {
            @Override
            public void run() throws Resources.NotFoundException {
                dismiss();
                messageBoxListener.onDismissed();
            }
        }, 5000L);
    }

    public void showMessageWithDescription(FrameLayout frameLayout, CharSequence charSequence, CharSequence charSequence2, MessageBoxBase.MessageBoxListener messageBoxListener, boolean z) {
        showMessage(frameLayout, null, charSequence, charSequence2, null, messageBoxListener, z);
    }
}
