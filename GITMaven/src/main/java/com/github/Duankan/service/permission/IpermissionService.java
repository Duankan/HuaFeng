package com.github.Duankan.service.permission;

import com.github.Duankan.po.permissionPo;

import java.util.List;

public interface IpermissionService {

    //根据roleId获取权限
    public List<permissionPo> getPermissionByRoleId(Integer roleId);
}
