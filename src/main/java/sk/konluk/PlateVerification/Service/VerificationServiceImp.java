package sk.konluk.PlateVerification.Service;

import org.springframework.stereotype.Service;
import sk.konluk.PlateVerification.Domain.CarPlate;
import sk.konluk.PlateVerification.Domain.CarPlateRepository;
import sk.konluk.PlateVerification.Service.interfaces.VerificationService;

@Service
public class VerificationServiceImp implements VerificationService {

    private CarPlateRepository carPlateRepository;

    public VerificationServiceImp(CarPlateRepository carPlateRepository) {
        this.carPlateRepository = carPlateRepository;
    }

    @Override
    public boolean verficiate(String plate) {

        CarPlate carPlate = carPlateRepository.findByPlate(plate);

        if(carPlate == null) {
            return false;
        }else{
            carPlate.addSearches();
            carPlateRepository.save(carPlate);
            return true;
        }
    }
}
