package com.backend.jvmworkshop.module.category_car.repository;

import com.backend.jvmworkshop.module.category_car.domain.CategoryCar;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryCarRepository extends JpaRepository<CategoryCar, Long> {
}
