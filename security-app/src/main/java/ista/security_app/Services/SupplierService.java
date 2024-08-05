package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Supplier;
import ista.security_app.Repositories.SupplierRepository;

@Service
public class SupplierService {
    private SupplierRepository repository; 

    public SupplierService(SupplierRepository repository){
        this.repository = repository;
    }
    
    public Supplier add(Supplier supplier){
        return repository.save(supplier);
    }

    public List<Supplier> getAll(){
        return repository.findAll();
    }

    public Optional<Supplier> getById(int id){
        return repository.findById(id);
    }
    
    public Supplier update(int id, Supplier supplier){
        Optional<Supplier> saved = repository.findById(id);
        if (saved.isPresent()) {
            Supplier toUpdate = saved.get();

            toUpdate.setRuc(supplier.getRuc());
            toUpdate.setTelephone(supplier.getTelephone());
            toUpdate.setCountry(supplier.getCountry());
            toUpdate.setEmail(supplier.getEmail());
            toUpdate.setCoin(supplier.getCoin());

            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
