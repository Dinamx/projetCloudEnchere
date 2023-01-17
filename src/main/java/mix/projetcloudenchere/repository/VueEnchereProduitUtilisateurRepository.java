package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.views.VueEnchereProduitUtilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VueEnchereProduitUtilisateurRepository extends JpaRepository<VueEnchereProduitUtilisateur, Integer> {
    List<VueEnchereProduitUtilisateur> findByIdutilisateur(String idUser);
}