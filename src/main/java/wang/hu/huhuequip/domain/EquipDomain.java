/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.cglib.beans.BeanCopier;

import wang.hu.huhuequip.dao.db.EquipMapper;
import wang.hu.huhuequip.entity.EquipEntity;
import wang.hu.huhuequip.util.MapperLocator;
import wang.hu.huhuequip.util.PageModel;
import wang.hu.huhuequip.util.PageUtil;
import wang.hu.huhuequip.vo.EquipVO;

/**
 * TODO Comment of EquipDomain
 * 
 * @author chong.zhu
 */
public class EquipDomain {

    private static final EquipMapper equipMapper          = MapperLocator.getEquipMapper();
    private static final BeanCopier  equipEntity2VOCopier = BeanCopier.create(EquipEntity.class, EquipVO.class, false);
    private static final BeanCopier  equipVO2EntityCopier = BeanCopier.create(EquipVO.class, EquipEntity.class, false);

    private int                      id;
    private int                      specialtyId;

    private List<EquipVO>            equipVOs;

    public EquipDomain() {

    }

    public EquipDomain(int id) {
        this.id = id;
    }

    public EquipDomain(List<EquipVO> equipVOs) {
        this.equipVOs = equipVOs;
    }

    public EquipVO loadEquip() {
        EquipEntity equip = equipMapper.loadEquip(id);
        return convertEntity2VO(equip);
    }

    public List<EquipVO> findEquipsBySpecialtyId(int page, int limit) {
        List<EquipEntity> equips = equipMapper.findEquipsBySpecialtyId(specialtyId, page, limit);
        return convertEntitys2VOs(equips);
    }

    public void addEquips() {
        if (CollectionUtils.isEmpty(equipVOs)) {
            return;
        }

        for (EquipVO equipVO : equipVOs) {
            equipMapper.addEquip(convertVO2Entity(equipVO));
        }
    }

    public PageModel paginateEquipsBySpecialtyId(int page, int limit) {
        List<EquipEntity> equips = equipMapper.findEquipsBySpecialtyId(specialtyId, (page - 1) * limit, limit);
        if (CollectionUtils.isEmpty(equips)) {
            return null;
        }

        int recordCount = equipMapper.getEquipCountBySpecialtyId(specialtyId);
        if (recordCount == 0) {
            return null;
        }

        return PageUtil.convertPage(convertEntitys2VOs(equips), recordCount, page, limit);
    }

    public PageModel paginateAllEquips(int page, int limit) {
        List<EquipEntity> equips = equipMapper.findAllEquips((page - 1) * limit, limit);
        if (CollectionUtils.isEmpty(equips)) {
            return null;
        }

        int recordCount = equipMapper.getAllEquipCount();
        if (recordCount == 0) {
            return null;
        }

        return PageUtil.convertPage(convertEntitys2VOs(equips), recordCount, page, limit);
    }

    private List<EquipVO> convertEntitys2VOs(List<EquipEntity> equips) {
        if (CollectionUtils.isEmpty(equips)) {
            return Collections.emptyList();
        }

        List<EquipVO> equipVOs = new ArrayList<EquipVO>(equips.size());
        for (EquipEntity equip : equips) {
            equipVOs.add(convertEntity2VO(equip));
        }

        return equipVOs;
    }

    private EquipVO convertEntity2VO(EquipEntity equip) {
        if (equip == null) {
            return null;
        }

        EquipVO equipVO = new EquipVO();
        equipEntity2VOCopier.copy(equip, equipVO, null);
        return equipVO;
    }

    private EquipEntity convertVO2Entity(EquipVO equipVO) {
        EquipEntity equip = new EquipEntity();
        equipVO2EntityCopier.copy(equipVO, equip, null);
        return equip;
    }

    /**
     * @param specialtyId the specialtyId to set
     */
    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }
}
