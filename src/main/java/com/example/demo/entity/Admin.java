package com.example.demo.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data   //加了这个后就不用写getset
@TableName("admin") //表明
public class Admin {

    @TableId(type = IdType.AUTO)
    private Long id;

    private String username;
    private String password;
    private String name;
    private String sex;
    private String tel;
    private String headurl;

}
