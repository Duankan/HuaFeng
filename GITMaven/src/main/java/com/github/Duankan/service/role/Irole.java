package com.github.Duankan.service.role;

import com.github.Duankan.po.rolePo;

import java.util.List;

public interface Irole {

    //根据userid获取角色
    public List<rolePo> getRolesByUserid(Integer userid);
}
