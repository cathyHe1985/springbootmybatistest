package com.example.springbootmybatistest.dao;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class ReturnInfo {
    private String isSuccess;
    private String errorMsg;
    private String info;
}
