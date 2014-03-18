/**
 * Project: huhuequip File Created at 2014-3-7 $Id$ Copyright 2010 dianping.com. All rights reserved. This software is
 * the confidential and proprietary information of Dianping Company. ("Confidential Information"). You shall not
 * disclose such Confidential Information and shall use it only in accordance with the terms of the license agreement
 * you entered into with dianping.com.
 */
package wang.hu.huhuequip.dao.datasource;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;

import wang.hu.huhuequip.vo.EquipVO;

/**
 * TODO Comment of ExcelEquipSource
 * 
 * @author chong.zhu
 */
public class ExcelEquipSource implements EquipSource {

    @Override
    public List<EquipVO> readEquip(File dataSource) {
        if (dataSource == null) {
            return Collections.emptyList();
        }

        List<EquipVO> equipVOs = new ArrayList<EquipVO>();
        try {
            HSSFWorkbook workbook = new HSSFWorkbook(new FileInputStream(dataSource));
            int sheetCount = workbook.getNumberOfSheets();
            for (int i = 0; i < sheetCount; i++) {
                readFromSheet(workbook.getSheetAt(i), equipVOs);
            }
        } catch (Exception e) {
            e.printStackTrace();
            return Collections.emptyList();
        }

        return equipVOs;
    }

    /**
     * @param sheet
     * @param equipVOs
     */
    private void readFromSheet(HSSFSheet sheet, List<EquipVO> equipVOs) {
        if (sheet == null) {
            return;
        }

        if (equipVOs == null) {
            equipVOs = new ArrayList<EquipVO>();
        }

        for (int rowi = 1; rowi < sheet.getLastRowNum(); rowi++) {
            HSSFRow row = sheet.getRow(rowi);
            if (row == null || row.getCell(0) == null || row.getCell(0).equals(StringUtils.EMPTY)) {
                continue;
            }

            EquipVO equip = new EquipVO();
            if (row.getCell(0) != null) {
                equip.setPriceYear(row.getCell(0).getNumericCellValue() + "");
            }
            if (row.getCell(1) != null) {
                equip.setName(row.getCell(1).getStringCellValue());
            }
            if (row.getCell(2) != null) {
                equip.setSpecification(row.getCell(2).getStringCellValue());
            }
            if (row.getCell(3) != null) {
                equip.setTechParams(row.getCell(3).getStringCellValue());
            }
            if (row.getCell(4) != null) {
                equip.setUnit(row.getCell(4).getStringCellValue());
            }
            if (row.getCell(5) != null) {
                equip.setUnitPrice(row.getCell(5).getNumericCellValue());
            }
            if (row.getCell(6) != null) {
                equip.setPriceSource(row.getCell(6).getStringCellValue());
            }
            if (row.getCell(7) != null) {
                equip.setContractNo(row.getCell(7).getStringCellValue());
            }
            if (row.getCell(8) != null) {
                equip.setProject(row.getCell(8).getStringCellValue());
            }
            if (row.getCell(9) != null) {
                equip.setSubProject(row.getCell(9).getStringCellValue());
            }
            if (row.getCell(10) != null) {
                equip.setSpecialtyName(row.getCell(10).getStringCellValue());
            }
            if (row.getCell(11) != null) {
                equip.setSupplierAndContact(row.getCell(11).getStringCellValue());
            }
            if (row.getCell(12) != null) {
                equip.setMemo(row.getCell(12).getStringCellValue());
            }
            equipVOs.add(equip);
        }
    }

}
