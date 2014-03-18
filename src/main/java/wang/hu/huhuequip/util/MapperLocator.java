/**
 * Project: huhuequip File Created at 2014-3-14 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.util;

import wang.hu.huhuequip.dao.db.EquipMapper;
import wang.hu.huhuequip.dao.db.SpecialtyMapper;

/**
 * TODO Comment of MapperLocator
 * 
 * @author chong.zhu
 */
public class MapperLocator extends SpringBeanLocator {

    public static EquipMapper getEquipMapper() {
        return getBean("equipMapper");
    }
    
    public static SpecialtyMapper getSpecialtyMapper() {
        return getBean("specialtyMapper");
    }
}
