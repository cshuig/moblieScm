package com.cshuig.scm.controller;

import com.cshuig.scm.UserDto;
import com.cshuig.scm.common.AjaxObject;
import com.cshuig.scm.entity.RoleEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

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

    @RequestMapping(value = "/addUser", method = RequestMethod.GET)
    public String addUser(Model model){

        return "addUser";
    }

    @RequestMapping(value = "/addUser1",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addUser1(@RequestBody UserDto user){
        System.out.println(user);
        return new AjaxObject("水水水水水水水");
    }

    @RequestMapping(value = "/addUser2",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addUser2(int id,String name){
        System.out.println(name);
        return new AjaxObject("水水水水水水水");
    }

    @RequestMapping(value = "/addUser3",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addUser3(@RequestBody List<RoleEntity> roleLists){
        System.out.println(roleLists.size());
        return new AjaxObject("水水水水水水水");
    }

    @RequestMapping(value = "/addUser4",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addUser4(@RequestBody RoleEntity[] roleLists){
        System.out.println(roleLists.length);
        return new AjaxObject("水水水水水水水");
    }

    @RequestMapping(value = "/addUser5",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addUser5(int id,String name,@RequestBody List<RoleEntity> roleLists){
        System.out.println(roleLists.size());
        return new AjaxObject("水水水水水水水");
    }

    @RequestMapping(value = "/addUser6",method = RequestMethod.POST)
    @ResponseBody
    public AjaxObject addUser6(int id,String name,@RequestBody RoleEntity[] roleLists){
        System.out.println(roleLists.length);
        return new AjaxObject("水水水水水水水");
    }

    @RequestMapping(value = "/saveUser", method = {RequestMethod.POST})
    @ResponseBody
    public AjaxObject saveUser(@RequestBody List<RoleEntity> roleLists){
        return new AjaxObject("水水水水水水水");
    }
}
