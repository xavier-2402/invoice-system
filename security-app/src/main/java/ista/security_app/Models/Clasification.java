package ista.security_app.Models;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity
public class Clasification {
    @Id
    @Column(name = "classification_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer classificationId;
    @Column(name = "group_name")
    private String group;

}
