package mix.projetcloudenchere.controllerWeb;

import mix.projetcloudenchere.model.Enchere;
import mix.projetcloudenchere.model.Produit;
import mix.projetcloudenchere.repository.EnchereRepository;
import mix.projetcloudenchere.repository.ProduitRepository;
import mix.projetcloudenchere.repository.VueEnchereProduitUtilisateurRepository;
import mix.projetcloudenchere.views.DetailEnchere;
import mix.projetcloudenchere.viewsRepository.DetailEnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
public class EnchereController {

    @Autowired
    EnchereRepository enchereRepository;
    @Autowired
    VueEnchereProduitUtilisateurRepository vueEnchereProduitUtilisateurRepository;

    @Autowired
    DetailEnchereRepository detailEnchereRepository;
    @Autowired
    ProduitRepository produitRepository;



    @GetMapping("/encheres")
    public ResponseEntity<List<DetailEnchere>> listeToutesEnchereDetails(){
        try {
            System.out.println("user");

            List<DetailEnchere> enchere = new ArrayList<>();
            detailEnchereRepository.findAll().forEach(enchere::add);
            if (enchere.isEmpty()) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("retour");
            return new ResponseEntity<>(enchere, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/encheres/details/{idenchere}")
    public ResponseEntity<DetailEnchere> detailsEnchere(@PathVariable("idenchere") int idenchere){
        try {
            System.out.println("details");
            List<DetailEnchere> enchere = new ArrayList<>();
            DetailEnchere e = detailEnchereRepository.findByIdenchere(idenchere);
            if (detailEnchereRepository.findByIdenchere(idenchere) == null) {
                return new ResponseEntity<>(HttpStatus.NO_CONTENT);
            }
            System.out.println("retour d'une enchere en particulier ");
            return new ResponseEntity<>(e, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
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
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/encheres/{iduser}")
    public ResponseEntity<List<DetailEnchere>> allAuctionsByIdUser(@PathVariable String iduser){
        try {
            System.out.println("iduser" + iduser);
            System.out.println("user");

            List<DetailEnchere> enchere = new ArrayList<>();
            detailEnchereRepository.findAllByIdutilisateur(Integer.valueOf(iduser)).forEach(enchere::add);
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
            enchereRepository.findAllByIdutilisateur(iduser).forEach(enchere::add);
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

//POZINJAVATRA ILAINY
//    {
//        "prixminimumvente": 70000.0,
//            "descriptionenchere": "Courroie en or",
//            "idutilisateur": 2,
//            "duree": 120,
//            "description": "Courroie en or ",
//            "idcategorieproduit": 1,
//            "photo": "photo",
//            "nomproduit": "Courroie",
//            "dateheureenchere": "2023-01-18T17:20:05.882+00:00"
//    }

    @Transactional
    @PostMapping("/encheres")
    public ResponseEntity<DetailEnchere> ajoutEnchere(@RequestBody DetailEnchere enchere){
        try {
            System.out.println("ok");
            Timestamp now = new Timestamp(System.currentTimeMillis());

            Produit p =produitRepository.save(new Produit(enchere.getIdutilisateur(),enchere.getNomproduit(),enchere.getDescription(),enchere.getPhoto(),enchere.getIdcategorieproduit())) ;
            System.out.println("p saved");
            Enchere e = enchereRepository.save(new Enchere(p.getId(),p.getIdutilisateur(),enchere.getDescriptionenchere(),enchere.getPrixminimumvente(),now, enchere.getDuree()));
            System.out.println("coucou");
            DetailEnchere detail = detailEnchereRepository.findById(e.getId()).orElseThrow(() -> new Exception("Enchere not found"));
            System.out.println("retour");
            return new ResponseEntity<>(detail, HttpStatus.OK);
        }
        catch (Exception e){
            e.printStackTrace();
            return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }




}
