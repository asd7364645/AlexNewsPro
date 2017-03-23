package com.newspro.alexnewspro.event.news;

/**
 * Created by Alex on 2017/1/4.
 * Alex
 * 与NewsType联系的event
 */
public class NewsActionBtnEvent {
    //判断是否刷新结束
    boolean isRefreshOver;

    public NewsActionBtnEvent(boolean isRefreshOver) {
        this.isRefreshOver = isRefreshOver;
    }

    public boolean isRefreshOver() {
        return isRefreshOver;
    }
}
