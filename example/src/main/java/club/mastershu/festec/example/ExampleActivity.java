package club.mastershu.festec.example;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import club.mastershu.latte.activities.ProxyActivity;
import club.mastershu.latte.app.Latte;
import club.mastershu.latte.delegates.LatteDelegate;

public class ExampleActivity extends ProxyActivity {

    @Override
    public LatteDelegate setRootDelegate() {
        return new ExampleDelegate();
    }
}
