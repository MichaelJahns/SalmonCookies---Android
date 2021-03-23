package com.leyline.salmoncookies.util;

import android.content.Context;
import android.graphics.Typeface;
import android.widget.TextView;

public class TypefaceProvider {
    private static Typeface jimNightshade;
    private static Typeface cinzelDecorative;

    public final void setJimNightshade(Context context, TextView tv){
        if (jimNightshade == null) {
            jimNightshade = Typeface.createFromAsset(context.getAssets(), "fonts/JimNightshade-Regular.ttf");
        }
        tv.setTypeface(jimNightshade);
    }
    public final void setCinzelDecorative(Context context, TextView tv){
        if (cinzelDecorative == null) {
            cinzelDecorative = Typeface.createFromAsset(context.getAssets(), "fonts/CinzelDecorative-Regular.ttf");
        }

        tv.setTypeface(cinzelDecorative);
    }
    public static final TypefaceProvider INSTANCE = new TypefaceProvider();

}
