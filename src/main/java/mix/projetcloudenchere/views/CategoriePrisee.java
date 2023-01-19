package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "categorie_prisees")
public class CategoriePrisee {
    @Column(name = "nombre_enchere")
    private Integer nombreEnchere;

    @Column(name = "categorie", length = 100)
    private String categorie;

    public String getCategorie() {
        return categorie;
    }

    public Integer getNombreEnchere() {
        return nombreEnchere;
    }

    protected CategoriePrisee() {
    }
}