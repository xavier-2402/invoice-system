package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.Person;
import ista.security_app.Repositories.PersonRepository;

@Service
public class PersonService {
    
    private PersonRepository repository; 

    public PersonService(PersonRepository repository){
        this.repository = repository;
    }

    public Person add(Person person){
        return repository.save(person);
    }

    public List<Person> getAll(){
        return repository.findAll();
    }

    public Optional<Person> getById(int id){
        return repository.findById(id);
    }

    public Person update(int id, Person person){
        Optional<Person> saved = repository.findById(id);
        if (saved.isPresent()) {
            Person toUpdate = saved.get();
            toUpdate.setFirstName(person.getFirstName());
            toUpdate.setLastName(person.getLastName());
            toUpdate.setDni(person.getDni());
            toUpdate.setEmail(person.getEmail());
            toUpdate.setPhone(person.getPhone());
            
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
