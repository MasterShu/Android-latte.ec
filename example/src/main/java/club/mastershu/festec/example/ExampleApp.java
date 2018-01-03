package club.mastershu.festec.example;

import android.app.Application;

import com.joanzapata.iconify.fonts.FontAwesomeModule;

import club.mastershu.latte.app.Latte;
import club.mastershu.latte.ec.icon.FontEcModule;

/**
 * Created by Administrator on 2018/1/1.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate () {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())   // 引入自定义字体module
                .configure();
    }
}
