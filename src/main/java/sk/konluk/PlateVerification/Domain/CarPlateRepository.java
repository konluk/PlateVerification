package sk.konluk.PlateVerification.Domain;

import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface CarPlateRepository extends CrudRepository<CarPlate, Integer> {



    CarPlate findByPlate(String plate);





}
