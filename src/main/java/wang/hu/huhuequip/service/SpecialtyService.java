/**
 * Project: huhuequip File Created at 2014-3-14 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.service;

import java.util.List;

import wang.hu.huhuequip.vo.SpecialtyVO;

/**
 * TODO Comment of SpecialtyService
 * 
 * @author chong.zhu
 */
public interface SpecialtyService {

    List<SpecialtyVO> findAllSpecialty();

    void addSpecialtys(List<SpecialtyVO> specialtyVOs);

    SpecialtyVO loadSpecialtyByName(String name);
}
