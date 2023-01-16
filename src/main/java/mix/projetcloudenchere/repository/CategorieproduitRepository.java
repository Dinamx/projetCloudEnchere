package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Categorieproduit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CategorieproduitRepository extends JpaRepository<Categorieproduit, Integer> {
}