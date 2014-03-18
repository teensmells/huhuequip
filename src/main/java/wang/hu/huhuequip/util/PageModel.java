/**
 * Project: huhuequip File Created at 2014-3-15 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.util;

import java.util.List;

/**
 * TODO Comment of Page
 * 
 * @author chong.zhu
 */
public class PageModel {

    //当前页码
    private int     page;

    //页数
    private int     pageCount;

    //记录总数
    private int     recordCount;

    //列表数据
    private List<?> list;

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

    /**
     * @return the pageCount
     */
    public int getPageCount() {
        return pageCount;
    }

    /**
     * @param pageCount the pageCount to set
     */
    public void setPageCount(int pageCount) {
        this.pageCount = pageCount;
    }

    
    /**
     * @return the recordCount
     */
    public int getRecordCount() {
        return recordCount;
    }

    
    /**
     * @param recordCount the recordCount to set
     */
    public void setRecordCount(int recordCount) {
        this.recordCount = recordCount;
    }

    /**
     * @return the list
     */
    public List<?> getList() {
        return list;
    }

    /**
     * @param list the list to set
     */
    public void setList(List<?> list) {
        this.list = list;
    }

}
