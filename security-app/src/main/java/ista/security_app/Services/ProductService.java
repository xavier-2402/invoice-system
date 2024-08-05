package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Product;
import ista.security_app.Repositories.ProductRepository;

@Service
public class ProductService {
    
    private ProductRepository repository; 

    public ProductService(ProductRepository repository){
        this.repository = repository;
    }

    public Product add(Product Product){
        return repository.save(Product);
    }

    public List<Product> getAll(){
        return repository.findAll();
    }

    public Optional<Product> getById(int id){
        return repository.findById(id);
    }

    public Product update(int id, Product product){
        Optional<Product> saved = repository.findById(id);
        if (saved.isPresent()) {
            Product toUpdate = saved.get();
            toUpdate.setStock(product.getStock());
            toUpdate.setUnitPrice(product.getUnitPrice());
            toUpdate.setUnit(product.getUnit());
            toUpdate.setIva(product.getIva());
            
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
