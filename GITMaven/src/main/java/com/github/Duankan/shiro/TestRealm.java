package com.github.Duankan.shiro;

import com.github.Duankan.dao.UsersPoMapper;
import com.github.Duankan.dao.permissionPoMapper;
import com.github.Duankan.dao.rolePoMapper;
import com.github.Duankan.po.UsersPo;
import com.github.Duankan.po.rolePo;
import com.github.Duankan.service.permission.IpermissionService;
import com.github.Duankan.service.role.Irole;
import com.github.Duankan.service.users.Iusers;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.StringUtils;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class TestRealm extends AuthorizingRealm {

   @Autowired
    Iusers iusers;
   @Autowired
    Irole irole;
   @Autowired
    IpermissionService ipermissionService;

    //授权
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        String username = (String) principalCollection.getPrimaryPrincipal();
        UsersPo usersPo = iusers.getUserByUserName(username);
        List<rolePo> rs=irole.getRolesByUserid(usersPo.getId());
        Set<String> roles =new HashSet<>();
        for (rolePo r:rs){
            roles.add(r.getRolename());
        }
        SimpleAuthorizationInfo simpleAuthorizationInfo = new SimpleAuthorizationInfo();
        simpleAuthorizationInfo.setRoles(roles);
        return simpleAuthorizationInfo;
    }

    //验证
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        String userName = (String) authenticationToken.getPrincipal(); //用户名
        UsersPo usersPo = iusers.getUserByUserName(userName);
        String password=null;
        if (usersPo != null) {
            password = usersPo.getPassword();
        }
        SimpleAuthenticationInfo authenticationInfo = new SimpleAuthenticationInfo(userName,password,"testRealm");
        return authenticationInfo;
    }
}
