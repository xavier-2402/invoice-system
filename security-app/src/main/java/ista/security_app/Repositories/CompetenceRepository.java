package ista.security_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.Competence;

@Repository
public interface CompetenceRepository  extends JpaRepository<Competence, Integer>{

    
}