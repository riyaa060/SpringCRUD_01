package com.example.riyadb.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.example.riyadb.entity.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
