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

import ista.security_app.Models.InvoiceItem;
import ista.security_app.Services.InvoiceItemService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/invoiceI-item")
public class InvoiceItemController {
    
    private InvoiceItemService service; 

    public InvoiceItemController(InvoiceItemService service){
        this.service = service; 
    }

     @PostMapping("/add")
    public ResponseEntity<InvoiceItem> add(InvoiceItem invoiceItem){
        return new ResponseEntity<>(service.add(invoiceItem), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<InvoiceItem>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<InvoiceItem>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<InvoiceItem> update(int id, InvoiceItem invoiceItem){
        return new ResponseEntity<>(service.update(id,invoiceItem),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<InvoiceItem>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

}
