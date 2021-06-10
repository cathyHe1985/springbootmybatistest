package com.example.springbootmybatistest.mapper;

import com.example.springbootmybatistest.dao.UserInfo;
import com.example.springbootmybatistest.dao.userdao.UserRoleInfo;
import javafx.beans.property.adapter.ReadOnlyJavaBeanBooleanProperty;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface UserInfoMapper {
    Map<String,Object> getWinHout(Map<String,Object> map);

    Map<String,Object> getHinHout(Map<String,Object> map);

    List<UserInfo> findAllUser();

    List<UserInfo> pageUser(@Param("beginNumber")String beginNumber,@Param("endNumber")String endNumber);

    UserInfo queryUserById(int userid);

    UserInfo queryUserByNamePassword(@Param("userName")String userName,@Param("passWord")String passWord);

    boolean addUser(UserInfo userInfo);

    int updateUser(UserInfo userInfo);

    int delUserById(int id);

    int delUser(UserInfo userInfo);

    List<UserRoleInfo> queryUserWithRole();
}
