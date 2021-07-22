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
    /*@GetMapping("/department/retrieve/all")
    public ResponseEntity<List<Department>> retrieveAllDepartment(){
        return ResponseEntity.ok(employeeManagementService.retrieveAllDepartments());
    }*/
}
