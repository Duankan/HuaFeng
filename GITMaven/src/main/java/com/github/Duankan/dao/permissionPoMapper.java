package com.github.Duankan.dao;

import com.github.Duankan.po.permissionPo;

import java.util.List;

public interface permissionPoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(permissionPo record);

    int insertSelective(permissionPo record);

    permissionPo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(permissionPo record);

    int updateByPrimaryKey(permissionPo record);

    //根据角色id获取权限
    public List<permissionPo> getPermissionByRoleId(Integer roleId);
}