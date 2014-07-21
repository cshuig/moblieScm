package com.cshuig.scm.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * Created by Administrator on 2014/7/20.
 */
@Entity
@Table(name = "TB_ROLE")
public class RoleEntity implements Serializable{

    private static final long serialVersionUID = 8656463447824864225L;
    private int id;
    private String roleName;
    private Integer status;
    private String remark;

    @Id
    @Column(name = "id", length = 32)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "roleName", length = 50)
    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    @Column(name = "status", length = 1)
    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Column(name = "remark", length = 200)
    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }
}
