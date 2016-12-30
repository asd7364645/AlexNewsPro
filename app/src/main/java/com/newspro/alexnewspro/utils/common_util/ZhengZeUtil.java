package com.newspro.alexnewspro.utils.common_util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配工具类
 * Alex
 */

public class ZhengZeUtil {

    /**匹配图片url正则表达式*/
    private static String zzImgUrl = "[a-zA-z]+://[^\\s]*.+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";

    private static String zzUrl = "[a-zA-z]+://[^\\s]*";
    private static String zzImg = "(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)";

    public static boolean isImgUrl(String str){
        Pattern urlPattern = Pattern.compile(zzUrl);
        Matcher urlMatcher = urlPattern.matcher(str);
        Pattern imgPattern = Pattern.compile(zzImg);
        Matcher imgMatcher = imgPattern.matcher(str);
        return urlMatcher.find()&&imgMatcher.find();
    }

}
