package ista.security_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    
}
