package ista.security_app.Repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.Supplier;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {
    
}
