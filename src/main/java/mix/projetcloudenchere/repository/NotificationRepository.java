package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import javax.transaction.Transactional;
import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "select * from notification where idutilisateur = :idUtilisateur",nativeQuery = true)
    public List<Notification> findAllByIdutilisateur(@Param("idUtilisateur") int idUtilisateur);


    @Modifying(clearAutomatically = true)
    @Transactional
    @Query(value = "UPDATE public.notification SET lu = true WHERE idnotification = :idnotification",nativeQuery = true)
    public void updateRechargement(@Param("idnotification")int idnotification);

}