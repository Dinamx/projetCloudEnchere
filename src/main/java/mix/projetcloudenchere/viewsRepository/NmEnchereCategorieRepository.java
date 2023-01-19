package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.NmEnchereCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NmEnchereCategorieRepository extends CrudRepository<NmEnchereCategorie, Integer> {
    @Query(value = "select * from nm_enchere_categorie",nativeQuery = true)
    List<NmEnchereCategorie> getNmEnchereCategorie();

}