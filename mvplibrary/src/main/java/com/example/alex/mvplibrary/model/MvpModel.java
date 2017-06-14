package com.example.alex.mvplibrary.model;

import android.os.Handler;
import android.os.Looper;

/**
 * Created by Alex on 2017/2/15.
 * Alex
 */

public class MvpModel {

    private Handler handler = new Handler(Looper.getMainLooper());

    /**
     * 在子线程线程中切换到主线程发送消息
     *
     * @param callBacks
     * @param obj
     * @param <O>
     */
    protected <O> void sendCallback(final MvpModelCallBack<O> callBacks, final O obj) {
        if (handler == null) {
            return;
        }
        handler.post(new Runnable() {
            @Override
            public void run() {
                callBacks.result(obj);
            }
        });
    }

    /**
     * 当activity或者fragment销毁的时候可以调用
     */
    public void onDestroy() {
        handler.removeCallbacksAndMessages(null);
        handler = null;
    }

}
