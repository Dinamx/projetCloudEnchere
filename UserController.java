package mix.controller.controllerWeb;

import mix.projetcloudenchere.model.Administrateur;
import mix.projetcloudenchere.model.Token;
import mix.projetcloudenchere.model.Tutorial;
import mix.projetcloudenchere.model.Voiture;
import mix.projetcloudenchere.repository.AdministrateurRepository;
import mix.projetcloudenchere.repository.TokenRepository;
import mix.projetcloudenchere.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.zip.Adler32;

@RestController
@CrossOrigin
public class LoginController {
    @Autowired
    UtilisateurRepository utilisateurRepository;
    @Autowired
    TokenutilisateurRepository tokenutilisateurRepository;


    @PostMapping("/registration")
    public ResponseEntity<Tokenuser> registration(@RequestBody Utilisateur utilisateur) {
        try {
            System.out.println("nom request body" + utilisateur.getNom());
            System.out.println("prenom request body" + utilisateur.getPrenom);
            System.out.println("email request body" + utilisateur.getEmail());
            System.out.println("date d inscription request body" + utilisateur.getDateinscription());
            System.out.println("mdp request body" + utilisateur.getMdp());
            List<Utilisateur> utilisateur = utilisateurRepository.findById(int id);
            if (admin.size() == 1){
                System.out.println("User" + utilisateur.size());
                Tokenuser t = new TokenService().createToken(admin.get(0));
                Tokenuser saved = tokenuserRepository.save(t);
                System.out.println("RegistrationUser");
                System.out.println(saved.getId());

                System.out.println(saved.getToken());
                return new ResponseEntity<>(saved, HttpStatus.OK);
            }
            else{
                return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

        }
    }
    @GetMapping("/registration")
    public ResponseEntity<List<Utilisateur>> getListe(){
        try {
            System.out.println("Okee");
            List<Utilisateur> utilisateur = new ArrayList<Utilisateur>();
            administrateurRepository.findAll().forEach(utilisateur::add);
            if (utilisateur.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(admin, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
