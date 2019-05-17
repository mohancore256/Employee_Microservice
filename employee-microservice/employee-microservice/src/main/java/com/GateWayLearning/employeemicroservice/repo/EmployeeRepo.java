package com.GateWayLearning.employeemicroservice.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.GateWayLearning.employeemicroservice.model.Employee;



@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>  {

}
