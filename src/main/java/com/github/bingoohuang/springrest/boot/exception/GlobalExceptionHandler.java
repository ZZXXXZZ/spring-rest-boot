package com.github.bingoohuang.springrest.boot.exception;

import com.github.bingoohuang.utils.net.Http;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import javax.servlet.http.HttpServletResponse;

@ControllerAdvice
public class GlobalExceptionHandler {
    @ExceptionHandler(NotFoundException.class)
    public void handleConflict(NotFoundException ex, HttpServletResponse response) {
        Http.error(response, 500, ex);
    }

    @ExceptionHandler(RestException.class)
    public void handleConflict(RestException ex, HttpServletResponse response) {
        Http.error(response, ex.getHttpStatusCode(), ex);
    }

    @ExceptionHandler(Throwable.class)
    public void handleConflict(Throwable ex, HttpServletResponse response) {
        ex.printStackTrace();
        Http.error(response, 500, ex);
    }
}
