package com.cshuig.scm.service;

import com.cshuig.scm.dao.IBasicDao;
import com.cshuig.scm.entity.MenuEctity;
import com.cshuig.scm.entity.RoleEntity;
import com.cshuig.scm.exception.ServiceException;
import com.cshuig.scm.service.Interface.IMenuService;
import org.springframework.cache.annotation.Cacheable;

import javax.inject.Inject;
import java.util.List;

/**
 * Created by Administrator on 2014/7/21.
 */
public class MenuService implements IMenuService{

    @Inject
    private IBasicDao basicDao;
    /**
     * 获取菜单
     *
     * @param parentId
     * @param roleList
     * @return
     * @throws com.cshuig.scm.exception.ServiceException
     */
    @Override
    @Cacheable(value = "menuCache")
    public List<MenuEctity> getMenuList(String parentId, List<RoleEntity> roleList) throws ServiceException {
        return null;
    }
}
