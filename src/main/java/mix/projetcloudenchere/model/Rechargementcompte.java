package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "rechargementcompte")
public class Rechargementcompte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idrechargementcompte", nullable = false)
    private Integer id;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idutilisateur", nullable = false)
    private Integer idutilisateur;

    @Column(name = "montant", nullable = false)
    private Double montant;

    @Column(name = "dateheurechargement")
    private Timestamp dateheurechargement;

    @Column(name = "validation")
    private Integer validation;

    public Integer getValidation() {
        return validation;
    }

    public void setValidation(Integer validation) {
        this.validation = validation;
    }

    public Timestamp getDateheurechargement() {
        return dateheurechargement;
    }

    public void setDateheurechargement(Timestamp dateheurechargement) {
        this.dateheurechargement = dateheurechargement;
    }

    public Double getMontant() {
        return montant;
    }

    public void setMontant(Double montant) {
        this.montant = montant;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}