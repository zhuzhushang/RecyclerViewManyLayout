package com.uyac.recyclerviewmanylayout;

import android.content.Context;
import android.util.DisplayMetrics;
import android.view.WindowManager;

/**
 * Created by ShaoQuanwei on 2017/2/8.
 */

public class ScreenUtils {

    public static int[] getScreenWH(Context context)
    {

        WindowManager wm = (WindowManager) context.getSystemService(Context.WINDOW_SERVICE);
        DisplayMetrics dm = new DisplayMetrics();
        wm.getDefaultDisplay().getMetrics(dm);
        return new int[]{dm.widthPixels,dm.heightPixels};
    }

}
