package com.cjsecurite.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cjsecurite.model.role.Role;

public interface RoleRepository extends JpaRepository<Role, Long>{

	Role findByLabel(String label);
}
