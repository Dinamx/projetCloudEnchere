package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.sql.Timestamp;

@Entity
@Table(name = "notification")
public class Notification {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idnotification", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idenchere", nullable = false)
    private Enchere idenchere;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "idutilisateur", nullable = false)
    private Utilisateur idutilisateur;

    @Column(name = "datenotif")
    private Timestamp datenotif;

    @Column(name = "lu")
    private Boolean lu;

    public Boolean getLu() {
        return lu;
    }

    public void setLu(Boolean lu) {
        this.lu = lu;
    }

    public Timestamp getDatenotif() {
        return datenotif;
    }

    public void setDatenotif(Timestamp datenotif) {
        this.datenotif = datenotif;
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

    public Notification(int idenchere, int idutilisateur) {
        Enchere e = new Enchere();
        e.setId(idenchere);

        Utilisateur utilisateur = new Utilisateur();
        utilisateur.setId(idutilisateur);

        Timestamp now  = new Timestamp(System.currentTimeMillis());

        this.idenchere = e;
        this.idutilisateur = utilisateur;
        this.datenotif = now;
        this.lu = false;
    }
}