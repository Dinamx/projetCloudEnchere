package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.Soldeclient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldeclientRepository extends JpaRepository<Soldeclient, Integer> {

    public Soldeclient findByIdutilisateur(int idutilisateur);
}