package cjSecurity.repository.role;


import org.springframework.data.jpa.repository.JpaRepository;

import cjSecurity.model.role.Role;

public interface IRoleRepository extends JpaRepository<Role, Long> {

	Role findByLabel(String label);

}
