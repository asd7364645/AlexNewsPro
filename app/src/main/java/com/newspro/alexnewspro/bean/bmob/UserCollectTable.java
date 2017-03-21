package com.newspro.alexnewspro.bean.bmob;

import cn.bmob.v3.BmobObject;

/**
 * Created by Alex on 2017/3/21.
 * Alex
 */

public class UserCollectTable extends BmobObject {

    private String userId;
    private String collectUrl;
    private String collectTitle;

    public UserCollectTable() {
    }

    public UserCollectTable(String userId, String collectUrl, String collectTitle) {
        this.userId = userId;
        this.collectUrl = collectUrl;
        this.collectTitle = collectTitle;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getCollectUrl() {
        return collectUrl;
    }

    public void setCollectUrl(String collectUrl) {
        this.collectUrl = collectUrl;
    }

    public String getCollectTitle() {
        return collectTitle;
    }

    public void setCollectTitle(String collectTitle) {
        this.collectTitle = collectTitle;
    }
}
