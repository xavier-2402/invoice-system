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

import ista.security_app.Models.PaymentType;
import ista.security_app.Services.PaymentTypeService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/payment-type")
public class PaymentTypeController {
    
    private PaymentTypeService service; 

    public PaymentTypeController(PaymentTypeService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<PaymentType> add(PaymentType paymentType){
        return new ResponseEntity<>(service.add(paymentType), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<PaymentType>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<PaymentType>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<PaymentType> update(int id, PaymentType paymentType){
        return new ResponseEntity<>(service.update(id,paymentType),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<PaymentType>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
