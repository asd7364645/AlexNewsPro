package com.newspro.alexnewspro.presenter.user;

import android.content.Intent;
import android.view.View;

import com.example.alex.mvplibrary.model.MvpModelCallBack;
import com.example.alex.mvplibrary.presenter.MvpBaseAct;
import com.newspro.alexnewspro.R;
import com.newspro.alexnewspro.constant.Constant;
import com.newspro.alexnewspro.model.UserModel;
import com.newspro.alexnewspro.utils.LoadingDialogUtils;
import com.newspro.alexnewspro.utils.common_util.ToastUtils;
import com.newspro.alexnewspro.view.user.LoginView;

import static com.newspro.alexnewspro.constant.Constant.GO_REGISTER_CODE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_AND_PWD_OK;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_IS_EMPTY;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.ACC_OR_PWD_ERROR;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.GREATER_THAN_16;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_CHINESE;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.IS_HAS_HALF;
import static com.newspro.alexnewspro.utils.BmobUtils.UserUtils.PWD_IS_EMPTY;

public class LoginAct extends MvpBaseAct<LoginView, UserModel> implements View.OnClickListener {

    private Intent intent;

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.login_login_btn:
                login();
                break;
            case R.id.login_register:
                intent = new Intent(this, RegisterAct.class);
                startActivityForResult(intent, GO_REGISTER_CODE);
                break;
        }
    }

    private void login() {
        LoadingDialogUtils.showLoadingDialog(LoginAct.this, "请稍后...");
        int result = mvpModel.judgeAccAndPwd(mvpView.getAcc(), mvpView.getPwd());
        switch (result) {
            case ACC_AND_PWD_OK:
                mvpModel.userLogin(mvpView.getAcc(), mvpView.getPwd(), new MvpModelCallBack<Void>() {
                    @Override
                    public void result(Void data) {
                        ToastUtils.showShort(LoginAct.this, "登陆成功!");
                        LoadingDialogUtils.dismissDialog();
                        finish();
                    }
                }, new MvpModelCallBack<Integer>() {
                    @Override
                    public void result(Integer data) {
                        switch (data) {
                            case ACC_OR_PWD_ERROR:
                                ToastUtils.showShort(LoginAct.this, "账号或密码错误");
                                LoadingDialogUtils.dismissDialog();
                                break;
                        }
                    }
                });
                break;
            case ACC_IS_EMPTY://"用户名不能为空"
                mvpView.setAccErr("用户名不能为空");
                LoadingDialogUtils.dismissDialog();
                break;
            case PWD_IS_EMPTY://"密码不能为空"
                mvpView.setPwdErr("密码不能为空");
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
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == Constant.GO_REGISTER_CODE && resultCode == Constant.GO_REGISTER_CODE) {
            mvpView.setAccText(data.getStringExtra("register_acc"));
        }
    }
}
