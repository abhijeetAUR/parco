package com.hexagon.parcodriver.Utils;

import android.os.Build;
import android.transition.Explode;
import android.transition.Fade;
import android.transition.Slide;
import android.transition.Transition;

import androidx.annotation.RequiresApi;

/**
 * Created by shine on 1/2/17.
 */

public class TransitionUtil {

    private static long duration = 200;

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Transition slide(int gravity) {
        Slide slideTransition = new Slide(gravity);
        slideTransition.setDuration(duration);
        return slideTransition;
    }

    @RequiresApi(api = Build.VERSION_CODES.KITKAT)
    public static Transition fade(int mode) {
        Fade fadeTransition = new Fade(mode);
        fadeTransition.setDuration(duration);
        return fadeTransition;
    }

    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public static Transition explode() {
        Explode enterTransition = new Explode();
        enterTransition.setDuration(500);
        return enterTransition;
    }

}
