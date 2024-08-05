package ista.security_app.Repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ista.security_app.Models.Invoice;

@Repository
public interface InvoiceRepository  extends JpaRepository<Invoice, Integer>{
    
}
