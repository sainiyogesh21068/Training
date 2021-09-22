package com.example.demo.controller;

import com.example.demo.model.Emp;
import com.example.demo.service.EmpService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@CrossOrigin
@RestController
public class EmpController {

    @Autowired
    EmpService empService;

    @GetMapping("/getallemp")
    public Collection<Emp> getAllEmp() {
        return empService.getAll();
    }

    @GetMapping("/findbyid")
    public Collection<Emp> findById(@RequestParam Integer id) {
        return empService.getById(id);
    }

    @PostMapping("/addemp")
    public boolean saveemp(@RequestBody Emp emp) {
        return empService.saveEmp(emp);
    }

    @PostMapping("/delemp")
    public boolean delemp(@RequestParam int id){
        return empService.delEmp(id);
    }
}
