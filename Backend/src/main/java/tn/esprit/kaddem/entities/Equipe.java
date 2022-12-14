package tn.esprit.kaddem.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "Equipe")
public class Equipe implements Serializable {

    @ManyToOne
    Encadrant encadrant;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int idEquipe;
    private String nomEquipe;
    @Enumerated(EnumType.STRING)
    private Niveau niveau;
    @OneToOne
    private DetailEquipe detailEquipe;
    @ManyToMany
    @JsonIgnore
    private Set<Etudiant> etudiants;
    /*--  Added  */
    @Column(nullable = true, length = 64)
    private String photos;
    private float rating;

    @Transient
    public String getPhotosImagePath() {
        if (this.photos == null)
            return null;

        return "/equipe-photos/" + idEquipe + "/" + photos;
    }

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "equipe")
    @JsonIgnore
    private Set<Projet> projets;

}