package com.cshuig.scm.exception;

/**
 * Created by Administrator on 2014/7/21.
 */
public class ServiceException extends RuntimeException{
    private static final long serialVersionUID = -4481025235377160134L;

    public ServiceException() {
        super();
    }

    public ServiceException(String message) {
        super(message);
    }

    public ServiceException(String message, Throwable cause) {
        super(message, cause);
    }

    public ServiceException(Throwable cause) {
        super(cause);
    }
}
