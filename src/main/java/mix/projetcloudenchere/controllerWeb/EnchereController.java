package mix.projetcloudenchere.controllerWeb;

import mix.projetcloudenchere.repository.EnchereRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class EnchereController {
    @Autowired
    EnchereRepository enchereRepository;

}
