package com.cshuig.scm;

import com.cshuig.scm.entity.RoleEntity;

import java.util.List;

/**
 * Created by cshuig on 2014/10/13.
 */
public class UserDto {

    private int id;
    private String name;
    private RoleEntity[] roleLists;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public RoleEntity[] getRoleLists() {
        return roleLists;
    }

    public void setRoleLists(RoleEntity[] roleLists) {
        this.roleLists = roleLists;
    }

    @Override
    public String toString() {
        return "UserDto{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", roleLists=" + roleLists +
                '}';
    }
}
