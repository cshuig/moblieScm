package com.cshuig.scm.service.Interface;

import javax.security.auth.login.LoginException;

/**
 * Created by Administrator on 2014/6/20.
 */
public interface ILoginService {

    public boolean login(String userName, String password) throws LoginException;
}
