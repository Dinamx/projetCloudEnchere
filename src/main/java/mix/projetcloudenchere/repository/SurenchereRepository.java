package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Surenchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface SurenchereRepository extends JpaRepository<Surenchere, Integer> {

    public List<Surenchere> findAllByIdenchereOrderByDateheuremiseDesc(int id);

//    Tout setter a 0  ,  c'est a dire debloquer le montant
    @Transactional
    @Modifying
    @Query(value = "UPDATE public.surenchere SET etat = 0 WHERE idsurenchere =:idSurenchere",nativeQuery = true)
    public void updateEtat(@Param("idSurenchere")int idSurenchere);


//    Bloquer la surenchere gagnante
    @Transactional
    @Modifying
    @Query(value = "UPDATE public.surenchere SET etat = 2 WHERE idsurenchere =:idSurenchere",nativeQuery = true)
    public void updateGagnant(@Param("idSurenchere")int idSurenchere);


}