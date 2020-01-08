package com.zscat.mall.admin.validator;

import java.awt.*;
import java.io.ByteArrayInputStream;

/**
 * @ClassName ImgFontByte
 * @Description: 验证字体样式类
 * @Author 张古良
 * @Date 2019/12/21 10:01
 **/
public class ImgFontByte {

    public Font getFont(int fontHeight){
        try {
            Font baseFont = Font.createFont(Font.HANGING_BASELINE, new ByteArrayInputStream(hex2byte(getFontByteStr())));
            return baseFont.deriveFont(Font.PLAIN, fontHeight);
        }catch (Exception e){
            return new Font("Arial", Font.PLAIN, fontHeight);
        }
    }
    private byte[] hex2byte(String str) {
        if (str == null)return null;
        str = str.trim();
        int len = str.length();
        if (len == 0 || len % 2 == 1)return null;
        byte[] b = new byte[len / 2];
        try {
            for (int i = 0; i < str.length(); i += 2) {
                b[i / 2] = (byte) Integer.decode("0x" + str.substring(i, i + 2)).intValue();
            }
            return b;
        }catch (Exception e){
            return null;
        }
    }
    // 字体文件的十六进制字符串
    private String getFontByteStr() {
        //防止报字符串长度过长错误，改为从配置文件读取
        return ReadFontByteProperties.getFontByteStr();
    }
}
