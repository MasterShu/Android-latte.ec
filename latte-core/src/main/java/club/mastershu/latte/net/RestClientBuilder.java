package club.mastershu.latte.net;

import java.util.Map;
import java.util.WeakHashMap;

import club.mastershu.latte.net.callback.IError;
import club.mastershu.latte.net.callback.IFailure;
import club.mastershu.latte.net.callback.IRequest;
import club.mastershu.latte.net.callback.ISuccess;
import okhttp3.MediaType;
import okhttp3.RequestBody;

/**
 * Created by Administrator on 2018/1/7.
 */

public class RestClientBuilder {

    private String mUrl;
    private static final Map<String, Object> PARAMS = RestCreator.getParams();
    private IRequest mRequest;
    private ISuccess mSuccess;
    private IError mError;
    private IFailure mFailure;
    private RequestBody mBody;

    RestClientBuilder(){};

    public final RestClientBuilder url(String url) {
        this.mUrl = url;
        return this;
    }
    public final RestClientBuilder params(WeakHashMap<String, Object> params) {
        PARAMS.putAll(params);
        return this;
    }
    public final RestClientBuilder params(String key, Object value) {
        PARAMS.put(key, value);
        return this;
    }
    public final RestClientBuilder raw(String raw) {
        this.mBody = RequestBody.create(MediaType.parse("application/json;charset=UTF-8"), raw);
        return this;
    }
    public final RestClientBuilder onRequest(IRequest iRequest) {
        this.mRequest = iRequest;
        return this;
    }
    public final RestClientBuilder success(ISuccess iSuccess) {
        this.mSuccess= iSuccess;
        return this;
    }
    public final RestClientBuilder failure(IFailure iFailure) {
        this.mFailure= iFailure;
        return this;
    }
    public final RestClientBuilder error(IError iError) {
        this.mError= iError;
        return this;
    }

    public final RestClient build() {
        return new RestClient(mUrl, PARAMS, mRequest, mSuccess, mError, mFailure, mBody);
    }
}
