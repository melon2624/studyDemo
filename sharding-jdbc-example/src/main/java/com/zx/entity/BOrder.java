package com.zx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.util.Date;

import lombok.Data;

/**
 * @author zhangxin
 * @date 2021/10/13 0:43
 */
@Data
@TableName(value = "b_order")
public class BOrder {
    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 是否被删除
     */
    @TableField(value = "is_del")
    private Boolean isDel;

    /**
     * 公司ID
     */
    @TableField(value = "company_id")
    private Integer companyId;

    /**
     * 职位ID
     */
    @TableField(value = "position_id")
    private Long positionId;

    /**
     * 用户id
     */
    @TableField(value = "user_id")
    private Integer userId;

    /**
     * 职位发布者id
     */
    @TableField(value = "publish_user_id")
    private Integer publishUserId;

    /**
     * 简历类型：0 附件 1 在线
     */
    @TableField(value = "resume_type")
    private Integer resumeType;

    /**
     * 投递状态 投递状态 WAIT-待处理 AUTO_FILTER-自动过滤 PREPARE_CONTACT-待沟通 REFUSE-拒绝 ARRANGE_INTERVIEW-通知面试
     */
    @TableField(value = "status")
    private String status;

    /**
     * 创建时间
     */
    @TableField(value = "create_time")
    private Date createTime;

    /**
     * 操作时间
     */
    @TableField(value = "operate_time")
    private Date operateTime;

    /**
     * 工作年限
     */
    @TableField(value = "work_year")
    private String workYear;

    /**
     * 投递简历人名字
     */
    @TableField(value = "name")
    private String name;

    /**
     * 职位名称
     */
    @TableField(value = "position_name")
    private String positionName;

    /**
     * 投递的简历id（在线和附件都记录，通过resumeType进行区别在线还是附件）
     */
    @TableField(value = "resume_id")
    private Integer resumeId;
}