package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.time.Instant;

@Entity
@Table(name = "surenchere")
public class Surenchere {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idsurenchere", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idenchere")
    private Enchere idenchere;

    @ManyToOne(fetch = FetchType.LAZY )
    @JoinColumn(name = "idutilisateur")
    private Utilisateur idutilisateur;

    @Column(name = "montant_offre")
    private Double montantOffre;

    @Column(name = "dateheuremise")
    private Instant dateheuremise;

    public Instant getDateheuremise() {
        return dateheuremise;
    }

    public void setDateheuremise(Instant dateheuremise) {
        this.dateheuremise = dateheuremise;
    }

    public Double getMontantOffre() {
        return montantOffre;
    }

    public void setMontantOffre(Double montantOffre) {
        this.montantOffre = montantOffre;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Enchere getIdenchere() {
        return idenchere;
    }

    public void setIdenchere(Enchere idenchere) {
        this.idenchere = idenchere;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}