package com.cshuig.scm.controller;

import com.cshuig.scm.service.Interface.ILoginService;
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
            System.out.println(userName +"、"+password + " 登陆了");
            String s = "123123";
            System.out.println(s);
            System.out.println("改java代码，立马生效");
            System.out.println(loginService.login());
        } catch (LoginException e) {
            e.printStackTrace();
        }
        return "welcome";
    }

    @RequestMapping(value="/inMian")
    public String inMain(){
        System.out.println("加载mian页面");
        return "mian";
    }
}
