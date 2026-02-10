package com.example.demo.response;

import lombok.Getter;

/**
 * 统一的返回结果
 */
@Getter
public class R<T> {



    private Integer code;
    private String message;
    /**
     * 自定义类型数据
     */
    private T data;

    private R(Integer code)
    {
        this.code = code;
    }
    private R(Integer code, String message)
    {
        this.code = code;
        this.message = message;
    }
    private R(Integer code, String message,T data)
    {
        this.code = code;
        this.message = message;
        this.data = data;
    }

    public static <T> R<T> success()
    {
        return new R<>(ResponseCode.SUCCESS.getCode());
    }
    public static <T> R<T> success(String message)
    {
        return new R<>(ResponseCode.SUCCESS.getCode(),message);
    }

    public static <T> R<T> data(T data)
    {
        return new R<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),data);
    }
    public static <T> R<T> success(T data)
    {
        return new R<>(ResponseCode.SUCCESS.getCode(),ResponseCode.SUCCESS.getMessage(),data);
    }

    public static <T> R<T> error()
    {
        return new R<>(ResponseCode.ERROR.getCode(),ResponseCode.ERROR.getMessage());
    }

    public static <T> R<T> error(ResponseCode responseCode)
    {
        return new R<>(responseCode.getCode(), responseCode.getMessage());
    }

    public static <T> R<T> error(Integer code, String message)
    {
        return new R<>(code ,message);
    }

    public static <T> R<T> error(String message)
    {
        return new R<>(ResponseCode.ERROR.getCode(),message);

    }
}
