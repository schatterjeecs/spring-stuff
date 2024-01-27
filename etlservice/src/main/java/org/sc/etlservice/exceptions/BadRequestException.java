package org.sc.etlservice.exceptions;

public class BadRequestException extends RuntimeException{
    public BadRequestException() {
        super("Bad Disgusting Input");
    }
}
