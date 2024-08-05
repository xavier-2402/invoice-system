package ista.security_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.Role;

@Repository
public interface RoleRepository extends JpaRepository<Role, Integer>{
    
}
