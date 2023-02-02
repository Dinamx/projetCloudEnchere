package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "surenchere")
public class Surenchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsurenchere", nullable = false)
    private Integer id;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idenchere")
    private Integer idenchere;

    @Basic(fetch = FetchType.LAZY)
    @Column(name = "idutilisateur")
    private Integer idutilisateur;

    @Column(name = "montant_offre")
    private Double montantOffre;

    @Column(name = "dateheuremise")
    private Timestamp dateheuremise;

    @Column(name = "etat")
    private Integer etat = 1;

    public Integer getEtat() {
        return etat;
    }

    public void setEtat(Integer etat) {
        this.etat = etat;
    }

    public Surenchere() {

    }

    public Timestamp getDateheuremise() {
        return dateheuremise;
    }

    public void setDateheuremise(Timestamp dateheuremise) {
        this.dateheuremise = dateheuremise;
    }

    public Double getMontantOffre() {
        return montantOffre;
    }

    public void setMontantOffre(Double montantOffre) {
        this.montantOffre = montantOffre;
    }

    public Integer getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Integer idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(Integer idenchere) {
        this.idenchere = idenchere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Surenchere(Integer idenchere, Integer idutilisateur, Double montantOffre, Timestamp dateheuremise) {
        this.idenchere = idenchere;
        this.idutilisateur = idutilisateur;
        this.montantOffre = montantOffre;
        this.dateheuremise = dateheuremise;
    }
}