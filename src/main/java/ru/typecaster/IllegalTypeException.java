package ru.typecaster;

import java.io.IOException;

/**
 * @author : faint
 * @date : 12.07.2023
 * @time : 15:43
 */
public class IllegalTypeException extends IOException {
    public IllegalTypeException() {
        super();
    }

    public IllegalTypeException(String message) {
        super(message);
    }

    public IllegalTypeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalTypeException(Throwable cause) {
        super(cause);
    }
}
