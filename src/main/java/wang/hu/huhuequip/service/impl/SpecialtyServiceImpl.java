/**
 * Project: huhuequip File Created at 2014-3-14 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.service.impl;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import wang.hu.huhuequip.domain.SpecialtyDomain;
import wang.hu.huhuequip.service.SpecialtyService;
import wang.hu.huhuequip.vo.SpecialtyVO;

/**
 * TODO Comment of SpecialtyServiceImpl
 * 
 * @author chong.zhu
 */
public class SpecialtyServiceImpl implements SpecialtyService {

    @Override
    public List<SpecialtyVO> findAllSpecialty() {
        SpecialtyDomain specialtyDomain = new SpecialtyDomain();
        return specialtyDomain.findAllSpecialty();
    }

    @Override
    public void addSpecialtys(List<SpecialtyVO> specialtyVOs) {
        if (CollectionUtils.isEmpty(specialtyVOs)) {
            return;
        }

        SpecialtyDomain specialtyDomain = new SpecialtyDomain(specialtyVOs);
        specialtyDomain.addSpecialtys();
    }

    @Override
    public SpecialtyVO loadSpecialtyByName(String name) {
        SpecialtyDomain specialtyDomain = new SpecialtyDomain(name);
        return specialtyDomain.loadSpecialtyByName();
    }

}
