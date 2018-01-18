package club.mastershu.latte.net.rx;

import android.content.Context;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import club.mastershu.latte.net.RestClient;
import club.mastershu.latte.net.RestCreator;
import club.mastershu.latte.net.callback.IError;
import club.mastershu.latte.net.callback.IFailure;
import club.mastershu.latte.net.callback.IRequest;
import club.mastershu.latte.net.callback.ISuccess;
import club.mastershu.latte.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/1/7.
 */

public class RxRestClientBuilder {

    private String mUrl = null;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private RequestBody mBody = null;
    private Context mContext = null;
    private LoaderStyle mLoaderStyle = null;
    private File mFile = null;

    RxRestClientBuilder(){};

    public final RxRestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }
    public final RxRestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }
    public final RxRestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }
    public final RxRestClientBuilder file(File file) {
        this.mFile = file;
        return this;
    }
    public final RxRestClientBuilder file(String file) {
        this.mFile = new File(file);
        return this;
    }
    public final RxRestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }

    public final RxRestClientBuilder loader(Context context, LoaderStyle style) {
        this.mContext = context;
        this.mLoaderStyle = style;
        return this;
    }
    public final RxRestClientBuilder loader(Context context) {
        this.mContext = context;
        this.mLoaderStyle = LoaderStyle.BallClipRotatePulseIndicator;
        return this;
    }

    public final RxRestClient build() {
        return new RxRestClient(mUrl, PARAMS, mBody, mLoaderStyle, mFile, mContext);
    }
}
