package mix.projetcloudenchere.model;

import javax.persistence.*;

@Entity
@Table(name = "categorieproduit")
public class Categorieproduit {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcategorieproduit", nullable = false)
    private Integer id;

    @Column(name = "categorie", length = 20)
    private String categorie;

    public Categorieproduit(String nomCategorie) {
        this.categorie = nomCategorie;
    }

    public Categorieproduit() {

    }

    public String getCategorie() {
        return categorie;
    }
    public void setCategorie(String categorie) {
        this.categorie = categorie;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}