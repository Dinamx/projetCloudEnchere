package mix.projetcloudenchere.controllerWeb;

import mix.projetcloudenchere.connect.Connect;
import mix.projetcloudenchere.dao.EnchereDao;
import mix.projetcloudenchere.model.Enchere;
import mix.projetcloudenchere.views.VueEnchereProduitUtilisateur;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.swing.text.html.parser.Entity;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin

public class RechercheController {
    static Connect con1 = new Connect();

    static EnchereDao ed=new EnchereDao();

    public RechercheController() {
    }



//    @PostMapping("/enchereproduitutilisateur")
//    public static List<VueEnchereProduitUtilisateur> advancedSearch(@RequestBody VueEnchereProduitUtilisateur produit) {
//        List<VueEnchereProduitUtilisateur> encheres= null;
//
//        try {
////        PreparedStatement stmt = ed.generateStatement(con1,startDate,idcategory,status,prix,nomproduit);
//
//            System.out.println("bonjour" + String.valueOf(produit.getDateheureenchere()) + produit.getIdcategorieproduit() + produit.getStatus() + produit.getPrixminimumvente() + produit.getNomproduit() );
//        PreparedStatement stmt = ed.generateStatement(con1,String.valueOf(produit.getDateheureenchere()),produit.getIdcategorieproduit(),produit.getStatus(),produit.getPrixminimumvente(),produit.getNomproduit());
//
//
//
//            encheres = ed.getListEnchereRecherche(stmt);
//
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return encheres;
//
//    }
    @PostMapping("/searches")
    public static List<VueEnchereProduitUtilisateur> advancedSearches(@RequestParam(required = false, value="dateheureenchere") String dateheureenchere,
                                        @RequestParam(required = false, value="idcategorie") int  idcategorie,
                                        @RequestParam(required = false, value="status") int status,
                                        @RequestParam(required = false, value="prixminimumvente") double prixminimumvente ,
                                        @RequestParam(required = false, value="nomproduit") String nomproduit ){

        PreparedStatement stmt = ed.generateStatement(con1,dateheureenchere,idcategorie,status,prixminimumvente,nomproduit);
        List<VueEnchereProduitUtilisateur> encheres= null;
        try {
            encheres = ed.getListEnchereRecherche(stmt);
//                con1.getConnection().close();
        } catch (Exception e) {
        }
        return encheres;

    }

    public static void main(String[] args){
        List<VueEnchereProduitUtilisateur> advancedSearch=advancedSearches("",0,0,0,"");
        for(int i=0;i<advancedSearch.size();i++){
            System.out.println(advancedSearch.get(i).getNomproduit());
        }
    }
}
