package com.github.Duankan.dao;

import com.github.Duankan.po.rolePo;

import java.util.List;

public interface rolePoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(rolePo record);

    int insertSelective(rolePo record);

    rolePo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(rolePo record);

    int updateByPrimaryKey(rolePo record);

    //根据用户Id,获取角色
    public List<rolePo> getRolesByUserid(Integer userid);
}