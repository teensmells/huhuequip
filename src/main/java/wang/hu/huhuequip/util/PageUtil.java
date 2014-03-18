/**
 * Project: huhuequip File Created at 2014-3-15 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.util;

import java.util.List;

import org.apache.commons.collections.CollectionUtils;

/**
 * TODO Comment of PageUtil
 * 
 * @author chong.zhu
 */
public class PageUtil {

    public static PageModel convertPage(List<?> list, int recordCount, int page, int limit) {
        if (CollectionUtils.isEmpty(list) || recordCount == 0) {
            return null;
        }

        PageModel pageModel = new PageModel();
        pageModel.setList(list);
        pageModel.setPage(page);
        pageModel.setPageCount(recordCount % limit == 0 ? recordCount / limit : recordCount / limit + 1);
        pageModel.setRecordCount(recordCount);
        return pageModel;
    }
}
