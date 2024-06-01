package org.jenjetsu.graduate_project.exception;

public class LexerException extends RuntimeException {

    public LexerException() {
        super();
    }

    public LexerException(String msg) {
        super(msg);
    }

    public LexerException(Throwable cause) {
        super(cause);
    }

    public LexerException(String message, Throwable cause) {
        super(message, cause);
    }

}
