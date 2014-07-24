package com.cshuig.scm.service.Interface;

import com.cshuig.scm.entity.RoleEntity;
import com.cshuig.scm.entity.UserEntity;
import com.cshuig.scm.exception.ServiceException;

import java.util.Set;

/**
 * Created by Administrator on 2014/7/24 0024.
 */
public interface IUserSerice {

    /**
     * 根据用户id：获取用户
     * @param id 用户ID
     * @return
     * @throws ServiceException
     */
    public UserEntity getUserById(int id) throws ServiceException;

    /**
     * 通过用户名：获取所有的角色
     * @param userName
     * @return
     * @throws ServiceException
     */
    public Set<String> getRolesByUsername(String userName) throws  ServiceException;
}
