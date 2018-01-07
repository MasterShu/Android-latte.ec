package club.mastershu.festec.example;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.View;

import club.mastershu.latte.delegates.LatteDelegate;
import club.mastershu.latte.net.RestClient;
import club.mastershu.latte.net.callback.IError;
import club.mastershu.latte.net.callback.IFailure;
import club.mastershu.latte.net.callback.ISuccess;

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

    private void testRequestClient() {
        RestClient.bulider()
                .url("")
                .params("", "")
                .success(new ISuccess() {
                    @Override
                    public void onSuccess(String response) {

                    }
                })
                .error(new IError() {
                    @Override
                    public void onError(int code, String msg) {

                    }
                })
                .failure(new IFailure() {
                    @Override
                    public void onFailure() {

                    }
                })
                .build();
    }
}
