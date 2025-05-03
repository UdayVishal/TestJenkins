package com.example.demo.service;

import com.example.demo.model.Employee;
import com.example.demo.repository.TestRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DemoService {


    @Autowired
    TestRepo testRepo;

    public List<Employee> listEmp()
    {
       return testRepo.findAll();
    }


}
