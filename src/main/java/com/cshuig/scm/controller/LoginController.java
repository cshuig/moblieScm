package com.cshuig.scm.controller;

import com.cshuig.scm.service.Interface.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.inject.Inject;
import javax.security.auth.login.LoginException;

/**
 * Created by Administrator on 2014/6/18.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @Inject
    private ILoginService loginService;

    @RequestMapping(value = "/{flag}")
    public String login(@PathVariable String flag, String userName, String password, Model model){
        try {
           loginService.login(userName, password);
        } catch (LoginException e) {
            e.printStackTrace();
        }catch (UnknownAccountException e){
            System.out.println("用户名错误");
        }catch (IncorrectCredentialsException e){
            System.out.println("密码错误");
        }catch (AuthenticationException e){
            System.out.println("其他错误");
        }
        return "welcome";
    }

    @RequestMapping(value="/inMian")
    public String inMain(){
        System.out.println("加载mian页面");
        return "mian";
    }
}
