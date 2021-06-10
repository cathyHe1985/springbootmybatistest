package com.example.springbootmybatistest.service;

import com.example.springbootmybatistest.dao.UserInfo;
import com.example.springbootmybatistest.dao.userdao.UserRoleInfo;
import com.example.springbootmybatistest.mapper.UserInfoMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserInfoService  {
    @Resource
    private UserInfoMapper userInfoMapper;
    public UserInfo queryUserByNamePassword(String userName, String passWord) {
        return userInfoMapper.queryUserByNamePassword(userName,passWord);
    }
}
