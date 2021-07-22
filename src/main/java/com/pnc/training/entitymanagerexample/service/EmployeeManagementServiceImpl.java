package com.pnc.training.entitymanagerexample.service;


import com.pnc.training.entitymanagerexample.dao.EmployeeDao;
import com.pnc.training.entitymanagerexample.model.Department;
import com.pnc.training.entitymanagerexample.model.Employee;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
@AllArgsConstructor(onConstructor = @__(@Autowired))
@Transactional
public class EmployeeManagementServiceImpl implements EmployeeManagementService{

    EmployeeDao employeeDao;

    @Override
    public void saveEmployeeDetails(Employee employee) {
        employeeDao.save(employee);
    }

    @Override
    //@Transactional(value = Transactional.TxType.NOT_SUPPORTED, rollbackOn = Exception.class)
    public Employee retrieveEmployee(Long empId) {
        return employeeDao.retrieve(empId);
    }

    @Override
    public List<Employee> listAllEmployee() {
        return employeeDao.retrieveAll();
    }

    @Override
    public List<Employee> listAllEmployee(Long[] empIds) {
        return employeeDao.retrieveAllEmployees(empIds);
    }

    @Override
    public List<Employee> listAllEmployeeForDepartment(Long deptId) {
        return employeeDao.getAllEmpFromDept(deptId);
    }

    @Override
    public void deleteEmployee(Long empId) {
        employeeDao.delete(empId);
    }

}
