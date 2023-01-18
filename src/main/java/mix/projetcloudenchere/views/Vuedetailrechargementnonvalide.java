package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.time.Instant;
import java.time.LocalDate;

@Entity
@Immutable
@Table(name = "vuedetailrechargementnonvalides")
public class Vuedetailrechargementnonvalide {
    @Id
    @Column(name = "idrechargementcompte")
    private Integer idrechargementcompte;

    @Column(name = "montant")
    private Double montant;

    @Column(name = "dateheurechargement")
    private Instant dateheurechargement;

    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "nom", length = 20)
    private String nom;

    @Column(name = "prenom", length = 20)
    private String prenom;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "dateinscription")
    private LocalDate dateinscription;

    public LocalDate getDateinscription() {
        return dateinscription;
    }

    public String getEmail() {
        return email;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public Instant getDateheurechargement() {
        return dateheurechargement;
    }

    public Double getMontant() {
        return montant;
    }

    public Integer getIdrechargementcompte() {
        return idrechargementcompte;
    }

    protected Vuedetailrechargementnonvalide() {
    }
}