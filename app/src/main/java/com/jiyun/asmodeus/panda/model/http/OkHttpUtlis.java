package com.jiyun.asmodeus.panda.model.http;

import com.google.gson.Gson;
import com.jiyun.asmodeus.panda.App;

import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.Set;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttpUtlis {
    private static OkHttpUtlis okHttpUtils;
    private OkHttpClient okHttpClient;
    private OkHttpUtlis(){
        okHttpClient = new OkHttpClient.Builder().build();
    }
    public static OkHttpUtlis getInstance() {
        if (okHttpUtils == null)
            okHttpUtils = new OkHttpUtlis();
        return okHttpUtils;
    }

    public <T> void doGet(String url, final MyNetworkCallback<T> callback) {

            Request request = new Request.Builder().url(url).build();
            okHttpClient.newCall(request).enqueue(new Callback() {
                @Override
                public void onFailure(Call call, IOException e) {
                    callback.onError(e.getMessage());
                }

                @Override
                public void onResponse(final Call call, Response response) throws IOException {

                    final String result = response.body().string();
                    App.context.runOnUiThread(new Runnable() {
                        @Override
                        public void run() {
                            callback.onSuccess(parseData(result, callback));
                        }
                    });
                }
            });
    }
    private <T> T parseData(String json, MyNetworkCallback<T> call) {
        Type[] interfaces = call.getClass().getGenericInterfaces();
        Type[] arguments = ((ParameterizedType) interfaces[0]).getActualTypeArguments();
        Gson gson = new Gson();
        T t = gson.fromJson(json, arguments[0]);
        return t;
    }

}

