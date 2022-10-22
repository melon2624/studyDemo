package com.zx.controller;

import com.alibaba.druid.util.StringUtils;
import com.zx.entity.Patient;
import com.zx.service.PatientService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.File;
import java.io.FileInputStream;

/**
 * @author zhangxin
 * @date 2022-10-22 9:29
 */
@RestController
public class PatientController {

    @Resource
    PatientService patientService;

    @RequestMapping("/hospital")
    public String hospital(@RequestParam("fileName") MultipartFile file) throws
            Exception {

        // 防止生成的临时文件重复-建议使用UUID
        final File excelFile = File.createTempFile(System.currentTimeMillis() + "", "zx");
        file.transferTo(excelFile);
        Workbook workbook = null;
        workbook = new HSSFWorkbook(new FileInputStream(excelFile));
        Patient patient = new Patient();
        patient.setAge("333");

        patientService.saveExcelList(workbook);

       // patientService.save(patient);

        System.out.println("zxxx");
        return "null";
    }


}
