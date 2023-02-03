package mix.projetcloudenchere.viewsRepository;

import mix.projetcloudenchere.views.Soldeuser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SoldeuserRepository extends JpaRepository<Soldeuser, Integer> {
    Soldeuser findByIdutilisateur(int iduser);
}