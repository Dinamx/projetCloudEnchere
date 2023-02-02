package mix.projetcloudenchere.controllerMobile;

import mix.projetcloudenchere.model.Categorieproduit;
import mix.projetcloudenchere.repository.CategorieproduitRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@CrossOrigin
@RequestMapping("/categories")
public class CategorieController {

    @Autowired
    CategorieproduitRepository categorieproduitRepository;

    @GetMapping("/liste")
    public ResponseEntity<List<Categorieproduit>> getCategorie(){
        try{
            return new ResponseEntity<>(categorieproduitRepository.findAll(),HttpStatus.OK);
        }
        catch (Exception e){
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
