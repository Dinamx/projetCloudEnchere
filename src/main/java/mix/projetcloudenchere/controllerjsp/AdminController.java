package mix.projetcloudenchere.controllerjsp;


import mix.projetcloudenchere.model.Admin;
import mix.projetcloudenchere.model.Categorieproduit;
import mix.projetcloudenchere.model.Tokenadmin;
import mix.projetcloudenchere.repository.*;
import mix.projetcloudenchere.service.TokenService;
import mix.projetcloudenchere.viewsRepository.CategoriePriseeRepository;
import mix.projetcloudenchere.viewsRepository.ClientActifRepository;
import mix.projetcloudenchere.viewsRepository.NmCategorieRepository;
import mix.projetcloudenchere.viewsRepository.NmEnchereCategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.LocalDate;

@Controller
public class AdminController {

    @Autowired
    AdminRepository adminRepository;
    @Autowired
    TokenadminRepository tokenadminRepository;
    @Autowired
    CategorieproduitRepository categorieproduitRepository;

    @Autowired
    ClientActifRepository clientActifRepository;

    @Autowired
    NmCategorieRepository nmCategorieRepository;

    @Autowired
    NmEnchereCategorieRepository nmEnchereCategorieRepository;

    @Autowired
    CategoriePriseeRepository categoriePriseeRepository;


    @GetMapping("/")
    public String logadmin(Model model) {
        System.out.println("ok");
        model.addAttribute("email", "admin@gmail.com");
        model.addAttribute("mdp","adminpassword");
        return "Pagelogin";
    }

    @PostMapping("/login")
    public String loginTraitement(HttpServletRequest request, Model model) throws Exception {
        HttpSession session = request.getSession(true);
        System.out.println("log");
        String email = request.getParameter("email");
        String password = request.getParameter("password");
        if( adminRepository.findByEmailAndMdp(email,password) != null) {
            Admin admin = adminRepository.findByEmailAndMdp(email, password);
            System.out.println();

            Tokenadmin t = new TokenService().createToken(admin);
            Tokenadmin saved = tokenadminRepository.save(t);
            System.out.println("LoginAdmin" + t.getToken() + t.getId() + t.getRole());
            model.addAttribute("categories",categorieproduitRepository.findAll());
            return "acceuilAdmin";
        }
        else{
            return "acceuilAdmin?error=1";
        }
    }

//    public String loginTraitement(HttpServletRequest request, Model model) throws Exception {
//        try {
//            HttpSession session = request.getSession(true);
//            System.out.println("log");
//            String email = request.getParameter("email");
//            String password = request.getParameter("password");
//            if (adminRepository.findByEmailAndMdp(email, password) != null) {
//                Admin admin = adminRepository.findByEmailAndMdp(email, password);
//                System.out.println(admin.getId());
//                if (tokenadminRepository.existsTokenadminByIdadmin((Integer) admin.getId())) {
//                    System.out.println("now exist");
//                    tokenadminRepository.updateToken(admin.getId(), LocalDate.now());
//                    System.out.println("now existe");
//
//                } else {
//                    Tokenadmin t = new TokenService().createToken(admin);
//                    Tokenadmin saved = tokenadminRepository.save(t);
//                    System.out.println("LoginAdmin" + t.getToken() + t.getId() + t.getRole());
//                }
//                model.addAttribute("categories", categorieproduitRepository.findAll());
//                return "acceuilAdmin";
//            } else {
//                return "acceuilAdmin?error=1";
//            }
//        }
//        catch (Exception e){
//            e.printStackTrace();
//            return "acceuilAdmin?error=1";
//        }
//    }

    @GetMapping("/home")
    public String loginTraitement(Model model) throws Exception {
            model.addAttribute("categories",categorieproduitRepository.findAll());
            return "acceuilAdmin";
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
    @PostMapping("categories")
    public String addCategorie(HttpServletRequest request, Model model){
        String nomCategorie = request.getParameter("categorie");
        categorieproduitRepository.save(new Categorieproduit(nomCategorie));
        model.addAttribute("categories",categorieproduitRepository.findAll());
        return "acceuilAdmin";
    }
    @GetMapping("/stat")
    public String statistiques(Model model) {
        try{
            model.addAttribute("clien_actif", clientActifRepository.getClientActif());
            model.addAttribute("nm_categorie", nmCategorieRepository.getNombreCategorie());
        model.addAttribute("nm_enchere_categorie", nmEnchereCategorieRepository.getNmEnchereCategorie());
        model.addAttribute("categorie_prisee", categoriePriseeRepository.getCategoriePrisee());
        return "statistiques";
        }

        catch (Exception e){
            e.printStackTrace();
            return "error";
        }

    }

}
