package com.backend.jvmworkshop.module.category_car.presenter;

import com.backend.jvmworkshop.module.category_car.domain.CategoryCar;
import com.backend.jvmworkshop.module.category_car.usecase.CategoryCarUseCaseImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("api/v1/")
public class CategoryCarPresenter {
    @Autowired
    private CategoryCarUseCaseImpl categoryCarUseCase;

    @GetMapping("category-cars")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getAllCategoryCar() {
        Map<String, Object> map = new HashMap<>();
        List<CategoryCar> categoryCars = categoryCarUseCase.findAllCategoryCars();
        Long countAllCategoryCars = categoryCarUseCase.countAllCategoryCars();
        map.put("total", countAllCategoryCars);
        map.put("count", categoryCars.size());
        map.put("data", categoryCars);
        return map;
    }

    @GetMapping("category-car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> getSingleCategoryCar(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        Optional<CategoryCar> categoryCarById = categoryCarUseCase.findByCategoryCarId(id);
        map.put("data", categoryCarById);
        return map;
    }

    @PostMapping("category-car")
    @ResponseStatus(HttpStatus.CREATED)
    public Map<String, Object> createNewCategoryCar(@RequestBody CategoryCar categoryCarPayload) {
        Map<String, Object> map = new HashMap<>();
        CategoryCar categoryCarCreate = categoryCarUseCase.createNewCategoryCar(categoryCarPayload);
        map.put("message", "Category Car created successfully");
        map.put("created", categoryCarCreate);
        return map;
    }

    @PutMapping("category-car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> updateCategoryCar(@PathVariable Long id,
                                                 @RequestBody CategoryCar categoryCarPayload) {
        Map<String, Object> map = new HashMap<>();
        CategoryCar categoryCarUpdate = categoryCarUseCase.updateCategoryCar(id, categoryCarPayload);
        map.put("message", "Category Car updated successfully");
        map.put("updated", categoryCarUpdate);
        return map;
    }

    @DeleteMapping("category-car/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Map<String, Object> deleteCategoryCar(@PathVariable Long id) {
        Map<String, Object> map = new HashMap<>();
        CategoryCar categoryCarDelete = categoryCarUseCase.deleteCategoryCar(id);
        map.put("message", "Category Car deleted successfully");
        map.put("deleted", categoryCarDelete);
        return map;
    }
}
