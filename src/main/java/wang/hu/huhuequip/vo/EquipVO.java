/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.vo;

import java.util.Date;

/**
 * TODO Comment of EquipmentVO
 * 
 * @author chong.zhu
 */
public class EquipVO {

    private int    id;
    private String priceYear;
    private String name;
    private String specification;
    private String techParams;
    private String unit;
    private double unitPrice;
    private String priceSource;
    private String contractNo;
    private String project;
    private String subProject;
    private int    specialtyId;
    private String specialtyName;
    private String supplierAndContact;
    private String memo;
    private Date   addTime;
    private Date   updateTime;

    private String cutPriceYear;
    private String cutName;
    private String cutSpecification;
    private String cutTechParams;
    private String cutUnit;
    private String cutPriceSource;
    private String cutContractNo;
    private String cutProject;
    private String cutSubProject;
    private String cutSpecialtyName;
    private String cutSupplierAndContact;
    private String cutMemo;

    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    /**
     * @param id the id to set
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * @return the priceYear
     */
    public String getPriceYear() {
        return priceYear;
    }

    /**
     * @param priceYear the priceYear to set
     */
    public void setPriceYear(String priceYear) {
        this.priceYear = priceYear;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the specification
     */
    public String getSpecification() {
        return specification;
    }

    /**
     * @param specification the specification to set
     */
    public void setSpecification(String specification) {
        this.specification = specification;
    }

    /**
     * @return the techParams
     */
    public String getTechParams() {
        return techParams;
    }

    /**
     * @param techParams the techParams to set
     */
    public void setTechParams(String techParams) {
        this.techParams = techParams;
    }

    /**
     * @return the unit
     */
    public String getUnit() {
        return unit;
    }

    /**
     * @param unit the unit to set
     */
    public void setUnit(String unit) {
        this.unit = unit;
    }

    /**
     * @return the unitPrice
     */
    public double getUnitPrice() {
        return unitPrice;
    }

    /**
     * @param unitPrice the unitPrice to set
     */
    public void setUnitPrice(double unitPrice) {
        this.unitPrice = unitPrice;
    }

    /**
     * @return the priceSource
     */
    public String getPriceSource() {
        return priceSource;
    }

    /**
     * @param priceSource the priceSource to set
     */
    public void setPriceSource(String priceSource) {
        this.priceSource = priceSource;
    }

    /**
     * @return the contractNo
     */
    public String getContractNo() {
        return contractNo;
    }

    /**
     * @param contractNo the contractNo to set
     */
    public void setContractNo(String contractNo) {
        this.contractNo = contractNo;
    }

    /**
     * @return the project
     */
    public String getProject() {
        return project;
    }

    /**
     * @param project the project to set
     */
    public void setProject(String project) {
        this.project = project;
    }

    /**
     * @return the subProject
     */
    public String getSubProject() {
        return subProject;
    }

    /**
     * @param subProject the subProject to set
     */
    public void setSubProject(String subProject) {
        this.subProject = subProject;
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
     * @return the specialtyName
     */
    public String getSpecialtyName() {
        return specialtyName;
    }

    /**
     * @param specialtyName the specialtyName to set
     */
    public void setSpecialtyName(String specialtyName) {
        this.specialtyName = specialtyName;
    }

    /**
     * @return the supplierAndContact
     */
    public String getSupplierAndContact() {
        return supplierAndContact;
    }

    /**
     * @param supplierAndContact the supplierAndContact to set
     */
    public void setSupplierAndContact(String supplierAndContact) {
        this.supplierAndContact = supplierAndContact;
    }

    /**
     * @return the memo
     */
    public String getMemo() {
        return memo;
    }

    /**
     * @param memo the memo to set
     */
    public void setMemo(String memo) {
        this.memo = memo;
    }

    /**
     * @return the addTime
     */
    public Date getAddTime() {
        return addTime;
    }

    /**
     * @param addTime the addTime to set
     */
    public void setAddTime(Date addTime) {
        this.addTime = addTime;
    }

    /**
     * @return the updateTime
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * @param updateTime the updateTime to set
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * @return the cutPriceYear
     */
    public String getCutPriceYear() {
        return cutPriceYear;
    }

    /**
     * @param cutPriceYear the cutPriceYear to set
     */
    public void setCutPriceYear(String cutPriceYear) {
        this.cutPriceYear = cutPriceYear;
    }

    /**
     * @return the cutName
     */
    public String getCutName() {
        return cutName;
    }

    /**
     * @param cutName the cutName to set
     */
    public void setCutName(String cutName) {
        this.cutName = cutName;
    }

    /**
     * @return the cutSpecification
     */
    public String getCutSpecification() {
        return cutSpecification;
    }

    /**
     * @param cutSpecification the cutSpecification to set
     */
    public void setCutSpecification(String cutSpecification) {
        this.cutSpecification = cutSpecification;
    }

    /**
     * @return the cutTechParams
     */
    public String getCutTechParams() {
        return cutTechParams;
    }

    /**
     * @param cutTechParams the cutTechParams to set
     */
    public void setCutTechParams(String cutTechParams) {
        this.cutTechParams = cutTechParams;
    }

    /**
     * @return the cutUnit
     */
    public String getCutUnit() {
        return cutUnit;
    }

    /**
     * @param cutUnit the cutUnit to set
     */
    public void setCutUnit(String cutUnit) {
        this.cutUnit = cutUnit;
    }

    /**
     * @return the cutPriceSource
     */
    public String getCutPriceSource() {
        return cutPriceSource;
    }

    /**
     * @param cutPriceSource the cutPriceSource to set
     */
    public void setCutPriceSource(String cutPriceSource) {
        this.cutPriceSource = cutPriceSource;
    }

    /**
     * @return the cutContractNo
     */
    public String getCutContractNo() {
        return cutContractNo;
    }

    /**
     * @param cutContractNo the cutContractNo to set
     */
    public void setCutContractNo(String cutContractNo) {
        this.cutContractNo = cutContractNo;
    }

    /**
     * @return the cutProject
     */
    public String getCutProject() {
        return cutProject;
    }

    /**
     * @param cutProject the cutProject to set
     */
    public void setCutProject(String cutProject) {
        this.cutProject = cutProject;
    }

    /**
     * @return the cutSubProject
     */
    public String getCutSubProject() {
        return cutSubProject;
    }

    /**
     * @param cutSubProject the cutSubProject to set
     */
    public void setCutSubProject(String cutSubProject) {
        this.cutSubProject = cutSubProject;
    }

    /**
     * @return the cutSpecialtyName
     */
    public String getCutSpecialtyName() {
        return cutSpecialtyName;
    }

    /**
     * @param cutSpecialtyName the cutSpecialtyName to set
     */
    public void setCutSpecialtyName(String cutSpecialtyName) {
        this.cutSpecialtyName = cutSpecialtyName;
    }

    /**
     * @return the cutSupplierAndContact
     */
    public String getCutSupplierAndContact() {
        return cutSupplierAndContact;
    }

    /**
     * @param cutSupplierAndContact the cutSupplierAndContact to set
     */
    public void setCutSupplierAndContact(String cutSupplierAndContact) {
        this.cutSupplierAndContact = cutSupplierAndContact;
    }

    /**
     * @return the cutMemo
     */
    public String getCutMemo() {
        return cutMemo;
    }

    /**
     * @param cutMemo the cutMemo to set
     */
    public void setCutMemo(String cutMemo) {
        this.cutMemo = cutMemo;
    }

}
