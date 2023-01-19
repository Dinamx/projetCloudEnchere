package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Immutable
@Table(name = "surencheredetails")
public class Surencheredetail {
    @Id
    @Column(name = "idsurenchere")
    private Integer idsurenchere;

    @Column(name = "idenchere")
    private Integer idenchere;

    @Column(name = "idsurencherisseur")
    private Integer idsurencherisseur;

    @Column(name = "montant_offre")
    private Double montantOffre;

    @Column(name = "dateheuremise")
    private Timestamp dateheuremise;

    @Column(name = "prixminimumvente")
    private Double prixminimumvente;

    @Column(name = "descriptionenchere", length = 100)
    private String descriptionenchere;

    @Column(name = "nom", length = 20)
    private String nom;

    @Column(name = "prenom", length = 20)
    private String prenom;

    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "description", length = 100)
    private String description;

    @Column(name = "idcategorieproduit")
    private Integer idcategorieproduit;

    @Column(name = "nomproduit", length = 50)
    private String nomproduit;

    @Column(name = "dateheureenchere")
    private Timestamp dateheureenchere;

    @Column(name = "datefin")
    private Instant datefin;

    public Instant getDatefin() {
        return datefin;
    }

    public Timestamp getDateheureenchere() {
        return dateheureenchere;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public Integer getIdcategorieproduit() {
        return idcategorieproduit;
    }

    public String getDescription() {
        return description;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public String getPrenom() {
        return prenom;
    }

    public String getNom() {
        return nom;
    }

    public String getDescriptionenchere() {
        return descriptionenchere;
    }

    public Double getPrixminimumvente() {
        return prixminimumvente;
    }

    public Timestamp getDateheuremise() {
        return dateheuremise;
    }

    public Double getMontantOffre() {
        return montantOffre;
    }

    public Integer getIdsurencherisseur() {
        return idsurencherisseur;
    }

    public Integer getIdenchere() {
        return idenchere;
    }

    public Integer getIdsurenchere() {
        return idsurenchere;
    }

    protected Surencheredetail() {
    }
}