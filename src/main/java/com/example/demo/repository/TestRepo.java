package com.example.demo.repository;


import com.example.demo.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestRepo extends JpaRepository<Employee, Integer>
{

}
