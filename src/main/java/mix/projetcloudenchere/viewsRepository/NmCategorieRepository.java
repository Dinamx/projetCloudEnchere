package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.NmCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface NmCategorieRepository extends CrudRepository<NmCategorie, Integer> {

    @Query(value = "select * from nm_categorie",nativeQuery = true)
    List<NmCategorie> getNombreCategorie();
}