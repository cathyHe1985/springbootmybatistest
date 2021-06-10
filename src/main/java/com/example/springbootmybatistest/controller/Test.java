package com.example.springbootmybatistest.controller;

import com.alibaba.fastjson.JSON;
import com.example.springbootmybatistest.authvalidate.Auth;
import com.example.springbootmybatistest.dao.RoleInfo;
import com.example.springbootmybatistest.dao.userdao.UserRoleInfo;
import com.example.springbootmybatistest.mapper.RoleInfoMapper;
import com.example.springbootmybatistest.mapper.UserInfoMapper;
import com.example.springbootmybatistest.dao.UserInfo;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@Api(tags = "接口测试")
public class Test {

    @Autowired
    private UserInfoMapper userInfoDao;
    @Autowired
    private RoleInfoMapper roleInfoMapper;

    @RequestMapping(value = "/listUserRoleInfo",method = RequestMethod.GET)
    @ApiOperation("用户列表")
    public List<UserRoleInfo> listUserRoleInfo() {
        return userInfoDao.queryUserWithRole();
    }

    @Auth
    @RequestMapping(value = "/listRole",method =RequestMethod.GET)
    public List<RoleInfo> listRole() {
        return roleInfoMapper.selectAll();
    }

    @RequestMapping(value = "/insertRole",method = RequestMethod.GET)
    public String insertRole() {
        short sid = 3;
        RoleInfo ri = new RoleInfo();
        ri.setId(sid);
        ri.setRoleName("角色1");
        return roleInfoMapper.insert(ri) + "";
    }

    @RequestMapping(value = "/updateRole",method = RequestMethod.GET)
    public String updateRole() {
        short sid = 3;
        RoleInfo ri = roleInfoMapper.selectByPrimaryKey(sid);
        ri.setRoleName("角色2");
        ri.setIsDel("0");
        return roleInfoMapper.updateByPrimaryKey(ri) + "";
    }


    @RequestMapping(value = "/helloWorld",method = RequestMethod.GET)
    public String helloWorld() {
        return "Hello word";
    }

    @RequestMapping(value = "/listUser",method = RequestMethod.GET)
    public String listUser() {
        return JSON.toJSONString(userInfoDao.findAllUser());
    }

    @RequestMapping(value = {"/queryUserById"}, method = RequestMethod.GET)
    public UserInfo queryUserById(String userid) {
        UserInfo user = userInfoDao.queryUserById(Integer.parseInt(userid));
        return user;
    }

    @RequestMapping(value = {"/queryUserByUserPass"}, method = RequestMethod.GET)
    @ApiOperation("通过用户名密码查询用户")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "username",value = "用户名"),
            @ApiImplicitParam(name = "password",value = "密码")
    })
    public String queryUserByUserPass(String username, String password) {
        UserInfo user = userInfoDao.queryUserByNamePassword(username, password);
        if (user != null) {
            return "1";
        } else {
            return "0";
        }
    }

    @RequestMapping(value = {"/pageUserInfo"}, method = RequestMethod.GET)
    public List<UserInfo> pageUserInfo(String strBegin, String strEnd) {
        return userInfoDao.pageUser(strBegin, strEnd);
    }

    @RequestMapping(value = {"/pWinHout"}, method = RequestMethod.GET)
    public String pWinHout(){
        Map<String,Object> mm=new HashMap<String,Object>();
        mm.put("sc",0);
        userInfoDao.getWinHout(mm);
        return  mm.get("sc").toString();
    }

    @RequestMapping(value = {"/pHinHout"}, method = RequestMethod.GET)
    public String pHinHout(int a,int b){
        Map<String,Object> mm=new HashMap<String,Object>();
        mm.put("a",a);
        mm.put("b",b);
        userInfoDao.getHinHout(mm);
        List<UserInfo> listUserInfo= (List<UserInfo>)mm.get("userinfo");
        return mm.get("sc").toString()+"<br/>"+JSON.toJSONString(listUserInfo);
    }

    @Auth(value = "admin")
    @PostMapping("/addUser")
    public String addUser(@RequestHeader("application/json") @RequestBody UserInfo user) {
        UserInfo ui = user;
        if (userInfoDao.addUser(ui)) {
            return "1";
        } else {
            return "0";
        }
    }

    @RequestMapping(value = "/updateUser",method=RequestMethod.GET)
    public String updateUser() {
        UserInfo ui = new UserInfo();
        ui.setId(5);
        ui.setIs_Del("1");
        int ur = userInfoDao.updateUser(ui);
        return ur + "";
    }

    @RequestMapping(value = "/delUser0",method = RequestMethod.GET)
    public String delUser0(String id) {
        return userInfoDao.delUserById(Integer.parseInt(id)) + "";
    }

    @RequestMapping(value = "/delUser1",method = RequestMethod.GET)
    public String delUser1() {
        UserInfo ui = new UserInfo();
        ui.setUser_Name("倩倩");
        return userInfoDao.delUser(ui) + "";
    }
}
