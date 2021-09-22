package com.example.demo.service;

import com.example.demo.model.Dept;
import com.example.demo.sql.DeptDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;

@Service
public class DeptService {
    @Autowired
    DeptDao deptDao;

    public Collection<Dept> getAll(){
        return deptDao.findAll();
    }

    public Collection<Dept> getById( Integer id){
        return deptDao.findById(id);
    }

    public boolean saveDept(Dept dept){
        return deptDao.saveDept(dept);
    }

    public boolean delDept(int id){
        return deptDao.delDept(id);
    }
}
