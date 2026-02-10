package com.example.demo.controller;


import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;

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
    public Long add(@RequestBody Admin admin)
    {
        adminService.save(admin);
        return admin.getId();
    }

    @Operation(summary = "查")
    @GetMapping("/admin/list")
    public List<Admin> list()
    {
        return adminService.list();
    }

    @Operation(summary = "更新")
    @PostMapping("/admin/update")
    public Long update(@RequestBody Admin admin)
    {
        adminService.updateById(admin);
        return admin.getId();
    }

    @Operation(summary = "删除")
    @PostMapping("/admin/del")
    public String del(@RequestParam  Long id)
    {
        adminService.removeById(id);
        return "success";
    }
}
