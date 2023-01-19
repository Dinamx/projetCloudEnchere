package mix.projetcloudenchere.mongodb;

import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface PhotoRepository extends MongoRepository<Photo, Integer> {
    List<Photo> findAllByIdproduit(String idproduit);

}