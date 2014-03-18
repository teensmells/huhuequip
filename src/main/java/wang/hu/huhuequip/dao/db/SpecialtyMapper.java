/**
 * Project: huhuequip File Created at 2014-3-14 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.dao.db;

import java.util.List;

import wang.hu.huhuequip.entity.SpecialtyEntity;

/**
 * TODO Comment of SpecialtyMapper
 * 
 * @author chong.zhu
 */
public interface SpecialtyMapper {

    SpecialtyEntity loadSpecialty(int id);

    List<SpecialtyEntity> findAllSpecialty();

    void addSpecialty(SpecialtyEntity specialty);

    SpecialtyEntity loadSpecialtyByName(String name);
}
