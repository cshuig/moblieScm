package com.cshuig.scm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2014/7/20.
 */
@Entity
@Table(name = "TB_ACTION")
public class ActionEntity implements Serializable{

    private static final long serialVersionUID = 2497233147404235711L;

    /** 普通动作 */
    private static final int ACTIONTYPE_FORMAL = 1;
    /** 授权动作 */
    private static final int ACTIONTYPE_AUTHOR = 2;
    private int id;
    private String actionName;
    private String type;
    private int menuId;
    private String remark;

    @Column(name="id",length = 32)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name="actionName",length = 100)
    public String getActionName() {
        return actionName;
    }

    public void setActionName(String actionName) {
        this.actionName = actionName;
    }

    @Column(name="type",length = 1)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Column(name="menuId",length = 32)
    public int getMenuId() {
        return menuId;
    }

    public void setMenuId(int menuId) {
        this.menuId = menuId;
    }

    @Column(name="remark",length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
