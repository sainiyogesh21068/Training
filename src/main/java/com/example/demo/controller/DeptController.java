package com.example.demo.controller;

import com.example.demo.model.Dept;
import com.example.demo.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
public class DeptController {

    @Autowired
    DeptService deptService;

    @GetMapping("/getalldept")
    public Collection<Dept> getAllDept() {
        return deptService.getAll();
    }

    @GetMapping("/finddeptbyid")
    public Collection<Dept> findDeptById(@RequestParam Integer id) {
        return deptService.getById(id);
    }

    @PostMapping("/adddept")
    public boolean savedept(@RequestBody Dept dept) {
        return deptService.saveDept(dept);
    }

    @PostMapping("/deldept")
    public boolean deldept(@RequestParam int id){
        return deptService.delDept(id);
    }
}
