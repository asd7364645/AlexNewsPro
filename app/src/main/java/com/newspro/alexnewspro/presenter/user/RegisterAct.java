package com.newspro.alexnewspro.presenter.user;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

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
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.GREATER_THAN_16;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_ACC;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_CHINESE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_HALF;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_NO_EQUALLY;

public class RegisterAct extends MvpBaseAct<RegisterView, UserModel> implements View.OnClickListener {

    Intent intent;

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
        }
    }

    private void register() {
        int result = mvpModel.registerJudgeAccAndPwd(mvpView.getAcc(), mvpView.getPwd(), mvpView.getRePwd());
        switch (result) {
            case ACC_AND_PWD_OK:
                LoadingDialogUtils.showLoadingDialog(this, "请稍后...");
                mvpModel.userRegister(mvpView.getAcc(), mvpView.getPwd(), new MvpModelCallBack<BmobUser>() {
                    @Override
                    public void result(BmobUser data) {
                        ToastUtils.showShort(RegisterAct.this, "注册成功!");
                        String acc = data.getUsername();
                        LoadingDialogUtils.dismissDialog();
                        intent.putExtra("register_acc", acc);
                        setResult(GO_REGISTER_CODE, intent);
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
        }
    }
}
