package com.newspro.alexnewspro.http;

import retrofit2.Converter;
import retrofit2.Retrofit;

public class RetrofitUtil {

    private static Retrofit retrofit;

    public static Retrofit RetrofitUtil(String baseUrl, Converter.Factory factory) {
       retrofit = new Retrofit.Builder()
                .addConverterFactory(factory)
                .baseUrl(baseUrl)
                .build();
        return retrofit;
    }

    public static Retrofit getRetrofit() {
        return retrofit;
    }
}