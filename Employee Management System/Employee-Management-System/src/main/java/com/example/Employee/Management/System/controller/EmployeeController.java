package com.example.Employee.Management.System.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.Employee.Management.System.model.Employee;
import com.example.Employee.Management.System.service.EmployeeService;

@RestController
public class EmployeeController {
	
@Autowired
EmployeeService employeeservice;

   @PostMapping("employee")
   public String addemployee(@RequestBody Employee employee) {
	  return employeeservice.addemployee(employee);
}
   @GetMapping("employee")
   public List<Employee>getallemployee(){
	   return employeeservice.getallemployee();
   }
  
   @PutMapping("Employee/name/{name}/id/{id}")
   public String updatenamebyid(@PathVariable Long id,@PathVariable String name) {
   	return employeeservice.updatenamebyid(id,name);
}
   
   @DeleteMapping("employee/id/{id}")
   public String removebyId(@PathVariable Long id) {
	   return employeeservice.removebyId(id);
   }
}



