package ista.security_app.Models;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Invoice {
    @Id
    @Column(name = "invoice_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer invoiceId;
    private String ruc;
    private Date date;
    private Double total;
    private Double discount;

    @ManyToOne
    @JoinColumn(name = "person_id", referencedColumnName ="person_id")
    private Person person;

    @ManyToOne
    @JoinColumn(name="payment_type_id", referencedColumnName ="payment_type_id")
    private PaymentType paymentType;
}
