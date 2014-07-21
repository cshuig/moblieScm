package com.cshuig.scm.entity;

import javax.persistence.*;
import java.beans.Transient;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Administrator on 2014/6/16.
 */
@Entity
@Table(name = "TB_USER")
public class UserEntity implements Serializable{

    private static final long serialVersionUID = -7013233561185317156L;
    private int id;
    private String userName;
    private String password;
    private String remark;
    private String createId;
    private String createTime;
    private String lastLoginTime;
    private Integer status;
    private List<RoleEntity> rolesList;

    @Id
    @Column(name = "id", length = 32)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "userName", length = 50)
    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    @Column(name = "passwork", length = 32)
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Column(name = "remark", length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    @Column(name = "createId", length = 32)
    public String getCreateId() {
        return createId;
    }

    public void setCreateId(String createId) {
        this.createId = createId;
    }

    @Column(name = "createTime", length = 20)
    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Column(name = "lastLoginTime", length = 20)
    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    @Column(name = "status", length = 1)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Transient
    @ElementCollection(targetClass=RoleEntity.class)
    public List<RoleEntity> getRolesList() {
        return rolesList;
    }

    public void setRolesList(List<RoleEntity> rolesList) {
        this.rolesList = rolesList;
    }
}
