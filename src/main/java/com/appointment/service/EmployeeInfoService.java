package com.appointment.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appointment.dao.EmployeeInfoRepository;
import com.appointment.form.EmployeeInfoForm;
import com.appointment.model.Address;
import com.appointment.model.Employee;

@Service
public class EmployeeInfoService {

	@Autowired
	private EmployeeInfoRepository employeeInfoRepository;

	public void insertEmployee(EmployeeInfoForm employeeInfoForm) {

		
		Address address = new Address();
		address.setAddressLine1(employeeInfoForm.getAddressLine1());
		address.setAddressLine2(employeeInfoForm.getAddressLine2());
		/*address.setOwner(employee);*/
		Employee employee = new Employee();
		employee.setName(employeeInfoForm.getName());
		employee.setEmailAddress(employeeInfoForm.getEmailAddress());
		employee.setMobileNo(employeeInfoForm.getMobileNo());
		employee.setAddress(address);
		
		employeeInfoRepository.save(employee);
	}
}
