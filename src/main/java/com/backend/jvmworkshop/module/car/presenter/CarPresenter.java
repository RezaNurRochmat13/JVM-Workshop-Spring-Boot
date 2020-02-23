package com.backend.jvmworkshop.module.car.presenter;

import com.backend.jvmworkshop.module.car.dao.Car;
import com.backend.jvmworkshop.module.car.usecase.CarUseCaseImpl;
import com.backend.jvmworkshop.module.util.response.BaseCreateOrUpdateResponse;
import com.backend.jvmworkshop.module.util.response.BaseListCollectionResponse;
import com.backend.jvmworkshop.module.util.response.BaseSingleResponse;
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
    public BaseListCollectionResponse getAllCars() {
        BaseListCollectionResponse baseListCollectionResponse = new BaseListCollectionResponse();
        List<Car> allCars = carUseCase.findAllCars();
        Long countAllCars = carUseCase.countTotalCars();
        baseListCollectionResponse.setCount(allCars.size());
        baseListCollectionResponse.setTotal(countAllCars);
        baseListCollectionResponse.setResult(allCars);
        return baseListCollectionResponse;
    }

    @GetMapping("car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseSingleResponse getSingleCar(@PathVariable Long id) {
        BaseSingleResponse baseSingleResponse = new BaseSingleResponse();
        Optional<Car> carSingleData = carUseCase.findByCarId(id);
        baseSingleResponse.setResult(carSingleData);
        return baseSingleResponse;
    }

    @PostMapping("car")
    @ResponseStatus(HttpStatus.CREATED)
    public BaseCreateOrUpdateResponse createNewCars(@RequestBody Car carPayload) {
        BaseCreateOrUpdateResponse baseCreateOrUpdateResponse = new BaseCreateOrUpdateResponse();
        Car carSave = carUseCase.createNewCar(carPayload);
        baseCreateOrUpdateResponse.setMessages("Car created successfully");
        baseCreateOrUpdateResponse.setResourceCreateOrUpdated(carSave);
        return baseCreateOrUpdateResponse;
    }

    @PutMapping("car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseCreateOrUpdateResponse updateCar(
            @PathVariable Long id,
            @RequestBody Car carPayload) {
        BaseCreateOrUpdateResponse baseCreateOrUpdateResponse = new BaseCreateOrUpdateResponse();
        Car carUpdate = carUseCase.updateCar(id, carPayload);
        baseCreateOrUpdateResponse.setMessages("Car updated successfully");
        baseCreateOrUpdateResponse.setResourceCreateOrUpdated(carUpdate);
        return baseCreateOrUpdateResponse;
    }

    @DeleteMapping("car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public BaseCreateOrUpdateResponse deleteCar(@PathVariable Long id) {
        BaseCreateOrUpdateResponse baseCreateOrUpdateResponse = new BaseCreateOrUpdateResponse();
        Car carDelete = carUseCase.deleteCar(id);
        baseCreateOrUpdateResponse.setMessages("Car deleted successfully");
        baseCreateOrUpdateResponse.setResourceCreateOrUpdated(carDelete);
        return baseCreateOrUpdateResponse;
    }
}
