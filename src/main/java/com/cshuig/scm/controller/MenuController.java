package com.cshuig.scm.controller;

import com.cshuig.scm.common.AjaxObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

/**
 * Created by Administrator on 2014/7/20.
 */
@Controller
@RequestMapping("/menu")
public class MenuController {

    @RequestMapping(value="/getMenus")
    @ResponseBody
    public AjaxObject getMenus(HttpServletRequest request, Model model){
        return new AjaxObject();
    }
}
