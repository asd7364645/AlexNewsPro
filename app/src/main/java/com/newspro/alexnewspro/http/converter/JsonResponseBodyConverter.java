package com.newspro.alexnewspro.http.converter;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;

import okhttp3.ResponseBody;
import retrofit2.Converter;

/**
 * Created by Alex on 2016/12/29.
 * Alex
 */
final public class JsonResponseBodyConverter<T> implements Converter<ResponseBody, T> {
    JsonResponseBodyConverter() {

    }

    @Override
    public T convert(ResponseBody value) throws IOException {
        JSONObject jsonObj;
        try {
            jsonObj = new JSONObject(value.string());
            return (T) jsonObj;
        } catch(JSONException e) {
            return null;
        }
    }
}
