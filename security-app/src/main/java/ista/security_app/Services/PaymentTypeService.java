package ista.security_app.Services;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import ista.security_app.Models.PaymentType;
import ista.security_app.Repositories.PaymentTypeRepository;

@Service
public class PaymentTypeService {
    

    private PaymentTypeRepository repository; 

    public PaymentTypeService(PaymentTypeRepository repository){
        this.repository = repository;
    }


    public PaymentType add(PaymentType paymentType){
        return repository.save(paymentType);
    }

    public List<PaymentType> getAll(){
        return repository.findAll();
    }

    public Optional<PaymentType> getById(int id){
        return repository.findById(id);
    }

    public PaymentType update(int id, PaymentType paymentType){
    Optional<PaymentType> saved = repository.findById(id);
        if (saved.isPresent()) {
            PaymentType toUpdate = saved.get();
            toUpdate.setType(paymentType.getType());
            toUpdate.setDescription(paymentType.getDescription());
            return repository.save(toUpdate);
        }else{
            return null;
        }
    }

    public void delete(int id){
        repository.deleteById(id);
    }
}
