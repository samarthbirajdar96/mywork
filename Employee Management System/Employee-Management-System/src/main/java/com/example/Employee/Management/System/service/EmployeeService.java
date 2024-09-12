package com.example.Employee.Management.System.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.Employee.Management.System.model.Employee;
import com.example.Employee.Management.System.repo.EmpRepo;


@Service
public class EmployeeService {
	
	@Autowired
	EmpRepo emprepo;

	public String addemployee(Employee employee) {
		emprepo.save(employee);
		return "employee sucessfully added";
	}

	public List<Employee> getallemployee() {
		return (List<Employee>)emprepo.findAll();
		
	}

	public String updatenamebyid(Long id, String name) {
	    if (emprepo.existsById(id)) {
	        Employee employee = emprepo.findById(id).get();
	        employee.setEmpName(name);
	        emprepo.save(employee);
	        return "employee updated";
	    } else {
	        return "invalid Id";
	    }
	}


	public String removebyId(Long id) {
		if(emprepo.existsById(id)) {
			emprepo.deleteById(id);
			return "employee deleted";
		}else {
			return "invalid Id";
		}
	}
	

}
