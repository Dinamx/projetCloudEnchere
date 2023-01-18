package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.DetailEnchere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DetailEnchereRepository extends JpaRepository<DetailEnchere, Integer> {

    List<DetailEnchere> findAllByIdutilisateur(int idUser);
}