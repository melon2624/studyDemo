package com.zx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * @author zhangxin
 * @date 2022-10-22 9:16
 */

@TableName(value = "patient")
@Data
public class Patient implements Serializable {

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    /**
     * 姓名
     */
    @TableField(value = "name")
    private String name;

    /**
     * 申请科室
     */
    @TableField(value = "applyDepartment")
    private String applydepartment;

    /**
     * 年龄
     */
    @TableField(value = "age")
    private String age;

    /**
     * 双签医生
     */
    @TableField(value = "doubleDoctor")
    private String doubledoctor;

    /**
     * 检查费用
     */
    @TableField(value = "fee")
    private String fee;

    /**
     * 联系电话
     */
    @TableField(value = "phone")
    private String phone;

    /**
     * 检查所见
     */
    @TableField(value = "checkFind")
    private String checkfind;

    /**
     * 检查时间
     */
    @TableField(value = "checkTime")
    private String checktime;

    /**
     * 打印时间
     */
    @TableField(value = "printTime")
    private String printtime;

    /**
     * 孕周
     */
    @TableField(value = "gestationalWeek")
    private String gestationalweek;

    /**
     * 检查提示
     */
    @TableField(value = "checkTips")
    private String checktips;

    /**
     * 病人来源
     */
    @TableField(value = "patientSource")
    private String patientsource;

    /**
     * 打印医生
     */
    @TableField(value = "printDoctor")
    private String printdoctor;

    /**
     * 检查号
     */
    @TableField(value = "checkNo")
    private String checkno;

    /**
     * 登记时间
     */
    @TableField(value = "registerTime")
    private String registertime;

    /**
     * 病人id
     */
    @TableField(value = "patientID")
    private String patientid;

    /**
     * 检查医生
     */
    @TableField(value = "checkDoctor")
    private String checkdoctor;

    /**
     * 检查部位
     */
    @TableField(value = "checkPosition")
    private String checkposition;

    /**
     * 临床诊断
     */
    @TableField(value = "clinicalDiagnosis")
    private String clinicaldiagnosis;

    /**
     * 性别
     */
    @TableField(value = "sex")
    private String sex;

    /**
     * 检查状态
     */
    @TableField(value = "checkState")
    private String checkstate;

    /**
     * 检查设备
     */
    @TableField(value = "checkEquipment")
    private String checkequipment;

    /**
     * 记录医生
     */
    @TableField(value = "recordDoctor")
    private String recorddoctor;

    /**
     * 检查类型
     */
    @TableField(value = "checkType")
    private String checktype;

    @TableField(value = "checkRemark")
    private String checkremark;

}