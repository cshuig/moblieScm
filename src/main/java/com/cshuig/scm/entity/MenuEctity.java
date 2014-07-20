package com.cshuig.scm.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2014/7/20.
 */
@Entity
@Table(name = "TB_MENUS")
public class MenuEctity implements Serializable{


    private static final long serialVersionUID = 348293969441970299L;
    /** 含子菜单 */
    private static final int MENUTYPE_PARENT = 1;
    /** 叶子菜单 */
    private static final int MENUTYPE_NODE = 2;
    /** 分割线 */
    private static final int MENUTYPE_LINE = 3;

    private int id;
    private String menuName;
    private String href;
    private Integer type;
    private String typeName;
    private ActionEntity actionId;
    private int parentId;
    private int sortOrder;
    private String remark;

    List<MenuEctity> subMenuList;

    @Column(name = "id", length = 32)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "menuName", length = 50)
    public String getMenuName() {
        return menuName;
    }

    public void setMenuName(String menuName) {
        this.menuName = menuName;
    }

    @Column(name = "href", length = 100)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Column(name = "type", length = 1)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        switch (type){
            case MENUTYPE_PARENT:
                this.typeName = "有子菜单";
                break;
            case MENUTYPE_NODE:
                this.typeName = "叶子菜单";
                break;
            case MENUTYPE_LINE:
                this.typeName = "分割线";
                break;
        }
        this.type = type;
    }

    @Transient
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @OneToOne
    @JoinColumn(name = "actionId")//在菜单表中，添加actionId字段
    public ActionEntity getActionId() {
        return actionId;
    }

    public void setActionId(ActionEntity actionId) {
        this.actionId = actionId;
    }

    @Column(name = "parentId", length = 32)
    public int getParentId() {
        return parentId;
    }

    public void setParentId(int parentId) {
        this.parentId = parentId;
    }

    @Column(name = "sortOrder", length = 20)
    public int getSortOrder() {
        return sortOrder;
    }

    public void setSortOrder(int sortOrder) {
        this.sortOrder = sortOrder;
    }

    @Column(name = "remark", length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public List<MenuEctity> getSubMenuList() {
        return subMenuList;
    }

    public void setSubMenuList(List<MenuEctity> subMenuList) {
        this.subMenuList = subMenuList;
    }
}
