/// -----------------------CODE FOR SIMPLE ENTRY-----------------------------------------------------------
//package com.example.riyadb.controller;
//
//import java.util.List;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import com.example.riyadb.entity.Employee;
//import com.example.riyadb.service.EmployeeService;
//
//@RestController
//@RequestMapping("/employees")
//public class EmployeeController {
//
//    @Autowired
//    private EmployeeService service;
//
//    // ✅ ADD Single Employee
//    @PostMapping
//    public Employee addEmployee(@RequestBody Employee employee) {
//        return service.saveEmployee(employee);
//    }
//
//    // ✅ ADD Multiple Employees
//    @PostMapping("/batch")
//    public List<Employee> addEmployees(@RequestBody List<Employee> employees) {
//        return service.saveEmployees(employees);
//    }
//
//    // ✅ GET All Employees
//    @GetMapping
//    public List<Employee> findAllEmployees() {
//        return service.getEmployees();
//    }
//
//    // ✅ GET By ID
//    @GetMapping("/{empId}")
//    public Employee findEmployeeByEmpId(@PathVariable int empId) {
//        return service.getEmployeeById(empId);
//    }
//
//    // ✅ GET By First Name
//    @GetMapping("/name/{firstName}")
//    public Employee findEmployeeByFirstName(@PathVariable String firstName) {
//        return service.getEmployeeByFirstName(firstName);
//    }
//
//    // ✅ UPDATE Employee
//    @PutMapping
//    public Employee updateEmployee(@RequestBody Employee employee) {
//        return service.updateEmployee(employee);
//    }
//
//    // ✅ DELETE By ID
//    @DeleteMapping("/{empId}")
//    public String deleteEmployee(@PathVariable int empId) {
//        return service.deleteEmployee(empId);
//    }
//}
//--------------------------------------------------------------------------------------------------------

package com.example.riyadb.controller;

import com.example.riyadb.dto.EmployeeRequest;

import com.example.riyadb.entity.Employee;
import com.example.riyadb.service.EmployeeService;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping("/create")
    public Employee createEmployee(@RequestBody EmployeeRequest request) {
        return employeeService.saveEmployee(request);
    }

    @GetMapping("/{id}")
    public Employee getEmployee(@PathVariable int id) {
        return employeeService.getEmployee(id);
    }
     // ---------------------- UPDATE EMPLOYEE ----------------------
        @PutMapping("/update/{id}")
        public ResponseEntity<Employee> updateEmployee(
                @PathVariable int id,
                @RequestBody EmployeeRequest updatedEmployee) {

            Employee emp = employeeService.updateEmployee(id, updatedEmployee);
            return ResponseEntity.ok(emp);
            
        }
        //---------------
        @DeleteMapping("/delete/{id}")
        public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
            String response = employeeService.deleteEmployee(id);
            return ResponseEntity.ok(response);
        }

}
