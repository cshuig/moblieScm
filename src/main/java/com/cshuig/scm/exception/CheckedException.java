package com.cshuig.scm.exception;

/**
 * Created by Administrator on 2014/6/20.
 */
public class CheckedException extends RuntimeException{

    private static final long serialVersionUID = 9068376142077893477L;

    public CheckedException() {
        super();
    }

    public CheckedException(String message) {
        super(message);
    }

    public CheckedException(String message, Throwable cause) {
        super(message, cause);
    }

    public CheckedException(Throwable cause) {
        super(cause);
    }
}
