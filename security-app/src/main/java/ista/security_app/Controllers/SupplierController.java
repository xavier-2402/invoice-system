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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ista.security_app.Models.Supplier;
import ista.security_app.Services.SupplierService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/supplier")
public class SupplierController {
    
    private SupplierService service; 

    public SupplierController(SupplierService service){
        this.service = service;
    }

     @PostMapping("/add")
    public ResponseEntity<Supplier> add(Supplier supplier){
        return new ResponseEntity<>(service.add(supplier), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Supplier>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Supplier>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Supplier> update(int id, Supplier supplier){
        return new ResponseEntity<>(service.update(id,supplier),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Supplier>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
