
package com.example.riyadb.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "ADDRESS")
public class Address {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int addressId;

    private String city;
    private String state;

    // MANY TO ONE (many addresses belong to one employee)
    @ManyToOne
    @JoinColumn(name = "emp_id")
    private Employee employee;

    // Getters & Setters
    public int getAddressId() { return addressId; }
    public void setAddressId(int addressId) { this.addressId = addressId; }

    public String getCity() { return city; }
    public void setCity(String city) { this.city = city; }

    public String getState() { return state; }
    public void setState(String state) { this.state = state; }

    public Employee getEmployee() { return employee; }
    public void setEmployee(Employee employee) { this.employee = employee; }
}
