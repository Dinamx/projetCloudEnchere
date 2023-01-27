package mix.projetcloudenchere.repository;

import mix.projetcloudenchere.model.Notification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface NotificationRepository extends JpaRepository<Notification, Integer> {
    public List<Notification> findAllByIdutilisateur(int idUtilisateur);




}