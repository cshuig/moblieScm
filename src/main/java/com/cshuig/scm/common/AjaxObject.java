package com.cshuig.scm.common;

import java.io.Serializable;

/**
 * Created by Administrator on 2014/7/20.
 */
public class AjaxObject implements Serializable{

    private static final long serialVersionUID = 4769254487881814421L;
    private boolean type;
    private String msg;
    private Object obj;

    public AjaxObject() {
    }

    public AjaxObject(String msg) {
        this.msg = msg;
    }

    public boolean isType() {
        return type;
    }

    public void setType(boolean type) {
        this.type = type;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getObj() {
        return obj;
    }

    public void setObj(Object obj) {
        this.obj = obj;
    }
}
