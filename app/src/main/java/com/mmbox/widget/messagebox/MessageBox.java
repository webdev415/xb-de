package com.mmbox.widget.messagebox;

import android.app.Activity;
import android.content.Context;
import android.graphics.drawable.Drawable;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TextView;

import com.xbrowser.play.R;
import p000.ThemeManager;

/**
 * MessageBox - a styled popup message view with buttons, icons, and optional checkbox.
 */
public class MessageBox extends MessageBoxBase {

    private Activity parentActivity;
    private final View contentView;

    public MessageBox(Context context, int style) {
        super(context);
        this.messageStyle = style;
        this.contentView = ThemeManager.getInstance().m9489j(getContext(), style);
        removeFromParent();
    }

    /**
     * Display a message box inside the provided parent layout.
     *
     * @param parentLayout   The FrameLayout container to show the message in.
     * @param iconDrawable   Optional drawable to show as the icon (default: info icon).
     * @param messageText    Main text message.
     * @param positiveText   Text for the confirm button.
     * @param negativeText   Text for the cancel button.
     * @param showCheckbox   Whether to display the "Do not show again" checkbox.
     */
    public void showMessage(FrameLayout parentLayout,
                            Drawable iconDrawable,
                            CharSequence messageText,
                            CharSequence positiveText,
                            CharSequence negativeText,
                            boolean showCheckbox) {

        removeAllViews();
        addView(this.contentView);
        setVisibility(View.VISIBLE);

        this.parentActivity = (Activity) parentLayout.getContext();

        TextView messageTextView = contentView.findViewById(R.id.message);
        TextView positiveButton = findViewById(R.id.command_btn);
        Button negativeButton = findViewById(R.id.command_btn2);
        CheckBox doNotShowAgainCheckBox = findViewById(R.id.check_do_not_show);
        ImageView iconView = contentView.findViewById(R.id.msg_icon);
        View closeButton = contentView.findViewById(R.id.btn_close);

        // Setup positive button
        if (positiveButton != null) {
            if (!TextUtils.isEmpty(positiveText)) {
                positiveButton.setVisibility(View.VISIBLE);
                positiveButton.setEnabled(true);
                positiveButton.setText(positiveText);
                positiveButton.setOnClickListener(v -> {
                    if (listener != null) {
                        listener.onShown();
                    }
                    v.setEnabled(false);
                    removeFromParent();
                });
            } else {
                positiveButton.setVisibility(View.GONE);
            }
        }

        // Setup checkbox
        if (showCheckbox && doNotShowAgainCheckBox != null) {
            doNotShowAgainCheckBox.setVisibility(View.VISIBLE);
        }

        // Setup negative button
        if (negativeButton != null) {
            if (!TextUtils.isEmpty(negativeText)) {
                negativeButton.setText(negativeText);
                negativeButton.setVisibility(View.VISIBLE);
                negativeButton.setOnClickListener(v -> {
                    if (listener != null) {
                        listener.onDismissed();
                    }
                    removeFromParent();
                });
            } else {
                negativeButton.setVisibility(View.INVISIBLE);
            }
        }

        // Setup close button
        if (closeButton != null) {
            closeButton.setOnClickListener(v -> {
                if (listener != null) {
                    listener.onDismissed();
                }
                removeFromParent();
            });
        }

        // Setup icon
        if (iconView != null) {
            if (iconDrawable != null) {
                iconView.setImageDrawable(iconDrawable);
            } else {
                iconView.setImageResource(R.drawable.ic_info_outline);
            }
        }

        // Setup message text
        if (!TextUtils.isEmpty(messageText)) {
            messageTextView.setText(messageText);
        }

        // Show message box inside the layout
        show(parentLayout);
    }
}
