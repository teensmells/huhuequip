/**
 * Project: huhuequip File Created at 2014年4月27日 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.action;

import org.apache.commons.lang3.StringUtils;

import wang.hu.huhuequip.service.EquipService;
import wang.hu.huhuequip.service.SpecialtyService;
import wang.hu.huhuequip.util.ServiceLocator;
import wang.hu.huhuequip.vo.EquipVO;
import wang.hu.huhuequip.vo.SpecialtyVO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO Comment of EquipAddAction
 * 
 * @author zhuchong
 */
public class EquipAddAction extends ActionSupport {

    /**
     * 
     */
    private static final long serialVersionUID = -1517996378659258771L;

    // 输入参数
    private String            name;
    private String            priceYear;
    private String            specification;
    private String            techParams;
    private String            unit;
    private String            unitPriceStr;
    private String            priceSource;
    private String            contractNo;
    private String            project;
    private String            subProject;
    private String            specialtyName;
    private String            supplierAndContact;
    private String            memo;

    private EquipService      equipService     = ServiceLocator.getEquipService();
    private SpecialtyService  specialtyService = ServiceLocator.getSpecialtyService();

    // 输出参数
    private String            msg;
    private int               code;

    @Override
    public String execute() {
        if (!checkParams()) {
            code = 500;
            msg = "参数错误";
            return SUCCESS;
        }

        SpecialtyVO specialtyVO = specialtyService.loadSpecialtyByName(specialtyName);
        if (specialtyVO == null) {
            code = 500;
            msg = "专业未添加过，若需要添加，请联系朱翀";
            return SUCCESS;
        }

        EquipVO equip = packEquipVO(specialtyVO);
        equipService.addEquip(equip);
        code = 200;
        msg = "保存成功";
        return SUCCESS;
    }

    /**
     * @param specialtyVO
     * @return
     */
    private EquipVO packEquipVO(SpecialtyVO specialtyVO) {
        EquipVO equipVO = new EquipVO();
        equipVO.setName(name);
        equipVO.setPriceYear(StringUtils.isEmpty(priceYear) ? "" : priceYear);
        equipVO.setSpecification(StringUtils.isEmpty(specification) ? "" : specification);
        equipVO.setTechParams(StringUtils.isEmpty(techParams) ? "" : techParams);
        equipVO.setUnit(StringUtils.isEmpty(unit) ? "" : unit);
        equipVO.setUnitPrice(StringUtils.isEmpty(unitPriceStr) ? 0 : Double.parseDouble(unitPriceStr));
        equipVO.setPriceSource(StringUtils.isEmpty(priceSource) ? "" : priceSource);
        equipVO.setContractNo(StringUtils.isEmpty(contractNo) ? "" : contractNo);
        equipVO.setProject(StringUtils.isEmpty(project) ? "" : project);
        equipVO.setSubProject(StringUtils.isEmpty(subProject) ? "" : subProject);
        equipVO.setSpecialtyId(specialtyVO.getId());
        equipVO.setSpecialtyName(specialtyName);
        equipVO.setSupplierAndContact(StringUtils.isEmpty(supplierAndContact) ? "" : supplierAndContact);
        equipVO.setMemo(StringUtils.isEmpty(memo) ? "" : memo);
        return equipVO;
    }

    /**
     * 
     */
    private boolean checkParams() {
        if (StringUtils.isEmpty(name)) {
            return false;
        }

        if (StringUtils.isEmpty(specialtyName)) {
            return false;
        }
        return true;
    }

    /**
     * @return the msg
     */
    public String getMsg() {
        return msg;
    }

    /**
     * @param msg the msg to set
     */
    public void setMsg(String msg) {
        this.msg = msg;
    }

    /**
     * @return the code
     */
    public int getCode() {
        return code;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @param priceYear the priceYear to set
     */
    public void setPriceYear(String priceYear) {
        this.priceYear = priceYear;
    }

    /**
     * @param specification the specification to set
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @param techParams the techParams to set
     */
    public void setTechParams(String techParams) {
        this.techParams = techParams;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @param unitPriceStr the unitPriceStr to set
     */
    public void setUnitPriceStr(String unitPriceStr) {
        this.unitPriceStr = unitPriceStr;
    }

    /**
     * @param priceSource the priceSource to set
     */
    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource;
    }

    /**
     * @param contractNo the contractNo to set
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * @param project the project to set
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @param subProject the subProject to set
     */
    public void setSubProject(String subProject) {
        this.subProject = subProject;
    }

    /**
     * @param specialtyName the specialtyName to set
     */
    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    /**
     * @param supplierAndContact the supplierAndContact to set
     */
    public void setSupplierAndContact(String supplierAndContact) {
        this.supplierAndContact = supplierAndContact;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }
}
