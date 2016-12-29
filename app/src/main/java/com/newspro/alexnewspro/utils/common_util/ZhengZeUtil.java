package com.newspro.alexnewspro.utils.common_util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 正则表达式匹配工具类
 * Alex
 */

public class ZhengZeUtil {

    /**匹配图片url正则表达式*/
    private static String zzUrl = "[a-zA-z]+://[^\\s]*.+(.JPEG|.jpeg|.JPG|.jpg|.GIF|.gif|.BMP|.bmp|.PNG|.png)$";

    public static boolean isImgUrl(String str){
        Pattern pattern = Pattern.compile(zzUrl);
        Matcher matcher = pattern.matcher(str);
        return matcher.find();
    }

}
