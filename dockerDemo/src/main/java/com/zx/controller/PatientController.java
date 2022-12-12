package com.zx.controller;

import com.alibaba.druid.util.StringUtils;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.zx.entity.Patient;
import com.zx.entity.Tbuser;
import com.zx.mapper.TbuserMapper;
import com.zx.service.PatientService;
import com.zx.service.TbuserService;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.transaction.annotation.Transactional;
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

    @Resource
    TbuserMapper tbuserMapper;

    @Resource
    TbuserService tbuserService;


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
        return "null";
    }

    @RequestMapping("/name")
    @Transactional
    public String name() {
        File file = new File("C:\\12525\\3140");
        File[] list = file.listFiles();
        if (file.exists() && file.isDirectory()) {
            for (int i = 0; i < list.length; i++) {
                String name = list[i].getName();
                Tbuser tbuser = new Tbuser();
                tbuser.setUsername(name);
                tbuserService.save(tbuser);
            }
        }
        return "success";
    }


    @RequestMapping("/excel")
    public String excel() {
        patientService.excel();
        return "";
    }

    @RequestMapping("/sortPatient")
    public String sortPatient(@RequestParam("fileName") MultipartFile file) throws Exception {
        // 防止生成的临时文件重复-建议使用UUID
        final File excelFile = File.createTempFile(System.currentTimeMillis() + "", "zx");
        file.transferTo(excelFile);
        Workbook workbook = null;
        workbook = new HSSFWorkbook(new FileInputStream(excelFile));

        patientService.saveExcelList(workbook);
        patientService.getSortData(workbook);
        return null;
    }


}
