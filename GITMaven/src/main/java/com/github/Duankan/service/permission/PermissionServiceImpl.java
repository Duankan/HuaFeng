package com.github.Duankan.service.permission;

import com.github.Duankan.dao.permissionPoMapper;
import com.github.Duankan.po.permissionPo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PermissionServiceImpl implements IpermissionService {
    @Autowired
    permissionPoMapper permissionPoMapper;
    @Override
    public List<permissionPo> getPermissionByRoleId(Integer roleId) {
        if(roleId!=null){
            return permissionPoMapper.getPermissionByRoleId(roleId);
        }
        return null;
    }
}
