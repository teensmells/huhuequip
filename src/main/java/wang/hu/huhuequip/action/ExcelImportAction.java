/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.action;

import java.io.File;
import java.util.List;

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
    private String              upload;
    private String              excelFileName;

    private EquipSource         equipSource      = SourceFactory.getEquipmentSource("excel");

    private EquipService        equipService     = ServiceLocator.getEquipService();
    private SpecialtyService    specialtyService = ServiceLocator.getSpecialtyService();

    @Override
    public String execute() {
        if (StringUtils.isEmpty(upload)) {
            return SUCCESS;
        }

        if (excelFile == null || StringUtils.isEmpty(excelFileName)) {
            msg = "上传失败，请联系朱翀";
            return SUCCESS;
        }

        if (!excelFileName.endsWith("xls")) {
            msg = "只支持上传xls文件";
            return SUCCESS;
        }

        List<EquipVO> equipVOs = equipSource.readEquip(excelFile);
        if (CollectionUtils.isEmpty(equipVOs)) {
            msg = "读取excel失败，或excel为空，请联系朱翀";
            return SUCCESS;
        }

        fillSpecialtyId(equipVOs);
        equipService.addEquips(equipVOs);

        return ADD_SUCCESS;
    }

    /**
     * @param specialtyNames
     * @return
     */
    private SpecialtyVO convert2VO(String specialtyName) {
        SpecialtyVO specialtyVO = new SpecialtyVO();
        specialtyVO.setSpecialtyName(specialtyName);
        return specialtyVO;
    }

    /**
     * @param equipVOs
     */
    private void fillSpecialtyId(List<EquipVO> equipVOs) {
        for (EquipVO equipVO : equipVOs) {
            if (StringUtils.isEmpty(equipVO.getSpecialtyName())) {
                continue;
            }

            SpecialtyVO specialtyVO = specialtyService.loadSpecialtyByName(equipVO.getSpecialtyName());
            if (specialtyVO == null) {
                int id = specialtyService.addSpecialty(convert2VO(equipVO.getSpecialtyName()));
                if (id == 0) {
                    continue;
                }
                equipVO.setSpecialtyId(id);
            } else {
                equipVO.setSpecialtyId(specialtyVO.getId());
            }
        }

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

    /**
     * @return the upload
     */
    public String getUpload() {
        return upload;
    }

    /**
     * @param upload the upload to set
     */
    public void setUpload(String upload) {
        this.upload = upload;
    }

    /**
     * @return the excelFileName
     */
    public String getExcelFileName() {
        return excelFileName;
    }

    /**
     * @param excelFileName the excelFileName to set
     */
    public void setExcelFileName(String excelFileName) {
        this.excelFileName = excelFileName;
    }

}
