package com.example.demo.exception;

import com.example.demo.response.ResponseCode;
import lombok.Data;

@Data
public class BussinnessException extends RuntimeException{

    private Integer code;
    private  String message;
    public BussinnessException(Integer code,String message)
    {
        this.code = code;
        this.message = message;
    }

    public BussinnessException(String message)
    {
        this.message = message;
    }
    public BussinnessException(ResponseCode responseCode)
    {
        this.code = responseCode.getCode();
        this.message = responseCode.getMessage();
    }
}
