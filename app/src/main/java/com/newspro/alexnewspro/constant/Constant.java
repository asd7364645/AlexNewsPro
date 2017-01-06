package com.newspro.alexnewspro.constant;

import android.util.SparseArray;

import java.util.HashMap;

/**
 * 全局静态常量
 * Alex
 */

public class Constant {

    public static final String TITLE_NEWS = "新闻";
    public static final String TITLE_BIMGS = "美图";

    /**
     * "channelId": "5572a108b3cdc86cf39001ce",
     * "name": "国际焦点"
     * "channelId": "5572a108b3cdc86cf39001d0",
     * "name": "财经焦点"
     * "channelId": "5572a108b3cdc86cf39001d2",
     * "name": "房产焦点"
     * "channelId": "5572a108b3cdc86cf39001d3",
     * "name": "汽车焦点"
     * "channelId": "5572a108b3cdc86cf39001d4",
     * "name": "体育焦点"
     * "channelId": "5572a108b3cdc86cf39001d5",
     * "name": "娱乐焦点"
     * "channelId": "5572a108b3cdc86cf39001d7",
     * "name": "教育焦点"
     * "channelId": "5572a108b3cdc86cf39001d8",
     * "name": "女人焦点"
     * "channelId": "5572a109b3cdc86cf39001da",
     * "name": "社会焦点"
     * "channelId": "5572a109b3cdc86cf39001db",
     * "name": "国内最新"
     * "channelId": "5572a109b3cdc86cf39001dc",
     * "name": "台湾最新"
     * "channelId": "5572a109b3cdc86cf39001dd",
     * "name": "港澳最新"
     * "channelId": "5572a109b3cdc86cf39001de",
     * "name": "国际最新"
     * "channelId": "5572a109b3cdc86cf39001df",
     * "name": "军事最新"
     * "channelId": "5572a109b3cdc86cf39001e0",
     * "name": "财经最新"
     * "channelId": "5572a109b3cdc86cf39001e1",
     * "name": "理财最新"
     * "channelId": "5572a109b3cdc86cf39001e2",
     * "name": "宏观经济最新"
     * "channelId": "5572a109b3cdc86cf39001e3",
     * "name": "互联网最新"
     * "channelId": "5572a109b3cdc86cf39001e4",
     * "name": "房产最新"
     * "channelId": "5572a109b3cdc86cf39001e5",
     * "name": "汽车最新"
     * "channelId": "5572a109b3cdc86cf39001e6",
     * "name": "体育最新"
     * "channelId": "5572a10ab3cdc86cf39001e7",
     * "name": "国际足球最新"
     * "channelId": "5572a10ab3cdc86cf39001e8",
     * "name": "国内足球最新"
     * "channelId": "5572a10ab3cdc86cf39001e9",
     * "name": "CBA最新"
     * "channelId": "5572a10ab3cdc86cf39001ea",
     * "name": "综合体育最新"
     * "channelId": "5572a10ab3cdc86cf39001eb",
     * "name": "娱乐最新"
     * "channelId": "5572a10ab3cdc86cf39001ed",
     * "name": "电视最新"
     * "channelId": "5572a10ab3cdc86cf39001ee",
     * "name": "游戏最新"
     * "channelId": "5572a10ab3cdc86cf39001ef",
     * "name": "教育最新"
     * "channelId": "5572a10ab3cdc86cf39001f0",
     * "name": "女人最新"
     * "channelId": "5572a10ab3cdc86cf39001f1",
     * "name": "美容护肤最新"
     * "channelId": "5572a10ab3cdc86cf39001f2",
     * "name": "情感两性最新"
     * "channelId": "5572a10ab3cdc86cf39001f3",
     * "name": "健康养生最新"
     * "channelId": "5572a10ab3cdc86cf39001f4",
     * "name": "科技最新"
     * "channelId": "5572a10bb3cdc86cf39001f5",
     * "name": "数码最新"
     * "channelId": "5572a10bb3cdc86cf39001f6",
     * "name": "电脑最新"
     * "channelId": "5572a10bb3cdc86cf39001f7",
     * "name": "科普最新"
     * "channelId": "5572a10bb3cdc86cf39001f8",
     * "name": "社会最新"
     */
    /**
     * 新闻url
     */
    public static final String NEWS_URL = "http://route.showapi.com/";
    /**
     * 新闻appkey
     */
    public static final String NEWS_APPKEY = "500554d0d0fa48d8b4ae9c0611344d0d";
    /**
     * 新闻appid
     */
    public static final int NEWS_APPID = 29674;
    /**
     * 新闻默认参数
     */
    public static final String NEWS_DEF_PARAM = "109-35?showapi_appid="+NEWS_APPID+"&showapi_sign=" +
            NEWS_APPKEY+"";
    /**国内焦点*/
    public static final String NEWS_GUONEIJIAODIAN = "5572a108b3cdc86cf39001cd";
    /**军事焦点*/
    public static final String NEWS_JUNSHIJIAODIAN = "5572a108b3cdc86cf39001cf";
    /**互联网焦点*/
    public static final String NEWS_HULIANWANGJIAODIAN = "5572a108b3cdc86cf39001d1";
    /**游戏焦点*/
    public static final String NEWS_YOUXIJIAODIAN = "5572a108b3cdc86cf39001d6";
    /**科技焦点*/
    public static final String NEWS_KEJIJIAODIAN = "5572a108b3cdc86cf39001d9";
    /**电影最新*/
    public static final String NEWS_DIANYINGZUIXIN = "5572a10ab3cdc86cf39001ec";

