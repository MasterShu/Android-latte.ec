package club.mastershu.latte.net.interceptors;

import android.support.annotation.RawRes;

import java.io.IOException;

import club.mastershu.latte.util.file.FileUtil;
import okhttp3.MediaType;
import okhttp3.Protocol;
import okhttp3.Response;
import okhttp3.ResponseBody;

/**
 * Created by Administrator on 2018/1/18.
 */

public class DebugInterceptor extends BaseInterceptor {


    private final String DEBUG_URL;
    private final int DEBUG_RAW_ID;

    public DebugInterceptor(String debugUrl, int rawId) {
        DEBUG_URL = debugUrl;
        DEBUG_RAW_ID = rawId;
    }

    private Response getResopnse(Chain chain, String json) {
        return new Response.Builder()
                .code(200)
                .addHeader("Content-Type", "application/json")
                .body(ResponseBody.create(MediaType.parse("application/json"), json))
                .message("OK")
                .request(chain.request())
                .protocol(Protocol.HTTP_1_1)
                .build();
    }

    private Response debugResponse(Chain chain, @RawRes int rawId) {
        final String json = FileUtil.getRawFile(rawId);
        return getResopnse(chain, json);
    }

    @Override
    public Response intercept(Chain chain) throws IOException{
        final String url = chain.request().url().toString();
        if (url.contains(DEBUG_URL)) {
            return debugResponse(chain, DEBUG_RAW_ID);
        }
        return chain.proceed(chain.request());
    }
}
