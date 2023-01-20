package mix.projetcloudenchere.views;

import org.hibernate.annotations.Immutable;

import javax.persistence.*;

@Entity
@Immutable
@Table(name = "nm_enchere_utilisateur")
public class NmEnchereUtilisateur {
    @Id
    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "nom_prenom")
    private String nomPrenom;

    @Column(name = "nombre_enchere")
    private Integer nombreEnchere;

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

    public String getNomPrenom() {
        return nomPrenom;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    protected NmEnchereUtilisateur() {
    }
}