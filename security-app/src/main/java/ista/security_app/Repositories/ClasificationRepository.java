package ista.security_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.Clasification;

@Repository
public interface ClasificationRepository extends JpaRepository<Clasification, Integer>{
    
}
