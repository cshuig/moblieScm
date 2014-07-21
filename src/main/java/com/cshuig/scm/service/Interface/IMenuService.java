package com.cshuig.scm.service.Interface;

import com.cshuig.scm.entity.MenuEctity;
import com.cshuig.scm.entity.RoleEntity;
import com.cshuig.scm.exception.ServiceException;

import java.util.List;

/**
 * Created by Administrator on 2014/7/21.
 */
public interface IMenuService {

    /**
     * 获取菜单
     * @param parentId
     * @param roleList
     * @return
     * @throws ServiceException
     */
    public List<MenuEctity> getMenuList(String parentId, List<RoleEntity> roleList) throws ServiceException;

}
