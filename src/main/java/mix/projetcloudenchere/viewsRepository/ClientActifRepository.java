package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.ClientActif;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface ClientActifRepository extends CrudRepository<ClientActif, Integer> {

    @Query(value = "select * from client_actif",nativeQuery = true)
    List<ClientActif> getClientActif();


}