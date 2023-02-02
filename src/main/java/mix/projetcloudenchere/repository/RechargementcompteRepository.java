package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Rechargementcompte;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

public interface RechargementcompteRepository extends JpaRepository<Rechargementcompte, Integer> {

    @Transactional
    @Modifying
    @Query(value = "UPDATE public.rechargementcompte SET validation = 1 WHERE idrechargementcompte =:idRechargement",nativeQuery = true)
    public void updateRechargement(@Param("idRechargement")int idRechargement);
}