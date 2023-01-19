package mix.projetcloudenchere.controllerWeb;

import mix.projetcloudenchere.model.Surenchere;
import mix.projetcloudenchere.repository.SurenchereRepository;
import mix.projetcloudenchere.views.DetailEnchere;
import mix.projetcloudenchere.views.VueEnchereProduitUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.EntityManager;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class SurenchereController {

    @Autowired
    SurenchereRepository surenchereRepository;

    @PostMapping("/surenchere")
    public ResponseEntity<Surenchere> surencherir(@RequestBody Surenchere surenchere) {
        try {


//        TODO Asiana check oe manana an'ilay vola ve zoky
//        SI oui , tode throwena ny exception

//        forme du json qui doit arriver
//        {
//                "idenchere": 1,
//                "idutilisateur": 1,
//                "montantOffre": 80000.0
//        }
            Timestamp now = new Timestamp(System.currentTimeMillis());
            System.out.println(now);
            System.out.println(surenchere.getMontantOffre());
            System.out.println(surenchere.getIdutilisateur());
            System.out.println(surenchere.getIdenchere());
            Surenchere saved = surenchereRepository.save(new Surenchere(surenchere.getIdenchere(),surenchere.getIdutilisateur(),surenchere.getMontantOffre(),now)) ;
            return new ResponseEntity<>(saved, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    @GetMapping("/surenchere")
    public ResponseEntity<List<Surenchere>> liste() {
        try {

        List<Surenchere> surenchere = new ArrayList<>();
        surenchereRepository.findAll().forEach(surenchere::add);
        if (surenchere.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(surenchere, HttpStatus.OK);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
    }

}

