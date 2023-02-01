package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Surenchere;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SurenchereRepository extends JpaRepository<Surenchere, Integer> {

    public List<Surenchere> findAllByIdenchereOrderByDateheuremiseDesc(int id);

}