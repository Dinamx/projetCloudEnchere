package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Enchere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EnchereRepository extends JpaRepository<Enchere, Integer> {
    List<Enchere> findByIdutilisateur(String idUser);
    List<Enchere> findByStatus(int status);

}