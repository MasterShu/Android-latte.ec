package club.mastershu.latte.delegates;


import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import butterknife.Unbinder;
import me.yokeyword.fragmentation_swipeback.SwipeBackFragment;

/**
 * Created by Administrator on 2018/1/5.
 */

// 这个不希望以后实例化这个类, 所以使用 abstract 抽象
public abstract class BaseDelegate extends SwipeBackFragment {

    private Unbinder mUnbinder = null;
    public abstract Object setLayout();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View rootView = null;
        if (setLayout() instanceof Integer) {
            rootView = inflater.inflate((Integer) setLayout(), container, false);
        } else if(setLayout() instanceof View) {
            rootView = (View) setLayout();
        }
        return super.onCreateView(inflater, container, savedInstanceState);
    }
}

