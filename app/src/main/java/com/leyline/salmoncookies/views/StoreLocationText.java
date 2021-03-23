package com.leyline.salmoncookies.views;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;

import androidx.annotation.Nullable;

import com.leyline.salmoncookies.util.TypefaceProvider;

public class StoreLocationText extends androidx.appcompat.widget.AppCompatTextView {
    private final TypefaceProvider typefaceProvider = new TypefaceProvider();
    public StoreLocationText(Context context) {
        super(context);
        typefaceProvider.setCinzelDecorative(context, this);
    }

    public StoreLocationText(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public StoreLocationText(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
