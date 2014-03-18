/**
 * Project: huhuequip File Created at 2014-3-14 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.dao.db;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import wang.hu.huhuequip.entity.EquipEntity;

/**
 * TODO Comment of EquipMapper
 * 
 * @author chong.zhu
 */
public interface EquipMapper {

    public EquipEntity loadEquip(int id);

    public List<EquipEntity> findAllEquips(@Param("startIndex")
    int startIndex, @Param("limit")
    int limit);

    public int getAllEquipCount();

    public List<EquipEntity> findEquipsBySpecialtyId(@Param("specialtyId")
    int specialtyId, @Param("startIndex")
    int startIndex, @Param("limit")
    int limit);

    public int getEquipCountBySpecialtyId(int specialtyId);

    public void addEquip(EquipEntity equip);

}
