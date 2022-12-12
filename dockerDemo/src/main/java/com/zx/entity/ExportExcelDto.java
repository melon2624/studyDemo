package com.zx.entity;

import lombok.Data;

import java.util.List;

@Data
public class ExportExcelDto {

    private String[] header;


    private List<String[]> list;

    private String sheetTitle;

    private String filePath;

    private String title;

    private String secondHang;

    private String fileName;

    private Integer[] sheetWidth;

}
