package mix.projetcloudenchere.controllerjsp;

import mix.projetcloudenchere.model.Categorieproduit;
import mix.projetcloudenchere.model.Pourcentageprelevee;
import mix.projetcloudenchere.repository.PourcentagepreleveeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import java.sql.Timestamp;

@Controller
public class ParametresController {
    @Autowired
    PourcentagepreleveeRepository pourcentagepreleveeRepository;

    @PostMapping("/prelevement")
    public String addPrelevement(HttpServletRequest request, Model model){
        System.out.println("requete tonga" + request.getParameter("prelevement") );
        double nomCategorie = (Double) Double.valueOf(request.getParameter("prelevement"));
        Pourcentageprelevee pel=new  Pourcentageprelevee(nomCategorie , new Timestamp(System.currentTimeMillis()));
        pourcentagepreleveeRepository.save(pel);
        model.addAttribute("categories",pourcentagepreleveeRepository.findAll());
        return "InsertionPrelevement";
    }

    @GetMapping("/prelevement")
    public String seePrelevement(HttpServletRequest request, Model model){
        model.addAttribute("categories",pourcentagepreleveeRepository.findAll());
        System.out.println("InsertionPrelevement");
        return "InsertionPrelevement";
    }

}
