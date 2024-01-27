package org.sc.etlservice.exceptions;

public class DataNotFoundException extends RuntimeException{
    public DataNotFoundException() {
        super("No data exists");
    }

    public DataNotFoundException(Long id) {
        super("Data not found for id "+ id);
    }
}
