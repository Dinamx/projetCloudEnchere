package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.CategoriePrisee;
import mix.projetcloudenchere.views.NmEnchereCategorie;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CategoriePriseeRepository extends CrudRepository<CategoriePrisee, Integer> {
    @Query(value = "select * from categorie_prisees",nativeQuery = true)
    List<CategoriePrisee> getCategoriePrisee();
}