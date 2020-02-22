package com.backend.jvmworkshop.module.car_service.presenter;

import com.backend.jvmworkshop.module.car_service.dao.Car;
import com.backend.jvmworkshop.module.car_service.usecase.CarUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CarPresenter {
    @Autowired
    private CarUseCaseImpl carUseCase;

    @GetMapping("cars")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllCars() {
        Map<String, Object> map = new HashMap<>();
        List<Car> allCars = carUseCase.findAllCars();
        Long countAllCars = carUseCase.countTotalCars();
        map.put("total", countAllCars);
        map.put("count", allCars.size());
        map.put("data", allCars);
        return map;
    }

    @GetMapping("car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getSingleCar(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        Optional<Car> carSingleData = carUseCase.findByCarId(id);
        map.put("data", carSingleData);
        return map;
    }

    @PostMapping("car")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> createNewCars(@RequestBody Car carPayload) {
        Map<String, Object> map = new HashMap<>();
        Car carSave = carUseCase.createNewCar(carPayload);
        map.put("message", "Car created successfully");
        map.put("created", carSave);
        return map;
    }

    @PutMapping("car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateCar(@PathVariable Long id,
                                         @RequestBody Car carPayload) {
        Map<String, Object> map = new HashMap<>();
        Car carUpdate = carUseCase.updateCar(id, carPayload);
        map.put("message", "Car updated successfully");
        map.put("updated", carUpdate);
        return map;
    }

    @DeleteMapping("car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteCar(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        Car carDelete = carUseCase.deleteCar(id);
        map.put("message", "Car deleted successfully");
        map.put("delete", carDelete);
        return map;
    }
}
