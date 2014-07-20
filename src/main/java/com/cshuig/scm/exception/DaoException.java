package com.cshuig.scm.exception;

/**
 * Created by Administrator on 2014/7/20.
 */
public class DaoException extends RuntimeException{
    private static final long serialVersionUID = -6273043020801086098L;

    public DaoException() {
        super();
    }

    public DaoException(String message) {
        super(message);
    }

    public DaoException(String message, Throwable cause) {
        super(message, cause);
    }

    public DaoException(Throwable cause) {
        super(cause);
    }
}
