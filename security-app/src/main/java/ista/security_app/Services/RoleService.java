package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Role;
import ista.security_app.Repositories.RoleRepository;

@Service
public class RoleService {
    
    private RoleRepository repository; 

    public RoleService(RoleRepository repository){
        this.repository = repository;
    }
    
    public Role add(Role Role){
        return repository.save(Role);
    }

    public List<Role> getAll(){
        return repository.findAll();
    }

    public Optional<Role> getById(int id){
        return repository.findById(id);
    }

    public Role update(int id, Role role){
        Optional<Role> saved = repository.findById(id);
        if (saved.isPresent()) {
            Role toUpdate = saved.get();
            toUpdate.setRole(role.getRole());
            toUpdate.setState(role.isState());
            
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
