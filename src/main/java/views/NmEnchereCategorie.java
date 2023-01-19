package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "nm_enchere_categorie")
public class NmEnchereCategorie {

    @Id
    @Column(name = "nombre_enchere")
    private Long nombreEnchere;

    @Column(name = "categorie", length = 20)
    private String categorie;

    @Lob
    @Column(name = "mois")
    private String mois;

    public String getMois() {
        return mois;
    }

    public String getCategorie() {
        return categorie;
    }

    public Long getNombreEnchere() {
        return nombreEnchere;
    }

    protected NmEnchereCategorie() {
    }
}