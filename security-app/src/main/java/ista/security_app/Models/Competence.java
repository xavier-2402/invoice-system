package ista.security_app.Models;

import java.util.HashSet;
import java.util.Set;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@Entity

public class Competence {
    @Id
    @Column(name = "competence_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer competenceId;
    private String name;
    private String description;

    @ManyToMany(mappedBy = "competences")
    private Set<Role> roles = new HashSet<>();
}
