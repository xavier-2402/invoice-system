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

import ista.security_app.Models.Person;
import ista.security_app.Services.PersonService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/person")
public class PersonController {
    

    private PersonService service; 

    public PersonController(PersonService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Person> add(Person person){
        return new ResponseEntity<>(service.add(person), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Person>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Person>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Person> update(int id, Person person){
        return new ResponseEntity<>(service.update(id,person),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Person>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
