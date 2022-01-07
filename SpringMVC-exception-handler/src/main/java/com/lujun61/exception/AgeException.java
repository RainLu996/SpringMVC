package com.lujun61.exception;

/**
 * 当用户的年龄有异常时，抛出AgeException异常
 */
public class AgeException extends MyUserException{
    public AgeException() {
        super();
    }

    public AgeException(String message) {
        super(message);
    }
}
