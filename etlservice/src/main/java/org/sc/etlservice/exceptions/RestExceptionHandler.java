package org.sc.etlservice.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.ServerResponse.notFound;
import static org.springframework.web.reactive.function.server.ServerResponse.badRequest;

@RestControllerAdvice
@Slf4j
public class RestExceptionHandler {
    @ExceptionHandler(DataNotFoundException.class)
    Mono<ServerResponse> dataNotFound(DataNotFoundException ex) {
        log.debug("Exception raised due to data not found: "+ex);
        return notFound().build();
    }

    @ExceptionHandler(BadRequestException.class)
    Mono<ServerResponse> badRequestEx(BadRequestException ex) {
        log.debug("Exception raised due to bad request "+ex);
        return badRequest().build();
    }
}
