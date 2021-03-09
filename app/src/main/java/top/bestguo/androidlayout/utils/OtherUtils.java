package top.bestguo.androidlayout.utils;

import android.graphics.Point;
import android.view.Display;
import android.view.Window;
import android.view.WindowManager;

public class OtherUtils {

    public static void adjustDialog(Window window) {
        WindowManager m = window.getWindowManager();
        Display d = m.getDefaultDisplay();
        WindowManager.LayoutParams p = window.getAttributes();
        Point size = new Point();
        d.getSize(size);
        p.width = (int)(size.x * 0.55);//设置diaLog的宽度为当前手机屏幕的宽度*0.8getwindow( ).setAttributes(p);
    }

}
