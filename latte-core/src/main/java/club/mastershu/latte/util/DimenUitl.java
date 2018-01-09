package club.mastershu.latte.util;

import android.content.res.Resources;
import android.util.DisplayMetrics;

import club.mastershu.latte.app.Latte;

/**
 * Created by Administrator on 2018/1/9.
 * 工具类方法, 用 static 来定义, 方便调用
 */

public class DimenUitl {
    public static int getScreenWidth() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.widthPixels;
    }
    public static int getScreenHeight() {
        final Resources resources = Latte.getApplication().getResources();
        final DisplayMetrics dm = resources.getDisplayMetrics();
        return dm.heightPixels;
    }
}

