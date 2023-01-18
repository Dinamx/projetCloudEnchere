package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Produit;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProduitRepository extends JpaRepository<Produit, Integer> {

}