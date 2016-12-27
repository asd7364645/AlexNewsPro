package com.newspro.alexnewspro.utils.common_util;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;

import java.io.File;
import java.util.List;

/**
 * Created by Alex on 2016/12/27.
 * Alex
 */

public class AppUtils {
    private AppUtils() {
        /* cannot be instantiated */
        throw new UnsupportedOperationException("cannot be instantiated");

    }

    // 在进程中去寻找当前APP的信息，判断是否在前台运行
    public static boolean isAppOnForeground(Context context) {
        if (context == null)
            return false;
        ActivityManager activityManager = (ActivityManager) context.getApplicationContext()
                .getSystemService(Context.ACTIVITY_SERVICE);
        String packageName = context.getApplicationContext().getPackageName();
        List<ActivityManager.RunningAppProcessInfo> appProcesses = activityManager.getRunningAppProcesses();
        if (appProcesses == null)
            return false;
        for (ActivityManager.RunningAppProcessInfo appProcess : appProcesses) {
            if (appProcess.processName.equals(packageName)
                    && appProcess.importance == ActivityManager.RunningAppProcessInfo.IMPORTANCE_FOREGROUND) {
                return true;
            }
        }
        return false;
    }

    /**
     * 开启安装apk
     *
     * @param context
     * @param apkName
     */
    public static void installApk(Context context, File dir, String apkName) {
        Intent intent = new Intent(Intent.ACTION_VIEW);
        File apkFile = new File(dir, apkName);
        intent.setDataAndType(Uri.fromFile(apkFile), "application/vnd.android.package-archive");
        context.startActivity(intent);
    }

    /**
     * 打开已经安装的APP
     *
     * @param context
     * @param pkgName
     * @return 返回开启状态："打开成功"，"没有找到应用"
     */
    public static String openApp(Context context, String pkgName) {
        PackageManager pManager = context.getPackageManager();
        Intent intent = pManager.getLaunchIntentForPackage(pkgName);
        if (intent != null) {
            context.startActivity(intent);
            return "打开成功";
        } else {
            return "没有找到应用";
        }
    }

    /**
     * 判断是否有这个应用了
     *
     * @param context
     * @param pkgName
     * @return
     */
    public static boolean isInstallApp(Context context, String pkgName) {
        PackageManager pManager = context.getPackageManager();
        try {
            pManager.getApplicationInfo(pkgName, 0);
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            return false;
        }
        return true;
    }

    /**
     * 获取应用程序名称
     */
    public static String getAppName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            int labelRes = packageInfo.applicationInfo.labelRes;
            return context.getResources().getString(labelRes);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 通过包名得到应用
     *
     * @param context
     * @param pkgName
     * @return
     */
    public static PackageInfo getInstallApp(Context context, String pkgName) {
        PackageManager pManager = context.getPackageManager();
        try {
            PackageInfo info = pManager.getPackageInfo(pkgName, 0);
            return info;
        } catch (PackageManager.NameNotFoundException e) {
            // TODO Auto-generated catch block
            return null;
        }
    }

    /**
     * [获取应用程序版本名称信息]
     *
     * @param context
     * @return 当前应用的版本名称
     */
    public static String getVersionName(Context context) {
        try {
            PackageManager packageManager = context.getPackageManager();
            PackageInfo packageInfo = packageManager.getPackageInfo(
                    context.getPackageName(), 0);
            return packageInfo.versionName;

        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }
}
