package com.newspro.alexnewspro.event.user;

/**
 * Created by Alex on 2017/3/23.
 * Alex
 */

public class UserIsLoginEvent {

    private boolean isLogin;

    public UserIsLoginEvent(boolean isLogin) {
        this.isLogin = isLogin;
    }

    public boolean isLogin() {
        return isLogin;
    }

    public void setLogin(boolean login) {
        isLogin = login;
    }
}
