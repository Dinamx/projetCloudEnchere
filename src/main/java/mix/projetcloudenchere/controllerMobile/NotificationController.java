package mix.projetcloudenchere.controllerMobile;

import mix.projetcloudenchere.model.Enchere;
import mix.projetcloudenchere.model.Notification;
import mix.projetcloudenchere.model.Rechargementcompte;
import mix.projetcloudenchere.repository.EnchereRepository;
import mix.projetcloudenchere.repository.NotificationRepository;
import mix.projetcloudenchere.views.DetailEnchere;
import mix.projetcloudenchere.viewsRepository.DetailEnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    DetailEnchereRepository detailEnchereRepository;

    @GetMapping("/{iduser}")
    public ResponseEntity<List<Notification>> checkNotif(@PathVariable int iduser){
        try {
            return new ResponseEntity<>(notificationRepository.findAllByIdutilisateur(iduser) , HttpStatus.OK  );
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PostMapping("")
    public ResponseEntity<?> rechargerMonCompte(
            @RequestParam(required = true, value="idnotification") int idnotification) {
        try {
             notificationRepository.updateRechargement(idnotification);
            System.out.println("--------------- notification lue ---------------");
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


//    @PostMapping("")
//    public ResponseEntity<Notification> newNotif(
//            @RequestParam(required = true, value="idUser") int IdUser,
//            @RequestParam(required = true, value="montant") int idEnchere){
//        try {
//
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }
    @GetMapping("")
    public ResponseEntity<List<Notification>> getAll(){
        try {


            return new ResponseEntity<>(notificationRepository.findAll() , HttpStatus.OK  );
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
