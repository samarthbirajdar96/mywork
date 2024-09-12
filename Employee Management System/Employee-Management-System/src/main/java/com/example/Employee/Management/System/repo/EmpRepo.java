package com.example.Employee.Management.System.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.Employee.Management.System.model.Employee;


@Repository
public interface EmpRepo extends JpaRepository<Employee, Long> {

}
