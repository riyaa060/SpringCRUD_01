package com.example.riyadb.service;

import com.example.riyadb.dto.EmployeeRequest;
import com.example.riyadb.entity.*;
import com.example.riyadb.repository.*;

import org.springframework.stereotype.Service;

import java.util.*;
import com.example.riyadb.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepo;
    private final RoleRepository roleRepo;

    public EmployeeServiceImpl(EmployeeRepository employeeRepo, RoleRepository roleRepo) {
        this.employeeRepo = employeeRepo;
        this.roleRepo = roleRepo;
    }

    // ------------------ CREATE EMPLOYEE ------------------
    @Override
    public Employee saveEmployee(EmployeeRequest request) {

        Employee emp = new Employee();
        emp.setFirstName(request.getFirstName());
        emp.setLastName(request.getLastName());
        emp.setEmail(request.getEmail());

        // Aadhaar (One-to-One)
        Adharcard ac = new Adharcard();
        ac.setAadhaarNumber(request.getAadhaar().aadhaarNumber);
        emp.setAadhaar(ac);

        // Address list (One-to-Many)
        List<Address> addressList = new ArrayList<>();
        if (request.getAddresses() != null) {
            for (EmployeeRequest.AddressDto dto : request.getAddresses()) {
                Address address = new Address();
                address.setCity(dto.city);
                address.setState(dto.state);
                address.setEmployee(emp);
                addressList.add(address);
            }
        }
        emp.setAddresses(addressList);

        // Roles (Many-to-Many)
        if (request.getRoleIds() != null) {
            Set<Role> roles = new HashSet<>(roleRepo.findAllById(request.getRoleIds()));
            emp.setRoles(roles);
        }

        return employeeRepo.save(emp);
    }

    // ------------------ GET EMPLOYEE ------------------
    @Override
    public Employee getEmployee(int id) {
        return employeeRepo.findById(id).orElse(null);
    }
    
 // ------------------ DELETE EMPLOYEE ------------------
    @Override
    public String deleteEmployee(int id) {

        if (!employeeRepo.existsById(id)) {
            throw new RuntimeException("Employee not found with id: " + id);
        }

        employeeRepo.deleteById(id);
        return "Employee deleted successfully with id: " + id;
    }


 // ------------------ UPDATE EMPLOYEE ------------------
    @Override
    public Employee updateEmployee(int id, EmployeeRequest request) {

        Employee existing = employeeRepo.findById(id)
                .orElseThrow(() -> new RuntimeException("Employee not found with id: " + id));

        // ✅ Update basic fields
        existing.setFirstName(request.getFirstName());
        existing.setLastName(request.getLastName());
        existing.setEmail(request.getEmail());

        // ✅ Update Aadhaar (1-1)
        if (request.getAadhaar() != null) {
            existing.getAadhaar()
                    .setAadhaarNumber(request.getAadhaar().aadhaarNumber);
        }

        // ✅ Update Address List (1-M)
        if (request.getAddresses() != null) {
            existing.getAddresses().clear();

            for (EmployeeRequest.AddressDto dto : request.getAddresses()) {
                Address addr = new Address();
                addr.setCity(dto.city);
                addr.setState(dto.state);
                addr.setEmployee(existing);
                existing.getAddresses().add(addr);
            }
        }

        // ✅ Update Roles (M-M)
        if (request.getRoleIds() != null) {
            existing.setRoles(new HashSet<>(roleRepo.findAllById(request.getRoleIds())));
        }

        return employeeRepo.save(existing);
    }

}
