package com.backend.jvmworkshop.module.car.usecase;

import com.backend.jvmworkshop.module.car.dao.Car;

import java.util.List;
import java.util.Optional;

public interface CarUseCase {
    List<Car> findAllCars();
    Long countTotalCars();
    Optional<Car> findByCarId(Long id);
    Car createNewCar(Car carPayload);
    Car updateCar(Long id, Car carPayload);
    Car deleteCar(Long id);
}
