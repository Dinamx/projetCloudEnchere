package mix.projetcloudenchere.controllerWeb;

import mix.projetcloudenchere.model.Enchere;
import mix.projetcloudenchere.model.Surenchere;
import mix.projetcloudenchere.repository.EnchereRepository;
import mix.projetcloudenchere.repository.SurenchereRepository;
import mix.projetcloudenchere.repository.VueEnchereProduitUtilisateurRepository;
import mix.projetcloudenchere.views.VueEnchereProduitUtilisateur;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EnchereController {
    @Autowired
    SurenchereRepository surenchereRepository;

    @Autowired
    EnchereRepository enchereRepository;
    @Autowired
    VueEnchereProduitUtilisateurRepository vueEnchereProduitUtilisateurRepository;




    @GetMapping("/encheres")
    public ResponseEntity<List<VueEnchereProduitUtilisateur>> listeToutesEnchereDetails(){
        try {
            System.out.println("user");

            List<VueEnchereProduitUtilisateur> enchere = new ArrayList<>();
            vueEnchereProduitUtilisateurRepository.findAll().forEach(enchere::add);
            if (enchere.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("retour");
            return new ResponseEntity<>(enchere, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/encheresList")
    public ResponseEntity<List<Enchere>> toutesEnchereDetails(){
        try {
            System.out.println("user");

            List<Enchere> enchere = new ArrayList<>();
            enchereRepository.findAll().forEach(enchere::add);
            if (enchere.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("retour");
            return new ResponseEntity<>(enchere, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/encheres/{iduser}")
    public ResponseEntity<List<VueEnchereProduitUtilisateur>> allAuctionsByIdUser(@PathVariable String iduser){
        try {
            System.out.println("iduser" + iduser);
            System.out.println("user");

            List<VueEnchereProduitUtilisateur> enchere = new ArrayList<>();
            vueEnchereProduitUtilisateurRepository.findAllByIdutilisateur(Integer.valueOf(iduser)).forEach(enchere::add);
            if (enchere.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("retour");
            return new ResponseEntity<>(enchere, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/encheres/history/{iduser}")
    public ResponseEntity<List<Enchere>> getHistoryByUser(@PathVariable String iduser){
        try {
            System.out.println("iduser" + iduser);
            System.out.println("user");

            List<Enchere> enchere = new ArrayList<>();
            enchereRepository.findAllByIdutilisateur(Integer.valueOf(iduser)).forEach(enchere::add);
            if (enchere.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("retour");
            return new ResponseEntity<>(enchere, HttpStatus.OK);
        }
        catch (Exception e){
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


}
