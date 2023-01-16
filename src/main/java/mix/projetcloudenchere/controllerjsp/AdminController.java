package mix.projetcloudenchere.controllerjsp;


import mix.projetcloudenchere.model.Admin;
import mix.projetcloudenchere.model.Tokenadmin;
import mix.projetcloudenchere.repository.AdminRepository;
import mix.projetcloudenchere.repository.CategorieproduitRepository;
import mix.projetcloudenchere.repository.TokenadminRepository;
import mix.projetcloudenchere.service.TokenService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    TokenadminRepository tokenadminRepository;
    @Autowired
    CategorieproduitRepository categorieproduitRepository;

    @GetMapping("/")
    public String logadmin(Model model) {
        System.out.println("ok");
        model.addAttribute("email", "admin@gmail.com");
        model.addAttribute("mdp","admin");
        return "Pagelogin";
    }

    @PostMapping("/login")
    public String loginTraitement(HttpServletRequest request, Model model) throws Exception {
        HttpSession session = request.getSession(true);
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if( adminRepository.findByEmailAndAndMdp(email,password) != null) {
            Admin admin = adminRepository.findByEmailAndAndMdp(email, password);
            System.out.println();
//            TODO Echanger cette portion de code par un tokenrepository.findByID
            Tokenadmin t = new TokenService().createToken(admin);




            Tokenadmin saved = tokenadminRepository.save(t);
            System.out.println("LoginAdmin" + t.getToken() + t.getId() + t.getRole());

            return "acceuilAdmin";
        }
        else{
            return "Pagelogin?error=1";
        }
    }

    @RequestMapping("/backOffice")
    public String backOffice(HttpServletRequest request){

        HttpSession session = request.getSession();
        if(session.getAttribute("admin")!=null){
//            request.setAttribute("chiffreAffaire",p.ChiffreAffaire(con));
            return "backOffice";
        }else {
            return "/";
        }
    }
    @PostMapping("AjoutProduit")
    public String addProduit(HttpServletRequest request){
        String nomProduit = request.getParameter("nomProduit");
        return "acceuilAdmin";
    }

}
