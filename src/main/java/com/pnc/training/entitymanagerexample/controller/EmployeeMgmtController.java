package com.pnc.training.entitymanagerexample.controller;

import com.pnc.training.entitymanagerexample.model.Department;
import com.pnc.training.entitymanagerexample.model.Employee;
import com.pnc.training.entitymanagerexample.service.EmployeeManagementService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@AllArgsConstructor(onConstructor = @__(@Autowired))
public class EmployeeMgmtController {

    private EmployeeManagementService employeeManagementService;

    @GetMapping("/employee/retrieve/{id}")
    public ResponseEntity<Employee> getEmployee(@PathVariable("id") Long empId){
        return ResponseEntity.ok(employeeManagementService.retrieveEmployee(empId));
    }
    @GetMapping("/employee/retrieve/all")
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return ResponseEntity.ok(employeeManagementService.listAllEmployee());
    }

    @GetMapping("/employee/retrieve")
    public ResponseEntity<List<Employee>> getAllEmployee(@RequestParam Long[] empIds){
        return ResponseEntity.ok(employeeManagementService.listAllEmployee(empIds));
    }
    @PutMapping("/employee/save")
    public ResponseEntity saveEmployee(@RequestBody Employee employee){
        employeeManagementService.saveEmployeeDetails(employee);
        return ResponseEntity.ok(null);
    }
    @DeleteMapping("/employee/delete/{id}")
    public ResponseEntity saveEmployee(@PathVariable("id") Long empId){
        employeeManagementService.deleteEmployee(empId);
        return ResponseEntity.ok(null);
    }
        @GetMapping("/department/retrieve/employee/{id}")
    public ResponseEntity<List<Employee>> retrieveAllDepartmentEmployee(@PathVariable("id") Long deptId){
        return ResponseEntity.ok(employeeManagementService.listAllEmployeeForDepartment(deptId));
    }
}
