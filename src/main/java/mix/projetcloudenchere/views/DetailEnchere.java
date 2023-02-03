package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.sql.Timestamp;

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

    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "nom", length = 20)
    private String nom;

    @Column(name = "prenom", length = 20)
    private String prenom;

//    Transient signifie que la colonne va etre ignoree , simplement.
    @Transient
    private int duree;

    public int getDuree() {
        return duree;
    }

    @Lob
//    @Column(name = "description" , columnDefinition="TEXT")
//    @Column(name = "description", length = 100)
    @Type(type = "org.hibernate.type.TextType")
    private String description;


    @Column(name = "idcategorieproduit")
    private Integer idcategorieproduit;

    @Lob
    @Column(name = "photo" )
    @Type(type = "org.hibernate.type.TextType")
    private String photo;

    @Column(name = "nomproduit", length = 50)
    private String nomproduit;

    @Column(name = "dateheureenchere")
    private Timestamp dateheureenchere;

    @Column(name = "datefin")
    private Timestamp datefin;

    public Timestamp getDatefin() {
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

    public Integer getIdutilisateur() {
        return idutilisateur;
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


    protected DetailEnchere() {
    }
}