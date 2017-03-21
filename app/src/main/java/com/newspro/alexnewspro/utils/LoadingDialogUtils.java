package com.newspro.alexnewspro.utils;

import android.app.Dialog;
import android.content.Context;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.LinearInterpolator;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.newspro.alexnewspro.R;

/**
 * Created by Alex on 2017/2/20.
 * Alex
 */

public class LoadingDialogUtils {
    private static Dialog loadingDialog;

    private static Dialog createLoadingDialog(Context context, String msg) {

        LayoutInflater inflater = LayoutInflater.from(context);
        View v = inflater.inflate(R.layout.loading_dialog, null);// 得到加载view
        LinearLayout layout = (LinearLayout) v.findViewById(R.id.dialog_view);// 加载布局
        // main.xml中的ImageView
        ImageView spaceshipImage = (ImageView) v.findViewById(R.id.pro_img);
        TextView tipTextView = (TextView) v.findViewById(R.id.pro_msg);// 提示文字
        // 加载动画
        Animation hyperspaceJumpAnimation = AnimationUtils.loadAnimation(context, R.anim.loading_animation);
        hyperspaceJumpAnimation.setInterpolator(new LinearInterpolator());
        // 使用ImageView显示动画
        spaceshipImage.startAnimation(hyperspaceJumpAnimation);
        tipTextView.setText(msg);// 设置加载信息

        loadingDialog = new Dialog(context, R.style.loading_dialog);// 创建自定义样式dialog
        Window window = loadingDialog.getWindow();
        window.setGravity(Gravity.CENTER);
//		window.setWindowAnimations(R.style.myProgressStyle);
        loadingDialog.setCanceledOnTouchOutside(false);// 可以用“返回键”取消,但点击外部不会取消
        loadingDialog.setContentView(layout, new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT,
                LinearLayout.LayoutParams.MATCH_PARENT));// 设置布局
        return loadingDialog;

    }

    public static void showLoadingDialog(Context context, String message) {
        createLoadingDialog(context, message).show();
    }

    public static boolean isShowing(){
        return loadingDialog != null && loadingDialog.isShowing();
    }

    public static void dismissDialog() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
            loadingDialog = null;
        }
    }

}
