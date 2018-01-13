package club.mastershu.latte.net.download;

import android.os.AsyncTask;

import java.util.WeakHashMap;

import club.mastershu.latte.net.RestCreator;
import club.mastershu.latte.net.callback.IError;
import club.mastershu.latte.net.callback.IFailure;
import club.mastershu.latte.net.callback.IRequest;
import club.mastershu.latte.net.callback.ISuccess;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2018/1/13.
 */

public class DownloadHandler {
    private final String URL;
    private static final WeakHashMap<String, Object> PARAMS = RestCreator.getParams();
    private final IRequest REQUEST;
    private final ISuccess SUCCESS;
    private final IError ERROR;
    private final IFailure FAILURE;
    private final String DOWNLOAD_DIR;
    private final String EXTENSION;
    private final String NAME;

    public DownloadHandler(String url,
                           IRequest request,
                           ISuccess success,
                           IError error,
                           IFailure failure,
                           String download_dir,
                           String extension,
                           String name) {
        URL = url;
        REQUEST = request;
        SUCCESS = success;
        ERROR = error;
        FAILURE = failure;
        DOWNLOAD_DIR = download_dir;
        EXTENSION = extension;
        NAME = name;
    }

    public final void handlerDownload() {
        if (REQUEST != null) {
            REQUEST.onRequestStart();
        }

        RestCreator.getRestService().download(URL, PARAMS)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) {
                            final SaveFileTask task = new SaveFileTask(REQUEST, SUCCESS);
                            final ResponseBody responseBody = response.body();
                            task.executeOnExecutor(AsyncTask.THREAD_POOL_EXECUTOR, DOWNLOAD_DIR, EXTENSION, responseBody, NAME);

                            // 判断文件是否下载完成
                            if (task.isCancelled()) {
                                if (REQUEST != null) {
                                    REQUEST.onRequestEnd();
                                }
                            }
                        } else {
                            if (ERROR != null) {
                                ERROR.onError(response.code(), response.message());
                            }
                        }
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        if (FAILURE != null) {
                            FAILURE.onFailure();
                        }

                    }
                });
    }
}
