package com.GateWayLearning.employeemicroservice.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
@Entity(name = "EMPLOYEE_TABLE")
public class Employee {
		
		@Id
	    @GeneratedValue(strategy = GenerationType.IDENTITY)
		@Column
		private Long employeeId;
		
		@Column
		private String firstName;
		
		@Column
		private Integer age;

		public Long getEmployeeId() {
			return employeeId;
		}

		public void setEmployeeId(Long employeeId) {
			this.employeeId = employeeId;
		}

		public String getFirstName() {
			return firstName;
		}

		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}

		public Integer getAge() {
			return age;
		}

		public void setAge(Integer age) {
			this.age = age;
		}
		
		
}
