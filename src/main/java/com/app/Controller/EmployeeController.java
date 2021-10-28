package com.app.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.Model.Employee;
import com.app.Service.EmployeeServiceDAO;
import com.app.Service.EmployeeServiceImpl;



@RestController
@RequestMapping("api/v1")
public class EmployeeController {
	@Autowired
	private EmployeeServiceDAO empService;
	
	
	@GetMapping("/getAll")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> getAllEmp(){
		List<Employee> empList=empService.getAllEmp();
		if(empList!=null) {
			return new ResponseEntity<List<Employee>>(empList,HttpStatus.OK);
		}
		return new ResponseEntity<String>("Employee List is Empty...",HttpStatus.NO_CONTENT);
	}
	
	@PostMapping(value="/addEmp",consumes="application/json; charset=utf-8")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> addEmpployee(@RequestBody Employee emp){
		if(empService.addEmp(emp)!=null) {
			return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Sorry! Do not Inserted...",HttpStatus.CONFLICT);
	}
	
	
	
	
	
	@PostMapping("/login")
	@CrossOrigin(origins = "http://localhost:4200")
	public Employee loginUser(@RequestBody Employee emp) throws Exception {
		String tempEmailID=emp.getEmail();
		String tempPassword =emp.getPassword();
		Employee empObj=null;
		if(tempEmailID != null && tempPassword != null) {
			empObj=empService.fetchEmployeeByEmailAndPassword(tempEmailID,tempPassword);
		}
		if(empObj == null) {
			throw new Exception("bad Credentials");
		}
		return empObj;
	}
	
	@PutMapping(value="/updateEmp",consumes="application/json; charset=utf-8")
	@CrossOrigin(origins = "http://localhost:4200")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee emp){
		if(empService.addEmp(emp)!=null) {
			return new ResponseEntity<Employee>(emp,HttpStatus.CREATED);
		}
		return new ResponseEntity<String>("Sorry! Do not Updated...",HttpStatus.CONFLICT);
	}
	

}
