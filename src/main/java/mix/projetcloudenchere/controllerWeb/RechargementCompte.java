package mix.projetcloudenchere.controllerWeb;


import mix.projetcloudenchere.views.VueEnchereProduitUtilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.PreparedStatement;
import java.util.List;

@RestController
@CrossOrigin
public class RechargementCompte {

    @PostMapping("/searches")
    public static ResponseEntity<?> rechargerMonCompte(
            @RequestParam(required = true, value="idUser") int IdUser,
            @RequestParam(required = true, value="montant") double montant){
        try {
            return new ResponseEntity<>(HttpStatus.OK);
        } catch (Exception e) {
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
