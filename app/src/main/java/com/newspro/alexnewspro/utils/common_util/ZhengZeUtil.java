package com.newspro.alexnewspro.utils.common_util;

/**
 * 正则表达式匹配工具类
 * Alex
 */

public class ZhengZeUtil {

    /**
     * 匹配图片url正则表达式
     */
    public static String zzImgUrl = "[a-zA-z]+://[^\\s]*.+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";
    /**
     * 网址
     */
    public static String zzUrl = "[a-zA-z]+://[^\\s]*";
    /**
     * 匹配图片url正则表达式
     */
    public static String zzImg = "(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)";
    /**
     * 是否有全角字符
     */
    public static final String zzHalfChar = "[\u0000-\u00FF]+";
    /**
     * 手机号
     */
    public static final String zzPhone = "^((13[0-9])|(15[^4,\\D])|(18[0,1,5-9])|(17[6，7,8]))\\d{8}$";

}
