package com.cshuig.scm.service;

import com.cshuig.scm.service.Interface.ILoginService;
import org.springframework.stereotype.Service;

import javax.security.auth.login.LoginException;

/**
 * Created by Administrator on 2014/6/21.
 */
@Service
public class LoginService implements ILoginService{

    @Override
    public boolean login() throws LoginException {
        return false;
    }
}
