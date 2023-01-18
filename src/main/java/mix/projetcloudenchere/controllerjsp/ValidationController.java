package mix.projetcloudenchere.controllerjsp;

import mix.projetcloudenchere.model.Rechargementcompte;
import mix.projetcloudenchere.repository.RechargementcompteRepository;
import mix.projetcloudenchere.viewsRepository.VuedetailrechargementnonvalideRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import javax.persistence.EntityManager;
import java.util.List;

@Controller
public class ValidationController {
    @Autowired
    EntityManager em;

    @Autowired
    RechargementcompteRepository rechargementcompteRepository;

    @Autowired
    VuedetailrechargementnonvalideRepository nonvalide;

    @GetMapping("/listeRechargement")
    public String listeRechargement(Model model){
        model.addAttribute("nonvalide" ,nonvalide.findAll());
        return "rechargementDetails";
    }

    @Transactional
    @GetMapping("/listeRechargement/{idRechargement}")
    public String validation(@PathVariable String idRechargement,Model model)
    {
        try{
            if (idRechargement != null ){
                System.out.println(idRechargement);
                if (Integer.valueOf(idRechargement) instanceof Integer)
                    rechargementcompteRepository.updateRechargement(Integer.valueOf(idRechargement));
            }
            model.addAttribute("nonvalide" ,nonvalide.findAll());
            return "rechargementDetails";
        }
        catch(Exception e){
            e.printStackTrace();
        return "errorPage";
    }
}


}
