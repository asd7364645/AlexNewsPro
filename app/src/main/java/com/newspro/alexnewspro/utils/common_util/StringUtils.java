package com.newspro.alexnewspro.utils.common_util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Created by Alex on 2017/3/20.
 * Alex
 */

public class StringUtils {
    /**
     * 判断有没有全角字符
     * @param str
     * @return
     */
    public static boolean isHalfChar(String str) {
        if (str == null) {
            return false;
        } else {
            String regex = ZhengZeUtil.zzHalfChar;
            Pattern p = Pattern.compile(regex);
            Matcher m = p.matcher(str);
            boolean validate = m.matches();
            return validate;
        }
    }

    public static int uniLength(String value) {
        int valueLength = 0;
        // 获取字段值的长度，如果含中文字符，则每个中文字符长度为2，否则为1
        for (int i = 0; i < value.length(); i++) {
            // 获取一个字符
            char c = value.charAt(i);
            // 判断是否为中文字符
            if (isChinese(c)) {
                // 中文字符长度为2
                valueLength += 2;
            } else {
                // 其他字符长度为1
                valueLength += 1;
            }
        }
        // 进位取整
        return valueLength;
    }

    /**
     * 用来判断字符串中是否含有中文
     * @param str
     * @return
     */
    public static boolean hasChineseString(String str){
        for(int i = 0;i<str.length();i++){
            if (isChinese(str.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    /**
     * 判断是否为中文字或英文字母。
     *
     * @param c
     *
     * @return 是则返回true 不是则返回false
     *
     * @author Perry
     */
    public static boolean isChineseOrLetter(char c) {
        int charCode = c;

        if (c == '！' || c == '￥' || c == '…' || c == '（' || c == '）'
                || c == '—' || c == '、' || c == '；' || c == '：' || c == '？'
                || c == '。' || c == '》' || c == '《' || c == '，') {
            return false;
        }
        // ａ~ｚ 双字节字母
        if (charCode >= 65345 && charCode <= 65370) {
            return false;
        } else {
            if (isChinese(c)) {
                return true;
            } else if ((c >= 'a' && c <= 'z') || (c >= 'A' && c <= 'Z')) {
                return true;
            }
        }
        return false;
    }

    private static boolean isChinese(char c){
        Character.UnicodeBlock ub = Character.UnicodeBlock.of(c);
        if (ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_COMPATIBILITY_IDEOGRAPHS
                || ub == Character.UnicodeBlock.CJK_UNIFIED_IDEOGRAPHS_EXTENSION_A
                || ub == Character.UnicodeBlock.GENERAL_PUNCTUATION
                || ub == Character.UnicodeBlock.CJK_SYMBOLS_AND_PUNCTUATION
                || ub == Character.UnicodeBlock.HALFWIDTH_AND_FULLWIDTH_FORMS) {
            return true;
        }
        return false;
    }

}
