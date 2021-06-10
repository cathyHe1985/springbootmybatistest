package com.example.springbootmybatistest.dao.userdao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class UserRoleInfo {
    private Integer Id;
    private String User_Name;
    private String User_Password;
    private String User_Acccount;
    private String Is_Del;
    private String Role_Name;
    private Integer Role_Id;
}
