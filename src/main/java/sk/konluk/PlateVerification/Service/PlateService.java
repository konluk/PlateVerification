package sk.konluk.PlateVerification.Service;

import sk.konluk.PlateVerification.Domain.CarPlate;

public interface PlateService {

    Integer addPlate(CarPlate carPlate) throws Exception;

    void deletePlate(String plate) throws Exception;

}
