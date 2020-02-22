package com.backend.jvmworkshop.module.car_service.usecase;

import com.backend.jvmworkshop.module.car_service.dao.Car;
import com.backend.jvmworkshop.module.car_service.exception.ResourceNotFound;
import com.backend.jvmworkshop.module.car_service.repository.CarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CarUseCaseImpl implements CarUseCase {

    @Autowired
    private CarRepository carRepository;

    @Override
    public List<Car> findAllCars() {
        return carRepository.findAll();
    }

    @Override
    public Long countTotalCars() {
        return carRepository.count();
    }

    @Override
    public Optional<Car> findByCarId(Long id) {
        Optional<Car> carSingleData = Optional.ofNullable(carRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Car not found with id " + id)));
        return carSingleData;
    }

    @Override
    public Car createNewCar(Car carPayload) {
        return carRepository.save(carPayload);
    }

    @Override
    public Car updateCar(Long id, Car carPayload) {
        Car carById = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Car not found with id " + id));

        carById.setBrand(carPayload.getBrand());
        carById.setModel(carPayload.getModel());
        carById.setColor(carPayload.getColor());
        carById.setFuel(carPayload.getFuel());
        carRepository.save(carById);

        return carById;
    }

    @Override
    public Car deleteCar(Long id) {
        Car carById = carRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFound("Car not found with id " + id));
        carRepository.delete(carById);

        return carById;
    }
}
