/**
 * Project: huhuequip File Created at 2014年4月24日 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.util;

import java.io.UnsupportedEncodingException;

import org.apache.commons.lang3.StringUtils;

/**
 * TODO Comment of StringUtil
 * 
 * @author zhuchong
 */
public class StringUtil {

    public static String cutString(String str, int byteCount) throws UnsupportedEncodingException {
        if (StringUtils.isEmpty(str)) {
            return StringUtils.EMPTY;
        }

        StringBuilder sb = new StringBuilder();
        int currentLength = 0;
        for (char c : str.toCharArray()) {
            currentLength += String.valueOf(c).getBytes("UTF-8").length;
            if (currentLength <= byteCount) {
                sb.append(c);
            } else {
                return sb.append("...").toString();
            }
        }
        return sb.toString();
    }
}
