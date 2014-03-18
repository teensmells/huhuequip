/**
 * Project: huhuequip File Created at 2014-3-13 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.util;

import wang.hu.huhuequip.service.EquipService;
import wang.hu.huhuequip.service.SpecialtyService;

/**
 * TODO Comment of ServiceLocator
 * 
 * @author chong.zhu
 */
public class ServiceLocator extends SpringBeanLocator {

    public static EquipService getEquipService() {
        return (EquipService) getBean("equipService");
    }

    public static SpecialtyService getSpecialtyService() {
        return (SpecialtyService) getBean("specialtyService");
    }
}
