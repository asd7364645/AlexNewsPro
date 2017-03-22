package com.newspro.alexnewspro.utils.common_util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

    public static boolean isMobileNum(String mobiles){
        if (mobiles == null||mobiles.equals("")) {
            return false;
        }
        Pattern pattern = Pattern.compile(ZhengZeUtil.zzPhone);
        Matcher matcher = pattern.matcher(mobiles);
        return matcher.matches();
    }

    public static boolean isImgUrl(String str) {
        Pattern urlPattern = Pattern.compile(ZhengZeUtil.zzUrl);
        Matcher urlMatcher = urlPattern.matcher(str);
        Pattern imgPattern = Pattern.compile(ZhengZeUtil.zzImg);
        Matcher imgMatcher = imgPattern.matcher(str);
        return urlMatcher.find() && imgMatcher.find();
    }

}
