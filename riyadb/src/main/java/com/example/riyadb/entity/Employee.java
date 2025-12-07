package com.example.riyadb.entity;

import jakarta.persistence.*;
import java.util.*;

@Entity
@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int empId;

    @Column(name = "firstName")
    private String firstName;

    @Column(name = "lastName")
    private String lastName;

    @Column(name = "email", nullable = false, length = 200)
    private String email;

    // ONE TO ONE → Adhar
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "aadhaar_id")   // FK located in EMPLOYEE table
    private Adharcard aadhaar;

    // ONE TO MANY → Address list
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<Address> addresses = new ArrayList<>();

    // MANY TO MANY → Roles
    @ManyToMany
    @JoinTable(
            name = "employee_roles",
            joinColumns = @JoinColumn(name = "emp_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    private Set<Role> roles = new HashSet<>();


    // Getters & Setters
    public int getEmpId() { return empId; }
    public void setEmpId(int empId) { this.empId = empId; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public Adharcard getAadhaar() { return aadhaar; }
    public void setAadhaar(Adharcard aadhaar) { this.aadhaar = aadhaar; }

    public List<Address> getAddresses() { return addresses; }
    public void setAddresses(List<Address> addresses) { this.addresses = addresses; }

    public Set<Role> getRoles() { return roles; }
    public void setRoles(Set<Role> roles) { this.roles = roles; }

    @Override
    public String toString() {
        return "Employee [empId=" + empId + ", firstName=" + firstName +
               ", lastName=" + lastName + ", email=" + email + "]";
    }
}
