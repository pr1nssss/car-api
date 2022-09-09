package com.prins.carapi.models;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Service
public class Car {

    @NotNull
    private String brand;
    private String model;
    private String color;
    private String transmission;
    private Integer yearModel;
    private Integer mileage;
}
