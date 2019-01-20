package com.example.yuekao.okhttp;

import java.io.IOException;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.FormBody;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class OkHttp3 {
    private static OkHttpClient okHttpClient;
    private static Request request;
    private static FormBody builder;

    public static void okHttpGet(String url, final GetBackGet getBackGet){
        okHttpClient = new OkHttpClient();
        request = new Request.Builder().url(url).method("GET", null).build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {

            }
            @Override
            public void onResponse(Call call, Response response) throws IOException {
                getBackGet.getTrue(response.body().string());
            }
        });
    }
    public static void okHttpPost(final String url, final String name, final String pwd, final GetBackPost getBackPost){
        okHttpClient = new OkHttpClient();
         builder = new FormBody.Builder().add("mobile", name).add("password", pwd).build();
        //创建request
        request = new Request
                .Builder()
                .url(url)
                .post(builder)
                .build();
        okHttpClient.newCall(request).enqueue(new Callback() {
            @Override
            public void onFailure(Call call, IOException e) {
                getBackPost.getTrue("出错了");
            }

            @Override
            public void onResponse(Call call, Response response) throws IOException {
                getBackPost.getTrue(response.body().string());
            }
        });
    }
    //自定义接口
    public interface GetBackGet{
        public void getTrue(String succ);
    }
    public interface GetBackPost{
        public void getTrue(String succ);
    }
}
