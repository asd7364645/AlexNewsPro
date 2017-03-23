package com.newspro.alexnewspro.event.news;

/**
 * Created by Alex on 2017/1/4.
 * Alex
 * 正在加载新闻列表数据时的事件
 */

public class NewsLoadingEvent {

    boolean isLoading ;

    public NewsLoadingEvent(boolean isLoading) {
        this.isLoading = isLoading;
    }

    public boolean isLoading() {
        return isLoading;
    }
}
