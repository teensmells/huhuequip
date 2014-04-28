/**
 * Project: huhuequip File Created at 2014-3-13 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.service;

import java.util.List;

import wang.hu.huhuequip.util.PageModel;
import wang.hu.huhuequip.vo.EquipVO;

/**
 * TODO Comment of EquipService
 * 
 * @author chong.zhu
 */
public interface EquipService {

    EquipVO loadEquipVO(int id);

    void addEquips(List<EquipVO> equipVOs);
    
    void addEquip(EquipVO equipVO);

    PageModel paginateAllEquip(int page, int limit);

    PageModel paginateEquipBySpecialtyId(int specialtyId, int page, int limit);

    void updateEquipVO(EquipVO equip);
}
