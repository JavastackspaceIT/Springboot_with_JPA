package com.appointment.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.appointment.model.Employee;

public interface EmployeeInfoRepository extends JpaRepository<Employee,Integer> {

}
