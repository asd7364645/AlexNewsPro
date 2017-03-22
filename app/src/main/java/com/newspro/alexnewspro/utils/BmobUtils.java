package com.newspro.alexnewspro.utils;

import com.newspro.alexnewspro.bean.NewsBean.ShowapiResBodyBean.PagebeanBean.ContentlistBean;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobSMS;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.QueryListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class BmobUtils {

    /**
     * 用户收藏管理工具类，
     */
    public static class CollectUtils {

        /**
         * 添加收藏
         *
         * @param bmobObject
         * @param listener
         */
        public static void addCollect(BmobObject bmobObject, SaveListener<String> listener) {
            bmobObject.save(listener);
        }

        /**
         * 通过用户Id和新闻url得到收藏的新闻
         *
         * @param url
         * @param userId
         * @param litener
         */
        public static void getNewsCollectWithUser(String url, String userId, FindListener<ContentlistBean> litener) {
            BmobQuery<ContentlistBean> urlQ = new BmobQuery<>();
            urlQ.addWhereEqualTo("link", url);
            BmobQuery<ContentlistBean> userIdQ = new BmobQuery<>();
            urlQ.addWhereEqualTo("userId", userId);
            List<BmobQuery<ContentlistBean>> queries = new ArrayList<>();
            queries.add(urlQ);
            queries.add(userIdQ);
            BmobQuery<ContentlistBean> mainQ = new BmobQuery<>();
            mainQ.and(queries);
            mainQ.findObjects(litener);
        }

        /**
         * 根据url删除对应信息
         *
         * @param objId
         * @param listener
         */
        public static void deleteCollectWithUrl(BmobObject bmobObject,String objId, UpdateListener listener) {
            bmobObject.delete(objId, listener);
        }

    }

    public static class UserUtils {
        private static BmobUser mBmobUser;
        public static final int ACC_AND_PWD_OK = 0;
        public static final int ACC_IS_EMPTY = 10; //"用户名不能为空"
        public static final int PWD_IS_EMPTY = 20;//"密码不能为空"
        public static final int IS_HAS_HALF = 30;//存在全角字符
        public static final int IS_HAS_CHINESE = 40;//存在中文
        public static final int GREATER_THAN_16 = 50;//字符串长度大于16位
        public static final int PWD_NO_EQUALLY = 60;//两次密码输入不一致
        public static final int NOT_PHONE = 70;//手机号有误
        public static final int PHONE_IS_EMPTY = 80;//"手机号不能为空"
        public static final int AUTH_CODE_IS_EMPTY = 90;//"手机号不能为空"
        public static final int ACC_OR_PWD_ERROR = 101;//账号或密码错误
        public static final int IS_HAS_ACC = 202;//用户名已存在
        public static final int IS_HAS_EMALE = 203;//邮箱已存在
        public static final int AUTH_CODE_ERROR = 207;//验证码错误

        public static void isHaveThisUserWhereObj(String rowName, String obj, FindListener<BmobUser> listener){
            BmobQuery<BmobUser> query = new BmobQuery<>();
            query.addWhereEqualTo(rowName,obj);
            query.findObjects(listener);
        }

        public static boolean isLogin() {
            return mBmobUser != null;
        }

        /**
         * 登录
         * @param acc
         * @param pwd
         * @param logInListener
         */
        public static void login(String acc, String pwd, LogInListener logInListener) {
            BmobUser.loginByAccount(acc, pwd, logInListener);
        }

        /**
         * 退出登录
         */
        public static void logout() {
            BmobUser.logOut();
            initUser();
        }

        /**
         * 普通注册
         * @param acc
         * @param pwd
         * @param listener
         */
        public static void register(String acc, String pwd, SaveListener listener) {
            BmobUser bmobUser = new BmobUser();
            bmobUser.setUsername(acc);
            bmobUser.setPassword(pwd);
            bmobUser.signUp(listener);
        }

        public static void sendSmsAuthCode(String phone, QueryListener<Integer> listener){
            BmobSMS.requestSMSCode(phone,"看看验证",listener);
        }

        /**
         * 手机号注册
         * @param acc
         * @param phone
         * @param pwd
         * @param code
         * @param listener
         */
        public static void phoneRegister(String acc, String phone, String pwd, String code, SaveListener<? extends Object> listener){
            BmobUser bmobUser = new BmobUser();
            bmobUser.setUsername(acc);
            bmobUser.setMobilePhoneNumber(phone);
            bmobUser.setPassword(pwd);
            bmobUser.signOrLogin(code,listener);

        }

        /**
         * 初始化user,一般在Application中使用
         * 判断是否登录
         */
        public static void initUser() {
            try {
                mBmobUser = BmobUser.getCurrentUser();
            } catch (NullPointerException e) {
                e.printStackTrace();
                mBmobUser = null;
            }
        }

        public static BmobUser getmBmobUser() {
            return mBmobUser;
        }

        public static void setmBmobUser(BmobUser mBmobUser) {
            UserUtils.mBmobUser = mBmobUser;
        }

        public static String getUserId() {
            return isLogin() ? mBmobUser.getObjectId() : null;
        }

    }

}
