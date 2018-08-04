package com.github.Duankan.service.role;

import com.github.Duankan.dao.rolePoMapper;
import com.github.Duankan.po.rolePo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class RoleServiceImpl implements Irole {

    @Resource
    rolePoMapper rolePoMapper;
    @Override
    public List<rolePo> getRolesByUserid(Integer userid) {
        if(userid!=null){
            return rolePoMapper.getRolesByUserid(userid);
        }
        return null;
    }
}
