package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.InvoiceItem;
import ista.security_app.Repositories.InvoiceItemRepository;

@Service
public class InvoiceItemService {
    
    private InvoiceItemRepository repository;

    public InvoiceItemService(InvoiceItemRepository repository){
        this.repository = repository;
    }

    
    public InvoiceItem add(InvoiceItem invoiceItem){
        return repository.save(invoiceItem);
    }

    public List<InvoiceItem> getAll(){
        return repository.findAll();
    }

    public Optional<InvoiceItem> getById(int id){
        return repository.findById(id);
    }

    public InvoiceItem update(int id, InvoiceItem invoiceItem){
        Optional<InvoiceItem> saved = repository.findById(id);
        if (saved.isPresent()) {
            InvoiceItem toUpdate = saved.get();
            toUpdate.setQuantity(invoiceItem.getQuantity());
            toUpdate.setPrice(invoiceItem.getPrice());
            toUpdate.setSubtotal(invoiceItem.getSubtotal());
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
