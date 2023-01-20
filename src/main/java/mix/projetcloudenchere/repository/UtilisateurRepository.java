package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UtilisateurRepository extends JpaRepository<Utilisateur, Integer> {
    Utilisateur findById(int id);

    Utilisateur findByEmailAndMdp(String email ,String mdp);

}