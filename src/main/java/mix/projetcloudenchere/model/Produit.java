package mix.projetcloudenchere.model;

import org.hibernate.annotations.Type;

import javax.persistence.*;

@Entity
@Table(name = "produit")
public class Produit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idproduit", nullable = false)
    private Integer id;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "nomproduit", length = 50)
    private String nomproduit;

    @Column(name = "description", length = 100)
    private String description;

    @Lob
    @Column(name = "photo")
    @Type(type = "org.hibernate.type.TextType")
    private String photo;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idcategorieproduit")
    private Integer idcategorieproduit;

    public Integer getIdcategorieproduit() {
        return idcategorieproduit;
    }

    public void setIdcategorieproduit(Integer idcategorieproduit) {
        this.idcategorieproduit = idcategorieproduit;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getNomproduit() {
        return nomproduit;
    }

    public void setNomproduit(String nomproduit) {
        this.nomproduit = nomproduit;
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

    public Produit(Integer idutilisateur, String nomproduit, String description, String photo, Integer idcategorieproduit) {
        this.idutilisateur = idutilisateur;
        this.nomproduit = nomproduit;
        this.description = description;
        this.photo = photo;
        this.idcategorieproduit = idcategorieproduit;
    }
}