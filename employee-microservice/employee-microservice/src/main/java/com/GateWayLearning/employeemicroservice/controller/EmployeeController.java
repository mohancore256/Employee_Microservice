package com.GateWayLearning.employeemicroservice.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.GateWayLearning.employeemicroservice.model.Employee;
import com.GateWayLearning.employeemicroservice.service.EmployeeService;



@RestController
@EnableEurekaClient
@RequestMapping(value = "/employee")
public class EmployeeController {

	@Autowired
	public EmployeeService employeeService;
	
	@PostMapping(value = "/save")
	public ResponseEntity<?> createEmployee(@RequestBody Employee employee) {
		ModelMap map = new ModelMap();
		ResponseEntity<?> response;
		Employee employeeResponse =  employeeService.saveEmployee(employee);
		if(employeeResponse != null && employeeResponse.getEmployeeId() > 0) {
			map.put("Employee Saved", employeeResponse);
			response = new ResponseEntity<>(map, HttpStatus.OK);
		}else {
			map.put("Employee Not Saved", "Bad Request");
			response = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
	
	@GetMapping(value ="/get")
	public ResponseEntity<?> readEmployee(@PathVariable Long employeeId){
		ModelMap map = new ModelMap();
		ResponseEntity<?> response;
		Optional<Employee> employeeResponse =  employeeService.getEmployee(employeeId);
		if(employeeResponse != null) {
			map.put("Employee Detail Requested", employeeResponse);
			response = new ResponseEntity<>(map, HttpStatus.OK);
		}else {
			map.put("Employee Not Saved", "Bad Request");
			response = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
		return response;
		}
	
	
	@DeleteMapping(value = "/delete")
	public ResponseEntity<?> deleteEmployee(@PathVariable Long employeeId){
		ModelMap map = new ModelMap();
		ResponseEntity<?> response;
		employeeService.deleteEmployee(employeeId);
		map.put("Employee Detail Deleted ", " "+employeeId+" ");
		return response = new ResponseEntity<>(map, HttpStatus.NOT_FOUND);
		}
	
	@PutMapping(value = "/update")
	public ResponseEntity<?> updateEmployee(@RequestBody Employee employee) {
		ModelMap map = new ModelMap();
		ResponseEntity<?> response;
		Employee employeeResponse =  employeeService.updateEmployee(employee);
		if(employeeResponse != null && employeeResponse.getEmployeeId() > 0) {
			map.put("Employee updated", employeeResponse);
			response = new ResponseEntity<>(map, HttpStatus.OK);
		}else {
			map.put("Employee Not updated", "Bad Request");
			response = new ResponseEntity<>(map, HttpStatus.BAD_REQUEST);
		}
		return response;
	}
}
