package club.mastershu.festec.example;

import android.app.Application;

import com.facebook.stetho.Stetho;
import com.joanzapata.iconify.fonts.FontAwesomeModule;

import club.mastershu.latte.app.Latte;
import club.mastershu.latte.ec.database.DatabaseManager;
import club.mastershu.latte.ec.icon.FontEcModule;
import club.mastershu.latte.net.interceptors.DebugInterceptor;

/**
 * Created by Administrator on 2018/1/1.
 */

public class ExampleApp extends Application {

    @Override
    public void onCreate () {
        super.onCreate();
        Latte.init(this)
                .withApiHost("http://127.0.0.1/")
                .withInterceptor(new DebugInterceptor("index", R.raw.test))
                .withIcon(new FontAwesomeModule())
                .withIcon(new FontEcModule())   // 引入自定义字体module
                .configure();
        initStetho();
        DatabaseManager.getInstance().init(this);
    }


    private void initStetho() {
        Stetho.initialize(
                Stetho.newInitializerBuilder(this)
                        .enableDumpapp(Stetho.defaultDumperPluginsProvider(this))
                        .enableWebKitInspector(Stetho.defaultInspectorModulesProvider(this))
                        .build());
    }
}
