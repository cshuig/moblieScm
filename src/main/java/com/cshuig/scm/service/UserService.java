package com.cshuig.scm.service;

import com.cshuig.scm.dao.IBasicDao;
import com.cshuig.scm.entity.RoleEntity;
import com.cshuig.scm.entity.UserEntity;
import com.cshuig.scm.exception.ServiceException;
import com.cshuig.scm.service.Interface.IUserSerice;
import org.springframework.stereotype.Service;

import javax.inject.Inject;
import java.util.Set;

/**
 * Created by Administrator on 2014/7/24 0024.
 */
@Service
public class UserService implements IUserSerice{
    @Inject
    private IBasicDao<UserEntity> basicDao;
    /**
     * 根据用户id：获取用户
     * @param id 用户ID
     * @return
     * @throws com.cshuig.scm.exception.ServiceException
     */
    @Override
    public UserEntity getUserById(int id) throws ServiceException {
        return basicDao.getObjectById(id);
    }

    /**
     * 通过用户名：获取所有的角色
     * @param userName
     * @return
     * @throws com.cshuig.scm.exception.ServiceException
     */
    @Override
    public Set<String> getRolesByUsername(String userName) throws ServiceException {
        return null;
    }
}
