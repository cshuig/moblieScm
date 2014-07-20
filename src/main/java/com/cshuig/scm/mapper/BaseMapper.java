package com.cshuig.scm.mapper;

import com.cshuig.scm.exception.DaoException;

/**
 * Created by Administrator on 2014/7/20.
 */
public interface BaseMapper<T> {

    public T addObject(T t) throws DaoException;
}
