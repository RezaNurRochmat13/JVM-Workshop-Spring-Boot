package com.backend.jvmworkshop.module.car.dao;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "cars")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private Long id;

    @Column(name = "brand")
    private String brand;

    @Column(name = "model")
    private String model;

    @Column(name = "color")
    private String color;

    @Column(name = "fuel")
    private String fuel;
}
