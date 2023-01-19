package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "nm_categorie")
public class NmCategorie {
    @Id
    @Column(name = "nombre_enchere")
    private Integer nombreEnchere;

    @Lob
    @Column(name = "mois")
    private String mois;

    @Column(name = "annee")
    private Double annee;

    public Double getAnnee() {
        return annee;
    }

    public String getMois() {
        return mois;
    }

    public Integer getNombreEnchere() {
        return nombreEnchere;
    }

    protected NmCategorie() {
    }
}