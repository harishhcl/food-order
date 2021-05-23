package com.hcl.foodorder.security.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.hcl.foodorder.security.domain.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Long> {

}
