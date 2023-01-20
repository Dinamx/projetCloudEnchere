package mix.projetcloudenchere.controllerWeb;


import mix.projetcloudenchere.mongodb.Photo;
import mix.projetcloudenchere.mongodb.PhotoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
public class PhotoController {

    @Autowired
    PhotoRepository photoRepository;

    @GetMapping("/photos")
    public ResponseEntity<List<Photo>> listePhotos() {
        try {
            return new ResponseEntity<>(photoRepository.findAll(), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
    @GetMapping("/photos/{idproduit}")
    public ResponseEntity<List<Photo>> listePhotos(@PathVariable String idproduit ) {
        try {
            return new ResponseEntity<>(photoRepository.findAllByIdproduit(idproduit), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }
//    Format requete
//    {
//      "idproduit": "1",
//      "photo" :  "data:image/jpeg;base64,/9j/BJKfcedhboniknbcde/"
//    }
    @PostMapping("/photos")
    public ResponseEntity<Photo> listePhotos(@RequestBody Photo photo) {
        try {
            return new ResponseEntity<>(photoRepository.save(photo), HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
