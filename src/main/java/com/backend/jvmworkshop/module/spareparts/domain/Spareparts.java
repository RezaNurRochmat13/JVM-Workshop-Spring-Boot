package com.backend.jvmworkshop.module.spareparts.domain;

import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

import jakarta.persistence.*;

@Entity
@Table(name = "spareparts")
@Data
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Spareparts {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(name = "name")
    private String sparepartName;

    @Column(name = "stock")
    private Integer sparepartStock;
}
