package mix.projetcloudenchere.controllerjsp;

import mix.projetcloudenchere.model.Rechargementcompte;
import mix.projetcloudenchere.repository.RechargementcompteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;

@Controller
public class ValidationController {
    @Autowired
    EntityManager em;

    @Autowired
    RechargementcompteRepository rechargementcompteRepository;

    @GetMapping("/valider/{idRechargement}")
    public String validation(@PathVariable int idRechargement)
    {
        try{
//            Initialisation listeRechargementEnAttente
//            List<Rechargementcompte>

            em.getTransaction().begin();

            rechargementcompteRepository.updateRechargement(idRechargement);
//             updating stuffs
            em.getTransaction().commit();
            return "ok";
        }
        catch(Exception e){
        em.getTransaction().rollback();
        return "errorPage";
    }
        finally{
        em.close();
    }
}


}
