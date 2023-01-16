package mix.projetcloudenchere.controllerWeb;

import mix.projetcloudenchere.model.Enchere;
import mix.projetcloudenchere.repository.EnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@CrossOrigin
public class EnchereController {
    @Autowired
    EnchereRepository enchereRepository;

    @GetMapping("/encheres")
    public ResponseEntity<List<Enchere>> listeToutesEnchere(){
        return  null;
    }


}
