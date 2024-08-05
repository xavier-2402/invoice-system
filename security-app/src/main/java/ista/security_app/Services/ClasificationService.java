package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Clasification;
import ista.security_app.Repositories.ClasificationRepository;

@Service
public class ClasificationService {
    private ClasificationRepository repository; 

    public ClasificationService( ClasificationRepository repository){
        this.repository = repository;
    }

    public Clasification add(Clasification clasification){
        return repository.save(clasification);
    }

    public List<Clasification> getAll(){
        return repository.findAll();
    }

    public Optional<Clasification> getById(int id){
        return repository.findById(id);
    }

    public Clasification update(int id, Clasification clasification){
        Optional<Clasification> saved = repository.findById(id);
        if (saved.isPresent()) {
            Clasification toUpdate = saved.get();
            toUpdate.setGroup(clasification.getGroup());
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }

}
