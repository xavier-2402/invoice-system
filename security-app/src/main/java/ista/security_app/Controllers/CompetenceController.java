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

import ista.security_app.Models.Competence;
import ista.security_app.Services.CompetenceService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/competence")
public class CompetenceController {
    
    private CompetenceService service;

    public CompetenceController(CompetenceService service){
        this.service = service; 
    }

     @PostMapping("/add")
    public ResponseEntity<Competence> add(Competence competence){
        return new ResponseEntity<>(service.add(competence), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Competence>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Competence>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Competence> update(int id, Competence competence){
        return new ResponseEntity<>(service.update(id,competence),HttpStatus.OK);
    }
    

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Competence>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
