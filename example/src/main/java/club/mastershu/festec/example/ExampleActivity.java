package club.mastershu.festec.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import club.mastershu.latte.activities.ProxyActivity;
import club.mastershu.latte.app.Latte;
import club.mastershu.latte.delegates.LatteDelegate;
import club.mastershu.latte.ec.launcher.LauncherDelegate;
import club.mastershu.latte.ec.launcher.LauncherScrollDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new LauncherScrollDelegate();
    }
}
