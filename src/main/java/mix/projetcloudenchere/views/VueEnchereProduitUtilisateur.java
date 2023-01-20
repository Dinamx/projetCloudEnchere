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
@Table(name = "vue_enchere_produit_utilisateur")
public class VueEnchereProduitUtilisateur {
    @Id
    @Column(name = "idenchere")
    private Integer idenchere;

    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "nom", length = 20)
    private String nom;

    @Column(name = "prenom", length = 20)
    private String prenom;

    @Column(name = "idproduit")
    private Integer idproduit;

    @Column(name = "nomproduit", length = 50)
    private String nomproduit;

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

    @Column(name = "idcategorieproduit")
    Integer idcategorieproduit;

    @Column(name = "categorie")
    String categorie;

    public Integer getIdcategorieproduit() {
        return idcategorieproduit;
    }

    public String getCategorie() {
        return categorie;
    }

    public Integer getStatus() {
        return status;
    }

    public Timestamp getDateheureenchere() {
        return dateheureenchere;
    }

    public Integer getDureeenchere() {
        return dureeenchere;
    }

    public Double getPrixminimumvente() {
        return prixminimumvente;
    }

    public String getDescription() {
        return description;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public Integer getIdproduit() {
        return idproduit;
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

    public Integer getIdenchere() {
        return idenchere;
    }

    protected VueEnchereProduitUtilisateur() {
    }
    public VueEnchereProduitUtilisateur(Integer idenchere, Integer idutilisateur, String nom, String prenom, Integer idproduit, String nomproduit, String description, Double prixminimumvente, Integer dureeenchere, Timestamp dateheureenchere, Integer status, Integer idcategorieproduit, String categorie) {
        this.idenchere = idenchere;
        this.idutilisateur = idutilisateur;
        this.nom = nom;
        this.prenom = prenom;
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.description = description;
        this.prixminimumvente = prixminimumvente;
        this.dureeenchere = dureeenchere;
        this.dateheureenchere = this.dateheureenchere;
        this.status = status;
        this.idcategorieproduit = idcategorieproduit;
        this.categorie = categorie;
    }

    public VueEnchereProduitUtilisateur(String nom, String prenom, Integer idproduit, String nomproduit, String description, Double prixminimumvente, Integer dureeenchere, Timestamp dateheureenchere, Integer status, Integer idcategorieproduit, String categorie) {
        this.nom = nom;
        this.prenom = prenom;
        this.idproduit = idproduit;
        this.nomproduit = nomproduit;
        this.description = description;
        this.prixminimumvente = prixminimumvente;
        this.dureeenchere = dureeenchere;
        this.dateheureenchere = dateheureenchere;
        this.status = status;
        this.idcategorieproduit = idcategorieproduit;
        this.categorie = categorie;
    }

    public VueEnchereProduitUtilisateur(String nomproduit, Double prixminimumvente, Timestamp dateheureenchere, Integer status, Integer idcategorieproduit) {
        this.nomproduit = nomproduit;
        this.prixminimumvente = prixminimumvente;
        this.dateheureenchere = dateheureenchere;
        this.status = status;
        this.idcategorieproduit = idcategorieproduit;
    }
}