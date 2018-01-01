package club.mastershu.festec.example;

import android.app.Application;

import club.mastershu.latte.app.Latte;

/**
 * Created by Administrator on 2018/1/1.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate () {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .configure();
    }
}
