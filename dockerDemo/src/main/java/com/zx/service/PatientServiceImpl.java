package com.zx.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.zx.entity.Patient;
import com.zx.entity.Tbuser;
import com.zx.mapper.PatientMapper;
import com.zx.mapper.TbuserMapper;
import lombok.val;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * @author zhangxin
 * @date 2022-10-22 9:16
 */

@Service
public class PatientServiceImpl extends ServiceImpl<PatientMapper, Patient>
        implements PatientService {

    @Resource
    private PatientMapper patientMapper;

    @Override
    @Transactional
    public void saveExcelList(Workbook workbook) {
        List<Patient> list = new ArrayList<>();
        Sheet sheet = workbook.getSheetAt(0);

        int rowNum = sheet.getPhysicalNumberOfRows();
        for (int i = 2; i < 304; i++) {
            Row row = sheet.getRow(i);
            Patient patient = new Patient();
            System.out.println("-----------------zhangxin:::" + i);
            Cell cell = row.getCell(0);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setName(cell.getStringCellValue());

            cell = row.getCell(1);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setApplydepartment(cell.getStringCellValue());

            cell = row.getCell(2);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setAge(cell.getStringCellValue());

            cell = row.getCell(3);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setDoubledoctor(cell.getStringCellValue());

            cell = row.getCell(4);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setFee(cell.getStringCellValue());

            cell = row.getCell(5);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setPhone(cell.getStringCellValue());


            cell = row.getCell(6);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setPrinttime(cell.getStringCellValue());

            cell = row.getCell(7);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setChecktime(cell.getStringCellValue());

            cell = row.getCell(8);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setGestationalweek(cell.getStringCellValue());

            cell = row.getCell(9);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setChecktips(cell.getStringCellValue());

            cell = row.getCell(10);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setPatientsource(cell.getStringCellValue());

            cell = row.getCell(11);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setPrintdoctor(cell.getStringCellValue());

            cell=row.getCell(12);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckfind(cell.getStringCellValue());


            cell = row.getCell(13);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckno(cell.getStringCellValue());

            cell = row.getCell(14);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setRegistertime(cell.getStringCellValue());


            cell = row.getCell(15);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setPatientid(cell.getStringCellValue());

            cell = row.getCell(16);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckdoctor(cell.getStringCellValue());

            cell = row.getCell(17);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckposition(cell.getStringCellValue());

            cell = row.getCell(18);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setClinicaldiagnosis(cell.getStringCellValue());

            cell = row.getCell(19);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setSex(cell.getStringCellValue());

            cell = row.getCell(20);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckstate(cell.getStringCellValue());


            cell = row.getCell(21);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckequipment(cell.getStringCellValue());

            cell = row.getCell(22);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setRecorddoctor(cell.getStringCellValue());

            cell = row.getCell(23);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setChecktype(cell.getStringCellValue());

            cell = row.getCell(24);
            if (cell.getCellType() == Cell.CELL_TYPE_NUMERIC) {
                cell.setCellType(Cell.CELL_TYPE_STRING);
            }
            patient.setCheckremark(cell.getStringCellValue());

            // patient.setPatientsource(row.getCell(11).getStringCellValue());
            //patient.setPrintdoctor(row.getCell(12).getStringCellValue());
            //  patient.setCheckno(row.getCell(13).getStringCellValue());
            // patient.setRegistertime(row.getCell(14).getStringCellValue());
            // patient.setPatientid(row.getCell(15).getStringCellValue());
            //   patient.setCheckdoctor(row.getCell(16).getStringCellValue());
     /*       patient.setCheckposition(row.getCell(17).getStringCellValue());
            patient.setClinicaldiagnosis(row.getCell(18).getStringCellValue());
            patient.setSex(row.getCell(19).getStringCellValue());
           // patient.setCheckstate(row.getCell(20).getStringCellValue());
            patient.setCheckequipment(row.getCell(21).getStringCellValue());
            patient.setRecorddoctor(row.getCell(22).getStringCellValue());
            patient.setChecktype(row.getCell(23).getStringCellValue());
            patient.setCheckremark(row.getCell(24).getStringCellValue());*/


            this.save(patient);
        }


    }
}
