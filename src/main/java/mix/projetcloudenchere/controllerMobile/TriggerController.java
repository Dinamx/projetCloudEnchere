package mix.projetcloudenchere.controllerMobile;


import mix.projetcloudenchere.dao.DateDao;
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
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping("/trigger")
public class TriggerController {

    @Autowired
    DetailEnchereRepository detailEnchereRepository;

    @GetMapping("/notifs")
    public ResponseEntity<?> checkNotif(){
        List<DetailEnchere> unchecked = detailEnchereRepository.findAllUnchecked();
        System.out.println("------find all unchecked : number " + unchecked.size() + "--------------");
        for (DetailEnchere d : unchecked){
            if (d.getDatefin().compareTo(new DateDao().getNow()) > 0) {
                // La date de fin est après la date actuelle
            }
            System.out.println("ok");
        }


        return new ResponseEntity<>(HttpStatus.OK);
    }
}
