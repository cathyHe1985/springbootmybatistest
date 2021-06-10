package com.example.springbootmybatistest.mapper;

import com.example.springbootmybatistest.dao.UserRole;
import java.util.List;

public interface UserRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER_ROLE
     *
     * @mbggenerated
     */
    int deleteByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER_ROLE
     *
     * @mbggenerated
     */
    int insert(UserRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER_ROLE
     *
     * @mbggenerated
     */
    UserRole selectByPrimaryKey(Short id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER_ROLE
     *
     * @mbggenerated
     */
    List<UserRole> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_USER_ROLE
     *
     * @mbggenerated
     */
    int updateByPrimaryKey(UserRole record);
}