package com.it.config.shiro;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.it.common.utils.StringUtil;
import com.it.entity.Permission;
import com.it.entity.User;
import com.it.mapper.PermissionMapper;
import com.it.service.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Describe: 自定义ShiroRealm 认证 授权
 */
@Slf4j
public class MyShiroRealm extends AuthorizingRealm {

    @Autowired
    private IUserService iUserService;

    @Autowired
    private PermissionMapper permissionMapper;

    /**
     * 认证信息.(身份验证)
     * @param token
     * @return
     * @throws AuthenticationException
     */
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
        log.info("MyShiroRealm.doGetAuthenticationInfo()");

        // 获取用户的输入的账号.
        String username = (String)token.getPrincipal();

        //查询用户信息
        QueryWrapper<User> wrapper = new QueryWrapper<>();
        wrapper.eq("username", username);
        User user = iUserService.getOne(wrapper);
        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),getName());

        return simpleAuthenticationInfo;
    }

    /**
     * 权限信息.(授权):
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        log.info("MyShiroRealm.doGetAuthorizationInfo()");

        // 获取用户信息
        User user = (User) principals.getPrimaryPrincipal();

        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();

        // 查询用户拥有那些权限
        List<Permission> permissions = permissionMapper.findUserPermission(user.getId());
        List<String> list = new ArrayList<String>();

        // 添加权限代码
        for (Permission item: permissions) {
            if (StringUtil.isNotEmpty(item.getPermCode()))
                list.add(item.getPermCode());
        }
        authorizationInfo.addStringPermissions(list);

        return authorizationInfo;
    }

}
