package com.newspro.alexnewspro.utils;

import com.newspro.alexnewspro.bean.bmob.UserCollectTable;

import java.util.ArrayList;
import java.util.List;

import cn.bmob.v3.BmobObject;
import cn.bmob.v3.BmobQuery;
import cn.bmob.v3.BmobUser;
import cn.bmob.v3.listener.FindListener;
import cn.bmob.v3.listener.LogInListener;
import cn.bmob.v3.listener.SaveListener;
import cn.bmob.v3.listener.UpdateListener;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class BmobUtils {

    public static class CollectUtils{

        public static void addCollect(BmobObject bmobObject, SaveListener<String> listener){
            bmobObject.save(listener);
        }

        public static void getCollectWithUser(String url, String userId, FindListener<UserCollectTable> litener){
            BmobQuery<UserCollectTable> urlQ = new BmobQuery<>();
            urlQ.addWhereEqualTo("collectUrl",url);
            BmobQuery<UserCollectTable> userIdQ = new BmobQuery<>();
            urlQ.addWhereEqualTo("userId",userId);
            List<BmobQuery<UserCollectTable>> queries = new ArrayList<>();
            queries.add(urlQ);
            queries.add(userIdQ);
            BmobQuery<UserCollectTable> mainQ = new BmobQuery<>();
            mainQ.and(queries);
            mainQ.findObjects(litener);
        }

        /**
         * 根据url删除对应信息
         * @param objId
         * @param listener
         */
        public static void deleteCollectWithUrl(String objId, UpdateListener listener){
            UserCollectTable userCollectTable = new UserCollectTable();
            userCollectTable.delete(objId,listener);
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
        public static final int ACC_OR_PWD_ERROR = 101;//账号或密码错误
        public static final int IS_HAS_ACC = 202;//用户名已存在
        public static final int IS_HAS_EMALE = 203;//邮箱已存在

        public static boolean isLogin() {
            return mBmobUser != null;
        }

        public static void login(String acc, String pwd, LogInListener logInListener) {
            BmobUser.loginByAccount(acc, pwd, logInListener);
        }

        public static void logout() {
            BmobUser.logOut();
            initUser();
        }

        public static void register(String acc, String pwd, SaveListener listener) {
            BmobUser bmobUser = new BmobUser();
            bmobUser.setUsername(acc);
            bmobUser.setPassword(pwd);
            bmobUser.signUp(listener);
        }

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

        public static String getUserId(){
            return isLogin()?mBmobUser.getObjectId():null;
        }

    }

}
