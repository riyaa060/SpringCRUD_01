package com.example.riyadb.dto;

import java.util.*;

public class EmployeeRequest {

    private String firstName;
    private String lastName;
    private String email;

    private AadharDto aadhaar;

    private List<AddressDto> addresses;

    private List<Integer> roleIds;  // many-to-many mapping

    // Inner DTOs
    public static class AadharDto {
        public String aadhaarNumber;
    }

    public static class AddressDto {
        public String city;
        public String state;
    }

    // Getters & Setters
    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }

    public AadharDto getAadhaar() { return aadhaar; }
    public void setAadhaar(AadharDto aadhaar) { this.aadhaar = aadhaar; }

    public List<AddressDto> getAddresses() { return addresses; }
    public void setAddresses(List<AddressDto> addresses) { this.addresses = addresses; }

    public List<Integer> getRoleIds() { return roleIds; }
    public void setRoleIds(List<Integer> roleIds) { this.roleIds = roleIds; }
}
