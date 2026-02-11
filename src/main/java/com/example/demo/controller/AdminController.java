package com.example.demo.controller;


import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.demo.entity.Admin;
import com.example.demo.exception.BussinnessException;
import com.example.demo.response.R;
import com.example.demo.response.ResponseCode;
import com.example.demo.service.AdminService;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@Tag(name = "管理模块")
@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @Operation(summary = "增")
    @PostMapping("/admin/add")
    public R add(@RequestBody Admin admin)
    {
        LambdaQueryWrapper<Admin>  queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(Admin::getUsername,admin.getUsername());
        long count = adminService.count(queryWrapper);
        if(count > 0)
        {
            throw new BussinnessException(ResponseCode.USERNAME_EXISIT);
        }
        adminService.save(admin);
        return R.success();
    }

    @Operation(summary = "查")
    @PostMapping("/admin/list")
    public R<PageInfo<Admin>> list(@RequestBody Admin admin,@RequestParam Integer pageNum,@RequestParam Integer pageSize)
    {
        LambdaQueryWrapper<Admin> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.like(admin.getName() != null,Admin::getName,admin.getName());
        queryWrapper.like(admin.getTel() != null,Admin::getTel,admin.getTel());

        PageHelper.startPage(pageNum,pageSize);
        PageInfo<Admin> pageInfo = new PageInfo<>(adminService.list());
        return R.data(pageInfo);
    }

    @Operation(summary = "更新")
    @PostMapping("/admin/update")
    public R update(@RequestBody Admin admin)
    {
        adminService.updateById(admin);
        return R.success();
    }

    @Operation(summary = "删除")
    @PostMapping("/admin/del")
    public R del(@RequestParam  Long id)
    {
        adminService.removeById(id);
        return R.success();
    }
}
