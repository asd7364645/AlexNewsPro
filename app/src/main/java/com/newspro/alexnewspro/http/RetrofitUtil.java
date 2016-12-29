package com.newspro.alexnewspro.http;

import com.newspro.alexnewspro.http.converter.JsonConverterFactory;

import retrofit2.Retrofit;

public class RetrofitUtil {

    public static Retrofit RetrofitUtil(String baseUrl) {
       Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(JsonConverterFactory.create())
                .baseUrl(baseUrl)
                .build();
        return retrofit;
    }

}