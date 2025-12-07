package com.example.riyadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.riyadb.entity.Address;

public interface AddressRepository extends JpaRepository<Address, Integer> {
}
