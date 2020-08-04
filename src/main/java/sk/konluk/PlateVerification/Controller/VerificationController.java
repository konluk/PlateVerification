package sk.konluk.PlateVerification.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import sk.konluk.PlateVerification.Service.interfaces.VerificationService;

@Controller
@RequestMapping("/verification")
public class VerificationController {

    private VerificationService verificationService;

    public VerificationController(VerificationService verificationService) {
        this.verificationService = verificationService;
    }

    @GetMapping("{plate}")
    public ResponseEntity verification(@PathVariable("plate") String plate) {
        if(verificationService.verficiate(plate)) {
            return new ResponseEntity<>("Spz je kradnuta", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Spz sa nenachadza v databaze", HttpStatus.NOT_FOUND);
        }
    }
}
