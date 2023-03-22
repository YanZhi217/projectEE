package com.reggie.entity;

import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.annotation.TableField;
import lombok.Data;
import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 员工实体类
 */
@Data
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    private Long id;//主键

    private String username;//用户名

    private String name;//姓名

    private String password;//密码

    private String phone;//电话

    private String sex;//性别

    private String idNumber;//身份证号码

    private Integer status;//状态 0 1 禁用 启用

    @TableField(fill = FieldFill.INSERT)//添加时自动填充字段
    private LocalDateTime createTime;//创建时间

    @TableField(fill = FieldFill.INSERT_UPDATE)//添加与修改时自动填充字段
    private LocalDateTime updateTime;//更新时间

    @TableField(fill = FieldFill.INSERT)//添加时自动填充字段
    private Long createUser;//创建人

    @TableField(fill = FieldFill.INSERT_UPDATE)//添加与修改时自动填充字段
    private Long updateUser;//修改人

}
