package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Immutable
@Table(name = "detail_enchere")
public class DetailEnchere {
    @Id
    @Column(name = "idenchere")
    private Integer idenchere;

    @Column(name = "prixminimumvente")
    private Double prixminimumvente;

    @Column(name = "descriptionenchere", length = 100)
    private String descriptionenchere;

    @Column(name = "idutilisateur", length = 20)
    private Integer idutilisateur;

    @Column(name = "nom", length = 20)
    private String nom;

    @Column(name = "prenom", length = 20)
    private String prenom;

    @Lob
    @Column(name = "description")
    private String description;

    @Column(name = "idcategorieproduit")
    private Integer idcategorieproduit;

    @Lob
    @Column(name = "photo")
    private String photo;

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

    public String getPhoto() {
        return photo;
    }

    public Integer getIdcategorieproduit() {
        return idcategorieproduit;
    }

    public String getDescription() {
        return description;
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

    public Integer getIdenchere() {
        return idenchere;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    protected DetailEnchere() {
    }
}