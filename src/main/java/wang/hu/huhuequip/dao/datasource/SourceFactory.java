/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.dao.datasource;

/**
 * TODO Comment of SourceFactory
 * 
 * @author chong.zhu
 */
public class SourceFactory {

    public static EquipSource getEquipmentSource(String sourceType) {
        if (sourceType.equals("excel")) {
            return new ExcelEquipSource();
        }

        return null;
    }
}
