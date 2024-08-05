package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Competence;
import ista.security_app.Repositories.CompetenceRepository;

@Service
public class CompetenceService {
    
    private CompetenceRepository repository;

    public CompetenceService(CompetenceRepository repository){
        this.repository = repository;
    }

    public Competence add(Competence competence){
        return repository.save(competence);
    }

    public List<Competence> getAll(){
        return repository.findAll();
    }

    public Optional<Competence> getById(int id){
        return repository.findById(id);
    }

    public Competence update(int id, Competence competence){
    Optional<Competence> saved = repository.findById(id);
        if (saved.isPresent()) {
            Competence toUpdate = saved.get();
            toUpdate.setName(competence.getName());
            toUpdate.setDescription(competence.getDescription());
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }

}
