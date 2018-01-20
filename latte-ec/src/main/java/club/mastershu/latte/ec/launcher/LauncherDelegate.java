package club.mastershu.latte.ec.launcher;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.AppCompatTextView;
import android.view.View;

import butterknife.BindView;
import club.mastershu.latte.delegates.LatteDelegate;
import club.mastershu.latte.ec.R;
import club.mastershu.latte.ec.R2;

/**
 * Created by Administrator on 2018/1/20.
 */

public class LauncherDelegate extends LatteDelegate {

    @BindView(R2.id.tv_launcher_timer)
    AppCompatTextView mTvTimer = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_launcher;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }
}
