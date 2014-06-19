package com.cshuig.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2014/6/18.
 */
@Controller
@RequestMapping("/login")
public class LoginController {

    @RequestMapping(value = "/{flag}")
    public String login(@PathVariable String flag, String userName, String password, Model model){
        System.out.println(userName +"、"+password + " 登陆了");
        String s = "123123";
        System.out.println(s);
        return "index";
    }
}
