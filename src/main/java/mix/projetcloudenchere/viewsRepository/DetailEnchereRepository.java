package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.model.Notification;
import mix.projetcloudenchere.views.DetailEnchere;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DetailEnchereRepository extends JpaRepository<DetailEnchere, Integer> {

    List<DetailEnchere> findAllByIdutilisateur(int idUser);


    @Query(value = "select * from detail_enchere where idenchere not in (select idenchere from notification) ",nativeQuery = true)
    public List<DetailEnchere> findAllUnchecked();

}