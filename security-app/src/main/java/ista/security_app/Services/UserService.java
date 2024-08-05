package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.User;
import ista.security_app.Repositories.UserRepository;

@Service
public class UserService {
    
    private UserRepository repository; 

    public UserService(UserRepository repository){
        this.repository = repository;
    }
    
    public User add(User user){
        return repository.save(user);
    }

    public List<User> getAll(){
        return repository.findAll();
    }

    public Optional<User> getById(int id){
        return repository.findById(id);
    }

    public User update(int id, User user){
        Optional<User> saved = repository.findById(id);
        if (saved.isPresent()) {
            User toUpdate = saved.get();
            toUpdate.setUsername(user.getUsername());
            toUpdate.setPassword(user.getPassword());

            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
