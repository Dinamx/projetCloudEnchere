package mix.projetcloudenchere.dao;



import mix.projetcloudenchere.connect.Connect;
import mix.projetcloudenchere.views.VueEnchereProduitUtilisateur;

import java.sql.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class EnchereDao {
    VueEnchereProduitUtilisateur ench;


    public List<VueEnchereProduitUtilisateur> getListEnchereRecherche(PreparedStatement stm) throws Exception {
        List<VueEnchereProduitUtilisateur> liste = new ArrayList<>();
        ResultSet rs=stm.executeQuery();
        while(rs.next()){
            VueEnchereProduitUtilisateur ls = new VueEnchereProduitUtilisateur(rs.getInt("idenchere"),rs.getInt("idutilisateur"),rs.getString("nom"), rs.getString("prenom"), rs.getInt("idproduit"), rs.getString("nomproduit"), rs.getString("description"), rs.getDouble("prixminimumvente"), rs.getInt("dureeenchere"), rs.getTimestamp("dateheureenchere"),rs.getInt("status"),rs.getInt("idcategorieproduit"),rs.getString("categorie"));
            liste.add(ls);
        }
        return liste;
    }
    public PreparedStatement generateStatement(Connect conn, String startDate, int idcategory,
                                               int status, double prix, String nomproduit) {
        PreparedStatement stmt =null;
        try {
            String query = "select * from vue_enchere_produit_utilisateur WHERE 1=1";
            StringBuilder sb = new StringBuilder(query);
            int parameterIndex = 1;
            if (startDate != null && !startDate.isEmpty() ) {
                sb.append(" AND dateheureenchere >= '" + java.sql.Date.valueOf(startDate) + "'");
            }
            if (idcategory != 0) {
                sb.append(" AND idcategorieproduit = "+idcategory+"");
            }

            if (status != 0) {
                sb.append(" AND status = "+status+"");
            }
            if (prix != 0) {

                sb.append(" AND prixminimumvente >= "+prix+"");

            }
            if (nomproduit != null && !nomproduit.isEmpty()) {
                sb.append(" AND nomproduit LIKE '%"+nomproduit+"%'");
            }
            query=sb.toString();
            stmt = conn.prepareStatement(query);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return stmt;
    }

}
