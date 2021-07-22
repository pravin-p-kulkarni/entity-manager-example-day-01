package com.pnc.training.entitymanagerexample.service;

import com.pnc.training.entitymanagerexample.model.Department;
import com.pnc.training.entitymanagerexample.model.Employee;

import java.util.List;

public interface EmployeeManagementService {
    Employee retrieveEmployee(Long empId);
    void saveEmployeeDetails(Employee employee);
    void deleteEmployee(Long empId);
    List<Employee> listAllEmployee();
    List<Employee> listAllEmployee(Long[] empIds);
    List<Employee> listAllEmployeeForDepartment(Long deptId);
    //List<Department> retrieveAllDepartments();
}
