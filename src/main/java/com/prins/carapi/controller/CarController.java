package com.prins.carapi.controller;

import com.prins.carapi.models.Car;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.BeanUtils;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/cars")
public class CarController {

    private final List<Car> cars = new ArrayList<>();

    @GetMapping
    public List<Car> getAllCars() {
        return cars;
    }

    @PostMapping()
    public String addCar(@RequestBody @Valid Car car) {
        cars.add(car);
        return "car added";
    }

    @PutMapping("/{index}")
    public String updateCarInfo(@PathVariable Integer index, @RequestBody Car car) {
        var carToBeUpdated = cars.get(index);
        BeanUtils.copyProperties(car, carToBeUpdated);
        return "Car info updated";
    }

    @PatchMapping("/{index}")
    public String changeCarInfo(@PathVariable Integer index, @RequestBody Car car) {
        var carToBeUpdated = cars.get(index);
        if (StringUtils.isNotEmpty(car.getBrand())) {
            carToBeUpdated.setBrand(car.getBrand());
        }
        if (StringUtils.isNotEmpty(car.getModel())) {
            carToBeUpdated.setModel(car.getModel());
        }
        if (StringUtils.isNotEmpty(car.getColor())) {
            carToBeUpdated.setBrand(car.getColor());
        }
        if (StringUtils.isNotEmpty(car.getTransmission())) {
            carToBeUpdated.setTransmission(car.getTransmission());
        }
        if (car.getYearModel() != null && car.getYearModel() != 0) {
            carToBeUpdated.setYearModel(car.getYearModel());
        }
        if (car.getMileage() != null && car.getMileage() != 0) {
            carToBeUpdated.setMileage(car.getMileage());
        }
        return "successfully changed";
    }

    @DeleteMapping("/{index}")
    public String deleteCar(@PathVariable Integer index) {
        cars.remove(index.intValue());
        return "car deleted";
    }

//    @GetMapping("/nissan")
//    public String getCarByID(@RequestParam String model, @RequestParam(required = false) Integer year, @RequestParam String serial) {
//        return "Nissan " + model + " " + year + " : " + serial;
//    }
//    @PostMapping
//    public DataWrapper postMotor(@RequestBody DataWrapper dataWrapper) {
//        return dataWrapper;
//    }
//
//    @PutMapping
//    public DataWrapper putMotor(@RequestBody DataWrapper dataWrapper) {
//        return dataWrapper;
//
//    }
}
