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

import ista.security_app.Models.Clasification;
import ista.security_app.Services.ClasificationService;

@CrossOrigin("*")
@RestController
@RequestMapping("/api/clasification")
public class ClasificationController {
    
    private ClasificationService service; 

    public ClasificationController(ClasificationService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Clasification> add(@RequestBody Clasification clasification){
        return new ResponseEntity<>(service.add(clasification), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Clasification>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Clasification>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Clasification> update(int id,@RequestBody Clasification clasification){
        return new ResponseEntity<>(service.update(id,clasification),HttpStatus.OK);
    }
    

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Clasification>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
