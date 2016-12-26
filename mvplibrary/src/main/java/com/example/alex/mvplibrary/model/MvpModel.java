package com.example.alex.mvplibrary.model;

/**
 * Created by Alex on 2016/12/26.
 * Alex
 */

public class MvpModel {

    protected MvpCallback callback;

    public interface MvpCallback<T>{
        void result(T data);
    }

}
