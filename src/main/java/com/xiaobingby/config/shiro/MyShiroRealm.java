package com.xiaobingby.config.shiro;

import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.xiaobingby.common.utils.StringUtil;
import com.xiaobingby.sys.entity.Permission;
import com.xiaobingby.sys.entity.User;
import com.xiaobingby.sys.mapper.PermissionMapper;
import com.xiaobingby.sys.service.IPermissionService;
import com.xiaobingby.sys.service.IUserService;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationInfo;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.SimpleAuthenticationInfo;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: XiaoBingBy
 * Email: XiaoBingBy@qq.com
 * Date: 2017/9/1
 * Time: 00:00
 * Describe: 自定义ShiroRealm 认证 授权
 */
public class MyShiroRealm extends AuthorizingRealm {

    private static final transient Logger logger = LoggerFactory.getLogger(ShiroConfiguration.class);

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
        logger.info("MyShiroRealm.doGetAuthenticationInfo()");

        // 获取用户的输入的账号.
        String username = (String)token.getPrincipal();

        //查询用户信息
        EntityWrapper<User> wrapper = new EntityWrapper<>();
        wrapper.eq("username", username);
        User user = iUserService.selectOne(wrapper);
        if (user == null) {
            return null;
        }

        SimpleAuthenticationInfo simpleAuthenticationInfo = new SimpleAuthenticationInfo(user, user.getPassword(),
                ByteSource.Util.bytes(user.getSalt()),"MyShiroRealm");

        return simpleAuthenticationInfo;
    }

    /**
     * 权限信息.(授权):
     * @param principals
     * @return
     */
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
        logger.info("MyShiroRealm.doGetAuthorizationInfo()");

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
