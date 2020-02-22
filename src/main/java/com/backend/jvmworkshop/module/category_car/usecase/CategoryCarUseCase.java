package com.backend.jvmworkshop.module.category_car.usecase;

import com.backend.jvmworkshop.module.category_car.domain.CategoryCar;

import java.util.List;
import java.util.Optional;

public interface CategoryCarUseCase {
    List<CategoryCar> findAllCategoryCars();
    Long countAllCategoryCars();
    Optional<CategoryCar> findByCategoryCarId(Long id);
    CategoryCar createNewCategoryCar(CategoryCar categoryCarPayload);
    CategoryCar updateCategoryCar(Long id, CategoryCar categoryCarPayload);
    CategoryCar deleteCategoryCar(Long id);
}
