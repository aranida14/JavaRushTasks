package com.javarush.task.task22.task2201;

public class StringForSecondThreadTooShortException extends RuntimeException {
    public StringForSecondThreadTooShortException() {
    }

    public StringForSecondThreadTooShortException(String message) {
        super(message);
    }

    public StringForSecondThreadTooShortException(String message, Throwable cause) {
        super(message, cause);
    }

    public StringForSecondThreadTooShortException(Throwable cause) {
        super(cause);
    }

    public StringForSecondThreadTooShortException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
