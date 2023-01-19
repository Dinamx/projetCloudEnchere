package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "utilisateur")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idutilisateur", nullable = false)
    private Integer id;

    @Column(name = "nom", length = 20)
    private String nom;

    @Column(name = "prenom", length = 20)
    private String prenom;

    @Column(name = "email", length = 20)
    private String email;

    @Column(name = "mdp", length = 20)
    private String mdp;

    @Column(name = "dateinscription")
    private LocalDate dateinscription;

    public Utilisateur() {
    }

    public Utilisateur(String nom, String prenom, String email, String mdp,LocalDate now) {
        this.nom = nom;
        this.prenom = prenom;
        this.email = email;
        this.mdp = mdp;
        this.dateinscription = now;
    }

    public LocalDate getDateinscription() {
        return dateinscription;
    }

    public void setDateinscription(LocalDate dateinscription) {
        this.dateinscription = dateinscription;
    }

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}