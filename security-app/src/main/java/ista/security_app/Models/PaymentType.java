package ista.security_app.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
@Entity
public class PaymentType {
    @Id
    @Column(name="payment_type_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer paymentTypeId;
    private String type;
    private String description;
    
}
