/**
 * Project: huhuequip File Created at 2014-3-6 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.action;

import java.util.List;

import org.apache.commons.lang3.StringUtils;

import wang.hu.huhuequip.service.EquipService;
import wang.hu.huhuequip.service.SpecialtyService;
import wang.hu.huhuequip.util.PageModel;
import wang.hu.huhuequip.util.ServiceLocator;
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

    private String                        method;
    private int                           specialtyId;
    private int                           page;

    private static final int              LIMIT            = 20;

    @Override
    public String execute() {
        if (StringUtils.isEmpty(method)) {
            pageModel = equipService.paginateAllEquip(page == 0 ? 1 : page, LIMIT);
        } else {
            pageModel = equipService.paginateEquipBySpecialtyId(specialtyId, page == 0 ? 1 : page, LIMIT);
        }

        specialtyVOs = specialtyService.findAllSpecialty();
        return SUCCESS;
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
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * @param method the method to set
     */
    public void setMethod(String method) {
        this.method = method;
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
