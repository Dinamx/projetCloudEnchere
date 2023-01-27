package mix.projetcloudenchere.controllerMobile;

import mix.projetcloudenchere.model.Enchere;
import mix.projetcloudenchere.model.Notification;
import mix.projetcloudenchere.repository.EnchereRepository;
import mix.projetcloudenchere.repository.NotificationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/ckeckNotif")
public class NotificationController {
    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    EnchereRepository enchereRepository;

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

    @GetMapping("")
    public ResponseEntity<List<Notification>> getAll(){
        try {
            List<Enchere> unchecked =


            return new ResponseEntity<>(notificationRepository.findAll() , HttpStatus.OK  );
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
