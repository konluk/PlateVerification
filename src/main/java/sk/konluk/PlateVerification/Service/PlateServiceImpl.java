package sk.konluk.PlateVerification.Service;

import org.springframework.stereotype.Service;
import sk.konluk.PlateVerification.Domain.CarPlate;
import sk.konluk.PlateVerification.Domain.CarPlateRepository;

@Service
public class PlateServiceImpl implements PlateService {

    private CarPlateRepository carPlateRepository;

    public PlateServiceImpl(CarPlateRepository carPlateRepository) {
        this.carPlateRepository = carPlateRepository;
    }

    @Override
    public Integer addPlate(CarPlate carPlate) throws Exception {
        if(!carPlate.getEmail().contains("@")) throw new Exception("Email musi obsahovat @");

        if(carPlate.getPlate().length() != 7) throw new Exception("Nepovolena dlzka SPZ");

        if(carPlateRepository.findByPlate(carPlate.getPlate()) != null) throw new Exception("SPZ sa uz nachadza v databaze");

        return carPlateRepository.save(carPlate).getId();
    }

    @Override
    public void deletePlate(String plate) throws Exception {

        CarPlate carPlate = carPlateRepository.findByPlate(plate);

        if(carPlate == null){
            throw new Exception("Spz sa nenachadza v databaze");
        }else{
            carPlateRepository.deleteById(carPlate.getId());
        }
    }
}
