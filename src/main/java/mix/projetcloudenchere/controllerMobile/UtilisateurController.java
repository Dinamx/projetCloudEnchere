package mix.projetcloudenchere.controllerMobile;


import mix.projetcloudenchere.model.*;
import mix.projetcloudenchere.repository.TokenuserRepository;
import mix.projetcloudenchere.repository.UtilisateurRepository;
import mix.projetcloudenchere.service.TokenService;
import mix.projetcloudenchere.views.DetailEnchere;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.sql.Timestamp;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class UtilisateurController {
    @Autowired
    UtilisateurRepository utilisateurRepository;

    @Autowired
    TokenuserRepository tokenuserRepository;

//    Format Json Inscription
//        {
//        "nom": "John",
//        "prenom": "Wick",
//        "email": "user1@example.com",
//        "mdp": "user1",
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


    @PostMapping("/users/signup")
    public ResponseEntity<Tokenuser> login(@RequestBody Utilisateur utilisateur) throws Exception {
        System.out.println("log");
//        {
//        "email": "user1@example.com",
//        "mdp": "user1"
//    }
        if( utilisateurRepository.findByEmailAndMdp(utilisateur.getEmail(),utilisateur.getMdp()) != null) {
            Utilisateur user = utilisateurRepository.findByEmailAndMdp(utilisateur.getEmail(),utilisateur.getMdp());
            System.out.println();
            Tokenuser t = new TokenService().createTokenUser(user);
            Tokenuser saved = tokenuserRepository.save(t);
            System.out.println("LoginUtilisateur" + t.getToken() + t.getId() + t.getRole());
            return new ResponseEntity<>(saved,HttpStatus.OK);
        }
        else{
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
    }
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
