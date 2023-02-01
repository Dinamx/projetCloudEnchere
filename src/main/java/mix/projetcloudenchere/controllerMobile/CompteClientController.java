package mix.projetcloudenchere.controllerMobile;

import mix.projetcloudenchere.model.Rechargementcompte;
import mix.projetcloudenchere.repository.RechargementcompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Timestamp;

@RestController
@CrossOrigin
@RequestMapping("/account")
public class CompteClientController {
//    Get total solde
// Recherger mon compte

    @Autowired
    RechargementcompteRepository rechargementcompteRepository;

    @PostMapping("")
    public ResponseEntity<Rechargementcompte> rechargerMonCompte(@RequestBody Rechargementcompte rechargementcomptes){
//        @RequestParam(required = true, value="idUser") String IdUser,
//        @RequestParam(required = true, value="montant") String montant) {
    try {

        Timestamp now = new Timestamp(System.currentTimeMillis());
        Rechargementcompte rechargementcompte = new Rechargementcompte(rechargementcomptes.getIdutilisateur(), rechargementcomptes.getMontant() , now , 0);
        rechargementcompteRepository.save(rechargementcompte);
        System.out.println("--------------- Account recharge done ---------------");
        return new ResponseEntity<>(HttpStatus.OK);
    } catch (Exception e) {
        e.printStackTrace();
        return  new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
    }
}

}
