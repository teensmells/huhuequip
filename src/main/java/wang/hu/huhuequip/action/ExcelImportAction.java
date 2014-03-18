/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.action;

import java.io.File;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import wang.hu.huhuequip.dao.datasource.EquipSource;
import wang.hu.huhuequip.dao.datasource.SourceFactory;
import wang.hu.huhuequip.service.EquipService;
import wang.hu.huhuequip.service.SpecialtyService;
import wang.hu.huhuequip.util.ServiceLocator;
import wang.hu.huhuequip.vo.EquipVO;
import wang.hu.huhuequip.vo.SpecialtyVO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO Comment of AddEquipmentFromExcelAjaxAction
 * 
 * @author chong.zhu
 */
public class ExcelImportAction extends ActionSupport {

    /**
     * 
     */
    private static final long   serialVersionUID = 4781261195124005601L;

    private static final String ADD_SUCCESS      = "addsuccess";

    private File                excelFile;
    private String              msg;

    private EquipSource         equipSource      = SourceFactory.getEquipmentSource("excel");

    private EquipService        equipService     = ServiceLocator.getEquipService();
    private SpecialtyService    specialtyService = ServiceLocator.getSpecialtyService();

    @Override
    public String execute() {
        if (excelFile == null) {
            return SUCCESS;
        }

        List<EquipVO> equipVOs = equipSource.readEquip(excelFile);
        if (CollectionUtils.isEmpty(equipVOs)) {
            msg = "read excel fail or excel is empty. contact chong.zhu";
            return SUCCESS;
        }

        Set<String> specialtyNames = fillSpecialtyId(equipVOs);
        List<SpecialtyVO> specialtyVOs = convert2VOs(specialtyNames);

        equipService.addEquips(equipVOs);
        specialtyService.addSpecialtys(specialtyVOs);

        return ADD_SUCCESS;
    }

    /**
     * @param specialtyNames
     * @return
     */
    private List<SpecialtyVO> convert2VOs(Set<String> specialtyNames) {
        List<SpecialtyVO> specialtyVOs = new ArrayList<SpecialtyVO>(specialtyNames.size());
        for (String specialtyName : specialtyNames) {
            SpecialtyVO specialtyVO = new SpecialtyVO();
            specialtyVO.setSpecialtyName(specialtyName);
            specialtyVOs.add(specialtyVO);
        }
        return specialtyVOs;
    }

    /**
     * @param equipVOs
     */
    private Set<String> fillSpecialtyId(List<EquipVO> equipVOs) {
        Set<String> specialtyNames = new HashSet<String>();

        for (EquipVO equipVO : equipVOs) {
            if (StringUtils.isEmpty(equipVO.getSpecialtyName())) {
                continue;
            }

            SpecialtyVO specialtyVO = specialtyService.loadSpecialtyByName(equipVO.getSpecialtyName());
            if (specialtyVO == null) {
                specialtyNames.add(equipVO.getSpecialtyName());
                continue;
            }
            equipVO.setSpecialtyId(specialtyVO.getId());
        }

        return specialtyNames;
    }

    /**
     * @param excelFile the excelFile to set
     */
    public void setExcelFile(File excelFile) {
        this.excelFile = excelFile;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

}
