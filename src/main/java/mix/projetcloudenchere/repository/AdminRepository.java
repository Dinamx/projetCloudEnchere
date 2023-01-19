package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Admin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AdminRepository extends JpaRepository<Admin, Integer> {

    Admin findByEmailAndAndMdp(String email , String mdp);


}