/**
 * Project: huhuequip File Created at 2014-3-13 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import wang.hu.huhuequip.domain.EquipDomain;
import wang.hu.huhuequip.domain.SpecialtyDomain;
import wang.hu.huhuequip.service.EquipService;
import wang.hu.huhuequip.util.PageModel;
import wang.hu.huhuequip.vo.EquipVO;
import wang.hu.huhuequip.vo.SpecialtyVO;

/**
 * TODO Comment of EquipServiceImpl
 * 
 * @author chong.zhu
 */
public class EquipServiceImpl implements EquipService {

    @Override
    public EquipVO loadEquipVO(int id) {
        EquipDomain equipDomain = new EquipDomain(id);
        EquipVO equipVO = equipDomain.loadEquip();

        fillSpecialName(equipVO);
        return equipVO;
    }

    private void fillSpecialName(EquipVO equipVO) {
        if (equipVO == null) {
            return;
        }

        SpecialtyDomain specialtyDomain = new SpecialtyDomain(equipVO.getSpecialtyId());
        SpecialtyVO specialtyVO = specialtyDomain.loadSpecialty();
        if (specialtyVO == null) {
            return;
        }

        equipVO.setSpecialtyName(specialtyVO.getSpecialtyName());
    }

    @Override
    public void addEquips(List<EquipVO> equipVOs) {
        if (CollectionUtils.isEmpty(equipVOs)) {
            return;
        }

        EquipDomain equipDomain = new EquipDomain(equipVOs);
        equipDomain.addEquips();
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageModel paginateEquipBySpecialtyId(int specialtyId, int page, int limit) {
        EquipDomain equipDomain = new EquipDomain();
        equipDomain.setSpecialtyId(specialtyId);
        PageModel pageModel = equipDomain.paginateEquipsBySpecialtyId(page, limit);
        if (pageModel == null) {
            return null;
        }

        for (EquipVO equipVO : (List<EquipVO>) pageModel.getList()) {
            fillSpecialName(equipVO);
        }
        return pageModel;
    }

    @SuppressWarnings("unchecked")
    @Override
    public PageModel paginateAllEquip(int page, int limit) {
        EquipDomain equipDomain = new EquipDomain();
        PageModel pageModel = equipDomain.paginateAllEquips(page, limit);
        if (pageModel == null) {
            return null;
        }

        for (EquipVO equipVO : (List<EquipVO>) pageModel.getList()) {
            fillSpecialName(equipVO);
        }
        return pageModel;
    }

    @Override
    public void updateEquipVO(EquipVO equip) {
        EquipDomain equipDomain = new EquipDomain(equip);
        equipDomain.updateEquip();
    }

    @Override
    public void addEquip(EquipVO equip) {
        EquipDomain equipDomain = new EquipDomain(equip);
        equipDomain.addEquip();
    }
}
