package org.demo.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
@ResponseStatus(HttpStatus.NOT_FOUND)
public class RecordsNotFoundException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public RecordsNotFoundException(String message) {
        super(message);
    }

    public String getMessage(String noRecordsFound) {
        return noRecordsFound;
    }
}
