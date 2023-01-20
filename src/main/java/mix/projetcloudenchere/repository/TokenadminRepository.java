package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Tokenadmin;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.time.LocalDate;

public interface TokenadminRepository extends JpaRepository<Tokenadmin, Integer> {
    @Query(value = "UPDATE Tokenadmin SET dateexpiration =:expiration WHERE idadmin =:idadmin")
    @Transactional
    @Modifying
    public void updateToken(@Param("idadmin") int idadmin , @Param("expiration") LocalDate exp);

//    public boolean existsByIdadmin(Integer idadmin);

    public boolean existsTokenadminByIdadmin(int idadmin);
}