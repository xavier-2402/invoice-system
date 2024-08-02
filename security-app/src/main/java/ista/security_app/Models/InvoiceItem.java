package ista.security_app.Models;

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
public class InvoiceItem {
    @Id
    @Column(name = "invoice_item_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int invoiceItemId;

    @Column(name = "invoice_id")
    private int invoiceId;

    private int quantity;
    private Double price; 
    private Double subtotal;

    @ManyToOne
    @JoinColumn(name="product_id", referencedColumnName ="product_id")
    private Product product;

}
