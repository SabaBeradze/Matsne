package dev.boot.exception;

public class NormativeActNofFoundException extends RuntimeException{
    public NormativeActNofFoundException() {
    }

    public NormativeActNofFoundException(String message) {
        super(message);
    }

    public NormativeActNofFoundException(String message, Throwable cause) {
        super(message, cause);
    }

    public NormativeActNofFoundException(Throwable cause) {
        super(cause);
    }

    public NormativeActNofFoundException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
