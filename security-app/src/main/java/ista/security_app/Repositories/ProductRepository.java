package ista.security_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.Product;

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {
    
}
