package club.mastershu.latte.ec.sign;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.TextInputEditText;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.OnClick;
import club.mastershu.latte.delegates.LatteDelegate;
import club.mastershu.latte.ec.R;
import club.mastershu.latte.ec.R2;

/**
 * Created by Administrator on 2018/2/1.
 */

public class SignInDelegate extends LatteDelegate {

    @BindView(R2.id.edit_sign_in_email)
    TextInputEditText mEmail = null;
    @BindView(R2.id.edit_sign_in_password)
    TextInputEditText mPassword = null;

    @Override
    public Object setLayout() {
        return R.layout.delegate_sign_in;
    }

    @Override
    public void onBindView(@Nullable Bundle savedInstanceState, View rootView) {

    }

    @OnClick(R2.id.btn_sign_in)
    void onClickSignIn() {
        if (checkForm()) {
//            RestClient.builder()
//                    .url("http://192.168.56.1:8080/RestDataServer/api/user_profile.php")
//                    .params("email", mEmail.getText().toString())
//                    .params("password", mPassword.getText().toString())
//                    .success(new ISuccess() {
//                        @Override
//                        public void onSuccess(String response) {
//                            LatteLogger.json("USER_PROFILE", response);
//                            SignHandler.onSignIn(response, mISignListener);
//                        }
//                    })
//                    .build()
//                    .post();
            Toast.makeText(getContext(), " pass verity ", Toast.LENGTH_SHORT).show();

        }
    }

    @OnClick(R2.id.icon_sign_in_wechat)
    void onClickWeChat() {
//        LatteWeChat
//                .getInstance()
//                .onSignSuccess(new IWeChatSignInCallback() {
//                    @Override
//                    public void onSignInSuccess(String userInfo) {
//                        Toast.makeText(getContext(), userInfo, Toast.LENGTH_LONG).show();
//                    }
//                })
//                .signIn();
    }

    @OnClick(R2.id.tv_link_sign_up)
    void onClickLink() {
        getSupportDelegate().start(new SignUpDelegate());
    }

    private boolean checkForm() {
        final String email = mEmail.getText().toString();
        final String password = mPassword.getText().toString();

        boolean isPass = true;

        if (email.isEmpty() || !Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            mEmail.setError("错误的邮箱格式");
            isPass = false;
        } else {
            mEmail.setError(null);
        }

        if (password.isEmpty() || password.length() < 6) {
            mPassword.setError("请填写至少6位数密码");
            isPass = false;
        } else {
            mPassword.setError(null);
        }

        return isPass;
    }
}
