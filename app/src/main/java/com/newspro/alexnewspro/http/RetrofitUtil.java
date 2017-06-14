package com.newspro.alexnewspro.http;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Converter;
import retrofit2.Retrofit;

public class RetrofitUtil {

    private static Retrofit retrofit;

    private static OkHttpClient okHttpClient;

    public static Retrofit retrofitUtil(String baseUrl, Converter.Factory factory) {
        if (okHttpClient == null) {
            okHttpClient = new OkHttpClient.Builder()
                    .connectTimeout(5000, TimeUnit.MILLISECONDS)
                    // 连接超时时间设置
                    .connectTimeout(10, TimeUnit.SECONDS)
                    // 读取超时时间设置
                    .readTimeout(10, TimeUnit.SECONDS)
                    // 失败重试
                    .retryOnConnectionFailure(true)
                    .build();
        }

        retrofit = new Retrofit.Builder()
                .addConverterFactory(factory)
                .baseUrl(baseUrl).client(okHttpClient)
                .build();
        return retrofit;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}