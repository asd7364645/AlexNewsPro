package com.newspro.alexnewspro.model;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.utils.BmobUtils;
import com.newspro.alexnewspro.utils.common_util.StringUtils;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;

import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_AND_PWD_OK;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.GREATER_THAN_16;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_CHINESE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_HALF;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_NO_EQUALLY;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class UserModel extends MvpModel {

    /**
     * 判断登录的时候账号密码的正确性
     *
     * @param acc
     * @param pwd
     * @return
     */
    public int judgeAccAndPwd(String acc, String pwd) {
        //账号是否为空
        if (acc.isEmpty()) {
            return ACC_IS_EMPTY;
        }
        //密码是否为空
        if (pwd.isEmpty()) {
            return PWD_IS_EMPTY;
        }
        //账号或密码长度是否大于16位
        if (StringUtils.uniLength(acc) > 16 || StringUtils.uniLength(pwd) > 16) {
            return GREATER_THAN_16;
        }
        //账号或密码是否存在中文
        if (StringUtils.hasChineseString(acc) || StringUtils.hasChineseString(pwd)) {
            return IS_HAS_CHINESE;
        }
        //账号或密码是否存在全角字符
        if (!StringUtils.isHalfChar(acc) || !StringUtils.isHalfChar(pwd)) {
            return IS_HAS_HALF;
        }

        return ACC_AND_PWD_OK;

    }

    /**
     * 判断注册的时候账号和密码的正确性
     *
     * @param acc
     * @param pwd
     * @param rePwd
     * @return
     */
    public int registerJudgeAccAndPwd(String acc, String pwd, String rePwd) {
        int apResult = judgeAccAndPwd(acc, pwd);
        if (apResult == ACC_AND_PWD_OK) {
            if (rePwd.equals(pwd)) {
                return ACC_AND_PWD_OK;
            } else {
                return PWD_NO_EQUALLY;
            }
        } else {
            return apResult;
        }
    }

    /**
     * 登录
     *
     * @param acc
     * @param pwd
     * @param success
     * @param error
     */
    public void userLogin(String acc, String pwd, final MvpModelCallBack<Void> success, final MvpModelCallBack<Integer> error) {
        BmobUtils.UserUtils.login(acc, pwd, new LogInListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
                    BmobUtils.UserUtils.setmBmobUser(bmobUser);
                    success.result(null);
                } else {
                    error.result(e.getErrorCode());
                }

            }
        });
    }

    public void userRegister(String acc, String pwd, final MvpModelCallBack<BmobUser> success, final MvpModelCallBack<Integer> error) {

        BmobUtils.UserUtils.register(acc, pwd, new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
                    success.result(bmobUser);
                } else {
                    error.result(e.getErrorCode());
                }
            }
        });

    }

}
