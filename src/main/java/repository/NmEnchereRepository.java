package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.views.NmEnchereCategorie;
import org.springframework.data.jpa.repository.JpaRepository;

public interface NmEnchereRepository extends JpaRepository<NmEnchereCategorie, Integer> {
}
