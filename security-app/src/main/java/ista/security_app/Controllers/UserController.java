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

import ista.security_app.Models.User;
import ista.security_app.Services.UserService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/user")
public class UserController {
    
    private UserService service; 

    public UserController(UserService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<User> add(@RequestBody User user){
        return new ResponseEntity<>(service.add(user), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<User>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<User>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<User> update(int id, @RequestBody User user){
        return new ResponseEntity<>(service.update(id,user),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<User>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
