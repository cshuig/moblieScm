package com.cshuig.scm.service;

import com.cshuig.scm.service.Interface.ILoginService;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

/**
 * Created by Administrator on 2014/6/21.
 */
@Service
public class LoginService implements ILoginService{

    @Override
    public boolean login(String userName, String password) throws LoginException {
        Subject subject = SecurityUtils.getSubject();
        UsernamePasswordToken token = new UsernamePasswordToken(userName,password);
        subject.login(token);
        return false;
    }
}
