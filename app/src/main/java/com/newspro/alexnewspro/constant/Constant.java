package com.newspro.alexnewspro.constant;

import android.util.SparseArray;

import java.util.HashMap;

/**
 * 全局静态常量
 * Alex
 */

public class Constant {

    public static final String BMOB_APPKEY = "06c05a3180042aed6b29bb1409e66581";

    public static final String TITLE_NEWS = "新闻";
    public static final String TITLE_BIMGS = "美图";
    public static final String TITLE_MOVIES = "影讯";
    public static final String TITLE_BAISI = "百思不得姐";
    /**
     * 新闻url
     */
    public static final String SHOW_API_URL = "http://route.showapi.com/";
    /**
     * 新闻appkey
     */
    public static final String NEWS_APPKEY = "500554d0d0fa48d8b4ae9c0611344d0d";
    /**
     * 新闻appid
     */
    public static final int NEWS_APPID = 29674;
    private static final String SHOW_API_DEF_PARAM = "?showapi_appid=" + NEWS_APPID + "&showapi_sign=" +
            NEWS_APPKEY + "";
    /**
     * 新闻默认参数
     */
    public static final String NEWS_DEF_PARAM = "109-35" + SHOW_API_DEF_PARAM ;
    /**
     * 国内焦点
     */
    public static final String NEWS_GUONEIJIAODIAN = "5572a108b3cdc86cf39001cd";
    /**
     * 军事焦点
     */
    public static final String NEWS_JUNSHIJIAODIAN = "5572a108b3cdc86cf39001cf";
    /**
     * 互联网焦点
     */
    public static final String NEWS_HULIANWANGJIAODIAN = "5572a108b3cdc86cf39001d1";
    /**
     * 游戏焦点
     */
    public static final String NEWS_YOUXIJIAODIAN = "5572a108b3cdc86cf39001d6";
    /**
     * 科技焦点
     */
    public static final String NEWS_KEJIJIAODIAN = "5572a108b3cdc86cf39001d9";
    /**
     * 电影最新
     */
    public static final String NEWS_DIANYINGZUIXIN = "5572a10ab3cdc86cf39001ec";

    public static final HashMap<String, String> NEWS_TITLES_MAP;
    public static final String NEWS_TYPE_STR = "type";
    public static final String[] MOVIES_TYPE
            = new String[]{"正在上映", "TOP 250", "即将上映"};
    /**
     * 百思不得姐默认参数
     */
    public static final String BAISIBUDEJIE_DEF_PARAM = "255-1" + SHOW_API_DEF_PARAM;
    public static final SparseArray<String> BAISIBUDEJIE_SPARSE;
    public static final int BAISIBUDEJIE_IMGS_TYPE = 10;
    public static final int BAISIBUDEJIE_DUANZI_TYPE = 29;
    public static final int BAISIBUDEJIE_MUSIC_TYPE = 31;
    public static final int BAISIBUDEJIE_MEDIA_TYPE = 41;

    static {
        NEWS_TITLES_MAP = new HashMap<>();
        NEWS_TITLES_MAP.put(NEWS_GUONEIJIAODIAN, "国内焦点");
        NEWS_TITLES_MAP.put(NEWS_JUNSHIJIAODIAN, "军事焦点");
        NEWS_TITLES_MAP.put(NEWS_HULIANWANGJIAODIAN, "互联网焦点");
        NEWS_TITLES_MAP.put(NEWS_YOUXIJIAODIAN, "游戏焦点");
        NEWS_TITLES_MAP.put(NEWS_KEJIJIAODIAN, "科技焦点");
        NEWS_TITLES_MAP.put(NEWS_DIANYINGZUIXIN, "电影最新");

        BAISIBUDEJIE_SPARSE = new SparseArray<>();
        BAISIBUDEJIE_SPARSE.put(BAISIBUDEJIE_IMGS_TYPE, "图片");
        BAISIBUDEJIE_SPARSE.put(BAISIBUDEJIE_DUANZI_TYPE, "段子");
        BAISIBUDEJIE_SPARSE.put(BAISIBUDEJIE_MUSIC_TYPE, "声音");
        BAISIBUDEJIE_SPARSE.put(BAISIBUDEJIE_MEDIA_TYPE, "视频");

    }


    //--------------------美图-------------------------

    /**
     * 美图url地址
     **/
    public static final String GANK_IO_URL = "http://gank.io/api/data/";

    /**
     * 图库列表
     **/
    public static final String BIMG_LIST = "福利";

    public static final String BIMG_URL = GANK_IO_URL + BIMG_LIST + "/20/";


    //--------------------豆瓣电影-------------------------

    public static final String MOVIE_API_URL = "https://api.douban.com/v2/movie/";


    //--------------------  其他  ------------------------
    public static final int GO_REGISTER_CODE = 1;

    /**
     * 网络Bmob数据库或者内部数据库用到的表名
     */
    public static class SQLTable {
        public static String COLLECT_TABLE_NAME = "UserCollectTable";
    }

}
