package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Invoice;
import ista.security_app.Repositories.InvoiceRepository;

@Service
public class InvoiceService {
    
    private InvoiceRepository repository; 

    public InvoiceService(InvoiceRepository repository){
        this.repository = repository;
    }


    public Invoice add(Invoice invoice){
        return repository.save(invoice);
    }

    public List<Invoice> getAll(){
        return repository.findAll();
    }

    public Optional<Invoice> getById(int id){
        return repository.findById(id);
    }

    public Invoice update(int id, Invoice invoice ){
        Optional<Invoice> saved = repository.findById(id);
        if (saved.isPresent()) {
            Invoice toUpdate = saved.get();
            toUpdate.setRuc(invoice.getRuc());
            toUpdate.setDate(invoice.getDate());
            toUpdate.setTotal(invoice.getTotal());
            toUpdate.setDiscount(invoice.getDiscount());
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
