package com.backend.jvmworkshop.module.car_service.repository;

import com.backend.jvmworkshop.module.car_service.dao.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Car, Long> {
}
