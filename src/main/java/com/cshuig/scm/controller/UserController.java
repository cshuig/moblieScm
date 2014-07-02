package com.cshuig.scm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * Created by Administrator on 2014/6/16.
 */
@Controller
@RequestMapping(value="/user")
public class UserController {

    @RequestMapping(value = "/index")
    public String init(){
        return "welcome";
    }
}
