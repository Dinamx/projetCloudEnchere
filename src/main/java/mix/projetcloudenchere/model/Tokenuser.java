package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tokenuser")
public class Tokenuser {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtokenuser", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idutilisateur")
    private Utilisateur idutilisateur;

    @Column(name = "token", length = 100)
    private String token;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @Column(name = "dateexpiration")
    private LocalDate dateexpiration;

    @Column(name = "role", length = 10)
    private String role;

    public Tokenuser(Utilisateur admin, String token, LocalDate creation, LocalDate expiration) {
        this.idutilisateur = admin ;
        this.token = token;
        this.datecreation = creation;
        this.dateexpiration = expiration;
    }

    public Tokenuser() {

    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public LocalDate getDateexpiration() {
        return dateexpiration;
    }

    public void setDateexpiration(LocalDate dateexpiration) {
        this.dateexpiration = dateexpiration;
    }

    public LocalDate getDatecreation() {
        return datecreation;
    }

    public void setDatecreation(LocalDate datecreation) {
        this.datecreation = datecreation;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public Utilisateur getIdutilisateur() {
        return idutilisateur;
    }

    public void setIdutilisateur(Utilisateur idutilisateur) {
        this.idutilisateur = idutilisateur;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}