    public static final HashMap<String, String> NEWS_TITLES_MAP;
    public static final String NEWS_TYPE_STR = "type";

    static {
        NEWS_TITLES_MAP = new HashMap<>();
        NEWS_TITLES_MAP.put(NEWS_GUONEIJIAODIAN, "国内焦点");
        NEWS_TITLES_MAP.put(NEWS_JUNSHIJIAODIAN, "军事焦点");
        NEWS_TITLES_MAP.put(NEWS_HULIANWANGJIAODIAN, "互联网焦点");
        NEWS_TITLES_MAP.put(NEWS_YOUXIJIAODIAN, "游戏焦点");
        NEWS_TITLES_MAP.put(NEWS_KEJIJIAODIAN, "科技焦点");
        NEWS_TITLES_MAP.put(NEWS_DIANYINGZUIXIN, "电影最新");
    }

    //--------------------美图-------------------------

    /**百度API key**/
    public static final String BAIDU_APPKEY = "4b464d1f8a5ffb55dc85c7d785856760";

    /**美图url地址**/
    public static final String BIMG_URL = "http://apis.baidu.com/tngou/gallery/";

    /**图片返回的不是完整网址，所以需要在前面加上这个**/
    public static final String BIMG_IMG_START_URL = "http://tnfs.tngou.net/image";

    /**图库列表**/
    public static final String BIMG_LIST = "list";
    /**图库详情**/
    public static final String BIMG_SHOW = "show";


    /**性感美女**/
    public static final int BIMG_TYPE_XINGGANMEINV = 1;
    /**韩日美女**/
    public static final int BIMG_TYPE_RIHANMEINV = 2;
    /**丝袜美腿**/
    public static final int BIMG_TYPE_SIWAMEITUI = 3;
    /**美女照片**/
    public static final int BIMG_TYPE_MEINVZHAOPIAN = 4;
    /**美女写真**/
    public static final int BIMG_TYPE_MEINVXIEZHEN = 5;
    /**清纯美女**/
    public static final int BIMG_TYPE_QINGCHUNMEINV = 6;
    /**性感车模**/
    public static final int BIMG_TYPE_XINGGANCHEMO = 7;

    public static final SparseArray<String> BIMG_TITLE_SPARSEARRAY;

    static {
        BIMG_TITLE_SPARSEARRAY = new SparseArray<>();
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_XINGGANMEINV,"性感美女");
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_RIHANMEINV,"韩日美女");
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_SIWAMEITUI,"丝袜美腿");
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_MEINVZHAOPIAN,"美女照片");
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_MEINVXIEZHEN,"美女写真");
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_QINGCHUNMEINV,"清纯美女");
        BIMG_TITLE_SPARSEARRAY.put(BIMG_TYPE_XINGGANCHEMO,"性感车模");
    }


}
