package mix.projetcloudenchere.controllerMobile;


import mix.projetcloudenchere.dao.DateDao;
import mix.projetcloudenchere.model.Notification;
import mix.projetcloudenchere.repository.NotificationRepository;
import mix.projetcloudenchere.views.DetailEnchere;
import mix.projetcloudenchere.viewsRepository.DetailEnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trigger")
public class TriggerController {

    @Autowired
    DetailEnchereRepository detailEnchereRepository;

    @Autowired
    NotificationRepository notificationRepository;

    @GetMapping("/notifs")
    public ResponseEntity<?> checkNotif(){
        try {
        List<DetailEnchere> unchecked = detailEnchereRepository.findAllUnchecked();
        List<Notification> newNotifs = new ArrayList<>();
        if (unchecked.size()== 0){
            return  new ResponseEntity<>(HttpStatus.OK);
        }
        else {
            for (DetailEnchere d : unchecked) {
                System.out.println("------find all unchecked : number " + unchecked.size() + "--------------");
                if (d.getDatefin().compareTo(new DateDao().getNow()) < 0) {
                    // La date de fin est après la date actuelle
                    Notification notif = new Notification(d.getIdenchere(), d.getIdutilisateur());
                    notificationRepository.save(notif);
                    System.out.println("------------new Notification inserted ----------------");
                }
                else {
                    System.out.println("else condition");
                }

            }
            return new ResponseEntity<>(HttpStatus.OK);
        }

        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

}
