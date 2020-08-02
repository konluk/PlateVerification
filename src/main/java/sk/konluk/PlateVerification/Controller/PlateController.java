package sk.konluk.PlateVerification.Controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sk.konluk.PlateVerification.Domain.CarPlate;
import sk.konluk.PlateVerification.Service.PlateService;
import sk.konluk.PlateVerification.Service.PlateServiceImpl;

@RestController
@RequestMapping("/plate")
public class PlateController {

    private PlateService plateService;

    public PlateController(PlateService plateService) {
        this.plateService = plateService;
    }

    @PostMapping()
    public ResponseEntity addPlate(@RequestBody CarPlate carPlate) {
        Integer id = null;//

        try {
            id = plateService.addPlate(carPlate);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_ACCEPTABLE);
        }

        return new ResponseEntity<>(id, HttpStatus.CREATED);
    }

    @DeleteMapping("{plate}")
    public ResponseEntity deletePlate(@PathVariable("plate") String plate) {
        try {
            plateService.deletePlate(plate);
        } catch (Exception e) {
            return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>("deleted", HttpStatus.OK);
    }

}
