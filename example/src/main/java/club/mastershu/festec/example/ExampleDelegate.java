package club.mastershu.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import club.mastershu.latte.delegates.LatteDelegate;

/**
 * Created by Administrator on 2018/1/6.
 */

public class ExampleDelegate extends LatteDelegate {
    @Override
    public Object setLayout() {
        return R.layout.delegate_example;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
