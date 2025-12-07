package com.example.riyadb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "AADHAR")
public class Adharcard {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int aadhaarId;

    @Column(nullable = false, unique = true)
    private String aadhaarNumber;

    // Optional reverse mapping (not required, but useful)
    @OneToOne(mappedBy = "aadhaar")
    private Employee employee;

    // Getters & Setters
    public int getAadhaarId() { return aadhaarId; }
    public void setAadhaarId(int aadhaarId) { this.aadhaarId = aadhaarId; }

    public String getAadhaarNumber() { return aadhaarNumber; }
    public void setAadhaarNumber(String aadhaarNumber) { this.aadhaarNumber = aadhaarNumber; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
