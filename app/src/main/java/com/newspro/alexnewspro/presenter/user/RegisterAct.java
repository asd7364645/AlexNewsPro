package com.newspro.alexnewspro.presenter.user;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.IdRes;
import android.view.View;
import android.widget.RadioGroup;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.model.UserModel;
import com.newspro.alexnewspro.utils.LoadingDialogUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.user.RegisterView;

import cn.bmob.v3.BmobUser;

import static com.newspro.alexnewspro.constant.Constant.GO_REGISTER_CODE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_AND_PWD_OK;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.AUTH_CODE_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.GREATER_THAN_16;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_ACC;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_CHINESE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_HALF;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.NOT_PHONE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PHONE_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_NO_EQUALLY;

public class RegisterAct extends MvpBaseAct<RegisterView, UserModel> implements View.OnClickListener, RadioGroup.OnCheckedChangeListener {

    Intent intent;
    private boolean isPhoneRegister;

    @Override
    public void create(Bundle saveInstance) {
        super.create(saveInstance);
        intent = getIntent();
    }


    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register_register_btn:
                register();
                break;
            case R.id.send_code_btn:
                mvpView.setSendBtnEnable(false);
                sendRegisterAuthCode();
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mvpModel.closeCountDown();
    }

    private void sendRegisterAuthCode() {
        //判断手机号是否正确
        Integer result = mvpModel.isRightPhone(mvpView.getPhone());
        switch (result) {
            //正确的话则执行发送短信验证码，并且开启倒计时
            case 1:
                //判断手机号是否存在
                mvpModel.isHavePhone(mvpView.getPhone(), new MvpModelCallBack<Void>() {
                    @Override
                    public void result(Void data) {
                        mvpModel.registerSendAuthCode(mvpView.getPhone(), new MvpModelCallBack<String>() {
                            @Override
                            public void result(String data) {
                                ToastUtils.showShort(RegisterAct.this, data);
                                mvpModel.startCountDown(120000, new MvpModelCallBack<String>() {
                                    @Override
                                    public void result(String data) {
                                        mvpView.setSendBtnText(data);
                                    }
                                }, new MvpModelCallBack<String>() {
                                    @Override
                                    public void result(String data) {
                                        mvpView.setSendBtnEnable(true);
                                        mvpView.setSendBtnText(data);
                                    }
                                });
                            }
                        }, new MvpModelCallBack<String>() {
                            @Override
                            public void result(String data) {
                                ToastUtils.showShort(RegisterAct.this, data);
                                mvpView.setSendBtnEnable(true);
                            }
                        });
                    }
                }, new MvpModelCallBack<Integer>() {
                    @Override
                    public void result(Integer data) {
                        ToastUtils.showShort(RegisterAct.this, "手机号已被注册！");
                    }
                });
                break;
            case PHONE_IS_EMPTY:
                mvpView.setPhoneError("手机号不能为空");
                mvpView.setSendBtnEnable(true);
                break;
            case NOT_PHONE:
                mvpView.setPhoneError("手机号有误，请重新输入！");
                mvpView.setSendBtnEnable(true);
                break;
        }
    }

    private void register() {
        int result;
        //判断是否是手机注册模式
        if (isPhoneRegister) {
            result = mvpModel.registerPhoneJudge(mvpView.getAcc(), mvpView.getPhone(), mvpView.getAuthCode(), mvpView.getPwd(), mvpView.getRePwd());
        } else {
            result = mvpModel.registerJudgeAccAndPwd(mvpView.getAcc(), mvpView.getPwd(), mvpView.getRePwd());
        }
        //判断返回码，根据返回码做不同的处理
        switch (result) {
            case ACC_AND_PWD_OK:
                if (isPhoneRegister) {
                    LoadingDialogUtils.showLoadingDialog(this, "请稍后...");
                    mvpModel.userPhoneRegister(mvpView.getAcc(), mvpView.getPhone(), mvpView.getPwd(), mvpView.getAuthCode(), new MvpModelCallBack<BmobUser>() {
                        @Override
                        public void result(BmobUser data) {
                            ToastUtils.showShort(RegisterAct.this, "注册成功!");
                            resultAcc(data);
                            LoadingDialogUtils.dismissDialog();
                            finish();
                        }
                    }, new MvpModelCallBack<String>() {
                        @Override
                        public void result(String data) {
                            ToastUtils.showShort(RegisterAct.this, data);
                            LoadingDialogUtils.dismissDialog();
                        }
                    });
                } else {
                    LoadingDialogUtils.showLoadingDialog(this, "请稍后...");
                    mvpModel.userRegister(mvpView.getAcc(), mvpView.getPwd(), new MvpModelCallBack<BmobUser>() {
                        @Override
                        public void result(BmobUser data) {
                            ToastUtils.showShort(RegisterAct.this, "注册成功!");
                            resultAcc(data);
                            LoadingDialogUtils.dismissDialog();
                            finish();
                        }
                    }, new MvpModelCallBack<Integer>() {
                        @Override
                        public void result(Integer data) {
                            switch (data) {
                                case IS_HAS_ACC:
                                    mvpView.setAccError("用户名已存在");
                                    LoadingDialogUtils.dismissDialog();
                                    break;
                            }
                        }
                    });
                }
                break;
            case ACC_IS_EMPTY://"用户名不能为空"
                mvpView.setAccError("用户名不能为空");
                LoadingDialogUtils.dismissDialog();
                break;
            case PWD_IS_EMPTY://"密码不能为空"
                mvpView.setPwdError("密码不能为空");
                LoadingDialogUtils.dismissDialog();
                break;
            case IS_HAS_HALF://存在全角字符
                ToastUtils.showShort(this, "存在全角字符，请检查");
                LoadingDialogUtils.dismissDialog();
                break;
            case IS_HAS_CHINESE://存在中文
                ToastUtils.showShort(this, "存在中文字符，请检查");
                LoadingDialogUtils.dismissDialog();
                break;
            case GREATER_THAN_16://字符串长度大于16位
                ToastUtils.showShort(this, "账号或密码大于16位，请检查");
                LoadingDialogUtils.dismissDialog();
                break;
            case PWD_NO_EQUALLY://两次密码输入不一致
                mvpView.setRePwdError("与密码不一致，请重新输入");
                LoadingDialogUtils.dismissDialog();
                break;
            case PHONE_IS_EMPTY:
                mvpView.setPhoneError("手机号不能为空");
                break;
            case NOT_PHONE:
                mvpView.setPhoneError("手机号有误，请重新输入！");
                break;
            case AUTH_CODE_IS_EMPTY:
                mvpView.setAuthCodeError("验证码不能为空！");
                break;
        }
    }

    /**
     * 向登录界面返回用户名或者手机号
     *
     * @param data
     */
    private void resultAcc(BmobUser data) {
        String acc;
        if (isPhoneRegister) {
            acc = data.getMobilePhoneNumber();
        } else {
            acc = data.getUsername();
        }
        LoadingDialogUtils.dismissDialog();
        intent.putExtra("register_acc", acc);
        setResult(GO_REGISTER_CODE, intent);
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        switch (checkedId) {
            case R.id.register_rb_common:
                isPhoneRegister = false;
                break;
            case R.id.register_rb_phone:
                isPhoneRegister = true;
                break;
        }
        mvpView.setIsPhoneRegister(isPhoneRegister);
    }
}
