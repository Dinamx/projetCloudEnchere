package mix.projetcloudenchere.controllerMobile;


import mix.projetcloudenchere.model.Surenchere;
import mix.projetcloudenchere.model.Tokenuser;
import mix.projetcloudenchere.model.Utilisateur;
import mix.projetcloudenchere.repository.UtilisateurRepository;
import mix.projetcloudenchere.views.DetailEnchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

//    Format Json Inscription
//        {
//        "id": 1,
//        "nom": "John",
//        "prenom": "Wick",
//        "email": "user1@example.com",
//        "mdp": "user1",
//        "dateinscription": "2023-01-16"
//    }

//    Inscription
@PostMapping("/users")
public ResponseEntity<Utilisateur> surencherir(@RequestBody Utilisateur tosave) {
    try {
        Timestamp now = new Timestamp(System.currentTimeMillis());
        Utilisateur user = utilisateurRepository.save(new Utilisateur(tosave.getNom(),tosave.getPrenom(),tosave.getEmail(),tosave.getMdp(), LocalDate.now())) ;
        return new ResponseEntity<>(user, HttpStatus.OK);
    } catch (Exception e) {
        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
//    @PostMapping("/users/signup")
//    public ResponseEntity<Tokenuser> Connexion(@RequestBody Utilisateur tosave) {
//        try {
//            Timestamp now = new Timestamp(System.currentTimeMillis());
//            Utilisateur user = utilisateurRepository.save(new Utilisateur(tosave.getNom(),tosave.getPrenom(),tosave.getEmail(),tosave.getMdp(), LocalDate.now())) ;
//            return new ResponseEntity<>(user, HttpStatus.OK);
//        } catch (Exception e) {
//            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
//        }
//    }

}
