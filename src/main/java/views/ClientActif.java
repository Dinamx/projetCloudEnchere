package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "client_actif")
public class ClientActif {


    @Column(name = "nombre_enchere")
    private Long nombreEnchere;

    @Column(name = "nombre_mise")
    private Long nombreMise;

    @Id
    @Column(name = "mise_lapluselevee")
    private Double miseLapluselevee;

    @Lob
    @Column(name = "nom_prenom")
    private String nomPrenom;


    public String getNomPrenom() {
        return nomPrenom;
    }

    public Double getMiseLapluselevee() {
        return miseLapluselevee;
    }

    public Long getNombreMise() {
        return nombreMise;
    }

    public Long getNombreEnchere() {
        return nombreEnchere;
    }

    protected ClientActif() {
    }
}