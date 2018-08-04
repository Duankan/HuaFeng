package com.github.Duankan.service.users;

import com.github.Duankan.dao.UsersPoMapper;
import com.github.Duankan.po.UsersPo;
import org.springframework.beans.factory.annotation.Autowired;

public interface Iusers {

    //根据用户名获取User对象
    public UsersPo getUserByUserName(String username);
    public void shiroAnotation();
}
