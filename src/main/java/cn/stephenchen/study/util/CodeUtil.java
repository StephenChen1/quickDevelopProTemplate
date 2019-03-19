package cn.stephenchen.study.util;

import org.springframework.util.DigestUtils;

/**
 * @Author : chenzhulin
 * @Date : 2019/1/24 09 21
 * @Description :  编码工具类
 */
public class CodeUtil {

    public static String generateMagicId(String objStr){

        System.out.println("magicId : " + DigestUtils.md5DigestAsHex(objStr.getBytes()));
        return DigestUtils.md5DigestAsHex(objStr.getBytes());

    }

}
