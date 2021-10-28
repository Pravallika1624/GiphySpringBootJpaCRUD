package com.app.Service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.Model.Employee;
import com.app.Repository.EmployeeRepository;
@Service
public class EmployeeServiceImpl implements EmployeeServiceDAO{
	@Autowired
	private EmployeeRepository empRepo;

	@Override
	public List<Employee> getAllEmp() {
		List<Employee> empList=empRepo.findAll();
		if(empList!=null && empList.size()>0) {
			return empList;
		}
		else {
			return null;
		}
	}

	@Override
	public Employee addEmp(Employee emp) {
		if(emp!=null) {
			return empRepo.saveAndFlush(emp);
		}
		else {
			return null;
		}
	}

	@Override
	public Employee fetchEmployeeByEmailAndPassword(String email, String password) {
		
		return empRepo.findByEmailAndPassword(email,password);
	}

}
