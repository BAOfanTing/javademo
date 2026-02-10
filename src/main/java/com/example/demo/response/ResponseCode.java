package com.example.demo.response;

import lombok.AllArgsConstructor;
import lombok.Getter;

@AllArgsConstructor
@Getter
public enum ResponseCode {

    SUCCESS(200,"操作成功"),
    ERROR(500,"操作失败");

    private Integer code;
    private String message;
}
