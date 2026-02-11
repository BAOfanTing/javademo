package com.example.demo.exception;


import com.example.demo.response.R;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ControllerExceptionHandle {

    @ExceptionHandler(Exception.class)
    public R handleException(Exception e) {
            return R.error(e.getMessage());
    }

    @ExceptionHandler(BussinnessException.class)
    public R handleException(BussinnessException e) {
            return R.error(e.getCode(),e.getMessage());
    }
}
