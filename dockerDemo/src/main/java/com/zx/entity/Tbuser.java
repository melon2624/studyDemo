package com.zx.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.io.Serializable;

/**
 * 
 * @TableName tbuser
 */
@TableName(value ="tbuser")
@Data
public class Tbuser implements Serializable {
    /**
     * 
     */
    @TableId(value = "userid", type = IdType.AUTO)
    private Integer userid;

    /**
     * 
     */
    @TableField(value = "username")
    private String username;

    /**
     * 
     */
    @TableField(value = "password")
    private String password;

    /**
     * 
     */
    @TableField(value = "userroles")
    private String userroles;

    /**
     * 
     */
    @TableField(value = "nickname")
    private String nickname;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;
}