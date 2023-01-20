package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "enchere")
public class Enchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idenchere", nullable = false)
    private Integer id;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idproduit", nullable = false)
    private Integer idproduit;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "prixminimumvente")
    private Double prixminimumvente;

    @Column(name = "dureeenchere")
    private Integer dureeenchere;

    @Column(name = "dateheureenchere")
    private Timestamp dateheureenchere;

    @Column(name = "status")
    private Integer status;


    public Enchere(Integer idproduit,Integer idutilisateur, String description, Double prixminimumvente,Timestamp dateheureenchere , Integer dureeenchere) {
        this.idproduit = idproduit;
        this.idutilisateur = idutilisateur;
        this.description = description;
        this.prixminimumvente = prixminimumvente;
        this.dureeenchere = dureeenchere;
        this.dateheureenchere = dateheureenchere;
    }

    public Enchere() {

    }


    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Timestamp getDateheureenchere() {
        return dateheureenchere;
    }

    public void setDateheureenchere(Timestamp dateheureenchere) {
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

    public Integer getIdproduit() {
        return idproduit;
    }

    public void setIdproduit(Integer idproduit) {
        this.idproduit = idproduit;
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