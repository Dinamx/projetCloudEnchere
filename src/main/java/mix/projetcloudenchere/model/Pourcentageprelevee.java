package mix.projetcloudenchere.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "pourcentageprelevee")
public class Pourcentageprelevee {
    @Id
    @Column(name = "id", nullable = false)
    private Integer id;

    @Column(name = "pourcentage")
    private Double pourcentage;

    @Column(name = "date")
    private Timestamp date;

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public Double getPourcentage() {
        return pourcentage;
    }

    public void setPourcentage(Double pourcentage) {
        this.pourcentage = pourcentage;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Pourcentageprelevee(Double pourcentage, Timestamp date) {
        this.pourcentage = pourcentage;
        this.date = date;
    }

    public Pourcentageprelevee() {
    }
}