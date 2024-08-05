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

import ista.security_app.Models.Role;
import ista.security_app.Services.RoleService;


@CrossOrigin("*")
@RestController
@RequestMapping("/api/role")
public class RoleController {
    
    private RoleService  service; 

    public RoleController(RoleService service){
        this.service = service;
    }

    @PostMapping("/add")
    public ResponseEntity<Role> add(Role role){
        return new ResponseEntity<>(service.add(role), HttpStatus.OK);
    }

    @GetMapping("get-all")
    public ResponseEntity<List<Role>> getAll(){
        return new ResponseEntity<>(service.getAll(),HttpStatus.OK);
    }

    @GetMapping("get/{id}")
    public ResponseEntity<Optional<Role>> getById(int id){
        return new ResponseEntity<>(service.getById(id),HttpStatus.OK);
    }

    @PutMapping("update/{id}")
    public ResponseEntity<Role> update(int id, Role role){
        return new ResponseEntity<>(service.update(id,role),HttpStatus.OK);
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<List<Role>> delete(int id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
