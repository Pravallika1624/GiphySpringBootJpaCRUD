package com.app.Service;

import java.util.List;

import com.app.Model.Employee;

public interface EmployeeServiceDAO {
	public List<Employee> getAllEmp();
	public Employee addEmp(Employee emp);
	public Employee fetchEmployeeByEmailAndPassword(String email,String password);

}
