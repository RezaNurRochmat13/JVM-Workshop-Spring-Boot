package com.backend.jvmworkshop.module.category_car.usecase;

import com.backend.jvmworkshop.module.util.exception.ResourceNotFound;
import com.backend.jvmworkshop.module.category_car.domain.CategoryCar;
import com.backend.jvmworkshop.module.category_car.repository.CategoryCarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryCarUseCaseImpl implements CategoryCarUseCase {

    @Autowired
    private CategoryCarRepository categoryCarRepository;

    @Override
    public List<CategoryCar> findAllCategoryCars() {
        return categoryCarRepository.findAll();
    }

    @Override
    public Long countAllCategoryCars() {
        return categoryCarRepository.count();
    }

    @Override
    public Optional<CategoryCar> findByCategoryCarId(Long id) {
        Optional<CategoryCar> categoryCarById = Optional.ofNullable(categoryCarRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category Car not found with id " + id)));
        return categoryCarById;
    }

    @Override
    public CategoryCar createNewCategoryCar(CategoryCar categoryCarPayload) {
        return categoryCarRepository.save(categoryCarPayload);
    }

    @Override
    public CategoryCar updateCategoryCar(Long id, CategoryCar categoryCarPayload) {
        CategoryCar categoryCarById = categoryCarRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category Car not found with id " + id));
        categoryCarById.setCategoryName(categoryCarPayload.getCategoryName());
        categoryCarById.setCategoryDescription(categoryCarPayload.getCategoryDescription());
        categoryCarRepository.save(categoryCarById);
        return categoryCarById;
    }

    @Override
    public CategoryCar deleteCategoryCar(Long id) {
        CategoryCar categoryCarById = categoryCarRepository
                .findById(id)
                .orElseThrow(() -> new ResourceNotFound("Category Car not found with id " + id));
        categoryCarRepository.delete(categoryCarById);
        return categoryCarById;
    }
}
