package com.example.springbootmybatistest.dao;

public class RoleInfo {
    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_INFO.ID
     *
     * @mbggenerated
     */
    private Short id;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_INFO.ROLE_NAME
     *
     * @mbggenerated
     */
    private String roleName;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_INFO.ROLE_CODE
     *
     * @mbggenerated
     */
    private String roleCode;

    /**
     * This field was generated by MyBatis Generator.
     * This field corresponds to the database column T_ROLE_INFO.IS_DEL
     *
     * @mbggenerated
     */
    private String isDel;

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ROLE_INFO
     *
     * @mbggenerated
     */
    public RoleInfo(Short id, String roleName, String roleCode, String isDel) {
        this.id = id;
        this.roleName = roleName;
        this.roleCode = roleCode;
        this.isDel = isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table T_ROLE_INFO
     *
     * @mbggenerated
     */
    public RoleInfo() {
        super();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_INFO.ID
     *
     * @return the value of T_ROLE_INFO.ID
     *
     * @mbggenerated
     */
    public Short getId() {
        return id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_INFO.ID
     *
     * @param id the value for T_ROLE_INFO.ID
     *
     * @mbggenerated
     */
    public void setId(Short id) {
        this.id = id;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_INFO.ROLE_NAME
     *
     * @return the value of T_ROLE_INFO.ROLE_NAME
     *
     * @mbggenerated
     */
    public String getRoleName() {
        return roleName;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_INFO.ROLE_NAME
     *
     * @param roleName the value for T_ROLE_INFO.ROLE_NAME
     *
     * @mbggenerated
     */
    public void setRoleName(String roleName) {
        this.roleName = roleName == null ? null : roleName.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_INFO.ROLE_CODE
     *
     * @return the value of T_ROLE_INFO.ROLE_CODE
     *
     * @mbggenerated
     */
    public String getRoleCode() {
        return roleCode;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_INFO.ROLE_CODE
     *
     * @param roleCode the value for T_ROLE_INFO.ROLE_CODE
     *
     * @mbggenerated
     */
    public void setRoleCode(String roleCode) {
        this.roleCode = roleCode == null ? null : roleCode.trim();
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method returns the value of the database column T_ROLE_INFO.IS_DEL
     *
     * @return the value of T_ROLE_INFO.IS_DEL
     *
     * @mbggenerated
     */
    public String getIsDel() {
        return isDel;
    }

    /**
     * This method was generated by MyBatis Generator.
     * This method sets the value of the database column T_ROLE_INFO.IS_DEL
     *
     * @param isDel the value for T_ROLE_INFO.IS_DEL
     *
     * @mbggenerated
     */
    public void setIsDel(String isDel) {
        this.isDel = isDel == null ? null : isDel.trim();
    }
}