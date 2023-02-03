package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Immutable
@Table(name = "soldeuser")
public class Soldeuser {
    @Id
    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "solde")
    private Double solde;

    public Double getSolde() {
        return solde;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    protected Soldeuser() {
    }
}