package com.github.Duankan.controller;

import com.github.Duankan.service.users.Iusers;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.authz.annotation.RequiresRoles;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/git")
public class GitController {

    @Autowired
    Iusers iusers;

    @RequiresRoles("admin")
    @RequestMapping("/one")
    public String one(){
        return "vv";
    }
    @RequestMapping(value="/login",method = RequestMethod.POST)
    public String login(String username,String password){
        Subject subject = SecurityUtils.getSubject();
        // 登录后存放进shiro token
        UsernamePasswordToken token=new UsernamePasswordToken(username,password);
        try {
            subject.login(token);
            return "success";
        }
        catch (IncorrectCredentialsException e){
            System.out.println("fail!密码错误！");
            throw e;
        }
        catch (AuthenticationException e){
            throw e;
        }
//        return "index";
    }
}
