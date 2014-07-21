package com.cshuig.scm.entity;

import javax.lang.model.element.Name;
import javax.persistence.Column;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * Created by Administrator on 2014/7/21.
 */
public class roleMenuEntity implements Serializable{

    private static final long serialVersionUID = 8635069917562925095L;
    private int id;
    private RoleEntity roleEntity;
    private MenuEctity menuEctity;

    @Id
    @Column(name = "id", length = 32)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public RoleEntity getRoleEntity() {
        return roleEntity;
    }

    public void setRoleEntity(RoleEntity roleEntity) {
        this.roleEntity = roleEntity;
    }

    public MenuEctity getMenuEctity() {
        return menuEctity;
    }

    public void setMenuEctity(MenuEctity menuEctity) {
        this.menuEctity = menuEctity;
    }
}
