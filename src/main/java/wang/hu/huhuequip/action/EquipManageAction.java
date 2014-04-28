/**
 * Project: huhuequip File Created at 2014-3-6 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.action;

import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.commons.collections.CollectionUtils;

import wang.hu.huhuequip.service.EquipService;
import wang.hu.huhuequip.service.SpecialtyService;
import wang.hu.huhuequip.util.PageModel;
import wang.hu.huhuequip.util.ServiceLocator;
import wang.hu.huhuequip.util.StringUtil;
import wang.hu.huhuequip.vo.EquipVO;
import wang.hu.huhuequip.vo.SpecialtyVO;

import com.opensymphony.xwork2.ActionSupport;

/**
 * TODO Comment of EquipmentManageAction
 * 
 * @author chong.zhu
 */
public class EquipManageAction extends ActionSupport {

    /**
     * 
     */
    private static final long             serialVersionUID = 5439668211173560305L;

    private static final EquipService     equipService     = ServiceLocator.getEquipService();
    private static final SpecialtyService specialtyService = ServiceLocator.getSpecialtyService();

    private PageModel                     pageModel;
    private List<SpecialtyVO>             specialtyVOs;

    private int                           specialtyId;
    private int                           page;

    private static final int              LIMIT            = 20;

    @Override
    public String execute() throws UnsupportedEncodingException {
        if (specialtyId == 0) {
            pageModel = equipService.paginateAllEquip(page == 0 ? 1 : page, LIMIT);
        } else {
            pageModel = equipService.paginateEquipBySpecialtyId(specialtyId, page == 0 ? 1 : page, LIMIT);
        }

        specialtyVOs = specialtyService.findAllSpecialty();

        cutStr();

        return SUCCESS;
    }

    /**
     * @throws UnsupportedEncodingException
     */
    @SuppressWarnings("unchecked")
    private void cutStr() throws UnsupportedEncodingException {
        if (pageModel == null || CollectionUtils.isEmpty(pageModel.getList())) {
            return;
        }

        for (EquipVO equipVO : (List<EquipVO>) pageModel.getList()) {
            equipVO.setCutContractNo(StringUtil.cutString(equipVO.getContractNo(), 9));
            equipVO.setCutMemo(StringUtil.cutString(equipVO.getMemo(), 3));
            equipVO.setCutName(StringUtil.cutString(equipVO.getName(), 9));
            equipVO.setCutPriceSource(StringUtil.cutString(equipVO.getPriceSource(), 9));
            equipVO.setCutPriceYear(StringUtil.cutString(equipVO.getPriceYear(), 9));
            equipVO.setCutProject(StringUtil.cutString(equipVO.getProject(), 6));
            equipVO.setCutSpecialtyName(StringUtil.cutString(equipVO.getSpecialtyName(), 3));
            equipVO.setCutSpecification(StringUtil.cutString(equipVO.getSpecification(), 9));
            equipVO.setCutSubProject(StringUtil.cutString(equipVO.getSubProject(), 9));
            equipVO.setCutSupplierAndContact(StringUtil.cutString(equipVO.getSupplierAndContact(), 6));
            equipVO.setCutTechParams(StringUtil.cutString(equipVO.getTechParams(), 9));
            equipVO.setCutUnit(StringUtil.cutString(equipVO.getUnit(), 3));
        }
    }

    /**
     * @return the pageModel
     */
    public PageModel getPageModel() {
        return pageModel;
    }

    /**
     * @return the specialtyVOs
     */
    public List<SpecialtyVO> getSpecialtyVOs() {
        return specialtyVOs;
    }

    /**
     * @return the specialtyId
     */
    public int getSpecialtyId() {
        return specialtyId;
    }

    /**
     * @param specialtyId the specialtyId to set
     */
    public void setSpecialtyId(int specialtyId) {
        this.specialtyId = specialtyId;
    }

    /**
     * @return the page
     */
    public int getPage() {
        return page;
    }

    /**
     * @param page the page to set
     */
    public void setPage(int page) {
        this.page = page;
    }

}
