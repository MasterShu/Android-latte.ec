package club.mastershu.latte.net.rx;

import android.content.Context;
import android.database.Observable;

import java.io.File;
import java.util.Map;
import java.util.WeakHashMap;

import club.mastershu.latte.net.HttpMethod;
import club.mastershu.latte.net.RestCreator;
import club.mastershu.latte.ui.LatteLoader;
import club.mastershu.latte.ui.LoaderStyle;
import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/1/6.
 */

public class RxRestClient {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final RequestBody BODY;
    private final LoaderStyle LOADER_STYLE;
    private final File FILE;
    private final Context CONTEXT;

    public RxRestClient(String url,
                        Map<String, Object> params,
                        RequestBody body, LoaderStyle loader_style, File file, Context context) {
        URL = url;
        LOADER_STYLE = loader_style;
        FILE = file;
        CONTEXT = context;
        PARAMS.putAll(params);
        BODY = body;
    }

    public static RxRestClientBuilder bulider() {
        return new RxRestClientBuilder();
    }

    private Observable<String> request(HttpMethod method) {
        final RxRestService service = (RxRestService) RestCreator.getRxRestService();
        Observable<String> observable = null;

        if (LOADER_STYLE != null) {
            LatteLoader.showLoading(CONTEXT, LOADER_STYLE);
        }

        switch (method) {
            case GET:
                observable = service.get(URL, PARAMS);
                break;
            case POST:
                observable = service.post(URL, PARAMS);
                break;
            case POST_RAW:
                observable = service.postRow(URL, BODY);
                break;
            case PUT:
                observable = service.put(URL, PARAMS);
                break;
            case PUT_RAW:
                observable = service.putRow(URL, BODY);
                break;
            case DELETE:
                observable = service.delete(URL, PARAMS);
                break;
            case UPLOAD:
                final RequestBody requestBody =
                        RequestBody.create(MediaType.parse(MultipartBody.FORM.toString()),FILE);
                final MultipartBody.Part body =
                        MultipartBody.Part.createFormData("file", FILE.getName(), requestBody);
                observable = (Observable<String>) RestCreator.getRxRestService().upload(URL, body);
            default:
                break;
        }

        return observable;
    }

    public final Observable<String> get() {
        return request(HttpMethod.GET);
    }
    public final Observable<String> post() {
        if (BODY == null) {
            return request(HttpMethod.POST);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            return request(HttpMethod.POST_RAW);
        }

    }
    public final Observable<String> delete() {
        return request(HttpMethod.DELETE);
    }
    public final Observable<String> put() {
        if (BODY == null) {
            return request(HttpMethod.PUT);
        } else {
            if (!PARAMS.isEmpty()) {
                throw new RuntimeException("params must be null");
            }
            return request(HttpMethod.PUT_RAW);
        }
    }

    public final Observable<ResponseBody> download() {
        final Observable<ResponseBody> responseBodyObservable = (Observable<ResponseBody>) RestCreator.getRxRestService().download(URL, PARAMS);
        return responseBodyObservable;
    }
}




