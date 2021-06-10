package com.example.springbootmybatistest.dao;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@ApiModel
public class UserInfo {
    @ApiModelProperty(value = "Id")
    private Integer id;
    @ApiModelProperty(value = "姓名")
    private String user_Name;
    @ApiModelProperty(value = "密码")
    private String user_Password;
    @ApiModelProperty(value = "用户名")
    private String user_Acccount;
    @ApiModelProperty(value = "是否已删除")
    private String is_Del;
}
