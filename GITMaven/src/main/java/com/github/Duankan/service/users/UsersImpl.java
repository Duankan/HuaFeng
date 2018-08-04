package com.github.Duankan.service.users;

import com.github.Duankan.dao.UsersPoMapper;
import com.github.Duankan.po.UsersPo;
import org.apache.shiro.authz.annotation.Logical;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import javax.annotation.Resource;

@Service
public class UsersImpl implements Iusers {

    @Resource
    UsersPoMapper u_mapper;
    @Override
    public UsersPo getUserByUserName(String username) {
        //判空
        if(!StringUtils.isEmpty(username)){
            return u_mapper.getUserByUserName(username);
        }
        else {
            return null;
        }
    }
    //测试权限注解
    @RequiresRoles(value={"admin"},logical = Logical.OR)
    public void shiroAnotation(){
        System.out.println("admin角色！");
    }
}
