package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "enchere")
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenchere", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idutilisateur")
    private Utilisateur idutilisateur;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idproduit", nullable = false)
    private Produit idproduit;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "prixminimumvente")
    private Double prixminimumvente;

    @Column(name = "dureeenchere")
    private Integer dureeenchere;

    @Column(name = "dateheureenchere")
    private Instant dateheureenchere;

    @Column(name = "status")
    private Integer status;

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Instant getDateheureenchere() {
        return dateheureenchere;
    }

    public void setDateheureenchere(Instant dateheureenchere) {
        this.dateheureenchere = dateheureenchere;
    }

    public Integer getDureeenchere() {
        return dureeenchere;
    }

    public void setDureeenchere(Integer dureeenchere) {
        this.dureeenchere = dureeenchere;
    }

    public Double getPrixminimumvente() {
        return prixminimumvente;
    }

    public void setPrixminimumvente(Double prixminimumvente) {
        this.prixminimumvente = prixminimumvente;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Produit getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Produit idproduit) {
        this.idproduit = idproduit;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}