package custom_exception;

import java.lang.Exception;

public class ParseFileErrorException extends Exception {
    public ParseFileErrorException(String error) {
        super(error);
    }
}