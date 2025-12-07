package com.example.riyadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.riyadb.entity.Adharcard;

public interface AdharRepository extends JpaRepository<Adharcard, Integer> {
}
