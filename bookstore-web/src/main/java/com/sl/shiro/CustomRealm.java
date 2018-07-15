package com.sl.shiro;
import org.apache.shiro.SecurityUtils;
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

import com.sl.service.impl.SysService;


import java.util.ArrayList;
import java.util.List;


public class CustomRealm extends AuthorizingRealm
{

    //注入service
    @Autowired
    private SysService sysService;

    //设置realm的名称
    @Override
    public void setName(String name) {
        super.setName("customRealm");
    }

    //realm的认证方法，从数据库查询用户信息
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {

    	//token是用户输入的
        //第一步:丛token中取出身份信息
        String userCode= (String) token.getPrincipal();

        //第二步:根据用户输入的userCode丛数据库查询


        //模拟丛数据库查询到的密码
        String password="111111";

      

        //如果查不到返回null，

        //如果查询到，返回认证信息AuthenticationInfo

        ///将activeUser设置到simpleAuthenticationInfo
        SimpleAuthenticationInfo simpleAuthenticationInfo=new
                SimpleAuthenticationInfo(userCode,password,this.getName());


        return simpleAuthenticationInfo;
    }

    //授权
    @Override
	protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection arg0) {
		// TODO 自动生成的方法存根
		return null;
	}
    
    //清除缓存
    public void clearCached() {
        PrincipalCollection principals = SecurityUtils.getSubject().getPrincipals();
        super.clearCache(principals);
    }

	



}
