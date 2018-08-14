package com.sl.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import com.sl.exception.CustomException;

//import org.apache.shiro.authc.IncorrectCredentialsException;
//import org.apache.shiro.authc.UnknownAccountException;

@Controller
@RequestMapping("/user")
public class UserController
{
	/*
 	@RequestMapping(value="/loginsubmit",method = RequestMethod.POST)
    public String loginSubmit(HttpServletRequest request) throws Exception
    {
 		System.out.print("执行loginSubmit");
        //如果登录失败从request中获取认证异常信息,shiroLoginFailure就是shiro异常类的全限定名
        String exceptionClassName= (String) request.getAttribute("shiroLoginFailure");

        //根据shiro返回的异常类路径判断，抛出指定异常信息
        if(exceptionClassName!=null){
            if (UnknownAccountException.class.getName().equals(exceptionClassName)) {
                //最终会抛给异常处理器
                throw new CustomException("账号不存在");
            } else if (IncorrectCredentialsException.class.getName().equals(
                    exceptionClassName)) {
                throw new CustomException("用户名/密码错误");
            } else if("randomCodeError".equals(exceptionClassName)){
                throw new CustomException("验证码错误");
            } else{
                throw new Exception();//最终在异常处理器生成未知错误
            }
        }
        System.out.print("执行loginSubmit");
        //登录失败返回到login页面
        return "home";
    }
 	*/
 	@RequestMapping("/login")
    public String login() throws Exception
    {
 		System.out.print("执行login");
        //登录失败返回到login页面
        return "user/login";
    }
}