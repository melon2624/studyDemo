package com.zx.service;


import com.baomidou.mybatisplus.extension.service.IService;
import com.zx.entity.Patient;
import org.apache.poi.ss.usermodel.Workbook;

/**
 * @author  zhangxin
 * @date  2022-10-22 9:16
 */

public interface PatientService  extends IService<Patient> {


    void saveExcelList(Workbook workbook);

    void excel();

    void getSortData(Workbook workbook);
}
