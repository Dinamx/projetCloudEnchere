package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "client_actif")
public class ClientActif {
    @Id
    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "nombre_enchere")
    private Integer nombreEnchere;

    @Column(name = "nombre_mise")
    private Integer nombreMise;

    @Column(name = "mise_lapluselevee")
    private Double miseLapluselevee;

    @Column(name = "nom_prenom")
    private String nomPrenom;

    public String getNomPrenom() {
        return nomPrenom;
    }

    public Double getMiseLapluselevee() {
        return miseLapluselevee;
    }

    public Integer getNombreMise() {
        return nombreMise;
    }

    public Integer getNombreEnchere() {
        return nombreEnchere;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    protected ClientActif() {
    }
}