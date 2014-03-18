/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.dao.datasource;

import java.io.File;
import java.util.List;

import wang.hu.huhuequip.vo.EquipVO;

/**
 * TODO Comment of EquipmentSource
 * 
 * @author chong.zhu
 */
public interface EquipSource {

    /**
     * 读取设备数据来源
     * 
     * @param dataSource
     * @return
     */
    List<EquipVO> readEquip(File dataSource);
}
