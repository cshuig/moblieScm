package com.cshuig.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by Administrator on 2014/6/18.
 */
public class LoginController {

    //@RequestMapping(value = "/",method = RequestMethod.GET)
    public String login(){
        return "/index";
    }
}
