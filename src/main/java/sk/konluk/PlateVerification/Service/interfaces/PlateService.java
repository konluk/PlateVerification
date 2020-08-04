package sk.konluk.PlateVerification.Service.interfaces;

import sk.konluk.PlateVerification.Domain.CarPlate;

import java.util.Iterator;
import java.util.List;

public interface PlateService {

    Iterable<CarPlate> getPlates();

    Integer addPlate(CarPlate carPlate) throws Exception;

    void deletePlate(String plate) throws Exception;

}
