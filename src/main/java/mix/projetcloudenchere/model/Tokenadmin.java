package mix.projetcloudenchere.model;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table(name = "tokenadmin")
public class Tokenadmin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idtokenadmin", nullable = false)
    private Integer id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idadmin")
    private Admin idadmin;

    @Column(name = "token", length = 100)
    private String token;

    @Column(name = "datecreation")
    private LocalDate datecreation;

    @Column(name = "dateexpiration")
    private LocalDate dateexpiration;

    @Column(name = "role", length = 10)
    private String role = "super";

    public Tokenadmin(Admin idadmin, String token, LocalDate datecreation, LocalDate dateexpiration) {
        this.idadmin = idadmin;
        this.token = token;
        this.datecreation = datecreation;
        this.dateexpiration = dateexpiration;
    }

    public Tokenadmin() {

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

    public Admin getIdadmin() {
        return idadmin;
    }

    public void setIdadmin(Admin idadmin) {
        this.idadmin = idadmin;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}