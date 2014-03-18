/**
 * Project: huhuequip File Created at 2014-3-14 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
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

import wang.hu.huhuequip.dao.db.SpecialtyMapper;
import wang.hu.huhuequip.entity.SpecialtyEntity;
import wang.hu.huhuequip.util.MapperLocator;
import wang.hu.huhuequip.vo.SpecialtyVO;

/**
 * TODO Comment of SpecialtyDomain
 * 
 * @author chong.zhu
 */
public class SpecialtyDomain {

    private static final SpecialtyMapper specialtyMapper          = MapperLocator.getSpecialtyMapper();
    private static final BeanCopier      specialtyEntity2VOCopier = BeanCopier.create(SpecialtyEntity.class,
                                                                                      SpecialtyVO.class, false);
    private static final BeanCopier      specialtyVO2EntityCopier = BeanCopier.create(SpecialtyVO.class,
                                                                                      SpecialtyEntity.class, false);

    private int                          id;

    private String                       specialtyName;

    private List<SpecialtyVO>            specialtyVOs;

    public SpecialtyDomain() {

    }

    public SpecialtyDomain(int id) {
        this.id = id;
    }

    public SpecialtyDomain(List<SpecialtyVO> specialtyVOs) {
        this.specialtyVOs = specialtyVOs;
    }

    public SpecialtyDomain(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    public SpecialtyVO loadSpecialty() {
        SpecialtyEntity specialty = specialtyMapper.loadSpecialty(id);
        if (specialty == null) {
            return null;
        }

        SpecialtyVO specialtyVO = new SpecialtyVO();
        specialtyEntity2VOCopier.copy(specialty, specialtyVO, null);
        return specialtyVO;
    }

    public List<SpecialtyVO> findAllSpecialty() {
        List<SpecialtyEntity> specialtys = specialtyMapper.findAllSpecialty();
        if (CollectionUtils.isEmpty(specialtys)) {
            return Collections.emptyList();
        }

        return convertEntitys2VOs(specialtys);
    }

    public void addSpecialtys() {
        if (CollectionUtils.isEmpty(specialtyVOs)) {
            return;
        }

        for (SpecialtyVO specialtyVO : specialtyVOs) {
            SpecialtyEntity specialty = new SpecialtyEntity();
            specialtyVO2EntityCopier.copy(specialtyVO, specialty, null);
            specialtyMapper.addSpecialty(specialty);
        }
    }

    public SpecialtyVO loadSpecialtyByName() {
        SpecialtyEntity specialty = specialtyMapper.loadSpecialtyByName(specialtyName);
        return convertEntity2VO(specialty);
    }

    private SpecialtyVO convertEntity2VO(SpecialtyEntity specialty) {
        if (specialty == null) {
            return null;
        }

        SpecialtyVO specialtyVO = new SpecialtyVO();
        specialtyEntity2VOCopier.copy(specialty, specialtyVO, null);
        return specialtyVO;
    }

    private List<SpecialtyVO> convertEntitys2VOs(List<SpecialtyEntity> specialtys) {
        if (CollectionUtils.isEmpty(specialtys)) {
            return Collections.emptyList();
        }

        List<SpecialtyVO> specialtyVOs = new ArrayList<SpecialtyVO>(specialtys.size());
        for (SpecialtyEntity specialty : specialtys) {
            specialtyVOs.add(convertEntity2VO(specialty));
        }
        return specialtyVOs;
    }
}
