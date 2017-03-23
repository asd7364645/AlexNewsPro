package com.newspro.alexnewspro.model;

import android.os.CountDownTimer;

import com.example.alex.mvplibrary.model.MvpModel;
import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.newspro.alexnewspro.event.user.UserIsLoginEvent;
import com.newspro.alexnewspro.utils.BmobUtils;
import com.newspro.alexnewspro.utils.common_util.StringUtils;
import com.newspro.alexnewspro.utils.common_util.ZhengZeUtil;

import org.greenrobot.eventbus.EventBus;

import java.util.List;

import cn.bmob.v3.BmobUser;
import cn.bmob.v3.exception.BmobException;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;

import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_AND_PWD_OK;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.AUTH_CODE_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.GREATER_THAN_16;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_CHINESE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_HALF;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.NOT_PHONE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PHONE_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_NO_EQUALLY;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class UserModel extends MvpModel {

    private static MyCountDown myCountDown;

    public static class MyCountDown extends CountDownTimer {

        private MvpModelCallBack<String> ticking, finish;

        public MyCountDown(long millisInFuture, long countDownInterval, MvpModelCallBack<String> ticking, MvpModelCallBack<String> finish) {
            super(millisInFuture, countDownInterval);
            this.ticking = ticking;
            this.finish = finish;
        }

        @Override
        public void onTick(long millisUntilFinished) {
            ticking.result((millisUntilFinished / 1000) + "");
        }

        @Override
        public void onFinish() {
            finish.result("重新发送");
        }
    }

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
     * 手机注册时判断手机正确性
     *
     * @param acc
     * @param phone
     * @param authCode
     * @param pwd
     * @param rePwd
     * @return
     */
    public int registerPhoneJudge(String acc, String phone, String authCode, String pwd, String rePwd) {
        Integer x = isRightPhone(phone);
        if (x != 1) return x;
        if (authCode.isEmpty()) {
            return AUTH_CODE_IS_EMPTY;
        }
        return registerJudgeAccAndPwd(acc, pwd, rePwd);
    }

    public int isRightPhone(String phone) {
        if (phone.isEmpty()) {
            return PHONE_IS_EMPTY;
        }
        if (!ZhengZeUtil.isMobileNum(phone)) {
            return NOT_PHONE;
        }
        return 1;
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
                    EventBus.getDefault().post(new UserIsLoginEvent(true));
                } else {
                    error.result(e.getErrorCode());
                    EventBus.getDefault().post(new UserIsLoginEvent(true));
                }

            }
        });
    }

    public void userLogout(){
        EventBus.getDefault().post(new UserIsLoginEvent(false));
        BmobUtils.UserUtils.logout();
    }

    /**
     * 发送短信验证码
     *
     * @param phone
     * @param success
     * @param error
     */
    public void registerSendAuthCode(String phone, final MvpModelCallBack<String> success, final MvpModelCallBack<String> error) {
        BmobUtils.UserUtils.sendSmsAuthCode(phone, new QueryListener<Integer>() {
            @Override
            public void done(Integer integer, BmobException e) {
                if (e == null) {
                    success.result("短信发送成功！");
                } else {
                    error.result("短信发送失败!");
                }
            }
        });
    }

    /**
     * 启动倒计时
     *
     * @param targetTime
     */
    public void startCountDown(long targetTime, MvpModelCallBack<String> ticking, MvpModelCallBack<String> finish) {
        if (myCountDown != null) {
            myCountDown.cancel();
            myCountDown.start();
        } else {
            myCountDown = new MyCountDown(targetTime, 1000, ticking, finish);
            myCountDown.start();
        }
    }

    /**
     * 关闭倒计时
     */
    public void closeCountDown() {
        if (myCountDown != null) {
            myCountDown.cancel();
            myCountDown = null;
        }
    }

    /**
     * 手机注册
     *
     * @param acc
     * @param phone
     * @param pwd
     * @param authCode
     * @param success
     * @param error
     */
    public void userPhoneRegister(String acc, String phone, String pwd, String authCode, final MvpModelCallBack<BmobUser> success, final MvpModelCallBack<String> error) {
        BmobUtils.UserUtils.phoneRegister(acc, phone, pwd, authCode, new SaveListener<BmobUser>() {
            @Override
            public void done(BmobUser bmobUser, BmobException e) {
                if (e == null) {
                    success.result(bmobUser);
                } else {
                    switch (e.getErrorCode()) {
                        case BmobUtils.UserUtils.AUTH_CODE_ERROR:
                            error.result("验证码错误！");
                            break;
                    }
                }
            }
        });
    }

    /**
     * 判断当前手机号是否被注册
     * @param phone
     * @param success
     * @param error
     */
    public void isHavePhone(String phone, final MvpModelCallBack<Void> success, final MvpModelCallBack<Integer> error){

        BmobUtils.UserUtils.isHaveThisUserWhereObj("mobilePhoneNumber", phone, new FindListener<BmobUser>() {
            @Override
            public void done(List<BmobUser> list, BmobException e) {
                if (e == null){
                    if (!list.isEmpty()){
                        error.result(null);
                    }else {
                        success.result(null);
                    }
                }else {
                    error.result(e.getErrorCode());
                }
            }
        });

    }

    /**
     * 普通注册
     *
     * @param acc
     * @param pwd
     * @param success
     * @param error
     */
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
