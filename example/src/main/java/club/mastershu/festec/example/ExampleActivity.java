package club.mastershu.festec.example;

import android.support.annotation.Nullable;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import club.mastershu.latte.activities.ProxyActivity;
import club.mastershu.latte.app.Latte;
import club.mastershu.latte.delegates.LatteDelegate;
import club.mastershu.latte.ec.launcher.LauncherDelegate;
import club.mastershu.latte.ec.launcher.LauncherScrollDelegate;
import club.mastershu.latte.ec.sign.SignUpDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        final ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.hide();
        }
    }

    @Override
    public LatteDelegate setRootDelegate() {
        return new SignUpDelegate();
    }
}
