package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "nm_enchere_categorie")
public class NmEnchereCategorie {
    @Id
    @Column(name = "idcategorieproduit")
    private Integer idcategorieproduit;

    @Column(name = "nombre_enchere")
    private Integer nombreEnchere;

    @Column(name = "categorie", length = 100)
    private String categorie;

    @Column(name = "mois")
    private String mois;

    public String getMois() {
        return mois;
    }

    public String getCategorie() {
        return categorie;
    }

    public Integer getNombreEnchere() {
        return nombreEnchere;
    }

    public Integer getIdcategorieproduit() {
        return idcategorieproduit;
    }

    protected NmEnchereCategorie() {
    }
}