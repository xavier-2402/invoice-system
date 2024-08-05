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

import ista.security_app.Models.Invoice;
import ista.security_app.Services.InvoiceService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoice")
public class InvoiceController {
    
    private InvoiceService service; 

    public InvoiceController(InvoiceService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Invoice> add(Invoice Invoice){
        return new ResponseEntity<>(service.add(Invoice), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Invoice>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Invoice>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Invoice> update(int id, Invoice invoice){
        return new ResponseEntity<>(service.update(id,invoice),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Invoice>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
