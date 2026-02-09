package com.example.demo.controller;


import com.example.demo.entity.Admin;
import com.example.demo.service.AdminService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.List;

@RestController
public class AdminController {
    @Resource
    private AdminService adminService;

    @PostMapping("/admin/add")
    public Long add(@RequestBody Admin admin)
    {
        adminService.save(admin);
        return admin.getId();
    }

    @GetMapping("/admin/list")
    public List<Admin> list()
    {
        return adminService.list();
    }

    @PostMapping("/admin/update")
    public Long update(@RequestBody Admin admin)
    {
        adminService.updateById(admin);
        return admin.getId();
    }

    @PostMapping("/admin/del")
    public String del(@RequestParam  Long id)
    {
        adminService.removeById(id);
        return "success";
    }
}
