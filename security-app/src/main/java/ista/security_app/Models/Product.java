package ista.security_app.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Product {
    
    @Id
    @Column(name = "product_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer productId;
    private Integer stock; 
    @Column(name = "unit_price")
    private Double unitPrice;
    private String unit;
    public Boolean iva;

    @ManyToOne
    @JoinColumn(name = "classification_id", referencedColumnName ="classification_id")
    private Clasification classification;

    @ManyToOne
    @JoinColumn(name = "supplier_id", referencedColumnName ="supplier_id")
    private Supplier supplier;

}
