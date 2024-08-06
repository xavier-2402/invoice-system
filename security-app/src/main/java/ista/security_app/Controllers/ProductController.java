package ista.security_app.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ista.security_app.Models.Product;
import ista.security_app.Services.ProductService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/Product")
public class ProductController {
    
    private ProductService service; 

    public ProductController(ProductService service){
        this.service = service; 
    }

     @PostMapping("/add")
    public ResponseEntity<Product> add(@RequestBody Product product){
        return new ResponseEntity<>(service.add(product), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Product>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Product>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Product> update(int id,@RequestBody Product product){
        return new ResponseEntity<>(service.update(id,product),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Product>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
